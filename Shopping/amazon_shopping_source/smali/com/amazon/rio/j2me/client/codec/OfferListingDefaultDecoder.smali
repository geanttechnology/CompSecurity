.class public Lcom/amazon/rio/j2me/client/codec/OfferListingDefaultDecoder;
.super Ljava/lang/Object;
.source "OfferListingDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;
    .locals 5
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 21
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;-><init>()V

    .line 27
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 28
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 31
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 32
    .local v1, "isAbsent":Z
    if-nez v1, :cond_0

    .line 34
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickShippingOffersDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickShippingOffersDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickShippingOffersDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    move-result-object v0

    .line 35
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->setPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V

    .line 39
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    :cond_0
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/ExtraOfferListingDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/ExtraOfferListingDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/ExtraOfferListingDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    move-result-object v0

    .line 40
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->setExtraOffer(Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V

    .line 42
    return-object v2
.end method

.method public bridge synthetic decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/io/DataInputStream;
    .param p2, "x1"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/OfferListingDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    move-result-object v0

    return-object v0
.end method
