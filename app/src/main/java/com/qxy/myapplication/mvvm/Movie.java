package com.qxy.myapplication.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.qxy.myapplication.BR;

import java.util.List;

public class Movie extends BaseObservable {
    private String title;
    private String actors;
    private String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Movie(String title, String actors,String poster) {
        this.title = title;
        this.actors = actors;
        this.poster = poster;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
        notifyPropertyChanged(BR.actors);
    }
}
