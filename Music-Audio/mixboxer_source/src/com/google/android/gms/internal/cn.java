// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.internal:
//            ct

public final class cn
{

    private static final ThreadPoolExecutor iA;
    private static final ThreadFactory iz;

    public static void execute(Runnable runnable)
    {
        try
        {
            iA.execute(new Runnable(runnable) {

                final Runnable iB;

                public void run()
                {
                    Process.setThreadPriority(10);
                    iB.run();
                }

            
            {
                iB = runnable;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            ct.b("Too many background threads already running. Aborting task.", runnable);
        }
    }

    static 
    {
        iz = new ThreadFactory() {

            private final AtomicInteger iC = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AdWorker #").append(iC.getAndIncrement()).toString());
            }

        };
        iA = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), iz);
    }
}
