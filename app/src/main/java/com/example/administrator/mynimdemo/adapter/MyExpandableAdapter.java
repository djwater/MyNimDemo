package com.example.administrator.mynimdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.bean.MyUserInfo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */

public class MyExpandableAdapter extends BaseExpandableListAdapter {
    private List<List<MyUserInfo>> grouplist;
    private Context context;

    public MyExpandableAdapter(List<List<MyUserInfo>> grouplist, Context context) {
        this.grouplist = grouplist;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return grouplist.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grouplist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return grouplist.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder=null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.group_layout, parent, false);
            groupHolder = new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = ((GroupHolder) convertView.getTag());
        }
        switch (groupPosition) {
            case 0:
                groupHolder.listname.setText("好友列表");
                break;
            case 1:
                groupHolder.listname.setText("黑名单");
                break;
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.child_layout, parent, false);
            childHolder = new ChildHolder(convertView);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        MyUserInfo myUserInfo = grouplist.get(groupPosition).get(childPosition);
        String avatar = myUserInfo.getAvatar();
            String name = myUserInfo.getName();
            String rank = myUserInfo.getRank();
        String account = myUserInfo.getAccount();

        childHolder.avart.setImageURI("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=390542995,4068465260&fm=117&gp=0.jpg");
        if (account != null) {
            childHolder.name.setText(account);
        }
        if (rank != null) {
            childHolder.rank.setText(rank);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder {
        private TextView listname;
        private ImageView expandable;

        public GroupHolder(View view) {
            listname = ((TextView) view.findViewById(R.id.listname));
            expandable = (ImageView) view.findViewById(R.id.expandable);
        }
    }
    class ChildHolder{
        private TextView name, rank;
        private SimpleDraweeView avart;
        public ChildHolder(View view) {
            name = (TextView) view.findViewById(R.id.name);
            rank = (TextView) view.findViewById(R.id.info);
            avart = (SimpleDraweeView) view.findViewById(R.id.avart);
        }
    }
}
