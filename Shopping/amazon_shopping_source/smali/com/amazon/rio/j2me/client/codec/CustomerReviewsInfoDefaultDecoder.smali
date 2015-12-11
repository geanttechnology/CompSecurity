.class public Lcom/amazon/rio/j2me/client/codec/CustomerReviewsInfoDefaultDecoder;
.super Ljava/lang/Object;
.source "CustomerReviewsInfoDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;
    .locals 11
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/32 v9, 0x7fffffff

    const-wide/32 v7, -0x80000000

    const/4 v6, 0x0

    .line 21
    new-instance v4, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;-><init>()V

    .line 27
    .local v4, "record":Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 28
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setOneStarCount(I)V

    .line 32
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Integer;

    .line 33
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setTwoStarCount(I)V

    .line 37
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Integer;

    .line 38
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setThreeStarCount(I)V

    .line 42
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Integer;

    .line 43
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setFourStarCount(I)V

    .line 47
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Integer;

    .line 48
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setFiveStarCount(I)V

    .line 52
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/CustomerReviewDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/CustomerReviewDefaultDecoder;-><init>()V

    invoke-static {v5}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 53
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;>;"
    invoke-virtual {v4, v1}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setReviews(Ljava/util/List;)V

    .line 57
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;-><init>()V

    invoke-static {v5}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 58
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    invoke-virtual {v4, v2}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setSortTypes(Ljava/util/List;)V

    .line 61
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 62
    .local v3, "isAbsent":Z
    if-nez v3, :cond_0

    .line 64
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/Integer;

    .line 65
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v4, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setSelectedStarFilter(Ljava/lang/Integer;)V

    .line 69
    :cond_0
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "data":Ljava/lang/Integer;
    check-cast v0, Ljava/lang/String;

    .line 70
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v4, v0}, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->setSelectedSortType(Ljava/lang/String;)V

    .line 72
    return-object v4
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/CustomerReviewsInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;

    move-result-object v0

    return-object v0
.end method
