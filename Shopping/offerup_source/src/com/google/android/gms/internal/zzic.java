// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.google.android.gms.internal:
//            zzin, zziq

public final class zzic
{

    private static final ExecutorService zzIr = Executors.newFixedThreadPool(10, zzay("Default"));
    private static final ExecutorService zzIs = Executors.newFixedThreadPool(5, zzay("Loader"));

    public static zziq zza(int i, Runnable runnable)
    {
        if (i == 1)
        {
            return zza(zzIs, ((Callable) (new _cls1(runnable))));
        } else
        {
            return zza(zzIr, ((Callable) (new _cls2(runnable))));
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
            zzin1.zzd(new _cls4(zzin1, executorservice.submit(new _cls3(zzin1, callable))));
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
        return new _cls5(s);
    }


    private class _cls1
        implements Callable
    {

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

        _cls1(Runnable runnable)
        {
            zzIt = runnable;
            super();
        }
    }


    private class _cls2
        implements Callable
    {

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

        _cls2(Runnable runnable)
        {
            zzIt = runnable;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final Future zzIv;
        final zzin zzrA;

        public final void run()
        {
            if (zzrA.isCancelled())
            {
                zzIv.cancel(true);
            }
        }

        _cls4(zzin zzin1, Future future)
        {
            zzrA = zzin1;
            zzIv = future;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

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

        _cls3(zzin zzin1, Callable callable)
        {
            zzrA = zzin1;
            zzIu = callable;
            super();
        }
    }


    private class _cls5
        implements ThreadFactory
    {

        private final AtomicInteger zzIw = new AtomicInteger(1);
        final String zzIx;

        public final Thread newThread(Runnable runnable)
        {
            return new Thread(runnable, (new StringBuilder("AdWorker(")).append(zzIx).append(") #").append(zzIw.getAndIncrement()).toString());
        }

        _cls5(String s)
        {
            zzIx = s;
            super();
        }
    }

}
