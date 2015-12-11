.class public Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private color:Ljava/lang/String;

.field private format:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private productId:Ljava/lang/String;

.field private sku:Ljava/lang/String;

.field private state:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1880
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadAlternateSKUData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v1, 0x0

    .line 1946
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    .line 1947
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_4

    .line 1948
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 1949
    if-eqz v3, :cond_2

    .line 1950
    new-instance v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;-><init>()V

    .line 1951
    const-string v5, "sku"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->sku:Ljava/lang/String;

    .line 1952
    iget-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->sku:Ljava/lang/String;

    if-eqz v5, :cond_0

    iget-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->sku:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1953
    :cond_0
    const-string v5, "skuId"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->sku:Ljava/lang/String;

    .line 1954
    :cond_1
    const-string v5, "displayName"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->color:Ljava/lang/String;

    .line 1956
    const-string v5, "state"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->state:Ljava/lang/String;

    .line 1957
    const-string v5, "productId"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->productId:Ljava/lang/String;

    .line 1958
    const-string v5, "format"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    .line 1959
    iget-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    if-eqz v5, :cond_3

    iget-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_3

    .line 1960
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    invoke-virtual {v5, v1, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    .line 1965
    :goto_1
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1947
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 1962
    :cond_3
    const-string v5, "price"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->price:Ljava/lang/String;

    .line 1963
    const-string v5, "type"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    goto :goto_1

    .line 1968
    :cond_4
    return-object v2
.end method


# virtual methods
.method public getColor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1926
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->color:Ljava/lang/String;

    return-object v0
.end method

.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1938
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1894
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1942
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1922
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1934
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1930
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setColor(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1902
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->color:Ljava/lang/String;

    .line 1903
    return-void
.end method

.method public setFormat(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1914
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->format:Ljava/lang/String;

    .line 1915
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1918
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->productId:Ljava/lang/String;

    .line 1919
    return-void
.end method

.method public setSku(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1898
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->sku:Ljava/lang/String;

    .line 1899
    return-void
.end method

.method public setState(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1910
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->state:Ljava/lang/String;

    .line 1911
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1906
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$AlternateSKU;->url:Ljava/lang/String;

    .line 1907
    return-void
.end method
