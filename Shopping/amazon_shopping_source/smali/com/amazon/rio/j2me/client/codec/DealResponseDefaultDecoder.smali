.class public Lcom/amazon/rio/j2me/client/codec/DealResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "DealResponseDefaultDecoder.java"

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
    .locals 6
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 22
    const/4 v3, 0x1

    new-array v1, v3, [I

    .line 25
    .local v1, "fieldPath":[I
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 26
    .local v2, "isAbsent":Z
    if-nez v2, :cond_0

    .line 28
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/DealDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/DealDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/DealDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    move-result-object v0

    .line 29
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/Deal;
    invoke-interface {p2, v0, v1}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 31
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Deal;
    :cond_0
    aget v3, v1, v5

    add-int/lit8 v3, v3, 0x1

    aput v3, v1, v5

    .line 32
    new-array v3, v5, [I

    invoke-interface {p2, v4, v3}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 33
    return-object v4
.end method
