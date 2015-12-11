// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.poshmark.application.PMApplication;

public class AppInfoCache
{

    Object mutex;
    SharedPreferences userFeedCacheInfo;

    public AppInfoCache()
    {
        mutex = new Object();
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        userFeedCacheInfo = context.getSharedPreferences("appInfoCache", 0);
    }

    public String getCurrentVersion()
    {
        return userFeedCacheInfo.getString("version", null);
    }

    public boolean isAppUpgraded()
    {
        return userFeedCacheInfo.getBoolean("version_upgraded", false);
    }

    public void setCurrentVersion(String s)
    {
        if (s != null)
        {
            userFeedCacheInfo.edit().putString("version", s).commit();
        }
    }

    public void setUpgradeFlag(boolean flag)
    {
        userFeedCacheInfo.edit().putBoolean("version_upgraded", flag).commit();
    }
}
