package com.example.uu.mylinshf.apps;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;


/**
 * Created by 陈驰 on 2017/7/9.
 */

public class GlideImageLoader extends ImageLoader {

    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context.getApplicationContext()).load(path).crossFade().into(imageView);
    }
}
