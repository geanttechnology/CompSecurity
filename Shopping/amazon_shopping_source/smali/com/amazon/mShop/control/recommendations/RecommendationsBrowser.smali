.class public Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
.super Lcom/amazon/mShop/control/PagedListingBrowser;
.source "RecommendationsBrowser.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsResponseListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/control/PagedListingBrowser",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
        ">;",
        "Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsResponseListener;"
    }
.end annotation


# instance fields
.field private mRatingPendingIndexSet:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mRecSubscriber:Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;

.field private final mRefinements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;",
            ">;"
        }
    .end annotation
.end field

.field private final mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

.field private mRequestId:Ljava/lang/String;

.field protected mTotalCount:I


# direct methods
.method public constructor <init>(IIILcom/amazon/mShop/control/search/QueryProvider;Ljava/lang/String;)V
    .locals 2
    .param p1, "_pageSize"    # I
    .param p2, "nextPageTriggerCount"    # I
    .param p3, "imageDimension"    # I
    .param p4, "queryProvider"    # Lcom/amazon/mShop/control/search/QueryProvider;
    .param p5, "category"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;-><init>(II)V

    .line 46
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mTotalCount:I

    .line 89
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRefinements:Ljava/util/List;

    .line 54
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    .line 55
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    iget v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->pageSize:I

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->setCount(I)V

    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    invoke-virtual {v0, p3}, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->setMaxImageDimension(I)V

    .line 57
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    invoke-virtual {v0, p5}, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->setCategory(Ljava/lang/String;)V

    .line 58
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRatingPendingIndexSet:Ljava/util/Set;

    .line 59
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->currentRequestPageIndex:I

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->pageSize:I

    return v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingIndices:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingObjects:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    .param p1, "x1"    # Ljava/util/List;
    .param p2, "x2"    # Ljava/lang/Object;
    .param p3, "x3"    # I
    .param p4, "x4"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 22
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->addToListAndNotify(Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->currentRequestPageIndex:I

    return v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->pageSize:I

    return v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingImages:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    .param p1, "x1"    # Ljava/util/List;
    .param p2, "x2"    # Ljava/lang/Object;
    .param p3, "x3"    # I
    .param p4, "x4"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 22
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->addToListAndNotify(Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    return-void
.end method


# virtual methods
.method public addRatingPendingIndex(I)V
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 297
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRatingPendingIndexSet:Ljava/util/Set;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 298
    return-void
.end method

.method protected adjustRequestTriggerIndex(I)I
    .locals 1
    .param p1, "currentIndex"    # I

    .prologue
    .line 272
    invoke-virtual {p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getRatingPendingIndexSet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 273
    invoke-virtual {p0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getRatingPendingIndexSet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    add-int/2addr p1, v0

    .line 275
    :cond_0
    return p1
.end method

.method public amountHasDelted(I)I
    .locals 4
    .param p1, "index"    # I

    .prologue
    .line 325
    const/4 v0, 0x0

    .line 326
    .local v0, "i":I
    iget-object v3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRatingPendingIndexSet:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/Integer;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 327
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    .line 328
    .local v2, "temp":Ljava/lang/Integer;
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-le p1, v3, :cond_0

    .line 329
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 332
    .end local v2    # "temp":Ljava/lang/Integer;
    :cond_1
    return v0
.end method

.method public clearAllList()V
    .locals 1

    .prologue
    .line 336
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 337
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 338
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingIndices:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 339
    return-void
.end method

.method public clearRatingPendingIndexSet()V
    .locals 1

    .prologue
    .line 305
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRatingPendingIndexSet:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 306
    return-void
.end method

.method public getRatingPendingIndexSet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 289
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRatingPendingIndexSet:Ljava/util/Set;

    return-object v0
.end method

.method public getRecSubscriber()Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRecSubscriber:Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;

    return-object v0
.end method

.method public getRefinements()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 95
    iget-object v3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRefinements:Ljava/util/List;

    monitor-enter v3

    .line 96
    :try_start_0
    iget-object v2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRefinements:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    .line 97
    .local v0, "size":I
    if-nez v0, :cond_0

    const/4 v1, 0x0

    monitor-exit v3

    .line 100
    :goto_0
    return-object v1

    .line 98
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 99
    .local v1, "v":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    iget-object v2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRefinements:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 100
    monitor-exit v3

    goto :goto_0

    .line 101
    .end local v0    # "size":I
    .end local v1    # "v":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public hasCategoryResult()Z
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->getCategory()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasDeletedAt(I)Z
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 314
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRatingPendingIndexSet:Ljava/util/Set;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method protected imageReceived([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "image"    # [B
    .param p2, "intraPageIndex"    # I
    .param p3, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 189
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;

    invoke-direct {v1, p0, p2, p1, p3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;-><init>(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;I[BLcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 205
    return-void
.end method

.method protected objectReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "intraPageIndex"    # I
    .param p3, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 148
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;

    invoke-direct {v1, p0, p2, p1, p3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;-><init>(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;ILcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 160
    return-void
.end method

.method protected bridge synthetic objectReceived(Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 22
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->objectReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    return-void
.end method

.method public receivedAvailableCount(Ljava/lang/Integer;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/Integer;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 127
    const/16 v0, 0x64

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->availableCountReceived(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 128
    return-void
.end method

.method public receivedCategoryResult(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 211
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRefinements:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 212
    return-void
.end method

.method public receivedImage([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # [B
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 165
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->imageReceived([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 166
    return-void
.end method

.method public receivedNoRecommendationsExplanation(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 224
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$3;-><init>(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 233
    return-void
.end method

.method public receivedSearchResult(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 133
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->objectReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 134
    return-void
.end method

.method public refine(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;)Z
    .locals 3
    .param p1, "categoryResult"    # Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    .prologue
    const/4 v1, 0x0

    .line 116
    iget-object v2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->getCategory()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->setCategory(Ljava/lang/String;)V

    .line 117
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRefinements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 118
    const v0, 0x7fffffff

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    move-result v0

    return v0

    :cond_0
    move-object v0, v1

    .line 116
    goto :goto_0
.end method

.method public removeItemAt(I)Ljava/lang/Object;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 242
    const/4 v0, 0x0

    .line 243
    .local v0, "o":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge p1, v1, :cond_0

    .line 244
    iget-object v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v0

    .line 246
    .end local v0    # "o":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge p1, v1, :cond_1

    .line 247
    iget-object v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingImages:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 249
    :cond_1
    return-object v0
.end method

.method public removeItemIndexAt(I)I
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 260
    iget-object v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingIndices:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 261
    .local v0, "i":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    return v1
.end method

.method public setRecSubscriber(Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;)V
    .locals 0
    .param p1, "recSubscriber"    # Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRecSubscriber:Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;

    .line 41
    return-void
.end method

.method public startFirstPageRequest(ILjava/util/List;)Z
    .locals 1
    .param p1, "availableCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 69
    .local p2, "firstPage":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mTotalCount:I

    .line 70
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRefinements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 72
    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequestId:Ljava/lang/String;

    .line 73
    const/4 v0, 0x0

    invoke-super {p0, p1, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    move-result v0

    return v0
.end method

.method protected startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 3
    .param p1, "pageNumber"    # I

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    iget v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->pageSize:I

    mul-int/2addr v1, p1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->setStartOffset(I)V

    .line 84
    const-string/jumbo v1, "get_recommended_items_v32"

    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequestId:Ljava/lang/String;

    invoke-static {v1, v0, v2}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 86
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;

    invoke-interface {v0, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->getRecommendedItems(Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    return-object v0

    .line 84
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
