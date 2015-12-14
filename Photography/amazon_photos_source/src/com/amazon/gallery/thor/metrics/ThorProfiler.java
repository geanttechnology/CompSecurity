// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.metrics;

import com.amazon.client.metrics.MetricsFactory;
import com.amazon.gallery.foundation.metrics.CompositeTimer;
import com.amazon.gallery.foundation.metrics.ProfilerTimer;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.metrics.customer.CustomerMetricsProfiler;
import com.amazon.gallery.foundation.metrics.dcm.DCMProfiler;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.ComponentClickstreamRecorder;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.service.WhisperUploadManager;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.thor.metrics:
//            TrapzTimer

public class ThorProfiler extends DCMProfiler
{

    private ComponentClickstreamRecorder clickstreamRecorder;
    private CustomerMetricsProfiler customerMetricsProfiler;

    public ThorProfiler(MetricsFactory metricsfactory)
    {
        super(metricsfactory);
    }

    private void trackLaunchEvent(String s, String s1)
    {
        if (s.equals(com/amazon/gallery/framework/kindle/activity/LaunchSourceMetrics.getSimpleName()))
        {
            customerMetricsProfiler.setLaunchSource(s1);
        }
    }

    public void endSession()
    {
        customerMetricsProfiler.endSession();
        clickstreamRecorder.recordEvent(com.amazon.gallery.framework.gallery.metrics.SessionMetrics.MetricEvent.SessionStop.toString(), ClickstreamEventHelper.createClickstreamExtra("NavigationEvent", HitType.PAGE_HIT));
        super.endSession();
        ((SyncManager)ThorGalleryApplication.getBean(Keys.SYNC_MANAGER)).scheduleBackgroundSync();
        ((WhisperUploadManager)ThorGalleryApplication.getBean(Keys.WHISPER_UPLOAD_MANAGER)).scheduleBackgroundSync();
    }

    public Timer newTimer(String s, String s1)
    {
        return new CompositeTimer(new Timer[] {
            new ProfilerTimer(this, s, s1), new TrapzTimer(s1)
        });
    }

    public Timer newTimer(String s, String s1, Map map)
    {
        if (ClickstreamEventHelper.isClickstreamEvent(map))
        {
            clickstreamRecorder.recordEvent(s1, map);
        }
        return newTimer(s, s1);
    }

    protected void record(Collection collection, Collection collection1)
    {
        super.record(collection, collection1);
        customerMetricsProfiler.record(collection, collection1);
    }

    public void setClickstreamRecorder(ComponentClickstreamRecorder componentclickstreamrecorder)
    {
        clickstreamRecorder = componentclickstreamrecorder;
    }

    public void setCustomerMetricsProfiler(CustomerMetricsProfiler customermetricsprofiler)
    {
        customerMetricsProfiler = customermetricsprofiler;
    }

    public void startSession()
    {
        super.startSession();
        customerMetricsProfiler.startSession();
        clickstreamRecorder.recordEvent(com.amazon.gallery.framework.gallery.metrics.SessionMetrics.MetricEvent.SessionStart.toString(), ClickstreamEventHelper.createClickstreamExtra("NavigationEvent", HitType.PAGE_HIT));
    }

    public void trackEvent(String s, String s1, Map map)
    {
        super.trackEvent(s, s1, map);
        if (ClickstreamEventHelper.isClickstreamEvent(map))
        {
            clickstreamRecorder.recordEvent(s1, map);
        }
    }

    public void trackEvent(String s, String s1, Map map, boolean flag)
    {
        super.trackEvent(s, s1, map, flag);
        customerMetricsProfiler.trackEvent(s, s1, map);
        trackLaunchEvent(s, s1);
    }

    public void trackTimer(String s, String s1, long l, Map map)
    {
        super.trackTimer(s, s1, l, map);
        if (ClickstreamEventHelper.isClickstreamEvent(map))
        {
            clickstreamRecorder.recordEvent(s1, map);
        }
    }

    public void trackTimer(String s, String s1, long l, Map map, boolean flag)
    {
        super.trackTimer(s, s1, l, map, flag);
        customerMetricsProfiler.trackTimer(s, s1, l, map);
        trackLaunchEvent(s, s1);
    }
}
