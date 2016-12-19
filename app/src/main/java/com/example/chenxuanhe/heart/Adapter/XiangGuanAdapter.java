package com.example.chenxuanhe.heart.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenxuanhe.heart.R;
import com.example.chenxuanhe.heart.Util.XiangGuanUtil;

import java.util.List;

/**
 * Created by ChenXuanHe on 2016/12/19.
 */

public class XiangGuanAdapter extends RecyclerView.Adapter<XiangGuanAdapter.XGHolder> {

    private Context context;
    private List<XiangGuanUtil> xiangGuanUtils;
    public Boolean flag = true;

    public XiangGuanAdapter(Context context, List<XiangGuanUtil> xiangUtils) {
        this.context = context;
        this.xiangGuanUtils = xiangUtils;
    }

    @Override
    public XGHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xiangguan, parent, false);
        return new XGHolder(view);
    }

    @Override
    public void onBindViewHolder(final XiangGuanAdapter.XGHolder holder, int position) {

        XiangGuanUtil xiangGuanUtil = xiangGuanUtils.get(position);
        // xiangGuanUtils.add(xiangGuanUtil);
        holder.xiangguan_message.setText(xiangGuanUtil.getXiangguan_message());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                    flag=false;
                    holder.xiangguan_message.setEllipsize(null);
                    holder.xiangguan_message.setSingleLine(flag);
                }else {
                    flag = true;
                    holder.xiangguan_message.setEllipsize(TextUtils.TruncateAt.END);
                    holder.xiangguan_message.setSingleLine(flag);
                    holder.xiangguan_message.setLines(2);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return xiangGuanUtils == null ? 0 : xiangGuanUtils.size();
    }


    public class XGHolder extends RecyclerView.ViewHolder {

        public TextView xiangguan_message;
        public CardView cardView;

        public XGHolder(View v) {
            super(v);
            xiangguan_message = (TextView) v.findViewById(R.id.xiangguan_message);
            cardView = (CardView) v.findViewById(R.id.xiangguan_card_view);
        }
    }
}
