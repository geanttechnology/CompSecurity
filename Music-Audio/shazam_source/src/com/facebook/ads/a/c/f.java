// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.ads.a.f.b;
import com.facebook.ads.a.f.c;
import com.facebook.ads.a.f.g;

public final class f
{

    public static final String a;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static int g = 0;
    public static String h = "";
    public static int i = 0;
    public static String j = "";
    public static int k = 0;
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static boolean o = false;
    private static boolean p = false;

    public static void a(Context context)
    {
        com/facebook/ads/a/c/f;
        JVM INSTR monitorenter ;
        Object obj;
        if (p)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        p = true;
        obj = context.getPackageManager();
        try
        {
            PackageInfo packageinfo = ((PackageManager) (obj)).getPackageInfo(context.getPackageName(), 0);
            d = packageinfo.packageName;
            f = packageinfo.versionName;
            g = packageinfo.versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1) { }
        obj = ((PackageManager) (obj)).getApplicationLabel(((PackageManager) (obj)).getApplicationInfo(context.getPackageName(), 0));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        try
        {
            if (((CharSequence) (obj)).length() > 0)
            {
                e = ((CharSequence) (obj)).toString();
            }
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
        obj = (TelephonyManager)context.getSystemService("phone");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj = ((TelephonyManager) (obj)).getNetworkOperatorName();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        if (((String) (obj)).length() > 0)
        {
            h = ((String) (obj));
        }
        obj = Build.MANUFACTURER;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (((String) (obj)).length() > 0)
        {
            b = ((String) (obj));
        }
        obj = Build.MODEL;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        if (((String) (obj)).length() > 0)
        {
            c = Build.MODEL;
        }
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context != null)
        {
            try
            {
                if (context.isConnectedOrConnecting())
                {
                    i = context.getType();
                    j = context.getTypeName();
                    k = context.getSubtype();
                    l = context.getSubtypeName();
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
            finally
            {
                com/facebook/ads/a/c/f;
            }
        }
        com/facebook/ads/a/c/f;
        JVM INSTR monitorexit ;
        return;
        throw context;
    }

    public static void b(Context context)
    {
        Object obj;
        if (!p)
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
                m = sharedpreferences.getString("attributionId", "");
            }
            if (sharedpreferences.contains("advertisingId"))
            {
                n = sharedpreferences.getString("advertisingId", "");
                o = sharedpreferences.getBoolean("limitAdTracking", o);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        obj = com.facebook.ads.a.f.g.a(context.getContentResolver());
_L1:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        s = ((com.facebook.ads.a.f.g.a) (obj)).a;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        m = s;
        context = com.facebook.ads.a.g.a(context, ((com.facebook.ads.a.f.g.a) (obj)));
_L2:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        obj = ((com.facebook.ads.a.g) (context)).b;
        flag = ((com.facebook.ads.a.g) (context)).c;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        n = ((String) (obj));
        o = Boolean.valueOf(flag).booleanValue();
        context = sharedpreferences.edit();
        context.putString("attributionId", m);
        context.putString("advertisingId", n);
        context.putBoolean("limitAdTracking", o);
        context.apply();
        return;
        Exception exception;
        exception;
        com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(exception, "Error retrieving attribution id from fb4a"));
        exception = null;
          goto _L1
        context;
        com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(context, "Error retrieving advertising id from Google Play Services"));
        context = null;
          goto _L2
    }

    static 
    {
        a = android.os.Build.VERSION.RELEASE;
    }
}
