package com.example.arnoldgymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutUspage002 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_uspage002);


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
                Intent intent01 = new Intent(AboutUspage002.this, MenuPage002.class);
                startActivity(intent01);
                finish();
                return true;

            case R.id.AboutUs44:// this is case one for about us page, so, once click in this item,the action will happen as written blow.
                Intent intent02 = new Intent(AboutUspage002.this, AboutUspage002.class);
                startActivity(intent02);
                finish();
                return true;


            case R.id.membership44:
                Intent intent03 = new Intent(AboutUspage002.this, MemberShipPage002.class);
                startActivity(intent03);
                finish();
                return true;

            case R.id.GYM_sub:
                Intent intent04 = new Intent(AboutUspage002.this, SubscriptionActivities.class);
                startActivity(intent04);
                finish();
                return true;


            case R.id.ContactUs44:
                Intent intent05 = new Intent(AboutUspage002.this, ContactPage002.class);
                startActivity(intent05);
                finish();
                return true;

            case R.id.Close_app:// this statement will end the app
                finish();
                System.exit(0);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}