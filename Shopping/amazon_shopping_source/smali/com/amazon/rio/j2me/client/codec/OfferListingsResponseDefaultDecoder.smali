.class public Lcom/amazon/rio/j2me/client/codec/OfferListingsResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "OfferListingsResponseDefaultDecoder.java"

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
    .locals 7
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 21
    const/4 v3, 0x1

    new-array v2, v3, [I

    .line 43
    .local v2, "fieldPath":[I
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickStatusDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickStatusDefaultDecoder;-><init>()V

    invoke-virtual {v3, p1, v6}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickStatusDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v0

    .line 44
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
    invoke-interface {p2, v0, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 46
    aget v3, v2, v5

    add-int/lit8 v3, v3, 0x1

    aput v3, v2, v5

    .line 50
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/OfferListingDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/OfferListingDefaultDecoder;-><init>()V

    invoke-static {v3}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v3

    new-instance v4, Lcom/amazon/rio/j2me/client/codec/OfferListingsResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v4, p0, v2, p2}, Lcom/amazon/rio/j2me/client/codec/OfferListingsResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/OfferListingsResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v3, p1, v4}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 51
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;>;"
    invoke-interface {p2, v1, v2}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 53
    aget v3, v2, v5

    add-int/lit8 v3, v3, 0x1

    aput v3, v2, v5

    .line 54
    new-array v3, v5, [I

    invoke-interface {p2, v6, v3}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 55
    return-object v6
.end method
