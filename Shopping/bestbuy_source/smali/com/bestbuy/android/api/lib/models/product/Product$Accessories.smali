.class public Lcom/bestbuy/android/api/lib/models/product/Product$Accessories;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2750
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAccessoriesList(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product;",
            ">;"
        }
    .end annotation

    .prologue
    const-wide/16 v8, 0x0

    .line 2757
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 2758
    if-eqz p0, :cond_6

    .line 2759
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_6

    .line 2760
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/product/Product;-><init>()V

    .line 2761
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2762
    if-eqz v3, :cond_2

    .line 2763
    const-string v4, "skuId"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    # setter for: Lcom/bestbuy/android/api/lib/models/product/Product;->sku:Ljava/lang/String;
    invoke-static {v2, v4}, Lcom/bestbuy/android/api/lib/models/product/Product;->access$002(Lcom/bestbuy/android/api/lib/models/product/Product;Ljava/lang/String;)Ljava/lang/String;

    .line 2764
    const-string v4, "productId"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    # setter for: Lcom/bestbuy/android/api/lib/models/product/Product;->productId:Ljava/lang/String;
    invoke-static {v2, v4}, Lcom/bestbuy/android/api/lib/models/product/Product;->access$102(Lcom/bestbuy/android/api/lib/models/product/Product;Ljava/lang/String;)Ljava/lang/String;

    .line 2765
    const-string v4, "meta"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "title"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    # setter for: Lcom/bestbuy/android/api/lib/models/product/Product;->name:Ljava/lang/String;
    invoke-static {v2, v4}, Lcom/bestbuy/android/api/lib/models/product/Product;->access$202(Lcom/bestbuy/android/api/lib/models/product/Product;Ljava/lang/String;)Ljava/lang/String;

    .line 2766
    new-instance v4, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;-><init>()V

    .line 2767
    const-string v5, "media"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 2768
    const-string v5, "media"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "listImage"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 2769
    const-string v5, "media"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "listImage"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "url"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    # setter for: Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->image:Ljava/lang/String;
    invoke-static {v4, v5}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->access$302(Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;Ljava/lang/String;)Ljava/lang/String;

    .line 2771
    :cond_0
    const-string v5, "media"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "primaryImage"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 2772
    const-string v5, "media"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "primaryImage"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "url"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    # setter for: Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->primaryImage:Ljava/lang/String;
    invoke-static {v4, v5}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->access$402(Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;Ljava/lang/String;)Ljava/lang/String;

    .line 2775
    :cond_1
    # setter for: Lcom/bestbuy/android/api/lib/models/product/Product;->images:Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;
    invoke-static {v2, v4}, Lcom/bestbuy/android/api/lib/models/product/Product;->access$502(Lcom/bestbuy/android/api/lib/models/product/Product;Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;)Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    .line 2783
    const-string v4, "customerRatings"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "totalCount"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    # setter for: Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I
    invoke-static {v2, v4}, Lcom/bestbuy/android/api/lib/models/product/Product;->access$602(Lcom/bestbuy/android/api/lib/models/product/Product;I)I

    .line 2784
    # getter for: Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewCount:I
    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/product/Product;->access$600(Lcom/bestbuy/android/api/lib/models/product/Product;)I

    move-result v4

    if-nez v4, :cond_3

    .line 2785
    iput-wide v8, v2, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    .line 2798
    :cond_2
    :goto_1
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2759
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 2787
    :cond_3
    const-string v4, "customerRatings"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 2788
    const-string v4, "customerRatings"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "averageRating"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 2789
    const-string v4, "customerRatings"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    const-string v4, "averageRating"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    const-string v4, "score"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    goto :goto_1

    .line 2792
    :cond_4
    iput-wide v8, v2, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    goto :goto_1

    .line 2795
    :cond_5
    iput-wide v8, v2, Lcom/bestbuy/android/api/lib/models/product/Product;->customerReviewAverage:D

    goto :goto_1

    .line 2801
    :cond_6
    return-object v1
.end method
