// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

// Referenced classes of package com.bumptech.glide.load.engine.bitmap_recycle:
//            BitmapPool

public class BitmapPoolAdapter
    implements BitmapPool
{

    public BitmapPoolAdapter()
    {
    }

    public void clearMemory()
    {
    }

    public Bitmap get(int i, int j, android.graphics.Bitmap.Config config)
    {
        return null;
    }

    public Bitmap getDirty(int i, int j, android.graphics.Bitmap.Config config)
    {
        return null;
    }

    public boolean put(Bitmap bitmap)
    {
        return false;
    }

    public void trimMemory(int i)
    {
    }
}
