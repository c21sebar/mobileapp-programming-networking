package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    private RecyclerView recyclerView;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    List<Mountain> bergLista = new ArrayList<>();
    MountainAdapter bergAdapter= new MountainAdapter(bergLista);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new JsonTask(this).execute(JSON_URL); //för url
        //new JsonFile(this, this).execute(JSON_FILE); //För lokalt

        List<String> bergNamn = Arrays.asList("Kinnekulle", "Billingen", "K2", "Kebnekaise", "Halle Berg", "Hunne Berg");
        recyclerView = findViewById(R.id.recycler_view1);

        recyclerView.setAdapter(bergAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", "berg lista: " + bergLista.size());
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>(){}.getType();
        bergLista = gson.fromJson(json, type);
        Log.d("MainActivity", "berg lista1: " + bergLista.size());
        bergAdapter.setBergLista(bergLista);
        bergAdapter.notifyDataSetChanged();


    }

}
