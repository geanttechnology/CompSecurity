// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchResult, SearchParameters

public final class SearchResultState
{
    public static class SearchAds
    {

        public final List adsList;
        public final boolean isProductListingAds;

        public static SearchAds create(List list)
        {
            if (list != null && list.size() > 0)
            {
                return new SearchAds(list);
            } else
            {
                return null;
            }
        }

        private SearchAds(List list)
        {
            adsList = list;
            isProductListingAds = ((com.ebay.common.rtm.RtmContent.Ad)adsList.get(0)).isPla;
        }
    }


    private final List expansions = new ArrayList();
    private boolean hasBeenDelivered;
    private boolean isFetchingAds;
    private ArrayList popularSearchKeywords;
    private com.ebay.common.content.dm.SearchDataManager.SearchExpansionDescriptor primaryExpansion;
    private final SearchResult result;
    private SearchAds searchAds;
    private final SearchParameters searchParameters;

    public SearchResultState(SearchResult searchresult, SearchParameters searchparameters)
    {
        hasBeenDelivered = false;
        searchAds = null;
        isFetchingAds = false;
        primaryExpansion = null;
        result = searchresult;
        searchParameters = searchparameters;
        popularSearchKeywords = null;
    }

    public void addExpansion(com.ebay.common.content.dm.SearchDataManager.SearchExpansionDescriptor searchexpansiondescriptor)
    {
        if (searchexpansiondescriptor.isDisplayedOnTop() && primaryExpansion == null)
        {
            primaryExpansion = searchexpansiondescriptor;
            return;
        } else
        {
            expansions.add(searchexpansiondescriptor);
            return;
        }
    }

    public List getExpansions()
    {
        return expansions;
    }

    public SearchParameters getOriginalSearchParameters()
    {
        return searchParameters;
    }

    public ArrayList getPopularSearchKeywords()
    {
        return popularSearchKeywords;
    }

    public com.ebay.common.content.dm.SearchDataManager.SearchExpansionDescriptor getPrimaryExpansion()
    {
        return primaryExpansion;
    }

    public SearchResult getResult()
    {
        return result;
    }

    public SearchAds getSearchAds()
    {
        return searchAds;
    }

    public boolean isFetchingAds()
    {
        return isFetchingAds;
    }

    public boolean isInitialDelivery()
    {
        return !hasBeenDelivered;
    }

    public void setDelivered()
    {
        hasBeenDelivered = true;
    }

    public void setFetchingAds(boolean flag)
    {
        isFetchingAds = flag;
    }

    public void setPopularSearchResult(ArrayList arraylist)
    {
        popularSearchKeywords = arraylist;
    }

    public void setSearchAds(List list)
    {
        searchAds = SearchAds.create(list);
    }
}
