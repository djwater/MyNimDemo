package com.example.administrator.mynimdemo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.mynimdemo.model.OnGetUserInfoListenter;
import com.example.administrator.mynimdemo.model.OnRoomCreateListener;
import com.example.administrator.mynimdemo.model.OnSearchFriendsListener;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/23.
 */

public class Account_operation_util {


    //注册
    public static void register(final Context context, final String accid, final String token, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.netease.im/nimserver/user/create.action";
        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("accid", accid);
                map.put("token", token);
                return map;
            }
        };
        queue.add(request);
    }

    //注销
    public static void logout() {
        NIMClient.getService(AuthService.class).logout();
    }

    //登陆
    public static void login(final Context context, String account, String psd, RequestCallback<LoginInfo> callback) {
        LoginInfo info = new LoginInfo(account, psd); // config...
        NIMClient.getService(AuthService.class).login(info)
                .setCallback(callback);
    }

    //更改密码
    public static void resetPsw(Context context, final String accid, final String token, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.netease.im/nimserver/user/update.action";
        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("accid", accid);
                map.put("token", token);
                return map;
            }
        };
        queue.add(request);
    }

    //更新用户信息
    public static void upDataUserInfo(Context context, final String name, final String avart, final String rank, final String accid, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.netease.im/nimserver/user/updateUinfo.action";
        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("accid", accid);
                map.put("name", name);
                map.put("sign", rank);
                map.put("icon", avart);
                return map;
            }
        };
        queue.add(request);
    }

    //获取用户信息
    public static void getUserInfo(Context context, final ArrayList<String> accids, final OnGetUserInfoListenter onGetUserInfoListenter) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.netease.im/nimserver/user/getUinfos.action";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                onGetUserInfoListenter.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onGetUserInfoListenter.failed(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                StringBuilder accidlist = new StringBuilder();
                accidlist.append("[");
                int acount = 0;
                for (String id : accids) {
                    acount++;
                    accidlist.append("\"" + id + "\"");
                    if (acount != accids.size()) {
                        accidlist.append(",");
                    } else {
                        accidlist.append("]");
                    }
                }
                Log.d("google_lenve_fb", "getParams: accids" + accidlist.toString());
                map.put("accids", accidlist.toString());
                return map;
            }
        };
        queue.add(request);
    }

    //查看用户好友列表
    public static void searchFriendList(Context context, final String accid, final OnSearchFriendsListener onSearchFriendsListener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.netease.im/nimserver/friend/get.action";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                onSearchFriendsListener.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onSearchFriendsListener.failed(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("accid", accid);
                map.put("createtime", "0");
                return map;
            }
        };
        queue.add(request);
    }

    //加好友
    //type	int	是	1直接加好友，2请求加好友，3同意加好友，4拒绝加好友
    //msg	String	否	加好友对应的请求消息，第三方组装，最长256字符
    public static void addFriend(Context context, final String type, final String msg, final String accid, final String faccid, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        String url = "https://api.netease.im/nimserver/friend/add.action";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("accid", accid);
                map.put("faccid", faccid);
                map.put("type", type);
                map.put("msg", msg);
                return map;
            }
        };
        queue.add(request);
    }

    //好友备注
    public static void updataFriendInfo(Context context, final String accid, final String faccid, final String alias, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        String url = "https://api.netease.im/nimserver/friend/update.action";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("accid", accid);
                map.put("faccid", faccid);
                map.put("alias", alias);
                return map;
            }
        };
        queue.add(request);
    }

    //删除好友
    public static void deleteFriend(Context context, final String accid, final String faccid, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        String url = "https://api.netease.im/nimserver/friend/delete.action";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("accid", accid);
                map.put("faccid", faccid);
                return map;
            }
        };
        queue.add(request);
    }

    //发送消息
    //ope 0对人信息 1对群信息
    //type 0 表示文本消息,1图2语音3视频4gps6文件100自定义
    //body正文
    public static void sendMsg(Context context, final String accid, final String faccid, final String ope, final String type, final String body, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        String url = "https://api.netease.im/nimserver/msg/sendMsg.action";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("from", accid);
                map.put("ope", ope);
                map.put("to", faccid);
                map.put("type", type);
                String option = "{\"push\":false,\"roam\":true,\"history\":false,\"sendersync\":true,\"route\":false,\"badge\":false,\"needPushNick\":true}";
                map.put("option",option );
                map.put("body", "{\"msg\":\"" + body + "\"}");
                return map;
            }
        };
        queue.add(request);
    }

    //緩存用戶信息
    public static void saveUserinfo(Context context, String id, String password, String name, String avart, String rank) {
        SharedPreferences sp = context.getSharedPreferences("user", Context.MODE_APPEND);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("accid", id);
        edit.putString("password", password);
        edit.putString("name", name);
        edit.putString("avart", avart);
        edit.putString("rank", rank);
        edit.commit();
    }

    //获取已缓存账号id
    public static String getId(Context context) {
        String string = context.getSharedPreferences("user", Context.MODE_APPEND).getString("accid", "nobody");
        return string;
    }

    //获取已缓存账号密码
    public static String getPsw(Context context) {
        String string = context.getSharedPreferences("user", Context.MODE_APPEND).getString("password", "nobody");
        return string;
    }

    //获取已缓存账号name
    public static String getName(Context context) {
        String string = context.getSharedPreferences("user", Context.MODE_APPEND).getString("name", "nobody");
        return string;
    }

    //获取已缓存账号rank
    public static String getRank(Context context) {
        String string = context.getSharedPreferences("user", Context.MODE_APPEND).getString("rank", "nobody");
        return string;
    }

    //获取已缓存账号avart
    public static String getAvart(Context context) {
        String string = context.getSharedPreferences("user", Context.MODE_APPEND).getString("avart", "nobody");
        return string;
    }

    //刪除緩存
    public static void deleteId(Context context) {
        context.getSharedPreferences("user", Context.MODE_APPEND).edit().clear().commit();
    }

    //创建群
    public static void createRoom(Context context, final String roomName, final String owner, final String announcement, final OnRoomCreateListener roomCreateListener) {
        String url = "https://api.netease.im/nimserver/team/create.action";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                roomCreateListener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                roomCreateListener.onFaild(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String appSecret = "520ac86e2013";
                String curTime = String.valueOf((new Date()).getTime() / 1000L);
                String checkSum = CheckSumBuilder.getCheckSum(appSecret, "123456", curTime);
                map.put("AppKey", "4cc8c36caf54f67ff9873acc793e584b");
                map.put("Nonce", "123456");
                map.put("CurTime", curTime);
                map.put("CheckSum", checkSum);
                map.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
//                String roomName,String owner,String members,String mes,String magree,String joinMode,String announcement
                map.put("tname", roomName);
                map.put("owner", owner);
                map.put("members", "[\"123\"]");
                map.put("announcement", announcement);
                map.put("msg", owner+"邀请你进入房间");
                map.put("magree", "0");
                map.put("joinmode", "0");

                return map;
            }
        };
        queue.add(request);
    }

}
