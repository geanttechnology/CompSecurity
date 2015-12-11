// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Breadcrumb, CategoryCorrected, DidYouMean, DisplaySettings, 
//            FeaturedContent, MShopResult, NoResultsSet, Pagination, 
//            PastPurchases, PreloadImages, QuartzBacklink, Refinements, 
//            RelatedSearches, SearchResources, ResponseMetadata, ProductSectionSet, 
//            ResultsMetadata, ProductSection, Sort, SpellCorrected, 
//            TrackingInfo

public interface SearchResult
{

    public abstract Breadcrumb getBreadcrumb();

    public abstract CategoryCorrected getCorrectedCategoryResults();

    public abstract DidYouMean getDidYouMean();

    public abstract DisplaySettings getDisplaySettings();

    public abstract List getDynamicContent();

    public abstract FeaturedContent getFeaturedContent();

    public abstract List getFkmr();

    public abstract MShopResult getMShopResult();

    public abstract NoResultsSet getNoResults();

    public abstract Pagination getPagination();

    public abstract PastPurchases getPastPurchases();

    public abstract PreloadImages getPreloadImages();

    public abstract QuartzBacklink getQuartzBacklink();

    public abstract Refinements getRefinements();

    public abstract RelatedSearches getRelatedSearches();

    public abstract SearchResources getResources();

    public abstract ResponseMetadata getResponseMetadata();

    public abstract ProductSectionSet getResults();

    public abstract ResultsMetadata getResultsMetadata();

    public abstract ProductSection getSimilarities();

    public abstract Sort getSort();

    public abstract SpellCorrected getSpellCorrectedResults();

    public abstract TrackingInfo getTrackingInfo();

    public abstract SpellCorrected getWordSplitterCorrectedResults();
}
