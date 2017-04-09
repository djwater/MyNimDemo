package com.example.administrator.mynimdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.mynimdemo.R;

/**
 * Created by Administrator on 2017/2/24.
 */

public class Map extends View {
    int p1_1,p1_2,p1_3, p1_4;
    int p2_1,p2_2,p2_3, p2_4;
    int p3_1,p3_2,p3_3, p3_4;
    int p4_1,p4_2,p4_3, p4_4;

    public void setP1_1(int p1_1) {
        this.p1_1 = p1_1;
        invalidate();
    }

    public void setP1_2(int p1_2) {
        this.p1_2 = p1_2;;
        invalidate();
    }

    public void setP1_3(int p1_3) {
        this.p1_3 = p1_3;;
        invalidate();
    }

    public void setP1_4(int p1_4) {
        this.p1_4 = p1_4;;
        invalidate();
    }

    public void setP2_1(int p2_1) {
        this.p2_1 = p2_1;;
        invalidate();
    }

    public void setP2_2(int p2_2) {
        this.p2_2 = p2_2;;
        invalidate();
    }

    public void setP2_3(int p2_3) {
        this.p2_3 = p2_3;;
        invalidate();
    }

    public void setP2_4(int p2_4) {
        this.p2_4 = p2_4;;
        invalidate();
    }

    public void setP3_1(int p3_1) {
        this.p3_1 = p3_1;;
        invalidate();
    }

    public void setP3_2(int p3_2) {
        this.p3_2 = p3_2;;
        invalidate();
    }

    public void setP3_3(int p3_3) {
        this.p3_3 = p3_3;;
        invalidate();
    }

    public void setP3_4(int p3_4) {
        this.p3_4 = p3_4;;
        invalidate();
    }

    public void setP4_1(int p4_1) {
        this.p4_1 = p4_1;;
        invalidate();
    }

    public void setP4_2(int p4_2) {
        this.p4_2 = p4_2;;
        invalidate();
    }

    public void setP4_3(int p4_3) {
        this.p4_3 = p4_3;;
        invalidate();
    }

    public void setP4_4(int p4_4) {
        this.p4_4 = p4_4;;
        invalidate();
    }

    public Map(Context context) {
        this(context, null);
    }

    public Map(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Map(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundResource(R.drawable.cover);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int lenght = widthMeasureSpec > heightMeasureSpec ? heightMeasureSpec : widthMeasureSpec;
        super.onMeasure(lenght, lenght);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        invalidate();
    }


}
