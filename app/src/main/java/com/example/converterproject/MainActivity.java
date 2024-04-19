package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout;
        constraintLayout=findViewById(R.id.cons);
        constraintLayout.setOnClickListener((view -> {
            Intent intent=new Intent(this,Detailactivity.class);
            startActivity(intent);

        }));

    }
}