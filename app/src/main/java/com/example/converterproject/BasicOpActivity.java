package com.example.converterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.converterproject.Adapter.BasicOpAdapter;
import com.example.converterproject.Adapter.ConverterAdapter;
import com.example.converterproject.Domain.Operations;
import com.example.converterproject.Domain.Type;

import java.util.ArrayList;

public class BasicOpActivity extends AppCompatActivity {
    RecyclerView v1;
    RecyclerView.Adapter basicopadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_op);
        v1=findViewById(R.id.view);
        ArrayList<Operations> list=new ArrayList<>();
        list.add(new Operations("Addition"));
        list.add(new Operations("Subtraction"));
        list.add(new Operations("Multiplication"));
        list.add(new Operations("Division"));
        list.add(new Operations("1's Complement"));
        list.add(new Operations("2's Complement"));
        basicopadapter=new BasicOpAdapter(list);
        v1.setAdapter(basicopadapter);
        v1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}