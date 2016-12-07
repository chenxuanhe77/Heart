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
 * Created by chenxuanhe on 2016/11/4.
 */

public class Page2 extends android.support.v4.app.Fragment {

    private SwipeRefreshLayout mswiperefresh2;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Gongju> gongjus = new ArrayList<>();

    public Page2(){}


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_zuixin,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_zuixin);
        mswiperefresh2 = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout2);

        gongjus.add(new Gongju("222222222222"));
        gongjus.add(new Gongju("daaaaaaaaaaaaaaaaa"));
        gongjus.add(new Gongju("daaaaaaaaaaaaaaaaa"));
        gongjus.add(new Gongju("daaaaaaaaaaaaaaaaa"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(),gongjus);
        recyclerView.setAdapter(recyclerViewAdapter);

        //使加载dialog消失
        mswiperefresh2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                mswiperefresh2.setRefreshing(false);
            }
        });


        return view;
    }
}
