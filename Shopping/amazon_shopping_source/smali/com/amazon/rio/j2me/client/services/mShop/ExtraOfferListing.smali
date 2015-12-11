.class public Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
.super Ljava/lang/Object;
.source "ExtraOfferListing.java"


# instance fields
.field private comments:Ljava/lang/String;

.field private merchantRating:Ljava/lang/Integer;

.field private merchantRatingCount:Ljava/lang/Integer;

.field private merchantRatingMessage:Ljava/lang/String;

.field private merchantRatingPercentPositive:Ljava/lang/Integer;

.field private shippingCharge:Ljava/lang/String;

.field private shippingMessage:Ljava/lang/String;

.field private snsDiscountPercent:Ljava/lang/String;

.field private snsDiscountedPricePerUnit:Ljava/lang/String;

.field private snsSignUpPrice:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getComments()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->comments:Ljava/lang/String;

    return-object v0
.end method

.method public getMerchantRatingCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->merchantRatingCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMerchantRatingMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->merchantRatingMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getMerchantRatingPercentPositive()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->merchantRatingPercentPositive:Ljava/lang/Integer;

    return-object v0
.end method

.method public getShippingCharge()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->shippingCharge:Ljava/lang/String;

    return-object v0
.end method

.method public getSnsDiscountPercent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->snsDiscountPercent:Ljava/lang/String;

    return-object v0
.end method

.method public setComments(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->comments:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setMerchantRating(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->merchantRating:Ljava/lang/Integer;

    .line 35
    return-void
.end method

.method public setMerchantRatingCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->merchantRatingCount:Ljava/lang/Integer;

    .line 61
    return-void
.end method

.method public setMerchantRatingMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->merchantRatingMessage:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setMerchantRatingPercentPositive(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->merchantRatingPercentPositive:Ljava/lang/Integer;

    .line 74
    return-void
.end method

.method public setShippingCharge(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->shippingCharge:Ljava/lang/String;

    .line 113
    return-void
.end method

.method public setShippingMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->shippingMessage:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setSnsDiscountPercent(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->snsDiscountPercent:Ljava/lang/String;

    .line 126
    return-void
.end method

.method public setSnsDiscountedPricePerUnit(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->snsDiscountedPricePerUnit:Ljava/lang/String;

    .line 152
    return-void
.end method

.method public setSnsSignUpPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 138
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->snsSignUpPrice:Ljava/lang/String;

    .line 139
    return-void
.end method
