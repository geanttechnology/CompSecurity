// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.cache;

import android.support.v4.util.LruCache;

// Referenced classes of package com.amazon.ansel.fetch.cache:
//            ResourceCache, ResourceCacheListener, ResourceCacheValue

public class MemoryLimitedLruCache extends LruCache
    implements ResourceCache
{

    private final ResourceCacheListener listener;

    public MemoryLimitedLruCache(int i, ResourceCacheListener resourcecachelistener)
    {
        super(i);
        listener = resourcecachelistener;
    }

    protected void entryRemoved(boolean flag, Object obj, ResourceCacheValue resourcecachevalue, ResourceCacheValue resourcecachevalue1)
    {
        if (listener != null && (resourcecachevalue1 == null || resourcecachevalue1 != resourcecachevalue))
        {
            listener.evict(obj, resourcecachevalue);
        }
    }

    protected volatile void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
        entryRemoved(flag, obj, (ResourceCacheValue)obj1, (ResourceCacheValue)obj2);
    }

    protected int sizeOf(Object obj, ResourceCacheValue resourcecachevalue)
    {
        return resourcecachevalue.getByteCount();
    }

    protected volatile int sizeOf(Object obj, Object obj1)
    {
        return sizeOf(obj, (ResourceCacheValue)obj1);
    }
}
