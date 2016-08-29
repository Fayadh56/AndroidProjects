package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int wicketsA = 0;
    int wicketsB = 0;

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void wicketsA(int wickets) {
        TextView wicketsView = (TextView) findViewById(R.id.team_a_wickets);
        wicketsView.setText(String.valueOf(wickets));
    }

    public void wicketsB(int wickets) {
        TextView wicketsView = (TextView) findViewById(R.id.team_b_wickets);
        wicketsView.setText(String.valueOf(wickets));
    }

    // scoring system for team A
    public void addSixForA(View v) {
        scoreTeamA += 6;
        displayForTeamA(scoreTeamA);
    }

    public void addFourForA(View v) {
        scoreTeamA += 4;
        displayForTeamA(scoreTeamA);
    }

    public void oneForA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void outA(View v) {
        wicketsA += 1;
        wicketsA(wicketsA);
    }

    public void addSixForB(View v) {
        scoreTeamB += 6;
        displayForTeamB(scoreTeamB);
    }

    public void addFourForB(View v) {
        scoreTeamB += 4;
        displayForTeamB(scoreTeamB);
    }

    public void oneForB(View v) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    public void outB(View v) {
        wicketsB += 1;
        wicketsB(wicketsB);
    }

    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        wicketsB = 0;
        wicketsA = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        wicketsB(wicketsB);
        wicketsA(wicketsA);
    }
}
