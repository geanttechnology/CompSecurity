// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            v

public class ag
{

    public static final int a = 0;
    public static final int b = 1;
    public static String c = "";
    public static String d = "";

    public ag()
    {
    }

    public static int a(Context context, float f1)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f1 + 0.5F);
    }

    public static String a(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getSubscriberId();
    }

    public static int b(Context context, float f1)
    {
        return (int)(f1 / context.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static String b(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
    }

    public static String c(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String d(Context context)
    {
        context = (WifiManager)(WifiManager)context.getSystemService("wifi");
        if (context == null)
        {
            return "";
        }
        context = context.getConnectionInfo();
        if (context == null)
        {
            return "";
        } else
        {
            return context.getMacAddress();
        }
    }

    public static int e(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        int i1 = ((DisplayMetrics) (context)).widthPixels;
        return ((DisplayMetrics) (context)).heightPixels <= i1 ? 1 : 0;
    }

    public static int f(Context context)
    {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int g(Context context)
    {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static boolean h(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getSimState() == 5;
    }

    public static String i(Context context)
    {
        Object obj = (TelephonyManager)context.getSystemService("phone");
        context = ((TelephonyManager) (obj)).getSimCountryIso();
        if (TextUtils.isEmpty(context))
        {
            context = ((TelephonyManager) (obj)).getNetworkCountryIso();
        }
        obj = context;
        if (context == null)
        {
            obj = "";
        }
        return ((String) (obj)).toUpperCase(v.b);
    }

    public static String j(Context context)
    {
        context = ((TelephonyManager)context.getSystemService("phone")).getSimOperator();
        if (TextUtils.isEmpty(context))
        {
            break MISSING_BLOCK_LABEL_30;
        }
        context = context.substring(0, 3);
        return context;
        context;
        return c;
    }

    public static String k(Context context)
    {
        context = ((TelephonyManager)context.getSystemService("phone")).getSimOperator();
        if (TextUtils.isEmpty(context))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        int i1;
        context = context.substring(3);
        if (context.length() == 3)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        i1 = context.length();
        if (i1 != 2)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        return context;
        context;
        return d;
    }

    public static String l(Context context)
    {
        return Build.MODEL;
    }

}
