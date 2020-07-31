package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isTriangular() {
            double val = (Math.sqrt(8 * number + 1) - 1) / 2;
            return val % 1 == 0;
        }

        public boolean isSquare() {
            double val = Math.sqrt(number);
            return val % 1 == 0;
        }

    }

    public void testNumber(View view) {

        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);

        String toastMessage;

        if (editTextNumber.getText().toString().isEmpty()) {

            toastMessage = "Please enter a number";

        } else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(editTextNumber.getText().toString());

            if (myNumber.isTriangular() && myNumber.isSquare()) {

                toastMessage = "The number is both triangular and square";

            } else if (myNumber.isTriangular()) {

                toastMessage = "The number is triangular but not square";

            } else if (myNumber.isSquare()) {

                toastMessage = "The number is square but not triangular";

            } else {

                toastMessage = "The number is neither a triangle nor a square";

            }

            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}