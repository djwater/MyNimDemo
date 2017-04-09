package com.example.administrator.mynimdemo.model;

import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2017/4/2.
 */

public interface OnRoomCreateListener {
    void onSuccess(String respense);

    void onFaild(VolleyError error);
}
