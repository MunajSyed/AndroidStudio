package com.example.munaj.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number {

        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {

                return true;
            } else {

                return false;

            }

        }

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }

        }


    }

    Number myNumber  = new Number();


    public void shape(View view){
        EditText number = (EditText)findViewById(R.id.numberText);
        myNumber.number = Integer.parseInt(number.getText().toString());
        if(myNumber.isSquare() == true){
            Toast.makeText(MainActivity.this, "SQUARE", Toast.LENGTH_SHORT).show();
        }
        if(myNumber.isTriangular() == true){
            Toast.makeText(MainActivity.this, "TRIANGLE", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
