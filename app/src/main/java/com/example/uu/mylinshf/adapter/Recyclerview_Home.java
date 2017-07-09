package com.example.uu.mylinshf.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.uu.mylinshf.R;
import com.example.uu.mylinshf.apps.GlideImageLoader;
import com.example.uu.mylinshf.bean.Newss;
import com.example.uu.mylinshf.view.MyListview;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈驰 on 2017/7/9.
 */

public class Recyclerview_Home extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     List<Newss.TopStoriesBean> top_stories;
     List<Newss.StoriesBean> stories;
     Context context;
     int TYPE_ONE = 0;
     int TYPE_TWO = 1;


    public Recyclerview_Home(List<Newss.TopStoriesBean> top_stories, List<Newss.StoriesBean> stories, Context context) {
        this.top_stories = top_stories;
        this.stories = stories;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if(viewType == TYPE_ONE){
          return new MyViewHolder1(View.inflate(context, R.layout.ban_item,null)) ;
       }else if(viewType == TYPE_TWO){
           return  new MyViewHolder2(View.inflate(context,R.layout.listview_layout,null));
     }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  MyViewHolder1){
               ((MyViewHolder1) holder).bindHolder(top_stories,context);
        }else  if (holder instanceof  MyViewHolder2){
          ((MyViewHolder2) holder).mylistview.setAdapter(new MyListviewAdapter(stories,context));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return  TYPE_ONE;
        }else if (position == 1){
            return TYPE_TWO;
        }
        return -1;
    }

    @Override
    public int getItemCount() {

        return 2;

    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{
        List<String> list = new ArrayList<>();
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (top_stories == null){
                    card.setVisibility(View.GONE);
                    return;
                }
                List<Newss.TopStoriesBean> top_stories = (List<Newss.TopStoriesBean>) msg.obj;
                for (int i = 0; i < top_stories.size(); i++) {
                    list.add(top_stories.get(i).getImage());
                }
                banner.setImageLoader(new GlideImageLoader());
                banner.setImages(list);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.start();
            }
        };

        private Banner banner;
        private  CardView card;
        public MyViewHolder1(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
            card = (CardView) itemView.findViewById(R.id.card);

        }

        public void bindHolder( List<Newss.TopStoriesBean> top_stories, Context context) {
            Message msg = Message.obtain();
            msg.obj = top_stories;
            handler.sendMessage(msg);
        }

    }
    class  MyViewHolder2 extends  RecyclerView.ViewHolder{

        private final MyListview mylistview;

        public MyViewHolder2(View itemView) {
            super(itemView);
            mylistview = (MyListview) itemView.findViewById(R.id.mylistview);
        }
    }
}
