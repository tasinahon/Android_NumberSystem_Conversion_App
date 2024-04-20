package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.converterproject.NumberSystem.BasicOperations;

public class ComplementActivity extends AppCompatActivity {
    TextView comres,comtext;
    EditText editText;
    ConstraintLayout ok;
    String op;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complement);
        Intent intent=getIntent();
        BasicOperations bo = new BasicOperations();
        op=intent.getStringExtra("Op");
        comres=findViewById(R.id.comres);
        ok=findViewById(R.id.ok3);
        editText = findViewById(R.id.editText1);
        comtext=findViewById(R.id.complement);
        ok.setOnClickListener((view -> {
            comres.setText("");
            int base = 2;
            String num = editText.getText().toString();
            if(op.equalsIgnoreCase("1's Complement")) {
                comtext.setText("Required "+op+"\n"+"value"+" "+":");
                comres.setText(bo.One_s_Complement(num));
            } else if(op.equalsIgnoreCase("2's Complement")) {
                comtext.setText("Required "+op+"\n"+"value"+" "+":");
                comres.setText(bo.Two_s_Complement(num));
            }

            comtext.setVisibility(View.VISIBLE);
            comres.setVisibility(View.VISIBLE);

        }));

    }
}