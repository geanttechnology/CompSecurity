.class public Lcom/amazon/rio/j2me/client/codec/DeliveryLocationsSearchResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "DeliveryLocationsSearchResponseDefaultDecoder.java"

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
    const/4 v4, 0x1

    new-array v2, v4, [I

    .line 43
    .local v2, "fieldPath":[I
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 44
    .local v3, "isAbsent":Z
    if-nez v3, :cond_0

    .line 46
    const-wide/32 v4, -0x80000000

    const-wide/32 v6, 0x7fffffff

    invoke-static {v4, v5, v6, v7}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v9}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 47
    .local v0, "data":Ljava/lang/Integer;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 49
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_0
    aget v4, v2, v8

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v8

    .line 52
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 53
    if-nez v3, :cond_1

    .line 55
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v9}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 56
    .local v0, "data":Ljava/lang/String;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 58
    .end local v0    # "data":Ljava/lang/String;
    :cond_1
    aget v4, v2, v8

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v8

    .line 62
    const/4 v4, 0x2

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    invoke-interface {v4, p1, v9}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 63
    .local v0, "data":Ljava/lang/Integer;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 65
    aget v4, v2, v8

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v8

    .line 69
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;-><init>()V

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v4

    new-instance v5, Lcom/amazon/rio/j2me/client/codec/DeliveryLocationsSearchResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v5, p0, v2, p2}, Lcom/amazon/rio/j2me/client/codec/DeliveryLocationsSearchResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/DeliveryLocationsSearchResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v4, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 70
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Address;>;"
    invoke-interface {p2, v1, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 72
    aget v4, v2, v8

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v8

    .line 73
    new-array v4, v8, [I

    invoke-interface {p2, v9, v4}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 74
    return-object v9
.end method
