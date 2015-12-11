.class public Lcom/bestbuy/android/api/lib/models/product/Product$Details;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private link:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 2461
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2459
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->link:Ljava/lang/String;

    .line 2463
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 2465
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2459
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->link:Ljava/lang/String;

    .line 2466
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->name:Ljava/lang/String;

    .line 2467
    iput-object p2, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->value:Ljava/lang/String;

    .line 2468
    return-void
.end method

.method public static getDetailsList(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2483
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 2484
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 2485
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>()V

    .line 2486
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2487
    if-eqz v3, :cond_0

    .line 2488
    const-string v4, "displayName"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->name:Ljava/lang/String;

    .line 2489
    const-string v4, "value"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->value:Ljava/lang/String;

    .line 2490
    const-string v4, "link"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 2491
    const-string v4, "link"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    const-string v4, "url"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->link:Ljava/lang/String;

    .line 2494
    :cond_0
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2484
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2496
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2471
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2479
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->link:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2475
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;->value:Ljava/lang/String;

    return-object v0
.end method
