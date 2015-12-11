// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ja;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            r, g

abstract class af
{

    private static volatile Handler a;
    final r b;
    final Runnable c = new Runnable() {

        final af a;

        public final void run()
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                af.a(a).b().a(this);
            } else
            {
                boolean flag = a.b();
                af.b(a);
                if (flag && !af.c(a))
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
    volatile long d;
    private boolean e;

    af(r r1)
    {
        w.a(r1);
        b = r1;
    }

    static r a(af af1)
    {
        return af1.b;
    }

    static long b(af af1)
    {
        af1.d = 0L;
        return 0L;
    }

    static boolean c(af af1)
    {
        return af1.e;
    }

    public abstract void a();

    public final void a(long l)
    {
        c();
        if (l >= 0L)
        {
            d = b.c.a();
            if (!d().postDelayed(c, l))
            {
                b.a().e("Failed to schedule delayed post. time", Long.valueOf(l));
            }
        }
    }

    public final boolean b()
    {
        return d != 0L;
    }

    public final void c()
    {
        d = 0L;
        d().removeCallbacks(c);
    }

    final Handler d()
    {
        if (a != null)
        {
            return a;
        }
        com/google/android/gms/analytics/internal/af;
        JVM INSTR monitorenter ;
        Handler handler;
        if (a == null)
        {
            a = new Handler(b.a.getMainLooper());
        }
        handler = a;
        com/google/android/gms/analytics/internal/af;
        JVM INSTR monitorexit ;
        return handler;
        Exception exception;
        exception;
        com/google/android/gms/analytics/internal/af;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
