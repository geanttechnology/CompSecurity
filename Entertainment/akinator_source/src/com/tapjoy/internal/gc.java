// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.tapjoy.internal:
//            gg, aa, gb

public final class gc
{

    final gg a;
    final gb b;
    long c;
    private int d;
    private final gt.f.a e = gt.f.k();

    gc(gg gg1, gb gb1)
    {
        d = 1;
        a = gg1;
        b = gb1;
    }

    final gt.c.a a(gt.i i, String s)
    {
        gt.n n = a.b();
        i = gt.c.U().b(gg.a).a(i).a(s);
        if (aa.c())
        {
            i.a(aa.b()).b(System.currentTimeMillis());
        } else
        {
            i.a(System.currentTimeMillis()).c(SystemClock.elapsedRealtime());
        }
        i.a(n.f()).a(n.h()).a(n.j());
        return i;
    }

    final void a(gt.c.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        int i = d;
        d = i + 1;
        a1.a(i);
        if (e.d())
        {
            a1.a(e);
        }
        e.a(a1.f());
        e.a(a1.g());
        if (!a1.i())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        e.b(a1.j());
_L1:
        b.a(a1.e());
        this;
        JVM INSTR monitorexit ;
        return;
        e.f();
          goto _L1
        a1;
        throw a1;
    }

    public final void a(String s, String s1, double d1, String s2, String s3, String s4)
    {
        a.a(s1, d1);
        gt.c.a a1 = a(gt.i.a, "purchase");
        s = gt.r.G().a(s);
        if (s1 != null)
        {
            s.b(s1);
        }
        s.a(d1);
        if (s4 != null)
        {
            s.c(s4);
        }
        if (s2 != null)
        {
            s.d(s2);
        }
        if (s3 != null)
        {
            s.e(s3);
        }
        a1.a(s);
        a(a1);
        a.a(a1.h(), d1);
    }

    final void a(String s, String s1, String s2, String s3, Map map)
    {
        s1 = a(gt.i.c, s1);
        if (s != null)
        {
            s1.d(s);
        }
        if (s2 != null)
        {
            s1.e(s2);
        }
        if (s3 != null)
        {
            s1.f(s3);
        }
        if (map != null)
        {
            for (s = map.entrySet().iterator(); s.hasNext(); s1.a(gt.j.i().a((String)s2.getKey()).a(((Long)s2.getValue()).longValue())))
            {
                s2 = (java.util.Map.Entry)s.next();
            }

        }
        a(((gt.c.a) (s1)));
    }
}
