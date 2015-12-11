// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            hl, ga, fy, gx, 
//            fl, hg

public final class fz
{

    private static final fz a;
    private final int b;
    private final long c;
    private final LinkedList d = new LinkedList();
    private Executor e;
    private final Runnable f = new ga(this);

    private fz(int i, long l)
    {
        e = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), hl.a("OkHttp ConnectionPool", true));
        b = i;
        c = l * 1000L * 1000L;
    }

    public static fz a()
    {
        return a;
    }

    static void a(fz fz1)
    {
        while (fz1.b()) ;
    }

    private boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!d.isEmpty())
        {
            break MISSING_BLOCK_LABEL_16;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        Object obj = new ArrayList();
        int i = 0;
        ListIterator listiterator;
        long l;
        long l1;
        l1 = System.nanoTime();
        l = c;
        listiterator = d.listIterator(d.size());
_L4:
        fy fy1;
        long l3;
        if (!listiterator.hasPrevious())
        {
            break MISSING_BLOCK_LABEL_147;
        }
        fy1 = (fy)listiterator.previous();
        l3 = (fy1.h() + c) - l1;
        if (l3 <= 0L) goto _L2; else goto _L1
_L1:
        if (fy1.d()) goto _L3; else goto _L2
_L2:
        listiterator.remove();
        ((List) (obj)).add(fy1);
          goto _L4
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L3:
        if (!fy1.g()) goto _L4; else goto _L5
_L5:
        l = Math.min(l, l3);
        i++;
          goto _L4
        listiterator = d.listIterator(d.size());
_L6:
        fy fy2;
        do
        {
            if (!listiterator.hasPrevious() || i <= b)
            {
                break MISSING_BLOCK_LABEL_220;
            }
            fy2 = (fy)listiterator.previous();
        } while (!fy2.g());
        ((List) (obj)).add(fy2);
        listiterator.remove();
        i--;
          goto _L6
        boolean flag = ((List) (obj)).isEmpty();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        long l2 = l / 0xf4240L;
        wait(l2, (int)(l - 0xf4240L * l2));
        this;
        JVM INSTR monitorexit ;
        return true;
_L8:
        this;
        JVM INSTR monitorexit ;
        int k = ((List) (obj)).size();
        for (int j = 0; j < k; j++)
        {
            hl.a(((fy)((List) (obj)).get(j)).c());
        }

        return true;
        InterruptedException interruptedexception;
        interruptedexception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void c(fy fy1)
    {
        boolean flag = d.isEmpty();
        d.addFirst(fy1);
        if (flag)
        {
            e.execute(f);
            return;
        } else
        {
            notifyAll();
            return;
        }
    }

    public final fy a(fl fl1)
    {
        this;
        JVM INSTR monitorenter ;
        ListIterator listiterator = d.listIterator(d.size());
_L1:
        fy fy1;
        boolean flag;
        do
        {
            if (!listiterator.hasPrevious())
            {
                break MISSING_BLOCK_LABEL_170;
            }
            fy1 = (fy)listiterator.previous();
        } while (!fy1.b().a.equals(fl1) || !fy1.d() || System.nanoTime() - fy1.h() >= c);
        listiterator.remove();
        flag = fy1.j();
        Object obj;
        obj = fy1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        hg.a().a(fy1.c());
        for (obj = fy1; obj == null; obj = null)
        {
            break MISSING_BLOCK_LABEL_127;
        }

        if (((fy) (obj)).j())
        {
            d.addFirst(obj);
        }
        this;
        JVM INSTR monitorexit ;
        return ((fy) (obj));
        obj;
        hl.a(fy1.c());
        hg.a();
        hg.a((new StringBuilder("Unable to tagSocket(): ")).append(obj).toString());
          goto _L1
        fl1;
        throw fl1;
    }

    final void a(fy fy1)
    {
        while (fy1.j() || !fy1.a()) 
        {
            return;
        }
        if (!fy1.d())
        {
            hl.a(fy1.c());
            return;
        }
        try
        {
            hg.a().b(fy1.c());
        }
        catch (SocketException socketexception)
        {
            hg.a();
            hg.a((new StringBuilder("Unable to untagSocket(): ")).append(socketexception).toString());
            hl.a(fy1.c());
            return;
        }
        this;
        JVM INSTR monitorenter ;
        c(fy1);
        fy1.l();
        fy1.f();
        this;
        JVM INSTR monitorexit ;
        return;
        fy1;
        this;
        JVM INSTR monitorexit ;
        throw fy1;
    }

    final void b(fy fy1)
    {
        if (!fy1.j())
        {
            throw new IllegalArgumentException();
        }
        if (!fy1.d())
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        c(fy1);
        this;
        JVM INSTR monitorexit ;
        return;
        fy1;
        this;
        JVM INSTR monitorexit ;
        throw fy1;
    }

    static 
    {
        String s = System.getProperty("http.keepAlive");
        String s1 = System.getProperty("http.keepAliveDuration");
        String s2 = System.getProperty("http.maxConnections");
        long l;
        if (s1 != null)
        {
            l = Long.parseLong(s1);
        } else
        {
            l = 0x493e0L;
        }
        if (s != null && !Boolean.parseBoolean(s))
        {
            a = new fz(0, l);
        } else
        if (s2 != null)
        {
            a = new fz(Integer.parseInt(s2), l);
        } else
        {
            a = new fz(5, l);
        }
    }
}
