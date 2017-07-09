package com.example.uu.mylinshf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uu.mylinshf.R;
import com.example.uu.mylinshf.bean.News_two;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 陈驰 on 2017/7/9.
 */

public class MyRecyclerveiw_xiangqing extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<News_two.StoriesBean> stories;
    Context context;
    public int TYPE_ONE = 0;
    public int TYPE_TWO = 1;

    public MyRecyclerveiw_xiangqing(List<News_two.StoriesBean> stories, Context context) {
        this.stories = stories;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            return new MyViewHoder1(LayoutInflater.from(context).inflate(R.layout.item_layout_one, parent, false));
            //  return new MyViewHolder1(View.inflate(context,R.layout.item_one_layout,null));
        } else if (viewType == TYPE_TWO) {
            //  return new MyViewHolder2(View.inflate(context,R.layout.item_two_layout,null));
            return new MyViewHoder2(LayoutInflater.from(context).inflate(R.layout.item_layout_two, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (stories.get(position).getImages() != null) {
            if (holder instanceof MyViewHoder1) {
                ImageLoader.getInstance().displayImage(stories.get(position).getImages().get(0), ((MyViewHoder1) holder).image_recy);
                ((MyViewHoder1) holder).title_recy.setText(stories.get(position).getTitle());
            }
        } else {
            if (holder instanceof MyViewHoder2) {
                Log.i("www", stories.get(position).getTitle());
                ((MyViewHoder2) holder).title_two_recy.setText(stories.get(position).getTitle());
            }
        }
 }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(stories.get(position).getImages()!=null){
            return TYPE_ONE;
        }else{
            return TYPE_TWO;
        }
    }

    class MyViewHoder1 extends RecyclerView.ViewHolder {
        private final ImageView image_recy;
        private final TextView title_recy;

        public MyViewHoder1(View itemView) {
            super(itemView);
            image_recy = (ImageView) itemView.findViewById(R.id.image_Recy);
            title_recy = (TextView) itemView.findViewById(R.id.title_recy);
        }
    }
    class MyViewHoder2 extends RecyclerView.ViewHolder {
        private final TextView title_two_recy;

        public MyViewHoder2(View itemView) {
            super(itemView);
            title_two_recy = (TextView) itemView.findViewById(R.id.title_two_recy);
        }
    }
}