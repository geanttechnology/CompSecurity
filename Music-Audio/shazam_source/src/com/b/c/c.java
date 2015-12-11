// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.c;

import com.b.a.b;
import com.b.b.a;
import com.b.e.e;
import com.b.e.g;
import com.b.e.l;
import com.b.e.n;
import com.b.e.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.b.c:
//            b, a, e

public final class c
{

    b a;
    protected AtomicLong b;
    protected AtomicInteger c;
    protected AtomicLong d;
    protected AtomicInteger e;
    protected AtomicInteger f;
    protected Object g;
    private a h;

    public c(b b1)
    {
        h = null;
        g = new Object();
        c = new AtomicInteger(0);
        b = new AtomicLong(-1L);
        d = new AtomicLong(-1L);
        e = new AtomicInteger(0);
        f = new AtomicInteger(0);
        a = b1;
    }

    static void a(c c1, com.b.c.b b1)
    {
        (new StringBuilder("sendMeasurmement: ")).append(b1.a(c1.a.al));
        com.b.e.c.a(c1);
        c1.c(b1);
        if (b1 instanceof a) goto _L2; else goto _L1
_L1:
        o o1;
        boolean flag;
        c1.b(b1);
        b1.a(new com.b.c.a("c12", c1.a.t(), Boolean.valueOf(false)));
        if (c1.a.s() != null)
        {
            b1.a(new com.b.c.a("ns_ak", c1.a.s(), Boolean.valueOf(false)));
        }
        c1 = new com.b.d.b(c1.a, b1);
        b1 = ((com.b.d.b) (c1)).b.ab;
        flag = l.a(b1, "android.permission.ACCESS_NETWORK_STATE").booleanValue();
        o1 = ((com.b.d.b) (c1)).b.aj;
        ((com.b.d.b) (c1)).c.a("lastTransmission", String.valueOf(System.currentTimeMillis()));
        com.b.d.c.a[o1.ordinal()];
        JVM INSTR tableswitch 1 5: default 200
    //                   1 201
    //                   2 206
    //                   3 211
    //                   4 236
    //                   5 271;
           goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        return;
_L3:
        c1.b();
        return;
_L4:
        c1.b();
        return;
_L5:
        if (!flag || c1.c().booleanValue())
        {
            c1.a();
            return;
        } else
        {
            c1.b();
            return;
        }
_L6:
        if (!flag || com.b.e.e.b() || com.b.e.e.b(b1) || com.b.e.e.d(b1))
        {
            c1.a();
            return;
        } else
        {
            c1.b();
            return;
        }
_L7:
        if (!flag || com.b.e.e.b() || com.b.e.e.b(b1) || com.b.e.e.f(b1))
        {
            c1.a();
            return;
        } else
        {
            c1.b();
            return;
        }
    }

    public final void a()
    {
        n n1;
        n1 = a.b;
        if (!n1.a("q_dcc").booleanValue() || !n1.a("q_dcf").booleanValue())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        int i = Integer.parseInt(n1.b("q_dcc"), 10);
        long l1 = Long.parseLong(n1.b("q_dcf"), 10);
        if (System.currentTimeMillis() >= l1)
        {
            e.set(i);
            d.set(l1);
        }
_L1:
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        if (g.a)
        {
            com.b.e.c.a(this, "Unexpected error parsing storage data: ");
            com.b.e.c.a(numberformatexception);
            throw numberformatexception;
        }
          goto _L1
    }

    public final boolean a(com.b.c.b b1)
    {
        if (b1 == null)
        {
            return false;
        }
        n n1 = a.b;
        long l1 = System.currentTimeMillis();
        boolean flag;
        if (l1 < b.get())
        {
            c.set(0);
            b.set(l1);
            e.set(0);
            d.set(l1);
            n1.a("q_dcc", Integer.toString(e.get(), 10));
            n1.a("q_dcf", Long.toString(d.get(), 10));
        } else
        {
            if (l1 - b.get() > 1000L)
            {
                c.set(0);
                b.set(l1);
            }
            if (l1 - d.get() > 0x5265c00L)
            {
                e.set(0);
                d.set(l1);
                n1.a("q_dcc", Integer.toString(e.get(), 10));
                n1.a("q_dcf", Long.toString(d.get(), 10));
            }
        }
        if (c.get() < 20 && e.get() < 6000)
        {
            c.incrementAndGet();
            e.getAndIncrement();
            n1.a("q_dcc", Integer.toString(e.get(), 10));
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && a.b != null)
        {
            com.b.e.c.a(this);
            return false;
        } else
        {
            return a.f.a(new com.b.c.e(this, b1), false);
        }
    }

    public final void b(com.b.c.b b1)
    {
        f.getAndIncrement();
        b1.a(new com.b.c.a("ns_ap_ec", String.valueOf(f), Boolean.valueOf(false)));
    }

    public final void c(com.b.c.b b1)
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        if (!(b1 instanceof a))
        {
            break MISSING_BLOCK_LABEL_195;
        }
        obj1 = (a)b1;
        b1 = ((com.b.c.b) (g));
        b1;
        JVM INSTR monitorenter ;
        Object obj2;
        if (h != null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        h = ((a) (obj1));
        obj1 = h;
        obj2 = new ArrayList();
        Iterator iterator1 = ((a) (obj1)).a.values().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            com.b.c.a a2 = (com.b.c.a)iterator1.next();
            if (com.b.b.a.a(a2.b).booleanValue())
            {
                ((ArrayList) (obj2)).add(a2);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_123;
        obj1;
        b1;
        JVM INSTR monitorexit ;
        throw obj1;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
        com.b.c.a a1;
        for (obj2 = ((ArrayList) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((a) (obj1)).a(a1.a, com.b.b.a.a(a1.b, ""), Boolean.valueOf(true)))
        {
            a1 = (com.b.c.a)((Iterator) (obj2)).next();
        }

        break MISSING_BLOCK_LABEL_190;
        h.a(((a) (obj1)).a());
        b1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return;
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        for (Iterator iterator = h.a().iterator(); iterator.hasNext(); b1.a((com.b.c.a)iterator.next())) { }
        h = null;
        obj;
        JVM INSTR monitorexit ;
    }
}
