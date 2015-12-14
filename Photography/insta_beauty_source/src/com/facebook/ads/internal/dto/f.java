// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.dto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.g;

public class f
{

    public static final String a;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static int g = 0;
    public static String h = "";
    public static String i = "";
    public static int j = 0;
    public static String k = "";
    public static int l = 0;
    public static String m = "";
    public static String n = "";
    public static String o = "";
    public static boolean p = false;
    public static String q = "";
    private static boolean r = false;

    public static void a(Context context)
    {
        com/facebook/ads/internal/dto/f;
        JVM INSTR monitorenter ;
        if (!r)
        {
            r = true;
            c(context);
        }
        d(context);
        com/facebook/ads/internal/dto/f;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void b(Context context)
    {
        Object obj;
        if (!r)
        {
            return;
        }
        SharedPreferences sharedpreferences;
        String s;
        boolean flag;
        try
        {
            sharedpreferences = context.getSharedPreferences("SDKIDFA", 0);
            if (sharedpreferences.contains("attributionId"))
            {
                n = sharedpreferences.getString("attributionId", "");
            }
            if (sharedpreferences.contains("advertisingId"))
            {
                o = sharedpreferences.getString("advertisingId", "");
                p = sharedpreferences.getBoolean("limitAdTracking", p);
                q = com.facebook.ads.internal.c.a.name();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        obj = com.facebook.ads.internal.util.g.a(context.getContentResolver());
_L1:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s = ((com.facebook.ads.internal.util.g.a) (obj)).a;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        n = s;
        context = com.facebook.ads.internal.f.a(context, ((com.facebook.ads.internal.util.g.a) (obj)));
_L2:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        obj = context.a();
        flag = context.b();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        o = ((String) (obj));
        p = Boolean.valueOf(flag).booleanValue();
        q = context.c().name();
        context = sharedpreferences.edit();
        context.putString("attributionId", n);
        context.putString("advertisingId", o);
        context.putBoolean("limitAdTracking", p);
        context.apply();
        return;
        Exception exception;
        exception;
        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(exception, "Error retrieving attribution id from fb4a"));
        exception = null;
          goto _L1
        context;
        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(context, "Error retrieving advertising id from Google Play Services"));
        context = null;
          goto _L2
    }

    private static void c(Context context)
    {
        Object obj = context.getPackageManager();
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        String s;
        Exception exception;
        try
        {
            PackageInfo packageinfo = ((PackageManager) (obj)).getPackageInfo(context.getPackageName(), 0);
            d = packageinfo.packageName;
            f = packageinfo.versionName;
            g = packageinfo.versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1) { }
        if (d == null || d.length() < 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        s = ((PackageManager) (obj)).getInstallerPackageName(d);
        if (s != null)
        {
            try
            {
                if (s.length() > 0)
                {
                    h = s;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        obj = ((PackageManager) (obj)).getApplicationLabel(((PackageManager) (obj)).getApplicationInfo(context.getPackageName(), 0));
        if (obj != null)
        {
            try
            {
                if (((CharSequence) (obj)).length() > 0)
                {
                    e = ((CharSequence) (obj)).toString();
                }
            }
            // Misplaced declaration of an exception variable
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
        }
        context = (TelephonyManager)context.getSystemService("phone");
        if (context != null)
        {
            context = context.getNetworkOperatorName();
            if (context != null && context.length() > 0)
            {
                i = context;
            }
        }
        context = Build.MANUFACTURER;
        if (context != null && context.length() > 0)
        {
            b = context;
        }
        context = Build.MODEL;
        if (context != null && context.length() > 0)
        {
            c = Build.MODEL;
        }
        return;
    }

    private static void d(Context context)
    {
        try
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (context.isConnectedOrConnecting())
        {
            j = context.getType();
            k = context.getTypeName();
            l = context.getSubtype();
            m = context.getSubtypeName();
        }
    }

    static 
    {
        a = android.os.Build.VERSION.RELEASE;
    }
}
