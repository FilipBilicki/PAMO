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
import android.widget.Toast

class Question     // setting the values through
// arguments passed in constructor
(// setting the Question passed
        // returning the Question passed
        // answerResId will store Question
        var answerResId: Int, // setting the correct
        // ans of Question
        // returning the correct answer
        // of Question
        // answerTrue will store correct answer
        // of the Question provided
        var isAnswerTrue: Boolean)