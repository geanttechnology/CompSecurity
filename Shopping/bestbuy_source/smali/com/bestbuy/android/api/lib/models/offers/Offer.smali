.class public Lcom/bestbuy/android/api/lib/models/offers/Offer;
.super Lcom/bestbuy/android/api/lib/models/product/Product;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final CATEGORY_PATH_KEYS:Ljava/lang/String; = "category_path_keys"

.field public static final CHANNEL_KEYS:Ljava/lang/String; = "channel_keys"

.field public static final END_DATE:Ljava/lang/String; = "end"

.field public static final GAMING_CHANNEL:Ljava/lang/String; = "bby-mobile-game-tradein"

.field public static final IMAGE_URL:Ljava/lang/String; = "image_url"

.field public static final KEY:Ljava/lang/String; = "key"

.field public static final REMIX_DATA:Ljava/lang/String; = "remix_data"

.field private static final TAG:Ljava/lang/String;

.field private static final serialVersionUID:J = 0x67bc3d213e4a3ff1L


# instance fields
.field private beginDate:Ljava/util/Date;

.field private categoryId:Ljava/lang/String;

.field private categoryPathKeys:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private channelKeys:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private couponCode:Ljava/lang/String;

.field private couponSkus:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private created:Ljava/util/Date;

.field private endDate:Ljava/util/Date;

.field private imageUrl:Ljava/lang/String;

.field private inStoreOnly:Z

.field private insertPageNumber:D

.field private key:Ljava/lang/String;

.field private legal:Ljava/lang/String;

.field private legalCopy:Ljava/lang/String;

.field private localImageUrl:I

.field private manufacturer:Ljava/lang/String;

.field private marketingCopy:Ljava/lang/String;

.field private modified:Ljava/lang/String;

.field private offersDescription:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private priority:D

.field private productKey:Ljava/lang/String;

.field private promoSlot:Ljava/lang/String;

.field private regularPrice:Ljava/lang/String;

.field private remixDataString:Ljava/lang/String;

.field private rzLevels:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private searchFacet:Ljava/lang/String;

.field private shortMarketingCopy:Ljava/lang/String;

.field private skus:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private title:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 190
    invoke-direct {p0}, Lcom/bestbuy/android/api/lib/models/product/Product;-><init>()V

    .line 71
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->productKey:Ljava/lang/String;

    .line 191
    return-void
.end method

.method public static loadData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 202
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 203
    if-eqz p0, :cond_2

    move v0, v1

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-lez v4, :cond_3

    :goto_1
    and-int/2addr v0, v1

    if-eqz v0, :cond_5

    move v0, v2

    .line 204
    :goto_2
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_5

    .line 206
    :try_start_0
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 207
    new-instance v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-direct {v5}, Lcom/bestbuy/android/api/lib/models/offers/Offer;-><init>()V

    .line 209
    const-string v1, "in_store_only"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->inStoreOnly:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 212
    :try_start_1
    const-string v1, "begin"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 213
    if-eqz v1, :cond_0

    const-string v6, ""

    invoke-virtual {v1, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v6

    if-eqz v6, :cond_0

    .line 214
    sget-object v6, Lgv;->a:Ljava/text/SimpleDateFormat;

    invoke-virtual {v6, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->beginDate:Ljava/util/Date;

    .line 217
    :cond_0
    const-string v1, "end"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 218
    if-eqz v1, :cond_1

    const-string v6, ""

    invoke-virtual {v1, v6}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v6

    if-eqz v6, :cond_1

    .line 219
    sget-object v6, Lgv;->a:Ljava/text/SimpleDateFormat;

    invoke-virtual {v6, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->endDate:Ljava/util/Date;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 228
    :cond_1
    :goto_3
    :try_start_2
    const-string v1, "title"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->title:Ljava/lang/String;

    .line 230
    const-string v1, "skus"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 231
    if-eqz v6, :cond_4

    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_4

    .line 232
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->skus:Ljava/util/ArrayList;

    move v1, v2

    .line 233
    :goto_4
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v7

    if-ge v1, v7, :cond_4

    .line 234
    iget-object v7, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->skus:Ljava/util/ArrayList;

    invoke-virtual {v6, v1}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 233
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_2
    move v0, v2

    .line 203
    goto/16 :goto_0

    :cond_3
    move v1, v2

    goto/16 :goto_1

    .line 222
    :catch_0
    move-exception v1

    .line 223
    sget-object v6, Lcom/bestbuy/android/api/lib/models/offers/Offer;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Could not parse date fields: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v6, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_3

    .line 247
    :catch_1
    move-exception v1

    .line 248
    sget-object v4, Lcom/bestbuy/android/api/lib/models/offers/Offer;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Error parsing Offer, skipping offer: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 204
    :goto_5
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_2

    .line 238
    :cond_4
    :try_start_3
    const-string v1, "key"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->key:Ljava/lang/String;

    .line 239
    const-string v1, "manufacturer"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->manufacturer:Ljava/lang/String;

    .line 240
    const-string v1, "image_url"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->imageUrl:Ljava/lang/String;

    .line 241
    const-string v1, "promo_slot"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->promoSlot:Ljava/lang/String;

    .line 242
    const-string v1, "priority"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->priority:D

    .line 243
    const-string v1, "search_facet"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->searchFacet:Ljava/lang/String;

    .line 244
    const-string v1, "category_id"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/offers/Offer;->categoryId:Ljava/lang/String;

    .line 246
    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_5

    .line 255
    :cond_5
    return-object v3
.end method

.method public static loadOffersData(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 259
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 260
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 261
    const-string v3, "data"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 262
    const-string v3, "offers"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 264
    if-eqz v5, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-lez v3, :cond_1

    :goto_1
    and-int/2addr v0, v1

    if-eqz v0, :cond_a

    move v1, v2

    .line 265
    :goto_2
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_a

    .line 266
    invoke-virtual {v5, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 267
    new-instance v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    invoke-direct {v7}, Lcom/bestbuy/android/api/lib/models/offers/Offer;-><init>()V

    .line 268
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->skus:Ljava/util/ArrayList;

    .line 269
    const-string v0, "skus"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    move v0, v2

    .line 270
    :goto_3
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v0, v8, :cond_2

    .line 271
    iget-object v8, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->skus:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 270
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_0
    move v0, v2

    .line 264
    goto :goto_0

    :cond_1
    move v1, v2

    goto :goto_1

    .line 274
    :cond_2
    const-string v0, "category_path_keys"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v8

    .line 275
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->categoryPathKeys:Ljava/util/ArrayList;

    .line 276
    if-eqz v8, :cond_3

    move v3, v2

    .line 277
    :goto_4
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v3, v0, :cond_3

    .line 278
    iget-object v9, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->categoryPathKeys:Ljava/util/ArrayList;

    invoke-virtual {v8, v1}, Lorg/json/JSONArray;->opt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 277
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_4

    .line 282
    :cond_3
    const-string v0, "channel_keys"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v8

    .line 283
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->channelKeys:Ljava/util/ArrayList;

    .line 284
    if-eqz v8, :cond_4

    move v3, v2

    .line 285
    :goto_5
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v3, v0, :cond_4

    .line 286
    iget-object v9, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->channelKeys:Ljava/util/ArrayList;

    invoke-virtual {v8, v1}, Lorg/json/JSONArray;->opt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 285
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_5

    .line 290
    :cond_4
    const-string v0, "remix_data"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 291
    if-eqz v0, :cond_6

    .line 292
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->remixDataString:Ljava/lang/String;

    .line 293
    new-instance v3, Lorg/json/JSONObject;

    iget-object v8, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->remixDataString:Ljava/lang/String;

    invoke-direct {v3, v8}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->loadBBYOpenData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product;

    .line 294
    iget-object v3, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->skus:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-nez v3, :cond_5

    .line 296
    iget-object v3, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->skus:Ljava/util/ArrayList;

    const-string v8, "sku"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 298
    :cond_5
    const-string v3, "customerReviewAverage"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v8

    iput-wide v8, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->customerReviewAverage:D

    .line 302
    :cond_6
    invoke-static {v6}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->loadImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    .line 303
    const-string v0, "image_url"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->imageUrl:Ljava/lang/String;

    .line 304
    const-string v0, "key"

    const-string v3, ""

    invoke-virtual {v6, v0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->productKey:Ljava/lang/String;

    .line 305
    const-string v0, "title"

    const-string v3, "No title for this offer."

    invoke-virtual {v6, v0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->title:Ljava/lang/String;

    .line 306
    const-string v0, "url"

    const-string v3, "null"

    invoke-virtual {v6, v0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->url:Ljava/lang/String;

    .line 307
    iget-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->title:Ljava/lang/String;

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->replaceXMLCharacters(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->title:Ljava/lang/String;

    .line 308
    const-string v0, "price"

    const-string v3, "0.0"

    invoke-virtual {v6, v0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->price:Ljava/lang/String;

    .line 310
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v3, "yyyy-MM-dd"

    sget-object v8, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v3, v8}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 312
    const-string v3, "end"

    invoke-virtual {v6, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 313
    const-string v8, ""

    invoke-virtual {v3, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_7

    .line 314
    invoke-virtual {v0, v3}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->endDate:Ljava/util/Date;

    .line 317
    :cond_7
    iget-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->price:Ljava/lang/String;

    const-string v3, "null"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 318
    const-string v0, "0.0"

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->price:Ljava/lang/String;

    .line 321
    :cond_8
    const-string v0, "rz_levels"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 322
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->rzLevels:Ljava/util/ArrayList;

    .line 323
    if-eqz v3, :cond_9

    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_9

    move v0, v2

    .line 324
    :goto_6
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-ge v0, v6, :cond_9

    .line 325
    iget-object v6, v7, Lcom/bestbuy/android/api/lib/models/offers/Offer;->rzLevels:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 324
    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    .line 328
    :cond_9
    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 265
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_2

    .line 331
    :cond_a
    return-object v4
.end method

.method public static replaceXMLCharacters(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 335
    if-eqz p0, :cond_0

    .line 336
    invoke-static {p0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    .line 338
    :cond_0
    return-object p0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 350
    if-nez p1, :cond_1

    .line 363
    :cond_0
    :goto_0
    return v0

    .line 352
    :cond_1
    if-ne p1, p0, :cond_2

    move v0, v1

    .line 353
    goto :goto_0

    .line 354
    :cond_2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_0

    .line 357
    check-cast p1, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    .line 358
    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->title:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 359
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->hashCode()I

    move-result v2

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->hashCode()I

    move-result v3

    if-ne v2, v3, :cond_0

    move v0, v1

    .line 360
    goto :goto_0
.end method

.method public getBeginDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->beginDate:Ljava/util/Date;

    return-object v0
.end method

.method public getCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->categoryId:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryPathKeys()Ljava/util/ArrayList;
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
    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->categoryPathKeys:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getChannelKeys()Ljava/util/ArrayList;
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
    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->channelKeys:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCouponCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->couponCode:Ljava/lang/String;

    return-object v0
.end method

.method public getCouponSkus()Ljava/util/ArrayList;
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
    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->couponSkus:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCreated()Ljava/util/Date;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->created:Ljava/util/Date;

    return-object v0
.end method

.method public getEndDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->endDate:Ljava/util/Date;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getInsertPageNumber()D
    .locals 2

    .prologue
    .line 100
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->insertPageNumber:D

    return-wide v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getLegal()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->legal:Ljava/lang/String;

    return-object v0
.end method

.method public getLegalCopy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->legalCopy:Ljava/lang/String;

    return-object v0
.end method

.method public getLocalImageUrl()I
    .locals 1

    .prologue
    .line 367
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->localImageUrl:I

    return v0
.end method

.method public getManufacturer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->manufacturer:Ljava/lang/String;

    return-object v0
.end method

.method public getMarketingCopy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->marketingCopy:Ljava/lang/String;

    return-object v0
.end method

.method public getModified()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->modified:Ljava/lang/String;

    return-object v0
.end method

.method public getOffersDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->offersDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getOffersMarketingCopy()Ljava/lang/String;
    .locals 4

    .prologue
    const/16 v3, 0xc8

    .line 342
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->marketingCopy:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    .line 343
    if-le v0, v3, :cond_0

    .line 344
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->marketingCopy:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "..."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 346
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->marketingCopy:Ljava/lang/String;

    goto :goto_0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getPriority()D
    .locals 2

    .prologue
    .line 124
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->priority:D

    return-wide v0
.end method

.method public getPromoSlot()Ljava/lang/String;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->promoSlot:Ljava/lang/String;

    return-object v0
.end method

.method public getRegularPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->regularPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getRzLevels()Ljava/util/ArrayList;
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
    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->rzLevels:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSearchFacet()Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->searchFacet:Ljava/lang/String;

    return-object v0
.end method

.method public getShortMarketingCopy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->shortMarketingCopy:Ljava/lang/String;

    return-object v0
.end method

.method public getSkus()Ljava/util/ArrayList;
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
    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->skus:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->url:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 376
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public isInStoreOnly()Z
    .locals 1

    .prologue
    .line 148
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->inStoreOnly:Z

    return v0
.end method

.method public setLocalImageUrl(I)V
    .locals 0

    .prologue
    .line 371
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/offers/Offer;->localImageUrl:I

    .line 372
    return-void
.end method
