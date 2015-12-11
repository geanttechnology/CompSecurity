// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import com.google.common.base.Preconditions;

// Referenced classes of package com.google.common.cache:
//            LoadingCache, LocalCache, CacheLoader, CacheBuilder

static class init> extends init>
    implements LoadingCache
{

    Object writeReplace()
    {
        return new onProxy(localCache);
    }

    onProxy(CacheBuilder cachebuilder, CacheLoader cacheloader)
    {
        super(cachebuilder, (CacheLoader)Preconditions.checkNotNull(cacheloader));
    }
}
