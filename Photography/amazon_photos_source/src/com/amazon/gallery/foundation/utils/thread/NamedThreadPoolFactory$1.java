// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.foundation.utils.thread:
//            NamedThreadPoolFactory

static final class val.postExecute extends ThreadPoolExecutor
{

    final Runnable val$postExecute;

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        super.afterExecute(runnable, throwable);
        if (val$postExecute != null)
        {
            val$postExecute.run();
        }
    }

    I(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, ThreadFactory threadfactory, 
            Runnable runnable)
    {
        val$postExecute = runnable;
        super(i, j, l, timeunit, blockingqueue, threadfactory);
    }
}
