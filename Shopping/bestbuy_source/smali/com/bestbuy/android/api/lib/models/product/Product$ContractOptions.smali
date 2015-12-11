.class public Lcom/bestbuy/android/api/lib/models/product/Product$ContractOptions;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private price:Ljava/lang/String;

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1843
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadContractOptionsData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ContractOptions;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1861
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1862
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 1863
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 1864
    if-eqz v2, :cond_0

    .line 1865
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/Product$ContractOptions;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/Product$ContractOptions;-><init>()V

    .line 1866
    const-string v4, "price"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ContractOptions;->price:Ljava/lang/String;

    .line 1867
    const-string v4, "type"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/Product$ContractOptions;->type:Ljava/lang/String;

    .line 1868
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1862
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1871
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1857
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ContractOptions;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1853
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ContractOptions;->type:Ljava/lang/String;

    return-object v0
.end method
