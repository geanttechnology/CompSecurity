// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.b;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.b.c.a;
import com.b.c.b;
import com.b.e.k;
import com.b.e.n;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.b.b:
//            d, b, a

public class c extends b
{

    protected c(com.b.a.b b1, d d1, String s)
    {
        this(b1, d1, s, false, false, true);
    }

    protected c(com.b.a.b b1, d d1, String s, boolean flag, boolean flag1, boolean flag2)
    {
        super(b1);
        b1.o(flag2);
        if (flag2)
        {
            int i = b1.a(flag1);
            long l2 = b1.b(flag);
            long l4 = b1.c(flag1);
            long l5 = b1.d(flag);
            long l6 = b1.e(flag1);
            long l7 = b1.f(flag);
            long l8 = b1.g(flag1);
            long l9 = b1.h(flag1);
            long l10 = b1.i(flag1);
            long l11 = b1.j(flag1);
            long l12 = b1.q();
            int l = b1.k(flag1);
            int j1 = b1.l(flag1);
            int k1 = b1.m(flag1);
            int l1 = b1.n(flag1);
            a(new a("ns_ap_fg", String.valueOf(i), Boolean.valueOf(false)));
            a(new a("ns_ap_ft", String.valueOf(l2), Boolean.valueOf(false)));
            a(new a("ns_ap_dft", String.valueOf(l4), Boolean.valueOf(false)));
            a(new a("ns_ap_bt", String.valueOf(l5), Boolean.valueOf(false)));
            a(new a("ns_ap_dbt", String.valueOf(l6), Boolean.valueOf(false)));
            a(new a("ns_ap_it", String.valueOf(l7), Boolean.valueOf(false)));
            a(new a("ns_ap_dit", String.valueOf(l8), Boolean.valueOf(false)));
            if (l12 >= 60000L)
            {
                a(new a("ns_ap_ut", String.valueOf(l12), Boolean.valueOf(false)));
            }
            a(new a("ns_ap_as", String.valueOf(l), Boolean.valueOf(false)));
            a(new a("ns_ap_das", String.valueOf(l9), Boolean.valueOf(false)));
            if (j1 >= 0)
            {
                a(new a("ns_ap_aus", String.valueOf(j1), Boolean.valueOf(false)));
                a(new a("ns_ap_daus", String.valueOf(l10), Boolean.valueOf(false)));
                a(new a("ns_ap_uc", String.valueOf(l1), Boolean.valueOf(false)));
            }
            if (k1 >= 0)
            {
                a(new a("ns_ap_us", String.valueOf(k1), Boolean.valueOf(false)));
                a(new a("ns_ap_dus", String.valueOf(l11), Boolean.valueOf(false)));
            }
            a(new a("ns_ap_usage", Long.toString(c - b1.v()), Boolean.valueOf(false)));
        }
        if (s != null)
        {
            b(s);
        }
        a(new a("c1", "19", Boolean.valueOf(false)));
        a(new a("ns_ap_an", b1.u(), Boolean.valueOf(false)));
        a(new a("ns_ap_pn", "android", Boolean.valueOf(false)));
        a(new a("c12", b1.t(), Boolean.valueOf(false)));
        if (b1.s() != null)
        {
            a(new a("ns_ak", b1.s(), Boolean.valueOf(false)));
        }
        a(new a("ns_ap_device", Build.DEVICE, Boolean.valueOf(false)));
        Context context;
        Display display;
        int j;
        int i1;
        long l3;
        if (d1 == com.b.b.d.a || d1 == d.c || d1 == com.b.b.d.b)
        {
            s = com.b.d.a.a;
        } else
        {
            s = com.b.d.a.b;
        }
        a(new a("ns_type", s.toString(), Boolean.valueOf(false)));
        a(new a("ns_ts", Long.toString(c), Boolean.valueOf(false)));
        a(new a("ns_nc", "1", Boolean.valueOf(false)));
        a(new a("ns_ap_pfv", android.os.Build.VERSION.RELEASE, Boolean.valueOf(false)));
        a(new a("ns_ap_pfm", "android", Boolean.valueOf(false)));
        a(new a("ns_ap_ev", d1.toString(), Boolean.valueOf(false)));
        context = b1.ab;
        a(new a("ns_ap_ver", b1.o(), Boolean.valueOf(false)));
        s = new Point();
        display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            s = point;
            if (android.os.Build.VERSION.SDK_INT >= 13)
            {
                display.getSize(point);
                s = point;
            }
        } else
        {
            s.x = display.getWidth();
            s.y = display.getHeight();
        }
        j = ((Point) (s)).x;
        i1 = ((Point) (s)).y;
        a(new a("ns_ap_res", (new StringBuilder()).append(Integer.toString(j)).append("x").append(Integer.toString(i1)).toString(), Boolean.valueOf(false)));
        a(new a("ns_ap_lang", Locale.getDefault().getLanguage(), Boolean.valueOf(false)));
        a(new a("ns_ap_sv", "2.1403.17", Boolean.valueOf(false)));
        if (d1.equals(d.f))
        {
            b("ns_ap_oc", String.valueOf(b1.a.a()));
        }
        l3 = b1.m();
        j = b1.n();
        a(new a("ns_ap_id", String.valueOf(l3), Boolean.valueOf(false)));
        a(new a("ns_ap_cs", String.valueOf(j), Boolean.valueOf(false)));
        a(new a("ns_ap_bi", b1.ab.getPackageName(), Boolean.valueOf(false)));
    }

    public static c a(com.b.a.b b1, d d1, HashMap hashmap, String s)
    {
        Object obj;
label0:
        {
            boolean flag2 = true;
            obj = null;
            boolean flag;
            if (d1 == com.b.b.d.a)
            {
                b1.p.getAndIncrement();
                b1.b.a("runs", Long.toString(b1.p.get()));
                obj = new com.b.b.b(b1, d1, s, b1.b());
            } else
            if (d1 == d.d)
            {
                obj = new com.b.b.a(b1, d1, s);
            } else
            if (d1 != d.c)
            {
                boolean flag1;
                if (hashmap == null || hashmap.get("ns_st_ev") != "hb")
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (hashmap == null || !hashmap.containsKey("ns_st_ev"))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                obj = new c(b1, d1, s, false, flag, flag1);
            }
            if (d1 != d.d)
            {
                ((b) (obj)).a(b1.x(), false);
            }
            if (d1 == d.d)
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
            ((c) (obj)).a(hashmap, flag);
            if (!Boolean.valueOf(((b) (obj)).a.containsKey("name")).booleanValue())
            {
                if (b1.x == null)
                {
                    break label0;
                }
                ((c) (obj)).b("name", b1.x);
            }
            return ((c) (obj));
        }
        if (d1 == com.b.b.d.a)
        {
            ((c) (obj)).b("name", "start");
            return ((c) (obj));
        }
        if (b1.i() == com.b.a.a.c)
        {
            ((c) (obj)).b("name", "foreground");
            return ((c) (obj));
        } else
        {
            ((c) (obj)).b("name", "background");
            return ((c) (obj));
        }
    }
}
