package com.example.day2project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();
    MyListAdapter adapter;
    RecyclerView recyclerView;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        init();
        et = findViewById(R.id.etTv);
    }

    private void init(){
        data.add("경이로운 소문");
        data.add("놀라운 토요일");
        data.add("무한 도전");

        adapter = new MyListAdapter(this, data);
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void onAdd(View view) {
        String newm = et.getText().toString();
        data.add(newm);
        adapter.notifyDataSetChanged();
    }
}