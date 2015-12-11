// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.amazon.client.metrics.DataPoint;
import com.amazon.client.metrics.DataPointType;
import com.amazon.client.metrics.MetricEntry;
import com.dp.framework.CodecException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.codec:
//            MetricEntryCodec, ProtocolBuffersEncodedMetricEntry, EncodedMetricEntry

public class MetricEntryProtocolBuffersCodec
    implements MetricEntryCodec
{

    public MetricEntryProtocolBuffersCodec()
    {
    }

    private static DeviceMetricsMessage.DataPointMessage.DataType getDataType(DataPointType datapointtype)
        throws CodecException
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$client$metrics$DataPointType[];

            static 
            {
                $SwitchMap$com$amazon$client$metrics$DataPointType = new int[DataPointType.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.CT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.TI.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.DV.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.CK.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.client.metrics.DataPointType[datapointtype.ordinal()])
        {
        default:
            throw new CodecException("Invalid DataPoint type");

        case 1: // '\001'
            return DeviceMetricsMessage.DataPointMessage.DataType.COUNTER;

        case 2: // '\002'
            return DeviceMetricsMessage.DataPointMessage.DataType.TIMER;

        case 3: // '\003'
            return DeviceMetricsMessage.DataPointMessage.DataType.DISCRETE;

        case 4: // '\004'
            return DeviceMetricsMessage.DataPointMessage.DataType.CLICKSTREAM;
        }
    }

    public EncodedMetricEntry encode(MetricEntry metricentry)
        throws CodecException
    {
        if (metricentry == null)
        {
            throw new CodecException("Metric entry is null");
        }
        if (metricentry.getDatapoints().size() == 0)
        {
            throw new CodecException("Metric entry contains no data points");
        }
        DeviceMetricsMessage.MetricEntryMessage.Builder builder = DeviceMetricsMessage.MetricEntryMessage.newBuilder().setProgram(metricentry.getProgram()).setSource(metricentry.getSource()).setTimestamp(metricentry.getTimestamp());
        DataPoint datapoint;
        for (metricentry = metricentry.getDatapoints().iterator(); metricentry.hasNext(); builder.addDataPoint(DeviceMetricsMessage.DataPointMessage.newBuilder().setName(datapoint.getName()).setValue(datapoint.getValue()).setSampleSize(datapoint.getSamples()).setType(getDataType(datapoint.getType())).build()))
        {
            datapoint = (DataPoint)metricentry.next();
        }

        return new ProtocolBuffersEncodedMetricEntry(builder.build());
    }
}
