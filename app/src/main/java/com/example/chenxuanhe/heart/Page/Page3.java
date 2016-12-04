package com.example.chenxuanhe.heart.Page;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
 * Created by chenxuanhe on 2016/11/4.
 */

public class Page3 extends android.support.v4.app.Fragment {

    private SwipeRefreshLayout mswiperefresh3;
    private RecyclerView recyclerView;
    private List<Gongju> gongjus = new ArrayList<>();
    private Adapter1 adapter1;


    public Page3(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_guanzhu,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_guanzhu);
        mswiperefresh3 = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout3);

        gongjus.add(new Gongju("111111"));
        gongjus.add(new Gongju("!331311313"));
        gongjus.add(new Gongju("!331311313"));
        gongjus.add(new Gongju("!331311313"));
        gongjus.add(new Gongju("!331311313"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter1 = new Adapter1(getContext(),gongjus);
        recyclerView.setAdapter(adapter1);



        //使加载dialog消失
        mswiperefresh3.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                mswiperefresh3.setRefreshing(false);
            }
        });


        return view;
    }
}
