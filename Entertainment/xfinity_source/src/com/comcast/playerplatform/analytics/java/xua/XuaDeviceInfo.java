// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;


public class XuaDeviceInfo
{

    private String deviceId;
    private String deviceName;
    private String deviceVersion;

    public XuaDeviceInfo()
    {
    }

    public XuaDeviceInfo(String s, String s1, String s2)
    {
        deviceName = s;
        deviceVersion = s1;
        deviceId = s2;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public String getDeviceVersion()
    {
        return deviceVersion;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setDeviceName(String s)
    {
        deviceName = s;
    }

    public void setDeviceVersion(String s)
    {
        deviceVersion = s;
    }
}
