package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView dogImageView;

    ImageView foxImageView;

    double fadeSeconds = .5;

    public void fade(View view) {

        Log.i("Info", Float.toString(dogImageView.getAlpha()));


        if (dogImageView.getAlpha() == 1) {

            // Fade out dog
            fadeOutAnimation(dogImageView);

            // Fade in fox
            fadeInAnimation(foxImageView);

        } else if (dogImageView.getAlpha() == 0) {

            // Fade out dog
            fadeInAnimation(dogImageView);

            // Fade in fox
            fadeOutAnimation(foxImageView);

        }
    }

    public void fadeOutAnimation (ImageView imageView) {

        imageView.animate()
                .alpha(0)
                .scaleX(0.5f)
                .scaleY(0.5f)
                .setDuration((long) (1000 * fadeSeconds));

    }

    public void fadeInAnimation (ImageView imageView) {

        imageView.animate()
                .alpha(1)
                .scaleX(1)
                .scaleY(1)
                .setDuration((long) (1000 * fadeSeconds));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogImageView = (ImageView) findViewById(R.id.dogImageView);

        foxImageView = (ImageView) findViewById(R.id.foxImageView);

        dogImageView.animate().alpha(1).scaleX(1).scaleY(1).setDuration((long) (1000 * fadeSeconds));

    }
}