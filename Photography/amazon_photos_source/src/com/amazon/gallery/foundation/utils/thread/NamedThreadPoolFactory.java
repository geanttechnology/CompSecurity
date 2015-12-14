// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.foundation.utils.thread:
//            NamedThreadFactory

public class NamedThreadPoolFactory
{

    public static ThreadPoolExecutor newFixedThreadPoolExecutor(int i, int j, String s)
    {
        return newFixedThreadPoolExecutor(i, j, s, null);
    }

    public static ThreadPoolExecutor newFixedThreadPoolExecutor(int i, int j, String s, Runnable runnable)
    {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(s, j), runnable) {

            final Runnable val$postExecute;

            protected void afterExecute(Runnable runnable1, Throwable throwable)
            {
                super.afterExecute(runnable1, throwable);
                if (postExecute != null)
                {
                    postExecute.run();
                }
            }

            
            {
                postExecute = runnable;
                super(i, j, l, timeunit, blockingqueue, threadfactory);
            }
        };
    }

    public static ThreadPoolExecutor newThreadPool(String s, int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, Runnable runnable)
    {
        return new ThreadPoolExecutor(i, j, l, timeunit, blockingqueue, new NamedThreadFactory(s, 5), runnable) {

            final Runnable val$postExecute;

            protected void afterExecute(Runnable runnable1, Throwable throwable)
            {
                super.afterExecute(runnable1, throwable);
                if (postExecute != null)
                {
                    postExecute.run();
                }
            }

            
            {
                postExecute = runnable;
                super(i, j, l, timeunit, blockingqueue, threadfactory);
            }
        };
    }
}
