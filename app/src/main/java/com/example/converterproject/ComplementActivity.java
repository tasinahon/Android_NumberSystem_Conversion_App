package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ComplementActivity extends AppCompatActivity {
    TextView comres,comtext;
    ConstraintLayout ok;
    String op;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complement);
        Intent intent=getIntent();
        op=intent.getStringExtra("Op");
        comres=findViewById(R.id.comres);
        ok=findViewById(R.id.ok3);
        comtext=findViewById(R.id.complement);
        ok.setOnClickListener((view -> {
            comtext.setText(comtext.getText()+" "+op+"\n"+"value"+" "+":");
            comtext.setVisibility(View.VISIBLE);
            comres.setVisibility(View.VISIBLE);

        }));

    }
}