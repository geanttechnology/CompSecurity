// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class btz
{

    public static ExecutorService a(String s)
    {
        ExecutorService executorservice = Executors.newSingleThreadExecutor(c(s));
        a(s, executorservice);
        return executorservice;
    }

    private static final void a(String s, ExecutorService executorservice)
    {
        a(s, executorservice, 2L, TimeUnit.SECONDS);
    }

    public static final void a(String s, ExecutorService executorservice, long l, TimeUnit timeunit)
    {
        Runtime.getRuntime().addShutdownHook(new Thread(new buc(s, executorservice, l, timeunit), (new StringBuilder()).append("Crashlytics Shutdown Hook for ").append(s).toString()));
    }

    public static ScheduledExecutorService b(String s)
    {
        ScheduledExecutorService scheduledexecutorservice = Executors.newSingleThreadScheduledExecutor(c(s));
        a(s, scheduledexecutorservice);
        return scheduledexecutorservice;
    }

    public static final ThreadFactory c(String s)
    {
        return new bua(s, new AtomicLong(1L));
    }
}
