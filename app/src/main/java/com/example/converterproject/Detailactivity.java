package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.converterproject.Adapter.ConverterAdapter;
import com.example.converterproject.Domain.Type;

import java.util.ArrayList;

public class Detailactivity extends AppCompatActivity {
    RecyclerView v1;
    RecyclerView.Adapter detailadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailactivity);
        v1=findViewById(R.id.v1);
        ArrayList<Type> list=new ArrayList<>();
        list.add(new Type("Conversion","Transform numbers from one base system to another.Whether its binary,decimal,octal,hexadecimal or any other,convert"));
        list.add(new Type("Basic Operations","Perform fundamental arithmatic operations with ease using this feature.Addition,subtraction,multiplication and division are seamlessly executed"));
        list.add(new Type("Complements","Compute the 1's and 2's complements of binary numbers using this feature"));
        list.add(new Type("Addition & Subtraction","Addition and subtraction"));
        detailadapter=new ConverterAdapter(list);
        v1.setAdapter(detailadapter);
        v1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}