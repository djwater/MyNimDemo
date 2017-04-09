package com.example.administrator.mynimdemo.view;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/27.
 */

public class MarqueeView extends TextView {
    public MarqueeView(Context context) {
        super(context);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
