// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UpdateDialogVerison2 extends Dialog
{
    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener
    {

        static final List displayedImages = Collections.synchronizedList(new LinkedList());

        public void onLoadingComplete(String s, View view, Bitmap bitmap)
        {
            if (bitmap != null)
            {
                view = (ImageView)view;
                boolean flag;
                if (displayedImages.contains(s))
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (flag)
                {
                    FadeInBitmapDisplayer.animate(view, 500);
                    displayedImages.add(s);
                }
            }
        }


        private AnimateFirstDisplayListener()
        {
        }

        AnimateFirstDisplayListener(AnimateFirstDisplayListener animatefirstdisplaylistener)
        {
            this();
        }
    }

    public static interface OnCustomDialogListener
    {

        public abstract void back(String s);
    }


    private ImageLoadingListener animateFirstListener;
    private Button btnCancel;
    private Button btnEnter;
    private Context ctx;
    private ImageLoader imageLoader;
    private ImageView imgIcon;
    private android.view.View.OnClickListener itemsOnClick;
    private DisplayImageOptions options;
    private TextView tvContent;
    private TextView tvTitle;

    public UpdateDialogVerison2(Context context, int i, android.view.View.OnClickListener onclicklistener)
    {
        super(context, i);
        imageLoader = ImageLoader.getInstance();
        animateFirstListener = new AnimateFirstDisplayListener(null);
        ctx = context;
        itemsOnClick = onclicklistener;
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheOnDisc().showImageForEmptyUri(0x7f0200eb).displayer(new RoundedBitmapDisplayer(8)).build();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002f);
        btnCancel = (Button)findViewById(0x7f07015a);
        btnEnter = (Button)findViewById(0x7f07015b);
        tvTitle = (TextView)findViewById(0x7f07001c);
        tvContent = (TextView)findViewById(0x7f07001d);
        imgIcon = (ImageView)findViewById(0x7f070159);
        btnCancel.setOnClickListener(itemsOnClick);
        btnEnter.setOnClickListener(itemsOnClick);
    }

    public void setImgIcon(String s)
    {
        imageLoader.init(ImageLoaderConfiguration.createDefault(ctx));
        imageLoader.displayImage(s, imgIcon, options, animateFirstListener);
    }

    public void setTvContent(String s)
    {
        tvContent.setText(s);
    }

    public void setTvTitle(String s)
    {
        tvTitle.setText(s);
    }
}
