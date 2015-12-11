// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.groupon.Channel;
import com.groupon.abtest.BadgesAbTestHelper;
import com.groupon.abtest.RapiAbTestHelper;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.activity.transition.DealListTransitionController;
import com.groupon.db.models.Pagination;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.events.ExpandFilterSheetEvent;
import com.groupon.events.ResizeFilterSheetEvent;
import com.groupon.events.ToggleFilterSheetEvent;
import com.groupon.fragment.FilterSheetViewFragment;
import com.groupon.fragment.GlobalSearchResultFragment;
import com.groupon.fragment.RapiSearchResultContainerFragment;
import com.groupon.models.Place;
import com.groupon.models.RapiSearchResponse;
import com.groupon.models.category.Category;
import com.groupon.models.division.Division;
import com.groupon.models.nst.GlobalSearchToggleMetadata;
import com.groupon.models.search.domain.DateTimeSearchFilter;
import com.groupon.models.search.domain.FacetFilter;
import com.groupon.models.search.domain.Filter;
import com.groupon.models.search.domain.FilterSheetPresenter;
import com.groupon.models.search.domain.FilterValue;
import com.groupon.models.search.domain.NestedFilter;
import com.groupon.models.search.domain.RangedFilter;
import com.groupon.models.search.domain.SearchFilterDomainModel;
import com.groupon.models.search.domain.SearchFilterDomainModelListener;
import com.groupon.models.search.domain.StaticFilter;
import com.groupon.service.LocationService;
import com.groupon.service.RecentSearchTermService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.DateTimeSearchHelper;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.RapiRequestProperties;
import com.groupon.util.RapiResponseListener;
import com.groupon.util.SearchServiceInterface;
import com.groupon.util.ShowPropertyParam;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.squareup.otto.Bus;
import java.util.Date;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class GlobalSearchResult extends GrouponActivity
    implements com.groupon.fragment.FilterSheetViewFragment.ScrollableActivatedListener, SearchFilterDomainModelListener, RapiResponseListener
{

    private static final String BUNDLE_SEARCH_PROPERTIES = "BUNDLE_SEARCH_PROPERTIES";
    private static final String GLOBAL_SEARCH_RESULT_MODE = "global_search_result_mode";
    private static final String NST_FILTERS_DIM_AREA_CLOSE = "filtersheet_dimmed_click";
    public static final String SEARCH_FILTER = "searchFilter";
    private static final String SEARCH_FILTER_DOMAIN_MODEL = "SEARCH_FILTER_DOMAIN_MODEL";
    public static final String SEARCH_ORIGIN = "searchOrigin";
    private static final String SLIDING_UP_PANEL = "SLIDING_UP_PANEL";
    private final int LIST_MODE = 0;
    private final int MAP_MODE = 1;
    private AbTestService abTestService;
    String availableFacetGroupFiltersFromDeepLink;
    private BadgesAbTestHelper badgesAbTestHelper;
    private Bus bus;
    Channel carouselOriginChannel;
    String currentCategoryId;
    private CurrentDivisionManager currentDivisionManager;
    private DeepLinkUtil deepLinkUtil;
    String deepLinkWithApiParameters;
    private FilterSheetViewFragment filterSheetViewFragment;
    private int globalSearchResultMode;
    protected IncentivesUtil incentivesUtil;
    private IntentFactory intentFactory;
    private boolean isCategoryAttributes1510USCAEnabled;
    boolean isCategoryCarousel;
    boolean isDeepLinked;
    boolean isFromCollectionCard;
    boolean isFromFinderOrCollectionCard;
    boolean isFromGlobalSearch;
    private boolean isGoodsBrandFilter1510USCAEnabled;
    private boolean isGoodsConnectedMarketPlace1504;
    private boolean isRapiEnabled;
    private boolean isShowBadgeOnSearch1509USCA;
    private boolean isShowBandCardOnSearch1510USCA;
    private MenuItem listViewMenuItem;
    private LocationService locationService;
    private LoggingUtils loggingUtils;
    private MenuItem mapViewMenuItem;
    Channel originatingChannel;
    private com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener panelSlideListener;
    private Place place;
    private TextView postSearchText;
    private RapiAbTestHelper rapiAbTestHelper;
    private Fragment resultFragment;
    private SearchAbTestHelper searchAbTestHelper;
    String searchChannelFilter;
    String searchFilter;
    private SearchFilterDomainModel searchFilterDomainModel;
    String searchOrigin;
    private boolean searchResultsOnly;
    Channel searchSourceChannel;
    String searchTerm;
    private java.util.Map.Entry selectedCategory;
    Integer selectedCategoryId;
    Category selectedCategoryItem;
    private SlidingUpPanelLayout slidingUpPanelLayout;
    private DealListTransitionController transitionController;

    public GlobalSearchResult()
    {
        globalSearchResultMode = 0;
        isFromFinderOrCollectionCard = false;
        isFromCollectionCard = false;
    }

    private String channelToPageType(Channel channel)
    {
        static class _cls6
        {

            static final int $SwitchMap$com$groupon$Channel[];
            static final int $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[];

            static 
            {
                $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState = new int[com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.values().length];
                try
                {
                    $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.ANCHORED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.HIDDEN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$sothree$slidinguppanel$SlidingUpPanelLayout$PanelState[com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.EXPANDED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GETAWAYS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.TRAVEL.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls6..SwitchMap.com.groupon.Channel[channel.ordinal()])
        {
        default:
            return "search";

        case 1: // '\001'
        case 2: // '\002'
            return "search";

        case 3: // '\003'
            return "local";

        case 4: // '\004'
        case 5: // '\005'
            return "search";
        }
    }

    private SearchFilterDomainModel getSearchFilterDomainModel()
    {
        if (searchFilterDomainModel == null)
        {
            searchFilterDomainModel = new SearchFilterDomainModel(searchSourceChannel);
            searchFilterDomainModel.includeBrandFacet = isGoodsBrandFilter1510USCAEnabled;
            searchFilterDomainModel.includeCategoryAttributeFacet = isCategoryAttributes1510USCAEnabled;
        }
        return searchFilterDomainModel;
    }

    private boolean isFromBookableFinderCard()
    {
        return searchOrigin != null && isFromFinderOrCollectionCard && searchOrigin.contains("bookable");
    }

    private boolean isFromFoodAndDrinkFinderCard()
    {
        return isFromBookableFinderCard() && searchFilter != null && searchFilter.contains("food-and-drink");
    }

    private FilterValue parseFinderCardSearchFilter(String s)
    {
        if (!Strings.isEmpty(s))
        {
            String s1 = s;
            if (s.startsWith("("))
            {
                s1 = s;
                if (s.endsWith(")"))
                {
                    s1 = s.substring(1, s.lastIndexOf(")"));
                }
            }
            String as[] = s1.split(":");
            if (as.length == 2)
            {
                s = as[0];
                String s2 = as[1];
                if (Strings.equals(s, "category"))
                {
                    return new FilterValue("category", s2);
                }
            }
        }
        return null;
    }

    private void setUpFilterSheet()
    {
        if (filterSheetViewFragment == null)
        {
            initFilterSheetFragment();
        }
    }

    private boolean useRapiSearch()
    {
        return isRapiEnabled && (!isDeepLinked || isFromFinderOrCollectionCard);
    }

    protected void addCustomActionBar()
    {
        if (!searchResultsOnly)
        {
            postSearchText = (TextView)ActionBarUtil.setCustomView(getSupportActionBar(), 0x7f03010e).findViewById(0x7f100323);
            final CharSequence clientConsumedTitle = getClientConsumedTitle();
            final CharSequence searchText;
            if (Strings.isEmpty(clientConsumedTitle))
            {
                searchText = getSearchTextAndUpdateHistoryForDeeplinks();
            } else
            {
                searchText = clientConsumedTitle;
            }
            postSearchText.setText(searchText);
            postSearchText.setOnClickListener(new android.view.View.OnClickListener() {

                final GlobalSearchResult this$0;
                final CharSequence val$clientConsumedTitle;
                final CharSequence val$searchText;

                public void onClick(View view)
                {
                    if (!isDeepLinked && !isCategoryCarousel && isFromGlobalSearch)
                    {
                        setResult(-1);
                        finish();
                        overridePendingTransition(0, 0);
                        return;
                    }
                    if (Strings.notEmpty(searchTerm))
                    {
                        view = searchTerm;
                    } else
                    if (Strings.isEmpty(clientConsumedTitle))
                    {
                        view = searchText.toString();
                    } else
                    {
                        view = "";
                    }
                    if (isCategoryCarousel)
                    {
                        startActivity(intentFactory.newGlobalSearchIntent(searchSourceChannel, view));
                        finish();
                        return;
                    } else
                    {
                        startActivity(intentFactory.newGlobalSearchIntent(getOriginatingNstChannel(), view, isDeepLinked));
                        return;
                    }
                }

            
            {
                this$0 = GlobalSearchResult.this;
                clientConsumedTitle = charsequence;
                searchText = charsequence1;
                super();
            }
            });
        }
    }

    public void addMenuOptions(Menu menu)
    {
        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(0x7f110002, menu);
        listViewMenuItem = menu.findItem(0x7f100593);
        listViewMenuItem.setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

            final GlobalSearchResult this$0;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                globalSearchResultMode = 0;
                switchMode();
                toggleMenuItem();
                return false;
            }

            
            {
                this$0 = GlobalSearchResult.this;
                super();
            }
        });
        menuinflater.inflate(0x7f110003, menu);
        mapViewMenuItem = menu.findItem(0x7f100594);
        mapViewMenuItem.setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

            final GlobalSearchResult this$0;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                globalSearchResultMode = 1;
                switchMode();
                toggleMenuItem();
                return false;
            }

            
            {
                this$0 = GlobalSearchResult.this;
                super();
            }
        });
        toggleMenuItem();
    }

    public String getAvailableFacetGroupFiltersFromDeepLink()
    {
        return availableFacetGroupFiltersFromDeepLink;
    }

    protected CharSequence getClientConsumedTitle()
    {
        if (!isDeepLinked || !Strings.notEmpty(deepLinkWithApiParameters))
        {
            break MISSING_BLOCK_LABEL_54;
        }
        String s = deepLinkUtil.getDeepLink(deepLinkWithApiParameters).getParam("x_client_consumed_title");
        if (Strings.notEmpty(s))
        {
            return s;
        } else
        {
            return "";
        }
        InvalidDeepLinkException invaliddeeplinkexception;
        invaliddeeplinkexception;
        Ln.d(invaliddeeplinkexception);
        return "";
    }

    public String getCurrentCategoryId()
    {
        return currentCategoryId;
    }

    public String getDeepLinkSearchQuery()
    {
        String s = deepLinkUtil.getDeepLink(deepLinkWithApiParameters).getParam("query");
        if (Strings.notEmpty(s))
        {
            return s;
        } else
        {
            return "";
        }
        InvalidDeepLinkException invaliddeeplinkexception;
        invaliddeeplinkexception;
        return "";
    }

    public String getDeepLinkWithApiParameters()
    {
        return deepLinkWithApiParameters;
    }

    public Channel getOriginatingNstChannel()
    {
        if (Strings.notEmpty(originatingChannel))
        {
            return originatingChannel;
        } else
        {
            return Channel.GLOBAL_SEARCH;
        }
    }

    public Place getPlace()
    {
        return place;
    }

    public String getSearchChannelFilter()
    {
        return searchChannelFilter;
    }

    public Channel getSearchSourceChannel()
    {
        return searchSourceChannel;
    }

    public String getSearchTerm()
    {
        return searchTerm;
    }

    protected CharSequence getSearchTextAndUpdateHistoryForDeeplinks()
    {
        if (Strings.notEmpty(deepLinkWithApiParameters))
        {
            String s = getDeepLinkSearchQuery();
            if (Strings.notEmpty(s))
            {
                RecentSearchTermService recentsearchtermservice = (RecentSearchTermService)RoboGuice.getInjector(this).getInstance(com/groupon/service/RecentSearchTermService);
                recentsearchtermservice.init();
                recentsearchtermservice.addRecentlySearchedTerm(s, "");
                return s;
            }
        }
        String s1;
        if (Strings.notEmpty(searchTerm))
        {
            s1 = searchTerm;
        } else
        if (place != null && Strings.notEmpty(place.name))
        {
            s1 = place.name;
        } else
        {
            s1 = getString(0x7f08005e);
        }
        return s1;
    }

    public java.util.Map.Entry getSelectedCategory()
    {
        return selectedCategory;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(false);
    }

    protected void initFilterSheetFragment()
    {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putParcelable("channel", getSearchSourceChannel());
        bundle.putString("search_term", searchTerm);
        String s = com/groupon/fragment/FilterSheetViewFragment.getName();
        filterSheetViewFragment = (FilterSheetViewFragment)FilterSheetViewFragment.instantiate(this, s, bundle);
        fragmenttransaction.replace(0x7f100325, filterSheetViewFragment, s);
        fragmenttransaction.commitAllowingStateLoss();
    }

    protected void initGlobalSearchResultFragment()
    {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        Object obj = locationService.getLocation();
        Object obj2;
        Bundle bundle;
        if (obj != null)
        {
            obj = new Place("", ((Location) (obj)).getLatitude(), ((Location) (obj)).getLongitude());
        } else
        {
            obj = null;
        }
        bundle = new Bundle();
        bundle.putParcelable("channel", getSearchSourceChannel());
        bundle.putParcelable("selected_place", place);
        obj2 = searchTerm;
        if (useRapiSearch())
        {
            String s = com/groupon/fragment/RapiSearchResultContainerFragment.getName();
            resultFragment = RapiSearchResultContainerFragment.instantiate(this, s, bundle);
            Object obj1 = obj2;
            if (Strings.isEmpty(searchTerm))
            {
                obj1 = obj2;
                if (isDeepLinked)
                {
                    obj1 = obj2;
                    if (!Strings.isEmpty(deepLinkWithApiParameters))
                    {
                        obj1 = getDeepLinkSearchQuery();
                    }
                }
            }
            resultFragment.setHasOptionsMenu(true);
            obj2 = new RapiRequestProperties();
            obj2.pageType = channelToPageType(searchSourceChannel);
            obj2.searchQuery = ((String) (obj1));
            obj2.expressedLocation = place;
            obj2.selectedCategory = selectedCategory;
            obj2.currentCategoryId = currentCategoryId;
            obj2.deepLinkWithApiParameters = deepLinkWithApiParameters;
            obj2.availableFacetGroupFiltersFromDeepLink = availableFacetGroupFiltersFromDeepLink;
            obj2.currentLocation = ((Place) (obj));
            obj2.searchChannelFilter = searchChannelFilter;
            ShowPropertyParam showpropertyparam1;
            ShowPropertyParam showpropertyparam2;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (searchSourceChannel == Channel.GETAWAYS)
            {
                obj = com.groupon.models.search.domain.SortMethod.Methods.DISTANCE;
            } else
            {
                obj = com.groupon.models.search.domain.SortMethod.Methods.RELEVANCE;
            }
            obj2.sortMethod = ((com.groupon.models.search.domain.SortMethod) (obj));
            if (rapiAbTestHelper.isPostSearchFiltersRAPI1510Enabled() && useRapiSearch())
            {
                ((RapiRequestProperties) (obj2)).facetFilters.add(new NestedFilter("topcategory|category|subcategory|subcategory2"));
                ((RapiRequestProperties) (obj2)).facetFilters.add(new RangedFilter("price"));
                ((RapiRequestProperties) (obj2)).facetFilters.add(new RangedFilter("distance"));
                if (isGoodsBrandFilter1510USCAEnabled)
                {
                    ((RapiRequestProperties) (obj2)).facetFilters.add(new StaticFilter("brand_uuid"));
                }
                if (isCategoryAttributes1510USCAEnabled)
                {
                    ((RapiRequestProperties) (obj2)).facetFilters.add(new FacetFilter("category_attributes"));
                }
            }
            if (Strings.equals(searchSourceChannel, "nearby"))
            {
                obj2.radiusKm = 15;
            }
            flag1 = incentivesUtil.isExperimentEnabled();
            flag2 = isGoodsConnectedMarketPlace1504;
            if (isShowBadgeOnSearch1509USCA && !isRapiEnabled)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showpropertyparam1 = ApiRequestUtil.getRapiSearchShowParams("deals", flag1, false, flag2, flag, rapiAbTestHelper.isDTFforEitherHBWOrFDEnabled(place));
            flag1 = incentivesUtil.isExperimentEnabled();
            flag2 = isGoodsConnectedMarketPlace1504;
            if (isShowBadgeOnSearch1509USCA && !isRapiEnabled)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showpropertyparam2 = ApiRequestUtil.getRapiSearchShowParams("merchants", flag1, false, flag2, flag, false);
            if (rapiAbTestHelper.isDTFforEitherHBWOrFDEnabled(place))
            {
                ((RapiRequestProperties) (obj2)).removeFacetFilter("bookable");
                DateTimeSearchFilter datetimesearchfilter = new DateTimeSearchFilter("bookable");
                if (isFromBookableFinderCard())
                {
                    bundle.putBoolean("date_time_initial_toggle_state", true);
                    datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getBookableDayFilter(new Date()));
                    if (isFromFoodAndDrinkFinderCard())
                    {
                        datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getPartySizeFilter(2));
                    }
                    obj2.segmentLimit = 3;
                    if (Strings.notEmpty(searchFilter))
                    {
                        FilterValue filtervalue = parseFinderCardSearchFilter(searchFilter);
                        ShowPropertyParam showpropertyparam;
                        if (filtervalue != null)
                        {
                            Filter filter = ((RapiRequestProperties) (obj2)).findFilter("category");
                            obj = filter;
                            if (filter == null)
                            {
                                obj = new Filter("category");
                                ((RapiRequestProperties) (obj2)).filters.add(obj);
                            }
                            ((Filter) (obj)).addFilterValue(filtervalue);
                        } else
                        {
                            obj2.finderCardFilter = searchFilter;
                        }
                    }
                }
                ((RapiRequestProperties) (obj2)).facetFilters.add(datetimesearchfilter);
                obj = new ShowPropertyParam("_metadata");
                ((ShowPropertyParam) (obj)).addField(new ShowPropertyParam("category_intent"));
                ((RapiRequestProperties) (obj2)).showParams.add(obj);
                if (isFromFinderOrCollectionCard)
                {
                    showpropertyparam = showpropertyparam1.findField("options");
                    obj = showpropertyparam;
                    if (showpropertyparam == null)
                    {
                        obj = new ShowPropertyParam("options");
                        showpropertyparam1.addField(((ShowPropertyParam) (obj)));
                    }
                    ((ShowPropertyParam) (obj)).addField(new ShowPropertyParam("bookableSegments"));
                }
            }
            if (isFromCollectionCard)
            {
                obj2.finderCardFilter = searchFilter;
            }
            ((RapiRequestProperties) (obj2)).showParams.add(showpropertyparam1);
            ((RapiRequestProperties) (obj2)).showParams.add(showpropertyparam2);
            if (isShowBadgeOnSearch1509USCA)
            {
                ((RapiRequestProperties) (obj2)).showParams.add(new ShowPropertyParam("_badges"));
            }
            if (isShowBandCardOnSearch1510USCA)
            {
                obj = new ShowPropertyParam("bands");
                ((ShowPropertyParam) (obj)).addField(new ShowPropertyParam("message"));
                ((RapiRequestProperties) (obj2)).showParams.add(obj);
            }
            bundle.putParcelable("BUNDLE_SEARCH_PROPERTIES", ((android.os.Parcelable) (obj2)));
            obj = s;
        } else
        {
            obj = com/groupon/fragment/GlobalSearchResultFragment.getName();
            resultFragment = GlobalSearchResultFragment.instantiate(this, ((String) (obj)), bundle);
            resultFragment.setHasOptionsMenu(true);
            ((GlobalSearchResultFragment)resultFragment).setSearchTerm(((String) (obj2)));
        }
        fragmenttransaction.setCustomAnimations(0x10b0000, 0x10b0001);
        fragmenttransaction.replace(0x7f100171, resultFragment, ((String) (obj)));
        fragmenttransaction.commitAllowingStateLoss();
    }

    public boolean isDeepLinked()
    {
        return isDeepLinked;
    }

    public boolean isListMode()
    {
        return globalSearchResultMode == 0;
    }

    public void onActivityReenter(int i, Intent intent)
    {
        super.onActivityReenter(i, intent);
        transitionController.setReentering(true);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = intentFactory.newCarouselChannelIntent(carouselOriginChannel, new String[0]);
        intent.putExtra("refreshCarousel", isDeepLinked);
        startActivity(intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03010f);
        isRapiEnabled = searchAbTestHelper.isRapiSearch1511Enabled();
        isGoodsConnectedMarketPlace1504 = abTestService.isVariantEnabledAndUSCA("goodsConnectedMarketplaceUSCA1504", "on");
        isShowBadgeOnSearch1509USCA = badgesAbTestHelper.isShowBadgeOnSearch();
        isGoodsBrandFilter1510USCAEnabled = rapiAbTestHelper.isGoodsBrandFilter1510USCAEnabled();
        isCategoryAttributes1510USCAEnabled = rapiAbTestHelper.isCategoryAttributesFilter1510USCAEnabled();
        isShowBandCardOnSearch1510USCA = abTestService.isVariantEnabled("showBandCardOnSearch1510USCA", "on");
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            transitionController.setExitSharedElementCallback();
        }
        Bundle bundle1 = getIntent().getBundleExtra("selected_place_bundle");
        if (bundle1 != null)
        {
            place = (Place)bundle1.getParcelable("selected_place");
        }
        if ((place == null || !place.isValid()) && Strings.notEmpty(deepLinkWithApiParameters))
        {
            try
            {
                DeepLinkData deeplinkdata = deepLinkUtil.getDeepLink(deepLinkWithApiParameters);
                place = new Place("", Double.parseDouble(deeplinkdata.getParam("lat")), Double.parseDouble(deeplinkdata.getParam("lng")), "", "");
            }
            catch (Exception exception) { }
        }
        if (place == null || !place.isValid())
        {
            place = Place.geoPointToPlace(currentDivisionManager.getCurrentDivision().geoPoint);
        }
        if (selectedCategoryItem != null && selectedCategoryId != null)
        {
            selectedCategory = new java.util.AbstractMap.SimpleEntry(selectedCategoryItem, selectedCategoryId);
        }
        searchResultsOnly = getIntent().getBooleanExtra("search_results_only", false);
        if (bundle != null) goto _L2; else goto _L1
_L1:
        initGlobalSearchResultFragment();
_L4:
        if (useRapiSearch())
        {
            ((RapiSearchResultContainerFragment)resultFragment).setRapiResponseListener(this);
        }
        if (rapiAbTestHelper.isPostSearchFiltersRAPI1510Enabled() && useRapiSearch())
        {
            if (bundle != null)
            {
                searchFilterDomainModel = (SearchFilterDomainModel)bundle.getParcelable("SEARCH_FILTER_DOMAIN_MODEL");
            }
            setUpFilterSheet();
            slidingUpPanelLayout = (SlidingUpPanelLayout)findViewById(0x7f100324);
            panelSlideListener = new com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener() {

                private boolean fullSize;
                final GlobalSearchResult this$0;

                public void onPanelAnchored(View view)
                {
                    fullSize = false;
                    bus.post(new ResizeFilterSheetEvent((float)(slidingUpPanelLayout.getHeight() - slidingUpPanelLayout.getPanelHeight()) * slidingUpPanelLayout.getAnchorPoint()));
                    ((RapiSearchResultContainerFragment)resultFragment).showFilterSheetBackgroundTouchInterceptor(true);
                }

                public void onPanelCollapsed(View view)
                {
                    ((RapiSearchResultContainerFragment)resultFragment).showFilterSheetBackgroundTouchInterceptor(false);
                }

                public void onPanelExpanded(View view)
                {
                    ((RapiSearchResultContainerFragment)resultFragment).showFilterSheetBackgroundTouchInterceptor(true);
                }

                public void onPanelHidden(View view)
                {
                    ((RapiSearchResultContainerFragment)resultFragment).showFilterSheetBackgroundTouchInterceptor(false);
                }

                public void onPanelSlide(View view, float f)
                {
                    if (!fullSize && f > slidingUpPanelLayout.getAnchorPoint())
                    {
                        fullSize = true;
                        bus.post(new ResizeFilterSheetEvent(slidingUpPanelLayout.getHeight()));
                    }
                }

            
            {
                this$0 = GlobalSearchResult.this;
                super();
            }
            };
            slidingUpPanelLayout.setPanelSlideListener(panelSlideListener);
        }
        addCustomActionBar();
        configureShoppingCartIcon();
        restoreState(bundle);
        return;
_L2:
        resultFragment = getFragmentManager().findFragmentById(0x7f100171);
        filterSheetViewFragment = (FilterSheetViewFragment)getFragmentManager().findFragmentById(0x7f100325);
        if (resultFragment == null)
        {
            initGlobalSearchResultFragment();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        if (Strings.equals(searchSourceChannel, "goods"))
        {
            return false;
        } else
        {
            addMenuOptions(menu);
            return true;
        }
    }

    public void onDealCountUpdated(int i)
    {
    }

    public void onDestroy()
    {
        if (listViewMenuItem != null)
        {
            listViewMenuItem.setOnMenuItemClickListener(null);
        }
        if (mapViewMenuItem != null)
        {
            mapViewMenuItem.setOnMenuItemClickListener(null);
        }
        if (postSearchText != null)
        {
            postSearchText.setOnClickListener(null);
        }
        if (useRapiSearch())
        {
            ((RapiSearchResultContainerFragment)resultFragment).setRapiResponseListener(null);
        }
        super.onDestroy();
    }

    public void onExpandFilterSheet(ExpandFilterSheetEvent expandfiltersheetevent)
    {
        SlidingUpPanelLayout slidinguppanellayout = slidingUpPanelLayout;
        if (expandfiltersheetevent.isExpanded)
        {
            expandfiltersheetevent = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.ANCHORED;
        } else
        {
            expandfiltersheetevent = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED;
        }
        slidinguppanellayout.setPanelState(expandfiltersheetevent);
    }

    public void onFacetsUpdated()
    {
    }

    protected void onPause()
    {
        if (rapiAbTestHelper.isPostSearchFiltersRAPI1510Enabled() && useRapiSearch())
        {
            getSearchFilterDomainModel().removeSearchFilterDomainModelListener(this);
            bus.unregister(this);
            if (resultFragment.getView() != null)
            {
                resultFragment.getView().findViewById(0x7f1004a5).setOnClickListener(null);
            }
            getSearchFilterDomainModel().unRegisterBus();
        }
        super.onPause();
    }

    public void onRapiResponseAvailable(RapiSearchResponse rapisearchresponse)
    {
        SearchFilterDomainModel searchfilterdomainmodel = getSearchFilterDomainModel();
        searchfilterdomainmodel.setFacets(rapisearchresponse.facets);
        searchfilterdomainmodel.setDealCount(rapisearchresponse.pagination.getCount());
    }

    protected void onResume()
    {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0)
        {
            Toast.makeText(this, 0x7f080199, 0).show();
            setResult(-1);
            finish();
        }
        if (rapiAbTestHelper.isPostSearchFiltersRAPI1510Enabled() && useRapiSearch())
        {
            bus.register(this);
            SearchFilterDomainModel searchfilterdomainmodel = getSearchFilterDomainModel();
            searchfilterdomainmodel.registerBus(bus);
            searchfilterdomainmodel.addSearchFilterDomainModelListener(this);
            FilterSheetPresenter filtersheetpresenter = filterSheetViewFragment.getPresenter();
            searchfilterdomainmodel.addSearchFilterDomainModelListener(filtersheetpresenter);
            filtersheetpresenter.setSearchFilterDomainModel(searchfilterdomainmodel);
            if (resultFragment.getView() != null)
            {
                View view = resultFragment.getView().findViewById(0x7f1004a5);
                view.setOnClickListener(null);
                view.setOnClickListener(new android.view.View.OnClickListener() {

                    final GlobalSearchResult this$0;

                    public void onClick(View view2)
                    {
                        logger.logClick("", "filtersheet_dimmed_click", searchSourceChannel.toString(), Logger.NULL_NST_FIELD, Logger.NULL_NST_FIELD);
                        slidingUpPanelLayout.setPanelState(com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED);
                    }

            
            {
                this$0 = GlobalSearchResult.this;
                super();
            }
                });
            }
            if (filterSheetViewFragment.getView() != null)
            {
                View view1 = filterSheetViewFragment.getView().findViewById(0x7f10028e);
                slidingUpPanelLayout.setDragView(view1);
                view1.setClickable(false);
                view1.setOnClickListener(null);
            }
        }
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("global_search_result_mode", globalSearchResultMode);
        if (rapiAbTestHelper.isPostSearchFiltersRAPI1510Enabled() && useRapiSearch())
        {
            bundle.putParcelable("SEARCH_FILTER_DOMAIN_MODEL", searchFilterDomainModel);
            bundle.putParcelable("SLIDING_UP_PANEL", slidingUpPanelLayout.onSaveInstanceState());
        }
        super.onSaveInstanceState(bundle);
    }

    public void onScrollableActivated()
    {
        if (panelSlideListener == null)
        {
            return;
        }
        switch (_cls6..SwitchMap.com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState[slidingUpPanelLayout.getPanelState().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            panelSlideListener.onPanelAnchored(slidingUpPanelLayout);
            return;

        case 2: // '\002'
            panelSlideListener.onPanelHidden(slidingUpPanelLayout);
            return;

        case 3: // '\003'
            panelSlideListener.onPanelExpanded(slidingUpPanelLayout);
            break;
        }
    }

    public void onSearchFilterDomainModelSyncCompleted()
    {
    }

    public void onSearchFilterDomainModelSyncRequested()
    {
        if (rapiAbTestHelper.isPostSearchFiltersRAPI1510Enabled() && useRapiSearch())
        {
            RapiSearchResultContainerFragment rapisearchresultcontainerfragment = (RapiSearchResultContainerFragment)resultFragment;
            rapisearchresultcontainerfragment.updateSortMethod(getSearchFilterDomainModel().getSelectedSortMethod());
            rapisearchresultcontainerfragment.updateFacetFilters(getSearchFilterDomainModel().generateFilters());
            rapisearchresultcontainerfragment.resetSearch();
            rapisearchresultcontainerfragment.reloadDeals();
        }
    }

    protected void restoreState(Bundle bundle)
    {
        if (bundle != null)
        {
            globalSearchResultMode = bundle.getInt("global_search_result_mode", 0);
            if (rapiAbTestHelper.isPostSearchFiltersRAPI1510Enabled() && useRapiSearch())
            {
                bundle = bundle.getParcelable("SLIDING_UP_PANEL");
                if (bundle != null)
                {
                    slidingUpPanelLayout.onRestoreInstanceState(bundle);
                }
            }
        }
    }

    public void setHasMoreItems(boolean flag)
    {
        toggleMenuItem();
    }

    public void switchMode()
    {
        LoggingUtils loggingutils = loggingUtils;
        String s1 = searchSourceChannel.toString();
        String s;
        if (globalSearchResultMode == 0)
        {
            s = "Deals_list\u200B";
        } else
        {
            s = "Map\u200B";
        }
        loggingutils.logClickWithMetadata("", "map_list_view_click", s1, new GlobalSearchToggleMetadata(s, "toolbar\u200B"));
        if (globalSearchResultMode == 0)
        {
            ((SearchServiceInterface)resultFragment).switchToList();
        } else
        if (globalSearchResultMode == 1)
        {
            ((SearchServiceInterface)resultFragment).switchToMap();
            return;
        }
    }

    public void toggleFilterSheetView(ToggleFilterSheetEvent togglefiltersheetevent)
    {
        if (slidingUpPanelLayout.getPanelState() == com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED)
        {
            slidingUpPanelLayout.setPanelState(com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.ANCHORED);
            logger.logPageView("", com/groupon/fragment/FilterSheetViewFragment.getSimpleName(), Logger.NULL_NST_FIELD);
            return;
        } else
        {
            slidingUpPanelLayout.setPanelState(com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED);
            return;
        }
    }

    protected void toggleMenuItem()
    {
        boolean flag1 = true;
        if (listViewMenuItem == null || mapViewMenuItem == null)
        {
            return;
        }
        MenuItem menuitem = listViewMenuItem;
        boolean flag;
        if (globalSearchResultMode == 1 && !searchResultsOnly)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menuitem.setVisible(flag);
        menuitem = mapViewMenuItem;
        if (globalSearchResultMode == 0 && !searchResultsOnly)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        menuitem.setVisible(flag);
    }





/*
    static int access$302(GlobalSearchResult globalsearchresult, int i)
    {
        globalsearchresult.globalSearchResultMode = i;
        return i;
    }

*/

}
