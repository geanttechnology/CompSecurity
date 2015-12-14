// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.transmitter;

import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics.batch.transmitter:
//            PeriodicBatchTransmitter

protected class this._cls0
    implements Runnable
{

    private final AtomicBoolean mIsActive = new AtomicBoolean(true);
    final PeriodicBatchTransmitter this$0;

    public void run()
    {
        if (!mIsActive.get())
        {
            PeriodicBatchTransmitter.access$000().verbose("Transmitter.run", "Shutdown invoked.", new Object[0]);
            return;
        } else
        {
            transmitBatches(false);
            PeriodicBatchTransmitter.access$000().verbose("Transmitter.run", "Rescheduling next transmission.", new Object[0]);
            PeriodicBatchTransmitter.access$200(PeriodicBatchTransmitter.this).schedule(PeriodicBatchTransmitter.access$100(PeriodicBatchTransmitter.this), mBatchPipelineConfiguration.getTransmissionPeriodMillis(), TimeUnit.MILLISECONDS);
            return;
        }
    }

    public ()
    {
        this$0 = PeriodicBatchTransmitter.this;
        super();
    }
}
