package com.example.administrator.mynimdemo.view;

import com.example.administrator.mynimdemo.bean.MyUserInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/26.
 */

public interface IMainView {
    void setFriendlist(List<MyUserInfo> frilist);

    void setChatId(String faccid);
}
