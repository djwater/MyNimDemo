package com.example.administrator.mynimdemo.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mynimdemo.R;
import com.google.android.flexbox.FlexboxLayout;

/**
 * Created by Administrator on 2017/3/28.
 */

public class RoomlistFragment extends Fragment {
    private FlexboxLayout roomList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.roomlist_layout, container, false);
        roomList = ((FlexboxLayout) view.findViewById(R.id.roomList));
        addRoom("要一起来玩吧",3);
        return view;
    }
    private void addRoom(String name, int people) {
        LinearLayout vg = new LinearLayout(getActivity());
        ImageView iv_room = new ImageView(getActivity());
        iv_room.setImageResource(R.drawable.room);
        LinearLayout.LayoutParams ivparams = new LinearLayout.LayoutParams((int) pxChangeDp(100), (int) pxChangeDp(80));
        vg.addView(iv_room,ivparams);
        TextView textView = new TextView(getActivity()){
            @Override
            public boolean isFocused() {
                return true;
            }
        };
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setText(name+"_"+people+"人房");
        textView.setTextSize(18);
        textView.setMarqueeRepeatLimit(-1);
        textView.setTextColor(Color.WHITE);
        textView.setSingleLine();
        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams((int) pxChangeDp(100), LinearLayout.LayoutParams.WRAP_CONTENT);
        vg.addView(textView, tvParams);
        FlexboxLayout.LayoutParams vgParams = new FlexboxLayout.LayoutParams((int) pxChangeDp(100), LinearLayout.LayoutParams.WRAP_CONTENT);
        vgParams.setMargins(60,60,60,60);
        roomList.addView(vg,vgParams);
    }
    public float pxChangeDp(float px) {
        float v = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, px, this.getResources().getDisplayMetrics());
        return v;
    }
}
