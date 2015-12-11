// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.transmitter;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.batch.queue.ByteArrayQueue;
import com.amazon.client.metrics.transport.MetricsTransport;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics.batch.transmitter:
//            BatchTransmitter, UploadResultBroadcaster

protected class mUploadResultBroadcaster
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
        boolean flag;
        int i;
        s = bytearrayqueue.getQueueName();
        i = 0;
        flag = false;
_L22:
        byte abyte0[] = bytearrayqueue.remove();
        if (abyte0 == null || flag) goto _L2; else goto _L1
_L1:
        int j = mMetricsTransport.transmit(abyte0, BatchTransmitter.access$100());
        j;
        JVM INSTR tableswitch 1 12: default 838
    //                   1 700
    //                   2 626
    //                   3 367
    //                   4 589
    //                   5 552
    //                   6 663
    //                   7 315
    //                   8 186
    //                   9 404
    //                   10 441
    //                   11 478
    //                   12 515;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L20:
        try
        {
            bytearrayqueue.add(abyte0, false);
            BatchTransmitter.access$000().info("QueuePusher.sendBatches", (new StringBuilder()).append("Partial number of  ").append(s).append(" queue  batches sent").toString(), new Object[] {
                Integer.valueOf(i)
            });
            if (mBroadcastResultForCurrentRun)
            {
                mUploadResultBroadcaster.broadcastResult(j, i, s);
            }
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayQueue bytearrayqueue) { }
        finally
        {
            mMetricsTransport.close();
            throw bytearrayqueue;
        }
          goto _L16
_L11:
        BatchTransmitter.access$000().error("QueuePusher.sendBatches", "Batch transmission failed on empty data error, discarded.", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.EMPTY_DATA_ERROR", 1.0D);
          goto _L3
_L16:
        BatchTransmitter.access$000().error("QueuePusher.sendBatches", (new StringBuilder()).append("Unable to send  ").append(s).append(" queue batches").append(bytearrayqueue).toString(), new Object[0]);
        if (mBroadcastResultForCurrentRun)
        {
            mUploadResultBroadcaster.broadcastResult(-1, 0, s);
        }
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("QueuePusher.BATCH_FAILURE", 1.0D);
        mMetricsTransport.close();
        return false;
_L10:
        BatchTransmitter.access$000().warn("QueuePusher.sendBatches", "Batch transmission failed due to no usable connection, re-enqueuing batch", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.NO_USABLE_CONNECTION", 1.0D);
          goto _L3
_L6:
        BatchTransmitter.access$000().error("QueuePusher.sendBatches", "Batch transmission failed on client error, discarded.", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.CLIENT_ERROR", 1.0D);
          goto _L3
_L12:
        BatchTransmitter.access$000().error("QueuePusher.sendBatches", "Batch transmission failed on RequestFailedException, re-enqueuing batch.", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.REQUEST_FAILED_ERROR", 1.0D);
          goto _L3
_L13:
        BatchTransmitter.access$000().error("QueuePusher.sendBatches", "Batch transmission failed on IOException, discarded.", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.IO_ERROR", 1.0D);
          goto _L3
_L14:
        BatchTransmitter.access$000().error("QueuePusher.sendBatches", "Batch transmission failed on IllegalAccessException, discarded.", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.ILLEGAL_ACCESS_ERROR", 1.0D);
          goto _L3
_L15:
        BatchTransmitter.access$000().error("QueuePusher.sendBatches", "Batch transmission failed on no http response, re-enqueuing batch.", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.NO_RESPONSE_ERROR", 1.0D);
          goto _L3
_L8:
        BatchTransmitter.access$000().warn("QueuePusher.sendBatches", "Batch transmission failed on credentials error, re-enqueuing batch.", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.CREDENTIALS_ERROR", 1.0D);
          goto _L3
_L7:
        BatchTransmitter.access$000().warn("QueuePusher.sendBatches", "Batch transmission failed on server error, re-enqueuing batch", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.SERVER_ERROR", 1.0D);
          goto _L3
_L5:
        BatchTransmitter.access$000().warn("QueuePusher.sendBatches", "Batch transmission failed on network error, re-enqueuing batch", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.NETWORK_ERROR", 1.0D);
          goto _L3
_L9:
        BatchTransmitter.access$000().error("QueuePusher.sendBatches", "Batch transmission failed on unknown error, re-enqueuing batch", new Object[0]);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.UNEXPECTED_ERROR", 1.0D);
          goto _L3
_L4:
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.SUCCESS", 1.0D);
        i++;
          goto _L3
_L2:
        if (i <= 0) goto _L18; else goto _L17
_L17:
        updateActiveUploadStats();
_L18:
        if (flag)
        {
            mMetricsTransport.close();
            return false;
        }
        BatchTransmitter.access$000().info("QueuePusher.sendBatches", "Drained batch queue.", new Object[] {
            (new StringBuilder()).append("Number of ").append(s).append(" queue batches sent").toString(), Integer.valueOf(i)
        });
        if (mBroadcastResultForCurrentRun)
        {
            mUploadResultBroadcaster.broadcastResult(1, i, s);
        }
        mMetricsTransport.close();
        return true;
_L3:
        switch (j)
        {
        case 3: // '\003'
        case 8: // '\b'
        case 10: // '\n'
        case 11: // '\013'
        default:
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 9: // '\t'
        case 12: // '\f'
            break;
        }
        if (true) goto _L20; else goto _L19
_L19:
        flag = true;
        if (true) goto _L22; else goto _L21
_L21:
    }

    private void updateActiveUploadStats()
    {
        SharedPreferences sharedpreferences = BatchTransmitter.access$200(BatchTransmitter.this).getSharedPreferences("ActiveUploadStats", 0);
        Calendar calendar = Calendar.getInstance();
        android.content.atchTransmitter atchtransmitter = sharedpreferences.edit();
        int i = calendar.get(6);
        int j = calendar.get(3);
        int k = calendar.get(2);
        if (sharedpreferences.getInt("lastUploadDay", -1) != i)
        {
            atchtransmitter.nt("lastUploadDay", i);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.DAILY_ACTIVE_UPLOADS", 1.0D);
        }
        if (sharedpreferences.getInt("lastUploadWeek", -1) != j)
        {
            atchtransmitter.nt("lastUploadWeek", j);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.WEEKLY_ACTIVE_UPLOADS", 1.0D);
        }
        if (sharedpreferences.getInt("lastUploadMonth", -1) != k)
        {
            atchtransmitter.nt("lastUploadMonth", k);
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("MetricsTransport.MONTHLY_ACTIVE_UPLOADS", 1.0D);
        }
        atchtransmitter.y();
    }

    public void enableBroadcastResultForNextRun()
    {
        mEnableBroadcastResultForNextRun.set(true);
    }

    public void run()
    {
        if (!mIsActive.get())
        {
            BatchTransmitter.access$000().verbose("QueuePusher.run", "Shutdown invoked.", new Object[0]);
            return;
        } else
        {
            mBroadcastResultForCurrentRun = mEnableBroadcastResultForNextRun.getAndSet(false);
            BatchTransmitter.access$000().verbose("QueuePusher.run", "Transmitting batches.", new Object[0]);
            sendBatches(mByteArrayQueue);
            return;
        }
    }

    public void shutdown()
    {
        mIsActive.set(false);
    }

    public (UploadResultBroadcaster uploadresultbroadcaster)
    {
        this$0 = BatchTransmitter.this;
        super();
        mUploadResultBroadcaster = uploadresultbroadcaster;
    }
}
