// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadUtil
{
    private static class DexLoadThreadFactory
        implements ThreadFactory
    {

        private final AtomicInteger mThreadCount;

        public Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable);
            runnable.setName(String.format("DexLoadingPool-%d", new Object[] {
                Integer.valueOf(mThreadCount.getAndIncrement())
            }));
            return runnable;
        }

        private DexLoadThreadFactory()
        {
            mThreadCount = new AtomicInteger(0);
        }

    }


    private static final int MINIMAL_THREAD_COUNT = Math.max(2, Runtime.getRuntime().availableProcessors());

    ThreadUtil()
    {
    }

    public static ThreadPoolExecutor createExector(BlockingQueue blockingqueue, int i)
    {
        i = Math.min(i, MINIMAL_THREAD_COUNT);
        return new ThreadPoolExecutor(i, i, 1L, TimeUnit.SECONDS, blockingqueue, new DexLoadThreadFactory());
    }

}
