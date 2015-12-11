.class public Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private clipId:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private stillImage:Ljava/lang/String;

.field private videos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Video;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2051
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadProductVideos(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2078
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 2079
    const-string v0, "videoFiles"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 2080
    if-eqz v2, :cond_2

    .line 2081
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_2

    .line 2082
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2083
    if-eqz v3, :cond_1

    .line 2084
    new-instance v4, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;-><init>()V

    .line 2085
    const-string v5, "clipId"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->clipId:Ljava/lang/String;

    .line 2086
    const-string v5, "displayName"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->displayName:Ljava/lang/String;

    .line 2087
    const-string v5, "stillImage"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 2088
    if-eqz v5, :cond_0

    .line 2089
    const-string v6, "url"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->stillImage:Ljava/lang/String;

    .line 2090
    :cond_0
    const-string v5, "sizes"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->loadVideoDetails(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v3

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->videos:Ljava/util/ArrayList;

    .line 2091
    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2081
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2095
    :cond_2
    return-object v1
.end method


# virtual methods
.method public getClipId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2062
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->clipId:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2066
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getStillImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2070
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->stillImage:Ljava/lang/String;

    return-object v0
.end method

.method public getVideos()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Video;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2074
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProductVideos;->videos:Ljava/util/ArrayList;

    return-object v0
.end method
