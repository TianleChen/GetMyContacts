package com.project.tianle.getmycontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tianle on 2015/5/12.
 */
public class MyAdapter extends BaseAdapter {

    private List<PhoneInfo> lists;
    private Context context;
    private LinearLayout layout;

    public MyAdapter(List<PhoneInfo> lists, Context context){
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        layout = (LinearLayout) inflater.inflate(R.layout.cell, null);
//        TextView nametv = (TextView) layout.findViewById(R.id.name);
//        TextView numbertv = (TextView) layout.findViewById(R.id.number);
//        nametv.setText(lists.get(position).getName());
//        numbertv.setText(lists.get(position).getNumber());
        viewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cell, null);
            holder = new viewHolder();
            holder.nametv = (TextView) convertView.findViewById(R.id.name);
            holder.numbertv = (TextView) convertView.findViewById(R.id.number);
            holder.nametv.setText(lists.get(position).getName());
            holder.numbertv.setText(lists.get(position).getNumber());
            convertView.setTag(holder);
        }else{
            holder = (viewHolder) convertView.getTag();
            holder.nametv.setText(lists.get(position).getName());
            holder.numbertv.setText(lists.get(position).getNumber());
        }

        return convertView;
    }
    private static class viewHolder{
        TextView nametv;
        TextView numbertv;
    }
}
