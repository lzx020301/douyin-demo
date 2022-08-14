package com.qxy.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qxy.myapplication.adapter.MyAdapter;
import com.qxy.myapplication.adapter.MyAdapter2;
import com.qxy.myapplication.mvvm.Dianshiju;
import com.qxy.myapplication.mvvm.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent it2 = getIntent();
        Bundle bd = it2.getExtras();

        //Dianshiju
        //Zongyi
        List<Dianshiju> dianshijusList = new ArrayList<>();
        for(int i=0;i<10;i++){
            Dianshiju dianshiju = new Dianshiju(bd.getString("title" + i), bd.getString("actors" + i) , bd.getString("poster" + i));
            dianshijusList.add(dianshiju);
        }

        MyAdapter2 myAdapter2 = new MyAdapter2(dianshijusList , MainActivity3.this);

        recyclerView.setAdapter(myAdapter2);

    }
}