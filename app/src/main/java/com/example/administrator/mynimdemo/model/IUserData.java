package com.example.administrator.mynimdemo.model;

import android.content.Context;

/**
 * Created by Administrator on 2017/3/23.
 */

public interface IUserData {
    void getUserInfo(int id);

    void getFriendList(int id, Context context);

    void getBadFriendList(int id);

    void getRoom(int id);

    boolean isOnline();
}
