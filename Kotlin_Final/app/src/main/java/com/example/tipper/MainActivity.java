package com.example.tipper;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar; // for changing the tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text
import android.widget.Toast;



import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity  {
    // currency and percent formatter objects
    private static final NumberFormat currencyFormat =
            NumberFormat.getNumberInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getNumberInstance();
    public double age = 1.0;
    private double weight = 0.0; // bill amount entered by the user
    private double percent = 1.50; // initial tip percentage
    private TextView amountTextView; // shows formatted bill amount
    private TextView percentTextView; // shows tip percentage
    private TextView ageTextView; // shows tip percentage
    private TextView tipTextView; // shows calculated tip amount
    private TextView tipTextView2; // shows calculated tip amount




    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI
        // get references to programmatically manipulated TextViews
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        tipTextView2 = (TextView) findViewById(R.id.tipTextView2);
        tipTextView.setText(currencyFormat.format(0));
        tipTextView.setText(currencyFormat.format(0));


        // set amountEditText's TextWatcher
        EditText amountEditText =
                (EditText) findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWatcher);

        // set percentSeekBar's OnSeekBarChangeListener
        SeekBar percentSeekBar =
                (SeekBar) findViewById(R.id.percentSeekBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);
        SeekBar percentSeekBar2 =
                (SeekBar) findViewById(R.id.ageSeekBar);
        percentSeekBar2.setOnSeekBarChangeListener(seekBarListener2);



    }

    // calculate and display tip and total amounts
    private void calculate() {
        // format percent and display in percentTextView
        percentTextView.setText(percentFormat.format(percent));
        ageTextView.setText(percentFormat.format(age));


        // calculate the tip and total
        double tip = weight / (percent * percent);
        double height = percent * 100.0;
        double kcal = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);

        // display tip and total formatted as currency
        tipTextView.setText(currencyFormat.format(tip));

        tipTextView2.setText(currencyFormat.format(kcal));

    }

    // listener object for the SeekBar's progress changed events
    private final OnSeekBarChangeListener seekBarListener =
            new OnSeekBarChangeListener() {
                // update percent, then call calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    percent = progress / 100.0; // set percent based on progress
                    calculate(); // calculate and display tip and total
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

    private final OnSeekBarChangeListener seekBarListener2 =
            new OnSeekBarChangeListener() {
                // update percent, then call calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    age = progress + 1; // set percent based on progress
                    calculate(); // calculate and display tip and
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

    // listener object for the EditText's text-changed events
    private final TextWatcher amountEditTextWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get bill amount and display currency formatted value
                weight = Double.parseDouble(s.toString());
                amountTextView.setText(currencyFormat.format(weight));
            } catch (NumberFormatException e) { // if s is empty or non-numeric
                amountTextView.setText("");
                weight = 0.0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };

    public void onRecipe1(View view) {
        startActivity(new Intent(this, RecipeNr1.class));
    }
    public void onRecipe2(View view) {
        startActivity(new Intent(this, RecipeNr2.class));
    }
    public void onQuiz(View view) { startActivity(new Intent(this, Quizz.class)); }
    public void onGame(View view) { startActivity(new Intent(this, Chart.class)); }

}




/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
