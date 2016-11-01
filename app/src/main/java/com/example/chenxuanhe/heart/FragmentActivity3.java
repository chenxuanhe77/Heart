package com.example.chenxuanhe.heart;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenxuanhe on 2016/10/28.
 */

public class FragmentActivity3 extends Fragment {

    private String content;

    public FragmentActivity3(){}

    public FragmentActivity3(Fragment fg){
    }

    public FragmentActivity3(String content) {
        this.content=content;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fg_content_three,container,false);
        return view;
    }
}
