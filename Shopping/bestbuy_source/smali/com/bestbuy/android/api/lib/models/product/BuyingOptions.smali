.class public Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static TAG:Ljava/lang/String; = null

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private availableForStorePickup:Z

.field private availableOnline:Z

.field private availableOnlineDispMsg:Ljava/lang/String;

.field private availableOnlineUrl:Ljava/lang/String;

.field private availableStoreDispMsg:Ljava/lang/String;

.field private availableStoreUrl:Ljava/lang/String;

.field private buyingOptionsInfo:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;",
            ">;"
        }
    .end annotation
.end field

.field private condition:Ljava/lang/String;

.field private currentPrice:D

.field private displayCertifiedLogo:Z

.field private displayCondition:Ljava/lang/String;

.field private financingOfferInfo:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;",
            ">;"
        }
    .end annotation
.end field

.field private freeShippingCode:Ljava/lang/String;

.field private height:I

.field private listingId:Ljava/lang/String;

.field private pricingType:Ljava/lang/String;

.field private productId:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private regularPrice:D

.field private savingsAmount:D

.field private sellerId:Ljava/lang/String;

.field private sellerImage:Ljava/lang/String;

.field private sellerInfoUrl:Ljava/lang/String;

.field private sellerName:Ljava/lang/String;

.field private sellerskuid:Ljava/lang/String;

.field private shippingCost:D

.field private shortname:Ljava/lang/String;

.field private sku:Ljava/lang/String;

.field private spclOfferInfo:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;",
            ">;"
        }
    .end annotation
.end field

.field private target:Ljava/lang/String;

.field private totalPrice:D

.field private width:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    const-wide/16 v2, 0x0

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sku:Ljava/lang/String;

    .line 25
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->shortname:Ljava/lang/String;

    .line 26
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->productType:Ljava/lang/String;

    .line 27
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerskuid:Ljava/lang/String;

    .line 28
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->condition:Ljava/lang/String;

    .line 29
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->displayCondition:Ljava/lang/String;

    .line 30
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->productId:Ljava/lang/String;

    .line 34
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableForStorePickup:Z

    .line 35
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableStoreDispMsg:Ljava/lang/String;

    .line 36
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableStoreUrl:Ljava/lang/String;

    .line 39
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnline:Z

    .line 40
    iput v1, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->height:I

    .line 41
    iput v1, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->width:I

    .line 42
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->target:Ljava/lang/String;

    .line 43
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnlineDispMsg:Ljava/lang/String;

    .line 44
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnlineUrl:Ljava/lang/String;

    .line 47
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->currentPrice:D

    .line 48
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->listingId:Ljava/lang/String;

    .line 49
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->pricingType:Ljava/lang/String;

    .line 50
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->shippingCost:D

    .line 51
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->totalPrice:D

    .line 52
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->regularPrice:D

    .line 53
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->savingsAmount:D

    .line 56
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerName:Ljava/lang/String;

    .line 57
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerInfoUrl:Ljava/lang/String;

    .line 58
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerImage:Ljava/lang/String;

    .line 59
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerId:Ljava/lang/String;

    .line 60
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->freeShippingCode:Ljava/lang/String;

    .line 433
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static loadBuyingOptionsData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;
    .locals 5

    .prologue
    .line 278
    new-instance v1, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;-><init>()V

    .line 280
    :try_start_0
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 281
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 282
    const-string v2, "productType"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->productType:Ljava/lang/String;

    .line 283
    const-string v2, "skuId"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sku:Ljava/lang/String;

    .line 285
    const-string v2, "names"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 286
    const-string v2, "names"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "short"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->shortname:Ljava/lang/String;

    .line 289
    :cond_0
    const-string v2, "buyingOptions"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 290
    const-string v2, "buyingOptions"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->loadBuyingOptionsArrayData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->buyingOptionsInfo:Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 299
    :cond_1
    :goto_0
    return-object v1

    .line 295
    :catch_0
    move-exception v0

    .line 296
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Couldn\'t parse buyingOptionsTab data:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public getAvailableOnlineDispMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnlineDispMsg:Ljava/lang/String;

    return-object v0
.end method

.method public getAvailableOnlineUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnlineUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getAvailableStoreDispMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableStoreDispMsg:Ljava/lang/String;

    return-object v0
.end method

.method public getAvailableStoreUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableStoreUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getBuyingOptionsInfo()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;",
            ">;"
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->buyingOptionsInfo:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrentPrice()D
    .locals 2

    .prologue
    .line 198
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->currentPrice:D

    return-wide v0
.end method

.method public getDisplayCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->displayCondition:Ljava/lang/String;

    return-object v0
.end method

.method public getFinancingOfferInfo()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->financingOfferInfo:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getFreeShippingCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->freeShippingCode:Ljava/lang/String;

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 163
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->height:I

    return v0
.end method

.method public getListingId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->listingId:Ljava/lang/String;

    return-object v0
.end method

.method public getPricingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->pricingType:Ljava/lang/String;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getRegularPrice()D
    .locals 2

    .prologue
    .line 233
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->regularPrice:D

    return-wide v0
.end method

.method public getSavingsAmount()D
    .locals 2

    .prologue
    .line 240
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->savingsAmount:D

    return-wide v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 274
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerId:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerImage:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerInfoUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 262
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerInfoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerName:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerskuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerskuid:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingCost()D
    .locals 2

    .prologue
    .line 219
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->shippingCost:D

    return-wide v0
.end method

.method public getShortname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->shortname:Ljava/lang/String;

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getSpclOfferInfo()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->spclOfferInfo:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->target:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalPrice()D
    .locals 2

    .prologue
    .line 226
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->totalPrice:D

    return-wide v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 170
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->width:I

    return v0
.end method

.method public isAvailableForStorePickup()Z
    .locals 1

    .prologue
    .line 135
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableForStorePickup:Z

    return v0
.end method

.method public isAvailableOnline()Z
    .locals 1

    .prologue
    .line 156
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnline:Z

    return v0
.end method

.method public isDisplayCertifiedLogo()Z
    .locals 1

    .prologue
    .line 79
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->displayCertifiedLogo:Z

    return v0
.end method

.method public loadBuyingOptionsArrayData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;",
            ">;"
        }
    .end annotation

    .prologue
    const-wide/16 v10, 0x0

    const/4 v1, 0x0

    .line 303
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 304
    if-eqz p1, :cond_8

    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_8

    move v0, v1

    .line 305
    :goto_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_8

    .line 306
    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 307
    if-eqz v3, :cond_7

    .line 309
    new-instance v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;-><init>()V

    .line 310
    const-string v5, "skuId"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerskuid:Ljava/lang/String;

    .line 311
    const-string v5, "condition"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->condition:Ljava/lang/String;

    .line 312
    const-string v5, "displayCondition"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->displayCondition:Ljava/lang/String;

    .line 313
    const-string v5, "productId"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->productId:Ljava/lang/String;

    .line 314
    const-string v5, "displayCertifiedLogo"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v5

    iput-boolean v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->displayCertifiedLogo:Z

    .line 316
    const-string v5, "specialOffers"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 317
    const-string v5, "specialOffers"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    invoke-static {v5}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;->loadSpecialOffersData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->spclOfferInfo:Ljava/util/ArrayList;

    .line 320
    :cond_0
    const-string v5, "financingOffers"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 321
    const-string v5, "financingOffers"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    invoke-static {v5}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;->loadFinanceOffersData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->financingOfferInfo:Ljava/util/ArrayList;

    .line 325
    :cond_1
    const-string v5, "sellerInfo"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 326
    const-string v5, "sellerInfo"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "seller"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerName:Ljava/lang/String;

    .line 327
    const-string v5, "sellerInfo"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "sellerUrl"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerInfoUrl:Ljava/lang/String;

    .line 328
    const-string v5, "sellerInfo"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "images"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 329
    const-string v6, "sellerInfo"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "sellerId"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerId:Ljava/lang/String;

    .line 330
    if-eqz v5, :cond_2

    .line 331
    invoke-virtual {v5, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 332
    if-eqz v5, :cond_2

    .line 333
    const-string v6, "url"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->sellerImage:Ljava/lang/String;

    .line 337
    :cond_2
    const-string v5, "availability"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 338
    const-string v5, "availability"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 340
    const-string v6, "pickup"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 341
    const-string v6, "pickup"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 342
    const-string v7, "available"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v7

    iput-boolean v7, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableForStorePickup:Z

    .line 343
    const-string v7, "displayMessage"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "<b>Store Pickup:</b>"

    const-string v9, ""

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "<b>Store Pickup</b>:"

    const-string v9, ""

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableStoreDispMsg:Ljava/lang/String;

    .line 344
    const-string v7, "checkStoresLink"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    if-eqz v7, :cond_3

    .line 345
    const-string v7, "checkStoresLink"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 346
    const-string v7, "url"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableStoreUrl:Ljava/lang/String;

    .line 349
    :cond_3
    const-string v6, "ship"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_4

    .line 350
    const-string v6, "ship"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 351
    const-string v6, "available"

    invoke-virtual {v5, v6, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v6

    iput-boolean v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnline:Z

    .line 352
    const-string v6, "displayMessage"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "<b>Shipping:</b>"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "<b>Shipping</b>:"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnlineDispMsg:Ljava/lang/String;

    .line 353
    const-string v6, "checkLink"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_4

    .line 354
    const-string v6, "checkLink"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 355
    const-string v6, "url"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->availableOnlineUrl:Ljava/lang/String;

    .line 356
    const-string v6, "height"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v6

    iput v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->height:I

    .line 357
    const-string v6, "width"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v6

    iput v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->width:I

    .line 358
    const-string v6, "target"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->target:Ljava/lang/String;

    .line 363
    :cond_4
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_5

    .line 364
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 365
    const-string v6, "currentPrice"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->currentPrice:D

    .line 366
    const-string v6, "pricingType"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->pricingType:Ljava/lang/String;

    .line 367
    const-string v6, "shippingCost"

    invoke-virtual {v5, v6, v10, v11}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;D)D

    move-result-wide v6

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->shippingCost:D

    .line 368
    const-string v6, "totalPrice"

    invoke-virtual {v5, v6, v10, v11}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;D)D

    move-result-wide v6

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->totalPrice:D

    .line 369
    const-string v6, "savingsAmount"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->savingsAmount:D

    .line 370
    const-string v6, "regularPrice"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->regularPrice:D

    .line 371
    const-string v6, "listingId"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->listingId:Ljava/lang/String;

    .line 373
    :cond_5
    const-string v5, "properties"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_6

    .line 374
    const-string v5, "properties"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 375
    const-string v5, "freeShippingCode"

    const-string v6, ""

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->freeShippingCode:Ljava/lang/String;

    .line 377
    :cond_6
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 305
    :cond_7
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 381
    :cond_8
    return-object v2
.end method

.method public setDisplayCertifiedLogo(Z)V
    .locals 0

    .prologue
    .line 83
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->displayCertifiedLogo:Z

    .line 84
    return-void
.end method
