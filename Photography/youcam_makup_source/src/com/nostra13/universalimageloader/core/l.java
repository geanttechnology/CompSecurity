// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.c.a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            h, a, LoadAndDisplayImageTask, n

class l
{

    final h a;
    private Executor b;
    private Executor c;
    private Executor d;
    private final Map e = Collections.synchronizedMap(new HashMap());
    private final Map f = new WeakHashMap();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final Object j = new Object();

    l(h h1)
    {
        a = h1;
        b = h1.g;
        c = h1.h;
        d = com.nostra13.universalimageloader.core.a.a();
    }

    static void a(l l1)
    {
        l1.f();
    }

    static Executor b(l l1)
    {
        return l1.c;
    }

    static Executor c(l l1)
    {
        return l1.b;
    }

    private void f()
    {
        if (!a.i && ((ExecutorService)b).isShutdown())
        {
            b = g();
        }
        if (!a.j && ((ExecutorService)c).isShutdown())
        {
            c = g();
        }
    }

    private Executor g()
    {
        return com.nostra13.universalimageloader.core.a.a(a.k, a.l, a.m);
    }

    String a(a a1)
    {
        return (String)e.get(Integer.valueOf(a1.f()));
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

    void a()
    {
        if (!a.i)
        {
            ((ExecutorService)b).shutdownNow();
        }
        if (!a.j)
        {
            ((ExecutorService)c).shutdownNow();
        }
        e.clear();
        f.clear();
    }

    void a(LoadAndDisplayImageTask loadanddisplayimagetask)
    {
        d.execute(new Runnable(loadanddisplayimagetask) {

            final LoadAndDisplayImageTask a;
            final l b;

            public void run()
            {
                File file = b.a.o.a(a.a());
                boolean flag;
                if (file != null && file.exists())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.nostra13.universalimageloader.core.l.a(b);
                if (flag)
                {
                    l.b(b).execute(a);
                    return;
                } else
                {
                    l.c(b).execute(a);
                    return;
                }
            }

            
            {
                b = l.this;
                a = loadanddisplayimagetask;
                super();
            }
        });
    }

    void a(a a1, String s)
    {
        e.put(Integer.valueOf(a1.f()), s);
    }

    void a(n n)
    {
        f();
        c.execute(n);
    }

    void a(Runnable runnable)
    {
        d.execute(runnable);
    }

    AtomicBoolean b()
    {
        return g;
    }

    void b(a a1)
    {
        e.remove(Integer.valueOf(a1.f()));
    }

    Object c()
    {
        return j;
    }

    boolean d()
    {
        return h.get();
    }

    boolean e()
    {
        return i.get();
    }
}
