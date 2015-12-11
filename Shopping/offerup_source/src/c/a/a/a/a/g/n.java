// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.g;

import c.a.a.a.a.b.j;
import c.a.a.a.a.b.l;
import c.a.a.a.a.b.r;
import c.a.a.a.a.b.s;
import c.a.a.a.a.b.x;
import c.a.a.a.a.e.a;
import c.a.a.a.e;
import c.a.a.a.q;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package c.a.a.a.a.g:
//            o, t, g, i, 
//            r, u, s, p, 
//            q

public final class n
{

    private final AtomicReference a;
    private final CountDownLatch b;
    private c.a.a.a.a.g.r c;
    private boolean d;

    private n()
    {
        a = new AtomicReference();
        b = new CountDownLatch(1);
        d = false;
    }

    n(byte byte0)
    {
        this();
    }

    public static n a()
    {
        return c.a.a.a.a.g.o.a();
    }

    private void a(c.a.a.a.a.g.s s1)
    {
        a.set(s1);
        b.countDown();
    }

    public final n a(c.a.a.a.n n1, x x1, a a1, String s1, String s2, String s3)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        if (c == null)
        {
            android.content.Context context = n1.getContext();
            String s4 = x1.c();
            String s5 = (new j()).a(context);
            String s6 = x1.h();
            r r1 = new r();
            t t1 = new t();
            g g1 = new g(n1);
            String s7 = l.i(context);
            a1 = new i(n1, s3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[] {
                s4
            }), a1);
            c = new c.a.a.a.a.g.r(n1, new u(s5, x1.a(s5, s4), l.a(new String[] {
                l.k(context)
            }), s2, s1, s.a(s6).a(), s7), r1, t1, g1, a1);
        }
        d = true;
        if (true) goto _L1; else goto _L3
_L3:
        n1;
        throw n1;
    }

    public final Object a(p p1, Object obj)
    {
        c.a.a.a.a.g.s s1 = (c.a.a.a.a.g.s)a.get();
        if (s1 == null)
        {
            return obj;
        } else
        {
            return p1.usingSettings(s1);
        }
    }

    public final c.a.a.a.a.g.s b()
    {
        c.a.a.a.a.g.s s1;
        try
        {
            b.await();
            s1 = (c.a.a.a.a.g.s)a.get();
        }
        catch (InterruptedException interruptedexception)
        {
            e.d().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
        return s1;
    }

    public final boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        c.a.a.a.a.g.s s1;
        s1 = c.a();
        a(s1);
        boolean flag;
        if (s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        c.a.a.a.a.g.s s1;
        s1 = c.a(q.b);
        a(s1);
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        e.d().c("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        boolean flag;
        if (s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }
}
