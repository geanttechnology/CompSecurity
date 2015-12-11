.class public Lcom/amazon/rio/j2me/client/codec/VariationProductInfoDefaultDecoder;
.super Ljava/lang/Object;
.source "VariationProductInfoDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .locals 9
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 21
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;-><init>()V

    .line 27
    .local v3, "record":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 28
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->setAsin(Ljava/lang/String;)V

    .line 32
    const-wide/16 v4, -0x1

    const-wide/16 v6, 0xfe

    invoke-static {v4, v5, v6, v7}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 33
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->setVariationAttributes(Ljava/util/List;)V

    .line 36
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 37
    .local v2, "isAbsent":Z
    if-nez v2, :cond_0

    .line 39
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/OffersSummaryDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v0

    .line 40
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->setOffersSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V

    .line 43
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 44
    if-nez v2, :cond_1

    .line 46
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 47
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->setListPrice(Ljava/lang/String;)V

    .line 51
    .end local v0    # "data":Ljava/lang/String;
    :cond_1
    const-wide/32 v4, -0x80000000

    const-wide/32 v6, 0x7fffffff

    invoke-static {v4, v5, v6, v7}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 52
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->setImagesCount(I)V

    .line 55
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v2

    .line 56
    if-nez v2, :cond_2

    .line 58
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;-><init>()V

    invoke-virtual {v4, p1, v8}, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 59
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 61
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/VariationProductInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v0

    return-object v0
.end method
