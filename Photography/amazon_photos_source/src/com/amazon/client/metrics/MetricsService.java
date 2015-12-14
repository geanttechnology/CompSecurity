// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.batch.creator.BatchCreator;
import com.amazon.client.metrics.batch.transmitter.BatchTransmitter;
import com.amazon.client.metrics.trigger.TriggerEvaluator;
import com.amazon.dp.logger.DPLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics:
//            UploadIntentListener, MetricsBroadcastReceiver, Priority, MetricEntry

public class MetricsService
    implements UploadIntentListener
{

    private static final DPLogger log = new DPLogger();
    private final Map mBatchCreatorMap;
    private final List mBatchTransmitterList;
    private final TriggerEvaluator mTriggerEvaluator;

    public MetricsService(Map map, List list, TriggerEvaluator triggerevaluator)
    {
        mBatchCreatorMap = map;
        mBatchTransmitterList = list;
        mTriggerEvaluator = triggerevaluator;
        MetricsBroadcastReceiver.addUploadIntentListener(this);
    }

    public void onUploadIntentReceived()
    {
        log.info("onUploadIntentReceived", "Enqueuing all batches and triggering transmission.", new Object[0]);
        for (Iterator iterator = mBatchCreatorMap.values().iterator(); iterator.hasNext(); ((BatchCreator)iterator.next()).enqueueBatchForTransmission()) { }
        for (Iterator iterator1 = mBatchTransmitterList.iterator(); iterator1.hasNext(); ((BatchTransmitter)iterator1.next()).transmitBatches(true)) { }
    }

    public void record(Priority priority, MetricEntry metricentry)
    {
        if (mTriggerEvaluator != null)
        {
            mTriggerEvaluator.evaluate(metricentry);
        }
        BatchCreator batchcreator = (BatchCreator)mBatchCreatorMap.get(priority);
        if (batchcreator != null)
        {
            batchcreator.addMetricEntry(metricentry);
            return;
        } else
        {
            log.error("record", "Metric dropped. No batch pipeline exists at priority level.", new Object[] {
                "priority", priority
            });
            return;
        }
    }

}
