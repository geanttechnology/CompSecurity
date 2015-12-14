// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            kc, js, kg, lt, 
//            jl, kr, jz, kb, 
//            ly, jk, ka

public abstract class ks
{

    private static final String a = com/flurry/sdk/ks.getSimpleName();
    private static long b = 10000L;
    private final int c = 0x7fffffff;
    private final jz d = a();
    private final List e = new ArrayList();
    private boolean f;
    private int g;
    private long h;
    private final Runnable i = new ly() {

        final ks a;

        public void a()
        {
            ks.a(a);
        }

            
            {
                a = ks.this;
                super();
            }
    };
    private final kb j = new kb() {

        final ks a;

        public void a(jk jk1)
        {
            if (jk1.a)
            {
                ks.a(a);
            }
        }

        public volatile void a(ka ka)
        {
            a((jk)ka);
        }

            
            {
                a = ks.this;
                super();
            }
    };

    public ks()
    {
        kc.a().a("com.flurry.android.sdk.NetworkStateEvent", j);
        h = b;
        g = -1;
        js.a().b(new ly() {

            final ks a;

            public void a()
            {
                a.b(ks.b(a));
                ks.a(a);
            }

            
            {
                a = ks.this;
                super();
            }
        });
    }

    static void a(ks ks1)
    {
        ks1.b();
    }

    static List b(ks ks1)
    {
        return ks1.e;
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (g < 0)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        kg.a(3, a, "Transmit is in progress");
          goto _L1
        Exception exception;
        exception;
        throw exception;
label0:
        {
            h();
            if (!e.isEmpty())
            {
                break label0;
            }
            h = b;
            g = -1;
        }
          goto _L1
        g = 0;
        js.a().b(new ly() {

            final ks a;

            public void a()
            {
                ks.c(a);
            }

            
            {
                a = ks.this;
                super();
            }
        });
          goto _L1
    }

    static void c(ks ks1)
    {
        ks1.f();
    }

    private void f()
    {
        this;
        JVM INSTR monitorenter ;
        lt.b();
        if (!jl.a().c()) goto _L2; else goto _L1
_L1:
        if (g >= e.size()) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = e;
        int k = g;
        g = k + 1;
        obj = (kr)((List) (obj)).get(k);
        if (((kr) (obj)).q()) goto _L1; else goto _L5
_L5:
        if (obj != null) goto _L7; else goto _L6
_L6:
        g();
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kg.a(3, a, "Network is not available, aborting transmission");
        break; /* Loop/switch isn't completed */
_L7:
        a(((kr) (obj)));
        if (true) goto _L8; else goto _L4
        obj;
        throw obj;
_L4:
        obj = null;
        if (true) goto _L5; else goto _L9
_L9:
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        h();
        a(e);
        if (!f) goto _L2; else goto _L1
_L1:
        kg.a(3, a, "Reporter paused");
        h = b;
_L3:
        g = -1;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!e.isEmpty())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        kg.a(3, a, "All reports sent successfully");
        h = b;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        h = h << 1;
        kg.a(3, a, (new StringBuilder()).append("One or more reports failed to send, backing off: ").append(h).append("ms").toString());
        js.a().b(i, h);
          goto _L3
    }

    private void h()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = e.iterator();
_L3:
        kr kr1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_222;
        }
        kr1 = (kr)((Iterator) (obj)).next();
        if (!kr1.q()) goto _L2; else goto _L1
_L1:
        kg.a(3, a, (new StringBuilder()).append("Url transmitted - ").append(kr1.s()).append(" Attempts: ").append(kr1.r()).toString());
        ((Iterator) (obj)).remove();
          goto _L3
        obj;
        throw obj;
_L2:
        if (kr1.r() <= kr1.d()) goto _L5; else goto _L4
_L4:
        kg.a(3, a, (new StringBuilder()).append("Exceeded max no of attempts - ").append(kr1.s()).append(" Attempts: ").append(kr1.r()).toString());
        ((Iterator) (obj)).remove();
          goto _L3
_L5:
        if (System.currentTimeMillis() <= kr1.p() || kr1.r() <= 0) goto _L3; else goto _L6
_L6:
        kg.a(3, a, (new StringBuilder()).append("Expired: Time expired - ").append(kr1.s()).append(" Attempts: ").append(kr1.r()).toString());
        ((Iterator) (obj)).remove();
          goto _L3
        this;
        JVM INSTR monitorexit ;
    }

    private void i()
    {
        kc.a().b("com.flurry.android.sdk.NetworkStateEvent", j);
    }

    protected abstract jz a();

    public void a(long l)
    {
        b = l;
        h = b;
    }

    protected abstract void a(kr kr1);

    protected void a(List list)
    {
        this;
        JVM INSTR monitorenter ;
        lt.b();
        list = new ArrayList(list);
        d.a(list);
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    public void b(kr kr1)
    {
        this;
        JVM INSTR monitorenter ;
        if (kr1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        e.add(kr1);
        js.a().b(new ly() {

            final ks a;

            public void a()
            {
                ks.a(a);
            }

            
            {
                a = ks.this;
                super();
            }
        });
        if (true) goto _L1; else goto _L3
_L3:
        kr1;
        throw kr1;
    }

    protected void b(List list)
    {
        this;
        JVM INSTR monitorenter ;
        List list1;
        lt.b();
        list1 = (List)d.a();
        if (list1 == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        list.addAll(list1);
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    public void c()
    {
        js.a().c(i);
        i();
    }

    protected void c(kr kr1)
    {
        this;
        JVM INSTR monitorenter ;
        kr1.b(true);
        js.a().b(new ly() {

            final ks a;

            public void a()
            {
                ks.c(a);
            }

            
            {
                a = ks.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        kr1;
        throw kr1;
    }

    public void d()
    {
        f = true;
    }

    protected void d(kr kr1)
    {
        this;
        JVM INSTR monitorenter ;
        kr1.a_();
        js.a().b(new ly() {

            final ks a;

            public void a()
            {
                ks.c(a);
            }

            
            {
                a = ks.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        kr1;
        throw kr1;
    }

    public void e()
    {
        f = false;
        js.a().b(new ly() {

            final ks a;

            public void a()
            {
                ks.a(a);
            }

            
            {
                a = ks.this;
                super();
            }
        });
    }

}
