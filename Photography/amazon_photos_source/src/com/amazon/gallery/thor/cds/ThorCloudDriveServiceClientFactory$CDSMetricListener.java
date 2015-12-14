// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import com.amazon.clouddrive.extended.AmazonCloudDriveExtendedClient;
import com.amazon.clouddrive.metrics.MetricEvent;
import com.amazon.clouddrive.metrics.MetricListener;
import com.amazon.gallery.foundation.metrics.Profiler;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ThorCloudDriveServiceClientFactory

private static class profiler
    implements MetricListener
{

    private final Profiler profiler;

    public void onMetricEvent(MetricEvent metricevent)
    {
        profiler.trackTimer(com/amazon/clouddrive/extended/AmazonCloudDriveExtendedClient.getSimpleName(), metricevent.getOperationName(), metricevent.getTimeInMillis(), metricevent.hasSucceeded());
    }

    public (Profiler profiler1)
    {
        profiler = profiler1;
    }
}
