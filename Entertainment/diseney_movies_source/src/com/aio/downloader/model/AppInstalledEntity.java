// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.model;

import android.graphics.drawable.Drawable;

public class AppInstalledEntity
{

    private String ackageinfo;
    private String apkpath;
    private String appId;
    private String appname;
    private Drawable icon;
    private String size;
    private String version;

    public AppInstalledEntity()
    {
    }

    public String getAckageinfo()
    {
        return ackageinfo;
    }

    public String getApkpath()
    {
        return apkpath;
    }

    public String getAppId()
    {
        return appId;
    }

    public String getAppname()
    {
        return appname;
    }

    public Drawable getIcon()
    {
        return icon;
    }

    public String getSize()
    {
        return size;
    }

    public String getVersion()
    {
        return version;
    }

    public void setAckageinfo(String s)
    {
        ackageinfo = s;
    }

    public void setApkpath(String s)
    {
        apkpath = s;
    }

    public void setAppId(String s)
    {
        appId = s;
    }

    public void setAppname(String s)
    {
        appname = s;
    }

    public void setIcon(Drawable drawable)
    {
        icon = drawable;
    }

    public void setSize(String s)
    {
        size = s;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
