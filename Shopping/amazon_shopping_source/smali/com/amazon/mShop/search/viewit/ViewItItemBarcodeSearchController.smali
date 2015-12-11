.class public Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;
.super Ljava/lang/Object;
.source "ViewItItemBarcodeSearchController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mBarcodeString:Ljava/lang/String;

.field private mMatchedItemsReturned:Z

.field private mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

.field private mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

.field private mSearchResultsList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;"
        }
    .end annotation
.end field

.field private mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field private mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .param p2, "view"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .prologue
    const/4 v0, 0x0

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 39
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mBarcodeString:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mSearchResultsList:Ljava/util/List;

    .line 41
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMatchedItemsReturned:Z

    .line 66
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    .line 68
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .line 69
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mBarcodeString:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    return-object p1
.end method

.method static synthetic access$500(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mSearchResultsList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    return-object v0
.end method

.method private getBarcodeSearchResultType()I
    .locals 1

    .prologue
    .line 54
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMatchedItemsReturned:Z

    if-eqz v0, :cond_0

    .line 55
    const/4 v0, 0x2

    .line 60
    :goto_0
    return v0

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    if-eqz v0, :cond_1

    .line 58
    const/4 v0, 0x1

    goto :goto_0

    .line 60
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "size"    # I
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 241
    return-void
.end method

.method public cancel()V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 75
    :cond_0
    return-void
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 178
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 190
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 112
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 158
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 162
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 174
    return-void
.end method

.method public receivedCounts(Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 226
    return-void
.end method

.method public receivedImage([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # [B
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 236
    return-void
.end method

.method public receivedMatchedItem(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 194
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 201
    return-void
.end method

.method public receivedMatchedItemThumbnail([BLcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # [B
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 206
    return-void
.end method

.method public receivedMatchedItemsReturned(Ljava/lang/Boolean;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/Boolean;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 210
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMatchedItemsReturned:Z

    .line 211
    return-void
.end method

.method public receivedQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 221
    return-void
.end method

.method public receivedResultsTitle(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 216
    return-void
.end method

.method public receivedSearchResult(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 230
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mSearchResultsList:Ljava/util/List;

    invoke-interface {v0, p2, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 231
    return-void
.end method

.method public startBarcodeSearch(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "barcodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 80
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mSearchResultsList:Ljava/util/List;

    .line 81
    iput-boolean v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMatchedItemsReturned:Z

    .line 82
    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 83
    invoke-interface {p1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mBarcodeString:Ljava/lang/String;

    .line 88
    const/4 v0, 0x1

    .line 90
    .local v0, "maxImageDimension":I
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;-><init>()V

    .line 91
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;
    invoke-interface {p1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setBarcode(Ljava/lang/String;)V

    .line 92
    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setBarcodeType(Ljava/lang/String;)V

    .line 93
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setMaxImageDimension(I)V

    .line 94
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setSize(I)V

    .line 95
    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setIncludeAddOnItems(Ljava/lang/Boolean;)V

    .line 96
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 99
    const-string/jumbo v2, "barcode_search_v32"

    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v4, v3}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 100
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->barcodeSearch(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 102
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->startFlowBarcodeSuccessObserver()V

    .line 103
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->startFlowBarcodeNoMatchesObserver()V

    .line 104
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->startFlowBarcodeFailObserver()V

    .line 105
    return-void
.end method
