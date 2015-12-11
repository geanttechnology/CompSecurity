.class public Lcom/amazon/rio/j2me/client/codec/PrimeOneClickShippingOffersDefaultDecoder;
.super Ljava/lang/Object;
.source "PrimeOneClickShippingOffersDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    .locals 6
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 21
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;-><init>()V

    .line 27
    .local v3, "record":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/ShippingOfferDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/ShippingOfferDefaultDecoder;-><init>()V

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 28
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;>;"
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->setShippingOffers(Ljava/util/List;)V

    .line 31
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 32
    .local v2, "isAbsent":Z
    if-nez v2, :cond_0

    .line 34
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 35
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->setNote(Ljava/lang/String;)V

    .line 37
    .end local v0    # "data":Ljava/lang/String;
    :cond_0
    return-object v3
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickShippingOffersDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    move-result-object v0

    return-object v0
.end method
