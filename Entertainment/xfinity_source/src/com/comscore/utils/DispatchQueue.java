// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.utils;

import com.comscore.analytics.Core;
import com.comscore.utils.task.TaskExecutor;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DispatchQueue extends ConcurrentLinkedQueue
{

    private Core b;

    public DispatchQueue(Core core)
    {
        b = core;
    }

    public volatile boolean offer(Object obj)
    {
        return offer((Runnable)obj);
    }

    public boolean offer(Runnable runnable)
    {
        return b.getTaskExecutor().execute(runnable, true);
    }
}
