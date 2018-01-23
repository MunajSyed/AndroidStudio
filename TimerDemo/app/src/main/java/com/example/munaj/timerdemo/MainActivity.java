package com.example.munaj.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CountDownTimer(10000,1000){//Count downs from 10s to zero by decreasing by 1 second each time
           public void onTick(long millisecondsUntilDone){
                //Countdown
               Log.i("Seconds left", String.valueOf(millisecondsUntilDone/1000));
           }
           public void onFinish(){
               //Counter to finish agter 10 seconds
               Log.i("Done!","Countdown Timer Finished");
           }
        }.start();
       /* final Handler handler = new Handler(); //also chunk of code to be delayed , controls timing of event
        Runnable run = new Runnable() {
            @Override
            public void run() {
            //insert code to be run every second
                Log.i("Running has Run!", "a second must have passed...");
                handler.postDelayed(this, 5000);

            }
        };
        handler.post(run);*/
    }
}
