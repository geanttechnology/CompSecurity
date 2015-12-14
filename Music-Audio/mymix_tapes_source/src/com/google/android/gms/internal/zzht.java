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
//            zzie, zzih

public final class zzht
{

    private static final ExecutorService zzHy = Executors.newFixedThreadPool(10, zzav("Default"));
    private static final ExecutorService zzHz = Executors.newFixedThreadPool(5, zzav("Loader"));

    public static zzih zza(int i, Runnable runnable)
    {
        if (i == 1)
        {
            return zza(zzHz, ((Callable) (new _cls1(runnable))));
        } else
        {
            return zza(zzHy, ((Callable) (new _cls2(runnable))));
        }
    }

    public static zzih zza(Runnable runnable)
    {
        return zza(0, runnable);
    }

    public static zzih zza(Callable callable)
    {
        return zza(zzHy, callable);
    }

    public static zzih zza(ExecutorService executorservice, Callable callable)
    {
        zzie zzie1 = new zzie();
        try
        {
            executorservice.submit(new _cls3(zzie1, callable));
        }
        // Misplaced declaration of an exception variable
        catch (ExecutorService executorservice)
        {
            zzb.zzd("Thread execution is rejected.", executorservice);
            zzie1.cancel(true);
            return zzie1;
        }
        return zzie1;
    }

    private static ThreadFactory zzav(String s)
    {
        return new _cls4(s);
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}

}
