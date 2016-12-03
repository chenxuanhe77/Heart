package com.example.chenxuanhe.heart.Method;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.chenxuanhe.heart.R;

/**
 * Created by ChenXuanHe on 2016/12/3.
 */

public class AttentionMethod extends Activity {

    public ImageView attention;
    public ImageView goodjib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view);
        init();
        attentionclick();
    }


    public void init(){
        attention = (ImageView) findViewById(R.id.card_attention);
        goodjib = (ImageView) findViewById(R.id.card_goodjob);
    }

    public void attentionclick(){
        attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttentionMethod.this, "ddddddd", Toast.LENGTH_SHORT).show();
            }
        });
    }

}