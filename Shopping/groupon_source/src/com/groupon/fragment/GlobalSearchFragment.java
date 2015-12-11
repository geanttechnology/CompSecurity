// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.f2prateek.dart.Dart;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.groupon.Channel;
import com.groupon.abtest.GtgAbTestHelper;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.activity.GlobalSearch;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.SnapOfferGridActivity;
import com.groupon.adapter.BaseGlobalSearchLocationIndexerAdapter;
import com.groupon.adapter.FilteringAdapter;
import com.groupon.adapter.GlobalCategoriesAdapter;
import com.groupon.adapter.LocationIndexerAdapter;
import com.groupon.models.Place;
import com.groupon.models.SearchSuggestion;
import com.groupon.models.SearchTermAndCategory;
import com.groupon.models.category.Category;
import com.groupon.models.country.Country;
import com.groupon.models.nst.GlobalSearchAutoCompleteClickMetadata;
import com.groupon.models.nst.GlobalSearchCategoryClickExtraInfo;
import com.groupon.models.nst.GlobalSearchClickToPerformSearchMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.SearchSuggestionClickExtraInfo;
import com.groupon.models.nst.SnapGroceryGenericMetadata;
import com.groupon.service.CategoryService;
import com.groupon.service.GlobalSearchService;
import com.groupon.service.RecentSearchTermService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.gdt.GdtService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CategoriesUtil;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function1;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.util.GlobalSearchUtil;
import com.groupon.util.LayoutUtil;
import com.groupon.util.LocationAutocompleteClient;
import com.groupon.util.LocationSearchUtil;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.LoggingUtils;
import com.groupon.util.SearchInterfaceListener;
import com.groupon.util.SearchInterfaceProvider;
import com.groupon.util.ViewUtils;
import com.groupon.view.ClearableEditText;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apmem.tools.layouts.FlowLayout;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

public class GlobalSearchFragment extends Fragment
    implements LocationAutocompleteClient, SearchInterfaceListener
{
    protected class GlobalSearchState
    {

        private int currentMode;
        private boolean showTextOrLocationSearchResult;
        final GlobalSearchFragment this$0;

        public int getCurrentMode()
        {
            return currentMode;
        }

        public boolean isSearchModeLocationSearch()
        {
            return currentMode == 1;
        }

        public boolean isSearchModeTextSearch()
        {
            return currentMode == 0;
        }

        public void setCurrentMode(int i)
        {
            currentMode = i;
        }

        public void setShowTextOrLocationSearchResult(boolean flag)
        {
            if (showTextOrLocationSearchResult == flag)
            {
                return;
            }
            showTextOrLocationSearchResult = flag;
            if (isReloadGlobalCategoriesList)
            {
                isReloadGlobalCategoriesList = false;
                reloadCategoriesList();
            }
            setViewOnGlobalStateChange();
        }

        public void switchToSearchModeLocationSearch()
        {
            currentMode = 1;
            setViewOnGlobalStateChange();
        }

        public void switchToSearchModeTextSearch()
        {
            currentMode = 0;
            setViewOnGlobalStateChange();
        }


        public GlobalSearchState()
        {
            this$0 = GlobalSearchFragment.this;
            super();
            currentMode = 0;
            showTextOrLocationSearchResult = false;
        }
    }

    static class IndexerAdapter extends FilteringAdapter
    {

        protected String getStringRepresentation(SearchSuggestion searchsuggestion)
        {
            return searchsuggestion.value;
        }

        protected volatile String getStringRepresentation(Object obj)
        {
            return getStringRepresentation((SearchSuggestion)obj);
        }

        public IndexerAdapter(Context context1, int i, List list)
        {
            super(context1, i, list);
        }
    }

    static class SearchTermIndexerAdapter extends FilteringAdapter
    {

        protected String getStringRepresentation(SearchTermAndCategory searchtermandcategory)
        {
            return searchtermandcategory.getSearchTerm();
        }

        protected volatile String getStringRepresentation(Object obj)
        {
            return getStringRepresentation((SearchTermAndCategory)obj);
        }

        public SearchTermIndexerAdapter(Context context1, int i, List list)
        {
            super(context1, i, list);
        }
    }


    private static final int BROWSE_BY_CATEGORY_TREE_DEPTH = 2;
    private static final String CATEGORY_CLICK = "category_click";
    private static final String CATEGORY_FACET_GROUP_FILTERS = "category_facet_group_filters";
    private static final String CATEGORY_LEVEL_2 = "L2";
    private static final String CATEGORY_LEVEL_3 = "L3";
    private static final String CATEGORY_SELECTION_CLICK = "category_selection_click";
    public static final String CHANNEL;
    private static final String CURRENT_CATEGORY = "current_category";
    private static final String CURRENT_CATEGORY_ID = "current_category_id";
    private static final String CURRENT_CATEGORY_LEVEL = "current_category_level";
    private static final String CURRENT_SEARCH_KEYWORD = "current_search_keyword";
    private static final String GLOBAL_SEARCH_MODE = "global_search_mode";
    private static final int GLOBAL_SEARCH_TREE_DEPTH = 3;
    private static final String GROCERY_ID = "groceries";
    private static final String GROCERY_SEARCH_ALL_CLICK = "groceries_search_all_click";
    private static final int INDEX_START_EXPANDED_CATEGORY = 2;
    private static final int REQUEST_CODE = 100;
    private static final String SEARCH_FILTER_CHANNEL = "search_filter_channel";
    private static final String SEARCH_SOURCE_CHANNEL = "search_source_channel";
    private static final String SUB_CATEGORY_CLICK = "sub-category_click";
    String CURRENT_LOCATION;
    private final int MAX_NUM_RECENTLY_SEARCHED = 3;
    private final int MAX_NUM_RECENTLY_SEARCHED_GETAWAYS = 7;
    private final int SEARCH_MODE_LOCATION_SEARCH = 1;
    private final int SEARCH_MODE_TEXT_SEARCH = 0;
    protected ListView autocompleteListView;
    private String availableFacetGroupFiltersFromDeepLink;
    private NewCartAbTestHelper cartAbTestHelper;
    private GlobalCategoriesAdapter categoriesAdapter;
    protected ProgressBar categoriesProgress;
    protected ListView categoriesSection;
    private CategoriesUtil categoriesUtil;
    Category categoryFromGoods;
    private CategoryService categoryService;
    private Context context;
    private String currentCategoryId;
    private CurrentCountryManager currentCountryManager;
    private DeviceInfoUtil deviceInfoUtil;
    private GdtService gdtService;
    private GeoUtils geoUtils;
    LinearLayout globalSearch;
    private GlobalSearchService globalSearchService;
    private GlobalSearchState globalSearchState;
    private GlobalSearchUtil globalSearchUtil;
    private GtgAbTestHelper gtgAbTestHelper;
    private LayoutInflater inflater;
    protected Lazy intentFactory;
    boolean isBrowseByCategory;
    private boolean isDeepLinked;
    private boolean isGTGOnSearch;
    private boolean isGlobalSearchChannelSelector1506;
    private boolean isGlobalSearchRedesign1505;
    private boolean isReloadCategories;
    private boolean isReloadGlobalCategoriesList;
    private boolean isUpdateTags;
    private LayoutUtil layoutUtil;
    private LocationsAutocompleteServiceWrapper locationAutocompleteServiceWrapper;
    private EditText locationSearchEditText;
    private ImageView locationSearchIcon;
    private LocationSearchUtil locationSearchUtil;
    ClearableEditText locationSearchView;
    private Logger logger;
    private LoggingUtils loggingUtils;
    protected LinearLayout popularBox;
    protected FlowLayout popularList;
    protected TextView popularSearchLabel;
    private List popularSearches;
    protected LinearLayout recentBox;
    protected FlowLayout recentList;
    protected LinearLayout recentListView;
    protected LinearLayout recentSearchContainer;
    private RecentSearchTermService recentSearchTermService;
    private SearchAbTestHelper searchAbTestHelper;
    private String searchFilterChannel;
    private SearchInterfaceProvider searchInterfaceProvider;
    protected View searchLocationContainer;
    private boolean searchResultsOnly;
    private Channel searchSourceChannel;
    String searchTerm;
    private java.util.Map.Entry selectedCategory;
    protected ProgressBar spinner;
    protected LinearLayout suggestionsContainer;
    protected ScrollView tagsSection;
    private List textSuggestionsList;

    public GlobalSearchFragment()
    {
    }

    private void addCategory(Category category, Category category1, Map map)
    {
        if (category != null && map != null)
        {
            List list = (List)map.get(category);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
            }
            if (category1 != null)
            {
                ((List) (obj)).add(category1);
            }
            map.put(category, obj);
        }
    }

    private void addRecentlySearchedTerm(String s, String s1)
    {
        s = recentSearchTermService.addRecentlySearchedTerm(s, s1);
        recentBox.setVisibility(8);
        recentSearchContainer.setVisibility(8);
        if (isGlobalSearchRedesign1505)
        {
            updateSearchTags(s, recentListView, recentSearchContainer, "recent_search_click");
            return;
        } else
        {
            updateSearchTags(s, recentList, recentBox, "recent_search_click");
            return;
        }
    }

    private void addSubcategory(Category category, Category category1, Map map)
    {
        Iterator iterator = category1.getChildren().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Category category2 = (Category)iterator.next();
            category2.parent = category;
            if (category2.count > 0 && Strings.notEmpty(category2.friendlyName))
            {
                category1.hasSubcategories = true;
                category2.isSubcategory = true;
                addCategory(category1, category2, map);
                addSubcategory(category, category2, map);
            }
        } while (true);
    }

    private void createLocationWithGeocoder(final String locationKeyword)
    {
        locationSearchUtil.geocoderSearchForLocation(new Function1() {

            final GlobalSearchFragment this$0;
            final String val$locationKeyword;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                locationSearchEditText.clearFocus();
                String s;
                EditText edittext;
                if (list != null && !list.isEmpty())
                {
                    locationAutocompleteServiceWrapper.saveRecentLocation((Place)list.get(0));
                } else
                {
                    Toast.makeText(getActivity().getApplicationContext(), getString(0x7f080155), 1).show();
                }
                edittext = locationSearchEditText;
                if (list != null && !list.isEmpty())
                {
                    s = ((Place)list.get(0)).name;
                } else
                {
                    s = locationKeyword;
                }
                edittext.setText(s);
                if (list != null)
                {
                    reloadOnkeypress();
                    return;
                } else
                {
                    locationSearchEditText.requestFocus();
                    return;
                }
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                locationKeyword = s;
                super();
            }
        }, new Function1() {

            final GlobalSearchFragment this$0;
            final String val$locationKeyword;

            public void execute(Exception exception)
                throws RuntimeException
            {
                if (exception instanceof IOException)
                {
                    Toast.makeText(getActivity().getApplicationContext(), getString(0x7f080162), 1).show();
                } else
                if (exception instanceof NullPointerException)
                {
                    Toast.makeText(getActivity().getApplicationContext(), getString(0x7f080155), 1).show();
                } else
                {
                    Toast.makeText(getActivity().getApplicationContext(), 0x7f080165, 1).show();
                }
                geoUtils.logGeocodeException(exception, com/groupon/activity/GlobalSearch.getSimpleName());
                locationSearchEditText.setText(locationKeyword);
                locationSearchEditText.requestFocus();
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                locationKeyword = s;
                super();
            }
        }, locationKeyword, 1);
    }

    private void getCategoryList(final String facet, final String relevanceContext)
    {
        final Category parent = categoriesUtil.getTitleFromFacet(facet, context);
        parent = new Category(null, facet, parent, parent, -1);
        final String friendlyName = categoriesUtil.getStringFromFacet(facet, context);
        final Channel currentSourceChannel = searchSourceChannel;
        CategoryService categoryservice = categoryService;
        Activity activity = getActivity();
        byte byte0;
        if (isBrowseByCategory)
        {
            byte0 = 2;
        } else
        {
            byte0 = 3;
        }
        categoryservice.getGlobalCategories(activity, facet, relevanceContext, byte0, new Function1() {

            final GlobalSearchFragment this$0;
            final Channel val$currentSourceChannel;
            final String val$facet;
            final String val$friendlyName;
            final Category val$parent;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                if (!searchSourceChannel.equals(currentSourceChannel))
                {
                    return;
                } else
                {
                    String s = categoriesUtil.getRelevanceContext(facet);
                    Category category = new Category(parent, s, friendlyName, friendlyName, -1);
                    category.isAllDeals = true;
                    category.relevanceContext = s;
                    updateCategoryList(parent, category, list);
                    return;
                }
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                currentSourceChannel = channel;
                facet = s;
                parent = category;
                friendlyName = s1;
                super();
            }
        }, new Function1() {

            final GlobalSearchFragment this$0;
            final Channel val$currentSourceChannel;
            final String val$friendlyName;
            final Category val$parent;
            final String val$relevanceContext;

            public void execute(Exception exception)
            {
                if (!searchSourceChannel.equals(currentSourceChannel))
                {
                    return;
                } else
                {
                    exception = new Category(parent, relevanceContext, friendlyName, friendlyName, -1);
                    exception.isAllDeals = true;
                    exception.relevanceContext = relevanceContext;
                    updateCategoryList(parent, exception, null);
                    categoriesProgress.setVisibility(8);
                    showPopularSearches();
                    return;
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                currentSourceChannel = channel;
                parent = category;
                relevanceContext = s;
                friendlyName = s1;
                super();
            }
        });
    }

    private int getMaxRecentSearchesForChannel(Channel channel)
    {
        return channel != Channel.GETAWAYS ? 3 : 7;
    }

    private void getPopularSearches()
    {
        categoryService.getSearchDealCategories(getActivity(), new Function1() {

            final GlobalSearchFragment this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                if (list.size() > 0)
                {
                    popularSearches = new ArrayList();
                    String s;
                    Object obj;
                    for (list = list.iterator(); list.hasNext(); popularSearches.add(new SearchTermAndCategory(s, ((String) (obj)))))
                    {
                        obj = (Category)list.next();
                        s = ((Category) (obj)).friendlyName.replaceAll("\"", "");
                        obj = ((Category) (obj)).id.replaceAll("\"", "");
                    }

                    if (tagsSection.getVisibility() == 0 || searchTerm != null || isUpdateTags)
                    {
                        isUpdateTags = false;
                        updateSearchTags(popularSearches, popularList, popularBox, "popular_category_click");
                    }
                }
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
        });
    }

    private void getTextSuggestionsList(final String searchTerm)
    {
        String s = Strings.toString(searchInterfaceProvider.getQueryText());
        if (Strings.notEmpty(s))
        {
            globalSearchService.getTextSuggestions(new Function1() {

                final GlobalSearchFragment this$0;
                final String val$searchTerm;

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((List)obj);
                }

                public void execute(List list)
                {
                    if (getActivity() != null)
                    {
                        if (list.size() > 0)
                        {
                            textSuggestionsList = new ArrayList(list);
                            if (tagsSection.getVisibility() == 8 && globalSearchState.isSearchModeTextSearch())
                            {
                                showTextSuggestionsList(searchTerm, null);
                                return;
                            }
                        } else
                        {
                            loggingUtils.logTextSearch("", searchTerm, "", searchTerm.length(), null);
                            resetTextSuggestionsList();
                            return;
                        }
                    }
                }

            
            {
                this$0 = GlobalSearchFragment.this;
                searchTerm = s;
                super();
            }
            }, s);
            autocompleteListView.setFastScrollEnabled(true);
            return;
        } else
        {
            resetTextSuggestionsList();
            showTextSuggestionsList(searchTerm, recentSearchTermService.getRecentlySearchedTerms(true));
            return;
        }
    }

    private void globalSearchInit()
    {
        globalSearchState = new GlobalSearchState();
        locationAutocompleteServiceWrapper.setLocationAutocompleteClient(this);
        recentSearchTermService.init();
        updateCategoriesList();
        initializeTextSearchView();
    }

    private void handleDeepLinkLocation(GeoPoint geopoint)
    {
        if (geopoint != null)
        {
            geopoint = new Place("", geopoint.getLatitudeDegrees(), geopoint.getLongitudeDegrees(), "", "");
            locationAutocompleteServiceWrapper.setCurrentlySelectedPlace(geopoint);
        }
    }

    private void handleDeeplinkingSearch()
    {
        isDeepLinked = getActivity().getIntent().getBooleanExtra("isDeepLinked", false);
        if (isDeepLinked)
        {
            String s1 = getActivity().getIntent().getStringExtra("global_search_query");
            String s = getActivity().getIntent().getStringExtra("category");
            String s2 = getActivity().getIntent().getStringExtra("interest");
            String s3 = getActivity().getIntent().getStringExtra("facet_group_filters");
            GeoPoint geopoint = (GeoPoint)getActivity().getIntent().getParcelableExtra("global_search_geopoint");
            if (Strings.notEmpty(s3))
            {
                availableFacetGroupFiltersFromDeepLink = s3;
            }
            handleDeepLinkLocation(geopoint);
            if (Strings.notEmpty(s2))
            {
                s1 = Strings.capitalize(s2.split(Pattern.quote(","))[0].replaceAll(Pattern.quote("-"), " "));
                if (!Strings.notEmpty(s))
                {
                    s = "";
                }
                addRecentlySearchedTerm(s1, s);
                setTextValueAndReloadDeals(s1, s, true);
                return;
            }
            if (Strings.notEmpty(s))
            {
                s1 = Strings.capitalize(s.replaceAll(Pattern.quote("-"), " "));
                addRecentlySearchedTerm(s1, s);
                setTextValueAndReloadDeals(s1, s, true);
                return;
            }
            if (Strings.notEmpty(s1))
            {
                addRecentlySearchedTerm(s1, "");
                setTextValueAndReloadDeals(s1, "", true);
                return;
            }
            if (locationAutocompleteServiceWrapper.getCurrentlySelectedPlace() != null)
            {
                setTextValueAndReloadDeals("", "", false);
                return;
            }
        }
    }

    private void initializeLocationSearchView()
    {
        locationSearchEditText = (EditText)locationSearchView.findViewById(0x7f1001a3);
        locationSearchIcon = (ImageView)locationSearchView.findViewById(0x7f1001a2);
        if (currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
        {
            locationSearchEditText.addTextChangedListener(locationAutocompleteServiceWrapper.getTextWatcher());
        }
        locationSearchEditText.setImeOptions(3);
        if (!cartAbTestHelper.isShoppingCartEnabled())
        {
            locationSearchView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final GlobalSearchFragment this$0;

                public void onGlobalLayout()
                {
                    locationSearchView.setWidth(searchInterfaceProvider.getMeasuredWidth());
                    locationSearchView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
            });
        }
        locationSearchEditText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final GlobalSearchFragment this$0;

            public void onFocusChange(View view, boolean flag)
            {
                int i;
                if (flag)
                {
                    globalSearchState.switchToSearchModeLocationSearch();
                    loggingUtils.logClick("", "location_box_click", "global_search", "");
                    if (Strings.equalsIgnoreCase(Strings.toString(locationSearchEditText.getText()), CURRENT_LOCATION))
                    {
                        locationSearchEditText.setText("");
                    }
                    locationAutocompleteServiceWrapper.searchLocation(Strings.toString(locationSearchEditText.getText()));
                } else
                {
                    locationSearchEditText.setText(locationAutocompleteServiceWrapper.getTopListSearchLocation().value);
                }
                view = locationSearchIcon;
                if (flag)
                {
                    i = 0x7f020260;
                } else
                {
                    i = 0x7f020262;
                }
                view.setImageResource(i);
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
        });
        locationSearchEditText.setOnClickListener(new android.view.View.OnClickListener() {

            final GlobalSearchFragment this$0;

            public void onClick(View view)
            {
                locationAutocompleteServiceWrapper.searchLocation(Strings.toString(locationSearchEditText.getText()));
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
        });
        locationSearchEditText.setOnKeyListener(new android.view.View.OnKeyListener() {

            final GlobalSearchFragment this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if (i == 66)
                {
                    triggerNewSearchAndReload();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
        });
        locationSearchEditText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final GlobalSearchFragment this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 3)
                {
                    triggerNewSearchAndReload();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
        });
    }

    private void initializeTextSearchView()
    {
        initializeLocationSearchView();
        if (searchResultsOnly)
        {
            searchInterfaceProvider.setSearchBarVisibility(4);
        }
        if (!isFromGoodsCategoryTab() && !isBrowseByCategory)
        {
            searchInterfaceProvider.requestTextFocus();
            if (layoutUtil.isLandscape() && !deviceInfoUtil.isTablet())
            {
                ViewUtils.forceShowKeyboard(context, true);
            }
        } else
        {
            searchLocationContainer.requestFocus();
        }
        if (searchTerm != null)
        {
            if (!isFromGoodsCategoryTab() && !isBrowseByCategory)
            {
                searchInterfaceProvider.requestTextFocus();
            }
            searchInterfaceProvider.setQueryText(searchTerm);
            searchInterfaceProvider.setSelection(searchTerm.length());
        }
        resetTextSuggestionsList();
        tagsSection.setOnTouchListener(new android.view.View.OnTouchListener() {

            final GlobalSearchFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                searchInterfaceProvider.clearFocus();
                return false;
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
        });
        updateLocationBarVisibility();
        locationSearchEditText.setText(locationAutocompleteServiceWrapper.getCurrentlySelectedPlace().value);
    }

    private boolean isFromGoodsCategoryTab()
    {
        return categoryFromGoods != null;
    }

    private boolean isSearchInitialized()
    {
        return searchInterfaceProvider.isInitialized();
    }

    private boolean isSuggestionsEnabled()
    {
        return isGTGOnSearch;
    }

    private boolean isTextSearch()
    {
        return searchInterfaceProvider != null && searchInterfaceProvider.hasFocus();
    }

    private void processCategories(Category category, Category category1, Map map)
    {
        category1.parent = category;
        if (category1.count > 0 && Strings.notEmpty(category1.friendlyName))
        {
            addCategory(category1, null, map);
            addSubcategory(category, category1, map);
        }
    }

    private void refresh(String s, String s1, boolean flag)
    {
        reload(s, s1, flag);
    }

    private void reloadCategories()
    {
label0:
        {
            if (isReloadCategories)
            {
                isReloadCategories = false;
                isUpdateTags = true;
                if (!isGlobalSearchRedesign1505)
                {
                    break label0;
                }
                isReloadGlobalCategoriesList = true;
            }
            return;
        }
        setRecentSearchesAndSuggestionsHeader();
        reloadCategoriesList();
        updateSearchTags(recentSearchTermService.getRecentlySearchedTerms(true), recentList, recentBox, "recent_search_click");
    }

    private void reloadCategoriesList()
    {
        categoriesSection.setAdapter(null);
        categoriesAdapter = null;
        updateCategoriesList();
    }

    private void reloadOnkeypress()
    {
        selectedCategory = null;
        String s = searchInterfaceProvider.getQueryText();
        if (Strings.notEmpty(s))
        {
            addRecentlySearchedTerm(Strings.toString(s), "");
            currentCategoryId = "";
            availableFacetGroupFiltersFromDeepLink = "";
        }
        refresh("", "", false);
    }

    private void resetTextSuggestionsList()
    {
        if (getView() == null)
        {
            return;
        } else
        {
            autocompleteListView.setAdapter(null);
            autocompleteListView.setVisibility(8);
            textSuggestionsList = new ArrayList();
            reloadCategories();
            return;
        }
    }

    private void setRecentSearchesAndSuggestionsHeader()
    {
        LinearLayout linearlayout = (LinearLayout)getActivity().getLayoutInflater().inflate(0x7f0301be, null);
        suggestionsContainer = (LinearLayout)linearlayout.findViewById(0x7f1004ab);
        if (isSuggestionsEnabled())
        {
            View view = linearlayout.findViewById(0x7f100327);
            LinearLayout linearlayout1 = (LinearLayout)linearlayout.findViewById(0x7f100326);
            boolean flag = gtgAbTestHelper.isGtgNewFlagDivision();
            suggestionsContainer.setVisibility(0);
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
            linearlayout1.setOnClickListener(new android.view.View.OnClickListener() {

                final GlobalSearchFragment this$0;

                public void onClick(View view1)
                {
                    loggingUtils.logClick("", "suggestion_selection_click", Channel.GLOBAL_SEARCH.toString(), Logger.NULL_NST_FIELD, new SearchSuggestionClickExtraInfo("delivery & takeout", "GTG", String.valueOf(0)));
                    startActivity(((IntentFactory)intentFactory.get()).newGrouponWebViewIntent(gdtService.getGtgEntryUrl(), false, true, true, true, false));
                }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
            });
        } else
        {
            suggestionsContainer.setVisibility(8);
        }
        recentSearchContainer = (LinearLayout)linearlayout.findViewById(0x7f1004a8);
        recentListView = (LinearLayout)linearlayout.findViewById(0x7f1004aa);
        categoriesSection.addHeaderView(linearlayout);
    }

    private void setSelectedLocation(Place place, boolean flag)
    {
        EditText edittext = locationSearchEditText;
        if (flag)
        {
            place = place.locationString;
        } else
        {
            place = place.value;
        }
        edittext.setText(place);
        showPopularSearches();
    }

    private void setTextValueAndReloadDeals(String s, String s1, boolean flag)
    {
        if (Strings.equals(s1, ""))
        {
            selectedCategory = null;
        }
        currentCategoryId = s1;
        searchInterfaceProvider.setQueryText(s);
        refresh(s, s1, flag);
    }

    private void setViewOnGlobalStateChange()
    {
        boolean flag = false;
        if (!globalSearchState.isSearchModeTextSearch()) goto _L2; else goto _L1
_L1:
        if (!globalSearchState.showTextOrLocationSearchResult) goto _L4; else goto _L3
_L3:
        autocompleteListView.setVisibility(0);
        categoriesSection.setVisibility(8);
        tagsSection.setVisibility(8);
_L6:
        return;
_L4:
        Object obj;
        int i;
        int j;
        if (isGlobalSearchRedesign1505 || isBrowseByCategory)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        autocompleteListView.setVisibility(8);
        obj = categoriesSection;
        if (i != 0)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((ListView) (obj)).setVisibility(j);
        obj = tagsSection;
        if (i == 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((ScrollView) (obj)).setVisibility(i);
        return;
_L2:
        if (globalSearchState.isSearchModeLocationSearch())
        {
            categoriesSection.setVisibility(8);
            tagsSection.setVisibility(8);
            autocompleteListView.setVisibility(0);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void showPopularSearches()
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            getPopularSearches();
            return;
        } else
        {
            categoriesSection.setVisibility(8);
            popularSearchLabel.setVisibility(8);
            return;
        }
    }

    private void showTextSuggestionsList(String s, List list)
    {
        if (list != null)
        {
            s = new ArrayList(list);
            autocompleteListView.setVisibility(0);
            autocompleteListView.setAdapter(null);
            autocompleteListView.setAdapter(new SearchTermIndexerAdapter(0x7f030111, s, s) {

                final GlobalSearchFragment this$0;
                final List val$recentlySearchedTermsListClone;

                public View getView(int i, View view, ViewGroup viewgroup)
                {
                    if (view == null)
                    {
                        view = inflater.inflate(0x7f030111, null);
                    }
                    view = (TextView)view.findViewById(0x7f100204);
                    viewgroup = ((SearchTermAndCategory)recentlySearchedTermsListClone.get(i)).getSearchTerm();
                    view.setText(viewgroup);
                    view.setOnClickListener(viewgroup. new android.view.View.OnClickListener() {

                        final _cls18 this$1;
                        final String val$suggestion;

                        public void onClick(View view)
                        {
                            addRecentlySearchedTerm(suggestion, "");
                            setTextValueAndReloadDeals(suggestion, "", true);
                            searchInterfaceProvider.clearFocus();
                        }

            
            {
                this$1 = final__pcls18;
                suggestion = String.this;
                super();
            }
                    });
                    return view;
                }

            
            {
                this$0 = GlobalSearchFragment.this;
                recentlySearchedTermsListClone = list1;
                super(final_context1, i, list);
            }
            });
            return;
        }
        list = new ArrayList(textSuggestionsList.size());
        for (Iterator iterator = textSuggestionsList.iterator(); iterator.hasNext(); list.add(((SearchSuggestion)iterator.next()).value)) { }
        loggingUtils.logTextSearch("", s, Strings.join(",", list), s.length(), null);
        autocompleteListView.setVisibility(0);
        autocompleteListView.setAdapter(null);
        s = new ArrayList(textSuggestionsList);
        autocompleteListView.setAdapter(new IndexerAdapter(0x7f030111, s, s) {

            final GlobalSearchFragment this$0;
            final List val$textSuggestionsListClone;

            public View getView(int i, View view, final ViewGroup suggestion)
            {
                if (view == null)
                {
                    view = inflater.inflate(0x7f030111, null);
                }
                view = (TextView)view.findViewById(0x7f100204);
                suggestion = (SearchSuggestion)textSuggestionsListClone.get(i);
                view.setText(Html.fromHtml(((SearchSuggestion) (suggestion)).label));
                view.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final _cls19 this$1;
                    final int val$position;
                    final SearchSuggestion val$suggestion;

                    public void onClick(View view)
                    {
                        setTextValueAndReloadDeals(suggestion.value, "", true);
                        searchInterfaceProvider.clearFocus();
                        if (searchAbTestHelper.isUniversalSearchChannelSelectorEnabled())
                        {
                            view = new GlobalSearchAutoCompleteClickMetadata(globalSearchUtil.loggingNameForChannelString(searchSourceChannel.toString()), Strings.join(",", Arrays.asList(new Serializable[] {
                                suggestion.value, Integer.valueOf(position + 1)
                            })));
                            logger.logClick("", "autocomplete_selection_click", "global_search", view);
                            return;
                        } else
                        {
                            loggingUtils.logClick("", "autocomplete_selection_click", "global_search", Strings.join(",", Arrays.asList(new Serializable[] {
                                suggestion.value, Integer.valueOf(position + 1)
                            })));
                            return;
                        }
                    }

            
            {
                this$1 = final__pcls19;
                suggestion = searchsuggestion;
                position = I.this;
                super();
            }
                });
                return view;
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                textSuggestionsListClone = list1;
                super(final_context1, i, list);
            }
        });
    }

    private void startSearchResult()
    {
        Intent intent = new Intent(context, com/groupon/activity/GlobalSearchResult);
        intent.putExtra("search_term", searchInterfaceProvider.getQueryText());
        Bundle bundle = new Bundle();
        bundle.putParcelable("selected_place", locationAutocompleteServiceWrapper.getCurrentlySelectedPlace());
        intent.putExtra("selected_place_bundle", bundle);
        intent.putExtra("isDeepLinked", isDeepLinked);
        intent.putExtra("current_category_id", currentCategoryId);
        intent.putExtra("sourceChannel", searchSourceChannel);
        intent.putExtra("global_search_channel_filter", searchFilterChannel);
        intent.putExtra("carousel_origin_channel", getArguments().getParcelable("carousel_origin_channel"));
        if (isDeepLinked)
        {
            intent.setFlags(0x14000000);
        }
        if (searchResultsOnly)
        {
            intent.putExtra("search_results_only", searchResultsOnly);
        }
        if (selectedCategory != null)
        {
            intent.putExtra("selected_category_item", (Parcelable)selectedCategory.getKey());
            intent.putExtra("selected_category_id", (Serializable)selectedCategory.getValue());
        }
        intent.putExtra("facet_group_filter", availableFacetGroupFiltersFromDeepLink);
        intent.putExtra("fromGlobalSearch", true);
        getActivity().startActivityForResult(intent, 100);
        getActivity().overridePendingTransition(0, 0);
        if (!isFromGoodsCategoryTab() && !isBrowseByCategory)
        {
            ViewUtils.forceShowKeyboard(getActivity(), false);
        }
        if (isDeepLinked)
        {
            getActivity().finish();
        }
    }

    private void triggerNewSearchAndReload()
    {
        String s = Strings.toString(locationSearchEditText.getText());
        if (currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
        {
            locationSearchEditText.clearFocus();
            locationSearchEditText.setText(locationAutocompleteServiceWrapper.getTopListSearchLocation().value);
            reloadOnkeypress();
        } else
        {
            if (Strings.equalsIgnoreCase(CURRENT_LOCATION, s))
            {
                locationSearchEditText.clearFocus();
                locationSearchEditText.setText(locationAutocompleteServiceWrapper.getCurrentLocationOrDivisionPlace().value);
                reloadOnkeypress();
                return;
            }
            if (Strings.notEmpty(s))
            {
                createLocationWithGeocoder(s);
                return;
            }
        }
    }

    private void updateCategoriesList()
    {
        String s;
        Object obj;
        int i;
        boolean flag1;
        flag1 = false;
        boolean flag = false;
        boolean flag2 = isGlobalSearchRedesign1505;
        static class _cls24
        {

            static final int $SwitchMap$com$groupon$Channel[];

            static 
            {
                $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 3;
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

        LinearLayout linearlayout;
        if (categoryFromGoods != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        isGlobalSearchRedesign1505 = i | flag2;
        if (!isGlobalSearchRedesign1505 && !isBrowseByCategory) goto _L2; else goto _L1
_L1:
        categoriesProgress.setVisibility(0);
        categoriesSection.setVisibility(8);
        updateLocationBarVisibility();
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            s = "mobile_local";
        } else
        {
            s = "mobile_search_intl";
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            obj = "mobile_goods";
        } else
        {
            obj = "mobile_search_intl";
        }
        _cls24..SwitchMap.com.groupon.Channel[searchSourceChannel.ordinal()];
        JVM INSTR tableswitch 1 5: default 144
    //                   1 203
    //                   2 248
    //                   3 248
    //                   4 266
    //                   5 266;
           goto _L3 _L4 _L5 _L5 _L6 _L6
_L3:
        linearlayout = suggestionsContainer;
        if (isSuggestionsEnabled())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        linearlayout.setVisibility(i);
        getCategoryList("local", s);
        getCategoryList("goods", ((String) (obj)));
_L8:
        return;
_L4:
        obj = suggestionsContainer;
        if (isSuggestionsEnabled() && !isBrowseByCategory)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        getCategoryList("local", s);
        return;
_L5:
        suggestionsContainer.setVisibility(8);
        getCategoryList("goods", ((String) (obj)));
        return;
_L6:
        categoriesProgress.setVisibility(8);
        categoriesSection.setVisibility(0);
        suggestionsContainer.setVisibility(8);
        if (categoriesAdapter != null) goto _L8; else goto _L7
_L7:
        categoriesAdapter = new GlobalCategoriesAdapter(getActivity());
        categoriesSection.setAdapter(categoriesAdapter);
        return;
_L2:
        showPopularSearches();
        return;
    }

    private void updateCategoryList(Category category, Category category1, List list)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (list != null)
        {
            for (list = list.iterator(); list.hasNext(); processCategories(category, (Category)list.next(), linkedhashmap)) { }
        }
        if (categoriesAdapter == null)
        {
            categoriesAdapter = new GlobalCategoriesAdapter(getActivity());
        }
        if (isBrowseByCategory)
        {
            categoriesAdapter.setIsBrowseByCategory(true);
        }
        categoriesAdapter.addDataSet(category, category1, linkedhashmap);
        categoriesSection.setAdapter(categoriesAdapter);
        categoriesSection.setOnTouchListener(new android.view.View.OnTouchListener() {

            final GlobalSearchFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                searchInterfaceProvider.clearFocus();
                return false;
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
        });
        categoriesAdapter.notifyDataSetChanged();
        categoriesAdapter.setOnClickListener(new android.view.View.OnClickListener() {

            final GlobalSearchFragment this$0;

            public void onClick(View view)
            {
                Category category2 = (Category)view.getTag();
                if (category2 == null || !category2.id.equals("groceries")) goto _L2; else goto _L1
_L1:
                loggingUtils.logClick(null, "groceries_search_all_click", "snap", null, new SnapGroceryGenericMetadata(null, com/groupon/activity/GlobalSearch.getSimpleName(), null, null));
                startActivity(((IntentFactory)intentFactory.get()).newSnapOfferGridIntent((new StringBuilder()).append(Channel.SNAP_GROCERY).append(com/groupon/activity/SnapOfferGridActivity.getSimpleName()).toString(), Channel.SNAP_GROCERY));
_L4:
                return;
_L2:
                if (category2 == null || category2.isParent()) goto _L4; else goto _L3
_L3:
                int i;
                int j;
                int k;
                searchInterfaceProvider.setQueryText(category2.friendlyName);
                j = 0;
                i = 0;
                view = categoriesAdapter.getExpandedCategories();
                k = j;
                if (view == null) goto _L6; else goto _L5
_L5:
                k = j;
                if (view.size() <= 2) goto _L6; else goto _L7
_L7:
                j = 2;
_L12:
                k = i;
                if (j >= view.size()) goto _L6; else goto _L8
_L8:
                Object obj = (Category)view.get(j);
                if (!((Category) (obj)).equals(category2)) goto _L10; else goto _L9
_L9:
                k = i;
_L6:
                selectedCategory = new java.util.AbstractMap.SimpleEntry(category2, Integer.valueOf(k + 1));
                reload("", "", false);
                searchInterfaceProvider.clearFocus();
                if (isBrowseByCategory)
                {
                    int l;
                    if (category2.relevanceContext.equals("mobile_goods"))
                    {
                        view = "goods";
                    } else
                    {
                        view = "nearby";
                    }
                    if (category2.isAllDeals || !category2.isSubcategory)
                    {
                        obj = "L2";
                    } else
                    {
                        obj = "L3";
                    }
                    loggingUtils.logCategoryClick("category_click", view, Channel.GLOBAL_SEARCH.toString(), ((String) (obj)), category2);
                    isBrowseByCategory = false;
                    isReloadCategories = true;
                    view = (GlobalSearch)getActivity();
                    if (isGlobalSearchChannelSelector1506)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    view.setRadioTabGroupVisibility(i);
                    return;
                }
                break; /* Loop/switch isn't completed */
_L10:
                l = i;
                if (!((Category) (obj)).isSubcategory)
                {
                    l = i + 1;
                }
                j++;
                i = l;
                if (true) goto _L12; else goto _L11
_L11:
                GlobalSearchCategoryClickExtraInfo globalsearchcategoryclickextrainfo;
                if (category2.isAllDeals || !category2.isSubcategory)
                {
                    view = "category_selection_click";
                } else
                {
                    view = "sub-category_click";
                }
                globalsearchcategoryclickextrainfo = new GlobalSearchCategoryClickExtraInfo(((Category)selectedCategory.getKey()).toNstTracking(((Integer)selectedCategory.getValue()).intValue()));
                loggingUtils.logClick("", view, "global_search", JsonEncodedNSTField.NULL_JSON_NST_FIELD, globalsearchcategoryclickextrainfo);
                return;
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super();
            }
        });
        categoriesProgress.setVisibility(8);
        categoriesSection.setVisibility(0);
    }

    private void updateLocationBarVisibility()
    {
        Channel channel = searchSourceChannel;
        if (channel == Channel.GOODS || channel == Channel.SHOPPING)
        {
            locationSearchView.setVisibility(8);
            return;
        } else
        {
            locationSearchView.setVisibility(0);
            return;
        }
    }

    private void updateSearchTags(List list, LinearLayout linearlayout, LinearLayout linearlayout1, final String clickTag)
    {
        if (list == null || list.isEmpty() || isBrowseByCategory)
        {
            linearlayout1.setVisibility(8);
            return;
        }
        linearlayout.removeAllViews();
        int i;
        int j;
        if (list.size() >= getMaxRecentSearchesForChannel(searchSourceChannel))
        {
            i = getMaxRecentSearchesForChannel(searchSourceChannel);
        } else
        {
            i = list.size();
        }
        for (j = 0; j < i; j++)
        {
            final String categoryId = (SearchTermAndCategory)list.get(j);
            final String suggestion = categoryId.getSearchTerm();
            categoryId = categoryId.getSearchCategory();
            ViewGroup viewgroup = (ViewGroup)getActivity().getLayoutInflater().inflate(0x7f03010c, linearlayout, false);
            TextView textview = (TextView)viewgroup.findViewById(0x7f10031d);
            View view = viewgroup.findViewById(0x7f100165);
            textview.setText(suggestion);
            viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                final GlobalSearchFragment this$0;
                final String val$categoryId;
                final String val$clickTag;
                final String val$suggestion;

                public void onClick(View view1)
                {
                    if (searchAbTestHelper.isUniversalSearchChannelSelectorEnabled())
                    {
                        view1 = new GlobalSearchClickToPerformSearchMetadata(globalSearchUtil.loggingNameForChannelString(searchSourceChannel.toString()), suggestion);
                        logger.logClick("", clickTag, "global_search", Logger.NULL_NST_FIELD, view1);
                    } else
                    {
                        loggingUtils.logClick("", clickTag, "global_search", suggestion);
                    }
                    addRecentlySearchedTerm(suggestion, categoryId);
                    setTextValueAndReloadDeals(suggestion, categoryId, true);
                    searchInterfaceProvider.clearFocus();
                }

            
            {
                this$0 = GlobalSearchFragment.this;
                suggestion = s;
                clickTag = s1;
                categoryId = s2;
                super();
            }
            });
            if (j == list.size() - 1)
            {
                view.setVisibility(8);
            }
            linearlayout.addView(viewgroup);
        }

        linearlayout1.setVisibility(0);
    }

    private void updateSearchTags(List list, FlowLayout flowlayout, LinearLayout linearlayout, final String clickTag)
    {
        if (list == null || list.isEmpty() || isBrowseByCategory)
        {
            linearlayout.setVisibility(8);
            return;
        }
        flowlayout.removeAllViews();
        LayoutInflater layoutinflater = LayoutInflater.from(flowlayout.getContext());
        Button button;
        for (list = list.iterator(); list.hasNext(); flowlayout.addView(button))
        {
            final String categoryId = (SearchTermAndCategory)list.next();
            final String suggestion = categoryId.getSearchTerm();
            categoryId = categoryId.getSearchCategory();
            button = (Button)layoutinflater.inflate(0x7f030113, flowlayout, false);
            button.setText(suggestion);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final GlobalSearchFragment this$0;
                final String val$categoryId;
                final String val$clickTag;
                final String val$suggestion;

                public void onClick(View view)
                {
                    if (searchAbTestHelper.isUniversalSearchChannelSelectorEnabled())
                    {
                        view = new GlobalSearchClickToPerformSearchMetadata(globalSearchUtil.loggingNameForChannelString(searchSourceChannel.toString()), suggestion);
                        logger.logClick("", clickTag, "global_search", Logger.NULL_NST_FIELD, view);
                    } else
                    {
                        loggingUtils.logClick("", clickTag, "global_search", suggestion);
                    }
                    addRecentlySearchedTerm(suggestion, categoryId);
                    setTextValueAndReloadDeals(suggestion, categoryId, true);
                    searchInterfaceProvider.clearFocus();
                }

            
            {
                this$0 = GlobalSearchFragment.this;
                suggestion = s;
                clickTag = s1;
                categoryId = s2;
                super();
            }
            });
        }

        linearlayout.setVisibility(0);
    }

    protected LocationIndexerAdapter getLocationIndexerAdapter(List list)
    {
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        return new BaseGlobalSearchLocationIndexerAdapter(getActivity(), locationAutocompleteServiceWrapper, CURRENT_LOCATION, ((List) (obj))) {

            final GlobalSearchFragment this$0;

            public void onLocationClick(Place place)
            {
                locationSearchEditText.clearFocus();
                locationAutocompleteServiceWrapper.saveRecentLocation(place);
                setSelectedLocation(place, locationAutocompleteServiceWrapper.isUserLocation(place));
                searchInterfaceProvider.requestTextFocus();
                reloadCategoriesList();
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                super(context1, locationsautocompleteservicewrapper, s, list);
            }
        };
    }

    public boolean isAutocomplete()
    {
        return locationSearchEditText != null && locationSearchEditText.hasFocus();
    }

    public boolean isTextEmpty()
    {
        return Strings.isEmpty(locationSearchEditText.getText());
    }

    public void locationReadyCallback(Location location)
    {
    }

    public void locationSearchReady(List list)
    {
        autocompleteListView.setAdapter(null);
        if (globalSearchState.isSearchModeLocationSearch())
        {
            autocompleteListView.setAdapter(getLocationIndexerAdapter(list));
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        intentFactory = new Lazy(getActivity()) {

            final GlobalSearchFragment this$0;

            
            {
                this$0 = GlobalSearchFragment.this;
                super(context1);
            }
        };
    }

    public void onBackButtonPress()
    {
        if (isGlobalSearchRedesign1505 || isBrowseByCategory)
        {
            isDeepLinked = false;
        }
    }

    public void onClearSearch()
    {
        searchInterfaceProvider.setQueryText("");
        globalSearchState.switchToSearchModeTextSearch();
        searchInterfaceProvider.requestTextFocus();
        searchInterfaceProvider.hideKeyboard(false);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        globalSearchState.switchToSearchModeTextSearch();
        handleDeeplinkingSearch();
        if (categoryFromGoods != null && !Strings.equals(categoryFromGoods.id, "mobile_goods"))
        {
            searchInterfaceProvider.setQueryText(categoryFromGoods.friendlyName);
            selectedCategory = new java.util.AbstractMap.SimpleEntry(categoryFromGoods, Integer.valueOf(1));
            reload("", "", false);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030109, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onFinishedWithResults()
    {
        globalSearchState.switchToSearchModeTextSearch();
        searchInterfaceProvider.requestTextFocus();
        searchInterfaceProvider.setSelection(searchInterfaceProvider.getQueryText().length());
    }

    public void onResume()
    {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0)
        {
            Toast.makeText(getActivity(), 0x7f080199, 0).show();
            getActivity().finish();
        }
        searchInterfaceProvider = (SearchInterfaceProvider)getActivity();
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (isSearchInitialized())
        {
            if (Strings.notEmpty(searchInterfaceProvider.getQueryText()))
            {
                bundle.putString("current_search_keyword", Strings.toString(searchInterfaceProvider.getQueryText()));
            }
            bundle.putInt("global_search_mode", globalSearchState.getCurrentMode());
            bundle.putString("current_category_id", currentCategoryId);
            bundle.putParcelable("search_source_channel", searchSourceChannel);
            bundle.putString("search_filter_channel", searchFilterChannel);
            bundle.putString("category_facet_group_filters", availableFacetGroupFiltersFromDeepLink);
            if (locationAutocompleteServiceWrapper.getCurrentlySelectedPlace() != null)
            {
                bundle.putParcelable("place", locationAutocompleteServiceWrapper.getCurrentlySelectedPlace());
            }
            if (selectedCategory != null)
            {
                bundle.putParcelable("current_category", (Parcelable)selectedCategory.getKey());
                bundle.putInt("current_category_level", ((Integer)selectedCategory.getValue()).intValue());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSearchBarClicked()
    {
        if (Strings.isEmpty(searchInterfaceProvider.getQueryText()))
        {
            resetTextSuggestionsList();
            globalSearchState.setShowTextOrLocationSearchResult(false);
        }
        globalSearchState.switchToSearchModeTextSearch();
    }

    public void onSearchBarFocusChanged(boolean flag)
    {
        boolean flag1 = true;
        if (getView() == null)
        {
            return;
        }
        if (flag && isBrowseByCategory && Strings.isEmpty(searchInterfaceProvider.getQueryText()))
        {
            isBrowseByCategory = false;
            isReloadCategories = true;
            resetTextSuggestionsList();
            globalSearchState.setShowTextOrLocationSearchResult(false);
        }
        recentBox.setVisibility(8);
        recentSearchContainer.setVisibility(8);
        if (isGlobalSearchRedesign1505)
        {
            updateSearchTags(recentSearchTermService.getRecentlySearchedTerms(true), recentListView, recentSearchContainer, "recent_search_click");
        } else
        {
            updateSearchTags(recentSearchTermService.getRecentlySearchedTerms(true), recentList, recentBox, "recent_search_click");
        }
        if (flag)
        {
            updateLocationBarVisibility();
            globalSearch.setVisibility(0);
            spinner.setVisibility(8);
            SearchInterfaceProvider searchinterfaceprovider;
            if (Strings.notEmpty(searchInterfaceProvider.getQueryText()))
            {
                globalSearchState.setShowTextOrLocationSearchResult(true);
                searchInterfaceProvider.showClearSearchButton(true);
                getTextSuggestionsList(searchInterfaceProvider.getQueryText());
            } else
            {
                resetTextSuggestionsList();
                globalSearchState.setShowTextOrLocationSearchResult(false);
            }
            globalSearchState.switchToSearchModeTextSearch();
        }
        searchinterfaceprovider = searchInterfaceProvider;
        if (!flag && !locationSearchEditText.hasFocus())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        searchinterfaceprovider.hideKeyboard(flag);
    }

    public void onSearchExecuted(String s)
    {
        reloadOnkeypress();
        searchInterfaceProvider.clearFocus();
    }

    public void onTextChanged(CharSequence charsequence)
    {
        if (getView() != null)
        {
            final boolean isFiltering;
            if (Strings.notEmpty(charsequence) && charsequence.length() >= 1)
            {
                isFiltering = true;
            } else
            {
                isFiltering = false;
            }
            if (isTextSearch())
            {
                searchInterfaceProvider.showClearSearchButton(Strings.notEmpty(charsequence));
                android.widget.ListAdapter listadapter;
                if (Strings.isEmpty(charsequence))
                {
                    resetTextSuggestionsList();
                    globalSearchState.setShowTextOrLocationSearchResult(false);
                } else
                {
                    globalSearchState.setShowTextOrLocationSearchResult(true);
                }
            }
            if (isFiltering)
            {
                if (isTextSearch() && globalSearchState.isSearchModeTextSearch())
                {
                    getTextSuggestionsList(Strings.toString(charsequence));
                }
            } else
            {
                resetTextSuggestionsList();
            }
            listadapter = autocompleteListView.getAdapter();
            if (listadapter instanceof SearchTermIndexerAdapter)
            {
                ((SearchTermIndexerAdapter)listadapter).getFilter().filter(charsequence, new android.widget.Filter.FilterListener() {

                    final GlobalSearchFragment this$0;
                    final boolean val$isFiltering;

                    public void onFilterComplete(int i)
                    {
                        if (i == 0 && isFiltering)
                        {
                            resetTextSuggestionsList();
                        }
                    }

            
            {
                this$0 = GlobalSearchFragment.this;
                isFiltering = flag;
                super();
            }
                });
                return;
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        boolean flag1 = true;
        super.onViewCreated(view, bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        Dart.inject(this);
        globalSearchState = new GlobalSearchState();
        restoreState(bundle);
        searchInterfaceProvider = (SearchInterfaceProvider)getActivity();
        isGlobalSearchRedesign1505 = searchAbTestHelper.isUniversalSearchRedesignEnabled();
        isGlobalSearchChannelSelector1506 = searchAbTestHelper.isUniversalSearchChannelSelectorEnabled();
        isGTGOnSearch = gtgAbTestHelper.isGtgOnSearch();
        isDeepLinked = getActivity().getIntent().getBooleanExtra("isDeepLinked", false);
        boolean flag;
        if (categoryFromGoods != null && !Strings.equals(categoryFromGoods.id, "mobile_goods"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isDeepLinked || flag)
        {
            locationSearchView.setVisibility(4);
            globalSearch.setVisibility(4);
            spinner.setVisibility(0);
        }
        searchResultsOnly = getActivity().getIntent().getBooleanExtra("search_results_only", false);
        categoriesAdapter = null;
        setRecentSearchesAndSuggestionsHeader();
        globalSearchInit();
        if (isBrowseByCategory)
        {
            flag1 = false;
        }
        onSearchBarFocusChanged(flag1);
    }

    public void reload(final String suggestionValue, final String categoryId, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        startSearchResult();
        if (!isFromGoodsCategoryTab() && !isBrowseByCategory)
        {
            searchInterfaceProvider.requestTextFocus();
        }
        globalSearchState.switchToSearchModeTextSearch();
        if (isDeepLinked)
        {
            availableFacetGroupFiltersFromDeepLink = null;
            locationAutocompleteServiceWrapper.setCurrentlySelectedPlace(locationAutocompleteServiceWrapper.getCurrentLocationOrDivisionPlace());
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        (new Handler()).postDelayed(new Runnable() {

            final GlobalSearchFragment this$0;
            final String val$categoryId;
            final String val$suggestionValue;

            public void run()
            {
                if (getActivity() != null)
                {
                    addRecentlySearchedTerm(suggestionValue, categoryId);
                }
            }

            
            {
                this$0 = GlobalSearchFragment.this;
                suggestionValue = s;
                categoryId = s1;
                super();
            }
        }, 1000L);
        this;
        JVM INSTR monitorexit ;
        return;
        suggestionValue;
        throw suggestionValue;
    }

    protected void restoreState(Bundle bundle)
    {
        if (bundle != null)
        {
            Place place = (Place)bundle.getParcelable("place");
            if (place != null)
            {
                locationAutocompleteServiceWrapper.setCurrentlySelectedPlace(place);
            }
            bundle.remove("place");
            if (bundle.containsKey("current_category") && bundle.containsKey("current_category_level"))
            {
                selectedCategory = new java.util.AbstractMap.SimpleEntry((Category)bundle.get("current_category"), Integer.valueOf(bundle.getInt("current_category_level")));
                bundle.remove("current_category");
                bundle.remove("current_category_level");
            }
            currentCategoryId = bundle.getString("current_category_id");
            availableFacetGroupFiltersFromDeepLink = bundle.getString("category_facet_group_filters");
            globalSearchState.setCurrentMode(bundle.getInt("global_search_mode", 0));
            searchFilterChannel = bundle.getString("search_filter_channel");
            searchSourceChannel = (Channel)bundle.getParcelable("search_source_channel");
        }
    }

    public void setSearchFilterChannel(String s)
    {
        searchFilterChannel = s;
    }

    public void setSearchSourceChannel(Channel channel)
    {
        searchSourceChannel = channel;
    }

    public void updateSourceChannelAndRefresh(Channel channel)
    {
        if (!Strings.equals(channel, searchSourceChannel))
        {
            searchSourceChannel = channel;
            if (getView() != null)
            {
                updateSearchTags(recentSearchTermService.getRecentlySearchedTerms(true), recentListView, recentSearchContainer, "recent_search_click");
                updateLocationBarVisibility();
                categoriesAdapter = null;
                globalSearchInit();
                return;
            }
        }
    }

    static 
    {
        CHANNEL = Channel.GLOBAL_SEARCH.name();
    }





/*
    static boolean access$1002(GlobalSearchFragment globalsearchfragment, boolean flag)
    {
        globalsearchfragment.isUpdateTags = flag;
        return flag;
    }

*/









/*
    static java.util.Map.Entry access$1702(GlobalSearchFragment globalsearchfragment, java.util.Map.Entry entry)
    {
        globalsearchfragment.selectedCategory = entry;
        return entry;
    }

*/


/*
    static boolean access$1802(GlobalSearchFragment globalsearchfragment, boolean flag)
    {
        globalsearchfragment.isReloadCategories = flag;
        return flag;
    }

*/









/*
    static List access$2502(GlobalSearchFragment globalsearchfragment, List list)
    {
        globalsearchfragment.textSuggestionsList = list;
        return list;
    }

*/











/*
    static boolean access$3402(GlobalSearchFragment globalsearchfragment, boolean flag)
    {
        globalsearchfragment.isReloadGlobalCategoriesList = flag;
        return flag;
    }

*/








/*
    static List access$902(GlobalSearchFragment globalsearchfragment, List list)
    {
        globalsearchfragment.popularSearches = list;
        return list;
    }

*/
}
