.class public Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;
.super Lcom/amazon/mShop/control/PagedListingBrowser;
.source "BarcodeSearchBrowser.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/QueryResponseListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/control/PagedListingBrowser",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
        ">;",
        "Lcom/amazon/rio/j2me/client/services/mShop/QueryResponseListener;"
    }
.end annotation


# instance fields
.field private descriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

.field private maxImageDimension:I

.field private maximumAvailableCount:I

.field private pageSize:I


# direct methods
.method public constructor <init>(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;IIII)V
    .locals 0
    .param p1, "descriptor"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    .param p2, "pageSize"    # I
    .param p3, "nextPageTriggerCount"    # I
    .param p4, "maxImageDimension"    # I
    .param p5, "maximumAvailableCount"    # I

    .prologue
    .line 24
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/control/PagedListingBrowser;-><init>(II)V

    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->descriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    .line 26
    iput p2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->pageSize:I

    .line 27
    iput p4, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->maxImageDimension:I

    .line 28
    iput p5, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->maximumAvailableCount:I

    .line 29
    return-void
.end method


# virtual methods
.method public receivedCategoryResult(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 57
    return-void
.end method

.method public receivedCounts(Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 62
    iget v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->maximumAvailableCount:I

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;->getAvailableCount()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->availableCountReceived(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 64
    return-void
.end method

.method public receivedImage([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # [B
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->imageReceived([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 71
    return-void
.end method

.method public receivedQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 77
    return-void
.end method

.method public receivedSearchResult(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 83
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->objectReceived(Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 85
    return-void
.end method

.method public setQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V
    .locals 0
    .param p1, "descriptor"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->descriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    .line 33
    return-void
.end method

.method protected startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 3
    .param p1, "pageNumber"    # I

    .prologue
    const/4 v2, 0x0

    .line 39
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;-><init>()V

    .line 40
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;
    iget v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->pageSize:I

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setSize(I)V

    .line 41
    iget v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->maxImageDimension:I

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setMaxImageDimension(I)V

    .line 42
    add-int/lit8 v1, p1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setPage(I)V

    .line 43
    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setReturnRefinements(Ljava/lang/Boolean;)V

    .line 44
    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->descriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V

    .line 45
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setCategoryRefinements(Ljava/util/List;)V

    .line 46
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setQuery(Ljava/lang/String;)V

    .line 47
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->setIncludeAddOnItems(Ljava/lang/Boolean;)V

    .line 49
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->query(Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/QueryResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    return-object v1
.end method
