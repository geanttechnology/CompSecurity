// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ViewAnimator;
import com.amazon.device.crashmanager.CrashDetectionHelper;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.TimeChangedReceiver;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.MShopDiskCachePolicy;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.share.SharableAppInfoManager;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.ExitConfirmationDialogHelper;
import com.amazon.mShop.util.ShortcutUtil;
import com.amazon.mShop.util.UpgradeUtil;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.home:
//            HomeView, GatewayWeblabUtil

public class GatewayActivity extends AmazonActivity
{

    private HomeView mHomeView;
    private boolean mJustCreated;
    private boolean mLaunchSignInPrompt;
    private boolean mNeedFetchMenusFromServer;
    private TimeChangedReceiver mTimeChangedReceiver;

    public GatewayActivity()
    {
        mLaunchSignInPrompt = false;
        mNeedFetchMenusFromServer = false;
        mJustCreated = false;
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

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
_L2:
        return true;
        if (isPushAnimationInProgress() || menuDispatchedKeyEvent(keyevent)) goto _L2; else goto _L1
_L1:
        if (4 != keyevent.getKeyCode() || keyevent.getAction() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        View view = getCurrentView();
        if (view != null && view.dispatchKeyEvent(keyevent))
        {
            continue; /* Loop/switch isn't completed */
        }
        if ((view instanceof HomeView) && ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_hasExitApp))
        {
            ExitConfirmationDialogHelper.create(this, "hm_exit_ok", "hm_exit_cancel").show();
            return true;
        }
        if (!popView(false))
        {
            break; /* Loop/switch isn't completed */
        }
        keyevent = getCurrentView();
        if (keyevent instanceof HomeView)
        {
            ((HomeView)keyevent).postHomePageImpression();
            return true;
        }
        if (true) goto _L2; else goto _L3
_L3:
        return super.dispatchKeyEvent(keyevent);
    }

    protected void handleForceSignIn()
    {
        mLaunchSignInPrompt = SSOUtil.needSigninPrompt();
    }

    protected void insertErrorBox(View view)
    {
        if (mHomeView == getCurrentView())
        {
            mHomeView.insertErrorBox(view);
            return;
        } else
        {
            super.insertErrorBox(view);
            return;
        }
    }

    public boolean isHomeActivityJustCreated()
    {
        return mJustCreated;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        mLaunchSignInPrompt = false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mJustCreated = true;
        boolean flag = getIntent().getBooleanExtra("INTENT_EXTRA_STARTED_NO_NEED_COUNT_APPSTART", false);
        HomeController.getInstance().setNoNeedCountAppStart(flag);
        setStopBehavior(0);
        mTimeChangedReceiver = new TimeChangedReceiver();
        registerReceiver(mTimeChangedReceiver, TimeChangedReceiver.INTENT_FILTER);
        MShopDiskCachePolicy.populateCachedFiles();
    }

    public void onDestroy()
    {
        super.onDestroy();
        mHomeView.destroy();
        unregisterReceiver(mTimeChangedReceiver);
        mTimeChangedReceiver = null;
        User.removeUserListener(HomeController.getInstance());
        HomeController.setInstance(null);
        if (isNeedRestart())
        {
            setNeedRestart(false);
            AppUtils.launchApp(this);
        }
    }

    public void onEulaAccepted()
    {
        new com.amazon.mShop.AmazonActivity.DelayedInitializer(this, (HomeView)getCurrentView(), true);
    }

    protected void onNewIntent(Intent intent)
    {
        String s = intent.getStringExtra("newIntentOrigin");
        View view = getViewAnimator().getChildAt(0);
        if ("home".equals(s) && (view instanceof HomeView) && getViewAnimator().getChildCount() > 1)
        {
            ((HomeView)view).postHomePageImpression();
        }
        if (view instanceof HomeView)
        {
            ((HomeView)view).scollToTop();
        }
        super.onNewIntent(intent);
    }

    protected void onResume()
    {
        com.amazon.mShop.feature.Features.FeatureStateChangeType featurestatechangetype;
        super.onResume();
        featurestatechangetype = GatewayWeblabUtil.getInstance().updateGatewayWeblabState();
        if (!(getCurrentView() instanceof HomeView) || com.amazon.mShop.feature.Features.FeatureStateChangeType.NO_CHANGE == featurestatechangetype || mLaunchSignInPrompt || SSOUtil.needSigninPrompt()) goto _L2; else goto _L1
_L1:
        if (com.amazon.mShop.feature.Features.FeatureStateChangeType.TREATMENT_CHANGE != featurestatechangetype) goto _L4; else goto _L3
_L3:
        ActivityUtils.reloadHomeActivity(this);
_L6:
        if (mNeedFetchMenusFromServer && CrashDetectionHelper.getInstance() != null)
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
        if (!mLaunchSignInPrompt || User.isLoggedIn() || !ActivityUtils.isSignInPrompt())
        {
            checkAndShowShortcutInstallDialog();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onSearchRequested()
    {
        if (mLaunchSignInPrompt)
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
        removeTemporaryBlankView();
        Object obj = AndroidPlatform.getInstance().getDataStore();
        if (!mLaunchSignInPrompt && ((DataStore) (obj)).getBoolean("upgradeShouldShowDialog", false) && UpgradeUtil.checkTimeout(((DataStore) (obj)).getLong("upgradeLastDialogTime"), 0x48190800L))
        {
            UpgradeUtil.showUpgradeNotificationDialog(this);
        }
        obj = getCurrentView();
        if (obj == null)
        {
            mNeedFetchMenusFromServer = false;
            mHomeView = (HomeView)View.inflate(this, com.amazon.mShop.android.lib.R.layout.home_v2, null);
            setRootView(mHomeView);
        } else
        if (obj instanceof HomeView)
        {
            mNeedFetchMenusFromServer = true;
            mHomeView = (HomeView)obj;
            new com.amazon.mShop.AmazonActivity.DelayedInitializer(this, mHomeView, false);
            return;
        }
    }

    public void pushView(View view)
    {
        view.setBackgroundColor(-1);
        super.pushView(view);
    }

    protected void removeErrorBox(View view)
    {
        if (mHomeView == getCurrentView())
        {
            mHomeView.removeErrorBox(view);
            return;
        } else
        {
            super.removeErrorBox(view);
            return;
        }
    }

    public void setHomeActivityJustCreated(boolean flag)
    {
        mJustCreated = flag;
    }

    protected void updateGNOMenuItems()
    {
        GNODrawer gnodrawer = getGNODrawer();
        if (gnodrawer != null)
        {
            gnodrawer.updateMenuItems(mNeedFetchMenusFromServer);
        }
    }
}
