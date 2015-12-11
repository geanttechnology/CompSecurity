// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.millennial;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.millennialmedia.android.BasicMMAdListener;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdViewOverlayActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.millennial:
//            Parameters

public class MillennialRenderer extends BasicMMAdListener
    implements IRenderer
{

    private IActivityCallbackListener activityCallbackListener;
    private Timer adProgressTimer;
    private Timer adRequestTimer;
    private MMAdView adView;
    private IConstants constants;
    private double duration;
    private Handler handler;
    private int height;
    private boolean listening;
    private Logger logger;
    private Parameters params;
    private double playhead;
    private IRendererContext rendererContext;
    private ISlot slot;
    private int width;

    public MillennialRenderer()
    {
        playhead = 0.0D;
        width = 320;
        height = 53;
        listening = false;
        logger = Logger.getLogger(this);
        logger.info("MillennialRenderer_5.6.0-r6885-1305271003");
    }

    private void adReturned()
    {
        rendererContext.getActivity().runOnUiThread(new Runnable() {

            final MillennialRenderer this$0;

            public void run()
            {
                logger.debug("adReturned()");
                if (listening)
                {
                    listening = false;
                    disposeAdRequestTimer();
                    if (adView != null && isDisplayAd())
                    {
                        showDisplayAd();
                    }
                    startAdProgressTimer();
                    activityCallbackListener = new IActivityCallbackListener() {

                        final _cls1 this$1;

                        public void onActivityCallback(int i)
                        {
label0:
                            {
                                logger.debug((new StringBuilder()).append("onActivityCallback(").append(i).append(")").toString());
                                if (i == constants.ACTIVITY_CALLBACK_RESUME())
                                {
                                    logger.debug("Content activity resumed");
                                    if (slot.getTimePositionClass() != constants.TIME_POSITION_CLASS_DISPLAY())
                                    {
                                        break label0;
                                    }
                                    rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_RESUME());
                                }
                                return;
                            }
                            if (slot.getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY())
                            {
                                rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_RESUME());
                                startAdProgressTimer();
                                return;
                            } else
                            {
                                stop();
                                return;
                            }
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    };
                    rendererContext.addOnActivityCallbackListener(activityCallbackListener);
                    rendererContext.dispatchEvent(constants.EVENT_AD_STARTED());
                    return;
                } else
                {
                    logger.warn("MMAdReturned has already been received, returning.");
                    return;
                }
            }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
        });
    }

    private void disposeAdProgressTimer()
    {
        logger.debug("disposeAdProgressTimer()");
        if (adProgressTimer != null)
        {
            adProgressTimer.cancel();
            adProgressTimer.purge();
            adProgressTimer = null;
        }
    }

    private void disposeAdRequestTimer()
    {
        logger.debug("disposeAdRequestTimer()");
        if (adRequestTimer != null)
        {
            adRequestTimer.cancel();
            adRequestTimer.purge();
            adRequestTimer = null;
        }
    }

    private void failWithError(String s, String s1)
    {
        logger.error(s1);
        if (adView != null)
        {
            adView.setListener(null);
        }
        Bundle bundle = new Bundle();
        bundle.putString(constants.INFO_KEY_ERROR_CODE(), s);
        bundle.putString(constants.INFO_KEY_ERROR_INFO(), s1);
        s = new HashMap();
        s.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
        rendererContext.dispatchEvent(constants.EVENT_ERROR(), s);
    }

    private void handleAdClick()
    {
        logger.debug("handleAdClick()");
        disposeAdProgressTimer();
        if (isDisplayAd())
        {
            rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_PAUSE());
        }
        HashMap hashmap = new HashMap();
        hashmap.put(constants.INFO_KEY_SHOW_BROWSER(), Boolean.valueOf(false));
        rendererContext.dispatchEvent(constants.EVENT_AD_CLICK(), hashmap);
    }

    private boolean isDisplayAd()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (params == null)
            {
                break label0;
            }
            if (!params.adType.equals("MMBannerAdBottom") && !params.adType.equals("MMBannerAdRectangle"))
            {
                flag = flag1;
                if (!params.adType.equals("MMBannerAdTop"))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private boolean isValidCombination(String s, String s1, int i, String s2)
    {
        boolean flag1 = true;
        if (s1.equals("external/millennial-media")) goto _L2; else goto _L1
_L1:
        flag1 = false;
        if (!s1.equals("external/millennial-media-display")) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        logger.debug((new StringBuilder()).append("isValidCombination(").append(s).append(",").append(s1).append(",").append(i).append(",").append(s2).append("), returning ").append(flag).toString());
        return flag;
_L4:
        flag = flag1;
        if (s1.equals("external/millennial-media-takeover"))
        {
            flag = flag1;
            if (i != constants.TIME_POSITION_CLASS_OVERLAY())
            {
                flag = true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        flag = flag1;
        if (i == constants.TIME_POSITION_CLASS_OVERLAY())
        {
            flag = flag1;
            if (!isDisplayAd())
            {
                flag = false;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void onAdProgressTimer()
    {
        playhead = playhead + 1.0D;
        if (slot.getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY() && slot.getBase().getChildAt(0) != adView)
        {
            rendererContext.getActivity().runOnUiThread(new Runnable() {

                final MillennialRenderer this$0;

                public void run()
                {
                    adView.bringToFront();
                }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
            });
        }
        if ((params.shouldEndAfterDuration || isDisplayAd()) && playhead >= duration)
        {
            logger.debug("Duration is reached, stopping ad.");
            disposeAdProgressTimer();
            stop();
        }
    }

    private void onAdRequestTimeout()
    {
        logger.error((new StringBuilder()).append("onAdRequestTimeout(): timed out after ").append(params.adRequestTimeout).append(" seconds.").toString());
        if (listening)
        {
            listening = false;
            disposeAdRequestTimer();
            failWithError(constants.ERROR_TIMEOUT(), "Ad request to Millennial timed out.");
            return;
        } else
        {
            logger.warn("Ad has either been returned or failed for other reason.");
            return;
        }
    }

    private void showDisplayAd()
    {
        if (slot.getType() != constants.SLOT_TYPE_TEMPORAL()) goto _L2; else goto _L1
_L1:
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(width, height);
        layoutparams.gravity = 1;
        if (slot.getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY())
        {
            layoutparams.gravity = layoutparams.gravity | 0x50;
        } else
        if (params.adType.equals("MMBannerAdTop"))
        {
            layoutparams.gravity = layoutparams.gravity | 0x30;
        } else
        if (params.adType.equals("MMBannerAdBottom"))
        {
            layoutparams.gravity = layoutparams.gravity | 0x50;
        }
        slot.getBase().addView(adView, 0, layoutparams);
_L4:
        adView.setVisibility(0);
        adView.bringToFront();
        return;
_L2:
        android.widget.RelativeLayout.LayoutParams layoutparams1;
        layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        if (!params.adType.equals("MMBannerAdTop"))
        {
            break; /* Loop/switch isn't completed */
        }
        layoutparams1.addRule(10);
_L6:
        layoutparams1.addRule(14);
        slot.getBase().addView(adView, 0, layoutparams1);
        if (true) goto _L4; else goto _L3
_L3:
        if (!params.adType.equals("MMBannerAdBottom")) goto _L6; else goto _L5
_L5:
        layoutparams1.addRule(12);
          goto _L6
    }

    private void startAdProgressTimer()
    {
        if (slot.getTimePositionClass() != constants.TIME_POSITION_CLASS_DISPLAY())
        {
            logger.debug("startAdProgressTimer()");
            adProgressTimer = new Timer();
            adProgressTimer.scheduleAtFixedRate(new TimerTask() {

                final MillennialRenderer this$0;

                public void run()
                {
                    onAdProgressTimer();
                }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
            }, 0L, 1000L);
        }
    }

    private void startAdRequestTimer()
    {
        logger.debug("startAdRequestTimer()");
        adRequestTimer = new Timer();
        adRequestTimer.schedule(new TimerTask() {

            final MillennialRenderer this$0;

            public void run()
            {
                onAdRequestTimeout();
            }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
        }, params.adRequestTimeout * 1000);
    }

    public void MMAdClickedToNewBrowser(MMAdView mmadview)
    {
        rendererContext.getActivity().runOnUiThread(new Runnable() {

            final MillennialRenderer this$0;

            public void run()
            {
                logger.debug("MMAdClickedToNewBrowser()");
                handleAdClick();
            }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
        });
    }

    public void MMAdClickedToOverlay(MMAdView mmadview)
    {
        rendererContext.getActivity().runOnUiThread(new Runnable() {

            final MillennialRenderer this$0;

            public void run()
            {
                logger.debug("MMAdClickedToOverlay()");
                handleAdClick();
            }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
        });
    }

    public void MMAdFailed(MMAdView mmadview)
    {
        rendererContext.getActivity().runOnUiThread(new Runnable() {

            final MillennialRenderer this$0;

            public void run()
            {
                logger.debug("MMAdFailed()");
                if (!listening)
                {
                    logger.warn("MMAdFailed has already been received, returning");
                    return;
                } else
                {
                    listening = false;
                    disposeAdRequestTimer();
                    failWithError(constants.ERROR_NO_AD_AVAILABLE(), "No ad available.");
                    return;
                }
            }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
        });
    }

    public void MMAdOverlayLaunched(MMAdView mmadview)
    {
        logger.debug("MMAdOverlayLaunched()");
        adReturned();
    }

    public void MMAdReturned(MMAdView mmadview)
    {
        logger.debug("MMAdReturned()");
        adReturned();
    }

    public void dispose()
    {
        logger.debug("dispose()");
        disposeAdProgressTimer();
        activityCallbackListener = null;
        adView = null;
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
        return playhead;
    }

    public void load(IRendererContext irenderercontext)
    {
        IAdInstance iadinstance;
        ICreativeRendition icreativerendition;
        logger.debug("load()");
        rendererContext = irenderercontext;
        constants = irenderercontext.getConstants();
        params = Parameters.parseParameters(irenderercontext);
        handler = new Handler(rendererContext.getActivity().getMainLooper());
        if (!params.validate())
        {
            failWithError(constants.ERROR_MISSING_PARAMETER(), TextUtils.join(",", params.errors));
            return;
        }
        iadinstance = irenderercontext.getAdInstance();
        icreativerendition = iadinstance.getActiveCreativeRendition();
        duration = icreativerendition.getDuration();
        irenderercontext = "";
        String s = icreativerendition.getBaseUnit();
        irenderercontext = s;
_L1:
        Object obj;
        if (!isValidCombination(irenderercontext, icreativerendition.getContentType(), iadinstance.getSlot().getTimePositionClass(), params.adType))
        {
            failWithError(constants.ERROR_INVALID_SLOT(), (new StringBuilder()).append("Not a valid combination: baseUnit=").append(irenderercontext).append(" contentType=").append(icreativerendition.getContentType()).append(" slotTPC=").append(iadinstance.getSlot().getTimePositionClass()).append(" adtype=").append(params.adType).toString());
            return;
        } else
        {
            rendererContext.dispatchEvent(constants.EVENT_AD_LOADED());
            return;
        }
        obj;
        logger.warn("Player is running on FreeWheel SDK < 4.6");
          goto _L1
        obj;
        logger.warn("Player is running on FreeWheel SDK < 4.6");
          goto _L1
    }

    public void pause()
    {
        logger.debug("pause()");
    }

    public void resize()
    {
    }

    public void resume()
    {
        logger.debug("resume()");
    }

    public void start()
    {
        logger.debug("start()");
        listening = true;
        Object obj = new WeakReference(rendererContext.getActivity());
        if (((WeakReference) (obj)).get() == null)
        {
            logger.error("Activity is null, terminate.");
            rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
            return;
        }
        slot = rendererContext.getAdInstance().getSlot();
        adView = new MMAdView((Activity)((WeakReference) (obj)).get(), params.apId, params.adType, -1, params.metaMap);
        adView.setId(0x711e41a1);
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
        obj = rendererContext.getAdInstance().getActiveCreativeRendition();
        if (((ICreativeRendition) (obj)).getWidth() > 0)
        {
            i = ((ICreativeRendition) (obj)).getWidth();
        } else
        {
            i = width;
        }
        width = i;
        if (((ICreativeRendition) (obj)).getHeight() > 0)
        {
            i = ((ICreativeRendition) (obj)).getHeight();
        } else
        {
            i = height;
        }
        height = i;
        logger.debug((new StringBuilder()).append("width is ").append(width).append(" height is ").append(height).toString());
        adView.setWidth(String.valueOf(width));
        adView.setHeight(String.valueOf(height));
        obj = rendererContext.getLocation();
        adView.updateUserLocation(((android.location.Location) (obj)));
        adView.setListener(this);
        rendererContext.getActivity().runOnUiThread(new Runnable() {

            final MillennialRenderer this$0;

            public void run()
            {
                adView.callForAd();
            }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
        });
        startAdRequestTimer();
    }

    public void stop()
    {
        logger.debug("stop()");
        disposeAdProgressTimer();
        activityCallbackListener = null;
        handler.post(new Runnable() {

            final MillennialRenderer this$0;

            public void run()
            {
                if (adView != null)
                {
                    try
                    {
                        if (MMAdViewOverlayActivity.getContext() != null)
                        {
                            ((MMAdViewOverlayActivity)MMAdViewOverlayActivity.getContext()).finish();
                        }
                        adView.removeAllViews();
                        adView.setVisibility(4);
                        adView.setListener(null);
                        slot.getBase().removeView(adView);
                    }
                    catch (Exception exception)
                    {
                        logger.warn((new StringBuilder()).append("Error when trying to stop MMAdViewOverlayActivity and remove adView: ").append(exception.getMessage()).toString());
                    }
                } else
                {
                    logger.warn("when stop Millennial ad, the adView is null");
                }
                rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
            }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
        });
    }





/*
    static boolean access$102(MillennialRenderer millennialrenderer, boolean flag)
    {
        millennialrenderer.listening = flag;
        return flag;
    }

*/












/*
    static IActivityCallbackListener access$702(MillennialRenderer millennialrenderer, IActivityCallbackListener iactivitycallbacklistener)
    {
        millennialrenderer.activityCallbackListener = iactivitycallbacklistener;
        return iactivitycallbacklistener;
    }

*/


}
