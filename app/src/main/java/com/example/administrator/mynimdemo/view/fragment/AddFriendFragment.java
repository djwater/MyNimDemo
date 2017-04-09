package com.example.administrator.mynimdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

/**
 * Created by Administrator on 2017/3/28.
 */

public class AddFriendFragment extends Fragment {
    private String accid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_layout, container, false);
        Button btn_search = (Button) view.findViewById(R.id.btn_search);
        final EditText et_id = (EditText) view.findViewById(R.id.et_id);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String faccid = et_id.getText().toString();
                Account_operation_util.addFriend(getActivity(), "1", "123", accid, faccid, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (accid.equals(faccid)) {
                            Toast.makeText(getActivity(), "不能添加自己为好友", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "添加成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity(), "添加失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }
}
