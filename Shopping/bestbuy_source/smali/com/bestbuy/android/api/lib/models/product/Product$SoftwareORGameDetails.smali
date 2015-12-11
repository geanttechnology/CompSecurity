.class public Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private softwareORGameDetailsList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2660
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getSoftwareORGameDetailsData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 2672
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;-><init>()V

    .line 2673
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    .line 2674
    const-string v0, "requirements"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 2676
    if-eqz v3, :cond_7

    .line 2677
    const-string v0, "mac"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 2678
    if-eqz v4, :cond_1

    .line 2679
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    const-string v5, "Mac Requirements"

    const-string v6, ""

    invoke-direct {v0, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2680
    iget-object v5, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move v0, v1

    .line 2681
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v0, v5, :cond_1

    .line 2682
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 2683
    if-eqz v5, :cond_0

    .line 2684
    const-string v6, "displayName"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2685
    const-string v7, "value"

    invoke-virtual {v5, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2686
    new-instance v7, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    invoke-direct {v7, v6, v5}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2687
    iget-object v5, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2681
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2691
    :cond_1
    const-string v0, "pc"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 2692
    if-eqz v4, :cond_3

    .line 2693
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    const-string v5, "PC Requirements"

    const-string v6, ""

    invoke-direct {v0, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2694
    iget-object v5, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move v0, v1

    .line 2695
    :goto_1
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v0, v5, :cond_3

    .line 2696
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 2697
    if-eqz v5, :cond_2

    .line 2698
    const-string v6, "displayName"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2699
    const-string v7, "value"

    invoke-virtual {v5, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2700
    new-instance v7, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    invoke-direct {v7, v6, v5}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2701
    iget-object v5, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2695
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 2705
    :cond_3
    const-string v0, "download"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 2706
    if-eqz v4, :cond_5

    .line 2707
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    const-string v5, "Download Requirements"

    const-string v6, ""

    invoke-direct {v0, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2708
    iget-object v5, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move v0, v1

    .line 2709
    :goto_2
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v0, v5, :cond_5

    .line 2710
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 2711
    if-eqz v5, :cond_4

    .line 2712
    const-string v6, "displayName"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2713
    const-string v7, "value"

    invoke-virtual {v5, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2714
    new-instance v7, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    invoke-direct {v7, v6, v5}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2715
    iget-object v5, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2709
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 2719
    :cond_5
    const-string v0, "system"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 2720
    if-eqz v3, :cond_7

    .line 2721
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    const-string v4, "System Requirements"

    const-string v5, ""

    invoke-direct {v0, v4, v5}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2722
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move v0, v1

    .line 2723
    :goto_3
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_7

    .line 2724
    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 2725
    if-eqz v4, :cond_6

    .line 2726
    const-string v5, "displayName"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2727
    const-string v6, "value"

    invoke-virtual {v4, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 2728
    new-instance v6, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    invoke-direct {v6, v5, v4}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2729
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2723
    :cond_6
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 2734
    :cond_7
    const-string v0, "specifications"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 2735
    if-eqz v0, :cond_9

    .line 2736
    :goto_4
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v1, v3, :cond_9

    .line 2737
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2738
    if-eqz v3, :cond_8

    .line 2739
    const-string v4, "displayName"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 2740
    const-string v5, "value"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 2741
    new-instance v5, Lcom/bestbuy/android/api/lib/models/product/Product$Details;

    invoke-direct {v5, v4, v3}, Lcom/bestbuy/android/api/lib/models/product/Product$Details;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2742
    iget-object v3, v2, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2736
    :cond_8
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    .line 2746
    :cond_9
    return-object v2
.end method


# virtual methods
.method public getSoftwareORGameDetailsList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Details;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2668
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$SoftwareORGameDetails;->softwareORGameDetailsList:Ljava/util/ArrayList;

    return-object v0
.end method
