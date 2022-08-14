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
import com.qxy.myapplication.mvvm.Dianshiju;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder>{
    List<Dianshiju> dianshijuList;
    Context context;

    public MyAdapter2(List<Dianshiju> dianshijuList ,Context context) {
        this.dianshijuList = dianshijuList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item ,parent ,false);
        MyAdapter2.MyViewHolder myViewHolder = new MyAdapter2.MyViewHolder(itemView);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder, int position) {
        Dianshiju dianshiju = dianshijuList.get(position);
        holder.title.setText(dianshiju.getTitle());
        holder.actors.setText(dianshiju.getActors());
        Glide.with(context).load(dianshiju.getPoster()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dianshijuList.size();
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
