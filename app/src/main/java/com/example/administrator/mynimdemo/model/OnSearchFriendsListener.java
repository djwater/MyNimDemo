package com.example.administrator.mynimdemo.model;

import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2017/3/27.
 */

public interface OnSearchFriendsListener {
    void success(String response);

    void failed(VolleyError error);
}
