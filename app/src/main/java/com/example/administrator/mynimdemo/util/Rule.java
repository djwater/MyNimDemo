package com.example.administrator.mynimdemo.util;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 */


public class Rule {
    private List<Float> list;
    private  float h;
    private  float w;
    private Context context;

    public Rule(Context context) {
        this.context = context;
    }
    //win=59
    public List rule(String color,int num) {
        list = new ArrayList<Float>();
        switch (color) {
            case "green":
                if (num > 50 && num < 70) {
                    num += 2;
                }
                break;
            case "red":
                if (num <= 39) {
                    num += 13;
                } else if (num <= 50) {
                    num -= 39;
                } else if (num <= 70) {
                    num += 9;
                }
                break;
            case "yellow":
                if (num <= 26) {
                    num += 26;
                } else if (num <= 50) {
                    num -= 26;
                } else if(num<=70){
                    num += 15;
                }
                break;
            case "bule":
                if (num <= 13) {
                    num += 39;
                } else if (num <= 50) {
                    num -= 13;
                } else if(num<=70){
                    num += 21;
                }
                break;
        }
        switch (num) {
            case 1:
                h = 99;
                w = 15;
                break;
            case 2:
                h = 90;
                w = 38.5f;
                break;
            case 3:
                h = 90;
                w = 60;
                break;
            case 4:
                h = 100;
                w = 82;
                break;
            case 5:
                h=82;
                w = 100;
                break;
            case 6:
                h=59;
                w=90;
                break;
            case 7:
                h=38;
                w=90;
                break;
            case 8:
                h=15;
                w = 100;
                break;
            case 9:
                h = 7;
                w = 123.5f;
                break;
            case 10:
                h=7;
                w = 144;
                break;
            case 11:
                h = 7;
                w = 165.5f;
                break;
            case 12:
                h = 7;
                w = 187f;
                break;
            case 13:
                h = 7;
                w = 208.5f;
                break;
            case 14:
                h=15;
                w=231;
                break;
            case 15:
                h=38;
                w = 240;
                break;
            case 16:
                h = 59;
                w = 240;
                break;
            case 17:
                h=82;
                w = 230;
                break;
            case 18:
                h=100;
                w = 248;
                break;
            case 19:
                h=90;
                w = 272;
                break;
            case 20:
                h=90;
                w = 293;
                break;
            case 21:
                h=100;
                w = 315;
                break;
            case 22:
                h=123;
                w = 324;
                break;
            case 23:
                h=144;
                w = 324;
                break;
            case 24:
                h=165.5f;
                w = 324;
                break;
            case 25:
                h=187;
                w = 324;
                break;
            case 26:
                h=208.5f;
                w = 324;
                break;
            case 27:
                h=230;
                w = 315;
                break;
            case 28:
                h=240;
                w = 293;
                break;
            case 29:
                h=240;
                w = 272;
                break;
            case 30:
                h=230;
                w = 248;
                break;
            case 31:
                h=248;
                w = 230;
                break;
            case 32:
                h=271.5f;
                w = 240;
                break;
            case 33:
                h=293;
                w = 240;
                break;
            case 34:
                h=316;
                w = 231;
                break;
            case 35:
                h=324;
                w = 208.5f;
                break;
            case 36:
                h=324;
                w = 187;
                break;
            case 37:
                h=324;
                w = 165.5f;
                break;
            case 38:
                h=324;
                w = 144;
                break;
            case 39:
                h=324;
                w = 123.5f;
                break;
            case 40:
                h=316;
                w = 100;
                break;
            case 41:
                h=293;
                w = 90;
                break;
            case 42:
                h=271.5f;
                w = 90;
                break;
            case 43:
                h=248;
                w = 100;
                break;
            case 44:
                h=230;
                w = 82;
                break;
            case 45:
                h=240;
                w = 60;
                break;
            case 46:
                h=240   ;
                w = 38.5f;
                break;
            case 47:
                h=230;
                w = 15;
                break;
            case 48:
                h=208.5f;
                w = 5;
                break;
            case 49:
                h=187;
                w = 5;
                break;
            case 50:
                h=165.5f;
                w = 5;
                break;
            case 51:
                h=144;
                w = 5;
                break;
            case 52:
                h=123;
                w = 5;
                break;
            //分支绿
            case 53:
                w=38;
                h = 165.5f;
                break;
            case 54:
                w = 59;
                h = 165.5f;
                break;
            case 55:
                w = 82;
                h = 165.5f;
                break;
            case 56:
                w = 100;
                h = 165.5f;
                break;
            case 57:
                w = 123;
                h = 165.5f;
                break;
            case 58:
                w = 144;
                h = 165.5f;
                break;
            case 59:
                w = 165.5f;
                h = 165.5f;
                break;
            //分支红
            case 60:
                w = 165.5f;
                h = 38;
                break;
            case 61:
                w = 165.5f;
                h = 59;
                break;
            case 62:
                w = 165.5f;
                h = 82;
                break;
            case 63:
                w = 165.5f;
                h = 100;
                break;
            case 64:
                w = 165.5f;
                h = 123;
                break;
            case 65:
                w = 165.5f;
                h = 144;
                break;
            //分支黄
            case 66:
                h = 165.5f;
                w = 293;
                break;
            case 67:
                h = 165.5f;
                w = 271.5f;
                break;
            case 68:
                h = 165.5f;
                w = 250;
                break;
            case 69:
                h = 165.5f;
                w = 228.5f;
                break;
            case 70:
                h = 165.5f;
                w = 207.5f;
                break;
            case 71:
                h = 165.5f;
                w = 186;
                break;
            //分支蓝
            case 72:
                w = 165.5f;
                h = 293;
                break;
            case 73:
                w = 165.5f;
                h = 271.5f;
                break;
            case 74:
                w = 165.5f;
                h = 250;
                break;
            case 75:
                w = 165.5f;
                h = 228.5f;
                break;
            case 76:
                w = 165.5f;
                h = 207.5f;
                break;
            case 77:
                w = 165.5f;
                h = 186;
                break;
            //绿色出棋
            case 78:
                h=11;
                w=7;
                break;
            case 79:
                h=11;
                w = 49;
                break;
            case 80:
                h=44;
                w = 7;
                break;
            case 81:
                h=44;
                w = 49;
                break;
            //红色出棋
            case 82:
                h=11;w=282;
                break;
            case 83:
                //top44 6 top 44 48//top10 48
                h = 11;
                w = 324;
                break;
            case 84:
                h = 44;
                w = 282;
                break;
            case 85:
                h = 44;
                w = 324;
                break;
            //黄色出棋
            case 86:
                h = 286;
                w = 324;
                break;
            case 87:
                h = 320;
                w = 324;
                break;
            case 88:
                h = 286;
                w = 282;
                break;
            case 89:
                h = 320;
                w = 282;
                break;
            //蓝色出棋
            case 90:
                h = 286;
                w = 49;
                break;
            case 91:
                h = 320;
                w = 49;
                break;
            case 92:
                h = 286;
                w = 7;
                break;
            case 93:
                h = 320;
                w = 7;
                break;
        }
        list.add(w);
        list.add(h);
        return list;
    }

    public void move(Object chess, int star,int target, String color) {

        for (int i=star;i<target;i++) {
            List stars = rule(color, i);
            float stars_x = (float) stars.get(0);
            float stars_y = (float) stars.get(1);
            List targets = rule(color, i+1);
            float targets_x = (float) targets.get(0);
            float targets_y = (float) targets.get(1);
            ObjectAnimator x= ObjectAnimator.ofFloat(chess, "translationX", pxChange2dp(stars_x), pxChange2dp(targets_x));
            ObjectAnimator y= ObjectAnimator.ofFloat(chess, "translationY", pxChange2dp(stars_y), pxChange2dp(targets_y));
            x.setDuration(1000);
            y.setDuration(1000);
            x.start();
            y.start();
        }}
    //将PX转换成DP
    public float pxChange2dp(float i) {
        float v = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, i, context.getResources().getDisplayMetrics());
        return v;
    }
}

