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

class RecipeNr2 : AppCompatActivity() {
    private var list: ListView? = null
    private var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_nr2)
        list = findViewById<View>(R.id.listView) as ListView
        val recipes = arrayOf("3 łyżki oliwy z pierwszego tłoczenia,",
                "50 g szynki suszonej*",
                "1 cebula",
                "4 ząbki czosnku",
                "1 cukinia",
                "1 podłużna czerwona papryka",
                "1/2 łyżeczki suszonego oregano",
                "2 łyżki posiekanych listków bazylii",
                "1/2 łyżeczki wędzonej papryki w proszku (lub słodkiej)",
                "1/2 puszki pomidorów (krojonych, obranych)**")
        val recipeL = ArrayList<String>()
        recipeL.addAll(Arrays.asList(*recipes))
        adapter = ArrayAdapter(this, R.layout.mylist, recipeL)
        list!!.adapter = adapter
    }
}