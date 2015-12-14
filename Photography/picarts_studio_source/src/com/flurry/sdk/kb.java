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
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.flurry.sdk:
//            jt, li, ka, ls, 
//            kc, lr

public class kb
{

    private static final String a = com/flurry/sdk/kb.getSimpleName();
    private final jt b = new jt();
    private final HashMap c = new HashMap();
    private final HashMap d = new HashMap();
    private final ThreadPoolExecutor e;

    public kb(String s, int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue)
    {
        e = new ThreadPoolExecutor(i, j, l, timeunit, blockingqueue) {

            final kb a;

            protected void afterExecute(Runnable runnable, Throwable throwable)
            {
                super.afterExecute(runnable, throwable);
                throwable = kb.a(a, runnable);
                if (throwable == null)
                {
                    return;
                }
                synchronized (kb.a(a))
                {
                    kb.a(a).remove(throwable);
                }
                kb.a(a, throwable);
                (new lr(this, throwable) {

                    final ls a;
                    final _cls1 b;

                    public void a()
                    {
                        a.p();
                    }

            
            {
                b = _pcls1;
                a = ls1;
                super();
            }
                }).run();
                return;
                throwable;
                runnable;
                JVM INSTR monitorexit ;
                throw throwable;
            }

            protected void beforeExecute(Thread thread, Runnable runnable)
            {
                super.beforeExecute(thread, runnable);
                thread = kb.a(a, runnable);
                if (thread == null)
                {
                    return;
                } else
                {
                    (new lr(this, thread) {

                        final ls a;
                        final _cls1 b;

                        public void a()
                        {
                            a.o();
                        }

            
            {
                b = _pcls1;
                a = ls1;
                super();
            }
                    }).run();
                    return;
                }
            }

            protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
            {
                ka ka1 = new ka(runnable, obj);
                synchronized (kb.a(a))
                {
                    kb.a(a).put((ls)runnable, ka1);
                }
                return ka1;
                runnable;
                obj;
                JVM INSTR monitorexit ;
                throw runnable;
            }

            protected RunnableFuture newTaskFor(Callable callable)
            {
                throw new UnsupportedOperationException("Callable not supported");
            }

            
            {
                a = kb.this;
                super(i, j, l, timeunit, blockingqueue);
            }
        };
        e.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy() {

            final kb a;

            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadpoolexecutor)
            {
                super.rejectedExecution(runnable, threadpoolexecutor);
                threadpoolexecutor = kb.a(a, runnable);
                if (threadpoolexecutor == null)
                {
                    return;
                }
                synchronized (kb.a(a))
                {
                    kb.a(a).remove(threadpoolexecutor);
                }
                kb.a(a, threadpoolexecutor);
                (new lr(this, threadpoolexecutor) {

                    final ls a;
                    final _cls2 b;

                    public void a()
                    {
                        a.q();
                    }

            
            {
                b = _pcls2;
                a = ls1;
                super();
            }
                }).run();
                return;
                threadpoolexecutor;
                runnable;
                JVM INSTR monitorexit ;
                throw threadpoolexecutor;
            }

            
            {
                a = kb.this;
                super();
            }
        });
        s = new li(s, 1);
        e.setThreadFactory(s);
    }

    static ls a(kb kb1, Runnable runnable)
    {
        return kb1.a(runnable);
    }

    private ls a(Runnable runnable)
    {
        if (runnable instanceof ka)
        {
            return (ls)((ka)runnable).a();
        }
        if (runnable instanceof ls)
        {
            return (ls)runnable;
        } else
        {
            kc.a(6, a, (new StringBuilder("Unknown runnable class: ")).append(runnable.getClass().getName()).toString());
            return null;
        }
    }

    static HashMap a(kb kb1)
    {
        return kb1.d;
    }

    static void a(kb kb1, ls ls1)
    {
        kb1.b(ls1);
    }

    private void b(ls ls1)
    {
        this;
        JVM INSTR monitorenter ;
        c(c.get(ls1), ls1);
        this;
        JVM INSTR monitorexit ;
        return;
        ls1;
        throw ls1;
    }

    private void b(Object obj, ls ls1)
    {
        this;
        JVM INSTR monitorenter ;
        b.a(obj, ls1);
        c.put(ls1, obj);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    private void c(Object obj, ls ls1)
    {
        this;
        JVM INSTR monitorenter ;
        b.b(obj, ls1);
        c.remove(ls1);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public void a(ls ls1)
    {
        this;
        JVM INSTR monitorenter ;
        if (ls1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Future future;
        synchronized (d)
        {
            future = (Future)d.remove(ls1);
        }
        b(ls1);
        if (future == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        future.cancel(true);
        (new lr(ls1) {

            final ls a;
            final kb b;

            public void a()
            {
                a.m();
            }

            
            {
                b = kb.this;
                a = ls1;
                super();
            }
        }).run();
        if (true) goto _L1; else goto _L3
_L3:
        ls1;
        throw ls1;
        ls1;
        hashmap;
        JVM INSTR monitorexit ;
        throw ls1;
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
            a((ls)((Iterator) (obj)).next());
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public void a(Object obj, ls ls1)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null && ls1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b(obj, ls1);
        e.submit(ls1);
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

}
