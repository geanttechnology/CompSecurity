// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.net.api.search.EbayFindingApi;
import com.ebay.common.net.api.search.SearchConfiguration;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResult;
import com.ebay.common.net.api.search.SearchServiceApi;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.security.InvalidParameterException;

// Referenced classes of package com.ebay.common.content.dm:
//            SearchDataManager, RlProductInfoDataManager

public final class param extends AsyncTask
{

    private asyncPopularSearchResult asyncPopularSearchResult;
    private arams param;
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

    private SearchResult doRedLaserFallback(arams arams)
        throws InterruptedException
    {
        Object obj = null;
        Object obj1 = arams.searchParameters;
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
            obj1 = arams.searchTracker;
            boolean flag = param.config.isGbhEnabled;
            if (param.config.isSearchServiceEnabled)
            {
                obj1 = SearchServiceApi.executeSearch(getEbayContext(), ((SearchParameters) (obj)), ((com.ebay.common.net.api.search.ISearchEventTracker) (obj1)), param.config);
            } else
            {
                obj1 = EbayFindingApi.findItem(getEbayContext(), ((SearchParameters) (obj)), flag, ((com.ebay.common.net.api.search.ISearchEventTracker) (obj1)));
            }
            obj = obj1;
            if (((SearchResult) (obj1)).resultStatus.hasError())
            {
                obj = null;
            }
        }
        if (obj != null && ((SearchResult) (obj)).totalItemCount > 0)
        {
            ((SearchResult) (obj)).setRedLaserCorrectedSearch(new com.ebay.common.net.api.search.nit>(arams.searchParameters));
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
            result = new SearchResult(ResultStatus.create(new com.ebay.nautilus.kernel.content.[] {
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

    public arams getParams()
    {
        return param;
    }

    public param getPopularSearchResult()
    {
        return asyncPopularSearchResult;
    }

    public SearchResult getResult()
    {
        return result;
    }

    protected void onPostExecute(SearchResult searchresult)
    {
        super.onPostExecute(searchresult);
        SearchDataManager.access$700(SearchDataManager.this, this, searchresult);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((SearchResult)obj);
    }

    public void setPopularSearchResult(onPostExecute onpostexecute)
    {
        asyncPopularSearchResult = onpostexecute;
    }


    public arams(arams arams)
    {
        this$0 = SearchDataManager.this;
        super();
        result = null;
        param = null;
        asyncPopularSearchResult = null;
        param = arams;
    }
}
