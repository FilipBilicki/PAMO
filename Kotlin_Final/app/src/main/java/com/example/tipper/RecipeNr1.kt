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
import android.view.View
import android.widget.*
import java.util.*

class RecipeNr1 : AppCompatActivity() {
    private var list: ListView? = null
    private var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_nr1)
        list = findViewById<View>(R.id.listView) as ListView
        val recipes = arrayOf("400 g filetu (polędwiczki) z dorsza),",
                "2 łyżeczki skrobi ziemniaczanej lub mąki pszennej",
                "1 słoiczek tartego selera z ananasem lub bez",
                "1 łyżka masła klarowanego lub oleju roślinnego np. kokosowego",
                "2 łyżki czerwonej pasty curry (tajskiej)",
                "125 ml mleka kokosowego",
                "1/2 łyżeczki słodkiej papryki",
                "2 łyżeczki soku z limonki lub cytryny",
                "opcjonalnie 1 łyżeczka sosu (rybnego)",
                "garść szpinaku baby (sałatkowy)")
        val recipeL = ArrayList<String>()
        recipeL.addAll(Arrays.asList(*recipes))
        adapter = ArrayAdapter(this, R.layout.mylist, recipeL)
        list!!.adapter = adapter
    }
}