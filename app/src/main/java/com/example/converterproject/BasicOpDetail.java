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
import android.widget.EditText;
import android.widget.TextView;

import com.example.converterproject.NumberSystem.BasicOperations;

public class BasicOpDetail extends AppCompatActivity {
    String op;
    TextView t1,opvalue;
    ConstraintLayout ok;
    String item1;
    AutoCompleteTextView autoCompleteTextView;
    String[] item={"Decimal","Binary","Octal","Hexadecimal","Others"};
    ArrayAdapter<String> adapteritems;
    EditText editText1,editText2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_op_detail);
        autoCompleteTextView=findViewById(R.id.auto_complete_text);
        adapteritems=new ArrayAdapter<String>(this,R.layout.list,item);
        autoCompleteTextView.setAdapter(adapteritems);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item1=adapterView.getItemAtPosition(i).toString();
            }
        });

        BasicOperations bo = new BasicOperations();

        Intent intent=getIntent();
        op=intent.getStringExtra("Op");
        t1=findViewById(R.id.result);
        opvalue=findViewById(R.id.opvalue);
        ok=findViewById(R.id.ok3);
//        if(item1!=null) t1.setText("Result after "+op+" "+":");
        opvalue.setText("");
        ok.setOnClickListener((view -> {

            t1.setVisibility(View.VISIBLE);
            int base;
            if(item1!=null) {
                if (!item1.equalsIgnoreCase("Others")) base = bo.baseMap.get(item1);
                else base = 10;

                String num1 = editText1.getText().toString();
                String num2 = editText2.getText().toString();
                if (op.equalsIgnoreCase("Addition")) {
                    t1.setText("Result after "+op+" "+":");
                    opvalue.setText(bo.Addition(num1, num2, base));
                } else if (op.equalsIgnoreCase("Subtraction")) {
                    t1.setText("Result after "+op+" "+":");
                    opvalue.setText(bo.Subtraction(num1, num2, base));
                }
                else if (op.equalsIgnoreCase("Multiplication")) {
                    t1.setText("Result after "+op+" "+":");
                    opvalue.setText(bo.Multiplication(num1, num2, base));
                }
            }

            opvalue.setVisibility(View.VISIBLE);

        }));


    }
}