.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private condition:Ljava/lang/String;

.field private price:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

.field private productId:Ljava/lang/String;

.field private skuId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->price:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->condition:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setPrice(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->price:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    .line 23
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->productId:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->skuId:Ljava/lang/String;

    .line 39
    return-void
.end method
