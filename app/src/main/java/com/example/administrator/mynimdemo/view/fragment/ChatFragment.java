package com.example.administrator.mynimdemo.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.util.Account_operation_util;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.MsgServiceObserve;
import com.netease.nimlib.sdk.msg.model.IMMessage;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */

public class ChatFragment extends Fragment {
    final static int GETMSG = 0;
    final static int SENDMSG =1;
    final static int CHANGEMINENAME =2;

    private String sendBody;
    private TextView friendsName;
    private String accid;
    private String faccid;
    private Button btn_sent;
    private LinearLayout chatWindow;
    private ScrollView sv_scrpllView;
    private EditText editview;
    private Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GETMSG:
                    String content = msg.getData().getString("content");
                    TextView receiveWindow = createChat(0, content);
                    ScrollView.LayoutParams lp = new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT, ScrollView.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(10,10,10,0);
                    lp.gravity = Gravity.LEFT;
                    chatWindow.addView(receiveWindow,lp);
                    break;
                case SENDMSG:
                    TextView sendWindow = createChat(1, sendBody);
                        LinearLayout.LayoutParams sendlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        sendlp.setMargins(10,10,10,0);
                        sendlp.gravity = Gravity.RIGHT;
                        chatWindow.addView(sendWindow,sendlp);
                        editview.setText("");
                    break;
                case CHANGEMINENAME:
                    friendsName.setText(faccid);
            }
            sv_scrpllView.smoothScrollTo(0,Integer.MAX_VALUE);
        }
    };
    private Observer<List<IMMessage>> incomingMessageObserver =
            new Observer<List<IMMessage>>() {
                @Override
                public void onEvent(List<IMMessage> messages) {
                    for (IMMessage msg : messages) {
                        String s = msg.getFromAccount().toString();
                        Log.d("google_lenve_fb", "onEvent: "+s);
                        if (s .equals( faccid)) {
                            Message message = new Message();
                            message.what = GETMSG;
                            Bundle data = new Bundle();
                            data.putString("content", msg.getContent());
                            message.setData(data);
                            mhandler.sendMessage(message);
                        }
                    }
                    // 处理新收到的消息，为了上传处理方便，SDK 保证参数 messages 全部来自同一个聊天对象。
                }
            };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_layout, container, false);
        btn_sent = ((Button) view.findViewById(R.id.btn_send));
        chatWindow = ((LinearLayout) view.findViewById(R.id.chatWindow));
        friendsName = ((TextView) view.findViewById(R.id.name));
        sv_scrpllView = ((ScrollView) view.findViewById(R.id.scrollView));
        editview = ((EditText) view.findViewById(R.id.edittext));
        btn_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBody = editview.getText().toString();
                Account_operation_util.sendMsg(getActivity(), accid, faccid, "0", "0", sendBody, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mhandler.sendEmptyMessage(SENDMSG);
                        Log.d("google_lenve_fb", "onResponse: " + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),"发送失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NIMClient.getService(MsgServiceObserve.class)
                .observeReceiveMessage(incomingMessageObserver, true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        NIMClient.getService(MsgServiceObserve.class)
                .observeReceiveMessage(incomingMessageObserver, false);
    }

    private TextView createChat(int who,String content) {
        TextView textView = new TextView(getActivity());
        switch (who) {
            case 0:
                //收到的信息
                textView.setBackgroundResource(R.drawable.radius_bg);
                textView.setTextColor(Color.BLACK);
                break;
                //自身发送的信息
            case 1:
                textView.setBackgroundResource(R.drawable.bule_radius_bg);
                textView.setTextColor(Color.WHITE);
                break;

        }
        textView.setPadding(10,0,10,0);
        textView.setTextSize(25);
        textView.setText(content);
        return textView;
    }

    public void setId(String accid,String faccid) {
        this.faccid = faccid;
        this.accid = accid;
        mhandler.sendEmptyMessage(CHANGEMINENAME);
    }
}
