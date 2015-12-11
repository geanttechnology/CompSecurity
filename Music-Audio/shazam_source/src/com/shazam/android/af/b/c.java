// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;

import android.content.Context;
import android.os.Looper;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.i.b.g.b.a;
import com.shazam.model.TrackCategory;

// Referenced classes of package com.shazam.android.af.b:
//            e, j, k, m, 
//            d, h, a, b

public final class c
    implements e, j
{

    private static final TrackCategory b;
    private final Object c = new Object();
    private k d;
    private e e;
    private String f;
    private final Looper g;
    private final b h;
    private final EventAnalytics i = com.shazam.i.b.g.b.a.a();

    public c(Context context)
    {
        d = k.d;
        e = com.shazam.android.af.b.e.a;
        f = "RESTING_ID";
        g = context.getMainLooper();
        h = new m(context.getApplicationContext());
    }

    private void b()
    {
        synchronized (c)
        {
            f = "RESTING_ID";
            d = k.d;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a()
    {
        synchronized (c)
        {
            d.a(d.d);
            b();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(e e1)
    {
        e = e1;
        d.a(this);
    }

    public final void a(h h1)
    {
        synchronized (c)
        {
            if (!f.equals(h1.a))
            {
                f = h1.a;
                d.b();
                d = new com.shazam.android.af.b.a(h1.b, h1.a, g, h, com.shazam.android.af.b.a.b.a, b, i);
                d.a(this);
                d.e();
                d.a(com.shazam.android.af.b.d.a);
            }
        }
        return;
        h1;
        obj;
        JVM INSTR monitorexit ;
        throw h1;
    }

    public final void a(String s, String s1, boolean flag)
    {
        synchronized (c)
        {
            e.a(s, s1, flag);
            if (f.equals(s1))
            {
                b();
            }
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void b(h h1)
    {
        synchronized (c)
        {
            if (f.equals(h1.a))
            {
                a();
            }
        }
        return;
        h1;
        obj;
        JVM INSTR monitorexit ;
        throw h1;
    }

    static 
    {
        b = TrackCategory.MUSIC;
    }
}
