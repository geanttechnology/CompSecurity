// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.d:
//            fs, gm

public static final class y
{

    private int a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private String g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private double m;
    private boolean n;
    private String o;
    private boolean p;
    private boolean q;
    private String r;
    private boolean s;
    private boolean t;
    private String u;
    private String v;
    private float w;
    private int x;
    private int y;

    private static ResolveInfo a(PackageManager packagemanager, String s1)
    {
        return packagemanager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(s1)), 0x10000);
    }

    private static String a(PackageManager packagemanager)
    {
        Object obj = a(packagemanager, "market://details?id=com.google.android.gms.ads");
        if (obj != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((obj = ((ResolveInfo) (obj)).activityInfo) == null) goto _L1; else goto _L3
_L3:
        try
        {
            packagemanager = packagemanager.getPackageInfo(((ActivityInfo) (obj)).packageName, 0);
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            return null;
        }
        if (packagemanager == null) goto _L1; else goto _L4
_L4:
        packagemanager = (new StringBuilder()).append(((PackageInfo) (packagemanager)).versionCode).append(".").append(((ActivityInfo) (obj)).packageName).toString();
        return packagemanager;
    }

    private void a(Context context)
    {
        context = (AudioManager)context.getSystemService("audio");
        a = context.getMode();
        b = context.isMusicActive();
        c = context.isSpeakerphoneOn();
        d = context.getStreamVolume(3);
        e = context.getRingerMode();
        f = context.getStreamVolume(2);
    }

    private void a(Context context, PackageManager packagemanager)
    {
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        g = telephonymanager.getNetworkOperator();
        int i1 = -2;
        com.google.android.gms.ads.internal.p.e();
        if (com.google.android.gms.d.gm.a(packagemanager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
        {
            context = connectivitymanager.getActiveNetworkInfo();
            if (context != null)
            {
                i1 = context.getType();
            } else
            {
                i1 = -1;
            }
        }
        h = i1;
        i = telephonymanager.getNetworkType();
        j = telephonymanager.getPhoneType();
        if (android.os..VERSION.SDK_INT >= 16)
        {
            k = connectivitymanager.isActiveNetworkMetered();
            if (connectivitymanager.getActiveNetworkInfo() != null)
            {
                l = connectivitymanager.getActiveNetworkInfo().getDetailedState().ordinal();
                return;
            } else
            {
                l = -1;
                return;
            }
        } else
        {
            k = false;
            l = -1;
            return;
        }
    }

    private void b(Context context)
    {
        boolean flag = false;
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (context != null)
        {
            int i1 = context.getIntExtra("status", -1);
            int j1 = context.getIntExtra("level", -1);
            int k1 = context.getIntExtra("scale", -1);
            m = (float)j1 / (float)k1;
            if (i1 == 2 || i1 == 5)
            {
                flag = true;
            }
            n = flag;
            return;
        } else
        {
            m = -1D;
            n = false;
            return;
        }
    }

    public final fs a()
    {
        return new fs(a, p, q, g, r, s, t, b, c, u, v, d, h, i, j, e, f, w, x, y, m, n, k, l, o);
    }

    public ger(Context context)
    {
        boolean flag1 = true;
        super();
        PackageManager packagemanager = context.getPackageManager();
        a(context);
        a(context, packagemanager);
        b(context);
        Locale locale = Locale.getDefault();
        boolean flag;
        if (a(packagemanager, "geo:0,0?q=donuts") != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p = flag;
        if (a(packagemanager, "http://www.google.com") != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        q = flag;
        r = locale.getCountry();
        com.google.android.gms.ads.internal.client.m.a();
        s = com.google.android.gms.ads.internal.util.client.a.a();
        t = GooglePlayServicesUtil.zzag(context);
        u = locale.getLanguage();
        v = a(packagemanager);
        context = context.getResources();
        if (context != null)
        {
            if ((context = context.getDisplayMetrics()) != null)
            {
                w = ((DisplayMetrics) (context)).density;
                x = ((DisplayMetrics) (context)).widthPixels;
                y = ((DisplayMetrics) (context)).heightPixels;
                return;
            }
        }
    }

    public ger(Context context, fs fs1)
    {
        PackageManager packagemanager = context.getPackageManager();
        a(context);
        a(context, packagemanager);
        b(context);
        o = Build.FINGERPRINT;
        p = fs1.b;
        q = fs1.c;
        r = fs1.e;
        s = fs1.f;
        t = fs1.g;
        u = fs1.j;
        v = fs1.k;
        w = fs1.r;
        x = fs1.s;
        y = fs1.t;
    }
}
