package com.example.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    public void onClick(View view) {

        Button buttonPressed = (Button) view;

        Log.i("Button pressed", view.getTag().toString());

        String buttonTag = view.getTag().toString();

        String uriPath = "android.resource://" + getPackageName() + "/raw/" + buttonTag;

        Uri uri = Uri.parse(uriPath);

        mediaPlayer = MediaPlayer.create(this, uri);
        try {
            mediaPlayer.start();
        }
        catch (Exception e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}