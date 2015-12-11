// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.appstore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.amazon.logging.Logger;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.categoryBrowse.CategoryMetadata;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.search.ScopedSearch;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mas.bamberg.settings.notifications.NotificationSettings;
import com.amazon.mas.client.authentication.AuthenticationException;
import com.amazon.mas.client.install.foreground.InstallKickoffReceiver;
import com.amazon.venezia.mShop.AppstoreController;
import com.amazon.venezia.web.WebViewFragment;
import java.util.Locale;

// Referenced classes of package com.amazon.mShop.appstore:
//            SnuffyNoConnectionViewAdapterFactory

public class AppstoreActivity extends AmazonActivity
    implements ScopedSearch, com.amazon.venezia.auth.AccountPreparer.AccountPreparationCallbacks
{

    private static final Logger LOG = Logger.getLogger(com/amazon/mShop/appstore/AppstoreActivity);
    private AppstoreController controller;
    private Fragment fragment;
    private InstallKickoffReceiver installReceiver;
    protected boolean upKeyFromAppstore;

    public AppstoreActivity()
    {
        upKeyFromAppstore = false;
    }

    private void addFragmentIfNecessary()
    {
        if (fragment == null)
        {
            fragment = controller.getFragment();
            getSupportFragmentManager().beginTransaction().replace(com.amazon.mShop.android.lib.R.id.appstore_root, fragment).commit();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (1 == keyevent.getAction())
        {
            upKeyFromAppstore = true;
        }
        if (upKeyFromAppstore && SearchActivity.downKeyFromSearch)
        {
            upKeyFromAppstore = false;
            SearchActivity.downKeyFromSearch = false;
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public String getAppstoreName()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_appstore_search_field);
    }

    public CategoryMetadata getCategoryMetadata()
    {
        return new CategoryMetadata(getAppstoreName(), getSearchUrl(), "mobile-apps");
    }

    public int getCurrentDepartmentDepth()
    {
        return 1;
    }

    public String getSearchUrl()
    {
        String s = getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_appstore_browse_node);
        return (new StringBuilder()).append("/s?node=").append(s).append("&ref=").append("mshop_appstore_sr").toString();
    }

    public void onAccountPreparationComplete()
    {
        LOG.i("Account preparation complete");
        addFragmentIfNecessary();
    }

    public void onAccountPreparationError(AuthenticationException authenticationexception)
    {
        LOG.i("Account preparation error");
        if (!isFinishing())
        {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            if (fragmentmanager.findFragmentByTag("AccountPerparationFailureDialogFragment") == null)
            {
                controller.getAccountPreparationFailureDialogFragment(authenticationexception).show(fragmentmanager, "AccountPerparationFailureDialogFragment");
            }
        }
    }

    public void onBackPressed()
    {
        if (!controller.handleBackPressed())
        {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSharedPreferences("mShopLocalePrefs", 0).edit().putString("mShopLocaleValue", AppLocale.getInstance().getCurrentLocale().getCountry()).commit();
        WebViewFragment.setNoConnectionViewAdapterFactory(new SnuffyNoConnectionViewAdapterFactory());
        controller = AppstoreController.getFactory().createController(getIntent(), this, this);
        controller.prepareAccountIfNeeded();
        pushView(com.amazon.mShop.android.lib.R.layout.appstore_activity);
        installReceiver = new InstallKickoffReceiver();
        (new NotificationSettings()).initNotificationSettings(false);
        bundle = getIntent().getStringExtra("com.amazon.venezia.mShop.ASIN");
        if (bundle != null)
        {
            ActivityUtils.logViewHistory(this, bundle);
        }
    }

    public void onInsufficientInfoReceived(Intent intent)
    {
        LOG.i("Insufficient account information");
        authenticateUser(new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

            final AppstoreActivity this$0;

            public void userCancelledSignIn()
            {
                finish();
            }

            public void userSuccessfullySignedIn()
            {
            }

            
            {
                this$0 = AppstoreActivity.this;
                super();
            }
        }, null);
    }

    protected void onNewIntent(Intent intent)
    {
        if (!controller.canHandleIntent(intent))
        {
            intent = new Intent(intent);
            intent.setFlags(intent.getFlags() & 0xdfffffff & 0xfbffffff);
            startActivity(intent);
        } else
        {
            setIntent(intent);
            controller.handleNewIntent(intent);
        }
        getGNODrawer().close();
    }

    protected void onPause()
    {
        super.onPause();
        controller.cancelAccountPreparationIfNeeded();
        installReceiver.unregister(this);
    }

    protected void onResume()
    {
        super.onResume();
        installReceiver.register(this);
        installReceiver.nextInstall(this);
        getGNODrawer().focusOn("mshop:appstore");
        if (!controller.prepareAccountIfNeeded())
        {
            addFragmentIfNecessary();
        }
    }

    public void pushTemporaryBlankView()
    {
    }

}
