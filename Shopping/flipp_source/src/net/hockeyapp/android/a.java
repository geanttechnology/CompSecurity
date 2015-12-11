// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.io.File;

public final class a
{

    public static String a = null;
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;

    private static int a(Context context, PackageManager packagemanager)
    {
        int i = 0;
        try
        {
            context = packagemanager.getApplicationInfo(context.getPackageName(), 128).metaData;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("HockeyApp", "Exception thrown when accessing the application info:");
            context.printStackTrace();
            return 0;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        i = context.getInt("buildNumber", 0);
        return i;
    }

    public static void a(Context context)
    {
        e = android.os.Build.VERSION.RELEASE;
        f = Build.MODEL;
        g = Build.MANUFACTURER;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        File file = context.getFilesDir();
        PackageInfo packageinfo;
        int i;
        if (file != null)
        {
            try
            {
                a = file.getAbsolutePath();
            }
            catch (Exception exception)
            {
                Log.e("HockeyApp", "Exception thrown when accessing the files dir:");
                exception.printStackTrace();
            }
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        try
        {
            PackageManager packagemanager = context.getPackageManager();
            packageinfo = packagemanager.getPackageInfo(context.getPackageName(), 0);
            d = packageinfo.packageName;
            b = (new StringBuilder()).append(packageinfo.versionCode).toString();
            c = packageinfo.versionName;
            i = a(context, packagemanager);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("HockeyApp", "Exception thrown when accessing the package info:");
            context.printStackTrace();
            return;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (i > packageinfo.versionCode)
        {
            b = String.valueOf(i);
        }
    }

}
