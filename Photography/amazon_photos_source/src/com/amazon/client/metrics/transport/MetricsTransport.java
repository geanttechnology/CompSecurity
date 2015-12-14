// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;

import com.amazon.client.metrics.MetricEvent;

public interface MetricsTransport
{

    public abstract void close();

    public abstract int transmit(byte abyte0[], MetricEvent metricevent);
}
