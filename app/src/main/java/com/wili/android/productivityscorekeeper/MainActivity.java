package com.wili.android.productivityscorekeeper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.wili.android.productivityscorekeeper.R.id.button_1h_android_player1;

public class MainActivity extends AppCompatActivity {
    /**
     * variables
     */
    int player1Score = 0;
    int player2Score = 0;
    String player1;
    String player2;
    EditText player1name;
    EditText player2name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextWatcher textWatcherForPlayer1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                player1 = editable.toString();
            }
        };
        TextWatcher textWatcherForPlayer2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                player2 = editable.toString();
            }
        };

        player1name = (EditText) findViewById(R.id.name_player1);
        player2name = (EditText) findViewById(R.id.name_player2);
        player1name.addTextChangedListener(textWatcherForPlayer1);
        player2name.addTextChangedListener(textWatcherForPlayer2);

    }


    public void displayForPlayer1() {
        TextView playerOneScoreView = (TextView) findViewById(R.id.score_player1);
        playerOneScoreView.setText(String.valueOf(player1Score));
    }

    public void displayForPlayer2() {
        TextView scoreView = (TextView) findViewById(R.id.score_player2);
        scoreView.setText(String.valueOf(player2Score));
    }

    public void toastMaker(String text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void displayAndIncreaseScore(String player, int points) {
        if (player.equals("player1")) {
            player1Score += points;
            displayForPlayer1();
            toastMaker(points + " added to " + player1);
        } else if (player.equals("player2")) {
            player2Score += points;
            displayForPlayer2();
            toastMaker(points + " added to " + player2);
        }
    }

    public void clicker(View view) {

        Button switchButton = (Button) view;
        switch (switchButton.getId()) {
            case button_1h_android_player1:
                displayAndIncreaseScore("player1", 1);
                break;
            case R.id.button_1h_android_player2:
                displayAndIncreaseScore("player2", 1);
                break;
            case R.id.button_1h_app_coding_player1:
                displayAndIncreaseScore("player1", 1);
                break;
            case R.id.button_1h_app_coding_player2:
                displayAndIncreaseScore("player2", 1);
                break;
            case R.id.button_1h_java_player1:
                displayAndIncreaseScore("player1", 1);
                break;
            case R.id.button_1h_java_player2:
                displayAndIncreaseScore("player2", 1);
                break;
            case R.id.button_1h_lazy_player1:
                displayAndIncreaseScore("player1", -2);
                break;
            case R.id.button_1h_lazy_player2:
                displayAndIncreaseScore("player2", -2);
                break;
            case R.id.button_reset:
                doResetScores(view);
                break;

        }
    }

    public String whoIsWinner() {
        String winner = null;
        if (player1Score > player2Score)
            winner = player1;
        else if (player1Score == player2Score)
            winner = player1 + " and " + player2;
        else
            winner = player2;
        return winner;
    }


    /**
     * Reset all scores and display them.
     */
    public void doResetScores(View view) {
        toastMaker("Winner is: " + whoIsWinner());
        player1Score = 0;
        player2Score = 0;
        displayForPlayer1();
        displayForPlayer2();
        player1name.setText("");
        player2name.setText("");


    }
}
