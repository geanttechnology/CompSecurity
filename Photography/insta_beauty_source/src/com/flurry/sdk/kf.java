// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.flurry.sdk:
//            jx, lm, ke, lz, 
//            kg

public class kf
{

    private static final String a = com/flurry/sdk/kf.getSimpleName();
    private final jx b = new jx();
    private final HashMap c = new HashMap();
    private final HashMap d = new HashMap();
    private final ThreadPoolExecutor e;

    public kf(String s, int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue)
    {
        e = new _cls1(i, j, l, timeunit, blockingqueue);
        e.setRejectedExecutionHandler(new _cls2());
        s = new lm(s, 1);
        e.setThreadFactory(s);
    }

    static lz a(kf kf1, Runnable runnable)
    {
        return kf1.a(runnable);
    }

    private lz a(Runnable runnable)
    {
        if (runnable instanceof ke)
        {
            return (lz)((ke)runnable).a();
        }
        if (runnable instanceof lz)
        {
            return (lz)runnable;
        } else
        {
            kg.a(6, a, (new StringBuilder()).append("Unknown runnable class: ").append(runnable.getClass().getName()).toString());
            return null;
        }
    }

    static HashMap a(kf kf1)
    {
        return kf1.d;
    }

    static void a(kf kf1, lz lz1)
    {
        kf1.b(lz1);
    }

    private void b(lz lz1)
    {
        this;
        JVM INSTR monitorenter ;
        c(c.get(lz1), lz1);
        this;
        JVM INSTR monitorexit ;
        return;
        lz1;
        throw lz1;
    }

    private void b(Object obj, lz lz1)
    {
        this;
        JVM INSTR monitorenter ;
        b.a(obj, lz1);
        c.put(lz1, obj);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    private void c(Object obj, lz lz1)
    {
        this;
        JVM INSTR monitorenter ;
        b.b(obj, lz1);
        c.remove(lz1);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public void a(lz lz1)
    {
        this;
        JVM INSTR monitorenter ;
        if (lz1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Future future;
        synchronized (d)
        {
            future = (Future)d.remove(lz1);
        }
        b(lz1);
        if (future == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        future.cancel(true);
        (new _cls3(lz1)).run();
        if (true) goto _L1; else goto _L3
_L3:
        lz1;
        throw lz1;
        lz1;
        hashmap;
        JVM INSTR monitorexit ;
        throw lz1;
    }

    public void a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        HashSet hashset = new HashSet();
        hashset.addAll(b.a(obj));
        obj = hashset.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            a((lz)((Iterator) (obj)).next());
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public void a(Object obj, lz lz1)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null && lz1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b(obj, lz1);
        e.submit(lz1);
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public long b(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null) goto _L2; else goto _L1
_L1:
        long l = 0L;
_L4:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        int i = b.a(obj).size();
        l = i;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = new HashSet();
        ((Set) (obj)).addAll(b.c());
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a(((Iterator) (obj)).next())) { }
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }


    private class _cls1 extends ThreadPoolExecutor
    {

        final kf a;

        protected void afterExecute(Runnable runnable, Throwable throwable)
        {
            super.afterExecute(runnable, throwable);
            throwable = kf.a(a, runnable);
            if (throwable == null)
            {
                return;
            }
            synchronized (kf.a(a))
            {
                kf.a(a).remove(throwable);
            }
            kf.a(a, throwable);
            class _cls2 extends ly
            {

                final lz a;
                final _cls1 b;

                public void a()
                {
                    a.p();
                }

                _cls2(lz lz1)
                {
                    b = _cls1.this;
                    a = lz1;
                    super();
                }
            }

            (new _cls2(throwable)).run();
            return;
            throwable;
            runnable;
            JVM INSTR monitorexit ;
            throw throwable;
        }

        protected void beforeExecute(Thread thread, Runnable runnable)
        {
            super.beforeExecute(thread, runnable);
            thread = kf.a(a, runnable);
            if (thread == null)
            {
                return;
            } else
            {
                class _cls1 extends ly
                {

                    final lz a;
                    final _cls1 b;

                    public void a()
                    {
                        a.o();
                    }

                _cls1(lz lz1)
                {
                    b = _cls1.this;
                    a = lz1;
                    super();
                }
                }

                (new _cls1(thread)).run();
                return;
            }
        }

        protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
        {
            ke ke1 = new ke(runnable, obj);
            synchronized (kf.a(a))
            {
                kf.a(a).put((lz)runnable, ke1);
            }
            return ke1;
            runnable;
            obj;
            JVM INSTR monitorexit ;
            throw runnable;
        }

        protected RunnableFuture newTaskFor(Callable callable)
        {
            throw new UnsupportedOperationException("Callable not supported");
        }

        _cls1(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue)
        {
            a = kf.this;
            super(i, j, l, timeunit, blockingqueue);
        }
    }


    private class _cls2 extends java.util.concurrent.ThreadPoolExecutor.DiscardPolicy
    {

        final kf a;

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadpoolexecutor)
        {
            super.rejectedExecution(runnable, threadpoolexecutor);
            threadpoolexecutor = kf.a(a, runnable);
            if (threadpoolexecutor == null)
            {
                return;
            }
            synchronized (kf.a(a))
            {
                kf.a(a).remove(threadpoolexecutor);
            }
            kf.a(a, threadpoolexecutor);
            class _cls1 extends ly
            {

                final lz a;
                final _cls2 b;

                public void a()
                {
                    a.q();
                }

                _cls1(lz lz1)
                {
                    b = _cls2.this;
                    a = lz1;
                    super();
                }
            }

            (new _cls1(threadpoolexecutor)).run();
            return;
            threadpoolexecutor;
            runnable;
            JVM INSTR monitorexit ;
            throw threadpoolexecutor;
        }

        _cls2()
        {
            a = kf.this;
            super();
        }
    }


    private class _cls3 extends ly
    {

        final lz a;
        final kf b;

        public void a()
        {
            a.m();
        }

        _cls3(lz lz1)
        {
            b = kf.this;
            a = lz1;
            super();
        }
    }

}
