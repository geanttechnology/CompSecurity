// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

// Referenced classes of package com.flurry.sdk:
//            el

public final class du
{

    private static final String a = com/flurry/sdk/du.getSimpleName();

    public du()
    {
    }

    public static PackageInfo a(Context context)
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
                el.a(a, (new StringBuilder()).append("Cannot find package info for package: ").append(context.getPackageName()).toString());
                return null;
            }
        }
        return packageinfo;
    }

    public static ApplicationInfo b(Context context)
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
                el.a(a, (new StringBuilder()).append("Cannot find application info for package: ").append(context.getPackageName()).toString());
                return null;
            }
        }
        return applicationinfo;
    }

    public static String c(Context context)
    {
        context = a(context);
        if (context != null && ((PackageInfo) (context)).packageName != null)
        {
            return ((PackageInfo) (context)).packageName;
        } else
        {
            return "";
        }
    }

    public static Bundle d(Context context)
    {
        context = b(context);
        if (context != null && ((ApplicationInfo) (context)).metaData != null)
        {
            return ((ApplicationInfo) (context)).metaData;
        } else
        {
            return Bundle.EMPTY;
        }
    }

}
