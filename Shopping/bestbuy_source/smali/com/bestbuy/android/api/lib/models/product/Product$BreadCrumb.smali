.class public Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private categoryId:Ljava/lang/String;

.field private displayName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2805
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadBreadCrumbDetails(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2830
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 2831
    if-eqz p0, :cond_1

    .line 2832
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 2833
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 2834
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;-><init>()V

    .line 2835
    if-eqz v2, :cond_0

    .line 2836
    const-string v4, "categoryId"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;->categoryId:Ljava/lang/String;

    .line 2837
    const-string v4, "displayName"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;->displayName:Ljava/lang/String;

    .line 2839
    :cond_0
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2832
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2842
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2814
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;->categoryId:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2818
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public setCategoryId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2822
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;->categoryId:Ljava/lang/String;

    .line 2823
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2826
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$BreadCrumb;->displayName:Ljava/lang/String;

    .line 2827
    return-void
.end method
