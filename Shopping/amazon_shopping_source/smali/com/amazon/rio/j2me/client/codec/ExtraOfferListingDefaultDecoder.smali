.class public Lcom/amazon/rio/j2me/client/codec/ExtraOfferListingDefaultDecoder;
.super Ljava/lang/Object;
.source "ExtraOfferListingDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    .locals 12
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/32 v10, 0x7fffffff

    const-wide/32 v8, -0x80000000

    const/4 v7, 0x0

    .line 21
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;-><init>()V

    .line 26
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 27
    .local v1, "isAbsent":Z
    if-nez v1, :cond_0

    .line 29
    const-wide/16 v3, 0x2

    const-wide/16 v5, 0xa

    invoke-static {v3, v4, v5, v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 30
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setMerchantRating(Ljava/lang/Integer;)V

    .line 33
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 34
    if-nez v1, :cond_1

    .line 36
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 37
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setMerchantRatingMessage(Ljava/lang/String;)V

    .line 40
    .end local v0    # "data":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 41
    if-nez v1, :cond_2

    .line 43
    invoke-static {v8, v9, v10, v11}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 44
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setMerchantRatingCount(Ljava/lang/Integer;)V

    .line 47
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 48
    if-nez v1, :cond_3

    .line 50
    invoke-static {v8, v9, v10, v11}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 51
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setMerchantRatingPercentPositive(Ljava/lang/Integer;)V

    .line 54
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 55
    if-nez v1, :cond_4

    .line 57
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 58
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setComments(Ljava/lang/String;)V

    .line 61
    .end local v0    # "data":Ljava/lang/String;
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 62
    if-nez v1, :cond_5

    .line 64
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 65
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setShippingMessage(Ljava/lang/String;)V

    .line 68
    .end local v0    # "data":Ljava/lang/String;
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 69
    if-nez v1, :cond_6

    .line 71
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 72
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setShippingCharge(Ljava/lang/String;)V

    .line 75
    .end local v0    # "data":Ljava/lang/String;
    :cond_6
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 76
    if-nez v1, :cond_7

    .line 78
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 79
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setSnsDiscountPercent(Ljava/lang/String;)V

    .line 82
    .end local v0    # "data":Ljava/lang/String;
    :cond_7
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 83
    if-nez v1, :cond_8

    .line 85
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 86
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setSnsSignUpPrice(Ljava/lang/String;)V

    .line 89
    .end local v0    # "data":Ljava/lang/String;
    :cond_8
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 90
    if-nez v1, :cond_9

    .line 92
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 93
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->setSnsDiscountedPricePerUnit(Ljava/lang/String;)V

    .line 95
    .end local v0    # "data":Ljava/lang/String;
    :cond_9
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/ExtraOfferListingDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    move-result-object v0

    return-object v0
.end method
