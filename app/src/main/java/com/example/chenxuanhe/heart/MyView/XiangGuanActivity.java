package com.example.chenxuanhe.heart.MyView;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.chenxuanhe.heart.Adapter.XiangGuanAdapter;
import com.example.chenxuanhe.heart.R;
import com.example.chenxuanhe.heart.Util.XiangGuanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxuanhe on 2016/11/2.
 */

public class XiangGuanActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView center_title;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<XiangGuanUtil> xiangGuanList = new ArrayList<>();
    private XiangGuanAdapter xiangGuanAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_xiangguan);
        setTitle();

        init();

        xiangGuanList.add(new XiangGuanUtil("aaaaaaaddjhuuhoooooooooooooooooooooooooooooooooooooooo1111111111111111111111115415444"));

    }

    public void init(){
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.my_xiangguan_swip);
        recyclerView = (RecyclerView) findViewById(R.id.my_xiangguan_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        xiangGuanAdapter = new XiangGuanAdapter(this,xiangGuanList);
        recyclerView.setAdapter(xiangGuanAdapter);



        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(

        ) {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void setTitle(){
        toolbar = (Toolbar) findViewById(R.id.Tool_bar_my_xiangguan);
        center_title = (TextView) findViewById(R.id.centertitle_xiangguan);
        toolbar.setNavigationIcon(R.drawable.backoff);
        setSupportActionBar(toolbar);
        setTitle("");
        center_title.setText("与我相关");

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                XiangGuanActivity.this.finish();
            }
        });
    }


}
