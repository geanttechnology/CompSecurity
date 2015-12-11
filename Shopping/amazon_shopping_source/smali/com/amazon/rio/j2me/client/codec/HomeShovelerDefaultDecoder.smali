.class public Lcom/amazon/rio/j2me/client/codec/HomeShovelerDefaultDecoder;
.super Ljava/lang/Object;
.source "HomeShovelerDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
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
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;-><init>()V

    .line 26
    .local v3, "record":Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 27
    .local v2, "isAbsent":Z
    if-nez v2, :cond_0

    .line 29
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 30
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setTitle(Ljava/lang/String;)V

    .line 33
    .end local v0    # "data":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 34
    if-nez v2, :cond_1

    .line 36
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 37
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setSeedSubtitle(Ljava/lang/String;)V

    .line 40
    .end local v0    # "data":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 41
    if-nez v2, :cond_2

    .line 43
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 44
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setItemsSubtitle(Ljava/lang/String;)V

    .line 47
    .end local v0    # "data":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 48
    if-nez v2, :cond_3

    .line 50
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/HomeItemDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/HomeItemDefaultDecoder;-><init>()V

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 51
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setSeedItems(Ljava/util/List;)V

    .line 54
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 55
    if-nez v2, :cond_4

    .line 57
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/HomeItemDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/HomeItemDefaultDecoder;-><init>()V

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 58
    .restart local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setItems(Ljava/util/List;)V

    .line 61
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;>;"
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 62
    if-nez v2, :cond_5

    .line 64
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 65
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setMoreLinkText(Ljava/lang/String;)V

    .line 68
    .end local v0    # "data":Ljava/lang/String;
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 69
    if-nez v2, :cond_6

    .line 71
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v0

    .line 72
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setMoreLink(Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;)V

    .line 75
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;
    :cond_6
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 76
    if-nez v2, :cond_7

    .line 78
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 79
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setSlotToken(Ljava/lang/String;)V

    .line 82
    .end local v0    # "data":Ljava/lang/String;
    :cond_7
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 83
    if-nez v2, :cond_8

    .line 85
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 86
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 89
    .end local v0    # "data":Ljava/lang/String;
    :cond_8
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 90
    if-nez v2, :cond_9

    .line 92
    const/4 v4, 0x2

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 93
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->setDisplayType(Ljava/lang/Integer;)V

    .line 95
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_9
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/HomeShovelerDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v0

    return-object v0
.end method
