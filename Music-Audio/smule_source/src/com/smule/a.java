// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.smule.android.f.o;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class a extends Application
{

    public static final String TAG = com/smule/a.getName();
    private static a sInstance;
    protected boolean mShouldRefreshSessionAfterInactivity;

    public a()
    {
        mShouldRefreshSessionAfterInactivity = true;
    }

    public static void clearPreferences()
    {
        clearPreferencesExclude(null);
    }

    public static void clearPreferencesExclude(String as[])
    {
        PackageManager packagemanager;
        int i;
        i = 0;
        packagemanager = getContext().getPackageManager();
        if (packagemanager != null) goto _L2; else goto _L1
_L1:
        Log.e(TAG, "Could not get the package manager");
_L4:
        return;
_L2:
        HashSet hashset;
        hashset = new HashSet();
        if (as != null)
        {
            Collections.addAll(hashset, as);
        }
        as = getContext().getPackageName();
        hashset.add(as);
        int j;
        as = new File(packagemanager.getApplicationInfo(as, 128).dataDir, "shared_prefs");
        if (!as.exists() || !as.isDirectory())
        {
            continue; /* Loop/switch isn't completed */
        }
        as = as.list();
        j = as.length;
        while (i < j) 
        {
            try
            {
                String s = (new File(as[i])).getName().replace(".xml", "");
                if (!hashset.contains(s))
                {
                    Log.d(TAG, (new StringBuilder()).append("Clearing shared preference; file='").append(s).append("'").toString());
                    getContext().getSharedPreferences(s, 0).edit().clear().apply();
                }
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Log.e(TAG, "Failed to get app info!", as);
                return;
            }
            i++;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Context getContext()
    {
        return sInstance;
    }

    public static a getInstance()
    {
        return sInstance;
    }

    public void onCreate()
    {
        super.onCreate();
        sInstance = this;
        if (mShouldRefreshSessionAfterInactivity)
        {
            registerActivityLifecycleCallbacks(new o());
        }
    }

}
