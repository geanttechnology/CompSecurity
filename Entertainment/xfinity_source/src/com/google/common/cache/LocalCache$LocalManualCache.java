// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.google.common.cache:
//            Cache, LocalCache, CacheBuilder, CacheLoader

static class localCache
    implements Cache, Serializable
{

    final LocalCache localCache;

    public final Object apply(Object obj)
    {
        return getUnchecked(obj);
    }

    public ConcurrentMap asMap()
    {
        return localCache;
    }

    public Object get(Object obj)
        throws ExecutionException
    {
        return localCache.getOrLoad(obj);
    }

    public Object getUnchecked(Object obj)
    {
        try
        {
            obj = get(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new UncheckedExecutionException(((ExecutionException) (obj)).getCause());
        }
        return obj;
    }

    Object writeReplace()
    {
        return new onProxy(localCache);
    }

    onProxy(CacheBuilder cachebuilder)
    {
        this(cachebuilder, null);
    }

    protected <init>(CacheBuilder cachebuilder, CacheLoader cacheloader)
    {
        localCache = new LocalCache(cachebuilder, cacheloader);
    }
}
