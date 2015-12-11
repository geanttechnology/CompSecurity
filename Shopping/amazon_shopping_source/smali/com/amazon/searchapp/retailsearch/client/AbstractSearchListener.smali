.class public abstract Lcom/amazon/searchapp/retailsearch/client/AbstractSearchListener;
.super Ljava/lang/Object;
.source "AbstractSearchListener.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/SearchListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public breadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V
    .locals 0
    .param p1, "breadcrumb"    # Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .prologue
    .line 87
    return-void
.end method

.method public categoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
    .locals 0
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 71
    return-void
.end method

.method public dataItem(Lcom/amazon/searchapp/retailsearch/model/SearchResultDataItem;)V
    .locals 0
    .param p1, "dataItem"    # Lcom/amazon/searchapp/retailsearch/model/SearchResultDataItem;

    .prologue
    .line 115
    return-void
.end method

.method public didYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 0
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 91
    return-void
.end method

.method public displaySettings(Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V
    .locals 0
    .param p1, "displaySettings"    # Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    .prologue
    .line 107
    return-void
.end method

.method public endParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 0
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 123
    return-void
.end method

.method public endRequest()V
    .locals 0

    .prologue
    .line 43
    return-void
.end method

.method public error(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 39
    return-void
.end method

.method public fkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
    .locals 0
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    .line 59
    return-void
.end method

.method public noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 0
    .param p1, "noResultsSet"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 103
    return-void
.end method

.method public pagination(Lcom/amazon/searchapp/retailsearch/model/Pagination;)V
    .locals 0
    .param p1, "pagination"    # Lcom/amazon/searchapp/retailsearch/model/Pagination;

    .prologue
    .line 79
    return-void
.end method

.method public preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
    .locals 0
    .param p1, "preloadImages"    # Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    .prologue
    .line 51
    return-void
.end method

.method public product(Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 0
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 55
    return-void
.end method

.method public refinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 0
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 75
    return-void
.end method

.method public relatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
    .locals 0
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    .line 95
    return-void
.end method

.method public resources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V
    .locals 0
    .param p1, "resources"    # Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    .prologue
    .line 111
    return-void
.end method

.method public result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 0
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 35
    return-void
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/AbstractSearchListener;->result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V

    return-void
.end method

.method public resultMetadata(Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V
    .locals 0
    .param p1, "resultMetadata"    # Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    .prologue
    .line 99
    return-void
.end method

.method public sort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
    .locals 0
    .param p1, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;

    .prologue
    .line 83
    return-void
.end method

.method public spellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 0
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 63
    return-void
.end method

.method public startParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 0
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 119
    return-void
.end method

.method public startRequest()V
    .locals 0

    .prologue
    .line 31
    return-void
.end method

.method public trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V
    .locals 0
    .param p1, "trackingInfo"    # Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    .prologue
    .line 47
    return-void
.end method

.method public wordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 0
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 67
    return-void
.end method
