// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager, BitmapPersistenceMapper

public class BitmapCacheManager extends CacheManager
{

    public BitmapCacheManager(Context context, String s, int i, int j, long l, long l1, boolean flag)
    {
        super(context, BitmapPersistenceMapper.get(), android/graphics/Bitmap, s, i, j, l, l1, flag);
    }

    public int flattenedSizeOf(String s, byte abyte0[])
    {
        int j = s.length();
        int i = j;
        if (abyte0 != null)
        {
            i = j + abyte0.length;
        }
        return i;
    }

    protected float getCacheMemorySizeFactor(Context context)
    {
        return Math.max((float)((ActivityManager)context.getSystemService("activity")).getMemoryClass() / 48F, 0.5F);
    }

    public Bitmap put(String s, Bitmap bitmap)
    {
        return put(s, bitmap, maxTtl);
    }

    public Bitmap put(String s, Bitmap bitmap, long l)
    {
        throw new IllegalStateException("You cannot add fully inflated Bitmaps directly to the cache. You must use putFlattenedBytes() with raw data.");
    }

    public volatile Object put(String s, Object obj)
    {
        return put(s, (Bitmap)obj);
    }

    public volatile Object put(String s, Object obj, long l)
    {
        return put(s, (Bitmap)obj, l);
    }

    public int sizeOf(String s, Bitmap bitmap)
    {
        int j = s.length();
        int i = j;
        if (bitmap != null)
        {
            i = j + bitmap.getByteCount();
        }
        return i;
    }

    public volatile int sizeOf(String s, Object obj)
    {
        return sizeOf(s, (Bitmap)obj);
    }
}
