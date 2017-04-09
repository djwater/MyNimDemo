package com.example.administrator.mynimdemo.bean;

import android.content.Context;

import com.example.administrator.mynimdemo.model.OnGetUserInfoListenter;
import com.example.administrator.mynimdemo.util.Account_operation_util;
import com.netease.nimlib.sdk.uinfo.UserInfoProvider;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/23.
 */

public class MyUserInfo implements UserInfoProvider.UserInfo {
    private Context context;
    private String rank;
    private String name;
    private String account;
    private String avatar;
    private String token;

    public MyUserInfo(Context context, String rank, String name, String account, String avatar) {
        this.context = context;
        this.rank = rank;
        this.name = name;
        this.account = account;
        this.avatar = avatar;
    }

    public MyUserInfo(String id,OnGetUserInfoListenter onGetUserInfoListenter) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(id);
        Account_operation_util.getUserInfo(context, strings, onGetUserInfoListenter);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MyUserInfo() {
    }

    public MyUserInfo(String rank, String name, String account, String avatar, String token) {
        this.rank = rank;
        this.name = name;
        this.account = account;
        this.avatar = avatar;
        this.token = token;
    }
}
