// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.rhythm.display;

import android.app.Activity;
import android.os.Handler;
import com.rhythmnewmedia.sdk.display.AdView;
import com.rhythmnewmedia.sdk.display.InterstitialAdView;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.renderers.rhythm.Parameters;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.rhythm.display:
//            RhythmBaseRenderer

public class RhythmTakeoverRenderer extends RhythmBaseRenderer
{

    private IActivityCallbackListener activityCallbackListener;

    public RhythmTakeoverRenderer()
    {
    }

    protected void _postLoad()
    {
        logger.debug("_postLoad");
        super._postLoad();
        super.adView = new InterstitialAdView(super.context.getActivity());
        ((InterstitialAdView)super.adView).setAdEventListener(this);
        if (Parameters.getTargeting() != null)
        {
            ((InterstitialAdView)super.adView).setTargeting(Parameters.getTargeting());
        }
        (new Handler(context.getActivity().getMainLooper())).post(new Runnable() {

            final RhythmTakeoverRenderer this$0;

            public void run()
            {
                ((InterstitialAdView)adView).requestNewAd();
            }

            
            {
                this$0 = RhythmTakeoverRenderer.this;
                super();
            }
        });
    }

    public void dispose()
    {
        logger.info("dispose");
        super.dispose();
        activityCallbackListener = null;
    }

    public volatile void onAdReady(AdView adview)
    {
        onAdReady((InterstitialAdView)adview);
    }

    public void onAdReady(InterstitialAdView interstitialadview)
    {
        super.countOfOnAdReady = super.countOfOnAdReady + 1;
        if (super.countOfOnAdReady > 1)
        {
            logger.warn("More than 1 onAdReady triggered!");
            return;
        } else
        {
            logger.info("onAdReady, Send ad impression");
            super.onAdReady(interstitialadview);
            context.dispatchEvent(constants.EVENT_AD_LOADED());
            return;
        }
    }

    public void run()
    {
        logger.debug("run...");
        ((InterstitialAdView)super.adView).showAsTakeover();
        super.context.dispatchEvent(constants.EVENT_AD_STARTED());
        activityCallbackListener = new IActivityCallbackListener() {

            final RhythmTakeoverRenderer this$0;

            public void onActivityCallback(int i)
            {
                logger.debug((new StringBuilder()).append("onActivityStateChange ").append(i).toString());
                if (i == constants.ACTIVITY_CALLBACK_RESUME())
                {
                    logger.info("context activity resumed, ad has ended");
                    context.dispatchEvent(constants.EVENT_AD_STOPPED());
                }
            }

            
            {
                this$0 = RhythmTakeoverRenderer.this;
                super();
            }
        };
        super.context.addOnActivityCallbackListener(activityCallbackListener);
    }
}
