// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.transmitter;

import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.batch.queue.ByteArrayQueue;
import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.client.metrics.transport.MetricsTransport;
import com.amazon.device.utils.BackgroundThreadFactory;
import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics.batch.transmitter:
//            ThreadPoolBatchTransmitter, UploadResultBroadcaster

public class PeriodicBatchTransmitter extends ThreadPoolBatchTransmitter
{
    protected class Transmitter
        implements Runnable
    {

        private final AtomicBoolean mIsActive = new AtomicBoolean(true);
        final PeriodicBatchTransmitter this$0;

        public void run()
        {
            if (!mIsActive.get())
            {
                PeriodicBatchTransmitter.log.verbose("Transmitter.run", "Shutdown invoked.", new Object[0]);
                return;
            } else
            {
                transmitBatches(false);
                PeriodicBatchTransmitter.log.verbose("Transmitter.run", "Rescheduling next transmission.", new Object[0]);
                mScheduledExecutor.schedule(mTransmitter, mBatchPipelineConfiguration.getTransmissionPeriodMillis(), TimeUnit.MILLISECONDS);
                return;
            }
        }

        public Transmitter()
        {
            this$0 = PeriodicBatchTransmitter.this;
            super();
        }
    }


    private static final DPLogger log = new DPLogger("PeriodicBatchTransmitter");
    protected BatchPipelineConfiguration mBatchPipelineConfiguration;
    private ScheduledThreadPoolExecutor mScheduledExecutor;
    private Transmitter mTransmitter;

    public PeriodicBatchTransmitter(ByteArrayQueue bytearrayqueue, MetricsTransport metricstransport, UploadResultBroadcaster uploadresultbroadcaster, BatchPipelineConfiguration batchpipelineconfiguration, PeriodicMetricReporter periodicmetricreporter, long l)
    {
        super(bytearrayqueue, metricstransport, uploadresultbroadcaster, periodicmetricreporter);
        mBatchPipelineConfiguration = batchpipelineconfiguration;
        createScheduledThreadPoolExecutor(l);
    }

    private void createScheduledThreadPoolExecutor(long l)
    {
        mScheduledExecutor = new ScheduledThreadPoolExecutor(1, new BackgroundThreadFactory());
        mScheduledExecutor.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        mTransmitter = new Transmitter();
        mScheduledExecutor.schedule(mTransmitter, l, TimeUnit.MILLISECONDS);
    }




}
