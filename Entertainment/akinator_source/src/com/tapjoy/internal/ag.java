// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

// Referenced classes of package com.tapjoy.internal:
//            cw

public final class ag
{

    public static int a(Context context)
    {
        return b(context.getPackageManager(), context.getPackageName());
    }

    public static String a(PackageManager packagemanager, String s)
    {
        try
        {
            packagemanager = packagemanager.getPackageInfo(s, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            return null;
        }
        return packagemanager;
    }

    public static int b(PackageManager packagemanager, String s)
    {
        int i;
        try
        {
            i = packagemanager.getPackageInfo(s, 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            return 0;
        }
        return i;
    }

    public static long c(PackageManager packagemanager, String s)
    {
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        long l = packagemanager.getPackageInfo(s, 0).firstInstallTime;
        if (l > 0L)
        {
            return l;
        }
        break MISSING_BLOCK_LABEL_27;
        packagemanager;
        return 0L;
    }

    public static String d(PackageManager packagemanager, String s)
    {
        try
        {
            packagemanager = cw.b(packagemanager.getApplicationInfo(s, 0).sourceDir);
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            return null;
        }
        return packagemanager;
    }

    public static Signature[] e(PackageManager packagemanager, String s)
    {
        try
        {
            packagemanager = packagemanager.getPackageInfo(s, 64).signatures;
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            return null;
        }
        return packagemanager;
    }
}
