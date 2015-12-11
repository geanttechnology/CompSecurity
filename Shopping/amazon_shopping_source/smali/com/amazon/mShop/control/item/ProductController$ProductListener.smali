.class Lcom/amazon/mShop/control/item/ProductController$ProductListener;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/control/item/ProductController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ProductListener"
.end annotation


# instance fields
.field private cancelled:Z

.field private dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

.field private productServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field private receiveArraySize:I

.field final synthetic this$0:Lcom/amazon/mShop/control/item/ProductController;

.field private variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

.field private visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1861
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1905
    iput-boolean v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z

    .line 2085
    new-array v0, v1, [Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    .line 2086
    new-array v0, v1, [Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    .line 2087
    new-array v0, v1, [Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    .line 2095
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receiveArraySize:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/mShop/control/item/ProductController$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p2, "x1"    # Lcom/amazon/mShop/control/item/ProductController$1;

    .prologue
    .line 1861
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;-><init>(Lcom/amazon/mShop/control/item/ProductController;)V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .prologue
    .line 1861
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancel()V

    return-void
.end method

.method static synthetic access$1300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .prologue
    .line 1861
    iget-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z

    return v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController$ProductListener;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;

    .prologue
    .line 1861
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->start(Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;)V

    return-void
.end method

.method static synthetic access$2000(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .prologue
    .line 1861
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .prologue
    .line 1861
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    return-object v0
.end method

.method static synthetic access$2300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    .prologue
    .line 1861
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    return-object v0
.end method

.method private cancel()V
    .locals 1

    .prologue
    .line 1911
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z

    .line 1912
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->productServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 1913
    return-void
.end method

.method private start(Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;)V
    .locals 3
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;

    .prologue
    .line 1878
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$1100(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v0

    if-nez v0, :cond_0

    .line 1880
    const-string/jumbo v0, "product_v32"

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->mRequestId:Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/control/item/ProductController;->access$1200(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 1886
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    invoke-interface {v0, p1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->product(Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->productServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 1890
    return-void

    .line 1883
    :cond_0
    const-string/jumbo v0, "product_v32"

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->mRequestId:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/control/item/ProductController;->access$1200(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "pageReplacement"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "size"    # I
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2100
    iput p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receiveArraySize:I

    .line 2102
    return-void
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2139
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$8;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$8;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2150
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2160
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2204
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2211
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2222
    return-void
.end method

.method public receivedBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 1967
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$3;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 1982
    return-void
.end method

.method public receivedBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 1941
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 1957
    return-void
.end method

.method public receivedDealId(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2258
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2276
    return-void
.end method

.method public receivedDimension(Lcom/amazon/rio/j2me/client/services/mShop/Dimension;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2107
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    array-length v0, v0

    iget v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receiveArraySize:I

    if-eq v0, v1, :cond_0

    .line 2108
    iget v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receiveArraySize:I

    new-array v0, v0, [Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    .line 2111
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    aput-object p1, v0, p2

    .line 2112
    return-void
.end method

.method public receivedExternalBuyLink(Lcom/amazon/rio/j2me/client/services/mShop/WebLink;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/WebLink;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2253
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # setter for: Lcom/amazon/mShop/control/item/ProductController;->externalBuyLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;
    invoke-static {v0, p1}, Lcom/amazon/mShop/control/item/ProductController;->access$3002(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/WebLink;)Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    .line 2254
    return-void
.end method

.method public receivedExtraOffer(Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2281
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2290
    return-void
.end method

.method public receivedExtraProduct(Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2044
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$6;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$6;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2059
    return-void
.end method

.method public receivedImage([BLcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # [B
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2066
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty([B)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2067
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$7;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$7;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;[B)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2082
    :cond_0
    return-void
.end method

.method public receivedMultiImage(Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2226
    if-eqz p1, :cond_0

    .line 2227
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;ILcom/amazon/rio/j2me/client/services/mShop/MultiImage;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2244
    :cond_0
    return-void
.end method

.method public receivedPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2019
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2034
    return-void
.end method

.method public receivedPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 1920
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$1;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 1934
    return-void
.end method

.method public receivedSavings(Lcom/amazon/rio/j2me/client/services/mShop/Savings;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Savings;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 1993
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener$4;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/item/ProductController$ProductListener$4;-><init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/Savings;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 2008
    return-void
.end method

.method public receivedVariationProductInfo(Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2117
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    array-length v0, v0

    iget v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receiveArraySize:I

    if-eq v0, v1, :cond_0

    .line 2118
    iget v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receiveArraySize:I

    new-array v0, v0, [Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    .line 2121
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    aput-object p1, v0, p2

    .line 2122
    return-void
.end method

.method public receivedVisualBucket(Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2127
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    array-length v0, v0

    iget v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receiveArraySize:I

    if-eq v0, v1, :cond_0

    .line 2128
    iget v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receiveArraySize:I

    new-array v0, v0, [Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    .line 2131
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    aput-object p1, v0, p2

    .line 2132
    return-void
.end method

.method public receivedWebLink(Lcom/amazon/rio/j2me/client/services/mShop/WebLink;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/WebLink;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 2248
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->shareLinkByName:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$2900(Lcom/amazon/mShop/control/item/ProductController;)Ljava/util/Map;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2249
    return-void
.end method

.method public replay()V
    .locals 3

    .prologue
    .line 1896
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->productServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 1897
    const-string/jumbo v0, "product_v32"

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->mRequestId:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/control/item/ProductController;->access$1200(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "pageReplacement"

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1898
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->productServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->replay()V

    .line 1900
    :cond_0
    return-void
.end method
