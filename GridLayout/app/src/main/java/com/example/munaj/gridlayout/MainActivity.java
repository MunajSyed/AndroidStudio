package com.example.munaj.gridlayout;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer helloPlay, howAreYouPlay,goodEveningPlay,pleasePlay,myNameIsPlay, doYouPlay, welcomePlay,iLiveInPlay;

    public void hello (View view){
        helloPlay.start();
    }
    public void howAreYou (View view){
        howAreYouPlay.start();
    }
    public void goodEvening (View view){
        goodEveningPlay.start();
    }
    public void please (View view){
        pleasePlay.start();
    }
    public void myNameIs(View view){
        myNameIsPlay.start();
    }
    public void doYou (View view){
        doYouPlay.start();
    }
    public void welcome (View view){
        welcomePlay.start();
    }
    public void iLiveIn (View view){
        iLiveInPlay.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloPlay = MediaPlayer.create(this, R.raw.hello);
        howAreYouPlay= MediaPlayer.create(this, R.raw.howareyou);
        goodEveningPlay= MediaPlayer.create(this, R.raw.goodevening);
        pleasePlay= MediaPlayer.create(this, R.raw.please);
        myNameIsPlay= MediaPlayer.create(this, R.raw.mynameis);
        doYouPlay= MediaPlayer.create(this, R.raw.doyouspeakenglish);
        welcomePlay= MediaPlayer.create(this, R.raw.welcome);
        iLiveInPlay= MediaPlayer.create(this, R.raw.ilivein);

    }
}
