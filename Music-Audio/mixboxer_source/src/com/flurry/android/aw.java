// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

// Referenced classes of package com.flurry.android:
//            cy

final class aw
{

    private static final String p = com/flurry/android/aw.getSimpleName();

    aw()
    {
    }

    private static PackageInfo h(Context context)
    {
        PackageInfo packageinfo = null;
        if (context != null)
        {
            try
            {
                packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 20815);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                cy.c(p, (new StringBuilder()).append("Cannot find package info for package: ").append(context.getPackageName()).toString());
                return null;
            }
        }
        return packageinfo;
    }

    private static ApplicationInfo i(Context context)
    {
        ApplicationInfo applicationinfo = null;
        if (context != null)
        {
            try
            {
                applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                cy.c(p, (new StringBuilder()).append("Cannot find application info for package: ").append(context.getPackageName()).toString());
                return null;
            }
        }
        return applicationinfo;
    }

    public static String j(Context context)
    {
        context = h(context);
        if (context != null && ((PackageInfo) (context)).packageName != null)
        {
            return ((PackageInfo) (context)).packageName;
        } else
        {
            return "";
        }
    }

    public static String k(Context context)
    {
        context = h(context);
        if (context != null && ((PackageInfo) (context)).versionName != null)
        {
            return ((PackageInfo) (context)).versionName;
        } else
        {
            return "";
        }
    }

    public static Bundle l(Context context)
    {
        context = i(context);
        if (context != null && ((ApplicationInfo) (context)).metaData != null)
        {
            return ((ApplicationInfo) (context)).metaData;
        } else
        {
            return Bundle.EMPTY;
        }
    }

}
