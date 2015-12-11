// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ViewAnimator;
import com.amazon.mShop.actionBar.ActionBarHelper;
import com.amazon.mShop.actionBar.ActionBarIconController;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.error.AmazonActivityErrorHandler;
import com.amazon.mShop.error.AmazonErrorBox;
import com.amazon.mShop.error.AmazonErrorInfo;
import com.amazon.mShop.fastBrowse.FastBrowseActivity;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.home.GatewayActivity;
import com.amazon.mShop.home.web.MShopWebGatewayActivity;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.net.NetworkInfoMetricObserver;
import com.amazon.mShop.order.web.WebViewOrderActivity;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.share.WechatSDKManager;
import com.amazon.mShop.smile.SmileHelper;
import com.amazon.mShop.smile.SmileUserListener;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.startup.BaseActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.KeyUtils;
import com.amazon.mShop.util.LayoutUtils;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.MShopUiOOMHandler;
import com.amazon.mShop.util.MenuUtil;
import com.amazon.mShop.util.ShortcutUtil;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.retailsearch.android.ui.DelayedInitView;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop:
//            TitleProvider, AmazonBrandedWebView, AmazonApplication, ActivityTerminationReceiver, 
//            DelayedInitView, AmazonChooserActivity

public class AmazonActivity extends BaseActivity
    implements ActionBarIconController, com.amazon.mShop.model.auth.UserSubscriber.Callback
{
    protected final class DelayedInitializer
        implements Runnable
    {

        final AmazonActivity this$0;
        private final com.amazon.mShop.DelayedInitView view;

        public void run()
        {
            (new MShopUiOOMHandler(AmazonActivity.this, new com.amazon.mShop.util.MShopUiOOMHandler.UiRunnable(new Runnable() {

                final DelayedInitializer this$1;

                public void run()
                {
                    view.onPushViewCompleted();
                }

            
            {
                this$1 = DelayedInitializer.this;
                super();
            }
            }, false))).execute();
        }


        public DelayedInitializer(com.amazon.mShop.DelayedInitView delayedinitview, boolean flag)
        {
            this$0 = AmazonActivity.this;
            super();
            view = delayedinitview;
            if (flag)
            {
                ((View)delayedinitview).postDelayed(this, getResources().getInteger(com.amazon.mShop.android.lib.R.integer.animation_default_duration));
                return;
            } else
            {
                ((View)delayedinitview).post(this);
                return;
            }
        }
    }

    public static interface NewIntentListener
    {

        public abstract void handleNewIntent(Intent intent);
    }

    public static interface OnConfigurationChangedListener
    {

        public abstract void handleConfigurationChanged(Configuration configuration);
    }

    public final class RetailSearchDelayedInitializer
        implements Runnable
    {

        final AmazonActivity this$0;
        private final DelayedInitView view;

        public void run()
        {
            (new MShopUiOOMHandler(AmazonActivity.this, new com.amazon.mShop.util.MShopUiOOMHandler.UiRunnable(new Runnable() {

                final RetailSearchDelayedInitializer this$1;

                public void run()
                {
                    view.onPushViewCompleted();
                }

            
            {
                this$1 = RetailSearchDelayedInitializer.this;
                super();
            }
            }, false))).execute();
        }


        public RetailSearchDelayedInitializer(DelayedInitView delayedinitview, boolean flag)
        {
            this$0 = AmazonActivity.this;
            super();
            view = delayedinitview;
            if (flag)
            {
                ((View)delayedinitview).postDelayed(this, getResources().getInteger(com.amazon.mShop.android.lib.R.integer.animation_default_duration));
                return;
            } else
            {
                ((View)delayedinitview).post(this);
                return;
            }
        }
    }


    public static final String ACTIVITY_START_TIME = "activity_start_time";
    public static final String CLICK_STREAM_ORIGIN = "clickStreamOrigin";
    protected static final boolean DEBUG = DebugSettings.isDebugEnabled();
    public static final String INTENT_ACTION_START_ACTIVITY = "intentActionStartActivity";
    public static final String KEY_SEARCH_REQUEST_QUERY = "Query";
    public static final String KEY_SEARCH_SELECT_INITIAL_QUERY = "selectInitialQuery";
    public static final String LOG_TAG = "AmazonActivity";
    public static final int ONSTOP_BEHAVIOR_FINISH = 1;
    public static final int ONSTOP_BEHAVIOR_MODAL = 0;
    public static final int ONSTOP_BEHAVIOR_POP_TO_ROOT = 3;
    public static final int ONSTOP_BEHAVIOR_REMOVE_VIEWS = 2;
    public static final String REFMARKER = "REFMARKER";
    public static final String TOP_MOST_VIEW_CHANGED_RECEIVER_INTENT = "com.amazon.mShop.TopMostViewChangedReceiverIntent";
    private static boolean sIsInitialLaunch = true;
    private static boolean sKeepTopActivity = false;
    private static boolean sNeedRestart = false;
    private static int sTaskID = 0x80000000;
    private static int sTerminationReceiverCounter = 0;
    private static AmazonActivity sTopMostAmazonActivity;
    protected static WebView sWebViewInst = null;
    private SparseArray animationMap;
    private View mActionBarSeparatorDecorator;
    private long mActivityStartTime;
    private AmazonActivityErrorHandler mAmazonErrorHandler;
    private boolean mBackButtonPoppedView;
    private String mClickStreamOrigin;
    private List mConfigChangedListenerList;
    private View mContentView;
    private AmazonErrorBox mErrorBoxView;
    private GNODrawer mGNODrawer;
    private int mIndexFirstPdv;
    private NetworkInfoMetricObserver mNetworkInfoMetricObserver;
    private List mNewIntentListenerList;
    private View mTemporaryBlankView;
    private ActivityTerminationReceiver mTerminationReceiver;
    private com.amazon.mShop.model.auth.UserSubscriber.Callback primaryUserSubscriberCallback;
    private boolean pushAnimationInProgress;
    private final android.view.animation.Animation.AnimationListener pushInAnimationListener = new android.view.animation.Animation.AnimationListener() {

        final AmazonActivity this$0;

        public void onAnimationEnd(Animation animation)
        {
            pushAnimationInProgress = false;
        }

        public void onAnimationRepeat(Animation animation)
        {
            pushAnimationInProgress = true;
        }

        public void onAnimationStart(Animation animation)
        {
            pushAnimationInProgress = true;
        }

            
            {
                this$0 = AmazonActivity.this;
                super();
            }
    };
    private com.amazon.mShop.model.auth.UserSubscriber.Callback secondaryUserSubscriberCallback;
    private boolean skipStopBehavior;
    private int stopBehavior;
    private ViewAnimator viewAnimator;

    public AmazonActivity()
    {
        mConfigChangedListenerList = new ArrayList();
        mIndexFirstPdv = -1;
        mErrorBoxView = null;
        mAmazonErrorHandler = null;
        mBackButtonPoppedView = false;
        pushAnimationInProgress = false;
        animationMap = new SparseArray();
        mNewIntentListenerList = new ArrayList();
    }

    private void UpdateCartAndAppStartCount(Context context, boolean flag, boolean flag1)
    {
        context = HomeController.getInstance();
        if (flag1)
        {
            context.setApplicationStarted(true);
            if (!flag)
            {
                context.setReturnCartItems(true);
                context.setReturnHomeItems(false);
                context.phoneHome(false, false);
            }
        }
    }

    private void applyTitle(View view)
    {
        CharSequence charsequence = null;
        if (view instanceof TitleProvider)
        {
            charsequence = ((TitleProvider)view).getTitle();
        }
        setTitle(charsequence);
    }

    private void authenticateUser(com.amazon.mShop.model.auth.UserSubscriber.Callback callback, com.amazon.mShop.model.auth.UserSubscriber.Callback callback1, boolean flag, String s)
    {
        primaryUserSubscriberCallback = callback;
        secondaryUserSubscriberCallback = callback1;
        if (IdentityType.NON_SSO_TYPE != SSOUtil.getCurrentIdentityType())
        {
            SSOUtil.getCurrentIdentityType().handleSSOLogin(this);
            return;
        }
        if (this instanceof AmazonActivity)
        {
            skipNextStopBehavior();
        }
        boolean flag1;
        if (isLaunchedFromPublicUrl() && (this instanceof WebViewOrderActivity) && SSOUtil.needSigninPrompt())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ActivityUtils.startLoginActivityForResult(this, 0, "authenticate_user", flag1, flag1, flag, s);
    }

    private Animation getAnimation(int i)
    {
        return getAnimation(i, null);
    }

    private Animation getAnimation(int i, android.view.animation.Animation.AnimationListener animationlistener)
    {
        Animation animation;
        if (i == 0)
        {
            animation = null;
        } else
        {
            Animation animation2 = (Animation)animationMap.get(i);
            animation = animation2;
            if (animation2 == null)
            {
                Animation animation1 = AnimationUtils.loadAnimation(this, i);
                animationMap.put(i, animation1);
                animation1.setAnimationListener(animationlistener);
                return animation1;
            }
        }
        return animation;
    }

    public static int getTerminationReceiverCounter()
    {
        com/amazon/mShop/AmazonActivity;
        JVM INSTR monitorenter ;
        int i = sTerminationReceiverCounter;
        com/amazon/mShop/AmazonActivity;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static final AmazonActivity getTopMostBaseActivity()
    {
        return sTopMostAmazonActivity;
    }

    private ViewAnimator getViewAnimator(boolean flag)
    {
        if (viewAnimator == null)
        {
            viewAnimator = new ViewAnimator(this);
            viewAnimator.setLayoutParams(LayoutUtils.fillBoth());
            if (flag)
            {
                View view = setupCustomizedActionbar(viewAnimator);
                mActionBarSeparatorDecorator = view;
                view = ActionBarHelper.applyActionBar(this, setWrappedViewAnimator(view));
                super.setContentView(view);
                mContentView = view;
            } else
            {
                super.setContentView(viewAnimator);
                mContentView = viewAnimator;
            }
        }
        return viewAnimator;
    }

    public static boolean isNeedRestart()
    {
        com/amazon/mShop/AmazonActivity;
        JVM INSTR monitorenter ;
        boolean flag = sNeedRestart;
        com/amazon/mShop/AmazonActivity;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private void onTopmostViewChanged()
    {
        applyTitle(getCurrentView());
        Intent intent = new Intent();
        intent.setAction("com.amazon.mShop.TopMostViewChangedReceiverIntent");
        sendBroadcast(intent);
    }

    public static void setNeedRestart(boolean flag)
    {
        com/amazon/mShop/AmazonActivity;
        JVM INSTR monitorenter ;
        sNeedRestart = flag;
        com/amazon/mShop/AmazonActivity;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setTerminationReceiverCounter(int i)
    {
        com/amazon/mShop/AmazonActivity;
        JVM INSTR monitorenter ;
        sTerminationReceiverCounter = i;
        com/amazon/mShop/AmazonActivity;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void startLogTime()
    {
        mNetworkInfoMetricObserver = NetworkInfoMetricObserver.start(NetInfo.getNetworkType());
        mNetworkInfoMetricObserver.startForObject(getClass().getSimpleName());
        if (DEBUG)
        {
            Log.i(getClass().getSimpleName(), "Network collection start to log time");
        }
    }

    private void stopLogTime()
    {
        if (mNetworkInfoMetricObserver != null && !mNetworkInfoMetricObserver.isFinished())
        {
            mNetworkInfoMetricObserver.completeForObject(getClass().getSimpleName());
            if (DEBUG)
            {
                Log.i(getClass().getSimpleName(), "Network collection end to log time");
            }
        }
        mNetworkInfoMetricObserver = null;
    }

    public void authenticateUser(com.amazon.mShop.model.auth.UserSubscriber.Callback callback, com.amazon.mShop.model.auth.UserSubscriber.Callback callback1)
    {
        authenticateUser(callback, callback1, false, null);
    }

    public void authenticateUser(com.amazon.mShop.model.auth.UserSubscriber.Callback callback, com.amazon.mShop.model.auth.UserSubscriber.Callback callback1, String s)
    {
        authenticateUser(callback, callback1, false, s);
    }

    public void authenticateUser(com.amazon.mShop.model.auth.UserSubscriber.Callback callback, com.amazon.mShop.model.auth.UserSubscriber.Callback callback1, boolean flag)
    {
        authenticateUser(callback, callback1, flag, null);
    }

    public boolean canLaunchHomeFromActionBar()
    {
        return true;
    }

    public void clearErrorOnView(View view)
    {
        int i = UIUtils.findViewIndex(getViewAnimator(), view);
        getErrorHandler().onErrorReportAt(null, i);
        if (i == getViewAnimator().getChildCount() - 1)
        {
            dismissErrorBox();
        }
    }

    protected void clearKeepTopActivityFlag()
    {
        sKeepTopActivity = false;
    }

    public void closeSoftKeyboard()
    {
        if (viewAnimator != null && viewAnimator.getChildCount() > 0)
        {
            UIUtils.closeSoftKeyboard(viewAnimator.getCurrentView());
        }
    }

    public void defaultStartActivity(Intent intent)
    {
        super.startActivity(intent);
    }

    public void dismissErrorBox()
    {
        if (mErrorBoxView != null)
        {
            removeErrorBox(mErrorBoxView);
            getErrorHandler().onErrorBoxDisappeared();
            unregisterConfigChangedListener(mErrorBoxView);
            mErrorBoxView = null;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
_L2:
        return true;
        if (menuDispatchedKeyEvent(keyevent) || pushAnimationInProgress) goto _L2; else goto _L1
_L1:
        if (viewAnimator == null || 4 != keyevent.getKeyCode() || keyevent.getAction() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        View view = getCurrentView();
        if (view != null && view.dispatchKeyEvent(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (popView(false))
        {
            mBackButtonPoppedView = true;
            return true;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L3
_L3:
        if (mBackButtonPoppedView && 4 == keyevent.getKeyCode() && 1 == keyevent.getAction())
        {
            mBackButtonPoppedView = false;
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (pushAnimationInProgress)
        {
            return true;
        } else
        {
            return super.dispatchTouchEvent(motionevent);
        }
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent)
    {
        if (pushAnimationInProgress)
        {
            return true;
        } else
        {
            return super.dispatchTrackballEvent(motionevent);
        }
    }

    public final View findViewById(int i)
    {
        return super.findViewById(i);
    }

    public void finishIfNotFinishing()
    {
        if (isFinishing())
        {
            return;
        } else
        {
            finish();
            return;
        }
    }

    public boolean forward(Object obj)
    {
        closeSoftKeyboard();
        if (obj instanceof ProductController)
        {
            ActivityUtils.launchDetailsPage(this, (ProductController)obj, new int[0]);
            return true;
        }
        if (obj instanceof Uri)
        {
            pushView(new AmazonBrandedWebView(this, obj.toString(), getString(com.amazon.mShop.android.lib.R.string.navigate_forward_to_uri)));
            return true;
        } else
        {
            return false;
        }
    }

    public long getActivityStartTime()
    {
        if (mActivityStartTime > 0L)
        {
            return mActivityStartTime;
        } else
        {
            return SystemClock.elapsedRealtime();
        }
    }

    public String getClickStreamOrigin()
    {
        return mClickStreamOrigin;
    }

    public View getContentView()
    {
        return mContentView;
    }

    public AmazonErrorInfo getCurrentErrorInfo()
    {
        return getErrorHandler().getCurrentErrorInfo();
    }

    public View getCurrentView()
    {
        if (viewAnimator != null)
        {
            return viewAnimator.getCurrentView();
        } else
        {
            return null;
        }
    }

    public AmazonActivityErrorHandler getErrorHandler()
    {
        if (mAmazonErrorHandler == null)
        {
            mAmazonErrorHandler = new AmazonActivityErrorHandler(this);
        }
        return mAmazonErrorHandler;
    }

    public GNODrawer getGNODrawer()
    {
        return mGNODrawer;
    }

    public ViewAnimator getViewAnimator()
    {
        return getViewAnimator(true);
    }

    public void handleConfigChanged(Configuration configuration)
    {
        for (Iterator iterator = mConfigChangedListenerList.iterator(); iterator.hasNext(); ((OnConfigurationChangedListener)iterator.next()).handleConfigurationChanged(configuration)) { }
    }

    protected void handleForceSignIn()
    {
    }

    public void handleNewIntent(Intent intent)
    {
        for (Iterator iterator = mNewIntentListenerList.iterator(); iterator.hasNext(); ((NewIntentListener)iterator.next()).handleNewIntent(intent)) { }
    }

    protected void insertErrorBox(View view)
    {
        ViewGroup viewgroup = (ViewGroup)mActionBarSeparatorDecorator;
        int i = viewgroup.getChildCount() - 1;
        if (i >= 0)
        {
            viewgroup.addView(view, i);
            return;
        } else
        {
            viewgroup.addView(view);
            return;
        }
    }

    public boolean isActionBarSearchIconFadeable()
    {
        View view = getCurrentView();
        return (view instanceof ActionBarIconController) && ((ActionBarIconController)view).isActionBarSearchIconFadeable();
    }

    public boolean isErrorBoxShowing()
    {
        return mErrorBoxView != null;
    }

    public boolean isLaunchedFromPublicUrl()
    {
        boolean flag1 = false;
        Intent intent = getIntent();
        boolean flag = flag1;
        if (intent != null)
        {
            flag = flag1;
            if (intent.getBooleanExtra("Launch_From_Public_Url", false))
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isPushAnimationInProgress()
    {
        return pushAnimationInProgress;
    }

    public void logTimeWhenNetworkTypeChanged()
    {
        if (DEBUG)
        {
            Log.i(getClass().getSimpleName(), "Network work type changed");
        }
        stopLogTime();
        startLogTime();
    }

    public boolean menuDispatchedKeyEvent(KeyEvent keyevent)
    {
        if (KeyUtils.isEventMatching(keyevent, 82, 0))
        {
            if (this instanceof FastBrowseActivity)
            {
                getGNODrawer().unlock();
            }
            getGNODrawer().toggle();
        } else
        if (keyevent.getKeyCode() == 4 && mGNODrawer.isVisible())
        {
            if (keyevent.getAction() == 0)
            {
                if (mGNODrawer.isAppDrawerOpen())
                {
                    mGNODrawer.closeAppDrawer();
                    return true;
                } else
                {
                    mGNODrawer.close();
                    return true;
                }
            }
        } else
        {
            return false;
        }
        return true;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 0)
        {
            if (-1 == j)
            {
                userSuccessfullySignedIn();
            } else
            {
                userCancelledSignIn();
            }
            primaryUserSubscriberCallback = null;
            secondaryUserSubscriberCallback = null;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        handleConfigChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag1 = true;
        int i = getTaskId();
        boolean flag;
        if (sTaskID == 0x80000000)
        {
            sTaskID = i;
            sIsInitialLaunch = true;
        } else
        if (sTaskID != i)
        {
            sTaskID = i;
            sIsInitialLaunch = true;
        } else
        {
            sIsInitialLaunch = false;
        }
        if (sIsInitialLaunch)
        {
            ShortcutUtil.increaseAppStartCountInCurrentVersion(this);
        }
        if (DEBUG)
        {
            Log.d("AmazonActivity", (new StringBuilder()).append("sIsInitialLaunch is ").append(sIsInitialLaunch).toString());
        }
        AmazonApplication.setUp(this);
        flag = flag1;
        if (!(this instanceof GatewayActivity))
        {
            if (this instanceof MShopWebGatewayActivity)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        UpdateCartAndAppStartCount(this, flag, sIsInitialLaunch);
        handleForceSignIn();
        sIsInitialLaunch = false;
        registerPushNotification();
        super.onCreate(bundle);
        if (bundle == null)
        {
            mActivityStartTime = getIntent().getLongExtra("activity_start_time", SystemClock.elapsedRealtime());
        }
        mTerminationReceiver = new ActivityTerminationReceiver();
        registerReceiver(mTerminationReceiver, ActivityTerminationReceiver.INTENT_FILTER);
        setTerminationReceiverCounter(getTerminationReceiverCounter() + 1);
        if (DEBUG)
        {
            Log.v("AmazonActivity", (new StringBuilder()).append("onCreate: ").append(this).toString());
        }
        stopBehavior = 0;
        mClickStreamOrigin = getIntent().getStringExtra("clickStreamOrigin");
        if (sWebViewInst == null)
        {
            sWebViewInst = new WebView(getApplicationContext());
        }
        mGNODrawer = GNODrawer.getInstance(this);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuUtil.onCreateOptionsMenu(menu, this);
        return true;
    }

    protected void onDestroy()
    {
        unregisterReceiver(mTerminationReceiver);
        setTerminationReceiverCounter(getTerminationReceiverCounter() - 1);
        super.onDestroy();
        removeAllViews();
        if (getTerminationReceiverCounter() == 0 && isNeedRestart())
        {
            AppUtils.launchApp(this);
            setNeedRestart(false);
        }
        mTerminationReceiver = null;
        if (MShopPushNotificationUtils.isPushNotificationAvailable() && isTaskRoot())
        {
            PushNotificationManager.getInstance().onMainActivityDestroyed(getApplicationContext());
        }
        mGNODrawer.destroy();
    }

    public void onEulaAccepted()
    {
    }

    public void onLowMemory()
    {
        LRUCache.onLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        switch (i)
        {
        default:
            return false;

        case 0: // '\0'
            return onOptionsItemSelected(menuitem);

        case 6: // '\006'
            return super.onMenuItemSelected(i, menuitem);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mActivityStartTime = intent.getLongExtra("activity_start_time", SystemClock.elapsedRealtime());
        handleNewIntent(intent);
        intent = intent.getAction();
        if (intent != null && intent.equals("intentActionStartActivity"))
        {
            popToRoot();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return MenuUtil.onOptionsItemSelected(menuitem, this);
    }

    protected void onPause()
    {
        super.onPause();
        stopLogTime();
        if (sTopMostAmazonActivity == this && !sKeepTopActivity)
        {
            sTopMostAmazonActivity = null;
        }
        pauseTimersIfNeeded();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onResume()
    {
        super.onResume();
        sTopMostAmazonActivity = this;
        resumeTimersIfNeeded();
        Features.getInstance().fetchFeatureStates();
        mGNODrawer.resetPosition();
        updateGNOMenuItems();
        removeTemporaryBlankView();
        startLogTime();
        SmileUserListener.registerUserListener();
        SmileHelper.syncSmileInfoWithTimeInterval();
    }

    public boolean onSearchRequested()
    {
        return onSearchRequested(null, true);
    }

    public boolean onSearchRequested(String s, boolean flag)
    {
        return ActivityUtils.startSearchActivity(this, (new SearchIntentBuilder(this)).query(s).showSearchEntryView(true).selectInitialQuery(flag).clickStreamOrigin(ClickStreamTag.ORIGIN_SEARCH.getTag()).build());
    }

    protected void onStart()
    {
        super.onStart();
        if (DEBUG)
        {
            Log.v("AmazonActivity", (new StringBuilder()).append("onStart: ").append(this).toString());
        }
        getWindow().setSoftInputMode(3);
        skipStopBehavior = false;
    }

    protected void onStop()
    {
        super.onStop();
        if (DEBUG)
        {
            Log.v("AmazonActivity", (new StringBuilder()).append("onStop: ").append(this).toString());
        }
        if (skipStopBehavior) goto _L2; else goto _L1
_L1:
        stopBehavior;
        JVM INSTR tableswitch 1 3: default 72
    //                   1 89
    //                   2 96
    //                   3 103;
           goto _L2 _L3 _L4 _L5
_L2:
        if (!AppUtils.isApplicationForeground())
        {
            WechatSDKManager.clearPendingTransaction();
        }
        mGNODrawer.close();
        return;
_L3:
        finish();
        continue; /* Loop/switch isn't completed */
_L4:
        removeAllViews();
        continue; /* Loop/switch isn't completed */
_L5:
        popToRoot();
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void onTitleChanged(CharSequence charsequence, int i)
    {
        super.onTitleChanged(charsequence, i);
        ActionBarHelper.onTitleChanged(this, charsequence);
    }

    protected void onViewPopped(View view, View view1)
    {
    }

    protected void onViewPushed(View view)
    {
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
        {
            View view = getCurrentView();
            if (view != null)
            {
                view.setVisibility(0);
            }
        }
    }

    protected void pauseTimersIfNeeded()
    {
        if (!AmazonApplication.isWebViewCacheEmpty())
        {
            sWebViewInst.pauseTimers();
        }
    }

    public void popToRoot()
    {
        closeSoftKeyboard();
        if (viewAnimator != null && 1 < viewAnimator.getChildCount())
        {
            viewAnimator.setInAnimation(null);
            viewAnimator.setOutAnimation(null);
            viewAnimator.removeViews(1, viewAnimator.getChildCount() - 1);
            onTopmostViewChanged();
            getErrorHandler().onPoppedToRoot();
        }
    }

    public boolean popView()
    {
        return popView(true);
    }

    public boolean popView(boolean flag)
    {
        return popView(flag, true);
    }

    public boolean popView(boolean flag, int i, int j)
    {
        View view;
        Object obj;
        boolean flag2;
        flag2 = false;
        obj = null;
        view = null;
        pushAnimationInProgress = false;
        closeSoftKeyboard();
        if (viewAnimator == null || 1 >= viewAnimator.getChildCount()) goto _L2; else goto _L1
_L1:
        View view1;
        boolean flag1;
        dismissErrorBox();
        view1 = viewAnimator.getCurrentView();
        viewAnimator.setInAnimation(getAnimation(i));
        viewAnimator.setOutAnimation(getAnimation(j));
        viewAnimator.showPrevious();
        viewAnimator.removeView(view1);
        view = viewAnimator.getCurrentView();
        onTopmostViewChanged();
        getErrorHandler().onViewPopped();
        flag1 = true;
_L4:
        onViewPopped(view1, view);
        return flag1;
_L2:
        flag1 = flag2;
        view1 = obj;
        if (flag)
        {
            view = viewAnimator.getCurrentView();
            finish();
            flag1 = flag2;
            view1 = obj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean popView(boolean flag, boolean flag1)
    {
        if (flag1)
        {
            return popView(flag, com.amazon.mShop.android.lib.R.anim.transition_pop_in, com.amazon.mShop.android.lib.R.anim.transition_pop_out);
        } else
        {
            return popView(flag, 0, 0);
        }
    }

    public void pushTemporaryBlankView()
    {
        mTemporaryBlankView = new View(this);
        pushView(mTemporaryBlankView, 0, com.amazon.mShop.android.lib.R.anim.fade_out);
    }

    public void pushView(int i)
    {
        if (pushAnimationInProgress)
        {
            return;
        } else
        {
            pushView(View.inflate(this, i, null));
            return;
        }
    }

    public void pushView(View view)
    {
        pushView(view, true);
    }

    public void pushView(View view, int i, int j)
    {
        if (pushAnimationInProgress)
        {
            return;
        }
        getErrorHandler().onPushView();
        closeSoftKeyboard();
        ViewAnimator viewanimator = getViewAnimator();
        viewanimator.setInAnimation(getAnimation(i, pushInAnimationListener));
        viewanimator.setOutAnimation(getAnimation(j));
        viewanimator.addView(view);
        viewanimator.showNext();
        onTopmostViewChanged();
        if (!(view instanceof com.amazon.mShop.DelayedInitView)) goto _L2; else goto _L1
_L1:
        new DelayedInitializer((com.amazon.mShop.DelayedInitView)view, true);
_L4:
        onViewPushed(view);
        return;
_L2:
        if (view instanceof DelayedInitView)
        {
            new RetailSearchDelayedInitializer((DelayedInitView)view, true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void pushView(View view, boolean flag)
    {
        if (flag)
        {
            pushView(view, com.amazon.mShop.android.lib.R.anim.transition_push_in, com.amazon.mShop.android.lib.R.anim.transition_push_out);
            return;
        } else
        {
            pushView(view, 0, 0);
            return;
        }
    }

    public void registerConfigChangedListener(OnConfigurationChangedListener onconfigurationchangedlistener)
    {
        if (onconfigurationchangedlistener != null && !mConfigChangedListenerList.contains(onconfigurationchangedlistener))
        {
            mConfigChangedListenerList.add(onconfigurationchangedlistener);
        }
    }

    public void registerNewIntentListener(NewIntentListener newintentlistener)
    {
        if (newintentlistener != null && !mNewIntentListenerList.contains(newintentlistener))
        {
            mNewIntentListenerList.add(newintentlistener);
        }
    }

    protected void registerPushNotification()
    {
        String s = null;
        if (MShopPushNotificationUtils.isPushNotificationAvailable())
        {
            PushNotificationManager pushnotificationmanager = PushNotificationManager.getInstance();
            NotificationTarget notificationtarget = pushnotificationmanager.getNewNotificationTarget(null);
            if (notificationtarget != null)
            {
                pushnotificationmanager.updateDeviceToken(notificationtarget.getDestination());
            }
            if (Util.isEmpty(MShopPushNotificationUtils.getLastMarketPlace()) || !MShopPushNotificationUtils.getLastMarketPlace().equals(AppLocale.getInstance().getCurrentLocaleName()))
            {
                if (notificationtarget != null)
                {
                    s = notificationtarget.getDestination();
                }
                pushnotificationmanager.enableNotificationsForNewMarketplace(s);
            }
        }
    }

    public void removeAllViews()
    {
        if (viewAnimator != null)
        {
            closeSoftKeyboard();
            viewAnimator.setInAnimation(null);
            viewAnimator.setOutAnimation(null);
            viewAnimator.removeAllViews();
            getErrorHandler().removeAllErrors();
            dismissErrorBox();
        }
    }

    protected void removeErrorBox(View view)
    {
        ((ViewGroup)mActionBarSeparatorDecorator).removeView(view);
    }

    protected void removeTemporaryBlankView()
    {
        if (mTemporaryBlankView != null)
        {
            removeView(mTemporaryBlankView, false);
            mTemporaryBlankView = null;
        }
    }

    public boolean removeView(View view, boolean flag)
    {
        if (view != null)
        {
            closeSoftKeyboard();
            if (!flag)
            {
                viewAnimator.setInAnimation(null);
                viewAnimator.setOutAnimation(null);
            }
            int j = viewAnimator.getChildCount();
            int i = 0;
            while (i < j) 
            {
                View view1 = viewAnimator.getChildAt(i);
                if (view1 == view)
                {
                    viewAnimator.removeView(view1);
                    getErrorHandler().removeErrorAt(i);
                    if (i == j - 1)
                    {
                        onTopmostViewChanged();
                        getErrorHandler().onTopViewRemoved();
                    }
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public void reportErrorOnView(AmazonErrorInfo amazonerrorinfo, AmazonErrorBox amazonerrorbox, View view)
    {
        int i = UIUtils.findViewIndex(getViewAnimator(), view);
        getErrorHandler().onErrorReportAt(amazonerrorinfo, i);
        if (i == getViewAnimator().getChildCount() - 1 && i >= 0)
        {
            if (mErrorBoxView != null)
            {
                removeErrorBox(mErrorBoxView);
                mErrorBoxView = null;
            }
            if (amazonerrorbox != null)
            {
                mErrorBoxView = amazonerrorbox;
                insertErrorBox(mErrorBoxView);
                mErrorBoxView.setVisibility(0);
                registerConfigChangedListener(mErrorBoxView);
            }
        }
    }

    protected void resumeTimersIfNeeded()
    {
        if (!AmazonApplication.isWebViewCacheEmpty())
        {
            sWebViewInst.resumeTimers();
        }
    }

    public void setActionBarAndSeparatorDecoratorVisibility(int i)
    {
        ViewGroup viewgroup = (ViewGroup)getContentView();
        ViewGroup viewgroup1 = (ViewGroup)mActionBarSeparatorDecorator;
        if (viewgroup != null && viewgroup1 != null)
        {
            if (viewgroup1.getChildCount() > 1)
            {
                viewgroup1.getChildAt(0).setVisibility(i);
            }
            if (viewgroup.getChildCount() > 1)
            {
                viewgroup.getChildAt(0).setVisibility(i);
            }
        }
    }

    public void setClickStreamOrigin(String s)
    {
        mClickStreamOrigin = s;
    }

    public final void setContentView(int i)
    {
        super.setContentView(i);
    }

    public final void setContentView(View view)
    {
        super.setContentView(view);
    }

    public final void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
    }

    protected void setKeepTopActivityFlag()
    {
        sKeepTopActivity = true;
    }

    public void setRootView(View view)
    {
        setRootView(view, true);
    }

    public void setRootView(View view, boolean flag)
    {
        setRootView(view, flag, true);
    }

    public void setRootView(View view, boolean flag, int i, int j)
    {
        if (viewAnimator == null)
        {
            getViewAnimator(flag);
        } else
        {
            closeSoftKeyboard();
            viewAnimator.removeAllViews();
        }
        viewAnimator.setInAnimation(getAnimation(i, pushInAnimationListener));
        viewAnimator.setOutAnimation(getAnimation(j));
        viewAnimator.addView(view);
        viewAnimator.showNext();
        onTopmostViewChanged();
        getErrorHandler().removeAllErrors();
        getErrorHandler().setCurrentErrorInfo(null);
        if (view instanceof com.amazon.mShop.DelayedInitView)
        {
            new DelayedInitializer((com.amazon.mShop.DelayedInitView)view, false);
        }
    }

    public void setRootView(View view, boolean flag, boolean flag1)
    {
        if (flag1)
        {
            setRootView(view, flag, com.amazon.mShop.android.lib.R.anim.transition_push_in, com.amazon.mShop.android.lib.R.anim.transition_push_out);
            return;
        } else
        {
            setRootView(view, flag, 0, 0);
            return;
        }
    }

    public void setSkipStopBehavior(boolean flag)
    {
        skipStopBehavior = flag;
    }

    public void setStopBehavior(int i)
    {
        stopBehavior = i;
    }

    protected void setViewAnimator(ViewAnimator viewanimator)
    {
        viewAnimator = viewanimator;
        if (viewanimator != null)
        {
            super.setContentView(viewanimator);
        }
    }

    protected View setWrappedViewAnimator(View view)
    {
        return mGNODrawer.applyGNODrawer(view);
    }

    protected View setupCustomizedActionbar(ViewAnimator viewanimator)
    {
        return ActionBarHelper.applyActionBarSeparator(this, viewanimator);
    }

    public void skipNextStopBehavior()
    {
        skipStopBehavior = true;
    }

    public void startActivity(Intent intent)
    {
        Intent intent2;
        intent2 = intent;
        intent.putExtra("activity_start_time", SystemClock.elapsedRealtime());
        if (!"android.intent.action.CHOOSER".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        Intent intent1 = AmazonChooserActivity.getIntentToStart(this, intent);
_L4:
        super.startActivity(intent1);
        return;
_L2:
        intent1 = intent2;
        if (!"android.intent.action.DIAL".equals(intent.getAction()))
        {
            List list = getPackageManager().queryIntentActivities(intent, 0x10000);
            intent1 = intent2;
            if (list != null)
            {
                intent1 = intent2;
                if (list.size() > 1)
                {
                    intent1 = AmazonChooserActivity.getIntentToStart(this, intent);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void swapView(View view)
    {
        if (pushAnimationInProgress)
        {
            return;
        }
        pushView(view);
        view = getViewAnimator();
        int i = view.getChildCount();
        if (1 < i)
        {
            view.removeViewAt(i - 2);
        }
        getErrorHandler().onViewSwapped();
    }

    public void unregisterConfigChangedListener(OnConfigurationChangedListener onconfigurationchangedlistener)
    {
        if (onconfigurationchangedlistener != null)
        {
            mConfigChangedListenerList.remove(onconfigurationchangedlistener);
        }
    }

    public void unregisterNewIntentListener(NewIntentListener newintentlistener)
    {
        if (newintentlistener != null)
        {
            mNewIntentListenerList.remove(newintentlistener);
        }
    }

    protected void updateGNOMenuItems()
    {
        mGNODrawer.updateMenuItems(true);
    }

    public void updateTitle(View view)
    {
        if (view == getCurrentView())
        {
            applyTitle(view);
        }
    }

    public void userCancelledSignIn()
    {
        if (primaryUserSubscriberCallback != null)
        {
            primaryUserSubscriberCallback.userCancelledSignIn();
        }
        if (secondaryUserSubscriberCallback != null)
        {
            secondaryUserSubscriberCallback.userCancelledSignIn();
        }
    }

    public void userSuccessfullySignedIn()
    {
        if (primaryUserSubscriberCallback != null)
        {
            primaryUserSubscriberCallback.userSuccessfullySignedIn();
        }
        if (secondaryUserSubscriberCallback != null)
        {
            secondaryUserSubscriberCallback.userSuccessfullySignedIn();
        }
    }



/*
    static boolean access$202(AmazonActivity amazonactivity, boolean flag)
    {
        amazonactivity.pushAnimationInProgress = flag;
        return flag;
    }

*/
}
