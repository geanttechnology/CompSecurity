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
//            fc, fd, ed, ec

class t> extends fc
{

    final fd a;
    final a b;

    public void a()
    {
        a.j();
    }

    imeUnit(imeUnit imeunit, fd fd1)
    {
        b = imeunit;
        a = fd1;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/ed$1

/* anonymous class */
    class ed._cls1 extends ThreadPoolExecutor
    {

        final ed a;

        protected void afterExecute(Runnable runnable, Throwable throwable)
        {
            super.afterExecute(runnable, throwable);
            throwable = ed.a(a, runnable);
            if (throwable == null)
            {
                return;
            }
            synchronized (ed.a(a))
            {
                ed.a(a).remove(throwable);
            }
            ed.a(a, throwable);
            (new ed._cls1._cls2(throwable)).run();
            return;
            throwable;
            runnable;
            JVM INSTR monitorexit ;
            throw throwable;
        }

        protected void beforeExecute(Thread thread, Runnable runnable)
        {
            super.beforeExecute(thread, runnable);
            thread = ed.a(a, runnable);
            if (thread == null)
            {
                return;
            } else
            {
                (new ed._cls1._cls1(this, thread)).run();
                return;
            }
        }

        protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
        {
            ec ec1 = new ec(runnable, obj);
            synchronized (ed.a(a))
            {
                ed.a(a).put((fd)runnable, ec1);
            }
            return ec1;
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
                a = ed1;
                super(i, j, l, timeunit, blockingqueue);
            }

        // Unreferenced inner class com/flurry/sdk/ed$1$2

/* anonymous class */
        class ed._cls1._cls2 extends fc
        {

            final fd a;
            final ed._cls1 b;

            public void a()
            {
                a.k();
            }

                    
                    {
                        b = ed._cls1.this;
                        a = fd1;
                        super();
                    }
        }

    }

}
