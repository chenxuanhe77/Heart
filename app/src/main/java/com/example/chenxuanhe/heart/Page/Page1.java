package com.example.chenxuanhe.heart.Page;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.chenxuanhe.heart.R;

/**
 * Created by chenxuanhe on 2016/11/3.
 */

public class Page1 extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tuijian);

        tv = (TextView) findViewById(R.id.tv);
        tv.append("xdddddddddddddd");

    }
}
