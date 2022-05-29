package com.example.tipper;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tipper.Question;
import com.example.tipper.R;

public class Quizz extends AppCompatActivity
        implements View.OnClickListener {
    // setting up things
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private ImageView Image;
    private TextView questionTextView;
    private int correct = 0;
    // to keep current Question track
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {

            new Question(R.string.a, true),
            new Question(R.string.b, true),
            new Question(R.string.c, true),
            new Question(R.string.d, true),
            new Question(R.string.e, true),
            new Question(R.string.f, true),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);

        questionTextView
                = findViewById(R.id.answer_text_view);
        Image = findViewById(R.id.myimage);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v)
    {

        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:

                if (currentQuestionIndex < 7) {
                    currentQuestionIndex
                            = currentQuestionIndex + 1;

                    if (currentQuestionIndex == 6) {
                        questionTextView.setText(getString(
                                R.string.correct, correct));
                        nextButton.setVisibility(
                                View.INVISIBLE);
                        prevButton.setVisibility(
                                View.INVISIBLE);
                        trueButton.setVisibility(
                                View.INVISIBLE);
                        falseButton.setVisibility(
                                View.INVISIBLE);
                        if (correct > 3)

                            questionTextView.setText(
                                    "Poprawne " + correct
                                            + " "
                                            + "Z 6");

                        else
                            Image.setImageResource(
                                    R.drawable.olej);
                    }
                    else {
                        updateQuestion();
                    }
                }

                break;
            case R.id.prev_button:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex
                            = (currentQuestionIndex - 1)
                            % questionBank.length;
                    updateQuestion();
                }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion()
    {
        Log.d("Current",
                "onClick: " + currentQuestionIndex);

        questionTextView.setText(
                questionBank[currentQuestionIndex]
                        .getAnswerResId());
        // setting the textview with new Question
        switch (currentQuestionIndex) {
            case 1:
                // setting up image for each
                // Question
                Image.setImageResource(R.drawable.olej);
                break;
            case 2:
                Image.setImageResource(R.drawable.left);
                break;
            case 3:
                Image.setImageResource(R.drawable.right);
                break;
            case 4:
                Image.setImageResource(R.drawable.abc_vector_test);
                break;
            case 5:
                Image.setImageResource(R.drawable.ic_launcher_background);
                break;
            case 6:
                Image.setImageResource(R.drawable.dieta1);
                break;
            case 7:
                Image.setImageResource(R.drawable.ic_launcher_foreground);
                break;
        }
    }
    private void checkAnswer(boolean userChooseCorrect)
    {
        boolean answerIsTrue
                = questionBank[currentQuestionIndex]
                .isAnswerTrue();
        int toastMessageId;

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {
            // showing toast
            // message correct
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(Quizz.this, toastMessageId,
                Toast.LENGTH_SHORT).show();
    }
}
