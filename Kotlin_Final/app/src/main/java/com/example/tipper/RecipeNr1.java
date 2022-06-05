package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeNr1 extends AppCompatActivity {

    private ListView list ;
    private ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_nr1);

        list = (ListView) findViewById(R.id.listView);

        String recipes[] = {"400 g filetu (polędwiczki) z dorsza),",
                "2 łyżeczki skrobi ziemniaczanej lub mąki pszennej",
                "1 słoiczek tartego selera z ananasem lub bez",
                "1 łyżka masła klarowanego lub oleju roślinnego np. kokosowego",
                "2 łyżki czerwonej pasty curry (tajskiej)",
                "125 ml mleka kokosowego",
                "1/2 łyżeczki słodkiej papryki",
                "2 łyżeczki soku z limonki lub cytryny",
                "opcjonalnie 1 łyżeczka sosu (rybnego)",
                "garść szpinaku baby (sałatkowy)"};

        ArrayList<String> recipeL = new ArrayList<String>();
        recipeL.addAll( Arrays.asList(recipes) );

        adapter = new ArrayAdapter<String>(this, R.layout.mylist, recipeL);

        list.setAdapter(adapter);
    }
}