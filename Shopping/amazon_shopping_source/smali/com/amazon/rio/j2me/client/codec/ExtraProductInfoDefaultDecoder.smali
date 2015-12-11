.class public Lcom/amazon/rio/j2me/client/codec/ExtraProductInfoDefaultDecoder;
.super Ljava/lang/Object;
.source "ExtraProductInfoDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;
    .locals 12
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x0

    .line 21
    new-instance v9, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    invoke-direct {v9}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;-><init>()V

    .line 26
    .local v9, "record":Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v8

    .line 27
    .local v8, "isAbsent":Z
    if-nez v8, :cond_0

    .line 29
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/CustomerReviewsInfoDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/CustomerReviewsInfoDefaultDecoder;-><init>()V

    invoke-virtual {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/CustomerReviewsInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;

    move-result-object v0

    .line 30
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;
    invoke-virtual {v9, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setCustomerReviewsInfo(Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;)V

    .line 34
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;
    :cond_0
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;-><init>()V

    invoke-static {v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v10

    invoke-interface {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 35
    .local v4, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    invoke-virtual {v9, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setDetails(Ljava/util/List;)V

    .line 39
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;-><init>()V

    invoke-static {v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v10

    invoke-interface {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    check-cast v4, Ljava/util/List;

    .line 40
    .restart local v4    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    invoke-virtual {v9, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setDescs(Ljava/util/List;)V

    .line 44
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/ConditionalOffersSummaryDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/ConditionalOffersSummaryDefaultDecoder;-><init>()V

    invoke-static {v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v10

    invoke-interface {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 45
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;>;"
    invoke-virtual {v9, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setOfferListSummaries(Ljava/util/List;)V

    .line 49
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/OfferListingDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/OfferListingDefaultDecoder;-><init>()V

    invoke-static {v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v10

    invoke-interface {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    .line 50
    .local v5, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;>;"
    invoke-virtual {v9, v5}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setOffers(Ljava/util/List;)V

    .line 53
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v8

    .line 54
    if-nez v8, :cond_1

    .line 56
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;-><init>()V

    invoke-static {v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v10

    invoke-interface {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 57
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    invoke-virtual {v9, v3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setProductMessages(Ljava/util/List;)V

    .line 60
    .end local v3    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v8

    .line 61
    if-nez v8, :cond_2

    .line 63
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/ProductWarningDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/ProductWarningDefaultDecoder;-><init>()V

    invoke-static {v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v10

    invoke-interface {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 64
    .local v6, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;>;"
    invoke-virtual {v9, v6}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setProductWarnings(Ljava/util/List;)V

    .line 67
    .end local v6    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;>;"
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v8

    .line 68
    if-nez v8, :cond_3

    .line 70
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;-><init>()V

    invoke-virtual {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;

    move-result-object v0

    .line 71
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;
    invoke-virtual {v9, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setSimilarItems(Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;)V

    .line 74
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v8

    .line 75
    if-nez v8, :cond_4

    .line 77
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/VideoClipDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/VideoClipDefaultDecoder;-><init>()V

    invoke-static {v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v10

    invoke-interface {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/List;

    .line 78
    .local v7, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;>;"
    invoke-virtual {v9, v7}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setVideoClips(Ljava/util/List;)V

    .line 81
    .end local v7    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;>;"
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v8

    .line 82
    if-nez v8, :cond_5

    .line 84
    new-instance v10, Lcom/amazon/rio/j2me/client/codec/DiscListingDefaultDecoder;

    invoke-direct {v10}, Lcom/amazon/rio/j2me/client/codec/DiscListingDefaultDecoder;-><init>()V

    invoke-static {v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v10

    invoke-interface {v10, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 85
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/DiscListing;>;"
    invoke-virtual {v9, v2}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->setTrackListings(Ljava/util/List;)V

    .line 87
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/DiscListing;>;"
    :cond_5
    return-object v9
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/ExtraProductInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    move-result-object v0

    return-object v0
.end method
