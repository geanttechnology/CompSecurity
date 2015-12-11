// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
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

public interface SearchListener
    extends ServiceCallListener
{

    public abstract void breadcrumb(Breadcrumb breadcrumb1);

    public abstract void categoryCorrected(CategoryCorrected categorycorrected);

    public abstract void dataItem(SearchResultDataItem searchresultdataitem);

    public abstract void didYouMean(DidYouMean didyoumean);

    public abstract void displaySettings(DisplaySettings displaysettings);

    public abstract void endParse(SearchResult searchresult);

    public abstract void fkmr(FKMR fkmr1);

    public abstract void noResultsSet(NoResultsSet noresultsset);

    public abstract void pagination(Pagination pagination1);

    public abstract void preloadImages(PreloadImages preloadimages);

    public abstract void product(Product product1);

    public abstract void refinements(Refinements refinements1);

    public abstract void relatedSearches(RelatedSearches relatedsearches);

    public abstract void resources(SearchResources searchresources);

    public abstract void resultMetadata(ResultsMetadata resultsmetadata);

    public abstract void sort(Sort sort1);

    public abstract void spellCorrected(SpellCorrected spellcorrected);

    public abstract void startParse(SearchResult searchresult);

    public abstract void trackingInfo(TrackingInfo trackinginfo);

    public abstract void wordSplitter(SpellCorrected spellcorrected);
}
