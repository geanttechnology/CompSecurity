// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.Glide;

// Referenced classes of package com.bumptech.glide.load.engine.cache:
//            DiskLruCacheWrapper, DiskCacheAdapter, DiskCache

public final class InternalCacheDiskCacheFactory
    implements DiskCache.Factory
{

    private final Context context;
    private final String diskCacheName;
    private final int diskCacheSize;

    public InternalCacheDiskCacheFactory(Context context1, int i)
    {
        this(context1, null, i);
    }

    public InternalCacheDiskCacheFactory(Context context1, String s, int i)
    {
        context = context1;
        diskCacheName = s;
        diskCacheSize = i;
    }

    public DiskCache build()
    {
        DiskCache diskcache = null;
        Object obj;
        if (diskCacheName != null)
        {
            obj = Glide.getPhotoCacheDir(context, diskCacheName);
        } else
        {
            obj = Glide.getPhotoCacheDir(context);
        }
        if (obj != null)
        {
            diskcache = DiskLruCacheWrapper.get(((java.io.File) (obj)), diskCacheSize);
        }
        obj = diskcache;
        if (diskcache == null)
        {
            obj = new DiskCacheAdapter();
        }
        return ((DiskCache) (obj));
    }
}
