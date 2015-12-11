.class public interface abstract Lcom/amazon/searchapp/retailsearch/client/SearchListener;
.super Ljava/lang/Object;
.source "SearchListener.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
        ">;"
    }
.end annotation


# virtual methods
.method public abstract breadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V
.end method

.method public abstract categoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
.end method

.method public abstract dataItem(Lcom/amazon/searchapp/retailsearch/model/SearchResultDataItem;)V
.end method

.method public abstract didYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
.end method

.method public abstract displaySettings(Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V
.end method

.method public abstract endParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
.end method

.method public abstract fkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
.end method

.method public abstract noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
.end method

.method public abstract pagination(Lcom/amazon/searchapp/retailsearch/model/Pagination;)V
.end method

.method public abstract preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
.end method

.method public abstract product(Lcom/amazon/searchapp/retailsearch/model/Product;)V
.end method

.method public abstract refinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
.end method

.method public abstract relatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
.end method

.method public abstract resources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V
.end method

.method public abstract resultMetadata(Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V
.end method

.method public abstract sort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
.end method

.method public abstract spellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
.end method

.method public abstract startParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
.end method

.method public abstract trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V
.end method

.method public abstract wordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
.end method
