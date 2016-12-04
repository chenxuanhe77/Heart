package com.example.chenxuanhe.heart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.chenxuanhe.heart.MyView.DengJiActivity;
import com.example.chenxuanhe.heart.MyView.GuanLiActivity;
import com.example.chenxuanhe.heart.MyView.SettingActivity;
import com.example.chenxuanhe.heart.MyView.SiXinActivity;
import com.example.chenxuanhe.heart.MyView.XiangGuanActivity;

/**
 * Created by chenxuanhe on 2016/10/28.
 */

public class FragmentActivity3 extends android.support.v4.app.Fragment implements View.OnClickListener{



    private TableRow guanli;
    private TableRow xiangguan;
    private TableRow sixin;
    private TableRow dengji;
    private TableRow setting;


    public FragmentActivity3(){}


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fg_content_three,container,false);

        //绑定，设置点击事件监控
        guanli = (TableRow) view.findViewById(R.id.my_guanli);
        xiangguan = (TableRow) view.findViewById(R.id.my_xiangguan);
        sixin = (TableRow) view.findViewById(R.id.my_sixin);
        dengji = (TableRow) view.findViewById(R.id.my_dengji);
        setting = (TableRow) view.findViewById(R.id.my_setting);
        guanli.setOnClickListener(this);
        xiangguan.setOnClickListener(this);
        sixin.setOnClickListener(this);
        dengji.setOnClickListener(this);
        setting.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.my_guanli:
                doIntent(GuanLiActivity.class);
                Toast.makeText(getActivity(), "sssssssssssssssss", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_xiangguan:
                doIntent(XiangGuanActivity.class);
                Toast.makeText(getActivity(), "aaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_sixin:
                doIntent(SiXinActivity.class);
                break;
            case R.id.my_dengji:
                doIntent(DengJiActivity.class);
                break;
            case R.id.my_setting:
                doIntent(SettingActivity.class);
                break;
        }
    }

    /**
     * 写的跳转，简化代码
     * @param activity
     */
    public void doIntent(Class activity){
        Intent intent = new Intent();
        intent.setClass(getActivity(),activity);
        startActivity(intent);
    }


}
