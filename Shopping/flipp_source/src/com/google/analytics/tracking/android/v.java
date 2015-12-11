// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.google.analytics.tracking.android:
//            aw, d, e, ak, 
//            w, z, f, ad, 
//            an, aa, ac, y, 
//            b, h, x, a, 
//            m, s, ab

final class v
    implements aw, d, e
{

    volatile long a;
    volatile int b;
    final Queue c;
    volatile Timer d;
    m e;
    long f;
    private volatile a g;
    private f h;
    private f i;
    private final ak j;
    private final h k;
    private final Context l;
    private volatile int m;
    private volatile Timer n;
    private volatile Timer o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    v(Context context, h h1)
    {
        this(context, h1, ak.a(context));
    }

    private v(Context context, h h1, ak ak1)
    {
        c = new ConcurrentLinkedQueue();
        f = 0x493e0L;
        i = null;
        l = context;
        k = h1;
        j = ak1;
        e = new w(this);
        m = 0;
        b = z.g;
    }

    private static Timer a(Timer timer)
    {
        if (timer != null)
        {
            timer.cancel();
        }
        return null;
    }

    private void j()
    {
        n = a(n);
        o = a(o);
        d = a(d);
    }

    private void k()
    {
        h.b();
        p = false;
    }

    private void l()
    {
        n = a(n);
        n = new Timer("Service Reconnect");
        n.schedule(new ad(this, (byte)0), 5000L);
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        o = a(o);
        m = 0;
        an.c("Connected to service");
        b = z.b;
        if (!r) goto _L2; else goto _L1
_L1:
        i();
        r = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f();
        d = a(d);
        d = new Timer("disconnect check");
        d.schedule(new aa(this, (byte)0), f);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        b = z.e;
        if (m >= 2) goto _L2; else goto _L1
_L1:
        an.d((new StringBuilder("Service unavailable (code=")).append(i1).append("), will retry.").toString());
        l();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        an.d((new StringBuilder("Service unavailable (code=")).append(i1).append("), using local store.").toString());
        g();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(Map map, long l1, String s1, List list)
    {
        an.c("putHit called");
        c.add(new ac(map, l1, s1, list));
        f();
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != z.f) goto _L2; else goto _L1
_L1:
        an.c("Disconnected from service");
        j();
        b = z.g;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        an.c("Unexpected disconnect.");
        b = z.e;
        if (m >= 2)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        l();
          goto _L3
        Exception exception;
        exception;
        throw exception;
        g();
          goto _L3
    }

    public final void c()
    {
        switch (y.a[b - 1])
        {
        default:
            p = true;
            // fall through

        case 2: // '\002'
            return;

        case 1: // '\001'
            k();
            break;
        }
    }

    public final void d()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = s;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        an.c("setForceLocalDispatch called.");
        s = true;
        y.a[b - 1];
        JVM INSTR tableswitch 1 3: default 80
    //                   1 11
    //                   2 60
    //                   3 72;
           goto _L3 _L3 _L4 _L5
_L3:
        if (true) goto _L1; else goto _L6
_L6:
_L4:
        i();
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L5:
        r = true;
          goto _L1
    }

    public final void e()
    {
        if (g != null)
        {
            return;
        } else
        {
            g = new b(l, this, this);
            h();
            return;
        }
    }

    final void f()
    {
        this;
        JVM INSTR monitorenter ;
        if (Thread.currentThread().equals(k.d())) goto _L2; else goto _L1
_L1:
        k.c().add(new x(this));
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!q) goto _L4; else goto _L3
_L3:
        an.c("clearHits called");
        c.clear();
        y.a[b - 1];
        JVM INSTR tableswitch 1 2: default 416
    //                   1 225
    //                   2 242;
           goto _L5 _L6 _L7
_L5:
        q = true;
_L4:
        y.a[b - 1];
        JVM INSTR tableswitch 1 6: default 419
    //                   1 148
    //                   2 273
    //                   3 419
    //                   4 419
    //                   5 419
    //                   6 391;
           goto _L8 _L9 _L10 _L8 _L8 _L8 _L11
_L9:
        ac ac1;
        for (; !c.isEmpty(); h.a(ac1.a, ac1.b, ac1.c, ac1.d))
        {
            ac1 = (ac)c.poll();
            an.c((new StringBuilder("Sending hit to store  ")).append(ac1).toString());
        }

          goto _L12
        Exception exception;
        exception;
        throw exception;
_L6:
        h.a();
        q = false;
          goto _L4
_L7:
        g.a();
        q = false;
          goto _L4
_L12:
        if (!p) goto _L8; else goto _L13
_L13:
        k();
          goto _L8
_L10:
        if (c.isEmpty()) goto _L15; else goto _L14
_L14:
        ac ac2;
        ac2 = (ac)c.peek();
        an.c((new StringBuilder("Sending hit to service   ")).append(ac2).toString());
        if (j.b()) goto _L17; else goto _L16
_L16:
        g.a(ac2.a, ac2.b, ac2.c, ac2.d);
_L18:
        c.poll();
          goto _L10
_L17:
        an.c("Dry run enabled. Hit not actually sent to service.");
          goto _L18
_L15:
        a = e.a();
          goto _L8
_L11:
        an.c("Need to reconnect");
        if (!c.isEmpty())
        {
            h();
        }
          goto _L8
    }

    final void g()
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        int j1;
        i1 = b;
        j1 = z.c;
        if (i1 != j1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        j();
        an.c("falling back to local store");
        if (i == null)
        {
            break; /* Loop/switch isn't completed */
        }
        h = i;
_L4:
        b = z.c;
        f();
        if (true) goto _L1; else goto _L3
        Exception exception;
        exception;
        throw exception;
_L3:
        s s1 = com.google.analytics.tracking.android.s.a();
        s1.a(l, k);
        h = s1.b();
          goto _L4
    }

    final void h()
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        int j1;
        if (s || g == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        i1 = b;
        j1 = z.c;
        if (i1 == j1)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        m = m + 1;
        a(o);
        b = z.a;
        o = new Timer("Failed Connect");
        o.schedule(new ab(this, (byte)0), 3000L);
        an.c("connecting to Analytics service");
        g.b();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        an.d("security exception on connectToService");
        g();
          goto _L1
        obj;
        throw obj;
        an.d("client not initialized.");
        g();
          goto _L1
    }

    final void i()
    {
        this;
        JVM INSTR monitorenter ;
        if (g != null && b == z.b)
        {
            b = z.f;
            g.c();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
