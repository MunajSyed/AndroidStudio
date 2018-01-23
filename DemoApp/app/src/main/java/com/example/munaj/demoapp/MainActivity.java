package com.example.munaj.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void closedStar(View view){
        Toast.makeText(MainActivity.this, "Fav", Toast.LENGTH_SHORT).show();
        ImageView goldStar = (ImageView)findViewById(R.id.goldStar);
        ImageView star = (ImageView)findViewById(R.id.star);

        goldStar.setVisibility(View.VISIBLE);
        star.setVisibility(View.INVISIBLE);
    }

    public void star(View view){
        ImageView goldStar = (ImageView)findViewById(R.id.goldStar);
        ImageView star = (ImageView)findViewById(R.id.star);
        Toast.makeText(MainActivity.this, "UnFav", Toast.LENGTH_SHORT).show();
        goldStar.setVisibility(View.INVISIBLE);
        star.setVisibility(View.VISIBLE);
    }

    //View connects to the button
    public void clickFunction(View view){

        EditText myTextField = (EditText) findViewById(R.id.txtUsername);
        Toast.makeText(MainActivity.this, myTextField.getText().toString(), Toast.LENGTH_LONG).show();

        //Display messages on the Log
        Log.i("Info", myTextField.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
