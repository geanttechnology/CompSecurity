.class public Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private count:I

.field private percent0To100:D

.field private score:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 127
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadStarRatingBreakdownData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;",
            ">;"
        }
    .end annotation

    .prologue
    .line 150
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 151
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 152
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;-><init>()V

    .line 153
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 154
    if-eqz v3, :cond_0

    .line 155
    const-string v4, "count"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v2, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;->count:I

    .line 156
    const-string v4, "percent0To100"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;->percent0To100:D

    .line 157
    const-string v4, "score"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v3

    iput v3, v2, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;->score:I

    .line 158
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 151
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 161
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 138
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;->count:I

    return v0
.end method

.method public getPercent0To100()D
    .locals 2

    .prologue
    .line 142
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;->percent0To100:D

    return-wide v0
.end method

.method public getScore()I
    .locals 1

    .prologue
    .line 146
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Review$StarRatingBreakdown;->score:I

    return v0
.end method
