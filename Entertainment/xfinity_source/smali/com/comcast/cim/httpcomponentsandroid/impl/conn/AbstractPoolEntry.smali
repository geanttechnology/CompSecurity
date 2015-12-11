.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
.super Ljava/lang/Object;
.source "AbstractPoolEntry.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field protected final connOperator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

.field protected final connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

.field protected volatile route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

.field protected volatile state:Ljava/lang/Object;

.field protected volatile tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V
    .locals 2
    .param p1, "connOperator"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;
    .param p2, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    if-nez p1, :cond_0

    .line 90
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Connection operator may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 92
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connOperator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    .line 93
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;->createConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    .line 94
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .line 95
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    .line 96
    return-void
.end method


# virtual methods
.method public getState()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->state:Ljava/lang/Object;

    return-object v0
.end method

.method public layerProtocol(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 3
    .param p1, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 252
    if-nez p2, :cond_0

    .line 253
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Parameters must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 257
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->isConnected()Z

    move-result v1

    if-nez v1, :cond_2

    .line 258
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Connection not open."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 260
    :cond_2
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->isTunnelled()Z

    move-result v1

    if-nez v1, :cond_3

    .line 262
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Protocol layering without a tunnel not supported."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 265
    :cond_3
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->isLayered()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 266
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Multiple protocol layering not supported."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 276
    :cond_4
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v0

    .line 278
    .local v0, "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connOperator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v1, v2, v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;->updateSecureConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 281
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isSecure()Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->layerProtocol(Z)V

    .line 283
    return-void
.end method

.method public open(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 8
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 129
    if-nez p1, :cond_0

    .line 130
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Route must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 133
    :cond_0
    if-nez p3, :cond_1

    .line 134
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parameters must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 137
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 138
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Connection already open."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 147
    :cond_2
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    .line 148
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getProxyHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v7

    .line 150
    .local v7, "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connOperator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    if-eqz v7, :cond_3

    move-object v2, v7

    :goto_0
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getLocalAddress()Ljava/net/InetAddress;

    move-result-object v3

    move-object v4, p2

    move-object v5, p3

    invoke-interface/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;->openConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Ljava/net/InetAddress;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 156
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    .line 160
    .local v6, "localTracker":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;
    if-nez v6, :cond_4

    .line 161
    new-instance v0, Ljava/io/InterruptedIOException;

    const-string v1, "Request aborted"

    invoke-direct {v0, v1}, Ljava/io/InterruptedIOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 150
    .end local v6    # "localTracker":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;
    :cond_3
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v2

    goto :goto_0

    .line 164
    .restart local v6    # "localTracker":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;
    :cond_4
    if-nez v7, :cond_5

    .line 165
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isSecure()Z

    move-result v0

    invoke-virtual {v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->connectTarget(Z)V

    .line 170
    :goto_1
    return-void

    .line 167
    :cond_5
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isSecure()Z

    move-result v0

    invoke-virtual {v6, v7, v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->connectProxy(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Z)V

    goto :goto_1
.end method

.method public setState(Ljava/lang/Object;)V
    .locals 0
    .param p1, "state"    # Ljava/lang/Object;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->state:Ljava/lang/Object;

    .line 114
    return-void
.end method

.method protected shutdownEntry()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 292
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    .line 293
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->state:Ljava/lang/Object;

    .line 294
    return-void
.end method

.method public tunnelProxy(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "next"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "secure"    # Z
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 222
    if-nez p1, :cond_0

    .line 223
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Next proxy must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 226
    :cond_0
    if-nez p3, :cond_1

    .line 227
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parameters must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 232
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->isConnected()Z

    move-result v0

    if-nez v0, :cond_3

    .line 233
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Connection not open."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 236
    :cond_3
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    const/4 v1, 0x0

    invoke-interface {v0, v1, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->update(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 237
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->tunnelProxy(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Z)V

    .line 238
    return-void
.end method

.method public tunnelTarget(ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 3
    .param p1, "secure"    # Z
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 186
    if-nez p2, :cond_0

    .line 187
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parameters must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 191
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->isConnected()Z

    move-result v0

    if-nez v0, :cond_2

    .line 192
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Connection not open."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 194
    :cond_2
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->isTunnelled()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 195
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Connection is already tunnelled."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 199
    :cond_3
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v2

    invoke-interface {v0, v1, v2, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->update(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 201
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->tunnelTarget(Z)V

    .line 202
    return-void
.end method
