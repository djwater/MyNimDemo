package com.example.administrator.mynimdemo.util;

import com.example.administrator.mynimdemo.bean.MyUserInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/26.
 */

public class JsonParse {
    public static ArrayList<String> parseFriendsId(String json) {
        ArrayList<String> friendslist = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray friends = jsonObject.getJSONArray("friends");
            for (int i=0;i<=friends.length();i++) {
                JSONObject friend = friends.getJSONObject(i);
                String friendId = friend.getString("faccid");
                friendslist.add(friendId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return friendslist;
    }

    public static ArrayList<MyUserInfo> parseUserInfo(String json) {
        ArrayList<MyUserInfo> users = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray uinfos = jsonObject.getJSONArray("uinfos");
            for (int i=0;i<uinfos.length();i++) {
                MyUserInfo myUserInfo = new MyUserInfo();
                JSONObject user = uinfos.getJSONObject(i);
                if (user.has("accid")) {
                    String accid = user.getString("accid");
                    myUserInfo.setAccount(accid);
                }
                if (user.has("name")) {
                    String name = user.getString("name");
                myUserInfo.setAccount(name);
                }
                if (user.has("icon")) {
                String avatar = user.getString("icon");
                myUserInfo.setAccount(avatar);
                }
                if (user.has("ex")) {
                String rank = user.getString("ex");
                myUserInfo.setAccount(rank);
                }
                users.add(myUserInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return users;

    }

    public static String getTid(String json) {
        String tid = null;
        try {
            JSONObject object = new JSONObject(json);
            tid =  object.getString("tid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tid;
    }
}
