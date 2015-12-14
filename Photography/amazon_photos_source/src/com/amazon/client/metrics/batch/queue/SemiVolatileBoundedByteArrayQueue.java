// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.queue;

import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.dp.logger.DPLogger;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.amazon.client.metrics.batch.queue:
//            ByteArrayQueue, VolatileBoundedByteArrayQueue, NonVolatileBoundedByteArrayQueue, ByteArrayQueueListener

public class SemiVolatileBoundedByteArrayQueue
    implements ByteArrayQueue
{

    private static final DPLogger log = new DPLogger("Metrics:SemiVolatileBoundedByteArrayQueue");
    NonVolatileBoundedByteArrayQueue mNonVolatileQueue;
    private String mQueueName;
    VolatileBoundedByteArrayQueue mVolatileQueue;

    public SemiVolatileBoundedByteArrayQueue(BatchPipelineConfiguration batchpipelineconfiguration, PeriodicMetricReporter periodicmetricreporter, File file)
        throws IllegalArgumentException, IOException
    {
        mVolatileQueue = new VolatileBoundedByteArrayQueue(batchpipelineconfiguration, periodicmetricreporter);
        mNonVolatileQueue = new NonVolatileBoundedByteArrayQueue(batchpipelineconfiguration, periodicmetricreporter, file);
    }

    public void add(byte abyte0[], boolean flag)
        throws IllegalArgumentException, IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        mVolatileQueue.add(abyte0, true);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mNonVolatileQueue.add(abyte0, false);
        while (mVolatileQueue.getNumEntriesInQueue() > 0L) 
        {
            long l = mVolatileQueue.peekVolatileQueueSerializedObject().getTimeStamp();
            mNonVolatileQueue.add(mVolatileQueue.remove(), false, l);
        }
        if (true) goto _L4; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }

    public void addListener(ByteArrayQueueListener bytearrayqueuelistener)
    {
        this;
        JVM INSTR monitorenter ;
        mVolatileQueue.addListener(bytearrayqueuelistener);
        this;
        JVM INSTR monitorexit ;
        return;
        bytearrayqueuelistener;
        throw bytearrayqueuelistener;
    }

    public String getQueueName()
    {
        return mQueueName;
    }

    public byte[] remove()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (mVolatileQueue.getNumEntriesInQueue() <= 0L) goto _L2; else goto _L1
_L1:
        byte abyte0[] = mVolatileQueue.remove();
_L4:
        this;
        JVM INSTR monitorexit ;
        return abyte0;
_L2:
        if (mNonVolatileQueue.getNumEntriesInQueue() > 0L)
        {
            abyte0 = mNonVolatileQueue.remove();
            continue; /* Loop/switch isn't completed */
        }
        abyte0 = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setQueueName(String s)
    {
        mQueueName = s;
    }

}
