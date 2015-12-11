// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class cv
    implements Executor
{

    private static final TimeUnit a;
    private static final BlockingQueue b = new LinkedBlockingQueue();
    private static cv c = null;
    private ThreadPoolExecutor d;

    private cv()
    {
        TimeUnit timeunit = a;
        BlockingQueue blockingqueue = b;
        d = new ThreadPoolExecutor(3, 5, 120, timeunit, blockingqueue);
    }

    public static cv a()
    {
        android/support/v7/cv;
        JVM INSTR monitorenter ;
        cv cv1;
        if (c == null)
        {
            c = new cv();
        }
        cv1 = c;
        android/support/v7/cv;
        JVM INSTR monitorexit ;
        return cv1;
        Exception exception;
        exception;
        throw exception;
    }

    public void execute(Runnable runnable)
    {
        d.submit(runnable);
    }

    static 
    {
        a = TimeUnit.SECONDS;
    }
}
