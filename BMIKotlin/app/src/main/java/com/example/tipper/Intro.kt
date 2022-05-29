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

class Intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
    }

    fun onClick(view: View?) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}