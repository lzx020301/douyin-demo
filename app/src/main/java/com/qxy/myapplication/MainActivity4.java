package com.qxy.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qxy.myapplication.adapter.MyAdapter;
import com.qxy.myapplication.adapter.MyAdapter3;
import com.qxy.myapplication.mvvm.Movie;
import com.qxy.myapplication.mvvm.Zongyi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent it2 = getIntent();
        Bundle bd = it2.getExtras();

        //Dianshiju
        //Zongyi
        List<Zongyi> zongyisList = new ArrayList<>();
        for(int i=0;i<10;i++){
            Zongyi zongyi = new Zongyi(bd.getString("title" + i), bd.getString("actors" + i) , bd.getString("poster" + i));
            zongyisList.add(zongyi);
        }

        MyAdapter3 myAdapter3 = new MyAdapter3(zongyisList , MainActivity4.this);

        recyclerView.setAdapter(myAdapter3);

    }
}