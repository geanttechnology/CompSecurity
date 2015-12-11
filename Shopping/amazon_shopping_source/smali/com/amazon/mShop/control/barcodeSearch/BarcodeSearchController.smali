.class public Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
.super Lcom/amazon/mShop/control/BaseController;
.source "BarcodeSearchController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatchResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;


# instance fields
.field private mBarcodeFormat:Ljava/lang/String;

.field private mBarcodeSearchStatus:I

.field private mBarcodeString:Ljava/lang/String;

.field private mMatchedItemThumbnail:[B

.field private mMatchedItemsReturned:Z

.field private mQueryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

.field private mResultsTitle:Ljava/lang/String;

.field private mSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

.field private final mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;)V
    .locals 2
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    .prologue
    const/4 v1, 0x0

    .line 22
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 37
    iput v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeSearchStatus:I

    .line 132
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 168
    iput-boolean v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mMatchedItemsReturned:Z

    .line 23
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    .line 24
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .param p1, "x1"    # I

    .prologue
    .line 20
    iput p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeSearchStatus:I

    return p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 20
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    .prologue
    .line 20
    invoke-virtual {p0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;)Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    return-object p1
.end method

.method static synthetic access$502(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;[B)[B
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .param p1, "x1"    # [B

    .prologue
    .line 20
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mMatchedItemThumbnail:[B

    return-object p1
.end method

.method static synthetic access$602(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .param p1, "x1"    # Z

    .prologue
    .line 20
    iput-boolean p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mMatchedItemsReturned:Z

    return p1
.end method

.method static synthetic access$702(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mQueryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    return-object p1
.end method

.method static synthetic access$802(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mResultsTitle:Ljava/lang/String;

    return-object p1
.end method


# virtual methods
.method public aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "size"    # I
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 96
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 101
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 114
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Null;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 250
    invoke-virtual {p0, p2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->serviceCallCompleted()V

    .line 251
    :cond_0
    return-void
.end method

.method public getBarcodeSearchResultType()I
    .locals 1

    .prologue
    .line 237
    iget-boolean v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mMatchedItemsReturned:Z

    if-eqz v0, :cond_0

    .line 238
    const/4 v0, 0x2

    .line 243
    :goto_0
    return v0

    .line 240
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    if-eqz v0, :cond_1

    .line 241
    const/4 v0, 0x1

    goto :goto_0

    .line 243
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBarcodeSearchStatus()I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeSearchStatus:I

    return v0
.end method

.method public getMatchItemSearchResult()Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    return-object v0
.end method

.method public getResultsTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mResultsTitle:Ljava/lang/String;

    return-object v0
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 20
    invoke-virtual {p0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getSubscriber()Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    return-object v0
.end method

.method public hasMoreResults()Z
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mQueryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public receivedCounts(Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 119
    return-void
.end method

.method public receivedImage([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # [B
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 124
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$2;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;[BI)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 130
    return-void
.end method

.method public receivedMatchedItem(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 141
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 148
    return-void
.end method

.method public receivedMatchedItemThumbnail([BLcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # [B
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 159
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;[B)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 166
    return-void
.end method

.method public receivedMatchedItemsReturned(Ljava/lang/Boolean;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/Boolean;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 173
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$5;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$5;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Ljava/lang/Boolean;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 182
    return-void
.end method

.method public receivedQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 189
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 199
    return-void
.end method

.method public receivedResultsTitle(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 211
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$7;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$7;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 218
    return-void
.end method

.method public receivedSearchResult(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 223
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;I)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 230
    return-void
.end method

.method public reportMismatch()V
    .locals 4

    .prologue
    .line 68
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;-><init>()V

    .line 69
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;
    iget-object v2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeString:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->setBarcode(Ljava/lang/String;)V

    .line 70
    iget-object v2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeFormat:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->setBarcodeType(Ljava/lang/String;)V

    .line 72
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 74
    .local v0, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    if-eqz v2, :cond_3

    .line 76
    iget-object v2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 84
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 85
    new-instance v2, Ljava/util/Vector;

    invoke-direct {v2, v0}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;->setAsins(Ljava/util/List;)V

    .line 88
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->hasServiceCallRunning()Z

    move-result v2

    if-nez v2, :cond_2

    .line 89
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->barcodeBadMatch(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 91
    :cond_2
    return-void

    .line 79
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mQueryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    if-eqz v2, :cond_0

    .line 80
    iget-object v2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mQueryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;->getQueryData()Ljava/util/List;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0
.end method

.method public setBarcodeSearchStatus(I)V
    .locals 0
    .param p1, "status"    # I

    .prologue
    .line 44
    iput p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeSearchStatus:I

    .line 45
    return-void
.end method

.method public startBarcodeSearch(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 3
    .param p1, "barcodeString"    # Ljava/lang/String;
    .param p2, "barcodeFormat"    # Ljava/lang/String;
    .param p3, "maxImageDimension"    # I

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeString:Ljava/lang/String;

    .line 53
    iput-object p2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeFormat:Ljava/lang/String;

    .line 55
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;-><init>()V

    .line 56
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setBarcode(Ljava/lang/String;)V

    .line 57
    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setBarcodeType(Ljava/lang/String;)V

    .line 58
    invoke-virtual {v0, p3}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setMaxImageDimension(I)V

    .line 59
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;->setIncludeAddOnItems(Ljava/lang/Boolean;)V

    .line 61
    const/4 v1, 0x1

    iput v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeSearchStatus:I

    .line 63
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->barcodeSearch(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 64
    return-void
.end method
