.class public Lcom/bestbuy/android/api/lib/models/reviews/Badge;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private badgeKey:Ljava/lang/String;

.field private badgeType:Ljava/lang/String;

.field private contentType:Ljava/lang/String;

.field private id:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadReviewBadgeData(Lorg/json/JSONObject;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/Badge;",
            ">;"
        }
    .end annotation

    .prologue
    .line 35
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 36
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 37
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 38
    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 39
    if-eqz v3, :cond_0

    .line 40
    new-instance v4, Lcom/bestbuy/android/api/lib/models/reviews/Badge;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/reviews/Badge;-><init>()V

    .line 41
    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->badgeKey:Ljava/lang/String;

    .line 42
    const-string v0, "BadgeType"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->badgeType:Ljava/lang/String;

    .line 43
    const-string v0, "Id"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->id:Ljava/lang/String;

    .line 44
    const-string v0, "ContentType"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->contentType:Ljava/lang/String;

    .line 45
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 36
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 48
    :cond_1
    return-object v2
.end method


# virtual methods
.method public getBadgeKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->badgeKey:Ljava/lang/String;

    return-object v0
.end method

.method public getBadgeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->badgeType:Ljava/lang/String;

    return-object v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->contentType:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/Badge;->id:Ljava/lang/String;

    return-object v0
.end method
