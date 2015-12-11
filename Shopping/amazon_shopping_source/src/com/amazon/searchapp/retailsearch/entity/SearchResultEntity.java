// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Breadcrumb;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.DisplaySettings;
import com.amazon.searchapp.retailsearch.model.FeaturedContent;
import com.amazon.searchapp.retailsearch.model.MShopResult;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.Pagination;
import com.amazon.searchapp.retailsearch.model.PastPurchases;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.ProductSectionSet;
import com.amazon.searchapp.retailsearch.model.QuartzBacklink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import com.amazon.searchapp.retailsearch.model.ResponseMetadata;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.SearchResources;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.Sort;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SearchResultEntity extends RetailSearchEntity
    implements SearchResult
{

    private Breadcrumb breadcrumb;
    private CategoryCorrected correctedCategoryResults;
    private DidYouMean didYouMean;
    private DisplaySettings displaySettings;
    private List dynamicContent;
    private FeaturedContent featuredContent;
    private List fkmr;
    private MShopResult mShopResult;
    private NoResultsSet noResults;
    private Pagination pagination;
    private PastPurchases pastPurchases;
    private PreloadImages preloadImages;
    private QuartzBacklink quartzBacklink;
    private Refinements refinements;
    private RelatedSearches relatedSearches;
    private SearchResources resources;
    private ResponseMetadata responseMetadata;
    private ProductSectionSet results;
    private ResultsMetadata resultsMetadata;
    private ProductSection similarities;
    private Sort sort;
    private SpellCorrected spellCorrectedResults;
    private TrackingInfo trackingInfo;
    private SpellCorrected wordSplitterCorrectedResults;

    public SearchResultEntity()
    {
    }

    public Breadcrumb getBreadcrumb()
    {
        return breadcrumb;
    }

    public CategoryCorrected getCorrectedCategoryResults()
    {
        return correctedCategoryResults;
    }

    public DidYouMean getDidYouMean()
    {
        return didYouMean;
    }

    public DisplaySettings getDisplaySettings()
    {
        return displaySettings;
    }

    public List getDynamicContent()
    {
        return dynamicContent;
    }

    public FeaturedContent getFeaturedContent()
    {
        return featuredContent;
    }

    public List getFkmr()
    {
        return fkmr;
    }

    public MShopResult getMShopResult()
    {
        return mShopResult;
    }

    public NoResultsSet getNoResults()
    {
        return noResults;
    }

    public Pagination getPagination()
    {
        return pagination;
    }

    public PastPurchases getPastPurchases()
    {
        return pastPurchases;
    }

    public PreloadImages getPreloadImages()
    {
        return preloadImages;
    }

    public QuartzBacklink getQuartzBacklink()
    {
        return quartzBacklink;
    }

    public Refinements getRefinements()
    {
        return refinements;
    }

    public RelatedSearches getRelatedSearches()
    {
        return relatedSearches;
    }

    public SearchResources getResources()
    {
        return resources;
    }

    public ResponseMetadata getResponseMetadata()
    {
        return responseMetadata;
    }

    public ProductSectionSet getResults()
    {
        return results;
    }

    public ResultsMetadata getResultsMetadata()
    {
        return resultsMetadata;
    }

    public ProductSection getSimilarities()
    {
        return similarities;
    }

    public Sort getSort()
    {
        return sort;
    }

    public SpellCorrected getSpellCorrectedResults()
    {
        return spellCorrectedResults;
    }

    public TrackingInfo getTrackingInfo()
    {
        return trackingInfo;
    }

    public SpellCorrected getWordSplitterCorrectedResults()
    {
        return wordSplitterCorrectedResults;
    }

    public void setBreadcrumb(Breadcrumb breadcrumb1)
    {
        breadcrumb = breadcrumb1;
    }

    public void setCorrectedCategoryResults(CategoryCorrected categorycorrected)
    {
        correctedCategoryResults = categorycorrected;
    }

    public void setDidYouMean(DidYouMean didyoumean)
    {
        didYouMean = didyoumean;
    }

    public void setDisplaySettings(DisplaySettings displaysettings)
    {
        displaySettings = displaysettings;
    }

    public void setDynamicContent(List list)
    {
        dynamicContent = list;
    }

    public void setFeaturedContent(FeaturedContent featuredcontent)
    {
        featuredContent = featuredcontent;
    }

    public void setFkmr(List list)
    {
        fkmr = list;
    }

    public void setMShopResult(MShopResult mshopresult)
    {
        mShopResult = mshopresult;
    }

    public void setNoResults(NoResultsSet noresultsset)
    {
        noResults = noresultsset;
    }

    public void setPagination(Pagination pagination1)
    {
        pagination = pagination1;
    }

    public void setPastPurchases(PastPurchases pastpurchases)
    {
        pastPurchases = pastpurchases;
    }

    public void setPreloadImages(PreloadImages preloadimages)
    {
        preloadImages = preloadimages;
    }

    public void setQuartzBacklink(QuartzBacklink quartzbacklink)
    {
        quartzBacklink = quartzbacklink;
    }

    public void setRefinements(Refinements refinements1)
    {
        refinements = refinements1;
    }

    public void setRelatedSearches(RelatedSearches relatedsearches)
    {
        relatedSearches = relatedsearches;
    }

    public void setResources(SearchResources searchresources)
    {
        resources = searchresources;
    }

    public void setResponseMetadata(ResponseMetadata responsemetadata)
    {
        responseMetadata = responsemetadata;
    }

    public void setResults(ProductSectionSet productsectionset)
    {
        results = productsectionset;
    }

    public void setResultsMetadata(ResultsMetadata resultsmetadata)
    {
        resultsMetadata = resultsmetadata;
    }

    public void setSimilarities(ProductSection productsection)
    {
        similarities = productsection;
    }

    public void setSort(Sort sort1)
    {
        sort = sort1;
    }

    public void setSpellCorrectedResults(SpellCorrected spellcorrected)
    {
        spellCorrectedResults = spellcorrected;
    }

    public void setTrackingInfo(TrackingInfo trackinginfo)
    {
        trackingInfo = trackinginfo;
    }

    public void setWordSplitterCorrectedResults(SpellCorrected spellcorrected)
    {
        wordSplitterCorrectedResults = spellcorrected;
    }
}
