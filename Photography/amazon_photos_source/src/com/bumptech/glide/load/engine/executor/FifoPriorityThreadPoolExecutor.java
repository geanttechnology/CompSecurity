// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.bumptech.glide.load.engine.executor:
//            Prioritized

public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor
{
    public static class DefaultThreadFactory
        implements ThreadFactory
    {

        int threadNum;

        public Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable, (new StringBuilder()).append("fifo-pool-thread-").append(threadNum).toString()) {

                final DefaultThreadFactory this$0;

                public void run()
                {
                    Process.setThreadPriority(10);
                    super.run();
                }

            
            {
                this$0 = DefaultThreadFactory.this;
                super(runnable, s);
            }
            };
            threadNum = threadNum + 1;
            return runnable;
        }

        public DefaultThreadFactory()
        {
            threadNum = 0;
        }
    }

    static class LoadTask extends FutureTask
        implements Comparable
    {

        private final int order;
        private final int priority;

        public int compareTo(LoadTask loadtask)
        {
            int j = priority - loadtask.priority;
            int i = j;
            if (j == 0)
            {
                i = order - loadtask.order;
            }
            return i;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((LoadTask)obj);
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof LoadTask)
            {
                obj = (LoadTask)obj;
                flag = flag1;
                if (order == ((LoadTask) (obj)).order)
                {
                    flag = flag1;
                    if (priority == ((LoadTask) (obj)).priority)
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return priority * 31 + order;
        }

        public LoadTask(Runnable runnable, Object obj, int i)
        {
            super(runnable, obj);
            if (!(runnable instanceof Prioritized))
            {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            } else
            {
                priority = ((Prioritized)runnable).getPriority();
                order = i;
                return;
            }
        }
    }


    AtomicInteger ordering;

    public FifoPriorityThreadPoolExecutor(int i)
    {
        this(i, i, 0L, TimeUnit.MILLISECONDS, ((ThreadFactory) (new DefaultThreadFactory())));
    }

    public FifoPriorityThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, ThreadFactory threadfactory)
    {
        super(i, j, l, timeunit, new PriorityBlockingQueue(), threadfactory);
        ordering = new AtomicInteger();
    }

    protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
    {
        return new LoadTask(runnable, obj, ordering.getAndIncrement());
    }
}
