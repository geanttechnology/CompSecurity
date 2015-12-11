.class public Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private displayName:Ljava/lang/String;

.field private percent0To1:D

.field private percent0To100:D

.field private rangeMax:I

.field private score:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 166
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadFeatureRatingData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 199
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 200
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 201
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;-><init>()V

    .line 202
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 203
    if-eqz v3, :cond_0

    .line 204
    const-string v4, "displayName"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->displayName:Ljava/lang/String;

    .line 206
    const-string v4, "percent0To1"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->percent0To1:D

    .line 207
    const-string v4, "percent0To100"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->percent0To100:D

    .line 209
    const-string v4, "rangeMax"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v2, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->rangeMax:I

    .line 210
    const-string v4, "score"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->score:D

    .line 211
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 200
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 214
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getPercent0To1()D
    .locals 2

    .prologue
    .line 182
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->percent0To1:D

    return-wide v0
.end method

.method public getPercent0To100()D
    .locals 2

    .prologue
    .line 186
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->percent0To100:D

    return-wide v0
.end method

.method public getRangeMax()I
    .locals 1

    .prologue
    .line 190
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->rangeMax:I

    return v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 194
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->score:D

    return-wide v0
.end method
