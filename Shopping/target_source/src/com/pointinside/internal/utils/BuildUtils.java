// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuildUtils
{

    public static String sAppName;
    public static String sAppVersionLabel;
    private static String sBaseVersionName;
    private static boolean sBuildInfoCollected = false;
    private static boolean sIsDebuggable;

    public BuildUtils()
    {
    }

    private static void ensureBuildInfo(Context context)
    {
        boolean flag;
        flag = true;
        if (sBuildInfoCollected)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        PackageInfo packageinfo;
        packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        if (packageinfo.applicationInfo.labelRes == 0)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        sAppName = context.getString(packageinfo.applicationInfo.labelRes);
_L1:
        sBaseVersionName = packageinfo.versionName;
        if ((packageinfo.applicationInfo.flags & 2) == 0)
        {
            flag = false;
        }
        sIsDebuggable = flag;
        sBuildInfoCollected = true;
        return;
        try
        {
            sAppName = packageinfo.packageName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
          goto _L1
    }

    public static String getAppVersionLabel(Context context)
    {
        ensureBuildInfo(context);
        if (sAppVersionLabel == null)
        {
            sAppVersionLabel = makeAppVersionLabel(context);
        }
        return sAppVersionLabel;
    }

    public static String getFriendlyAppName(Context context)
    {
        ensureBuildInfo(context);
        return sAppName;
    }

    public static String getMetadataApiKey(Context context)
    {
        context = getMetadataBundle(context);
        if (context != null)
        {
            return context.getString("com.pointinside.android.API_KEY");
        } else
        {
            return null;
        }
    }

    private static Bundle getMetadataBundle(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        context = context.getPackageName();
        try
        {
            context = packagemanager.getApplicationInfo(context, 128).metaData;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        return context;
    }

    public static String getTidyAppName(Context context)
    {
        return getFriendlyAppName(context).replaceAll("[^\\w]+", "");
    }

    public static boolean isDebuggable(Context context)
    {
        ensureBuildInfo(context);
        return sIsDebuggable;
    }

    public static boolean isEmulatorBuild()
    {
        while ("generic".equals(Build.DEVICE) || "google_sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.MODEL) || Build.PRODUCT.startsWith("sdk") || Build.PRODUCT.endsWith("sdk")) 
        {
            return true;
        }
        return false;
    }

    private static String makeAppVersionLabel(Context context)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        Resources resources = context.getResources();
        int i = resources.getIdentifier("build_number", "integer", context.getPackageName());
        int j;
        if (i != 0)
        {
            i = resources.getInteger(i);
        } else
        {
            i = 0;
        }
        if (!isDebuggable(context) || i <= 0) goto _L2; else goto _L1
_L1:
        j = resources.getIdentifier("build_timestamp", "string", context.getPackageName());
        long l;
        if (j != 0)
        {
            l = Long.parseLong(resources.getString(j)) * 1000L;
        } else
        {
            l = 0L;
        }
        stringbuilder.append((new SimpleDateFormat("yyyyMMdd")).format(new Date(l)));
        stringbuilder.append(" build ");
        stringbuilder.append(String.valueOf(i));
_L4:
        return stringbuilder.toString();
_L2:
        stringbuilder.append(sBaseVersionName);
        if (isDebuggable(context))
        {
            stringbuilder.append('*');
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
