// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.internal:
//            zzin, zziq, zzhu

public final class zzic
{

    private static final ExecutorService zzIr = Executors.newFixedThreadPool(10, zzay("Default"));
    private static final ExecutorService zzIs = Executors.newFixedThreadPool(5, zzay("Loader"));

    public static zziq zza(int i, Runnable runnable)
    {
        if (i == 1)
        {
            return zza(zzIs, new Callable(runnable) {

                final Runnable zzIt;

                public final Object call()
                {
                    return zzgA();
                }

                public final Void zzgA()
                {
                    zzIt.run();
                    return null;
                }

            
            {
                zzIt = runnable;
                super();
            }
            });
        } else
        {
            return zza(zzIr, new Callable(runnable) {

                final Runnable zzIt;

                public final Object call()
                {
                    return zzgA();
                }

                public final Void zzgA()
                {
                    zzIt.run();
                    return null;
                }

            
            {
                zzIt = runnable;
                super();
            }
            });
        }
    }

    public static zziq zza(Runnable runnable)
    {
        return zza(0, runnable);
    }

    public static zziq zza(Callable callable)
    {
        return zza(zzIr, callable);
    }

    public static zziq zza(ExecutorService executorservice, Callable callable)
    {
        zzin zzin1 = new zzin();
        try
        {
            zzin1.zzd(new Runnable(zzin1, executorservice.submit(new Runnable(zzin1, callable) {

                final Callable zzIu;
                final zzin zzrA;

                public final void run()
                {
                    try
                    {
                        Process.setThreadPriority(10);
                        zzrA.zzf(zzIu.call());
                        return;
                    }
                    catch (Exception exception)
                    {
                        zzp.zzby().zzc(exception, true);
                    }
                    zzrA.cancel(true);
                }

            
            {
                zzrA = zzin1;
                zzIu = callable;
                super();
            }
            })) {

                final Future zzIv;
                final zzin zzrA;

                public final void run()
                {
                    if (zzrA.isCancelled())
                    {
                        zzIv.cancel(true);
                    }
                }

            
            {
                zzrA = zzin1;
                zzIv = future;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (ExecutorService executorservice)
        {
            zzb.zzd("Thread execution is rejected.", executorservice);
            zzin1.cancel(true);
            return zzin1;
        }
        return zzin1;
    }

    private static ThreadFactory zzay(String s)
    {
        return new ThreadFactory(s) {

            private final AtomicInteger zzIw = new AtomicInteger(1);
            final String zzIx;

            public final Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder("AdWorker(")).append(zzIx).append(") #").append(zzIw.getAndIncrement()).toString());
            }

            
            {
                zzIx = s;
                super();
            }
        };
    }

}
