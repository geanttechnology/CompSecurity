// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;

import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.framework.network:
//            NetworkExecutor

private class this._cls0 extends ThreadPoolExecutor
{

    final NetworkExecutor this$0;

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        runnable = (this._cls0)runnable;
        NetworkExecutor.access$100(NetworkExecutor.this, this, runnable);
    }

    protected void beforeExecute(Thread thread, Runnable runnable)
    {
        thread = (this._cls0)runnable;
        GLogger.d(NetworkExecutor.access$000(), "Executing %s %s", new Object[] {
            thread._mth0(), thread
        });
        NetworkExecutor.access$200(NetworkExecutor.this, this, thread);
    }

    public List shutdownNow2()
    {
        return super.shutdownNow();
    }

    protected void terminated()
    {
        super.terminated();
    }

    public (int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, 
            ThreadFactory threadfactory)
    {
        this$0 = NetworkExecutor.this;
        super(i, j, l, timeunit, blockingqueue, threadfactory);
    }
}
