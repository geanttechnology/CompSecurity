// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformMetricsTimer, PlatformMetricsCollector

static final class mEnd extends PlatformMetricsTimer
{

    private static final String TAG = com/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer.getName();
    private final PlatformMetricsCollector mCollector;
    private boolean mDiscard;
    private long mEnd;
    private final String mMetricComponent;
    private long mStart;
    private String mTimerName;

    public void discard()
    {
        (new StringBuilder("Discarding timer: ")).append(mTimerName);
        mDiscard = true;
    }

    public void setTimerName(String s)
    {
        mTimerName = s;
    }

    public void start()
    {
        (new StringBuilder("Starting timer: ")).append(mTimerName).append(" ").append(mMetricComponent);
        mStart = System.nanoTime();
    }

    public void stop()
    {
        while (TextUtils.isEmpty(mTimerName) || mDiscard) 
        {
            return;
        }
        if (mStart < 0L)
        {
            (new StringBuilder("Timer not started: ")).append(mTimerName);
            return;
        }
        long l;
        if (mEnd > 0L)
        {
            l = (mEnd - mStart) / 0xf4240L;
        } else
        {
            l = (System.nanoTime() - mStart) / 0xf4240L;
        }
        (new StringBuilder("Stopping timer: ")).append(mTimerName);
        mStart = -1L;
        mEnd = -1L;
        if (mCollector == null)
        {
            MAPLog.w(TAG, "Could not record timer because no collector was set");
            return;
        } else
        {
            mCollector.recordMetricTimerEvent(mMetricComponent, mTimerName, l);
            return;
        }
    }

    public void stopAndDiscard()
    {
        stop();
        discard();
    }

    public void stopClock()
    {
        mEnd = System.nanoTime();
    }


    public (PlatformMetricsCollector platformmetricscollector, String s, String s1)
    {
        mDiscard = false;
        mCollector = platformmetricscollector;
        mMetricComponent = s;
        mTimerName = s1;
        mStart = -1L;
        mEnd = -1L;
    }
}
