package com.example.networking;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity  extends AppCompatActivity {

    TextView text;
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_second);
        super.onCreate(savedInstanceState);
        final String name = getIntent().getExtras().getString("Test");
        text =findViewById(R.id.secondActivityID);
        text.setText(name);
    }
    void goBackToMain(){
        finish();
    }
}
