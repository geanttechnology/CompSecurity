// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;

import java.util.UUID;

public class DeviceInfo
{

    static String deviceId = null;

    public DeviceInfo()
    {
    }

    public static String getDeviceId()
    {
        if (deviceId == null)
        {
            deviceId = UUID.randomUUID().toString();
        }
        return deviceId;
    }

    public static String getDeviceName()
    {
        return "DMSTestApp";
    }

    public static String getDeviceUserAgent()
    {
        return "Android-Phone";
    }

}
