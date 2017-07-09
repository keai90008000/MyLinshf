package com.example.uu.mylinshf.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.uu.mylinshf.R;
import com.example.uu.mylinshf.bean.Newss;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈驰 on 2017/7/9.
 */

public class MyListviewAdapter extends BaseAdapter {
    private List<Newss.StoriesBean> stories = new ArrayList<>();
    Context context;

    public MyListviewAdapter(List<Newss.StoriesBean> stories, Context context) {
        this.stories = stories;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stories == null? 0:stories.size();
    }

    @Override
    public Object getItem(int position) {
        return stories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder= null;
        if (holder == null) {
            convertView = View.inflate(context, R.layout.mlistview_item, null);
            holder = new ViewHolder();
            holder.text_name= (TextView) convertView.findViewById(R.id.text_name);
            holder.image = (ImageView) convertView.findViewById(R.id.imagee);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text_name.setText(stories.get(position).getTitle());
        Glide.with(context).load(stories.get(position).getImages().get(0)).into(holder.image);
        return convertView;
    }
    class ViewHolder{
     TextView text_name;
     ImageView image;

    }
}
