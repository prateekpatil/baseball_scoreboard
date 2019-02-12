package com.example.android.baseball_scoreborad;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ballCount = 0;
    int strikeCount = 0;
    int outCount = 0;
    int guestRun = 0;
    int inning =0;
    int homeRun=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayChangesOnScoreborad();
    }


    public void outOnClick(View view) {
        outCount+=1;
        strikeCount=0;
        ballCount=0;
        if (outCount == 3) {
            outCount=0;
        }
        displayChangesOnScoreborad();
    }

    public void displayOutCount(int score) {
        TextView scoreView = (TextView) findViewById(R.id.out_count);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LED.Font.ttf");
        scoreView.setTypeface(typeface);
        scoreView.setText(String.valueOf(score));
    }

    public void strikeOnClick(View view) {
        strikeCount+=1;
        if(strikeCount==3){
            strikeCount=0;
            ballCount=0;
            outOnClick(view);
        }
        displayChangesOnScoreborad();
    }
    public void displayStrikeCount(int score) {
        TextView scoreView = (TextView) findViewById(R.id.strike_count);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LED.Font.ttf");
        scoreView.setTypeface(typeface);
        scoreView.setText(String.valueOf(score));
    }

    public void ballOnClick(View view) {
        ballCount+=1;
        if(ballCount==4){
            strikeCount=0;
            ballCount=0;
        }
        displayChangesOnScoreborad();
    }

    public void displayBallCount(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ball_count);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LED.Font.ttf");
        scoreView.setTypeface(typeface);
        scoreView.setText(String.valueOf(score));
    }
    private void displayChangesOnScoreborad(){
        displayBallCount(ballCount);
        displayStrikeCount(strikeCount);
        displayOutCount(outCount);
    }

    public void resetScore(View view) {
        ballCount = 0;
        strikeCount = 0;
        outCount = 0;
        guestRun = 0;
        inning =0;
        homeRun=0;
        displayChangesOnScoreborad();

    }
}
