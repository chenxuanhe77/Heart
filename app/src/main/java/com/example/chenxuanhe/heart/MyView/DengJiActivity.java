package com.example.chenxuanhe.heart.MyView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.chenxuanhe.heart.R;

/**
 * Created by chenxuanhe on 2016/11/2.
 */

public class DengJiActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView center_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dengji);
        setTitle();
    }

    public void setTitle(){
        toolbar = (Toolbar) findViewById(R.id.Tool_bar_my_dengji);
        center_title = (TextView) findViewById(R.id.centertitle_dengji);
        toolbar.setNavigationIcon(R.drawable.backoff);
        setSupportActionBar(toolbar);
        setTitle("");
        center_title.setText("我的等级");

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DengJiActivity.this.finish();
            }
        });
    }


}
