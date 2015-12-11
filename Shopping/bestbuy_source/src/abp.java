// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class abp
{

    private static final ThreadFactory a;
    private static final ExecutorService b;

    public static Future a(Runnable runnable)
    {
        return a(new Callable(runnable) {

            final Runnable a;

            public Void a()
            {
                a.run();
                return null;
            }

            public Object call()
            {
                return a();
            }

            
            {
                a = runnable;
                super();
            }
        });
    }

    public static Future a(Callable callable)
    {
        try
        {
            callable = b.submit(new Callable(callable) {

                final Callable a;

                public Object call()
                {
                    Object obj;
                    try
                    {
                        Process.setThreadPriority(10);
                        obj = a.call();
                    }
                    catch (Exception exception)
                    {
                        abi.a(exception);
                        return null;
                    }
                    return obj;
                }

            
            {
                a = callable;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            acb.d("Thread execution is rejected.", callable);
            return new abt(null);
        }
        return callable;
    }

    static 
    {
        a = new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AdWorker #").append(a.getAndIncrement()).toString());
            }

        };
        b = Executors.newFixedThreadPool(10, a);
    }
}
