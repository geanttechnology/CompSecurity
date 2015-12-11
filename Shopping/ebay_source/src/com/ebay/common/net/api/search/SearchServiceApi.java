// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import android.util.Pair;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.wiremodel.Rewrite;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchResult, SearchParameters, SearchConfiguration, SearchServiceQuery, 
//            KnownSearchExpansion, SearchExpansion, ISearchEventTracker

public class SearchServiceApi
{

    public SearchServiceApi()
    {
    }

    private static SearchResult bopisMetroAutoCorrection(EbayContext ebaycontext, SearchParameters searchparameters, ISearchEventTracker isearcheventtracker, SearchConfiguration searchconfiguration)
        throws InterruptedException
    {
        ebaycontext = doBopisFallback(ebaycontext, searchparameters, isearcheventtracker, searchconfiguration);
        if (ebaycontext != null)
        {
            ebaycontext.setBopisMetroCorrectedSearch();
        }
        return ebaycontext;
    }

    private static SearchResult doBopisFallback(EbayContext ebaycontext, SearchParameters searchparameters, ISearchEventTracker isearcheventtracker, SearchConfiguration searchconfiguration)
        throws InterruptedException
    {
        searchparameters.inStorePickupOnly = false;
        searchparameters = executeSearch(ebaycontext, searchparameters, isearcheventtracker, searchconfiguration);
        ebaycontext = searchparameters;
        if (((SearchResult) (searchparameters)).resultStatus.hasError())
        {
            ebaycontext = null;
        }
        return ebaycontext;
    }

    private static SearchResult doEbayNowFallback(EbayContext ebaycontext, SearchParameters searchparameters, ISearchEventTracker isearcheventtracker, SearchConfiguration searchconfiguration)
        throws InterruptedException
    {
        searchparameters = searchparameters.clone();
        searchparameters.ebnOnly = false;
        searchparameters = executeSearch(ebaycontext, searchparameters, isearcheventtracker, searchconfiguration);
        ebaycontext = searchparameters;
        if (((SearchResult) (searchparameters)).resultStatus.hasError())
        {
            ebaycontext = null;
        }
        return ebaycontext;
    }

    public static SearchResult doFallback(EbayContext ebaycontext, SearchParameters searchparameters, ISearchEventTracker isearcheventtracker, List list, SearchConfiguration searchconfiguration)
        throws InterruptedException
    {
        SearchResult searchresult = null;
        if (isBopisMetroError(searchparameters, list))
        {
            searchresult = bopisMetroAutoCorrection(ebaycontext, searchparameters, isearcheventtracker, searchconfiguration);
        } else
        if (isEbayNowMetroError(searchparameters, list))
        {
            return eBayNowMetroAutoCorrection(ebaycontext, searchparameters, isearcheventtracker, searchconfiguration);
        }
        return searchresult;
    }

    private static SearchResult eBayNowMetroAutoCorrection(EbayContext ebaycontext, SearchParameters searchparameters, ISearchEventTracker isearcheventtracker, SearchConfiguration searchconfiguration)
        throws InterruptedException
    {
        ebaycontext = doEbayNowFallback(ebaycontext, searchparameters, isearcheventtracker, searchconfiguration);
        if (ebaycontext != null)
        {
            ebaycontext.setEbayNowMetroCorrectedSearch();
        }
        return ebaycontext;
    }

    public static SearchResult executeSearch(EbayContext ebaycontext, SearchParameters searchparameters, ISearchEventTracker isearcheventtracker, SearchConfiguration searchconfiguration)
        throws InterruptedException
    {
        EbayCategoryHistogram ebaycategoryhistogram;
        searchparameters.useSoaLocaleList = searchconfiguration.isGbhEnabled;
        SearchServiceQuery searchservicequery;
        com.ebay.common.model.search.SellerOffer selleroffer;
        EbayAspectHistogram ebayaspecthistogram;
        List list;
        int i;
        int j;
        int k;
        boolean flag;
        if (searchconfiguration.isGbhEnabled && !searchparameters.country.isSite())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            searchparameters.countryId = searchparameters.country.getCountryCode();
        }
        searchservicequery = new SearchServiceQuery(ebaycontext, searchparameters, isearcheventtracker, searchconfiguration);
        searchservicequery.startQuery();
        selleroffer = searchservicequery.getSellerOffer();
        ebayaspecthistogram = searchservicequery.getAspects();
        flag = searchservicequery.hasLocalItems();
        j = searchservicequery.getTotalCount();
        k = searchservicequery.getTotalCountWithDupes();
        list = searchservicequery.getDataList();
        ebaycategoryhistogram = searchservicequery.getCategories();
        ebaycontext = searchservicequery.getExpansions();
        isearcheventtracker = ebaycontext;
        if (ebaycontext == null)
        {
            isearcheventtracker = getExpansionsFromRewrites(searchservicequery.getRewrites());
        }
        i = j;
        ebaycontext = isearcheventtracker;
        if (isearcheventtracker != null)
        {
            i = j;
            ebaycontext = isearcheventtracker;
            if (!isearcheventtracker.isEmpty())
            {
                if (isUnknownExpansionSearchParameters(isearcheventtracker, searchparameters))
                {
                    i = Math.min(list.size(), searchparameters.maxCountPerPage);
                    ebaycontext = null;
                } else
                {
                    ebaycontext = processExpansions(isearcheventtracker, searchparameters);
                    SearchParameters searchparameters1 = (SearchParameters)((Pair) (ebaycontext)).first;
                    isearcheventtracker = (ArrayList)((Pair) (ebaycontext)).second;
                    i = j;
                    ebaycontext = isearcheventtracker;
                    if (searchparameters1 != null)
                    {
                        searchservicequery.params = searchparameters1;
                        i = j;
                        ebaycontext = isearcheventtracker;
                    }
                }
            }
        }
        isearcheventtracker = searchservicequery.getRewrites();
        if (isearcheventtracker != null && searchconfiguration.isUseUvccEnabled)
        {
            isearcheventtracker = KnownSearchExpansion.getQueryRewriteSearchParameters(searchservicequery.params, isearcheventtracker);
            if (isearcheventtracker != null)
            {
                searchservicequery.params = isearcheventtracker;
            }
        }
        isearcheventtracker = ebaycategoryhistogram;
        if (searchparameters.category == null) goto _L2; else goto _L1
_L1:
        if (ebaycategoryhistogram != null || TextUtils.isEmpty(searchparameters.category.name)) goto _L4; else goto _L3
_L3:
        searchconfiguration = new com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory();
        searchconfiguration.id = searchparameters.category.id;
        searchconfiguration.name = searchparameters.category.name;
        searchconfiguration.count = i;
        isearcheventtracker = new EbayCategoryHistogram();
        ((EbayCategoryHistogram) (isearcheventtracker)).categories.add(searchconfiguration);
_L2:
        if (searchservicequery.params != null && !TextUtils.isEmpty(searchparameters.keywords) && !searchparameters.keywords.equals(searchservicequery.params.keywords) && DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.useQuotationMarksForRecourseKeywords))
        {
            searchparameters.keywords = (new StringBuilder()).append("\"").append(searchparameters.keywords.replace("\"", "")).append("\"").toString();
        }
        return new SearchResult(i, k, list, searchparameters, flag, selleroffer, isearcheventtracker, ebayaspecthistogram, null, ebaycontext, searchservicequery, searchservicequery.params);
_L4:
        isearcheventtracker = ebaycategoryhistogram;
        if (ebaycategoryhistogram == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        isearcheventtracker = ebaycategoryhistogram;
        if (searchparameters.category.id <= 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        isearcheventtracker = ebaycategoryhistogram;
        if (!TextUtils.isEmpty(searchparameters.category.name))
        {
            continue; /* Loop/switch isn't completed */
        }
        isearcheventtracker = ebaycategoryhistogram;
        if (ebaycategoryhistogram.categories == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        searchconfiguration = ebaycategoryhistogram.categories.iterator();
        do
        {
            isearcheventtracker = ebaycategoryhistogram;
            if (!searchconfiguration.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            isearcheventtracker = (com.ebay.common.model.search.EbayCategoryHistogram.Category)searchconfiguration.next();
        } while (((com.ebay.common.model.search.EbayCategoryHistogram.Category) (isearcheventtracker)).id != searchparameters.category.id);
        searchparameters.category.name = ((com.ebay.common.model.search.EbayCategoryHistogram.Category) (isearcheventtracker)).name;
        isearcheventtracker = ebaycategoryhistogram;
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static ArrayList getExpansionsFromRewrites(List list)
    {
        Object obj;
label0:
        {
            obj = null;
            Object obj1 = null;
            if (list == null)
            {
                break label0;
            }
            Iterator iterator = list.iterator();
            list = obj1;
            do
            {
                Rewrite rewrite;
                do
                {
                    obj = list;
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    rewrite = (Rewrite)iterator.next();
                } while (rewrite.rewriteResults == null);
                Iterator iterator1 = rewrite.rewriteResults.iterator();
                obj = list;
                do
                {
                    list = ((List) (obj));
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult rewriteresult = (com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult)iterator1.next();
                    if (rewriteresult.expansionResult != null)
                    {
                        list = ((List) (obj));
                        if (obj == null)
                        {
                            list = new ArrayList();
                        }
                        obj = new SearchExpansion();
                        obj.expansionType = rewrite.type;
                        obj.expansionResult = rewriteresult.expansionResult;
                        list.add(obj);
                        obj = list;
                    }
                } while (true);
            } while (true);
        }
        return ((ArrayList) (obj));
    }

    private static boolean isBopisMetroError(SearchParameters searchparameters, List list)
    {
        if (!searchparameters.inStorePickupOnly)
        {
            return false;
        } else
        {
            return EbayErrorUtil.containsError(list, "243051");
        }
    }

    private static boolean isEbayNowMetroError(SearchParameters searchparameters, List list)
    {
        if (!searchparameters.ebnOnly)
        {
            return false;
        } else
        {
            return EbayErrorUtil.containsError(list, "243058");
        }
    }

    public static boolean isSaasPostalCodeWarning(SearchParameters searchparameters, List list)
    {
        for (searchparameters = list.iterator(); searchparameters.hasNext();)
        {
            list = (com.ebay.nautilus.kernel.content.ResultStatus.Message)searchparameters.next();
            if (list.getSeverity() == com.ebay.nautilus.kernel.content.ResultStatus.Severity.Warning && list.getId() == 0x3b55d)
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isUnknownExpansionSearchParameters(ArrayList arraylist, SearchParameters searchparameters)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            SearchExpansion searchexpansion = (SearchExpansion)arraylist.next();
            SearchExpansion.ExpansionResult expansionresult = searchexpansion.expansionResult;
            if (expansionresult != null && expansionresult.isAutoRun && expansionresult.promotedToPrimary && KnownSearchExpansion.getCorrectedSearchParameters(searchparameters, searchexpansion) == null)
            {
                return true;
            }
        }

        return false;
    }

    private static Pair processExpansions(List list, SearchParameters searchparameters)
    {
        Object obj = null;
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        list = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SearchExpansion searchexpansion = (SearchExpansion)iterator.next();
            SearchExpansion.ExpansionResult expansionresult = searchexpansion.expansionResult;
            if (expansionresult != null && (expansionresult.promotedToPrimary || expansionresult.matchCount != 0L && expansionresult.searchRecords.size() != 0))
            {
                arraylist.add(searchexpansion);
                if (expansionresult.promotedToPrimary)
                {
                    list = KnownSearchExpansion.getCorrectedSearchParameters(searchparameters, searchexpansion);
                }
            }
        } while (true);
        searchparameters = arraylist;
        if (arraylist.isEmpty())
        {
            searchparameters = null;
        }
        return new Pair(list, searchparameters);
    }

    public static boolean useSearchService(SearchParameters searchparameters, SearchConfiguration searchconfiguration)
    {
        while (searchconfiguration != null && !searchconfiguration.isSearchServiceEnabled || searchparameters.aspectHistogram != null && (searchparameters.aspectHistogram.scopeType == null || searchparameters.aspectHistogram.scopeValue == null) || searchparameters.productId != null) 
        {
            return false;
        }
        return true;
    }
}
