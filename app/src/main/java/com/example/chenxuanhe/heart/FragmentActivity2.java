package com.example.chenxuanhe.heart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenxuanhe on 2016/10/28.
 */

public class FragmentActivity2 extends android.support.v4.app.Fragment{


    public FragmentActivity2(){}


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fg_content_two,container,false);
        return view;
    }


}
