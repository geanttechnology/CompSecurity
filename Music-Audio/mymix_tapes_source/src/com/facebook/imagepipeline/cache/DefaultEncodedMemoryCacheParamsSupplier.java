// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            MemoryCacheParams

public class DefaultEncodedMemoryCacheParamsSupplier
    implements Supplier
{

    private static final int MAX_CACHE_ENTRIES = 0x7fffffff;
    private static final int MAX_EVICTION_QUEUE_ENTRIES = 0x7fffffff;

    public DefaultEncodedMemoryCacheParamsSupplier()
    {
    }

    private int getMaxCacheSize()
    {
        int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 0x7fffffffL);
        if (i < 0x1000000)
        {
            return 0x100000;
        }
        return i >= 0x2000000 ? 0x400000 : 0x200000;
    }

    public MemoryCacheParams get()
    {
        int i = getMaxCacheSize();
        return new MemoryCacheParams(i, 0x7fffffff, i, 0x7fffffff, i / 8);
    }

    public volatile Object get()
    {
        return get();
    }
}
