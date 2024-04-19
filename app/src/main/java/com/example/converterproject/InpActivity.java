package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InpActivity extends AppCompatActivity {
    String from,to;
    TextView textViewfrom,textViewto;
    ConstraintLayout ok;
    TextView req,totext,value;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inp);
        Intent intent=getIntent();
        from=intent.getStringExtra("From");
        to=intent.getStringExtra("To");
        textViewfrom=findViewById(R.id.fromt);
        textViewfrom.setText(from);

        req=findViewById(R.id.reqvalue);
        totext=findViewById(R.id.totext);
        value=findViewById(R.id.value);
        totext.setText(to);
        ok=findViewById(R.id.ok);
        ok.setOnClickListener((view -> {
            req.setVisibility(View.VISIBLE);
            totext.setVisibility(View.VISIBLE);
            value.setVisibility(View.VISIBLE);

        }));




    }
}