// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Loader;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.f2prateek.dart.Dart;
import com.groupon.Channel;
import com.groupon.abtest.RapiAbTestHelper;
import com.groupon.animation.ExpandCollapseAnimation;
import com.groupon.callbacks.OnToggleListener;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.Features;
import com.groupon.db.models.Pagination;
import com.groupon.events.FilterDataChangedLocallyEvent;
import com.groupon.events.ResetFilterSheetEvent;
import com.groupon.events.SearchFilterSelectedFacetUpdatedEvent;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.RapiPaginatedSyncManagerProcess;
import com.groupon.models.Place;
import com.groupon.models.RapiSearchResponse;
import com.groupon.models.nst.DTFGenericMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.search.domain.FacetFilter;
import com.groupon.models.search.domain.Filter;
import com.groupon.models.search.domain.SortMethod;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.RapiRequestProperties;
import com.groupon.util.RapiResponseListener;
import com.groupon.util.RapiResponsePostProcessor;
import com.groupon.util.ResultsAvailableListener;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.mapping.BandCardMapping;
import com.groupon.v3.adapter.mapping.BusinessCardMapping;
import com.groupon.v3.adapter.mapping.DateTimeSearchDealCardMapping;
import com.groupon.v3.adapter.mapping.DefaultLargeDealCardMapping;
import com.groupon.v3.adapter.mapping.GenericHeaderCardMapping;
import com.groupon.v3.adapter.mapping.NextPageTriggerMapping;
import com.groupon.v3.loader.IUniversalCallback;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalListLoader;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.PaginationInserter;
import com.groupon.v3.processor.RapiRequestProcessor;
import com.groupon.v3.view.callbacks.BandCardCallbacks;
import com.groupon.v3.view.callbacks.BandCardViewHandler;
import com.groupon.v3.view.callbacks.BusinessCardCallback;
import com.groupon.v3.view.callbacks.BusinessCardViewHandler;
import com.groupon.v3.view.callbacks.DealCallbacks;
import com.groupon.v3.view.callbacks.DealCardBookingsViewHandler;
import com.groupon.v3.view.callbacks.DealCardViewHandler;
import com.groupon.view.HeaderToggle;
import com.groupon.view.HeaderTogglePresenter;
import com.squareup.otto.Bus;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment, DateTimeFindingView, DateTimeFilterDialog, RapiSearchResultFragmentPresenter, 
//            RapiSearchResultDomainModelFacade

public class RapiSearchResultFragment extends BaseRecyclerViewFragment
    implements DateTimeFindingView, RapiResponseListener, IUniversalCallback
{
    private class DTFReservationToggleListener
        implements OnToggleListener
    {

        final RapiSearchResultFragment this$0;

        public void onToggle(boolean flag)
        {
            presenter.toggleReservation(flag);
            DTFGenericMetadata dtfgenericmetadata = new DTFGenericMetadata();
            dtfgenericmetadata.type = presenter.getCategoryIntent().toTrackingString();
            String s;
            if (flag)
            {
                s = "on";
            } else
            {
                s = "off";
            }
            dtfgenericmetadata.state = s;
            loggingUtils.logImpression("", "bookable_toggle", Channel.GLOBAL_SEARCH.name(), "", dtfgenericmetadata);
            headerToggle.getPresenter().setEnabled(false);
            loggingUtils.logClickWithMetadata("", "bookable_toggle", Channel.GLOBAL_SEARCH.name(), dtfgenericmetadata);
            presenter.reloadDeals();
        }

        private DTFReservationToggleListener()
        {
            this$0 = RapiSearchResultFragment.this;
            super();
        }

    }


    private static final String BUNDLE_SEARCH_PROPERTIES = "BUNDLE_SEARCH_PROPERTIES";
    public static final String DATE_TIME_INITIAL_TOGGLE_STATE = "date_time_initial_toggle_state";
    private static final String DATE_TIME_PICKER_DIALOG = "date_time_picker_dialog";
    private static final String IS_FIRST_LOAD = "IS_FIRST_LOAD";
    private static final int TOP_OF_LIST = 0;
    AbTestService abTestService;
    private boolean areFiltersActive;
    Bus bus;
    CurrentCountryManager currentCountryManager;
    TextView dateTimeHeader;
    DeviceInfoUtil deviceInfoUtil;
    private DTFReservationToggleListener dtfReservationToggleListener;
    HeaderToggle headerToggle;
    protected boolean initialDateTimeToggleState;
    private boolean isFilterSheetUSCA;
    private boolean isFirstLoad;
    private boolean isShowBadgeOnSearch1509USCA;
    private boolean isSmallDealCardsOnSearch1508;
    private RapiSearchResultFragmentPresenter presenter;
    RapiAbTestHelper rapiAbTestHelper;
    private RapiPaginatedSyncManagerProcess rapiPaginatedSyncManagerProcess;
    private RapiRequestProcessor rapiRequestProcessor;
    private RapiResponseListener rapiResponseListener;
    RapiResponsePostProcessor rapiResponsePostProcessor;
    private ResultsAvailableListener resultsAvailableListener;
    protected Place searchPlace;
    protected RapiRequestProperties searchProperties;
    Channel searchSourceChannel;
    private UniversalLoaderCallbacks universalLoaderCallbacks;
    private UniversalUpdateEvent universalUpdateEvent;

    public RapiSearchResultFragment()
    {
        isFirstLoad = true;
        dtfReservationToggleListener = new DTFReservationToggleListener();
    }

    private String generateDbChannelHash()
    {
        return Channel.encodePath(new String[] {
            Channel.RAPI_SEARCH.name(), String.valueOf(searchProperties.hashCode())
        });
    }

    private String getLocationLabel(Place place)
    {
        if (Strings.isEmpty(place.label))
        {
            return String.format("%f,%f", new Object[] {
                Double.valueOf(place.lat), Double.valueOf(place.lng)
            });
        } else
        {
            return place.label;
        }
    }

    private void showDateTimePickerDialog()
    {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        Object obj = getFragmentManager().findFragmentByTag("date_time_picker_dialog");
        if (obj != null)
        {
            fragmenttransaction.remove(((android.app.Fragment) (obj)));
        }
        obj = new DateTimeFilterDialog();
        ((DateTimeFilterDialog) (obj)).setRapiSearchResultFragmentPresenter(presenter);
        ((DateTimeFilterDialog) (obj)).show(fragmenttransaction, "date_time_picker_dialog");
    }

    public void animateDateTimeHeaderVisible(boolean flag)
    {
        int i = (int)getResources().getDimension(0x7f0b00c6);
        if (flag && dateTimeHeader.getVisibility() != 0)
        {
            ExpandCollapseAnimation.expand(dateTimeHeader, i);
        } else
        if (!flag && dateTimeHeader.getVisibility() != 8)
        {
            ExpandCollapseAnimation.collapse(dateTimeHeader, i);
            return;
        }
    }

    protected void configureEmptyView(View view)
    {
        View view1;
        View view2;
        int i;
        boolean flag;
        if (headerToggle.getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isFilterSheetUSCA && areFiltersActive)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        if (flag || isFilterSheetUSCA && areFiltersActive)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view1 = view.findViewById(0x7f1004a4);
        view2 = view.findViewById(0x7f100216);
        view1.setVisibility(i);
        view2.setVisibility(i);
        if (flag)
        {
            ((LinearLayout)view).setGravity(1);
            ((LinearLayout)view).setPadding(0, deviceInfoUtil.convertDpToPixels(45), 0, 0);
        }
        view2.setOnClickListener(new android.view.View.OnClickListener() {

            final RapiSearchResultFragment this$0;

            public void onClick(View view3)
            {
                bus.post(new ResetFilterSheetEvent());
            }

            
            {
                this$0 = RapiSearchResultFragment.this;
                super();
            }
        });
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        rapiRequestProcessor = new RapiRequestProcessor(getActivity(), dbChannel, true);
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            rapiRequestProcessor, new PaginationInserter(true)
        });
        Object obj;
        if (rapiAbTestHelper.isDTFforEitherHBWOrFDEnabled(searchPlace))
        {
            obj = new DateTimeSearchDealCardMapping(presenter.getDomainModelFacade());
            ((DefaultLargeDealCardMapping) (obj)).registerCallback(com/groupon/v3/view/callbacks/DealCallbacks, new DealCardBookingsViewHandler(getActivity(), getClass().getSimpleName(), Channel.GLOBAL_SEARCH, presenter.getDomainModelFacade(), presenter));
        } else
        {
            obj = new DefaultLargeDealCardMapping();
            ((DefaultLargeDealCardMapping) (obj)).registerCallback(com/groupon/v3/view/callbacks/DealCallbacks, new DealCardViewHandler(getActivity(), getClass().getSimpleName(), Channel.GLOBAL_SEARCH));
        }
        ((DefaultLargeDealCardMapping) (obj)).setUseSmallDealCard(isSmallDealCardsOnSearch1508);
        ((DefaultLargeDealCardMapping) (obj)).setIsShowBadge(isShowBadgeOnSearch1509USCA);
        ((DefaultLargeDealCardMapping) (obj)).setCurrentLocation(searchProperties.expressedLocation);
        universallistadapter.registerOverrideMapping(((com.groupon.v3.adapter.mapping.Mapping) (obj)));
        universallistadapter.registerOverrideMapping((new BusinessCardMapping()).registerCallback(com/groupon/v3/view/callbacks/BusinessCardCallback, new BusinessCardViewHandler(getActivity())));
        universallistadapter.registerOverrideMapping(new NextPageTriggerMapping(this));
        universallistadapter.registerOverrideMapping(new GenericHeaderCardMapping());
        obj = new BandCardMapping();
        ((BandCardMapping) (obj)).registerCallback(com/groupon/v3/view/callbacks/BandCardCallbacks, new BandCardViewHandler(activity, "global_search"));
        universallistadapter.registerOverrideMapping(((com.groupon.v3.adapter.mapping.Mapping) (obj)));
        universallistadapter.registerAdapterDataObserver(new android.support.v7.widget.RecyclerView.AdapterDataObserver() {

            final RapiSearchResultFragment this$0;

            public void onChanged()
            {
                bus.post(new FilterDataChangedLocallyEvent());
            }

            
            {
                this$0 = RapiSearchResultFragment.this;
                super();
            }
        });
        universalLoaderCallbacks = universalloadercallbacks;
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        dbChannel = generateDbChannelHash();
        rapiPaginatedSyncManagerProcess = new RapiPaginatedSyncManagerProcess(getActivity(), dbChannel, Channel.RAPI_SEARCH.name());
        rapiPaginatedSyncManagerProcess.setRequestParams(searchProperties);
        rapiPaginatedSyncManagerProcess.setRapiResponseListener(this);
        if (isFirstLoad)
        {
            rapiPaginatedSyncManagerProcess.forceUpdateOnSync();
        }
        universalUpdateEvent = new UniversalUpdateEvent(dbChannel);
        universalsyncmanager.configurePaginatedSyncManager(rapiPaginatedSyncManagerProcess, null, universalUpdateEvent);
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f0301bb;
    }

    public int getLayoutId()
    {
        return 0x7f0301bd;
    }

    public RapiSearchResultFragmentPresenter getPresenter()
    {
        return presenter;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (isFirstLoad)
        {
            headerToggle.getPresenter().setToggle(initialDateTimeToggleState);
            bundle = searchProperties.findFilter("category");
            if (bundle != null && !Strings.equals(bundle.getFilterValue("category"), "food-and-drink"))
            {
                presenter.initializeServiceCategory(bundle.getFilterValue("category"));
            }
        }
        dateTimeHeader.setOnClickListener(new android.view.View.OnClickListener() {

            final RapiSearchResultFragment this$0;

            public void onClick(View view)
            {
                view = new DTFGenericMetadata();
                view.type = presenter.getCategoryIntent().toTrackingString();
                view.date = presenter.getDomainModelFacade().getReservationDateFormatted();
                view.time = presenter.getDomainModelFacade().getReservationTimeFormatted();
                if (presenter.isFoodAndDrinkIntent())
                {
                    view.partysize = Integer.valueOf(presenter.getDomainModelFacade().getPartySize());
                } else
                {
                    view.service = presenter.getDomainModelFacade().getServiceType();
                }
                loggingUtils.logClickWithMetadata("", "dtf_inputs", Channel.GLOBAL_SEARCH.name(), view);
                showDateTimePickerDialog();
            }

            
            {
                this$0 = RapiSearchResultFragment.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Dart.inject(this);
        presenter = new RapiSearchResultFragmentPresenter(this, getResources(), bundle, searchProperties, bus, initialDateTimeToggleState);
        isSmallDealCardsOnSearch1508 = abTestService.isVariantEnabled("smallDealCardsOnSearch1508", "on");
        isShowBadgeOnSearch1509USCA = abTestService.isVariantEnabledAndUSCA("showBadgeOnSearch1509USCA", "on");
        isFilterSheetUSCA = rapiAbTestHelper.isPostSearchFiltersRAPI1510Enabled();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (bundle != null)
        {
            isFirstLoad = bundle.getBoolean("IS_FIRST_LOAD");
            android.app.Fragment fragment = getFragmentManager().findFragmentByTag("date_time_picker_dialog");
            if (fragment != null)
            {
                ((DateTimeFilterDialog)fragment).setRapiSearchResultFragmentPresenter(presenter);
                showDateTimePickerDialog();
            }
        }
        Dart.inject(this);
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        super.onLoaderDataChanged(universallistloadresultdata, flag);
        if (resultsAvailableListener != null)
        {
            resultsAvailableListener.resultsAvailable(universallistloadresultdata.getListData());
        }
        if (isFirstLoad)
        {
            isFirstLoad = false;
        }
        if (!flag)
        {
            presenter.refreshView();
            headerToggle.getPresenter().setEnabled(true);
            return;
        } else
        {
            recyclerView.scrollToPosition(0);
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        bus.unregister(this);
        headerToggle.getPresenter().setOnToggleListener(null);
    }

    public void onRapiResponseAvailable(RapiSearchResponse rapisearchresponse)
    {
        Object obj;
        Object obj1;
        if (rapisearchresponse.features != null && rapisearchresponse.containsFacet("bookable") && (rapisearchresponse.features.getCategoryIntent().equals(com.groupon.db.models.Features.SearchIntentCategory.HEALTH_BEAUTY_WELLNESS) && rapiAbTestHelper.isDTFforHBWEnabled(searchPlace) || rapisearchresponse.features.getCategoryIntent().equals(com.groupon.db.models.Features.SearchIntentCategory.FOOD_AND_DRINK) && rapiAbTestHelper.isDTFforFDEnabled(searchPlace)))
        {
            obj = rapisearchresponse.features.getCategoryIntent();
            obj1 = presenter.getCategoryIntent();
            presenter.setSearchIntentCategory(((com.groupon.db.models.Features.SearchIntentCategory) (obj)));
            RapiSearchResultFragmentPresenter rapisearchresultfragmentpresenter = presenter;
            float f;
            float f1;
            Logger logger;
            String s1;
            String s2;
            int i;
            boolean flag;
            if (rapisearchresponse.containsFacet("bookable") && !((com.groupon.db.models.Features.SearchIntentCategory) (obj)).equals(com.groupon.db.models.Features.SearchIntentCategory.UNKNOWN))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            rapisearchresultfragmentpresenter.setMakeAReservationVisibility(flag);
            if (((com.groupon.db.models.Features.SearchIntentCategory) (obj1)).equals(com.groupon.db.models.Features.SearchIntentCategory.UNKNOWN) && !((com.groupon.db.models.Features.SearchIntentCategory) (obj)).equals(com.groupon.db.models.Features.SearchIntentCategory.UNKNOWN))
            {
                presenter.buildStaticListsAndSetDefaultValues();
            }
        }
        if (rapisearchresponse.pagination.getCurrentOffset() != 0 || rapisearchresponse.cards.size() <= 0) goto _L2; else goto _L1
_L1:
        obj = null;
        if (!headerToggle.getPresenter().isToggled()) goto _L4; else goto _L3
_L3:
        obj = new DTFGenericMetadata();
        obj1 = presenter.getCategoryIntent();
        obj.type = ((com.groupon.db.models.Features.SearchIntentCategory) (obj1)).toTrackingString();
        if (!((com.groupon.db.models.Features.SearchIntentCategory) (obj1)).equals(com.groupon.db.models.Features.SearchIntentCategory.HEALTH_BEAUTY_WELLNESS)) goto _L6; else goto _L5
_L5:
        obj.service = presenter.getDomainModelFacade().getServiceType();
_L8:
        obj.date = presenter.getDomainModelFacade().getReservationDateFormatted();
        obj.time = presenter.getDomainModelFacade().getReservationTimeFormatted();
_L4:
        logger = this.logger;
        s1 = Channel.GLOBAL_SEARCH.toString();
        String s;
        if (Strings.notEmpty(searchProperties.currentCategoryId))
        {
            obj1 = "";
        } else
        {
            obj1 = searchProperties.searchQuery;
        }
        s2 = searchSourceChannel.toString();
        if (Strings.notEmpty(searchProperties.currentCategoryId))
        {
            s = searchProperties.currentCategoryId;
        } else
        {
            s = "";
        }
        f = (float)searchProperties.expressedLocation.lat;
        f1 = (float)searchProperties.expressedLocation.lng;
        i = rapisearchresponse.pagination.getCount();
        if (obj == null)
        {
            obj = JsonEncodedNSTField.NULL_JSON_NST_FIELD;
        }
        logger.logDealSearch("", s1, ((String) (obj1)), s2, s, f, f1, "pull", i, ((com.groupon.tracking.mobile.EncodedNSTField) (obj)));
_L2:
        rapiResponsePostProcessor.setResponse(rapisearchresponse).removeBlacklistedFacetsById(Arrays.asList(new String[] {
            "bookable"
        })).addDepthToChildFacetValues();
        if (rapiResponseListener != null)
        {
            rapiResponseListener.onRapiResponseAvailable(rapisearchresponse);
        }
        return;
_L6:
        if (((com.groupon.db.models.Features.SearchIntentCategory) (obj1)).equals(com.groupon.db.models.Features.SearchIntentCategory.FOOD_AND_DRINK))
        {
            obj.partysize = Integer.valueOf(presenter.getDomainModelFacade().getPartySize());
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onResume()
    {
        super.onResume();
        bus.register(this);
        headerToggle.getPresenter().setOnToggleListener(dtfReservationToggleListener);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("IS_FIRST_LOAD", isFirstLoad);
        presenter.onSaveInstanceState(bundle);
    }

    public void onSearchFilterDomainModelUpdate(SearchFilterSelectedFacetUpdatedEvent searchfilterselectedfacetupdatedevent)
    {
        boolean flag;
        if (searchfilterselectedfacetupdatedevent.facetCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        areFiltersActive = flag;
        configureEmptyView(emptyView);
    }

    public void onViewBound(int i, Object obj)
    {
    }

    public void onViewClick(View view)
    {
        super.onViewClick(view);
    }

    public void resetSearch()
    {
        searchProperties.offset = 0;
        String s = generateDbChannelHash();
        rapiRequestProcessor.setDbChannel(s);
        rapiPaginatedSyncManagerProcess.setDbChannel(s);
        universalLoaderCallbacks.setChannel(s);
        universalUpdateEvent.channel = s;
        ((UniversalListLoader)getLoaderManager().getLoader(0)).setDbChannel(s);
        getLoaderManager().restartLoader(0, null, universalLoaderCallbacks).cancelLoad();
    }

    public void setDateTimeHeaderString(String s)
    {
        dateTimeHeader.setText(s);
    }

    public void setDateTimeHeaderVisible(boolean flag)
    {
        TextView textview = dateTimeHeader;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    public void setHeaderToggleVisible(boolean flag)
    {
        int i;
        if (flag && headerToggle.getVisibility() == 8)
        {
            DTFGenericMetadata dtfgenericmetadata = new DTFGenericMetadata();
            dtfgenericmetadata.type = presenter.getCategoryIntent().toTrackingString();
            Object obj;
            if (headerToggle.getPresenter().isToggled())
            {
                obj = "on";
            } else
            {
                obj = "off";
            }
            dtfgenericmetadata.state = ((String) (obj));
            loggingUtils.logImpression("", "bookable_toggle", Channel.GLOBAL_SEARCH.name(), "", dtfgenericmetadata);
        }
        obj = headerToggle;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((HeaderToggle) (obj)).setVisibility(i);
        configureEmptyView(emptyView);
    }

    public void setRapiResponseListener(RapiResponseListener rapiresponselistener)
    {
        rapiResponseListener = rapiresponselistener;
    }

    public void setResultsListener(ResultsAvailableListener resultsavailablelistener)
    {
        resultsAvailableListener = resultsavailablelistener;
    }

    public void setToggleHeader(boolean flag)
    {
        headerToggle.getPresenter().setToggle(flag);
    }

    public void setToggleTitle(String s)
    {
        headerToggle.setTitle(s);
    }

    public void updateFacetFilters(List list)
    {
        FacetFilter facetfilter = null;
        Iterator iterator = searchProperties.facetFilters.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FacetFilter facetfilter1 = (FacetFilter)iterator.next();
            if (facetfilter1.facetId.equals("bookable"))
            {
                facetfilter = facetfilter1;
            }
        } while (true);
        searchProperties.facetFilters = list;
        if (facetfilter != null)
        {
            searchProperties.facetFilters.add(facetfilter);
        }
    }

    public void updateSearchLocation(Place place)
    {
        searchProperties.expressedLocation = place;
        getLoaderManager().restartLoader(0, null, universalLoaderCallbacks).cancelLoad();
    }

    public void updateSortMethod(SortMethod sortmethod)
    {
        searchProperties.sortMethod = sortmethod;
    }


}
