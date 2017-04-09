package com.example.administrator.mynimdemo.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mynimdemo.R;
import com.example.administrator.mynimdemo.view.fragment.LoginFragment;
import com.example.administrator.mynimdemo.view.fragment.RegistFragment;

public class WelcomeActivity extends AppCompatActivity {

    private Fragment targetFargmen;
    private FragmentTransaction transaction;
    private LoginFragment loginFragment;
    private RegistFragment registFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        transaction = getSupportFragmentManager().beginTransaction();
        loginFragment = new LoginFragment();
        transaction.replace(R.id.fragment, loginFragment);
        transaction.commit();

    }


    public void changeFragment(String targetFargment) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (targetFargment) {
            case "login":
                targetFargmen = loginFragment;
                break;
            case "regist":
                if (registFragment == null) {
                    registFragment = new RegistFragment();
                }
                targetFargmen = registFragment;
                break;
        }
        transaction.replace(R.id.fragment, targetFargmen);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
