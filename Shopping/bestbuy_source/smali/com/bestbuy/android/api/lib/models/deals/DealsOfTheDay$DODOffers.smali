.class public Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private ListImgAltText:Ljava/lang/String;

.field private ListImgURL:Ljava/lang/String;

.field private avgRatingScore:D

.field private bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private brand:Ljava/lang/String;

.field private currentPrice:Ljava/lang/String;

.field private customOfferURL:Ljava/lang/String;

.field private freeShippingCode:Ljava/lang/String;

.field private lid:Ljava/lang/String;

.field private lowPriceGuaranteedProduct:Z

.field private metaDescription:Ljava/lang/String;

.field private metaKeywords:Ljava/lang/String;

.field private metaTitle:Ljava/lang/String;

.field private modelNumber:Ljava/lang/String;

.field private offerImgAltText:Ljava/lang/String;

.field private offerImgURL:Ljava/lang/String;

.field private offerTitle:Ljava/lang/String;

.field private offerType:Ljava/lang/String;

.field private onSale:Z

.field private priceType:Ljava/lang/String;

.field private primaryImgAltText:Ljava/lang/String;

.field private primaryImgURL:Ljava/lang/String;

.field private prodPriceBlock:Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

.field private productCondition:Ljava/lang/String;

.field private productId:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private regularPrice:Ljava/lang/String;

.field private reviewTotalCount:I

.field private savingsAmount:Ljava/lang/String;

.field private shortDescription:Ljava/lang/String;

.field private shortName:Ljava/lang/String;

.field private skuActive:Z

.field private skuId:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadDODoffersArrayData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 243
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 244
    if-eqz p0, :cond_10

    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_10

    move v0, v1

    .line 245
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-gt v0, v3, :cond_10

    .line 246
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 247
    if-eqz v3, :cond_e

    .line 248
    new-instance v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;-><init>()V

    .line 249
    const-string v5, "lid"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->lid:Ljava/lang/String;

    .line 250
    const-string v5, "offerType"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->offerType:Ljava/lang/String;

    .line 251
    const-string v5, "offerTitle"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 252
    const-string v5, "offerTitle"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->offerTitle:Ljava/lang/String;

    .line 253
    :cond_0
    const-string v5, "url"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 254
    const-string v5, "url"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->customOfferURL:Ljava/lang/String;

    .line 255
    :cond_1
    const-string v5, "sku"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_b

    .line 256
    const-string v5, "sku"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 257
    const-string v6, "skuId"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->skuId:Ljava/lang/String;

    .line 258
    const-string v6, "url"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->url:Ljava/lang/String;

    .line 259
    const-string v6, "productId"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->productId:Ljava/lang/String;

    .line 260
    const-string v6, "productType"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->productType:Ljava/lang/String;

    .line 261
    const-string v6, "condition"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->productCondition:Ljava/lang/String;

    .line 262
    const-string v6, "attributes"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 263
    const-string v6, "attributes"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "lowPriceGuaranteedProduct"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v6

    iput-boolean v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->lowPriceGuaranteedProduct:Z

    .line 266
    :cond_2
    const-string v6, "manufacturerId"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 267
    const-string v6, "manufacturerId"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "modelNumber"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->modelNumber:Ljava/lang/String;

    .line 270
    :cond_3
    const-string v6, "media"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_5

    .line 271
    const-string v6, "media"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "primaryImage"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_4

    .line 272
    const-string v6, "media"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "primaryImage"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "url"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->primaryImgURL:Ljava/lang/String;

    .line 273
    const-string v6, "media"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "primaryImage"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "altText"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->primaryImgAltText:Ljava/lang/String;

    .line 275
    :cond_4
    const-string v6, "media"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "listImage"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_5

    .line 276
    const-string v6, "media"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "listImage"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "url"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->ListImgURL:Ljava/lang/String;

    .line 277
    const-string v6, "media"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "listImage"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "altText"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->ListImgAltText:Ljava/lang/String;

    .line 281
    :cond_5
    const-string v6, "meta"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_6

    .line 282
    const-string v6, "meta"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "description"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->metaDescription:Ljava/lang/String;

    .line 283
    const-string v6, "meta"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "keywords"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->metaKeywords:Ljava/lang/String;

    .line 284
    const-string v6, "meta"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "title"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->metaTitle:Ljava/lang/String;

    .line 287
    :cond_6
    const-string v6, "names"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_7

    .line 288
    const-string v6, "names"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "short"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->shortName:Ljava/lang/String;

    .line 291
    :cond_7
    const-string v6, "descriptions"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_8

    .line 292
    const-string v6, "descriptions"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "short"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->shortDescription:Ljava/lang/String;

    .line 295
    :cond_8
    const-string v6, "brand"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_9

    .line 296
    const-string v6, "brand"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "brand"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->brand:Ljava/lang/String;

    .line 299
    :cond_9
    const-string v6, "properties"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_a

    .line 300
    const-string v6, "properties"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "freeShippingCode"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->freeShippingCode:Ljava/lang/String;

    .line 303
    :cond_a
    const-string v6, "customerRatings"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_b

    .line 304
    const-string v6, "customerRatings"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "averageRating"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    if-eqz v6, :cond_f

    .line 305
    const-string v6, "customerRatings"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "averageRating"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "score"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->avgRatingScore:D

    .line 306
    const-string v6, "customerRatings"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "totalCount"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v5

    iput v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->reviewTotalCount:I

    .line 314
    :cond_b
    :goto_1
    const-string v5, "offerImage"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_c

    .line 315
    const-string v5, "offerImage"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "url"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->offerImgURL:Ljava/lang/String;

    .line 316
    const-string v5, "offerImage"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "altText"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->offerImgAltText:Ljava/lang/String;

    .line 319
    :cond_c
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_d

    .line 320
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "currentPrice"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->currentPrice:Ljava/lang/String;

    .line 321
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "onSale"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v5

    iput-boolean v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->onSale:Z

    .line 322
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "priceType"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->priceType:Ljava/lang/String;

    .line 323
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "regularPrice"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->regularPrice:Ljava/lang/String;

    .line 324
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    const-string v5, "savingsAmount"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->savingsAmount:Ljava/lang/String;

    .line 326
    :cond_d
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 245
    :cond_e
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 308
    :cond_f
    const-wide/16 v6, 0x0

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->avgRatingScore:D

    .line 309
    iput v1, v4, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->reviewTotalCount:I

    goto :goto_1

    .line 330
    :cond_10
    return-object v2
.end method


# virtual methods
.method public getAvgRatingScore()D
    .locals 2

    .prologue
    .line 207
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->avgRatingScore:D

    return-wide v0
.end method

.method public getBbyProduct()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    return-object v0
.end method

.method public getBrand()Ljava/lang/String;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->brand:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrentPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->currentPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomOfferURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->customOfferURL:Ljava/lang/String;

    return-object v0
.end method

.method public getFreeShippingCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->freeShippingCode:Ljava/lang/String;

    return-object v0
.end method

.method public getLid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->lid:Ljava/lang/String;

    return-object v0
.end method

.method public getListImgAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->ListImgAltText:Ljava/lang/String;

    return-object v0
.end method

.method public getListImgURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->ListImgURL:Ljava/lang/String;

    return-object v0
.end method

.method public getMetaDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->metaDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getMetaKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->metaKeywords:Ljava/lang/String;

    return-object v0
.end method

.method public getMetaTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->metaTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getModelNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->modelNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferImgAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->offerImgAltText:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferImgURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->offerImgURL:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->offerTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->offerType:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->priceType:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimaryImgAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->primaryImgAltText:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimaryImgURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->primaryImgURL:Ljava/lang/String;

    return-object v0
.end method

.method public getProdPriceBlock()Lcom/bestbuy/android/api/lib/models/product/PriceBlock;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->prodPriceBlock:Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    return-object v0
.end method

.method public getProductCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->productCondition:Ljava/lang/String;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getRegularPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->regularPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getReviewTotalCount()I
    .locals 1

    .prologue
    .line 210
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->reviewTotalCount:I

    return v0
.end method

.method public getSavingsAmount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->savingsAmount:Ljava/lang/String;

    return-object v0
.end method

.method public getShortDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->shortDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getShortName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->shortName:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isLowPriceGuaranteedProduct()Z
    .locals 1

    .prologue
    .line 156
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->lowPriceGuaranteedProduct:Z

    return v0
.end method

.method public isOnSale()Z
    .locals 1

    .prologue
    .line 228
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->onSale:Z

    return v0
.end method

.method public isSkuActive()Z
    .locals 1

    .prologue
    .line 153
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->skuActive:Z

    return v0
.end method

.method public setBbyProduct(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 131
    return-void
.end method

.method public setProdPriceBlock(Lcom/bestbuy/android/api/lib/models/product/PriceBlock;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->prodPriceBlock:Lcom/bestbuy/android/api/lib/models/product/PriceBlock;

    .line 139
    return-void
.end method
