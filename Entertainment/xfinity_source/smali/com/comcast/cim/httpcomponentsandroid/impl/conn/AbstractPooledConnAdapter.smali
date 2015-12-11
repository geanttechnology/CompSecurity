.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;
.source "AbstractPooledConnAdapter.java"


# instance fields
.field protected volatile poolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V
    .locals 1
    .param p1, "manager"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    .prologue
    .line 63
    iget-object v0, p2, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 64
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->poolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    .line 65
    return-void
.end method


# virtual methods
.method protected assertValid(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V
    .locals 1
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    .prologue
    .line 85
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->isReleased()Z

    move-result v0

    if-nez v0, :cond_0

    if-nez p1, :cond_1

    .line 86
    :cond_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException;-><init>()V

    throw v0

    .line 88
    :cond_1
    return-void
.end method

.method public close()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 146
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v1

    .line 147
    .local v1, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    if-eqz v1, :cond_0

    .line 148
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->shutdownEntry()V

    .line 150
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 151
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    if-eqz v0, :cond_1

    .line 152
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->close()V

    .line 154
    :cond_1
    return-void
.end method

.method protected declared-synchronized detach()V
    .locals 1

    .prologue
    .line 106
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->poolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    .line 107
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->detach()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 108
    monitor-exit p0

    return-void

    .line 106
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->poolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    return-object v0
.end method

.method public getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .locals 2

    .prologue
    .line 111
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v0

    .line 112
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    .line 113
    iget-object v1, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    if-nez v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    return-object v1

    :cond_0
    iget-object v1, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->toRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v1

    goto :goto_0
.end method

.method public getState()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 168
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v0

    .line 169
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    .line 170
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->getState()Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public layerProtocol(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 1
    .param p1, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 140
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v0

    .line 141
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    .line 142
    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->layerProtocol(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 143
    return-void
.end method

.method public open(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 1
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 119
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v0

    .line 120
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    .line 121
    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->open(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 122
    return-void
.end method

.method public setState(Ljava/lang/Object;)V
    .locals 1
    .param p1, "state"    # Ljava/lang/Object;

    .prologue
    .line 174
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v0

    .line 175
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    .line 176
    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->setState(Ljava/lang/Object;)V

    .line 177
    return-void
.end method

.method public shutdown()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 157
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v1

    .line 158
    .local v1, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    if-eqz v1, :cond_0

    .line 159
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->shutdownEntry()V

    .line 161
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 162
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    if-eqz v0, :cond_1

    .line 163
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->shutdown()V

    .line 165
    :cond_1
    return-void
.end method

.method public tunnelProxy(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 1
    .param p1, "next"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "secure"    # Z
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 133
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v0

    .line 134
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    .line 135
    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tunnelProxy(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 136
    return-void
.end method

.method public tunnelTarget(ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 1
    .param p1, "secure"    # Z
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 126
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v0

    .line 127
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    .line 128
    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tunnelTarget(ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 129
    return-void
.end method
