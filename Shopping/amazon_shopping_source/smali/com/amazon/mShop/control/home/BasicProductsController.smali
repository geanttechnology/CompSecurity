.class public Lcom/amazon/mShop/control/home/BasicProductsController;
.super Lcom/amazon/mShop/control/BaseController;
.source "BasicProductsController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;


# instance fields
.field private mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/home/BasicProductsSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/amazon/mShop/control/home/BasicProductsController;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    .line 23
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/home/BasicProductsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/BasicProductsController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/home/BasicProductsController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/home/BasicProductsController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/BasicProductsController;

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/control/home/BasicProductsController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/home/BasicProductsController;)Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/BasicProductsController;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/mShop/control/home/BasicProductsController;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/home/BasicProductsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/BasicProductsController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/home/BasicProductsController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/home/BasicProductsController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/home/BasicProductsController;

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/control/home/BasicProductsController;->serviceCallCompleted()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 40
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 59
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/BasicProductsController$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/home/BasicProductsController$2;-><init>(Lcom/amazon/mShop/control/home/BasicProductsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 70
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "exp"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 44
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/home/BasicProductsController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/home/BasicProductsController$1;-><init>(Lcom/amazon/mShop/control/home/BasicProductsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 55
    return-void
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/control/home/BasicProductsController;->getSubscriber()Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/mShop/control/home/BasicProductsController;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    return-object v0
.end method

.method public requestBasicProducts(Ljava/util/List;Ljava/lang/String;)V
    .locals 4
    .param p2, "requestId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v2, 0x0

    .line 28
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;-><init>()V

    .line 29
    .local v0, "req":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;
    if-eqz p1, :cond_0

    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1, p1}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    :goto_0
    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;->setAsins(Ljava/util/List;)V

    .line 33
    const-string/jumbo v1, "basic_products_v32"

    const/4 v3, 0x1

    invoke-static {v1, v3, p2}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 34
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->basicProducts(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/control/home/BasicProductsController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 35
    return-void

    :cond_0
    move-object v1, v2

    .line 29
    goto :goto_0
.end method
