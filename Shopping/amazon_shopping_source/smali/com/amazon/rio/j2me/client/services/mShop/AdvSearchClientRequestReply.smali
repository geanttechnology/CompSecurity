.class public Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;
.super Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;
.source "AdvSearchClientRequestReply.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;


# instance fields
.field private final callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

.field private final request:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;


# direct methods
.method public constructor <init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;)V
    .locals 0
    .param p1, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    .param p2, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;
    .param p3, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;)V

    .line 24
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->request:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    .line 25
    iput-object p3, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

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
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;->aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

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
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    iget-object v3, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v2, v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

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
    new-instance v2, Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder;-><init>()V

    invoke-virtual {v2, v0, p0}, Lcom/amazon/rio/j2me/client/codec/AdvSearchResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    goto :goto_1
.end method

.method protected getCallback()Lcom/amazon/rio/j2me/client/services/ResponseListener;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

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
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

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
    new-instance v1, Lcom/amazon/rio/j2me/client/codec/AdvSearchRequestDefaultEncoder;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/codec/AdvSearchRequestDefaultEncoder;-><init>()V

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->request:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/rio/j2me/client/codec/AdvSearchRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;Ljava/io/DataOutputStream;)V

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
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->allDataReceived()V

    .line 72
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;->completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 91
    .end local p1    # "data":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-void

    .line 76
    .restart local p1    # "data":Ljava/lang/Object;
    :cond_1
    aget v0, p2, v3

    packed-switch v0, :pswitch_data_0

    .line 89
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unexpected field number "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    aget v2, p2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " for record of Rio type \'Adv_Search_Response\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 79
    :pswitch_0
    array-length v0, p2

    if-le v0, v1, :cond_0

    .line 80
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .end local p1    # "data":Ljava/lang/Object;
    aget v1, p2, v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;->receivedHyperText(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 83
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    .end local p1    # "data":Ljava/lang/Object;
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;->receivedMainResults(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 85
    .restart local p1    # "data":Ljava/lang/Object;
    :pswitch_2
    array-length v0, p2

    if-le v0, v1, :cond_0

    .line 86
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    .end local p1    # "data":Ljava/lang/Object;
    aget v1, p2, v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;->receivedAdvSearchResults(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 76
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
