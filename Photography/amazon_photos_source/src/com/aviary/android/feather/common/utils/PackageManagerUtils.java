// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

public final class PackageManagerUtils
{

    private static final String LOG_TAG = "PackageManagerUtils";
    private static ApplicationInfo mInfo;
    private static PackageInfo mPackageInfo;
    private static String sCdsAuthority;
    private static String sCdsProviderContentUri;

    private PackageManagerUtils()
    {
    }

    public static ApplicationInfo getApplicationInfo(Context context)
    {
        if (mInfo == null)
        {
            PackageManager packagemanager = context.getPackageManager();
            try
            {
                mInfo = packagemanager.getApplicationInfo(context.getPackageName(), 128);
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        return mInfo;
    }

    public static String getCDSProviderAuthority(Context context)
    {
        if (sCdsAuthority == null)
        {
            sCdsAuthority = (new StringBuilder()).append(context.getPackageName()).append(".AviaryCdsProvider").toString();
        }
        return sCdsAuthority;
    }

    public static Uri getCDSProviderContentUri(Context context, String s)
    {
        if (s == null)
        {
            return Uri.parse(getCDSProviderContentUrl(context));
        } else
        {
            return Uri.withAppendedPath(Uri.parse(getCDSProviderContentUrl(context)), s);
        }
    }

    public static String getCDSProviderContentUrl(Context context)
    {
        if (sCdsProviderContentUri == null)
        {
            sCdsProviderContentUri = (new StringBuilder()).append("content://").append(getCDSProviderAuthority(context)).toString();
        }
        return sCdsProviderContentUri;
    }

    public static PackageInfo getPackageInfo(Context context)
    {
        if (mPackageInfo == null && context != null)
        {
            PackageManager packagemanager = context.getPackageManager();
            try
            {
                mPackageInfo = packagemanager.getPackageInfo(context.getPackageName(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        return mPackageInfo;
    }

    public static PackageInfo getPackageInfo(Context context, int i)
    {
        return getPackageInfo(context, context.getPackageName(), i);
    }

    public static PackageInfo getPackageInfo(Context context, String s, int i)
    {
        context = context.getPackageManager();
        try
        {
            context = context.getPackageInfo(s, i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static boolean hasPermission(Context context, String s)
    {
        context = getPackageInfo(context, 4096);
        if (context != null && ((PackageInfo) (context)).requestedPermissions != null)
        {
            context = ((PackageInfo) (context)).requestedPermissions;
            int j = context.length;
            for (int i = 0; i < j; i++)
            {
                if (s.equals(context[i]))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isDebugVersion(Context context)
    {
        return false;
    }

    public static boolean isStandalone(Context context)
    {
        return "com.aviary.android.feather".equals(context.getPackageName());
    }
}
