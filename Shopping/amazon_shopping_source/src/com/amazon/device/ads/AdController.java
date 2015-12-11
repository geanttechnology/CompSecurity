// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            IAdController, IAdLoaderCallback, WebViewFactory, AdRenderer, 
//            Log, AdError, AdData, MetricsCollector, 
//            DeviceInfo, Metrics, WebRequest, DefaultAdListener, 
//            AdRendererFactory, AdSize, AdUtils, AdLayout, 
//            AdListener, AdProperties

class AdController
    implements IAdController, IAdLoaderCallback
{

    private static final String LOG_TAG = "AdController";
    private AdData adData;
    private final AdLayout adLayout;
    private AdListener adListener;
    private final AdSize adSize;
    private int adWindowHeight;
    private int adWindowWidth;
    private final Context context;
    private AdRenderer currentAdRenderer;
    private boolean isLoading;
    private int timeout;
    private WebView webView;

    protected AdController()
    {
        timeout = 20000;
        adLayout = null;
        context = null;
        adSize = null;
    }

    AdController(AdLayout adlayout, AdSize adsize, Context context1)
    {
        timeout = 20000;
        adLayout = adlayout;
        context = context1;
        adSize = adsize;
        adListener = createAdListener();
    }

    private void createAndCacheWebView()
    {
        webView = WebViewFactory.getInstance().createWebView(context);
    }

    private void destroyCurrentAdRenderer()
    {
        if (currentAdRenderer != null)
        {
            currentAdRenderer.removeView();
            currentAdRenderer.destroy();
            currentAdRenderer = null;
        }
    }

    protected static String getAsSizeString(int i, int j)
    {
        return (new StringBuilder()).append(Integer.toString(i)).append("x").append(Integer.toString(j)).toString();
    }

    private void prepareRenderer(AdData.AAXCreative aaxcreative)
    {
        currentAdRenderer = createAdRendererFromFactory(aaxcreative, currentAdRenderer);
        if (currentAdRenderer == null)
        {
            Log.d("AdController", "No renderer returned, not loading an ad");
            adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "No renderer returned, not loading an ad"));
        } else
        {
            currentAdRenderer.initialize();
            getAdData().setIsRendering(true);
            long l = System.nanoTime();
            getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, l);
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER, l);
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER_FAILED, l);
            if (!currentAdRenderer.render())
            {
                destroyCurrentAdRenderer();
                Log.d("AdController", "Ad could not render");
                adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Ad could not render"));
                return;
            }
        }
    }

    private void processAdFailure()
    {
        if (webView != null)
        {
            webView.destroy();
            webView = null;
        }
        isLoading = false;
    }

    private void retrieveAndSetUserAgentString()
    {
        createAndCacheWebView();
        DeviceInfo.setUserAgentString(webView.getSettings().getUserAgentString());
    }

    private void submitAndResetMetricsIfNecessary(boolean flag)
    {
        if (flag)
        {
            Metrics.getInstance().submitAndResetMetrics(getAdData());
        }
    }

    protected void accumulateAdFailureMetrics(AdError aderror)
    {
        long l = System.nanoTime();
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER_FAILED, l);
        if (aderror.getCode() != AdError.ErrorCode.NO_FILL)
        {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED);
        }
        if (getAdData().getIsRendering())
        {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_RENDERING_FATAL);
            getAdData().setIsRendering(false);
        }
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_FAILURE, l);
        setAdditionalMetrics();
    }

    public void adClosedExpansion()
    {
        (new Handler(context.getMainLooper())).post(new Runnable() {

            final AdController this$0;

            public void run()
            {
                adListener.onAdCollapsed(adLayout);
            }

            
            {
                this$0 = AdController.this;
                super();
            }
        });
    }

    public void adExpanded()
    {
        (new Handler(context.getMainLooper())).post(new Runnable() {

            final AdController this$0;

            public void run()
            {
                adListener.onAdExpanded(adLayout);
            }

            
            {
                this$0 = AdController.this;
                super();
            }
        });
    }

    public void adFailed(AdError aderror)
    {
        if (getAdData() == null || getAdData().getMetricsCollector().isMetricsCollectorEmpty())
        {
            adFailedBeforeAdMetricsStart(aderror);
            return;
        } else
        {
            adFailedAfterAdMetricsStart(aderror);
            return;
        }
    }

    protected void adFailedAfterAdMetricsStart(AdError aderror)
    {
        processAdFailure();
        accumulateAdFailureMetrics(aderror);
        callListenerOnAdFailedToLoad(aderror, true);
    }

    protected void adFailedBeforeAdMetricsStart(AdError aderror)
    {
        processAdFailure();
        callListenerOnAdFailedToLoad(aderror, false);
    }

    public void adLoaded(final AdProperties props)
    {
        long l = System.nanoTime();
        adShown();
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_SUCCESS, l);
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER, l);
        setAdditionalMetrics();
        getAdData().setIsRendering(false);
        isLoading = false;
        (new Handler(context.getMainLooper())).post(new Runnable() {

            final AdController this$0;
            final AdProperties val$props;

            public void run()
            {
                adListener.onAdLoaded(adLayout, props);
                submitAndResetMetricsIfNecessary(true);
            }

            
            {
                this$0 = AdController.this;
                props = adproperties;
                super();
            }
        });
    }

    public void adShown()
    {
        WebRequest.executeWebRequestInThread(getAdData().getImpressionPixelUrl());
    }

    protected void callListenerOnAdFailedToLoad(final AdError error, final boolean shouldSubmitMetrics)
    {
        (new Handler(context.getMainLooper())).post(new Runnable() {

            final AdController this$0;
            final AdError val$error;
            final boolean val$shouldSubmitMetrics;

            public void run()
            {
                adListener.onAdFailedToLoad(adLayout, error);
                submitAndResetMetricsIfNecessary(shouldSubmitMetrics);
            }

            
            {
                this$0 = AdController.this;
                error = aderror;
                shouldSubmitMetrics = flag;
                super();
            }
        });
    }

    protected AdListener createAdListener()
    {
        return new DefaultAdListener("AdController");
    }

    protected AdRenderer createAdRendererFromFactory(AdData.AAXCreative aaxcreative, AdRenderer adrenderer)
    {
        AdRendererFactory adrendererfactory = new AdRendererFactory();
        if (adrendererfactory.shouldCreateNewRenderer(aaxcreative, adrenderer))
        {
            Log.d("AdController", "Creating new renderer");
            if (adrenderer != null)
            {
                adrenderer.destroy();
            }
            if (webView == null)
            {
                createAndCacheWebView();
            }
            aaxcreative = adrendererfactory.getAdRenderer(aaxcreative, adData, this, webView, context);
            webView = null;
            return aaxcreative;
        } else
        {
            Log.d("AdController", "Re-using renderer");
            adrenderer.setAd(adData);
            return adrenderer;
        }
    }

    public void destroy()
    {
        destroyCurrentAdRenderer();
    }

    protected AdData getAdData()
    {
        return adData;
    }

    public AdLayout getAdLayout()
    {
        return adLayout;
    }

    protected AdListener getAdListener()
    {
        return adListener;
    }

    public AdSize getAdSize()
    {
        return adSize;
    }

    protected Context getContext()
    {
        return context;
    }

    protected AdRenderer getCurrentAdRenderer()
    {
        return currentAdRenderer;
    }

    public String getMaxSize()
    {
        if (!adSize.isAuto())
        {
            return null;
        } else
        {
            return getAsSizeString(getWindowWidth(), getWindowHeight());
        }
    }

    public AdWebViewClient.UrlExecutor getSpecialUrlExecutor()
    {
        return new AdWebViewClient.AmazonMobileExecutor(currentAdRenderer, context);
    }

    public int getTimeout()
    {
        return timeout;
    }

    public int getWindowHeight()
    {
        return adWindowHeight;
    }

    public int getWindowWidth()
    {
        return adWindowWidth;
    }

    public void handleResponse()
    {
        AdData.AAXCreative aaxcreative;
label0:
        {
            if (currentAdRenderer != null)
            {
                currentAdRenderer.removeView();
            }
            if (adData == null)
            {
                Log.d("AdController", "We are unable to load the ad due to an internal error.");
                adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "We are unable to load the ad due to an internal error."));
                return;
            }
            if (adData.getCreativeTypes() != null && !adData.getCreativeTypes().isEmpty())
            {
                aaxcreative = AdData.AAXCreative.getTopCreative(adData.getCreativeTypes());
                if (aaxcreative != null)
                {
                    break label0;
                }
            }
            Log.d("AdController", "There were no valid creative types returned, and we are unable to load the ad.");
            adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "There were no valid creative types returned, and we are unable to load the ad."));
            return;
        }
        prepareRenderer(aaxcreative);
    }

    public boolean isAdExpanded()
    {
        if (currentAdRenderer == null)
        {
            return false;
        } else
        {
            return currentAdRenderer.getAdState(AdRenderer.AdState.valueOf("EXPANDED"));
        }
    }

    public boolean isAdLoading()
    {
        return isLoading;
    }

    public void prepareAd(long l)
    {
        Looper looper;
label0:
        {
            setNewAdData();
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l);
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_FAILURE, l);
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_SUCCESS, l);
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, l);
            if (adSize.isAuto())
            {
                getAdData().setMaxSize(getMaxSize());
            }
            isLoading = true;
            if (DeviceInfo.getUserAgentString() == null)
            {
                looper = Looper.getMainLooper();
                if (Thread.currentThread() != looper.getThread())
                {
                    break label0;
                }
                retrieveAndSetUserAgentString();
            }
            return;
        }
        (new Handler(looper)).post(new Runnable() {

            final AdController this$0;

            public void run()
            {
                if (DeviceInfo.getUserAgentString() == null)
                {
                    retrieveAndSetUserAgentString();
                }
            }

            
            {
                this$0 = AdController.this;
                super();
            }
        });
    }

    public void prepareToGoAway()
    {
        if (currentAdRenderer != null)
        {
            currentAdRenderer.prepareToGoAway();
        }
    }

    public boolean sendCommand(String s, HashMap hashmap)
    {
        if (currentAdRenderer != null)
        {
            return currentAdRenderer.sendCommand(s, hashmap);
        } else
        {
            return false;
        }
    }

    protected void setAdData(AdData addata)
    {
        adData = addata;
    }

    protected void setAdditionalMetrics()
    {
        AdUtils.setConnectionMetrics(getAdData());
        if (getAdLayout().isParentViewMissingAtLoadTime())
        {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_PARENT_VIEW_MISSING);
        }
        if (getWindowHeight() == 0)
        {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.ADLAYOUT_HEIGHT_ZERO);
        }
        if (currentAdRenderer != null)
        {
            getAdData().getMetricsCollector().setMetricString(Metrics.MetricType.VIEWPORT_SCALE, currentAdRenderer.getScalingMultiplierDescription());
        }
    }

    public void setListener(AdListener adlistener)
    {
        if (adlistener == null)
        {
            adListener = createAdListener();
            return;
        } else
        {
            adListener = adlistener;
            return;
        }
    }

    protected void setNewAdData()
    {
        setAdData(new AdData(adSize));
    }

    public void setTimeout(int i)
    {
        timeout = i;
    }

    public void setWindowDimensions(int i, int j)
    {
        adWindowWidth = i;
        adWindowHeight = j;
    }

    public boolean shouldDisableWebViewHardwareAcceleration()
    {
        return getAdLayout().shouldDisableWebViewHardwareAcceleration();
    }




}
