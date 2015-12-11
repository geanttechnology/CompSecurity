.class public Lcom/amazon/rio/j2me/client/codec/UpgradeResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "UpgradeResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;
    .locals 5
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;-><init>()V

    .line 26
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 27
    .local v1, "isAbsent":Z
    if-nez v1, :cond_0

    .line 29
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/UpgradeInfoDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/UpgradeInfoDefaultDecoder;-><init>()V

    const/4 v4, 0x0

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/UpgradeInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    move-result-object v0

    .line 30
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;->setUpgradeInfo(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V

    .line 32
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/UpgradeResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;

    move-result-object v0

    return-object v0
.end method
