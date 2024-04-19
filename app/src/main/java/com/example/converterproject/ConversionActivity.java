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
import android.widget.Toast;

public class ConversionActivity extends AppCompatActivity {
    String[] item={"Decimal","Binary","Octal","Hexadecimal","Others"};
    String item1,item2;
    AutoCompleteTextView autoCompleteTextView,autoCompleteTextView1;
    ArrayAdapter<String>adapteritems;
    ConstraintLayout done;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        autoCompleteTextView=findViewById(R.id.auto_complete_text);
        adapteritems=new ArrayAdapter<String>(this,R.layout.list,item);
        autoCompleteTextView.setAdapter(adapteritems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item1=adapterView.getItemAtPosition(i).toString();

            }
        });
        autoCompleteTextView1=findViewById(R.id.auto_complete_text1);
        autoCompleteTextView1.setAdapter(adapteritems);
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item2=adapterView.getItemAtPosition(i).toString();

            }
        });
        done = findViewById(R.id.done);
        done.setOnClickListener((view -> {
            Intent intent=new Intent(this,InpActivity.class);
            intent.putExtra("From",item1);
            intent.putExtra("To",item2);
            startActivity(intent);

        }));


    }
}