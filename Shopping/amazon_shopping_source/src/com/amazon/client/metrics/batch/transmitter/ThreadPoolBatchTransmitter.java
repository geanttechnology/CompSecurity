// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.transmitter;

import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.batch.queue.ByteArrayQueue;
import com.amazon.client.metrics.transport.MetricsTransport;
import com.amazon.device.utils.BackgroundThreadFactory;
import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.client.metrics.batch.transmitter:
//            BatchTransmitter, UploadResultBroadcaster

public abstract class ThreadPoolBatchTransmitter extends BatchTransmitter
{

    private static final int THREAD_KEEP_ALIVE_TIME_MS = 1;
    private static final int THREAD_POOL_CORE_SIZE = 1;
    private static final int THREAD_POOL_MAX_SIZE = 1;
    private static final int THREAD_POOL_QUEUE_CAPACITY = 2;
    private static final int THREAD_POOL_TERMINATION_WAIT_MS = 5000;
    private static final DPLogger log = new DPLogger("Metrics:ThreadPoolBatchTransmitter");
    protected ThreadPoolExecutor mThreadPoolExecutor;

    public ThreadPoolBatchTransmitter(ByteArrayQueue bytearrayqueue, MetricsTransport metricstransport, UploadResultBroadcaster uploadresultbroadcaster, PeriodicMetricReporter periodicmetricreporter)
    {
        super(bytearrayqueue, metricstransport, uploadresultbroadcaster, periodicmetricreporter);
        createDefaultThreadPoolExecutor();
    }

    private void createDefaultThreadPoolExecutor()
    {
        mThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(2), new BackgroundThreadFactory());
        mThreadPoolExecutor.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
    }

    public void shutdown()
    {
        super.shutdown();
        mThreadPoolExecutor.shutdown();
        try
        {
            if (!mThreadPoolExecutor.awaitTermination(5000L, TimeUnit.MILLISECONDS))
            {
                mThreadPoolExecutor.shutdownNow();
                if (!mThreadPoolExecutor.awaitTermination(5000L, TimeUnit.MILLISECONDS))
                {
                    log.error("shutdown", "Thread pool did not terminate.", new Object[0]);
                }
            }
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            log.error("shutdown", "Thread pool interrupted on shutdown.", new Object[] {
                interruptedexception
            });
        }
        Thread.currentThread().interrupt();
    }

    public void transmitBatches(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        log.verbose("transmitBatches", "Enabling broadcast result for next run.", new Object[0]);
        mQueuePusher.enableBroadcastResultForNextRun();
        mThreadPoolExecutor.execute(mQueuePusher);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        log.error("transmitBatches", "Unexpected rejected execution exception while executing QueuePusher", new Object[] {
            obj
        });
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

}
