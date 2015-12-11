.class public Lcom/amazon/retailsearch/data/search/AbstractResultStreamListener;
.super Ljava/lang/Object;
.source "AbstractResultStreamListener.java"

# interfaces
.implements Lcom/amazon/retailsearch/data/search/ResultStreamListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public breadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V
    .locals 0
    .param p1, "breadcrumb"    # Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .prologue
    .line 65
    return-void
.end method

.method public categoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
    .locals 0
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 49
    return-void
.end method

.method public clearError()V
    .locals 0

    .prologue
    .line 141
    return-void
.end method

.method public close()V
    .locals 0

    .prologue
    .line 145
    return-void
.end method

.method public dataItem(Lcom/amazon/searchapp/retailsearch/model/SearchResultDataItem;)V
    .locals 0
    .param p1, "dataItem"    # Lcom/amazon/searchapp/retailsearch/model/SearchResultDataItem;

    .prologue
    .line 93
    return-void
.end method

.method public didYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 0
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 69
    return-void
.end method

.method public displaySettings(Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V
    .locals 0
    .param p1, "displaySettings"    # Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    .prologue
    .line 85
    return-void
.end method

.method public endPage()V
    .locals 0

    .prologue
    .line 133
    return-void
.end method

.method public endParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 0
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 101
    return-void
.end method

.method public endRequest()V
    .locals 0

    .prologue
    .line 117
    return-void
.end method

.method public endResult()V
    .locals 0

    .prologue
    .line 125
    return-void
.end method

.method public error(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 113
    return-void
.end method

.method public fkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
    .locals 0
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    .line 37
    return-void
.end method

.method public noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 0
    .param p1, "noResultsSet"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 77
    return-void
.end method

.method public pagination(Lcom/amazon/searchapp/retailsearch/model/Pagination;)V
    .locals 0
    .param p1, "pagination"    # Lcom/amazon/searchapp/retailsearch/model/Pagination;

    .prologue
    .line 57
    return-void
.end method

.method public preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
    .locals 0
    .param p1, "preloadImages"    # Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    .prologue
    .line 29
    return-void
.end method

.method public product(Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 0
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 33
    return-void
.end method

.method public ready()V
    .locals 0

    .prologue
    .line 137
    return-void
.end method

.method public refinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 0
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 53
    return-void
.end method

.method public relatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
    .locals 0
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    .line 73
    return-void
.end method

.method public resources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V
    .locals 0
    .param p1, "resources"    # Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    .prologue
    .line 89
    return-void
.end method

.method public result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 0
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 109
    return-void
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 22
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/data/search/AbstractResultStreamListener;->result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V

    return-void
.end method

.method public resultMetadata(Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V
    .locals 0
    .param p1, "resultMetadata"    # Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    .prologue
    .line 81
    return-void
.end method

.method public sort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
    .locals 0
    .param p1, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;

    .prologue
    .line 61
    return-void
.end method

.method public spellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 0
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 41
    return-void
.end method

.method public startPage()V
    .locals 0

    .prologue
    .line 129
    return-void
.end method

.method public startParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 0
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 97
    return-void
.end method

.method public startRequest()V
    .locals 0

    .prologue
    .line 105
    return-void
.end method

.method public startResult()V
    .locals 0

    .prologue
    .line 121
    return-void
.end method

.method public trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V
    .locals 0
    .param p1, "trackingInfo"    # Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    .prologue
    .line 25
    return-void
.end method

.method public wordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 0
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 45
    return-void
.end method
