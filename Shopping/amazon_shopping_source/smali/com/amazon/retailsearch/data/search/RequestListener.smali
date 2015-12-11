.class public Lcom/amazon/retailsearch/data/search/RequestListener;
.super Lcom/amazon/searchapp/retailsearch/client/AbstractSearchListener;
.source "RequestListener.java"


# static fields
.field private static final NEXT_PAGE_TAG:Ljava/lang/String; = "next"


# instance fields
.field private final resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

.field retailSearchDataProvider:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private final searchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

.field private searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private serviceCall:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/data/search/SearchLoader;Lcom/amazon/retailsearch/data/search/ResultStream;)V
    .locals 1
    .param p1, "searchLoader"    # Lcom/amazon/retailsearch/data/search/SearchLoader;
    .param p2, "resultStream"    # Lcom/amazon/retailsearch/data/search/ResultStream;

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/AbstractSearchListener;-><init>()V

    .line 43
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 48
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    .line 49
    iput-object p2, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    .line 50
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 51
    return-void
.end method

.method private addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V
    .locals 1
    .param p1, "item"    # Lcom/amazon/retailsearch/data/search/ResultEvent;

    .prologue
    .line 364
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/data/search/ResultStream;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 365
    return-void
.end method


# virtual methods
.method public breadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V
    .locals 1
    .param p1, "breadcrumb"    # Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .prologue
    .line 301
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$21;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$21;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 307
    return-void
.end method

.method public categoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
    .locals 1
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 252
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$17;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$17;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 258
    return-void
.end method

.method public didYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 1
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 311
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$22;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$22;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 317
    return-void
.end method

.method public displaySettings(Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V
    .locals 1
    .param p1, "displaySettings"    # Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    .prologue
    .line 192
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$11;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$11;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 198
    return-void
.end method

.method public endParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 1
    .param p1, "searchResult"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 359
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchSRDSResponseEndParse()V

    .line 360
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchSRDSCompleted()V

    .line 361
    return-void
.end method

.method public endRequest()V
    .locals 2

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->retailSearchDataProvider:Ldagger/Lazy;

    invoke-interface {v0}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    sget-object v1, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->POST_SEARCH_PAGE_LOAD:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->fetchAssets(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V

    .line 91
    sget-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Error:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 96
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$3;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/data/search/RequestListener$3;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 141
    :goto_0
    return-void

    .line 107
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/data/search/SearchLoader;->getNextUrl()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    .line 108
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    sget-object v1, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Done:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->setStatus(Lcom/amazon/retailsearch/data/search/ResultStream$Status;)V

    .line 111
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->getPageCount()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->setPageCount(I)V

    .line 113
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$4;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/data/search/RequestListener$4;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 120
    sget-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Done:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 121
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$5;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/data/search/RequestListener$5;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 129
    :cond_2
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/SearchLoader;->setLoading(Z)V

    .line 133
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$6;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/data/search/RequestListener$6;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;)V

    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->getListeners()Ljava/lang/Iterable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/RequestListener$6;->send(Ljava/lang/Iterable;)V

    goto :goto_0
.end method

.method public error(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    const-string/jumbo v1, "Search request error"

    iget-object v2, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;

    invoke-interface {v0, v1, p1, v2}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchSRDSError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;)V

    .line 157
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    sget-object v1, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Error:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->setStatus(Lcom/amazon/retailsearch/data/search/ResultStream$Status;)V

    .line 158
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/SearchLoader;->setLoading(Z)V

    .line 160
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$8;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$8;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Ljava/lang/Exception;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 168
    return-void
.end method

.method public fkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
    .locals 1
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    .line 222
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$14;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$14;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/FKMR;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 228
    return-void
.end method

.method public noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 1
    .param p1, "noResultsSet"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 331
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$24;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$24;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 337
    return-void
.end method

.method public pagination(Lcom/amazon/searchapp/retailsearch/model/Pagination;)V
    .locals 4
    .param p1, "pagination"    # Lcom/amazon/searchapp/retailsearch/model/Pagination;

    .prologue
    .line 272
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Pagination;->getPages()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 273
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Pagination;->getPages()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/Page;

    .line 274
    .local v1, "page":Lcom/amazon/searchapp/retailsearch/model/Page;
    if-eqz v1, :cond_0

    const-string/jumbo v2, "next"

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Page;->getType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 275
    iget-object v2, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Page;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/data/search/SearchLoader;->setNextUrl(Ljava/lang/String;)V

    .line 281
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "page":Lcom/amazon/searchapp/retailsearch/model/Page;
    :cond_1
    new-instance v2, Lcom/amazon/retailsearch/data/search/RequestListener$19;

    invoke-direct {v2, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$19;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/Pagination;)V

    invoke-direct {p0, v2}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 287
    return-void
.end method

.method public preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
    .locals 1
    .param p1, "preloadImages"    # Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    .prologue
    .line 182
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$10;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$10;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 188
    return-void
.end method

.method public product(Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 1
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 212
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$13;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$13;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/Product;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 218
    return-void
.end method

.method public refinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 1
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 262
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$18;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$18;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/Refinements;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 268
    return-void
.end method

.method public relatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
    .locals 1
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    .line 321
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$23;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$23;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 327
    return-void
.end method

.method public resources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V
    .locals 1
    .param p1, "searchResources"    # Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    .prologue
    .line 202
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$12;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$12;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 208
    return-void
.end method

.method public result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 1
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 145
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$7;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$7;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 151
    return-void
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 38
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener;->result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V

    return-void
.end method

.method public resultMetadata(Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V
    .locals 1
    .param p1, "resultMetadata"    # Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    .prologue
    .line 341
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$25;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$25;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 347
    return-void
.end method

.method setServiceCall(Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;)V
    .locals 0
    .param p1, "serviceCall"    # Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;

    .line 58
    return-void
.end method

.method public sort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
    .locals 1
    .param p1, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;

    .prologue
    .line 291
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$20;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$20;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/Sort;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 297
    return-void
.end method

.method public spellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 1
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 232
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$15;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$15;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 238
    return-void
.end method

.method public startParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 1
    .param p1, "searchResult"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 352
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchFirstByteReceived()V

    .line 353
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchSRDSResponseBeginParse()V

    .line 354
    return-void
.end method

.method public startRequest()V
    .locals 3

    .prologue
    .line 62
    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchSRDSStarted()V

    .line 63
    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    sget-object v2, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->None:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/data/search/ResultStream;->setStatus(Lcom/amazon/retailsearch/data/search/ResultStream$Status;)V

    .line 64
    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/data/search/SearchLoader;->setNextUrl(Ljava/lang/String;)V

    .line 65
    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->getPageCount()I

    move-result v0

    .line 66
    .local v0, "pageCount":I
    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->searchLoader:Lcom/amazon/retailsearch/data/search/SearchLoader;

    iget-object v2, p0, Lcom/amazon/retailsearch/data/search/RequestListener;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/data/search/ResultStream;->getContent()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/data/search/SearchLoader;->setPageStartIndex(I)V

    .line 68
    if-nez v0, :cond_0

    .line 69
    new-instance v1, Lcom/amazon/retailsearch/data/search/RequestListener$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/data/search/RequestListener$1;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;)V

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 77
    :cond_0
    new-instance v1, Lcom/amazon/retailsearch/data/search/RequestListener$2;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/data/search/RequestListener$2;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;)V

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 83
    return-void
.end method

.method public trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V
    .locals 1
    .param p1, "trackingInfo"    # Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    .prologue
    .line 172
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$9;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$9;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 178
    return-void
.end method

.method public wordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 1
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 242
    new-instance v0, Lcom/amazon/retailsearch/data/search/RequestListener$16;

    invoke-direct {v0, p0, p1}, Lcom/amazon/retailsearch/data/search/RequestListener$16;-><init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/data/search/RequestListener;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 248
    return-void
.end method
