// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class IdentifyUserWithSisRequest
{

    private List deviceInfo;
    private List deviceNativeData;

    public IdentifyUserWithSisRequest()
    {
    }

    public List getDeviceInfo()
    {
        return deviceInfo;
    }

    public List getDeviceNativeData()
    {
        return deviceNativeData;
    }

    public void setDeviceInfo(List list)
    {
        deviceInfo = list;
    }

    public void setDeviceNativeData(List list)
    {
        deviceNativeData = list;
    }
}
