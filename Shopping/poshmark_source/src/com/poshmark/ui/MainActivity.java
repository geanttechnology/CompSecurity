// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.facebook.appevents.AppEventsLogger;
import com.kochava.android.tracker.Feature;
import com.mobileapptracker.MobileAppTracker;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.AppInfo;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.Env;
import com.poshmark.config.EnvConfig;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.models.ActiveUserInfo;
import com.poshmark.data_model.models.BadgeCount;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.PMDisplayedAlerts;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.notifications.SynchronousBroadcastManager;
import com.poshmark.ui.customviews.PMTabBar;
import com.poshmark.ui.customviews.PMTabButton;
import com.poshmark.ui.fragments.ClosetFragment;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.ui.fragments.ListingEditorFragment;
import com.poshmark.ui.fragments.NewFeedFragment;
import com.poshmark.ui.fragments.NewsPageFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.fragments.RootTabFragment;
import com.poshmark.ui.fragments.ShopFragment;
import com.poshmark.ui.fragments.SignInSignUpWallFragment;
import com.poshmark.ui.fragments.UserSettingsFragment;
import com.poshmark.utils.AppInfoCache;
import com.poshmark.utils.DeepLinkLaunchInfo;
import com.poshmark.utils.DeepLinkUtils;
import com.poshmark.utils.DeferredDeepLinkManager;
import com.poshmark.utils.FbDeferredDeepLinkManager;
import com.poshmark.utils.GCMUtils;
import com.poshmark.utils.NMostRecentPushNotifications;
import com.poshmark.utils.ObjectPickupDropOff;
import com.poshmark.utils.PMCrashManagerListener;
import com.poshmark.utils.PoshLearnManager;
import java.util.Stack;
import java.util.UUID;
import net.hockeyapp.android.CrashManager;
import net.singular.sdk.Singular;

// Referenced classes of package com.poshmark.ui:
//            PMContainerActivity

public class MainActivity extends PMContainerActivity
    implements PMNotificationListener
{

    public static final int FEED_TAB_INDEX = 0;
    public static final int NEWS_TAB_INDEX = 3;
    public static final int SHOP_TAB_INDEX = 1;
    public static final UUID SHOP_TAB_SEARCH_FLAG_KEY = ObjectPickupDropOff.getUniqueKey();
    int NEWS_NOTIFICATION;
    int PARTY_NOTIFICATION;
    ActiveUserInfo activeUserInfo;
    boolean bNewListingCompleted;
    RootTabFragment currentActiveRootFragment;
    PMTabButton currentTab;
    int currentTabIndex;
    DeepLinkLaunchInfo delayedDeepLinkLaunchInfo;
    PMTabButton feedtab;
    boolean isActivityBeingPoppedFromPMStack;
    boolean isActivityBeingResurrected;
    private boolean isBacktracking;
    PMTabButton newsTab;
    PMTabButton sellTab;
    com.poshmark.ui.customviews.PMTabBar.PMTabListener sellTabListener;
    PMTabButton shopTab;
    Stack stack;
    PMTabBar tabBar;
    com.poshmark.ui.customviews.PMTabBar.PMTabListener tabListener;
    PMTabButton userTab;

    public MainActivity()
    {
        stack = new Stack();
        PARTY_NOTIFICATION = 0;
        NEWS_NOTIFICATION = 1;
        isActivityBeingResurrected = false;
        isActivityBeingPoppedFromPMStack = false;
        currentActiveRootFragment = null;
        currentTab = null;
        currentTabIndex = -1;
        isBacktracking = false;
        bNewListingCompleted = false;
        delayedDeepLinkLaunchInfo = null;
        tabListener = new com.poshmark.ui.customviews.PMTabBar.PMTabListener() {

            final MainActivity this$0;

            public void onTabSelected(PMTabButton pmtabbutton)
            {
                pmtabbutton.launchFragment(MainActivity.this);
                isBacktracking = false;
                removeVisitedTabFromStack(pmtabbutton);
                currentTab = pmtabbutton;
                pmtabbutton.setSelected(true);
                currentActiveRootFragment = pmtabbutton.getFragment();
            }

            public void onTabUnselected(PMTabButton pmtabbutton)
            {
                pmtabbutton.hideFragment(MainActivity.this);
                pmtabbutton.setSelected(false);
                if (!isBacktracking)
                {
                    pushCurrentTabToStack();
                }
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        };
        sellTabListener = new com.poshmark.ui.customviews.PMTabBar.PMTabListener() {

            final MainActivity this$0;

            public void onTabSelected(PMTabButton pmtabbutton)
            {
                pmtabbutton = new Bundle();
                pmtabbutton.putBoolean("NEW_LISTING", true);
                launchFragment(pmtabbutton, com/poshmark/ui/fragments/ListingEditorFragment, null);
            }

            public void onTabUnselected(PMTabButton pmtabbutton)
            {
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        };
    }

    private void checkForCrashes()
    {
        CrashManager.register(this, "01486de8725142766a044552d92ef77f", new PMCrashManagerListener());
    }

    private void clearAllNotifications()
    {
        ((NotificationManager)PMApplication.getContext().getSystemService("notification")).cancelAll();
        NMostRecentPushNotifications.clearAllSavedPushNotifications();
    }

    private void collapseAllStacks()
    {
        feedtab.collapseFragmentStack();
        newsTab.collapseFragmentStack();
        shopTab.collapseFragmentStack();
        userTab.collapseFragmentStack();
    }

    private void doPostLoginSteps()
    {
        ((PMTabButton)tabBar.findViewById(0x7f0c01fe)).setText((new StringBuilder()).append("@").append(PMApplicationSession.GetPMSession().getUserName()).toString());
        newsTab = (PMTabButton)tabBar.findViewById(0x7f0c01fd);
        Bundle bundle = new Bundle();
        String s = (new StringBuilder()).append("/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/notifications?pageName=NEWS_ROOT").toString();
        bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com").append(s).toString());
        bundle.putBoolean("SHOW_REFRESH", true);
        newsTab.setFragmentToLaunch(com/poshmark/ui/fragments/NewsPageFragment, bundle);
    }

    private void endKochavaSession()
    {
        PMApplication.getKochavaTracker().endSession();
    }

    private void fireBeacons()
    {
        (new Handler()).post(new Runnable() {

            final MainActivity this$0;
            final Context val$context;

            public void run()
            {
                AppEventsLogger.activateApp(context, getResources().getString(0x7f06010b));
            }

            
            {
                this$0 = MainActivity.this;
                context = context1;
                super();
            }
        });
        if (activeUserInfo == null)
        {
            activeUserInfo = new ActiveUserInfo();
            activeUserInfo.type = "direct";
        }
        PMApi.becameActive(null, activeUserInfo);
        if (activeUserInfo.type.equals("push_ntf") || activeUserInfo.type.equals("local_ntf"))
        {
            PMApi.trackPushNotificationClick(activeUserInfo);
        }
        activeUserInfo = null;
    }

    private void handleAppLaunchIntent(Intent intent)
    {
        Object obj = intent.getBundleExtra("NOTIFICATION_BUNDLE");
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (intent.getBooleanExtra("IS_CONSUMED", false)) goto _L4; else goto _L3
_L3:
        int i = ((Bundle) (obj)).getInt("TYPE");
        if (i != PARTY_NOTIFICATION) goto _L6; else goto _L5
_L5:
        activeUserInfo = new ActiveUserInfo();
        activeUserInfo.type = "local_ntf";
        Bundle bundle = ((Bundle) (obj)).getBundle("FRAGMENT_DATA");
        String s1 = bundle.getString("ID");
        activeUserInfo.addLocalNotification(s1);
        if (!PMDisplayedAlerts.isEventAlertDisplayed(s1))
        {
            PMDisplayedAlerts.addEventToDisplayedList(s1);
        }
        PoshLearnManager.getInstance().setDeepLinkLaunchFlag(true);
        launchFragmentInNewActivity(bundle, (Class)((Bundle) (obj)).getSerializable("FRAGMENT"), null);
_L4:
        intent.putExtra("IS_CONSUMED", true);
        setIntent(null);
_L8:
        return;
_L6:
        if (i == NEWS_NOTIFICATION)
        {
            String s = ((Bundle) (obj)).getString("PUSH_MESSAGE");
            String s2 = ((Bundle) (obj)).getString("BADGE");
            obj = ((Bundle) (obj)).getString("PUSH_MESSAGE_TYPE");
            activeUserInfo = new ActiveUserInfo();
            activeUserInfo.type = "push_ntf";
            activeUserInfo.addPushNotification(s, s2, ((String) (obj)));
            if (currentTab != null)
            {
                if (currentTab != newsTab)
                {
                    tabBar.setActiveTab(newsTab);
                }
            } else
            {
                currentTabIndex = 3;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        intent = intent.getData();
        if (intent != null)
        {
            handleDeepLinkLaunch(intent, true);
        } else
        {
            activeUserInfo = new ActiveUserInfo();
            activeUserInfo.type = "direct";
        }
        if (PMApplicationSession.GetPMSession().isLoggedIn()) goto _L8; else goto _L7
_L7:
        FbDeferredDeepLinkManager.INSTANCE.fetchFbDeferredDeepLink();
        return;
        if (true) goto _L4; else goto _L9
_L9:
    }

    private void handleNewsPushNotification(Bundle bundle)
    {
        newsTab.setBadge(BadgeCount.count);
    }

    private void launchDeepLink(DeepLinkLaunchInfo deeplinklaunchinfo)
    {
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            if (deeplinklaunchinfo.switchTabs)
            {
                gotoTab(deeplinklaunchinfo.tab);
            }
            if (deeplinklaunchinfo.fragmentClass != null)
            {
                launchFragmentInNewActivity(deeplinklaunchinfo.bundle, deeplinklaunchinfo.fragmentClass, deeplinklaunchinfo.data);
            }
            return;
        } else
        {
            delayedDeepLinkLaunchInfo = deeplinklaunchinfo;
            return;
        }
    }

    private void registerForEvents()
    {
    }

    private void registerForGCMNotifications()
    {
        GCMUtils gcmutils = new GCMUtils();
        if (gcmutils.checkPlayServices(this))
        {
            gcmutils.registerWithGCM(PMApplication.getContext());
        }
    }

    private Bundle saveResurectionType(Bundle bundle)
    {
        if (bundle != null)
        {
            isActivityBeingResurrected = true;
            isActivityBeingPoppedFromPMStack = bundle.getBoolean("POPPED_FROM_STACK", false);
        } else
        {
            isActivityBeingResurrected = false;
        }
        return null;
    }

    private void setupPMTabs()
    {
        tabBar = (PMTabBar)findViewById(0x7f0c004a);
        feedtab = (PMTabButton)tabBar.findViewById(0x7f0c01fa);
        feedtab.setTabListener(tabListener);
        Bundle bundle = new Bundle();
        if (isActivityBeingResurrected)
        {
            bundle.putBoolean("RESURRECTION", true);
            String s;
            if (isActivityBeingPoppedFromPMStack)
            {
                bundle.putBoolean("FRAGMENT_BEING_POPPED_OFF_STACK", true);
            } else
            {
                bundle.putBoolean("FRAGMENT_BEING_POPPED_OFF_STACK", false);
            }
        } else
        {
            bundle.putBoolean("RESURRECTION", false);
        }
        feedtab.setFragmentToLaunch(com/poshmark/ui/fragments/NewFeedFragment, bundle);
        shopTab = (PMTabButton)tabBar.findViewById(0x7f0c01fb);
        shopTab.setTabListener(tabListener);
        shopTab.setFragmentToLaunch(com/poshmark/ui/fragments/ShopFragment, null);
        sellTab = (PMTabButton)tabBar.findViewById(0x7f0c01fc);
        sellTab.setTabListener(sellTabListener);
        newsTab = (PMTabButton)tabBar.findViewById(0x7f0c01fd);
        newsTab.setTabListener(tabListener);
        bundle = new Bundle();
        s = (new StringBuilder()).append("/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/notifications?pageName=NEWS_ROOT").toString();
        bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com").append(s).toString());
        bundle.putBoolean("SHOW_REFRESH", true);
        newsTab.setFragmentToLaunch(com/poshmark/ui/fragments/NewsPageFragment, bundle);
        newsTab.setBadge(BadgeCount.count);
        userTab = (PMTabButton)tabBar.findViewById(0x7f0c01fe);
        userTab.setText((new StringBuilder()).append("@").append(PMApplicationSession.GetPMSession().getUserName()).toString());
        userTab.setTabListener(tabListener);
        userTab.setFragmentToLaunch(com/poshmark/ui/fragments/UserSettingsFragment, null);
    }

    private void setupUserTrackingSessions()
    {
        if (EnvConfig.ENV != Env.PRODUCTION)
        {
            Singular.initialize(this, true);
        } else
        {
            Singular.initialize(this, false);
        }
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            if (PMApplication.getHasOffersObject() != null)
            {
                PMApplication.getHasOffersObject().setUserId(PMApplicationSession.GetPMSession().getUserId());
            }
            Singular.setCustomUserId(PMApplicationSession.GetPMSession().getUserId());
        }
    }

    private void showPoshLearnScreen()
    {
        if (PMApplicationSession.GetPMSession().isLoggedIn() && PoshLearnManager.getInstance().shouldShowPoshLearnScreen())
        {
            GlobalPartiesController.getGlobalPartiesController().disablePartyAlerts();
            (new AppInfoCache()).setCurrentVersion(AppInfo.getInstance().versionName);
            FragmentManager fragmentmanager = currentTab.getFragment().getFragmentManager();
            PoshLearnManager.getInstance().lauchPoshLearn(fragmentmanager);
        }
    }

    private void startKochavaSession()
    {
        PMApplication.getKochavaTracker().startSession();
    }

    private void transitionTabsToInitialState()
    {
    }

    public RootTabFragment getCurrentRootFragment()
    {
        return currentActiveRootFragment;
    }

    public PMTabButton getTabFromIndex(int i)
    {
        switch (i)
        {
        case 2: // '\002'
        default:
            return null;

        case 0: // '\0'
            return feedtab;

        case 1: // '\001'
            return shopTab;

        case 3: // '\003'
            return newsTab;
        }
    }

    public PMFragment getVisibleFragment()
    {
        return currentActiveRootFragment.getCurrentActiveChildFragment();
    }

    public void gotoFeedTab()
    {
        tabBar.setActiveTab(feedtab);
    }

    public void gotoTab(int i)
    {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 33
    //                   1 56
    //                   2 32
    //                   3 79;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return;
_L2:
        if (currentTab != feedtab)
        {
            tabBar.setActiveTab(feedtab);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (currentTab != shopTab)
        {
            tabBar.setActiveTab(shopTab);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (currentTab != newsTab)
        {
            tabBar.setActiveTab(newsTab);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void handleDeepLinkLaunch(Uri uri, boolean flag)
    {
        if (DeepLinkUtils.isValidDeepLink(uri))
        {
            DeepLinkLaunchInfo deeplinklaunchinfo = DeepLinkUtils.getDeepLinkLaunchInfo(uri);
            if (deeplinklaunchinfo != null)
            {
                if (flag)
                {
                    activeUserInfo = new ActiveUserInfo();
                    activeUserInfo.type = "deep_link";
                    activeUserInfo.addDeepLink(uri.toString());
                }
                PoshLearnManager.getInstance().setDeepLinkLaunchFlag(true);
                launchDeepLink(deeplinklaunchinfo);
            }
        }
    }

    public void handleNotification(Intent intent)
    {
        if (isFinishing())
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (!intent.getAction().equals("com.poshmark.intents.INITIATE_LOGOUT")) goto _L2; else goto _L1
_L1:
        logout();
_L4:
        return;
_L2:
        if (intent.getAction().equals("com.poshmark.intents.PUSH_NOTIFICATION"))
        {
            handleNewsPushNotification(intent.getBundleExtra("RESULT"));
            return;
        }
        if (intent.getAction().equals("com.poshmark.intents.CLEAR_NEWS_BADGE"))
        {
            BadgeCount.resetCount();
            newsTab.clearBadge();
            return;
        }
        if (intent.getAction().equals("com.poshmark.intents.NEW_BADGE_COUNT"))
        {
            newsTab.setBadge(BadgeCount.count);
            return;
        }
        if (!intent.getAction().equals("com.poshmark.intents.SWITCH_TAB")) goto _L4; else goto _L3
_L3:
        intent = intent.getBundleExtra("RESULT");
        if (intent == null) goto _L4; else goto _L5
_L5:
        int i = intent.getInt("TAB_INDEX");
        if (i == 1)
        {
            ObjectPickupDropOff.dropOffDataObject(SHOP_TAB_SEARCH_FLAG_KEY, Boolean.valueOf(true));
            UserStateSummaryController.getGlobalInteractionsController().refreshModels();
            intent = shopTab.getFragment();
            if (intent != null)
            {
                intent.popFragmentsToTop();
            }
        }
        if (isActivityInForeground())
        {
            gotoTab(i);
            return;
        } else
        {
            currentTab = getTabFromIndex(i);
            return;
        }
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
        return;
    }

    public void launchFragment(Bundle bundle, Class class1, Object obj)
    {
        if (class1 != com/poshmark/ui/fragments/ListingDetailsFragment && class1 != com/poshmark/ui/fragments/ListingEditorFragment && class1 != com/poshmark/ui/fragments/ClosetFragment)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj = new Intent(this, com/poshmark/ui/PMContainerActivity);
        ((Intent) (obj)).putExtra("FRAGMENT", class1);
        ((Intent) (obj)).putExtra("FRAGMENT_DATA", bundle);
        if (descendants != null)
        {
            bundle = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(bundle, descendants);
            ((Intent) (obj)).putExtra("SCREENSTACK", new ParcelUuid(bundle));
        }
        if (class1 == com/poshmark/ui/fragments/ListingEditorFragment)
        {
            try
            {
                startActivityForResult(((Intent) (obj)), 101);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_161;
        }
        startActivity(((Intent) (obj)));
        return;
        class1 = (PMFragment)class1.newInstance();
        class1.setArguments(bundle);
        class1.setUserVisibleHint(true);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        class1.setFragmentData(obj);
        class1.setNavigationList(descendants);
        currentActiveRootFragment.startChildFragment(class1);
        return;
    }

    public void launchFragmentForResult(Bundle bundle, Class class1, Object obj, PMFragment pmfragment, int i)
    {
        try
        {
            class1 = (PMFragment)class1.newInstance();
            class1.setTargetFragment(pmfragment, i);
            class1.setArguments(bundle);
            class1.setUserVisibleHint(true);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        class1.setFragmentData(obj);
        class1.setNavigationList(descendants);
        currentActiveRootFragment.startChildFragment(class1);
        return;
    }

    public void launchFragmentInNewActivity(Bundle bundle, Class class1, Object obj)
    {
        super.launchFragmentInNewActivity(bundle, class1, obj);
        isActivityBeingPoppedFromPMStack = true;
    }

    public void logout()
    {
        tabBar.setActiveTab(feedtab);
        collapseAllStacks();
        SynchronousBroadcastManager.getSyncronousBroadcastManager().sendSynchronousBroadcast("com.poshmark.intents.LOGOUT_COMPLETE", null);
        PMNotificationManager.fireNotification("com.poshmark.intents.LOGOUT_COMPLETE");
        ExtServiceConnectManager.getGlobalConnectManager().logout();
        PMApplicationSession.GetPMSession().logout();
        Intent intent = new Intent(this, com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", com/poshmark/ui/fragments/SignInSignUpWallFragment);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 1 && j == 2)
        {
            finish();
        } else
        if (i == 101 && j == 102)
        {
            bNewListingCompleted = true;
            return;
        }
    }

    public void onBackPressed()
    {
label0:
        {
            if (!currentActiveRootFragment.handleBackPressed())
            {
                if (!stack.empty())
                {
                    break label0;
                }
                super.onBackPressed();
            }
            return;
        }
        PMTabButton pmtabbutton = (PMTabButton)stack.pop();
        isBacktracking = true;
        tabBar.setActiveTab(pmtabbutton);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(saveResurectionType(bundle));
        registerForGCMNotifications();
        setupUserTrackingSessions();
        NewRelicWrapper.initNewRelic(getApplication());
        PMApplication.getApplicationObject().setActivity(this);
        setContentView(0x7f030007);
        registerForEvents();
        PMNotificationManager.fireNotification("com.poshmark.intents.APP_STARTED");
        handleAppLaunchIntent(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0b0000, menu);
        return false;
    }

    public void onDestroy()
    {
        super.onDestroy();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
        Analytics.getInstance().onDestroy();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        handleAppLaunchIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131493658 2131493658: default 24
    //                   2131493658 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        ExtServiceConnectManager.getGlobalConnectManager().logout();
        PMApplicationSession.GetPMSession().logout();
        transitionTabsToInitialState();
        PMNotificationManager.fireNotification("com.poshmark.intents.COLLAPSE_ALL_SUBFRAGMENTS");
        Intent intent = new Intent(this, com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", com/poshmark/ui/fragments/SignInSignUpWallFragment);
        startActivityForResult(intent, 1);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unRegisterForEvent("com.poshmark.intents.INITIATE_LOGOUT", this);
        PMNotificationManager.getNotificationManager().unRegisterForEvent("com.poshmark.intents.PUSH_NOTIFICATION", this);
        PMNotificationManager.getNotificationManager().unRegisterForEvent("com.poshmark.intents.CLEAR_NEWS_BADGE", this);
        PMNotificationManager.getNotificationManager().unRegisterForEvent("com.poshmark.intents.NEW_BADGE_COUNT", this);
        PMNotificationManager.getNotificationManager().unRegisterForEvent("com.poshmark.intents.SWITCH_TAB", this);
        Singular.onPause();
    }

    public void onResume()
    {
        super.onResume();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.INITIATE_LOGOUT", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PUSH_NOTIFICATION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.CLEAR_NEWS_BADGE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.NEW_BADGE_COUNT", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.SWITCH_TAB", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
        if (PMApplication.getHasOffersObject() != null)
        {
            PMApplication.getHasOffersObject().measureSession();
        }
        Singular.onResume();
        if (isFinishing()) goto _L2; else goto _L1
_L1:
        fireBeacons();
        clearAllNotifications();
        checkForCrashes();
        setupPMTabs();
        if (currentTab == null) goto _L4; else goto _L3
_L3:
        if (!bNewListingCompleted) goto _L6; else goto _L5
_L5:
        gotoFeedTab();
        currentActiveRootFragment.collapseAllSubfragments();
        PMNotificationManager.fireNotification("com.poshmark.intents.LISTING_CREATED");
_L11:
        bNewListingCompleted = false;
        isActivityBeingPoppedFromPMStack = false;
        if (PMApplicationSession.GetPMSession().isLoggedIn()) goto _L8; else goto _L7
_L7:
        Intent intent = new Intent(this, com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", com/poshmark/ui/fragments/SignInSignUpWallFragment);
        startActivityForResult(intent, 1);
_L2:
        return;
_L6:
        if (tabBar.getActiveTab() != currentTab)
        {
            tabBar.setActiveTab(currentTab);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (currentTabIndex != -1)
        {
            currentTab = getTabFromIndex(currentTabIndex);
            if (tabBar.getActiveTab() != currentTab)
            {
                tabBar.setActiveTab(currentTab);
            }
            currentTabIndex = -1;
        } else
        {
            tabBar.setActiveTab(feedtab);
        }
        continue; /* Loop/switch isn't completed */
_L8:
        FbHelper.getInstance().refreshAndSyncFbTokenState();
        showPoshLearnScreen();
        GlobalPartiesController.getGlobalPartiesController().firePartyAlert(null);
        if (delayedDeepLinkLaunchInfo == null) goto _L2; else goto _L9
_L9:
        launchDeepLink(delayedDeepLinkLaunchInfo);
        delayedDeepLinkLaunchInfo = null;
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("POPPED_FROM_STACK", isActivityBeingPoppedFromPMStack);
    }

    public void onStart()
    {
        super.onStart();
        DeferredDeepLinkManager deferreddeeplinkmanager = DeferredDeepLinkManager.INSTANCE;
        Intent intent = getIntent();
        if (intent != null)
        {
            deferreddeeplinkmanager.init(intent.getData(), this);
        }
    }

    public void popTopFragment()
    {
        currentActiveRootFragment = currentTab.getFragment();
        FragmentManager fragmentmanager = currentActiveRootFragment.getChildFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 1)
        {
            fragmentmanager.popBackStack();
        }
    }

    public void pushCurrentTabToStack()
    {
        if (currentTab != null)
        {
            stack.push(currentTab);
        }
    }

    public void removeVisitedTabFromStack(PMTabButton pmtabbutton)
    {
        if (stack.contains(pmtabbutton))
        {
            stack.remove(pmtabbutton);
        }
    }

    public void replaceFragment(Bundle bundle, Class class1, Object obj)
    {
        try
        {
            class1 = (PMFragment)class1.newInstance();
            class1.setArguments(bundle);
            class1.setUserVisibleHint(true);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        class1.setFragmentData(obj);
        class1.setNavigationList(descendants);
        currentActiveRootFragment.replaceChildFragment(class1);
        return;
    }




/*
    static boolean access$002(MainActivity mainactivity, boolean flag)
    {
        mainactivity.isBacktracking = flag;
        return flag;
    }

*/
}
