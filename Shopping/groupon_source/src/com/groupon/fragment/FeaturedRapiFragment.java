// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.NotificationManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.groupon.Channel;
import com.groupon.abtest.GtgAbTestHelper;
import com.groupon.abtest.RapiAbTestHelper;
import com.groupon.callbacks.FeaturedLocationBarClickListener;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.DealCollection;
import com.groupon.db.models.Finder;
import com.groupon.db.models.Pagination;
import com.groupon.http.RapiRequestBuilder;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.RapiPaginatedSyncManagerProcess;
import com.groupon.models.Place;
import com.groupon.models.RapiSearchResponse;
import com.groupon.models.division.Division;
import com.groupon.service.LocationService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.AppStartupImageLoadListener;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.BaseRecyclerViewDelegate;
import com.groupon.util.GeoPoint;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.RapiRequestProperties;
import com.groupon.util.RapiResponseListener;
import com.groupon.util.ShowPropertyParam;
import com.groupon.util.SmuggleDealManager;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.mapping.BusinessCardMapping;
import com.groupon.v3.adapter.mapping.DefaultLargeDealCardMapping;
import com.groupon.v3.adapter.mapping.FallbackCardMapping;
import com.groupon.v3.adapter.mapping.FinderCardMapping;
import com.groupon.v3.adapter.mapping.GenericHeaderCardMapping;
import com.groupon.v3.adapter.mapping.GtgPromoteCardWithDefaultsMapping;
import com.groupon.v3.adapter.mapping.LocationBarMapping;
import com.groupon.v3.adapter.mapping.Mapping;
import com.groupon.v3.adapter.mapping.NextPageTriggerMapping;
import com.groupon.v3.adapter.mapping.VersionedCollectionCardMapping;
import com.groupon.v3.loader.EmptyListChecker;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.PaginationInserter;
import com.groupon.v3.processor.RapiRequestProcessor;
import com.groupon.v3.trigger.NextPageTrigger;
import com.groupon.v3.view.callbacks.BusinessCardCallback;
import com.groupon.v3.view.callbacks.BusinessCardViewHandler;
import com.groupon.v3.view.callbacks.CollectionCardCallback;
import com.groupon.v3.view.callbacks.CollectionCardViewHandler;
import com.groupon.v3.view.callbacks.DealCallbacks;
import com.groupon.v3.view.callbacks.DealCardViewHandler;
import com.groupon.v3.view.callbacks.FallbackCallback;
import com.groupon.v3.view.callbacks.FallbackViewHandler;
import com.groupon.v3.view.callbacks.FinderCardCallback;
import com.groupon.v3.view.callbacks.FinderCardViewHandler;
import com.groupon.v3.view.callbacks.GtgJumpOffCardHandler;
import com.groupon.v3.view.callbacks.GtgPromoCardHandler;
import com.groupon.v3.view.list_view.LocationBarHeader;
import com.groupon.view.LocationBar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment

public class FeaturedRapiFragment extends BaseRecyclerViewFragment
    implements RapiResponseListener
{
    private static class FeaturedTabEmptyListChecker
        implements EmptyListChecker
    {

        public boolean isEmpty(List list)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                Object obj = list.next();
                if (!(obj instanceof LocationBarHeader) && !(obj instanceof NextPageTrigger) && !(obj instanceof Pagination))
                {
                    return false;
                }
            }

            return true;
        }

        private FeaturedTabEmptyListChecker()
        {
        }

    }


    public static final String NST_CLICK_DIVISION_TYPE = "click_country_selector";
    private AbTestService abTestService;
    private CurrentDivisionManager currentDivisionManager;
    private LocationBar emptyLocationBar;
    private GtgAbTestHelper gtgAbTestHelper;
    private AppStartupImageLoadListener imageLoadListener;
    protected IncentivesUtil incentivesUtil;
    private boolean isShowBadgeOnRAPIFeaturedTab1509USCA;
    private boolean isShowFindersCard;
    private LocationService locationService;
    private LoggingUtils loggingUtils;
    private ArraySharedPreferences loginPrefs;
    private NotificationManager notificationManager;
    private RapiAbTestHelper rapiAbTestHelper;
    private RapiRequestProperties rapiRequestProperties;
    private SmuggleDealManager smuggleDealManager;

    public FeaturedRapiFragment()
    {
    }

    private void initEmptyViewLocationBar()
    {
        emptyLocationBar = (LocationBar)emptyView.findViewById(0x7f100289);
        emptyLocationBar.setText(currentDivisionManager.getCurrentDivision().name);
        emptyLocationBar.setOnClickListener(new FeaturedLocationBarClickListener(getActivity(), emptyLocationBar.getText().toString(), Channel.FEATURED));
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        RapiRequestProcessor rapirequestprocessor = new RapiRequestProcessor(getActivity(), dbChannel, true);
        rapirequestprocessor.setHeader(new LocationBarHeader(currentDivisionManager.getCurrentDivision().name));
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            rapirequestprocessor, new PaginationInserter(true)
        });
        universalloadercallbacks = new DefaultLargeDealCardMapping();
        universalloadercallbacks.setIsShowBadge(isShowBadgeOnRAPIFeaturedTab1509USCA);
        universalloadercallbacks.setImageStartUpListener(imageLoadListener);
        universallistadapter.registerOverrideMapping(universalloadercallbacks.registerCallback(com/groupon/v3/view/callbacks/DealCallbacks, new DealCardViewHandler(getActivity(), getClass().getSimpleName(), Channel.FEATURED)));
        universallistadapter.registerOverrideMapping((new BusinessCardMapping()).registerCallback(com/groupon/v3/view/callbacks/BusinessCardCallback, new BusinessCardViewHandler(getActivity())));
        universallistadapter.registerOverrideMapping(new NextPageTriggerMapping(this));
        universallistadapter.registerOverrideMapping(new GenericHeaderCardMapping());
        universallistadapter.registerOverrideMapping(new LocationBarMapping(getActivity(), Channel.FEATURED));
        universallistadapter.registerOverrideMapping((new FinderCardMapping()).registerCallback(com/groupon/v3/view/callbacks/FinderCardCallback, new FinderCardViewHandler(getActivity())));
        universallistadapter.registerOverrideMapping((new GtgPromoteCardWithDefaultsMapping("gtg_promo_card_with_defaults", 0x7f03012e)).registerCallback(com/groupon/v3/view/callbacks/FinderCardCallback, new GtgPromoCardHandler(getActivity())));
        universallistadapter.registerOverrideMapping((new GtgPromoteCardWithDefaultsMapping("gtg_jumpoff_card_with_defaults", 0x7f03012d, true)).registerCallback(com/groupon/v3/view/callbacks/FinderCardCallback, new GtgJumpOffCardHandler(getActivity())));
        universallistadapter.registerOverrideMapping(VersionedCollectionCardMapping.create("FullBleedCollectionCard").registerCallback(com/groupon/v3/view/callbacks/CollectionCardCallback, new CollectionCardViewHandler(getActivity())));
        universallistadapter.registerOverrideMapping(VersionedCollectionCardMapping.create("NativeCollectionCard").registerCallback(com/groupon/v3/view/callbacks/CollectionCardCallback, new CollectionCardViewHandler(getActivity())));
        universallistadapter.registerOverrideMapping((new FallbackCardMapping(com/groupon/db/models/DealCollection)).registerCallback(com/groupon/v3/view/callbacks/FallbackCallback, new FallbackViewHandler()));
        universallistadapter.registerOverrideMapping((new FallbackCardMapping(com/groupon/db/models/Finder)).registerCallback(com/groupon/v3/view/callbacks/FallbackCallback, new FallbackViewHandler()));
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        dbChannel = Channel.FEATURED.toString();
        isShowBadgeOnRAPIFeaturedTab1509USCA = abTestService.isVariantEnabledAndUSCA("showBadgeOnRAPIFeaturedTab1509USCA", "on");
        Place place = Place.geoPointToPlace(locationService.getBestGuessForLocation());
        isShowFindersCard = rapiAbTestHelper.isShowFinderCardForEitherHBWOrFD1510USCA(place);
        Object obj = currentDivisionManager.getCurrentDivision().geoPoint;
        Place place1 = new Place("", ((GeoPoint) (obj)).getLatitudeDegrees(), ((GeoPoint) (obj)).getLongitudeDegrees());
        rapiRequestProperties = new RapiRequestProperties();
        android.content.Intent intent = getActivity().getIntent();
        obj = locationService.getLocation();
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (obj != null)
        {
            obj = new Place("", ((Location) (obj)).getLatitude(), ((Location) (obj)).getLongitude());
        } else
        {
            obj = null;
        }
        rapiRequestProperties.pageType = "featured";
        rapiRequestProperties.expressedLocation = place1;
        rapiRequestProperties.currentLocation = ((Place) (obj));
        flag1 = smuggleDealManager.getDealIdsToBeSmuggled(Channel.FEATURED.name()).isEmpty();
        obj = rapiRequestProperties.showParams;
        flag2 = incentivesUtil.isExperimentEnabled();
        if (gtgAbTestHelper.isGtgPromoCardOnFeatured() && !gtgAbTestHelper.isGtgJumpoffCardOnFeatured())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((List) (obj)).add(ApiRequestUtil.getRapiFeaturedShowParams(flag2, flag));
        if (isShowBadgeOnRAPIFeaturedTab1509USCA)
        {
            rapiRequestProperties.showParams.add(new ShowPropertyParam("_badges"));
        }
        if (isShowFindersCard)
        {
            rapiRequestProperties.showParams.add(new ShowPropertyParam("finders"));
            rapiRequestProperties.bookable = rapiAbTestHelper.findBookableType(place);
        }
        if (rapiAbTestHelper.isShowCollectionCards1510USCAEnabled())
        {
            rapiRequestProperties.showParams.add(new ShowPropertyParam("collections"));
            rapiRequestProperties.deckId = rapiAbTestHelper.getCollectionCardsDeckId();
        }
        obj = new RapiPaginatedSyncManagerProcess(getActivity(), dbChannel, null);
        ((RapiPaginatedSyncManagerProcess) (obj)).setRequestParams(rapiRequestProperties);
        ((RapiPaginatedSyncManagerProcess) (obj)).setIncludeSmuggledDeals(true);
        ((RapiPaginatedSyncManagerProcess) (obj)).setRapiResponseListener(this);
        universalsyncmanager.configurePaginatedSyncManager(((com.groupon.manager.sync_process.AbstractPaginatedSyncManagerProcess) (obj)), null, new UniversalUpdateEvent(dbChannel));
        if (intent != null && !flag1 || loginPrefs.getBoolean("should_refresh_deals_after_login", false))
        {
            ((RapiPaginatedSyncManagerProcess) (obj)).forceUpdateOnSync();
            baseRecyclerViewDelegate.triggerSwipeRefreshAnimation();
            loginPrefs.edit().remove("should_refresh_deals_after_login").apply();
        }
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f0300de;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        initEmptyViewLocationBar();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        baseRecyclerViewDelegate.setEmptyListChecker(new FeaturedTabEmptyListChecker());
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        super.onLoaderDataChanged(universallistloadresultdata, flag);
        if (!universallistloadresultdata.getListData().isEmpty())
        {
            loggingUtils.logPageViewed("deal_list");
        }
    }

    public void onRapiResponseAvailable(RapiSearchResponse rapisearchresponse)
    {
        if (rapisearchresponse.pagination.getCurrentOffset() == 0 && rapisearchresponse.cards.size() > 0)
        {
            loggingUtils.logDealSearch(com/groupon/fragment/FeaturedRapiFragment.getName(), Channel.FEATURED.toString(), (new RapiRequestBuilder(getActivity(), rapiRequestProperties)).build(), "full_list", "all", null, rapisearchresponse.pagination.getCount(), false);
        }
    }

    public void onResume()
    {
        super.onResume();
        com.groupon.Constants.Notification.NotificationType anotificationtype[] = com.groupon.Constants.Notification.NotificationType.values();
        int j = anotificationtype.length;
        for (int i = 0; i < j; i++)
        {
            com.groupon.Constants.Notification.NotificationType notificationtype = anotificationtype[i];
            if (notificationtype != com.groupon.Constants.Notification.NotificationType.NON_DEAL_NOTIFICATION)
            {
                notificationManager.cancel(notificationtype.getId());
            }
        }

    }

    public void onViewBound(int i, Object obj)
    {
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            String s = getClass().getSimpleName();
            logger.logPageView("", s, Logger.NULL_NST_FIELD);
        }
    }
}
