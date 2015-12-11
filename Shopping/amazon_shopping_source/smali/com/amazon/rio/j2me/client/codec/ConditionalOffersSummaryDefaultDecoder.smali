.class public Lcom/amazon/rio/j2me/client/codec/ConditionalOffersSummaryDefaultDecoder;
.super Ljava/lang/Object;
.source "ConditionalOffersSummaryDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    .locals 4
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 21
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;-><init>()V

    .line 26
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v2

    invoke-interface {v2, p1, v3}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 27
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->setCondition(Ljava/lang/String;)V

    .line 31
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v2

    invoke-interface {v2, p1, v3}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 32
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->setConditionType(Ljava/lang/String;)V

    .line 36
    new-instance v2, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;-><init>()V

    invoke-virtual {v2, p1, v3}, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v0

    .line 37
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->setSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V

    .line 39
    return-object v1
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/ConditionalOffersSummaryDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;

    move-result-object v0

    return-object v0
.end method
