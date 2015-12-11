.class public abstract Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;
.super Ljava/lang/Object;
.source "BaseClientRequestReply.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;


# instance fields
.field protected final serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;


# direct methods
.method protected constructor <init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;)V
    .locals 0
    .param p1, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    .line 22
    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 57
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->getCallback()Lcom/amazon/rio/j2me/client/services/ResponseListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/services/ResponseListener;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 58
    return-void
.end method

.method public communicationError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .locals 3
    .param p1, "exp"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    .prologue
    .line 39
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v1, p2}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 41
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->getEventListener()Lcom/amazon/rio/j2me/client/services/RioEventListener;

    move-result-object v0

    .line 42
    .local v0, "eventListener":Lcom/amazon/rio/j2me/client/services/RioEventListener;
    if-eqz v0, :cond_0

    .line 43
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/services/RioEventListener;->connectionFailed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 45
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->getCallback()Lcom/amazon/rio/j2me/client/services/ResponseListener;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v1, p1, v2}, Lcom/amazon/rio/j2me/client/services/ResponseListener;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 46
    return-void
.end method

.method public consumeReply(Ljava/io/InputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .locals 2
    .param p1, "is"    # Ljava/io/InputStream;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v1, p2}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 32
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->getEventListener()Lcom/amazon/rio/j2me/client/services/RioEventListener;

    move-result-object v0

    .line 33
    .local v0, "eventListener":Lcom/amazon/rio/j2me/client/services/RioEventListener;
    if-eqz v0, :cond_0

    .line 34
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/services/RioEventListener;->connectionSucceeded(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 35
    :cond_0
    return-void
.end method

.method protected abstract getCallback()Lcom/amazon/rio/j2me/client/services/ResponseListener;
.end method

.method public internalError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .locals 2
    .param p1, "exp"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 51
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->getCallback()Lcom/amazon/rio/j2me/client/services/ResponseListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/BaseClientRequestReply;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/services/ResponseListener;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 52
    return-void
.end method
