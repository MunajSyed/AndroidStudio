package com.example.munaj.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int n;
    public void guess(View view){
        EditText guessMe = (EditText)findViewById(R.id.guessId);
        int guessNumber;
        int loop = 0;
            guessNumber = Integer.parseInt(guessMe.getText().toString());
            if(guessNumber == n){
                Toast.makeText(MainActivity.this, "Congrats! The Number Was " + n, Toast.LENGTH_SHORT).show();
                Random rand = new Random();

                n = rand.nextInt(10) + 1;
            }
            else if (guessNumber > n){
                Toast.makeText(MainActivity.this, "Lower" + guessNumber, Toast.LENGTH_SHORT).show();
            }
            else if (guessNumber < n){
                Toast.makeText(MainActivity.this, "Higher" + guessNumber, Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();

        n = rand.nextInt(10) + 1;

    }
}
