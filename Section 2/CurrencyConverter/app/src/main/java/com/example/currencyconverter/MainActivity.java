package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view){

        float USDRate = 8.77f;

        EditText amountEditText = (EditText) findViewById(R.id.editTextAmount);

        String amountInUSD = amountEditText.getText().toString();

        float amountInUSDFloat = Float.parseFloat(amountInUSD);
        float amountInSEKFloat = amountInUSDFloat * USDRate;

        String amountInSEK = String.format("%.2f", amountInSEKFloat);

        Log.i("info", "convert button pressed");
        Log.i("values", amountInUSD);
        Log.i("values", amountInSEK);

        String toastStr = amountInUSD + "$ converts to " + amountInSEK + "kr";

        Toast.makeText(this, toastStr, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}