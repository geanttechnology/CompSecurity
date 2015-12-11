// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.metrics;

import android.app.Activity;
import android.util.Log;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.shopapp.voice.module.VoiceContext;
import com.amazon.shopapp.voice.module.VoiceInitSettings;

// Referenced classes of package com.amazon.shopapp.voice.metrics:
//            VoiceSearchMetric

public class VoiceSearchMetricsRecorder
{
    private static class EventTimer
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


        public EventTimer(MetricsFactory metricsfactory, String s)
        {
            mMetricsFactory = metricsfactory;
            mName = s;
        }
    }


    protected static final String SOURCE_NAME = "VoiceSearch";
    private static final String TAG = com/amazon/shopapp/voice/metrics/VoiceSearchMetricsRecorder.getSimpleName();
    private MetricsFactory mMetricsFactory;
    private EventTimer mReadyTimer;
    private EventTimer mRecognitionTimer;
    private EventTimer mRequestTimer;

    public VoiceSearchMetricsRecorder(Activity activity)
    {
        mMetricsFactory = VoiceContext.getInstance().getMetricsFactory();
    }

    private String getProgramName()
    {
        return VoiceContext.getSettings().getProgramName();
    }

    public void recordManualEndpoint()
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            MetricEvent metricevent = mMetricsFactory.createMetricEvent(getProgramName(), "VoiceSearch");
            metricevent.addCounter(VoiceSearchMetric.MANUAL_ENDPOINT.getName(), 1.0D);
            mMetricsFactory.record(metricevent);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void recordStartVoiceSearchDialog(Activity activity, boolean flag)
    {
        if (flag)
        {
            try
            {
                recordVoiceSearchFromContexMenu();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                Log.e(TAG, "Error", activity);
            }
            break MISSING_BLOCK_LABEL_37;
        }
        if (activity.getLocalClassName().contains("SearchActivity"))
        {
            recordVoiceSearchFromSearchResults();
            return;
        }
        break MISSING_BLOCK_LABEL_38;
        return;
        recordVoiceSearchFromNav();
        return;
    }

    public void recordTryAgain(com.amazon.shopapp.voice.search.ui.VoiceSearchDialog.DialogState dialogstate)
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            MetricEvent metricevent = mMetricsFactory.createMetricEvent(getProgramName(), "VoiceSearch");
            metricevent.addCounter(VoiceSearchMetric.RETRY.getName(), 1.0D);
            metricevent.addCounter((new StringBuilder()).append(VoiceSearchMetric.RETRY.getName()).append("_").append(dialogstate).toString(), 1.0D);
            mMetricsFactory.record(metricevent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.amazon.shopapp.voice.search.ui.VoiceSearchDialog.DialogState dialogstate)
        {
            Log.e(TAG, "Error", dialogstate);
        }
    }

    public void recordTypeYourSearch(com.amazon.shopapp.voice.search.ui.VoiceSearchDialog.DialogState dialogstate)
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            MetricEvent metricevent = mMetricsFactory.createMetricEvent(getProgramName(), "VoiceSearch");
            metricevent.addCounter(VoiceSearchMetric.TYPE_SEARCH.getName(), 1.0D);
            metricevent.addCounter((new StringBuilder()).append(VoiceSearchMetric.TYPE_SEARCH.getName()).append("_").append(dialogstate).toString(), 1.0D);
            mMetricsFactory.record(metricevent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.amazon.shopapp.voice.search.ui.VoiceSearchDialog.DialogState dialogstate)
        {
            Log.e(TAG, "Error", dialogstate);
        }
    }

    public void recordVoiceSearch()
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            MetricEvent metricevent = mMetricsFactory.createMetricEvent(getProgramName(), "VoiceSearch");
            metricevent.addCounter(VoiceSearchMetric.VOICE_SEARCH.getName(), 1.0D);
            mMetricsFactory.record(metricevent);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void recordVoiceSearchFromContexMenu()
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            MetricEvent metricevent = mMetricsFactory.createMetricEvent(getProgramName(), "VoiceSearch");
            metricevent.addCounter(VoiceSearchMetric.CONTEXT_MENU.getName(), 1.0D);
            mMetricsFactory.record(metricevent);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void recordVoiceSearchFromNav()
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            MetricEvent metricevent = mMetricsFactory.createMetricEvent(getProgramName(), "VoiceSearch");
            metricevent.addCounter(VoiceSearchMetric.NAV.getName(), 1.0D);
            mMetricsFactory.record(metricevent);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void recordVoiceSearchFromSearchResults()
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            MetricEvent metricevent = mMetricsFactory.createMetricEvent(getProgramName(), "VoiceSearch");
            metricevent.addCounter(VoiceSearchMetric.SEARCH_VIEW.getName(), 1.0D);
            mMetricsFactory.record(metricevent);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void recordVoiceSearchResults(com.amazon.shopapp.voice.search.VoiceResult.Status status)
    {
        if (mMetricsFactory == null)
        {
            return;
        }
        try
        {
            MetricEvent metricevent = mMetricsFactory.createMetricEvent(getProgramName(), "VoiceSearch");
            metricevent.addCounter(VoiceSearchMetric.ASR_RESULT.getName(), 1.0D);
            metricevent.addCounter((new StringBuilder()).append(VoiceSearchMetric.ASR_RESULT.getName()).append("_").append(status).toString(), 1.0D);
            mMetricsFactory.record(metricevent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.amazon.shopapp.voice.search.VoiceResult.Status status)
        {
            Log.e(TAG, "Error", status);
        }
    }

    public void startReadyTimer()
    {
        try
        {
            mReadyTimer = new EventTimer(mMetricsFactory, VoiceSearchMetric.READY_TIME.getName());
            mReadyTimer.start();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void startRecognitionTimer()
    {
        try
        {
            mRecognitionTimer = new EventTimer(mMetricsFactory, VoiceSearchMetric.RECOGNITION_TIME.getName());
            mRecognitionTimer.start();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void startRequestTimer()
    {
        try
        {
            mRequestTimer = new EventTimer(mMetricsFactory, VoiceSearchMetric.REQUEST_TIME.getName());
            mRequestTimer.start();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
    }

    public void stopReadyTimer()
    {
        if (mReadyTimer == null)
        {
            Log.e(TAG, "Ready timer is null");
            return;
        }
        try
        {
            mReadyTimer.stop();
            mReadyTimer = null;
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }

    public void stopRecognitionTimer()
    {
        if (mRecognitionTimer == null)
        {
            Log.e(TAG, "Recognition timer is null");
            return;
        }
        try
        {
            mRecognitionTimer.stop();
            mRecognitionTimer = null;
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }

    public void stopRequestTimer()
    {
        if (mRequestTimer == null)
        {
            Log.e(TAG, "Request timer is null");
            return;
        }
        try
        {
            mRequestTimer.stop();
            mRequestTimer = null;
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Error", exception);
        }
        return;
    }

}
