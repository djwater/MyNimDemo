package com.example.administrator.mynimdemo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.bean.MyUserInfo;
import com.example.administrator.mynimdemo.model.OnGetUserInfoListenter;
import com.example.administrator.mynimdemo.util.Account_operation_util;
import com.example.administrator.mynimdemo.util.JsonParse;
import com.example.administrator.mynimdemo.view.MainActivity;
import com.example.administrator.mynimdemo.view.WelcomeActivity;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/24.
 */

public class LoginFragment extends Fragment {
    private TextView tv_account, tv_password;
    private Button btn_login;
    private Button btn_regist;
    private ProgressBar loding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_layout, container, false);
        init(view);

        return view;
    }

    private void init(View view) {
        tv_account = (TextView) view.findViewById(R.id.account);
        tv_password = (TextView) view.findViewById(R.id.password);
        btn_login = ((Button) view.findViewById(R.id.btn_login));
        btn_regist = ((Button) view.findViewById(R.id.btn_regist));
        loding = ((ProgressBar) view.findViewById(R.id.loading));
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loding.setVisibility(View.VISIBLE);
                String account = tv_account.getText().toString();
                final String password = tv_password.getText().toString();
                Account_operation_util.login(getActivity(), account, password, new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo loginInfo) {
                        String accid = loginInfo.getAccount();
                        getLoginUser( accid);
                    }

                    @Override
                    public void onFailed(int i) {
                        loding.setVisibility(View.GONE);
                        Toast.makeText(getActivity(),"登陆失败",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        loding.setVisibility(View.GONE);
                        Toast.makeText(getActivity(),"登陆失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((WelcomeActivity) getActivity()).changeFragment("regist");
            }
        });
    }

    public void getLoginUser(String id) {
        ArrayList<String> ids = new ArrayList<>();
        ids.add(id);
        Account_operation_util.getUserInfo(getActivity(), ids, new OnGetUserInfoListenter() {
            @Override
            public void onsuccess(String response) {
                ArrayList<MyUserInfo> myUserInfos = JsonParse.parseUserInfo(response);
                MyUserInfo myUserInfo = myUserInfos.get(0);
                String accid = myUserInfo.getAccount();
                String avart = myUserInfo.getAvatar();
                String name = myUserInfo.getName();
                String rank = myUserInfo.getRank();
                String password = myUserInfo.getToken();
                Account_operation_util.saveUserinfo(getActivity(),accid,password,name,avart,rank);
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }

            @Override
            public void failed(VolleyError error) {

            }
        });
    }
}
