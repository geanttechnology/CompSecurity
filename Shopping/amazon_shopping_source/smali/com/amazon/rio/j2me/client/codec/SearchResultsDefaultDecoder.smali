.class public Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder;
.super Ljava/lang/Object;
.source "SearchResultsDefaultDecoder.java"

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
    .locals 10
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x0

    .line 22
    const/4 v6, 0x1

    new-array v4, v6, [I

    .line 44
    .local v4, "fieldPath":[I
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/SearchResultsCountsDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/SearchResultsCountsDefaultDecoder;-><init>()V

    invoke-virtual {v6, p1, v9}, Lcom/amazon/rio/j2me/client/codec/SearchResultsCountsDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;

    move-result-object v0

    .line 45
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;
    invoke-interface {p2, v0, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 47
    aget v6, v4, v8

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v8

    .line 51
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/SearchResultDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/SearchResultDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    new-instance v7, Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v7, p0, v4, p2}, Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 52
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-interface {p2, v2, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 54
    aget v6, v4, v8

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v8

    .line 58
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getOctetArrayInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    new-instance v7, Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v7, p0, v4, p2}, Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 59
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<[B>;"
    invoke-interface {p2, v3, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 61
    aget v6, v4, v8

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v8

    .line 64
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 65
    .local v5, "isAbsent":Z
    if-nez v5, :cond_0

    .line 67
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/CategoryResultDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/CategoryResultDefaultDecoder;-><init>()V

    invoke-static {v6}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v6

    new-instance v7, Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v7, p0, v4, p2}, Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/SearchResultsDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v6, p1, v7}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 68
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    invoke-interface {p2, v1, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 70
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    :cond_0
    aget v6, v4, v8

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v8

    .line 73
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v5

    .line 74
    if-nez v5, :cond_1

    .line 76
    new-instance v6, Lcom/amazon/rio/j2me/client/codec/QueryDescriptorDefaultDecoder;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/codec/QueryDescriptorDefaultDecoder;-><init>()V

    invoke-virtual {v6, p1, v9}, Lcom/amazon/rio/j2me/client/codec/QueryDescriptorDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    move-result-object v0

    .line 77
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    invoke-interface {p2, v0, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 79
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    :cond_1
    aget v6, v4, v8

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v8

    .line 80
    new-array v6, v8, [I

    invoke-interface {p2, v9, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 81
    return-object v9
.end method
