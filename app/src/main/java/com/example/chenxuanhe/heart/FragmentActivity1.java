package com.example.chenxuanhe.heart;


import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GestureDetectorCompat;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.chenxuanhe.heart.Page.Page1;
import com.example.chenxuanhe.heart.Page.Page2;
import com.example.chenxuanhe.heart.Page.Page3;


/**
 * Created by chenxuanhe on 2016/10/28.
 */

public class FragmentActivity1  extends android.support.v4.app.Fragment implements View.OnClickListener{

    private FrameLayout frameLayout_content2;
    private Page1 fg4;
    private Page2 fg5;
    private Page3 fg6;
    private TextView tuijian;
    private TextView zuixin;
    private TextView guanzhu;
    private FragmentManager fragManager;

    private ImageView line;
    private int currIndex= 0 ;
    private int bmpWidth;
    private int pianyiliang = 0;
    private int one = 0 ;
    private int two = 0;

    /**
     * 定义手势检测实例
     */
    private GestureDetectorCompat detector;
    /**
     * 做标签，记录当前是哪个fragment
     */
    private int Mark = 0;
    /**
     * 定义手势两点之间的最小距离
     */
    private int xDistance = 0;
    private int Distance = 50;

    public static FragmentActivity1[] fragments;

    public FragmentActivity1(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fg_content_one,container,false);
        detector = new GestureDetectorCompat(this.getActivity(),new MyGuetureListener());
        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view,MotionEvent event){
                return detector.onTouchEvent(event);
            }

        });

        fragManager = getChildFragmentManager();

        frameLayout_content2 = (FrameLayout) view.findViewById(R.id.frag_of_all2);
        tuijian = (TextView) view.findViewById(R.id.tuijian);
        zuixin = (TextView) view.findViewById(R.id.zuixin);
        guanzhu = (TextView) view.findViewById(R.id.guanzhu);
        line = (ImageView) view.findViewById(R.id.down_Line);

        tuijian.setOnClickListener(this);
        zuixin.setOnClickListener(this);
        guanzhu.setOnClickListener(this);

        initfrag();

        tuijian.performClick();

        return view;
    }


    /**
     * 重写滑动Listener，onDown是入口，必须写true
     */
    private class MyGuetureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onDown(MotionEvent event){
            return  true;
        }

        /**
         * 设置滑动时间，每个Mark值响应执行
         * @param event1
         * @param event2
         * @param velocityX
         * @param velocityY
         * @return
         */
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            if(Mark == 0){
                if(event1.getX() - event2.getX() > Distance && Math.abs(velocityX) > xDistance ){
                    fragManager.beginTransaction().hide(fg4).hide(fg5).hide(fg6).show(fg5).commit();
                    Mark =1;
                }else {
                    return false;
                }
            }

            else  if(Mark ==1){
                if(event1.getX() - event2.getX() > Distance && Math.abs(velocityX) > xDistance){
                    fragManager.beginTransaction().hide(fg4).hide(fg5).hide(fg6).show(fg6).commit();
                    Mark =2;
                }else if( event2.getX() - event1.getX() >Distance && Math.abs(velocityX) > xDistance) {
                    fragManager.beginTransaction().hide(fg4).hide(fg5).hide(fg6).show(fg4).commit();
                    Mark = 0;
                }
            }

            else if(Mark ==2){
                if(event2.getX() - event1.getX() > Distance && Math.abs(velocityX) > xDistance ){
                    fragManager.beginTransaction().hide(fg4).hide(fg5).hide(fg6).show(fg5).commit();
                    Mark = 1;
                }else {
                    return true;
                }
            }

            return true;
        }

    }



    public void setLine(){
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
    }


    /**
     * 隐藏所有的fragment
     * @param fragmentTransaction
     */
    private void hidefrag(android.support.v4.app.FragmentTransaction fragmentTransaction){

        if(fg4!=null)fragmentTransaction.hide(fg4);
        if(fg5!=null)fragmentTransaction.hide(fg5);
        if(fg6!=null)fragmentTransaction.hide(fg6);
    }

    /**
     * 初始化全部未选中状态
     */
    private void fgselect(){
        tuijian.setSelected(false);
        guanzhu.setSelected(false);
        zuixin.setSelected(false);
    }

    /**
     * 三个全部点一遍获取frag方便滑动，有待改进
     */
    private void initfrag() {

        tuijian.performClick();
        zuixin.performClick();
        guanzhu.performClick();
    }


    public void onClick(View view){
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        hidefrag(fragmentTransaction);
        switch (view.getId()){
            case R.id.tuijian:
                fgselect();
                tuijian.setSelected(true);
                if(fg4==null){
                    fg4 = new Page1();
                    fragmentTransaction.add(R.id.frag_of_all2,fg4);
                }else {
                    fragmentTransaction.show(fg4);
                }
              //  Mark =0;
                break;
            case R.id.zuixin:
                fgselect();
                zuixin.setSelected(true);
                if(fg5==null){
                    fg5 = new Page2();
                    fragmentTransaction.add(R.id.frag_of_all2,fg5);
            }else {
                    fragmentTransaction.show(fg5);
                }
            //    Mark =1;
                break;
            case R.id.guanzhu:
                fgselect();
                guanzhu.setSelected(true);
                if(fg6==null){
                    fg6 = new Page3();
                    fragmentTransaction.add(R.id.frag_of_all2,fg6);
                }else {
                    fragmentTransaction.show(fg6);
                }
             //   Mark =2;
                break;
        }fragmentTransaction.commit();
    }

}
