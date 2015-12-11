// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.net.api.search.FindPopularSearchesRequest;
import com.ebay.common.net.api.search.FindPopularSearchesResponse;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

private static class tag extends EbaySimpleNetLoader
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

    public (EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, String s, List list, int i)
    {
        super(ebaycontext);
        popularKeywords = null;
        api = ebayshoppingapi;
        keywords = s;
        categories = list;
        tag = i;
    }
}
