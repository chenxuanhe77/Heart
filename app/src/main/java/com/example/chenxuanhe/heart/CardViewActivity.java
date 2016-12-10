package com.example.chenxuanhe.heart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
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
    private PopupWindow mpopupWindow;
    private CardView card_commit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        init();
        setTitle();
    }

    private void showPopupWindow(){
        View content = LayoutInflater.from(CardViewActivity.this).inflate(R.layout.popuplayout,null);

        card_commit = (CardView) content.findViewById(R.id.at_card_commit);
        edit_card = (EditText) content.findViewById(R.id.at_card_edit);

        edit_card.setImeOptions(EditorInfo.IME_ACTION_SEND);
        edit_card.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_SEND){
                    Toast.makeText(CardViewActivity.this, "ddddddddd", Toast.LENGTH_SHORT).show();
                    card_commit.performClick();
                }
                return false;
            }
        });


        mpopupWindow = new PopupWindow(content, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,true);//content是子布局，pppwindow的布局
        mpopupWindow.setContentView(content);
        View mainview = LayoutInflater.from(CardViewActivity.this).inflate(R.layout.activity_card_view,null);
        //mainview才是cardview的主布局，在这个上面显示pppwindow
        mpopupWindow.setAnimationStyle(R.style.reply_menu_enter_exit);
        content.clearAnimation();

        //防止PopupWindow被软件盘挡住
        mpopupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        mpopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        mpopupWindow.showAtLocation(mainview, Gravity.CENTER_VERTICAL,0,0);


        card_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CardViewActivity.this, "daadadadad", Toast.LENGTH_SHORT).show();
            }
        });
        edit_card.setVisibility(View.VISIBLE);
        edit_card.setFocusable(true);
        edit_card.setFocusableInTouchMode(true);
        edit_card.requestFocus();
        edit_card.requestFocusFromTouch();//对应的View支持Focus，不支持在Touch模式下的Focus中也行获取焦点
        //三句一起，在这才能显示软键盘，一般1.2局就能显示
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInputFromInputMethod(edit_card.getWindowToken(), 0);
        imm.toggleSoftInput(100, InputMethodManager.HIDE_NOT_ALWAYS);//切换软键盘的显示与隐藏

    }

    /**
     * 初始化绑定card activity的控件，设置点赞，关注，回复事件
     */
    public void init() {
        card_msg = (TextView) findViewById(R.id.at_card_msg);
        card_attention = (ImageView) findViewById(R.id.at_card_attention);
        card_goodjob = (ImageView) findViewById(R.id.at_card_goodjob);
        card_goodjob_number = (TextView) findViewById(R.id.at_goodjob_number);
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
                showPopupWindow();
            }
        });

     /*   edit_card.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        });*/

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
