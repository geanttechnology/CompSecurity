.class public Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;
.super Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;
.source "NavigationMenuClientRequestReply.java"


# instance fields
.field private final callback:Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;

.field private final request:Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;


# direct methods
.method public constructor <init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;)V
    .locals 0
    .param p1, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    .param p2, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;
    .param p3, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;)V

    .line 24
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->request:Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;

    .line 25
    iput-object p3, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;

    .line 26
    return-void
.end method


# virtual methods
.method public consumeReply(Ljava/io/InputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .locals 5
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
    instance-of v3, p1, Ljava/io/DataInputStream;

    if-eqz v3, :cond_0

    check-cast p1, Ljava/io/DataInputStream;

    .end local p1    # "is":Ljava/io/InputStream;
    move-object v0, p1

    .line 49
    .local v0, "dis":Ljava/io/DataInputStream;
    :goto_0
    invoke-static {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->isErrorResponse(Ljava/io/DataInputStream;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 51
    invoke-static {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->decodeApplicationException(Ljava/io/DataInputStream;)Lcom/amazon/rio/j2me/client/services/ApplicationException;

    move-result-object v1

    .line 52
    .local v1, "e":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;

    iget-object v4, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v3, v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 60
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
    new-instance v3, Lcom/amazon/rio/j2me/client/codec/NavigationMenuResponseDefaultDecoder;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/codec/NavigationMenuResponseDefaultDecoder;-><init>()V

    const/4 v4, 0x0

    invoke-virtual {v3, v0, v4}, Lcom/amazon/rio/j2me/client/codec/NavigationMenuResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;

    move-result-object v2

    .line 57
    .local v2, "response":Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->allDataReceived()V

    .line 58
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;

    iget-object v4, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v3, v2, v4}, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;->completed(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_1
.end method

.method protected getCallback()Lcom/amazon/rio/j2me/client/services/ResponseListener;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->callback:Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;

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
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

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
    new-instance v1, Lcom/amazon/rio/j2me/client/codec/NavigationMenuRequestDefaultEncoder;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/codec/NavigationMenuRequestDefaultEncoder;-><init>()V

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;->request:Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/rio/j2me/client/codec/NavigationMenuRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;Ljava/io/DataOutputStream;)V

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
