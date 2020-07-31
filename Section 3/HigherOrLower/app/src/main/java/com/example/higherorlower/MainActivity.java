package com.example.higherorlower;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    Random  randomGenerator = new Random();

    int min = 0;
    int max = 20;

    int randomNumber;


    public void generateRandomNumber(int min, int max){
        int randomNumber = randomGenerator.nextInt(4)+1;
        Log.i("values", "randomNumber: " + randomNumber);
    }

    public void guessButtonPressed(View view){



        // Take the guessed number
        EditText guessedNumber = (EditText) findViewById(R.id.editTextGuessedNumber);
        String guessedNumberString = guessedNumber.getText().toString();

        // Convert string to int
        int guessedNumberInt;
        try {
            guessedNumberInt = Integer.parseInt(guessedNumberString);
        }
        catch (NumberFormatException e)
        {
            guessedNumberInt = 0;
        }


        // Compare the random number and the guessed number Higher or lower?
        String message;

        if (randomNumber > guessedNumberInt){

            message = "The random number is higher, try again";

        } else if( randomNumber < guessedNumberInt) {

            message = "The random number is lower, try again";

        }else{

            message = "Congratulations! You guessed the number! Hurray!";

            generateRandomNumber(min, max);

        }

        //Toast the message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber(min, max);
    }
}