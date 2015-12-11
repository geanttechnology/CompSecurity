// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.model;

import android.graphics.drawable.Drawable;

public class AppInfo
{

    private String appname;
    private Drawable avatar;
    private String p_name;
    private String version;

    public AppInfo()
    {
    }

    public String getAppname()
    {
        return appname;
    }

    public Drawable getAvatar()
    {
        return avatar;
    }

    public String getP_name()
    {
        return p_name;
    }

    public String getVersion()
    {
        return version;
    }

    public void setAppname(String s)
    {
        appname = s;
    }

    public void setAvatar(Drawable drawable)
    {
        avatar = drawable;
    }

    public void setP_name(String s)
    {
        p_name = s;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
