.class public Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "RecommendedItemsResponseDefaultDecoder.java"

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
    .locals 12
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x0

    const/4 v10, 0x0

    .line 22
    const/4 v6, 0x1

    new-array v4, v6, [I

    .line 43
    .local v4, "fieldPath":[I
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 44
    .local v5, "isAbsent":Z
    if-nez v5, :cond_0

    .line 46
    const-wide/32 v6, -0x80000000

    const-wide/32 v8, 0x7fffffff

    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-interface {v6, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 47
    .local v0, "data":Ljava/lang/Integer;
    invoke-interface {p2, v0, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 49
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_0
    aget v6, v4, v10

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v10

    .line 53
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/SearchResultDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/SearchResultDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    new-instance v7, Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v7, p0, v4, p2}, Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 54
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-interface {p2, v2, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 56
    aget v6, v4, v10

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v10

    .line 60
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getOctetArrayInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    new-instance v7, Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v7, p0, v4, p2}, Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 61
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<[B>;"
    invoke-interface {p2, v3, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 63
    aget v6, v4, v10

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v10

    .line 66
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 67
    if-nez v5, :cond_1

    .line 69
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/CategoryResultDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/CategoryResultDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    new-instance v7, Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v7, p0, v4, p2}, Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/RecommendedItemsResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 70
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    invoke-interface {p2, v1, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 72
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    :cond_1
    aget v6, v4, v10

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v10

    .line 75
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 76
    if-nez v5, :cond_2

    .line 78
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-interface {v6, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 79
    .local v0, "data":Ljava/lang/String;
    invoke-interface {p2, v0, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 81
    .end local v0    # "data":Ljava/lang/String;
    :cond_2
    aget v6, v4, v10

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v10

    .line 82
    new-array v6, v10, [I

    invoke-interface {p2, v11, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 83
    return-object v11
.end method
