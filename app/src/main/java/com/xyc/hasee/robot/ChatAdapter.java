package com.xyc.hasee.robot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by hasee on 2016/9/10.
 */
public class ChatAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<String> list;

    public ChatAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
        inflater=LayoutInflater.from(mContext);
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
        ViewHolder mHolder;
        if(convertView==null){

        }
        return convertView;
    }

    class ViewHolder {

    }
}
