// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class emy
    implements ThreadFactory
{

    private ThreadFactory a;
    private String b;
    private AtomicLong c;
    private Boolean d;
    private Integer e;
    private Thread.UncaughtExceptionHandler f;

    emy(ThreadFactory threadfactory, String s, AtomicLong atomiclong, Boolean boolean1, Integer integer, Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        a = threadfactory;
        b = s;
        c = atomiclong;
        d = boolean1;
        e = integer;
        f = uncaughtexceptionhandler;
        super();
    }

    public final Thread newThread(Runnable runnable)
    {
        runnable = a.newThread(runnable);
        if (b != null)
        {
            runnable.setName(String.format(b, new Object[] {
                Long.valueOf(c.getAndIncrement())
            }));
        }
        if (d != null)
        {
            runnable.setDaemon(d.booleanValue());
        }
        if (e != null)
        {
            runnable.setPriority(e.intValue());
        }
        if (f != null)
        {
            runnable.setUncaughtExceptionHandler(f);
        }
        return runnable;
    }
}
