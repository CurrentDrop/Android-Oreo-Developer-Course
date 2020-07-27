package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunktion(View view){

        EditText usernameEditText = (EditText) findViewById(R.id.editTextUsername);

        EditText passwordEditText = (EditText) findViewById(R.id.editTextPassword);

        Log.i("info", "Button pressed");

        Log.i("values", usernameEditText.getText().toString());

        Log.i("values", passwordEditText.getText().toString());

        if(usernameEditText.getText().length() == 0){

            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(this, "Welcome " + usernameEditText.getText().toString(), Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}