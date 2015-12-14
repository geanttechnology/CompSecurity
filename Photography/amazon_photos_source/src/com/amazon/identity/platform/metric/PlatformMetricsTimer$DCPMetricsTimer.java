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
        String s = TAG;
        (new StringBuilder("Discarding timer: ")).append(mTimerName).toString();
        mDiscard = true;
    }

    public void setTimerName(String s)
    {
        mTimerName = s;
    }

    public void start()
    {
        String s = TAG;
        (new StringBuilder("Starting timer: ")).append(mTimerName).append(" ").append(mMetricComponent).toString();
        mStart = System.nanoTime();
    }

    public void stop()
    {
        String s;
        if (TextUtils.isEmpty(mTimerName))
        {
            s = TAG;
        } else
        if (!mDiscard)
        {
            if (mStart < 0L)
            {
                String s1 = TAG;
                (new StringBuilder("Timer not started: ")).append(mTimerName).toString();
                return;
            }
            String s2;
            long l;
            if (mEnd > 0L)
            {
                l = (mEnd - mStart) / 0xf4240L;
            } else
            {
                l = (System.nanoTime() - mStart) / 0xf4240L;
            }
            s2 = TAG;
            (new StringBuilder("Stopping timer: ")).append(mTimerName).toString();
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
