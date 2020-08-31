package com.example.tarea02quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static String[] questions = new String [] {
            "Apollo and Artemis are Twins",
            "Aphrodite is the goddess of marriage",
            "Heracles beheaded Medusa",
            "The Roman name for Hephaestus is Mercury",
            "Persephone is the daughter of Demeter",
            "One of Hera's sacred animals is the peacock",
            "Athena gifted the romans the olive tree",
            "Poseidon is the Lord of horses",
            "Achilles was the son of Zeus",
    };

    public static boolean[] answers = new boolean[]{
            true, false, false, false, true, true, false, true, false
    };

    private Button mTrueButton, mFalseButton, mNextButton;

    private TextView mQuestion;
    private static boolean mAnswer;
    private static int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion = (TextView) findViewById(R.id.questionTextView);
        mTrueButton = (Button) findViewById(R.id.trueButton);
        mFalseButton = (Button) findViewById(R.id.falseButton);
        mNextButton = (Button) findViewById(R.id.nextButton);

        mQuestion.setText(questions[mQuestionNumber]);
        mAnswer = answers[mQuestionNumber];

        // True Button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(mQuestionNumber < 9){
                Context context = getApplicationContext();
                String result = answers[mQuestionNumber] ? "Correct!" : "Incorrect!";
                Toast toast = Toast.makeText(context, result, Toast.LENGTH_SHORT);
                toast.show();
            }
            }


        });

        // False Button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestionNumber < 9){
                    Context context = getApplicationContext();
                    String result = answers[mQuestionNumber] ? "Incorrect!" : "Correct!";
                    Toast toast = Toast.makeText(context, result, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestionNumber < 9) {
                    mQuestionNumber++;
                    mQuestion.setText(questions[mQuestionNumber]);
                    mAnswer = answers[mQuestionNumber];

                }
                else {
                    mQuestionNumber = 0;
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "End of Quiz", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        });

    }
}