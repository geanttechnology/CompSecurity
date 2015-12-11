// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.AsyncList;
import com.ebay.common.net.api.finding.PagedList;
import com.ebay.common.net.api.search.FindPopularSearchesRequest;
import com.ebay.common.net.api.search.FindPopularSearchesResponse;
import com.ebay.common.net.api.search.SavedSearchesApi;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.shopping.EbayShoppingApiHelper;
import com.ebay.common.util.Debug;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.util.EbayObservableAsyncTask;
import com.ebay.common.util.LruHistoryCache;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.notifications.PollServiceListCache;
import com.ebay.mobile.search.LruVisitedItemCache;
import com.ebay.mobile.search.RelatedSearchesActivity;
import com.ebay.mobile.search.SavedSearchList;
import com.ebay.mobile.search.SearchListAdapter;
import com.ebay.mobile.search.SearchResultFragmentActivity;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.shared.ui.SearchRefinementSummary;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseListActivity, SignInModalActivity

public class SavedSearchResultListActivity extends BaseListActivity
    implements android.content.DialogInterface.OnCancelListener, android.view.View.OnClickListener, com.ebay.common.net.AsyncList.NetworkListObserver, com.ebay.common.util.EbayAsyncTask.TaskHandler
{
    private static class ConfigInstanceState
    {

        private final SearchResults activeSearchResults;
        private final SearchState searchState;



        private ConfigInstanceState(SearchResults searchresults, SearchState searchstate)
        {
            activeSearchResults = searchresults;
            searchState = searchstate;
        }

    }

    private static final class ErrorHandler extends EbayErrorHandler
    {

        public final boolean allowRetry;
        public boolean wasRetry;

        protected void onNetworkError(EbayResponseError ebayresponseerror)
        {
            if (allowRetry)
            {
                wasRetry = true;
                activity.showDialog(0x7f070151);
                return;
            } else
            {
                super.onNetworkError(ebayresponseerror);
                return;
            }
        }

        public ErrorHandler(BaseActivity baseactivity, boolean flag)
        {
            super(baseactivity, false, true);
            wasRetry = false;
            allowRetry = flag;
        }
    }

    private static final class FindItemListAsyncTask extends EbayObservableAsyncTask
    {

        private final Authentication authentication;
        private final EbayContext context;
        public final boolean isRetry;
        private final Object parameters;

        private com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult doSearch(SavedSearch savedsearch)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            Object obj;
            obj = DeviceConfiguration.getAsync();
            obj = SavedSearchesApi.findItem(context, savedsearch, ((DeviceConfiguration) (obj)).get(DcsNautilusBoolean.GBH));
            new com.ebay.mobile.search.SavedSearchListActivity.SearchQueryParser(savedsearch, authentication);
            if (savedsearch.searchParameters == null || savedsearch.searchParameters.category == null || savedsearch.searchParameters.category.name != null)
            {
                break MISSING_BLOCK_LABEL_235;
            }
            Object obj1 = new EbayShoppingApi(savedsearch.searchParameters.country.site);
            savedsearch = savedsearch.searchParameters.category;
            int i;
            int j;
            try
            {
                obj1 = EbayShoppingApiHelper.getCategoryInfo(context, ((EbayShoppingApi) (obj1)), ((EbayCategorySummary) (savedsearch)).id, false);
            }
            // Misplaced declaration of an exception variable
            catch (SavedSearch savedsearch)
            {
                return ((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (obj));
            }
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_235;
            }
            if (((ArrayList) (obj1)).isEmpty())
            {
                break MISSING_BLOCK_LABEL_235;
            }
            obj1 = (EbayCategory)((ArrayList) (obj1)).get(0);
            if (((EbayCategory) (obj1)).id != ((EbayCategorySummary) (savedsearch)).id)
            {
                break MISSING_BLOCK_LABEL_235;
            }
            savedsearch.name = ((EbayCategory) (obj1)).name;
            if (TextUtils.isEmpty(((EbayCategory) (obj1)).namePath))
            {
                break MISSING_BLOCK_LABEL_235;
            }
            j = -1;
            i = ((EbayCategory) (obj1)).namePath.indexOf(':');
_L2:
            if (i == -1)
            {
                break; /* Loop/switch isn't completed */
            }
            j = i;
            i = ((EbayCategory) (obj1)).namePath.indexOf(':', i + 1);
            if (true) goto _L2; else goto _L1
_L1:
            if (j == -1)
            {
                break MISSING_BLOCK_LABEL_235;
            }
            savedsearch = new com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult(((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (obj)).totalItemsCount, ((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (obj)).list, null, ((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (obj)).aspects, ((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (obj)).searchUrl, ((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (obj)).itemIds);
            return savedsearch;
            return ((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (obj));
        }

        protected com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult doInBackgroundInternal(Void void1)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            if (!isRetry)
            {
                break MISSING_BLOCK_LABEL_38;
            }
            void1 = (com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult)parameters;
            if (void1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            if (((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (void1)).list == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            ((PagedList)((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult) (void1)).list).retry();
            return void1;
            try
            {
                void1 = doSearch((SavedSearch)parameters);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                throw EbayApiUtil.buildOutOfMemoryError(void1);
            }
            return void1;
            return void1;
        }

        protected volatile Object doInBackgroundInternal(Object obj)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            return doInBackgroundInternal((Void)obj);
        }

        public FindItemListAsyncTask(EbayContext ebaycontext, SavedSearch savedsearch, Authentication authentication1)
        {
            authentication = authentication1;
            isRetry = false;
            parameters = savedsearch;
            context = ebaycontext;
        }

        public FindItemListAsyncTask(EbayContext ebaycontext, com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult searchlistresult, Authentication authentication1)
        {
            authentication = authentication1;
            isRetry = true;
            parameters = searchlistresult;
            context = ebaycontext;
        }
    }

    private static class FindPopularSearchesNetLoader extends EbaySimpleNetLoader
    {

        private final EbayShoppingApi api;
        private final List categories;
        private final String keywords;
        private ArrayList popularKeywords;
        private final int tag;

        protected EbayRequest createRequest()
        {
            return new FindPopularSearchesRequest(api, keywords, categories);
        }

        public ArrayList getSearchKeywords()
        {
            if (popularKeywords == null && response != null)
            {
                popularKeywords = ((FindPopularSearchesResponse)response).getRelatedSearches();
            }
            return popularKeywords;
        }

        public FindPopularSearchesNetLoader(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, String s, List list, int i)
        {
            super(ebaycontext);
            popularKeywords = null;
            api = ebayshoppingapi;
            keywords = s;
            categories = list;
            tag = i;
        }
    }

    public class OnItemSelectedListenerWrapper
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        private int lastPosition;
        private final android.widget.AdapterView.OnItemSelectedListener listener;
        final SavedSearchResultListActivity this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            if (lastPosition == i)
            {
                Log.d(getClass().getName(), (new StringBuilder()).append("Ignoring onItemSelected for same position: ").append(i).toString());
            } else
            {
                Log.d(getClass().getName(), (new StringBuilder()).append("Passing on onItemSelected for different position: ").append(i).toString());
                listener.onItemSelected(adapterview, view, i, l);
            }
            lastPosition = i;
        }

        public void onNothingSelected(AdapterView adapterview)
        {
            listener.onNothingSelected(adapterview);
        }

        public OnItemSelectedListenerWrapper(int i, android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
        {
            this$0 = SavedSearchResultListActivity.this;
            super();
            lastPosition = i;
            listener = onitemselectedlistener;
        }
    }

    private static final class SearchResults
    {

        public FindItemListAsyncTask asyncTask;
        public boolean isLoaded;
        private ArrayList relatedSearches;
        public com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult result;
        public SavedSearch savedSearch;
        public SearchParameters searchParameters;
        private CharSequence searchSummary;

        public final FindItemListAsyncTask getCompletedTask(com.ebay.common.util.EbayAsyncTask.TaskHandler taskhandler)
        {
            FindItemListAsyncTask finditemlistasynctask = asyncTask;
            if (finditemlistasynctask != null)
            {
                asyncTask = null;
                finditemlistasynctask.removeObserver(taskhandler);
            }
            return finditemlistasynctask;
        }

        public final CharSequence getRefinementsSummary(Resources resources)
        {
            AbsoluteSizeSpan absolutesizespan = new AbsoluteSizeSpan((int)TypedValue.applyDimension(2, 12F, resources.getDisplayMetrics()));
            if (savedSearch != null)
            {
                resources = SearchRefinementSummary.getRefinementsSummary(savedSearch, resources, absolutesizespan, resources.getString(0x7f0705a9));
            } else
            {
                resources = SearchRefinementSummary.getRefinementsSummary(searchParameters, resources, absolutesizespan, resources.getString(0x7f0705a9));
            }
            searchSummary = resources;
            return searchSummary;
        }

        public final void query(EbayContext ebaycontext, com.ebay.common.util.EbayAsyncTask.TaskHandler taskhandler, Authentication authentication)
        {
            ebaycontext = new FindItemListAsyncTask(ebaycontext, savedSearch, authentication);
            asyncTask = ebaycontext;
            ebaycontext.addObserver(taskhandler);
            ebaycontext.execute(new Void[0]);
        }

        public final void retry(EbayContext ebaycontext, com.ebay.common.util.EbayAsyncTask.TaskHandler taskhandler, Authentication authentication)
        {
            ebaycontext = new FindItemListAsyncTask(ebaycontext, result, authentication);
            asyncTask = ebaycontext;
            ebaycontext.addObserver(taskhandler);
            ebaycontext.execute(new Void[0]);
        }



/*
        static ArrayList access$302(SearchResults searchresults, ArrayList arraylist)
        {
            searchresults.relatedSearches = arraylist;
            return arraylist;
        }

*/

        public SearchResults(SavedSearch savedsearch)
        {
            result = null;
            asyncTask = null;
            isLoaded = false;
            searchSummary = null;
            relatedSearches = null;
            searchParameters = null;
            savedSearch = savedsearch;
        }

        public SearchResults(SearchParameters searchparameters)
        {
            result = null;
            asyncTask = null;
            isLoaded = false;
            searchSummary = null;
            relatedSearches = null;
            searchParameters = searchparameters;
            savedSearch = null;
            if (searchparameters != null && searchparameters.aspectHistogram != null && !searchparameters.aspectHistogram.hasCheck())
            {
                searchparameters.aspectHistogram = null;
            }
        }
    }

    private static final class SearchState extends Enum
    {

        private static final SearchState $VALUES[];
        public static final SearchState PRIMARY_SEARCH;

        public static SearchState valueOf(String s)
        {
            return (SearchState)Enum.valueOf(com/ebay/mobile/activities/SavedSearchResultListActivity$SearchState, s);
        }

        public static SearchState[] values()
        {
            return (SearchState[])$VALUES.clone();
        }

        static 
        {
            PRIMARY_SEARCH = new SearchState("PRIMARY_SEARCH", 0);
            $VALUES = (new SearchState[] {
                PRIMARY_SEARCH
            });
        }

        private SearchState(String s, int i)
        {
            super(s, i);
        }
    }

    private class SpinnerAdapter extends ArrayAdapter
    {

        final SavedSearchResultListActivity this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = super.getView(i, null, viewgroup);
            }
            viewgroup = (String)getItem(i);
            TextView textview = (TextView)view.findViewById(0x1020014);
            if (textview != null)
            {
                textview.setText(viewgroup);
            }
            return view;
        }

        public SpinnerAdapter(Context context, int i, List list)
        {
            this$0 = SavedSearchResultListActivity.this;
            super(context, i, list);
        }
    }


    private static final String EXTRA_ITEM_KIND = "item_kind";
    private static final String EXTRA_REFINED = "refined";
    private static final String EXTRA_SCROLL_POSITION = "scrollPos";
    private static final String EXTRA_SEARCH_STATE = "search_state";
    private static final String FORWARDED_SOURCE_ID_TAG = "com.ebay.mobile.analytics.sid.FWD";
    private static final int LOADER_ID_RELATED_SEARCHES = 0;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Search", 3, "Search log");
    private SearchState _searchState;
    private SearchResults activeSearchResults;
    private boolean bFromNotification;
    private String bidSource;
    private Button buttonRefine;
    private EbayCountry currentCountry;
    private String currentSavedSearchId;
    private boolean firstTimeRunSavedSearch;
    private boolean icsCrashHackIgnoreBack;
    private boolean isSearchRefined;
    private com.ebay.common.ConstantsCommon.ItemKind itemKind;
    private View noResultsLayout;
    private TextView noResultsText;
    private TextView noResultsTipLanguage;
    private String referrer;
    private TextView refinementsSummary;
    private View savedSearchNoResultsLayout;
    private TextView savedSearchNoResultsText;
    private int scrollPosition;
    private View showNewItemsLayout;
    private Spinner spinner;
    private final EbayTimer timer = new EbayTimer(1000L);
    private SourceIdentification trackingSid;
    private SourceIdentification trackingSidForSrp;

    public SavedSearchResultListActivity()
    {
        currentSavedSearchId = null;
        firstTimeRunSavedSearch = false;
        bFromNotification = false;
        isSearchRefined = false;
        _searchState = SearchState.PRIMARY_SEARCH;
        trackingSid = null;
        trackingSidForSrp = null;
    }

    private static List addCategoryToList(EbayCategorySummary ebaycategorysummary, List list)
    {
        if (ebaycategorysummary == null)
        {
            return list;
        }
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        ((List) (obj)).add(ebaycategorysummary);
        return ((List) (obj));
    }

    private void destroySearchResults(SearchResults searchresults)
    {
        if (searchresults != null)
        {
            if (searchresults.asyncTask != null)
            {
                searchresults.asyncTask.removeObserver(this);
                if (isFinishing())
                {
                    searchresults.asyncTask.cancel(true);
                }
            }
            if (searchresults.result != null && searchresults.result.list != null)
            {
                searchresults.result.list.unregisterObserver(this);
                if (isFinishing())
                {
                    searchresults.result.list.clear();
                }
            }
        }
    }

    public static final com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult findItem(Context context, SavedSearch savedsearch, boolean flag)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return null;
    }

    private void handleRelatedSearchTracking(ArrayList arraylist)
    {
        if (arraylist != null && arraylist.size() > 0)
        {
            arraylist = new TrackingData("RelatedSearchAvailable", TrackingType.EVENT);
            arraylist.addKeyValuePair("mfls", "sra");
            arraylist.send(this);
        }
    }

    private void handleStandardSearchResult(com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult searchlistresult)
    {
        activeSearchResults.result = searchlistresult;
        if (activeSearchResults.savedSearch != null && !TextUtils.isEmpty(activeSearchResults.savedSearch.query))
        {
            activeSearchResults.searchParameters = activeSearchResults.savedSearch.searchParameters;
            setupViews(activeSearchResults);
            if (activeSearchResults.searchParameters.completedListings)
            {
                query(new SearchResults(activeSearchResults.searchParameters));
                return;
            }
            if (activeSearchResults.result.totalItemsCount > 0)
            {
                queryRelatedSearches(activeSearchResults);
            }
        }
        if (activeSearchResults.result.totalItemsCount == 0)
        {
            handleZeroResultsFound();
        } else
        {
            setupViewForResultsFound();
        }
        SiteSpeedActivityUtil.primaryAndAllLoaded(this);
    }

    private void handleZeroResultsFound()
    {
        showNoResultsUI(activeSearchResults.searchParameters.keywords);
    }

    private SearchResults init(Intent intent, Bundle bundle)
    {
        Object obj = null;
        SavedSearch savedsearch = null;
        if (bundle != null)
        {
            obj = (SearchParameters)bundle.getParcelable("search_param");
            savedsearch = (SavedSearch)bundle.getParcelable("SavedSearch");
        }
        bundle = ((Bundle) (obj));
        if (obj == null)
        {
            bundle = (SearchParameters)intent.getParcelableExtra("search_param");
        }
        obj = savedsearch;
        if (savedsearch == null)
        {
            obj = initSavedSearch(intent);
        }
        if (obj != null)
        {
            intent = new SearchResults(((SavedSearch) (obj)));
        } else
        if (bundle != null)
        {
            intent = new SearchResults(bundle);
        } else
        {
            return null;
        }
        setupViews(intent);
        return intent;
    }

    private void initFields()
    {
        buttonRefine = (Button)findViewById(0x7f10060b);
        refinementsSummary = (TextView)findViewById(0x7f10053e);
        noResultsLayout = findViewById(0x7f10053f);
        noResultsText = (TextView)findViewById(0x7f1001f1);
        noResultsTipLanguage = (TextView)findViewById(0x7f10060a);
        savedSearchNoResultsLayout = findViewById(0x7f100540);
        savedSearchNoResultsText = (TextView)findViewById(0x7f100541);
        showNewItemsLayout = findViewById(0x7f100609);
        buttonRefine.setOnClickListener(this);
        spinner = (Spinner)findViewById(0x7f1001bb);
    }

    private SavedSearch initSavedSearch(Intent intent)
    {
label0:
        {
label1:
            {
                Object obj2 = null;
                Object obj = UserCache.getSavedSearchList();
                currentSavedSearchId = intent.getStringExtra("saved_search_id");
                firstTimeRunSavedSearch = intent.getBooleanExtra("first_time_run_ss", false);
                Object obj1;
                ItemCache itemcache;
                com.ebay.mobile.notifications.PollService.SavedSearchPollData savedsearchpolldata;
                boolean flag;
                if (firstTimeRunSavedSearch && currentSavedSearchId != null && obj != null)
                {
                    obj = ((SavedSearchList) (obj)).getById(currentSavedSearchId);
                } else
                {
                    obj = null;
                }
                bFromNotification = intent.getBooleanExtra("saved_search_from_notification", false);
                flag = intent.getBooleanExtra("saved_search_from_sign_in", false);
                intent = intent.getStringExtra("event_type");
                if (!bFromNotification)
                {
                    obj1 = obj;
                    if (!flag)
                    {
                        break label1;
                    }
                    obj1 = obj;
                    if (obj != null)
                    {
                        break label1;
                    }
                }
                if (bFromNotification)
                {
                    ServiceStarter.startUpdateNotificationCacheService(this, intent, null);
                }
                itemcache = new ItemCache(this);
                savedsearchpolldata = itemcache.getSavedSearchPollData(currentSavedSearchId);
                intent = ((Intent) (obj));
                if (obj == null)
                {
                    intent = obj2;
                    if (savedsearchpolldata == null)
                    {
                        break label0;
                    }
                    intent = new SavedSearch(currentCountry, 25);
                    intent.id = savedsearchpolldata.searchId;
                    intent.name = savedsearchpolldata.searchName;
                }
                obj = MyApp.getPrefs().getAuthentication();
                if (obj != null)
                {
                    ((SavedSearch) (intent)).searchParameters.iafToken = ((Authentication) (obj)).iafToken;
                }
                intent.since = PollServiceListCache.getSinceTime(savedsearchpolldata);
                if (bFromNotification)
                {
                    intent.newItemsOnly = true;
                } else
                {
                    intent.newItemsOnly = PollServiceListCache.hasNew(savedsearchpolldata);
                }
                obj1 = intent;
                if (savedsearchpolldata != null)
                {
                    itemcache.markSavedSearchViewed(((SavedSearch) (intent)).id);
                    obj1 = intent;
                }
            }
            intent = ((Intent) (obj1));
        }
        return intent;
    }

    private boolean isRefined(SearchParameters searchparameters)
    {
        return searchparameters.maxDistance != 0 || searchparameters.condition != null || searchparameters.completedListings || searchparameters.soldItemsOnly || searchparameters.category != null || searchparameters.descriptionSearch || searchparameters.minPrice != null || searchparameters.maxPrice != null;
    }

    private void onRefineSearch()
    {
        Intent intent = new Intent(this, com/ebay/mobile/search/SearchResultFragmentActivity);
        intent.putExtra("com.ebay.mobile.tracking.Referrer", referrer);
        intent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
        if (trackingSidForSrp != null)
        {
            intent.putExtra("com.ebay.mobile.analytics.sid", trackingSidForSrp);
        }
        SearchParameters searchparameters = activeSearchResults.searchParameters;
        Object obj = activeSearchResults.result.categories;
        if (obj != null)
        {
            intent.putExtra("cat_histogram", ((android.os.Parcelable) (obj)));
            if (searchparameters.category != null && !((EbayCategoryHistogram) (obj)).categories.isEmpty())
            {
                obj = (com.ebay.common.model.search.EbayCategoryHistogram.Category)((EbayCategoryHistogram) (obj)).categories.get(0);
                if (searchparameters.category.id == ((com.ebay.common.model.search.EbayCategoryHistogram.Category) (obj)).id)
                {
                    searchparameters.category.name = ((com.ebay.common.model.search.EbayCategoryHistogram.Category) (obj)).name;
                }
            }
        }
        obj = searchparameters;
        if (activeSearchResults.result.aspects != null)
        {
            obj = searchparameters.clone();
            obj.aspectHistogram = activeSearchResults.result.aspects;
        }
        intent.putExtra("search_param", ((android.os.Parcelable) (obj)));
        if (currentSavedSearchId != null)
        {
            (new TrackingData("SavedSearchRefine", TrackingType.EVENT)).send(this);
            intent.putExtra("open_refine_panel", true);
        }
        startActivity(intent);
        finish();
    }

    private final void onRefreshAfterNetworkFailure()
    {
        if (getListAdapter() != null)
        {
            getListView().invalidateViews();
            return;
        } else
        {
            setSearchResultAdapter();
            return;
        }
    }

    private void query(SearchResults searchresults)
    {
label0:
        {
label1:
            {
                if (searchresults != null)
                {
                    timer.stop();
                    String s;
                    DeviceConfiguration deviceconfiguration;
                    if (searchresults.savedSearch != null)
                    {
                        s = null;
                    } else
                    if (searchresults.searchParameters.productId != null)
                    {
                        s = (new StringBuilder()).append(searchresults.searchParameters.productIdType).append(':').append(searchresults.searchParameters.productId).toString();
                    } else
                    {
                        s = searchresults.searchParameters.keywords;
                    }
                    if (searchresults.savedSearch != null && searchresults.savedSearch.searchParameters != null)
                    {
                        Authentication authentication = MyApp.getPrefs().getAuthentication();
                        if (authentication == null)
                        {
                            break label1;
                        }
                        searchresults.savedSearch.searchParameters.iafToken = authentication.iafToken;
                    }
                    deviceconfiguration = DeviceConfiguration.getAsync();
                    if (!deviceconfiguration.get(DcsNautilusBoolean.QA_ENABLED) || !"4f37292d53e41eb687dc617e4a021a7cd01f91ed".equals(SearchUtil.toSHA1(s)))
                    {
                        break label0;
                    }
                    MyApp.getPrefs().setGlobalPref(true, "developerOptions");
                    deviceconfiguration.developerOptionsEnabled(true);
                }
                return;
            }
            searchresults = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this);
            searchresults.putExtras(getIntent());
            searchresults.putExtra("saved_search_from_sign_in", true);
            startActivityForResult(searchresults, 65);
            return;
        }
        Object obj = MyApp.getPrefs().getAuthentication();
        activeSearchResults = searchresults;
        activeSearchResults.relatedSearches = null;
        setProgressOn();
        _searchState = SearchState.PRIMARY_SEARCH;
        activeSearchResults.query(getEbayContext(), this, ((Authentication) (obj)));
        if (activeSearchResults.savedSearch == null)
        {
            queryRelatedSearches(activeSearchResults);
        }
        obj = null;
        if (searchresults.savedSearch == null)
        {
            obj = activeSearchResults.getRefinementsSummary(getResources());
        }
        noResultsLayout.setVisibility(8);
        refinementsSummary.setText(((CharSequence) (obj)));
        refinementsSummary.setVisibility(0);
    }

    private void queryRelatedSearches(SearchResults searchresults)
    {
        if (isRelatedSearchesEnabled(searchresults))
        {
            searchresults.relatedSearches = null;
            EbayShoppingApi ebayshoppingapi = EbayApiUtil.getShoppingApi(this);
            List list = addCategoryToList(searchresults.searchParameters.category, null);
            list = addCategoryToList(searchresults.searchParameters.category1, list);
            list = addCategoryToList(searchresults.searchParameters.category2, list);
            getFwLoaderManager().start(0, new FindPopularSearchesNetLoader(getEbayContext(), ebayshoppingapi, searchresults.searchParameters.keywords, list, searchresults.hashCode()), true);
        }
    }

    private void requery(Intent intent)
    {
        intent = init(intent, null);
        if (activeSearchResults != null)
        {
            if (activeSearchResults.asyncTask != null)
            {
                activeSearchResults.asyncTask.removeObserver(this);
                activeSearchResults.asyncTask.cancel(true);
            }
            if (activeSearchResults.result != null)
            {
                activeSearchResults.result.list.unregisterObserver(this);
                activeSearchResults.result.list.clear();
            }
            activeSearchResults = null;
        }
        getSupportActionBar().setSubtitle(null);
        setListAdapter(null);
        query(intent);
    }

    private void setProgressOff()
    {
        findViewById(0x7f100120).setVisibility(8);
    }

    private void setProgressOn()
    {
        findViewById(0x7f100120).setVisibility(0);
    }

    private void setQuantityText(com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult searchlistresult)
    {
        int i = searchlistresult.totalItemsCount;
        searchlistresult = NumberFormat.getInstance().format(i);
        searchlistresult = getResources().getQuantityString(0x7f080015, i, new Object[] {
            searchlistresult
        });
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            actionbar.setSubtitle(searchlistresult);
        }
    }

    private void setSearchResultAdapter()
    {
        com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult searchlistresult;
        final AsyncList items;
        boolean flag;
        flag = true;
        searchlistresult = activeSearchResults.result;
        items = searchlistresult.list;
        break MISSING_BLOCK_LABEL_16;
        SearchListAdapter searchlistadapter;
        int i;
        if (activeSearchResults.searchParameters != null && activeSearchResults.searchParameters.hideShipping)
        {
            flag = false;
        }
        if (activeSearchResults.searchParameters != null)
        {
            i = activeSearchResults.searchParameters.buyingFormat;
        } else
        {
            i = 7;
        }
        searchlistadapter = new SearchListAdapter(this, flag, i, items, activeSearchResults.relatedSearches, 0x7f030074);
        setQuantityText(searchlistresult);
        setListAdapter(searchlistadapter);
        getListView().post(new Runnable() {

            final SavedSearchResultListActivity this$0;
            final List val$items;

            public void run()
            {
                getListView().setSelection(Math.min(items.size(), scrollPosition));
            }

            
            {
                this$0 = SavedSearchResultListActivity.this;
                items = list;
                super();
            }
        });
        timer.start();
        return;
    }

    private void setupActivityState(Bundle bundle)
    {
        _searchState = SearchState.values()[bundle.getInt("search_state")];
        activeSearchResults = init(getIntent(), bundle);
    }

    private void setupTimer()
    {
        timer.setOnTimerEvent(new com.ebay.common.EbayTimer.OnTimerEvent() {

            final SavedSearchResultListActivity this$0;

            public void OnTimer()
            {
                android.widget.ListAdapter listadapter = getListAdapter();
                if (listadapter != null)
                {
                    ((SearchListAdapter)listadapter).refresh(getListView());
                }
            }

            
            {
                this$0 = SavedSearchResultListActivity.this;
                super();
            }
        });
    }

    private void setupViewForResultsFound()
    {
        activeSearchResults.result.list.registerObserver(this);
        buttonRefine.setVisibility(0);
        setSearchResultAdapter();
        refinementsSummary.setVisibility(8);
    }

    private void setupViews(SearchResults searchresults)
    {
        SearchParameters searchparameters = searchresults.searchParameters;
        SavedSearch savedsearch = searchresults.savedSearch;
        searchresults = null;
        if (savedsearch != null)
        {
            String s = savedsearch.name;
            itemKind = com.ebay.common.ConstantsCommon.ItemKind.Found;
            searchresults = s;
            if (spinner.getAdapter() == null)
            {
                searchresults = new ArrayList();
                searchresults.add(getString(0x7f070167));
                searchresults.add(getString(0x7f070654));
                searchresults = new SpinnerAdapter(this, 0x1090008, searchresults);
                spinner.setAdapter(searchresults);
                searchresults.setDropDownViewResource(0x1090009);
                int i = 0;
                if (savedsearch.newItemsOnly)
                {
                    i = 1;
                    spinner.setSelection(1);
                }
                spinner.setOnItemSelectedListener(new OnItemSelectedListenerWrapper(i, new android.widget.AdapterView.OnItemSelectedListener() {

                    final SavedSearchResultListActivity this$0;

                    public void onItemSelected(AdapterView adapterview, View view1, int k, long l)
                    {
                        if (activeSearchResults == null || activeSearchResults.savedSearch == null) goto _L2; else goto _L1
_L1:
                        if (k != 0) goto _L4; else goto _L3
_L3:
                        activeSearchResults.savedSearch.newItemsOnly = false;
_L6:
                        query(new SearchResults(activeSearchResults.savedSearch));
_L2:
                        return;
_L4:
                        if (k == 1)
                        {
                            activeSearchResults.savedSearch.newItemsOnly = true;
                        }
                        if (true) goto _L6; else goto _L5
_L5:
                    }

                    public void onNothingSelected(AdapterView adapterview)
                    {
                    }

            
            {
                this$0 = SavedSearchResultListActivity.this;
                super();
            }
                }));
                searchresults = s;
            }
        } else
        {
            showNewItemsLayout.setVisibility(8);
        }
        if (searchparameters != null)
        {
            Object obj;
            Object obj1;
            Button button;
            int j;
            byte byte0;
            if (activeSearchResults != null && activeSearchResults.isLoaded)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (!TextUtils.isEmpty(searchparameters.sellerId))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            isSearchRefined = isRefined(searchparameters);
            obj = getResources().getColorStateList(ThemeUtil.resolveThemeForegroundColorResId(getTheme(), 0x1010212));
            obj1 = getResources().getColorStateList(ThemeUtil.resolveThemeForegroundColorResId(getTheme(), 0x1010036));
            button = buttonRefine;
            if (!isSearchRefined)
            {
                obj = obj1;
            }
            button.setTextColor(((android.content.res.ColorStateList) (obj)));
            buttonRefine.setVisibility(0);
            if (byte0 != 0)
            {
                obj = (new StringBuilder()).append(getString(0x7f0709ed)).append(" ").append(searchparameters.sellerId).toString();
                searchresults = ((SearchResults) (obj));
                if (!TextUtils.isEmpty(searchparameters.keywords))
                {
                    searchresults = (new StringBuilder()).append(((String) (obj))).append(" - ").append(searchparameters.keywords).toString();
                }
                itemKind = com.ebay.common.ConstantsCommon.ItemKind.SellersOther;
                obj = searchresults;
            } else
            {
                itemKind = com.ebay.common.ConstantsCommon.ItemKind.Found;
                obj = searchresults;
            }
            searchresults = ((SearchResults) (obj));
            if (obj == null)
            {
                if (searchparameters.productId != null)
                {
                    obj = (new StringBuilder()).append(searchparameters.productIdType).append(':').append(searchparameters.productId).toString();
                } else
                {
                    obj = searchparameters.keywords;
                }
                if (byte0 != 0)
                {
                    obj1 = (new StringBuilder()).append(getString(0x7f0709ed)).append(" ").append(searchparameters.sellerId).toString();
                    searchresults = ((SearchResults) (obj1));
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        searchresults = (new StringBuilder()).append(((String) (obj1))).append(" - ").append(((String) (obj))).toString();
                    }
                } else
                {
                    searchresults = ((SearchResults) (obj));
                }
            }
            obj = refinementsSummary;
            if (j != 0)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            ((TextView) (obj)).setVisibility(byte0);
            if (savedsearch == null)
            {
                obj = noResultsLayout;
                if (j != 0)
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                ((View) (obj)).setVisibility(j);
            } else
            {
                View view = savedSearchNoResultsLayout;
                if (j != 0)
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                view.setVisibility(j);
            }
        } else
        {
            buttonRefine.setVisibility(8);
        }
        setTitle(searchresults);
    }

    private void showNoResultsUI(String s)
    {
        if (activeSearchResults.savedSearch != null)
        {
            savedSearchNoResultsLayout.setVisibility(0);
            noResultsLayout.setVisibility(8);
            int i;
            if (activeSearchResults.savedSearch.newItemsOnly)
            {
                i = 0x7f070947;
            } else
            {
                i = 0x7f070946;
            }
            savedSearchNoResultsText.setText(getString(i, new Object[] {
                s
            }));
        }
    }

    private void trackZrpEvent(String s)
    {
        TrackingData trackingdata = new TrackingData("NullSearch", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", s);
        trackingdata.send(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14 && icsCrashHackIgnoreBack)
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public String getTrackingEventName()
    {
        return "SearchResultsViewed";
    }

    protected boolean isRelatedSearchesEnabled(SearchResults searchresults)
    {
        return searchresults.searchParameters.sellerId == null && searchresults.searchParameters.productId == null && searchresults.searchParameters.aspectHistogram == null && DeviceConfiguration.getAsync().get(DcsBoolean.RelatedSearches);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   65: 87
    //                   527: 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (j == -1 && (!TextUtils.isEmpty(intent = intent.getStringExtra("category_name")) && activeSearchResults.searchParameters != null && activeSearchResults.searchParameters.category != null))
        {
            activeSearchResults.searchParameters.category.name = intent;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (j == -1)
        {
            query(init(intent, null));
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (activeSearchResults == null || activeSearchResults.asyncTask == null || activeSearchResults.asyncTask.cancel(true))
        {
            finish();
        }
    }

    public void onChanged()
    {
        if (getListAdapter() != null)
        {
            getListView().invalidateViews();
        }
        removeDialog(0x7f070151);
        setProgressOff();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756555: 
            break;
        }
        if (activeSearchResults != null && activeSearchResults.result != null && activeSearchResults.result.totalItemsCount == 0)
        {
            trackZrpEvent("NSRR");
        }
        if (activeSearchResults != null && activeSearchResults.savedSearch != null)
        {
            showDialog(0x7f070615);
            return;
        } else
        {
            onRefineSearch();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301e7);
        Intent intent = getIntent();
        referrer = intent.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = intent.getStringExtra("com.ebay.mobile.tracking.BidSource");
        trackingSid = (SourceIdentification)intent.getParcelableExtra("com.ebay.mobile.analytics.sid");
        trackingSidForSrp = trackingSid;
        initFields();
        currentCountry = EbayApiUtil.getCurrentCountry();
        ConfigInstanceState configinstancestate = (ConfigInstanceState)getLastFwNonConfigurationInstance();
        if (configinstancestate != null)
        {
            activeSearchResults = configinstancestate.activeSearchResults;
            _searchState = configinstancestate.searchState;
            if (activeSearchResults != null)
            {
                if (activeSearchResults.result != null)
                {
                    activeSearchResults.result.list.registerObserver(this);
                }
                if (activeSearchResults.asyncTask != null)
                {
                    activeSearchResults.asyncTask.addObserver(this);
                } else
                if (activeSearchResults.isLoaded)
                {
                    setSearchResultAdapter();
                }
                setupViews(activeSearchResults);
            }
        } else
        if (bundle != null)
        {
            setupActivityState(bundle);
            query(activeSearchResults);
        } else
        {
            bundle = init(intent, bundle);
            if (bundle == null)
            {
                finish();
                return;
            }
            query(bundle);
        }
        setupTimer();
    }

    protected Dialog onCreateDialog(int i)
    {
        boolean flag = MyApp.getDeviceConfiguration().isMaintenanceWindow();
        String s = null;
        if (flag)
        {
            s = getString(0x7f0705fd);
        }
        switch (i)
        {
        default:
            return super.onCreateDialog(i);

        case 2131165506: 
        case 2131165507: 
        case 2131165518: 
            return (new android.support.v7.app.AlertDialog.Builder(this)).setMessage(i).setNegativeButton(0x104000a, DialogManager.closeListener).setOnCancelListener(this).setTitle(s).create();

        case 2131165521: 
            return (new android.support.v7.app.AlertDialog.Builder(this)).setMessage(i).setNegativeButton(0x1040000, DialogManager.closeListener).setPositiveButton(0x7f070920, new android.content.DialogInterface.OnClickListener() {

                final SavedSearchResultListActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    setProgressOn();
                    dialoginterface = MyApp.getPrefs().getAuthentication();
                    activeSearchResults.retry(getEbayContext(), SavedSearchResultListActivity.this, dialoginterface);
                }

            
            {
                this$0 = SavedSearchResultListActivity.this;
                super();
            }
            }).setOnCancelListener(this).setTitle(s).create();

        case 2131165489: 
        case 2131165490: 
            return DialogManager.createAlertDialog(this, i);

        case 2131166741: 
            return (new android.support.v7.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0708e1)).setMessage(i).setCancelable(true).setNegativeButton(0x1040000, DialogManager.closeListener).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

                final SavedSearchResultListActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    onRefineSearch();
                }

            
            {
                this$0 = SavedSearchResultListActivity.this;
                super();
            }
            }).create();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        if (MyApp.getPrefs().getGlobalPref("developerOptionSearchUrl", false))
        {
            menu.add("URL").setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final SavedSearchResultListActivity this$0;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    if (activeSearchResults != null && activeSearchResults.result != null && activeSearchResults.result.searchUrl != null) goto _L2; else goto _L1
_L1:
                    Toast.makeText(SavedSearchResultListActivity.this, "There are no search results!", 1).show();
_L4:
                    return true;
_L2:
label0:
                    {
                        menuitem = activeSearchResults.result.searchUrl;
                        Object obj = Uri.parse(menuitem);
                        Object obj1 = ((Uri) (obj)).getEncodedQuery();
                        if (obj1 == null)
                        {
                            break label0;
                        }
                        menuitem = new HashSet(Arrays.asList(new String[] {
                            "_pos", "_stpos", "_ipg", "_pgn", "_os"
                        }));
                        obj1 = new StringBuilder(((String) (obj1)));
                        int j = 0;
label1:
                        do
                        {
                            int i;
label2:
                            {
                                if (j >= ((StringBuilder) (obj1)).length())
                                {
                                    break label1;
                                }
                                int l = ((StringBuilder) (obj1)).indexOf("&", j);
                                int k;
                                int i1;
                                if (l == -1)
                                {
                                    i = ((StringBuilder) (obj1)).length();
                                } else
                                {
                                    i = l;
                                }
                                i1 = ((StringBuilder) (obj1)).indexOf("=", j);
                                if (i1 != -1)
                                {
                                    k = i1;
                                    if (i1 <= i)
                                    {
                                        break label2;
                                    }
                                }
                                k = i;
                            }
                            if (menuitem.contains(((StringBuilder) (obj1)).substring(j, k)))
                            {
                                if (l != -1)
                                {
                                    ((StringBuilder) (obj1)).delete(j, l + 1);
                                } else
                                if (j > 0)
                                {
                                    ((StringBuilder) (obj1)).delete(j - 1, i);
                                } else
                                {
                                    ((StringBuilder) (obj1)).delete(j, i);
                                }
                            } else
                            {
                                j = i + 1;
                            }
                        } while (true);
                        if (((StringBuilder) (obj1)).length() == 0)
                        {
                            menuitem = null;
                        } else
                        {
                            menuitem = ((StringBuilder) (obj1)).toString();
                        }
                        menuitem = ((Uri) (obj)).buildUpon().encodedQuery(menuitem).build().toString();
                    }
                    obj = new Intent("android.intent.action.SEND");
                    ((Intent) (obj)).setType("text/plain");
                    ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", "URL for RTM");
                    ((Intent) (obj)).putExtra("android.intent.extra.TEXT", menuitem);
                    menuitem = Intent.createChooser(((Intent) (obj)), "URL for RTM");
                    startActivity(menuitem);
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = SavedSearchResultListActivity.this;
                super();
            }
            });
        }
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        destroySearchResults(activeSearchResults);
    }

    public void onError(int i, List list)
    {
        Object obj;
        if (activeSearchResults == null)
        {
            obj = null;
        } else
        {
            obj = activeSearchResults.getCompletedTask(this);
        }
        if (!isFinishing())
        {
            setProgressOff();
            refinementsSummary.setVisibility(8);
            if (activeSearchResults != null && activeSearchResults.searchParameters != null && activeSearchResults.searchParameters.keywords != null)
            {
                noResultsText.setText(getString(0x7f07066e, new Object[] {
                    activeSearchResults.searchParameters.keywords
                }));
            } else
            {
                noResultsText.setText(null);
            }
            noResultsLayout.setVisibility(0);
            if (EbayErrorUtil.savedSearchError(list) && activeSearchResults != null && activeSearchResults.savedSearch != null)
            {
                ((DialogManager)getShim(com/ebay/common/view/util/DialogManager)).showDynamicAlertDialog(null, getString(0x7f070616, new Object[] {
                    activeSearchResults.savedSearch.name
                }), true);
                return;
            }
            if (obj != null)
            {
                obj = new ErrorHandler(this, ((FindItemListAsyncTask) (obj)).isRetry);
                ((ErrorHandler) (obj)).handleEbayError(i, list);
                if (!((ErrorHandler) (obj)).wasRetry && i != -1)
                {
                    finish();
                    return;
                }
            }
        }
    }

    public void onGetNotReady()
    {
        setProgressOn();
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        if (l > 0L)
        {
            icsCrashHackIgnoreBack = true;
            listview = (EbaySearchListItem)listview.getItemAtPosition(i);
            LruVisitedItemCache.get().remember(Long.valueOf(((EbaySearchListItem) (listview)).id));
            ((SearchListAdapter)getListAdapter()).markItemAsVisited(view, listview);
            ItemViewActivity.StartActivity(this, ((EbaySearchListItem) (listview)).id, ((EbaySearchListItem) (listview)).endDate, itemKind, referrer, bidSource, i + 1, null, activeSearchResults.searchParameters.inStorePickupOnly, activeSearchResults.searchParameters.ebnOnly, activeSearchResults.searchParameters.searchOtherCountries, ((EbaySearchListItem) (listview)).originalRetailPrice, ((EbaySearchListItem) (listview)).isPlusEligible);
        } else
        if (SearchListAdapter.isRelatedSearchesItem(i) && activeSearchResults.relatedSearches != null)
        {
            icsCrashHackIgnoreBack = true;
            listview = new Intent(this, com/ebay/mobile/search/RelatedSearchesActivity);
            listview.putStringArrayListExtra("related_searches", activeSearchResults.relatedSearches);
            listview.putExtra("com.ebay.mobile.tracking.Referrer", referrer);
            listview.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            listview.putExtra("search_param", activeSearchResults.searchParameters);
            startActivity(listview);
            return;
        }
    }

    public void onNetworkError(IOException ioexception)
    {
        setProgressOff();
        showDialog(0x7f070151);
    }

    protected void onNewIntent(Intent intent)
    {
        SiteSpeedActivityUtil.initSiteSpeedData(this, getTrackingEventName());
        super.onNewIntent(intent);
        referrer = intent.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = intent.getStringExtra("com.ebay.mobile.tracking.BidSource");
        setIntent(intent);
        requery(intent);
    }

    protected void onPause()
    {
        super.onPause();
        timer.stop();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle.getBoolean("refined", false))
        {
            android.content.res.ColorStateList colorstatelist = ThemeUtil.resolveThemeColorStateList(getResources(), getTheme(), 0x1010212);
            buttonRefine.setTextColor(colorstatelist);
        }
        itemKind = com.ebay.common.ConstantsCommon.ItemKind.values()[bundle.getInt("item_kind")];
        trackingSid = (SourceIdentification)bundle.getParcelable("com.ebay.mobile.analytics.sid");
        trackingSidForSrp = (SourceIdentification)bundle.getParcelable("com.ebay.mobile.analytics.sid.FWD");
        scrollPosition = bundle.getInt("scrollPos");
    }

    protected void onResume()
    {
        super.onResume();
        icsCrashHackIgnoreBack = false;
        if (Debug.logBidTracking.isLoggable)
        {
            FwLog.println(Debug.logBidTracking, (new StringBuilder()).append(com/ebay/mobile/activities/SavedSearchResultListActivity.getSimpleName()).append(" referrer:").append(referrer).append(" bidSource:").append(bidSource).toString());
        }
        Object obj = getIntent();
        if (((Intent) (obj)).getBooleanExtra("saved_search_from_notification", false))
        {
            TrackingData trackingdata = new TrackingData("SearchResultsFromSSNotification", TrackingType.EVENT);
            trackingdata.addKeyValuePair("ssrid", ((Intent) (obj)).getStringExtra("saved_search_id"));
            NotificationTrackingUtil.addNotificationTracking(this, trackingdata, ((Intent) (obj)), com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name());
            trackingdata.send(this);
        }
        if (Util.currentLanguageBadForSearch())
        {
            obj = getString(0x7f070674, new Object[] {
                MyApp.getPrefs().getCurrentCountry().getSiteLocale().getDisplayLanguage()
            });
            noResultsTipLanguage.setText(((CharSequence) (obj)));
            noResultsTipLanguage.setVisibility(0);
        } else
        {
            noResultsTipLanguage.setVisibility(8);
        }
        if (activeSearchResults == null || activeSearchResults.asyncTask != null) goto _L2; else goto _L1
_L1:
        timer.start();
_L4:
        obj = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        if (trackingSid != null)
        {
            ((TrackingData) (obj)).addSourceIdentification(trackingSid);
            trackingSid = null;
        }
        ((TrackingData) (obj)).send(this);
        return;
_L2:
        if (activeSearchResults != null && !activeSearchResults.isLoaded)
        {
            if (activeSearchResults.savedSearch == null)
            {
                CharSequence charsequence = activeSearchResults.getRefinementsSummary(getResources());
                refinementsSummary.setText(charsequence);
                refinementsSummary.setVisibility(0);
                noResultsLayout.setVisibility(8);
            }
            setProgressOn();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object onRetainFwNonConfigurationInstance()
    {
        return new ConfigInstanceState(activeSearchResults, _searchState);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (isSearchRefined)
        {
            bundle.putBoolean("refined", isSearchRefined);
        }
        if (getListView() != null)
        {
            bundle.putInt("scrollPos", getListView().getFirstVisiblePosition());
        }
        int i;
        if (itemKind == null)
        {
            i = com.ebay.common.ConstantsCommon.ItemKind.Unknown.ordinal();
        } else
        {
            i = itemKind.ordinal();
        }
        bundle.putInt("item_kind", i);
        bundle.putInt("search_state", _searchState.ordinal());
        if (trackingSid != null)
        {
            bundle.putParcelable("com.ebay.mobile.analytics.sid", trackingSid);
        }
        if (trackingSidForSrp != null)
        {
            bundle.putParcelable("com.ebay.mobile.analytics.sid.FWD", trackingSidForSrp);
        }
        if (activeSearchResults != null)
        {
            if (activeSearchResults.savedSearch != null)
            {
                bundle.putParcelable("SavedSearch", activeSearchResults.savedSearch);
            } else
            if (activeSearchResults.searchParameters != null)
            {
                bundle.putParcelable("search_param", activeSearchResults.searchParameters);
                return;
            }
        }
    }

    public void onTaskComplete(int i, FwLoader fwloader)
    {
        if (!isFinishing())
        {
            switch (i)
            {
            default:
                return;

            case 0: // '\0'
                fwloader = (FindPopularSearchesNetLoader)fwloader;
                break;
            }
            SearchResults searchresults = activeSearchResults;
            if (!fwloader.isError())
            {
                handleRelatedSearchTracking(fwloader.getSearchKeywords());
            }
            if (fwloader.isError())
            {
                searchresults.relatedSearches = null;
                return;
            }
            searchresults.relatedSearches = fwloader.getSearchKeywords();
            if (activeSearchResults.isLoaded)
            {
                setSearchResultAdapter();
                return;
            }
        }
    }

    public void onTaskComplete(com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult searchlistresult)
    {
        FindItemListAsyncTask finditemlistasynctask = activeSearchResults.getCompletedTask(this);
        if (!isFinishing())
        {
            if (searchlistresult == null || finditemlistasynctask == null)
            {
                setProgressOff();
                finish();
                return;
            }
            if (finditemlistasynctask.isRetry)
            {
                onRefreshAfterNetworkFailure();
                return;
            }
            activeSearchResults.isLoaded = true;
            static class _cls7
            {

                static final int $SwitchMap$com$ebay$mobile$activities$SavedSearchResultListActivity$SearchState[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$activities$SavedSearchResultListActivity$SearchState = new int[SearchState.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$activities$SavedSearchResultListActivity$SearchState[SearchState.PRIMARY_SEARCH.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                }
            }

            switch (_cls7..SwitchMap.com.ebay.mobile.activities.SavedSearchResultListActivity.SearchState[_searchState.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                handleStandardSearchResult(searchlistresult);
                break;
            }
            if (activeSearchResults.asyncTask == null)
            {
                setProgressOff();
                return;
            }
        }
    }

    public volatile void onTaskComplete(Object obj)
    {
        onTaskComplete((com.ebay.common.net.api.search.SavedSearchesApi.SearchListResult)obj);
    }






}
