// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.queue;

import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.device.utils.BackgroundThreadFactory;
import com.amazon.dp.logger.DPLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics.batch.queue:
//            ByteArrayQueue, ByteArrayQueueListener

public abstract class BoundedByteArrayQueue
    implements ByteArrayQueue
{
    private class QueuePurger
        implements Runnable
    {

        private final AtomicBoolean mIsActive = new AtomicBoolean(true);
        final BoundedByteArrayQueue this$0;

        public void run()
        {
            if (!mIsActive.get())
            {
                BoundedByteArrayQueue.log.verbose("QueuePurger.run", "Shutdown invoked.", new Object[0]);
                return;
            } else
            {
                BoundedByteArrayQueue.log.verbose("QueuePurger.run", "Purging expired batches.", new Object[0]);
                purgeExpiredBatches();
                return;
            }
        }

        public void shutdown()
        {
            mIsActive.set(false);
        }

        public QueuePurger()
        {
            this$0 = BoundedByteArrayQueue.this;
            super();
        }
    }


    protected static final String METRIC_NAME_DROPPED_BATCHES = "droppedBatches";
    protected static final String METRIC_NAME_EXPIRED_BATCHES = "expiredBatches";
    private static final int THREAD_POOL_TERMINATION_WAIT_MS = 5000;
    private static final DPLogger log = new DPLogger("Metrics:BoundedByteArrayQueue");
    protected final BatchPipelineConfiguration mBatchPipelineConfiguration;
    protected long mBytesUsed;
    protected final Set mListeners = new HashSet(1);
    protected long mNumEntries;
    protected final PeriodicMetricReporter mPeriodicMetricReporter;
    private String mQueueName;
    private final QueuePurger mQueuePurger = new QueuePurger();
    private ScheduledThreadPoolExecutor mQueuePurgerExecutor;

    public BoundedByteArrayQueue(BatchPipelineConfiguration batchpipelineconfiguration, PeriodicMetricReporter periodicmetricreporter)
        throws IllegalArgumentException
    {
        mBytesUsed = 0L;
        mNumEntries = 0L;
        if (batchpipelineconfiguration.getMaxBatchQueueCapacityBytes() <= 0L)
        {
            throw new IllegalArgumentException("Capacity of queue must be greater than 0 bytes.");
        }
        if (batchpipelineconfiguration.getExpiryTimeMillis() < 0L)
        {
            throw new IllegalArgumentException("ExpiryTimeMillis must not be negative.");
        }
        if (batchpipelineconfiguration.getPurgePeriodMillis() < 0L)
        {
            throw new IllegalArgumentException("PurgePeriodMillis must not be negative.");
        }
        if (periodicmetricreporter == null)
        {
            throw new IllegalArgumentException("Periodic metric reporter must not be null.");
        } else
        {
            mPeriodicMetricReporter = periodicmetricreporter;
            mBatchPipelineConfiguration = batchpipelineconfiguration;
            initializeQueuePurger();
            return;
        }
    }

    private void initializeQueuePurger()
    {
        mQueuePurgerExecutor = new ScheduledThreadPoolExecutor(1, new BackgroundThreadFactory());
        mQueuePurgerExecutor.scheduleAtFixedRate(mQueuePurger, mBatchPipelineConfiguration.getPurgePeriodMillis(), mBatchPipelineConfiguration.getPurgePeriodMillis(), TimeUnit.MILLISECONDS);
        mQueuePurgerExecutor.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
    }

    public void addListener(ByteArrayQueueListener bytearrayqueuelistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (bytearrayqueuelistener != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("listener cannot be null");
        bytearrayqueuelistener;
        this;
        JVM INSTR monitorexit ;
        throw bytearrayqueuelistener;
        mListeners.add(bytearrayqueuelistener);
        this;
        JVM INSTR monitorexit ;
    }

    public long getNumEntriesInQueue()
    {
        this;
        JVM INSTR monitorenter ;
        long l = mNumEntries;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public String getQueueName()
    {
        return mQueueName;
    }

    protected void notifyListeners()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((ByteArrayQueueListener)iterator.next()).onInsert(mNumEntries, mBytesUsed)) { }
        break MISSING_BLOCK_LABEL_51;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    protected abstract void purgeExpiredBatches();

    public void removeListener(ByteArrayQueueListener bytearrayqueuelistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (bytearrayqueuelistener != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("listener cannot be null");
        bytearrayqueuelistener;
        this;
        JVM INSTR monitorexit ;
        throw bytearrayqueuelistener;
        mListeners.remove(bytearrayqueuelistener);
        this;
        JVM INSTR monitorexit ;
    }

    public void setQueueName(String s)
    {
        mQueueName = s;
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        mQueuePurger.shutdown();
        mQueuePurgerExecutor.shutdown();
        if (!mQueuePurgerExecutor.awaitTermination(5000L, TimeUnit.MILLISECONDS))
        {
            mQueuePurgerExecutor.shutdownNow();
            if (!mQueuePurgerExecutor.awaitTermination(5000L, TimeUnit.MILLISECONDS))
            {
                log.error("shutdown", "Thread pool did not terminate.", new Object[0]);
            }
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        mQueuePurgerExecutor.shutdownNow();
        log.error("shutdown", "Thread pool interrupted on shutdown.", new Object[] {
            obj
        });
        Thread.currentThread().interrupt();
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    protected void validateInput(byte abyte0[])
        throws IllegalArgumentException
    {
        if (abyte0 == null || abyte0.length <= 0)
        {
            throw new IllegalArgumentException("Serialized object should not be null or empty.");
        }
        if ((long)abyte0.length > mBatchPipelineConfiguration.getMaxBatchQueueCapacityBytes())
        {
            throw new IllegalArgumentException("Serialized object size is larger than the maximum capacity.");
        } else
        {
            return;
        }
    }


}
