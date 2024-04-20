package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.converterproject.NumberSystem.NumberConvertion;

public class InpActivity extends AppCompatActivity {
    String from,to;
    TextView textViewfrom,textViewto;
    ConstraintLayout ok;
    TextView req,totext,value;
    EditText val;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inp);

        NumberConvertion nc = new NumberConvertion();

        Intent intent=getIntent();
        from=intent.getStringExtra("From");
        to=intent.getStringExtra("To");
        textViewfrom=findViewById(R.id.fromt);
        textViewfrom.setText(from);

        req=findViewById(R.id.reqvalue);
        totext=findViewById(R.id.totext);

//        System.out.println(result);
        value=findViewById(R.id.value);

        totext.setText(to);
        ok=findViewById(R.id.ok3);
        int base1,base2;

        if(!from.equalsIgnoreCase("Others")) base1 = nc.baseMap.get(from);
        else base1 = 10;
        if(!to.equalsIgnoreCase("Others")) base2 = nc.baseMap.get(to);
        else base2 = 10;

        ok.setOnClickListener((view -> {
            req.setVisibility(View.VISIBLE);
            totext.setVisibility(View.VISIBLE);
            val = findViewById(R.id.editTextTextPersonName);
            String result = nc.AnyToAny(val.getText().toString(),base1,base2);
            value.setText(result);
            value.setVisibility(View.VISIBLE);

        }));

    }
}