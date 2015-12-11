.class public Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
.super Ljava/lang/Object;
.source "BasicOfferListing.java"


# instance fields
.field private availabilityCondition:I

.field private availabilityMessages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation
.end field

.field private badgeInfo:Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

.field private condition:Ljava/lang/String;

.field private conditionType:Ljava/lang/String;

.field private deprecatedEligibleForPrimeShipping:Z

.field private eligibleForSuperSaverShipping:Z

.field private fulfilledBy:Ljava/lang/String;

.field private giftWrapAvailable:Z

.field private merchantInfo:Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

.field private offerId:Ljava/lang/String;

.field private percentSavings:Ljava/lang/Integer;

.field private points:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private priceMessage:Ljava/lang/String;

.field private pricePerUnit:Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;

.field private priceSavings:Ljava/lang/String;

.field private priceViolatesMap:Z

.field private shippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

.field private specialOffer:Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailabilityCondition()I
    .locals 1

    .prologue
    .line 165
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->availabilityCondition:I

    return v0
.end method

.method public getAvailabilityMessages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->availabilityMessages:Ljava/util/List;

    return-object v0
.end method

.method public getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    .locals 1

    .prologue
    .line 253
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->badgeInfo:Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getEligibleForSuperSaverShipping()Z
    .locals 1

    .prologue
    .line 145
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->eligibleForSuperSaverShipping:Z

    return v0
.end method

.method public getMerchantInfo()Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->merchantInfo:Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getPoints()Ljava/lang/String;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->points:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->priceMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getPricePerUnit()Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->pricePerUnit:Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;

    return-object v0
.end method

.method public getPriceViolatesMap()Z
    .locals 1

    .prologue
    .line 99
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->priceViolatesMap:Z

    return v0
.end method

.method public getShippingOffer()Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->shippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    return-object v0
.end method

.method public setAvailabilityCondition(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 170
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->availabilityCondition:I

    .line 171
    return-void
.end method

.method public setAvailabilityMessages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 180
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->availabilityMessages:Ljava/util/List;

    .line 181
    return-void
.end method

.method public setBadgeInfo(Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    .prologue
    .line 258
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->badgeInfo:Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    .line 259
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->condition:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setConditionType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->conditionType:Ljava/lang/String;

    .line 72
    return-void
.end method

.method public setDeprecatedEligibleForPrimeShipping(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 160
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->deprecatedEligibleForPrimeShipping:Z

    .line 161
    return-void
.end method

.method public setEligibleForSuperSaverShipping(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 150
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->eligibleForSuperSaverShipping:Z

    .line 151
    return-void
.end method

.method public setFulfilledBy(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 219
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->fulfilledBy:Ljava/lang/String;

    .line 220
    return-void
.end method

.method public setGiftWrapAvailable(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 140
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->giftWrapAvailable:Z

    .line 141
    return-void
.end method

.method public setMerchantInfo(Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->merchantInfo:Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    .line 52
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->offerId:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setPercentSavings(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 130
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->percentSavings:Ljava/lang/Integer;

    .line 131
    return-void
.end method

.method public setPoints(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 232
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->points:Ljava/lang/String;

    .line 233
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->price:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setPriceMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 94
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->priceMessage:Ljava/lang/String;

    .line 95
    return-void
.end method

.method public setPricePerUnit(Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;

    .prologue
    .line 245
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->pricePerUnit:Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;

    .line 246
    return-void
.end method

.method public setPriceSavings(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->priceSavings:Ljava/lang/String;

    .line 118
    return-void
.end method

.method public setPriceViolatesMap(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 104
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->priceViolatesMap:Z

    .line 105
    return-void
.end method

.method public setShippingOffer(Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    .prologue
    .line 193
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->shippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    .line 194
    return-void
.end method

.method public setSpecialOffer(Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;

    .prologue
    .line 206
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->specialOffer:Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;

    .line 207
    return-void
.end method
