// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class b
    implements ThreadFactory
{

    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    private final int e;

    b(int i)
    {
        e = i;
        Object obj = System.getSecurityManager();
        if (obj != null)
        {
            obj = ((SecurityManager) (obj)).getThreadGroup();
        } else
        {
            obj = Thread.currentThread().getThreadGroup();
        }
        b = ((ThreadGroup) (obj));
        d = (new StringBuilder()).append("uil-pool-").append(a.getAndIncrement()).append("-thread-").toString();
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(b, runnable, (new StringBuilder()).append(d).append(c.getAndIncrement()).toString(), 0L);
        if (runnable.isDaemon())
        {
            runnable.setDaemon(false);
        }
        runnable.setPriority(e);
        return runnable;
    }

}
