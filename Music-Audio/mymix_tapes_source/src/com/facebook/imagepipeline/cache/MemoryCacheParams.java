// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;


public class MemoryCacheParams
{

    public final int maxCacheEntries;
    public final int maxCacheEntrySize;
    public final int maxCacheSize;
    public final int maxEvictionQueueEntries;
    public final int maxEvictionQueueSize;

    public MemoryCacheParams(int i, int j, int k, int l, int i1)
    {
        maxCacheSize = i;
        maxCacheEntries = j;
        maxEvictionQueueSize = k;
        maxEvictionQueueEntries = l;
        maxCacheEntrySize = i1;
    }
}
