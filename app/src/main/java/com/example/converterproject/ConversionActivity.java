package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class ConversionActivity extends AppCompatActivity {
    String[] item={"Decimal","Binary","Octal","Hexadecimal","Others"};

    AutoCompleteTextView autoCompleteTextView,autoCompleteTextView1;
    ArrayAdapter<String>adapteritems;
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
                String item=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ConversionActivity.this,"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteTextView1=findViewById(R.id.auto_complete_text1);
        autoCompleteTextView1.setAdapter(adapteritems);


    }
}