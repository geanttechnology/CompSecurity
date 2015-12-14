// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.transmitter;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.NullMetricEvent;
import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.batch.queue.ByteArrayQueue;
import com.amazon.client.metrics.transport.MetricsTransport;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics.batch.transmitter:
//            UploadResultBroadcaster

public abstract class BatchTransmitter
{
    protected class QueuePusher
        implements Runnable
    {

        private boolean mBroadcastResultForCurrentRun;
        private final AtomicBoolean mEnableBroadcastResultForNextRun = new AtomicBoolean(false);
        private final AtomicBoolean mIsActive = new AtomicBoolean(true);
        private final UploadResultBroadcaster mUploadResultBroadcaster;
        final BatchTransmitter this$0;

        private boolean sendBatches(ByteArrayQueue bytearrayqueue)
        {
            String s;
            int i;
            s = bytearrayqueue.getQueueName();
            i = 0;
_L16:
            byte abyte0[] = bytearrayqueue.remove();
            if (abyte0 == null) goto _L2; else goto _L1
_L1:
            int j = mMetricsTransport.transmit(abyte0, BatchTransmitter.NULL_METRIC_EVENT);
            j;
            JVM INSTR tableswitch 1 12: default 813
        //                       1 703
        //                       2 629
        //                       3 370
        //                       4 592
        //                       5 555
        //                       6 666
        //                       7 318
        //                       8 189
        //                       9 407
        //                       10 444
        //                       11 481
        //                       12 518;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L17:
            bytearrayqueue.add(abyte0, false);
            BatchTransmitter.log.info("QueuePusher.sendBatches", (new StringBuilder()).append("Partial number of  ").append(s).append(" queue  batches sent").toString(), new Object[] {
                Integer.valueOf(i)
            });
            if (mBroadcastResultForCurrentRun)
            {
                mUploadResultBroadcaster.broadcastResult(j, i, s);
            }
            mMetricsTransport.close();
            return false;
_L11:
            BatchTransmitter.log.error("QueuePusher.sendBatches", "Batch transmission failed on empty data error, discarded.", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.EMPTY_DATA_ERROR", 1.0D);
              goto _L3
            bytearrayqueue;
            BatchTransmitter.log.error("QueuePusher.sendBatches", (new StringBuilder()).append("Unable to send  ").append(s).append(" queue batches").append(bytearrayqueue).toString(), new Object[0]);
            if (mBroadcastResultForCurrentRun)
            {
                mUploadResultBroadcaster.broadcastResult(-1, 0, s);
            }
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("QueuePusher.BATCH_FAILURE", 1.0D);
            mMetricsTransport.close();
            return false;
_L10:
            BatchTransmitter.log.warn("QueuePusher.sendBatches", "Batch transmission failed due to no usable connection, re-enqueuing batch", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.NO_USABLE_CONNECTION", 1.0D);
              goto _L3
            bytearrayqueue;
            mMetricsTransport.close();
            throw bytearrayqueue;
_L6:
            BatchTransmitter.log.error("QueuePusher.sendBatches", "Batch transmission failed on client error, discarded.", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.CLIENT_ERROR", 1.0D);
              goto _L3
_L12:
            BatchTransmitter.log.error("QueuePusher.sendBatches", "Batch transmission failed on RequestFailedException, re-enqueuing batch.", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.REQUEST_FAILED_ERROR", 1.0D);
              goto _L3
_L13:
            BatchTransmitter.log.error("QueuePusher.sendBatches", "Batch transmission failed on IOException, discarded.", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.IO_ERROR", 1.0D);
              goto _L3
_L14:
            BatchTransmitter.log.error("QueuePusher.sendBatches", "Batch transmission failed on IllegalAccessException, discarded.", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.ILLEGAL_ACCESS_ERROR", 1.0D);
              goto _L3
_L15:
            BatchTransmitter.log.error("QueuePusher.sendBatches", "Batch transmission failed on no http response, re-enqueuing batch.", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.NO_RESPONSE_ERROR", 1.0D);
              goto _L3
_L8:
            BatchTransmitter.log.warn("QueuePusher.sendBatches", "Batch transmission failed on credentials error, re-enqueuing batch.", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.CREDENTIALS_ERROR", 1.0D);
              goto _L3
_L7:
            BatchTransmitter.log.warn("QueuePusher.sendBatches", "Batch transmission failed on server error, re-enqueuing batch", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.SERVER_ERROR", 1.0D);
              goto _L3
_L5:
            BatchTransmitter.log.warn("QueuePusher.sendBatches", "Batch transmission failed on network error, re-enqueuing batch", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.NETWORK_ERROR", 1.0D);
              goto _L3
_L9:
            BatchTransmitter.log.error("QueuePusher.sendBatches", "Batch transmission failed on unknown error, re-enqueuing batch", new Object[0]);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.UNEXPECTED_ERROR", 1.0D);
              goto _L3
_L4:
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.SUCCESS", 1.0D);
            i++;
              goto _L3
_L2:
            BatchTransmitter.log.info("QueuePusher.sendBatches", "Drained batch queue.", new Object[] {
                (new StringBuilder()).append("Number of ").append(s).append(" queue batches sent").toString(), Integer.valueOf(i)
            });
            if (mBroadcastResultForCurrentRun)
            {
                mUploadResultBroadcaster.broadcastResult(1, i, s);
            }
            mMetricsTransport.close();
            return true;
_L3:
            j;
            JVM INSTR tableswitch 2 12: default 872
        //                       2 104
        //                       3 872
        //                       4 104
        //                       5 104
        //                       6 104
        //                       7 104
        //                       8 872
        //                       9 104
        //                       10 872
        //                       11 872
        //                       12 104;
               goto _L16 _L17 _L16 _L17 _L17 _L17 _L17 _L16 _L17 _L16 _L16 _L17
        }

        public void enableBroadcastResultForNextRun()
        {
            mEnableBroadcastResultForNextRun.set(true);
        }

        public void run()
        {
            if (!mIsActive.get())
            {
                BatchTransmitter.log.verbose("QueuePusher.run", "Shutdown invoked.", new Object[0]);
                return;
            } else
            {
                mBroadcastResultForCurrentRun = mEnableBroadcastResultForNextRun.getAndSet(false);
                BatchTransmitter.log.verbose("QueuePusher.run", "Transmitting batches.", new Object[0]);
                sendBatches(mByteArrayQueue);
                return;
            }
        }

        public QueuePusher(UploadResultBroadcaster uploadresultbroadcaster)
        {
            this$0 = BatchTransmitter.this;
            super();
            mUploadResultBroadcaster = uploadresultbroadcaster;
        }
    }


    private static final MetricEvent NULL_METRIC_EVENT = new NullMetricEvent("MetricsService", "BatchTransmitter");
    private static final DPLogger log = new DPLogger("Metrics:BatchTransmitter");
    protected final ByteArrayQueue mByteArrayQueue;
    protected final MetricsTransport mMetricsTransport;
    final PeriodicMetricReporter mPeriodicMetricReporter;
    protected final QueuePusher mQueuePusher;

    public BatchTransmitter(ByteArrayQueue bytearrayqueue, MetricsTransport metricstransport, UploadResultBroadcaster uploadresultbroadcaster, PeriodicMetricReporter periodicmetricreporter)
    {
        mByteArrayQueue = bytearrayqueue;
        mMetricsTransport = metricstransport;
        mQueuePusher = new QueuePusher(uploadresultbroadcaster);
        if (mByteArrayQueue == null)
        {
            throw new IllegalArgumentException("Byte array queue cannot be null");
        }
        if (mMetricsTransport == null)
        {
            throw new IllegalArgumentException("Metrics transport instance cannot be null.");
        } else
        {
            mPeriodicMetricReporter = periodicmetricreporter;
            return;
        }
    }

    public abstract void transmitBatches(boolean flag);



}
