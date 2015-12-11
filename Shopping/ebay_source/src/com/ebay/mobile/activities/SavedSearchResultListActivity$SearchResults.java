// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.res.Resources;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.shared.ui.SearchRefinementSummary;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

private static final class savedSearch
{

    public yncTask asyncTask;
    public boolean isLoaded;
    private ArrayList relatedSearches;
    public com.ebay.common.net.api.search.ask result;
    public SavedSearch savedSearch;
    public SearchParameters searchParameters;
    private CharSequence searchSummary;

    public final yncTask getCompletedTask(com.ebay.common.util.sults sults)
    {
        yncTask ynctask = asyncTask;
        if (ynctask != null)
        {
            asyncTask = null;
            ynctask.removeObserver(sults);
        }
        return ynctask;
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

    public final void query(EbayContext ebaycontext, com.ebay.common.util.sults sults, Authentication authentication)
    {
        ebaycontext = new yncTask(ebaycontext, savedSearch, authentication);
        asyncTask = ebaycontext;
        ebaycontext.addObserver(sults);
        ebaycontext.execute(new Void[0]);
    }

    public final void retry(EbayContext ebaycontext, com.ebay.common.util.sults sults, Authentication authentication)
    {
        ebaycontext = new yncTask(ebaycontext, result, authentication);
        asyncTask = ebaycontext;
        ebaycontext.addObserver(sults);
        ebaycontext.execute(new Void[0]);
    }



/*
    static ArrayList access$302(yncTask ynctask, ArrayList arraylist)
    {
        ynctask.relatedSearches = arraylist;
        return arraylist;
    }

*/

    public relatedSearches(SavedSearch savedsearch)
    {
        result = null;
        asyncTask = null;
        isLoaded = false;
        searchSummary = null;
        relatedSearches = null;
        searchParameters = null;
        savedSearch = savedsearch;
    }

    public savedSearch(SearchParameters searchparameters)
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
