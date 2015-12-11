// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.vn;
import android.support.v7.wf;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            r, g

abstract class af
{

    private static volatile Handler b;
    private final r a;
    private final Runnable c = new Runnable() {

        final af a;

        public void run()
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                af.a(a).h().a(this);
            } else
            {
                boolean flag = a.c();
                af.a(a, 0L);
                if (flag && !af.b(a))
                {
                    a.a();
                    return;
                }
            }
        }

            
            {
                a = af.this;
                super();
            }
    };
    private volatile long d;
    private boolean e;

    af(r r1)
    {
        x.a(r1);
        a = r1;
    }

    static long a(af af1, long l)
    {
        af1.d = l;
        return l;
    }

    static r a(af af1)
    {
        return af1.a;
    }

    static boolean b(af af1)
    {
        return af1.e;
    }

    private Handler e()
    {
        if (b != null)
        {
            return b;
        }
        com/google/android/gms/analytics/internal/af;
        JVM INSTR monitorenter ;
        Handler handler;
        if (b == null)
        {
            b = new Handler(a.b().getMainLooper());
        }
        handler = b;
        com/google/android/gms/analytics/internal/af;
        JVM INSTR monitorexit ;
        return handler;
        Exception exception;
        exception;
        com/google/android/gms/analytics/internal/af;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abstract void a();

    public void a(long l)
    {
        d();
        if (l >= 0L)
        {
            d = a.d().a();
            if (!e().postDelayed(c, l))
            {
                a.f().e("Failed to schedule delayed post. time", Long.valueOf(l));
            }
        }
    }

    public long b()
    {
        if (d == 0L)
        {
            return 0L;
        } else
        {
            return Math.abs(a.d().a() - d);
        }
    }

    public void b(long l)
    {
        long l1 = 0L;
        if (c())
        {
            if (l < 0L)
            {
                d();
                return;
            }
            l -= Math.abs(a.d().a() - d);
            if (l < 0L)
            {
                l = l1;
            }
            e().removeCallbacks(c);
            if (!e().postDelayed(c, l))
            {
                a.f().e("Failed to adjust delayed post. time", Long.valueOf(l));
                return;
            }
        }
    }

    public boolean c()
    {
        return d != 0L;
    }

    public void d()
    {
        d = 0L;
        e().removeCallbacks(c);
    }
}
