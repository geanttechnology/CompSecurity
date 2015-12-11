// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.amazon.client.metrics.MetricBatch;
import com.dp.framework.CodecException;

public interface MetricBatchCodec
{

    public abstract byte[] encode(MetricBatch metricbatch)
        throws CodecException;
}
