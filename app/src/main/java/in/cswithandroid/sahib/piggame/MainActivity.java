package in.cswithandroid.sahib.piggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int userOverallScore;
    int userTurnScore;
    int computerTurnScore;
    int computerOverallScore;
    Random random;
    int rNumber;
    ImageView diceFace;
    boolean userTurn = true;
    TextView overallScoreTextView;
    TextView customTextView;
    TextView turnScoreTextView;
    Button holdButton;
    Button resetButton;
    Button rollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diceFace = (ImageView) findViewById(R.id.diceImageView);
        overallScoreTextView = (TextView) findViewById(R.id.scoreOverallTextView);
        turnScoreTextView = (TextView) findViewById(R.id.scoreTurnTextView);
        rollButton = (Button) findViewById(R.id.rollButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        holdButton = (Button) findViewById(R.id.holdButton);
        customTextView = (TextView) findViewById(R.id.comCustomtextView);
    }

    public void rollButtonClicked(View view){
        int value = rollDice();
        updateScore(value, userTurn, false);
    }

    public void updateScore(int value,boolean userT , boolean hold){

        if(userT){
            if(hold){
                userOverallScore += userTurnScore;
                userTurn = false;
                userTurnScore = 0;
            }
            else if(value == 1){
                userTurnScore = 0;
                userTurn = false;
            }
            else{
                userTurnScore += value;
            }
        }
        else{
            if(hold){
                computerOverallScore += computerTurnScore;
                userTurn = true;
                computerTurnScore = 0;
            }
            else if(value == 1){
                computerTurnScore = 0;
                userTurn = true;
            }
            else{
                computerTurnScore += value;
            }

        }
        updateLabelText();
    }

    public void updateLabelText(){
        overallScoreTextView.setText("Your Score: " + userOverallScore + " Computer Score: " + computerOverallScore);
        turnScoreTextView.setText("U-Turn: " + userTurnScore + " C-Turn: " + computerTurnScore);
    }

    public int  rollDice(){
        random = new Random();
        rNumber = random.nextInt(6)+1;

        switch(rNumber){
            case 1:
                diceFace.setImageResource(R.drawable.dice1);
                break;
            case 2:
                diceFace.setImageResource(R.drawable.dice2);
                break;
            case 3:
                diceFace.setImageResource(R.drawable.dice3);
                break;
            case 4:
                diceFace.setImageResource(R.drawable.dice4);
                break;
            case 5:
                diceFace.setImageResource(R.drawable.dice5);
                break;
            case 6:
                diceFace.setImageResource(R.drawable.dice6);
                break;
          }

        return rNumber;
    }


    public void holdButtonClicked(View view){
        updateScore(rNumber,userTurn,true);
    }


    public  void resetButtonClicked(View view){
        userOverallScore = 0;
        userTurnScore = 0;
        computerOverallScore = 0;
        computerTurnScore = 0;
        userTurn = true;
        updateLabelText();
    }

}
