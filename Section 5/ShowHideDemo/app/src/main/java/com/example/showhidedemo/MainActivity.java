package com.example.showhidedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        new CountDownTimer(30_000, 1000){


            @Override
            public void onTick(long l) {

                int seconds = (int) (l / 1000);

                if(seconds % 2 == 0){

                    imageView.setVisibility(View.VISIBLE);

                } else {

                    imageView.setVisibility(View.INVISIBLE);

                }

            }

            @Override
            public void onFinish() {

            }
        }.start();

    }
}