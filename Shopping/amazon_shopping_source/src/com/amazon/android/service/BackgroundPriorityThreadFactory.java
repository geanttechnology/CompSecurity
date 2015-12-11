// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.service;

import android.os.Process;
import com.amazon.logging.Logger;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class BackgroundPriorityThreadFactory
    implements ThreadFactory
{
    protected static class PriorityWrapper
        implements Runnable
    {

        private static final Logger LOG = Logger.getLogger(com/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper);
        private final String name;
        private final int priority;
        private final Runnable runnable;

        public void run()
        {
            try
            {
                Process.setThreadPriority(priority);
                LOG.d((new StringBuilder()).append(name).append(": set thread priority to ").append(10).toString());
            }
            catch (SecurityException securityexception)
            {
                LOG.w((new StringBuilder()).append(name).append(": SecurityException caught, could not set thread priority to ").append(10).toString(), securityexception);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                LOG.w((new StringBuilder()).append(name).append(": IllegalArgumentException caught, could not set thread priority to ").append(10).toString(), illegalargumentexception);
            }
            runnable.run();
        }


        protected PriorityWrapper(Runnable runnable1, int i, String s)
        {
            runnable = runnable1;
            priority = i;
            name = s;
        }
    }


    private static final Logger LOG = Logger.getLogger(com/amazon/android/service/BackgroundPriorityThreadFactory);
    private final AtomicInteger mCount = new AtomicInteger(1);
    private final String prefix;

    public BackgroundPriorityThreadFactory(String s)
    {
        LOG.d("BackgroundPriorityThreadFactory is created");
        prefix = s;
    }

    public Thread newThread(Runnable runnable)
    {
        String s = (new StringBuilder()).append(prefix).append(" #").append(mCount.getAndIncrement()).toString();
        return new Thread(new PriorityWrapper(runnable, 10, s), s);
    }

}
