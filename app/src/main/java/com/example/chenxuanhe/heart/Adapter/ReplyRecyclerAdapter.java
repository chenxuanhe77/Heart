package com.example.chenxuanhe.heart.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenxuanhe.heart.R;
import com.example.chenxuanhe.heart.Util.ReplyUtil;

import java.util.List;

/**
 * Created by ChenXuanHe on 2016/12/10.
 */

public class ReplyRecyclerAdapter extends RecyclerView.Adapter<ReplyRecyclerAdapter.ReplyViewHolder>{

    private Context context;
    private List<ReplyUtil> replyUtilsList;

    public ReplyRecyclerAdapter(Context context,List<ReplyUtil> replyUtils){
        this.context = context;
        this.replyUtilsList = replyUtils;
    }

    @Override
    public ReplyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_reply,parent,false);
        return new ReplyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReplyViewHolder holder, int position) {
        ReplyUtil replyUtil = replyUtilsList.get(position);
        holder.reply_message.setText(": "+replyUtil.getReplymessage());
    }

    @Override
    public int getItemCount() {
        return replyUtilsList == null ? 0 : replyUtilsList.size();
    }

    public void commmitcontent(ReplyUtil replyUtil){
        replyUtilsList.add(replyUtil);
        notifyDataSetChanged();
    }

    public class ReplyViewHolder extends RecyclerView.ViewHolder {

        public TextView reply_username;
        public TextView reply_message;

        public ReplyViewHolder(View v) {
            super(v);
            reply_username = (TextView) v.findViewById(R.id.reply_username);
            reply_message = (TextView) v.findViewById(R.id.reply_message);
        }
    }
}
