package com.example.arnoldgymapp;// this is the package name.

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
public class SplashScreen001 extends AppCompatActivity {
    Handler handler;// here we made handler class in order to transit and handle Messages + Runnables and that from threads MessageQueue.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen001);
        handler =new Handler();// here we made new handler
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent720=new
                        Intent(SplashScreen001.this,MenuPage002.class);
                startActivity(intent720);
                finish();
            }
        },3000);
    }
}
