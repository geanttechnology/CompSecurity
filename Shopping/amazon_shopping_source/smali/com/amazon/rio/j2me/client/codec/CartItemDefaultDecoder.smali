.class public Lcom/amazon/rio/j2me/client/codec/CartItemDefaultDecoder;
.super Ljava/lang/Object;
.source "CartItemDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/CartItem;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    .locals 10
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/32 v8, 0x7fffffff

    const-wide/32 v6, -0x80000000

    const/4 v5, 0x0

    .line 21
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;-><init>()V

    .line 27
    .local v3, "record":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 28
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setItemId(Ljava/lang/String;)V

    .line 32
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 33
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setOfferId(Ljava/lang/String;)V

    .line 37
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 38
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setAsin(Ljava/lang/String;)V

    .line 42
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 43
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setTitle(Ljava/lang/String;)V

    .line 46
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 47
    .local v2, "isAbsent":Z
    if-nez v2, :cond_0

    .line 49
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 50
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setShortDescription(Ljava/lang/String;)V

    .line 54
    :cond_0
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 55
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setPrice(Ljava/lang/String;)V

    .line 59
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/Integer;

    .line 60
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setQuantity(I)V

    .line 63
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 64
    if-nez v2, :cond_1

    .line 66
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 67
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setMessages(Ljava/util/List;)V

    .line 71
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Boolean;

    .line 72
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setIsSavedItem(Z)V

    .line 76
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Boolean;
    check-cast v0, Ljava/lang/Boolean;

    .line 77
    .restart local v0    # "data":Ljava/lang/Boolean;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setIsQuantityEditable(Z)V

    .line 80
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 81
    if-nez v2, :cond_2

    .line 83
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Boolean;
    check-cast v0, Ljava/lang/String;

    .line 84
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setPoints(Ljava/lang/String;)V

    .line 87
    .end local v0    # "data":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 88
    if-nez v2, :cond_3

    .line 90
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 91
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setMsToExpiry(Ljava/lang/Integer;)V

    .line 94
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 95
    if-nez v2, :cond_4

    .line 97
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 98
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setImageUrl(Ljava/lang/String;)V

    .line 101
    .end local v0    # "data":Ljava/lang/String;
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 102
    if-nez v2, :cond_5

    .line 104
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 105
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setByLine(Ljava/lang/String;)V

    .line 108
    .end local v0    # "data":Ljava/lang/String;
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 109
    if-nez v2, :cond_6

    .line 111
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 112
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setShippingCharge(Ljava/lang/String;)V

    .line 115
    .end local v0    # "data":Ljava/lang/String;
    :cond_6
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 116
    if-nez v2, :cond_7

    .line 118
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 119
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setDeprecatedEligibleForPrimeShipping(Ljava/lang/Boolean;)V

    .line 122
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_7
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 123
    if-nez v2, :cond_8

    .line 125
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 126
    .restart local v0    # "data":Ljava/lang/Boolean;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setEligibleForSuperSaverShipping(Ljava/lang/Boolean;)V

    .line 129
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_8
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 130
    if-nez v2, :cond_9

    .line 132
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 133
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setBinding(Ljava/lang/String;)V

    .line 136
    .end local v0    # "data":Ljava/lang/String;
    :cond_9
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 137
    if-nez v2, :cond_a

    .line 139
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/MerchantInfoDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/MerchantInfoDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/MerchantInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    move-result-object v0

    .line 140
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setMerchantInfo(Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;)V

    .line 143
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    :cond_a
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 144
    if-nez v2, :cond_b

    .line 146
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/BadgeDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/BadgeDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/BadgeDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v0

    .line 147
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/Badge;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setBadge(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)V

    .line 150
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Badge;
    :cond_b
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 151
    if-nez v2, :cond_c

    .line 153
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 154
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->setIsMinimumThresholdRequired(Ljava/lang/Boolean;)V

    .line 156
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_c
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/CartItemDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    move-result-object v0

    return-object v0
.end method
