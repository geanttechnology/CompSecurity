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
//            da

public final class cu
{

    private static final ThreadFactory pK;
    private static final ThreadPoolExecutor pL;

    public static void execute(Runnable runnable)
    {
        try
        {
            pL.execute(new Runnable(runnable) {

                final Runnable pM;

                public void run()
                {
                    Process.setThreadPriority(10);
                    pM.run();
                }

            
            {
                pM = runnable;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            da.b("Too many background threads already running. Aborting task.", runnable);
        }
    }

    static 
    {
        pK = new ThreadFactory() {

            private final AtomicInteger pN = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AdWorker #").append(pN.getAndIncrement()).toString());
            }

        };
        pL = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), pK);
    }
}
