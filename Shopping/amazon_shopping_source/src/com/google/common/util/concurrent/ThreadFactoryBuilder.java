// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadFactoryBuilder
{

    private ThreadFactory backingThreadFactory;
    private Boolean daemon;
    private String nameFormat;
    private Integer priority;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public ThreadFactoryBuilder()
    {
        nameFormat = null;
        daemon = null;
        priority = null;
        uncaughtExceptionHandler = null;
        backingThreadFactory = null;
    }

    private static ThreadFactory build(ThreadFactoryBuilder threadfactorybuilder)
    {
        String s = threadfactorybuilder.nameFormat;
        Boolean boolean1 = threadfactorybuilder.daemon;
        Integer integer = threadfactorybuilder.priority;
        Thread.UncaughtExceptionHandler uncaughtexceptionhandler = threadfactorybuilder.uncaughtExceptionHandler;
        AtomicLong atomiclong;
        if (threadfactorybuilder.backingThreadFactory != null)
        {
            threadfactorybuilder = threadfactorybuilder.backingThreadFactory;
        } else
        {
            threadfactorybuilder = Executors.defaultThreadFactory();
        }
        if (s != null)
        {
            atomiclong = new AtomicLong(0L);
        } else
        {
            atomiclong = null;
        }
        return new ThreadFactory(threadfactorybuilder, s, atomiclong, boolean1, integer, uncaughtexceptionhandler) {

            final ThreadFactory val$backingThreadFactory;
            final AtomicLong val$count;
            final Boolean val$daemon;
            final String val$nameFormat;
            final Integer val$priority;
            final Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler;

            public Thread newThread(Runnable runnable)
            {
                runnable = backingThreadFactory.newThread(runnable);
                if (nameFormat != null)
                {
                    runnable.setName(String.format(nameFormat, new Object[] {
                        Long.valueOf(count.getAndIncrement())
                    }));
                }
                if (daemon != null)
                {
                    runnable.setDaemon(daemon.booleanValue());
                }
                if (priority != null)
                {
                    runnable.setPriority(priority.intValue());
                }
                if (uncaughtExceptionHandler != null)
                {
                    runnable.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return runnable;
            }

            
            {
                backingThreadFactory = threadfactory;
                nameFormat = s;
                count = atomiclong;
                daemon = boolean1;
                priority = integer;
                uncaughtExceptionHandler = uncaughtexceptionhandler;
                super();
            }
        };
    }

    public ThreadFactory build()
    {
        return build(this);
    }

    public ThreadFactoryBuilder setNameFormat(String s)
    {
        String.format(s, new Object[] {
            Integer.valueOf(0)
        });
        nameFormat = s;
        return this;
    }
}
