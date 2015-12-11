// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.rhythm.display;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import com.rhythmnewmedia.sdk.NoAdReason;
import com.rhythmnewmedia.sdk.display.AdEventAdapter;
import com.rhythmnewmedia.sdk.display.AdView;
import java.util.HashMap;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.renderers.rhythm.Parameters;
import tv.freewheel.utils.Logger;

public class RhythmBaseRenderer extends AdEventAdapter
    implements IRenderer, Runnable
{

    protected AdView adView;
    protected IConstants constants;
    protected IRendererContext context;
    protected int countOfOnAdReady;
    protected Logger logger;
    protected ISlot slot;
    protected ViewGroup slotBase;

    protected RhythmBaseRenderer()
    {
        countOfOnAdReady = 0;
        logger = Logger.getLogger(this);
    }

    protected void _postLoad()
    {
        logger.debug("_postLoad...");
        context.setRendererCapability(constants.EVENT_AD_CLICK(), constants.CAPABILITY_STATUS_OFF());
    }

    public void dispose()
    {
        logger.info("dispose");
        if (slotBase != null)
        {
            (new Handler(context.getActivity().getMainLooper())).post(new Runnable() {

                final RhythmBaseRenderer this$0;

                public void run()
                {
                    slotBase.removeAllViews();
                }

            
            {
                this$0 = RhythmBaseRenderer.this;
                super();
            }
            });
        }
        if (adView != null)
        {
            adView.setAdEventListener(null);
            adView.setAdControlListener(null);
        }
    }

    protected void failWhenNoAd()
    {
        logger.error("failWhenNoAd");
        failWithError(constants.ERROR_NO_AD_AVAILABLE(), "Did not received any Ad from Rhythm NewMedia");
    }

    protected void failWithError(String s, String s1)
    {
        logger.error((new StringBuilder()).append("failWithError errorCode:").append(s).append(", errorMessage:").append(s1).toString());
        Bundle bundle = new Bundle();
        bundle.putString(constants.INFO_KEY_ERROR_CODE(), s);
        bundle.putString(constants.INFO_KEY_ERROR_INFO(), s1);
        s = new HashMap();
        s.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
        context.dispatchEvent(constants.EVENT_ERROR(), s);
    }

    public double getDuration()
    {
        return -1D;
    }

    public HashMap getModuleInfo()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("moduleType", "renderer");
        hashmap.put("requiredAPIVersion", "5.6.0-r9942-1305271002");
        return hashmap;
    }

    public double getPlayheadTime()
    {
        return -1D;
    }

    public void load(IRendererContext irenderercontext)
    {
        logger.info("load");
        context = irenderercontext;
        constants = context.getConstants();
        slot = context.getAdInstance().getSlot();
        slotBase = slot.getBase();
        Parameters.extractParam(context);
        irenderercontext = Parameters.getAppId();
        if (irenderercontext != null && irenderercontext.length() != 0)
        {
            logger.info((new StringBuilder()).append("Application ID = ").append(irenderercontext).toString());
        } else
        if (Parameters.isTestMode())
        {
            logger.info("Running on test mode...");
        } else
        {
            failWithError(constants.ERROR_MISSING_PARAMETER(), "No Application ID and not running on test mode");
            return;
        }
        _postLoad();
    }

    public void onAdReady(AdView adview)
    {
        logger.info("onAdReady");
        super.onAdReady(adview);
    }

    public void onNoAdReceived(AdView adview, NoAdReason noadreason)
    {
        logger.info("onNoAdReceived");
        super.onNoAdReceived(adview, noadreason);
        failWhenNoAd();
    }

    public void pause()
    {
        logger.info("pause");
    }

    public void resize()
    {
    }

    public void resume()
    {
        logger.info("resume");
    }

    public void run()
    {
    }

    public void start()
    {
        logger.info("start");
        (new Handler(context.getActivity().getMainLooper())).post(this);
    }

    public void stop()
    {
    }
}
