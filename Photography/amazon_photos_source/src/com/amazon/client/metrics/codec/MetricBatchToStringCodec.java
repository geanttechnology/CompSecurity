// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.amazon.client.metrics.MetricBatch;
import com.dp.framework.CodecException;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.amazon.client.metrics.codec:
//            MetricBatchCodec

public class MetricBatchToStringCodec
    implements MetricBatchCodec
{

    public MetricBatchToStringCodec()
    {
    }

    public byte[] encode(MetricBatch metricbatch)
        throws CodecException
    {
        try
        {
            metricbatch = (new StringBuilder()).append(metricbatch.toString()).append("\n").toString().getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (MetricBatch metricbatch)
        {
            throw new CodecException(metricbatch);
        }
        return metricbatch;
    }
}
