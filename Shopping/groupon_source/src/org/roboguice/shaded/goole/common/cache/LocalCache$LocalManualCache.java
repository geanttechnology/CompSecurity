// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            Cache, LocalCache, CacheBuilder

static class <init>
    implements Serializable, Cache
{

    final LocalCache localCache;

    public ConcurrentMap asMap()
    {
        return localCache;
    }

    public void cleanUp()
    {
        localCache.cleanUp();
    }

    public Object getIfPresent(Object obj)
    {
        return localCache.getIfPresent(obj);
    }

    public void put(Object obj, Object obj1)
    {
        localCache.put(obj, obj1);
    }

    I(CacheBuilder cachebuilder)
    {
        this(new LocalCache(cachebuilder, null));
    }

    private <init>(LocalCache localcache)
    {
        localCache = localcache;
    }

    localCache(LocalCache localcache, localCache localcache1)
    {
        this(localcache);
    }
}
