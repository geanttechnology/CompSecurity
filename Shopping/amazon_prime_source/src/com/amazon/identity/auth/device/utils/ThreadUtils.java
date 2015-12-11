// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            NamedCachedThreadPool, NamedThreadFactory

public final class ThreadUtils
{

    private static final Object LOCK[] = new Object[0];
    public static final Executor MAP_COMMON_THREAD_POOL = new NamedCachedThreadPool("MAPCommonThreadPool");
    private static Handler sMapLooperHandler;
    private static Thread sMapLooperThread;

    public static Handler getMapLooperHandler()
    {
label0:
        {
            Handler handler;
            synchronized (LOCK)
            {
                if (sMapLooperHandler == null)
                {
                    break label0;
                }
                handler = sMapLooperHandler;
            }
            return handler;
        }
        Object obj;
        obj = new Thread() {

            public void run()
            {
                Looper.prepare();
                ThreadUtils.sMapLooperHandler = new Handler();
                Looper.loop();
            }

        };
        sMapLooperThread = ((Thread) (obj));
        ((Thread) (obj)).start();
        obj = sMapLooperHandler;
        aobj;
        JVM INSTR monitorexit ;
        return ((Handler) (obj));
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static NamedThreadFactory getNamedThreadFactory(String s)
    {
        return new NamedThreadFactory(s);
    }

    public static boolean isRunningOnMainThread()
    {
        return Looper.getMainLooper() != null && Looper.getMainLooper() == Looper.myLooper();
    }

    public static void runOffMainThread(Runnable runnable)
    {
        if (!isRunningOnMainThread())
        {
            runnable.run();
            return;
        } else
        {
            submitToBackgroundThread(runnable);
            return;
        }
    }

    public static void runOnMainThread(Runnable runnable)
    {
        (new Handler(Looper.getMainLooper())).post(runnable);
    }

    public static void submitToBackgroundThread(Runnable runnable)
    {
        MAP_COMMON_THREAD_POOL.execute(runnable);
    }



/*
    static Handler access$002(Handler handler)
    {
        sMapLooperHandler = handler;
        return handler;
    }

*/
}
