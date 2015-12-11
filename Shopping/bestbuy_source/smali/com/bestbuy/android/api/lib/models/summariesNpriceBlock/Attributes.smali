.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private lowPriceGuaranteedProduct:Z

.field private marketplace:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "marketplaceProduct"
    .end annotation
.end field

.field private onlineOnly:Z

.field private parentalAdvisory:Z

.field private specialOrderDelivery:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isLowPriceGuaranteedProduct()Z
    .locals 1

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->lowPriceGuaranteedProduct:Z

    return v0
.end method

.method public isMarketplace()Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->marketplace:Z

    return v0
.end method

.method public isOnlineOnly()Z
    .locals 1

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->onlineOnly:Z

    return v0
.end method

.method public isParentalAdvisory()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->parentalAdvisory:Z

    return v0
.end method

.method public isSpecialOrderDelivery()Z
    .locals 1

    .prologue
    .line 66
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->specialOrderDelivery:Z

    return v0
.end method

.method public setLowPriceGuaranteedProduct(Z)V
    .locals 0

    .prologue
    .line 62
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->lowPriceGuaranteedProduct:Z

    .line 63
    return-void
.end method

.method public setMarketplace(Z)V
    .locals 0

    .prologue
    .line 54
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->marketplace:Z

    .line 55
    return-void
.end method

.method public setOnlineOnly(Z)V
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->onlineOnly:Z

    .line 47
    return-void
.end method

.method public setParentalAdvisory(Z)V
    .locals 0

    .prologue
    .line 31
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->parentalAdvisory:Z

    .line 32
    return-void
.end method

.method public setSpecialOrderDelivery(Z)V
    .locals 0

    .prologue
    .line 70
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->specialOrderDelivery:Z

    .line 71
    return-void
.end method
