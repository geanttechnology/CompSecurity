.class public Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;
.super Ljava/lang/Object;
.source "RichMessageDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    .locals 10
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/32 v8, 0x7fffffff

    const-wide/32 v6, -0x80000000

    const/4 v5, 0x0

    .line 21
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;-><init>()V

    .line 26
    .local v3, "record":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
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
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->setImageUrl(Ljava/lang/String;)V

    .line 34
    .end local v0    # "data":Ljava/lang/String;
    :cond_0
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;-><init>()V

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 35
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->setMessages(Ljava/util/List;)V

    .line 38
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 39
    if-nez v2, :cond_1

    .line 41
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/UniversalLinkDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v0

    .line 42
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->setImageLink(Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;)V

    .line 45
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 46
    if-nez v2, :cond_2

    .line 48
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 49
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->setBackgroundColor(Ljava/lang/Integer;)V

    .line 52
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 53
    if-nez v2, :cond_3

    .line 55
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 56
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->setBorderColor(Ljava/lang/Integer;)V

    .line 58
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_3
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    return-object v0
.end method
