.class public Lcom/bestbuy/android/api/lib/models/product/PriceBlock;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private advertisedPriceRestriction:Z

.field private buttonStateId:Ljava/lang/String;

.field private clearance:Z

.field private collection:Ljava/lang/String;

.field private contractOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation
.end field

.field private displayName:Ljava/lang/String;

.field private dollarSavings:D

.field private formatOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation
.end field

.field private freeShipping:Z

.field private icr_hidePrice:Z

.field private icr_noPrice:Z

.field private icr_strike:Z

.field private ircEndDate:Ljava/util/Date;

.field private ircStartDate:Ljava/util/Date;

.field private isBundle:Z

.field private isContractProduct:Z

.field private isInActiveSku:Z

.field private lowPriceGuarantee:Z

.field private map:Z

.field private marketPlace:Z

.field private minimumDisplayPrice:D

.field private onSale:Z

.field private onlineOnly:Z

.field private orderable:Ljava/lang/String;

.field private outletCenter:Z

.field private percentSavings:D

.field private planPrice:D

.field private priceUpdateDate:Ljava/util/Date;

.field private priceWithPlan_newTwoYearPlan:D

.field private priceWithPlan_upgradeTwoYearPlan:D

.field private purchasable:Z

.field private refurbished:Z

.field private regularPrice:D

.field private restrictedSalePrice:D

.field private salePrice:D

.field private sellerInfo:Lcom/bestbuy/android/api/lib/models/product/SellerInfo;

.field private skuId:Ljava/lang/String;

.field private smartCapable:Z

.field private url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 99
    const-class v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isInActiveSku:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isContractProduct:Z

    .line 101
    return-void
.end method

.method public static loadCBAPIPriceData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/PriceBlock;
    .locals 6

    .prologue
    const/4 v2, 0x1

    .line 364
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;-><init>()V

    .line 365
    const-string v1, "error"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 366
    iput-boolean v2, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isInActiveSku:Z

    .line 444
    :cond_0
    :goto_0
    return-object v0

    .line 370
    :cond_1
    :try_start_0
    const-string v1, "skuId"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->skuId:Ljava/lang/String;

    .line 371
    const-string v1, "price"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 372
    const-string v1, "buttonState"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 373
    if-eqz v1, :cond_2

    .line 374
    const-string v3, "purchasable"

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->purchasable:Z

    .line 375
    const-string v3, "displayName"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->displayName:Ljava/lang/String;

    .line 376
    const-string v3, "buttonStateID"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->buttonStateId:Ljava/lang/String;

    .line 378
    :cond_2
    const-string v1, "url"

    const-string v3, ""

    invoke-virtual {p0, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->url:Ljava/lang/String;

    .line 379
    const-string v1, "properties"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 380
    if-eqz v1, :cond_4

    .line 381
    const-string v3, "contractCondition"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 382
    const-string v3, "2_YEARS_NEW"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    const-string v3, "2_YEARS_UPGRADE"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 383
    :cond_3
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isContractProduct:Z

    .line 386
    :cond_4
    const-string v1, "attributes"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 387
    if-eqz v1, :cond_5

    .line 388
    const-string v3, "lowPriceGuaranteedProduct"

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->lowPriceGuarantee:Z

    .line 391
    :cond_5
    const-string v1, "condition"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 392
    if-eqz v1, :cond_6

    .line 393
    const-string v3, "refurbished"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 394
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->refurbished:Z

    .line 396
    :cond_6
    const-string v1, "sellerInfo"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 397
    if-eqz v1, :cond_7

    .line 398
    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->getSellerInfo(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/SellerInfo;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->sellerInfo:Lcom/bestbuy/android/api/lib/models/product/SellerInfo;

    .line 400
    :cond_7
    if-eqz v2, :cond_9

    .line 401
    const-string v1, "originalPricingType"

    const-string v3, ""

    invoke-virtual {v2, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 402
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_8

    .line 403
    const-string v1, "pricingType"

    const-string v3, ""

    invoke-virtual {v2, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 404
    :cond_8
    const-string v3, "minimumPriceDisplay"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->minimumDisplayPrice:D

    .line 405
    const-string v3, "currentPrice"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->salePrice:D

    .line 406
    const-string v3, "regularPrice"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->regularPrice:D

    .line 407
    const-string v3, "savingsAmount"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->dollarSavings:D

    .line 408
    const-string v2, "MAP"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 409
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->map:Z

    .line 431
    :cond_9
    :goto_1
    const-string v1, "productOptions"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 432
    const-string v1, "productOptions"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "alternateProducts"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 433
    if-eqz v1, :cond_a

    .line 434
    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->loadAlternateSKUData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->formatOptions:Ljava/util/ArrayList;

    .line 436
    :cond_a
    const-string v1, "productOptions"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "contractOptions"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 437
    if-eqz v1, :cond_0

    .line 438
    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->loadAlternateSKUData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->contractOptions:Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 441
    :catch_0
    move-exception v1

    .line 442
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error Parsing Price Block: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 410
    :cond_b
    :try_start_1
    const-string v2, "onSale"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 411
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->onSale:Z

    goto :goto_1

    .line 412
    :cond_c
    const-string v2, "ICR-noPrice"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 413
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_noPrice:Z

    goto :goto_1

    .line 414
    :cond_d
    const-string v2, "ICR-strikeThrough"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_e

    .line 415
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_strike:Z

    goto :goto_1

    .line 416
    :cond_e
    const-string v2, "ICR-hidePrice"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_f

    .line 417
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_hidePrice:Z

    goto :goto_1

    .line 418
    :cond_f
    const-string v2, "clearance"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_10

    .line 419
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->clearance:Z

    goto/16 :goto_1

    .line 420
    :cond_10
    const-string v2, "bundle"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 421
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isBundle:Z

    goto/16 :goto_1

    .line 423
    :cond_11
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->map:Z

    .line 424
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->onSale:Z

    .line 425
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_noPrice:Z

    .line 426
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_noPrice:Z

    .line 427
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isBundle:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/PriceBlock;
    .locals 6

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 259
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;-><init>()V

    .line 261
    :try_start_0
    const-string v2, "onSale"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->onSale:Z

    .line 262
    const-string v2, "marketplace"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->marketPlace:Z

    .line 263
    const-string v2, "collection"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->collection:Ljava/lang/String;

    .line 264
    const-string v2, "salePrice"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->salePrice:D

    .line 265
    const-string v2, "planPrice"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->planPrice:D

    .line 266
    const-string v2, "restrictedSalePrice"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->restrictedSalePrice:D

    .line 267
    const-string v2, "regularPrice"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->regularPrice:D

    .line 268
    const-string v2, "percentSavings"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->percentSavings:D

    .line 269
    const-string v2, "priceUpdateDate"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 270
    if-eqz v2, :cond_0

    const-string v4, "null"

    invoke-virtual {v2, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_0

    const-string v4, ""

    invoke-virtual {v2, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_0

    .line 271
    sget-object v4, Lgv;->c:Ljava/text/SimpleDateFormat;

    invoke-virtual {v4, v2}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->priceUpdateDate:Ljava/util/Date;

    .line 274
    :cond_0
    const-string v2, "icrStartDate"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 275
    if-eqz v2, :cond_1

    const-string v4, "null"

    invoke-virtual {v2, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_1

    const-string v4, ""

    invoke-virtual {v2, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_1

    .line 276
    sget-object v4, Lgv;->a:Ljava/text/SimpleDateFormat;

    invoke-virtual {v4, v2}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->ircStartDate:Ljava/util/Date;

    .line 278
    :cond_1
    const-string v2, "icrEndDate"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 279
    if-eqz v2, :cond_2

    const-string v4, "null"

    invoke-virtual {v2, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_2

    const-string v4, ""

    invoke-virtual {v2, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_2

    .line 280
    sget-object v4, Lgv;->a:Ljava/text/SimpleDateFormat;

    invoke-virtual {v4, v2}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->ircEndDate:Ljava/util/Date;

    .line 282
    :cond_2
    const-string v2, "dollarSavings"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->dollarSavings:D

    .line 283
    const-string v2, "priceWithPlan"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 284
    if-eqz v2, :cond_3

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-lez v4, :cond_3

    .line 285
    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 286
    const-string v4, "upgradeTwoYearPlan"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->priceWithPlan_upgradeTwoYearPlan:D

    .line 287
    const-string v4, "newTwoYearPlan"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->priceWithPlan_newTwoYearPlan:D

    .line 290
    :cond_3
    const-string v2, "outletCenter"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->outletCenter:Z

    .line 291
    const-string v2, "advertisedPriceRestriction"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->advertisedPriceRestriction:Z

    .line 292
    const-string v2, "orderable"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->orderable:Ljava/lang/String;

    .line 294
    const-string v2, "lowPriceGuarantee"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->lowPriceGuarantee:Z

    .line 295
    const-string v2, "freeShipping"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->freeShipping:Z

    .line 297
    const-string v2, "priceRestriction"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 298
    const-string v2, "icrType"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 299
    const-string v2, "MAP"

    invoke-virtual {v4, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_4

    move v2, v0

    :goto_0
    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->map:Z

    .line 300
    const-string v2, "ICR"

    invoke-virtual {v4, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "ST"

    invoke-virtual {v5, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_5

    move v2, v0

    :goto_1
    iput-boolean v2, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_strike:Z

    .line 301
    const-string v2, "ICR"

    invoke-virtual {v4, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_6

    const-string v2, "NP"

    invoke-virtual {v5, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_6

    :goto_2
    iput-boolean v0, v3, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_noPrice:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 305
    :goto_3
    return-object v3

    :cond_4
    move v2, v1

    .line 299
    goto :goto_0

    :cond_5
    move v2, v1

    .line 300
    goto :goto_1

    :cond_6
    move v0, v1

    .line 301
    goto :goto_2

    .line 302
    :catch_0
    move-exception v0

    .line 303
    sget-object v1, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error Parsing Price Block: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3
.end method

.method public static loadPandaAPIPriceData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/PriceBlock;
    .locals 5

    .prologue
    .line 315
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;-><init>()V

    .line 317
    :try_start_0
    const-string v1, "skuId"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->skuId:Ljava/lang/String;

    .line 318
    const-string v1, "error"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 319
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isInActiveSku:Z

    .line 354
    :goto_0
    return-object v0

    .line 322
    :cond_0
    const-string v1, "originalPricingType"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 323
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 324
    const-string v1, "pricingType"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 325
    :cond_1
    const-string v2, "minimumPriceDisplay"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->minimumDisplayPrice:D

    .line 326
    const-string v2, "currentPrice"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->salePrice:D

    .line 327
    const-string v2, "regularPrice"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->regularPrice:D

    .line 328
    const-string v2, "savingsAmount"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->dollarSavings:D

    .line 329
    const-string v2, "MAP"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 330
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->map:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 351
    :catch_0
    move-exception v1

    .line 352
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error Parsing Price Block: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 331
    :cond_2
    :try_start_1
    const-string v2, "onSale"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 332
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->onSale:Z

    goto :goto_0

    .line 333
    :cond_3
    const-string v2, "ICR-noPrice"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 334
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_noPrice:Z

    goto :goto_0

    .line 335
    :cond_4
    const-string v2, "ICR-strikeThrough"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 336
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_strike:Z

    goto/16 :goto_0

    .line 337
    :cond_5
    const-string v2, "ICR-hidePrice"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 338
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_hidePrice:Z

    goto/16 :goto_0

    .line 339
    :cond_6
    const-string v2, "clearance"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 340
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->clearance:Z

    goto/16 :goto_0

    .line 341
    :cond_7
    const-string v2, "bundle"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 342
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isBundle:Z

    goto/16 :goto_0

    .line 345
    :cond_8
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->map:Z

    .line 346
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->onSale:Z

    .line 347
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_noPrice:Z

    .line 348
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_noPrice:Z

    .line 349
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isBundle:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method


# virtual methods
.method public getButtonStateId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->buttonStateId:Ljava/lang/String;

    return-object v0
.end method

.method public getCollection()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->collection:Ljava/lang/String;

    return-object v0
.end method

.method public getContractOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->contractOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getDollarSavings()D
    .locals 2

    .prologue
    .line 159
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->dollarSavings:D

    return-wide v0
.end method

.method public getFormatOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation

    .prologue
    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->formatOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getIrcEndDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->ircEndDate:Ljava/util/Date;

    return-object v0
.end method

.method public getIrcStartDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->ircStartDate:Ljava/util/Date;

    return-object v0
.end method

.method public getMinimumDisplayPrice()D
    .locals 2

    .prologue
    .line 147
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->minimumDisplayPrice:D

    return-wide v0
.end method

.method public getOrderable()Ljava/lang/String;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->orderable:Ljava/lang/String;

    return-object v0
.end method

.method public getPercentSavings()D
    .locals 2

    .prologue
    .line 139
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->percentSavings:D

    return-wide v0
.end method

.method public getPlanPrice()D
    .locals 2

    .prologue
    .line 127
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->planPrice:D

    return-wide v0
.end method

.method public getPriceUpdateDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->priceUpdateDate:Ljava/util/Date;

    return-object v0
.end method

.method public getPriceWithPlan_newTwoYearPlan()D
    .locals 2

    .prologue
    .line 177
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->priceWithPlan_newTwoYearPlan:D

    return-wide v0
.end method

.method public getPriceWithPlan_upgradeTwoYearPlan()D
    .locals 2

    .prologue
    .line 181
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->priceWithPlan_upgradeTwoYearPlan:D

    return-wide v0
.end method

.method public getRegularPrice()D
    .locals 2

    .prologue
    .line 135
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->regularPrice:D

    return-wide v0
.end method

.method public getRestrictedSalePrice()D
    .locals 2

    .prologue
    .line 131
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->restrictedSalePrice:D

    return-wide v0
.end method

.method public getSalePrice()D
    .locals 2

    .prologue
    .line 123
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->salePrice:D

    return-wide v0
.end method

.method public getSellerInfo()Lcom/bestbuy/android/api/lib/models/product/SellerInfo;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->sellerInfo:Lcom/bestbuy/android/api/lib/models/product/SellerInfo;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isAdvertisedPriceRestriction()Z
    .locals 1

    .prologue
    .line 201
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->advertisedPriceRestriction:Z

    return v0
.end method

.method public isBundle()Z
    .locals 1

    .prologue
    .line 96
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isBundle:Z

    return v0
.end method

.method public isClearance()Z
    .locals 1

    .prologue
    .line 245
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->clearance:Z

    return v0
.end method

.method public isContractProduct()Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isContractProduct:Z

    return v0
.end method

.method public isFreeShipping()Z
    .locals 1

    .prologue
    .line 225
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->freeShipping:Z

    return v0
.end method

.method public isIcr_hidePrice()Z
    .locals 1

    .prologue
    .line 217
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_hidePrice:Z

    return v0
.end method

.method public isIcr_noPrice()Z
    .locals 1

    .prologue
    .line 209
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_noPrice:Z

    return v0
.end method

.method public isIcr_strike()Z
    .locals 1

    .prologue
    .line 213
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->icr_strike:Z

    return v0
.end method

.method public isInActiveSku()Z
    .locals 1

    .prologue
    .line 88
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->isInActiveSku:Z

    return v0
.end method

.method public isLowPriceGuarantee()Z
    .locals 1

    .prologue
    .line 221
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->lowPriceGuarantee:Z

    return v0
.end method

.method public isMap()Z
    .locals 1

    .prologue
    .line 205
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->map:Z

    return v0
.end method

.method public isMarketPlace()Z
    .locals 1

    .prologue
    .line 108
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->marketPlace:Z

    return v0
.end method

.method public isOnSale()Z
    .locals 1

    .prologue
    .line 104
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->onSale:Z

    return v0
.end method

.method public isOnlineOnly()Z
    .locals 1

    .prologue
    .line 237
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->onlineOnly:Z

    return v0
.end method

.method public isOutletCenter()Z
    .locals 1

    .prologue
    .line 197
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->outletCenter:Z

    return v0
.end method

.method public isPurchasable()Z
    .locals 1

    .prologue
    .line 249
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->purchasable:Z

    return v0
.end method

.method public isRefurbished()Z
    .locals 1

    .prologue
    .line 233
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->refurbished:Z

    return v0
.end method

.method public isSmartCapable()Z
    .locals 1

    .prologue
    .line 241
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->smartCapable:Z

    return v0
.end method

.method public setDollarSavings(D)V
    .locals 1

    .prologue
    .line 173
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->dollarSavings:D

    .line 174
    return-void
.end method

.method public setRegularPrice(D)V
    .locals 1

    .prologue
    .line 166
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->regularPrice:D

    .line 167
    return-void
.end method

.method public setSalePrice(D)V
    .locals 1

    .prologue
    .line 115
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/product/PriceBlock;->salePrice:D

    .line 116
    return-void
.end method
