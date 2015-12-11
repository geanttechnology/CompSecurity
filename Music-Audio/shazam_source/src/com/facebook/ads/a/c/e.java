// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.ads.a.b.k;
import com.facebook.ads.a.e.a;
import com.facebook.ads.a.f;
import com.facebook.ads.a.f.c;
import com.facebook.ads.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.facebook.ads.a.c:
//            b, f

public final class e
{

    protected String a;
    protected a b;
    protected b c;
    public Context d;
    public f e;
    public boolean f;
    public int g;
    public com.facebook.ads.e h;
    private com.facebook.ads.a.d i;

    public e(Context context, String s, com.facebook.ads.e e1, f f1, com.facebook.ads.a.d d1, int j, boolean flag)
    {
        a = s;
        h = e1;
        e = f1;
        c = com.facebook.ads.a.c.b.a(f1);
        i = d1;
        g = j;
        f = flag;
        d = context;
        com.facebook.ads.a.c.f.a(context);
        if (c == null)
        {
            c = com.facebook.ads.a.c.b.a;
        }
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.facebook.ads.a.c.b.values().length];
                try
                {
                    a[com.facebook.ads.a.c.b.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[b.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.facebook.ads.a.c.b.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.facebook.ads.a.c._cls1.a[c.ordinal()])
        {
        default:
            b = a.a;
            return;

        case 1: // '\001'
            b = a.c;
            return;

        case 2: // '\002'
            b = a.b;
            return;

        case 3: // '\003'
            b = a.d;
            break;
        }
    }

    private static void a(Map map, String s, String s1)
    {
        map.put(s, s1);
    }

    public final String a()
    {
        return a;
    }

    public final b b()
    {
        return c;
    }

    public final Map c()
    {
        HashMap hashmap = new HashMap();
        a(hashmap, "PLACEMENT_ID", a);
        if (b != a.a)
        {
            a(hashmap, "PLACEMENT_TYPE", b.toString().toLowerCase());
        }
        Object obj = d;
        Object obj1 = new HashMap();
        ((Map) (obj1)).put("VIEWABLE", "1");
        ((Map) (obj1)).put("SCHEMA", "json");
        ((Map) (obj1)).put("SDK", "android");
        ((Map) (obj1)).put("SDK_VERSION", "4.7.0");
        ((Map) (obj1)).put("LOCALE", Locale.getDefault().toString());
        float f1 = ((Context) (obj)).getResources().getDisplayMetrics().density;
        int j = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
        int l = ((Context) (obj)).getResources().getDisplayMetrics().heightPixels;
        ((Map) (obj1)).put("DENSITY", String.valueOf(f1));
        ((Map) (obj1)).put("SCREEN_WIDTH", String.valueOf((int)((float)j / f1)));
        ((Map) (obj1)).put("SCREEN_HEIGHT", String.valueOf((int)((float)l / f1)));
        ((Map) (obj1)).put("IDFA", f.n);
        if (f.o)
        {
            obj = "0";
        } else
        {
            obj = "1";
        }
        ((Map) (obj1)).put("IDFA_FLAG", obj);
        ((Map) (obj1)).put("ATTRIBUTION_ID", f.m);
        ((Map) (obj1)).put("OS", "Android");
        ((Map) (obj1)).put("OSVERS", com.facebook.ads.a.c.f.a);
        ((Map) (obj1)).put("BUNDLE", com.facebook.ads.a.c.f.d);
        ((Map) (obj1)).put("APPNAME", f.e);
        ((Map) (obj1)).put("APPVERS", com.facebook.ads.a.c.f.f);
        ((Map) (obj1)).put("APPBUILD", String.valueOf(f.g));
        ((Map) (obj1)).put("CARRIER", f.h);
        ((Map) (obj1)).put("MAKE", f.b);
        ((Map) (obj1)).put("MODEL", com.facebook.ads.a.c.f.c);
        ((Map) (obj1)).put("COPPA", String.valueOf(com.facebook.ads.d.b()));
        ((Map) (obj1)).put("SDK_CAPABILITY", a());
        for (obj = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); a(hashmap, (String)((java.util.Map.Entry) (obj1)).getKey(), (String)((java.util.Map.Entry) (obj1)).getValue()))
        {
            obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        if (h != null)
        {
            a(hashmap, "WIDTH", String.valueOf(h.f));
            a(hashmap, "HEIGHT", String.valueOf(h.g));
        }
        a(hashmap, "ADAPTERS", k.a(b));
        if (e != null)
        {
            a(hashmap, "TEMPLATE_ID", String.valueOf(e.l));
        }
        if (i != null)
        {
            a(hashmap, "REQUEST_TYPE", String.valueOf(i.c));
        }
        if (f)
        {
            a(hashmap, "TEST_MODE", "1");
        }
        if (g != 0)
        {
            a(hashmap, "NUM_ADS_REQUESTED", String.valueOf(g));
        }
        a(hashmap, "CLIENT_EVENTS", com.facebook.ads.a.f.c.a());
        return hashmap;
    }
}
