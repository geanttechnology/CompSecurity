// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.client.metrics.MetricEvent;

public interface BandwidthToolByteAccountant
{

    public static final String SYSTEM_SERVICE_KEY = "com.amazon.communication.BandwidthToolByteAccountant";

    public abstract boolean accountBytesReceived(int i, long l, MetricEvent metricevent);

    public abstract boolean accountBytesTransmitted(int i, long l, MetricEvent metricevent);
}
