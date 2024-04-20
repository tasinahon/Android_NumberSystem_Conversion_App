package com.example.converterproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.converterproject.BasicOpActivity;
import com.example.converterproject.BasicOpDetail;
import com.example.converterproject.ComplementActivity;
import com.example.converterproject.ConversionActivity;
import com.example.converterproject.Domain.Operations;
import com.example.converterproject.Domain.Type;
import com.example.converterproject.R;

import java.util.ArrayList;

public class BasicOpAdapter extends RecyclerView.Adapter<BasicOpAdapter.viewholder> {
    ArrayList<Operations>operationsArrayList;
    Context context;
    public BasicOpAdapter(ArrayList<Operations>operationsArrayLis)
    {
        this.operationsArrayList=operationsArrayLis;
    }
    @NonNull
    @Override
    public BasicOpAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.basicoprecycle,parent,false);
        return new BasicOpAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasicOpAdapter.viewholder holder, int position) {
        holder.t1.setText(operationsArrayList.get(position).getName());
        final Operations item = operationsArrayList.get(position);
        holder.itemView.setOnClickListener(v -> {

            if(item.getName().equals("Addition"))
            {
                Intent intent=new Intent(holder.itemView.getContext(), BasicOpDetail.class);
                intent.putExtra("Op","Addition");
                context.startActivity(intent);
            }
            else if(item.getName().equals("Subtraction"))
            {
                Intent intent=new Intent(holder.itemView.getContext(), BasicOpDetail.class);
                intent.putExtra("Op","Subtraction");
                context.startActivity(intent);
            }
            else if(item.getName().equals("Multiplication"))
            {
                Intent intent=new Intent(holder.itemView.getContext(), BasicOpDetail.class);
                intent.putExtra("Op","Multiplication");
                context.startActivity(intent);
            }

            else if(item.getName().equals("1's Complement"))
            {
                Intent intent=new Intent(holder.itemView.getContext(), ComplementActivity.class);
                intent.putExtra("Op","1's Complement");
                context.startActivity(intent);
            }
            else if(item.getName().equals("2's Complement"))
            {
                Intent intent=new Intent(holder.itemView.getContext(), ComplementActivity.class);
                intent.putExtra("Op","2's Complement");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return operationsArrayList.size();
    }
    public class viewholder extends RecyclerView.ViewHolder{


        TextView t1;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.opname);

        }
    }
}
