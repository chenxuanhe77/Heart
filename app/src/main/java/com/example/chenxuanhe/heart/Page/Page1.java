package com.example.chenxuanhe.heart.Page;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenxuanhe.heart.Adapter.Adapter1;
import com.example.chenxuanhe.heart.R;
import com.example.chenxuanhe.heart.Util.Gongju;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chenxuanhe on 2016/11/3.
 */

public class Page1 extends android.support.v4.app.Fragment {


    private RecyclerView recyclerView;
    private Adapter1 myAdapter;
    private List<Gongju> gongjus = new ArrayList<>();

    public Page1(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_tuijian,container,false);

        gongjus.add(new Gongju("111111"));
        gongjus.add(new Gongju("!331311313"));
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_tuijian); //拿到recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);
        myAdapter = new Adapter1(getContext(),gongjus);
        recyclerView.setAdapter(myAdapter);


        return view;
    }




}
