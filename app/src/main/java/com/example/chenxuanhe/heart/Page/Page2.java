package com.example.chenxuanhe.heart.Page;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenxuanhe.heart.R;

/**
 * Created by chenxuanhe on 2016/11/4.
 */

public class Page2 extends android.support.v4.app.Fragment {
    private String content;

    private Fragment fg5;

    public Page2(){}

    public Page2(Fragment fg){
        this.fg5=fg;
    }

    public Page2(String content) {
        this.content=content;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_zuixin,container,false);
        return view;
    }
}
