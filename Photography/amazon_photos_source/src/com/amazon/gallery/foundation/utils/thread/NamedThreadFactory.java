// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
    implements ThreadFactory
{

    private final AtomicInteger count;
    private final boolean daemon;
    private final int priority;
    private final String tag;

    public NamedThreadFactory(String s)
    {
        this(s, -1);
    }

    public NamedThreadFactory(String s, int i)
    {
        this(s, i, false);
    }

    public NamedThreadFactory(String s, int i, boolean flag)
    {
        count = new AtomicInteger(1);
        tag = s;
        priority = i;
        daemon = flag;
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, (new StringBuilder()).append(tag).append(" Thread#").append(count.getAndIncrement()).toString());
        if (priority != -1)
        {
            runnable.setPriority(priority);
        }
        runnable.setDaemon(daemon);
        return runnable;
    }
}
