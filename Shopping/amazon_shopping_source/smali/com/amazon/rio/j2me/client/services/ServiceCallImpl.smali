.class public Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
.super Ljava/lang/Object;
.source "ServiceCallImpl.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ServiceCall;


# instance fields
.field private allDataReceived:Z

.field private final eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

.field private underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;


# direct methods
.method public constructor <init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V
    .locals 1
    .param p1, "eventListener"    # Lcom/amazon/rio/j2me/client/services/RioEventListener;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    .line 26
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    .line 27
    return-void
.end method


# virtual methods
.method public declared-synchronized allDataReceived()V
    .locals 1

    .prologue
    .line 51
    monitor-enter p0

    const/4 v0, 0x1

    :try_start_0
    iput-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->allDataReceived:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 52
    monitor-exit p0

    return-void

    .line 51
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public cancel()V
    .locals 1

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->getUnderlyingCall()Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->cancel()V

    .line 42
    return-void
.end method

.method public getEventListener()Lcom/amazon/rio/j2me/client/services/RioEventListener;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getUnderlyingCall()Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    .locals 2

    .prologue
    .line 57
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    if-nez v0, :cond_0

    .line 58
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "This really should never happen: attempt to access underlyingCall before object initialized!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 57
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 60
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-object v0
.end method

.method public declared-synchronized replay()V
    .locals 7

    .prologue
    .line 65
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->allDataReceived:Z

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->getUnderlyingCall()Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->isTerminalState()Z

    move-result v0

    if-nez v0, :cond_0

    .line 66
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "can\'t replay call until after original call completes"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 65
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 68
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->getServiceCallInvoker()Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->getServiceName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    invoke-interface {v2}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    invoke-interface {v3}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    invoke-interface {v4}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->isSecure()Z

    move-result v4

    iget-object v5, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    invoke-interface {v5}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->allowCookies()Z

    move-result v5

    iget-object v6, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    invoke-interface {v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCall;->getClientRequestReply()Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;

    move-result-object v6

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 81
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->allDataReceived:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 82
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .locals 1
    .param p1, "call"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    .prologue
    .line 31
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->underlyingCall:Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 32
    monitor-exit p0

    return-void

    .line 31
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
