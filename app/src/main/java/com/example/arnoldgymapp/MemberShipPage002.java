package com.example.arnoldgymapp;// this is the package name.
// below imported of all the required java packages.
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemberShipPage002 extends AppCompatActivity {
    // here the required variables has been declared
    DBHelper mDb;
    EditText fn720, ln720, phone720, member720, Cost;
    Button bttn1, bttn2, bttn3, bttn4, bttn5, bb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_ship_page002);

        mDb = new DBHelper(this);// here is the object of DBHelper that created
        //Here, we will get the all IDs of Edittext that created

        fn720 = (EditText) findViewById(R.id.edit_1);
        ln720 = (EditText) findViewById(R.id.edit_2);
        phone720 = (EditText) findViewById(R.id.edit_3);
        member720 = (EditText) findViewById(R.id.edit_4);
        Cost= (EditText) findViewById(R.id.edit_5);

        // //Here, we will get all the IDs of button that created.
        bttn1 = (Button) findViewById(R.id.btn_add);
        bttn2 = (Button) findViewById(R.id.btn_updt);
        bttn3 = (Button) findViewById(R.id.btn_delt);
        bttn4 = (Button) findViewById(R.id.btn_view);
        bttn5 = (Button) findViewById(R.id.btn_clear);
        bb6= (Button) findViewById(R.id.b6);




        //here, all the 6 of methods that applied has been defined
        add_Data720();
        update_Data720();
        delete_Data720();
        view_Data720();
        clear_Data720();
        cal_Data720();
    }


    //This is the add data method
    public void add_Data720()
    {
        bttn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean insert=mDb.insertData(fn720.getText().toString(),ln720.getText().toString(), phone720.getText().toString(),member720.getText().toString(), Cost.getText().toString());
                if(insert==true)
                    Toast.makeText(MemberShipPage002.this, "New client has been added successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MemberShipPage002.this,"Please try again, data not inserted",Toast.LENGTH_LONG).show();
            }
        });
    }

    // This is the update data method
    public void update_Data720()
    {
        bttn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean update=mDb.updateData(fn720.getText().toString(),ln720.getText().toString(), phone720.getText().toString(),member720.getText().toString());
                if(update==true)
                    Toast.makeText(MemberShipPage002.this,"Data has updated successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MemberShipPage002.this, "try again: Data not updated",Toast.LENGTH_LONG).show();
            }
        });
    }



    //delete date method
    public void delete_Data720()
    {
        bttn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer del=mDb.deleteData(phone720.getText().toString());
                if(del>0)
                    Toast.makeText(MemberShipPage002.this,"Data of Client removed",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MemberShipPage002.this,"Data you entered not removed",Toast.LENGTH_LONG).show();
            }
        });
    }

    //view data method
    public void view_Data720()
    {
        bttn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Cursor r=mDb.getAllData();
                if(r.getCount()==0)
                {
                    show_Message720("Found Error", "Nothings are found");
                    return;
                }
                StringBuffer view720=new StringBuffer();
                while(r.moveToNext())
                {

                    view720.append("First_Name:"+r.getString(0)+"\n");
                    view720.append("Last_Name:"+r.getString(1)+"\n");
                    view720.append("Phone_Number:"+r.getString(2)+"\n");
                    view720.append("Membership per month:"+r.getString(3)+"\n");
                }
                show_Message720("Subscribers Details",view720.toString());
            }
        });
    }





    //clear method for remove all the written text in the all Edit_texts
    public void clear_Data720()
    {
        bttn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fn720.setText("");
                ln720.setText("");
                phone720.setText("");
                member720.setText("");
            }
        });
    }
// this is method that applied to make calculation for clients subscription.
    public void cal_Data720()
    {
        bb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fn720.getText().toString().isEmpty()|| ln720.getText().toString().isEmpty()|| phone720.getText().toString().isEmpty()||member720.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please Fill all The Details",Toast.LENGTH_LONG).show();
                }
                else
                {
                    double MemberShip_price=15.0;
                    double Months1= Double.parseDouble(member720.getText().toString());
                    double avgerge720=(MemberShip_price * Months1);
                    Cost.setText(Double.toString(avgerge720));

                }

            }
        });
    }

    //status bar method
    public void show_Message720(String title,String mes)
    {
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(mes);
        ad.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu002,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)// method to selected the items in created menu.
    {
        Toast.makeText(this,"The Selected Item: "+item.getTitle(),Toast.LENGTH_LONG).show();
        switch (item.getItemId())// here we make switch case statement in order for the items that created in menu.
        {

            case R.id.Menu_page:// this is case one for about us page, so, once click in this item,the action will happen as written blow.
                Intent intent01 = new Intent(MemberShipPage002.this, MenuPage002.class);
                startActivity(intent01);
                finish();
                return true;


            case R.id.AboutUs44:// this is case one for about us page, so, once click in this item,the action will happen as written blow.
                Intent intent02 = new Intent(MemberShipPage002.this, AboutUspage002.class);
                startActivity(intent02);
                finish();
                return true;


            case R.id.membership44:
                Intent intent03 = new Intent(MemberShipPage002.this, MemberShipPage002.class);
                startActivity(intent03);
                finish();
                return true;

            case R.id.GYM_sub:
                Intent intent04 = new Intent(MemberShipPage002.this, SubscriptionActivities.class);
                startActivity(intent04);
                finish();
                return true;


            case R.id.ContactUs44:
                Intent intent05 = new Intent(MemberShipPage002.this, ContactPage002.class);
                startActivity(intent05);
                finish();
                return true;

            case R.id.Close_app:
                finish();
                System.exit(0);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }






}

