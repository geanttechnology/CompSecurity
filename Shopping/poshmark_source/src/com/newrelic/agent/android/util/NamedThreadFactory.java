// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
    implements ThreadFactory
{

    final ThreadGroup group;
    final String namePrefix;
    final AtomicInteger threadNumber = new AtomicInteger(1);

    public NamedThreadFactory(String s)
    {
        Object obj = System.getSecurityManager();
        if (obj != null)
        {
            obj = ((SecurityManager) (obj)).getThreadGroup();
        } else
        {
            obj = Thread.currentThread().getThreadGroup();
        }
        group = ((ThreadGroup) (obj));
        namePrefix = (new StringBuilder()).append("NR_").append(s).append("-").toString();
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(group, runnable, (new StringBuilder()).append(namePrefix).append(threadNumber.getAndIncrement()).toString(), 0L);
        if (runnable.isDaemon())
        {
            runnable.setDaemon(false);
        }
        if (runnable.getPriority() != 5)
        {
            runnable.setPriority(5);
        }
        return runnable;
    }
}
