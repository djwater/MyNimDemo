package com.example.administrator.mynimdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.mynimdemo.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.model.IMMessage;

import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */

public class GameWindowFragme extends Fragment {
    private SimpleDraweeView bule1, bule2, bule3, bule4;
    private SimpleDraweeView green1, green2, green3, green4;
    private SimpleDraweeView red1, red2, red3, red4;
    private SimpleDraweeView yellow1, yellow2, yellow3, yellow4;
    private String tId=null;
    private Observer<List<IMMessage>> incomingMessageObserver =
            new Observer<List<IMMessage>>() {
                @Override
                public void onEvent(List<IMMessage> messages) {
                    for (IMMessage msg : messages) {
                        if (msg.getFromAccount().equals(tId)) {
                            switch (msg.getMsgType().toString()) {
                                case "100":
                                    Toast.makeText(getActivity(),"100",Toast.LENGTH_SHORT).show();
                                    break;
                                case "0":
                                    Toast.makeText(getActivity(),"0",Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }


                    }
                    // 处理新收到的消息，为了上传处理方便，SDK 保证参数 messages 全部来自同一个聊天对象。
                }
            };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gamewindow_layout, container, false);
        return view;
    }
    public void setTid(String tid) {
        this.tId = tid;
    }
    private void inin(View view) {
        green1 = ((SimpleDraweeView) view.findViewById(R.id.p1_1));
        green1.setImageResource(R.drawable.green);
        green2 = ((SimpleDraweeView) view.findViewById(R.id.p1_2));
        green2.setImageResource(R.drawable.green);
        green3 = ((SimpleDraweeView) view.findViewById(R.id.p1_3));
        green3.setImageResource(R.drawable.green);
        green4 = ((SimpleDraweeView) view.findViewById(R.id.p1_4));
        green4.setImageResource(R.drawable.green);

        red1 = ((SimpleDraweeView) view.findViewById(R.id.p2_1));
        red1.setImageResource(R.drawable.red);
        red2 = ((SimpleDraweeView) view.findViewById(R.id.p2_2));
        red2.setImageResource(R.drawable.red);
        red3 = ((SimpleDraweeView) view.findViewById(R.id.p2_3));
        red3.setImageResource(R.drawable.red);
        red4 = ((SimpleDraweeView) view.findViewById(R.id.p2_4));
        red4.setImageResource(R.drawable.red);

        bule1 = ((SimpleDraweeView) view.findViewById(R.id.p3_1));
        bule1.setImageResource(R.drawable.bule);
        bule2 = ((SimpleDraweeView) view.findViewById(R.id.p3_2));
        bule2.setImageResource(R.drawable.bule);
        bule3 = ((SimpleDraweeView) view.findViewById(R.id.p3_3));
        bule3.setImageResource(R.drawable.bule);
        bule4 = ((SimpleDraweeView)view. findViewById(R.id.p3_4));
        bule4.setImageResource(R.drawable.bule);

        yellow1 = ((SimpleDraweeView) view.findViewById(R.id.p4_1));
        yellow1.setImageResource(R.drawable.yellow);
        yellow2 = ((SimpleDraweeView) view.findViewById(R.id.p4_2));
        yellow2.setImageResource(R.drawable.yellow);
        yellow3 = ((SimpleDraweeView) view.findViewById(R.id.p4_3));
        yellow3.setImageResource(R.drawable.yellow);
        yellow4 = ((SimpleDraweeView)view. findViewById(R.id.p4_4));
        yellow4.setImageResource(R.drawable.yellow);
    }

}
