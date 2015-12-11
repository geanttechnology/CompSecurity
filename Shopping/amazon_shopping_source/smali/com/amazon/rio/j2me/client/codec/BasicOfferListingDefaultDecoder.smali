.class public Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;
.super Ljava/lang/Object;
.source "BasicOfferListingDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .locals 9
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 21
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;-><init>()V

    .line 27
    .local v3, "record":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 28
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setOfferId(Ljava/lang/String;)V

    .line 32
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/MerchantInfoDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/MerchantInfoDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/MerchantInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    move-result-object v0

    .line 33
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setMerchantInfo(Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;)V

    .line 37
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    check-cast v0, Ljava/lang/String;

    .line 38
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setCondition(Ljava/lang/String;)V

    .line 42
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 43
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setConditionType(Ljava/lang/String;)V

    .line 47
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 48
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setPrice(Ljava/lang/String;)V

    .line 51
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 52
    .local v2, "isAbsent":Z
    if-nez v2, :cond_0

    .line 54
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 55
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setPriceMessage(Ljava/lang/String;)V

    .line 59
    :cond_0
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/Boolean;

    .line 60
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setPriceViolatesMap(Z)V

    .line 63
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 64
    if-nez v2, :cond_1

    .line 66
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Boolean;
    check-cast v0, Ljava/lang/String;

    .line 67
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setPriceSavings(Ljava/lang/String;)V

    .line 70
    .end local v0    # "data":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 71
    if-nez v2, :cond_2

    .line 73
    const-wide/32 v4, -0x80000000

    const-wide/32 v6, 0x7fffffff

    invoke-static {v4, v5, v6, v7}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 74
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setPercentSavings(Ljava/lang/Integer;)V

    .line 78
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_2
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 79
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setGiftWrapAvailable(Z)V

    .line 83
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Boolean;
    check-cast v0, Ljava/lang/Boolean;

    .line 84
    .restart local v0    # "data":Ljava/lang/Boolean;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setEligibleForSuperSaverShipping(Z)V

    .line 88
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Boolean;
    check-cast v0, Ljava/lang/Boolean;

    .line 89
    .restart local v0    # "data":Ljava/lang/Boolean;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setDeprecatedEligibleForPrimeShipping(Z)V

    .line 93
    const/4 v4, 0x3

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Boolean;
    check-cast v0, Ljava/lang/Integer;

    .line 94
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setAvailabilityCondition(I)V

    .line 98
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;-><init>()V

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 99
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setAvailabilityMessages(Ljava/util/List;)V

    .line 102
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 103
    if-nez v2, :cond_3

    .line 105
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/ShippingOfferDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/ShippingOfferDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/ShippingOfferDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    move-result-object v0

    .line 106
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setShippingOffer(Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;)V

    .line 109
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 110
    if-nez v2, :cond_4

    .line 112
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/SpecialOfferDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/SpecialOfferDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/SpecialOfferDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;

    move-result-object v0

    .line 113
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setSpecialOffer(Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;)V

    .line 116
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 117
    if-nez v2, :cond_5

    .line 119
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 120
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setFulfilledBy(Ljava/lang/String;)V

    .line 123
    .end local v0    # "data":Ljava/lang/String;
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 124
    if-nez v2, :cond_6

    .line 126
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 127
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setPoints(Ljava/lang/String;)V

    .line 130
    .end local v0    # "data":Ljava/lang/String;
    :cond_6
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 131
    if-nez v2, :cond_7

    .line 133
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/PricePerUnitDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/PricePerUnitDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/PricePerUnitDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;

    move-result-object v0

    .line 134
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setPricePerUnit(Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;)V

    .line 137
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;
    :cond_7
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 138
    if-nez v2, :cond_8

    .line 140
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/BadgeInfoDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/BadgeInfoDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/BadgeInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    .line 141
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->setBadgeInfo(Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;)V

    .line 143
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    :cond_8
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    return-object v0
.end method
