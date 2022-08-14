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
import com.qxy.myapplication.R;
import com.qxy.myapplication.mvvm.Zongyi;

import java.util.List;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder>{
    List<Zongyi> zongyiList;
    Context context;

    public MyAdapter3(List<Zongyi> zongyiList ,Context context) {
        this.zongyiList = zongyiList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item ,parent ,false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Zongyi zongyi = zongyiList.get(position);
        holder.title.setText(zongyi.getTitle());
        holder.actors.setText(zongyi.getActors());
        Glide.with(context).load(zongyi.getPoster()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return zongyiList.size();
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
