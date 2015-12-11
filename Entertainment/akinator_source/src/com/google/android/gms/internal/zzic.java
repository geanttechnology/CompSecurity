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


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls5 {}

}
