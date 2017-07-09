package com.example.uu.mylinshf.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.uu.mylinshf.R;
import com.example.uu.mylinshf.activite.XiangqingActivity;
import com.example.uu.mylinshf.adapter.MyGfidview;
import com.example.uu.mylinshf.bean.News;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by 陈驰 on 2017/7/9.
 */

public class Fragment_zuanlan extends Fragment {
    private  String url = "http://news-at.zhihu.com/api/4/themes";
    private GridView gridview;

    //handle 接受
    Handler handrle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
               final List<News.OthersBean> others = (List<News.OthersBean>) msg.obj;
                MyGfidview myGfidview = new MyGfidview(others,getActivity());
              gridview.setAdapter(myGfidview);
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                        intent.putExtra("id",others.get(position).getId());
                        startActivity(intent);
                    }
                });

            }

        }
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.zuanlan_layout, null);
        //刷新页面

        gridview = (GridView) view.findViewById(R.id.gridview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       jiexi();

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
                News news = gson.fromJson(string, News.class);
                List<News.OthersBean> others = news.getOthers();
                Message obtain = Message.obtain(handrle,0,others);
                obtain.sendToTarget();
            }
        });
    }
}
