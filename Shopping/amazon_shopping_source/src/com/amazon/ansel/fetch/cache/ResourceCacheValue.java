// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.cache;


public class ResourceCacheValue
{

    private final int byteCount;
    private final long expireTime;
    private final Object value;

    public ResourceCacheValue(Object obj, int i, long l)
    {
        value = obj;
        byteCount = i;
        expireTime = l;
    }

    public int getByteCount()
    {
        return byteCount;
    }

    public Object getValue()
    {
        return value;
    }

    public boolean isExpired()
    {
        return expireTime >= 0L && expireTime < System.currentTimeMillis();
    }
}
