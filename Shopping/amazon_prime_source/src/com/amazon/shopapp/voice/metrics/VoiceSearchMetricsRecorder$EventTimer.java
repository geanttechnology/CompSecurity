// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.metrics;

import android.util.Log;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.shopapp.voice.module.VoiceContext;
import com.amazon.shopapp.voice.module.VoiceInitSettings;

// Referenced classes of package com.amazon.shopapp.voice.metrics:
//            VoiceSearchMetricsRecorder

private static class mName
{

    private static final String TAG = com/amazon/shopapp/voice/metrics/VoiceSearchMetricsRecorder$EventTimer.getSimpleName();
    private MetricEvent mEvent;
    private MetricsFactory mMetricsFactory;
    private String mName;

    public void start()
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            mEvent = mMetricsFactory.createMetricEvent(VoiceContext.getSettings().getProgramName(), "VoiceSearch");
            mEvent.startTimer(mName);
            return;
        }
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
        }
        return;
    }

    public void stop()
    {
        try
        {
            if (mMetricsFactory == null)
            {
                return;
            }
        }
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
            return;
        }
        if (mEvent == null)
        {
            Log.e(TAG, "mEvent is null");
            return;
        }
        mEvent.stopTimer(mName);
        mMetricsFactory.record(mEvent);
        return;
    }


    public (MetricsFactory metricsfactory, String s)
    {
        mMetricsFactory = metricsfactory;
        mName = s;
    }
}
