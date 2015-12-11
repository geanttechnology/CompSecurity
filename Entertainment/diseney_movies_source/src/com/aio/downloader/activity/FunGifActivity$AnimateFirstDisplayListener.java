// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            FunGifActivity

private class <init> extends SimpleImageLoadingListener
{

    final List displayedImages;
    final FunGifActivity this$0;

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

    private r()
    {
        this$0 = FunGifActivity.this;
        super();
        displayedImages = Collections.synchronizedList(new LinkedList());
    }

    displayedImages(displayedImages displayedimages)
    {
        this();
    }
}
