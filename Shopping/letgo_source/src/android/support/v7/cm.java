// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class cm
{
    private static class a
        implements Executor
    {

        public void execute(Runnable runnable)
        {
            (new Handler(Looper.getMainLooper())).post(runnable);
        }

        private a()
        {
        }

    }


    static final int a;
    static final int b;
    private static final cm c = new cm();
    private static final int e;
    private final Executor d = new a();

    private cm()
    {
    }

    public static ExecutorService a()
    {
        ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadpoolexecutor, true);
        return threadpoolexecutor;
    }

    public static void a(ThreadPoolExecutor threadpoolexecutor, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            threadpoolexecutor.allowCoreThreadTimeOut(flag);
        }
    }

    public static Executor b()
    {
        return c.d;
    }

    static 
    {
        e = Runtime.getRuntime().availableProcessors();
        a = e + 1;
        b = e * 2 + 1;
    }
}
