package com.example.converterproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.converterproject.BasicOpActivity;
import com.example.converterproject.ConversionActivity;
import com.example.converterproject.Domain.Type;
import com.example.converterproject.R;

import java.util.ArrayList;

public class ConverterAdapter extends RecyclerView.Adapter<ConverterAdapter.viewholder> {
    ArrayList<Type>typelist;
    Context context;
    public ConverterAdapter(ArrayList<Type>typelist)
    {
        this.typelist=typelist;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detail,parent,false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
           holder.t1.setText(typelist.get(position).getName());
           holder.t2.setText(typelist.get(position).getDescription());
        final Type item = typelist.get(position);
        holder.itemView.setOnClickListener(v -> {

           if(item.getName().equals("Conversion"))
           {
               Intent intent=new Intent(holder.itemView.getContext(), ConversionActivity.class);
               context.startActivity(intent);
           }
           else if(item.getName().equals("Basic Operations"))
           {
               Intent intent=new Intent(holder.itemView.getContext(), BasicOpActivity.class);
               context.startActivity(intent);
           }
        });
    }

    @Override
    public int getItemCount() {
        return typelist.size();
    }
    public class viewholder extends RecyclerView.ViewHolder{
        TextView t1,t2;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
        }
    }
}
