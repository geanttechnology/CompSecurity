// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.net.Uri;

public final class z
{

    private static final Uri a = Uri.parse("http://play.google.com/store/apps/details");
    private static final String b[] = {
        "com.google.android.youtube", "com.google.android.youtube.tv", "com.google.android.youtube.googletv", "com.google.android.gms", null
    };

    public static String a(Context context)
    {
        context = context.getPackageManager();
        String as[] = b;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = as[i];
            obj = context.resolveService((new Intent("com.google.android.youtube.api.service.START")).setPackage(((String) (obj))), 0);
            if (obj != null && ((ResolveInfo) (obj)).serviceInfo != null && ((ResolveInfo) (obj)).serviceInfo.packageName != null)
            {
                return ((ResolveInfo) (obj)).serviceInfo.packageName;
            }
        }

        if (context.hasSystemFeature("android.software.leanback"))
        {
            return "com.google.android.youtube.tv";
        }
        if (context.hasSystemFeature("com.google.android.tv"))
        {
            return "com.google.android.youtube.googletv";
        } else
        {
            return "com.google.android.youtube";
        }
    }

    public static boolean a(Context context, String s)
    {
        Resources resources;
        try
        {
            resources = context.getPackageManager().getResourcesForApplication(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        context = s;
        if (s.equals("com.google.android.youtube.googletvdev"))
        {
            context = "com.google.android.youtube.googletv";
        }
        for (int i = resources.getIdentifier("youtube_api_version_code", "integer", context); i == 0 || 12 > resources.getInteger(i) / 100;)
        {
            return true;
        }

        return false;
    }

    public static Context b(Context context)
    {
        try
        {
            context = context.createPackageContext(a(context), 3);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static int c(Context context)
    {
label0:
        {
            Context context1 = b(context);
            int i = 0;
            if (context1 != null)
            {
                i = context1.getResources().getIdentifier("clientTheme", "style", a(context));
            }
            int j = i;
            if (i == 0)
            {
                if (android.os.Build.VERSION.SDK_INT < 14)
                {
                    break label0;
                }
                j = 0x1030128;
            }
            return j;
        }
        return android.os.Build.VERSION.SDK_INT < 11 ? 0x1030005 : 0x103006b;
    }

    public static String d(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", context);
        }
        return context;
    }

}
