// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.httpcomponentsandroid.impl.client.cache.CacheConfig;
import java.io.File;

public interface HttpCacheConfiguration
{

    public abstract CacheConfig getApacheCacheConfig();

    public abstract File getCacheDirectory();

    public abstract int getCacheVersion();

    public abstract File getFileResourceDirectory();

    public abstract int getMaxSizeInBytes();

    public abstract int getPerResourceHeapLimitInBytes();
}
