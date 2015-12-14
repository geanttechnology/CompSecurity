// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifDrawable

static class bitmapProvider extends android.graphics.drawable.e
{

    BitmapPool bitmapPool;
    com.bumptech.glide.gifdecoder.ider bitmapProvider;
    Context context;
    byte data[];
    Bitmap firstFrame;
    Transformation frameTransformation;
    GifHeader gifHeader;
    int targetHeight;
    int targetWidth;

    public int getChangingConfigurations()
    {
        return 0;
    }

    public Drawable newDrawable()
    {
        return new GifDrawable(this);
    }

    public Drawable newDrawable(Resources resources)
    {
        return newDrawable();
    }

    public (GifHeader gifheader, byte abyte0[], Context context1, Transformation transformation, int i, int j, com.bumptech.glide.gifdecoder.ider ider, 
            BitmapPool bitmappool, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            throw new NullPointerException("The first frame of the GIF must not be null");
        } else
        {
            gifHeader = gifheader;
            data = abyte0;
            bitmapPool = bitmappool;
            firstFrame = bitmap;
            context = context1.getApplicationContext();
            frameTransformation = transformation;
            targetWidth = i;
            targetHeight = j;
            bitmapProvider = ider;
            return;
        }
    }
}
