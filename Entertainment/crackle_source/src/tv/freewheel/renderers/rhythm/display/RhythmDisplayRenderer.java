// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.rhythm.display;

import android.view.ViewGroup;
import com.rhythmnewmedia.sdk.display.AdView;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.rhythm.display:
//            RhythmBaseRenderer

public class RhythmDisplayRenderer extends RhythmBaseRenderer
{

    public RhythmDisplayRenderer()
    {
    }

    protected void _postLoad()
    {
        logger.debug("_postLoad");
        super._postLoad();
        context.dispatchEvent(constants.EVENT_AD_LOADED());
    }

    public void onAdReady(AdView adview)
    {
        super.countOfOnAdReady = super.countOfOnAdReady + 1;
        if (super.countOfOnAdReady > 1)
        {
            logger.warn("More than 1 onAdReady triggered!");
            return;
        } else
        {
            logger.info("AdEventListener, onAdReady");
            super.onAdReady(adview);
            super.adView.setVisibility(0);
            slotBase.addView(super.adView);
            logger.info("onAdReady, Send ad impression");
            context.dispatchEvent(constants.EVENT_AD_STARTED());
            return;
        }
    }

    public void run()
    {
        logger.debug("start to run...");
        super.run();
        super.adView = new AdView(super.context.getActivity());
        super.adView.setAdEventListener(this);
        super.adView.requestNewAd();
    }

    public void stop()
    {
        logger.info("stop");
        super.stop();
        context.dispatchEvent(constants.EVENT_AD_STOPPED());
    }
}
