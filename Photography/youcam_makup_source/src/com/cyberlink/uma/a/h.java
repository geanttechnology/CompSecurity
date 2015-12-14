// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class h
{

    private static String a;

    static String a()
    {
        return a;
    }

    static String a(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        context.getMetrics(displaymetrics);
        return (new StringBuilder()).append(displaymetrics.widthPixels).append("x").append(displaymetrics.heightPixels).toString();
    }

    static void a(String s)
    {
        a = s;
    }

    static String b()
    {
        return "Android";
    }

    static String b(Context context)
    {
        switch (context.getResources().getDisplayMetrics().densityDpi)
        {
        default:
            return "";

        case 120: // 'x'
            return "LDPI";

        case 160: 
            return "MDPI";

        case 213: 
            return "TVDPI";

        case 240: 
            return "HDPI";

        case 320: 
            return "XHDPI";

        case 400: 
            return "XMHDPI";

        case 480: 
            return "XXHDPI";

        case 640: 
            return "XXXHDPI";
        }
    }

    static String c()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    static String c(Context context)
    {
label0:
        {
            context = (TelephonyManager)context.getSystemService("phone");
            Object obj;
            if (context != null)
            {
                context = context.getNetworkOperatorName();
            } else
            {
                context = "";
            }
            if (context != null)
            {
                obj = context;
                if (context.length() != 0)
                {
                    break label0;
                }
            }
            obj = "";
            Log.i("CountlyDeviceInfo", "No carrier found");
        }
        return ((String) (obj));
    }

    static String d()
    {
        return Build.MODEL;
    }

    static String d(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("CountlyDeviceInfo", "No app version found");
            return "1.0";
        }
        return context;
    }

    static String e()
    {
        Locale locale = Locale.getDefault();
        return (new StringBuilder()).append(locale.getLanguage()).append("_").append(locale.getCountry()).toString();
    }

    static String e(Context context)
    {
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("_device", d());
            ((JSONObject) (obj)).put("_os", b());
            ((JSONObject) (obj)).put("_os_version", c());
            ((JSONObject) (obj)).put("_carrier", c(context));
            ((JSONObject) (obj)).put("_resolution", a(context));
            ((JSONObject) (obj)).put("_density", b(context));
            ((JSONObject) (obj)).put("_locale", e());
            ((JSONObject) (obj)).put("_app_version", d(context));
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        context = ((JSONObject) (obj)).toString();
        try
        {
            obj = URLEncoder.encode(context, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return context;
        }
        return ((String) (obj));
    }
}
