.class public Lcom/amazon/rio/j2me/client/codec/DealDefaultDecoder;
.super Ljava/lang/Object;
.source "DealDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/Deal;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Deal;
    .locals 10
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    new-instance v5, Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;-><init>()V

    .line 26
    .local v5, "record":Lcom/amazon/rio/j2me/client/services/mShop/Deal;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 27
    .local v4, "isAbsent":Z
    if-nez v4, :cond_0

    .line 29
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 30
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setAsin(Ljava/lang/String;)V

    .line 33
    .end local v0    # "data":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 34
    if-nez v4, :cond_1

    .line 36
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 37
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setOfferId(Ljava/lang/String;)V

    .line 40
    .end local v0    # "data":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 41
    if-nez v4, :cond_2

    .line 43
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 44
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setDealId(Ljava/lang/String;)V

    .line 47
    .end local v0    # "data":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 48
    if-nez v4, :cond_3

    .line 50
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 51
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setTitle(Ljava/lang/String;)V

    .line 54
    .end local v0    # "data":Ljava/lang/String;
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 55
    if-nez v4, :cond_4

    .line 57
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 58
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setDesc(Ljava/lang/String;)V

    .line 61
    .end local v0    # "data":Ljava/lang/String;
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 62
    if-nez v4, :cond_5

    .line 64
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 65
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setIsRedeemedToCustomer(Ljava/lang/Boolean;)V

    .line 68
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 69
    if-nez v4, :cond_6

    .line 71
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 72
    .restart local v0    # "data":Ljava/lang/Boolean;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setIsSoldOut(Ljava/lang/Boolean;)V

    .line 75
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_6
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 76
    if-nez v4, :cond_7

    .line 78
    const-wide/32 v6, -0x80000000

    const-wide/32 v8, 0x7fffffff

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 79
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setPercentageSold(Ljava/lang/Integer;)V

    .line 82
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_7
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 83
    if-nez v4, :cond_8

    .line 85
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 86
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setTotalAvailable(Ljava/lang/String;)V

    .line 89
    .end local v0    # "data":Ljava/lang/String;
    :cond_8
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 90
    if-nez v4, :cond_9

    .line 92
    const-wide/32 v6, -0x80000000

    const-wide/32 v8, 0x7fffffff

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 93
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setMsToCacheExpires(Ljava/lang/Integer;)V

    .line 96
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_9
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 97
    if-nez v4, :cond_a

    .line 99
    const-wide/32 v6, -0x80000000

    const-wide/32 v8, 0x7fffffff

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 100
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setMsToStart(Ljava/lang/Integer;)V

    .line 103
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_a
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 104
    if-nez v4, :cond_b

    .line 106
    const-wide/32 v6, -0x80000000

    const-wide/32 v8, 0x7fffffff

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 107
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setStartTime(Ljava/lang/Integer;)V

    .line 110
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_b
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 111
    if-nez v4, :cond_c

    .line 113
    const-wide/32 v6, -0x80000000

    const-wide/32 v8, 0x7fffffff

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 114
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setMsToEnd(Ljava/lang/Integer;)V

    .line 117
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_c
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 118
    if-nez v4, :cond_d

    .line 120
    const-wide/32 v6, -0x80000000

    const-wide/32 v8, 0x7fffffff

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 121
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setEndTime(Ljava/lang/Integer;)V

    .line 124
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_d
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 125
    if-nez v4, :cond_e

    .line 127
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/SavingsDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/SavingsDefaultDecoder;-><init>()V

    const/4 v7, 0x0

    invoke-virtual {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/SavingsDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v0

    .line 128
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/Savings;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setSavings(Lcom/amazon/rio/j2me/client/services/mShop/Savings;)V

    .line 131
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Savings;
    :cond_e
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 132
    if-nez v4, :cond_f

    .line 134
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 135
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setUrl(Ljava/lang/String;)V

    .line 138
    .end local v0    # "data":Ljava/lang/String;
    :cond_f
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 139
    if-nez v4, :cond_10

    .line 141
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/CustomerDealPurchaseStatusDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/CustomerDealPurchaseStatusDefaultDecoder;-><init>()V

    const/4 v7, 0x0

    invoke-virtual {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/CustomerDealPurchaseStatusDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;

    move-result-object v0

    .line 142
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setCustomerPurchaseStatus(Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;)V

    .line 145
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;
    :cond_10
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 146
    if-nez v4, :cond_11

    .line 148
    const-wide/16 v6, 0x2

    const-wide/16 v8, 0xa

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 149
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setAverageOverallRating(Ljava/lang/Integer;)V

    .line 152
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_11
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 153
    if-nez v4, :cond_12

    .line 155
    const-wide/32 v6, -0x80000000

    const-wide/32 v8, 0x7fffffff

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 156
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setCustomerReviewsCount(Ljava/lang/Integer;)V

    .line 159
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_12
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 160
    if-nez v4, :cond_13

    .line 162
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 163
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setEligibleForPrimeShipping(Ljava/lang/Boolean;)V

    .line 166
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_13
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 167
    if-nez v4, :cond_14

    .line 169
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 170
    .restart local v0    # "data":Ljava/lang/Boolean;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setPriceViolatesMap(Ljava/lang/Boolean;)V

    .line 173
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_14
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 174
    if-nez v4, :cond_15

    .line 176
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getOctetArrayInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    .line 177
    .local v0, "data":[B
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setImage([B)V

    .line 180
    .end local v0    # "data":[B
    :cond_15
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 181
    if-nez v4, :cond_16

    .line 183
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 184
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setImageName(Ljava/lang/String;)V

    .line 187
    .end local v0    # "data":Ljava/lang/String;
    :cond_16
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 188
    if-nez v4, :cond_17

    .line 190
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/DimensionDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/DimensionDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 191
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Dimension;>;"
    invoke-virtual {v5, v1}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setDealVariationDimensions(Ljava/util/List;)V

    .line 194
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Dimension;>;"
    :cond_17
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 195
    if-nez v4, :cond_18

    .line 197
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/VariationProductInfoDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/VariationProductInfoDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 198
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;>;"
    invoke-virtual {v5, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setDealVariationChildren(Ljava/util/List;)V

    .line 201
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;>;"
    :cond_18
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 202
    if-nez v4, :cond_19

    .line 204
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/VisualBucketDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/VisualBucketDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 205
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;>;"
    invoke-virtual {v5, v3}, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->setVisualBuckets(Ljava/util/List;)V

    .line 207
    .end local v3    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;>;"
    :cond_19
    return-object v5
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/DealDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    move-result-object v0

    return-object v0
.end method
