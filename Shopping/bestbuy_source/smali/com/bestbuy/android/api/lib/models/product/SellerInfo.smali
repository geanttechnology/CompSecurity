.class public Lcom/bestbuy/android/api/lib/models/product/SellerInfo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private averageScore:Ljava/lang/String;

.field private ratingRangeMax:Ljava/lang/String;

.field private ratingUrl:Ljava/lang/String;

.field private returnPolicyUrl:Ljava/lang/String;

.field private seller:Ljava/lang/String;

.field private sellerId:Ljava/lang/String;

.field private sellerUrl:Ljava/lang/String;

.field private shopSellerUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getSellerInfo(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/SellerInfo;
    .locals 3

    .prologue
    .line 54
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;-><init>()V

    .line 55
    const-string v1, "seller"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->seller:Ljava/lang/String;

    .line 56
    const-string v1, "sellerId"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->sellerId:Ljava/lang/String;

    .line 57
    const-string v1, "averageScore"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->averageScore:Ljava/lang/String;

    .line 58
    const-string v1, "ratingRangeMax"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->ratingRangeMax:Ljava/lang/String;

    .line 59
    const-string v1, "sellerUrl"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->sellerUrl:Ljava/lang/String;

    .line 60
    const-string v1, "ratingUrl"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->ratingUrl:Ljava/lang/String;

    .line 61
    const-string v1, "returnPolicyUrl"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->returnPolicyUrl:Ljava/lang/String;

    .line 62
    const-string v1, "shopSellerUrl"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->shopSellerUrl:Ljava/lang/String;

    .line 63
    return-object v0
.end method


# virtual methods
.method public getAverageScore()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->averageScore:Ljava/lang/String;

    return-object v0
.end method

.method public getRatingRangeMax()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->ratingRangeMax:Ljava/lang/String;

    return-object v0
.end method

.method public getRatingUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->ratingUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getReturnPolicyUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->returnPolicyUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSeller()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->seller:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->sellerId:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->sellerUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getShopSellerUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/SellerInfo;->shopSellerUrl:Ljava/lang/String;

    return-object v0
.end method
