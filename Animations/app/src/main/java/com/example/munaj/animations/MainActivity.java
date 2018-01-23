package com.example.munaj.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view){
        ImageView bart = (ImageView)findViewById(R.id.bart);

        // bart.animate().translationYBy(1000f).setDuration(2000); moves bart down off screen
        //bart.animate().translationXBy(1000f).setDuration(2000); // moves bart to the right off screen
        //bart.animate().rotation(360f).setDuration(2000); // Roate bart 180 degrees
        // ImageView homer = (ImageView)findViewById(R.id.homer);
        //bart.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000); //Shrink bart or make him grow.

        bart.animate().rotation(360f).scaleX(0.5f).scaleY(0.5f).setDuration(2000); //Shrink bart or make him grow.

        // homer.animate().alpha(1f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView bart = (ImageView)findViewById(R.id.bart);

        bart.setTranslationX(1000f);
        bart.animate().translationXBy(-1000f).setDuration(2000); // .alpha uses a float and duration is in 1000 = 1sec

    }
}
