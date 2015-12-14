// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.actions.FacebookHelper;
import com.amazon.gallery.framework.gallery.ftue.FixedViewPager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.ftue.FTUEAddPhotosFragment;
import com.amazon.gallery.framework.kindle.ftue.ProtectedDialog;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.AccountDetails;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.AndroidToolbar;
import com.amazon.gallery.thor.app.activity.GalleryNavigationSetting;
import com.amazon.gallery.thor.app.activity.GalleryToolbar;
import com.amazon.gallery.thor.app.activity.ManageStorageActivity;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            MobileScreen, DesktopScreen, FacebookScreen, WelcomeScreen

public class ThorFTUEActivity extends FTUEFragmentActivity
{
    private class AccountDetailsTask extends AsyncTask
    {

        final ThorFTUEActivity this$0;

        protected transient AccountDetails doInBackground(Void avoid[])
        {
            avoid = (AccountDetails)NetworkExecutor.getInstance().execute(
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        private AccountDetailsTask()
        {
            this$0 = ThorFTUEActivity.this;
            super();
        }

    }

    private class LoadingAsyncRunner extends AsyncTask
    {

        private boolean loadEndpoint;
        private boolean loadPromotion;
        private com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache.Promotion promotion;
        final ThorFTUEActivity this$0;

        private void loadEndpoint()
        {
            try
            {
                access$900.getEndpointManager().getEndpoint();
                return;
            }
            catch (TerminalException terminalexception)
            {
                GLogger.ix(ThorFTUEActivity.TAG, "Failed to get endpoint", terminalexception);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (loadEndpoint)
            {
                loadEndpoint();
            }
            if (accountDetails == null)
            {
                loadAccountDetails();
            }
            if (loadPromotion)
            {
                promotion = subscriptionInfo.getPromotion(ThorFTUEActivity.GET_PROMOTION_TIMEOUT);
            }
            return null;
        }

        protected void onCancelled()
        {
            dismissSpinner();
            loadingRunner = null;
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((Void)obj);
        }

        protected void onCancelled(Void void1)
        {
            dismissSpinner();
            loadingRunner = null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            GLogger.d("LoadingEndpointAsyncRunner", "Finished", new Object[0]);
            if (promotion != null)
            {
                void1 = GalleryWebViewHelper.getPromotionIntent(ThorFTUEActivity.this, com/amazon/gallery/thor/app/activity/ManageStorageActivity, promotion);
                startActivityForResult(void1, 975);
                subscriptionInfo.setPromotionCheckOccurredInThisSession(true);
                overridePendingTransition(0x7f040024, 0x7f040024);
            } else
            {
                dismissSpinner();
                makeWelcomeScreenVisible();
            }
            if (welcomeScreen != null)
            {
                welcomeScreen.setHideWelcomeContent(false);
            }
            loadingRunner = null;
        }

        protected void onPreExecute()
        {
            if (loadEndpoint || loadPromotion)
            {
                synchronized (ThorFTUEActivity.this)
                {
                    if (spinnerDialog != null)
                    {
                        spinnerDialog.show();
                    }
                }
                return;
            } else
            {
                return;
            }
            exception;
            thorftueactivity;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public LoadingAsyncRunner(boolean flag, boolean flag1)
        {
            this$0 = ThorFTUEActivity.this;
            super();
            promotion = null;
            loadEndpoint = flag;
            loadPromotion = flag1;
        }
    }


    private static final long GET_PROMOTION_TIMEOUT;
    private static final String TAG = com/amazon/gallery/thor/ftue/ThorFTUEActivity.getName();
    private AccountDetails accountDetails;
    private Toolbar appBar;
    private AuthenticationManager authenticationManager;
    private FacebookHelper facebookHelper;
    private FacebookScreen facebookScreen;
    private LoadingAsyncRunner loadingRunner;
    private MobileScreen mobileScreen;
    private NavigationPaneController navController;
    private PhotosNavigationPane navPane;
    private Dialog spinnerDialog;
    private SubscriptionInfoCache subscriptionInfo;
    private WelcomeScreen welcomeScreen;

    public ThorFTUEActivity()
    {
    }

    private void dismissSpinner()
    {
        this;
        JVM INSTR monitorenter ;
        if (spinnerDialog != null && spinnerDialog.isShowing())
        {
            spinnerDialog.dismiss();
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        GLogger.d(TAG, "activity no longer around when trying to dismiss popup", new Object[0]);
          goto _L1
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private void getFacebookPhotos()
    {
        this;
        JVM INSTR monitorenter ;
        if (facebookScreen != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        facebookHelper.isLinkedToFacebook(this, new com.amazon.gallery.framework.gallery.actions.FacebookHelper.LinkDetectCallback() {

            final ThorFTUEActivity this$0;

            public void onResult(boolean flag)
            {
                if (flag)
                {
                    facebookScreen.importFromFacebookHelper();
                    return;
                } else
                {
                    facebookScreen.enableButtons();
                    return;
                }
            }

            
            {
                this$0 = ThorFTUEActivity.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void loadAccountDetails()
    {
        this;
        JVM INSTR monitorenter ;
        if (accountDetails != null) goto _L2; else goto _L1
_L1:
        SharedPreferences sharedpreferences;
        boolean flag;
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
        flag = sharedpreferences.contains("cached_account_details");
        if (!flag) goto _L2; else goto _L3
_L3:
        accountDetails = new AccountDetails(new JSONObject(sharedpreferences.getString("cached_account_details", "")));
_L4:
        notifyAccountDetailsListeners(accountDetails);
_L2:
        if (endpoint != null)
        {
            (new AccountDetailsTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        GLogger.wx(TAG, "error parsing cached account details", ((Throwable) (obj)));
          goto _L4
        obj;
        throw obj;
    }

    private void loadEndpoint()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = authenticationManager.hasActiveAccount();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        runOnUiThread(new Runnable() );
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void makeWelcomeScreenVisible()
    {
        View view = findViewById(0x7f0c016e);
        if (view != null)
        {
            view.setVisibility(0);
        }
    }

    private void setupNavPane(PhotosNavigationPane photosnavigationpane)
    {
        if (!isAddPhotosMode())
        {
            photosnavigationpane.setSideBarEnabled(false);
        }
    }

    private boolean shouldHideWelcomeContent()
    {
        return networkConnectivity.getConnectionStatus() != com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.ConnectionStatus.NONE && authenticationManager.hasActiveAccount() && (endpoint == null || !subscriptionInfo.getPromotionCheckOccurredInThisSession());
    }

    public List addFragments()
    {
        ArrayList arraylist = new ArrayList();
        if (!isAddPhotosMode()) goto _L2; else goto _L1
_L1:
        FTUEAddPhotosFragment ftueaddphotosfragment = new FTUEAddPhotosFragment();
        arraylist.add(ftueaddphotosfragment);
        accountDetailsListeners.add(ftueaddphotosfragment);
_L4:
        if (((DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE)).isTablet())
        {
            if (mobileScreen == null)
            {
                mobileScreen = new MobileScreen();
            }
            orderedFragments.add(com.amazon.gallery.framework.kindle.ftue.FTUEAddPhotosFragment.OrderedFragments.MOBILE);
            MobileScreen mobilescreen = new MobileScreen();
            arraylist.add(mobilescreen);
            contactInfoListeners.add(mobilescreen);
            accountDetailsListeners.add(mobilescreen);
        }
        if (!BuildFlavors.isAosp())
        {
            orderedFragments.add(com.amazon.gallery.framework.kindle.ftue.FTUEAddPhotosFragment.OrderedFragments.DESKTOP);
            DesktopScreen desktopscreen = new DesktopScreen();
            arraylist.add(desktopscreen);
            contactInfoListeners.add(desktopscreen);
            accountDetailsListeners.add(desktopscreen);
        }
        if (facebookScreen == null)
        {
            facebookScreen = new FacebookScreen();
        }
        if (!BuildFlavors.isAosp() && (endpoint == null || endpoint.getMarketplace() != com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.CHINA))
        {
            orderedFragments.add(com.amazon.gallery.framework.kindle.ftue.FTUEAddPhotosFragment.OrderedFragments.FACEBOOK);
            arraylist.add(facebookScreen);
            accountDetailsListeners.add(facebookScreen);
        }
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Fragment fragment = (Fragment)iterator.next();
            if (fragment.getArguments() == null)
            {
                fragment.setArguments(new Bundle());
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        if (!BuildFlavors.isAosp())
        {
            welcomeScreen = new WelcomeScreen();
            if (shouldHideWelcomeContent())
            {
                welcomeScreen.setHideWelcomeContent(true);
            }
            arraylist.add(welcomeScreen);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return arraylist;
    }

    protected void clearAccountDetails()
    {
        PreferenceManager.getDefaultSharedPreferences(this).edit().remove("cached_account_details").apply();
        clearAccountDetails();
    }

    public void onAccountRegistered()
    {
        onAccountRegistered();
        loadEndpoint();
        loadAccountDetails();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        onActivityResult(i, j, intent);
        i;
        JVM INSTR lookupswitch 4: default 52
    //                   33: 97
    //                   34: 97
    //                   974: 53
    //                   975: 68;
           goto _L1 _L2 _L2 _L3 _L4
_L1:
        return;
_L3:
        this;
        JVM INSTR monitorenter ;
        returnedFromRegistration = true;
        this;
        JVM INSTR monitorexit ;
        return;
        intent;
        this;
        JVM INSTR monitorexit ;
        throw intent;
_L4:
        makeWelcomeScreenVisible();
        if (viewPager.getCurrentItem() == 0 && !BuildFlavors.isAosp())
        {
            moveToNext();
        }
        dismissSpinner();
        return;
_L2:
        getFacebookPhotos();
        return;
    }

    public void onAttachFragment(Fragment fragment)
    {
        onAttachFragment(fragment);
        if (fragment instanceof FacebookScreen)
        {
            facebookScreen = (FacebookScreen)fragment;
        }
    }

    public void onCreate(Bundle bundle)
    {
        authenticationManager = (AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER);
        onCreate(bundle);
        facebookHelper = (FacebookHelper)getApplicationBean(Keys.FACEBOOK_HELPER);
        subscriptionInfo = (SubscriptionInfoCache)getApplicationBean(Keys.SUBSCRIPTION_INFO_CACHE);
        bundle = (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO);
        TagDao tagdao = (TagDao)getApplicationBean(Keys.TAG_DAO);
        FreeTime freetime = (FreeTime)getApplicationBean(AppKeys.THOR_FREE_TIME);
        navPane = (PhotosNavigationPane)findViewById(0x7f0c014e);
        navController = new NavigationPaneController(this, navPane, tagdao, bundle, (Executor)getApplicationBean(Keys.UI_READY_EXECUTOR));
        setupNavPane(navPane);
        setupActionBar(navPane);
        spinnerDialog = new ProtectedDialog(this);
        spinnerDialog.setCanceledOnTouchOutside(false);
    }

    public void onDestroy()
    {
        onDestroy();
        if (navController != null)
        {
            navController.onDestroy();
        }
    }

    public void onEndpointLoaded(EndpointLoadedEvent endpointloadedevent)
    {
        endpoint = endpointloadedevent.endpoint;
        if (endpoint == null || orderedFragments == null)
        {
            return;
        } else
        {
            runOnUiThread(new Runnable() {

                final ThorFTUEActivity this$0;

                public void run()
                {
                    if (BuildFlavors.isAosp() || 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = ThorFTUEActivity.this;
                super();
            }
            });
            return;
        }
    }

    public void onPause()
    {
        onPause();
        if (navController != null)
        {
            navController.onPause();
        }
        if (FeatureManager.isFeatureEnabled(Features.HEADER_ACTION_BAR))
        {
            GlobalMessagingBus.unregister(this);
        }
    }

    public void onResume()
    {
        onResume();
        if (navController != null)
        {
            navController.onResume();
            navPane.select(0x7f0c026f);
        }
        if (FeatureManager.isFeatureEnabled(Features.HEADER_ACTION_BAR))
        {
            GlobalMessagingBus.register(this);
        }
        loadEndpoint();
        loadAccountDetails();
    }

    public void setupActionBar(final PhotosNavigationPane navPane)
    {
        appBar = (Toolbar)findViewById(0x7f0c0085).findViewById(0x7f0c0086);
        AndroidToolbar androidtoolbar = new AndroidToolbar(this, appBar, navPane);
        if (!isAddPhotosMode())
        {
            appBar.setVisibility(8);
            return;
        } else
        {
            androidtoolbar.setTitle(getString(0x7f0e00ae));
            androidtoolbar.setNavigationSetting(GalleryNavigationSetting.LEFT);
            androidtoolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

                final ThorFTUEActivity this$0;
                final PhotosNavigationPane val$navPane;

                public void onClick(View view)
                {
                    navPane.open();
                }

            
            {
                this$0 = ThorFTUEActivity.this;
                navPane = photosnavigationpane;
                super();
            }
            });
            return;
        }
    }

    protected void showScreenEvent(int i)
    {
        showScreenEvent(i);
        if (i == 0 && isAddPhotosMode())
        {
            appBar.setVisibility(0);
            return;
        } else
        {
            appBar.setVisibility(8);
            return;
        }
    }

    static 
    {
        GET_PROMOTION_TIMEOUT = TimeUnit.SECONDS.toMillis(15L);
    }





/*
    static AccountDetails access$102(ThorFTUEActivity thorftueactivity, AccountDetails accountdetails)
    {
        thorftueactivity.accountDetails = accountdetails;
        return accountdetails;
    }

*/





















/*
    static LoadingAsyncRunner access$602(ThorFTUEActivity thorftueactivity, LoadingAsyncRunner loadingasyncrunner)
    {
        thorftueactivity.loadingRunner = loadingasyncrunner;
        return loadingasyncrunner;
    }

*/



}
