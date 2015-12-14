// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

class GifBitmapProvider
    implements com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
{

    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmappool)
    {
        bitmapPool = bitmappool;
    }

    public Bitmap obtain(int i, int j, android.graphics.Bitmap.Config config)
    {
        return bitmapPool.getDirty(i, j, config);
    }

    public void release(Bitmap bitmap)
    {
        if (!bitmapPool.put(bitmap))
        {
            bitmap.recycle();
        }
    }
}
