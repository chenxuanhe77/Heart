package com.example.chenxuanhe.heart.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenxuanhe.heart.R;
import com.example.chenxuanhe.heart.Util.Gongju;

import java.util.List;

/**
 * Created by ChenXuanHe on 2016/11/26.
 */

public class Adapter1 extends RecyclerView.Adapter<Adapter1.MyViewHolder> {

    private List<Gongju> message;

    private Context mContext;


    public Adapter1(Context context, List<Gongju> datas){
        this.mContext = context;
        this.message=datas;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.card_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Gongju p = message.get(position);
        holder.msg.setText(p.txtmessage);

    }

    @Override
    public int getItemCount() {
        return message == null? 0 : message.size();
    }

    /**
     * 重写自定义的viewholder
     */
    public  class  MyViewHolder extends RecyclerView.ViewHolder{

        public TextView msg;

        public MyViewHolder(View v) {
            super(v);
            msg=(TextView) v.findViewById(R.id.txt_cardmessage);
        }

    }
}
