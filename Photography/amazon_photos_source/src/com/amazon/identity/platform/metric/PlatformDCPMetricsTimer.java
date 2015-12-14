// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.text.TextUtils;
import com.amazon.client.metrics.MetricEvent;

// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformMetricsTimer

class PlatformDCPMetricsTimer extends PlatformMetricsTimer
{

    private static final String TAG = com/amazon/identity/platform/metric/PlatformDCPMetricsTimer.getName();
    private boolean mDiscard;
    private long mEndTimeNanos;
    private final MetricEvent mMetricEvent;
    private long mStartTimeNanos;
    private String mTimerName;

    PlatformDCPMetricsTimer(MetricEvent metricevent, String s)
    {
        mStartTimeNanos = -1L;
        mEndTimeNanos = -1L;
        mDiscard = false;
        mMetricEvent = metricevent;
        mTimerName = s;
    }

    public void discard()
    {
        mDiscard = true;
    }

    public void setTimerName(String s)
    {
        mTimerName = s;
    }

    public void start()
    {
        mStartTimeNanos = System.nanoTime();
    }

    public void stop()
    {
        if (TextUtils.isEmpty(mTimerName))
        {
            String s = TAG;
            return;
        }
        if (mDiscard)
        {
            String s1 = TAG;
            (new StringBuilder("Timer already discarded : ")).append(mTimerName).toString();
            return;
        }
        if (mStartTimeNanos < 0L)
        {
            String s2 = TAG;
            (new StringBuilder("Timer not started : ")).append(mTimerName).toString();
            return;
        }
        long l;
        if (mEndTimeNanos > 0L)
        {
            l = mEndTimeNanos - mStartTimeNanos;
        } else
        {
            l = System.nanoTime() - mStartTimeNanos;
        }
        mStartTimeNanos = -1L;
        mEndTimeNanos = -1L;
        mMetricEvent.addTimer(mTimerName, (double)l / 1000000D);
    }

    public void stopAndDiscard()
    {
        stop();
        discard();
    }

    public void stopClock()
    {
        mEndTimeNanos = System.nanoTime();
    }

}
