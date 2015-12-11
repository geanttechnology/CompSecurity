// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.queue;

import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics.batch.queue:
//            BoundedByteArrayQueue

private class this._cls0
    implements Runnable
{

    private final AtomicBoolean mIsActive = new AtomicBoolean(true);
    final BoundedByteArrayQueue this$0;

    public void run()
    {
        if (!mIsActive.get())
        {
            BoundedByteArrayQueue.access$000().verbose("QueuePurger.run", "Shutdown invoked.", new Object[0]);
            return;
        } else
        {
            BoundedByteArrayQueue.access$000().verbose("QueuePurger.run", "Purging expired batches.", new Object[0]);
            purgeExpiredBatches();
            return;
        }
    }

    public void shutdown()
    {
        mIsActive.set(false);
    }

    public ()
    {
        this$0 = BoundedByteArrayQueue.this;
        super();
    }
}
