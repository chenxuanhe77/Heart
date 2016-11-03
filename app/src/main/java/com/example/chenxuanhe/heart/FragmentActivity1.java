package com.example.chenxuanhe.heart;

import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by chenxuanhe on 2016/10/28.
 */

public class FragmentActivity1  extends Fragment implements View.OnClickListener
        ,ViewPager.OnPageChangeListener{

    //viewpage需要的控件
    private ViewPager viewPager;
    private TextView tuijian;
    private TextView zuixin;
    private TextView guanzhu;
    private ImageView line;
    private ArrayList<View> listViews;
    //计算偏移量，滑动line所需
    private int currIndex= 0 ;
    private int bmpWidth;
    private int pianyiliang = 0;
    private int one = 0 ;
    private int two = 0;

    private TextView tv;

    private ArrayList<View> viewList;

    View view1,view2,view3;


    private String content;

    public FragmentActivity1(){}

    /*public FragmentActivity1(String content) {
        this.content=content;
    }*/

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fg_content_one,container,false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpage);
        line = (ImageView) view.findViewById(R.id.down_Line);
        tuijian = (TextView) view.findViewById(R.id.tuijian);
        zuixin = (TextView) view.findViewById(R.id.zuixin);
        guanzhu = (TextView) view.findViewById(R.id.guanzhu);

        initView();
        return view;
    }


    /**
     * 绑定，计算偏移量滑动
     */
    private void initView(){

        bmpWidth = BitmapFactory.decodeResource(getResources(),R.drawable.line).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        pianyiliang = (screenWidth / 3 - bmpWidth) / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(0,0);
        line.setImageMatrix(matrix);
        one = pianyiliang * 2 + bmpWidth;
        two = one * 2;

        listViews = new ArrayList<View>();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        listViews.add(inflater.inflate(R.layout.view_tuijian,null,false));
        listViews.add(inflater.inflate(R.layout.view_zuixin,null,false));
        listViews.add(inflater.inflate(R.layout.view_guanzhu,null,false));
        viewPager.setAdapter(new MyPagerAdapter(listViews));
        viewPager.setCurrentItem(0);


        tuijian.setOnClickListener(this);
        zuixin.setOnClickListener(this);
        guanzhu.setOnClickListener(this);

        viewPager.addOnPageChangeListener(this);

    }

    /**
     * 点击之后给值，计算滑动前一步
     * @param v
     */
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tuijian:
                viewPager.setCurrentItem(0);
                break;
            case R.id.zuixin:
                viewPager.setCurrentItem(1);
                break;
            case R.id.guanzhu:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    /**
     * 重写viewpage方法，实现滑动
     * @param index
     */
    @Override
    public void onPageSelected(int index){
        Animation animation = null;
        switch (index){
            case 0:
                if(currIndex ==1){
                    animation = new TranslateAnimation(one,0,0,0);
                }else if(currIndex == 2){
                    for(int m = 0;m <=1;m++) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                    }
                }
                break;
            case 1:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(pianyiliang, one, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(two, one, 0, 0);
                }
                break;
            case 2:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(pianyiliang, two, 0, 0);
                } else if (currIndex == 1) {
                    animation = new TranslateAnimation(one, two, 0, 0);
                }
                break;
        }
        currIndex = index;
        animation.setFillAfter(true);
        animation.setDuration(300);
        line.startAnimation(animation);

    }

    @Override
    public void onPageScrollStateChanged(int i){

    }

    @Override
    public void onPageScrolled(int i,float v,int m){

    }
}
