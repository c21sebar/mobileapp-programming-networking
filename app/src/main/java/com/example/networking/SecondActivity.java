package com.example.networking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity  extends AppCompatActivity {

    TextView text;
    Button button;
    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_second);
        super.onCreate(savedInstanceState);
        final String name = getIntent().getExtras().getString("Test");
        text =findViewById(R.id.secondActivityID);
        text.setText(name);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.finishButtonID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToMain();
            }
        });
    }
    void goBackToMain(){
        finish();
    }
}
