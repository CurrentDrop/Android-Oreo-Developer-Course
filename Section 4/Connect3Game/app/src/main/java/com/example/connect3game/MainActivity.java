package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.gridlayout.widget.GridLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2}; // 0: x, 1: o 2: empty

    int[][] winningPossitions = {
            // Rows
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            // Columns
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            // Diagonales
            {0, 4, 8},
            {2, 4, 6}};

    private int activePlayer = 0;

    public boolean win = false;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        ImageView imageViewCurrentPlayer = (ImageView) findViewById(R.id.imageViewCurrentPlayer);

        Button resetButton = (Button) findViewById(R.id.resetButton);

        TextView textViewWinner = (TextView) findViewById(R.id.textViewWinner);

        int currentTag = Integer.parseInt(counter.getTag().toString());

        if (gameState[currentTag] == 2 && !win) {

            String toastMessage = "";

            gameState[currentTag] = activePlayer;

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.x);

                imageViewCurrentPlayer.setImageResource(R.drawable.o);

                activePlayer = 1;

                toastMessage += "X has won!";

            } else if (activePlayer == 1) {

                counter.setImageResource(R.drawable.o);

                imageViewCurrentPlayer.setImageResource(R.drawable.x);

                activePlayer = 0;

                toastMessage += "O has won!";

            }

            counter.setTranslationY(-1500);

            counter.animate().translationYBy(1500).setDuration(300);

            if( checkPlayerWin(gameState) ) {

                win = true;

                Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

                textViewWinner.setText(toastMessage);

                textViewWinner.setVisibility(View.VISIBLE);

                resetButton.setVisibility(View.VISIBLE);

            }
        }
        Log.i("gameState", Arrays.toString(gameState));
    }

    public boolean checkPlayerWin(int[] gameState) {

        for (int[] positions : winningPossitions) {

            // all positions are equal
            if (gameState[positions[0]] != 2 && gameState[positions[1]] == gameState[positions[0]] && gameState[positions[2]] == gameState[positions[0]]) {

                return true;

            }

        }

        return false;

    }

    public void resetGame(View view) {

        Button resetButton = (Button) findViewById(R.id.resetButton);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        ImageView imageViewCurrentPlayer = (ImageView) findViewById(R.id.imageViewCurrentPlayer);

        TextView textViewWinner = (TextView) findViewById(R.id.textViewWinner);


        imageViewCurrentPlayer.setImageResource(R.drawable.x);

        resetButton.setVisibility(View.INVISIBLE);

        textViewWinner.setVisibility(View.INVISIBLE);

        for(int i = 0; i < gridLayout.getChildCount(); i++){

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for(int i = 0; i < gameState.length; i++){

            gameState[i] = 2;

        }

        activePlayer = 0;

        win = false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}