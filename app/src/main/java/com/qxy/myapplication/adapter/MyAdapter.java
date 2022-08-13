package com.qxy.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qxy.myapplication.MainActivity2;
import com.qxy.myapplication.R;
import com.qxy.myapplication.mvvm.Dianshiju;
import com.qxy.myapplication.mvvm.Movie;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    List<Movie> movieList;
    Context context;

    public MyAdapter(List<Movie> movieList ,Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item ,parent ,false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie dianshiju = movieList.get(position);
        holder.title.setText(dianshiju.getTitle());
        holder.actors.setText(dianshiju.getActors());
        Glide.with(context).load(dianshiju.getPoster()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView actors;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.actors = itemView.findViewById(R.id.tv_actors);
            this.imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
