package com.example.tipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipper.R
import com.anychart.charts.Pie
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.AnyChartView
import com.example.tipper.MainActivity
import android.widget.SeekBar.OnSeekBarChangeListener
import android.text.TextWatcher
import android.text.Editable
import android.content.Intent
import com.example.tipper.RecipeNr1
import com.example.tipper.RecipeNr2
import com.example.tipper.Quizz
import com.example.tipper.Question
import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.*

class Quizz : AppCompatActivity(), View.OnClickListener {
    // setting up things
    private var falseButton: Button? = null
    private var trueButton: Button? = null
    private var nextButton: ImageButton? = null
    private var prevButton: ImageButton? = null
    private var Image: ImageView? = null
    private var questionTextView: TextView? = null
    private var correct = 0

    // to keep current Question track
    private var currentQuestionIndex = 0
    private val questionBank = arrayOf(
            Question(R.string.a, true),
            Question(R.string.b, true),
            Question(R.string.c, true),
            Question(R.string.d, true),
            Question(R.string.e, true),
            Question(R.string.f, true))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)
        val falseButton = findViewById(R.id.false_button) as Button
        val trueButton = findViewById(R.id.true_button) as Button
        val nextButton = findViewById(R.id.next_button) as ImageButton
        val prevButton = findViewById(R.id.prev_button) as ImageButton
        questionTextView = findViewById(R.id.answer_text_view)
        Image = findViewById(R.id.myimage)

    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onClick(v: View) {
        when (v.id) {
            R.id.false_button -> checkAnswer(false)
            R.id.true_button -> checkAnswer(true)
            R.id.next_button -> if (currentQuestionIndex < 7) {
                currentQuestionIndex = currentQuestionIndex + 1
                if (currentQuestionIndex == 6) {
                    questionTextView!!.text = getString(
                            R.string.correct, correct)
                    nextButton!!.visibility = View.INVISIBLE
                    prevButton!!.visibility = View.INVISIBLE
                    trueButton!!.visibility = View.INVISIBLE
                    falseButton!!.visibility = View.INVISIBLE
                    if (correct > 3) questionTextView!!.text = ("Poprawne " + correct
                            + " "
                            + "Z 6") else Image!!.setImageResource(
                            R.drawable.olej)
                } else {
                    updateQuestion()
                }
            }
            R.id.prev_button -> if (currentQuestionIndex > 0) {
                currentQuestionIndex = ((currentQuestionIndex - 1)
                        % questionBank.size)
                updateQuestion()
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun updateQuestion() {
        Log.d("Current",
                "onClick: $currentQuestionIndex")
        questionTextView?.setText(
                questionBank[currentQuestionIndex]
                        .answerResId)
        when (currentQuestionIndex) {
            1 ->

                Image!!.setImageResource(R.drawable.olej)
            2 -> Image!!.setImageResource(R.drawable.left)
            3 -> Image!!.setImageResource(R.drawable.right)
            4 -> Image!!.setImageResource(R.drawable.abc_vector_test)
            5 -> Image!!.setImageResource(R.drawable.ic_launcher_background)
            6 -> Image!!.setImageResource(R.drawable.dieta1)
            7 -> Image!!.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }

    private fun checkAnswer(userChooseCorrect: Boolean) {
        val answerIsTrue = questionBank[currentQuestionIndex]
                .isAnswerTrue
        val toastMessageId: Int
        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer
            correct++
        } else {
            // showing toast
            // message correct
            toastMessageId = R.string.wrong_answer
        }
        Toast.makeText(this@Quizz, toastMessageId,
                Toast.LENGTH_SHORT).show()
    }
}