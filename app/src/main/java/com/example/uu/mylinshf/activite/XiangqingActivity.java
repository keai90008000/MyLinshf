package com.example.uu.mylinshf.activite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.uu.mylinshf.R;
import com.example.uu.mylinshf.adapter.MyRecyclerveiw_xiangqing;
import com.example.uu.mylinshf.bean.News_two;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;


public class XiangqingActivity extends AppCompatActivity {

    private RecyclerView recyl;
    private int ids;
   Handler handler = new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           if (msg.what == 0){
               List<News_two.StoriesBean> stories = (List<News_two.StoriesBean>) msg.obj;
               Log.i("ssss",stories.toString());
               MyRecyclerveiw_xiangqing adapte= new MyRecyclerveiw_xiangqing(stories,XiangqingActivity.this);
               recyl.setAdapter(adapte);
           }
       }
   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        recyl = (RecyclerView) findViewById(R.id.recy);
        Intent intent = getIntent();
        ids = intent.getIntExtra("id", 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyl.setLayoutManager(linearLayoutManager);
        jiexi();
    }

    private void jiexi() {
        OkHttpClient mOkhttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://news-at.zhihu.com/api/4/theme/" + ids).build();
        Call call = mOkhttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                News_two newss_two = gson.fromJson(string, News_two.class);
                List<News_two.StoriesBean> stories = newss_two.getStories();
                Log.i("ssssww",stories.toString());
                Message msg = Message.obtain(handler,0,stories);
                msg.sendToTarget();
            }
        });
    }
}
