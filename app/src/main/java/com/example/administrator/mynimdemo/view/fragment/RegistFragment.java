package com.example.administrator.mynimdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.util.Account_operation_util;
import com.example.administrator.mynimdemo.view.WelcomeActivity;

import static com.example.administrator.mynimdemo.R.id.accid;

/**
 * Created by Administrator on 2017/3/24.
 */

public class RegistFragment extends Fragment {
    private EditText et_account;
    private EditText et_password;
    private EditText et_repassword;
    private Button btn_regiser;
    private Button btn_back;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.regist_layout, container, false);
        et_account = ((EditText) v.findViewById(accid));
        et_password = ((EditText) v.findViewById(R.id.password));
        et_repassword = ((EditText) v.findViewById(R.id.repassword));
        btn_regiser = (Button) v.findViewById(R.id.regiser_btn);
        btn_back = ((Button) v.findViewById(R.id.back_btn));
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((WelcomeActivity) getActivity()).changeFragment("login");
            }
        });
        btn_regiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String code = "\"code\":200";
                String accid = et_account.getText().toString();
                String token = et_password.getText().toString();
                String retoken = et_repassword.getText().toString();
                if (accid == null || token == null || retoken == null) {
                    Toast.makeText(getActivity(), "请补全信息！", Toast.LENGTH_SHORT).show();
                } else if (!token.equals(retoken)) {
                    Toast.makeText(getActivity(), "两次密码不一致！", Toast.LENGTH_SHORT).show();
                } else {
                    Account_operation_util.register(getActivity(), accid, token, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.contains("already register")) {
                                Toast.makeText(getActivity(), "用户名已注册！" + response, Toast.LENGTH_SHORT).show();
                            } else if (response.contains(code)) {
                                Toast.makeText(getActivity(), "注册成功" + response, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "注册失败" + response, Toast.LENGTH_SHORT).show();
                            }
                            Log.d("google_lenve_fb", "onResponse: " + response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
        return v;
    }
}
