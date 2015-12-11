.class public Lcom/amazon/mShop/control/history/HistoryBrowser;
.super Lcom/amazon/mShop/control/PagedListingBrowser;
.source "HistoryBrowser.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/control/PagedListingBrowser",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
        ">;",
        "Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;"
    }
.end annotation


# instance fields
.field private mAvailableItemCount:I

.field private mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

.field private mDeletedCount:I

.field private mRecentlyViewedAsins:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mRequest:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;

.field private mRequestId:Ljava/lang/String;


# direct methods
.method public constructor <init>(IILjava/util/List;Lcom/amazon/mShop/control/home/BasicProductsSubscriber;)V
    .locals 1
    .param p1, "pageSize"    # I
    .param p2, "nextPageTriggerCount"    # I
    .param p4, "subscriber"    # Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/control/home/BasicProductsSubscriber;",
            ")V"
        }
    .end annotation

    .prologue
    .line 35
    .local p3, "requestAsins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;-><init>(II)V

    .line 36
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;

    .line 37
    iput-object p3, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRecentlyViewedAsins:Ljava/util/List;

    .line 38
    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mAvailableItemCount:I

    .line 39
    iput-object p4, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    .line 40
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/history/HistoryBrowser;Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/history/HistoryBrowser;
    .param p1, "x1"    # Ljava/util/List;
    .param p2, "x2"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 18
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/control/history/HistoryBrowser;->objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/history/HistoryBrowser;)Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/history/HistoryBrowser;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    return-object v0
.end method


# virtual methods
.method protected adjustRequestTriggerIndex(I)I
    .locals 1
    .param p1, "currentIndex"    # I

    .prologue
    .line 82
    iget v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mDeletedCount:I

    add-int/2addr v0, p1

    return v0
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 88
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/history/HistoryBrowser$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/control/history/HistoryBrowser$1;-><init>(Lcom/amazon/mShop/control/history/HistoryBrowser;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 96
    return-void
.end method

.method public deleteObject(I)Z
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->listingObjects:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 51
    iget v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mDeletedCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mDeletedCount:I

    .line 52
    iget v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mAvailableItemCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mAvailableItemCount:I

    .line 53
    const/4 v0, 0x1

    .line 55
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "exp"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 101
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/history/HistoryBrowser$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/history/HistoryBrowser$2;-><init>(Lcom/amazon/mShop/control/history/HistoryBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 109
    return-void
.end method

.method public getAvailableItemCount()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mAvailableItemCount:I

    return v0
.end method

.method public startFirstPageRequest(Ljava/util/List;Ljava/util/List;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 44
    .local p1, "allAsins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p2, "firstPage":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    iput-object p1, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRecentlyViewedAsins:Ljava/util/List;

    .line 45
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mAvailableItemCount:I

    .line 46
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    invoke-super {p0, v0, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    move-result v0

    return v0
.end method

.method protected startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 5
    .param p1, "pageNumber"    # I

    .prologue
    .line 62
    iget v2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->pageSize:I

    mul-int v1, p1, v2

    .line 63
    .local v1, "start":I
    iget v2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->pageSize:I

    add-int v0, v1, v2

    .line 64
    .local v0, "end":I
    iget-object v2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRecentlyViewedAsins:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-le v0, v2, :cond_0

    iget-object v2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRecentlyViewedAsins:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    .line 65
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;

    new-instance v3, Ljava/util/Vector;

    iget-object v4, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRecentlyViewedAsins:Ljava/util/List;

    invoke-interface {v4, v1, v0}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v2, v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;->setAsins(Ljava/util/List;)V

    .line 67
    if-nez p1, :cond_1

    .line 68
    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRequestId:Ljava/lang/String;

    .line 69
    const-string/jumbo v2, "basic_products_v32"

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRequestId:Ljava/lang/String;

    invoke-static {v2, v3, v4}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 73
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;

    invoke-interface {v2, v3, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->basicProducts(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    return-object v2

    .line 71
    :cond_1
    const-string/jumbo v2, "basic_products_v32"

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/amazon/mShop/control/history/HistoryBrowser;->mRequestId:Ljava/lang/String;

    invoke-static {v2, v3, v4}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    goto :goto_0
.end method
