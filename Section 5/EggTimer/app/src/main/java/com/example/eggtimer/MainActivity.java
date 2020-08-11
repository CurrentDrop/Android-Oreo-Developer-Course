package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView timeTextView;
    SeekBar seekBarTime;
    Button button;

    CountDownTimer runTimer;

    int time_seconds = 0;
    int max_time = 10 * 60;

    boolean timerActive = false;

    public void onClick(View view) {

        if (!timerActive) {
            if (time_seconds > 0) {
                timerActive = true;

                button.setText("Stop!");

                runTimer = new CountDownTimer(1000 * time_seconds + 100, 1000) {
                    @Override
                    public void onTick(long millisecondsUntilDone) {

                        timeTextView.setText(secondsToTime((int) millisecondsUntilDone / 1000));

                    }

                    @Override
                    public void onFinish() {

                        resetTimer();

                        playAlarm();

                        Toast.makeText(MainActivity.this, "The eggs are done!", Toast.LENGTH_LONG).show();

                    }
                }.start();
            }
        } else {

            resetTimer();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        timeTextView = (TextView) findViewById(R.id.textViewTime);

        seekBarTime = findViewById(R.id.seekBarTime);

        seekBarTime.setMax(max_time);

        seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                time_seconds = i;

                if (!timerActive) {

                    timeTextView.setText(secondsToTime(time_seconds));

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        timeTextView.setText(secondsToTime(time_seconds));

    }

    public void playAlarm(){

        MediaPlayer mediaPlayer;
        AudioManager audioManager;

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        mediaPlayer = MediaPlayer.create(this, R.raw.airhorn);

        mediaPlayer.start();

    }

    public String secondsToTime(int time_seconds) {

        int minutes = (int) Math.floor(time_seconds / 60);

        int seconds = time_seconds % 60;

        String minutesString;
        String secondsString;

        minutesString = String.valueOf(minutes);


        if(seconds < 10){

            secondsString = "0" + seconds;

        } else {

            secondsString = String.valueOf(seconds);

        }

        String time = minutesString + ":" + secondsString;

        return time;

    }

    public void resetTimer() {

        timerActive = false;

        button.setText("Start!");

        runTimer.cancel();

        timeTextView.setText(secondsToTime(time_seconds));

    }

}