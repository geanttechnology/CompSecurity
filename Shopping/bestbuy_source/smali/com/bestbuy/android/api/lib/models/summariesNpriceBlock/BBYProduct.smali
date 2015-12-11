.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private ep:Ljava/lang/String;

.field private priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field private restrictedPrice:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

.field private skuId:Ljava/lang/String;

.field private storeAvailability:Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

.field private summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getEp()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->ep:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getRestrictedPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->restrictedPrice:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->storeAvailability:Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    return-object v0
.end method

.method public getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    return-object v0
.end method

.method public setEp(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->ep:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 80
    return-void
.end method

.method public setRestrictedPrice(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->restrictedPrice:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    .line 96
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->skuId:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setStoreAvailability(Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->storeAvailability:Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    .line 35
    return-void
.end method

.method public setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    .line 72
    return-void
.end method
