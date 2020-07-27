package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int imgNumber = 0;

    public void buttonClicked(View view){

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if(imgNumber == 0){
            imageView.setImageResource(R.drawable.fox);
            imgNumber = 1;
        }else{
            imageView.setImageResource(R.drawable.dog);
            imgNumber = 0;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}