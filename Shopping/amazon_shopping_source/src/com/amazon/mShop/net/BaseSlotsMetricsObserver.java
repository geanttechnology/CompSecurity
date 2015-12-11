// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.List;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsCollector

public abstract class BaseSlotsMetricsObserver extends MetricsAggregator.MetricEvent
{

    private boolean eventAddedToQueue;
    private List mSlotTokens;

    public BaseSlotsMetricsObserver()
    {
        eventAddedToQueue = false;
    }

    public List getSlotTokens()
    {
        return mSlotTokens;
    }

    public void postSlotTokens(List list)
    {
        if (!eventAddedToQueue)
        {
            mSlotTokens = list;
            MetricsCollector.queueEvent(this);
            eventAddedToQueue = true;
        }
    }
}
