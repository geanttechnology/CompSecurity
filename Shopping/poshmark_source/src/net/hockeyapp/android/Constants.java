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

public class Constants
{

    public static String ANDROID_VERSION = null;
    public static String APP_PACKAGE = null;
    public static String APP_VERSION = null;
    public static String APP_VERSION_NAME = null;
    public static final String BASE_URL = "https://sdk.hockeyapp.net/";
    public static String FILES_PATH = null;
    public static String PHONE_MANUFACTURER = null;
    public static String PHONE_MODEL = null;
    public static final String SDK_NAME = "HockeySDK";
    public static final String SDK_VERSION = "3.0.0";
    public static final String TAG = "HockeyApp";

    public Constants()
    {
    }

    private static int loadBuildNumber(Context context, PackageManager packagemanager)
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

    private static void loadFilesPath(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        try
        {
            context = context.getFilesDir();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("HockeyApp", "Exception thrown when accessing the files dir:");
            context.printStackTrace();
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        FILES_PATH = context.getAbsolutePath();
    }

    public static void loadFromContext(Context context)
    {
        ANDROID_VERSION = android.os.Build.VERSION.RELEASE;
        PHONE_MODEL = Build.MODEL;
        PHONE_MANUFACTURER = Build.MANUFACTURER;
        loadFilesPath(context);
        loadPackageData(context);
    }

    private static void loadPackageData(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        PackageInfo packageinfo;
        int i;
        try
        {
            PackageManager packagemanager = context.getPackageManager();
            packageinfo = packagemanager.getPackageInfo(context.getPackageName(), 0);
            APP_PACKAGE = packageinfo.packageName;
            APP_VERSION = (new StringBuilder()).append("").append(packageinfo.versionCode).toString();
            APP_VERSION_NAME = packageinfo.versionName;
            i = loadBuildNumber(context, packagemanager);
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
            break MISSING_BLOCK_LABEL_98;
        }
        if (i > packageinfo.versionCode)
        {
            APP_VERSION = (new StringBuilder()).append("").append(i).toString();
        }
    }

}
