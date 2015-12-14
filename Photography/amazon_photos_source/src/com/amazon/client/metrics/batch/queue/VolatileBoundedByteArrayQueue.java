// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.queue;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.dp.logger.DPLogger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Referenced classes of package com.amazon.client.metrics.batch.queue:
//            BoundedByteArrayQueue

public class VolatileBoundedByteArrayQueue extends BoundedByteArrayQueue
{
    class TimeStampedSerializedObject
    {

        private byte mSerializedObject[];
        private long mTimeStamp;
        final VolatileBoundedByteArrayQueue this$0;

        public byte[] getSerializedObject()
        {
            return mSerializedObject;
        }

        public long getTimeStamp()
        {
            return mTimeStamp;
        }

        public TimeStampedSerializedObject(long l, byte abyte0[])
        {
            this$0 = VolatileBoundedByteArrayQueue.this;
            super();
            mTimeStamp = l;
            mSerializedObject = abyte0;
        }
    }


    private static final DPLogger log = new DPLogger("Metrics:VolatileBoundedByteArrayQueue");
    protected final Set mListeners = new HashSet(1);
    private Queue mQueue;

    public VolatileBoundedByteArrayQueue(BatchPipelineConfiguration batchpipelineconfiguration, PeriodicMetricReporter periodicmetricreporter)
    {
        super(batchpipelineconfiguration, periodicmetricreporter);
        mQueue = new LinkedList();
    }

    public void add(byte abyte0[], boolean flag)
        throws IllegalArgumentException
    {
        this;
        JVM INSTR monitorenter ;
        validateInput(abyte0);
        mBytesUsed = mBytesUsed + (long)abyte0.length;
        do
        {
            if (mBytesUsed <= mBatchPipelineConfiguration.getMaxBatchQueueCapacityBytes())
            {
                break MISSING_BLOCK_LABEL_89;
            }
            log.debug("add", "Queue is full. Dropping an item from the queue.", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("droppedBatches", 1.0D);
        } while (remove() != null);
        throw new IllegalArgumentException("All items removed and the queue is still full");
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        mQueue.add(new TimeStampedSerializedObject(System.currentTimeMillis(), abyte0));
        mNumEntries = mNumEntries + 1L;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        notifyListeners();
        this;
        JVM INSTR monitorexit ;
    }

    public TimeStampedSerializedObject peekVolatileQueueSerializedObject()
    {
        this;
        JVM INSTR monitorenter ;
        TimeStampedSerializedObject timestampedserializedobject = (TimeStampedSerializedObject)mQueue.peek();
        this;
        JVM INSTR monitorexit ;
        return timestampedserializedobject;
        Exception exception;
        exception;
        throw exception;
    }

    public void purgeExpiredBatches()
    {
        this;
        JVM INSTR monitorenter ;
        long l2;
        long l = System.currentTimeMillis();
        long l1 = mBatchPipelineConfiguration.getExpiryTimeMillis();
        l2 = mNumEntries;
        for (; mQueue.peek() != null && ((TimeStampedSerializedObject)mQueue.peek()).getTimeStamp() < l - l1; mPeriodicMetricReporter.getMetricEvent().incrementCounter("expiredBatches", 1.0D))
        {
            remove();
        }

        break MISSING_BLOCK_LABEL_88;
        Exception exception;
        exception;
        throw exception;
        log.debug("purgeExpiredBatches", "Number of batches purged: ", new Object[] {
            Long.valueOf(l2 - mNumEntries)
        });
        this;
        JVM INSTR monitorexit ;
    }

    public byte[] remove()
    {
        this;
        JVM INSTR monitorenter ;
        if (mQueue.peek() != null) goto _L2; else goto _L1
_L1:
        byte abyte0[] = null;
_L4:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        mBytesUsed = mBytesUsed - (long)abyte0.length;
        mNumEntries = mNumEntries - 1L;
        this;
        JVM INSTR monitorexit ;
        return abyte0;
_L2:
        abyte0 = ((TimeStampedSerializedObject)mQueue.poll()).getSerializedObject();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}
