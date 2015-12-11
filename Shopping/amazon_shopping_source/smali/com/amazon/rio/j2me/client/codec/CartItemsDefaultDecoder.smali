.class public Lcom/amazon/rio/j2me/client/codec/CartItemsDefaultDecoder;
.super Ljava/lang/Object;
.source "CartItemsDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/CartItems;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
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
    new-instance v5, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;-><init>()V

    .line 27
    .local v5, "record":Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/CartItemDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/CartItemDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 28
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    invoke-virtual {v5, v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setCartItem(Ljava/util/List;)V

    .line 32
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 33
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setSubtotal(Ljava/lang/String;)V

    .line 36
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 37
    .local v4, "isAbsent":Z
    if-nez v4, :cond_0

    .line 39
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 40
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v5, v3}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setMessages(Ljava/util/List;)V

    .line 43
    .end local v3    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 44
    if-nez v4, :cond_1

    .line 46
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 47
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    invoke-virtual {v5, v2}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setAlertMessages(Ljava/util/List;)V

    .line 50
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 51
    if-nez v4, :cond_2

    .line 53
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 54
    .restart local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    invoke-virtual {v5, v2}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setAlertMessagesDetailed(Ljava/util/List;)V

    .line 57
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 58
    if-nez v4, :cond_3

    .line 60
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 61
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setPointsTotal(Ljava/lang/String;)V

    .line 64
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 65
    if-nez v4, :cond_4

    .line 67
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;-><init>()V

    invoke-virtual {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v0

    .line 68
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setCartButtonUri(Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;)V

    .line 71
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 72
    if-nez v4, :cond_5

    .line 74
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/ButtonInfoDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/ButtonInfoDefaultDecoder;-><init>()V

    invoke-virtual {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/ButtonInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;

    move-result-object v0

    .line 75
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setAlternateCartButton(Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;)V

    .line 78
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 79
    if-nez v4, :cond_6

    .line 81
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/InterstitialCartItemsInfoDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/InterstitialCartItemsInfoDefaultDecoder;-><init>()V

    invoke-virtual {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/InterstitialCartItemsInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;

    move-result-object v0

    .line 82
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;
    invoke-virtual {v5, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->setInterstitialCartInfo(Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;)V

    .line 84
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;
    :cond_6
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/CartItemsDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    move-result-object v0

    return-object v0
.end method
