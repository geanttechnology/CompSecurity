.class public Lcom/amazon/rio/j2me/client/codec/BasicProductInfoDefaultDecoder;
.super Ljava/lang/Object;
.source "BasicProductInfoDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
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
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;-><init>()V

    .line 27
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 28
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setAsin(Ljava/lang/String;)V

    .line 32
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 33
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setTitle(Ljava/lang/String;)V

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
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setShortDescription(Ljava/lang/String;)V

    .line 43
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 44
    if-nez v1, :cond_1

    .line 46
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 47
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setByLine(Ljava/lang/String;)V

    .line 50
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

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 54
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setProductGroupId(Ljava/lang/String;)V

    .line 57
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 58
    if-nez v1, :cond_3

    .line 60
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 61
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setBindingSymbol(Ljava/lang/String;)V

    .line 64
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 65
    if-nez v1, :cond_4

    .line 67
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 68
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setImageUrl(Ljava/lang/String;)V

    .line 72
    :cond_4
    const/4 v3, 0x5

    invoke-static {v3}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/Integer;

    .line 73
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setAvailabilityCondition(I)V

    .line 76
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 77
    if-nez v1, :cond_5

    .line 79
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/String;

    .line 80
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setListPrice(Ljava/lang/String;)V

    .line 83
    .end local v0    # "data":Ljava/lang/String;
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 84
    if-nez v1, :cond_6

    .line 86
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 87
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setVariationParentAsin(Ljava/lang/String;)V

    .line 90
    .end local v0    # "data":Ljava/lang/String;
    :cond_6
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 91
    if-nez v1, :cond_7

    .line 93
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 94
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setVariationPriceRange(Ljava/lang/String;)V

    .line 97
    .end local v0    # "data":Ljava/lang/String;
    :cond_7
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 98
    if-nez v1, :cond_8

    .line 100
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 101
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setDefaultParent(Ljava/lang/Boolean;)V

    .line 104
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_8
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 105
    if-nez v1, :cond_9

    .line 107
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v0

    .line 108
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setUsedAndNewSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V

    .line 111
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    :cond_9
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 112
    if-nez v1, :cond_a

    .line 114
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v0

    .line 115
    .restart local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setNewSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V

    .line 119
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    :cond_a
    invoke-static {v8, v9, v10, v11}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 120
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setImagesCount(I)V

    .line 123
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 124
    if-nez v1, :cond_b

    .line 126
    const-wide/16 v3, 0x2

    const-wide/16 v5, 0xa

    invoke-static {v3, v4, v5, v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Integer;

    .line 127
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setAverageOverallRating(Ljava/lang/Integer;)V

    .line 131
    :cond_b
    invoke-static {v8, v9, v10, v11}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Integer;

    .line 132
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setCustomerReviewsCount(I)V

    .line 135
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 136
    if-nez v1, :cond_c

    .line 138
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Boolean;

    .line 139
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setBlackCurtain(Ljava/lang/Boolean;)V

    .line 142
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_c
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 143
    if-nez v1, :cond_d

    .line 145
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 146
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->setTradeInPrice(Ljava/lang/String;)V

    .line 148
    .end local v0    # "data":Ljava/lang/String;
    :cond_d
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/BasicProductInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v0

    return-object v0
.end method
