package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class BasicOpDetail extends AppCompatActivity {
    String op;
    TextView t1,opvalue;
    ConstraintLayout ok;
    String item1;
    AutoCompleteTextView autoCompleteTextView;
    String[] item={"Decimal","Binary","Octal","Hexadecimal","Others"};
    ArrayAdapter<String> adapteritems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_op_detail);
        autoCompleteTextView=findViewById(R.id.auto_complete_text);
        adapteritems=new ArrayAdapter<String>(this,R.layout.list,item);
        autoCompleteTextView.setAdapter(adapteritems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item1=adapterView.getItemAtPosition(i).toString();

            }
        });
        Intent intent=getIntent();
        op=intent.getStringExtra("Op");
        t1=findViewById(R.id.result);
        opvalue=findViewById(R.id.opvalue);
        ok=findViewById(R.id.ok3);
        ok.setOnClickListener((view -> {
            t1.setText(t1.getText()+" "+op+" "+":");
            t1.setVisibility(View.VISIBLE);
            opvalue.setVisibility(View.VISIBLE);

        }));


    }
}