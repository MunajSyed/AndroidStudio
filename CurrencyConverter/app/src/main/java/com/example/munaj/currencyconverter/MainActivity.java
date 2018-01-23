package com.example.munaj.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view){
        double pound = 0.0, dollar = 0.0;
        EditText dollarText = (EditText)findViewById(R.id.currencyTextField);
        dollar = Double.parseDouble(dollarText.getText().toString());

        pound = dollar * .58;

        Toast.makeText(MainActivity.this, "£" + pound, Toast.LENGTH_SHORT).show();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}
