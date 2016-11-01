package com.example.chenxuanhe.heart;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chenxuanhe on 2016/10/28.
 */

public class FragmentActivity3 extends Fragment implements View.OnClickListener{

    private String content;


    private TableRow guanli;
    private TableRow xiangguan;
    private TableRow sixin;
    private TableRow dengji;
    private TableRow setting;


    public FragmentActivity3(){}

    /*public FragmentActivity3(Fragment fg){
    }*/


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
                Toast.makeText(getActivity(), "sssssssssssssssss", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_xiangguan:
                Toast.makeText(getActivity(), "aaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_sixin:
                break;
            case R.id.my_dengji:
                break;
            case R.id.my_setting:
                break;
        }
    }


}
