// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.common.util.Views;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.util.WebViews;
import java.lang.ref.WeakReference;
import java.net.URI;

// Referenced classes of package com.mopub.mraid:
//            MraidBridge, PlacementType, ViewState, MraidOrientation, 
//            MraidScreenMetrics, MraidNativeCommandHandler, MraidCommandException, MraidWebViewDebugListener

public class MraidController
{
    public static interface MraidListener
    {

        public abstract void onClose();

        public abstract void onExpand();

        public abstract void onFailedToLoad();

        public abstract void onLoaded(View view);

        public abstract void onOpen();
    }

    class OrientationBroadcastReceiver extends BroadcastReceiver
    {

        private Context mContext;
        private int mLastRotation;
        final MraidController this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (mContext != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()))
            {
                int i = getDisplayRotation();
                if (i != mLastRotation)
                {
                    mLastRotation = i;
                    handleOrientationChange(mLastRotation);
                    return;
                }
            }
        }

        public void register(Context context)
        {
            Preconditions.checkNotNull(context);
            mContext = context.getApplicationContext();
            if (mContext != null)
            {
                mContext.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        public void unregister()
        {
            if (mContext != null)
            {
                mContext.unregisterReceiver(this);
                mContext = null;
            }
        }

        OrientationBroadcastReceiver()
        {
            this$0 = MraidController.this;
            super();
            mLastRotation = -1;
        }
    }

    static class ScreenMetricsWaiter
    {

        private final Handler mHandler = new Handler();
        private WaitRequest mLastWaitRequest;

        void cancelLastRequest()
        {
            if (mLastWaitRequest != null)
            {
                mLastWaitRequest.cancel();
                mLastWaitRequest = null;
            }
        }

        transient WaitRequest waitFor(View aview[])
        {
            mLastWaitRequest = new WaitRequest(mHandler, aview);
            return mLastWaitRequest;
        }

        ScreenMetricsWaiter()
        {
        }
    }

    static class ScreenMetricsWaiter.WaitRequest
    {

        private final Handler mHandler;
        private Runnable mSuccessRunnable;
        private final View mViews[];
        int mWaitCount;
        private final Runnable mWaitingRunnable;

        private void countDown()
        {
            mWaitCount = mWaitCount - 1;
            if (mWaitCount == 0 && mSuccessRunnable != null)
            {
                mSuccessRunnable.run();
                mSuccessRunnable = null;
            }
        }

        void cancel()
        {
            mHandler.removeCallbacks(mWaitingRunnable);
            mSuccessRunnable = null;
        }

        void start(Runnable runnable)
        {
            mSuccessRunnable = runnable;
            mWaitCount = mViews.length;
            mHandler.post(mWaitingRunnable);
        }



        private ScreenMetricsWaiter.WaitRequest(Handler handler, View aview[])
        {
            mWaitingRunnable = new _cls1();
            mHandler = handler;
            mViews = aview;
        }

    }

    public static interface UseCustomCloseListener
    {

        public abstract void useCustomCloseChanged(boolean flag);
    }


    private final AdReport mAdReport;
    private boolean mAllowOrientationChange;
    private final CloseableLayout mCloseableAdContainer;
    private final Context mContext;
    private MraidWebViewDebugListener mDebugListener;
    private final FrameLayout mDefaultAdContainer;
    private MraidOrientation mForceOrientation;
    private boolean mIsPaused;
    private final MraidBridge mMraidBridge;
    private final MraidBridge.MraidBridgeListener mMraidBridgeListener;
    private MraidListener mMraidListener;
    private final MraidNativeCommandHandler mMraidNativeCommandHandler;
    private MraidBridge.MraidWebView mMraidWebView;
    private UseCustomCloseListener mOnCloseButtonListener;
    private OrientationBroadcastReceiver mOrientationBroadcastReceiver;
    private Integer mOriginalActivityOrientation;
    private final PlacementType mPlacementType;
    private ViewGroup mRootView;
    private final MraidScreenMetrics mScreenMetrics;
    private final ScreenMetricsWaiter mScreenMetricsWaiter;
    private final MraidBridge mTwoPartBridge;
    private final MraidBridge.MraidBridgeListener mTwoPartBridgeListener;
    private MraidBridge.MraidWebView mTwoPartWebView;
    private ViewState mViewState;
    private final WeakReference mWeakActivity;

    public MraidController(Context context, AdReport adreport, PlacementType placementtype)
    {
        this(context, adreport, placementtype, new MraidBridge(adreport, placementtype), new MraidBridge(adreport, PlacementType.INTERSTITIAL), new ScreenMetricsWaiter());
    }

    MraidController(Context context, AdReport adreport, PlacementType placementtype, MraidBridge mraidbridge, MraidBridge mraidbridge1, ScreenMetricsWaiter screenmetricswaiter)
    {
        mViewState = ViewState.LOADING;
        mOrientationBroadcastReceiver = new OrientationBroadcastReceiver();
        mAllowOrientationChange = true;
        mForceOrientation = MraidOrientation.NONE;
        mMraidBridgeListener = new MraidBridge.MraidBridgeListener() {

            final MraidController this$0;

            public void onClose()
            {
                handleClose();
            }

            public boolean onConsoleMessage(ConsoleMessage consolemessage)
            {
                return handleConsoleMessage(consolemessage);
            }

            public void onExpand(URI uri, boolean flag)
                throws MraidCommandException
            {
                handleExpand(uri, flag);
            }

            public boolean onJsAlert(String s, JsResult jsresult)
            {
                return handleJsAlert(s, jsresult);
            }

            public void onOpen(URI uri)
            {
                handleOpen(uri.toString());
            }

            public void onPageFailedToLoad()
            {
                if (mMraidListener != null)
                {
                    mMraidListener.onFailedToLoad();
                }
            }

            public void onPageLoaded()
            {
                handlePageLoad();
            }

            public void onPlayVideo(URI uri)
            {
                handleShowVideo(uri.toString());
            }

            public void onResize(int i, int j, int k, int l, com.mopub.common.CloseableLayout.ClosePosition closeposition, boolean flag)
                throws MraidCommandException
            {
                handleResize(i, j, k, l, closeposition, flag);
            }

            public void onSetOrientationProperties(boolean flag, MraidOrientation mraidorientation)
                throws MraidCommandException
            {
                handleSetOrientationProperties(flag, mraidorientation);
            }

            public void onUseCustomClose(boolean flag)
            {
                handleCustomClose(flag);
            }

            public void onVisibilityChanged(boolean flag)
            {
                if (!mTwoPartBridge.isAttached())
                {
                    mMraidBridge.notifyViewability(flag);
                }
            }

            
            {
                this$0 = MraidController.this;
                super();
            }
        };
        mTwoPartBridgeListener = new MraidBridge.MraidBridgeListener() {

            final MraidController this$0;

            public void onClose()
            {
                handleClose();
            }

            public boolean onConsoleMessage(ConsoleMessage consolemessage)
            {
                return handleConsoleMessage(consolemessage);
            }

            public void onExpand(URI uri, boolean flag)
            {
            }

            public boolean onJsAlert(String s, JsResult jsresult)
            {
                return handleJsAlert(s, jsresult);
            }

            public void onOpen(URI uri)
            {
                handleOpen(uri.toString());
            }

            public void onPageFailedToLoad()
            {
            }

            public void onPageLoaded()
            {
                handleTwoPartPageLoad();
            }

            public void onPlayVideo(URI uri)
            {
                handleShowVideo(uri.toString());
            }

            public void onResize(int i, int j, int k, int l, com.mopub.common.CloseableLayout.ClosePosition closeposition, boolean flag)
                throws MraidCommandException
            {
                throw new MraidCommandException("Not allowed to resize from an expanded state");
            }

            public void onSetOrientationProperties(boolean flag, MraidOrientation mraidorientation)
                throws MraidCommandException
            {
                handleSetOrientationProperties(flag, mraidorientation);
            }

            public void onUseCustomClose(boolean flag)
            {
                handleCustomClose(flag);
            }

            public void onVisibilityChanged(boolean flag)
            {
                mMraidBridge.notifyViewability(flag);
                mTwoPartBridge.notifyViewability(flag);
            }

            
            {
                this$0 = MraidController.this;
                super();
            }
        };
        mContext = context.getApplicationContext();
        Preconditions.checkNotNull(mContext);
        mAdReport = adreport;
        if (context instanceof Activity)
        {
            mWeakActivity = new WeakReference((Activity)context);
        } else
        {
            mWeakActivity = new WeakReference(null);
        }
        mPlacementType = placementtype;
        mMraidBridge = mraidbridge;
        mTwoPartBridge = mraidbridge1;
        mScreenMetricsWaiter = screenmetricswaiter;
        mViewState = ViewState.LOADING;
        context = mContext.getResources().getDisplayMetrics();
        mScreenMetrics = new MraidScreenMetrics(mContext, ((DisplayMetrics) (context)).density);
        mDefaultAdContainer = new FrameLayout(mContext);
        mCloseableAdContainer = new CloseableLayout(mContext);
        mCloseableAdContainer.setOnCloseListener(new com.mopub.common.CloseableLayout.OnCloseListener() {

            final MraidController this$0;

            public void onClose()
            {
                handleClose();
            }

            
            {
                this$0 = MraidController.this;
                super();
            }
        });
        context = new View(mContext);
        context.setOnTouchListener(new android.view.View.OnTouchListener() {

            final MraidController this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = MraidController.this;
                super();
            }
        });
        mCloseableAdContainer.addView(context, new android.widget.FrameLayout.LayoutParams(-1, -1));
        mOrientationBroadcastReceiver.register(mContext);
        mMraidBridge.setMraidBridgeListener(mMraidBridgeListener);
        mTwoPartBridge.setMraidBridgeListener(mTwoPartBridgeListener);
        mMraidNativeCommandHandler = new MraidNativeCommandHandler();
    }

    private View getCurrentWebView()
    {
        if (mTwoPartBridge.isAttached())
        {
            return mTwoPartWebView;
        } else
        {
            return mMraidWebView;
        }
    }

    private int getDisplayRotation()
    {
        return ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    private ViewGroup getRootView()
    {
        if (mRootView == null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                Preconditions.checkState(mDefaultAdContainer.isAttachedToWindow());
            }
            mRootView = (ViewGroup)mDefaultAdContainer.getRootView().findViewById(0x1020002);
        }
        return mRootView;
    }

    private boolean isInlineVideoAvailable()
    {
        Activity activity = (Activity)mWeakActivity.get();
        if (activity == null || getCurrentWebView() == null)
        {
            return false;
        } else
        {
            return mMraidNativeCommandHandler.isInlineVideoAvailable(activity, getCurrentWebView());
        }
    }

    private void setViewState(ViewState viewstate)
    {
        setViewState(viewstate, null);
    }

    private void setViewState(ViewState viewstate, Runnable runnable)
    {
        MoPubLog.d((new StringBuilder()).append("MRAID state set to ").append(viewstate).toString());
        mViewState = viewstate;
        mMraidBridge.notifyViewState(viewstate);
        if (mTwoPartBridge.isLoaded())
        {
            mTwoPartBridge.notifyViewState(viewstate);
        }
        if (mMraidListener == null) goto _L2; else goto _L1
_L1:
        if (viewstate != ViewState.EXPANDED) goto _L4; else goto _L3
_L3:
        mMraidListener.onExpand();
_L2:
        updateScreenMetricsAsync(runnable);
        return;
_L4:
        if (viewstate == ViewState.HIDDEN)
        {
            mMraidListener.onClose();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void updateScreenMetricsAsync(final Runnable successRunnable)
    {
        mScreenMetricsWaiter.cancelLastRequest();
        final View currentWebView = getCurrentWebView();
        if (currentWebView == null)
        {
            return;
        } else
        {
            mScreenMetricsWaiter.waitFor(new View[] {
                mDefaultAdContainer, currentWebView
            }).start(new Runnable() {

                final MraidController this$0;
                final View val$currentWebView;
                final Runnable val$successRunnable;

                public void run()
                {
                    DisplayMetrics displaymetrics = mContext.getResources().getDisplayMetrics();
                    mScreenMetrics.setScreenSize(displaymetrics.widthPixels, displaymetrics.heightPixels);
                    int ai[] = new int[2];
                    ViewGroup viewgroup = getRootView();
                    viewgroup.getLocationOnScreen(ai);
                    mScreenMetrics.setRootViewPosition(ai[0], ai[1], viewgroup.getWidth(), viewgroup.getHeight());
                    mDefaultAdContainer.getLocationOnScreen(ai);
                    mScreenMetrics.setDefaultAdPosition(ai[0], ai[1], mDefaultAdContainer.getWidth(), mDefaultAdContainer.getHeight());
                    currentWebView.getLocationOnScreen(ai);
                    mScreenMetrics.setCurrentAdPosition(ai[0], ai[1], currentWebView.getWidth(), currentWebView.getHeight());
                    mMraidBridge.notifyScreenMetrics(mScreenMetrics);
                    if (mTwoPartBridge.isAttached())
                    {
                        mTwoPartBridge.notifyScreenMetrics(mScreenMetrics);
                    }
                    if (successRunnable != null)
                    {
                        successRunnable.run();
                    }
                }

            
            {
                this$0 = MraidController.this;
                currentWebView = view;
                successRunnable = runnable;
                super();
            }
            });
            return;
        }
    }

    void applyOrientation()
        throws MraidCommandException
    {
        if (mForceOrientation == MraidOrientation.NONE)
        {
            if (mAllowOrientationChange)
            {
                unApplyOrientation();
                return;
            }
            Activity activity = (Activity)mWeakActivity.get();
            if (activity == null)
            {
                throw new MraidCommandException("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            } else
            {
                lockOrientation(DeviceUtils.getScreenOrientation(activity));
                return;
            }
        } else
        {
            lockOrientation(mForceOrientation.getActivityInfoOrientation());
            return;
        }
    }

    int clampInt(int i, int j, int k)
    {
        return Math.max(i, Math.min(j, k));
    }

    public void destroy()
    {
        mScreenMetricsWaiter.cancelLastRequest();
        try
        {
            mOrientationBroadcastReceiver.unregister();
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            if (!illegalargumentexception.getMessage().contains("Receiver not registered"))
            {
                throw illegalargumentexception;
            }
        }
        if (!mIsPaused)
        {
            pause(true);
        }
        Views.removeFromParent(mCloseableAdContainer);
        mMraidBridge.detach();
        if (mMraidWebView != null)
        {
            mMraidWebView.destroy();
            mMraidWebView = null;
        }
        mTwoPartBridge.detach();
        if (mTwoPartWebView != null)
        {
            mTwoPartWebView.destroy();
            mTwoPartWebView = null;
        }
    }

    public FrameLayout getAdContainer()
    {
        return mDefaultAdContainer;
    }

    boolean getAllowOrientationChange()
    {
        return mAllowOrientationChange;
    }

    public Context getContext()
    {
        return mContext;
    }

    CloseableLayout getExpandedAdContainer()
    {
        return mCloseableAdContainer;
    }

    MraidOrientation getForceOrientation()
    {
        return mForceOrientation;
    }

    MraidBridge.MraidWebView getMraidWebView()
    {
        return mMraidWebView;
    }

    Integer getOriginalActivityOrientation()
    {
        return mOriginalActivityOrientation;
    }

    MraidBridge.MraidWebView getTwoPartWebView()
    {
        return mTwoPartWebView;
    }

    ViewState getViewState()
    {
        return mViewState;
    }

    void handleClose()
    {
        if (mMraidWebView != null && mViewState != ViewState.LOADING && mViewState != ViewState.HIDDEN)
        {
            if (mViewState == ViewState.EXPANDED || mPlacementType == PlacementType.INTERSTITIAL)
            {
                unApplyOrientation();
            }
            if (mViewState == ViewState.RESIZED || mViewState == ViewState.EXPANDED)
            {
                if (mTwoPartBridge.isAttached() && mTwoPartWebView != null)
                {
                    mCloseableAdContainer.removeView(mTwoPartWebView);
                    mTwoPartBridge.detach();
                } else
                {
                    mCloseableAdContainer.removeView(mMraidWebView);
                    mDefaultAdContainer.addView(mMraidWebView, new android.widget.FrameLayout.LayoutParams(-1, -1));
                    mDefaultAdContainer.setVisibility(0);
                }
                getRootView().removeView(mCloseableAdContainer);
                setViewState(ViewState.DEFAULT);
                return;
            }
            if (mViewState == ViewState.DEFAULT)
            {
                mDefaultAdContainer.setVisibility(4);
                setViewState(ViewState.HIDDEN);
                return;
            }
        }
    }

    boolean handleConsoleMessage(ConsoleMessage consolemessage)
    {
        if (mDebugListener != null)
        {
            return mDebugListener.onConsoleMessage(consolemessage);
        } else
        {
            return true;
        }
    }

    void handleCustomClose(boolean flag)
    {
        boolean flag3 = true;
        boolean flag1;
        if (!mCloseableAdContainer.isCloseVisible())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag != flag1)
        {
            CloseableLayout closeablelayout = mCloseableAdContainer;
            boolean flag2;
            if (!flag)
            {
                flag2 = flag3;
            } else
            {
                flag2 = false;
            }
            closeablelayout.setCloseVisible(flag2);
            if (mOnCloseButtonListener != null)
            {
                mOnCloseButtonListener.useCustomCloseChanged(flag);
                return;
            }
        }
    }

    void handleExpand(URI uri, boolean flag)
        throws MraidCommandException
    {
        boolean flag1;
        if (mMraidWebView == null)
        {
            throw new MraidCommandException("Unable to expand after the WebView is destroyed");
        }
        while (mPlacementType == PlacementType.INTERSTITIAL || mViewState != ViewState.DEFAULT && mViewState != ViewState.RESIZED) 
        {
            return;
        }
        applyOrientation();
        if (uri != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            mTwoPartWebView = new MraidBridge.MraidWebView(mContext);
            mTwoPartBridge.attachView(mTwoPartWebView);
            mTwoPartBridge.setContentUrl(uri.toString());
        }
        uri = new android.widget.FrameLayout.LayoutParams(-1, -1);
        if (mViewState != ViewState.DEFAULT) goto _L2; else goto _L1
_L1:
        if (flag1)
        {
            mCloseableAdContainer.addView(mTwoPartWebView, uri);
        } else
        {
            mDefaultAdContainer.removeView(mMraidWebView);
            mDefaultAdContainer.setVisibility(4);
            mCloseableAdContainer.addView(mMraidWebView, uri);
        }
        getRootView().addView(mCloseableAdContainer, new android.widget.FrameLayout.LayoutParams(-1, -1));
_L4:
        mCloseableAdContainer.setLayoutParams(uri);
        handleCustomClose(flag);
        setViewState(ViewState.EXPANDED);
        return;
_L2:
        if (mViewState == ViewState.RESIZED && flag1)
        {
            mCloseableAdContainer.removeView(mMraidWebView);
            mDefaultAdContainer.addView(mMraidWebView, uri);
            mDefaultAdContainer.setVisibility(4);
            mCloseableAdContainer.addView(mTwoPartWebView, uri);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean handleJsAlert(String s, JsResult jsresult)
    {
        if (mDebugListener != null)
        {
            return mDebugListener.onJsAlert(s, jsresult);
        } else
        {
            jsresult.confirm();
            return true;
        }
    }

    void handleOpen(String s)
    {
        if (mMraidListener != null)
        {
            mMraidListener.onOpen();
        }
        (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[] {
            UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
        }).build().handleUrl(mContext, s);
    }

    void handleOrientationChange(int i)
    {
        updateScreenMetricsAsync(null);
    }

    void handlePageLoad()
    {
        setViewState(ViewState.DEFAULT, new Runnable() {

            final MraidController this$0;

            public void run()
            {
                mMraidBridge.notifySupports(mMraidNativeCommandHandler.isSmsAvailable(mContext), mMraidNativeCommandHandler.isTelAvailable(mContext), MraidNativeCommandHandler.isCalendarAvailable(mContext), MraidNativeCommandHandler.isStorePictureSupported(mContext), isInlineVideoAvailable());
                mMraidBridge.notifyPlacementType(mPlacementType);
                mMraidBridge.notifyViewability(mMraidBridge.isVisible());
                mMraidBridge.notifyReady();
            }

            
            {
                this$0 = MraidController.this;
                super();
            }
        });
        if (mMraidListener != null)
        {
            mMraidListener.onLoaded(mDefaultAdContainer);
        }
    }

    void handleResize(int i, int j, int k, int l, com.mopub.common.CloseableLayout.ClosePosition closeposition, boolean flag)
        throws MraidCommandException
    {
        Object obj;
        if (mMraidWebView == null)
        {
            throw new MraidCommandException("Unable to resize after the WebView is destroyed");
        }
        if (mViewState == ViewState.LOADING || mViewState == ViewState.HIDDEN)
        {
            return;
        }
        if (mViewState == ViewState.EXPANDED)
        {
            throw new MraidCommandException("Not allowed to resize from an already expanded ad");
        }
        if (mPlacementType == PlacementType.INTERSTITIAL)
        {
            throw new MraidCommandException("Not allowed to resize from an interstitial ad");
        }
        int i1 = Dips.dipsToIntPixels(i, mContext);
        int j1 = Dips.dipsToIntPixels(j, mContext);
        int l1 = Dips.dipsToIntPixels(k, mContext);
        int k1 = Dips.dipsToIntPixels(l, mContext);
        l1 = mScreenMetrics.getDefaultAdRect().left + l1;
        k1 = mScreenMetrics.getDefaultAdRect().top + k1;
        Rect rect = new Rect(l1, k1, l1 + i1, k1 + j1);
        if (!flag)
        {
            Rect rect1 = mScreenMetrics.getRootViewRect();
            if (rect.width() > rect1.width() || rect.height() > rect1.height())
            {
                throw new MraidCommandException((new StringBuilder()).append("resizeProperties specified a size (").append(i).append(", ").append(j).append(") and offset (").append(k).append(", ").append(l).append(") that doesn't allow the ad to").append(" appear within the max allowed size (").append(mScreenMetrics.getRootViewRectDips().width()).append(", ").append(mScreenMetrics.getRootViewRectDips().height()).append(")").toString());
            }
            rect.offsetTo(clampInt(rect1.left, rect.left, rect1.right - rect.width()), clampInt(rect1.top, rect.top, rect1.bottom - rect.height()));
        }
        obj = new Rect();
        mCloseableAdContainer.applyCloseRegionBounds(closeposition, rect, ((Rect) (obj)));
        if (!mScreenMetrics.getRootViewRect().contains(((Rect) (obj))))
        {
            throw new MraidCommandException((new StringBuilder()).append("resizeProperties specified a size (").append(i).append(", ").append(j).append(") and offset (").append(k).append(", ").append(l).append(") that doesn't allow the close").append(" region to appear within the max allowed size (").append(mScreenMetrics.getRootViewRectDips().width()).append(", ").append(mScreenMetrics.getRootViewRectDips().height()).append(")").toString());
        }
        if (!rect.contains(((Rect) (obj))))
        {
            throw new MraidCommandException((new StringBuilder()).append("resizeProperties specified a size (").append(i).append(", ").append(j1).append(") and offset (").append(k).append(", ").append(l).append(") that don't allow the close region to appear ").append("within the resized ad.").toString());
        }
        mCloseableAdContainer.setCloseVisible(false);
        mCloseableAdContainer.setClosePosition(closeposition);
        obj = new android.widget.FrameLayout.LayoutParams(rect.width(), rect.height());
        obj.leftMargin = rect.left - mScreenMetrics.getRootViewRect().left;
        obj.topMargin = rect.top - mScreenMetrics.getRootViewRect().top;
        if (mViewState != ViewState.DEFAULT) goto _L2; else goto _L1
_L1:
        mDefaultAdContainer.removeView(mMraidWebView);
        mDefaultAdContainer.setVisibility(4);
        mCloseableAdContainer.addView(mMraidWebView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        getRootView().addView(mCloseableAdContainer, ((android.view.ViewGroup.LayoutParams) (obj)));
_L4:
        mCloseableAdContainer.setClosePosition(closeposition);
        setViewState(ViewState.RESIZED);
        return;
_L2:
        if (mViewState == ViewState.RESIZED)
        {
            mCloseableAdContainer.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void handleSetOrientationProperties(boolean flag, MraidOrientation mraidorientation)
        throws MraidCommandException
    {
        if (!shouldAllowForceOrientation(mraidorientation))
        {
            throw new MraidCommandException((new StringBuilder()).append("Unable to force orientation to ").append(mraidorientation).toString());
        }
        mAllowOrientationChange = flag;
        mForceOrientation = mraidorientation;
        if (mViewState == ViewState.EXPANDED || mPlacementType == PlacementType.INTERSTITIAL)
        {
            applyOrientation();
        }
    }

    void handleShowVideo(String s)
    {
        MraidVideoPlayerActivity.startMraid(mContext, s);
    }

    void handleTwoPartPageLoad()
    {
        updateScreenMetricsAsync(new Runnable() {

            final MraidController this$0;

            public void run()
            {
                MraidBridge mraidbridge = mTwoPartBridge;
                boolean flag = mMraidNativeCommandHandler.isSmsAvailable(mContext);
                boolean flag1 = mMraidNativeCommandHandler.isTelAvailable(mContext);
                MraidNativeCommandHandler _tmp = mMraidNativeCommandHandler;
                boolean flag2 = MraidNativeCommandHandler.isCalendarAvailable(mContext);
                MraidNativeCommandHandler _tmp1 = mMraidNativeCommandHandler;
                mraidbridge.notifySupports(flag, flag1, flag2, MraidNativeCommandHandler.isStorePictureSupported(mContext), isInlineVideoAvailable());
                mTwoPartBridge.notifyViewState(mViewState);
                mTwoPartBridge.notifyPlacementType(mPlacementType);
                mTwoPartBridge.notifyViewability(mTwoPartBridge.isVisible());
                mTwoPartBridge.notifyReady();
            }

            
            {
                this$0 = MraidController.this;
                super();
            }
        });
    }

    public void loadContent(String s)
    {
        boolean flag;
        if (mMraidWebView == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "loadContent should only be called once");
        mMraidWebView = new MraidBridge.MraidWebView(mContext);
        mMraidBridge.attachView(mMraidWebView);
        mDefaultAdContainer.addView(mMraidWebView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        mMraidBridge.setContentHtml(s);
    }

    public void loadJavascript(String s)
    {
        mMraidBridge.injectJavaScript(s);
    }

    void lockOrientation(int i)
        throws MraidCommandException
    {
        Activity activity = (Activity)mWeakActivity.get();
        if (activity == null || !shouldAllowForceOrientation(mForceOrientation))
        {
            throw new MraidCommandException((new StringBuilder()).append("Attempted to lock orientation to unsupported value: ").append(mForceOrientation.name()).toString());
        }
        if (mOriginalActivityOrientation == null)
        {
            mOriginalActivityOrientation = Integer.valueOf(activity.getRequestedOrientation());
        }
        activity.setRequestedOrientation(i);
    }

    public void pause(boolean flag)
    {
        mIsPaused = true;
        if (mMraidWebView != null)
        {
            WebViews.onPause(mMraidWebView, flag);
        }
        if (mTwoPartWebView != null)
        {
            WebViews.onPause(mTwoPartWebView, flag);
        }
    }

    public void resume()
    {
        mIsPaused = false;
        if (mMraidWebView != null)
        {
            WebViews.onResume(mMraidWebView);
        }
        if (mTwoPartWebView != null)
        {
            WebViews.onResume(mTwoPartWebView);
        }
    }

    public void setDebugListener(MraidWebViewDebugListener mraidwebviewdebuglistener)
    {
        mDebugListener = mraidwebviewdebuglistener;
    }

    public void setMraidListener(MraidListener mraidlistener)
    {
        mMraidListener = mraidlistener;
    }

    void setOrientationBroadcastReceiver(OrientationBroadcastReceiver orientationbroadcastreceiver)
    {
        mOrientationBroadcastReceiver = orientationbroadcastreceiver;
    }

    void setRootView(FrameLayout framelayout)
    {
        mRootView = framelayout;
    }

    void setRootViewSize(int i, int j)
    {
        mScreenMetrics.setRootViewPosition(0, 0, i, j);
    }

    public void setUseCustomCloseListener(UseCustomCloseListener usecustomcloselistener)
    {
        mOnCloseButtonListener = usecustomcloselistener;
    }

    void setViewStateForTesting(ViewState viewstate)
    {
        mViewState = viewstate;
    }

    boolean shouldAllowForceOrientation(MraidOrientation mraidorientation)
    {
        if (mraidorientation != MraidOrientation.NONE)
        {
            Object obj = (Activity)mWeakActivity.get();
            if (obj == null)
            {
                return false;
            }
            int i;
            try
            {
                obj = ((Activity) (obj)).getPackageManager().getActivityInfo(new ComponentName(((Context) (obj)), obj.getClass()), 0);
            }
            // Misplaced declaration of an exception variable
            catch (MraidOrientation mraidorientation)
            {
                return false;
            }
            i = ((ActivityInfo) (obj)).screenOrientation;
            if (i != -1)
            {
                if (i != mraidorientation.getActivityInfoOrientation())
                {
                    return false;
                }
            } else
            {
                boolean flag1 = Utils.bitMaskContainsFlag(((ActivityInfo) (obj)).configChanges, 128);
                boolean flag = flag1;
                if (android.os.Build.VERSION.SDK_INT >= 13)
                {
                    if (flag1 && Utils.bitMaskContainsFlag(((ActivityInfo) (obj)).configChanges, 1024))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
                return flag;
            }
        }
        return true;
    }

    void unApplyOrientation()
    {
        Activity activity = (Activity)mWeakActivity.get();
        if (activity != null && mOriginalActivityOrientation != null)
        {
            activity.setRequestedOrientation(mOriginalActivityOrientation.intValue());
        }
        mOriginalActivityOrientation = null;
    }













    // Unreferenced inner class com/mopub/mraid/MraidController$ScreenMetricsWaiter$WaitRequest$1

/* anonymous class */
    class ScreenMetricsWaiter.WaitRequest._cls1
        implements Runnable
    {

        final ScreenMetricsWaiter.WaitRequest this$0;

        public void run()
        {
            View aview[] = mViews;
            int j = aview.length;
            int i = 0;
            while (i < j) 
            {
                View view = aview[i];
                if (view.getHeight() > 0 || view.getWidth() > 0)
                {
                    countDown();
                } else
                {
                    view.getViewTreeObserver().addOnPreDrawListener(view. new android.view.ViewTreeObserver.OnPreDrawListener() {

                        final ScreenMetricsWaiter.WaitRequest._cls1 this$1;
                        final View val$view;

                        public boolean onPreDraw()
                        {
                            view.getViewTreeObserver().removeOnPreDrawListener(this);
    class ScreenMetricsWaiter.WaitRequest._cls1
        implements Runnable
    {
                            countDown();
                            return true;
                        }

            
            {
                this$1 = final__pcls1;
                view = View.this;
                super();
            }
                    });
                }
                i++;
            }
        }

            
            {
                this$0 = ScreenMetricsWaiter.WaitRequest.this;
                super();
            }
    }

}
