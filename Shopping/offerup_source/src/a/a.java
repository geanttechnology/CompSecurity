// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package a:
//            c

final class a
{

    private static final a a = new a();
    private static final int c;
    private static int d;
    private static int e;
    private final Executor b = new c((byte)0);

    private a()
    {
    }

    public static ExecutorService a()
    {
        ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            threadpoolexecutor.allowCoreThreadTimeOut(true);
        }
        return threadpoolexecutor;
    }

    public static Executor b()
    {
        return a.b;
    }

    static 
    {
        int i = Runtime.getRuntime().availableProcessors();
        c = i;
        d = i + 1;
        e = (c << 1) + 1;
    }
}
