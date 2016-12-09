package com.example.chenxuanhe.heart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ChenXuanHe on 2016/12/7.
 */

public class CardViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView center_title;
    private String message;
    private TextView card_msg;
    private ImageView card_attention;
    private ImageView card_goodjob;
    private TextView card_goodjob_number;
    private EditText edit_card;
    private CardView card_reply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        init();
        setTitle();
    }

    public void init() {
        card_msg = (TextView) findViewById(R.id.at_card_msg);
        card_attention = (ImageView) findViewById(R.id.at_card_attention);
        card_goodjob = (ImageView) findViewById(R.id.at_card_goodjob);
        card_goodjob_number = (TextView) findViewById(R.id.at_goodjob_number);
        edit_card = (EditText) findViewById(R.id.at_card_edit);
        edit_card.setVisibility(View.GONE);
        card_reply = (CardView) findViewById(R.id.at_card_reply);

        Intent intent = getIntent();
        message = intent.getStringExtra("msg");

        card_msg.setText(message);

        card_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card_attention.setImageResource(R.drawable.attention);
                Toast.makeText(CardViewActivity.this, "这里无法取消关注呦，请在关注中取消~", Toast.LENGTH_SHORT).show();
            }
        });
        card_goodjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card_goodjob_number.setText("" + 1);
            }
        });

        card_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_card.setVisibility(View.VISIBLE);
                edit_card.setFocusable(true);
                edit_card.setFocusableInTouchMode(true);
                edit_card.requestFocus();
                edit_card.requestFocusFromTouch();//对应的View支持Focus，不支持在Touch模式下的Focus中也行获取焦点
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(edit_card, 0);
            }
        });

        edit_card.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Toast.makeText(CardViewActivity.this, "ddddddddd", Toast.LENGTH_SHORT).show();
                if(edit_card.hasFocus()){
                    return  ;
                }else {
                    Toast.makeText(CardViewActivity.this, "ddddddddd", Toast.LENGTH_SHORT).show();
                    edit_card.setVisibility(View.INVISIBLE);
                    edit_card.setFocusable(false);
                    edit_card.setFocusableInTouchMode(false);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        });

    }





    public void setTitle() {
        toolbar = (Toolbar) findViewById(R.id.Tool_bar_my_dengji);
        center_title = (TextView) findViewById(R.id.centertitle_dengji);
        toolbar.setNavigationIcon(R.drawable.backoff);
        setSupportActionBar(toolbar);
        setTitle("");
        center_title.setText("心中");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardViewActivity.this.finish();
            }
        });
    }

}
