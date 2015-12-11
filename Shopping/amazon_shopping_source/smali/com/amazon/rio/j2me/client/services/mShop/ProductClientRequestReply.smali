.class public Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;
.super Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;
.source "ProductClientRequestReply.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;


# instance fields
.field private final callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

.field private final request:Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;


# direct methods
.method public constructor <init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;)V
    .locals 0
    .param p1, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    .param p2, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;
    .param p3, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;)V

    .line 24
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->request:Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;

    .line 25
    iput-object p3, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    .line 26
    return-void
.end method


# virtual methods
.method public aboutToReceiveArrayOfSize(I[I)V
    .locals 2
    .param p1, "size"    # I
    .param p2, "path"    # [I

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 65
    return-void
.end method

.method public consumeReply(Ljava/io/InputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .locals 4
    .param p1, "is"    # Ljava/io/InputStream;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-super {p0, p1, p2}, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->consumeReply(Ljava/io/InputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 47
    instance-of v2, p1, Ljava/io/DataInputStream;

    if-eqz v2, :cond_0

    check-cast p1, Ljava/io/DataInputStream;

    .end local p1    # "is":Ljava/io/InputStream;
    move-object v0, p1

    .line 49
    .local v0, "dis":Ljava/io/DataInputStream;
    :goto_0
    invoke-static {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->isErrorResponse(Ljava/io/DataInputStream;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 51
    invoke-static {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->decodeApplicationException(Ljava/io/DataInputStream;)Lcom/amazon/rio/j2me/client/services/ApplicationException;

    move-result-object v1

    .line 52
    .local v1, "e":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    iget-object v3, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v2, v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 58
    .end local v1    # "e":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    :goto_1
    return-void

    .line 47
    .end local v0    # "dis":Ljava/io/DataInputStream;
    .restart local p1    # "is":Ljava/io/InputStream;
    :cond_0
    new-instance v0, Ljava/io/DataInputStream;

    invoke-direct {v0, p1}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    goto :goto_0

    .line 56
    .end local p1    # "is":Ljava/io/InputStream;
    .restart local v0    # "dis":Ljava/io/DataInputStream;
    :cond_1
    new-instance v2, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;-><init>()V

    invoke-virtual {v2, v0, p0}, Lcom/amazon/rio/j2me/client/codec/ProductResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    goto :goto_1
.end method

.method protected getCallback()Lcom/amazon/rio/j2me/client/services/ResponseListener;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    return-object v0
.end method

.method public produceRequestData(Ljava/io/OutputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .locals 3
    .param p1, "os"    # Ljava/io/OutputStream;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 39
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v1, p2}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 40
    instance-of v1, p1, Ljava/io/DataOutputStream;

    if-eqz v1, :cond_0

    check-cast p1, Ljava/io/DataOutputStream;

    .end local p1    # "os":Ljava/io/OutputStream;
    move-object v0, p1

    .line 41
    .local v0, "dos":Ljava/io/DataOutputStream;
    :goto_0
    new-instance v1, Lcom/amazon/rio/j2me/client/codec/ProductRequestDefaultEncoder;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/codec/ProductRequestDefaultEncoder;-><init>()V

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->request:Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/rio/j2me/client/codec/ProductRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;Ljava/io/DataOutputStream;)V

    .line 42
    return-void

    .line 40
    .end local v0    # "dos":Ljava/io/DataOutputStream;
    .restart local p1    # "os":Ljava/io/OutputStream;
    :cond_0
    new-instance v0, Ljava/io/DataOutputStream;

    invoke-direct {v0, p1}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    goto :goto_0
.end method

.method public receivedObject(Ljava/lang/Object;[I)V
    .locals 4
    .param p1, "data"    # Ljava/lang/Object;
    .param p2, "path"    # [I

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x1

    .line 69
    array-length v0, p2

    if-ge v0, v1, :cond_1

    .line 71
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->allDataReceived()V

    .line 72
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 121
    .end local p1    # "data":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-void

    .line 76
    .restart local p1    # "data":Ljava/lang/Object;
    :cond_1
    aget v0, p2, v3

    packed-switch v0, :pswitch_data_0

    .line 119
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unexpected field number "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    aget v2, p2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " for record of Rio type \'Product_Response\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 79
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 81
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 83
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_2
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedSavings(Lcom/amazon/rio/j2me/client/services/mShop/Savings;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 85
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_3
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 87
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_4
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 89
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_5
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedExtraProduct(Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 91
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_6
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedExtraOffer(Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 93
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_7
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, [B

    .end local p1    # "data":Ljava/lang/Object;
    check-cast p1, [B

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedImage([BLcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 95
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_8
    array-length v0, p2

    if-le v0, v1, :cond_0

    .line 96
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    .end local p1    # "data":Ljava/lang/Object;
    aget v1, p2, v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedMultiImage(Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto/16 :goto_0

    .line 99
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_9
    array-length v0, p2

    if-le v0, v1, :cond_0

    .line 100
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    .end local p1    # "data":Ljava/lang/Object;
    aget v1, p2, v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedDimension(Lcom/amazon/rio/j2me/client/services/mShop/Dimension;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto/16 :goto_0

    .line 103
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_a
    array-length v0, p2

    if-le v0, v1, :cond_0

    .line 104
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    .end local p1    # "data":Ljava/lang/Object;
    aget v1, p2, v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedVariationProductInfo(Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto/16 :goto_0

    .line 107
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_b
    array-length v0, p2

    if-le v0, v1, :cond_0

    .line 108
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    .end local p1    # "data":Ljava/lang/Object;
    aget v1, p2, v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedVisualBucket(Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto/16 :goto_0

    .line 111
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_c
    array-length v0, p2

    if-le v0, v1, :cond_0

    .line 112
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    .end local p1    # "data":Ljava/lang/Object;
    aget v1, p2, v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedWebLink(Lcom/amazon/rio/j2me/client/services/mShop/WebLink;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto/16 :goto_0

    .line 115
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_d
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedExternalBuyLink(Lcom/amazon/rio/j2me/client/services/mShop/WebLink;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto/16 :goto_0

    .line 117
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_e
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    check-cast p1, Ljava/lang/String;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;->receivedDealId(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto/16 :goto_0

    .line 76
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
    .end packed-switch
.end method
