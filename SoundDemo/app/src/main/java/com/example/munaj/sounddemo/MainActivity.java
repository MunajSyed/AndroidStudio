package com.example.munaj.sounddemo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer media;
    AudioManager audio;
    ImageView dallas;
    public void play(View view){
        dallas = (ImageView)findViewById(R.id.dallas);

        media.start();

        dallas.animate().rotation(-360000).setDuration(100000);

    }

    public void pause(View view){
        dallas.animate().rotation(0).setDuration(0);

        media.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media = MediaPlayer.create(this, R.raw.anmolketchup);
        audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current = audio.getStreamVolume(AudioManager.STREAM_MUSIC);


        SeekBar volume = (SeekBar)findViewById(R.id.seekBar);

        volume.setMax(maxVolume);
        volume.setProgress(current);

        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){


            @Override //
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                 Log.i("Seekbar Value: ", Integer.toString(i));
                audio.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        }
        );
        final SeekBar seek = (SeekBar)findViewById(R.id.seekBar2);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seek.setProgress(media.getCurrentPosition());
            }
        }, 0, 100000);

        seek.setMax(media.getDuration());
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                media.seekTo(i);
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
