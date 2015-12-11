// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

class ParseExecutors
{

    private static final Object SCHEDULED_EXECUTOR_LOCK = new Object();
    private static ScheduledExecutorService scheduledExecutor;

    ParseExecutors()
    {
    }

    static Executor io()
    {
        return cu.a;
    }

    static Executor main()
    {
        return cu.b;
    }

    static ScheduledExecutorService scheduled()
    {
        synchronized (SCHEDULED_EXECUTOR_LOCK)
        {
            if (scheduledExecutor == null)
            {
                scheduledExecutor = Executors.newScheduledThreadPool(1);
            }
        }
        return scheduledExecutor;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
