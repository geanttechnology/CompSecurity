.class public Lcom/amazon/rio/j2me/client/codec/CoordinatesDefaultDecoder;
.super Ljava/lang/Object;
.source "CoordinatesDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;
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
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;-><init>()V

    .line 27
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 28
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->setLatitude(Ljava/lang/String;)V

    .line 32
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 33
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->setLongitude(Ljava/lang/String;)V

    .line 36
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 37
    .local v1, "isAbsent":Z
    if-nez v1, :cond_0

    .line 39
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 40
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->setElevation(Ljava/lang/String;)V

    .line 42
    :cond_0
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/CoordinatesDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    move-result-object v0

    return-object v0
.end method
