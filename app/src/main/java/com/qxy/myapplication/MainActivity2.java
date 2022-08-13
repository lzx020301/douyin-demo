package com.qxy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.qxy.myapplication.adapter.MyAdapter;
import com.qxy.myapplication.mvvm.Dianshiju;
import com.qxy.myapplication.mvvm.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent it2 = getIntent();
        Bundle bd = it2.getExtras();

        //Dianshiju
        //Zongyi
        List<Movie> movieList = new ArrayList<>();
        for(int i=0;i<10;i++){
            Movie movie = new Movie(bd.getString("title" + i), bd.getString("actors" + i) , bd.getString("poster" + i));
            movieList.add(movie);
        }

        MyAdapter myAdapter = new MyAdapter(movieList ,MainActivity2.this);

        recyclerView.setAdapter(myAdapter);

    }
}