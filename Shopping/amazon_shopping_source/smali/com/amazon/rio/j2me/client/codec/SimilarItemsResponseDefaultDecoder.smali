.class public Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "SimilarItemsResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;",
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
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;
    .locals 10
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v9, 0x0

    .line 21
    if-nez p2, :cond_7

    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;-><init>()V

    .line 23
    .local v3, "record":Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;
    :goto_0
    const/4 v5, 0x1

    new-array v2, v5, [I

    .line 45
    .local v2, "fieldPath":[I
    const-wide/32 v5, -0x80000000

    const-wide/32 v7, 0x7fffffff

    invoke-static {v5, v6, v7, v8}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 47
    .local v0, "data":Ljava/lang/Integer;
    if-eqz v3, :cond_0

    .line 49
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;->setTotalCount(I)V

    .line 52
    :cond_0
    if-eqz p2, :cond_1

    .line 53
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 55
    :cond_1
    aget v5, v2, v9

    add-int/lit8 v5, v5, 0x1

    aput v5, v2, v9

    .line 59
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/SearchResultDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/SearchResultDefaultDecoder;-><init>()V

    invoke-static {v5}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    if-nez p2, :cond_8

    move-object v5, v4

    :goto_1
    invoke-interface {v6, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 61
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    if-eqz v3, :cond_2

    .line 62
    invoke-virtual {v3, v1}, Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;->setItems(Ljava/util/List;)V

    .line 64
    :cond_2
    if-eqz p2, :cond_3

    .line 65
    invoke-interface {p2, v1, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 67
    :cond_3
    aget v5, v2, v9

    add-int/lit8 v5, v5, 0x1

    aput v5, v2, v9

    .line 71
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;-><init>()V

    invoke-virtual {v5, p1, v4}, Lcom/amazon/rio/j2me/client/codec/KeyValuePairDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;

    move-result-object v0

    .line 73
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    if-eqz v3, :cond_4

    .line 74
    invoke-virtual {v3, v0}, Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;->setDatasetInfo(Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;)V

    .line 76
    :cond_4
    if-eqz p2, :cond_5

    .line 77
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 79
    :cond_5
    aget v4, v2, v9

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v9

    .line 81
    if-eqz p2, :cond_6

    .line 82
    new-array v4, v9, [I

    invoke-interface {p2, v3, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 83
    :cond_6
    return-object v3

    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    .end local v2    # "fieldPath":[I
    .end local v3    # "record":Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;
    :cond_7
    move-object v3, v4

    .line 21
    goto :goto_0

    .line 59
    .local v0, "data":Ljava/lang/Integer;
    .restart local v2    # "fieldPath":[I
    .restart local v3    # "record":Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;
    :cond_8
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v5, p0, v2, p2}, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    goto :goto_1
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
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;

    move-result-object v0

    return-object v0
.end method
