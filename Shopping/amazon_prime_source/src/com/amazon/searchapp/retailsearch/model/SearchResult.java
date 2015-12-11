// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            AirstreamResult, Breadcrumb, CategoryCorrected, DidYouMean, 
//            DisplaySettings, FeaturedContent, MShopResult, NoResultsSet, 
//            Pagination, PreloadImages, QuartzBacklink, Refinements, 
//            RelatedSearches, SearchResources, ResponseMetadata, ProductSectionSet, 
//            ResultsMetadata, ProductSection, Sort, SpellCorrected, 
//            TrackingInfo

public interface SearchResult
{

    public abstract AirstreamResult getAirstream();

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

    public abstract List getWidgets();

    public abstract SpellCorrected getWordSplitterCorrectedResults();

    public abstract void setAirstream(AirstreamResult airstreamresult);

    public abstract void setBreadcrumb(Breadcrumb breadcrumb);

    public abstract void setCorrectedCategoryResults(CategoryCorrected categorycorrected);

    public abstract void setDidYouMean(DidYouMean didyoumean);

    public abstract void setDisplaySettings(DisplaySettings displaysettings);

    public abstract void setDynamicContent(List list);

    public abstract void setFeaturedContent(FeaturedContent featuredcontent);

    public abstract void setFkmr(List list);

    public abstract void setMShopResult(MShopResult mshopresult);

    public abstract void setNoResults(NoResultsSet noresultsset);

    public abstract void setPagination(Pagination pagination);

    public abstract void setPreloadImages(PreloadImages preloadimages);

    public abstract void setQuartzBacklink(QuartzBacklink quartzbacklink);

    public abstract void setRefinements(Refinements refinements);

    public abstract void setRelatedSearches(RelatedSearches relatedsearches);

    public abstract void setResources(SearchResources searchresources);

    public abstract void setResponseMetadata(ResponseMetadata responsemetadata);

    public abstract void setResults(ProductSectionSet productsectionset);

    public abstract void setResultsMetadata(ResultsMetadata resultsmetadata);

    public abstract void setSimilarities(ProductSection productsection);

    public abstract void setSort(Sort sort);

    public abstract void setSpellCorrectedResults(SpellCorrected spellcorrected);

    public abstract void setTrackingInfo(TrackingInfo trackinginfo);

    public abstract void setWidgets(List list);

    public abstract void setWordSplitterCorrectedResults(SpellCorrected spellcorrected);
}
