// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.github.ignition.support.images.remote.RemoteImageLoader;
import com.github.ignition.support.images.remote.RemoteImageLoaderHandler;

// Referenced classes of package com.comcast.cim.android.image:
//            CimImageLoader, BadUrlCache

private class onLoadListener extends RemoteImageLoaderHandler
{

    private getErrorDrawable onLoadListener;
    final CimImageLoader this$0;

    protected boolean handleImageLoaded(Bitmap bitmap, Message message)
    {
        String s;
        message = getImageView();
        s = (String)message.getTag();
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        CimImageLoader.access$000(CimImageLoader.this).setBadUrl(getImageUrl());
        if (onLoadListener == null) goto _L2; else goto _L3
_L3:
        onLoadListener.rror(message, s);
_L5:
        return false;
_L2:
        if (!getImageUrl().equals(s)) goto _L5; else goto _L4
_L4:
        if (bitmap == null) goto _L7; else goto _L6
_L6:
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(getImageView().getContext(), com.comcast.cim.android.ndler.getImageView);
        message.setImageBitmap(bitmap);
        message.startAnimation(animation);
        if (onLoadListener != null)
        {
            onLoadListener.onLoadListener(message, s, bitmap);
        }
_L9:
        CimImageLoader.access$300(CimImageLoader.this).cancelLoad(message);
        return true;
_L7:
        if (getErrorDrawable() != null)
        {
            message.setImageDrawable(getErrorDrawable());
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public (ImageView imageview, String s, Drawable drawable,  )
    {
        this$0 = CimImageLoader.this;
        super(imageview, s, drawable);
        onLoadListener = ;
    }
}
