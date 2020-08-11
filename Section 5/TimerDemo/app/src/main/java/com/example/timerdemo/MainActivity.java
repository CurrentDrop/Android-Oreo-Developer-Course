package com.example.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // First method (Perferd)
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisecondsUntilDone) {

                Log.i("Seconds left: " , String.valueOf( millisecondsUntilDone / 1000));

            }

            @Override
            public void onFinish() {

                Log.i("Seconds left: " , "No more seconds!");

            }
        }.start();

        //Second method
    /*
        final Handler handler = new Handler();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Info" , "A second hass passed by");

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run);
    */
    }
}