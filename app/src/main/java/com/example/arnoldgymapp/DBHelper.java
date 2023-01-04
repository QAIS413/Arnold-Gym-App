package com.example.arnoldgymapp;// package name

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    // here is the database table with its defined columns.
    public static final String DATABASE_NAME="QAIS44.db";// This is the database name called QAIS44
    public static final String TABLE_NAME="ARNOLD_GYM_MEMBERS";// This is table named ARNOLD_GYM_MEMBERS.
    // below we declared and set all possible columns in table ARNOLD_GYM_MEMBERS.
    public static final String COL_1="fn720";
    public static final String COL_2="ln720";
    public static final String COL_3="phone720";
    public static final String COL_4="member720";
    public static final String COL_5="Cost";

    public DBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);// / Here we uses DB helper for context from QAIS44.db.
    }
    public void onCreate(SQLiteDatabase db)// created table on DB
    {
        db.execSQL("create table " +TABLE_NAME+ "(fn720 TEXT,ln720 TEXT,phone720 INTEGER, member720 INTEGER, Cost INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // below method is to inserting data to the DB that created in table ARNOLD_GYM_MEMBERS.
    public boolean insertData(String fn720, String ln720, String phone720, String member720, String Cost)
    {
        // below, we read all the context in DB table columns.
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,fn720);
        contentValues.put(COL_2,ln720);
        contentValues.put(COL_3,phone720);
        contentValues.put(COL_4,member720);
        contentValues.put(COL_4,Cost);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    // below method is to update the data in the DB table named ARNOLD_GYM_MEMBERS.
    public boolean updateData(String fn720, String ln720, String phone720, String member720)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,fn720);
        contentValues.put(COL_2,ln720);
        contentValues.put(COL_3,phone720);
        contentValues.put(COL_4,member720);
        db.update(TABLE_NAME,contentValues,"phone720=?",new String[]{phone720});
        return true;
    }

    public Integer deleteData(String phone720)// method to remove all the data in ARNOLD_GYM_MEMBERS table and that depending to the phone number.
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"phone720=?",new String[]{phone720});
    }

    public Cursor getAllData() // this method is to read and view the data in ARNOLD_GYM_MEMBERS table.
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from " +TABLE_NAME,null);
        return cursor;
    }

}





