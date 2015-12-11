// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.amazon.client.metrics.MetricEntry;
import com.dp.framework.CodecException;

// Referenced classes of package com.amazon.client.metrics.codec:
//            MetricEntryCodec, StringEncodedMetricEntry, EncodedMetricEntry

public class MetricEntryToStringCodec
    implements MetricEntryCodec
{

    public MetricEntryToStringCodec()
    {
    }

    public EncodedMetricEntry encode(MetricEntry metricentry)
        throws CodecException
    {
        return new StringEncodedMetricEntry(metricentry.toString());
    }
}
