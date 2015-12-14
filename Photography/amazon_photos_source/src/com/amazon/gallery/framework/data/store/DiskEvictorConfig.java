// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;


public class DiskEvictorConfig
{

    protected long cloudSourceCapacity;
    protected long deviceSourceCapacity;
    protected int fetchFullLimit;
    protected int fetchThumbLimit;

    public DiskEvictorConfig()
    {
        cloudSourceCapacity = 0x12c00000L;
        deviceSourceCapacity = 0x6400000L;
        fetchFullLimit = 10;
        fetchThumbLimit = 200;
    }

    public long getCloudSourceCapacity()
    {
        return cloudSourceCapacity;
    }

    public long getDeviceSourceCapacity()
    {
        return deviceSourceCapacity;
    }

    public int getFetchFullLimit()
    {
        return fetchFullLimit;
    }

    public int getFetchThumbLimit()
    {
        return fetchThumbLimit;
    }
}
