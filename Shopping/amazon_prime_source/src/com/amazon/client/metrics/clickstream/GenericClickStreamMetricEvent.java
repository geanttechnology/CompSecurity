// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import com.amazon.client.metrics.MetricEvent;
import java.util.Collection;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            ClickStreamInfo

public interface GenericClickStreamMetricEvent
    extends MetricEvent
{

    public abstract void addClickStreamInfo(ClickStreamInfo clickstreaminfo);

    public abstract Collection getClickStreamInfo();

    public abstract String getRequestId();

    public abstract void removeClickStreamInfo(Class class1);

    public abstract boolean validateMetricEvent();
}
