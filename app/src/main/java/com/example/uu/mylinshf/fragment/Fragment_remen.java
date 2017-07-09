package com.example.uu.mylinshf.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.uu.mylinshf.R;
import com.example.uu.mylinshf.adapter.Recyclerview_Home;
import com.example.uu.mylinshf.bean.Newss;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.AcFunHeader;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈驰 on 2017/7/9.
 */

public class Fragment_remen extends Fragment {
    private  String url = "http://news-at.zhihu.com/api/4/news/latest";
    private SpringView spring;
    private Recyclerview_Home my;
    List<Newss.StoriesBean> stories = new ArrayList<>();
    List<Newss.TopStoriesBean> top_stories;
    private Newss newss;
    private RecyclerView recy;
    private long path=20170504;
    private LinearLayoutManager linearLayoutManager;
    //handle 接受
    Handler handrle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                newss = (Newss) msg.obj;
                top_stories = newss.getTop_stories();
                stories.addAll(newss.getStories());
            }
            my = new Recyclerview_Home(top_stories,stories,getActivity());
            recy.setAdapter(my);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        //刷新页面
        spring = (SpringView) view.findViewById(R.id.spring);
        recy = (RecyclerView) view.findViewById(R.id.recyl);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置列表展示
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recy.setLayoutManager(linearLayoutManager);

        spring.setType(SpringView.Type.FOLLOW);
        spring.setHeader(new AcFunHeader(getActivity(),R.mipmap.ic_launcher));
        spring.setFooter(new DefaultFooter(getActivity()));
        jiexi();
        spring.setListener(new SpringView.OnFreshListener(){

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        spring.onFinishFreshAndLoad();
                        jiexi();
                    }
                },1000);
            }

            @Override
            public void onLoadmore() {
              path++;
                jiexi();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        spring.onFinishFreshAndLoad();
                    }
                },1000);
            }
        });
        spring.setHeader(new DefaultHeader(getActivity()));
        spring.setFooter(new DefaultHeader(getActivity()));
    }
    //OK的请求
    private void jiexi() {
        OkHttpClient mokHttpClient = new OkHttpClient();
        Request build = new Request.Builder().url(url).build();
        Call call = mokHttpClient.newCall(build);
        call.enqueue(new Callback() {


            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(getActivity(), "ssssss", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                newss = gson.fromJson(string, Newss.class);
                Message obtain = Message.obtain(handrle,0,newss);
                obtain.sendToTarget();
            }
        });
    }
}
