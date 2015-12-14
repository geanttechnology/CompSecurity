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
//            ly, lz, kf, ke

class t> extends ly
{

    final lz a;
    final a b;

    public void a()
    {
        a.p();
    }

    imeUnit(imeUnit imeunit, lz lz1)
    {
        b = imeunit;
        a = lz1;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/kf$1

/* anonymous class */
    class kf._cls1 extends ThreadPoolExecutor
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
            (new kf._cls1._cls2(this, throwable)).run();
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
                (new kf._cls1._cls1(thread)).run();
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

            
            {
                a = kf1;
                super(i, j, l, timeunit, blockingqueue);
            }

        // Unreferenced inner class com/flurry/sdk/kf$1$1

/* anonymous class */
        class kf._cls1._cls1 extends ly
        {

            final lz a;
            final kf._cls1 b;

            public void a()
            {
                a.o();
            }

                    
                    {
                        b = kf._cls1.this;
                        a = lz1;
                        super();
                    }
        }

    }

}
