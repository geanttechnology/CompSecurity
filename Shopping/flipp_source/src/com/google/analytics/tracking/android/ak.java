// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            az, ae, i, au, 
//            k, n, ay, ai, 
//            aj, ba, h, ao

public class ak extends az
{

    private static ak h;
    volatile Boolean a;
    ao b;
    private boolean c;
    private h d;
    private Context e;
    private ay f;
    private final Map g;

    private ak(Context context)
    {
        this(context, ((h) (ae.a(context))));
    }

    private ak(Context context, h h1)
    {
        a = Boolean.valueOf(false);
        g = new HashMap();
        if (context == null)
        {
            throw new IllegalArgumentException("context cannot be null");
        } else
        {
            e = context.getApplicationContext();
            d = h1;
            i.a(e);
            au.a(e);
            k.a(e);
            b = new n();
            return;
        }
    }

    static ak a()
    {
        com/google/analytics/tracking/android/ak;
        JVM INSTR monitorenter ;
        ak ak1 = h;
        com/google/analytics/tracking/android/ak;
        JVM INSTR monitorexit ;
        return ak1;
        Exception exception;
        exception;
        com/google/analytics/tracking/android/ak;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static ak a(Context context)
    {
        com/google/analytics/tracking/android/ak;
        JVM INSTR monitorenter ;
        if (h == null)
        {
            h = new ak(context);
        }
        context = h;
        com/google/analytics/tracking/android/ak;
        JVM INSTR monitorexit ;
        return context;
        context;
        com/google/analytics/tracking/android/ak;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final ay a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Tracker name cannot be empty");
        }
        break MISSING_BLOCK_LABEL_24;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        ay ay2 = (ay)g.get(s);
        ay ay1;
        ay1 = ay2;
        if (ay2 != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        ay2 = new ay(s, s1, this);
        g.put(s, ay2);
        ay1 = ay2;
        if (f != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        f = ay2;
        ay1 = ay2;
        if (!TextUtils.isEmpty(s1))
        {
            ai.a().a(aj.k);
            ay1.a.put("&tid", s1);
        }
        ai.a().a(aj.N);
        this;
        JVM INSTR monitorexit ;
        return ay1;
    }

    final void a(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        ba.a(map, "&ul", ba.a(Locale.getDefault()));
        ba.a(map, "&sr", au.a().a("&sr"));
        map.put("&_u", ai.a().c());
        ai.a().b();
        d.a(map);
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        this;
        JVM INSTR monitorexit ;
        throw map;
    }

    public final boolean b()
    {
        ai.a().a(aj.ad);
        return c;
    }
}
