package com.example.administrator.mynimdemo.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.adapter.MyExpandableAdapter;
import com.example.administrator.mynimdemo.bean.MyUserInfo;
import com.example.administrator.mynimdemo.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */

public class FriendlistFargment extends Fragment {
    private ExpandableListView friendlistview;
    private List<List<MyUserInfo>> groupList=new ArrayList<List<MyUserInfo>>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friendlist_layout, container, false);
        friendlistview = ((ExpandableListView) view.findViewById(R.id.friendlist));
        return view;
    }

    public void setFriendlistview(List<MyUserInfo> friends, List<MyUserInfo> bads, Context c) {
        groupList.add(friends);
        groupList.add(bads);
        MyExpandableAdapter adapter = new MyExpandableAdapter(groupList,c);
        friendlistview.setAdapter(adapter);
        friendlistview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ((MainActivity) getActivity()).setChatId(groupList.get(groupPosition).get(childPosition).getAccount());
                return false;
            }
        });
    }
}
