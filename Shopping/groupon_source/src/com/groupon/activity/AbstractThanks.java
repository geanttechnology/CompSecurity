// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.abtest.WidgetOnThankYouIntlAbTestHelper;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.loader.ThanksDealListLoaderCallbacks;
import com.groupon.loader.WidgetsForThankYouLoaderCallbacks;
import com.groupon.manager.ThanksSyncManager;
import com.groupon.manager.WidgetOnThankYouSyncManager;
import com.groupon.models.MultiItemOrder;
import com.groupon.models.MultiItemOrderItem;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.nst.ThankYouScreenExtraInfo;
import com.groupon.service.LocationService;
import com.groupon.service.OrdersService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.DealCardMultiColumnListAdapter;
import com.groupon.util.Function1;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;
import com.groupon.util.PendingAdapterWrapper;
import com.groupon.view.DealSetCallbacks;
import com.groupon.view.dealcards.DefaultLargeDealCard;
import commonlib.adapter.JavaAdapter;
import commonlib.adapter.JavaListAdapter;
import java.util.ArrayList;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponListActivity, IntentFactory

public abstract class AbstractThanks extends GrouponListActivity
    implements CustomPageViewEvent, DealSetCallbacks, commonlib.manager.SyncManager.SyncUiCallbacks
{
    protected class LoadMultiItemOrder
        implements Function1
    {

        final AbstractThanks this$0;

        public void execute(MultiItemOrder multiitemorder)
        {
            if (multiitemorder != null && !multiitemorder.items.isEmpty())
            {
                multiitemorder = ((MultiItemOrderItem)multiitemorder.items.get(0)).legacyOrderId;
                if (Strings.notEmpty(multiitemorder))
                {
                    refreshDealList(multiitemorder);
                }
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((MultiItemOrder)obj);
        }

        protected LoadMultiItemOrder()
        {
            this$0 = AbstractThanks.this;
            super();
        }
    }


    public static final String CAB_SLOT = "CABSlot";
    public static final String CAV_SLOT = "CAVSlot";
    private static final int THANK_YOU_DEALS_LOADER_ID = 2;
    public static final String THANK_YOU_SLOT = "ThankYouSlot";
    private static final int WIDGETS_LOADER_ID = 1;
    public static final String WIDGET_TYPE_CAB = "MegamindCustomersAlsoBought";
    public static final String WIDGET_TYPE_CAV = "MegamindCustomersAlsoViewedMobile";
    public static final String WIDGET_TYPE_RV = "MegamindWatsonRecentlyViewedDeals_Android";
    public static final String WIDGET_TYPE_RV_NO_SEE_MORE = "MegamindRecentlyViewedDeals_PF_NoSeeMore_android";
    protected AbTestService abTestService;
    private BuyUtils buyUtil;
    Channel channel;
    private CurrentCountryManager currentCountryManager;
    protected Lazy currentDivisionManager;
    protected Deal deal;
    String dealId;
    boolean hidePurchasedDealInfo;
    private IntentFactory intentFactory;
    protected boolean isMegamindOnThankYouScreenEnabled;
    protected boolean isUSACompatible;
    private LocationService locationService;
    protected Logger logger;
    protected LoggingUtils loggingUtils;
    String multiItemOrderId;
    String orderId;
    private OrdersService ordersService;
    private PendingAdapterWrapper pendingAdapterWrapper;
    private FilterableWidgetListAdapter rvdCabCavWidgetListAdapter;
    private ThanksSyncManager thanksSyncManager;
    protected WidgetOnThankYouIntlAbTestHelper widgetOnThankYouIntlAbTestHelper;
    private WidgetOnThankYouSyncManager widgetSyncManager;

    public AbstractThanks()
    {
        channel = Channel.UNKNOWN;
        currentDivisionManager = new Lazy(this) {

            final AbstractThanks this$0;

            
            {
                this$0 = AbstractThanks.this;
                super(context);
            }
        };
    }

    private View getDealCardView(View view, DealSummary dealsummary, List list)
    {
        if (view != null && (view instanceof DefaultLargeDealCard))
        {
            view = (DefaultLargeDealCard)view;
        } else
        {
            view = new DefaultLargeDealCard(this);
        }
        view.setInfoWithPlaces(dealsummary, list);
        return view;
    }

    private void navigateToCarousel()
    {
        Intent intent = intentFactory.newCarouselChannelIntent(getNavigateToChannelName(), new String[0]);
        intent.addFlags(0x4000000);
        startActivity(intent);
    }

    private void refreshDealList(String s)
    {
        JavaListAdapter javalistadapter = new JavaListAdapter() {

            final AbstractThanks this$0;

            public long getItemId(int i)
            {
                return (long)getItem(i).hashCode();
            }

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                return getCardView(this, i, view);
            }

            public boolean isEmpty()
            {
                return false;
            }

            
            {
                this$0 = AbstractThanks.this;
                super();
            }
        };
        javalistadapter.setList(new ArrayList(), true);
        pendingAdapterWrapper = new PendingAdapterWrapper(javalistadapter);
        setListAdapter(new DealCardMultiColumnListAdapter(pendingAdapterWrapper, 1) {

            final AbstractThanks this$0;

            public void onDealCardClicked(int i, View view, DealSummary dealsummary)
            {
                startActivity(getDealIntent(dealsummary));
            }

            
            {
                this$0 = AbstractThanks.this;
                super(listadapter, i);
            }
        });
        if (Strings.notEmpty(s) && isUSACompatible)
        {
            getLoaderManager().initLoader(2, null, new ThanksDealListLoaderCallbacks(this, javalistadapter, pendingAdapterWrapper) {

                final AbstractThanks this$0;

                public volatile void onLoadFinished(Loader loader, Object obj)
                {
                    onLoadFinished(loader, (List)obj);
                }

                public void onLoadFinished(Loader loader, List list)
                {
                    super.onLoadFinished(loader, list);
                    afterDealListLoaded(list);
                }

            
            {
                this$0 = AbstractThanks.this;
                super(context, javaadapter, pendingadapterwrapper);
            }
            });
            thanksSyncManager.setChannelId(Channel.POST_PURCHASE.name());
            thanksSyncManager.setOrderId(s);
            thanksSyncManager.requestSync(this, null);
            return;
        } else
        {
            pendingAdapterWrapper.enableAppending(false);
            return;
        }
    }

    protected void afterDealListLoaded(List list)
    {
    }

    protected void afterDealLoaded(Deal deal1)
    {
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        pendingAdapterWrapper.enableAppending(flag);
    }

    protected View getCardView(ListAdapter listadapter, int i, View view)
    {
        return getDealCardView(view, (DealSummary)listadapter.getItem(i), null);
    }

    protected Intent getDealIntent(DealSummary dealsummary)
    {
        if (buyUtil.showOptionsWithImages(dealsummary, this))
        {
            int i;
            boolean flag;
            if (!currentCountryManager.getCurrentCountry().isJapan())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = dealsummary.optionDimensionsCount(flag, isUSACompatible);
            return intentFactory.newGoodsMultiOptionIntent(dealsummary.remoteId, channel, i);
        } else
        {
            return intentFactory.newDealIntent(dealsummary);
        }
    }

    protected Channel getNavigateToChannelName()
    {
        return Channel.FEATURED;
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        pendingAdapterWrapper.enableAppending(false);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f0803d6));
    }

    protected void initListHeaderView(int i)
    {
        View view = getLayoutInflater().inflate(i, getListView(), false);
        ButterKnife.bind(this, view);
        getListView().addHeaderView(view, null, false);
    }

    protected void initMegamindWidgets()
    {
        if (isMegamindOnThankYouScreenEnabled)
        {
            widgetsOnCreate();
            initWidgetsSyncManager();
        }
    }

    protected void initWidgetsSyncManager()
    {
        String s;
        WidgetsForThankYouLoaderCallbacks widgetsforthankyouloadercallbacks;
        if (deal != null)
        {
            s = deal.uuid;
        } else
        {
            s = "";
        }
        widgetsforthankyouloadercallbacks = new WidgetsForThankYouLoaderCallbacks(this, rvdCabCavWidgetListAdapter, s, pendingAdapterWrapper);
        getLoaderManager().initLoader(1, null, widgetsforthankyouloadercallbacks);
        widgetSyncManager.setDealUuid(s);
        widgetSyncManager.requestSync(this, null);
    }

    protected void loadDeal(String s)
    {
        getLoaderManager().initLoader(0, null, new DealLoaderCallbacks(this, s) {

            final AbstractThanks this$0;

            public void onDealLoaded(Deal deal1)
            {
                deal = deal1;
                afterDealLoaded(deal1);
                initMegamindWidgets();
            }

            
            {
                this$0 = AbstractThanks.this;
                super(context, s);
            }
        });
    }

    protected void loadDealBankDeals()
    {
        if (multiItemOrderId != null)
        {
            ordersService.getMultiItemOrder(multiItemOrderId, new LoadMultiItemOrder(), null, null);
            return;
        } else
        {
            refreshDealList(orderId);
            return;
        }
    }

    public void logPageViewEvent()
    {
        loggingUtils.logPageView(channel.toString(), getClass().getSimpleName(), new ThankYouScreenExtraInfo(dealId, null, null));
    }

    public void onBackPressed()
    {
        navigateToCarousel();
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isUSACompatible = currentCountryManager.getCurrentCountry().isUSACompatible();
        boolean flag;
        if (isUSACompatible || widgetOnThankYouIntlAbTestHelper.isMegamindOnThankYouScreenEnabledINTL())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isMegamindOnThankYouScreenEnabled = flag;
    }

    public void onMemberClick(View view, DealSummary dealsummary)
    {
        loggingUtils.logThankYouWidgetDealClick(dealsummary, channel.toString(), getClass().getSimpleName());
        startActivity(getDealIntent(dealsummary));
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            navigateToCarousel();
            break;
        }
        return true;
    }

    public void onSubsetClick(WidgetSummary widgetsummary)
    {
        String s;
        String s1;
        byte byte0;
        s = null;
        s1 = widgetsummary.type;
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 3: default 48
    //                   -1723349181: 130
    //                   -1653375329: 115
    //                   942990366: 145;
           goto _L1 _L2 _L3 _L4
_L1:
        byte0;
        JVM INSTR tableswitch 0 2: default 76
    //                   0 160
    //                   1 167
    //                   2 173;
           goto _L5 _L6 _L7 _L8
_L5:
        loggingUtils.logThankYouDealSubsetClick(widgetsummary, channel.toString(), getClass().getSimpleName());
        startActivity(intentFactory.newDealSubsetIntent(widgetsummary, Channel.POST_PURCHASE, s));
        return;
_L3:
        if (s1.equals("MegamindWatsonRecentlyViewedDeals_Android"))
        {
            byte0 = 0;
        }
          goto _L1
_L2:
        if (s1.equals("MegamindCustomersAlsoBought"))
        {
            byte0 = 1;
        }
          goto _L1
_L4:
        if (s1.equals("MegamindCustomersAlsoViewedMobile"))
        {
            byte0 = 2;
        }
          goto _L1
_L6:
        s = "topSlot";
          goto _L5
_L7:
        s = "CABSlot";
          goto _L5
_L8:
        s = "CAVSlot";
          goto _L5
    }

    protected void widgetsOnCreate()
    {
        Object obj = null;
        if (locationService.isAGpsProviderEnabled())
        {
            obj = locationService.getLocation();
            if (obj != null)
            {
                obj = new GeoPoint((int)(((Location) (obj)).getLatitude() * 1000000D), (int)(((Location) (obj)).getLongitude() * 1000000D));
            } else
            {
                obj = ((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision().geoPoint;
            }
        }
        if (rvdCabCavWidgetListAdapter == null)
        {
            rvdCabCavWidgetListAdapter = new FilterableWidgetListAdapter(this, this, null, ((GeoPoint) (obj)), loggingUtils, "INVALID_KEYSTRING", Channel.POST_PURCHASE, new String[] {
                "ThankYouSlot"
            });
            rvdCabCavWidgetListAdapter.setWidgetsAdapterOnThankYouScreen(true);
            rvdCabCavWidgetListAdapter.setRequiresRedirectLogging(false);
            rvdCabCavWidgetListAdapter.setPageId(getClass().getSimpleName());
            pendingAdapterWrapper = new PendingAdapterWrapper(rvdCabCavWidgetListAdapter);
            setListAdapter(new DealCardMultiColumnListAdapter(pendingAdapterWrapper, 1) {

                final AbstractThanks this$0;

                public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
                {
                    onMemberClick(view, dealsummary);
                }

            
            {
                this$0 = AbstractThanks.this;
                super(listadapter, i);
            }
            });
        }
    }

}
