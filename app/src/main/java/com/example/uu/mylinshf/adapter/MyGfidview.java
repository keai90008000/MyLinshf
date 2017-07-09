package com.example.uu.mylinshf.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uu.mylinshf.R;
import com.example.uu.mylinshf.bean.News;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 陈驰 on 2017/7/9.
 */

public class MyGfidview extends BaseAdapter {
    List<News.OthersBean> others ;
    Context context;

    public MyGfidview(List<News.OthersBean> others, Context context) {
        this.others = others;
        this.context = context;
    }

    @Override
    public int getCount() {
        return others.size();
    }

    @Override
    public Object getItem(int position) {
        return others.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.itme_layout,null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.image_Gridview);
            holder.content_gridview = (TextView) convertView.findViewById(R.id.content_Gridview);
            holder.title_gridview = (TextView) convertView.findViewById(R.id.title_Gridview);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
       holder.title_gridview.setText(others.get(position).getName());
         holder.content_gridview.setText(others.get(position).getDescription());
        ImageLoader.getInstance().displayImage(others.get(position).getThumbnail(),holder.image);
        return convertView;
    }
        class  ViewHolder{
        ImageView image;
        TextView title_gridview,content_gridview;
    }
}
