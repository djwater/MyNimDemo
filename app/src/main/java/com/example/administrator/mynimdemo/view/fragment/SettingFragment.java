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

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.util.Account_operation_util;

/**
 * Created by Administrator on 2017/3/28.
 */

public class SettingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_layout, container, false);
        final EditText et_avart = (EditText) view.findViewById(R.id.et_avart);
        final EditText et_name = (EditText) view.findViewById(R.id.et_name);
        final EditText et_rank = (EditText) view.findViewById(R.id.et_rank);
        Button btn_updata = (Button) view.findViewById(R.id.btn_updata);
        btn_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = Account_operation_util.getId(getActivity());
                String avart = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2075750630,4216747848&fm=117&gp=0.jpg";
                Account_operation_util.upDataUserInfo(getActivity(), et_name.getText().toString(), avart, et_rank.getText().toString(), id, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("google_lenve_fb", "onResponse: "+response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
