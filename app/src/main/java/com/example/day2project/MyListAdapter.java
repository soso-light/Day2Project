package com.example.day2project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder>{
    ArrayList<String> data;
    Context context;

    MyListAdapter(Context context, ArrayList<String> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, null);
        return new MyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyListViewHolder holder, int position) {
        //데이타 세팅
        holder.tv.setText(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv;
        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv  = itemView.findViewById(R.id.tvTitle);
            tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            tv.setText("Clicked - " + tv.getText().toString());
        }
    }


}
