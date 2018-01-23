package com.example.munaj.connect3;

import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 = Yellow, 1 = Red
    int activePlayer = 0;
    boolean gameIsActive = true;
    int [] placement = {2,2,2,2,2,2,2,2,2}; //2 mean unplayed
    int [][] winningPositions = {{0,1,2},{0,3,6},{0,4,8},{1,4,7},{2,5,8},{2,4,6},{3,4,5},{6,7,8}};
    int place;
    public void dropIn(View view){
        ImageView center = (ImageView)view;
        place = Integer.parseInt(center.getTag().toString());

        if(placement[place] == 2 && gameIsActive == true) {
            center.setTranslationY(-1000f);
            placement[place] = activePlayer;

            if (activePlayer == 0) {
                center.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                center.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            center.animate().translationYBy(1000f).rotation(720).setDuration(500);

            for (int[] winningPosition: winningPositions){
                if(placement[winningPosition[0]] == placement[winningPosition[1]] &&
                        placement[winningPosition[1]] == placement[winningPosition[2]]&&
                        placement[winningPosition[0]] != 2){
                    gameIsActive = false;

                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                    layout.setVisibility(view.VISIBLE);
                }
                else{
                    boolean gameIsOver = true;
                    for(int counterState : placement){
                        if(counterState == 2){
                            gameIsOver = false;
                        }
                    }
                    if(gameIsOver){
                        TextView draw = (TextView)findViewById(R.id.textView);
                        draw.setText("DRAW");
                        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                        layout.setVisibility(view.VISIBLE);
                    }
                }
            }

        }

    }

    public void playAgain(View view){
        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(view.INVISIBLE);

        activePlayer = 0;

        for(int i = 0; i < 9; i++){
            placement[i] = 2;
        }

        GridLayout grid = (GridLayout)findViewById(R.id.gridLayout);
        for(int i = 0; i < grid.getChildCount(); i++){//Child count shows how many views we have in the grid layout
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }
        gameIsActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
