.class public Lcom/amazon/rio/j2me/client/codec/BadgeInfoDefaultDecoder;
.super Ljava/lang/Object;
.source "BadgeInfoDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
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
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;-><init>()V

    .line 26
    .local v2, "record":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 27
    .local v1, "isAbsent":Z
    if-nez v1, :cond_0

    .line 29
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    .line 30
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->setProminentMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V

    .line 33
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 34
    if-nez v1, :cond_1

    .line 36
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    .line 37
    .restart local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->setDetailedMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V

    .line 40
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v1

    .line 41
    if-nez v1, :cond_2

    .line 43
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/BadgeDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/BadgeDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/BadgeDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v0

    .line 44
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/Badge;
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->setBadge(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)V

    .line 46
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Badge;
    :cond_2
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/BadgeInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    return-object v0
.end method
