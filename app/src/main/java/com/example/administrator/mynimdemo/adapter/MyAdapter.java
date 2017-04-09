package com.example.administrator.mynimdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mynimdemo.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/22.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<String> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public MyAdapter() {
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_layout, parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }
            holder.textView.setText(list.get(position).toString());
        return convertView;
    }

     class ViewHolder {
         private TextView textView;

         public ViewHolder(View view) {
             textView = ((TextView) view.findViewById(R.id.text));
         }
     }
}
