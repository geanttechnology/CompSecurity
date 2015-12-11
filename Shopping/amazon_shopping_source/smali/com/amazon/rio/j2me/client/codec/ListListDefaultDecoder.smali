.class public Lcom/amazon/rio/j2me/client/codec/ListListDefaultDecoder;
.super Ljava/lang/Object;
.source "ListListDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/ListList;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    .locals 5
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 21
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;-><init>()V

    .line 27
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 28
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->setListId(Ljava/lang/String;)V

    .line 32
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 33
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->setListTitle(Ljava/lang/String;)V

    .line 36
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 37
    .local v1, "isAbsent":Z
    if-nez v1, :cond_0

    .line 39
    const/4 v3, 0x2

    invoke-static {v3}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/Integer;

    .line 40
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->setSubtype(Ljava/lang/Integer;)V

    .line 43
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 44
    if-nez v1, :cond_1

    .line 46
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 47
    .local v0, "data":Ljava/lang/Boolean;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->setIsDefault(Ljava/lang/Boolean;)V

    .line 50
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 51
    if-nez v1, :cond_2

    .line 53
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 54
    .restart local v0    # "data":Ljava/lang/Boolean;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->setIsPrivate(Ljava/lang/Boolean;)V

    .line 57
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 58
    if-nez v1, :cond_3

    .line 60
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 61
    .restart local v0    # "data":Ljava/lang/Boolean;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->setIsSearchable(Ljava/lang/Boolean;)V

    .line 64
    .end local v0    # "data":Ljava/lang/Boolean;
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 65
    if-nez v1, :cond_4

    .line 67
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 68
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->setLastModified(Ljava/lang/String;)V

    .line 70
    .end local v0    # "data":Ljava/lang/String;
    :cond_4
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/ListListDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    move-result-object v0

    return-object v0
.end method
