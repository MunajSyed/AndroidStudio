package com.example.munaj.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.munaj.eggtimer.R.id.seekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar seek = (SeekBar)findViewById(seekBar);
        final TextView timerText = (TextView)findViewById(R.id.timerTextView);

        seek.setMax(600);
        seek.setProgress(30);}
        public void go(View view){

        }

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 30;
                final int minute = (int)i/60;
                int seconds = i - minute * 60;
                int times;
                if(i < min){
                    times = min;
                    seek.setProgress(min);

                }
                else{
                    times = i;
                }
                timerText.setText(Integer.toString(minute) + ":" + Integer.toString(seconds));

                int timesTable = times;

                new CountDownTimer(seconds*1000,1000){//Count downs from 10s to zero by decreasing by 1 second each time
                    public void onTick(long millisecondsUntilDone){
                        //Countdown
                        //timerText.setText(String.valueOf(millisecondsUntilDone/1000) + ":" + Integer.toString(minute));
                        Log.i("Seconds left", String.valueOf(millisecondsUntilDone/1000));
                    }
                    public void onFinish(){
                        //Counter to finish agter 10 seconds
                        Log.i("Done!","Countdown Timer Finished");
                    }
                }.start();
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
