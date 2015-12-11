.class public Lcom/amazon/rio/j2me/client/codec/AddListItemsResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "AddListItemsResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;
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
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;-><init>()V

    .line 26
    .local v3, "record":Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 27
    .local v2, "isAbsent":Z
    if-nez v2, :cond_0

    .line 29
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/ListListDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/ListListDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/ListListDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    move-result-object v0

    .line 30
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;->setAffectedRegistry(Lcom/amazon/rio/j2me/client/services/mShop/ListList;)V

    .line 33
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 34
    if-nez v2, :cond_1

    .line 36
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/ListItemDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/ListItemDefaultDecoder;-><init>()V

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 37
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ListItem;>;"
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;->setAddedItems(Ljava/util/List;)V

    .line 40
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ListItem;>;"
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 41
    if-nez v2, :cond_2

    .line 43
    const/4 v4, 0x2

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 44
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;->setErrorCode(Ljava/lang/Integer;)V

    .line 46
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_2
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/AddListItemsResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;

    move-result-object v0

    return-object v0
.end method
