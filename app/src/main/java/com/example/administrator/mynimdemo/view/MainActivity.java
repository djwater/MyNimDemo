package com.example.administrator.mynimdemo.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.adapter.MyAdapter;
import com.example.administrator.mynimdemo.bean.MyUserInfo;
import com.example.administrator.mynimdemo.presenter.MainPresenter;
import com.example.administrator.mynimdemo.util.Account_operation_util;
import com.example.administrator.mynimdemo.view.fragment.AddFriendFragment;
import com.example.administrator.mynimdemo.view.fragment.ChatFragment;
import com.example.administrator.mynimdemo.view.fragment.CreateRoomFragment;
import com.example.administrator.mynimdemo.view.fragment.FriendlistFargment;
import com.example.administrator.mynimdemo.view.fragment.GameWindowFragme;
import com.example.administrator.mynimdemo.view.fragment.RoomlistFragment;
import com.example.administrator.mynimdemo.view.fragment.SettingFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {
    private MyUserInfo loginUser;
    private SimpleDraweeView mine_avart;
    private SimpleDraweeView sliding_avart;
    private ListView lv;
    private FragmentTransaction transaction;
    private FriendlistFargment friendlistFargment;
    private ChatFragment chatFragment;
    private AddFriendFragment addFriendFragment;
    private SettingFragment settingFragment;
    private RoomlistFragment roomlistFragment;
    private GameWindowFragme gameWindowFragme;
    private CreateRoomFragment createRoomFragment;
    private MainPresenter mainPresenter = new MainPresenter(this);
    private TextView mine_name;
    private PopupWindow pw;
    private Button btn_confirm;
    private View exit_view;
    private SlidingMenu slidingMenu;
    private TextView mine_rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUser();
        initView();
        initWindow();
        slidingmeunSetting();
        transaction = getSupportFragmentManager().beginTransaction();
        roomlistFragment = new RoomlistFragment();
        transaction.add(R.id.fragment, roomlistFragment);
        transaction.commit();
        exit_view = LayoutInflater.from(this).inflate(R.layout.exit_layout, null);
        btn_confirm = (Button) exit_view.findViewById(R.id.btn_yes);
        pw = new PopupWindow(exit_view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    }

    private void initWindow() {
        mine_rank.setText(loginUser.getRank());
        mine_name.setText(loginUser.getName());
        String avatar = loginUser.getAvatar();
        if (avatar != null) {
            mine_avart.setImageURI(avatar);
        } else {
            mine_avart.setImageURI("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=497402080,104334312&fm=23&gp=0.jpg");
        }
    }

    private void initUser() {
        loginUser = new MyUserInfo();
        String accid = Account_operation_util.getId(this);
        String psw = Account_operation_util.getPsw(this);
        String name = Account_operation_util.getName(this);
        String avart = Account_operation_util.getAvart(this);
        String rank = Account_operation_util.getRank(this);
        loginUser.setName(name);
        loginUser.setAvatar(avart);
        loginUser.setAccount(accid);
        loginUser.setRank(rank);
        loginUser.setToken(psw);
    }

    private void initView() {
        mine_avart = ((SimpleDraweeView) findViewById(R.id.mine_avart));
        mine_name = ((TextView) findViewById(R.id.mine_name));
        mine_rank = ((TextView) findViewById(R.id.mine_rank));
    }

    private void slidingmeunSetting() {
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        slidingMenu.setBehindWidth(widthPixels / 3);
        slidingMenu.setMenu(R.layout.left_layout);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        sliding_avart = ((SimpleDraweeView) findViewById(R.id.avart));
        String avatar = loginUser.getAvatar();
        sliding_avart.setImageURI("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=497402080,104334312&fm=23&gp=0.jpg");
        if (avatar != null) {
            sliding_avart.setImageURI(avatar);
        }

        lv = ((ListView) findViewById(R.id.listview));
        ArrayList<String> list = new ArrayList<>();
        list.add("房间列表");
        list.add("好友列表");
        list.add("查找好友");
        list.add("个人信息");
        list.add("创建房间");
        list.add("账号设置");
        list.add("注销");
        lv.setAdapter(new MyAdapter(list, this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        changeFragment("roomlist");
                        break;
                    case 1:
                        changeFragment("friendlist");
                        break;
                    case 2:
                        changeFragment("addFriend");
                        addFriendFragment.setAccid(loginUser.getAccount());
                        break;
                    case 3:
                        changeFragment("setting");
                        break;
                    case 4:
                        changeFragment("createroom");
                        break;
                    case 5:
                        break;
                    case 6:
                        break;

                }
            }
        });
        mine_avart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.showMenu();
            }
        });
    }

    public void changeFragment(String target) {
        transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (target) {
            case "friendlist":
                if (friendlistFargment == null) {
                    friendlistFargment = new FriendlistFargment();
                    transaction.add(R.id.fragment, friendlistFargment);
                    mainPresenter.friendStrart();
                }
                transaction.show(friendlistFargment);
                break;
            case "chat":
                if (chatFragment != null) {
                    transaction.remove(chatFragment);
                }
                chatFragment = new ChatFragment();
                transaction.add(R.id.fragment, chatFragment);
                mainPresenter.chatStart();
                transaction.show(chatFragment);
                break;
            case "addFriend":
                if (addFriendFragment == null) {
                    addFriendFragment = new AddFriendFragment();
                    transaction.add(R.id.fragment, addFriendFragment);
                }
                transaction.show(addFriendFragment);
                break;
            case "setting":
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.fragment, settingFragment);
                }
                transaction.show(settingFragment);
                break;
            case "roomlist":
                transaction.show(roomlistFragment);
                break;
            case "gamewindow":
                if (gameWindowFragme == null) {
                    gameWindowFragme = new GameWindowFragme();
                    transaction.add(R.id.fragment, gameWindowFragme);
                    mainPresenter.gameStrart();
                }
                transaction.show(gameWindowFragme);
                break;
            case "createroom":
                if (createRoomFragment == null) {
                    createRoomFragment = new CreateRoomFragment();
                    transaction.add(R.id.fragment, createRoomFragment);
                }
                transaction.show(createRoomFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    public void setFriendlist(List<MyUserInfo> frilist) {
        friendlistFargment.setFriendlistview(frilist, new ArrayList<MyUserInfo>(), this);
    }

    @Override
    public void setChatId(String faccid) {
        changeFragment("chat");
        chatFragment.setId(loginUser.getAccount(), faccid);
    }

    @Override
    public void onBackPressed() {
        if (!roomlistFragment.isVisible()) {
            transaction = getSupportFragmentManager().beginTransaction();
            hideFragment(transaction);
            transaction.show(roomlistFragment);
            return;
        }
        if (this.pw.isShowing()) {
            pw.dismiss();
        } else {
            pw.showAsDropDown(mine_name, 0, 200);
            btn_confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.super.onBackPressed();
                }
            });
            Button btn_cancel = (Button) exit_view.findViewById(R.id.btn_no);
            btn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pw.dismiss();
                }
            });
        }
    }

    public void hideFragment(FragmentTransaction transaction) {
        if (roomlistFragment != null) {
            transaction.hide(roomlistFragment);
        }
        if (friendlistFargment != null) {
            transaction.hide(friendlistFargment);
            slidingMenu.showContent();
        }
        if (settingFragment != null) {
        }
        if (chatFragment != null) {
            transaction.hide(chatFragment);
        }
        if (addFriendFragment != null) {
            transaction.hide(addFriendFragment);
        }
        if (createRoomFragment != null) {
            transaction.hide(createRoomFragment);
        }
        if (gameWindowFragme != null) {
            transaction.hide(gameWindowFragme);
        }
        slidingMenu.showContent();
    }

    public void mine_avare_onClick(View view) {
        slidingMenu.showMenu();
    }

    public void gameWindowSetTid(String tid) {
        gameWindowFragme.setTid(tid);
    }
}
