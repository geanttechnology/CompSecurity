.class public Lcom/bestbuy/android/api/lib/models/product/Product$Feature;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private description:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2016
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadFeaturesData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Feature;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2033
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 2034
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 2035
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Product$Feature;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/product/Product$Feature;-><init>()V

    .line 2036
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2037
    if-eqz v3, :cond_0

    .line 2038
    const-string v4, "description"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$Feature;->description:Ljava/lang/String;

    .line 2039
    const-string v4, "title"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/bestbuy/android/api/lib/models/product/Product$Feature;->title:Ljava/lang/String;

    .line 2041
    :cond_0
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2034
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2043
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2025
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Feature;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2029
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Feature;->title:Ljava/lang/String;

    return-object v0
.end method
