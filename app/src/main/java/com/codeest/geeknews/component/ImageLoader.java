package com.codeest.geeknews.component;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.codeest.geeknews.app.App;

/**
 * Created by codeest on 2016/8/2.
 */
public class ImageLoader {

    public static void load(Context context, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
        if (!App.getAppComponent().preferencesHelper().getNoImageState()) {
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .transition(new DrawableTransitionOptions().crossFade())
                    .into(iv);
        }
    }

    public static void load(Activity activity, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
        if(!activity.isDestroyed()) {
            Glide.with(activity).load(url)
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                    .transition(new DrawableTransitionOptions().crossFade())
                    .into(iv);
        }
    }

    public static void loadAll(Context context, String url, ImageView iv) {    //不缓存，全部从网络加载
        Glide.with(context).load(url)
                .apply(new RequestOptions()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .transition(new DrawableTransitionOptions().crossFade())
                .into(iv);
    }

    public static void loadAll(Activity activity, String url, ImageView iv) {    //不缓存，全部从网络加载
        if(!activity.isDestroyed()) {
            Glide.with(activity).load(url)
                    .apply(new RequestOptions()
                            .skipMemoryCache(true)
                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                    .transition(new DrawableTransitionOptions().crossFade())
                    .into(iv);
        }
    }
}
