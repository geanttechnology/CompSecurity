.class public Lcom/bestbuy/android/api/lib/models/product/Product$Video;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private encoding:Ljava/lang/String;

.field private height:I

.field private url:Ljava/lang/String;

.field private width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadVideoDetails(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Video;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 2125
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    .line 2126
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 2127
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2128
    new-instance v4, Lcom/bestbuy/android/api/lib/models/product/Product$Video;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/product/Product$Video;-><init>()V

    .line 2129
    const-string v5, "height"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v5

    iput v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->height:I

    .line 2130
    const-string v5, "width"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v5

    iput v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->width:I

    .line 2131
    const-string v5, "formats"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 2132
    if-eqz v3, :cond_0

    .line 2133
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2134
    if-eqz v3, :cond_0

    .line 2135
    const-string v5, "encoding"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->encoding:Ljava/lang/String;

    .line 2136
    const-string v5, "url"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->url:Ljava/lang/String;

    .line 2137
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2126
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2141
    :cond_1
    return-object v2
.end method


# virtual methods
.method public getEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2118
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->encoding:Ljava/lang/String;

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 2112
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->height:I

    return v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2121
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 2115
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Video;->width:I

    return v0
.end method
