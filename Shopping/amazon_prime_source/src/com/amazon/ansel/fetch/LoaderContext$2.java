// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.cache.MemoryLimitedLruCache;
import com.amazon.ansel.fetch.cache.ResourceCache;
import com.amazon.ansel.fetch.cache.ResourceCacheFactory;
import com.amazon.ansel.fetch.cache.ResourceCacheListener;

// Referenced classes of package com.amazon.ansel.fetch:
//            LoaderContext

static final class val.maxBytes
    implements ResourceCacheFactory
{

    final int val$maxBytes;

    public ResourceCache getCache(ResourceCacheListener resourcecachelistener)
    {
        return new MemoryLimitedLruCache(val$maxBytes, resourcecachelistener);
    }

    che(int i)
    {
        val$maxBytes = i;
        super();
    }
}
