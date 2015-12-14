// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.flurry.sdk:
//            lr, ls, kb, ka

class t> extends lr
{

    final ls a;
    final a b;

    public void a()
    {
        a.o();
    }

    imeUnit(imeUnit imeunit, ls ls1)
    {
        b = imeunit;
        a = ls1;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/kb$1

/* anonymous class */
    class kb._cls1 extends ThreadPoolExecutor
    {

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
            (new kb._cls1._cls2(throwable)).run();
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
                (new kb._cls1._cls1(this, thread)).run();
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
                a = kb1;
                super(i, j, l, timeunit, blockingqueue);
            }

        // Unreferenced inner class com/flurry/sdk/kb$1$2

/* anonymous class */
        class kb._cls1._cls2 extends lr
        {

            final ls a;
            final kb._cls1 b;

            public void a()
            {
                a.p();
            }

                    
                    {
                        b = kb._cls1.this;
                        a = ls1;
                        super();
                    }
        }

    }

}
