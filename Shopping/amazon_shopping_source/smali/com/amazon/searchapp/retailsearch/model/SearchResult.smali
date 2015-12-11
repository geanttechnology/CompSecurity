.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/SearchResult;
.super Ljava/lang/Object;
.source "SearchResult.java"


# virtual methods
.method public abstract getBreadcrumb()Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;
.end method

.method public abstract getCorrectedCategoryResults()Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;
.end method

.method public abstract getDidYouMean()Lcom/amazon/searchapp/retailsearch/model/DidYouMean;
.end method

.method public abstract getDisplaySettings()Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;
.end method

.method public abstract getDynamicContent()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/DynamicContent;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getFeaturedContent()Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;
.end method

.method public abstract getFkmr()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/FKMR;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getMShopResult()Lcom/amazon/searchapp/retailsearch/model/MShopResult;
.end method

.method public abstract getNoResults()Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;
.end method

.method public abstract getPagination()Lcom/amazon/searchapp/retailsearch/model/Pagination;
.end method

.method public abstract getPastPurchases()Lcom/amazon/searchapp/retailsearch/model/PastPurchases;
.end method

.method public abstract getPreloadImages()Lcom/amazon/searchapp/retailsearch/model/PreloadImages;
.end method

.method public abstract getQuartzBacklink()Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;
.end method

.method public abstract getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;
.end method

.method public abstract getRelatedSearches()Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;
.end method

.method public abstract getResources()Lcom/amazon/searchapp/retailsearch/model/SearchResources;
.end method

.method public abstract getResponseMetadata()Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;
.end method

.method public abstract getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;
.end method

.method public abstract getResultsMetadata()Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;
.end method

.method public abstract getSimilarities()Lcom/amazon/searchapp/retailsearch/model/ProductSection;
.end method

.method public abstract getSort()Lcom/amazon/searchapp/retailsearch/model/Sort;
.end method

.method public abstract getSpellCorrectedResults()Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
.end method

.method public abstract getTrackingInfo()Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;
.end method

.method public abstract getWordSplitterCorrectedResults()Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
.end method
