// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.admob;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;
import com.google.ads.searchads.SearchAdRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.RendererTimer;

// Referenced classes of package tv.freewheel.renderers.admob:
//            Parameters

public class AdMobRenderer
    implements IRenderer, AdListener, tv.freewheel.utils.renderer.RendererTimer.IRendererTimerService
{
    private class showAdTask
        implements Runnable
    {

        final AdMobRenderer this$0;

        public void run()
        {
            if (admobAd instanceof AdView)
            {
                AdView adview = (AdView)admobAd;
                if (slot.getType() != constants.SLOT_TYPE_TEMPORAL())
                {
                    logger.debug("Show display banner");
                    android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                    layoutparams.addRule(13);
                    slot.getBase().addView(adview, layoutparams);
                } else
                {
                    android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-2, -2);
                    if (slot.getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY())
                    {
                        logger.debug((new StringBuilder()).append("Show overlay banner, primaryAnchor ").append(params.primaryAnchor).append(", marginWidth ").append(params.marginWidth).append(", marginHeight ").append(params.marginHeight).toString());
                        layoutparams1.gravity = 0;
                        if (params.primaryAnchor.contains("t"))
                        {
                            layoutparams1.gravity = layoutparams1.gravity | 0x30;
                            layoutparams1.topMargin = params.marginHeight;
                        }
                        if (params.primaryAnchor.contains("l"))
                        {
                            layoutparams1.gravity = layoutparams1.gravity | 3;
                            layoutparams1.leftMargin = params.marginWidth;
                        }
                        if (params.primaryAnchor.contains("r"))
                        {
                            layoutparams1.gravity = layoutparams1.gravity | 5;
                            layoutparams1.rightMargin = params.marginWidth;
                        }
                        if (params.primaryAnchor.contains("b"))
                        {
                            layoutparams1.gravity = layoutparams1.gravity | 0x50;
                            layoutparams1.bottomMargin = params.marginHeight;
                        }
                        if (params.primaryAnchor.contains("c"))
                        {
                            layoutparams1.gravity = layoutparams1.gravity | 1;
                        }
                        if (params.primaryAnchor.contains("m"))
                        {
                            layoutparams1.gravity = layoutparams1.gravity | 0x10;
                        }
                        if (params.primaryAnchor == "c" || params.primaryAnchor == "m" || params.primaryAnchor == "cm" || params.primaryAnchor == "mc")
                        {
                            layoutparams1.gravity = 17;
                        }
                        slot.getBase().setOnHierarchyChangeListener(adview. new android.view.ViewGroup.OnHierarchyChangeListener() {

                            final showAdTask this$1;
                            final AdView val$adView;

                            public void onChildViewAdded(View view, View view1)
                            {
                                (new Handler(rendererContext.getActivity().getMainLooper())).post(new Runnable() {

                                    final showAdTask._cls1 this$2;

                                    public void run()
                                    {
                                        adView.bringToFront();
                                    }

            
            {
                this$2 = showAdTask._cls1.this;
                super();
            }
                                });
                            }

                            public void onChildViewRemoved(View view, View view1)
                            {
                            }

            
            {
                this$1 = final_showadtask;
                adView = AdView.this;
                super();
            }
                        });
                    } else
                    {
                        logger.debug("Show preroll/midroll/postroll banner");
                        layoutparams1.gravity = 17;
                    }
                    slot.getBase().addView(adview, layoutparams1);
                }
                adview.setVisibility(0);
                adview.bringToFront();
            } else
            {
                ((InterstitialAd)admobAd).show();
            }
            rendererContext.dispatchEvent(constants.EVENT_AD_STARTED());
        }

        private showAdTask()
        {
            this$0 = AdMobRenderer.this;
            super();
        }

    }


    private static int RENDERER_STATE_PAUSED = 1;
    private static int RENDERER_STATE_PENDING = 2;
    private static int RENDERER_STATE_PLAYING = 0;
    private static int RENDERER_STATE_STOPPED = 3;
    private IAdInstance adInstance;
    private Ad admobAd;
    private AdRequest admobAdRequest;
    private IConstants constants;
    private double duration;
    private boolean firstAd;
    private boolean interstitialDismissed;
    private Logger logger;
    private Parameters params;
    private AtomicInteger playHeadTime;
    private IRendererContext rendererContext;
    private AtomicInteger rendererState;
    private RendererTimer rendererTimer;
    private ISlot slot;

    public AdMobRenderer()
    {
        rendererContext = null;
        constants = null;
        params = null;
        adInstance = null;
        slot = null;
        admobAdRequest = null;
        admobAd = null;
        firstAd = true;
        duration = -1D;
        playHeadTime = new AtomicInteger(-1);
        rendererTimer = null;
        interstitialDismissed = false;
        rendererState = new AtomicInteger(RENDERER_STATE_PLAYING);
        logger = Logger.getLogger(this);
        logger.info("AdMobRenderer_5.6.0-r6883-1305271003");
    }

    private void failWithError(String s, String s1)
    {
        logger.error((new StringBuilder()).append("errorMessage: ").append(s1).toString());
        Bundle bundle = new Bundle();
        bundle.putString(constants.INFO_KEY_ERROR_CODE(), s);
        bundle.putString(constants.INFO_KEY_ERROR_INFO(), s1);
        s = new HashMap();
        s.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
        rendererContext.dispatchEvent(constants.EVENT_ERROR(), s);
    }

    public void dispose()
    {
        logger.info("dispose");
        rendererState.set(RENDERER_STATE_STOPPED);
        if (admobAd != null)
        {
            admobAd.setAdListener(null);
        }
        if (admobAd instanceof AdView)
        {
            (new Handler(rendererContext.getActivity().getMainLooper())).post(new Runnable() {

                final AdMobRenderer this$0;

                public void run()
                {
                    AdView adview = (AdView)admobAd;
                    adview.setVisibility(8);
                    slot.getBase().removeView(adview);
                }

            
            {
                this$0 = AdMobRenderer.this;
                super();
            }
            });
        }
        if (rendererTimer != null)
        {
            rendererTimer.stop();
            rendererTimer = null;
        }
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
        return (double)playHeadTime.get();
    }

    public void load(IRendererContext irenderercontext)
    {
        logger.info("load");
        rendererContext = irenderercontext;
        constants = rendererContext.getConstants();
        adInstance = rendererContext.getAdInstance();
        slot = adInstance.getSlot();
        params = Parameters.parseParameters(rendererContext);
        if (!params.validate())
        {
            failWithError(params.errorCode, params.errorString);
            return;
        }
        irenderercontext = adInstance.getActiveCreativeRendition();
        if (!irenderercontext.getBaseUnit().toLowerCase().contains("interstitial") && !irenderercontext.getContentType().toLowerCase().contains("interstitial")) goto _L2; else goto _L1
_L1:
        if (slot.getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY())
        {
            failWithError(constants.ERROR_INVALID_SLOT(), "Interstitial Ad is not supported in overlay slot");
            return;
        }
        if (irenderercontext.getContentType().equalsIgnoreCase("external/admob-view"))
        {
            failWithError(constants.ERROR_INVALID_VALUE(), "baseUnit interstitial is incompatible with contentType external/admob-view");
            return;
        }
        logger.debug("Interstitial Ad");
        admobAdRequest = new AdRequest();
        admobAd = new InterstitialAd(rendererContext.getActivity(), params.publisherId, params.shortTimeout);
_L4:
        if (params.dateOfBirth != null)
        {
            admobAdRequest.setBirthday(params.dateOfBirth);
        }
        if (params.gender != null)
        {
            admobAdRequest.setGender(params.gender);
        }
        if (params.keywords != null)
        {
            admobAdRequest.addKeyword(params.keywords);
        }
        if (params.testDeviceIds != null && !params.testDeviceIds.isEmpty())
        {
            irenderercontext = new HashSet(params.testDeviceIds);
            irenderercontext.add(AdRequest.TEST_EMULATOR);
            admobAdRequest.setTestDevices(irenderercontext);
        }
        if (rendererContext.getLocation() != null)
        {
            admobAdRequest.setLocation(rendererContext.getLocation());
        }
        admobAd.setAdListener(this);
        rendererContext.setRendererCapability(constants.EVENT_AD_CLICK(), constants.CAPABILITY_STATUS_OFF());
        rendererContext.dispatchEvent(constants.EVENT_AD_LOADED());
        return;
_L2:
        AdSize adsize;
        if (slot.getType() == constants.SLOT_TYPE_TEMPORAL())
        {
            if (irenderercontext.getDuration() <= 0.0D)
            {
                failWithError(constants.ERROR_INVALID_VALUE(), "Invalid duration");
                return;
            }
            duration = irenderercontext.getDuration();
            logger.debug((new StringBuilder()).append("Duration ").append(duration).toString());
        }
        if (params.searchString != null)
        {
            logger.debug((new StringBuilder()).append("Search Ad for string ").append(params.searchString).toString());
            SearchAdRequest searchadrequest = new SearchAdRequest();
            searchadrequest.setQuery(params.searchString);
            if (params.backgroundColor != 0)
            {
                searchadrequest.setBackgroundColor(params.backgroundColor);
            }
            if (params.headerTextColor != 0)
            {
                searchadrequest.setHeaderTextColor(params.headerTextColor);
            }
            if (params.descriptionTextColor != 0)
            {
                searchadrequest.setDescriptionTextColor(params.descriptionTextColor);
            }
            admobAdRequest = searchadrequest;
        } else
        {
            logger.debug("Banner Ad");
            admobAdRequest = new AdRequest();
        }
        adsize = AdSize.BANNER;
        if (params.bannerSize == null)
        {
            break; /* Loop/switch isn't completed */
        }
        logger.debug((new StringBuilder()).append("Parameter set AdSize ").append(adsize).toString());
        irenderercontext = params.bannerSize;
_L5:
        admobAd = new AdView(rendererContext.getActivity(), irenderercontext, params.publisherId);
        if (true) goto _L4; else goto _L3
_L3:
        int k;
        k = 0;
        int l = 0;
        AdSize aadsize[];
        int i;
        int j;
        if (irenderercontext.getWidth() > 0 && irenderercontext.getHeight() > 0)
        {
            j = irenderercontext.getWidth();
            i = irenderercontext.getHeight();
            logger.debug((new StringBuilder()).append("Creative size ").append(j).append("x").append(i).toString());
        } else
        {
            i = l;
            j = k;
            if (slot.getWidth() > 0)
            {
                i = l;
                j = k;
                if (slot.getHeight() > 0)
                {
                    j = slot.getWidth();
                    i = slot.getHeight();
                    logger.debug((new StringBuilder()).append("Slot size ").append(j).append("x").append(i).toString());
                }
            }
        }
        aadsize = Parameters.adSizes;
        l = aadsize.length;
        k = 0;
_L6:
        irenderercontext = adsize;
        if (k < l)
        {
label0:
            {
                irenderercontext = aadsize[k];
                if (j < irenderercontext.getWidthInPixels(rendererContext.getActivity()) || i < irenderercontext.getHeightInPixels(rendererContext.getActivity()))
                {
                    break label0;
                }
                logger.debug((new StringBuilder()).append("Fit AdSize ").append(irenderercontext).toString());
            }
        }
          goto _L5
        k++;
          goto _L6
    }

    public void onDismissScreen(Ad ad)
    {
        logger.debug("onDismissScreen");
        if (rendererState.get() == RENDERER_STATE_STOPPED)
        {
            logger.warn("Renderer already stopped");
        } else
        if (ad == admobAd && (admobAd instanceof InterstitialAd))
        {
            interstitialDismissed = true;
            return;
        }
    }

    public void onFailedToReceiveAd(Ad ad, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        logger.debug("onFailedToReceiveAd");
        if (rendererState.get() == RENDERER_STATE_STOPPED)
        {
            logger.warn("Renderer already stopped");
            return;
        }
        static class _cls2
        {

            static final int $SwitchMap$com$google$ads$AdRequest$ErrorCode[];

            static 
            {
                $SwitchMap$com$google$ads$AdRequest$ErrorCode = new int[com.google.ads.AdRequest.ErrorCode.values().length];
                try
                {
                    $SwitchMap$com$google$ads$AdRequest$ErrorCode[com.google.ads.AdRequest.ErrorCode.NO_FILL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$google$ads$AdRequest$ErrorCode[com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$google$ads$AdRequest$ErrorCode[com.google.ads.AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$ads$AdRequest$ErrorCode[com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.google.ads.AdRequest.ErrorCode[errorcode.ordinal()])
        {
        default:
            failWithError(constants.ERROR_3P_COMPONENT(), errorcode.toString());
            return;

        case 1: // '\001'
            failWithError(constants.ERROR_NO_AD_AVAILABLE(), errorcode.toString());
            return;

        case 2: // '\002'
            failWithError(constants.ERROR_IO(), errorcode.toString());
            break;
        }
    }

    public void onLeaveApplication(Ad ad)
    {
        logger.debug("onLeaveApplication");
    }

    public void onPresentScreen(Ad ad)
    {
        logger.debug("onPresentScreen");
    }

    public void onReceiveAd(Ad ad)
    {
        logger.debug("onReceiveAd");
        if (rendererState.get() == RENDERER_STATE_STOPPED)
        {
            logger.warn("Renderer already stopped");
        } else
        {
            if (ad != admobAd)
            {
                logger.warn("Unknown received ad");
                return;
            }
            if (!firstAd)
            {
                logger.debug("Auto refreshed ad");
                return;
            }
            firstAd = false;
            if (duration > 0.0D)
            {
                rendererTimer = new RendererTimer((int)duration, this);
                rendererTimer.start();
            }
            if (!rendererState.compareAndSet(RENDERER_STATE_PAUSED, RENDERER_STATE_PENDING))
            {
                (new Handler(rendererContext.getActivity().getMainLooper())).post(new showAdTask());
                return;
            }
        }
    }

    public void pause()
    {
        logger.info("pause");
        rendererState.set(RENDERER_STATE_PAUSED);
        if (rendererTimer != null)
        {
            rendererTimer.pause();
        }
    }

    public void playHeadTime(int i)
    {
        playHeadTime.set(i);
    }

    public void resize()
    {
    }

    public void resume()
    {
        logger.info("resume");
        if (rendererState.getAndSet(RENDERER_STATE_PLAYING) == RENDERER_STATE_PENDING)
        {
            logger.debug("Received ad when pause, show it now");
            (new Handler(rendererContext.getActivity().getMainLooper())).post(new showAdTask());
        } else
        {
            if (rendererTimer != null)
            {
                rendererTimer.resume();
            }
            if ((admobAd instanceof InterstitialAd) && interstitialDismissed)
            {
                stop();
                return;
            }
        }
    }

    public void start()
    {
        logger.info("start");
        admobAd.loadAd(admobAdRequest);
    }

    public void stop()
    {
        logger.info("stop");
        if (rendererState.getAndSet(RENDERER_STATE_STOPPED) == RENDERER_STATE_STOPPED)
        {
            logger.debug("Renderer already stopped");
            return;
        }
        if (admobAd != null && !admobAd.isReady())
        {
            admobAd.stopLoading();
        }
        rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
    }

    public void timeOut()
    {
        logger.debug("duration timeout");
        stop();
    }







}
