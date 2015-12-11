// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.webkit.WebView;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            Ad, AdData, MetricsCollector, AdError, 
//            InternalAdRegistration, IInternalAdRegistration, DefaultAdListener, AdUtils, 
//            Log, IAdLoaderCallback, AdListener, MraidView, 
//            AdSlot, AdLoader, AdSize, WebViewFactory, 
//            AdActivity, InterstitialAdActivityAdapter, Metrics, AdTargetingOptions, 
//            WebRequest, AdView

public class InterstitialAd
    implements Ad
{
    class InterstitialAdLoaderCallback
        implements IAdLoaderCallback
    {

        private final InterstitialAd interstitialAd;
        final InterstitialAd this$0;

        public void adFailed(AdError aderror)
        {
            if (!getAndSetHasFinishedLoading(true))
            {
                failAd(aderror);
            }
        }

        public void adShown()
        {
            WebRequest.executeWebRequestInThread(getAdData().getImpressionPixelUrl());
        }

        public int getTimeout()
        {
            return interstitialAd.getTimeout();
        }

        public void handleResponse()
        {
            prerenderHtml();
        }

        public InterstitialAdLoaderCallback(InterstitialAd interstitialad1)
        {
            this$0 = InterstitialAd.this;
            super();
            interstitialAd = interstitialad1;
        }
    }

    static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State DISMISSED;
        public static final State LOADING;
        public static final State READY_TO_LOAD;
        public static final State READY_TO_SHOW;
        public static final State SHOWING;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/amazon/device/ads/InterstitialAd$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            READY_TO_LOAD = new State("READY_TO_LOAD", 0);
            LOADING = new State("LOADING", 1);
            READY_TO_SHOW = new State("READY_TO_SHOW", 2);
            SHOWING = new State("SHOWING", 3);
            DISMISSED = new State("DISMISSED", 4);
            $VALUES = (new State[] {
                READY_TO_LOAD, LOADING, READY_TO_SHOW, SHOWING, DISMISSED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final String ACTION_INTERSTITIAL_DISMISSED = "dismissed";
    protected static final String ACTION_INTERSTITIAL_FINISHED_LOADING = "finished";
    protected static final String BROADCAST_ACTION = "action";
    protected static final String BROADCAST_CREATIVE = "creative";
    protected static final String BROADCAST_INTENT = "amazon.mobile.ads.interstitial";
    protected static final String BROADCAST_UNIQUE_IDENTIFIER_KEY = "uniqueIdentifier";
    private static final String LOG_TAG = "InterstitialAd";
    protected static final String MSG_PREPARE_AD_DESTROYED = "This interstitial ad has been destroyed and can no longer be used. Create a new InterstitialAd object to load a new ad.";
    protected static final String MSG_PREPARE_AD_LOADING = "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.";
    protected static final String MSG_PREPARE_AD_READY_TO_SHOW = "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.";
    protected static final String MSG_PREPARE_AD_SHOWING = "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.";
    protected static final String MSG_SHOW_AD_ANOTHER_SHOWING = "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad.";
    protected static final String MSG_SHOW_AD_DESTROYED = "The interstitial ad cannot be shown because it has been destroyed. Create a new InterstitialAd object to load a new ad.";
    protected static final String MSG_SHOW_AD_DISMISSED = "The interstitial ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad.";
    protected static final String MSG_SHOW_AD_EXPIRED = "This interstitial ad has expired. Please load another ad.";
    protected static final String MSG_SHOW_AD_LOADING = "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.";
    protected static final String MSG_SHOW_AD_READY_TO_LOAD = "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.";
    protected static final String MSG_SHOW_AD_SHOWING = "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad.";
    private static final AtomicBoolean isAdShowing = new AtomicBoolean(false);
    private final Activity activity;
    private AdData adData;
    private AdListener adListener;
    private IAdLoaderCallback adLoaderCallback;
    private BroadcastReceiver broadcastReceiver;
    private final AtomicBoolean hasFinishedLoading;
    private boolean hasPassedActivityValidationCheck;
    private final AtomicBoolean isPrerendering;
    private MraidView mraidView;
    private State state;
    private int timeout;
    private Timer timer;
    private final String uniqueIdentifier;

    public InterstitialAd(Activity activity1)
    {
        this(activity1, generateUniqueIdentifier());
    }

    InterstitialAd(Activity activity1, String s)
    {
        adListener = null;
        adData = null;
        timeout = 20000;
        broadcastReceiver = null;
        isPrerendering = new AtomicBoolean(false);
        hasFinishedLoading = new AtomicBoolean(false);
        if (activity1 == null)
        {
            throw new IllegalArgumentException("InterstitialAd requires a non-null Activity");
        } else
        {
            activity = activity1;
            uniqueIdentifier = s;
            adLoaderCallback = new InterstitialAdLoaderCallback(this);
            initialize();
            return;
        }
    }

    private void failAd(AdError aderror)
    {
        setState(State.READY_TO_LOAD);
        long l = System.nanoTime();
        if (getAdData() != null && getAdData().getMetricsCollector() != null)
        {
            getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l);
            getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, l);
            getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_FAILURE, l);
            if (aderror != null && (aderror.getCode() == AdError.ErrorCode.NO_FILL || aderror.getCode() == AdError.ErrorCode.NETWORK_ERROR || aderror.getCode() == AdError.ErrorCode.NETWORK_TIMEOUT))
            {
                getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED);
                if (aderror.getCode() == AdError.ErrorCode.NETWORK_TIMEOUT)
                {
                    getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT);
                }
            }
        }
        callOnAdFailedToLoadOnMainThread(aderror);
    }

    private static String generateUniqueIdentifier()
    {
        return UUID.randomUUID().toString();
    }

    private void initialize()
    {
        InternalAdRegistration.getInstance().contextReceived(activity.getApplicationContext());
        setState(State.READY_TO_LOAD);
        adListener = new DefaultAdListener("InterstitialAd");
        hasPassedActivityValidationCheck = AdUtils.checkDefinedActivities(activity.getApplicationContext());
    }

    public static boolean isAdShowing()
    {
        return isAdShowing.get();
    }

    private void onRequestError(String s)
    {
        Log.e("InterstitialAd", s);
        getAdLoaderCallback().adFailed(new AdError(AdError.ErrorCode.REQUEST_ERROR, s));
    }

    static void resetIsAdShowing()
    {
        isAdShowing.set(false);
    }

    private void setAdditionalMetrics()
    {
        getAdData().getMetricsCollector().setAdType(AdProperties.AdType.INTERSTITIAL);
        getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_IS_INTERSTITIAL);
        AdUtils.setConnectionMetrics(getAdData());
    }

    void callOnAdDismissed()
    {
        adListener.onAdDismissed(this);
    }

    void callOnAdDismissedOnMainThread()
    {
        (new Handler(activity.getApplicationContext().getMainLooper())).post(new Runnable() {

            final InterstitialAd this$0;

            public void run()
            {
                callOnAdDismissed();
                submitAndResetMetrics();
            }

            
            {
                this$0 = InterstitialAd.this;
                super();
            }
        });
    }

    void callOnAdFailedToLoad(AdError aderror)
    {
        adListener.onAdFailedToLoad(this, aderror);
    }

    void callOnAdFailedToLoadOnMainThread(final AdError error)
    {
        (new Handler(activity.getApplicationContext().getMainLooper())).post(new Runnable() {

            final InterstitialAd this$0;
            final AdError val$error;

            public void run()
            {
                callOnAdFailedToLoad(error);
                submitAndResetMetrics();
            }

            
            {
                this$0 = InterstitialAd.this;
                error = aderror;
                super();
            }
        });
    }

    void callOnAdLoaded()
    {
        adListener.onAdLoaded(this, adData.getProperties());
    }

    void callOnAdLoadedOnMainThread()
    {
        (new Handler(activity.getApplicationContext().getMainLooper())).post(new Runnable() {

            final InterstitialAd this$0;

            public void run()
            {
                callOnAdLoaded();
            }

            
            {
                this$0 = InterstitialAd.this;
                super();
            }
        });
    }

    void cancelTimer()
    {
        timer.cancel();
    }

    MraidView constructMraidView(WebView webview)
    {
        return new MraidView(new AdView() {

            final InterstitialAd this$0;

            public int getHeight()
            {
                return 0;
            }

            public AdWebViewClient.UrlExecutor getSpecialUrlExecutor()
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
                getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER, l);
                getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l);
                getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_SUCCESS, l);
                onAdPrerendered();
            }

            public boolean shouldDisableWebViewHardwareAcceleration()
            {
                return false;
            }

            
            {
                this$0 = InterstitialAd.this;
                super();
            }
        }, activity, webview);
    }

    void executePostActivityShown()
    {
        getAdLoaderCallback().adShown();
    }

    AdData getAdData()
    {
        return adData;
    }

    IAdLoaderCallback getAdLoaderCallback()
    {
        return adLoaderCallback;
    }

    boolean getAndSetHasFinishedLoading(boolean flag)
    {
        return hasFinishedLoading.getAndSet(flag);
    }

    State getState()
    {
        return state;
    }

    public int getTimeout()
    {
        return timeout;
    }

    void handleDismissed()
    {
        getAdData().getMetricsCollector().stopMetric(Metrics.MetricType.AD_SHOW_DURATION);
        setState(State.DISMISSED);
        isAdShowing.set(false);
        callOnAdDismissedOnMainThread();
        unregisterBroadcastReceiver();
    }

    void handlePageFinished()
    {
        getAdData().getMetricsCollector().stopMetric(Metrics.MetricType.AD_SHOW_LATENCY);
        executePostActivityShown();
        submitAndResetMetricsOnMainThreadAndStartMetric(Metrics.MetricType.AD_SHOW_DURATION, System.nanoTime());
    }

    boolean hasDismissed()
    {
        return getState() == State.DISMISSED;
    }

    boolean isExpired()
    {
        return getAdData().isExpired();
    }

    public boolean isLoading()
    {
        return getState() == State.LOADING;
    }

    boolean isReadyToLoad()
    {
        return getState() == State.READY_TO_LOAD || hasDismissed();
    }

    boolean isReadyToShow()
    {
        return getState() == State.READY_TO_SHOW;
    }

    public boolean isShowing()
    {
        return getState() == State.SHOWING;
    }

    public boolean loadAd()
    {
        return loadAd(null);
    }

    public boolean loadAd(AdTargetingOptions adtargetingoptions)
    {
        return AdLoader.loadAds(getTimeout(), adtargetingoptions, new AdSlot[] {
            new AdSlot(this, adtargetingoptions)
        })[0];
    }

    void loadHtml(String s)
    {
        mraidView.loadHtmlData("http://amazon-adsystem.amazon.com/", s);
    }

    void onAdPrerendered()
    {
        if (mraidView != null)
        {
            mraidView.unregisterReceivers();
        }
        if (!getAndSetHasFinishedLoading(true))
        {
            isPrerendering.set(false);
            cancelTimer();
            setState(State.READY_TO_SHOW);
            callOnAdLoadedOnMainThread();
            long l = System.nanoTime();
            submitAndResetMetricsOnMainThreadAndStartMetric(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME, l);
        }
    }

    void onAdTimedOut()
    {
        boolean flag = isPrerendering.get();
        final MraidView mraidView = MraidView.removeCachedMraidView(uniqueIdentifier);
        if (mraidView != null)
        {
            (new Handler(activity.getApplicationContext().getMainLooper())).post(new Runnable() {

                final InterstitialAd this$0;
                final MraidView val$mraidView;

                public void run()
                {
                    mraidView.destroy();
                }

            
            {
                this$0 = InterstitialAd.this;
                mraidView = mraidview;
                super();
            }
            });
        }
        if (flag)
        {
            getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT);
        }
        failAd(new AdError(AdError.ErrorCode.NETWORK_ERROR, "Ad Load Timed Out"));
    }

    void onBroadcastReceived(Intent intent)
    {
        if (uniqueIdentifier.equals(intent.getStringExtra("uniqueIdentifier")) && "amazon.mobile.ads.interstitial".equals(intent.getAction()))
        {
            intent = intent.getStringExtra("action");
            if ("dismissed".equals(intent))
            {
                handleDismissed();
            } else
            if ("finished".equals(intent))
            {
                handlePageFinished();
                return;
            }
        }
    }

    int prepareAd(AdLoader.AdReadyToLoadListener adreadytoloadlistener)
    {
        long l;
        l = System.nanoTime();
        if (!hasPassedActivityValidationCheck)
        {
            onRequestError("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
            return 1;
        }
        if (isReadyToLoad()) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
        if (!isShowing()) goto _L4; else goto _L3
_L3:
        boolean flag;
        Log.e("InterstitialAd", "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.");
        flag = flag1;
_L5:
        if (flag)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (isReadyToShow())
        {
            if (getAdData() != null && getAdData().isExpired())
            {
                flag = false;
            } else
            {
                Log.e("InterstitialAd", "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.");
                flag = flag1;
            }
        } else
        {
            flag = flag1;
            if (isLoading())
            {
                Log.e("InterstitialAd", "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.");
                flag = flag1;
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
        isPrerendering.set(false);
        setHasFinishedLoading(false);
        if (timer != null)
        {
            timer.purge();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {

            final InterstitialAd this$0;

            public void run()
            {
                if (!getAndSetHasFinishedLoading(true))
                {
                    onAdTimedOut();
                }
            }

            
            {
                this$0 = InterstitialAd.this;
                super();
            }
        }, getTimeout());
        setState(State.LOADING);
        setAdData(new AdData(AdSize.SIZE_INTERSTITIAL));
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l);
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_FAILURE, l);
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_SUCCESS, l);
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, l);
        adreadytoloadlistener.onAdReady(this);
        return 0;
    }

    void prerenderHtml()
    {
        isPrerendering.set(true);
        String s = AdUtils.encloseHtml(adData.getCreative(), true).replace("<head>", (new StringBuilder()).append("<head>\n  <script type='text/javascript'>\n  var connectionType=\"").append(adData.getConnectionType()).append("\";\n").append("  var screenWidth=").append(adData.getScreenWidth()).append(";\n").append("  var screenHeight=").append(adData.getScreenHeight()).append(";\n").append("  </script>\n").toString());
        adData.setCreative(s);
        WebView webview = WebViewFactory.getInstance().createWebView(activity);
        webview.setBackgroundColor(0);
        mraidView = constructMraidView(webview);
        long l = System.nanoTime();
        getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, l);
        getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER, l);
        loadHtml(s);
    }

    void registerBroadcastReceiver()
    {
        broadcastReceiver = new BroadcastReceiver() {

            final InterstitialAd this$0;

            public void onReceive(Context context, Intent intent)
            {
                onBroadcastReceived(intent);
            }

            
            {
                this$0 = InterstitialAd.this;
                super();
            }
        };
        IntentFilter intentfilter = new IntentFilter("amazon.mobile.ads.interstitial");
        activity.getApplicationContext().registerReceiver(broadcastReceiver, intentfilter);
    }

    void setAdData(AdData addata)
    {
        adData = addata;
    }

    void setAdLoaderCallback(IAdLoaderCallback iadloadercallback)
    {
        adLoaderCallback = iadloadercallback;
    }

    void setHasFinishedLoading(boolean flag)
    {
        hasFinishedLoading.set(flag);
    }

    public void setListener(AdListener adlistener)
    {
        if (adlistener == null)
        {
            adListener = new DefaultAdListener("InterstitialAd");
            return;
        } else
        {
            adListener = adlistener;
            return;
        }
    }

    void setState(State state1)
    {
        state = state1;
    }

    public void setTimeout(int i)
    {
        timeout = i;
    }

    public boolean showAd()
    {
        long l = System.nanoTime();
        if (isReadyToShow())
        {
            if (isExpired())
            {
                Log.w("InterstitialAd", "This interstitial ad has expired. Please load another ad.");
                setState(State.READY_TO_LOAD);
                return false;
            }
            if (isAdShowing.getAndSet(true))
            {
                Log.w("InterstitialAd", "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad.");
                return false;
            }
            getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME, l);
            getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_SHOW_LATENCY, l);
            registerBroadcastReceiver();
            MraidView.cacheMraidView(uniqueIdentifier, mraidView);
            mraidView = null;
            boolean flag = showAdInActivity();
            if (flag)
            {
                setState(State.SHOWING);
                return flag;
            } else
            {
                MraidView.removeCachedMraidView(uniqueIdentifier);
                unregisterBroadcastReceiver();
                setState(State.READY_TO_LOAD);
                isAdShowing.set(false);
                getAdData().getMetricsCollector().stopMetric(Metrics.MetricType.AD_LATENCY_RENDER_FAILED);
                return flag;
            }
        }
        if (!hasDismissed()) goto _L2; else goto _L1
_L1:
        Log.w("InterstitialAd", "The interstitial ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad.");
_L4:
        return false;
_L2:
        if (isReadyToLoad())
        {
            Log.w("InterstitialAd", "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.");
        } else
        if (isLoading())
        {
            Log.w("InterstitialAd", "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.");
        } else
        if (isShowing())
        {
            Log.w("InterstitialAd", "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad.");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean showAdInActivity()
    {
        try
        {
            Intent intent = new Intent(activity.getApplicationContext(), com/amazon/device/ads/AdActivity);
            intent.putExtra("adapter", com/amazon/device/ads/InterstitialAdActivityAdapter.getName());
            intent.putExtra("uniqueIdentifier", uniqueIdentifier);
            intent.putExtra("creative", adData.getCreative());
            activity.startActivity(intent);
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.e("InterstitialAd", "Failed to show the interstitial ad because AdActivity could not be found.");
            return false;
        }
        return true;
    }

    protected void submitAndResetMetrics()
    {
        if (getAdData() != null && getAdData().getMetricsCollector() != null && !getAdData().getMetricsCollector().isMetricsCollectorEmpty())
        {
            setAdditionalMetrics();
            Metrics.getInstance().submitAndResetMetrics(getAdData());
        }
    }

    void submitAndResetMetricsOnMainThread()
    {
        submitAndResetMetricsOnMainThreadAndStartMetric(null, 0L);
    }

    void submitAndResetMetricsOnMainThreadAndStartMetric(final Metrics.MetricType metricType, final long startTime)
    {
        (new Handler(activity.getApplicationContext().getMainLooper())).post(new Runnable() {

            final InterstitialAd this$0;
            final Metrics.MetricType val$metricType;
            final long val$startTime;

            public void run()
            {
                submitAndResetMetrics();
                if (metricType != null)
                {
                    getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(metricType, startTime);
                }
            }

            
            {
                this$0 = InterstitialAd.this;
                metricType = metrictype;
                startTime = l;
                super();
            }
        });
    }

    void unregisterBroadcastReceiver()
    {
        activity.getApplicationContext().unregisterReceiver(broadcastReceiver);
        broadcastReceiver = null;
    }


}
