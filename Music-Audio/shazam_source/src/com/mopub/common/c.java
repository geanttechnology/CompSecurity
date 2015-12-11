// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.location.Location;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.mopub.common.d.b;

// Referenced classes of package com.mopub.common:
//            d, f, l, k, 
//            m

public abstract class c extends d
{

    public Context a;
    protected String b;
    protected String c;
    protected Location d;

    public c(Context context)
    {
        a = context;
    }

    private static int f(String s)
    {
        return Math.min(3, s.length());
    }

    public final c a(Location location)
    {
        d = location;
        return this;
    }

    public final c a(String s)
    {
        b = s;
        return this;
    }

    public final void a()
    {
        a("mr", "1");
    }

    public final void a(f f1)
    {
        Object obj;
        Object obj1;
label0:
        {
            a("id", b);
            a("nv", f1.l);
            a(new String[] {
                f1.h, f1.i, f1.j
            });
            obj = f1.n;
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                a("bundle", ((String) (obj)));
            }
            a("q", c);
            Location location = d;
            obj1 = k.a(a, com.mopub.common.l.b(), l.a());
            obj = location;
            if (obj1 == null)
            {
                break label0;
            }
            if (location != null)
            {
                obj = location;
                if (((Location) (obj1)).getTime() < location.getTime())
                {
                    break label0;
                }
            }
            obj = obj1;
        }
        if (obj != null)
        {
            a("ll", (new StringBuilder()).append(((Location) (obj)).getLatitude()).append(",").append(((Location) (obj)).getLongitude()).toString());
            a("lla", String.valueOf((int)((Location) (obj)).getAccuracy()));
            m.a(obj);
            long l1 = ((Location) (obj)).getTime();
            a("llf", String.valueOf((int)(System.currentTimeMillis() - l1)));
            if (obj == obj1)
            {
                a("llsdk", "1");
            }
        }
        a("z", com.mopub.common.d.b.b());
        int i = f1.p.getResources().getConfiguration().orientation;
        obj = "u";
        if (i == 1)
        {
            obj = "p";
        } else
        if (i == 2)
        {
            obj = "l";
        } else
        if (i == 3)
        {
            obj = "s";
        }
        a("o", ((String) (obj)));
        if (m.a.a(f1.p))
        {
            obj = com.mopub.common.d.c.c(f1.p);
        } else
        {
            obj = new Point(0, 0);
        }
        a(((Point) (obj)));
        a("sc_a", String.valueOf(f1.p.getResources().getDisplayMetrics().density));
        obj1 = f1.a;
        if (obj1 == null)
        {
            obj = "";
        } else
        {
            obj = ((String) (obj1)).substring(0, f(((String) (obj1))));
        }
        a("mcc", ((String) (obj)));
        if (obj1 == null)
        {
            obj = "";
        } else
        {
            obj = ((String) (obj1)).substring(f(((String) (obj1))));
        }
        a("mnc", ((String) (obj)));
        a("iso", f1.d);
        a("cn", f1.f);
        a("ct", f1.b().toString());
        e(f1.m);
        b();
    }

    public final c b(String s)
    {
        c = s;
        return this;
    }
}
