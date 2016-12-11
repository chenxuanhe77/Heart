package com.example.chenxuanhe.heart.Util;

/**
 * Created by ChenXuanHe on 2016/12/10.
 */

public class ReplyUtil {

    public ReplyUtil(){}

    private String username;
    private String replymessage;

    public ReplyUtil(String username,String replymessage){
        this.username = username;
        this.replymessage = replymessage;
    }

    public String getReplymessage() {
        return replymessage;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setReplymessage(String replymessage) {
        this.replymessage = replymessage;
    }
}
