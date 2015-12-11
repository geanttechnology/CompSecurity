// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;


public class AppLovinSdkSettings
{

    private boolean a;
    private long b;
    private String c;
    private String d;

    public AppLovinSdkSettings()
    {
        b = -1L;
    }

    public String getAutoPreloadSizes()
    {
        return c;
    }

    public String getAutoPreloadTypes()
    {
        return d;
    }

    public long getBannerAdRefreshSeconds()
    {
        return b;
    }

    public boolean isVerboseLoggingEnabled()
    {
        return a;
    }

    public void setAutoPreloadSizes(String s)
    {
        c = s;
    }

    public void setAutoPreloadTypes(String s)
    {
        d = s;
    }

    public void setBannerAdRefreshSeconds(long l)
    {
        b = l;
    }

    public void setVerboseLogging(boolean flag)
    {
        a = flag;
    }
}
