// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Process;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.support.v7:
//            ua, ud, tg

public final class to
{

    private static final ExecutorService a = Executors.newFixedThreadPool(10, a("Default"));
    private static final ExecutorService b = Executors.newFixedThreadPool(5, a("Loader"));

    public static ud a(int i, Runnable runnable)
    {
        if (i == 1)
        {
            return a(b, new Callable(runnable) {

                final Runnable a;

                public Void a()
                {
                    a.run();
                    return null;
                }

                public Object call()
                    throws Exception
                {
                    return a();
                }

            
            {
                a = runnable;
                super();
            }
            });
        } else
        {
            return a(a, new Callable(runnable) {

                final Runnable a;

                public Void a()
                {
                    a.run();
                    return null;
                }

                public Object call()
                    throws Exception
                {
                    return a();
                }

            
            {
                a = runnable;
                super();
            }
            });
        }
    }

    public static ud a(Runnable runnable)
    {
        return a(0, runnable);
    }

    public static ud a(Callable callable)
    {
        return a(a, callable);
    }

    public static ud a(ExecutorService executorservice, Callable callable)
    {
        ua ua1 = new ua();
        try
        {
            executorservice.submit(new Runnable(ua1, callable) {

                final ua a;
                final Callable b;

                public void run()
                {
                    try
                    {
                        Process.setThreadPriority(10);
                        a.b(b.call());
                        return;
                    }
                    catch (Exception exception)
                    {
                        zzp.zzbA().a(exception, true);
                    }
                    a.cancel(true);
                }

            
            {
                a = ua1;
                b = callable;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (ExecutorService executorservice)
        {
            zzb.zzd("Thread execution is rejected.", executorservice);
            ua1.cancel(true);
            return ua1;
        }
        return ua1;
    }

    private static ThreadFactory a(String s)
    {
        return new ThreadFactory(s) {

            final String a;
            private final AtomicInteger b = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AdWorker(").append(a).append(") #").append(b.getAndIncrement()).toString());
            }

            
            {
                a = s;
                super();
            }
        };
    }

}
