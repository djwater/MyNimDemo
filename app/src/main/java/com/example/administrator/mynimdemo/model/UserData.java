package com.example.administrator.mynimdemo.model;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.mynimdemo.util.JsonParse;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/23.
 */

public class UserData implements IUserData {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    Bundle data = msg.getData();
                    String json = data.getString("json");
                    ArrayList<String> strings = JsonParse.parseFriendsId(json);
            }
        }
    };

    public UserData() {
    }

    @Override
    public void getUserInfo(int id) {

    }

    @Override
    public void getFriendList(int id, Context context) {

    }

    @Override
    public void getBadFriendList(int id) {

    }

    @Override
    public void getRoom(int id) {

    }

    @Override
    public boolean isOnline() {
        return false;
    }
}
