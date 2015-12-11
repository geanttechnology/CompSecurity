.class public Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private availablemostflag:Z

.field private clearancePrice:D

.field private comingsoonflag:Z

.field private currentPrice:D

.field private customerRating:D

.field private distance:D

.field private dnmType:Ljava/lang/String;

.field private documentType:Ljava/lang/String;

.field private expressBuy:Ljava/lang/String;

.field private freeShipping:Z

.field private icrMapPriceValue:Ljava/lang/String;

.field private inStoreAvailMsg:Ljava/lang/String;

.field private instoreavailid:Ljava/lang/String;

.field private instorenaflag:Z

.field private instorenotavailflag:Z

.field private isICRPrice:Z

.field private isICRStrike:Z

.field private largeImageAlternateTag:Ljava/lang/String;

.field private largeImageHeight:D

.field private largeImageURL:Ljava/lang/String;

.field private largeImageWidth:D

.field private listPrice:D

.field private lpn:Ljava/lang/String;

.field private mapFlag:Z

.field private mediumImageAlternateTag:Ljava/lang/String;

.field private msrp:D

.field private noOfStoresItemAvlbl:I

.field private notavailablilityflag:Z

.field private numberOfReviews:Ljava/lang/String;

.field private onSale:Z

.field private onlineOnly:Z

.field private openBoxCondition:Ljava/lang/String;

.field private openBoxDamageLocation:Ljava/lang/String;

.field private openBoxDamageType:Ljava/lang/String;

.field private openBoxMissingAccessories:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private openBoxRegularPrice:D

.field private orderCode:Ljava/lang/String;

.field private preorderflag:Z

.field private priceEvent:Ljava/lang/String;

.field private productId:Ljava/lang/String;

.field private rebateAmt:D

.field private regularPrice:D

.field private saveAmt:D

.field private shipsoldoutflag:Z

.field private shortDescription:Ljava/lang/String;

.field private skuDisplayable:Ljava/lang/String;

.field private skuId:Ljava/lang/String;

.field private skuPermRegPrice:D

.field private skuShortLabel:Ljava/lang/String;

.field private skuTitle:Ljava/lang/String;

.field private skuType:Ljava/lang/String;

.field private skuTypeCode:Ljava/lang/String;

.field private smallImageAlternateTag:Ljava/lang/String;

.field private smallImageHeight:D

.field private smallImageURL:Ljava/lang/String;

.field private smallImageWidth:D

.field private specialOffers:Z

.field private specialOrderFlag:Z

.field private specialOrderHelpText:Ljava/lang/String;

.field private storeAddress1:Ljava/lang/String;

.field private storeAddress2:Ljava/lang/String;

.field private storeCity:Ljava/lang/String;

.field private storeId:Ljava/lang/String;

.field private storeLocation:Ljava/lang/String;

.field private storeMobileSpStoreInd:Ljava/lang/String;

.field private storeName:Ljava/lang/String;

.field private storePhoneNumber:Ljava/lang/String;

.field private storeState:Ljava/lang/String;

.field private storeZipCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static loadDNMProductData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v0, 0x0

    .line 382
    new-instance v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;-><init>()V

    .line 383
    const-string v1, "inStoreAvailMsg"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->inStoreAvailMsg:Ljava/lang/String;

    .line 384
    const-string v1, "lpn"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->lpn:Ljava/lang/String;

    .line 385
    const-string v1, "orderCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->orderCode:Ljava/lang/String;

    .line 386
    const-string v1, "storeMobileSpStoreInd"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeMobileSpStoreInd:Ljava/lang/String;

    .line 387
    const-string v1, "largeImageURL"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->largeImageURL:Ljava/lang/String;

    .line 388
    const-string v1, "skuType"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuType:Ljava/lang/String;

    .line 389
    const-string v1, "skuTypeCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuTypeCode:Ljava/lang/String;

    .line 390
    const-string v1, "storeCity"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeCity:Ljava/lang/String;

    .line 391
    const-string v1, "storeAddress1"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeAddress1:Ljava/lang/String;

    .line 392
    const-string v1, "storeAddress2"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeAddress2:Ljava/lang/String;

    .line 393
    const-string v1, "shortDescription"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->shortDescription:Ljava/lang/String;

    .line 394
    const-string v1, "openBoxDamageType"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxDamageType:Ljava/lang/String;

    .line 395
    const-string v1, "openBoxDamageLocation"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxDamageLocation:Ljava/lang/String;

    .line 396
    const-string v1, "distance"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    int-to-double v4, v1

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->distance:D

    .line 397
    const-string v1, "priceEvent"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->priceEvent:Ljava/lang/String;

    .line 398
    const-string v1, "numberOfReviews"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->numberOfReviews:Ljava/lang/String;

    .line 399
    const-string v1, "skuDisplayable"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuDisplayable:Ljava/lang/String;

    .line 400
    const-string v1, "icrMapPriceValue"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->icrMapPriceValue:Ljava/lang/String;

    .line 401
    const-string v1, "skuTitle"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuTitle:Ljava/lang/String;

    .line 402
    const-string v1, "documentType"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->documentType:Ljava/lang/String;

    .line 403
    const-string v1, "storePhoneNumber"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storePhoneNumber:Ljava/lang/String;

    .line 404
    const-string v1, "openBoxRegularPrice"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxRegularPrice:D

    .line 405
    const-string v1, "skuId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuId:Ljava/lang/String;

    .line 406
    const-string v1, "largeImageAlternateTag"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->largeImageAlternateTag:Ljava/lang/String;

    .line 407
    const-string v1, "smallImageURL"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->smallImageURL:Ljava/lang/String;

    .line 408
    const-string v1, "specialOffers"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->specialOffers:Z

    .line 409
    const-string v1, "specialOrderHelpText"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->specialOrderHelpText:Ljava/lang/String;

    .line 410
    const-string v1, "storeId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeId:Ljava/lang/String;

    .line 411
    const-string v1, "storeState"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeState:Ljava/lang/String;

    .line 412
    const-string v1, "instoreavailid"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->instoreavailid:Ljava/lang/String;

    .line 413
    const-string v1, "dnmType"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->dnmType:Ljava/lang/String;

    .line 414
    const-string v1, "onlineOnly"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->onlineOnly:Z

    .line 415
    const-string v1, "storeZipCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeZipCode:Ljava/lang/String;

    .line 416
    const-string v1, "storeLocation"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeLocation:Ljava/lang/String;

    .line 417
    const-string v1, "skuShortLabel"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuShortLabel:Ljava/lang/String;

    .line 418
    const-string v1, "storeName"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeName:Ljava/lang/String;

    .line 419
    const-string v1, "expressBuy"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->expressBuy:Ljava/lang/String;

    .line 420
    const-string v1, "openBoxCondition"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxCondition:Ljava/lang/String;

    .line 421
    const-string v1, "onSale"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->onSale:Z

    .line 422
    const-string v1, "productId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->productId:Ljava/lang/String;

    .line 423
    const-string v1, "smallImageAlternateTag"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->smallImageAlternateTag:Ljava/lang/String;

    .line 424
    const-string v1, "noOfStoresItemAvlbl"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->noOfStoresItemAvlbl:I

    .line 425
    const-string v1, "openBoxMissingAccessories"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 426
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxMissingAccessories:Ljava/util/ArrayList;

    .line 427
    :goto_0
    const-string v1, "openBoxMissingAccessories"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 429
    :try_start_0
    iget-object v1, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxMissingAccessories:Ljava/util/ArrayList;

    const-string v3, "openBoxMissingAccessories"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 427
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 430
    :catch_0
    move-exception v1

    .line 431
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 435
    :cond_0
    const-string v0, "comingsoonflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    const-string v0, "comingsoonflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 436
    const-string v0, "comingsoonflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->comingsoonflag:Z

    .line 437
    :cond_1
    const-string v0, "instorenaflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    const-string v0, "instorenaflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 438
    const-string v0, "instorenaflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->instorenaflag:Z

    .line 439
    :cond_2
    const-string v0, "shipsoldoutflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    const-string v0, "shipsoldoutflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 440
    const-string v0, "shipsoldoutflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->shipsoldoutflag:Z

    .line 441
    :cond_3
    const-string v0, "notavailablilityflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    const-string v0, "notavailablilityflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 442
    const-string v0, "notavailablilityflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->notavailablilityflag:Z

    .line 443
    :cond_4
    const-string v0, "freeShipping"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    const-string v0, "freeShipping"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 444
    const-string v0, "freeShipping"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->freeShipping:Z

    .line 445
    :cond_5
    const-string v0, "specialOrderFlag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    const-string v0, "specialOrderFlag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_6

    .line 446
    const-string v0, "specialOrderFlag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->specialOrderFlag:Z

    .line 447
    :cond_6
    const-string v0, "availablemostflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    const-string v0, "availablemostflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_7

    .line 448
    const-string v0, "availablemostflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->availablemostflag:Z

    .line 449
    :cond_7
    const-string v0, "instorenotavailflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_8

    const-string v0, "instorenotavailflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_8

    .line 450
    const-string v0, "instorenotavailflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->instorenotavailflag:Z

    .line 451
    :cond_8
    const-string v0, "mapFlag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_9

    const-string v0, "mapFlag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_9

    .line 452
    const-string v0, "mapFlag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->mapFlag:Z

    .line 453
    :cond_9
    const-string v0, "preorderflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_a

    const-string v0, "preorderflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 454
    const-string v0, "preorderflag"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->preorderflag:Z

    .line 455
    :cond_a
    const-string v0, "saveAmt"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_b

    const-string v0, "saveAmt"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    .line 456
    const-string v0, "saveAmt"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->saveAmt:D

    .line 457
    :cond_b
    const-string v0, "clearancePrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_c

    const-string v0, "clearancePrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_c

    .line 458
    const-string v0, "clearancePrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->clearancePrice:D

    .line 459
    :cond_c
    const-string v0, "skuPermRegPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_d

    const-string v0, "skuPermRegPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_d

    .line 460
    const-string v0, "skuPermRegPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuPermRegPrice:D

    .line 461
    :cond_d
    const-string v0, "msrp"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_e

    const-string v0, "msrp"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_e

    .line 462
    const-string v0, "msrp"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->msrp:D

    .line 463
    :cond_e
    const-string v0, "largeImageWidth"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_f

    const-string v0, "largeImageWidth"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_f

    .line 464
    const-string v0, "largeImageWidth"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->largeImageWidth:D

    .line 465
    :cond_f
    const-string v0, "smallImageWidth"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_10

    const-string v0, "smallImageWidth"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_10

    .line 466
    const-string v0, "smallImageWidth"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->smallImageWidth:D

    .line 467
    :cond_10
    const-string v0, "listPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_11

    const-string v0, "listPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_11

    .line 468
    const-string v0, "listPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->listPrice:D

    .line 469
    :cond_11
    const-string v0, "customerRating"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_12

    const-string v0, "customerRating"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_12

    .line 470
    const-string v0, "customerRating"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->customerRating:D

    .line 471
    :cond_12
    const-string v0, "regularPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_13

    const-string v0, "regularPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_13

    .line 472
    const-string v0, "regularPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->regularPrice:D

    .line 473
    :cond_13
    const-string v0, "largeImageHeight"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_14

    const-string v0, "largeImageHeight"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_14

    .line 474
    const-string v0, "largeImageHeight"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->largeImageHeight:D

    .line 475
    :cond_14
    const-string v0, "smallImageHeight"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_15

    const-string v0, "smallImageHeight"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_15

    .line 476
    const-string v0, "smallImageHeight"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->smallImageHeight:D

    .line 477
    :cond_15
    const-string v0, "currentPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_16

    const-string v0, "currentPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_16

    .line 478
    const-string v0, "currentPrice"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->currentPrice:D

    .line 480
    :cond_16
    const-string v0, "icrMapPriceStartDate"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 481
    const-string v1, "icrMapPriceEndDate"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 482
    iget-object v3, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->icrMapPriceValue:Ljava/lang/String;

    const-string v4, "1"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1a

    if-eqz v0, :cond_1a

    if-eqz v1, :cond_1a

    const-string v3, "null"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1a

    const-string v3, "null"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1a

    .line 483
    iput-boolean v6, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRPrice:Z

    .line 487
    :cond_17
    :goto_2
    if-eqz v0, :cond_19

    if-eqz v1, :cond_19

    const-string v3, "null"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_19

    const-string v3, "null"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_19

    .line 488
    new-instance v3, Ljava/text/SimpleDateFormat;

    const-string v4, "yyyy-MM-dd"

    sget-object v5, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v3, v4, v5}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 490
    :try_start_1
    invoke-virtual {v3, v0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 491
    invoke-virtual {v3, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 492
    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    .line 493
    invoke-virtual {v3, v1}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v1

    if-nez v1, :cond_18

    invoke-virtual {v3, v0}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 494
    :cond_18
    const/4 v0, 0x0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRPrice:Z

    .line 495
    const/4 v0, 0x0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRStrike:Z

    .line 496
    const/4 v0, 0x0

    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->mapFlag:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 502
    :cond_19
    :goto_3
    return-object v2

    .line 484
    :cond_1a
    iget-object v3, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->icrMapPriceValue:Ljava/lang/String;

    const-string v4, "2"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_17

    if-eqz v0, :cond_17

    if-eqz v1, :cond_17

    const-string v3, "null"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_17

    const-string v3, "null"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_17

    .line 485
    iput-boolean v6, v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRStrike:Z

    goto :goto_2

    .line 498
    :catch_1
    move-exception v0

    .line 499
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3
.end method

.method public static loadDNMProducts(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 371
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 372
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 373
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 374
    if-eqz v2, :cond_0

    .line 375
    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->loadDNMProductData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 372
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 378
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getClearancePrice()D
    .locals 2

    .prologue
    .line 147
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->clearancePrice:D

    return-wide v0
.end method

.method public getCurrentPrice()D
    .locals 2

    .prologue
    .line 339
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->currentPrice:D

    return-wide v0
.end method

.method public getCustomerRating()D
    .locals 2

    .prologue
    .line 259
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->customerRating:D

    return-wide v0
.end method

.method public getDistance()D
    .locals 2

    .prologue
    .line 183
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->distance:D

    return-wide v0
.end method

.method public getDnmType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 295
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->dnmType:Ljava/lang/String;

    return-object v0
.end method

.method public getDocumentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->documentType:Ljava/lang/String;

    return-object v0
.end method

.method public getExpressBuy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->expressBuy:Ljava/lang/String;

    return-object v0
.end method

.method public getIcrMapPriceValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->icrMapPriceValue:Ljava/lang/String;

    return-object v0
.end method

.method public getInStoreAvailMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->inStoreAvailMsg:Ljava/lang/String;

    return-object v0
.end method

.method public getInstoreavailid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 291
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->instoreavailid:Ljava/lang/String;

    return-object v0
.end method

.method public getLargeImageAlternateTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->largeImageAlternateTag:Ljava/lang/String;

    return-object v0
.end method

.method public getLargeImageHeight()D
    .locals 2

    .prologue
    .line 311
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->largeImageHeight:D

    return-wide v0
.end method

.method public getLargeImageURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->largeImageURL:Ljava/lang/String;

    return-object v0
.end method

.method public getLargeImageWidth()D
    .locals 2

    .prologue
    .line 215
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->largeImageWidth:D

    return-wide v0
.end method

.method public getListPrice()D
    .locals 2

    .prologue
    .line 247
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->listPrice:D

    return-wide v0
.end method

.method public getLpn()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->lpn:Ljava/lang/String;

    return-object v0
.end method

.method public getMediumImageAlternateTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->mediumImageAlternateTag:Ljava/lang/String;

    return-object v0
.end method

.method public getMsrp()D
    .locals 2

    .prologue
    .line 187
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->msrp:D

    return-wide v0
.end method

.method public getNoOfStoresItemAvlbl()I
    .locals 1

    .prologue
    .line 359
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->noOfStoresItemAvlbl:I

    return v0
.end method

.method public getNumberOfReviews()Ljava/lang/String;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->numberOfReviews:Ljava/lang/String;

    return-object v0
.end method

.method public getOpenBoxCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxCondition:Ljava/lang/String;

    return-object v0
.end method

.method public getOpenBoxDamageLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxDamageLocation:Ljava/lang/String;

    return-object v0
.end method

.method public getOpenBoxDamageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxDamageType:Ljava/lang/String;

    return-object v0
.end method

.method public getOpenBoxMissingAccessories()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 239
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxMissingAccessories:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getOpenBoxRegularPrice()D
    .locals 2

    .prologue
    .line 235
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->openBoxRegularPrice:D

    return-wide v0
.end method

.method public getOrderCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->orderCode:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceEvent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->priceEvent:Ljava/lang/String;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 343
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getRebateAmt()D
    .locals 2

    .prologue
    .line 191
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->rebateAmt:D

    return-wide v0
.end method

.method public getRegularPrice()D
    .locals 2

    .prologue
    .line 283
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->regularPrice:D

    return-wide v0
.end method

.method public getSaveAmt()D
    .locals 2

    .prologue
    .line 143
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->saveAmt:D

    return-wide v0
.end method

.method public getShortDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->shortDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuDisplayable()Ljava/lang/String;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuDisplayable:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuPermRegPrice()D
    .locals 2

    .prologue
    .line 163
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuPermRegPrice:D

    return-wide v0
.end method

.method public getSkuShortLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuShortLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuType:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuTypeCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->skuTypeCode:Ljava/lang/String;

    return-object v0
.end method

.method public getSmallImageAlternateTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 355
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->smallImageAlternateTag:Ljava/lang/String;

    return-object v0
.end method

.method public getSmallImageHeight()D
    .locals 2

    .prologue
    .line 319
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->smallImageHeight:D

    return-wide v0
.end method

.method public getSmallImageURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->smallImageURL:Ljava/lang/String;

    return-object v0
.end method

.method public getSmallImageWidth()D
    .locals 2

    .prologue
    .line 243
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->smallImageWidth:D

    return-wide v0
.end method

.method public getSpecialOrderHelpText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->specialOrderHelpText:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreAddress1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeAddress1:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreAddress2()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeAddress2:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeCity:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeId:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 307
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeLocation:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreMobileSpStoreInd()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeMobileSpStoreInd:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 327
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeName:Ljava/lang/String;

    return-object v0
.end method

.method public getStorePhoneNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storePhoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeState:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreZipCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->storeZipCode:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailablemostflag()Z
    .locals 1

    .prologue
    .line 175
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->availablemostflag:Z

    return v0
.end method

.method public isComingsoonflag()Z
    .locals 1

    .prologue
    .line 347
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->comingsoonflag:Z

    return v0
.end method

.method public isFreeShipping()Z
    .locals 1

    .prologue
    .line 227
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->freeShipping:Z

    return v0
.end method

.method public isICRPrice()Z
    .locals 1

    .prologue
    .line 363
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRPrice:Z

    return v0
.end method

.method public isICRStrike()Z
    .locals 1

    .prologue
    .line 367
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRStrike:Z

    return v0
.end method

.method public isInstorenaflag()Z
    .locals 1

    .prologue
    .line 351
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->instorenaflag:Z

    return v0
.end method

.method public isInstorenotavailflag()Z
    .locals 1

    .prologue
    .line 115
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->instorenotavailflag:Z

    return v0
.end method

.method public isMapFlag()Z
    .locals 1

    .prologue
    .line 119
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->mapFlag:Z

    return v0
.end method

.method public isNotavailablilityflag()Z
    .locals 1

    .prologue
    .line 231
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->notavailablilityflag:Z

    return v0
.end method

.method public isOnSale()Z
    .locals 1

    .prologue
    .line 323
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->onSale:Z

    return v0
.end method

.method public isOnlineOnly()Z
    .locals 1

    .prologue
    .line 299
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->onlineOnly:Z

    return v0
.end method

.method public isPreorderflag()Z
    .locals 1

    .prologue
    .line 167
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->preorderflag:Z

    return v0
.end method

.method public isShipsoldoutflag()Z
    .locals 1

    .prologue
    .line 275
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->shipsoldoutflag:Z

    return v0
.end method

.method public isSpecialOffers()Z
    .locals 1

    .prologue
    .line 267
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->specialOffers:Z

    return v0
.end method

.method public isSpecialOrderFlag()Z
    .locals 1

    .prologue
    .line 179
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->specialOrderFlag:Z

    return v0
.end method
