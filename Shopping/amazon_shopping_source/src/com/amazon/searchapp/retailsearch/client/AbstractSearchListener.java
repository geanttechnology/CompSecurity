// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.model.Breadcrumb;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.DisplaySettings;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.Pagination;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.SearchResources;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.SearchResultDataItem;
import com.amazon.searchapp.retailsearch.model.Sort;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchListener

public abstract class AbstractSearchListener
    implements SearchListener
{

    public AbstractSearchListener()
    {
    }

    public void breadcrumb(Breadcrumb breadcrumb1)
    {
    }

    public void categoryCorrected(CategoryCorrected categorycorrected)
    {
    }

    public void dataItem(SearchResultDataItem searchresultdataitem)
    {
    }

    public void didYouMean(DidYouMean didyoumean)
    {
    }

    public void displaySettings(DisplaySettings displaysettings)
    {
    }

    public void endParse(SearchResult searchresult)
    {
    }

    public void endRequest()
    {
    }

    public void error(Exception exception)
    {
    }

    public void fkmr(FKMR fkmr1)
    {
    }

    public void noResultsSet(NoResultsSet noresultsset)
    {
    }

    public void pagination(Pagination pagination1)
    {
    }

    public void preloadImages(PreloadImages preloadimages)
    {
    }

    public void product(Product product1)
    {
    }

    public void refinements(Refinements refinements1)
    {
    }

    public void relatedSearches(RelatedSearches relatedsearches)
    {
    }

    public void resources(SearchResources searchresources)
    {
    }

    public void result(SearchResult searchresult)
    {
    }

    public volatile void result(Object obj)
    {
        result((SearchResult)obj);
    }

    public void resultMetadata(ResultsMetadata resultsmetadata)
    {
    }

    public void sort(Sort sort1)
    {
    }

    public void spellCorrected(SpellCorrected spellcorrected)
    {
    }

    public void startParse(SearchResult searchresult)
    {
    }

    public void startRequest()
    {
    }

    public void trackingInfo(TrackingInfo trackinginfo)
    {
    }

    public void wordSplitter(SpellCorrected spellcorrected)
    {
    }
}
