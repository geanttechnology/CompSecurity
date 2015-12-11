// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.RefineContentFragment;
import com.ebay.mobile.navigation.NavigationFragment;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            ListingDraftListFragment, ActiveListFragment, SoldListFragment, UnsoldListFragment, 
//            SellListBaseFragment, ScheduledListFragment

public class SellingListActivity extends BaseActivity
    implements com.ebay.mobile.navigation.NavigationFragment.NavigationSelectionListener
{
    public static final class ListType extends Enum
    {

        private static final ListType $VALUES[];
        public static final ListType ACTIVE;
        public static final ListType DRAFT;
        public static final ListType SCHEDULED;
        public static final ListType SOLD;
        public static final ListType UNSOLD;

        public static ListType valueOf(String s)
        {
            return (ListType)Enum.valueOf(com/ebay/mobile/sell/lists/SellingListActivity$ListType, s);
        }

        public static ListType[] values()
        {
            return (ListType[])$VALUES.clone();
        }

        static 
        {
            DRAFT = new ListType("DRAFT", 0);
            ACTIVE = new ListType("ACTIVE", 1);
            SOLD = new ListType("SOLD", 2);
            UNSOLD = new ListType("UNSOLD", 3);
            SCHEDULED = new ListType("SCHEDULED", 4);
            $VALUES = (new ListType[] {
                DRAFT, ACTIVE, SOLD, UNSOLD, SCHEDULED
            });
        }

        private ListType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String ACTIVE_FRAGMENT_TAG = "sell.lists.active";
    private static final String DRAFTS_FRAGMENT_TAG = "sell.lists.drafts";
    public static final String FILTER = "filter";
    public static final String LIST_TYPE = "listType";
    private static final String SCHEDULED_FRAGMENT_TAG = "sell.lists.scheduled";
    private static final String SOLD_FRAGMENT_TAG = "sell.lists.sold";
    private static final String UNSOLD_FRAGMENT_TAG = "sell.lists.unsold";
    private ListType currentListType;
    private RefineContentFragment fragment;
    private String startingFilter;

    public SellingListActivity()
    {
    }

    private void addFragment(ListType listtype)
    {
        ListType listtype1;
        listtype1 = listtype;
        if (listtype == null)
        {
            listtype1 = ListType.DRAFT;
        }
        listtype = getFragmentManager();
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType = new int[ListType.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[ListType.DRAFT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[ListType.ACTIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[ListType.SOLD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[ListType.UNSOLD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[ListType.SCHEDULED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.mobile.sell.lists.SellingListActivity.ListType[listtype1.ordinal()];
        JVM INSTR tableswitch 1 5: default 56
    //                   1 107
    //                   2 158
    //                   3 242
    //                   4 326
    //                   5 377;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        fragment = (RefineContentFragment)listtype.findFragmentByTag("sell.lists.drafts");
        if (fragment == null)
        {
            fragment = new ListingDraftListFragment();
            listtype.beginTransaction().add(0x7f1001f3, fragment, "sell.lists.drafts").commit();
        }
_L8:
        return;
_L2:
        fragment = (RefineContentFragment)listtype.findFragmentByTag("sell.lists.drafts");
        if (fragment == null)
        {
            fragment = new ListingDraftListFragment();
            listtype.beginTransaction().add(0x7f1001f3, fragment, "sell.lists.drafts").commit();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        fragment = (RefineContentFragment)listtype.findFragmentByTag("sell.lists.active");
        if (fragment == null)
        {
            fragment = new ActiveListFragment();
            if (startingFilter != null)
            {
                Bundle bundle = new Bundle();
                bundle.putString("filter", startingFilter);
                fragment.setArguments(bundle);
            }
            listtype.beginTransaction().add(0x7f1001f3, fragment, "sell.lists.active").commit();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        fragment = (RefineContentFragment)listtype.findFragmentByTag("sell.lists.sold");
        if (fragment == null)
        {
            fragment = new SoldListFragment();
            if (startingFilter != null)
            {
                Bundle bundle1 = new Bundle();
                bundle1.putString("filter", startingFilter);
                fragment.setArguments(bundle1);
            }
            listtype.beginTransaction().add(0x7f1001f3, fragment, "sell.lists.sold").commit();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        fragment = (RefineContentFragment)listtype.findFragmentByTag("sell.lists.unsold");
        if (fragment == null)
        {
            fragment = new UnsoldListFragment();
            listtype.beginTransaction().add(0x7f1001f3, fragment, "sell.lists.unsold").commit();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        fragment = (SellListBaseFragment)listtype.findFragmentByTag("sell.lists.scheduled");
        if (fragment == null)
        {
            fragment = new ScheduledListFragment();
            listtype.beginTransaction().add(0x7f1001f3, fragment, "sell.lists.scheduled").commit();
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static Intent getRefinedActiveIntent(Context context, String s)
    {
        context = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
        context.putExtra("listType", ListType.ACTIVE);
        if (Arrays.asList(SellingListRefinement.SupportedMyEbayActiveFilters).contains(s))
        {
            context.putExtra("filter", s);
        }
        return context;
    }

    public static Intent getRefinedSoldIntent(Context context, String s)
    {
        context = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
        context.putExtra("listType", ListType.ACTIVE);
        if (Arrays.asList(SellingListRefinement.SupportedMyEbaySoldFilters).contains(s))
        {
            context.putExtra("filter", s);
        }
        return context;
    }

    public static void setSellingInvalid(EbayContext ebaycontext)
    {
        ebaycontext = (MyEbaySellingDataManager)DataManager.getIfExists(ebaycontext, new com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager.KeyParams(MyApp.getPrefs().getCurrentUser()));
        if (ebaycontext != null)
        {
            ebaycontext.invalidateSellLists();
        }
    }

    public String getTrackingEventName()
    {
        if (fragment != null && (fragment instanceof TrackingSupport))
        {
            return ((TrackingSupport)fragment).getTrackingEventName();
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
        } else
        if (i == 65 && j == -1)
        {
            addFragment(currentListType);
            return;
        }
    }

    public void onBackPressed()
    {
        if (fragment.isInEditMode())
        {
            fragment.onHardwareBackWhileEditing();
            return;
        }
        if (fragment.isRefinePanelOpen())
        {
            fragment.closeRefinePanel();
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
        setContentView(0x7f030229);
        Intent intent = getIntent();
        if (bundle == null)
        {
            int i = intent.getIntExtra("noti_sys_id", -1);
            if (i != -1)
            {
                ((NotificationManager)getSystemService("notification")).cancel(i);
                intent.removeExtra("noti_sys_id");
            }
            bundle = intent.getStringExtra("event_type");
            if (!TextUtils.isEmpty(bundle))
            {
                ServiceStarter.startUpdateNotificationCacheService(this, bundle, null);
            }
        }
        bundle = intent.getExtras();
        if (bundle != null)
        {
            startingFilter = bundle.getString("filter");
            currentListType = (ListType)bundle.getSerializable("listType");
        } else
        {
            currentListType = ListType.DRAFT;
        }
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn("MyEbaySellingList", this), 65);
        } else
        {
            addFragment(currentListType);
        }
        bundle = (NavigationFragment)getFragmentManager().findFragmentById(0x7f100175);
        if (bundle != null)
        {
            bundle.setNavigationSelectionListener(this);
        }
    }

    public void onNavigationSelected(int i)
    {
        if (fragment != null)
        {
            fragment.onLeavingViaNavigation();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (!TextUtils.isEmpty(getTrackingEventName()))
        {
            Intent intent = getIntent();
            TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
            NotificationTrackingUtil.addNotificationTracking(this, trackingdata, intent, intent.getStringExtra("event_type"));
            intent.removeExtra("noti_type_id");
            trackingdata.addSourceIdentification(intent);
            if (fragment != null && (fragment instanceof SellListBaseFragment))
            {
                ((SellListBaseFragment)fragment).addFilterTracking(trackingdata);
            }
            trackingdata.send(this);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putSerializable("listType", currentListType);
        bundle.putSerializable("filter", startingFilter);
        super.onSaveInstanceState(bundle);
    }
}
