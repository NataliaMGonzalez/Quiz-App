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
            "Magnets have two poles.",
            "Magnets have an East pole and a West pole.",
            "The Earth is not magnetic.",
            "Magnetic fields can clearly be seen with your eyes.",
            "The above diagram represents attraction between two magnets.",
            "An iron nail is attracted to a magnet.",
            "An electromagnet uses alternating current from the mains.",
            "An electromagnet is a temporary magnet.",
            "The above magnet is a disc magnet.",
    };

    public static boolean[] answers = new boolean[]{
            true, false, false, false, true, true, false, true, true
    };

    private Button mTrueButton, mFalseButton, mNextButton;

    private TextView mQuestion;
    private boolean mAnswer;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion = (TextView) findViewById(R.id.questionTextView);
        mTrueButton = (Button) findViewById(R.id.trueButton);
        mFalseButton = (Button) findViewById(R.id.falseButton);
        mNextButton = (Button) findViewById(R.id.nextButton);

        mQuestion.setText(questions[0]);
        mAnswer = answers[0];

        // True Button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(mQuestionNumber < 9){
                Context context = getApplicationContext();
                String result = answers[mQuestionNumber] ? "Correcto!" : "Incorrect!";
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
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "End of Quiz", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }


        });

    }
}