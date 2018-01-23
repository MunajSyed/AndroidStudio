package com.example.munaj.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = (ListView)findViewById(R.id.listView);
        final SeekBar seek = (SeekBar)findViewById(R.id.seekBar);

        seek.setMax(20);
        seek.setProgress(10);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int times;
                if(i < min){
                    times = min;
                    seek.setProgress(min);

                }
                else{
                    times = i;
                }

                int timesTable = times;

                ArrayList<String> content = new ArrayList<String>();
                for(int x = 1; x <=10; x++){
                    content.add(Integer.toString(x * timesTable));
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_item, content);

                list.setAdapter(adapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
