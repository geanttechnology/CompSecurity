// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.widget.ImageView;
import com.github.ignition.support.images.remote.RemoteImageLoaderHandler;

// Referenced classes of package com.comcast.cim.android.image:
//            CimImageLoader, BadUrlCache

class eImageLoaderHandler extends RemoteImageLoaderHandler
{

    final CimImageLoader this$0;

    protected boolean handleImageLoaded(Bitmap bitmap, Message message)
    {
        if (bitmap == null)
        {
            CimImageLoader.access$000(CimImageLoader.this).setBadUrl(getImageUrl());
        }
        return false;
    }

    eImageLoaderHandler(ImageView imageview, String s, Drawable drawable)
    {
        this$0 = CimImageLoader.this;
        super(imageview, s, drawable);
    }
}
