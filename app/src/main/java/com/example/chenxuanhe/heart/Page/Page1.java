package com.example.chenxuanhe.heart.Page;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenxuanhe.heart.Adapter.RecyclerViewAdapter;
import com.example.chenxuanhe.heart.R;
import com.example.chenxuanhe.heart.Util.Gongju;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chenxuanhe on 2016/11/3.
 */

public class Page1 extends android.support.v4.app.Fragment {


    private RecyclerView recyclerView;
    private RecyclerViewAdapter myAdapter;
    private List<Gongju> gongjus = new ArrayList<>();

    private SwipeRefreshLayout mswiperefresh1;

    public Page1(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_tuijian,container,false);

        for (int i =0;i<100;i++) {
            gongjus.add(new Gongju("11111111"));
            gongjus.add(new Gongju("6b6b6b6b6b6b6"));
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_tuijian); //拿到recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);
        myAdapter = new RecyclerViewAdapter(getContext(),gongjus);
        recyclerView.setAdapter(myAdapter);
        mswiperefresh1 = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout1);


        //使加载dialog消失
        mswiperefresh1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                mswiperefresh1.setRefreshing(false);
            }
        });

        return view;
    }
}

