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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //variables
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1;
    private String player2;
    private EditText player1name;
    private EditText player2name;
    private TextView playerOneScoreView;
    private TextView playerTwoScoreView;
    private Button android_player1;
    private Button android_player2;
    private Button app_coding_player1;
    private Button app_coding_player2;
    private Button java_player1;
    private Button java_player2;
    private Button lazy_player1;
    private Button lazy_player2;
    private Button reset;
    private static final String STATE_player1Score = "player1Score";
    private static final String STATE_player2Score = "player2Score";
    private static final String STATE_player1Name = "player1";
    private static final String STATE_player2Name = "player2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextWatchers
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

        //EditTexts
        player1name = (EditText) findViewById(R.id.name_player1);
        player2name = (EditText) findViewById(R.id.name_player2);

        //Adding TextWatchers to EditText
        player1name.addTextChangedListener(textWatcherForPlayer1);
        player2name.addTextChangedListener(textWatcherForPlayer2);

        //TextViews
        playerOneScoreView = (TextView) findViewById(R.id.score_player1);
        playerTwoScoreView = (TextView) findViewById(R.id.score_player2);

        //Buttons
        android_player1 = (Button) findViewById(R.id.button_1h_android_player1);
        android_player2 = (Button) findViewById(R.id.button_1h_android_player2);
        app_coding_player1 = (Button) findViewById(R.id.button_1h_app_coding_player1);
        app_coding_player2 = (Button) findViewById(R.id.button_1h_app_coding_player2);
        java_player1 = (Button) findViewById(R.id.button_1h_java_player1);
        java_player2 = (Button) findViewById(R.id.button_1h_java_player2);
        lazy_player1 = (Button) findViewById(R.id.button_1h_lazy_player1);
        lazy_player2 = (Button) findViewById(R.id.button_1h_lazy_player2);
        reset = (Button) findViewById(R.id.button_reset);

        //Setting OnClickListener to buttons
        android_player1.setOnClickListener(this);
        android_player2.setOnClickListener(this);
        app_coding_player1.setOnClickListener(this);
        app_coding_player2.setOnClickListener(this);
        java_player1.setOnClickListener(this);
        java_player2.setOnClickListener(this);
        lazy_player1.setOnClickListener(this);
        lazy_player2.setOnClickListener(this);
        reset.setOnClickListener(this);


    }


    public void displayForPlayer1() {
        playerOneScoreView.setText(String.valueOf(player1Score));
    }

    public void displayForPlayer2() {
        playerTwoScoreView.setText(String.valueOf(player2Score));
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

    public void doResetScores(View view) {
        toastMaker("Winner is: " + whoIsWinner());
        player1Score = 0;
        player2Score = 0;
        displayForPlayer1();
        displayForPlayer2();
        player1name.setText("");
        player2name.setText("");


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_player1Score, player1Score);
        outState.putInt(STATE_player2Score, player2Score);
        outState.putString(STATE_player1Name, player1);
        outState.putString(STATE_player2Name, player2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        player1Score = outState.getInt(STATE_player1Score);
        player2Score = outState.getInt(STATE_player2Score);
        player1 = outState.getString(STATE_player1Name);
        player2 = outState.getString(STATE_player2Name);
        displayForPlayer1();
        displayForPlayer2();

    }


}
