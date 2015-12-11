.class public Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;
.super Ljava/lang/Object;
.source "OfferListing.java"


# instance fields
.field private basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

.field private extraOffer:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

.field private primeOneClickShippingOffers:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    return-object v0
.end method

.method public getExtraOffer()Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->extraOffer:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    return-object v0
.end method

.method public getPrimeOneClickShippingOffers()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->primeOneClickShippingOffers:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    return-object v0
.end method

.method public setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .line 25
    return-void
.end method

.method public setExtraOffer(Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->extraOffer:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .line 48
    return-void
.end method

.method public setPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->primeOneClickShippingOffers:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    .line 38
    return-void
.end method
