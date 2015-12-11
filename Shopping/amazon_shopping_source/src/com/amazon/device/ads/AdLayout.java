// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            Ad, AdSize, Log, InternalAdRegistration, 
//            IInternalAdRegistration, AdUtils, Metrics, MetricsCollector, 
//            Utils, IAdController, AdController, WebViewFactory, 
//            AdTargetingOptions, AdSlot, AdLoader, IAdLoaderCallback, 
//            AdError, PermissionChecker, RegistrationInfo, AdListener

public class AdLayout extends FrameLayout
    implements Ad
{
    private static class OnLayoutChangeListenerUtil
    {

        protected static void setOnLayoutChangeListenerForRoot(AdLayout adlayout, AdLoader.AdReadyToLoadListener adreadytoloadlistener)
        {
            adreadytoloadlistener = new android.view.View.OnLayoutChangeListener(adlayout, adreadytoloadlistener) {

                final AdLayout val$adLayout;
                final AdLoader.AdReadyToLoadListener val$loadListener;

                public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                        int k1, int l1)
                {
                    if (adLayout.needsToLoadAdOnLayout.getAndSet(false))
                    {
                        adLayout.setFloatingWindowDimensions();
                        adLayout.loadAdFromAdController(loadListener);
                        adLayout.activityRootView.removeOnLayoutChangeListener(this);
                    }
                }

            
            {
                adLayout = adlayout;
                loadListener = adreadytoloadlistener;
                super();
            }
            };
            adlayout.activityRootView.addOnLayoutChangeListener(adreadytoloadlistener);
        }

        private OnLayoutChangeListenerUtil()
        {
        }
    }


    public static final int DEFAULT_TIMEOUT = 20000;
    private static final String LOG_TAG = "AdLayout";
    private static ScheduledThreadPoolExecutor threadPool;
    private View activityRootView;
    private AdSize adSize;
    private boolean attached;
    private Context context;
    private IAdController controller;
    private boolean hasPassedActivityValidationCheck;
    private boolean hasRegisterBroadcastReciever;
    private boolean isInForeground;
    private boolean isParentViewMissingAtLoadTime;
    private int lastVisibility;
    private AdLoader.AdReadyToLoadListener listenerOnLayout;
    private long loadAdStartTime;
    private AtomicBoolean needsToLoadAdOnLayout;
    private BroadcastReceiver screenStateReceiver;
    private boolean shouldDisableWebViewHardwareAcceleration;

    public AdLayout(Activity activity)
    {
        this(activity, AdSize.SIZE_AUTO);
    }

    public AdLayout(Activity activity, AdSize adsize)
    {
        super(activity);
        hasRegisterBroadcastReciever = false;
        attached = false;
        lastVisibility = 8;
        needsToLoadAdOnLayout = new AtomicBoolean(false);
        listenerOnLayout = null;
        isParentViewMissingAtLoadTime = false;
        activityRootView = null;
        hasPassedActivityValidationCheck = false;
        loadAdStartTime = 0L;
        initialize(activity, adsize);
    }

    public AdLayout(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        hasRegisterBroadcastReciever = false;
        attached = false;
        lastVisibility = 8;
        needsToLoadAdOnLayout = new AtomicBoolean(false);
        listenerOnLayout = null;
        isParentViewMissingAtLoadTime = false;
        activityRootView = null;
        hasPassedActivityValidationCheck = false;
        loadAdStartTime = 0L;
        initialize(context1, attributeset);
    }

    public AdLayout(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        hasRegisterBroadcastReciever = false;
        attached = false;
        lastVisibility = 8;
        needsToLoadAdOnLayout = new AtomicBoolean(false);
        listenerOnLayout = null;
        isParentViewMissingAtLoadTime = false;
        activityRootView = null;
        hasPassedActivityValidationCheck = false;
        loadAdStartTime = 0L;
        initialize(context1, attributeset);
    }

    AdLayout(IAdController iadcontroller)
    {
        super(null);
        hasRegisterBroadcastReciever = false;
        attached = false;
        lastVisibility = 8;
        needsToLoadAdOnLayout = new AtomicBoolean(false);
        listenerOnLayout = null;
        isParentViewMissingAtLoadTime = false;
        activityRootView = null;
        hasPassedActivityValidationCheck = false;
        loadAdStartTime = 0L;
        controller = iadcontroller;
        initialize(null, ((AdSize) (null)));
    }

    private static String getAttributeValue(AttributeSet attributeset, String s, String s1)
    {
        return attributeset.getAttributeValue(s, s1);
    }

    private void initialize(Context context1, AttributeSet attributeset)
    {
        String s = getAttributeValue(attributeset, "http://schemas.android.com/apk/lib/com.amazon.device.ads", "adSize");
        Object obj = s;
        if (s == null)
        {
            attributeset = getAttributeValue(attributeset, (new StringBuilder()).append("http://schemas.android.com/apk/res/").append(context1.getPackageName()).toString(), "adSize");
            obj = attributeset;
            if (attributeset != null)
            {
                Log.w(true, "AdLayout", "DEPRECATED - Please use the XML namespace \"http://schemas.android.com/apk/lib/com.amazon.device.ads\" for specifying AdLayout properties.");
                obj = attributeset;
                if (attributeset.toLowerCase(Locale.US).equals("custom"))
                {
                    Log.e(true, "AdLayout", "Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
                    throw new IllegalArgumentException("Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
                }
            }
        }
        initialize(context1, parseAdSize(((String) (obj))));
    }

    private void initialize(Context context1, AdSize adsize)
    {
        InternalAdRegistration.getInstance().contextReceived(context1);
        AdSize adsize1 = adsize;
        if (adsize == null)
        {
            adsize1 = AdSize.SIZE_AUTO;
        }
        adSize = adsize1;
        context = context1;
        if (isInEditMode())
        {
            context1 = new TextView(context);
            context1.setText("AdLayout");
            context1.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            context1.setGravity(17);
            addView(context1);
            return;
        }
        boolean flag;
        if (getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isInForeground = flag;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (isWebViewDatabaseNull(context))
        {
            Log.e(true, "AdLayout", "Disabling ads. Local cache file is inaccessible so ads will fail if we try to create a WebView. Details of this Android bug found at: http://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        if (controller == null)
        {
            controller = createAdController(adSize, context);
        }
        hasPassedActivityValidationCheck = AdUtils.checkDefinedActivities(context);
    }

    private void loadAdWhenParentViewMissing(AdLoader.AdReadyToLoadListener adreadytoloadlistener)
    {
        if (getLayoutParams() == null)
        {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_NULL_LAYOUT_PARAMS);
            onRequestError("Can't load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.");
            return;
        }
        if (Utils.isAtLeastAndroidAPI(11))
        {
            setActivityRootView();
            if (isActivityRootViewNull())
            {
                onRequestError("Ad load failed because root view could not be obtained from the activity.");
                return;
            }
            if (isActivityRootViewLayoutRequested())
            {
                deferAdLoadToLayoutEvent(adreadytoloadlistener);
                setOnLayoutChangeListenerForRoot(adreadytoloadlistener);
                return;
            } else
            {
                setFloatingWindowDimensions();
                loadAdFromAdController(adreadytoloadlistener);
                return;
            }
        } else
        {
            setFloatingWindowDimensions();
            loadAdFromAdController(adreadytoloadlistener);
            return;
        }
    }

    private static AdSize parseAdSize(String s)
    {
        AdSize adsize1 = AdSize.SIZE_AUTO;
        AdSize adsize = adsize1;
        if (s != null)
        {
            s = s.toLowerCase(Locale.US);
            adsize = adsize1;
            if (!s.equals("auto"))
            {
                s = s.split("x");
                int j = 0;
                int i = 0;
                if (s.length == 2)
                {
                    j = Utils.parseInt(s[0], 0);
                    i = Utils.parseInt(s[1], 0);
                }
                adsize = new AdSize(j, i);
            }
        }
        return adsize;
    }

    private void registerScreenStateBroadcastReceiver()
    {
        if (hasRegisterBroadcastReciever)
        {
            return;
        } else
        {
            hasRegisterBroadcastReciever = true;
            screenStateReceiver = new BroadcastReceiver() {

                final AdLayout this$0;

                public void onReceive(Context context1, Intent intent)
                {
                    if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && isInForeground)
                    {
                        controller.sendCommand("close", null);
                    }
                }

            
            {
                this$0 = AdLayout.this;
                super();
            }
            };
            IntentFilter intentfilter = new IntentFilter("android.intent.action.SCREEN_OFF");
            intentfilter.addAction("android.intent.action.USER_PRESENT");
            context.getApplicationContext().registerReceiver(screenStateReceiver, intentfilter);
            return;
        }
    }

    private void unregisterScreenStateBroadcastReceiver()
    {
        if (hasRegisterBroadcastReciever)
        {
            hasRegisterBroadcastReciever = false;
            context.getApplicationContext().unregisterReceiver(screenStateReceiver);
        }
    }

    public boolean collapseAd()
    {
        return controller.sendCommand("close", null);
    }

    IAdController createAdController(AdSize adsize, Context context1)
    {
        return new AdController(this, adsize, context1);
    }

    void deferAdLoadToLayoutEvent(AdLoader.AdReadyToLoadListener adreadytoloadlistener)
    {
        needsToLoadAdOnLayout.set(true);
        listenerOnLayout = adreadytoloadlistener;
        scheduleTaskForCheckingIfLayoutHasRun();
    }

    public void destroy()
    {
        Log.d("AdLayout", "Destroying the AdLayout");
        unregisterScreenStateBroadcastReceiver();
        controller.destroy();
    }

    void failLoadIfLayoutHasNotRun()
    {
        if (needsToLoadAdOnLayout.getAndSet(false))
        {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_LAYOUT_NOT_RUN);
            onRequestError("Can't load an ad because the view size cannot be determined.");
        }
    }

    View getActivityRootView()
    {
        return activityRootView;
    }

    int getActivityRootViewDimension(boolean flag)
    {
        if (flag)
        {
            return activityRootView.getWidth();
        } else
        {
            return activityRootView.getHeight();
        }
    }

    AdController getAdController()
    {
        return (AdController)controller;
    }

    public AdSize getAdSize()
    {
        return adSize;
    }

    boolean getNeedsToLoadAdOnLayout()
    {
        return needsToLoadAdOnLayout.get();
    }

    int getRawScreenDimension(boolean flag)
    {
        WindowManager windowmanager = (WindowManager)context.getSystemService("window");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
        if (flag)
        {
            return displaymetrics.widthPixels;
        } else
        {
            return displaymetrics.heightPixels;
        }
    }

    public int getTimeout()
    {
        return controller.getTimeout();
    }

    boolean isActivityRootViewLayoutRequested()
    {
        return activityRootView.isLayoutRequested();
    }

    boolean isActivityRootViewNull()
    {
        return activityRootView == null;
    }

    public boolean isAdLoading()
    {
        return isLoading();
    }

    public boolean isLoading()
    {
        return controller.isAdLoading();
    }

    boolean isParentViewMissingAtLoadTime()
    {
        return isParentViewMissingAtLoadTime;
    }

    boolean isWebViewDatabaseNull(Context context1)
    {
        return WebViewDatabase.getInstance(context1) == null;
    }

    boolean isWebViewOk(Context context1)
    {
        return WebViewFactory.isWebViewOk(context1);
    }

    public boolean loadAd()
    {
        return loadAd(new AdTargetingOptions());
    }

    public boolean loadAd(AdTargetingOptions adtargetingoptions)
    {
        AdTargetingOptions adtargetingoptions1 = adtargetingoptions;
        if (adtargetingoptions == null)
        {
            adtargetingoptions1 = new AdTargetingOptions();
        }
        return AdLoader.loadAds(controller.getTimeout(), adtargetingoptions1, new AdSlot[] {
            new AdSlot(this, adtargetingoptions1)
        })[0];
    }

    void loadAdFromAdController(AdLoader.AdReadyToLoadListener adreadytoloadlistener)
    {
        controller.prepareAd(loadAdStartTime);
        adreadytoloadlistener.onAdReady(this);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (isInEditMode())
        {
            return;
        } else
        {
            attached = true;
            registerScreenStateBroadcastReceiver();
            return;
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        attached = false;
        unregisterScreenStateBroadcastReceiver();
        controller.prepareToGoAway();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (!isInEditMode())
        {
            controller.setWindowDimensions(k - i, l - j);
            if (needsToLoadAdOnLayout.getAndSet(false))
            {
                loadAdFromAdController(listenerOnLayout);
                listenerOnLayout = null;
                return;
            }
        }
    }

    void onRequestError(String s)
    {
        Log.e("AdLayout", s);
        ((IAdLoaderCallback)controller).adFailed(new AdError(AdError.ErrorCode.REQUEST_ERROR, s));
    }

    protected void onWindowVisibilityChanged(int i)
    {
        if (attached && lastVisibility != i)
        {
            if (i != 0)
            {
                isInForeground = false;
                unregisterScreenStateBroadcastReceiver();
            } else
            if (i == 0)
            {
                isInForeground = true;
                return;
            }
        }
    }

    protected boolean passesInternetPermissionCheck(Context context1)
    {
        return PermissionChecker.getInstance().passesInternetPermissionCheck(context1);
    }

    int prepareAd(AdLoader.AdReadyToLoadListener adreadytoloadlistener)
    {
        loadAdStartTime = System.nanoTime();
        if (controller.isAdLoading() || needsToLoadAdOnLayout.get())
        {
            Log.e("AdLayout", "Can't load an ad because ad loading is already in progress");
            return -1;
        }
        if (controller.isAdExpanded())
        {
            Log.e("AdLayout", "Can't load an ad because another ad is currently expanded");
            return -1;
        }
        if (!hasPassedActivityValidationCheck)
        {
            onRequestError("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
            return 1;
        }
        if (!passesInternetPermissionCheck(context))
        {
            onRequestError("Ads cannot load because the INTERNET permission is missing from the app's manifest.");
            return 1;
        }
        if (InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey() == null)
        {
            onRequestError("Can't load an ad because Application Key has not been set. Did you forget to call AdRegistration.setAppKey( ... )?");
            return 1;
        }
        if (!isWebViewOk(context))
        {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_UNKNOWN_WEBVIEW_ISSUE);
            onRequestError("We will be unable to create a WebView for rendering an ad due to an unknown issue with the WebView.");
            return 1;
        }
        if (adSize.isAuto())
        {
            Log.d("AdLayout", "Ad size to be determined automatically.");
        }
        setIsParentViewMissingAtLoadTime();
        if (isLayoutRequested() && adSize.isAuto() && !isParentViewMissingAtLoadTime())
        {
            deferAdLoadToLayoutEvent(adreadytoloadlistener);
        } else
        if (isParentViewMissingAtLoadTime())
        {
            loadAdWhenParentViewMissing(adreadytoloadlistener);
        } else
        {
            loadAdFromAdController(adreadytoloadlistener);
        }
        return 0;
    }

    int resolveLayoutParamForFloatingAd(boolean flag)
    {
        int i;
        int j;
        if (flag)
        {
            i = getLayoutParams().width;
        } else
        {
            i = getLayoutParams().height;
        }
        if (i != -1) goto _L2; else goto _L1
_L1:
        if (!isActivityRootViewNull()) goto _L4; else goto _L3
_L3:
        j = getRawScreenDimension(flag);
_L6:
        return j;
_L4:
        return getActivityRootViewDimension(flag);
_L2:
        j = i;
        if (i == -2)
        {
            return 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    void scheduleTaskForCheckingIfLayoutHasRun()
    {
        Runnable runnable = new Runnable() {

            final AdLayout this$0;

            public void run()
            {
                failLoadIfLayoutHasNotRun();
            }

            
            {
                this$0 = AdLayout.this;
                super();
            }
        };
        threadPool.schedule(runnable, getTimeout(), TimeUnit.MILLISECONDS);
    }

    void setActivityRootView()
    {
        activityRootView = ((Activity)context).getWindow().getDecorView().findViewById(0x1020002).getRootView();
    }

    void setFloatingWindowDimensions()
    {
        int i = resolveLayoutParamForFloatingAd(true);
        int j = resolveLayoutParamForFloatingAd(false);
        controller.setWindowDimensions(i, j);
    }

    void setIsParentViewMissingAtLoadTime()
    {
        boolean flag;
        if (getParent() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isParentViewMissingAtLoadTime = flag;
    }

    void setIsParentViewMissingAtLoadTime(boolean flag)
    {
        isParentViewMissingAtLoadTime = flag;
    }

    public void setListener(AdListener adlistener)
    {
        controller.setListener(adlistener);
    }

    void setNeedsToLoadAdOnLayout(boolean flag)
    {
        needsToLoadAdOnLayout.set(flag);
    }

    void setOnLayoutChangeListenerForRoot(AdLoader.AdReadyToLoadListener adreadytoloadlistener)
    {
        OnLayoutChangeListenerUtil.setOnLayoutChangeListenerForRoot(this, adreadytoloadlistener);
    }

    void setShouldDisableWebViewHardwareAcceleration(boolean flag)
    {
        shouldDisableWebViewHardwareAcceleration = flag;
    }

    public void setTimeout(int i)
    {
        controller.setTimeout(i);
    }

    boolean shouldDisableWebViewHardwareAcceleration()
    {
        return shouldDisableWebViewHardwareAcceleration;
    }

    static 
    {
        threadPool = new ScheduledThreadPoolExecutor(1);
        threadPool.setKeepAliveTime(60L, TimeUnit.SECONDS);
    }




}
