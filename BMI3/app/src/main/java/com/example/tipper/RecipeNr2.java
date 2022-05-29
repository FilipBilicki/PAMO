package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeNr2 extends AppCompatActivity {

    private ListView list ;
    private ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_nr2);

        list = (ListView) findViewById(R.id.listView);

        String recipes[] = {"3 łyżki oliwy z pierwszego tłoczenia,",
                "50 g szynki suszonej*",
                "1 cebula",
                "4 ząbki czosnku",
                "1 cukinia",
                "1 podłużna czerwona papryka",
                "1/2 łyżeczki suszonego oregano",
                "2 łyżki posiekanych listków bazylii",
                "1/2 łyżeczki wędzonej papryki w proszku (lub słodkiej)",
                "1/2 puszki pomidorów (krojonych, obranych)**"};

        ArrayList<String> recipeL = new ArrayList<String>();
        recipeL.addAll( Arrays.asList(recipes) );

        adapter = new ArrayAdapter<String>(this, R.layout.mylist, recipeL);

        list.setAdapter(adapter);
    }
}