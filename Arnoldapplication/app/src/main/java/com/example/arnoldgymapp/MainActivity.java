package com.example.arnoldgymapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper mDb;
    EditText fn, ln, mks, id;
    Button b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDb = new DBHelper(this);
        //get the IDs of Edittext
        fn = (EditText) findViewById(R.id.ed1);
        ln = (EditText) findViewById(R.id.ed2);
        mks = (EditText) findViewById(R.id.ed3);
        id = (EditText) findViewById(R.id.ed4);
        //get the ids of button
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        //define user defined methods
        addData();
        updateData();
        deleteData();
        viewData();
        clearData();
    }


    //add data
    public void addData()
    {
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean insert=mDb.insertData(fn.getText().toString(),ln.getText().toString(),mks.getText().toString());
                if(insert==true)
                    Toast.makeText(MainActivity.this, "Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
            }
        });
    }


    //update
    public void updateData()
    {
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean update=mDb.updateData(fn.getText().toString(),ln.getText().toString(),mks.getText().toString(),id.getText().toString());
                if(update==true)
                    Toast.makeText(MainActivity.this,"Data updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not updated",Toast.LENGTH_LONG).show();
            }
        });
    }



    //delete date
    public void deleteData()
    {
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer del=mDb.deleteData(id.getText().toString());
                if(del>0)
                    Toast.makeText(MainActivity.this,"Data deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Dat not deleted",Toast.LENGTH_LONG).show();
            }
        });
    }

    //view data
    public void viewData()
    {
        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Cursor r=mDb.getAllData();
                if(r.getCount()==0)
                {
                    showMessage("Error", "Nothing found");
                    return;
                }
                StringBuffer b=new StringBuffer();
                while(r.moveToNext())
                {
                    b.append("ID:"+r.getString(0)+"\n");
                    b.append("FirstName:"+r.getString(1)+"\n");
                    b.append("LastName:"+r.getString(2)+"\n");
                    b.append("Marks:"+r.getString(3)+"\n");
                }
                showMessage("Student Details",b.toString());
            }
        });
    }






    //clear the screen
    public void clearData()
    {
        b5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fn.setText("");
                ln.setText("");
                mks.setText("");
                id.setText("");
            }
        });
    }




    //status bar
    public void showMessage(String title,String mes)
    {
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(mes);
        ad.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu002,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id=menuItem.getItemId();
        if(id==R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }







}

