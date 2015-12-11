.class public Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private errors:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/Error;",
            ">;"
        }
    .end annotation
.end field

.field private hasErrors:Z

.field private limit:I

.field private locale:Ljava/lang/String;

.field private offset:I

.field private reviews:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;",
            ">;"
        }
    .end annotation
.end field

.field private totalResults:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadReviewResponseData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;
    .locals 2

    .prologue
    .line 51
    new-instance v0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;-><init>()V

    .line 52
    const-string v1, "HasErrors"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->hasErrors:Z

    .line 53
    const-string v1, "Offset"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->offset:I

    .line 54
    const-string v1, "TotalResults"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->totalResults:I

    .line 55
    const-string v1, "Locale"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->locale:Ljava/lang/String;

    .line 56
    const-string v1, "Limit"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->limit:I

    .line 57
    const-string v1, "Results"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 58
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->loadRatingsAndReviewsData(Lorg/json/JSONObject;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->reviews:Ljava/util/ArrayList;

    .line 60
    :cond_0
    const-string v1, "Errors"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 61
    const-string v1, "Errors"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/reviews/Error;->loadErrorsData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->errors:Ljava/util/ArrayList;

    .line 63
    :cond_1
    return-object v0
.end method


# virtual methods
.method public getErrors()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/Error;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->errors:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getLimit()I
    .locals 1

    .prologue
    .line 43
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->limit:I

    return v0
.end method

.method public getLocale()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->locale:Ljava/lang/String;

    return-object v0
.end method

.method public getOffset()I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->offset:I

    return v0
.end method

.method public getReviews()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->reviews:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotalResults()I
    .locals 1

    .prologue
    .line 31
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->totalResults:I

    return v0
.end method

.method public isHasErrors()Z
    .locals 1

    .prologue
    .line 23
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/ReviewResponse;->hasErrors:Z

    return v0
.end method
