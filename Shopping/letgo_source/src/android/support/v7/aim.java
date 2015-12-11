// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package android.support.v7:
//            ail, aih, ajk, aio, 
//            aip, aht

class aim
{

    final ail a;
    private Executor b;
    private Executor c;
    private Executor d;
    private final Map e = Collections.synchronizedMap(new HashMap());
    private final Map f = new WeakHashMap();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final Object j = new Object();

    aim(ail ail1)
    {
        a = ail1;
        b = ail1.g;
        c = ail1.h;
        d = aih.a();
    }

    static void a(aim aim1)
    {
        aim1.e();
    }

    static Executor b(aim aim1)
    {
        return aim1.c;
    }

    static Executor c(aim aim1)
    {
        return aim1.b;
    }

    private void e()
    {
        if (!a.i && ((ExecutorService)b).isShutdown())
        {
            b = f();
        }
        if (!a.j && ((ExecutorService)c).isShutdown())
        {
            c = f();
        }
    }

    private Executor f()
    {
        return aih.a(a.k, a.l, a.m);
    }

    String a(ajk ajk1)
    {
        return (String)e.get(Integer.valueOf(ajk1.f()));
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

    void a(aio aio)
    {
        d.execute(new Runnable(aio) {

            final aio a;
            final aim b;

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
                aim.a(b);
                if (flag)
                {
                    aim.b(b).execute(a);
                    return;
                } else
                {
                    aim.c(b).execute(a);
                    return;
                }
            }

            
            {
                b = aim.this;
                a = aio1;
                super();
            }
        });
    }

    void a(aip aip)
    {
        e();
        c.execute(aip);
    }

    void a(ajk ajk1, String s)
    {
        e.put(Integer.valueOf(ajk1.f()), s);
    }

    void a(Runnable runnable)
    {
        d.execute(runnable);
    }

    Object b()
    {
        return j;
    }

    void b(ajk ajk1)
    {
        e.remove(Integer.valueOf(ajk1.f()));
    }

    boolean c()
    {
        return h.get();
    }

    boolean d()
    {
        return i.get();
    }
}
