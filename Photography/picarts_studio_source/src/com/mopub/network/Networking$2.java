// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

// Referenced classes of package com.mopub.network:
//            Networking

final class val.imageCache
    implements com.mopub.volley.toolbox.mageCache
{

    final LruCache val$imageCache;

    public final Bitmap getBitmap(String s)
    {
        return (Bitmap)val$imageCache.get(s);
    }

    public final void putBitmap(String s, Bitmap bitmap)
    {
        val$imageCache.put(s, bitmap);
    }

    e()
    {
        val$imageCache = lrucache;
        super();
    }
}
