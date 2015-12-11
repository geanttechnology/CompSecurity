// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.dagger.application;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

public class ContextModule
{

    public static final String SHARED_PREFERENCES_NAME = "default";
    private final Context baseContext;

    public ContextModule(Context context)
    {
        baseContext = context;
    }

    public ActivityManager provideActivityManager()
    {
        return (ActivityManager)baseContext.getSystemService("activity");
    }

    public Application provideApplication()
    {
        return (Application)baseContext.getApplicationContext();
    }

    public AssetManager provideAssetManager()
    {
        return baseContext.getApplicationContext().getAssets();
    }

    public ConnectivityManager provideConnectivityManager()
    {
        return (ConnectivityManager)baseContext.getSystemService("connectivity");
    }

    public Context provideContext()
    {
        return baseContext.getApplicationContext();
    }

    public PackageManager providePackageManager()
    {
        return baseContext.getPackageManager();
    }

    public SharedPreferences provideSharedPreferences()
    {
        return baseContext.getApplicationContext().getSharedPreferences("default", 0);
    }

    public WifiManager provideWifiManager()
    {
        return (WifiManager)baseContext.getSystemService("wifi");
    }
}
