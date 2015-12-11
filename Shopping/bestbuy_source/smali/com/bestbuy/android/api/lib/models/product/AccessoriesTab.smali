.class public Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static TAG:Ljava/lang/String; = null

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private averageRatingScore:D

.field private currentPrice:D

.field private includedItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private pricingType:Ljava/lang/String;

.field private productImage:Ljava/lang/String;

.field private productThumbNailImg:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private ratingTotalCount:D

.field private regularPrice:D

.field private requiredAccessories:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;",
            ">;"
        }
    .end annotation
.end field

.field private savingsAmount:D

.field private shortName:Ljava/lang/String;

.field private sku:Ljava/lang/String;

.field private suggestedAccessories:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->sku:Ljava/lang/String;

    .line 24
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productType:Ljava/lang/String;

    .line 27
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->currentPrice:D

    .line 28
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->pricingType:Ljava/lang/String;

    .line 29
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->regularPrice:D

    .line 30
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->savingsAmount:D

    .line 33
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->averageRatingScore:D

    .line 34
    iput-wide v2, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->ratingTotalCount:D

    .line 37
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->shortName:Ljava/lang/String;

    .line 38
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productImage:Ljava/lang/String;

    .line 39
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productThumbNailImg:Ljava/lang/String;

    return-void
.end method

.method public static getCompleteAccessoriesData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;",
            ">;"
        }
    .end annotation

    .prologue
    .line 154
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 155
    if-eqz p0, :cond_7

    .line 156
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_7

    .line 159
    :try_start_0
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 160
    if-eqz v1, :cond_6

    .line 161
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;-><init>()V

    .line 162
    const-string v4, "names"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 163
    const-string v4, "names"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 164
    const-string v5, "short"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->shortName:Ljava/lang/String;

    .line 167
    :cond_0
    const-string v4, "price"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 168
    const-string v4, "price"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 169
    const-string v5, "currentPrice"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->currentPrice:D

    .line 170
    const-string v5, "pricingType"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->pricingType:Ljava/lang/String;

    .line 171
    const-string v5, "regularPrice"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->regularPrice:D

    .line 172
    const-string v5, "savingsAmount"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->savingsAmount:D

    .line 175
    :cond_1
    const-string v4, "customerRatings"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_3

    .line 176
    const-string v4, "customerRatings"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 177
    const-string v5, "averageRating"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 178
    const-string v5, "averageRating"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 179
    const-string v6, "score"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->averageRatingScore:D

    .line 181
    :cond_2
    const-string v5, "totalCount"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->ratingTotalCount:D

    .line 184
    :cond_3
    const-string v4, "media"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 185
    const-string v4, "media"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 186
    const-string v4, "primaryImage"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 187
    const-string v4, "primaryImage"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 188
    const-string v5, "url"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productImage:Ljava/lang/String;

    .line 190
    :cond_4
    const-string v4, "listImage"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 191
    const-string v4, "listImage"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 192
    const-string v4, "url"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productThumbNailImg:Ljava/lang/String;

    .line 195
    :cond_5
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 156
    :cond_6
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 198
    :catch_0
    move-exception v1

    .line 199
    sget-object v3, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Couldn\'t parse Accessories data:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 203
    :cond_7
    return-object v2
.end method

.method public static loadAccessoriesData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;
    .locals 5

    .prologue
    .line 107
    new-instance v1, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;-><init>()V

    .line 109
    :try_start_0
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 110
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 111
    const-string v2, "productType"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 112
    const-string v2, "productType"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productType:Ljava/lang/String;

    .line 114
    :cond_0
    const-string v2, "includedItems"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 115
    const-string v2, "includedItems"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->loadIncludedItems(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->includedItems:Ljava/util/ArrayList;

    .line 118
    :cond_1
    const-string v2, "requiredAccessories"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 119
    const-string v2, "requiredAccessories"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->getCompleteAccessoriesData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->requiredAccessories:Ljava/util/ArrayList;

    .line 122
    :cond_2
    const-string v2, "suggestedAccessories"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 123
    const-string v2, "suggestedAccessories"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->getCompleteAccessoriesData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->suggestedAccessories:Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 130
    :cond_3
    :goto_0
    return-object v1

    .line 127
    :catch_0
    move-exception v0

    .line 128
    sget-object v2, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Couldn\'t parse accessoriesTab data:"

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

.method public static loadIncludedItems(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 134
    const-string v1, ""

    .line 135
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 136
    if-eqz p0, :cond_1

    .line 137
    const/4 v0, 0x0

    move v7, v0

    move-object v0, v1

    move v1, v7

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 140
    :try_start_0
    invoke-virtual {p0, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 141
    if-eqz v2, :cond_0

    .line 142
    const-string v4, "name"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 147
    :cond_0
    :goto_1
    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 137
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 144
    :catch_0
    move-exception v2

    .line 145
    sget-object v4, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Couldn\'t parse includedItems data: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v2}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 150
    :cond_1
    return-object v3
.end method


# virtual methods
.method public getAverageRatingScore()D
    .locals 2

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->averageRatingScore:D

    return-wide v0
.end method

.method public getCurrentPrice()D
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->currentPrice:D

    return-wide v0
.end method

.method public getIncludedItems()Ljava/util/ArrayList;
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
    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->includedItems:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getPricingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->pricingType:Ljava/lang/String;

    return-object v0
.end method

.method public getProductImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productImage:Ljava/lang/String;

    return-object v0
.end method

.method public getProductThumbNailImg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productThumbNailImg:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getRatingTotalCount()D
    .locals 2

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->ratingTotalCount:D

    return-wide v0
.end method

.method public getRegularPrice()D
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->regularPrice:D

    return-wide v0
.end method

.method public getRequiredAccessories()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;",
            ">;"
        }
    .end annotation

    .prologue
    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->requiredAccessories:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSavingsAmount()D
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->savingsAmount:D

    return-wide v0
.end method

.method public getShortName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->shortName:Ljava/lang/String;

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getSuggestedAccessories()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;",
            ">;"
        }
    .end annotation

    .prologue
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/AccessoriesTab;->suggestedAccessories:Ljava/util/ArrayList;

    return-object v0
.end method
