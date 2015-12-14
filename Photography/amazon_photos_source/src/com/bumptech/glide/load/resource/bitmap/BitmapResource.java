// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public class BitmapResource
    implements Resource
{

    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    public BitmapResource(Bitmap bitmap1, BitmapPool bitmappool)
    {
        if (bitmap1 == null)
        {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (bitmappool == null)
        {
            throw new NullPointerException("BitmapPool must not be null");
        } else
        {
            bitmap = bitmap1;
            bitmapPool = bitmappool;
            return;
        }
    }

    public static BitmapResource obtain(Bitmap bitmap1, BitmapPool bitmappool)
    {
        if (bitmap1 == null)
        {
            return null;
        } else
        {
            return new BitmapResource(bitmap1, bitmappool);
        }
    }

    public Bitmap get()
    {
        return bitmap;
    }

    public volatile Object get()
    {
        return get();
    }

    public int getSize()
    {
        return Util.getBitmapByteSize(bitmap);
    }

    public void recycle()
    {
        if (!bitmapPool.put(bitmap))
        {
            bitmap.recycle();
        }
    }
}
