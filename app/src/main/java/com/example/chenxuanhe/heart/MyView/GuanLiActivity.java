package com.example.chenxuanhe.heart.MyView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.chenxuanhe.heart.R;

/**
 * Created by chenxuanhe on 2016/11/2.
 */

public class GuanLiActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView center_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_guanli);
        setTitle();
    }

    public void setTitle(){
        toolbar = (Toolbar) findViewById(R.id.Tool_bar_my_guanli);
        center_title = (TextView) findViewById(R.id.centertitle_guanli);
        setSupportActionBar(toolbar);
        setTitle("");
        center_title.setText("账号管理");
    }
}
