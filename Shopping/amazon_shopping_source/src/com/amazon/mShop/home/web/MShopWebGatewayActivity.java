// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ViewAnimator;
import com.amazon.device.crashmanager.CrashDetectionHelper;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.TimeChangedReceiver;
import com.amazon.mShop.actionBar.ActionBarHelper;
import com.amazon.mShop.actionBar.ActionBarIconController;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.home.GatewayWeblabUtil;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.share.SharableAppInfoManager;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.ExitConfirmationDialogHelper;
import com.amazon.mShop.util.ShortcutUtil;
import com.amazon.mShop.util.UpgradeUtil;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mShop.web.MShopWebFragment;
import com.amazon.mShop.web.MShopWebViewContainer;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.home.web:
//            MShopWebHomeBar

public class MShopWebGatewayActivity extends MShopWebActivity
    implements UserListener
{
    private static class MShopGatewayWebViewContener extends MShopWebViewContainer
    {

        public void showSpinner()
        {
            super.showSpinner();
            getProgressBarContainer().setVisibility(8);
        }

        public MShopGatewayWebViewContener(Context context)
        {
            super(context);
        }
    }


    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private long lastUserSigninInTimeMillis;
    private boolean mIsGatewayJustCreated;
    private boolean mLaunchForceSignInPage;
    private boolean mNeedReloadHomeActivity;
    private boolean mSignInFromHtmlGatewayPage;
    private TimeChangedReceiver mTimeChangedReceiver;
    private MShopWebHomeBar mWebHomeBar;

    public MShopWebGatewayActivity()
    {
        mLaunchForceSignInPage = false;
        mWebHomeBar = null;
        mIsGatewayJustCreated = true;
        lastUserSigninInTimeMillis = 0L;
        mNeedReloadHomeActivity = false;
        mSignInFromHtmlGatewayPage = false;
    }

    private void checkAndShowShortcutInstallDialog()
    {
        boolean flag = false;
        if (ShortcutUtil.getAppStartCountInCurrentVersion(this) <= 1)
        {
            flag = true;
        }
        if (flag && SharableAppInfoManager.isCnMshopPackage(getApplicationContext()) && ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_shortcut_install) && !ShortcutUtil.isShortcutInstalled(this) && ShortcutUtil.isAbleToInstallShortcut(this))
        {
            ShortcutUtil.installShortcut(this);
        }
    }

    public void authenticateUser(com.amazon.mShop.model.auth.UserSubscriber.Callback callback, com.amazon.mShop.model.auth.UserSubscriber.Callback callback1)
    {
        mSignInFromHtmlGatewayPage = true;
        super.authenticateUser(callback, callback1);
    }

    protected MShopWebViewContainer createWebViewContainer()
    {
        return new MShopGatewayWebViewContener(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (isPushAnimationInProgress() || menuDispatchedKeyEvent(keyevent))
        {
            return true;
        }
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0 && ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_hasExitApp))
        {
            ExitConfirmationDialogHelper.create(this, "hm_exit_ok", "hm_exit_cancel").show();
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public ClassLoader getClassLoader()
    {
        ClassLoader classloader1 = SecondDexEntry.getInstance().getClassLoader();
        ClassLoader classloader = classloader1;
        if (classloader1 == null)
        {
            classloader = super.getClassLoader();
        }
        return classloader;
    }

    protected void handleForceSignIn()
    {
        SSOUtil.handleSigninPrompt(this);
    }

    protected void initWebView()
    {
        mWebFragment.initWebViewContainer(this);
        if (ActivityUtils.isHtmlGatewayWebViewHAOff())
        {
            getWebView().setLayerType(1, null);
        }
        initLayout();
    }

    public boolean isActionBarSearchIconFadeable()
    {
        return (mWebHomeBar instanceof ActionBarIconController) && mWebHomeBar.isActionBarSearchIconFadeable();
    }

    protected void loadHTMLGateway()
    {
        if (DEBUG)
        {
            Log.d("WebGatewayActivity", (new StringBuilder()).append("loadHTMLGateway with start time, ").append(getRealClickTime()).toString());
        }
        super.loadUrl();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        mLaunchForceSignInPage = false;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        User.addUserListener(this);
        boolean flag = getIntent().getBooleanExtra("INTENT_EXTRA_STARTED_NO_NEED_COUNT_APPSTART", false);
        HomeController.getInstance().setNoNeedCountAppStart(flag);
        setStopBehavior(0);
        mTimeChangedReceiver = new TimeChangedReceiver();
        registerReceiver(mTimeChangedReceiver, TimeChangedReceiver.INTENT_FILTER);
    }

    protected void onDestroy()
    {
        unregisterReceiver(mTimeChangedReceiver);
        mTimeChangedReceiver = null;
        super.onDestroy();
        User.removeUserListener(this);
        User.removeUserListener(HomeController.getInstance());
        HomeController.setInstance(null);
        if (isNeedRestart())
        {
            setNeedRestart(false);
            AppUtils.launchApp(this);
        }
    }

    protected void onResume()
    {
        com.amazon.mShop.feature.Features.FeatureStateChangeType featurestatechangetype;
        super.onResume();
        featurestatechangetype = GatewayWeblabUtil.getInstance().updateGatewayWeblabState();
        if (com.amazon.mShop.feature.Features.FeatureStateChangeType.NO_CHANGE == featurestatechangetype || mLaunchForceSignInPage || SSOUtil.needSigninPrompt()) goto _L2; else goto _L1
_L1:
        if (com.amazon.mShop.feature.Features.FeatureStateChangeType.TREATMENT_CHANGE != featurestatechangetype) goto _L4; else goto _L3
_L3:
        mNeedReloadHomeActivity = true;
        ActivityUtils.reloadHomeActivity(this);
_L6:
        if (CrashDetectionHelper.getInstance() != null)
        {
            CrashDetectionHelper.getInstance().uploadCrashReportAsync();
        }
        return;
_L4:
        if (com.amazon.mShop.feature.Features.FeatureStateChangeType.CACHETIMESTAMP_CHANGE == featurestatechangetype)
        {
            GatewayWeblabUtil.getInstance().postGatewayFeatureTrigger(false);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!mLaunchForceSignInPage || User.isLoggedIn() || !ActivityUtils.isSignInPrompt())
        {
            checkAndShowShortcutInstallDialog();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onSearchRequested()
    {
        if (mLaunchForceSignInPage)
        {
            return false;
        } else
        {
            return super.onSearchRequested();
        }
    }

    protected void onStart()
    {
        super.onStart();
        DataStore datastore = AndroidPlatform.getInstance().getDataStore();
        if (!mLaunchForceSignInPage && datastore.getBoolean("upgradeShouldShowDialog", false) && UpgradeUtil.checkTimeout(datastore.getLong("upgradeLastDialogTime"), 0x48190800L))
        {
            UpgradeUtil.showUpgradeNotificationDialog(this);
        }
        if (!mIsGatewayJustCreated && mWebHomeBar != null)
        {
            new com.amazon.mShop.AmazonActivity.DelayedInitializer(this, mWebHomeBar, false);
        }
        mIsGatewayJustCreated = false;
    }

    protected void processSavedInstanceAndInitWebview(Bundle bundle)
    {
        bundle = getIntent();
        if (TextUtils.isEmpty(bundle.getStringExtra(WebConstants.getWebViewUrlKey())))
        {
            bundle.putExtra(WebConstants.getWebViewUrlKey(), ActivityUtils.getHTMLGatewayUrl(this, null));
        }
        super.processSavedInstanceAndInitWebview(null);
    }

    public void reloadHtmlGateway(long l)
    {
        if (mNeedReloadHomeActivity)
        {
            if (DEBUG)
            {
                Log.d("WebGatewayActivity", "reloadHtmlGateway - no need to reload the gateway url when reload gateway activity");
            }
        } else
        {
            setWebviewStartTime(l);
            if (DEBUG)
            {
                Log.d("WebGatewayActivity", (new StringBuilder()).append("reloadHtmlGateway with start time, ").append(getRealClickTime()).toString());
            }
            if (getWebView() != null)
            {
                getWebView().stopLoading();
                getWebViewContainer().clearHistory();
                getWebView().loadUrl(getUrl());
                return;
            }
        }
    }

    public void setWebviewStartTime(long l)
    {
        mWebviewLoadStartTime = l;
    }

    protected View setupCustomizedActionbar(ViewAnimator viewanimator)
    {
        if (mWebHomeBar == null)
        {
            mWebHomeBar = (MShopWebHomeBar)View.inflate(this, com.amazon.mShop.android.lib.R.layout.web_home_bar, null);
        }
        return ActionBarHelper.applyWebGatewayCustomizedActionBar(this, viewanimator, mWebHomeBar);
    }

    public void userSignedIn(User user)
    {
        long l = System.currentTimeMillis();
        if (DEBUG)
        {
            Log.d("WebGatewayActivity", (new StringBuilder()).append("Invoke userSignedIn, current time is ").append(l).toString());
        }
        if (mSignInFromHtmlGatewayPage)
        {
            mSignInFromHtmlGatewayPage = false;
            lastUserSigninInTimeMillis = l;
        } else
        if (l - lastUserSigninInTimeMillis > HomeController.getUserSignInPeriod())
        {
            lastUserSigninInTimeMillis = l;
            if (DEBUG)
            {
                Log.d("WebGatewayActivity", (new StringBuilder()).append("refresh gateway when userSignedIn, and the time stamp is ").append(l).toString());
            }
            refresh();
            getWebViewContainer().showSpinner();
            return;
        }
    }

    public void userSignedOut()
    {
        lastUserSigninInTimeMillis = 0L;
    }

    public void userUpdated(User user)
    {
    }

}
