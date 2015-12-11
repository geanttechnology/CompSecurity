// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.URIUtil;

// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoAdView

public class VideoRenderer
    implements IRenderer
{

    private static int HLSSupportVersion = 0;
    private static final String PARAM_CLICK_DETECTION = "renderer.video.clickDetection";
    private static final String PARAM_DESIRED_BITRATE = "desiredBitrate";
    private static final String PARAM_USE_CONTROL_PANEL = "renderer.video.useControlPanel";
    private static final long QUARTILE_CHECK_INTERVAL = 500L;
    private static int STATE_DISPOSED = 2;
    private static int STATE_STARTED = 0;
    private static int STATE_STOPPED = 1;
    private boolean HLSDropped;
    private String assetUrl;
    private boolean checkRedirectUrl;
    private boolean clickHandledByPlayer;
    protected IConstants constants;
    private boolean defaultImpressionSent;
    private double estimatedDuration;
    private int impressionCountBeforeStart;
    private AtomicInteger internalState;
    private boolean isPaused;
    private Logger logger;
    private int quartilesSent;
    private IRendererContext rendererContext;
    private int renditionHeight;
    private int renditionWidth;
    private ISlot slot;
    private final boolean supportPreload;
    private int timeoutCountBeforeStart;
    private double timeoutMillisecondsBeforeStart;
    private Timer timer;
    private boolean useControlPanel;
    private VideoAdView videoAdView;

    public VideoRenderer()
    {
        boolean flag = false;
        super();
        defaultImpressionSent = false;
        quartilesSent = 0;
        isPaused = false;
        impressionCountBeforeStart = 0;
        timeoutMillisecondsBeforeStart = 10000D;
        timeoutCountBeforeStart = 0;
        estimatedDuration = -1D;
        clickHandledByPlayer = false;
        useControlPanel = false;
        checkRedirectUrl = false;
        HLSDropped = false;
        if (android.os.Build.VERSION.SDK_INT > 13)
        {
            flag = true;
        }
        supportPreload = flag;
        logger = Logger.getLogger(this);
        internalState = new AtomicInteger(STATE_STARTED);
    }

    private void _resume()
    {
        logger.debug("_resume");
        if (videoAdView != null)
        {
            isPaused = false;
            videoAdView.start();
            onAdResumed();
        }
        startQuartileImpressionAndTimeoutTimer();
    }

    private void checkAndFailIfTimeout()
    {
        if (impressionCountBeforeStart >= timeoutCountBeforeStart)
        {
            logger.warn((new StringBuilder()).append("ad content can not start in ").append(timeoutMillisecondsBeforeStart).append("ms, just fail!").toString());
            stopQuartileTimer();
            Bundle bundle = new Bundle();
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_TIMEOUT());
            bundle.putString(constants.INFO_KEY_ERROR_INFO(), "ad content can not start in 10s");
            HashMap hashmap = new HashMap();
            hashmap.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
            rendererContext.dispatchEvent(constants.EVENT_ERROR(), hashmap);
            return;
        } else
        {
            impressionCountBeforeStart = impressionCountBeforeStart + 1;
            return;
        }
    }

    private ICreativeRendition getBestFitRendition()
    {
        double d1;
        double d3;
        Object obj = new ArrayList();
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= HLSSupportVersion)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        logger.debug((new StringBuilder()).append("Android version ").append(android.os.Build.VERSION.RELEASE).append(", API ").append(android.os.Build.VERSION.SDK_INT).append(", HLS supported: ").append(flag).toString());
        for (Iterator iterator = rendererContext.getAdInstance().getRenderableCreativeRenditions().iterator(); iterator.hasNext();)
        {
            ICreativeRendition icreativerendition = (ICreativeRendition)iterator.next();
            if (icreativerendition.getContentType().equals("application/x-mpegurl"))
            {
                if (icreativerendition.getPrimaryCreativRenditionAsset() == null)
                {
                    logger.debug((new StringBuilder()).append("Drop HLS rendition ").append(icreativerendition.toString()).append(" that has no asset").toString());
                } else
                {
                    if (flag)
                    {
                        logger.debug((new StringBuilder()).append("Return HLS rendition ").append(icreativerendition.toString()).toString());
                        return icreativerendition;
                    }
                    HLSDropped = true;
                    logger.debug((new StringBuilder()).append("Drop HLS rendition ").append(icreativerendition.toString()).append(" for Android version is too old").toString());
                }
            } else
            {
                ((ArrayList) (obj)).add(icreativerendition);
            }
        }

        logger.debug((new StringBuilder()).append("Slot size ").append(slot.getWidth()).append("x").append(slot.getHeight()).toString());
        String s;
        NumberFormatException numberformatexception;
        if (slot.getWidth() > 0 && slot.getHeight() > 0)
        {
            double d4 = (1.0D * (double)slot.getWidth()) / (double)slot.getHeight();
            logger.debug((new StringBuilder()).append("Slot aspect ratio ").append(d4).toString());
            ArrayList arraylist1 = new ArrayList();
            ArrayList arraylist2 = new ArrayList();
            double d2 = -1D;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                ICreativeRendition icreativerendition1 = (ICreativeRendition)((Iterator) (obj)).next();
                if (icreativerendition1.getWidth() > 0 && icreativerendition1.getHeight() > 0)
                {
                    double d6 = (1.0D * (double)icreativerendition1.getWidth()) / (double)icreativerendition1.getHeight();
                    double d;
                    if (d6 > d4)
                    {
                        d = d6 - d4;
                    } else
                    {
                        d = d4 - d6;
                    }
                    logger.debug((new StringBuilder()).append("Rendition ").append(icreativerendition1.toString()).append(" aspect ratio ").append(d6).append(" offset ").append(d).toString());
                    if (d2 < 0.0D || d < d2)
                    {
                        logger.debug((new StringBuilder()).append("Less offset ").append(d).append(", drop ").append(arraylist1.size()).append(" kept renditions").toString());
                        logger.debug((new StringBuilder()).append("Keep rendition ").append(icreativerendition1.toString()).toString());
                        arraylist1.clear();
                        arraylist1.add(icreativerendition1);
                        d2 = d;
                    } else
                    if (d2 == d)
                    {
                        logger.debug((new StringBuilder()).append("Keep rendition ").append(icreativerendition1.toString()).toString());
                        arraylist1.add(icreativerendition1);
                    } else
                    {
                        logger.debug((new StringBuilder()).append("Drop rendition ").append(icreativerendition1.toString()).toString());
                    }
                } else
                {
                    logger.debug((new StringBuilder()).append("Keep rendition ").append(icreativerendition1.toString()).append(": unknown width or height").toString());
                    arraylist2.add(icreativerendition1);
                }
            }

            arraylist1.addAll(arraylist2);
            obj = arraylist1;
        } else
        {
            logger.warn("Unknown slot dimension, keep all renditions");
        }
        d3 = 1000D;
        s = (String)rendererContext.getParameter("desiredBitrate");
        d1 = d3;
        if (s == null) goto _L2; else goto _L1
_L1:
        d1 = d3;
        d3 = Double.parseDouble(s);
        if (d3 >= 0.0D)
        {
            break MISSING_BLOCK_LABEL_1034;
        }
        d1 = 1000D;
        try
        {
            throw new NumberFormatException();
        }
        // Misplaced declaration of an exception variable
        catch (NumberFormatException numberformatexception)
        {
            logger.warn((new StringBuilder()).append("Malformed or negative value of desiredBitrate: ").append(s).toString());
        }
          goto _L2
        d1 = d3;
        logger.debug((new StringBuilder()).append("Desired bit rate ").append(d3).append(" kbps").toString());
        d1 = d3;
        continue;
_L2:
        do
        {
            Object obj1 = new ArrayList();
            ArrayList arraylist3 = new ArrayList();
            ArrayList arraylist4 = new ArrayList();
            double d5 = 0.0D;
            d3 = -1D;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                ICreativeRendition icreativerendition2 = (ICreativeRendition)((Iterator) (obj)).next();
                if (icreativerendition2.getPrimaryCreativRenditionAsset() == null)
                {
                    logger.debug((new StringBuilder()).append("Drop rendition ").append(icreativerendition2.toString()).append(" that has no asset").toString());
                } else
                if (icreativerendition2.getPrimaryCreativRenditionAsset().getBytes() > 0 && icreativerendition2.getDuration() > 0.0D)
                {
                    double d7 = (8D * (double)icreativerendition2.getPrimaryCreativRenditionAsset().getBytes()) / 1000D / icreativerendition2.getDuration();
                    logger.debug((new StringBuilder()).append("Rendition ").append(icreativerendition2.toString()).append(" bit rate ").append(d7).toString());
                    if (d7 > d1)
                    {
                        if (d3 < 0.0D || d7 < d3)
                        {
                            logger.debug((new StringBuilder()).append("Less higher bit rate ").append(d7).append(", drop ").append(((ArrayList) (obj1)).size()).append(" renditions in pending list").toString());
                            logger.debug((new StringBuilder()).append("Keep rendition ").append(icreativerendition2.toString()).append(" in pending list").toString());
                            d3 = d7;
                            ((ArrayList) (obj1)).clear();
                            ((ArrayList) (obj1)).add(icreativerendition2);
                        } else
                        if (d7 == d3)
                        {
                            logger.debug((new StringBuilder()).append("Keep rendition ").append(icreativerendition2.toString()).append(" in pending list").toString());
                            ((ArrayList) (obj1)).add(icreativerendition2);
                        } else
                        {
                            logger.debug((new StringBuilder()).append("Drop rendition ").append(icreativerendition2.toString()).toString());
                        }
                    } else
                    if (d7 > d5)
                    {
                        logger.debug((new StringBuilder()).append("Less lower bit rate ").append(d7).append(", drop ").append(arraylist3.size()).append(" kept renditions").toString());
                        logger.debug((new StringBuilder()).append("Keep rendition ").append(icreativerendition2.toString()).toString());
                        d5 = d7;
                        arraylist3.clear();
                        arraylist3.add(icreativerendition2);
                    } else
                    if (d7 == d5)
                    {
                        logger.debug((new StringBuilder()).append("Keep rendition ").append(icreativerendition2.toString()).toString());
                        arraylist3.add(icreativerendition2);
                    } else
                    {
                        logger.debug((new StringBuilder()).append("Drop rendition ").append(icreativerendition2.toString()).toString());
                    }
                } else
                {
                    logger.debug((new StringBuilder()).append("Keep rendition ").append(icreativerendition2.toString()).append(": unknown duration or asset size").toString());
                    arraylist4.add(icreativerendition2);
                }
            }

            arraylist3.addAll(arraylist4);
            ArrayList arraylist = arraylist3;
            if (arraylist3.size() == 0)
            {
                arraylist = arraylist3;
                if (((ArrayList) (obj1)).size() > 0)
                {
                    logger.debug((new StringBuilder()).append("All renditions have higher bit rates than desired, use ").append(((ArrayList) (obj1)).size()).append(" renditions in pending list").toString());
                    arraylist = ((ArrayList) (obj1));
                }
            }
            obj1 = rendererContext.getAdInstance().getActiveCreativeRendition();
            if (arraylist.contains(obj1))
            {
                return ((ICreativeRendition) (obj1));
            }
            if (arraylist.size() > 0)
            {
                return (ICreativeRendition)arraylist.get(0);
            }
            return null;
        } while (true);
    }

    private void onImprTimer()
    {
        double d2 = getPlayheadTime();
        if (d2 <= 0.0D)
        {
            logger.debug("playhead <= 0");
            checkAndFailIfTimeout();
        } else
        {
            impressionCountBeforeStart = 0;
            if (!defaultImpressionSent)
            {
                rendererContext.dispatchEvent(constants.EVENT_AD_STARTED());
                defaultImpressionSent = true;
            }
            double d1 = getDuration();
            double d = d1;
            if (d1 <= 0.0D)
            {
                d = d1;
                if (estimatedDuration > 0.0D)
                {
                    logger.debug((new StringBuilder()).append("use estimatedDuration ").append(estimatedDuration).toString());
                    d = estimatedDuration;
                }
            }
            if (d > 0.0D)
            {
                sendQuartiles(d2 / d);
            } else
            {
                logger.debug("unknown duration");
            }
            if (videoAdView != null)
            {
                videoAdView.onImprTimer();
                return;
            }
        }
    }

    private void preload()
    {
        Object obj;
        logger.debug("preload");
        try
        {
            obj = slot.getBase();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Bundle bundle = new Bundle();
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_UNKNOWN());
            bundle.putString(constants.INFO_KEY_ERROR_INFO(), ((RuntimeException) (obj)).getMessage());
            HashMap hashmap = new HashMap();
            hashmap.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
            rendererContext.dispatchEvent(constants.EVENT_ERROR(), hashmap);
            ((RuntimeException) (obj)).printStackTrace();
            return;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        throw new RuntimeException("video display base is null, maybe forget to call registerVideoDisplay()?");
        logger.debug((new StringBuilder()).append("slotBase: ").append(obj).toString());
        videoAdView = new VideoAdView(((ViewGroup) (obj)).getContext(), this, useControlPanel);
        videoAdView.setId(0x77df444a);
        if (checkRedirectUrl)
        {
            videoAdView.tryToGetRedirectedUrl(assetUrl, (int)timeoutMillisecondsBeforeStart);
            return;
        }
        videoAdView.setAdUrl(assetUrl);
        onRedirectUrlChecked(assetUrl, null);
        return;
    }

    private void sendMissingQuartiles()
    {
        logger.debug("sendMissingQuartiles");
        sendQuartiles(1.0D);
    }

    private void sendQuartiles(double d)
    {
        if (d >= 0.25D && quartilesSent < 1)
        {
            logger.debug((new StringBuilder()).append("sendQuartiles ").append(d).toString());
            rendererContext.dispatchEvent(constants.EVENT_AD_FIRST_QUARTILE());
            quartilesSent = 1;
        }
        if (d >= 0.5D && quartilesSent < 2)
        {
            logger.debug((new StringBuilder()).append("sendQuartiles ").append(d).toString());
            rendererContext.dispatchEvent(constants.EVENT_AD_MIDPOINT());
            quartilesSent = 2;
        }
        if (d >= 0.75D && quartilesSent < 3)
        {
            logger.debug((new StringBuilder()).append("sendQuartiles ").append(d).toString());
            rendererContext.dispatchEvent(constants.EVENT_AD_THIRD_QUARTILE());
            quartilesSent = 3;
        }
        if (d >= 0.98999999999999999D && quartilesSent < 4)
        {
            logger.debug((new StringBuilder()).append("sendQuartiles ").append(d).toString());
            rendererContext.dispatchEvent(constants.EVENT_AD_COMPLETE());
            quartilesSent = 4;
        }
    }

    private void startQuartileImpressionAndTimeoutTimer()
    {
        if (timer != null)
        {
            return;
        } else
        {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {

                final VideoRenderer this$0;

                public void run()
                {
                    onImprTimer();
                }

            
            {
                this$0 = VideoRenderer.this;
                super();
            }
            }, 0L, 500L);
            return;
        }
    }

    private void stopQuartileTimer()
    {
        logger.debug("stopQuartileTimer");
        if (timer != null)
        {
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }

    public void dispose()
    {
        if (!internalState.compareAndSet(STATE_STARTED, STATE_DISPOSED) && !internalState.compareAndSet(STATE_STOPPED, STATE_DISPOSED))
        {
            logger.warn("dispose in incorrect state");
        } else
        {
            logger.debug("dispose");
            if (videoAdView != null)
            {
                final ViewGroup slotBase = slot.getBase();
                Handler handler = new Handler(slotBase.getContext().getMainLooper());
                videoAdView.dispose();
                handler.post(new Runnable() {

                    final VideoRenderer this$0;
                    final ViewGroup val$slotBase;

                    public void run()
                    {
                        videoAdView.setVisibility(8);
                        slotBase.removeView(videoAdView);
                        videoAdView = null;
                    }

            
            {
                this$0 = VideoRenderer.this;
                slotBase = viewgroup;
                super();
            }
                });
                return;
            }
        }
    }

    public double getDuration()
    {
        if (internalState.get() != STATE_STARTED)
        {
            logger.warn("getDuration in incorrect state");
        } else
        if (videoAdView != null && videoAdView.getDuration() > 0.0D)
        {
            return videoAdView.getDuration() / 1000D;
        }
        return -1D;
    }

    protected int getHeight()
    {
        return slot.getHeight();
    }

    public HashMap getModuleInfo()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("moduleType", "renderer");
        hashmap.put("requiredAPIVersion", "5.15.2-r10578-1407080530");
        return hashmap;
    }

    public double getPlayheadTime()
    {
        if (internalState.get() != STATE_STARTED)
        {
            logger.warn("getPlayheadTime in incorrect state");
        } else
        if (videoAdView != null)
        {
            return videoAdView.getPlayheadTime() / 1000D;
        }
        return -1D;
    }

    protected int getWidth()
    {
        return slot.getWidth();
    }

    public void load(IRendererContext irenderercontext)
    {
        Object obj1;
        logger.debug("init");
        rendererContext = irenderercontext;
        constants = rendererContext.getConstants();
        slot = rendererContext.getAdInstance().getSlot();
        Object obj = rendererContext.getParameter("timeoutMillisecondsBeforeStart");
        if (obj != null)
        {
            double d = Double.parseDouble(obj.toString());
            if (d > 0.0D)
            {
                timeoutMillisecondsBeforeStart = d;
            }
        }
        timeoutCountBeforeStart = (int)(timeoutMillisecondsBeforeStart / 500D);
        obj = rendererContext.getParameter("renderer.video.clickDetection");
        if (obj != null && obj.toString().equals("false"))
        {
            clickHandledByPlayer = true;
            obj = rendererContext.getParameter("renderer.video.useControlPanel");
            if (obj != null)
            {
                useControlPanel = obj.toString().equals("true");
            }
        }
        obj = rendererContext.getParameter("renderer.video.checkRedirectURL");
        if (obj != null && obj.toString().equals("true"))
        {
            checkRedirectUrl = true;
        }
        obj = getBestFitRendition();
        if (obj == null)
        {
            obj = new Bundle();
            HashMap hashmap;
            if (HLSDropped)
            {
                ((Bundle) (obj)).putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_UNKNOWN());
                ((Bundle) (obj)).putString(constants.INFO_KEY_ERROR_INFO(), (new StringBuilder()).append("HLS not supported on Android version ").append(android.os.Build.VERSION.RELEASE).toString());
            } else
            {
                ((Bundle) (obj)).putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_NULL_ASSET());
                ((Bundle) (obj)).putString(constants.INFO_KEY_ERROR_INFO(), "No asset");
            }
            hashmap = new HashMap();
            hashmap.put(constants.INFO_KEY_EXTRA_INFO(), obj);
            irenderercontext.dispatchEvent(constants.EVENT_ERROR(), hashmap);
            return;
        }
        logger.debug((new StringBuilder()).append("Best fit rendition ").append(obj.toString()).toString());
        rendererContext.getAdInstance().setActiveCreativeRendition(((ICreativeRendition) (obj)));
        estimatedDuration = ((ICreativeRendition) (obj)).getDuration();
        renditionWidth = ((ICreativeRendition) (obj)).getWidth();
        renditionHeight = ((ICreativeRendition) (obj)).getHeight();
        if (renditionWidth <= 0)
        {
            renditionWidth = slot.getWidth();
        }
        if (renditionHeight <= 0)
        {
            renditionHeight = slot.getHeight();
        }
        rendererContext.setRendererCapability(constants.EVENT_AD_QUARTILE(), constants.CAPABILITY_STATUS_ON());
        rendererContext.setRendererCapability(constants.EVENT_AD_MUTE(), constants.CAPABILITY_STATUS_ON());
        rendererContext.setRendererCapability(constants.EVENT_AD_UNMUTE(), constants.CAPABILITY_STATUS_ON());
        rendererContext.setRendererCapability(constants.EVENT_AD_PAUSE(), constants.CAPABILITY_STATUS_ON());
        rendererContext.setRendererCapability(constants.EVENT_AD_RESUME(), constants.CAPABILITY_STATUS_ON());
        HashMap hashmap1;
        if (((ICreativeRendition) (obj)).getPrimaryCreativRenditionAsset() != null)
        {
            assetUrl = ((ICreativeRendition) (obj)).getPrimaryCreativRenditionAsset().getURL();
        } else
        {
            assetUrl = "";
        }
        obj = assetUrl;
        logger.debug((new StringBuilder()).append("assetUrl passed in: ").append(assetUrl).toString());
        obj1 = new URI(assetUrl);
        if (!((URI) (obj1)).isAbsolute())
        {
            obj1 = new Bundle();
            ((Bundle) (obj1)).putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_NULL_ASSET());
            ((Bundle) (obj1)).putString(constants.INFO_KEY_ERROR_INFO(), (new StringBuilder()).append("original assetUrl: ").append(((String) (obj))).toString());
            hashmap1 = new HashMap();
            hashmap1.put(constants.INFO_KEY_EXTRA_INFO(), obj1);
            irenderercontext.dispatchEvent(constants.EVENT_ERROR(), hashmap1);
            return;
        }
        logger.debug((new StringBuilder()).append("converted to URI: ").append(((URI) (obj1)).toString()).toString());
        if (supportPreload)
        {
            preload();
            return;
        }
        try
        {
            irenderercontext.dispatchEvent(constants.EVENT_AD_LOADED());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            assetUrl = URIUtil.getFixedString(assetUrl);
            logger.debug((new StringBuilder()).append("assetUrl fixed: ").append(assetUrl).toString());
            if (assetUrl == null)
            {
                obj1 = new Bundle();
                ((Bundle) (obj1)).putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_NULL_ASSET());
                ((Bundle) (obj1)).putString(constants.INFO_KEY_ERROR_INFO(), (new StringBuilder()).append("original assetUrl: ").append(((String) (obj))).append(", fixed assetUrl: ").append(assetUrl).toString());
                obj = new HashMap();
                ((HashMap) (obj)).put(constants.INFO_KEY_EXTRA_INFO(), obj1);
                irenderercontext.dispatchEvent(constants.EVENT_ERROR(), ((HashMap) (obj)));
                return;
            }
        }
        if (supportPreload)
        {
            preload();
            return;
        } else
        {
            irenderercontext.dispatchEvent(constants.EVENT_AD_LOADED());
            return;
        }
    }

    public void onAdMuted()
    {
        logger.debug("onAdMuted");
        rendererContext.dispatchEvent(constants.EVENT_AD_MUTE());
    }

    public void onAdPaused()
    {
        logger.debug("onAdPaused");
        rendererContext.dispatchEvent(constants.EVENT_AD_PAUSE());
    }

    public void onAdResumed()
    {
        logger.debug("onAdResumed");
        rendererContext.dispatchEvent(constants.EVENT_AD_RESUME());
    }

    public void onAdRewind()
    {
        logger.debug("onAdRewind");
        rendererContext.dispatchEvent(constants.EVENT_AD_REWIND());
    }

    public void onAdUnMuted()
    {
        logger.debug("onAdUnMuted");
        rendererContext.dispatchEvent(constants.EVENT_AD_UNMUTE());
    }

    public void onAdVideoViewComplete()
    {
        logger.debug("onAdVideoViewComplete");
        stopQuartileTimer();
        sendMissingQuartiles();
        rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
    }

    public void onAdVideoViewError(Bundle bundle)
    {
        logger.debug((new StringBuilder()).append("onAdVideoViewError: ").append(bundle.getString(constants.INFO_KEY_ERROR_INFO())).toString());
        stopQuartileTimer();
        HashMap hashmap = new HashMap();
        hashmap.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
        rendererContext.dispatchEvent(constants.EVENT_ERROR(), hashmap);
    }

    public void onAdViewBuffered(boolean flag)
    {
        IRendererContext irenderercontext = rendererContext;
        String s;
        if (flag)
        {
            s = constants.EVENT_AD_BUFFERING_END();
        } else
        {
            s = constants.EVENT_AD_BUFFERING_START();
        }
        irenderercontext.dispatchEvent(s);
    }

    public void onAdViewClicked()
    {
        logger.debug((new StringBuilder()).append("onAdViewClicked, clickHandleByPlayer ").append(clickHandledByPlayer).toString());
        if (!clickHandledByPlayer)
        {
            rendererContext.dispatchEvent(constants.EVENT_AD_CLICK());
        }
    }

    public void onAdViewLoaded()
    {
        logger.debug("onAdViewLoaded");
        if (videoAdView != null)
        {
            rendererContext.dispatchEvent(constants.EVENT_AD_LOADED());
        }
    }

    public void onAdViewMediaPrepared()
    {
        logger.debug((new StringBuilder()).append("onAdViewMediaPrepared. Renderer paused ").append(isPaused).toString());
        if (videoAdView != null && !isPaused)
        {
            videoAdView.startPlayback();
        }
    }

    public void onAdViewStart()
    {
        logger.debug("onAdViewStart");
        startQuartileImpressionAndTimeoutTimer();
    }

    public void onAdViewSurfaceDestroyed()
    {
        stopQuartileTimer();
    }

    public void onRedirectUrlChecked(String s, Exception exception)
    {
        logger.debug((new StringBuilder()).append("onRedirectUrlChecked url ").append(s).toString());
        if (exception != null)
        {
            Bundle bundle = new Bundle();
            s = constants.ERROR_UNKNOWN();
            if (exception instanceof SocketTimeoutException)
            {
                s = constants.ERROR_TIMEOUT();
            }
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), s);
            bundle.putString(constants.INFO_KEY_ERROR_INFO(), exception.getMessage());
            s = new HashMap();
            s.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
            rendererContext.dispatchEvent(constants.EVENT_ERROR(), s);
            return;
        }
        assetUrl = s;
        if (supportPreload)
        {
            videoAdView.loadContent();
            return;
        } else
        {
            (new Handler(slot.getBase().getContext().getMainLooper())).post(new Runnable() {

                final VideoRenderer this$0;

                public void run()
                {
                    slot.getBase().addView(videoAdView);
                    videoAdView.bringToFront();
                }

            
            {
                this$0 = VideoRenderer.this;
                super();
            }
            });
            return;
        }
    }

    public void pause()
    {
        if (internalState.get() != STATE_STARTED)
        {
            logger.warn("pause in incorrect state");
        } else
        {
            logger.debug("pause");
            stopQuartileTimer();
            if (videoAdView != null)
            {
                isPaused = true;
                videoAdView.pause();
                onAdPaused();
                return;
            }
        }
    }

    public void resize()
    {
        if (videoAdView != null)
        {
            FrameLayout framelayout = (FrameLayout)videoAdView.getParent();
            if (framelayout != null && framelayout != slot.getBase())
            {
                logger.debug("video display base changed");
                videoAdView.pause();
                framelayout.removeView(videoAdView);
                slot.getBase().addView(videoAdView);
                videoAdView.start();
            }
        }
    }

    public void resume()
    {
        if (internalState.get() != STATE_STARTED)
        {
            logger.warn("resume in incorrect state");
            return;
        } else
        {
            logger.debug("resume");
            _resume();
            return;
        }
    }

    public void start()
    {
        logger.debug("start");
        defaultImpressionSent = false;
        startQuartileImpressionAndTimeoutTimer();
        if (supportPreload)
        {
            final ViewGroup slotBase = slot.getBase();
            (new Handler(slotBase.getContext().getMainLooper())).post(new Runnable() {

                final VideoRenderer this$0;
                final ViewGroup val$slotBase;

                public void run()
                {
                    slotBase.addView(videoAdView);
                    videoAdView.bringToFront();
                    videoAdView.requestFocus();
                    videoAdView.start();
                }

            
            {
                this$0 = VideoRenderer.this;
                slotBase = viewgroup;
                super();
            }
            });
            return;
        } else
        {
            preload();
            return;
        }
    }

    public void stop()
    {
        if (!internalState.compareAndSet(STATE_STARTED, STATE_STOPPED))
        {
            logger.warn("stop in incorrect state");
            return;
        }
        logger.debug("stop");
        stopQuartileTimer();
        if (videoAdView != null)
        {
            videoAdView.stop();
        }
        rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
    }

    static 
    {
        HLSSupportVersion = 11;
    }



/*
    static VideoAdView access$002(VideoRenderer videorenderer, VideoAdView videoadview)
    {
        videorenderer.videoAdView = videoadview;
        return videoadview;
    }

*/


}
