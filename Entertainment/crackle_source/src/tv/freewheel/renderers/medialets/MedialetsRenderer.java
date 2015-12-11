// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.medialets;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.medialets.advertising.AdView;
import com.medialets.advertising.BannerAdView;
import com.medialets.advertising.InterstitialAdView;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.RendererTimer;

// Referenced classes of package tv.freewheel.renderers.medialets:
//            Parameters

public class MedialetsRenderer
    implements IRenderer, com.medialets.advertising.AdView.AdListener, tv.freewheel.utils.renderer.RendererTimer.IRendererTimerService
{

    private static final String MEDIALETS_ADVIEW_CLASS = "com.medialets.advertising.AdView";
    private IActivityCallbackListener activityCallbackListener;
    private IConstants constants;
    private IRendererContext context;
    private FrameLayout displayBase;
    private double duration;
    private AtomicInteger headTime;
    private int height;
    private boolean isInterstitial;
    private Logger logger;
    private Handler mainLoopHandler;
    private AdView medialetsAdView;
    private Parameters parameters;
    private RendererTimer rendererTimer;
    private boolean shouldPauseResumeMainVideo;
    private ISlot slot;
    private boolean stopped;
    private int timePositionClass;
    private int width;

    public MedialetsRenderer()
    {
        mainLoopHandler = null;
        context = null;
        constants = null;
        slot = null;
        rendererTimer = null;
        duration = -1D;
        medialetsAdView = null;
        shouldPauseResumeMainVideo = false;
        isInterstitial = false;
        displayBase = null;
        width = 320;
        height = 50;
        stopped = false;
        logger = Logger.getLogger(this);
        logger.info("MedialetsRenderer_5.6.0-r6884-1305271003");
        headTime = new AtomicInteger(-1);
    }

    private void _load(IRendererContext irenderercontext)
    {
        String s;
        logger.info("_load");
        context = irenderercontext;
        constants = irenderercontext.getConstants();
        context.setRendererCapability(constants.EVENT_AD_CLICK(), constants.CAPABILITY_STATUS_OFF());
        slot = context.getAdInstance().getSlot();
        try
        {
            Class.forName("com.medialets.advertising.AdView");
        }
        // Misplaced declaration of an exception variable
        catch (IRendererContext irenderercontext)
        {
            failWithError(constants.ERROR_RENDERER_INIT(), "Medialets SDK is not available");
            return;
        }
        parameters = new Parameters();
        parameters.extractParam(irenderercontext);
        if (parameters.getAdSlotKey() == null)
        {
            failWithError(constants.ERROR_MISSING_PARAMETER(), "No renderer.medialets.adSlotKey");
            return;
        }
        if (!parameters.serviceConnected())
        {
            failWithError(constants.ERROR_RENDERER_INIT(), "Medialets Admanager service is not connected.");
            return;
        }
        s = "";
        String s1 = irenderercontext.getAdInstance().getActiveCreativeRendition().getBaseUnit();
        s = s1;
_L2:
        if (s == null || s.length() == 0 || !"app-interstitial".equalsIgnoreCase(s.trim()))
        {
            break MISSING_BLOCK_LABEL_316;
        }
        isInterstitial = true;
        if (irenderercontext.getAdInstance().getSlot().getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY())
        {
            failWithError(constants.ERROR_INVALID_SLOT(), "Overlay slot CAN NOT support Interstitial ad.");
            return;
        }
        break; /* Loop/switch isn't completed */
        Object obj;
        obj;
        logger.warn("FreeWheel SDK version is lower than 4.6, The baseUnit is not recognized.");
        continue; /* Loop/switch isn't completed */
        obj;
        logger.warn("FreeWheel SDK version is lower than 4.6, The baseUnit is not recognized.");
        if (true) goto _L2; else goto _L1
_L1:
        if (irenderercontext.getAdInstance().getSlot().getTimePositionClass() == constants.TIME_POSITION_CLASS_DISPLAY())
        {
            shouldPauseResumeMainVideo = true;
        }
        timePositionClass = irenderercontext.getAdInstance().getSlot().getTimePositionClass();
        if (timePositionClass != constants.TIME_POSITION_CLASS_DISPLAY() && !isInterstitial)
        {
            duration = irenderercontext.getAdInstance().getActiveCreativeRendition().getDuration();
            rendererTimer = new RendererTimer((int)duration, this);
            headTime = new AtomicInteger(0);
        }
        activityCallbackListener = new IActivityCallbackListener() {

            final MedialetsRenderer this$0;

            public void onActivityCallback(int j)
            {
                logger.debug((new StringBuilder()).append("onActivityStateChange ").append(j).toString());
                if (j == constants.ACTIVITY_CALLBACK_RESUME())
                {
                    logger.info("context activity resumed");
                    if (rendererTimer != null)
                    {
                        rendererTimer.resume();
                    }
                } else
                if (j == constants.ACTIVITY_CALLBACK_PAUSE())
                {
                    logger.info("context activity paused");
                    if (rendererTimer != null)
                    {
                        rendererTimer.pause();
                        return;
                    }
                }
            }

            
            {
                this$0 = MedialetsRenderer.this;
                super();
            }
        };
        context.addOnActivityCallbackListener(activityCallbackListener);
        if (isInterstitial)
        {
            medialetsAdView = new InterstitialAdView(context.getActivity());
        } else
        {
            medialetsAdView = new BannerAdView(context.getActivity());
            int i;
            if (slot.getWidth() > 0)
            {
                i = slot.getWidth();
            } else
            {
                i = width;
            }
            width = i;
            if (slot.getHeight() > 0)
            {
                i = slot.getHeight();
            } else
            {
                i = height;
            }
            height = i;
            irenderercontext = context.getAdInstance().getActiveCreativeRendition();
            if (irenderercontext.getWidth() > 0)
            {
                i = irenderercontext.getWidth();
            } else
            {
                i = width;
            }
            width = i;
            if (irenderercontext.getHeight() > 0)
            {
                i = irenderercontext.getHeight();
            } else
            {
                i = height;
            }
            height = i;
            logger.info((new StringBuilder()).append("BannerAdView(width=").append(width).append(",height=").append(height).append(")").toString());
            medialetsAdView.setWidth(width);
            medialetsAdView.setHeight(height);
        }
        medialetsAdView.setSlotName(parameters.getAdSlotKey());
        if (parameters.getKeyValuePairs() != null)
        {
            medialetsAdView.setCustomMacros(parameters.getKeyValuePairs());
        }
        if (parameters.getAdSlotKeywords() != null)
        {
            medialetsAdView.setSlotKeywords(parameters.getAdSlotKeywords());
        }
        if (parameters.getAdBlockKeywords() != null)
        {
            medialetsAdView.setBlockedKeywords(parameters.getAdBlockKeywords());
        }
        medialetsAdView.setAdListener(this);
        context.dispatchEvent(constants.EVENT_AD_LOADED());
        return;
    }

    private void _start()
    {
        logger.info("_start");
        if (!isInterstitial)
        {
            prepareDisplayAd();
            if (rendererTimer != null)
            {
                rendererTimer.start();
            }
        }
        if (shouldPauseResumeMainVideo)
        {
            context.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_PAUSE());
        }
        medialetsAdView.prepare();
        context.dispatchEvent(constants.EVENT_AD_STARTED());
    }

    private void _stop()
    {
        logger.info("_stop");
        if (stopped)
        {
            return;
        }
        stopped = true;
        if (shouldPauseResumeMainVideo)
        {
            context.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_RESUME());
        }
        if (rendererTimer != null)
        {
            rendererTimer.stop();
        }
        if (medialetsAdView != null)
        {
            medialetsAdView.setAdListener(null);
            if (!isInterstitial)
            {
                ((BannerAdView)medialetsAdView).dismiss();
                if (displayBase != null)
                {
                    slot.getBase().removeView(displayBase);
                }
            }
        }
        context.dispatchEvent(constants.EVENT_AD_STOPPED());
    }

    private void prepareDisplayAd()
    {
        if (slot.getTimePositionClass() != constants.TIME_POSITION_CLASS_DISPLAY())
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(width, height);
            if (slot.getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY())
            {
                layoutparams.gravity = 81;
                slot.getBase().addView(medialetsAdView, 0, layoutparams);
            } else
            {
                layoutparams.gravity = 17;
                displayBase = new FrameLayout(context.getActivity());
                displayBase.setBackgroundColor(0xff000000);
                slot.getBase().addView(displayBase, new android.widget.FrameLayout.LayoutParams(-1, -1));
                displayBase.addView(medialetsAdView, 0, layoutparams);
            }
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams1.addRule(13);
            slot.getBase().addView(medialetsAdView, 0, layoutparams1);
        }
        medialetsAdView.setVisibility(0);
        medialetsAdView.bringToFront();
    }

    public void dispose()
    {
        logger.info("dispose");
        stop();
    }

    protected void failWhenNoAd()
    {
        logger.error("failWhenNoAd");
        failWithError(constants.ERROR_NO_AD_AVAILABLE(), "No Medialets Ad returned");
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
        return duration;
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
        return (double)headTime.get();
    }

    public void load(final IRendererContext contextFinalRef)
    {
        logger.info("load");
        mainLoopHandler = new Handler(contextFinalRef.getActivity().getMainLooper());
        mainLoopHandler.post(new Runnable() {

            final MedialetsRenderer this$0;
            final IRendererContext val$contextFinalRef;

            public void run()
            {
                _load(contextFinalRef);
            }

            
            {
                this$0 = MedialetsRenderer.this;
                contextFinalRef = irenderercontext;
                super();
            }
        });
    }

    public void onAdVisible(AdView adview)
    {
        logger.info("onAdVisible");
    }

    public void onFinishedLoadingView(AdView adview)
    {
        logger.info("onFinishedLoadingView");
    }

    public void onInterstitialDismissed(AdView adview)
    {
        logger.info("onInterstitialDismissed");
        stop();
    }

    public void onNoAdsAvailable(AdView adview)
    {
        logger.info("onNoAdsAvailable");
        failWhenNoAd();
    }

    public void pause()
    {
        logger.info("pause");
        if (rendererTimer != null)
        {
            rendererTimer.pause();
        }
    }

    public void playHeadTime(int i)
    {
        headTime.set(i);
    }

    public void resize()
    {
    }

    public void resume()
    {
        logger.info("resume");
        if (rendererTimer != null)
        {
            rendererTimer.resume();
        }
    }

    public void start()
    {
        logger.info("start");
        mainLoopHandler.post(new Runnable() {

            final MedialetsRenderer this$0;

            public void run()
            {
                _start();
            }

            
            {
                this$0 = MedialetsRenderer.this;
                super();
            }
        });
    }

    public void stop()
    {
        logger.info("stop");
        mainLoopHandler.post(new Runnable() {

            final MedialetsRenderer this$0;

            public void run()
            {
                _stop();
            }

            
            {
                this$0 = MedialetsRenderer.this;
                super();
            }
        });
    }

    public void timeOut()
    {
        stop();
    }






}
