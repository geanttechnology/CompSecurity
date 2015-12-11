.class Lcom/amazon/mShop/control/item/ProductController$DealListener;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/DealResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/control/item/ProductController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DealListener"
.end annotation


# instance fields
.field private dealServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic this$0:Lcom/amazon/mShop/control/item/ProductController;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0

    .prologue
    .line 2402
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/mShop/control/item/ProductController$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p2, "x1"    # Lcom/amazon/mShop/control/item/ProductController$1;

    .prologue
    .line 2402
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController$DealListener;-><init>(Lcom/amazon/mShop/control/item/ProductController;)V

    return-void
.end method

.method static synthetic access$3700(Lcom/amazon/mShop/control/item/ProductController$DealListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController$DealListener;

    .prologue
    .line 2402
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->dealServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-object v0
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 2469
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->dealServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 2470
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->dealServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 2471
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->dealServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 2473
    :cond_0
    return-void
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2451
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2421
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2455
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;-><init>(Lcom/amazon/mShop/control/item/ProductController$DealListener;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2466
    return-void
.end method

.method public receivedDeal(Lcom/amazon/rio/j2me/client/services/mShop/Deal;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 6
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Deal;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    const-wide/16 v4, 0x3e8

    .line 2430
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getMsToStart()Ljava/lang/Integer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2431
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    div-long/2addr v0, v4

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getMsToStart()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    div-int/lit16 v2, v2, 0x3e8

    int-to-long v2, v2

    add-long/2addr v0, v2

    long-to-int v0, v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setMsToStart(Ljava/lang/Integer;)V

    .line 2433
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getMsToEnd()Ljava/lang/Integer;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 2434
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    div-long/2addr v0, v4

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->getMsToEnd()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    div-int/lit16 v2, v2, 0x3e8

    int-to-long v2, v2

    add-long/2addr v0, v2

    long-to-int v0, v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setMsToEnd(Ljava/lang/Integer;)V

    .line 2437
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;-><init>(Lcom/amazon/mShop/control/item/ProductController$DealListener;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/Deal;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2446
    return-void
.end method

.method public requestDeal(Ljava/lang/String;)V
    .locals 4
    .param p1, "dealId"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    .line 2407
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController$DealListener;->cancel()V

    .line 2408
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;-><init>()V

    .line 2409
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->setDealId(Ljava/lang/String;)V

    .line 2410
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->setShowVariations(Ljava/lang/Boolean;)V

    .line 2411
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->asin:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/control/item/ProductController;->access$3600(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;->setAsin(Ljava/lang/String;)V

    .line 2414
    const-string/jumbo v1, "deal_v32"

    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->mRequestId:Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/control/item/ProductController;->access$1200(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v3, v2}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 2415
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->deal(Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;Lcom/amazon/rio/j2me/client/services/mShop/DealResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->dealServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 2417
    return-void
.end method
