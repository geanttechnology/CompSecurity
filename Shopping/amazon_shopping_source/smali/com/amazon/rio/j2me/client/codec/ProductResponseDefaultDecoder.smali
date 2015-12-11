.class public Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "ProductResponseDefaultDecoder.java"

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
    const/4 v8, 0x1

    new-array v6, v8, [I

    .line 44
    .local v6, "fieldPath":[I
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickStatusDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickStatusDefaultDecoder;-><init>()V

    invoke-virtual {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickStatusDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v0

    .line 45
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 47
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 51
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/BasicProductInfoDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/BasicProductInfoDefaultDecoder;-><init>()V

    invoke-virtual {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/BasicProductInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v0

    .line 52
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 54
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 57
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 58
    .local v7, "isAbsent":Z
    if-nez v7, :cond_0

    .line 60
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/SavingsDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/SavingsDefaultDecoder;-><init>()V

    invoke-virtual {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/SavingsDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v0

    .line 61
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/Savings;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 63
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Savings;
    :cond_0
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 66
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 67
    if-nez v7, :cond_1

    .line 69
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;-><init>()V

    invoke-virtual {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/BasicOfferListingDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 70
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 72
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    :cond_1
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 75
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 76
    if-nez v7, :cond_2

    .line 78
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickShippingOffersDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickShippingOffersDefaultDecoder;-><init>()V

    invoke-virtual {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/PrimeOneClickShippingOffersDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    move-result-object v0

    .line 79
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 81
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    :cond_2
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 85
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/ExtraProductInfoDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/ExtraProductInfoDefaultDecoder;-><init>()V

    invoke-virtual {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/ExtraProductInfoDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    move-result-object v0

    .line 86
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 88
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 91
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 92
    if-nez v7, :cond_3

    .line 94
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/ExtraOfferListingDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/ExtraOfferListingDefaultDecoder;-><init>()V

    invoke-virtual {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/ExtraOfferListingDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    move-result-object v0

    .line 95
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 97
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    :cond_3
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 101
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getOctetArrayInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v8

    invoke-interface {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    .line 102
    .local v0, "data":[B
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 104
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 107
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 108
    if-nez v7, :cond_4

    .line 110
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/MultiImageDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/MultiImageDefaultDecoder;-><init>()V

    invoke-static {v8}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v8

    new-instance v9, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v9, p0, v6, p2}, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v8, p1, v9}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 111
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    invoke-interface {p2, v2, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 113
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    :cond_4
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 117
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/DimensionDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/DimensionDefaultDecoder;-><init>()V

    invoke-static {v8}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v8

    new-instance v9, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v9, p0, v6, p2}, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v8, p1, v9}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 118
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Dimension;>;"
    invoke-interface {p2, v1, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 120
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 124
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/VariationProductInfoDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/VariationProductInfoDefaultDecoder;-><init>()V

    invoke-static {v8}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v8

    new-instance v9, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v9, p0, v6, p2}, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v8, p1, v9}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 125
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;>;"
    invoke-interface {p2, v3, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 127
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 131
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/VisualBucketDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/VisualBucketDefaultDecoder;-><init>()V

    invoke-static {v8}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v8

    new-instance v9, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v9, p0, v6, p2}, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v8, p1, v9}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 132
    .local v4, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;>;"
    invoke-interface {p2, v4, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 134
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 137
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 138
    if-nez v7, :cond_5

    .line 140
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/WebLinkDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/WebLinkDefaultDecoder;-><init>()V

    invoke-static {v8}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v8

    new-instance v9, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;

    invoke-direct {v9, p0, v6, p2}, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder$1ArrayResponseListener;-><init>(Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V

    invoke-interface {v8, p1, v9}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    .line 141
    .local v5, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/WebLink;>;"
    invoke-interface {p2, v5, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 143
    .end local v5    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/WebLink;>;"
    :cond_5
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 146
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 147
    if-nez v7, :cond_6

    .line 149
    new-instance v8, Lcom/amazon/rio/j2me/client/codec/WebLinkDefaultDecoder;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/codec/WebLinkDefaultDecoder;-><init>()V

    invoke-virtual {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/WebLinkDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    move-result-object v0

    .line 150
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/WebLink;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 152
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/WebLink;
    :cond_6
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 155
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 156
    if-nez v7, :cond_7

    .line 158
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v8

    invoke-interface {v8, p1, v11}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 159
    .local v0, "data":Ljava/lang/String;
    invoke-interface {p2, v0, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 161
    .end local v0    # "data":Ljava/lang/String;
    :cond_7
    aget v8, v6, v10

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v10

    .line 162
    new-array v8, v10, [I

    invoke-interface {p2, v11, v8}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 163
    return-object v11
.end method
