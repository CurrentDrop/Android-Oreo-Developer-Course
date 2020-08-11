package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.gridlayout.widget.GridLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    CountDownTimer countDownTimer;

    TextView timerTextView;
    TextView questionTextView;
    TextView scoreTextView;
    TextView textViewFeedback;

    Button buttonPlayAgain;

    LinearLayout linearLayout;

    GridLayout gridLayout;

    Boolean timerActive = false;

    int seconds = 30;

    int correctAnswerIndex = 0;

    int score = 0;
    int count = 0;

    public void play(View view) {

        Log.i("info", "GO!");

        // Start timer
        countDownTimer = createCountDownTimer(seconds).start();

        findViewById(R.id.buttonGo).setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        buttonPlayAgain.setVisibility(View.INVISIBLE);
        textViewFeedback.setVisibility(View.INVISIBLE);

        score = 0;
        count = 0;

        scoreTextView.setText("0/0");

        newQuestion();

    }

    public void answerClick(View view) {
        if (timerActive) {
            TextView answerTextView = (TextView) view;

            textViewFeedback.setVisibility(View.VISIBLE);

            int answerTextViewTag = Integer.parseInt(answerTextView.getTag().toString());

            if (answerTextViewTag == correctAnswerIndex) {

                score++;

                textViewFeedback.setText("Correct! =D");

            } else {

                textViewFeedback.setText("Wrong :( ");

            }

            newQuestion();

            count++;

            String scoreText = score + "/" + count;

            scoreTextView.setText(scoreText);
        }
    }

    public void newQuestion() {

        int firstValue = random.nextInt(20);
        int secondValue = random.nextInt(20);
        int answer = firstValue + secondValue;

        String questionMessage = firstValue + " + " + secondValue;

        Log.i("question", questionMessage);

        questionTextView.setText(questionMessage);

        correctAnswerIndex = random.nextInt(4); //Todo: Random index value ( 0 - 3)

        for (int i = 0; i < 4; i++) {

            TextView answerTextView = (TextView) gridLayout.getChildAt(i);

            String answerMessage;

            if (i == correctAnswerIndex) {

                answerMessage = String.valueOf(answer);

            } else {

                int random_value = random.nextInt(20 * 2);

                if (random_value == answer) {

                    random_value = random.nextInt(20 * 2);

                }

                answerMessage = String.valueOf(random_value);

            }

            answerTextView.setText(answerMessage);

        }


    }

    public CountDownTimer createCountDownTimer(int seconds) {

        timerActive = true;

        return new CountDownTimer(seconds * 1000, 1000) {
            @Override
            public void onTick(long l) {

                int timerSeconds = (int) l / 1000;

                String timerText = "";

                if (timerSeconds < 10) {

                    timerText += " ";

                }

                timerText += timerSeconds + "s";

                timerTextView.setText(timerText);

            }

            @Override
            public void onFinish() {

                timerActive = false;

                buttonPlayAgain.setVisibility(View.VISIBLE);

            }
        };

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView
        timerTextView = findViewById(R.id.textViewTimer);
        questionTextView = findViewById(R.id.textViewQuestion);
        scoreTextView = findViewById(R.id.textViewScore);
        textViewFeedback = findViewById(R.id.textViewFeedback);

        linearLayout = findViewById(R.id.linearLayout);

        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);

        gridLayout = findViewById(R.id.gridLayout);

        random = new Random();

    }
}