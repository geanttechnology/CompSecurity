// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.EbayFindingApi;
import com.ebay.common.net.api.search.FindPopularSearchesRequest;
import com.ebay.common.net.api.search.FindPopularSearchesResponse;
import com.ebay.common.net.api.search.ISearchEventTracker;
import com.ebay.common.net.api.search.KnownSearchExpansion;
import com.ebay.common.net.api.search.SearchConfiguration;
import com.ebay.common.net.api.search.SearchExpansion;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResult;
import com.ebay.common.net.api.search.SearchResultState;
import com.ebay.common.net.api.search.SearchServiceApi;
import com.ebay.common.rtm.RtmHelper;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.google.gson.Gson;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager, RlProductInfoDataManager

public class SearchDataManager extends DataManager
{
    public static class ConcreteObserver
        implements Observer
    {

        public void onAdsLoaded(SearchResultState searchresultstate)
        {
        }

        public void onPopularSearchesAvailable(ArrayList arraylist, int i)
        {
        }

        public void onSearchCancelled()
        {
        }

        public void onSearchComplete(SearchResultState searchresultstate)
        {
        }

        public void onSearchContentChanged(ListContent listcontent)
        {
        }

        public void onSearchStarted(SearchParameters searchparameters)
        {
        }

        public ConcreteObserver()
        {
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
    {

        public final String uniquifier = UUID.randomUUID().toString();

        public static KeyParams fromString(String s)
        {
            return (KeyParams)DataMapperFactory.getDefaultMapper().fromJson(s, com/ebay/common/content/dm/SearchDataManager$KeyParams);
        }

        public SearchDataManager createManager(EbayContext ebaycontext)
        {
            return new SearchDataManager(ebaycontext, com/ebay/common/content/dm/SearchDataManager$Observer, this);
        }

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            } else
            {
                obj = (KeyParams)obj;
                return uniquifier.equals(((KeyParams) (obj)).uniquifier);
            }
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + uniquifier.hashCode();
        }

        public String toString()
        {
            return DataMapperFactory.getDefaultMapper().toJson(this);
        }

        public KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onAdsLoaded(SearchResultState searchresultstate);

        public abstract void onPopularSearchesAvailable(ArrayList arraylist, int i);

        public abstract void onSearchCancelled();

        public abstract void onSearchComplete(SearchResultState searchresultstate);

        public abstract void onSearchContentChanged(ListContent listcontent);

        public abstract void onSearchStarted(SearchParameters searchparameters);
    }

    private static interface PopularSearchResult
    {

        public abstract ArrayList getPopularKeywords();

        public abstract int getTag();
    }

    public final class PopularSearchesLoadTask extends AsyncTask
        implements PopularSearchResult
    {

        private final EbayShoppingApi api;
        private List categories;
        private final String keywords;
        private final SearchResultLoadTask parentSearchLoadTask;
        private ArrayList popularSearchKeywords;
        private final int tag;
        final SearchDataManager this$0;

        private List addCategoryToList(EbayCategorySummary ebaycategorysummary, List list)
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

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient ArrayList doInBackground(Void avoid[])
        {
            Object obj;
            obj = new FindPopularSearchesRequest(api, keywords, categories);
            avoid = null;
            obj = (FindPopularSearchesResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(getEbayContext(), ((com.ebay.nautilus.kernel.net.Request) (obj)));
            avoid = ((Void []) (obj));
_L1:
            Object obj1;
            if (avoid == null)
            {
                return null;
            } else
            {
                return avoid.getRelatedSearches();
            }
            obj1;
            ((com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException) (obj1)).printStackTrace();
              goto _L1
            obj1;
            ((com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException) (obj1)).printStackTrace();
              goto _L1
            obj1;
            ((IOException) (obj1)).printStackTrace();
              goto _L1
            obj1;
            ((InterruptedException) (obj1)).printStackTrace();
              goto _L1
        }

        public ArrayList getPopularKeywords()
        {
            return popularSearchKeywords;
        }

        public int getTag()
        {
            return tag;
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handlePopularSearchesLoaded(parentSearchLoadTask, this);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ArrayList)obj);
        }

        protected void onPostExecute(ArrayList arraylist)
        {
            super.onPostExecute(arraylist);
            popularSearchKeywords = arraylist;
            handlePopularSearchesLoaded(parentSearchLoadTask, this);
        }

        public PopularSearchesLoadTask(SearchResultLoadTask searchresultloadtask)
        {
            this$0 = SearchDataManager.this;
            super();
            popularSearchKeywords = null;
            parentSearchLoadTask = searchresultloadtask;
            searchdatamanager = searchresultloadtask.param.searchParameters;
            api = new EbayShoppingApi(country.site);
            keywords = SearchDataManager.this.keywords;
            categories = null;
            categories = addCategoryToList(category, categories);
            categories = addCategoryToList(category1, categories);
            categories = addCategoryToList(category2, categories);
            tag = 0;
        }

        public PopularSearchesLoadTask(EbayShoppingApi ebayshoppingapi, String s, List list, int i)
        {
            this$0 = SearchDataManager.this;
            super();
            popularSearchKeywords = null;
            parentSearchLoadTask = null;
            api = ebayshoppingapi;
            keywords = s;
            categories = list;
            tag = i;
        }
    }

    public static class SearchExpansionDescriptor
    {

        public final SearchExpansion expansion;
        public final SearchParameters expansionSearchParameters;
        public final KnownSearchExpansion expansionType;

        public long getAbridgedMatchCount()
        {
            return expansion.expansionResult.abridgedMatchCount;
        }

        public List getItems()
        {
            ArrayList arraylist = expansion.expansionResult.searchRecords;
            Object obj = arraylist;
            if (expansionType == KnownSearchExpansion.CROSS_BORDER)
            {
                obj = arraylist;
                if (arraylist.size() > 10)
                {
                    obj = arraylist.subList(0, 10);
                }
            }
            return ((List) (obj));
        }

        public long getMatchCount()
        {
            return expansion.expansionResult.matchCount;
        }

        public boolean isDisplayedOnTop()
        {
            return expansionType.isDisplayedOnTop;
        }

        private SearchExpansionDescriptor(KnownSearchExpansion knownsearchexpansion, SearchExpansion searchexpansion, SearchParameters searchparameters)
        {
            expansionType = knownsearchexpansion;
            expansionSearchParameters = searchparameters;
            expansion = searchexpansion;
        }

    }

    public final class SearchResultLoadTask extends AsyncTask
    {

        private PopularSearchResult asyncPopularSearchResult;
        private SearchResultLoadTaskParams param;
        private SearchResult result;
        final SearchDataManager this$0;

        private SearchResult doFindingSearch()
            throws InterruptedException
        {
            Object obj = param.searchParameters;
            SearchResult searchresult = EbayFindingApi.findItem(getEbayContext(), ((SearchParameters) (obj)), param.config.isGbhEnabled, param.searchTracker);
            ResultStatus resultstatus = searchresult.resultStatus;
            Object obj1 = searchresult;
            if (resultstatus.hasError())
            {
                if (((SearchParameters) (obj)).productId != null && param.config.isRedLaserFallbackEnabled && EbayErrorUtil.noProductMatch(resultstatus.getMessages()))
                {
                    obj = doRedLaserFallback(param);
                } else
                {
                    obj = EbayFindingApi.doFallback(getEbayContext(), ((SearchParameters) (obj)), param.config.isGbhEnabled, param.searchTracker, resultstatus.getMessages());
                }
                obj1 = searchresult;
                if (obj != null)
                {
                    param.searchParameters = ((SearchResult) (obj)).getSearchParameters();
                    obj1 = obj;
                }
            }
            return ((SearchResult) (obj1));
        }

        private SearchResult doRedLaserFallback(SearchResultLoadTaskParams searchresultloadtaskparams)
            throws InterruptedException
        {
            Object obj = null;
            Object obj1 = searchresultloadtaskparams.searchParameters;
            String s = ((SearchParameters) (obj1)).productId;
            String s1 = ((SearchParameters) (obj1)).productIdType;
            com.ebay.nautilus.domain.EbaySite ebaysite = ((SearchParameters) (obj1)).country.site;
            s = RlProductInfoDataManager.getRLKeywordsSynchronous(getEbayContext(), ebaysite, s, s1);
            if (!TextUtils.isEmpty(s))
            {
                obj = ((SearchParameters) (obj1)).clone();
                obj.keywords = s;
                obj.productId = null;
                obj.productIdType = null;
                obj1 = searchresultloadtaskparams.searchTracker;
                boolean flag = param.config.isGbhEnabled;
                if (param.config.isSearchServiceEnabled)
                {
                    obj1 = SearchServiceApi.executeSearch(getEbayContext(), ((SearchParameters) (obj)), ((ISearchEventTracker) (obj1)), param.config);
                } else
                {
                    obj1 = EbayFindingApi.findItem(getEbayContext(), ((SearchParameters) (obj)), flag, ((ISearchEventTracker) (obj1)));
                }
                obj = obj1;
                if (((SearchResult) (obj1)).resultStatus.hasError())
                {
                    obj = null;
                }
            }
            if (obj != null && ((SearchResult) (obj)).totalItemCount > 0)
            {
                ((SearchResult) (obj)).setRedLaserCorrectedSearch(new RedLaserCorrectedSearch(searchresultloadtaskparams.searchParameters));
                return ((SearchResult) (obj));
            } else
            {
                return null;
            }
        }

        private SearchResult doSearch()
            throws InterruptedException
        {
            SearchParameters searchparameters = param.searchParameters;
            searchparameters.allowExpansions = searchparameters.allowExpansions & param.config.isSearchExpansionsEnabled;
            SearchResult searchresult1 = SearchServiceApi.executeSearch(getEbayContext(), searchparameters, param.searchTracker, param.config);
            ResultStatus resultstatus = searchresult1.resultStatus;
            SearchResult searchresult = searchresult1;
            if (resultstatus.hasError())
            {
                SearchResult searchresult2 = SearchServiceApi.doFallback(getEbayContext(), searchparameters, param.searchTracker, resultstatus.getMessages(), param.config);
                searchresult = searchresult1;
                if (searchresult2 != null)
                {
                    searchresult = searchresult2;
                    param.searchParameters = searchresult.getSearchParameters();
                }
            }
            if (resultstatus.hasWarning() && SearchServiceApi.isSaasPostalCodeWarning(searchparameters, resultstatus.getMessages()))
            {
                searchparameters.clearZipCodeAndDependencies();
                searchresult.setInvalidPostalCodeCorrectedSearch();
            }
            return searchresult;
        }

        protected transient SearchResult doInBackground(Void avoid[])
        {
            if (isCancelled())
            {
                return null;
            }
            if (param == null)
            {
                throw new InvalidParameterException("SearchResultLoadTask expects config via constructor");
            }
            avoid = param.searchParameters;
            if (!SearchServiceApi.useSearchService(avoid, param.config)) goto _L2; else goto _L1
_L1:
            result = doSearch();
_L4:
            return result;
_L2:
            try
            {
                result = doFindingSearch();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                result = new SearchResult(ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    InternalDomainError.getNoNetworkMessage()
                }));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public SearchResultLoadTaskParams getParams()
        {
            return param;
        }

        public PopularSearchResult getPopularSearchResult()
        {
            return asyncPopularSearchResult;
        }

        public SearchResult getResult()
        {
            return result;
        }

        protected void onPostExecute(SearchResult searchresult)
        {
            onPostExecute(searchresult);
            handleSearchResultLoaded(this, searchresult);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((SearchResult)obj);
        }

        public void setPopularSearchResult(PopularSearchResult popularsearchresult)
        {
            asyncPopularSearchResult = popularsearchresult;
        }


        public SearchResultLoadTask(SearchResultLoadTaskParams searchresultloadtaskparams)
        {
            this$0 = SearchDataManager.this;
            super();
            result = null;
            param = null;
            asyncPopularSearchResult = null;
            param = searchresultloadtaskparams;
        }
    }

    private class SearchResultLoadTaskParams
    {

        public SearchConfiguration config;
        public Observer ownerObserver;
        public SearchParameters searchParameters;
        public ISearchEventTracker searchTracker;
        final SearchDataManager this$0;

        public SearchResultLoadTaskParams(SearchParameters searchparameters, SearchConfiguration searchconfiguration, Observer observer, ISearchEventTracker isearcheventtracker)
        {
            this$0 = SearchDataManager.this;
            super();
            searchParameters = searchparameters.clone();
            config = searchconfiguration;
            ownerObserver = observer;
            searchTracker = isearcheventtracker;
        }
    }


    private static final int MAX_CROSS_BORDER_ITEMS = 10;
    public static final int MAX_NUMBER_PAGES = 50;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new LogInfo("SearchDataManager", 2, "Log search data manager usage");
    private PopularSearchesLoadTask currentPopularSearchesTask;
    private SearchResultLoadTask currentSearchResultTask;
    private SearchResultState lastResultState;
    private final KeyParams params;
    private SearchResultEventRouter searchResultEventRouter;

    protected SearchDataManager(EbayContext ebaycontext, Class class1, KeyParams keyparams)
    {
        super(ebaycontext, class1);
        currentSearchResultTask = null;
        currentPopularSearchesTask = null;
        searchResultEventRouter = null;
        lastResultState = null;
        params = keyparams;
    }

    private void deliverResultState(SearchResultState searchresultstate)
    {
        if (searchresultstate == null)
        {
            return;
        } else
        {
            ((Observer)dispatcher).onSearchComplete(searchresultstate);
            return;
        }
    }

    private void getAds(final SearchResultState resultState, EbayCguidPersister ebaycguidpersister, final int maxItems, int i)
    {
        AdRtmDataManager adrtmdatamanager = (AdRtmDataManager)DataManager.get(getEbayContext(), new AdRtmDataManager.KeyParams());
        adrtmdatamanager.registerObserver(new AdRtmDataManager.Observer() {

            final SearchDataManager this$0;
            final int val$maxItems;
            final SearchResultState val$resultState;

            public void onAdsContextReady(List list, AdRtmDataManager.AdRequestType adrequesttype)
            {
            }

            public void onAdsReady(RtmHelper rtmhelper, AdRtmDataManager.AdRequestType adrequesttype)
            {
                if (lastResultState == resultState)
                {
                    resultState.setFetchingAds(false);
                    if (rtmhelper == null)
                    {
                        resultState.setSearchAds(null);
                    } else
                    {
                        rtmhelper = rtmhelper.getAds();
                        rtmhelper = rtmhelper.subList(0, Math.min(maxItems, rtmhelper.size()));
                        resultState.setSearchAds(rtmhelper);
                    }
                    if (!resultState.getResult().resultStatus.hasError())
                    {
                        ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = SearchDataManager.this;
                resultState = searchresultstate;
                maxItems = i;
                super();
            }
        });
        SearchParameters searchparameters = resultState.getResult().getSearchParameters();
        if (searchparameters.category == null)
        {
            resultState = null;
        } else
        {
            resultState = Long.toString(searchparameters.category.id);
        }
        adrtmdatamanager.getAds(searchparameters.keywords, resultState, i, ebaycguidpersister, searchparameters.country.site, searchparameters.iafToken, null);
    }

    private void handlePopularSearchesLoaded(SearchResultLoadTask searchresultloadtask, PopularSearchesLoadTask popularsearchesloadtask)
    {
        boolean flag1;
        flag1 = true;
        NautilusKernel.verifyMain();
        break MISSING_BLOCK_LABEL_6;
        if (popularsearchesloadtask == currentPopularSearchesTask && (searchresultloadtask == null || searchresultloadtask == currentSearchResultTask && !searchresultloadtask.isCancelled()))
        {
            ArrayList arraylist = popularsearchesloadtask.getPopularKeywords();
            int i = popularsearchesloadtask.getTag();
            if (arraylist != null && !arraylist.isEmpty())
            {
                boolean flag;
                if (searchresultloadtask != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag || currentSearchResultTask != null)
                {
                    flag1 = false;
                }
                if (!flag || flag1)
                {
                    if (logger.isLoggable)
                    {
                        logger.log("handlePopularSearchesLoaded() - parent search already delivered; dispatch immediately");
                    }
                    if (flag && lastResultState != null)
                    {
                        lastResultState.setPopularSearchResult(arraylist);
                    }
                    ((Observer)dispatcher).onPopularSearchesAvailable(arraylist, i);
                    return;
                }
                if (logger.isLoggable)
                {
                    logger.log("handlePopularSearchesLoaded() - parent search still in-flight; dispatch deferred");
                }
                searchresultloadtask.setPopularSearchResult(popularsearchesloadtask);
                return;
            }
        }
        return;
    }

    private void handleSearchResultLoaded(SearchResultLoadTask searchresultloadtask, SearchResult searchresult)
    {
        NautilusKernel.verifyMain();
        if (searchresultloadtask == currentSearchResultTask) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SearchConfiguration searchconfiguration;
        searchconfiguration = searchresultloadtask.getParams().config;
        currentSearchResultTask = null;
        if (!searchresultloadtask.isCancelled() && searchresult != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (logger.isLoggable)
        {
            logger.log("handleSearchResultLoaded() - current task was cancelled");
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        SearchParameters searchparameters = searchresultloadtask.getParams().searchParameters;
        lastResultState = new SearchResultState(searchresult, searchparameters);
        searchResultEventRouter = new SearchResultEventRouter(searchresult);
        if (searchresult.getSearchParameters() == null)
        {
            deliverResultState(lastResultState);
            return;
        }
        ArrayList arraylist = searchresult.expansions;
        int i = searchresult.totalItemCount;
        boolean flag;
        if (lastResultState.isInitialDelivery() && searchconfiguration.isAdDeliveryEnabled && searchconfiguration.adDeliveryResultCountThreshold > 0 && i <= searchconfiguration.adDeliveryResultCountThreshold && searchparameters.sellerId == null && searchparameters.sellerOffer == null && !TextUtils.isEmpty(searchparameters.keywords))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        lastResultState.setFetchingAds(flag);
        if (arraylist != null)
        {
            populateExpansionDescriptors(arraylist, searchparameters, lastResultState);
        }
        searchresultloadtask = searchresultloadtask.getPopularSearchResult();
        if (searchresultloadtask != null)
        {
            lastResultState.setPopularSearchResult(searchresultloadtask.getPopularKeywords());
        }
        deliverResultState(lastResultState);
        if (flag)
        {
            getAds(lastResultState, searchconfiguration.cguidPersister, searchconfiguration.adDeliveryMaxItems, i);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void loadDataInternal(Observer observer, SearchResultLoadTaskParams searchresultloadtaskparams)
    {
        if (searchresultloadtaskparams == null)
        {
            if (logger.isLoggable)
            {
                logger.log("loadDataInternal() - no new params; reissuing cached result");
            }
            if (lastResultState != null)
            {
                lastResultState.setDelivered();
            }
            deliverResultState(lastResultState);
            return;
        }
        if (currentSearchResultTask != null)
        {
            if (logger.isLoggable)
            {
                logger.log("loadDataInternal() - cancelling in-flight task");
            }
            currentSearchResultTask.cancel(false);
            Observer observer1 = currentSearchResultTask.getParams().ownerObserver;
            if (observer1 != null)
            {
                observer1.onSearchCancelled();
            }
            currentSearchResultTask = null;
        }
        currentSearchResultTask = new SearchResultLoadTask(searchresultloadtaskparams);
        lastResultState = null;
        currentPopularSearchesTask = null;
        if (searchresultloadtaskparams.config.isRelatedSearchesEnabled)
        {
            currentPopularSearchesTask = new PopularSearchesLoadTask(currentSearchResultTask);
        }
        executeOnThreadPool(currentSearchResultTask, new Void[] {
            (Void)null
        });
        if (currentPopularSearchesTask != null)
        {
            executeOnThreadPool(currentPopularSearchesTask, new Void[] {
                (Void)null
            });
        }
        if (observer != null)
        {
            observer.onSearchStarted(searchresultloadtaskparams.searchParameters);
        }
        ((Observer)dispatcher).onSearchStarted(searchresultloadtaskparams.searchParameters);
    }

    private void populateExpansionDescriptors(List list, SearchParameters searchparameters, SearchResultState searchresultstate)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            SearchExpansion searchexpansion = (SearchExpansion)list.next();
            KnownSearchExpansion knownsearchexpansion = KnownSearchExpansion.getTypeForNameAndPromotion(searchexpansion.expansionType, searchexpansion.expansionResult.promotedToPrimary);
            if (knownsearchexpansion.autoPromoted || !searchexpansion.expansionResult.searchRecords.isEmpty())
            {
                SearchParameters searchparameters1 = KnownSearchExpansion.getCorrectedSearchParameters(searchparameters, searchexpansion);
                if ((knownsearchexpansion != KnownSearchExpansion.CROSS_BORDER || searchparameters1 != null || searchexpansion.expansionResult.promotedToPrimary) && (knownsearchexpansion != KnownSearchExpansion.CATEGORY_AUTORUN_NULL || searchparameters.category != null && searchparameters.category.name != null))
                {
                    searchresultstate.addExpansion(new SearchExpansionDescriptor(knownsearchexpansion, searchexpansion, searchparameters1));
                }
            }
        } while (true);
    }

    public void executeSearch(SearchParameters searchparameters, Observer observer, SearchConfiguration searchconfiguration, ISearchEventTracker isearcheventtracker)
    {
        NautilusKernel.verifyMain();
        loadDataInternal(observer, new SearchResultLoadTaskParams(searchparameters, searchconfiguration, observer, isearcheventtracker));
    }

    public Object getParams()
    {
        return params;
    }

    public boolean isRunningSearch()
    {
        NautilusKernel.verifyMain();
        return currentSearchResultTask != null;
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        loadDataInternal(observer, null);
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void loadPage(int i)
    {
        NautilusKernel.verifyMain();
        if (logger.isLoggable)
        {
            logger.log("loadNextPage()");
        }
        if (lastResultState != null)
        {
            lastResultState.getResult().resultOwner.loadPage(i);
        }
    }

    public void retryFailedPages()
    {
        NautilusKernel.verifyMain();
        if (logger.isLoggable)
        {
            logger.log("retryFailedPages()");
        }
        if (lastResultState != null)
        {
            SearchResult searchresult = lastResultState.getResult();
            int i = searchresult.resultOwner.getHigestPageLoaded();
            searchresult.resultOwner.loadPage(i + 1);
        }
    }







}
