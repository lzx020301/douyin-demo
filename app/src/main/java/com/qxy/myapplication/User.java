package com.qxy.myapplication;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable {
    private String name;
    public User(String name){
        this.name = name;
    }
    public User(){

    }

    @Bindable
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
