// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.amazon.client.metrics.MetricBatch;
import com.dp.framework.CodecException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.client.metrics.codec:
//            MetricBatchCodec, EncodedMetricEntry

public class MetricBatchProtocolBuffersCodec
    implements MetricBatchCodec
{

    public MetricBatchProtocolBuffersCodec()
    {
    }

    public byte[] encode(MetricBatch metricbatch)
        throws CodecException
    {
        if (metricbatch == null)
        {
            throw new CodecException("MetricEntryBatch is null");
        }
        if (metricbatch.getBatchSizeInBytes() == 0L)
        {
            throw new CodecException("MetricEntryBatch is empty");
        }
        DeviceMetricsMessage.MetricBatchMessage.Builder builder = DeviceMetricsMessage.MetricBatchMessage.newBuilder();
        builder.setDeviceSerialNumber(metricbatch.getDeviceSerialNumber());
        if (metricbatch.getDeviceType() != null)
        {
            builder.setDeviceType(metricbatch.getDeviceType());
        }
        Iterator iterator = metricbatch.getDeviceInfoMap().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getValue() != null)
            {
                builder.addMetadata(DeviceMetricsMessage.KeyValue.newBuilder().setKey((String)entry.getKey()).setValue((String)entry.getValue()).build());
            }
        } while (true);
        for (int i = 0; i < metricbatch.getMetricEntryCount(); i++)
        {
            builder.addMetricEntry((DeviceMetricsMessage.MetricEntryMessage)metricbatch.getMetricEntry(i).getEncodedMetricEntry());
        }

        metricbatch = builder.build().toByteArray();
        if (metricbatch == null)
        {
            throw new CodecException("serialized batch is null");
        }
        if (metricbatch.length == 0)
        {
            throw new CodecException("serialized batch is empty");
        } else
        {
            return metricbatch;
        }
    }
}
