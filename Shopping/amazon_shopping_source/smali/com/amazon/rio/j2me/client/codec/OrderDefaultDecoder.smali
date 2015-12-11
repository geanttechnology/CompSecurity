.class public Lcom/amazon/rio/j2me/client/codec/OrderDefaultDecoder;
.super Ljava/lang/Object;
.source "OrderDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/Order;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Order;
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
    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/Order;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/services/mShop/Order;-><init>()V

    .line 26
    .local v6, "record":Lcom/amazon/rio/j2me/client/services/mShop/Order;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 27
    .local v5, "isAbsent":Z
    if-nez v5, :cond_0

    .line 29
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v7

    invoke-interface {v7, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 30
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v6, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Order;->setOrderId(Ljava/lang/String;)V

    .line 33
    .end local v0    # "data":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 34
    if-nez v5, :cond_1

    .line 36
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v7

    invoke-interface {v7, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 37
    .local v4, "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v6, v4}, Lcom/amazon/rio/j2me/client/services/mShop/Order;->setStatus(Ljava/util/List;)V

    .line 40
    .end local v4    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 41
    if-nez v5, :cond_2

    .line 43
    new-instance v7, Lcom/amazon/rio/j2me/client/codec/ItemDefaultDecoder;

    invoke-direct {v7}, Lcom/amazon/rio/j2me/client/codec/ItemDefaultDecoder;-><init>()V

    invoke-static {v7}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v7

    invoke-interface {v7, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 44
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Item;>;"
    invoke-virtual {v6, v1}, Lcom/amazon/rio/j2me/client/services/mShop/Order;->setItem(Ljava/util/List;)V

    .line 47
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Item;>;"
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 48
    if-nez v5, :cond_3

    .line 50
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v7

    invoke-interface {v7, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 51
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v6, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Order;->setMerchantName(Ljava/lang/String;)V

    .line 54
    .end local v0    # "data":Ljava/lang/String;
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 55
    if-nez v5, :cond_4

    .line 57
    new-instance v7, Lcom/amazon/rio/j2me/client/codec/ShippingOptionDefaultDecoder;

    invoke-direct {v7}, Lcom/amazon/rio/j2me/client/codec/ShippingOptionDefaultDecoder;-><init>()V

    invoke-static {v7}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v7

    invoke-interface {v7, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 58
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;>;"
    invoke-virtual {v6, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Order;->setShippingOption(Ljava/util/List;)V

    .line 61
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;>;"
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 62
    if-nez v5, :cond_5

    .line 64
    new-instance v7, Lcom/amazon/rio/j2me/client/codec/ShippingSpeedDefaultDecoder;

    invoke-direct {v7}, Lcom/amazon/rio/j2me/client/codec/ShippingSpeedDefaultDecoder;-><init>()V

    invoke-static {v7}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v7

    invoke-interface {v7, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 65
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;>;"
    invoke-virtual {v6, v3}, Lcom/amazon/rio/j2me/client/services/mShop/Order;->setShippingSpeed(Ljava/util/List;)V

    .line 68
    .end local v3    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;>;"
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 69
    if-nez v5, :cond_6

    .line 71
    new-instance v7, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;

    invoke-direct {v7}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;-><init>()V

    invoke-virtual {v7, p1, v8}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    .line 72
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    invoke-virtual {v6, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Order;->setShippingMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V

    .line 74
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :cond_6
    return-object v6
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/OrderDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Order;

    move-result-object v0

    return-object v0
.end method
