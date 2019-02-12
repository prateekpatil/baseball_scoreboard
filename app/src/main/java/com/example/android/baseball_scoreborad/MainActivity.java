package com.example.android.baseball_scoreborad;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private int ballCount = 0;
    private int strikeCount = 0;
    private int outCount = 0;
    private int guestTeamRuns = 0;
    private int inningCount = 0;
    private int homeTeamRuns = 0;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayChangesOnScoreborad();
        toggleButton = (ToggleButton) findViewById(R.id.togglebutton);
    }


    public void outOnClick(View view) {
        outCount += 1;
        strikeCount = 0;
        ballCount = 0;
        if (outCount == 3) {
            outCount = 0;
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
        strikeCount += 1;
        if (strikeCount == 3) {
            strikeCount = 0;
            ballCount = 0;
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
        ballCount += 1;
        if (ballCount == 4) {
            strikeCount = 0;
            ballCount = 0;
        }
        displayChangesOnScoreborad();
    }

    public void displayBallCount(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ball_count);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LED.Font.ttf");
        scoreView.setTypeface(typeface);
        scoreView.setText(String.valueOf(score));
    }

    public void guestOnClick(View view) {
        if (!toggleButton.isChecked()) {
            guestTeamRuns += 1;
        }
        displayChangesOnScoreborad();
    }

    public void displayGuestRunCount(int score) {
        TextView scoreView = (TextView) findViewById(R.id.guest_count);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LED.Font.ttf");
        scoreView.setTypeface(typeface);
        scoreView.setText(String.valueOf(score));
    }


    public void inningOnClick(View view) {
        inningCount += 1;
        displayChangesOnScoreborad();
    }

    public void displayInningCount(int score) {
        TextView scoreView = (TextView) findViewById(R.id.inning_count);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LED.Font.ttf");
        scoreView.setTypeface(typeface);
        scoreView.setText(String.valueOf(score));
    }

    public void homeOnclick(View view) {
        if (toggleButton.isChecked()) {
            homeTeamRuns += 1;
        }
        displayChangesOnScoreborad();
    }

    public void displayHomeTeamRunCount(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_count);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LED.Font.ttf");
        scoreView.setTypeface(typeface);
        scoreView.setText(String.valueOf(score));
    }

    private void displayChangesOnScoreborad() {
        displayBallCount(ballCount);
        displayStrikeCount(strikeCount);
        displayOutCount(outCount);
        displayGuestRunCount(guestTeamRuns);
        displayInningCount(inningCount);
        displayHomeTeamRunCount(homeTeamRuns);
    }

    public void teamSelectionOnToggle(View view) {
        if (toggleButton.isChecked()) {
            Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "GUEST", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetScore(View view) {
        ballCount = 0;
        strikeCount = 0;
        outCount = 0;
        guestTeamRuns = 0;
        inningCount = 0;
        homeTeamRuns = 0;
        displayChangesOnScoreborad();

    }
}
