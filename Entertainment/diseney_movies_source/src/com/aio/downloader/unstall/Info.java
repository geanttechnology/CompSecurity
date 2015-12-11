// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.graphics.drawable.Drawable;

public class Info
{

    private Drawable icon;
    private String name;
    private String packagename;
    private String version;

    public Info()
    {
    }

    public Drawable getIcon()
    {
        return icon;
    }

    public String getName()
    {
        return name;
    }

    public String getPackagename()
    {
        return packagename;
    }

    public String getVersion()
    {
        return version;
    }

    public void setIcon(Drawable drawable)
    {
        icon = drawable;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPackagename(String s)
    {
        packagename = s;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
