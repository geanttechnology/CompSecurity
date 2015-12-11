.class public Lcom/bestbuy/android/api/lib/models/product/ProductSummary;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private artistName:Ljava/lang/String;

.field private brandLabel:Ljava/lang/String;

.field private brandName:Ljava/lang/String;

.field private chatType:Ljava/lang/String;

.field private condition:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private energyStarCompatible:Z

.field private fileSize:Ljava/lang/String;

.field private format:Ljava/lang/String;

.field private freeShippingCode:Ljava/lang/String;

.field private hasTrailers:Z

.field private id:Ljava/lang/String;

.field private isActive:Z

.field private isContractProduct:Z

.field private itemId:Ljava/lang/String;

.field private keywords:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field private longDescription:Ljava/lang/String;

.field private lowPriceGuaranteedProduct:Z

.field private marketplaceProduct:Z

.field private mediaType:Ljava/lang/String;

.field private metaTitle:Ljava/lang/String;

.field private newProduct:Z

.field private parentalAdvisory:Z

.field private percent0To1:D

.field private percent0To100:I

.field private platform:Ljava/lang/String;

.field private productAvailability:Lcom/bestbuy/android/api/lib/models/product/Availability;

.field private productId:Ljava/lang/String;

.field private productImages:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

.field private productType:Ljava/lang/String;

.field private publisher:Ljava/lang/String;

.field private rangeMax:I

.field private rating:Ljava/lang/String;

.field private ratingDescriptors:Ljava/lang/String;

.field private recommPercent0To1:D

.field private recommPercent0To100:I

.field private score:D

.field private shortDes:Ljava/lang/String;

.field private shortName:Ljava/lang/String;

.field private skuId:Ljava/lang/String;

.field private smartCapable:Z

.field private streetDate:Ljava/lang/String;

.field private synopsis:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private totalRecommendCount:I

.field private vendor:Ljava/lang/String;

.field private wallMountable:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parseProductSummaryData(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/product/ProductSummary;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 239
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 240
    new-instance v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;-><init>()V

    .line 241
    const-string v2, "productId"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->productId:Ljava/lang/String;

    .line 242
    const-string v2, "productType"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->productType:Ljava/lang/String;

    .line 243
    const-string v2, "sku"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->skuId:Ljava/lang/String;

    .line 244
    const-string v2, "active"

    invoke-virtual {v0, v2, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->isActive:Z

    .line 245
    iget-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->condition:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->condition:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 246
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->condition:Ljava/lang/String;

    invoke-virtual {v3, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->condition:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->condition:Ljava/lang/String;

    .line 247
    :cond_0
    const-string v2, "attributes"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 248
    const-string v2, "attributes"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "energyStarCompatible"

    invoke-virtual {v2, v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->energyStarCompatible:Z

    .line 249
    const-string v2, "attributes"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "lowPriceGuaranteedProduct"

    invoke-virtual {v2, v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->lowPriceGuaranteedProduct:Z

    .line 250
    const-string v2, "attributes"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "smartCapable"

    invoke-virtual {v2, v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->smartCapable:Z

    .line 251
    const-string v2, "attributes"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "wallMountable"

    invoke-virtual {v2, v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->wallMountable:Z

    .line 252
    const-string v2, "attributes"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "newProduct"

    invoke-virtual {v2, v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->newProduct:Z

    .line 253
    const-string v2, "attributes"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "marketplaceProduct"

    invoke-virtual {v2, v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->marketplaceProduct:Z

    .line 254
    const-string v2, "attributes"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "parentalAdvisory"

    invoke-virtual {v2, v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->parentalAdvisory:Z

    .line 256
    :cond_1
    const-string v2, "meta"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 257
    const-string v2, "meta"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "description"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->description:Ljava/lang/String;

    .line 258
    const-string v2, "meta"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->title:Ljava/lang/String;

    .line 259
    const-string v2, "meta"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "keywords"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->keywords:Ljava/lang/String;

    .line 261
    :cond_2
    const-string v2, "descriptions"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 262
    const-string v2, "descriptions"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "short"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->shortDes:Ljava/lang/String;

    .line 263
    const-string v2, "descriptions"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "long"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->longDescription:Ljava/lang/String;

    .line 264
    const-string v2, "descriptions"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "synopsis"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->synopsis:Ljava/lang/String;

    .line 266
    :cond_3
    const-string v2, "brand"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 267
    const-string v2, "brand"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "label"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->brandLabel:Ljava/lang/String;

    .line 268
    const-string v2, "brand"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "brand"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->brandName:Ljava/lang/String;

    .line 269
    const-string v2, "brand"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "vendor"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->vendor:Ljava/lang/String;

    .line 270
    const-string v2, "brand"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "publisher"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->publisher:Ljava/lang/String;

    .line 271
    const-string v2, "brand"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "label"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->label:Ljava/lang/String;

    .line 273
    :cond_4
    const-string v2, "properties"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_7

    .line 274
    const-string v2, "properties"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "fileSize"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->fileSize:Ljava/lang/String;

    .line 275
    const-string v2, "properties"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "chatType"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->chatType:Ljava/lang/String;

    .line 276
    const-string v2, "properties"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "format"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->format:Ljava/lang/String;

    .line 277
    const-string v2, "properties"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "freeShippingCode"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->freeShippingCode:Ljava/lang/String;

    .line 278
    const-string v2, "properties"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "contractCondition"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 279
    const-string v3, "2_YEARS_NEW"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    const-string v3, "2_YEARS_UPGRADE"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 280
    :cond_5
    iput-boolean v6, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->isContractProduct:Z

    .line 282
    :cond_6
    const-string v2, "properties"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "primaryArtist"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 283
    const-string v3, "properties"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v3, "mediaType"

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->mediaType:Ljava/lang/String;

    .line 284
    if-eqz v2, :cond_7

    .line 285
    invoke-virtual {v2, v5}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "displayName"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->artistName:Ljava/lang/String;

    .line 288
    :cond_7
    return-object v1
.end method


# virtual methods
.method public getArtistName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->artistName:Ljava/lang/String;

    return-object v0
.end method

.method public getBrandLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->brandLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getBrandName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->brandName:Ljava/lang/String;

    return-object v0
.end method

.method public getChatType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->chatType:Ljava/lang/String;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getFileSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->fileSize:Ljava/lang/String;

    return-object v0
.end method

.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->format:Ljava/lang/String;

    return-object v0
.end method

.method public getFreeShippingCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->freeShippingCode:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->itemId:Ljava/lang/String;

    return-object v0
.end method

.method public getKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->keywords:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getLongDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->longDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->mediaType:Ljava/lang/String;

    return-object v0
.end method

.method public getMetaTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->metaTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getPercent0To1()D
    .locals 2

    .prologue
    .line 166
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->percent0To1:D

    return-wide v0
.end method

.method public getPercent0To100()I
    .locals 1

    .prologue
    .line 169
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->percent0To100:I

    return v0
.end method

.method public getPlatform()Ljava/lang/String;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->platform:Ljava/lang/String;

    return-object v0
.end method

.method public getProductAvailability()Lcom/bestbuy/android/api/lib/models/product/Availability;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->productAvailability:Lcom/bestbuy/android/api/lib/models/product/Availability;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductImages()Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->productImages:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getPublisher()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->publisher:Ljava/lang/String;

    return-object v0
.end method

.method public getRangeMax()I
    .locals 1

    .prologue
    .line 172
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->rangeMax:I

    return v0
.end method

.method public getRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->rating:Ljava/lang/String;

    return-object v0
.end method

.method public getRatingDescriptors()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->ratingDescriptors:Ljava/lang/String;

    return-object v0
.end method

.method public getRecommPercent0To1()D
    .locals 2

    .prologue
    .line 178
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->recommPercent0To1:D

    return-wide v0
.end method

.method public getRecommPercent0To100()I
    .locals 1

    .prologue
    .line 181
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->recommPercent0To100:I

    return v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 175
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->score:D

    return-wide v0
.end method

.method public getShortDes()Ljava/lang/String;
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->shortDes:Ljava/lang/String;

    return-object v0
.end method

.method public getShortName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->shortName:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getStreetDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->streetDate:Ljava/lang/String;

    return-object v0
.end method

.method public getSynopsis()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->synopsis:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalRecommendCount()I
    .locals 1

    .prologue
    .line 184
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->totalRecommendCount:I

    return v0
.end method

.method public getVendor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->vendor:Ljava/lang/String;

    return-object v0
.end method

.method public isActive()Z
    .locals 1

    .prologue
    .line 145
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->isActive:Z

    return v0
.end method

.method public isContractProduct()Z
    .locals 1

    .prologue
    .line 74
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->isContractProduct:Z

    return v0
.end method

.method public isEnergyStarCompatible()Z
    .locals 1

    .prologue
    .line 130
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->energyStarCompatible:Z

    return v0
.end method

.method public isHasTrailers()Z
    .locals 1

    .prologue
    .line 148
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->hasTrailers:Z

    return v0
.end method

.method public isLowPriceGuaranteedProduct()Z
    .locals 1

    .prologue
    .line 151
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->lowPriceGuaranteedProduct:Z

    return v0
.end method

.method public isMarketplaceProduct()Z
    .locals 1

    .prologue
    .line 122
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->marketplaceProduct:Z

    return v0
.end method

.method public isNewProduct()Z
    .locals 1

    .prologue
    .line 118
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->newProduct:Z

    return v0
.end method

.method public isParentalAdvisory()Z
    .locals 1

    .prologue
    .line 126
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->parentalAdvisory:Z

    return v0
.end method

.method public isSmartCapable()Z
    .locals 1

    .prologue
    .line 138
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->smartCapable:Z

    return v0
.end method

.method public isWallMountable()Z
    .locals 1

    .prologue
    .line 134
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductSummary;->wallMountable:Z

    return v0
.end method
