package xyz.fayadh.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int totalScore = 0;

    // displays scores here
    public void displayScore(int score) {
        TextView displayScore = (TextView) findViewById(R.id.score);
        EditText text = (EditText) findViewById(R.id.editText);
        String name = text.getText().toString();
        if (score == 8) {
            String score1 = "Score for " + name + ": " + score + " All Correct!";
            displayScore.setText(score1);
        } else {
            String score1 = "Score for " + name + ": " + score + " Some Errors!!";
            displayScore.setText(score1);
        }
    }

    //click handler for score button
    public void scoreClick(View v) {
        int score = 0;
        score = checkStatus();
        displayScore(score);
        totalScore = 0;
    }

    // function to check the status of radio buttons and the checkboxes
    public int checkStatus() {
        RadioButton btn8 = (RadioButton) findViewById(R.id.rad8);
        boolean btnStatus8 = btn8.isChecked();
        if (btnStatus8) {
            totalScore += 1;
        }

        RadioButton btn7 = (RadioButton) findViewById(R.id.rad7);
        boolean btnStatus7 = btn7.isChecked();
        if (btnStatus7) {
            totalScore += 1;
        }

        CheckBox rad6A = (CheckBox) findViewById(R.id.rad6A);
        CheckBox rad6B = (CheckBox) findViewById(R.id.rad6B);
        CheckBox rad6C = (CheckBox) findViewById(R.id.rad6C);
        CheckBox rad6D = (CheckBox) findViewById(R.id.rad6D);
        if (rad6A.isChecked() && rad6B.isChecked() && !rad6C.isChecked() && !rad6D.isChecked()) {
            totalScore += 1;
            rad6A.clearFocus();
        }

        RadioButton btn5 = (RadioButton) findViewById(R.id.rad5);
        boolean btnStatus5 = btn5.isChecked();
        if (btnStatus5) {
            totalScore += 1;
        }

        RadioButton btn4 = (RadioButton) findViewById(R.id.rad4);
        boolean btnStatus4 = btn4.isChecked();
        if (btnStatus4) {
            totalScore += 1;
        }

        RadioButton btn3 = (RadioButton) findViewById(R.id.rad3);
        boolean btnStatus3 = btn3.isChecked();
        if (btnStatus3) {
            totalScore += 1;
        }

        RadioButton btn2 = (RadioButton) findViewById(R.id.rad2);
        boolean btnStatus2 = btn2.isChecked();
        if (btnStatus2) {
            totalScore += 1;
        }

        EditText text2 = (EditText) findViewById(R.id.editText1);
        if (text2.getText().toString().equals("10")) {
            totalScore++;
        }
        return totalScore;
    }

    // reset scores functions, also resets radiobuttons and checkboxes
    public void resetScores(View v) {
        totalScore = 0;
        displayScore(totalScore);
        RadioGroup group8 = (RadioGroup) findViewById(R.id.group8);
        RadioGroup group7 = (RadioGroup) findViewById(R.id.group7);
        RadioGroup group5 = (RadioGroup) findViewById(R.id.group5);
        RadioGroup group4 = (RadioGroup) findViewById(R.id.group4);
        RadioGroup group3 = (RadioGroup) findViewById(R.id.group3);
        RadioGroup group2 = (RadioGroup) findViewById(R.id.group2);
        CheckBox rad6A = (CheckBox) findViewById(R.id.rad6A);
        CheckBox rad6B = (CheckBox) findViewById(R.id.rad6B);
        rad6A.setChecked(false);
        rad6B.setChecked(false);
        group8.clearCheck();
        group7.clearCheck();
        group5.clearCheck();
        group4.clearCheck();
        group3.clearCheck();
        group2.clearCheck();
    }
}
