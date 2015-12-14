// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

// Referenced classes of package com.mopub.network:
//            Networking

final class e extends LruCache
{

    protected final volatile int sizeOf(Object obj, Object obj1)
    {
        return sizeOf((String)obj, (Bitmap)obj1);
    }

    protected final int sizeOf(String s, Bitmap bitmap)
    {
        if (bitmap != null)
        {
            return bitmap.getRowBytes() * bitmap.getHeight();
        } else
        {
            return super.sizeOf(s, bitmap);
        }
    }

    e(int i)
    {
        super(i);
    }
}
