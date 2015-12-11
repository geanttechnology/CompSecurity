// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.activity.Carousel;
import com.groupon.activity.IntentFactory;
import com.groupon.animation.ActivityTransitionUtils;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.MarketRateResult;
import com.groupon.fragment.DealCardListLoader;
import com.groupon.fragment.HotelCardListLoader;
import com.groupon.manager.GetawaysSyncManager;
import com.groupon.manager.HotelsCarouselSyncManager;
import com.groupon.models.EndlessList;
import com.groupon.models.country.Country;
import com.groupon.models.nst.ImpressionClickMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.MarketRateDealImpressionExtraInfo;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.CountryUtil;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DealCardListUtils;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.GeoUtils;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LayoutUtil;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.util.ScrollToolBarHelperV3;
import com.groupon.view.UrlImageView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.getaways.carousel:
//            EndlessRecyclerViewAdapter, DealsRecyclerViewAdapter, DealCardViewPresenter, GetawaysWidgetRecyclerViewAdapter, 
//            HotelDealCardViewPresenter, GetawaysRecyclerViewAdapter, EndlessRecyclerViewOnScrollListener

public class GetawaysFragment extends Fragment
{
    private class DealListLoaderCallbacks
        implements android.app.LoaderManager.LoaderCallbacks
    {

        final GetawaysFragment this$0;

        public Loader onCreateLoader(int i, Bundle bundle)
        {
            return new DealCardListLoader(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, getActivity(), "GETAWAYS");
        }

        public volatile void onLoadFinished(Loader loader, Object obj)
        {
            onLoadFinished(loader, (List)obj);
        }

        public void onLoadFinished(Loader loader, List list)
        {
            loader = (EndlessList)list;
            GetawaysFragment getawaysfragment = GetawaysFragment.this;
            boolean flag;
            if (loader.getCurrentOffset() >= 0 && loader.getTotalSize() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            getawaysfragment.canLoadMoreDeals = flag;
            dealsAdapter.setDeals(list, false);
            isRefreshingDeals.set(false);
            endlessAdapter.setProgressViewVisible(false);
            if (!isRefreshingHotels.get())
            {
                swipeRefreshLayout.setRefreshing(false);
            }
        }

        public void onLoaderReset(Loader loader)
        {
            canLoadMoreDeals = true;
            dealsAdapter.setDeals(Collections.emptyList(), false);
        }

        private DealListLoaderCallbacks()
        {
            this$0 = GetawaysFragment.this;
            super();
        }

    }

    private class DealsEndlessRecyclerViewOnScrollListener extends EndlessRecyclerViewOnScrollListener
    {

        final GetawaysFragment this$0;

        public void onLoadMore()
        {
            if (canLoadMoreDeals)
            {
                endlessAdapter.setProgressViewVisible(true);
                dealsSyncManager.requestSyncNextPage(dealsSyncUiCallbacks, null);
            }
        }

        public DealsEndlessRecyclerViewOnScrollListener(android.support.v7.widget.RecyclerView.Adapter adapter1)
        {
            this$0 = GetawaysFragment.this;
            super(adapter1);
            setVisibleThreshold(3);
        }
    }

    private class DealsSyncUiCallbacks
        implements commonlib.manager.SyncManager.SyncUiCallbacks
    {

        final GetawaysFragment this$0;

        public void enableSyncProgressIndicator(boolean flag)
        {
        }

        public void handleSyncError(Runnable runnable, Exception exception)
        {
            if (!isAdded())
            {
                return;
            } else
            {
                LoaderCallbacksUtil.handleSyncError(runnable, exception, getActivity(), (LoginService)loginService.get(), (CountryUtil)countryUtil.get(), currentCountryManager.getCurrentCountry(), dealsSyncManager, (IntentFactory)intentFactory.get(), new Function2() {

                    final DealsSyncUiCallbacks this$1;

                    public volatile void execute(Object obj, Object obj1)
                        throws Exception
                    {
                        execute((Runnable)obj, (Exception)obj1);
                    }

                    public void execute(Runnable runnable, Exception exception)
                    {
                        LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, getActivity(), (DialogManager)dialogManager.get(), dealsSyncManager, null, new Function2() {

                            final DealsSyncUiCallbacks._cls1 this$2;

                            public volatile void execute(Object obj, Object obj1)
                                throws Exception
                            {
                                execute((Runnable)obj, (Exception)obj1);
                            }

                            public void execute(Runnable runnable, Exception exception)
                            {
                                logger.log(exception);
                                canLoadMoreDeals = false;
                                isRefreshingDeals.set(false);
                                endlessAdapter.setProgressViewVisible(false);
                                if (!isRefreshingHotels.get() && swipeRefreshLayout != null)
                                {
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                            }

            
            {
                this$2 = DealsSyncUiCallbacks._cls1.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = DealsSyncUiCallbacks.this;
                super();
            }
                });
                return;
            }
        }

        private DealsSyncUiCallbacks()
        {
            this$0 = GetawaysFragment.this;
            super();
        }

    }

    private class HotelDealListLoaderCallbacks
        implements android.app.LoaderManager.LoaderCallbacks
    {

        final GetawaysFragment this$0;

        public Loader onCreateLoader(int i, Bundle bundle)
        {
            return new HotelCardListLoader(com/groupon/db/models/MarketRateResult, com/groupon/db/events/ChannelUpdateEvent, getActivity(), "HOTELS");
        }

        public volatile void onLoadFinished(Loader loader, Object obj)
        {
            onLoadFinished(loader, (List)obj);
        }

        public void onLoadFinished(Loader loader, List list)
        {
            widgetAdapter.setDeals(list);
            isRefreshingHotels.set(false);
            if (!isRefreshingDeals.get())
            {
                swipeRefreshLayout.setRefreshing(false);
            }
        }

        public void onLoaderReset(Loader loader)
        {
            widgetAdapter.setDeals(Collections.emptyList());
        }

        private HotelDealListLoaderCallbacks()
        {
            this$0 = GetawaysFragment.this;
            super();
        }

    }

    private class OnDealClickListener
        implements android.view.View.OnClickListener
    {

        final GetawaysFragment this$0;

        public void onClick(View view)
        {
            Object obj = (DealsRecyclerViewAdapter.DealCardViewHolder)recyclerView.getChildViewHolder(view);
            int i = adapter.realPositionToDealPosition(((DealsRecyclerViewAdapter.DealCardViewHolder) (obj)).getPosition());
            DealSummary dealsummary = dealsAdapter.getItem(i);
            loggingUtils.logClickWithMetadata("", "impression_click", nstChannel, new ImpressionClickMetadata(dealsummary.remoteId, dealsummary.uuid, i, "deal"));
            if (((BuyUtils)buyUtils.get()).showOptionsWithImages(dealsummary, getActivity()))
            {
                int j;
                boolean flag;
                if (!currentCountryManager.getCurrentCountry().isJapan())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                j = dealsummary.optionDimensionsCount(flag, isUSACompatible);
                startActivity(((IntentFactory)intentFactory.get()).newGoodsMultiOptionIntent(dealsummary.remoteId, channel, j));
                return;
            }
            view = new ArrayList(2);
            view.add(Pair.create(((DealsRecyclerViewAdapter.DealCardViewHolder) (obj)).dealImageView, "deal_image_transition"));
            if (((DealsRecyclerViewAdapter.DealCardViewHolder) (obj)).newSoldOutBannerContainer.getVisibility() == 0)
            {
                view.add(Pair.create(((DealsRecyclerViewAdapter.DealCardViewHolder) (obj)).newSoldOutBannerContainer, "sold_out_banner_transition"));
            }
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                view = ActivityTransitionUtils.getDealToDetailsActivityOptions(getActivity(), (Pair[])view.toArray(new Pair[view.size()]));
            } else
            {
                view = null;
            }
            obj = new com.groupon.util.ViewUtils.Size(((DealsRecyclerViewAdapter.DealCardViewHolder) (obj)).dealImageView.getWidth(), getResources().getDimensionPixelSize(0x7f0b00ca));
            startActivity(((IntentFactory)intentFactory.get()).newDealIntent(dealsummary, dealsummary.getChannel(), ((com.groupon.util.ViewUtils.Size) (obj))), view);
        }

        private OnDealClickListener()
        {
            this$0 = GetawaysFragment.this;
            super();
        }

    }

    private class OnRefreshListener
        implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    {

        final GetawaysFragment this$0;

        public void onRefresh()
        {
            refreshDeals();
            if (isSingleTabWithWidget)
            {
                refreshHotels();
            }
        }

        private OnRefreshListener()
        {
            this$0 = GetawaysFragment.this;
            super();
        }

    }

    private class OnWidgetClickListener
        implements GetawaysWidgetRecyclerViewAdapter.OnWidgetClickListener
    {

        private static final String SEE_ALL_BUTTON_CLICK_TYPE = "Nearby_Tonight_All_Button_Clicked";
        private static final String WIDGET_DEAL_CLICK_TYPE = "Getaways_Nearby_Tonight_Widget_Clicked";
        final GetawaysFragment this$0;

        public void onDealClicked(View view)
        {
            Object obj = (GetawaysWidgetRecyclerViewAdapter.DealCardViewHolder)((GetawaysRecyclerViewAdapter.WidgetViewHolder)recyclerView.findViewHolderForPosition(0)).recyclerView.getChildViewHolder(view);
            MarketRateResult marketrateresult = widgetAdapter.getItem(((GetawaysWidgetRecyclerViewAdapter.DealCardViewHolder) (obj)).getPosition());
            loggingUtils.logClickWithMetadata("", "Getaways_Nearby_Tonight_Widget_Clicked", nstChannel, new MarketRateDealImpressionExtraInfo(marketrateresult.productType));
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                view = ActivityTransitionUtils.getDealToDetailsActivityOptions(getActivity(), ((GetawaysWidgetRecyclerViewAdapter.DealCardViewHolder) (obj)).imageView);
            } else
            {
                view = null;
            }
            obj = new com.groupon.util.ViewUtils.Size(((GetawaysWidgetRecyclerViewAdapter.DealCardViewHolder) (obj)).imageView.getWidth(), getResources().getDimensionPixelSize(0x7f0b0122));
            startActivity(getHotelDetailsIntentForTonight(marketrateresult, ((com.groupon.util.ViewUtils.Size) (obj))), view);
        }

        public void onSeeAllButtonClicked()
        {
            loggingUtils.logClickWithMetadata("", "Nearby_Tonight_All_Button_Clicked", nstChannel, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            startActivity(((IntentFactory)intentFactory.get()).newHotelSearchIntent(Channel.HOTELS, true));
        }

        private OnWidgetClickListener()
        {
            this$0 = GetawaysFragment.this;
            super();
        }

    }

    private class SpanSizeLookup extends android.support.v7.widget.GridLayoutManager.SpanSizeLookup
    {

        private final GridLayoutManager layoutManager;
        final GetawaysFragment this$0;

        public int getSpanSize(int i)
        {
            if (endlessAdapter.isProgressView(i) || adapter.isWidget(i))
            {
                return layoutManager.getSpanCount();
            } else
            {
                return 1;
            }
        }

        private SpanSizeLookup(GridLayoutManager gridlayoutmanager)
        {
            this$0 = GetawaysFragment.this;
            super();
            layoutManager = gridlayoutmanager;
        }

    }

    private class WidgetSyncUiCallbacks
        implements commonlib.manager.SyncManager.SyncUiCallbacks
    {

        final GetawaysFragment this$0;

        public void enableSyncProgressIndicator(boolean flag)
        {
        }

        public void handleSyncError(Runnable runnable, Exception exception)
        {
            if (!isAdded())
            {
                return;
            } else
            {
                LoaderCallbacksUtil.handleSyncError(runnable, exception, getActivity(), (LoginService)loginService.get(), (CountryUtil)countryUtil.get(), currentCountryManager.getCurrentCountry(), hotelsSyncManager, (IntentFactory)intentFactory.get(), new Function2() {

                    final WidgetSyncUiCallbacks this$1;

                    public volatile void execute(Object obj, Object obj1)
                        throws Exception
                    {
                        execute((Runnable)obj, (Exception)obj1);
                    }

                    public void execute(Runnable runnable, Exception exception)
                    {
                        LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, getActivity(), (DialogManager)dialogManager.get(), hotelsSyncManager, null, new Function2() {

                            final WidgetSyncUiCallbacks._cls1 this$2;

                            public volatile void execute(Object obj, Object obj1)
                                throws Exception
                            {
                                execute((Runnable)obj, (Exception)obj1);
                            }

                            public void execute(Runnable runnable, Exception exception)
                            {
                                logger.log(exception);
                                widgetAdapter.setDeals(Collections.emptyList());
                                isRefreshingHotels.set(false);
                                if (!isRefreshingDeals.get())
                                {
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                            }

            
            {
                this$2 = WidgetSyncUiCallbacks._cls1.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = WidgetSyncUiCallbacks.this;
                super();
            }
                });
                return;
            }
        }

        private WidgetSyncUiCallbacks()
        {
            this$0 = GetawaysFragment.this;
            super();
        }

    }


    private AbTestService abTestService;
    private GetawaysRecyclerViewAdapter adapter;
    private Lazy buyUtils;
    private boolean canLoadMoreDeals;
    private Channel channel;
    private Lazy countryUtil;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    private DealCardListUtils dealCardListUtils;
    private DealsRecyclerViewAdapter dealsAdapter;
    private GetawaysSyncManager dealsSyncManager;
    private final commonlib.manager.SyncManager.SyncUiCallbacks dealsSyncUiCallbacks = new DealsSyncUiCallbacks();
    private Lazy dialogManager;
    private EndlessRecyclerViewAdapter endlessAdapter;
    private GeoUtils geoUtils;
    private HotelsCarouselSyncManager hotelsSyncManager;
    private IncentivesUtil incentivesUtil;
    private Lazy intentFactory;
    private final AtomicBoolean isRefreshingDeals = new AtomicBoolean(false);
    private final AtomicBoolean isRefreshingHotels = new AtomicBoolean(false);
    private boolean isSingleTabWithWidget;
    private boolean isUSACompatible;
    private LayoutUtil layoutUtil;
    private Logger logger;
    private LoggingUtils loggingUtils;
    private Lazy loginService;
    private String nstChannel;
    RecyclerView recyclerView;
    private ScrollToolBarHelperV3 scrollToolBarHelper;
    SwipeRefreshLayout swipeRefreshLayout;
    private GetawaysWidgetRecyclerViewAdapter widgetAdapter;
    private final commonlib.manager.SyncManager.SyncUiCallbacks widgetSyncUiCallbacks = new WidgetSyncUiCallbacks();

    public GetawaysFragment()
    {
    }

    private Intent getHotelDetailsIntentForTonight(MarketRateResult marketrateresult, com.groupon.util.ViewUtils.Size size)
    {
        Object obj = new GregorianCalendar(TimeZone.getDefault(), Locale.US);
        java.util.Date date = ((Calendar) (obj)).getTime();
        ((Calendar) (obj)).add(5, 1);
        obj = ((Calendar) (obj)).getTime();
        return ((IntentFactory)intentFactory.get()).newHotelDealDetailsIntent(marketrateresult, DateFormat.format("yyyy-MM-dd", date).toString(), DateFormat.format("yyyy-MM-dd", ((java.util.Date) (obj))).toString(), 2, 0, false, Channel.HOTELS, Channel.HOTELS.name(), size);
    }

    private void refreshDeals()
    {
        dealsSyncManager.requestSync(dealsSyncUiCallbacks, null);
        isRefreshingDeals.set(true);
    }

    private void refreshHotels()
    {
        hotelsSyncManager.requestSync(widgetSyncUiCallbacks, null);
        isRefreshingHotels.set(true);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        scrollToolBarHelper.initToolBar((Carousel)getActivity(), this);
        loginService = new Lazy(getActivity()) {

            final GetawaysFragment this$0;

            
            {
                this$0 = GetawaysFragment.this;
                super(context);
            }
        };
        countryUtil = new Lazy(getActivity()) {

            final GetawaysFragment this$0;

            
            {
                this$0 = GetawaysFragment.this;
                super(context);
            }
        };
        dialogManager = new Lazy(getActivity()) {

            final GetawaysFragment this$0;

            
            {
                this$0 = GetawaysFragment.this;
                super(context);
            }
        };
        intentFactory = new Lazy(getActivity()) {

            final GetawaysFragment this$0;

            
            {
                this$0 = GetawaysFragment.this;
                super(context);
            }
        };
        buyUtils = new Lazy(getActivity()) {

            final GetawaysFragment this$0;

            
            {
                this$0 = GetawaysFragment.this;
                super(context);
            }
        };
        getLoaderManager().initLoader(0, null, new DealListLoaderCallbacks());
        refreshDeals();
        if (isSingleTabWithWidget)
        {
            getLoaderManager().initLoader(1, null, new HotelDealListLoaderCallbacks());
            refreshHotels();
        }
        swipeRefreshLayout.setRefreshing(true);
        endlessAdapter.setProgressViewVisible(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        boolean flag;
        if (currentCountryManager.getCurrentCountry() != null && currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isUSACompatible = flag;
        if (isUSACompatible)
        {
            bundle = Channel.GETAWAYS;
        } else
        {
            bundle = Channel.TRAVEL;
        }
        channel = bundle;
        nstChannel = channel.toString();
        dealsSyncManager.setFragmentName(com/groupon/getaways/carousel/GetawaysFragment.getSimpleName());
        dealsSyncManager.setChannelId(channel.name());
        dealsSyncManager.setNstChannel(nstChannel);
        dealsSyncManager.setFirstPageSize(dealCardListUtils.getFirstPageSize());
        dealsSyncManager.setSubsequencePageSize(dealCardListUtils.getSubsequencePageSize());
        canLoadMoreDeals = true;
        if (isUSACompatible)
        {
            dealsSyncManager.setChannelOptions(new String[] {
                "include_travel_bookable_deals", "true"
            });
        }
        isSingleTabWithWidget = abTestService.isVariantEnabledAndUSCA("getawaysUSCA1506", "singleTabWithWidget");
        dealsAdapter = new DealsRecyclerViewAdapter(loggingUtils, incentivesUtil, layoutUtil, abTestService, new DealCardViewPresenter(getActivity(), currentCountryManager, abTestService, incentivesUtil, currencyFormatter, geoUtils), nstChannel, getClass().getSimpleName());
        dealsAdapter.setOnDealClickListener(new OnDealClickListener());
        if (isSingleTabWithWidget)
        {
            hotelsSyncManager.setFragmentName(com/groupon/getaways/carousel/GetawaysFragment.getSimpleName());
            hotelsSyncManager.setChannelId(channel.name());
            hotelsSyncManager.setNstChannel(nstChannel);
            hotelsSyncManager.setFirstPageSize(dealCardListUtils.getFirstPageSize());
            widgetAdapter = new GetawaysWidgetRecyclerViewAdapter(new HotelDealCardViewPresenter(currencyFormatter), channel.name(), nstChannel, loggingUtils);
            widgetAdapter.setOnWidgetClickListener(new OnWidgetClickListener());
        }
        adapter = new GetawaysRecyclerViewAdapter(dealsAdapter, widgetAdapter);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300ea, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view = new GridLayoutManager(recyclerView.getContext(), getResources().getInteger(0x7f0d0001));
        view.setSpanSizeLookup(new SpanSizeLookup(view));
        recyclerView.setLayoutManager(view);
        recyclerView.setOnScrollListener(new DealsEndlessRecyclerViewOnScrollListener(dealsAdapter));
        endlessAdapter = new EndlessRecyclerViewAdapter(adapter, 0x7f030201);
        recyclerView.setAdapter(endlessAdapter);
        swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener());
        if (isSingleTabWithWidget)
        {
            adapter.setSwipeRefreshLayout(swipeRefreshLayout);
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            String s = getClass().getSimpleName();
            logger.logPageView("", s, Logger.NULL_NST_FIELD);
            abTestService.isVariantEnabled("AAonGetawaysTab1510", "On");
        }
    }








/*
    static boolean access$1502(GetawaysFragment getawaysfragment, boolean flag)
    {
        getawaysfragment.canLoadMoreDeals = flag;
        return flag;
    }

*/



















}
