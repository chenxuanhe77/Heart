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

public class Page3 extends android.support.v4.app.Fragment {

    private String content;
    private Fragment fg6;

    public Page3(){}

    public Page3(Fragment fg){
        this.fg6=fg;
    }

    public Page3(String content) {
        this.content=content;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_guanzhu,container,false);
        return view;
    }
}
