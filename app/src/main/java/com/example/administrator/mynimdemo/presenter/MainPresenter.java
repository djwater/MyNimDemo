package com.example.administrator.mynimdemo.presenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.administrator.mynimdemo.bean.MyUserInfo;
import com.example.administrator.mynimdemo.model.IUserData;
import com.example.administrator.mynimdemo.model.OnGetUserInfoListenter;
import com.example.administrator.mynimdemo.model.OnSearchFriendsListener;
import com.example.administrator.mynimdemo.model.UserData;
import com.example.administrator.mynimdemo.util.Account_operation_util;
import com.example.administrator.mynimdemo.util.JsonParse;
import com.example.administrator.mynimdemo.view.IMainView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/26.
 */

public class MainPresenter implements IMainPresenter{
    final int GET_FRIENDS_ID = 0;
    final int PARSE_INFO = 1;
    final int FRIEND_START = 2;
    private IUserData userData;
    private IMainView mainView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GET_FRIENDS_ID:
                    String accid = Account_operation_util.getId((Context) mainView);
                    Account_operation_util.searchFriendList((Context) mainView, accid, new OnSearchFriendsListener() {
                        @Override
                        public void success(String response) {
                            Message msg = new Message();
                            Bundle data = new Bundle();
                            data.putString("json",response);
                            msg.setData(data);
                            msg.what = PARSE_INFO;
                            handler.sendMessage(msg);
                        }

                        @Override
                        public void failed(VolleyError error) {

                        }
                    });
                    break;
                case PARSE_INFO:
                    Bundle data = msg.getData();
                    String friends = data.getString("json");
                    ArrayList<String> ids = JsonParse.parseFriendsId(friends);
                    Account_operation_util.getUserInfo((Context) mainView, ids, new OnGetUserInfoListenter() {
                        @Override
                        public void onsuccess(String response) {
                            Log.d("google_lenve_fb", "onsuccess: PARSE_INFO"+response);
                            Message msg = new Message();
                            Bundle data = new Bundle();
                            data.putString("json",response);
                            msg.setData(data);
                            msg.what = FRIEND_START;
                            handler.sendMessage(msg);
                        }

                        @Override
                        public void failed(VolleyError error) {

                        }
                    });
                    break;
                case FRIEND_START:
                    String friend = msg.getData().getString("json");
                    Log.d("google_lenve_fb", "handleMessage: FRIEND_START"+friend);
                    ArrayList<MyUserInfo> myUserInfos = JsonParse.parseUserInfo(friend);
                    Log.d("google_lenve_fb", "handleMessage_FRIEND_START: "+myUserInfos.size());
                    mainView.setFriendlist(myUserInfos);

            }
        }
    };

    public MainPresenter(IMainView mainView) {
        this.mainView = mainView;
        userData = new UserData();
    }

    @Override
    public void chatStart() {
    }

    @Override
    public void friendStrart() {
        handler.sendEmptyMessage(GET_FRIENDS_ID);
    }

    @Override
    public void gameStrart() {

    }
}
