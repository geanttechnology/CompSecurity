// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dp.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.dp.utils:
//            DpThreadPoolUtil

public class DpThreadFactory
    implements ThreadFactory
{

    private final AtomicInteger mNextThreadNumber;
    private final String mPrefix;
    protected final ThreadGroup mThreadGroup;

    public DpThreadFactory(String s)
    {
        if (s == null || s.trim().length() == 0)
        {
            throw new IllegalArgumentException("prefix must not be NULL or empty");
        } else
        {
            mThreadGroup = DpThreadPoolUtil.buildThreadGroup(s);
            mPrefix = s;
            mNextThreadNumber = new AtomicInteger(0);
            return;
        }
    }

    protected String buildNextThreadName()
    {
        return (new StringBuilder()).append(mPrefix).append("-").append(mNextThreadNumber.getAndIncrement()).toString();
    }

    public ThreadGroup getThreadGroup()
    {
        return mThreadGroup;
    }

    public Thread newThread(Runnable runnable)
    {
        return new Thread(mThreadGroup, runnable, buildNextThreadName());
    }
}
