// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            AdController, AmazonOOAdListener, AmazonOOActionCode, AmazonOOAdResponse, 
//            AdError, Metrics, MetricsCollector, AdData, 
//            AdLayout, AdSize, AdListener, DefaultAdListener, 
//            Log, Ad, AdView

class AmazonOOAdController extends AdController
{
    private class DefaultAmazonOOAdListener extends DefaultAdListener
        implements AmazonOOAdListener
    {

        final AmazonOOAdController this$0;

        public AmazonOOActionCode onAdReceived(Ad ad, AmazonOOAdResponse amazonooadresponse)
        {
            Log.d(LOG_TAG, "Default ad listener called - Ad Received.");
            return AmazonOOActionCode.DISPLAY;
        }

        public void onSpecialUrlClicked(Ad ad, String s)
        {
            Log.d(LOG_TAG, "Default ad listener called - Special URL clicked. Url: %s", new Object[] {
                s
            });
        }

        public DefaultAmazonOOAdListener()
        {
            this$0 = AmazonOOAdController.this;
            super("AmazonOOAdController");
        }
    }


    private static final String LOG_TAG = "AmazonOOAdController";

    AmazonOOAdController(AdLayout adlayout, AdSize adsize, Context context)
    {
        super(adlayout, adsize, context);
    }

    private AmazonOOAdListener getAmazonOOAdListener()
    {
        AdListener adlistener = getAdListener();
        if (adlistener instanceof AmazonOOAdListener)
        {
            return (AmazonOOAdListener)adlistener;
        } else
        {
            return null;
        }
    }

    protected AdListener createAdListener()
    {
        return new DefaultAmazonOOAdListener();
    }

    public AdWebViewClient.UrlExecutor getSpecialUrlExecutor()
    {
        return new AdWebViewClient.AmazonMobileExecutor(getCurrentAdRenderer(), getContext()) {

            final AmazonOOAdController this$0;

            protected void handleApplicationDefinedSpecialURL(String s)
            {
                AmazonOOAdListener amazonooadlistener = getAmazonOOAdListener();
                if (amazonooadlistener != null)
                {
                    amazonooadlistener.onSpecialUrlClicked(getAdLayout(), s);
                }
            }

            
            {
                this$0 = AmazonOOAdController.this;
                super(adview, context);
            }
        };
    }

    public void handleResponse()
    {
        AmazonOOActionCode amazonooactioncode1 = AmazonOOActionCode.DISPLAY;
        AdData addata = getAdData();
        AmazonOOActionCode amazonooactioncode = amazonooactioncode1;
        if (addata != null)
        {
            AmazonOOAdListener amazonooadlistener = getAmazonOOAdListener();
            amazonooactioncode = amazonooactioncode1;
            if (amazonooadlistener != null)
            {
                amazonooactioncode = amazonooadlistener.onAdReceived(getAdLayout(), new AmazonOOAdResponse(addata));
            }
        }
        amazonooactioncode1 = amazonooactioncode;
        if (amazonooactioncode == null)
        {
            amazonooactioncode1 = AmazonOOActionCode.DISPLAY;
        }
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$device$ads$AmazonOOActionCode[];

            static 
            {
                $SwitchMap$com$amazon$device$ads$AmazonOOActionCode = new int[AmazonOOActionCode.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$ads$AmazonOOActionCode[AmazonOOActionCode.REJECT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$device$ads$AmazonOOActionCode[AmazonOOActionCode.HANDLED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$device$ads$AmazonOOActionCode[AmazonOOActionCode.DISPLAY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.amazon.device.ads.AmazonOOActionCode[amazonooactioncode1.ordinal()])
        {
        default:
            super.handleResponse();
            return;

        case 1: // '\001'
            adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Ad explicitly rejected by host application."));
            return;

        case 2: // '\002'
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.CUSTOM_RENDER_HANDLED);
            break;
        }
        adLoaded(addata.getProperties());
    }

}
