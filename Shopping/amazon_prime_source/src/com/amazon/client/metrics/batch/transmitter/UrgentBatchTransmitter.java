// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.transmitter;

import android.content.Context;
import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.batch.queue.ByteArrayQueue;
import com.amazon.client.metrics.batch.queue.ByteArrayQueueListener;
import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.client.metrics.transport.MetricsTransport;
import com.amazon.client.metrics.transport.TransportStateNotifier;
import com.amazon.dp.logger.DPLogger;

// Referenced classes of package com.amazon.client.metrics.batch.transmitter:
//            PeriodicBatchTransmitter, UploadResultBroadcaster

public class UrgentBatchTransmitter extends PeriodicBatchTransmitter
    implements ByteArrayQueueListener, com.amazon.client.metrics.transport.TransportStateNotifier.TransportWarmedListener
{

    private static final DPLogger log = new DPLogger("Metrics:UrgentBatchTransmitter");

    public UrgentBatchTransmitter(ByteArrayQueue bytearrayqueue, MetricsTransport metricstransport, UploadResultBroadcaster uploadresultbroadcaster, BatchPipelineConfiguration batchpipelineconfiguration, PeriodicMetricReporter periodicmetricreporter, long l, 
            Context context)
    {
        super(bytearrayqueue, metricstransport, uploadresultbroadcaster, batchpipelineconfiguration, periodicmetricreporter, l, context);
        if (metricstransport instanceof TransportStateNotifier)
        {
            ((TransportStateNotifier)metricstransport).listenForTransportWarmed(this);
            bytearrayqueue.addListener(this);
            return;
        } else
        {
            throw new IllegalArgumentException("Unsupported MetricsTransport. TransportStateNotifier expected.");
        }
    }

    public void notifyTransportWarmed()
    {
        log.verbose("notifyTransportWarmed", "Notified that the transport is warm. Attempting to send batches.", new Object[0]);
        transmitBatches(false);
    }

    public void onInsert(long l, long l1)
    {
        log.verbose("onInsert", "attempting transmission of batches", new Object[0]);
        transmitBatches(false);
    }

}
