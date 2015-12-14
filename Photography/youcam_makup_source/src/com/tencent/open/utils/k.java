// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.tencent.open.utils:
//            l

public final class k
{

    public static final Executor a = c();
    private static Object b = new Object();
    private static Handler c;
    private static HandlerThread d;

    public k()
    {
    }

    public static Handler a()
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        com/tencent/open/utils/k;
        JVM INSTR monitorenter ;
        d = new HandlerThread("SDK_SUB");
        d.start();
        c = new Handler(d.getLooper());
        com/tencent/open/utils/k;
        JVM INSTR monitorexit ;
_L2:
        return c;
        Exception exception;
        exception;
        com/tencent/open/utils/k;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void a(Runnable runnable)
    {
        a().post(runnable);
    }

    public static Executor b()
    {
        return new l();
    }

    private static Executor c()
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            obj = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else
        {
            try
            {
                obj = android/os/AsyncTask.getDeclaredField("sExecutor");
                ((Field) (obj)).setAccessible(true);
                obj = (Executor)((Field) (obj)).get(null);
            }
            catch (Exception exception)
            {
                exception = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        }
        if (obj instanceof ThreadPoolExecutor)
        {
            ((ThreadPoolExecutor)obj).setCorePoolSize(3);
        }
        return ((Executor) (obj));
    }

}
