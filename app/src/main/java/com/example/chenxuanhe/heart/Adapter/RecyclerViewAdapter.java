package com.example.chenxuanhe.heart.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenxuanhe.heart.CardViewActivity;
import com.example.chenxuanhe.heart.R;
import com.example.chenxuanhe.heart.Util.Gongju;

import java.util.List;

/**
 * Created by ChenXuanHe on 2016/11/26.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Gongju> message;

    private Context mContext;

    private boolean flag;//点击关注判断


    public RecyclerViewAdapter(Context context, List<Gongju> datas) {
        this.mContext = context;
        this.message = datas;
    }


    /**
     * 创建视图
     *
     * @param parent
     * @param i
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(v);
    }



    /**
     * 绑定viewholder，操作事件全部写在这里
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder,int position) {
        position = holder.getAdapterPosition();

        Gongju p = message.get(position);
        holder.msg.setText(p.txtmessage);

        //点击关注，触发事件操作
        //利用flag 直接判断，不再需要累加奇偶计算
       /* holder.attention.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (flag) {
                    Toast.makeText(mContext, "取消关注~变心了~", Toast.LENGTH_SHORT).show();
                    holder.attention.setImageResource(R.drawable.disattention);
                    holder.attention.invalidate();
                    flag = false;
                } else {
                    Toast.makeText(mContext, "关注了呦！尽在关注中", Toast.LENGTH_SHORT).show();
                    holder.attention.setImageResource(R.drawable.attention);
                    holder.attention.invalidate();
                    flag = true;
                }
            }
        });*/

        //点击点赞，触发事件操作
        holder.goodjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点赞之后，数字增加
                Toast.makeText(mContext, "尽在与我相关中~", Toast.LENGTH_SHORT).show();
                holder.goodjob_number.setText("" + 1);
            }
        });

        //CardView点击事件，之后会显示内容等详细信息
        final int finalPosition = position;
        final String st= p.txtmessage;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mContext, CardViewActivity.class);
                intent.putExtra("msg",st);
                mContext.startActivity(intent);
                Toast.makeText(mContext, "这是第" + (finalPosition + 1) + "个cardviw,信息是" + st, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return message == null ? 0 : message.size();
    }


    /**
     * 重写自定义的viewholder
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView msg;
        public ImageView attention;
        public ImageView goodjob;
        public TextView goodjob_number;
        public CardView cardView;

        public MyViewHolder(View v) {
            super(v);
            msg = (TextView) v.findViewById(R.id.txt_cardmessage);
            attention = (ImageView) v.findViewById(R.id.card_attention);//关注image
            goodjob = (ImageView) v.findViewById(R.id.card_goodjob);    //点赞image
            goodjob_number = (TextView) v.findViewById(R.id.goodjob_number);//点赞数字text
            cardView = (CardView) v.findViewById(R.id.card_view);

            attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag){
                        Toast.makeText(mContext, "取消关注~变心了~", Toast.LENGTH_SHORT).show();
                        attention.setImageResource(R.drawable.disattention);
                        attention.invalidate();
                        flag = false;
                    }else {
                        Toast.makeText(mContext, "关注了呦！尽在关注中", Toast.LENGTH_SHORT).show();
                        attention.setImageResource(R.drawable.attention);
                        attention.invalidate();
                        flag = true;
                    }
                }
            });
        }

    }

}



