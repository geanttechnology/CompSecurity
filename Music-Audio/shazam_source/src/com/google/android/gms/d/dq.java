// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.location.Location;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.ads.c.j;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class dq
    implements j
{

    private final Date a;
    private final int b;
    private final Set c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final NativeAdOptionsParcel g;
    private final List h;

    public dq(Date date, int k, Set set, Location location, boolean flag, int l, NativeAdOptionsParcel nativeadoptionsparcel, 
            List list)
    {
        a = date;
        b = k;
        c = set;
        e = location;
        d = flag;
        f = l;
        g = nativeadoptionsparcel;
        h = list;
    }

    public final Date a()
    {
        return a;
    }

    public final int b()
    {
        return b;
    }

    public final Set c()
    {
        return c;
    }

    public final Location d()
    {
        return e;
    }

    public final int e()
    {
        return f;
    }

    public final boolean f()
    {
        return d;
    }

    public final b g()
    {
        if (g == null)
        {
            return null;
        } else
        {
            com.google.android.gms.ads.b.b.a a1 = new com.google.android.gms.ads.b.b.a();
            a1.a = g.b;
            a1.b = g.c;
            a1.c = g.d;
            return new b(a1, (byte)0);
        }
    }

    public final boolean h()
    {
        return h != null && h.contains("2");
    }

    public final boolean i()
    {
        return h != null && h.contains("1");
    }
}
