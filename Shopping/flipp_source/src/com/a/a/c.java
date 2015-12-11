// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.m;
import com.a.a.a.u;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.a.a:
//            d, b, v, a

public final class c
{

    private static final c d;
    public final LinkedList a = new LinkedList();
    public final ExecutorService b;
    public final Callable c = new d(this);
    private final int e;
    private final long f;

    private c(int i, long l)
    {
        b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), u.b("OkHttp ConnectionPool"));
        e = i;
        f = l * 1000L * 1000L;
    }

    public static c a()
    {
        return d;
    }

    static LinkedList a(c c1)
    {
        return c1.a;
    }

    static long b(c c1)
    {
        return c1.f;
    }

    static int c(c c1)
    {
        return c1.e;
    }

    public final b a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        ListIterator listiterator = a.listIterator(a.size());
_L1:
        b b1;
        boolean flag;
        do
        {
            if (!listiterator.hasPrevious())
            {
                break MISSING_BLOCK_LABEL_183;
            }
            b1 = (b)listiterator.previous();
        } while (!b1.d.a.equals(a1) || !b1.a() || System.nanoTime() - b1.d() >= f);
        listiterator.remove();
        flag = b1.e();
        Object obj;
        obj = b1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        m.a();
        obj = b1.e;
        m.c();
        for (obj = b1; obj == null; obj = null)
        {
            break MISSING_BLOCK_LABEL_129;
        }

        if (((b) (obj)).e())
        {
            a.addFirst(obj);
        }
        b.submit(c);
        this;
        JVM INSTR monitorexit ;
        return ((b) (obj));
        obj;
        u.a(b1);
        m.a();
        m.a((new StringBuilder("Unable to tagSocket(): ")).append(obj).toString());
          goto _L1
        a1;
        throw a1;
    }

    public final void a(b b1)
    {
        if (b1.e())
        {
            return;
        }
        if (!b1.a())
        {
            u.a(b1);
            return;
        }
        try
        {
            m.a();
            java.net.Socket socket = b1.e;
            m.d();
        }
        catch (SocketException socketexception)
        {
            m.a();
            m.a((new StringBuilder("Unable to untagSocket(): ")).append(socketexception).toString());
            u.a(b1);
            return;
        }
        this;
        JVM INSTR monitorenter ;
        a.addFirst(b1);
        if (b1.i != null)
        {
            throw new IllegalStateException("spdyConnection != null");
        }
        break MISSING_BLOCK_LABEL_93;
        b1;
        this;
        JVM INSTR monitorexit ;
        throw b1;
        b1.k = System.nanoTime();
        this;
        JVM INSTR monitorexit ;
        b.submit(c);
        return;
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
            d = new c(0, l);
        } else
        if (s2 != null)
        {
            d = new c(Integer.parseInt(s2), l);
        } else
        {
            d = new c(5, l);
        }
    }
}
