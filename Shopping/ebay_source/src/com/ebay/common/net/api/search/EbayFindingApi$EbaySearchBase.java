// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchPagedListManager, EbayFindingApi, SearchParameters

private static abstract class context extends SearchPagedListManager
{

    private EbayAspectHistogram aspects;
    private EbayCategoryHistogram categories;
    protected final EbayContext context;
    private String savedSearchQuery;

    private nse sendRequestAndTrackResponse(stBase stbase, int i)
        throws IOException, InterruptedException
    {
        stbase = (nse)context.getConnector().sendRequest(stbase);
        if (!stbase.getResultStatus().hasError())
        {
            trackResponse(stbase, i);
        }
        setLastResultStatus(stbase.getResultStatus());
        return stbase;
    }

    public void fill(ArrayList arraylist, int i)
        throws IOException, InterruptedException
    {
        nse nse = sendRequestAndTrackResponse(getRequest(i), i);
        if (!nse.getResultStatus().hasError())
        {
            rerankTrackableRows(arraylist);
            nse.fill(arraylist);
            totalNumberOfItems = nse.getTotalCount();
        }
    }

    public EbayAspectHistogram getAspects()
    {
        return aspects;
    }

    public EbayCategoryHistogram getCategories()
    {
        return categories;
    }

    protected abstract stBase getRequest(int i);

    public final String getSavedSearchQuery()
    {
        return savedSearchQuery;
    }

    public final int getTotalCount()
    {
        return totalNumberOfItems;
    }

    public void query()
        throws IOException, InterruptedException
    {
        nse nse = sendRequestAndTrackResponse(getRequest(1), 1);
        totalNumberOfItems = nse.getTotalCount();
        firstPage = nse.getPage();
        categories = nse.getCategories();
        aspects = nse.getAspects();
        savedSearchQuery = nse.getSavedSearchQuery();
        highestPageIndex = 50;
        rerankTrackableRows(firstPage);
    }

    protected abstract void trackResponse(nse nse, int i);

    protected nse(EbayContext ebaycontext, int i)
    {
        super(i, null);
        categories = null;
        aspects = null;
        savedSearchQuery = null;
        context = ebaycontext;
    }

    protected context(EbayContext ebaycontext, int i, SearchParameters searchparameters)
    {
        super(i, searchparameters);
        categories = null;
        aspects = null;
        savedSearchQuery = null;
        context = ebaycontext;
    }
}
