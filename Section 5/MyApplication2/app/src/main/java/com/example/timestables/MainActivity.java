package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int minMultiplier = 1;
    final int maxMultiplier = 20;
    final int sizeOfTimesTable = 20;

    ListView listViewTimesTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTimesTable = findViewById(R.id.listViewTimesTable);

        listViewTimesTable.setAdapter(createArrayAdapter(0 + minMultiplier));

        SeekBar seekBarMultiplier = findViewById(R.id.seekBarMultiplier);

        seekBarMultiplier.setMax(maxMultiplier - minMultiplier);

        seekBarMultiplier.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int multiplier = i + minMultiplier;

                Log.i("Multiplier", Integer.toString(multiplier));

                listViewTimesTable.setAdapter(createArrayAdapter(multiplier));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public ArrayAdapter createArrayAdapter(int multiplier){

        ArrayList<String> timesTable = new ArrayList<String>();

        for (int i = 1; i < sizeOfTimesTable + 1; i++){

            timesTable.add(multiplier + " * " + i + " = " + (i * multiplier));

        }

        return new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTable);

    }

}