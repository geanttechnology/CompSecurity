// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.SavedSearch;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi, SearchParameters

private static final class savedSearch extends ase
{

    private final SavedSearch savedSearch;

    protected int getMaxCountPerPage()
    {
        return savedSearch.searchParameters.maxCountPerPage;
    }

    protected tBase getRequest(int i)
    {
        return new equest(savedSearch, i);
    }

    protected void trackResponse(esponse esponse, int i)
    {
    }

    public esponse(EbayContext ebaycontext, SavedSearch savedsearch)
    {
        super(ebaycontext);
        savedSearch = savedsearch;
    }
}
