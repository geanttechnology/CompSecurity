.class public Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private additionalFields:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;",
            ">;"
        }
    .end annotation
.end field

.field private additionalFieldsOrder:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private authorId:Ljava/lang/String;

.field private badges:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/Badge;",
            ">;"
        }
    .end annotation
.end field

.field private badgesOrder:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private campaignId:Ljava/lang/String;

.field private cons:Ljava/lang/String;

.field private contentLocale:Ljava/lang/String;

.field private helpfulness:D

.field private id:Ljava/lang/String;

.field private isFeatured:Z

.field private isRatingsOnly:Z

.field private isRecommended:Z

.field private isSyndicated:Z

.field private lastModeratedTime:Ljava/lang/String;

.field private lastModificationTime:Ljava/lang/String;

.field private moderationStatus:Ljava/lang/String;

.field private productId:Ljava/lang/String;

.field private pros:Ljava/lang/String;

.field private rating:F

.field private ratingRange:I

.field private reviewText:Ljava/lang/String;

.field private secondaryRatings:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;",
            ">;"
        }
    .end annotation
.end field

.field private secondaryRatingsOrder:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private submissionId:Ljava/lang/String;

.field private submissionTime:Ljava/lang/String;

.field private tagDimensions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/TagDimension;",
            ">;"
        }
    .end annotation
.end field

.field private tagDimensionsOrder:Ljava/util/ArrayList;
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

.field private totalCommentCount:I

.field private totalFeedbackCount:I

.field private totalNegativeFeedbackCount:I

.field private totalPositiveFeedbackCount:I

.field private userLocation:Ljava/lang/String;

.field private userNickname:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadRatingsAndReviewsData(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 193
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 194
    const-string v0, "Results"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    move v0, v1

    .line 195
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_9

    .line 196
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 197
    if-eqz v5, :cond_8

    .line 198
    new-instance v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;

    invoke-direct {v6}, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;-><init>()V

    .line 199
    const-string v2, "TagDimensionsOrder"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 200
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->tagDimensionsOrder:Ljava/util/ArrayList;

    .line 201
    const-string v2, "TagDimensionsOrder"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    move v2, v1

    .line 202
    :goto_1
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v2, v8, :cond_0

    .line 203
    invoke-virtual {v7, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v8

    .line 204
    iget-object v9, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->tagDimensionsOrder:Ljava/util/ArrayList;

    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 202
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 207
    :cond_0
    const-string v2, "TagDimensions"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 208
    const-string v2, "TagDimensions"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    iget-object v7, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->tagDimensionsOrder:Ljava/util/ArrayList;

    invoke-static {v2, v7}, Lcom/bestbuy/android/api/lib/models/reviews/TagDimension;->loadTagDimensionData(Lorg/json/JSONObject;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->tagDimensions:Ljava/util/ArrayList;

    .line 211
    :cond_1
    const-string v2, "AdditionalFieldsOrder"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 212
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->additionalFieldsOrder:Ljava/util/ArrayList;

    .line 213
    const-string v2, "AdditionalFieldsOrder"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    move v2, v1

    .line 214
    :goto_2
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v2, v8, :cond_2

    .line 215
    invoke-virtual {v7, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v8

    .line 216
    iget-object v9, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->additionalFieldsOrder:Ljava/util/ArrayList;

    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 214
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 219
    :cond_2
    const-string v2, "AdditionalFields"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 220
    const-string v2, "AdditionalFields"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    iget-object v7, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->additionalFieldsOrder:Ljava/util/ArrayList;

    invoke-static {v2, v7}, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;->loadAdditionalFieldData(Lorg/json/JSONObject;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->additionalFields:Ljava/util/ArrayList;

    .line 223
    :cond_3
    const-string v2, "BadgesOrder"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 224
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->badgesOrder:Ljava/util/ArrayList;

    .line 225
    const-string v2, "BadgesOrder"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    move v2, v1

    .line 226
    :goto_3
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v2, v8, :cond_4

    .line 227
    invoke-virtual {v7, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v8

    .line 228
    iget-object v9, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->badgesOrder:Ljava/util/ArrayList;

    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 226
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 231
    :cond_4
    const-string v2, "Badges"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 232
    const-string v2, "Badges"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    iget-object v7, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->badgesOrder:Ljava/util/ArrayList;

    invoke-static {v2, v7}, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->loadReviewBadgeData(Lorg/json/JSONObject;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->badges:Ljava/util/ArrayList;

    .line 235
    :cond_5
    const-string v2, "SecondaryRatingsOrder"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 236
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->secondaryRatingsOrder:Ljava/util/ArrayList;

    .line 237
    const-string v2, "SecondaryRatingsOrder"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    move v2, v1

    .line 238
    :goto_4
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v2, v8, :cond_6

    .line 239
    invoke-virtual {v7, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v8

    .line 240
    iget-object v9, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->secondaryRatingsOrder:Ljava/util/ArrayList;

    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 238
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .line 243
    :cond_6
    const-string v2, "SecondaryRatings"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_7

    .line 244
    const-string v2, "SecondaryRatings"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    iget-object v7, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->secondaryRatingsOrder:Ljava/util/ArrayList;

    invoke-static {v2, v7}, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->loadSecondaryRatingData(Lorg/json/JSONObject;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->secondaryRatings:Ljava/util/ArrayList;

    .line 247
    :cond_7
    const-string v2, "Cons"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->cons:Ljava/lang/String;

    .line 248
    const-string v2, "IsRecommended"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->isRecommended:Z

    .line 249
    const-string v2, "IsRatingsOnly"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->isRatingsOnly:Z

    .line 250
    const-string v2, "UserNickname"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->userNickname:Ljava/lang/String;

    .line 251
    const-string v2, "Pros"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->pros:Ljava/lang/String;

    .line 252
    const-string v2, "SubmissionId"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->submissionId:Ljava/lang/String;

    .line 253
    const-string v2, "LastModificationTime"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->lastModificationTime:Ljava/lang/String;

    .line 254
    const-string v2, "TotalFeedbackCount"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->totalFeedbackCount:I

    .line 255
    const-string v2, "TotalPositiveFeedbackCount"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->totalPositiveFeedbackCount:I

    .line 256
    const-string v2, "UserLocation"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->userLocation:Ljava/lang/String;

    .line 257
    const-string v2, "AuthorId"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->authorId:Ljava/lang/String;

    .line 258
    const-string v2, "IsFeatured"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->isFeatured:Z

    .line 259
    const-string v2, "IsSyndicated"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->isSyndicated:Z

    .line 260
    const-string v2, "ProductId"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->productId:Ljava/lang/String;

    .line 261
    const-string v2, "Title"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->title:Ljava/lang/String;

    .line 262
    const-string v2, "Helpfulness"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v8

    iput-wide v8, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->helpfulness:D

    .line 263
    const-string v2, "CampaignId"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->campaignId:Ljava/lang/String;

    .line 264
    const-string v2, "TotalNegativeFeedbackCount"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->totalNegativeFeedbackCount:I

    .line 265
    const-string v2, "SubmissionTime"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->submissionTime:Ljava/lang/String;

    .line 266
    const-string v2, "ContentLocale"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->contentLocale:Ljava/lang/String;

    .line 267
    const-string v2, "ReviewText"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->reviewText:Ljava/lang/String;

    .line 268
    const-string v2, "ModerationStatus"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->moderationStatus:Ljava/lang/String;

    .line 269
    const-string v2, "Id"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->id:Ljava/lang/String;

    .line 270
    const-string v2, "LastModeratedTime"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->lastModeratedTime:Ljava/lang/String;

    .line 271
    const-string v2, "Rating"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v8

    double-to-float v2, v8

    iput v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->rating:F

    .line 272
    const-string v2, "RatingRange"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->ratingRange:I

    .line 273
    const-string v2, "TotalCommentCount"

    invoke-virtual {v5, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v6, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->totalCommentCount:I

    .line 274
    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 195
    :cond_8
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 277
    :cond_9
    return-object v3
.end method


# virtual methods
.method public getAdditionalFields()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;",
            ">;"
        }
    .end annotation

    .prologue
    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->additionalFields:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getAdditionalFieldsOrder()Ljava/util/ArrayList;
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
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->additionalFieldsOrder:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getAuthorId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->authorId:Ljava/lang/String;

    return-object v0
.end method

.method public getBadges()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/Badge;",
            ">;"
        }
    .end annotation

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->badges:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getBadgesOrder()Ljava/util/ArrayList;
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
    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->badgesOrder:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCampaignId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->campaignId:Ljava/lang/String;

    return-object v0
.end method

.method public getCons()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->cons:Ljava/lang/String;

    return-object v0
.end method

.method public getContentLocale()Ljava/lang/String;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->contentLocale:Ljava/lang/String;

    return-object v0
.end method

.method public getHelpfulness()D
    .locals 2

    .prologue
    .line 145
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->helpfulness:D

    return-wide v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLastModeratedTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->lastModeratedTime:Ljava/lang/String;

    return-object v0
.end method

.method public getLastModificationTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->lastModificationTime:Ljava/lang/String;

    return-object v0
.end method

.method public getModerationStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->moderationStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getPros()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->pros:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()F
    .locals 1

    .prologue
    .line 157
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->rating:F

    return v0
.end method

.method public getRatingRange()I
    .locals 1

    .prologue
    .line 165
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->ratingRange:I

    return v0
.end method

.method public getReviewText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->reviewText:Ljava/lang/String;

    return-object v0
.end method

.method public getSecondaryRatings()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->secondaryRatings:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSecondaryRatingsOrder()Ljava/util/ArrayList;
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
    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->secondaryRatingsOrder:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSubmissionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->submissionId:Ljava/lang/String;

    return-object v0
.end method

.method public getSubmissionTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->submissionTime:Ljava/lang/String;

    return-object v0
.end method

.method public getTagDimensions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/TagDimension;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->tagDimensions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTagDimensionsOrder()Ljava/util/ArrayList;
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
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->tagDimensionsOrder:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalCommentCount()I
    .locals 1

    .prologue
    .line 169
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->totalCommentCount:I

    return v0
.end method

.method public getTotalFeedbackCount()I
    .locals 1

    .prologue
    .line 97
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->totalFeedbackCount:I

    return v0
.end method

.method public getTotalNegativeFeedbackCount()I
    .locals 1

    .prologue
    .line 149
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->totalNegativeFeedbackCount:I

    return v0
.end method

.method public getTotalPositiveFeedbackCount()I
    .locals 1

    .prologue
    .line 101
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->totalPositiveFeedbackCount:I

    return v0
.end method

.method public getUserLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->userLocation:Ljava/lang/String;

    return-object v0
.end method

.method public getUserNickname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->userNickname:Ljava/lang/String;

    return-object v0
.end method

.method public isFeatured()Z
    .locals 1

    .prologue
    .line 121
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->isFeatured:Z

    return v0
.end method

.method public isRatingsOnly()Z
    .locals 1

    .prologue
    .line 77
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->isRatingsOnly:Z

    return v0
.end method

.method public isRecommended()Z
    .locals 1

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->isRecommended:Z

    return v0
.end method

.method public isSyndicated()Z
    .locals 1

    .prologue
    .line 125
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/RatingAndReview;->isSyndicated:Z

    return v0
.end method
