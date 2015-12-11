// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.google.android.gms.b:
//            cf, cg

public final class by
{

    private static final ExecutorService a = Executors.newFixedThreadPool(10, a("Default"));
    private static final ExecutorService b = Executors.newFixedThreadPool(5, a("Loader"));

    public static cg a(int i, Runnable runnable)
    {
        if (i == 1)
        {
            return a(b, ((Callable) (new _cls1(runnable))));
        } else
        {
            return a(a, ((Callable) (new _cls2(runnable))));
        }
    }

    public static cg a(Runnable runnable)
    {
        return a(0, runnable);
    }

    public static cg a(ExecutorService executorservice, Callable callable)
    {
        cf cf1 = new cf();
        try
        {
            executorservice.submit(new _cls3(cf1, callable));
        }
        // Misplaced declaration of an exception variable
        catch (ExecutorService executorservice)
        {
            com.google.android.gms.ads.internal.util.client.b.c("Thread execution is rejected.", executorservice);
            cf1.cancel(true);
            return cf1;
        }
        return cf1;
    }

    private static ThreadFactory a(String s)
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
