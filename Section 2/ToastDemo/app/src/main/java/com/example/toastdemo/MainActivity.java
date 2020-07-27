package com.example.toastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void buttonPressed(View view){

        EditText nameEditText = (EditText) findViewById(R.id.editTextName);

        Log.i("info", "Button Pressed");

        Log.i("values", nameEditText.getText().toString());

        Toast.makeText(this, "Hello " + nameEditText.getText().toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}