// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.appspeed.AppSpeedShim;
import com.ebay.mobile.connection.myebay.BuyingFragment;
import com.ebay.mobile.connection.myebay.MyEbayBuyingActivity;
import com.ebay.mobile.connection.myebay.MyEbayListFragmentBase;
import com.ebay.mobile.connection.myebay.MyEbayWatchingActivity;
import com.ebay.mobile.connection.myebay.WatchingFragment;
import com.ebay.mobile.navigation.NavigationFragment;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager;
import com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, SignInModalActivity

public class MyEbayLandingActivity extends BaseActivity
    implements com.ebay.mobile.connection.myebay.MyEbayListFragmentBase.BidSourceProvider, com.ebay.mobile.navigation.NavigationFragment.NavigationSelectionListener, com.ebay.mobile.util.ContentSyncManager.ContentSync
{
    public static final class BuyingTarget extends Enum
        implements Target
    {

        private static final BuyingTarget $VALUES[];
        public static final BuyingTarget ALL;
        public static final BuyingTarget BIDS;
        public static final BuyingTarget LOST;
        public static final BuyingTarget OFFERS;
        public static final BuyingTarget WON;
        private final int value;

        public static BuyingTarget valueOf(String s)
        {
            return (BuyingTarget)Enum.valueOf(com/ebay/mobile/activities/MyEbayLandingActivity$BuyingTarget, s);
        }

        public static BuyingTarget[] values()
        {
            return (BuyingTarget[])$VALUES.clone();
        }

        public int getTargetList()
        {
            return value;
        }

        static 
        {
            ALL = new BuyingTarget("ALL", 0, 0);
            BIDS = new BuyingTarget("BIDS", 1, 1);
            OFFERS = new BuyingTarget("OFFERS", 2, 2);
            WON = new BuyingTarget("WON", 3, 3);
            LOST = new BuyingTarget("LOST", 4, 4);
            $VALUES = (new BuyingTarget[] {
                ALL, BIDS, OFFERS, WON, LOST
            });
        }

        private BuyingTarget(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

    private class ErrorHandler
        implements android.view.View.OnClickListener
    {

        private final View buttonOk;
        private final View buttonRetry;
        private final View layout;
        final MyEbayLandingActivity this$0;
        private final TextView viewMessage;

        public void onClick(View view)
        {
            layout.setVisibility(8);
            buttonRetry.setOnClickListener(null);
            buttonOk.setOnClickListener(null);
            if (view.getId() == 0x7f10013f)
            {
                currentFragment.invalidate();
            }
        }

        public void showError(com.ebay.nautilus.kernel.content.ResultStatus.Message message, boolean flag)
        {
            byte byte0 = 8;
            layout.setVisibility(0);
            viewMessage.setText(ResultStatus.getSafeLongMessage(getEbayContext(), message));
            message = buttonRetry;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            message.setVisibility(i);
            message = buttonOk;
            if (flag)
            {
                i = byte0;
            } else
            {
                i = 0;
            }
            message.setVisibility(i);
        }

        public ErrorHandler(View view)
        {
            this$0 = MyEbayLandingActivity.this;
            super();
            layout = view;
            viewMessage = (TextView)view.findViewById(0x7f10013d);
            buttonRetry = view.findViewById(0x7f10013f);
            buttonOk = view.findViewById(0x7f100140);
            buttonRetry.setOnClickListener(this);
            buttonOk.setOnClickListener(this);
        }
    }

    private static interface Target
    {

        public abstract int getTargetList();
    }

    public static final class WatchingTarget extends Enum
        implements Target
    {

        private static final WatchingTarget $VALUES[];
        public static final WatchingTarget ACTIVE;
        public static final WatchingTarget ALL;
        public static final WatchingTarget ENDED;
        private final int value;

        public static WatchingTarget valueOf(String s)
        {
            return (WatchingTarget)Enum.valueOf(com/ebay/mobile/activities/MyEbayLandingActivity$WatchingTarget, s);
        }

        public static WatchingTarget[] values()
        {
            return (WatchingTarget[])$VALUES.clone();
        }

        public int getTargetList()
        {
            return value;
        }

        static 
        {
            ALL = new WatchingTarget("ALL", 0, 0);
            ACTIVE = new WatchingTarget("ACTIVE", 1, 1);
            ENDED = new WatchingTarget("ENDED", 2, 2);
            $VALUES = (new WatchingTarget[] {
                ALL, ACTIVE, ENDED
            });
        }

        private WatchingTarget(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    private static final String BUYING_LANDING_PAGE = "my_ebay_buying";
    private static final String EXTRA_LANDING_TYPE = "page_type";
    private static final String WATCHING_LANDING_PAGE = "my_ebay_watching";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag;
    private String bidSource;
    protected MyEbayListFragmentBase currentFragment;
    private View errorLayout;
    private String pageType;
    private final EbayTimer timer = new EbayTimer(1000L);

    public MyEbayLandingActivity()
    {
    }

    public static void deleteUserPreferences()
    {
        Preferences preferences = MyApp.getPrefs();
        preferences.removeUserPref("LASTLIST_WATCHING");
        preferences.removeUserPref("LAST_REFRESH_WATCHING");
        preferences.removeUserPref("LASTLIST_BUYING");
        preferences.removeUserPref("LAST_REFRESH_BUYING");
    }

    public static Intent getBuyingActivityIntent(Context context)
    {
        return getStartActivityIntent(context, "my_ebay_buying", null, com/ebay/mobile/connection/myebay/MyEbayBuyingActivity);
    }

    public static Intent getBuyingActivityIntent(Context context, BuyingTarget buyingtarget)
    {
        return getStartActivityIntent(context, "my_ebay_buying", buyingtarget, com/ebay/mobile/connection/myebay/MyEbayBuyingActivity);
    }

    private static Intent getStartActivityIntent(Context context, String s, Target target, Class class1)
    {
        context = new Intent(context, class1);
        context.putExtra("page_type", s);
        if (target != null)
        {
            context.putExtra("target_list", target.getTargetList());
        }
        return context;
    }

    public static Intent getWatchingActivityIntent(Context context)
    {
        return getStartActivityIntent(context, "my_ebay_watching", null, com/ebay/mobile/connection/myebay/MyEbayWatchingActivity);
    }

    public static Intent getWatchingActivityIntent(Context context, WatchingTarget watchingtarget)
    {
        return getStartActivityIntent(context, "my_ebay_watching", watchingtarget, com/ebay/mobile/connection/myebay/MyEbayWatchingActivity);
    }

    public static void setBuyingInvalid(EbayContext ebaycontext)
    {
        ebaycontext = (MyEbayBuyingDataManager)MyEbayBuyingDataManager.getIfExists(ebaycontext, new com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.KeyParams(MyApp.getPrefs().getCurrentUser()));
        if (ebaycontext != null)
        {
            ebaycontext.forceReloadBidList();
            ebaycontext.forceReloadNotWonList();
            ebaycontext.forceReloadOffersList();
            ebaycontext.forceReloadWonList();
            ebaycontext.invalidateRelatedDataManagers();
            BuyingFragment.setLastRefreshTime(EbayResponse.currentHostTime(), "LAST_REFRESH_BUYING");
            return;
        } else
        {
            BuyingFragment.setLastRefreshTime(1L, "LAST_REFRESH_BUYING");
            return;
        }
    }

    public static void setWatchingInvalid(EbayContext ebaycontext)
    {
        WatchingFragment.setLastRefreshTime(1L, "LAST_REFRESH_WATCHING");
        ebaycontext = (MyEbayWatchingDataManager)MyEbayWatchingDataManager.getIfExists(ebaycontext, new com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.KeyParams(MyApp.getPrefs().getCurrentUser()));
        if (ebaycontext != null)
        {
            ebaycontext.invalidateRelatedDataManagers();
        }
    }

    public String getBidSource()
    {
        return bidSource;
    }

    public String getTrackingEventName()
    {
        if (currentFragment != null)
        {
            return currentFragment.getTrackingEventName();
        } else
        {
            return null;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 65 && j == 0)
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        if (currentFragment.isInEditMode())
        {
            currentFragment.onHardwareBackWhileEditing();
            return;
        }
        if (currentFragment.isRefinePanelOpen())
        {
            currentFragment.closeRefinePanel();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0302a7);
        errorLayout = findViewById(0x7f10013c);
        errorLayout.setVisibility(8);
        errorLayout.setBackgroundColor(-1);
        Intent intent = getIntent();
        int j;
        if (bundle == null)
        {
            pageType = intent.getStringExtra("page_type");
            int i = intent.getIntExtra("noti_sys_id", -1);
            if (i != -1)
            {
                ((NotificationManager)getSystemService("notification")).cancel(i);
            }
            bidSource = intent.getStringExtra("com.ebay.mobile.tracking.BidSource");
            if (!TextUtils.isEmpty(bidSource))
            {
                bundle = intent.getStringExtra("event_type");
                if (bundle != null)
                {
                    ServiceStarter.startUpdateNotificationCacheService(this, bundle, null);
                }
            }
        } else
        {
            bidSource = bundle.getString("com.ebay.mobile.tracking.BidSource");
            pageType = bundle.getString("page_type");
        }
        j = intent.getIntExtra("target_list", -1);
        bundle = getFragmentManager();
        currentFragment = (MyEbayListFragmentBase)bundle.findFragmentByTag(pageType);
        if (currentFragment == null)
        {
            if ("my_ebay_watching".equals(pageType))
            {
                currentFragment = WatchingFragment.newInstance(j);
            } else
            if ("my_ebay_buying".equals(pageType))
            {
                currentFragment = BuyingFragment.newInstance(j);
            } else
            {
                throw new IllegalArgumentException("Page type not supplied in onCreate()");
            }
            bundle.beginTransaction().add(0x7f100911, currentFragment, pageType).commit();
        }
        bundle = (NavigationFragment)bundle.findFragmentById(0x7f100175);
        if (bundle != null)
        {
            bundle.setNavigationSelectionListener(this);
        }
        bundle = (AppSpeedShim)getShim(com/ebay/mobile/appspeed/AppSpeedShim);
        if (bundle != null)
        {
            bundle.init();
        }
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
        }
        ContentSyncManager.register(this, new String[] {
            com/ebay/mobile/Item.getName()
        });
        timer.setOnTimerEvent(currentFragment);
    }

    protected void onDestroy()
    {
        ContentSyncManager.unregister(this, new String[] {
            com/ebay/mobile/Item.getName()
        });
        super.onDestroy();
    }

    public void onNavigationSelected(int i)
    {
        if (currentFragment != null)
        {
            currentFragment.onLeavingViaNavigation();
        }
    }

    protected void onPause()
    {
        timer.stop();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        timer.start();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("com.ebay.mobile.tracking.BidSource", bidSource);
        bundle.putString("page_type", pageType);
    }

    public void showMessage(Fragment fragment, int i, ResultStatus resultstatus)
    {
        fragment = resultstatus.getFirstError();
        if (errorLayout.getVisibility() != 0)
        {
            (new ErrorHandler(errorLayout)).showError(fragment, resultstatus.canRetry());
        }
    }

    public void updateContent(String s, Object obj)
    {
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("updateContent sent, key=").append(s).toString());
        }
        if (com/ebay/mobile/Item.getName().equals(s))
        {
            currentFragment.refreshView((Item)obj);
        }
    }

    static 
    {
        logTag = MyEbayListFragmentBase.logTag;
    }
}
