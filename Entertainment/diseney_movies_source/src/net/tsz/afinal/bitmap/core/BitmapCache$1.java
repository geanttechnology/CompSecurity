// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import android.graphics.Bitmap;

// Referenced classes of package net.tsz.afinal.bitmap.core:
//            LruMemoryCache, BitmapCache, BitmapCommonUtils

class  extends LruMemoryCache
{

    final BitmapCache this$0;

    protected volatile int sizeOf(Object obj, Object obj1)
    {
        return sizeOf((String)obj, (Bitmap)obj1);
    }

    protected int sizeOf(String s, Bitmap bitmap)
    {
        return BitmapCommonUtils.getBitmapSize(bitmap);
    }

    ils(int i)
    {
        this$0 = BitmapCache.this;
        super(i);
    }
}
