.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private currentPrice:D

.field private listingId:Ljava/lang/String;

.field private originalPricingType:Ljava/lang/String;

.field private pricingType:Ljava/lang/String;

.field private regularPrice:D

.field private savingsAmount:D

.field private shippingCost:D

.field private totalPrice:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCurrentPrice()D
    .locals 2

    .prologue
    .line 40
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->currentPrice:D

    return-wide v0
.end method

.method public getListingId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->listingId:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginalPricingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->originalPricingType:Ljava/lang/String;

    return-object v0
.end method

.method public getPricingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->pricingType:Ljava/lang/String;

    return-object v0
.end method

.method public getRegularPrice()D
    .locals 2

    .prologue
    .line 56
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->regularPrice:D

    return-wide v0
.end method

.method public getSavingsAmount()D
    .locals 2

    .prologue
    .line 64
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->savingsAmount:D

    return-wide v0
.end method

.method public getShippingCost()D
    .locals 2

    .prologue
    .line 24
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->shippingCost:D

    return-wide v0
.end method

.method public getTotalPrice()D
    .locals 2

    .prologue
    .line 72
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->totalPrice:D

    return-wide v0
.end method

.method public setCurrentPrice(D)V
    .locals 1

    .prologue
    .line 44
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->currentPrice:D

    .line 45
    return-void
.end method

.method public setListingId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->listingId:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setOriginalPricingType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->originalPricingType:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setPricingType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->pricingType:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setRegularPrice(D)V
    .locals 1

    .prologue
    .line 60
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->regularPrice:D

    .line 61
    return-void
.end method

.method public setSavingsAmount(D)V
    .locals 1

    .prologue
    .line 68
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->savingsAmount:D

    .line 69
    return-void
.end method

.method public setShippingCost(D)V
    .locals 1

    .prologue
    .line 28
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->shippingCost:D

    .line 29
    return-void
.end method

.method public setTotalPrice(D)V
    .locals 1

    .prologue
    .line 76
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->totalPrice:D

    .line 77
    return-void
.end method
