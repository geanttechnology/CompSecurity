.class public Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private accessoriesImage:Ljava/lang/String;

.field private alternateViewsImage:Ljava/lang/String;

.field private angleImage:Ljava/lang/String;

.field private backViewImage:Ljava/lang/String;

.field private carrierLogoImage:Ljava/lang/String;

.field private energyGuideImage:Ljava/lang/String;

.field private galleryImages:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private image:Ljava/lang/String;

.field private largeFrontImage:Ljava/lang/String;

.field private largeImage:Ljava/lang/String;

.field private leftViewImage:Ljava/lang/String;

.field private mediumImage:Ljava/lang/String;

.field private primaryImage:Ljava/lang/String;

.field private remoteControlImage:Ljava/lang/String;

.field private rightViewImage:Ljava/lang/String;

.field private spin360Url:Ljava/lang/String;

.field private thumbnailImage:Ljava/lang/String;

.field private topViewImage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 2149
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2155
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->image:Ljava/lang/String;

    .line 2156
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->thumbnailImage:Ljava/lang/String;

    .line 2157
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->largeImage:Ljava/lang/String;

    .line 2158
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->mediumImage:Ljava/lang/String;

    .line 2159
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->largeFrontImage:Ljava/lang/String;

    .line 2160
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->topViewImage:Ljava/lang/String;

    .line 2161
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->rightViewImage:Ljava/lang/String;

    .line 2162
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->leftViewImage:Ljava/lang/String;

    .line 2163
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->backViewImage:Ljava/lang/String;

    .line 2164
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->angleImage:Ljava/lang/String;

    .line 2165
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->alternateViewsImage:Ljava/lang/String;

    .line 2166
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->accessoriesImage:Ljava/lang/String;

    .line 2167
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->energyGuideImage:Ljava/lang/String;

    .line 2168
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->remoteControlImage:Ljava/lang/String;

    .line 2169
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->spin360Url:Ljava/lang/String;

    .line 2170
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->primaryImage:Ljava/lang/String;

    .line 2171
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->carrierLogoImage:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$302(Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 2149
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->image:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$402(Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 2149
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->primaryImage:Ljava/lang/String;

    return-object p1
.end method

.method public static loadCBAPIImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;
    .locals 10

    .prologue
    const/16 v9, 0x1f4

    .line 2275
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;-><init>()V

    .line 2276
    if-eqz p0, :cond_9

    .line 2277
    const-string v0, "primaryImage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2278
    if-eqz v0, :cond_0

    .line 2279
    const-string v1, "url"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->primaryImage:Ljava/lang/String;

    .line 2280
    :cond_0
    const-string v0, "energyGuideImage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2281
    if-eqz v0, :cond_1

    .line 2282
    const-string v1, "url"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->energyGuideImage:Ljava/lang/String;

    .line 2283
    :cond_1
    const-string v0, "backImage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2284
    if-eqz v0, :cond_2

    .line 2285
    const-string v1, "url"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->backViewImage:Ljava/lang/String;

    .line 2286
    :cond_2
    const-string v0, "galleryImages"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 2287
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->galleryImages:Ljava/util/ArrayList;

    .line 2288
    if-eqz v4, :cond_7

    .line 2289
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_7

    .line 2290
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 2291
    const-string v1, "url"

    const-string v2, ""

    invoke-virtual {v5, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 2292
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 2293
    :cond_3
    const-string v1, "height"

    const-string v2, ""

    invoke-virtual {v5, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 2294
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 2295
    if-le v2, v9, :cond_4

    .line 2296
    const-string v1, "500"

    .line 2297
    :cond_4
    const-string v2, "width"

    const-string v6, ""

    invoke-virtual {v5, v2, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2298
    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    .line 2299
    if-le v6, v9, :cond_5

    .line 2300
    const-string v2, "500"

    .line 2301
    :cond_5
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "http://pisces.bbystatic.com/image2/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "path"

    const-string v8, ""

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ";canvasHeight="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, ";canvasWidth="

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 2305
    :cond_6
    iget-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->galleryImages:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2289
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2308
    :cond_7
    const-string v0, "alternateLogoImage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2309
    if-eqz v0, :cond_8

    .line 2310
    const-string v1, "url"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->alternateViewsImage:Ljava/lang/String;

    .line 2311
    :cond_8
    const-string v0, "carrierLogoImage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2312
    if-eqz v0, :cond_9

    .line 2313
    const-string v1, "url"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->carrierLogoImage:Ljava/lang/String;

    .line 2315
    :cond_9
    return-object v3
.end method

.method public static loadImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;
    .locals 2

    .prologue
    .line 2238
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;-><init>()V

    .line 2239
    const-string v1, "image"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->image:Ljava/lang/String;

    .line 2240
    const-string v1, "thumbnailImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->thumbnailImage:Ljava/lang/String;

    .line 2241
    const-string v1, "largeImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->largeImage:Ljava/lang/String;

    .line 2242
    const-string v1, "mediumImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->mediumImage:Ljava/lang/String;

    .line 2243
    const-string v1, "largeFrontImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->largeFrontImage:Ljava/lang/String;

    .line 2244
    const-string v1, "topViewImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->topViewImage:Ljava/lang/String;

    .line 2245
    const-string v1, "rightViewImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->rightViewImage:Ljava/lang/String;

    .line 2246
    const-string v1, "leftViewImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->leftViewImage:Ljava/lang/String;

    .line 2247
    const-string v1, "backViewImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->backViewImage:Ljava/lang/String;

    .line 2248
    const-string v1, "angleImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->angleImage:Ljava/lang/String;

    .line 2249
    const-string v1, "alternateViewsImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->alternateViewsImage:Ljava/lang/String;

    .line 2250
    const-string v1, "accessoriesImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->accessoriesImage:Ljava/lang/String;

    .line 2251
    const-string v1, "energyGuideImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->energyGuideImage:Ljava/lang/String;

    .line 2252
    const-string v1, "remoteControlImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->remoteControlImage:Ljava/lang/String;

    .line 2253
    const-string v1, "spin360Url"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->spin360Url:Ljava/lang/String;

    .line 2254
    return-object v0
.end method

.method public static loadPandaAPIImageData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;
    .locals 4

    .prologue
    .line 2258
    new-instance v1, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;-><init>()V

    .line 2260
    if-eqz p0, :cond_1

    .line 2261
    :try_start_0
    const-string v0, "primaryImage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2262
    if-eqz v0, :cond_0

    .line 2263
    const-string v2, "url"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->primaryImage:Ljava/lang/String;

    .line 2264
    :cond_0
    const-string v0, "listImage"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2265
    if-eqz v0, :cond_1

    .line 2266
    const-string v2, "url"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->thumbnailImage:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2271
    :cond_1
    :goto_0
    return-object v1

    .line 2268
    :catch_0
    move-exception v0

    .line 2269
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public getAccessoriesImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2208
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->accessoriesImage:Ljava/lang/String;

    return-object v0
.end method

.method public getAlternateViewsImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2205
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->alternateViewsImage:Ljava/lang/String;

    return-object v0
.end method

.method public getAngleImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2202
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->angleImage:Ljava/lang/String;

    return-object v0
.end method

.method public getBackViewImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2199
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->backViewImage:Ljava/lang/String;

    return-object v0
.end method

.method public getCarrierLogoImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2229
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->carrierLogoImage:Ljava/lang/String;

    return-object v0
.end method

.method public getEnergyGuideImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2211
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->energyGuideImage:Ljava/lang/String;

    return-object v0
.end method

.method public getGalleryImages()Ljava/util/ArrayList;
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
    .line 2175
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->galleryImages:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2221
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->image:Ljava/lang/String;

    return-object v0
.end method

.method public getLargeFrontImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2187
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->largeFrontImage:Ljava/lang/String;

    return-object v0
.end method

.method public getLargeImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2181
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->largeImage:Ljava/lang/String;

    return-object v0
.end method

.method public getLeftViewImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2196
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->leftViewImage:Ljava/lang/String;

    return-object v0
.end method

.method public getMediumImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2184
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->mediumImage:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimaryImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2225
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->primaryImage:Ljava/lang/String;

    return-object v0
.end method

.method public getRemoteControlImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2214
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->remoteControlImage:Ljava/lang/String;

    return-object v0
.end method

.method public getRightViewImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2193
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->rightViewImage:Ljava/lang/String;

    return-object v0
.end method

.method public getSpin360Url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2217
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->spin360Url:Ljava/lang/String;

    return-object v0
.end method

.method public getThumbnailImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2178
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->thumbnailImage:Ljava/lang/String;

    return-object v0
.end method

.method public getTopViewImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2190
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->topViewImage:Ljava/lang/String;

    return-object v0
.end method
