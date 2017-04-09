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

import com.android.volley.VolleyError;
import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.model.OnRoomCreateListener;
import com.example.administrator.mynimdemo.util.Account_operation_util;
import com.example.administrator.mynimdemo.util.JsonParse;
import com.example.administrator.mynimdemo.view.MainActivity;

/**
 * Created by Administrator on 2017/3/31.
 */

public class CreateRoomFragment extends Fragment {

    private EditText et_roomname;
    private EditText et_notice;
    private Button btn_create;
    private EditText et_password;
    private EditText et_peopleNum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_room_layout, container, false);
        et_roomname = (EditText) view.findViewById(R.id.et_roomName);
        et_notice = (EditText) view.findViewById(R.id.et_notice);
        btn_create = (Button) view.findViewById(R.id.btn_create);
        et_password = (EditText) view.findViewById(R.id.et_password);
        et_peopleNum = (EditText) view.findViewById(R.id.et_peopleNum);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = et_roomname.getText().toString();
                String owner = Account_operation_util.getId(getContext());
                String notice = et_notice.getText().toString();
                Account_operation_util.createRoom(getContext(), roomName, owner, notice, new OnRoomCreateListener() {
                    @Override
                    public void onSuccess(String respense) {
                        String tid = JsonParse.getTid(respense);
                       Toast.makeText(getActivity(),"房间创建成功",Toast.LENGTH_SHORT).show();
                        ((MainActivity) getActivity()).changeFragment("gamewindow");
                        ((MainActivity) getActivity()).gameWindowSetTid(tid);

                    }

                    @Override
                    public void onFaild(VolleyError error) {
                       Toast.makeText(getActivity(),"房间创建失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }
}
