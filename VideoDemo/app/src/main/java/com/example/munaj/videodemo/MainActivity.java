package com.example.munaj.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView vid = (VideoView)findViewById(R.id.videoView);
        vid.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mar); //Get the path of the video in the RAW folder under Rez that we created

        MediaController mediaController = new MediaController(this); //Media controls gives you access to control the video
        mediaController.setAnchorView(vid); //connecting it to the video

        vid.setMediaController(mediaController); //connect video to media control

        vid.start();
    }
}
