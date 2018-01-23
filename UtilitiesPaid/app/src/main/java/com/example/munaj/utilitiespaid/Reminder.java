package com.example.munaj.utilitiespaid;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Munaj on 12/26/2017.
 */

public class Reminder  extends AppCompatActivity {
    ImageButton startDate,endDate;
    int sDay,sMonth,sYear, eDay, eMonth, eYear;
    final String cYear = new SimpleDateFormat("yyyy").format(new Date());

    final String cMonth = new SimpleDateFormat("MM").format(new Date());
    final String cDay = new SimpleDateFormat("dd").format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        startDate = (ImageButton)findViewById(R.id.btnStart);
        endDate = (ImageButton)findViewById(R.id.btnEnd);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cal = Calendar.getInstance();
                sYear = cal.get(Calendar.YEAR);
                sMonth = cal.get(Calendar.MONTH);
                sDay = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dDate = new DatePickerDialog(Reminder.this,dpickerListner, sYear, sMonth, sDay);
                dDate.show();
                DatePickerDialog.OnDateSetListener dpickerListner
                        = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker,int year_x, int month_x, int day_x) {
                        sYear = year_x;
                        sMonth = month_x;
                        sDay = day_x;
                    }
                };
            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cal = Calendar.getInstance();
                eYear = cal.get(Calendar.YEAR);
                eMonth = cal.get(Calendar.MONTH);
                eDay = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dDate = new DatePickerDialog(Reminder.this,dpickerListner2, eYear, eMonth, eDay);
                dDate.show();
                DatePickerDialog.OnDateSetListener dpickerListner
                        = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker,int year_x, int month_x, int day_x) {
                        eYear = year_x;
                        eMonth = month_x;
                        eDay = day_x;
                    }
                };
            }
        });
    }
    public int dateChecker(int month, int day){
        if(month > Integer.parseInt(cMonth)){
            return 1;
        }
        else if(month == Integer.parseInt(cMonth)){
            if(day >= Integer.parseInt(cDay)){
                return 1;
            }
        }
        return 0;
    }
    //*****************************************************DATE PICKER***************************************************************
    private DatePickerDialog.OnDateSetListener dpickerListner
            = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year_x, int month_x, int day_x){
            sYear = year_x;
            sMonth = month_x + 1;
            sDay = day_x;
            if(sYear < Integer.parseInt(cYear) || dateChecker(sMonth, sDay) == 0){
                Toast.makeText(Reminder.this, "Please pick a correct date.", Toast.LENGTH_LONG).show();
                //dateError.setVisibility(View.VISIBLE);

            }
            else{
                Toast.makeText(Reminder.this, sYear + "/" + sMonth + "/" + sDay, Toast.LENGTH_LONG).show();
                //dateError.setVisibility(View.INVISIBLE);

            }
        }
    };

    private DatePickerDialog.OnDateSetListener dpickerListner2
            = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year_x, int month_x, int day_x){
            eYear = year_x;
            eMonth = month_x + 1;
            eDay = day_x;
            if(eYear < Integer.parseInt(cYear) || dateChecker(eMonth, eDay) == 0){
                Toast.makeText(Reminder.this, "Please pick a correct date.", Toast.LENGTH_LONG).show();
                //dateError.setVisibility(View.VISIBLE);

            }
            else{
                Toast.makeText(Reminder.this, eYear + "/" + eMonth + "/" + eDay, Toast.LENGTH_LONG).show();
                //dateError.setVisibility(View.INVISIBLE);

            }
        }
    };
}