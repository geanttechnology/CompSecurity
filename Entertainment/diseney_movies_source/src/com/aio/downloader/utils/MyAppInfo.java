// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

public class MyAppInfo
{

    Context context;
    PackageManager pm;

    public MyAppInfo(Context context1)
    {
        context = context1;
        pm = context1.getPackageManager();
    }

    public Drawable getAppIcon(String s)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        return pm.getApplicationInfo(s, 0).loadIcon(pm);
    }

    public String getAppName(String s)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        return pm.getApplicationInfo(s, 0).loadLabel(pm).toString();
    }

    public String getAppVersion(String s)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        return pm.getPackageInfo(s, 0).versionName;
    }
}
