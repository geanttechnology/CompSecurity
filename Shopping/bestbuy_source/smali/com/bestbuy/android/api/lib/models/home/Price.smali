.class public Lcom/bestbuy/android/api/lib/models/home/Price;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x355a2f27164377fL


# instance fields
.field private currentPrice:Ljava/lang/String;

.field private freeShipping:Z

.field private onSale:Z

.field private priceType:Ljava/lang/String;

.field private pricingType:Ljava/lang/String;

.field private regularPrice:Ljava/lang/String;

.field private savingsAmount:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCurrentPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->currentPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->priceType:Ljava/lang/String;

    return-object v0
.end method

.method public getPricingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->pricingType:Ljava/lang/String;

    return-object v0
.end method

.method public getRegularPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->regularPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getSavingsAmount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->savingsAmount:Ljava/lang/String;

    return-object v0
.end method

.method public isFreeShipping()Z
    .locals 1

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->freeShipping:Z

    return v0
.end method

.method public isOnSale()Z
    .locals 1

    .prologue
    .line 52
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->onSale:Z

    return v0
.end method

.method public setCurrentPrice(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->currentPrice:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public setFreeShipping(Z)V
    .locals 0

    .prologue
    .line 100
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->freeShipping:Z

    .line 101
    return-void
.end method

.method public setOnSale(Z)V
    .locals 0

    .prologue
    .line 94
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->onSale:Z

    .line 95
    return-void
.end method

.method public setPriceType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->priceType:Ljava/lang/String;

    .line 107
    return-void
.end method

.method public setPricingType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->pricingType:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setRegularPrice(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->regularPrice:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setSavingsAmount(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Price;->savingsAmount:Ljava/lang/String;

    .line 89
    return-void
.end method
