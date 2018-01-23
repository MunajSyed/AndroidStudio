package com.example.munaj.sqlite;

import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    EditText input;
    TextView text;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        text = (TextView) findViewById(R.id.text);
        dbHandler = new MyDBHandler(this, null, null, 1);

        printDatabase();

    }
    //Add a product to the database
    public void btnAddClicked(View view){
        List list = new List(input.getText().toString());
        dbHandler.addProduct(list);
        printDatabase();
    }

    //Delete items
    public void btnDeleteClicked(View view){
        String inputText = text.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        text.setText(dbString);
        input.setText("");
    }

}