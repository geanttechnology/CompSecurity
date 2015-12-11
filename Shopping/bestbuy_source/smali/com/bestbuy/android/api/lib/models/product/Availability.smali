.class public Lcom/bestbuy/android/api/lib/models/product/Availability;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private availabilityForPickup:Z

.field private availableToDeliver:Z

.field private availableToDownload:Z

.field private availableToShip:Z

.field private checkStoresLink:Ljava/lang/String;

.field private deliveryDisplayMessage:Ljava/lang/String;

.field private deliveryURL:Ljava/lang/String;

.field private downloadDisplayMessage:Ljava/lang/String;

.field private energyStarCompatible:Z

.field private height:I

.field private inStoreAvailabilityUpdateDate:Ljava/lang/String;

.field private inStoreOnly:Z

.field private inStoreOnlyOption:Z

.field private isDeliveryAnOption:Z

.field private isDownloadAnOption:Z

.field private isPickupAnOption:Z

.field private isPickupJsonFound:Z

.field private isShipAnOption:Z

.field private longStoreName:Ljava/lang/String;

.field private lowPriceGuaranteedProduct:Z

.field private pickupDisplayMessage:Ljava/lang/String;

.field private pickupMessage:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private seller:Ljava/lang/String;

.field private shipDisplayMessage:Ljava/lang/String;

.field private shippingUrl:Ljava/lang/String;

.field private shortName:Ljava/lang/String;

.field private signatureRequired:Z

.field private sku:Ljava/lang/String;

.field private smartCapable:Z

.field private specialOrderDelivery:Z

.field private storeName:Ljava/lang/String;

.field private target:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private wallMountable:Z

.field private width:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->seller:Ljava/lang/String;

    .line 29
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->productType:Ljava/lang/String;

    .line 30
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->shortName:Ljava/lang/String;

    .line 31
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->sku:Ljava/lang/String;

    .line 32
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->url:Ljava/lang/String;

    .line 35
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isPickupAnOption:Z

    .line 36
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->availabilityForPickup:Z

    .line 37
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupMessage:Ljava/lang/String;

    .line 38
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->storeName:Ljava/lang/String;

    .line 39
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->checkStoresLink:Ljava/lang/String;

    .line 40
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupDisplayMessage:Ljava/lang/String;

    .line 41
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->longStoreName:Ljava/lang/String;

    .line 42
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreAvailabilityUpdateDate:Ljava/lang/String;

    .line 43
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isPickupJsonFound:Z

    .line 47
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreOnlyOption:Z

    .line 50
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isShipAnOption:Z

    .line 51
    iput v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->width:I

    .line 52
    iput v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->height:I

    .line 53
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->target:Ljava/lang/String;

    .line 54
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->shippingUrl:Ljava/lang/String;

    .line 55
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToShip:Z

    .line 56
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    .line 57
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->signatureRequired:Z

    .line 60
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isDeliveryAnOption:Z

    .line 61
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->deliveryURL:Ljava/lang/String;

    .line 62
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToDeliver:Z

    .line 63
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->deliveryDisplayMessage:Ljava/lang/String;

    .line 66
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isDownloadAnOption:Z

    .line 67
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToDownload:Z

    .line 68
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->downloadDisplayMessage:Ljava/lang/String;

    .line 71
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->wallMountable:Z

    .line 72
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->lowPriceGuaranteedProduct:Z

    .line 73
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->smartCapable:Z

    .line 74
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->energyStarCompatible:Z

    .line 75
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->specialOrderDelivery:Z

    .line 76
    iput-boolean v1, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreOnly:Z

    return-void
.end method

.method public static loadAvailabilityData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Availability;
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 317
    new-instance v1, Lcom/bestbuy/android/api/lib/models/product/Availability;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/product/Availability;-><init>()V

    .line 318
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_e

    .line 319
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 320
    const-string v0, "productType"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->productType:Ljava/lang/String;

    .line 321
    const-string v0, "skuId"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->sku:Ljava/lang/String;

    .line 323
    const-string v0, "availability"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 324
    const-string v0, "availability"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 326
    const-string v0, "pickup"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_f

    .line 327
    iput-boolean v7, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->isPickupAnOption:Z

    .line 328
    const-string v0, "pickup"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 329
    const-string v4, "available"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->availabilityForPickup:Z

    .line 330
    const-string v4, "displayMessage"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupDisplayMessage:Ljava/lang/String;

    .line 331
    iget-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupDisplayMessage:Ljava/lang/String;

    const-string v5, "<b>Store Pickup:</b>"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 332
    iget-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupDisplayMessage:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupDisplayMessage:Ljava/lang/String;

    .line 334
    :cond_0
    const-string v4, "checkStoresLink"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 335
    const-string v4, "checkStoresLink"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 336
    const-string v5, "url"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->url:Ljava/lang/String;

    .line 338
    :cond_1
    const-string v4, "inStoreAvailability"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 339
    const-string v4, "inStoreAvailability"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 340
    const-string v4, "pickupMessage"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupMessage:Ljava/lang/String;

    .line 341
    const-string v4, "storeName"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->storeName:Ljava/lang/String;

    .line 346
    :cond_2
    :goto_0
    const-string v0, "inStoreOnly"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 347
    iput-boolean v7, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreOnlyOption:Z

    .line 348
    const-string v0, "inStoreOnly"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 349
    const-string v4, "available"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreOnlyOption:Z

    .line 350
    const-string v4, "pickup"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 351
    if-eqz v4, :cond_3

    .line 352
    const-string v5, "available"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->availabilityForPickup:Z

    .line 353
    :cond_3
    const-string v4, "checkStoresLink"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 354
    const-string v4, "checkStoresLink"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 355
    const-string v5, "url"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->url:Ljava/lang/String;

    .line 357
    :cond_4
    const-string v4, "inStoreAvailability"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 358
    const-string v4, "inStoreAvailability"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 359
    const-string v4, "pickupMessage"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupMessage:Ljava/lang/String;

    .line 360
    const-string v4, "storeName"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->storeName:Ljava/lang/String;

    .line 364
    :cond_5
    const-string v0, "ship"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 365
    iput-boolean v7, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->isShipAnOption:Z

    .line 366
    const-string v0, "ship"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 367
    const-string v4, "checkLink"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_6

    .line 368
    const-string v4, "checkLink"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 369
    const-string v5, "width"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v5

    iput v5, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->width:I

    .line 370
    const-string v5, "height"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v5

    iput v5, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->height:I

    .line 371
    const-string v5, "target"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->target:Ljava/lang/String;

    .line 372
    const-string v5, "url"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shippingUrl:Ljava/lang/String;

    .line 374
    :cond_6
    const-string v4, "available"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToShip:Z

    .line 375
    const-string v4, "signatureRequired"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->signatureRequired:Z

    .line 376
    const-string v4, "displayMessage"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    .line 377
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_7

    .line 378
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    const-string v4, "<b>Shipping:</b> "

    invoke-virtual {v0, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 379
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    const-string v4, "<b>Shipping:</b> "

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    .line 389
    :cond_7
    :goto_1
    const-string v0, "stores"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_8

    .line 390
    const-string v0, "stores"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 391
    invoke-virtual {v0, v6}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Lorg/json/JSONObject;

    if-eqz v4, :cond_8

    .line 392
    invoke-virtual {v0, v6}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    .line 393
    const-string v4, "longName"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->longStoreName:Ljava/lang/String;

    .line 394
    const-string v4, "products"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 395
    invoke-virtual {v0, v6}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Lorg/json/JSONObject;

    if-eqz v4, :cond_8

    .line 396
    invoke-virtual {v0, v6}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    .line 397
    const-string v4, "inStoreAvailabilityUpdateDate"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreAvailabilityUpdateDate:Ljava/lang/String;

    .line 402
    :cond_8
    const-string v0, "delivery"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_a

    .line 403
    iput-boolean v7, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->isDeliveryAnOption:Z

    .line 404
    const-string v0, "delivery"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 405
    const-string v4, "checkLink"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_9

    .line 406
    const-string v4, "checkLink"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "url"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->deliveryURL:Ljava/lang/String;

    .line 408
    :cond_9
    const-string v4, "available"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToDeliver:Z

    .line 409
    const-string v4, "displayMessage"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->deliveryDisplayMessage:Ljava/lang/String;

    .line 412
    :cond_a
    const-string v0, "download"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 413
    iput-boolean v7, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->isDownloadAnOption:Z

    .line 414
    const-string v0, "download"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 415
    const-string v3, "available"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToDownload:Z

    .line 416
    const-string v3, "displayMessage"

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->downloadDisplayMessage:Ljava/lang/String;

    .line 417
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->downloadDisplayMessage:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    .line 418
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->downloadDisplayMessage:Ljava/lang/String;

    const-string v3, "<b>Download:</b> "

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->downloadDisplayMessage:Ljava/lang/String;

    .line 422
    :cond_b
    const-string v0, "names"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_c

    .line 423
    const-string v0, "short"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shortName:Ljava/lang/String;

    .line 426
    :cond_c
    const-string v0, "sellerInfo"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_d

    .line 427
    const-string v0, "seller"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->seller:Ljava/lang/String;

    .line 430
    :cond_d
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_e

    .line 431
    const-string v0, "attributes"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 432
    const-string v2, "wallMountable"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->wallMountable:Z

    .line 433
    const-string v2, "lowPriceGuaranteedProduct"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->lowPriceGuaranteedProduct:Z

    .line 434
    const-string v2, "smartCapable"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->smartCapable:Z

    .line 435
    const-string v2, "energyStarCompatible"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->energyStarCompatible:Z

    .line 436
    const-string v2, "specialOrderDelivery"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->specialOrderDelivery:Z

    .line 439
    :cond_e
    return-object v1

    .line 344
    :cond_f
    iput-boolean v6, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->isPickupJsonFound:Z

    goto/16 :goto_0

    .line 380
    :cond_10
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    const-string v4, "<b>Shipping</b>: "

    invoke-virtual {v0, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 381
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    const-string v4, "<b>Shipping</b>: "

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    goto/16 :goto_1

    .line 383
    :cond_11
    iget-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    const-string v4, "Shipping:"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    goto/16 :goto_1
.end method


# virtual methods
.method public getCheckStoresLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->checkStoresLink:Ljava/lang/String;

    return-object v0
.end method

.method public getDeliveryDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->deliveryDisplayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getDeliveryURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->deliveryURL:Ljava/lang/String;

    return-object v0
.end method

.method public getDownloadDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->downloadDisplayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 186
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->height:I

    return v0
.end method

.method public getInStoreAvailabilityUpdateDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreAvailabilityUpdateDate:Ljava/lang/String;

    return-object v0
.end method

.method public getLongStoreName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->longStoreName:Ljava/lang/String;

    return-object v0
.end method

.method public getPickupDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupDisplayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getPickupMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->pickupMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getSeller()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->seller:Ljava/lang/String;

    return-object v0
.end method

.method public getShipDisplayMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->shipDisplayMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->shippingUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getShortName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->shortName:Ljava/lang/String;

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->storeName:Ljava/lang/String;

    return-object v0
.end method

.method public getTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->target:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 179
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->width:I

    return v0
.end method

.method public isAvailabilityForPickup()Z
    .locals 1

    .prologue
    .line 125
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->availabilityForPickup:Z

    return v0
.end method

.method public isAvailableToDeliver()Z
    .locals 1

    .prologue
    .line 228
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToDeliver:Z

    return v0
.end method

.method public isAvailableToDownload()Z
    .locals 1

    .prologue
    .line 242
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToDownload:Z

    return v0
.end method

.method public isAvailableToShip()Z
    .locals 1

    .prologue
    .line 207
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->availableToShip:Z

    return v0
.end method

.method public isDeliveryAnOption()Z
    .locals 1

    .prologue
    .line 292
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isDeliveryAnOption:Z

    return v0
.end method

.method public isDownloadAnOption()Z
    .locals 1

    .prologue
    .line 299
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isDownloadAnOption:Z

    return v0
.end method

.method public isEnergyStarCompatible()Z
    .locals 1

    .prologue
    .line 277
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->energyStarCompatible:Z

    return v0
.end method

.method public isInStoreOnly()Z
    .locals 1

    .prologue
    .line 87
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreOnly:Z

    return v0
.end method

.method public isInStoreOnlyOption()Z
    .locals 1

    .prologue
    .line 83
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->inStoreOnlyOption:Z

    return v0
.end method

.method public isLowPriceGuaranteedProduct()Z
    .locals 1

    .prologue
    .line 263
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->lowPriceGuaranteedProduct:Z

    return v0
.end method

.method public isPickupAnOption()Z
    .locals 1

    .prologue
    .line 306
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isPickupAnOption:Z

    return v0
.end method

.method public isPickupJsonFound()Z
    .locals 1

    .prologue
    .line 129
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isPickupJsonFound:Z

    return v0
.end method

.method public isShipAnOption()Z
    .locals 1

    .prologue
    .line 313
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->isShipAnOption:Z

    return v0
.end method

.method public isSignatureRequired()Z
    .locals 1

    .prologue
    .line 79
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->signatureRequired:Z

    return v0
.end method

.method public isSmartCapable()Z
    .locals 1

    .prologue
    .line 270
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->smartCapable:Z

    return v0
.end method

.method public isSpecialOrderDelivery()Z
    .locals 1

    .prologue
    .line 284
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->specialOrderDelivery:Z

    return v0
.end method

.method public isWallMountable()Z
    .locals 1

    .prologue
    .line 256
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/Availability;->wallMountable:Z

    return v0
.end method
