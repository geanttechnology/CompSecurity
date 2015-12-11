// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.model;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.Iterator;
import java.util.List;

public class PackagesInfo
{

    private List appList;

    public PackagesInfo(Context context)
    {
        appList = context.getApplicationContext().getPackageManager().getInstalledApplications(8192);
    }

    public ApplicationInfo getInfo(String s)
    {
        if (s == null)
        {
            return null;
        }
        Iterator iterator = appList.iterator();
        ApplicationInfo applicationinfo;
        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }
            applicationinfo = (ApplicationInfo)iterator.next();
        } while (!s.equals(applicationinfo.processName));
        return applicationinfo;
    }
}
