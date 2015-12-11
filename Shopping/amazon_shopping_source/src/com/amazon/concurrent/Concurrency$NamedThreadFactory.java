// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.concurrent:
//            Concurrency, ThreadFixer

static class ment
    implements ThreadFactory
{

    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final ThreadGroup group = Thread.currentThread().getThreadGroup();
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(group, runnable, (new StringBuilder()).append(namePrefix).append(threadNumber.getAndIncrement()).toString(), 0L);
        ThreadFixer.NORMAL_NON_DAEMON_FIXER.fix(runnable);
        return runnable;
    }


    (String s)
    {
        namePrefix = (new StringBuilder()).append(s).append("-").append(POOL_NUMBER.getAndIncrement()).append("-thread-").toString();
    }
}
