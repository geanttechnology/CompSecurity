.class public Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x6da1aa53a2aa80a2L


# instance fields
.field private currentPrice:Ljava/lang/String;

.field private onSale:Z

.field private priceType:Ljava/lang/String;

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
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->currentPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->priceType:Ljava/lang/String;

    return-object v0
.end method

.method public getRegularPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->regularPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getSavingsAmount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->savingsAmount:Ljava/lang/String;

    return-object v0
.end method

.method public isOnSale()Z
    .locals 1

    .prologue
    .line 43
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->onSale:Z

    return v0
.end method

.method public setCurrentPrice(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->currentPrice:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setOnSale(Z)V
    .locals 0

    .prologue
    .line 73
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->onSale:Z

    .line 74
    return-void
.end method

.method public setPriceType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->priceType:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public setRegularPrice(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->regularPrice:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setSavingsAmount(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomOfferPrice;->savingsAmount:Ljava/lang/String;

    .line 68
    return-void
.end method
