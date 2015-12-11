// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;

// Referenced classes of package com.jirbo.adcolony:
//            q, ak, bb

class bh
{

    static String a;
    static boolean b;

    static String a()
    {
        return android.provider.Settings.Secure.getString(q.d().getContentResolver(), "android_id");
    }

    static String b()
    {
        String s1 = ((TelephonyManager)q.d().getSystemService("phone")).getNetworkOperatorName();
        String s = s1;
        if (s1.length() == 0)
        {
            s = "unknown";
        }
        return s;
    }

    static int c()
    {
        Context context = ak.b().getApplicationContext();
        ak.b();
        return ((ActivityManager)context.getSystemService("activity")).getMemoryClass();
    }

    static long d()
    {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / (long)0x100000;
    }

    static String e()
    {
        return bb.a(ak.b());
    }

    static int f()
    {
        return ak.b().getWindowManager().getDefaultDisplay().getWidth();
    }

    static int g()
    {
        return ak.b().getWindowManager().getDefaultDisplay().getHeight();
    }

    static String h()
    {
        return "";
    }

    static boolean i()
    {
        if (ak.O == null) goto _L2; else goto _L1
_L1:
        if (!ak.O.equals("tablet")) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        DisplayMetrics displaymetrics = q.d().getResources().getDisplayMetrics();
        float f1 = (float)displaymetrics.widthPixels / displaymetrics.xdpi;
        float f2 = (float)displaymetrics.heightPixels / displaymetrics.ydpi;
        if (Math.sqrt(f2 * f2 + f1 * f1) < 6D)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    static String j()
    {
        return Locale.getDefault().getLanguage();
    }

    static String k()
    {
        return Build.MANUFACTURER;
    }

    static String l()
    {
        return Build.MODEL;
    }

    static String m()
    {
        return "";
    }

    static String n()
    {
        return android.os.Build.VERSION.RELEASE;
    }
}
