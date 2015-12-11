.class public Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;
.super Ljava/lang/Object;
.source "ViewItItemImageSearchController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

.field private mOriginalScannedOutput:Ljava/lang/String;

.field private mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field private mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .param p2, "view"    # Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mOriginalScannedOutput:Ljava/lang/String;

    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    .line 34
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .line 35
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mOriginalScannedOutput:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    return-object v0
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 41
    :cond_0
    return-void
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 114
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 126
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 68
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 94
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 98
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 110
    return-void
.end method

.method public startBasicProductsRequest(Ljava/util/List;)V
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
    .line 45
    .local p1, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "clickStreamOrigin":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->getTypeValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p1}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->getSeriesAsinString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mOriginalScannedOutput:Ljava/lang/String;

    .line 49
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 51
    const-string/jumbo v2, "basic_products_v32"

    invoke-static {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->createFullClickstreamTag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->logServiceMethodNameAndRefmarker(Ljava/lang/String;Ljava/lang/String;)Z

    .line 54
    :cond_0
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;-><init>()V

    .line 55
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;
    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;->setAsins(Ljava/util/List;)V

    .line 56
    const-string/jumbo v2, "basic_products_v32"

    const/4 v3, 0x0

    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 57
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->basicProducts(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 59
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->startFlowImageSuccessObserver()V

    .line 60
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->startFlowImageFailObserver()V

    .line 61
    return-void
.end method
