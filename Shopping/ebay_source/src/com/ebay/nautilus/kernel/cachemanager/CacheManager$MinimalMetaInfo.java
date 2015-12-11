// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;


// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager

private static class expirationTime
{

    public final long expirationTime;
    public final int itemSize;

    public boolean isExpired(long l)
    {
        return l >= expirationTime;
    }

    public long remainingTtl(long l)
    {
        return expirationTime - l;
    }

    protected (int i, long l)
    {
        itemSize = i;
        expirationTime = l;
    }

    protected expirationTime(expirationTime expirationtime)
    {
        this(expirationtime.itemSize, expirationtime.expirationTime);
    }
}
