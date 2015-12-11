.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field public static final BUNDLE:Ljava/lang/String; = "bundle"

.field public static final CLEARANCE:Ljava/lang/String; = "clearance"

.field public static final COMING_SOON:Ljava/lang/String; = "ComingSoon"

.field public static final CONTRACT_2_YEARS_NEW:Ljava/lang/String; = "2_YEARS_NEW"

.field public static final CONTRACT_2_YEARS_UPGRADE:Ljava/lang/String; = "2_YEARS_UPGRADE"

.field public static final ICR_HIDE_PRICE:Ljava/lang/String; = "ICR-hidePrice"

.field public static final ICR_NO_PRICE:Ljava/lang/String; = "ICR-noPrice"

.field public static final ICR_STRIKE_THROUGH:Ljava/lang/String; = "ICR-strikeThrough"

.field public static final MAP:Ljava/lang/String; = "MAP"

.field public static final ONSALE:Ljava/lang/String; = "onSale"

.field public static final REFURBISHED:Ljava/lang/String; = "refurbished"

.field public static final REGULAR:Ljava/lang/String; = "regular"

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private currentPrice:D

.field private firstOrderDate:Ljava/lang/String;

.field private ibPricing:Z

.field private listingId:Ljava/lang/String;

.field private minimumPriceDisplay:D

.field private originalPricingType:Ljava/lang/String;

.field private pricingType:Ljava/lang/String;

.field private regularPrice:D

.field private savingsAmount:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCurrentPrice()D
    .locals 2

    .prologue
    .line 54
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->currentPrice:D

    return-wide v0
.end method

.method public getFirstOrderDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->firstOrderDate:Ljava/lang/String;

    return-object v0
.end method

.method public getListingId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->listingId:Ljava/lang/String;

    return-object v0
.end method

.method public getMinimumPriceDisplay()D
    .locals 2

    .prologue
    .line 97
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->minimumPriceDisplay:D

    return-wide v0
.end method

.method public getOriginalPricingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->originalPricingType:Ljava/lang/String;

    return-object v0
.end method

.method public getPricingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->pricingType:Ljava/lang/String;

    return-object v0
.end method

.method public getRegularPrice()D
    .locals 2

    .prologue
    .line 81
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->regularPrice:D

    return-wide v0
.end method

.method public getSavingsAmount()D
    .locals 2

    .prologue
    .line 89
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->savingsAmount:D

    return-wide v0
.end method

.method public isIbPricing()Z
    .locals 1

    .prologue
    .line 113
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->ibPricing:Z

    return v0
.end method

.method public setCurrentPrice(D)V
    .locals 1

    .prologue
    .line 69
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->currentPrice:D

    .line 70
    return-void
.end method

.method public setFirstOrderDate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->firstOrderDate:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setIbPricing(Z)V
    .locals 0

    .prologue
    .line 117
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->ibPricing:Z

    .line 118
    return-void
.end method

.method public setListingId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->listingId:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setMinimumPriceDisplay(D)V
    .locals 1

    .prologue
    .line 101
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->minimumPriceDisplay:D

    .line 102
    return-void
.end method

.method public setOriginalPricingType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->originalPricingType:Ljava/lang/String;

    .line 128
    return-void
.end method

.method public setPricingType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->pricingType:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setRegularPrice(D)V
    .locals 1

    .prologue
    .line 85
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->regularPrice:D

    .line 86
    return-void
.end method

.method public setSavingsAmount(D)V
    .locals 1

    .prologue
    .line 93
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->savingsAmount:D

    .line 94
    return-void
.end method
