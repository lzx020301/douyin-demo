package com.qxy.myapplication.mvvm;

import androidx.databinding.Bindable;

import com.qxy.myapplication.BR;

public class Dianshiju {
    private String title;
    private String actors;
    private String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Dianshiju(String title, String actors,String poster) {
        this.title = title;
        this.actors = actors;
        this.poster = poster;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
