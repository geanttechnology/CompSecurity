.class public Lcom/amazon/rio/j2me/client/codec/HomeResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "HomeResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Ljava/lang/Object;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;
    .locals 8
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 22
    const/4 v4, 0x1

    new-array v2, v4, [I

    .line 43
    .local v2, "fieldPath":[I
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 44
    .local v3, "isAbsent":Z
    if-nez v3, :cond_0

    .line 46
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/LoginDataDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/LoginDataDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v7}, Lcom/amazon/rio/j2me/client/codec/LoginDataDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    move-result-object v0

    .line 47
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 49
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    :cond_0
    aget v4, v2, v6

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v6

    .line 52
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 53
    if-nez v3, :cond_1

    .line 55
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/PromoSlotDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/PromoSlotDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v7}, Lcom/amazon/rio/j2me/client/codec/PromoSlotDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    move-result-object v0

    .line 56
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 58
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    :cond_1
    aget v4, v2, v6

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v6

    .line 61
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 62
    if-nez v3, :cond_2

    .line 64
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/PromoSlotDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/PromoSlotDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v7}, Lcom/amazon/rio/j2me/client/codec/PromoSlotDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    move-result-object v0

    .line 65
    .restart local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 67
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    :cond_2
    aget v4, v2, v6

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v6

    .line 70
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 71
    if-nez v3, :cond_3

    .line 73
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/HomeShovelerDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/HomeShovelerDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v7}, Lcom/amazon/rio/j2me/client/codec/HomeShovelerDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v0

    .line 74
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 76
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    :cond_3
    aget v4, v2, v6

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v6

    .line 79
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 80
    if-nez v3, :cond_4

    .line 82
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/HomeShovelerDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/HomeShovelerDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v7}, Lcom/amazon/rio/j2me/client/codec/HomeShovelerDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v0

    .line 83
    .restart local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 85
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    :cond_4
    aget v4, v2, v6

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v6

    .line 88
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 89
    if-nez v3, :cond_5

    .line 91
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    new-instance v5, Lcom/amazon/rio/j2me/client/codec/HomeResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v5, p0, v2, p2}, Lcom/amazon/rio/j2me/client/codec/HomeResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/HomeResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 92
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p2, v1, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 94
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_5
    aget v4, v2, v6

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v6

    .line 97
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 98
    if-nez v3, :cond_6

    .line 100
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/CartItemsDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/CartItemsDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v7}, Lcom/amazon/rio/j2me/client/codec/CartItemsDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    move-result-object v0

    .line 101
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 103
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
    :cond_6
    aget v4, v2, v6

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v6

    .line 106
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 107
    if-nez v3, :cond_7

    .line 109
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/NotificationDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/NotificationDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v7}, Lcom/amazon/rio/j2me/client/codec/NotificationDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    move-result-object v0

    .line 110
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 112
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    :cond_7
    aget v4, v2, v6

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v6

    .line 113
    new-array v4, v6, [I

    invoke-interface {p2, v7, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 114
    return-object v7
.end method
