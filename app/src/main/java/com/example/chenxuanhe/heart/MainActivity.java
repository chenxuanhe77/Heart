package com.example.chenxuanhe.heart;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*fragment所需控件*/
    private TextView txt_lingting1;
    private TextView txt_chat1;
    private TextView txt_my1;
    private FrameLayout frameLayout_content1;
    private FragmentActivity1 fg1;
    private FragmentActivity2 fg2;
    private FragmentActivity3 fg3;



    //toolbar和居中的title
    public Toolbar toolbar;
    private TextView center_title;

    private android.support.v4.app.FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getSupportFragmentManager();
        bindView();
        txt_lingting1.performClick();

    }


    /**
     * 初始绑定，设置监听
     */
    private void bindView(){
        txt_lingting1 = (TextView) findViewById(R.id.txt_lingting1);
        txt_chat1 = (TextView) findViewById(R.id.txt_chat1);
        txt_my1 = (TextView) findViewById(R.id.txt_my1);
        frameLayout_content1 = (FrameLayout) findViewById(R.id.frag_of_all1);

        txt_lingting1.setOnClickListener(this);
        txt_chat1.setOnClickListener(this);
        txt_my1.setOnClickListener(this);
    }


    /**
     * 隐藏其他frag
     * @param fgTransaction
     */
    private void hideFragment(FragmentTransaction fgTransaction){
        if(fg1!=null)fgTransaction.hide(fg1);
        if(fg2!=null)fgTransaction.hide(fg2);
        if(fg3!=null)fgTransaction.hide(fg3);
    }

    /**
     * 初始化fragent都没有被点击
     */
    private void setSelect(){
        txt_lingting1.setSelected(false);
        txt_chat1.setSelected(false);
        txt_my1.setSelected(false);
    }

    /**
     * 点击相应的frag
     * @param view
     */
    public void onClick(View view){
        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (view.getId()){
            case R.id.txt_lingting1:
                toolbar = (Toolbar) findViewById(R.id.Tool_bar1);
                center_title = (TextView) findViewById(R.id.centertitle);
                setSupportActionBar(toolbar);
                setTitle("");
                center_title.setText("心中");

                setSelect();
                txt_lingting1.setSelected(true);
                if(fg1==null){
                    fg1 = new FragmentActivity1();
                    fragmentTransaction.add(R.id.frag_of_all1,fg1);
                }else{
                    fragmentTransaction.show(fg1);
                }
                break;
            case R.id.txt_chat1:
                toolbar = (Toolbar) findViewById(R.id.Tool_bar1);
                center_title = (TextView) findViewById(R.id.centertitle);
                setSupportActionBar(toolbar);
                setTitle("");
                center_title.setText("聊天");

                setSelect();
                txt_chat1.setSelected(true);
                if(fg2==null){
                    fg2 = new FragmentActivity2();
                    fragmentTransaction.add(R.id.frag_of_all1,fg2);

                }else{
                    fragmentTransaction.show(fg2);
                }
                break;
            case R.id.txt_my1:
                toolbar = (Toolbar) findViewById(R.id.Tool_bar1);
                center_title = (TextView) findViewById(R.id.centertitle);
                setSupportActionBar(toolbar);
                setTitle("");
                center_title.setText("我");

                setSelect();
                txt_my1.setSelected(true);
                if(fg3==null){
                    fg3 = new FragmentActivity3();
                    fragmentTransaction.add(R.id.frag_of_all1,fg3);
                }else{
                    fragmentTransaction.show(fg3);
                }
                break;
        }fragmentTransaction.commit();
    }


}
