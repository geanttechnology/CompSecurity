// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import com.c.a.a.a.b;
import com.c.a.b.e.a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.c.a.b:
//            g, a, k, l

class i
{

    final g a;
    private Executor b;
    private Executor c;
    private ExecutorService d;
    private final Map e = Collections.synchronizedMap(new HashMap());
    private final Map f = new WeakHashMap();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);

    i(g g1)
    {
        a = g1;
        b = g1.i;
        c = g1.j;
        d = Executors.newCachedThreadPool();
    }

    static void a(i j)
    {
        j.d();
    }

    static Executor b(i j)
    {
        return j.c;
    }

    static Executor c(i j)
    {
        return j.b;
    }

    private void d()
    {
        if (!a.k && ((ExecutorService)b).isShutdown())
        {
            b = e();
        }
        if (!a.l && ((ExecutorService)c).isShutdown())
        {
            c = e();
        }
    }

    private Executor e()
    {
        return com.c.a.b.a.a(a.m, a.n, a.o);
    }

    String a(a a1)
    {
        return (String)e.get(Integer.valueOf(a1.f()));
    }

    AtomicBoolean a()
    {
        return g;
    }

    ReentrantLock a(String s)
    {
        ReentrantLock reentrantlock1 = (ReentrantLock)f.get(s);
        ReentrantLock reentrantlock = reentrantlock1;
        if (reentrantlock1 == null)
        {
            reentrantlock = new ReentrantLock();
            f.put(s, reentrantlock);
        }
        return reentrantlock;
    }

    void a(a a1, String s)
    {
        e.put(Integer.valueOf(a1.f()), s);
    }

    void a(k k)
    {
        d.execute(new Runnable(k) {

            final k a;
            final i b;

            public void run()
            {
                boolean flag = b.a.q.a(a.a()).exists();
                com.c.a.b.i.a(b);
                if (flag)
                {
                    com.c.a.b.i.b(b).execute(a);
                    return;
                } else
                {
                    i.c(b).execute(a);
                    return;
                }
            }

            
            {
                b = i.this;
                a = k1;
                super();
            }
        });
    }

    void a(l l)
    {
        d();
        c.execute(l);
    }

    void b(a a1)
    {
        e.remove(Integer.valueOf(a1.f()));
    }

    boolean b()
    {
        return h.get();
    }

    boolean c()
    {
        return i.get();
    }
}
