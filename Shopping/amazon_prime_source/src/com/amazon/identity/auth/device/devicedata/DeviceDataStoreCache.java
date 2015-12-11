// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.devicedata;

import java.util.concurrent.ConcurrentHashMap;

public final class DeviceDataStoreCache
{

    private static final String TAG = com/amazon/identity/auth/device/devicedata/DeviceDataStoreCache.getName();
    private static volatile DeviceDataStoreCache sInstance;
    private final ConcurrentHashMap mCache = new ConcurrentHashMap();

    private DeviceDataStoreCache()
    {
    }

    public static DeviceDataStoreCache getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new DeviceDataStoreCache();
        }
        return sInstance;
    }

    public boolean containsKey(String s)
    {
        return mCache.containsKey(s);
    }

    public String get(String s)
    {
        return (String)mCache.get(s);
    }

    public void invalidateCache()
    {
        mCache.clear();
    }

    public void put(String s, String s1)
    {
        mCache.put(s, s1);
    }

}
