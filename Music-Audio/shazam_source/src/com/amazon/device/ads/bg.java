// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            cm, co, cn, dq, 
//            dz, dt, cd, do

class bg
{

    private static final String l = com/amazon/device/ads/bg.getSimpleName();
    String a;
    String b;
    String c;
    dt d;
    String e;
    boolean f;
    float g;
    String h;
    do i;
    do j;
    final cm k;
    private String m;
    private boolean n;
    private boolean o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private String t;
    private boolean u;
    private String v;
    private String w;
    private String x;
    private final cn y;

    public bg(Context context, dt dt1)
    {
        cm cm1 = cm.a();
        new co();
        this(context, dt1, cm1);
    }

    private bg(Context context, dt dt1, cm cm1)
    {
        Object obj = null;
        super();
        a = Build.MANUFACTURER;
        b = Build.MODEL;
        c = android.os.Build.VERSION.RELEASE;
        y = co.a(l);
        k = cm1;
        cm1 = Locale.getDefault().getCountry();
        if (cm1 == null || cm1.length() <= 0)
        {
            cm1 = null;
        }
        w = cm1;
        cm1 = (TelephonyManager)context.getSystemService("phone");
        if (cm1 != null)
        {
            cm1 = cm1.getNetworkOperatorName();
            String s1;
            if (cm1 == null || cm1.length() <= 0)
            {
                cm1 = null;
            }
            h = cm1;
        }
        s1 = Locale.getDefault().getLanguage();
        cm1 = obj;
        if (s1 != null)
        {
            cm1 = obj;
            if (s1.length() > 0)
            {
                cm1 = s1;
            }
        }
        x = cm1;
        if (a.equals("motorola") && b.equals("MB502"))
        {
            g = 1.0F;
        } else
        {
            context = (WindowManager)context.getSystemService("window");
            cm1 = new DisplayMetrics();
            context.getDefaultDisplay().getMetrics(cm1);
            g = ((DisplayMetrics) (cm1)).scaledDensity;
        }
        v = Float.toString(g);
        d = dt1;
    }

    public static String b()
    {
        return "android";
    }

    public static String c()
    {
        return "Android";
    }

    private void k()
    {
        if (o) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (WifiManager)k.b().getSystemService("wifi");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        obj = ((WifiManager) (obj)).getConnectionInfo();
_L3:
        if (obj == null)
        {
            m = null;
        } else
        {
            obj = ((WifiInfo) (obj)).getMacAddress();
            if (obj == null || ((String) (obj)).length() == 0)
            {
                m = null;
                n = true;
            } else
            if (!Pattern.compile("((([0-9a-fA-F]){1,2}[-:]){5}([0-9a-fA-F]){1,2})").matcher(((CharSequence) (obj))).find())
            {
                m = null;
                n = true;
            } else
            {
                m = dz.a(dq.c(((String) (obj))));
            }
        }
        o = true;
_L2:
        return;
        obj;
        y.b("Unable to get Wifi connection information: %s", new Object[] {
            obj
        });
        obj = null;
          goto _L3
        obj;
        y.b("Unable to get Wifi connection information: %s", new Object[] {
            obj
        });
        obj = null;
          goto _L3
    }

    private void l()
    {
        if (!r)
        {
            Object obj;
            try
            {
                obj = (String)android/os/Build.getDeclaredField("SERIAL").get(android/os/Build);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = null;
            }
            if (obj == null || ((String) (obj)).length() == 0 || ((String) (obj)).equalsIgnoreCase("unknown"))
            {
                q = true;
            } else
            {
                p = dz.a(dq.c(((String) (obj))));
            }
            r = true;
        }
    }

    final void a()
    {
        if (!u)
        {
            String s1 = android.provider.Settings.Secure.getString(k.b().getContentResolver(), "android_id");
            if (dq.a(s1) || s1.equalsIgnoreCase("9774d56d682e549c"))
            {
                s = null;
                t = null;
                f = true;
            } else
            {
                s = dz.a(s1);
                t = dz.a(dq.c(s1));
            }
            u = true;
        }
    }

    public final String d()
    {
        k();
        return m;
    }

    public final boolean e()
    {
        k();
        return n;
    }

    public final String f()
    {
        l();
        return p;
    }

    public final boolean g()
    {
        l();
        return q;
    }

    public final String h()
    {
        a();
        return t;
    }

    public final String i()
    {
        return d.a();
    }

    public final JSONObject j()
    {
        JSONObject jsonobject = new JSONObject();
        cd.b(jsonobject, "make", a);
        cd.b(jsonobject, "model", b);
        cd.b(jsonobject, "os", "Android");
        cd.b(jsonobject, "osVersion", c);
        cd.b(jsonobject, "scalingFactor", v);
        cd.b(jsonobject, "language", x);
        cd.b(jsonobject, "country", w);
        cd.b(jsonobject, "carrier", h);
        return jsonobject;
    }

}
