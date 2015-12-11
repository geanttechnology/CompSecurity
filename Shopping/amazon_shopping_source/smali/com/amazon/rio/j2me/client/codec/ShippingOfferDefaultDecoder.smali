.class public Lcom/amazon/rio/j2me/client/codec/ShippingOfferDefaultDecoder;
.super Ljava/lang/Object;
.source "ShippingOfferDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    .locals 8
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 21
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;-><init>()V

    .line 27
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 28
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->setName(Ljava/lang/String;)V

    .line 32
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 33
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->setShipOption(Ljava/lang/String;)V

    .line 36
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 37
    .local v1, "isAbsent":Z
    if-nez v1, :cond_0

    .line 39
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 40
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->setPrice(Ljava/lang/String;)V

    .line 43
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 44
    if-nez v1, :cond_1

    .line 46
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/DateDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/DateDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/DateDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v0

    .line 47
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->setDeliveryDate(Lcom/amazon/rio/j2me/client/services/mShop/Date;)V

    .line 50
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 51
    if-nez v1, :cond_2

    .line 53
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 54
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->setGetItText(Ljava/lang/String;)V

    .line 57
    .end local v0    # "data":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 58
    if-nez v1, :cond_3

    .line 60
    const-wide/32 v3, -0x80000000

    const-wide/32 v5, 0x7fffffff

    invoke-static {v3, v4, v5, v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 61
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->setRemainingMinutes(Ljava/lang/Integer;)V

    .line 63
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_3
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/ShippingOfferDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    move-result-object v0

    return-object v0
.end method
