// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdView, InterstitialAd, AdData, MetricsCollector

class this._cls0
    implements AdView
{

    final InterstitialAd this$0;

    public int getHeight()
    {
        return 0;
    }

    public rlExecutor getSpecialUrlExecutor()
    {
        return null;
    }

    public boolean isAdViewRenderable()
    {
        return true;
    }

    public boolean launchExternalBrowserForLink(String s)
    {
        return false;
    }

    public void onPageFinished()
    {
        long l = System.nanoTime();
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(e.AD_LATENCY_RENDER, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(e.AD_LATENCY_TOTAL, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(e.AD_LATENCY_TOTAL_SUCCESS, l);
        onAdPrerendered();
    }

    public boolean shouldDisableWebViewHardwareAcceleration()
    {
        return false;
    }

    rlExecutor()
    {
        this$0 = InterstitialAd.this;
        super();
    }
}
