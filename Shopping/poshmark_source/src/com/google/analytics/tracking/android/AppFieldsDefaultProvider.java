// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

// Referenced classes of package com.google.analytics.tracking.android:
//            DefaultProvider, Log

class AppFieldsDefaultProvider
    implements DefaultProvider
{

    private static AppFieldsDefaultProvider sInstance;
    private static Object sInstanceLock = new Object();
    protected String mAppId;
    protected String mAppInstallerId;
    protected String mAppName;
    protected String mAppVersion;

    protected AppFieldsDefaultProvider()
    {
    }

    private AppFieldsDefaultProvider(Context context)
    {
        String s;
        String s1;
        Object obj;
        PackageManager packagemanager;
        packagemanager = context.getPackageManager();
        mAppId = context.getPackageName();
        mAppInstallerId = packagemanager.getInstallerPackageName(mAppId);
        s1 = mAppId;
        obj = null;
        s = s1;
        PackageInfo packageinfo = packagemanager.getPackageInfo(context.getPackageName(), 0);
        s = s1;
        context = obj;
        if (packageinfo == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = s1;
        s1 = packagemanager.getApplicationLabel(packageinfo.applicationInfo).toString();
        s = s1;
        context = packageinfo.versionName;
        s = s1;
_L2:
        mAppName = s;
        mAppVersion = context;
        return;
        context;
        Log.e((new StringBuilder()).append("Error retrieving package info: appName set to ").append(s).toString());
        context = obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void dropInstance()
    {
        synchronized (sInstanceLock)
        {
            sInstance = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static AppFieldsDefaultProvider getProvider()
    {
        return sInstance;
    }

    public static void initializeProvider(Context context)
    {
        synchronized (sInstanceLock)
        {
            if (sInstance == null)
            {
                sInstance = new AppFieldsDefaultProvider(context);
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public String getValue(String s)
    {
        if (s != null)
        {
            if (s.equals("&an"))
            {
                return mAppName;
            }
            if (s.equals("&av"))
            {
                return mAppVersion;
            }
            if (s.equals("&aid"))
            {
                return mAppId;
            }
            if (s.equals("&aiid"))
            {
                return mAppInstallerId;
            }
        }
        return null;
    }

    public boolean providesField(String s)
    {
        return "&an".equals(s) || "&av".equals(s) || "&aid".equals(s) || "&aiid".equals(s);
    }

}
