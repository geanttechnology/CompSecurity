// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

// Referenced classes of package com.gotv.crackle.adapters:
//            BrowseGridViewAdapter

class leImageLoadingListener extends SimpleImageLoadingListener
{

    final BrowseGridViewAdapter this$0;
    final ImageView val$imageThumbnail;
    final boolean val$shouldAnimate;

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        if (val$shouldAnimate)
        {
            val$imageThumbnail.startAnimation(AnimationUtils.loadAnimation(BrowseGridViewAdapter.access$000(BrowseGridViewAdapter.this), 0x10a0000));
        }
    }

    leImageLoadingListener()
    {
        this$0 = final_browsegridviewadapter;
        val$shouldAnimate = flag;
        val$imageThumbnail = ImageView.this;
        super();
    }
}
