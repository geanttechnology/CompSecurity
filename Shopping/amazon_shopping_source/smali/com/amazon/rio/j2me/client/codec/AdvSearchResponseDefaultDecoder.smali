.class public Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "AdvSearchResponseDefaultDecoder.java"

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
    .locals 9
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 22
    const/4 v5, 0x1

    new-array v3, v5, [I

    .line 43
    .local v3, "fieldPath":[I
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 44
    .local v4, "isAbsent":Z
    if-nez v4, :cond_0

    .line 46
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;-><init>()V

    invoke-static {v5}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    new-instance v6, Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v6, p0, v3, p2}, Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 47
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    invoke-interface {p2, v2, v3}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 49
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    :cond_0
    aget v5, v3, v7

    add-int/lit8 v5, v5, 0x1

    aput v5, v3, v7

    .line 52
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 53
    if-nez v4, :cond_1

    .line 55
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/AdvSearchResultsDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/AdvSearchResultsDefaultDecoder;-><init>()V

    invoke-virtual {v5, p1, v8}, Lcom/amazon/rio/j2me/client/codec/AdvSearchResultsDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    move-result-object v0

    .line 56
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
    invoke-interface {p2, v0, v3}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 58
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
    :cond_1
    aget v5, v3, v7

    add-int/lit8 v5, v5, 0x1

    aput v5, v3, v7

    .line 61
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v4

    .line 62
    if-nez v4, :cond_2

    .line 64
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/AdvSearchResultsDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/AdvSearchResultsDefaultDecoder;-><init>()V

    invoke-static {v5}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    new-instance v6, Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v6, p0, v3, p2}, Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 65
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;>;"
    invoke-interface {p2, v1, v3}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 67
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;>;"
    :cond_2
    aget v5, v3, v7

    add-int/lit8 v5, v5, 0x1

    aput v5, v3, v7

    .line 68
    new-array v5, v7, [I

    invoke-interface {p2, v8, v5}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 69
    return-object v8
.end method
