.class public Lcom/bestbuy/android/api/lib/models/product/Review;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static featureRatings:Ljava/util/ArrayList; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;",
            ">;"
        }
    .end annotation
.end field

.field private static manufacturer:Ljava/lang/String; = null

.field private static mfgAvgRatingPercent0To1:D = 0.0

.field private static mfgAvgRatingPercent0To100:D = 0.0

.field private static mfgAvgRatingRangeMax:I = 0x0

.field private static mfgAvgRatingScore:D = 0.0

.field private static mfgAvgRatingTotalCount:I = 0x0

.field private static percent0To1:D = 0.0

.field private static percent0To100:I = 0x0

.field private static rangeMax:I = 0x0

.field private static recommendPercent0To1:D = 0.0

.field private static recommendPercent0To100:D = 0.0

.field private static recommendTotalCount:I = 0x0

.field private static score:D = 0.0

.field private static final serialVersionUID:J = 0x1L

.field private static starRatingBreakdowns:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;",
            ">;"
        }
    .end annotation
.end field

.field private static totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 166
    return-void
.end method

.method public static loadReviewData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Review;
    .locals 4

    .prologue
    .line 98
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Review;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/product/Review;-><init>()V

    .line 99
    const-string v1, "averageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 100
    const-string v1, "averageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "percent0To1"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    sput-wide v2, Lcom/bestbuy/android/api/lib/models/product/Review;->percent0To1:D

    .line 101
    const-string v1, "averageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "percent0To100"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    sput v1, Lcom/bestbuy/android/api/lib/models/product/Review;->percent0To100:I

    .line 102
    const-string v1, "averageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "rangeMax"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    sput v1, Lcom/bestbuy/android/api/lib/models/product/Review;->rangeMax:I

    .line 103
    const-string v1, "averageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "score"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    sput-wide v2, Lcom/bestbuy/android/api/lib/models/product/Review;->score:D

    .line 105
    :cond_0
    const-string v1, "averageWouldRecommend"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 106
    const-string v1, "averageWouldRecommend"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "percent0To1"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    sput-wide v2, Lcom/bestbuy/android/api/lib/models/product/Review;->recommendPercent0To1:D

    .line 107
    const-string v1, "averageWouldRecommend"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "percent0To100"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    sput-wide v2, Lcom/bestbuy/android/api/lib/models/product/Review;->recommendPercent0To100:D

    .line 108
    const-string v1, "averageWouldRecommend"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "totalCount"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    sput v1, Lcom/bestbuy/android/api/lib/models/product/Review;->recommendTotalCount:I

    .line 110
    :cond_1
    const-string v1, "mfgAverageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 111
    const-string v1, "mfgAverageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "manufacturer"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/bestbuy/android/api/lib/models/product/Review;->manufacturer:Ljava/lang/String;

    .line 112
    const-string v1, "mfgAverageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "percent0To1"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    sput-wide v2, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingPercent0To1:D

    .line 113
    const-string v1, "mfgAverageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "percent0To100"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    sput-wide v2, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingPercent0To100:D

    .line 114
    const-string v1, "mfgAverageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "rangeMax"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    sput v1, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingRangeMax:I

    .line 115
    const-string v1, "mfgAverageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "score"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    sput-wide v2, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingScore:D

    .line 116
    const-string v1, "mfgAverageRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "totalCount"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    sput v1, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingTotalCount:I

    .line 118
    :cond_2
    const-string v1, "totalCount"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    sput v1, Lcom/bestbuy/android/api/lib/models/product/Review;->totalCount:I

    .line 119
    const-string v1, "averageFeatureRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 120
    const-string v1, "averageFeatureRating"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;->loadFeatureRatingData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v1

    sput-object v1, Lcom/bestbuy/android/api/lib/models/product/Review;->featureRatings:Ljava/util/ArrayList;

    .line 121
    :cond_3
    const-string v1, "starRatingBreakdown"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 122
    const-string v1, "starRatingBreakdown"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;->loadStarRatingBreakdownData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v1

    sput-object v1, Lcom/bestbuy/android/api/lib/models/product/Review;->starRatingBreakdowns:Ljava/util/ArrayList;

    .line 124
    :cond_4
    return-object v0
.end method


# virtual methods
.method public getFeatureRatings()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Review$FeatureRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 38
    sget-object v0, Lcom/bestbuy/android/api/lib/models/product/Review;->featureRatings:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getManufacturer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    sget-object v0, Lcom/bestbuy/android/api/lib/models/product/Review;->manufacturer:Ljava/lang/String;

    return-object v0
.end method

.method public getMfgAvgRatingPercent0To1()D
    .locals 2

    .prologue
    .line 78
    sget-wide v0, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingPercent0To1:D

    return-wide v0
.end method

.method public getMfgAvgRatingPercent0To100()D
    .locals 2

    .prologue
    .line 82
    sget-wide v0, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingPercent0To100:D

    return-wide v0
.end method

.method public getMfgAvgRatingRangeMax()I
    .locals 1

    .prologue
    .line 86
    sget v0, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingRangeMax:I

    return v0
.end method

.method public getMfgAvgRatingScore()D
    .locals 2

    .prologue
    .line 90
    sget-wide v0, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingScore:D

    return-wide v0
.end method

.method public getMfgAvgRatingTotalCount()I
    .locals 1

    .prologue
    .line 94
    sget v0, Lcom/bestbuy/android/api/lib/models/product/Review;->mfgAvgRatingTotalCount:I

    return v0
.end method

.method public getPercent0To1()D
    .locals 2

    .prologue
    .line 42
    sget-wide v0, Lcom/bestbuy/android/api/lib/models/product/Review;->percent0To1:D

    return-wide v0
.end method

.method public getPercent0To100()I
    .locals 1

    .prologue
    .line 46
    sget v0, Lcom/bestbuy/android/api/lib/models/product/Review;->percent0To100:I

    return v0
.end method

.method public getRangeMax()I
    .locals 1

    .prologue
    .line 50
    sget v0, Lcom/bestbuy/android/api/lib/models/product/Review;->rangeMax:I

    return v0
.end method

.method public getRecommendPercent0To1()D
    .locals 2

    .prologue
    .line 62
    sget-wide v0, Lcom/bestbuy/android/api/lib/models/product/Review;->recommendPercent0To1:D

    return-wide v0
.end method

.method public getRecommendPercent0To100()D
    .locals 2

    .prologue
    .line 66
    sget-wide v0, Lcom/bestbuy/android/api/lib/models/product/Review;->recommendPercent0To100:D

    return-wide v0
.end method

.method public getRecommendTotalCount()I
    .locals 1

    .prologue
    .line 70
    sget v0, Lcom/bestbuy/android/api/lib/models/product/Review;->recommendTotalCount:I

    return v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 54
    sget-wide v0, Lcom/bestbuy/android/api/lib/models/product/Review;->score:D

    return-wide v0
.end method

.method public getTotalCount()I
    .locals 1

    .prologue
    .line 58
    sget v0, Lcom/bestbuy/android/api/lib/models/product/Review;->totalCount:I

    return v0
.end method
