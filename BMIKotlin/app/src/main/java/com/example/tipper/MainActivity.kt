package com.example.tipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipper.R
import com.anychart.charts.Pie
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.AnyChartView
import android.widget.TextView
import com.example.tipper.MainActivity
import android.widget.EditText
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.text.TextWatcher
import android.text.Editable
import android.content.Intent
import com.example.tipper.RecipeNr1
import com.example.tipper.RecipeNr2
import com.example.tipper.Quizz
import android.widget.ArrayAdapter
import android.widget.ImageButton
import com.example.tipper.Question
import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import android.os.Build
import android.view.View
import android.widget.Toast
import java.text.NumberFormat
import java.util.*

// for EditText event handling
// EditText listener
// for bill amount input
// for changing the tip percentage
// SeekBar listener
// for displaying text
// for currency formatting
class MainActivity : AppCompatActivity() {
    var age = 1.0
    private var weight = 0.0 // bill amount entered by the user
    private var percent = 1.50 // initial tip percentage
    private var amountTextView // shows formatted bill amount
            : TextView? = null
    private var percentTextView // shows tip percentage
            : TextView? = null
    private var ageTextView // shows tip percentage
            : TextView? = null
    private var tipTextView // shows calculated tip amount
            : TextView? = null
    private var tipTextView2 // shows calculated tip amount
            : TextView? = null
    var list = ArrayList<Double>()

    // called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.activity_main) // inflate the GUI
        // get references to programmatically manipulated TextViews
        amountTextView = findViewById<View>(R.id.amountTextView) as TextView
        percentTextView = findViewById<View>(R.id.percentTextView) as TextView
        ageTextView = findViewById<View>(R.id.ageTextView) as TextView
        tipTextView = findViewById<View>(R.id.tipTextView) as TextView
        tipTextView2 = findViewById<View>(R.id.tipTextView2) as TextView
        tipTextView!!.text = currencyFormat.format(0)
        tipTextView!!.text = currencyFormat.format(0)


        // set amountEditText's TextWatcher
        val amountEditText = findViewById<View>(R.id.amountEditText) as EditText
        amountEditText.addTextChangedListener(amountEditTextWatcher)

        // set percentSeekBar's OnSeekBarChangeListener
        val percentSeekBar = findViewById<View>(R.id.percentSeekBar) as SeekBar
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener)
        val percentSeekBar2 = findViewById<View>(R.id.ageSeekBar) as SeekBar
        percentSeekBar2.setOnSeekBarChangeListener(seekBarListener2)
    }

    // calculate and display tip and total amounts
    private fun calculate() {
        // format percent and display in percentTextView
        percentTextView!!.text = percentFormat.format(percent)
        ageTextView!!.text = percentFormat.format(age)

        // calculate the tip and total
        val tip = weight / (percent * percent)
        val height = percent * 100.0
        val kcal = 66.5 + 13.75 * weight + 5.003 * height - 6.775 * age


        // display tip and total formatted as currency
        tipTextView!!.text = currencyFormat.format(tip)
        tipTextView2!!.text = currencyFormat.format(kcal)
    }

    // listener object for the SeekBar's progress changed events
    private val seekBarListener: OnSeekBarChangeListener = object : OnSeekBarChangeListener {
        // update percent, then call calculate
        override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                       fromUser: Boolean) {
            percent = progress / 100.0 // set percent based on progress
            calculate() // calculate and display tip and total
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }
    private val seekBarListener2: OnSeekBarChangeListener = object : OnSeekBarChangeListener {
        // update percent, then call calculate
        override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                       fromUser: Boolean) {
            age = (progress + 1).toDouble() // set percent based on progress
            calculate() // calculate and display tip and
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }

    // listener object for the EditText's text-changed events
    private val amountEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try { // get bill amount and display currency formatted value
                weight = s.toString().toDouble()
                amountTextView!!.text = currencyFormat.format(weight)
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                amountTextView!!.text = ""
                weight = 0.0
            }
            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }

    fun onRecipe1(view: View?) {
        startActivity(Intent(this, RecipeNr1::class.java))
    }

    fun onRecipe2(view: View?) {
        startActivity(Intent(this, RecipeNr2::class.java))
    }

    fun onQuiz(view: View?) {
        startActivity(Intent(this, Quizz::class.java))
    }

    fun onGame(view: View?) {
        startActivity(Intent(this, Chart::class.java))
    }

    companion object {
        // currency and percent formatter objects
        private val currencyFormat = NumberFormat.getNumberInstance()
        private val percentFormat = NumberFormat.getNumberInstance()
    }
}