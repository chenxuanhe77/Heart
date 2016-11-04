package com.example.chenxuanhe.heart.Page;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenxuanhe.heart.R;


/**
 * Created by chenxuanhe on 2016/11/3.
 */

public class Page1 extends android.support.v4.app.Fragment {


    private TextView tv;
    private String content;
    private FragmentActivity fg4;

    public Page1(){}

    public Page1(FragmentActivity fragment){
        this.fg4=fragment;
    }

    public Page1(String content) {
        this.content=content;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_tuijian,container,false);
        return view;
    }


}
