// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.util;


public class HostInfo
{

    private String accountId;
    private final String applicationName;
    private final String applicationVersion;
    private final String deviceId;
    private final String deviceName;
    private final String deviceVersion;

    public HostInfo(String s, String s1, String s2, String s3, String s4)
    {
        this(s, s1, s2, s3, s4, null);
    }

    public HostInfo(String s, String s1, String s2, String s3, String s4, String s5)
    {
        applicationName = s;
        applicationVersion = s1;
        deviceId = s2;
        deviceName = s3;
        deviceVersion = s4;
        accountId = s5;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public String getApplicationName()
    {
        return applicationName;
    }

    public String getApplicationVersion()
    {
        return applicationVersion;
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

    public void setAccountId(String s)
    {
        accountId = s;
    }
}
