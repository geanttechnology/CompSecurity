// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.util.concurrent.ExecutionException;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.util.concurrent.UncheckedExecutionException;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LoadingCache, LocalCache, CacheLoader, CacheBuilder

static class init> extends init>
    implements LoadingCache
{

    public final Object apply(Object obj)
    {
        return getUnchecked(obj);
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

    xception(CacheBuilder cachebuilder, CacheLoader cacheloader)
    {
        super(new LocalCache(cachebuilder, (CacheLoader)Preconditions.checkNotNull(cacheloader)), null);
    }
}
