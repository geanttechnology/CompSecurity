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
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;

// Referenced classes of package com.amazon.device.ads:
//            MraidAbstractController, MraidView, AndroidTargetUtils, Log, 
//            MraidScreenSizeProperty, Utils, AdVideoPlayer, MraidStateProperty, 
//            MraidRenderer, WebViewFactory, MraidViewableProperty, IAdController, 
//            AdActivity, VideoActionHandler, Assets

class MraidDisplayController extends MraidAbstractController
{

    private static final int CLOSE_BUTTON_SIZE_DP = 50;
    private static final String LOGTAG = "MraidDisplayController";
    protected int adContainerLayoutId_;
    private boolean mAdWantsCustomCloseButton;
    private ImageView mCloseButton;
    private Context mContext;
    protected float mDensity;
    private final MraidView.ExpansionStyle mExpansionStyle;
    private boolean mIsViewable;
    private final MraidView.NativeCloseButtonStyle mNativeCloseButtonStyle;
    private BroadcastReceiver mOrientationBroadcastReceiver;
    private final int mOriginalRequestedOrientation;
    FrameLayout mPlaceholderView;
    private boolean mRegistered;
    private FrameLayout mRootView;
    protected int mScreenHeight;
    protected int mScreenWidth;
    private MraidView mTwoPartExpansionView;
    private int mViewHeight;
    private int mViewIndexInParent;
    private MraidView.ViewState mViewState;
    private int mViewWidth;
    private int modalContainerLayoutId_;
    private double scalingMultiplier_;
    private AdVideoPlayer vidPlayer_;
    private boolean vidPlaying_;
    private int videoContainerId_;
    private int viewCounterIncrement_;
    private int viewCounter_;
    private int windowHeight_;
    private int windowWidth_;

    MraidDisplayController(MraidView mraidview, MraidView.ExpansionStyle expansionstyle, MraidView.NativeCloseButtonStyle nativeclosebuttonstyle)
    {
        int i = -1;
        super(mraidview);
        mViewState = MraidView.ViewState.HIDDEN;
        vidPlaying_ = false;
        mOrientationBroadcastReceiver = new BroadcastReceiver() {

            private int mLastRotation;
            final MraidDisplayController this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
                    {
                        int j = getDisplayRotation();
                        if (j != mLastRotation)
                        {
                            mLastRotation = j;
                            onOrientationChanged(mLastRotation);
                        }
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.d("MraidDisplayController", "Orientation broadcast receiver got exception while executing: %s", new Object[] {
                        context.getLocalizedMessage()
                    });
                }
            }

            
            {
                this$0 = MraidDisplayController.this;
                super();
            }
        };
        mScreenWidth = -1;
        mScreenHeight = -1;
        mRegistered = false;
        modalContainerLayoutId_ = 0;
        adContainerLayoutId_ = 0;
        videoContainerId_ = 0;
        viewCounter_ = 0x436dae49;
        viewCounterIncrement_ = 50;
        mExpansionStyle = expansionstyle;
        mNativeCloseButtonStyle = nativeclosebuttonstyle;
        windowHeight_ = mraidview.getWindowHeight();
        windowWidth_ = mraidview.getWindowWidth();
        scalingMultiplier_ = mraidview.getScalingMultiplier();
        mContext = getView().getContext();
        if (mContext instanceof Activity)
        {
            i = ((Activity)mContext).getRequestedOrientation();
        }
        mOriginalRequestedOrientation = i;
        initialize();
    }

    private void establishViewIds()
        throws IllegalArgumentException
    {
        if (modalContainerLayoutId_ != 0)
        {
            return;
        } else
        {
            modalContainerLayoutId_ = getUniqueViewId();
            adContainerLayoutId_ = getUniqueViewId();
            videoContainerId_ = getUniqueViewId();
            return;
        }
    }

    private int getDisplayRotation()
    {
        return AndroidTargetUtils.getOrientation(((WindowManager)getView().getContext().getSystemService("window")).getDefaultDisplay());
    }

    private int getUniqueViewId()
        throws IllegalArgumentException
    {
        if (mRootView == null)
        {
            Log.w("MraidDisplayController", "Could not find root view. View ID may not be unique.");
            int i = viewCounter_;
            viewCounter_ = i + 1;
            return i;
        }
        viewCounter_ = viewCounter_ + 1;
        boolean flag = false;
        int j = 0;
        while (j < 100 && !flag) 
        {
            if (mRootView.findViewById(viewCounter_) == null)
            {
                flag = true;
            } else
            {
                viewCounter_ = viewCounter_ + viewCounterIncrement_;
            }
            j++;
        }
        if (!flag)
        {
            throw new IllegalArgumentException();
        } else
        {
            return viewCounter_;
        }
    }

    private void onOrientationChanged(int i)
    {
        initializeScreenMetrics();
        if (mRegistered)
        {
            getView().fireChangeEventForProperty(MraidScreenSizeProperty.createWithSize(mScreenWidth, mScreenHeight));
        }
    }

    private void resetViewToDefaultState()
    {
        Object obj = (FrameLayout)findViewByIdInRootView(adContainerLayoutId_);
        RelativeLayout relativelayout = (RelativeLayout)findViewByIdInRootView(modalContainerLayoutId_);
        setNativeCloseButtonEnabled(false);
        ((FrameLayout) (obj)).removeAllViewsInLayout();
        mRootView.removeView(relativelayout);
        getView().requestLayout();
        obj = (ViewGroup)mPlaceholderView.getParent();
        ((ViewGroup) (obj)).addView(getView(), mViewIndexInParent, new android.view.ViewGroup.LayoutParams(mViewWidth, mViewHeight));
        ((ViewGroup) (obj)).removeView(mPlaceholderView);
        ((ViewGroup) (obj)).invalidate();
    }

    private void setOrientationLockEnabled(boolean flag)
    {
        Object obj = getView().getContext();
        int i;
        try
        {
            obj = (Activity)obj;
        }
        catch (Exception exception)
        {
            Log.d("MraidDisplayController", "Unable to modify device orientation.");
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        i = Utils.determineCanonicalScreenOrientation();
_L2:
        ((Activity) (obj)).setRequestedOrientation(i);
        return;
        i = mOriginalRequestedOrientation;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void swapViewWithPlaceholderView()
    {
        ViewGroup viewgroup = getParentOfView();
        if (viewgroup == null)
        {
            return;
        }
        mPlaceholderView = new FrameLayout(getView().getContext());
        int j = viewgroup.getChildCount();
        int i = 0;
        do
        {
            if (i >= j || viewgroup.getChildAt(i) == getView())
            {
                mViewIndexInParent = i;
                mViewHeight = getViewHeight();
                mViewWidth = getViewWidth();
                viewgroup.addView(mPlaceholderView, i, new android.view.ViewGroup.LayoutParams(getView().getWidth(), getView().getHeight()));
                viewgroup.removeView(getView());
                return;
            }
            i++;
        } while (true);
    }

    protected void addViewToRootView(ViewGroup viewgroup, android.view.ViewGroup.LayoutParams layoutparams)
    {
        mRootView.addView(viewgroup, layoutparams);
    }

    protected boolean checkViewable()
    {
        return true;
    }

    protected void close()
    {
        if (vidPlaying_)
        {
            vidPlayer_.releasePlayer();
            vidPlaying_ = false;
        }
        removeKeyListenerFromWebView();
        if (mViewState != MraidView.ViewState.EXPANDED) goto _L2; else goto _L1
_L1:
        resetViewToDefaultState();
        setOrientationLockEnabled(false);
        mViewState = MraidView.ViewState.DEFAULT;
        getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
_L4:
        if (getView().getOnCloseListener() != null)
        {
            getView().getOnCloseListener().onClose(getView(), mViewState);
        }
        return;
_L2:
        if (mViewState == MraidView.ViewState.DEFAULT)
        {
            getView().setVisibility(4);
            mViewState = MraidView.ViewState.HIDDEN;
            getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected ViewGroup createExpansionViewContainer(View view, int i, int j)
    {
        int k = (int)(50F * mDensity + 0.5F);
        int l = i;
        if (i < k)
        {
            l = k;
        }
        i = j;
        if (j < k)
        {
            i = k;
        }
        RelativeLayout relativelayout = new RelativeLayout(getView().getContext());
        relativelayout.setId(modalContainerLayoutId_);
        Object obj = new View(getView().getContext());
        ((View) (obj)).setBackgroundColor(0);
        ((View) (obj)).setOnTouchListener(new android.view.View.OnTouchListener() {

            final MraidDisplayController this$0;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = MraidDisplayController.this;
                super();
            }
        });
        relativelayout.addView(((View) (obj)), new android.widget.RelativeLayout.LayoutParams(-1, -1));
        obj = new FrameLayout(getView().getContext());
        ((FrameLayout) (obj)).setId(adContainerLayoutId_);
        ((FrameLayout) (obj)).addView(view, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        view = new android.widget.RelativeLayout.LayoutParams(l, i);
        view.addRule(13);
        relativelayout.addView(((View) (obj)), view);
        return relativelayout;
    }

    public void destroy()
    {
        try
        {
            getView().getContext().unregisterReceiver(mOrientationBroadcastReceiver);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            if (!illegalargumentexception.getMessage().contains("Receiver not registered"))
            {
                throw illegalargumentexception;
            }
        }
        if (mTwoPartExpansionView != null)
        {
            mTwoPartExpansionView.destroy();
            mTwoPartExpansionView = null;
        }
    }

    protected void detachExpandedView()
    {
        if (mViewState == MraidView.ViewState.EXPANDED)
        {
            Log.d("MraidDisplayController", "Ad is currently expanded. Detaching the expanded view and returning ad to its default state.");
            Object obj = (RelativeLayout)mRootView.findViewById(modalContainerLayoutId_);
            if (obj != null)
            {
                if (((RelativeLayout) (obj)).isShown())
                {
                    mRootView.removeView(((View) (obj)));
                } else
                {
                    ((RelativeLayout) (obj)).removeAllViews();
                }
            }
            obj = (ViewGroup)mPlaceholderView.getParent();
            if (obj != null)
            {
                ((ViewGroup) (obj)).removeView(mPlaceholderView);
                setOrientationLockEnabled(false);
                mViewState = MraidView.ViewState.DEFAULT;
                getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
            }
        }
    }

    protected void expand(String s, int i, int j, boolean flag, boolean flag1)
    {
        if (mExpansionStyle != MraidView.ExpansionStyle.DISABLED && mViewState != MraidView.ViewState.EXPANDED)
        {
            if (isAdLoading())
            {
                Log.e("MraidDisplayController", "Expansion failed because ad loading is currently in progress.");
                return;
            }
            if (s != null && !URLUtil.isValidUrl(s))
            {
                getView().fireErrorEvent("expand", "URL passed to expand() was invalid.");
                return;
            }
            if (!obtainRootView())
            {
                getView().fireErrorEvent("expand", "Root view could not be found.");
                Log.e("MraidDisplayController", "Expansion failed because root view could not be found.");
                return;
            }
            Object obj;
            Object obj1;
            try
            {
                establishViewIds();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                getView().fireErrorEvent("expand", "Could not find available view ID.");
                Log.e("MraidDisplayController", "Expansion failed because available view ID could not be found.");
                return;
            }
            useCustomClose(flag);
            setOrientationLockEnabled(flag1);
            swapViewWithPlaceholderView();
            obj1 = getView();
            ((MraidView) (obj1)).setWebViewLayoutParams(-1, -1);
            obj = obj1;
            if (s != null)
            {
                obj = (MraidRenderer)((MraidView) (obj1)).getAdView();
                obj1 = WebViewFactory.getInstance().createWebView(((MraidRenderer) (obj)).context);
                mTwoPartExpansionView = new MraidView(((AdView) (obj)), windowWidth_, windowHeight_, scalingMultiplier_, ((MraidRenderer) (obj)).context, ((WebView) (obj1)), MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.AD_CONTROLLED, MraidView.PlacementType.INLINE);
                mTwoPartExpansionView.setOnCloseListener(new MraidView.OnCloseListener() {

                    final MraidDisplayController this$0;

                    public void onClose(MraidView mraidview, MraidView.ViewState viewstate)
                    {
                        close();
                    }

            
            {
                this$0 = MraidDisplayController.this;
                super();
            }
                });
                mTwoPartExpansionView.loadUrlForTwoPartExpansionView(s);
                obj = mTwoPartExpansionView;
            }
            addViewToRootView(createExpansionViewContainer(((View) (obj)), (int)((float)i * mDensity), (int)((float)j * mDensity)), new android.widget.RelativeLayout.LayoutParams(-1, -1));
            setKeyListenerToClose(((MraidView) (obj)));
            if (mNativeCloseButtonStyle == MraidView.NativeCloseButtonStyle.ALWAYS_VISIBLE || !mAdWantsCustomCloseButton && mNativeCloseButtonStyle != MraidView.NativeCloseButtonStyle.ALWAYS_HIDDEN)
            {
                setNativeCloseButtonEnabled(true);
            }
            mViewState = MraidView.ViewState.EXPANDED;
            getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
            if (getView().getOnExpandListener() != null)
            {
                getView().getOnExpandListener().onExpand(getView());
                return;
            }
        }
    }

    protected View findViewByIdInRootView(int i)
    {
        return mRootView.findViewById(i);
    }

    protected ViewGroup getParentOfView()
    {
        return (ViewGroup)getView().getParent();
    }

    protected int getViewHeight()
    {
        return getView().getHeight();
    }

    protected int getViewWidth()
    {
        return getView().getWidth();
    }

    protected void initialize()
    {
        mViewState = MraidView.ViewState.LOADING;
        initializeScreenMetrics();
        registerReceivers();
    }

    protected void initializeJavaScriptState()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(MraidScreenSizeProperty.createWithSize(mScreenWidth, mScreenHeight));
        arraylist.add(MraidViewableProperty.createWithViewable(mIsViewable));
        getView().fireChangeEventForProperties(arraylist);
        mViewState = MraidView.ViewState.DEFAULT;
        getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
    }

    protected void initializeScreenMetrics()
    {
        Object obj = getView().getContext();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)((Context) (obj)).getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        mDensity = displaymetrics.density;
        int i = 0;
        int j = 0;
        if (obj instanceof Activity)
        {
            obj = ((Activity)obj).getWindow();
            Rect rect = new Rect();
            ((Window) (obj)).getDecorView().getWindowVisibleDisplayFrame(rect);
            i = rect.top;
            j = ((Window) (obj)).findViewById(0x1020002).getTop() - i;
        }
        int k = displaymetrics.widthPixels;
        int l = displaymetrics.heightPixels;
        mScreenWidth = (int)((double)k * (160D / (double)displaymetrics.densityDpi));
        mScreenHeight = (int)((double)(l - i - j) * (160D / (double)displaymetrics.densityDpi));
    }

    protected boolean isAdLoading()
    {
        return ((MraidRenderer)getView().getAdView()).controller.isAdLoading();
    }

    protected boolean isExpanded()
    {
        return mViewState == MraidView.ViewState.EXPANDED;
    }

    protected boolean obtainRootView()
    {
        mRootView = (FrameLayout)getView().getRootView().findViewById(0x1020002);
        return mRootView != null;
    }

    protected void playVideo(String s, Controller.Dimensions dimensions, Controller.PlayerProperties playerproperties)
    {
        Log.d("MraidDisplayController", "in playVideo");
        if (vidPlaying_)
        {
            return;
        }
        if (playerproperties.isFullScreen())
        {
            Bundle bundle = new Bundle();
            bundle.putString("url", s);
            bundle.putParcelable("player_dimensions", dimensions);
            bundle.putParcelable("player_properties", playerproperties);
            try
            {
                s = new Intent(getView().getContext(), com/amazon/device/ads/AdActivity);
                s.putExtra("adapter", com/amazon/device/ads/VideoActionHandler.getName());
                s.putExtras(bundle);
                getView().getContext().startActivity(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("MraidDisplayController", "Failed to open VideoAction activity");
            }
            return;
        }
        if (vidPlayer_ == null)
        {
            vidPlayer_ = new AdVideoPlayer(mContext);
        }
        vidPlayer_.setPlayData(new Controller.PlayerProperties(), s);
        vidPlayer_.setListener(new AdVideoPlayer.AdVideoPlayerListener() {

            final MraidDisplayController this$0;

            public void onComplete()
            {
                Log.d("MraidDisplayController", "videoplayback complete");
                vidPlaying_ = false;
                FrameLayout framelayout = (FrameLayout)mRootView.findViewById(videoContainerId_);
                framelayout.setVisibility(4);
                mRootView.removeView(framelayout);
            }

            public void onError()
            {
                onComplete();
            }

            
            {
                this$0 = MraidDisplayController.this;
                super();
            }
        });
        s = new android.widget.FrameLayout.LayoutParams(dimensions.width, dimensions.height);
        s.topMargin = dimensions.x;
        s.bottomMargin = dimensions.y;
        vidPlayer_.setLayoutParams(s);
        s = new FrameLayout(getView().getContext());
        s.setId(videoContainerId_);
        s.setPadding(dimensions.x, dimensions.y, 0, 0);
        vidPlayer_.setViewGroup(s);
        mRootView.addView(s, -1, -1);
        vidPlaying_ = true;
        vidPlayer_.playVideo();
    }

    protected void registerReceivers()
    {
        if (!mRegistered)
        {
            mRegistered = true;
            getView().getContext().registerReceiver(mOrientationBroadcastReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    protected void removeKeyListenerFromWebView()
    {
        getView().getWebView().setOnKeyListener(null);
    }

    protected void setKeyListenerToClose(MraidView mraidview)
    {
        mraidview.getWebView().requestFocus();
        mraidview.getWebView().setOnKeyListener(new android.view.View.OnKeyListener() {

            final MraidDisplayController this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if (i == 4 && keyevent.getRepeatCount() == 0)
                {
                    close();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = MraidDisplayController.this;
                super();
            }
        });
    }

    protected void setNativeCloseButtonEnabled(boolean flag)
    {
        if (mRootView != null)
        {
            Object obj = (FrameLayout)mRootView.findViewById(adContainerLayoutId_);
            if (flag)
            {
                if (mCloseButton == null)
                {
                    StateListDrawable statelistdrawable = new StateListDrawable();
                    android.graphics.drawable.BitmapDrawable bitmapdrawable = AndroidTargetUtils.getNewBitmapDrawable(mContext.getResources(), Assets.getInstance().getFilePath("amazon_ads_close_button_normal.png"));
                    statelistdrawable.addState(new int[] {
                        0xfefeff59
                    }, bitmapdrawable);
                    bitmapdrawable = AndroidTargetUtils.getNewBitmapDrawable(mContext.getResources(), Assets.getInstance().getFilePath("amazon_ads_close_button_pressed.png"));
                    statelistdrawable.addState(new int[] {
                        0x10100a7
                    }, bitmapdrawable);
                    mCloseButton = new ImageButton(getView().getContext());
                    mCloseButton.setImageDrawable(statelistdrawable);
                    AndroidTargetUtils.setBackgroundDrawable(mCloseButton, null);
                    mCloseButton.setOnClickListener(new android.view.View.OnClickListener() {

                        final MraidDisplayController this$0;

                        public void onClick(View view)
                        {
                            close();
                        }

            
            {
                this$0 = MraidDisplayController.this;
                super();
            }
                    });
                }
                int i = (int)(50F * mDensity + 0.5F);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(i, i, 5);
                ((FrameLayout) (obj)).addView(mCloseButton, layoutparams);
            } else
            {
                ((FrameLayout) (obj)).removeView(mCloseButton);
            }
            obj = getView();
            if (((MraidView) (obj)).getOnCloseButtonStateChangeListener() != null)
            {
                ((MraidView) (obj)).getOnCloseButtonStateChangeListener().onCloseButtonStateChange(((MraidView) (obj)), flag);
                return;
            }
        }
    }

    protected void setRootView(FrameLayout framelayout)
    {
        mRootView = framelayout;
    }

    protected void surfaceAd()
    {
        getView().fireChangeEventForProperty(MraidViewableProperty.createWithViewable(true));
    }

    protected void unregisterReceivers()
    {
        if (!mRegistered)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        mRegistered = false;
        getView().getContext().unregisterReceiver(mOrientationBroadcastReceiver);
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
    }

    protected void useCustomClose(boolean flag)
    {
        mAdWantsCustomCloseButton = flag;
        MraidView mraidview = getView();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mraidview.getOnCloseButtonStateChangeListener() != null)
        {
            mraidview.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(mraidview, flag);
        }
    }




/*
    static boolean access$202(MraidDisplayController mraiddisplaycontroller, boolean flag)
    {
        mraiddisplaycontroller.vidPlaying_ = flag;
        return flag;
    }

*/


}
