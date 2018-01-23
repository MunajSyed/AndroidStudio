package com.example.munaj.listviewpictures;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Creating variables for the list and arrays
    ListView list;
    String [] titles;
    String [] description;
    String [] time;
    String [] room;
    //Creating an array to call the pictures
    int[] imgs = {R.drawable.pizza, R.drawable.burger, R.drawable.hotdog, R.drawable.other};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Declaring the variables by calling the array in strings.xml
        Resources res = getResources();
        titles = res.getStringArray(R.array.titles);
        description = res.getStringArray(R.array.clubs);
        time = res.getStringArray(R.array.time);
        room = res.getStringArray(R.array.room);
        //Connceting the list with the listview in the content_main.xml
        list = (ListView) findViewById(R.id.list1);
        //Calling adapter for the list taking in the following paramters
        MyAdapter adapter = new MyAdapter(this,titles,imgs,description,time,room);
        //Sending the adapter to the list
        list.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        int[] imgs;
        String myTitle[];
        String myDescripton[];
        String myTime[];
        String myRoom[];

        //The variables the adapter in main needs
        MyAdapter(Context c, String[] titles, int[] imgs, String[] description, String[] time, String[] room) {
            //
            super(c, R.layout.content_main, R.id.text1, titles);
            this.context = c;
            this.imgs = imgs;
            this.myDescripton = description;
            this.myTitle = titles;
            this.myTime = time;
            this.myRoom = room;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.content_main,parent,false);
            ImageView images = (ImageView) row.findViewById(R.id.icon);
            ImageView reminder = (ImageView) row.findViewById(R.id.reminderBtn);
            TextView myTitle = (TextView) row.findViewById(R.id.text1);
            TextView myDescription = (TextView) row.findViewById(R.id.text2);
            TextView myTime = (TextView) row.findViewById(R.id.time);
            TextView myRoom = (TextView) row.findViewById(R.id.room);
            images.setImageResource(imgs[position]);
            myTitle.setText(titles[position]);
            myDescription.setText(description[position]);
            myTime.setText(time[position]);
            myRoom.setText(room[position]);

            reminder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Reminder Set for " + time[position] + "!", Toast.LENGTH_LONG).show();
                }
            });

            return row;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
