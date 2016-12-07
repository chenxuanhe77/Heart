package com.example.chenxuanhe.heart.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chenxuanhe on 2016/10/26.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> fg;

    public MyPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments){
        super(fm);
        this.fg = fragments;
    }


    @Override
    public int getCount() {
        return fg.size();
    }


    @Override
    public Fragment getItem(int position) {
        return fg.get(position);
    }




}
