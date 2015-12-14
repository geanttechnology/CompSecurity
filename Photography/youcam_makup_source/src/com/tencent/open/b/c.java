// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.open.a.k;
import java.util.Locale;

// Referenced classes of package com.tencent.open.b:
//            a

public class c
{

    static String a = null;
    static String b = null;
    static String c = null;
    private static String d;
    private static String e = null;

    public static String a()
    {
        Object obj;
        try
        {
            obj = com.tencent.open.utils.c.a();
        }
        catch (SecurityException securityexception)
        {
            k.b("MobileInfoUtil", "getLocalMacAddress>>>", securityexception);
            return "";
        }
        if (obj == null)
        {
            return "";
        }
        obj = (WifiManager)((Context) (obj)).getSystemService("wifi");
        if (obj == null)
        {
            return "";
        }
        obj = ((WifiManager) (obj)).getConnectionInfo();
        if (obj == null)
        {
            return "";
        }
        obj = ((WifiInfo) (obj)).getMacAddress();
        return ((String) (obj));
    }

    public static String a(Context context)
    {
        if (!TextUtils.isEmpty(d))
        {
            return d;
        }
        if (context == null)
        {
            return "";
        }
        d = "";
        context = (WindowManager)context.getSystemService("window");
        if (context != null)
        {
            int i = context.getDefaultDisplay().getWidth();
            int j = context.getDefaultDisplay().getHeight();
            d = (new StringBuilder()).append(i).append("x").append(j).toString();
        }
        return d;
    }

    public static String b()
    {
        return Locale.getDefault().getLanguage();
    }

    public static String b(Context context)
    {
        if (a != null && a.length() > 0)
        {
            return a;
        }
        if (context == null)
        {
            return "";
        }
        try
        {
            a = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
            context = a;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
    }

    public static String c(Context context)
    {
        if (b != null && b.length() > 0)
        {
            return b;
        }
        if (context == null)
        {
            return "";
        }
        try
        {
            b = ((TelephonyManager)context.getSystemService("phone")).getSimSerialNumber();
            context = b;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
    }

    public static String d(Context context)
    {
        if (c != null && c.length() > 0)
        {
            return c;
        }
        if (context == null)
        {
            return "";
        }
        try
        {
            c = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            context = c;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
    }

    public static String e(Context context)
    {
        Object obj;
        String s;
        DisplayMetrics displaymetrics;
        StringBuilder stringbuilder;
        int i;
        try
        {
            if (e != null)
            {
                break MISSING_BLOCK_LABEL_259;
            }
            WindowManager windowmanager = (WindowManager)context.getSystemService("window");
            displaymetrics = new DisplayMetrics();
            windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
            stringbuilder = new StringBuilder();
            stringbuilder.append("imei=").append(b(context)).append('&');
            stringbuilder.append("model=").append(Build.MODEL).append('&');
            stringbuilder.append("os=").append(android.os.Build.VERSION.RELEASE).append('&');
            stringbuilder.append("apilevel=").append(android.os.Build.VERSION.SDK_INT).append('&');
            s = com.tencent.open.b.a.b(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        obj = s;
        if (s == null)
        {
            obj = "";
        }
        stringbuilder.append("network=").append(((String) (obj))).append('&');
        obj = stringbuilder.append("sdcard=");
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        ((StringBuilder) (obj)).append(i).append('&');
        stringbuilder.append("display=").append(displaymetrics.widthPixels).append('*').append(displaymetrics.heightPixels).append('&');
        stringbuilder.append("manu=").append(Build.MANUFACTURER).append("&");
        stringbuilder.append("wifi=").append(com.tencent.open.b.a.e(context));
        e = stringbuilder.toString();
        context = e;
        return context;
    }

}
