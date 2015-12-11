.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;
.super Ljava/lang/Object;
.source "AbstractClientConnAdapter.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
.implements Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;


# instance fields
.field private final connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

.field private volatile duration:J

.field private volatile markedReusable:Z

.field private volatile released:Z

.field private volatile wrappedConnection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V
    .locals 2
    .param p1, "mgr"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .param p2, "conn"    # Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    .prologue
    const/4 v0, 0x0

    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 100
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    .line 101
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->wrappedConnection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    .line 102
    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->markedReusable:Z

    .line 103
    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->released:Z

    .line 104
    const-wide v0, 0x7fffffffffffffffL

    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->duration:J

    .line 105
    return-void
.end method


# virtual methods
.method public declared-synchronized abortConnection()V
    .locals 4

    .prologue
    .line 308
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->released:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 318
    :goto_0
    monitor-exit p0

    return-void

    .line 311
    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->released:Z

    .line 312
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->unmarkReusable()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 314
    :try_start_2
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->shutdown()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 317
    :goto_1
    :try_start_3
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    iget-wide v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->duration:J

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, p0, v2, v3, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;->releaseConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;JLjava/util/concurrent/TimeUnit;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 308
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 315
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method protected final assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V
    .locals 1
    .param p1, "wrappedConn"    # Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException;
        }
    .end annotation

    .prologue
    .line 150
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->isReleased()Z

    move-result v0

    if-nez v0, :cond_0

    if-nez p1, :cond_1

    .line 151
    :cond_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException;-><init>()V

    throw v0

    .line 153
    :cond_1
    return-void
.end method

.method protected declared-synchronized detach()V
    .locals 2

    .prologue
    .line 112
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->wrappedConnection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    .line 113
    const-wide v0, 0x7fffffffffffffffL

    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->duration:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 114
    monitor-exit p0

    return-void

    .line 112
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 192
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 193
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 194
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->flush()V

    .line 195
    return-void
.end method

.method public getAttribute(Ljava/lang/String;)Ljava/lang/Object;
    .locals 2
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 321
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 322
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 323
    instance-of v1, v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    if-eqz v1, :cond_0

    .line 324
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .end local v0    # "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 326
    :goto_0
    return-object v1

    .restart local v0    # "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getLocalAddress()Ljava/net/InetAddress;
    .locals 2

    .prologue
    .line 236
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 237
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 238
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->getLocalAddress()Ljava/net/InetAddress;

    move-result-object v1

    return-object v1
.end method

.method public getLocalPort()I
    .locals 2

    .prologue
    .line 242
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 243
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 244
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->getLocalPort()I

    move-result v1

    return v1
.end method

.method protected getManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    return-object v0
.end method

.method public getMetrics()Lcom/comcast/cim/httpcomponentsandroid/HttpConnectionMetrics;
    .locals 2

    .prologue
    .line 186
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 187
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 188
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->getMetrics()Lcom/comcast/cim/httpcomponentsandroid/HttpConnectionMetrics;

    move-result-object v1

    return-object v1
.end method

.method public getRemoteAddress()Ljava/net/InetAddress;
    .locals 2

    .prologue
    .line 248
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 249
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 250
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->getRemoteAddress()Ljava/net/InetAddress;

    move-result-object v1

    return-object v1
.end method

.method public getRemotePort()I
    .locals 2

    .prologue
    .line 254
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 255
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 256
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->getRemotePort()I

    move-result v1

    return v1
.end method

.method public getSSLSession()Ljavax/net/ssl/SSLSession;
    .locals 4

    .prologue
    .line 266
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 267
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 268
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->isOpen()Z

    move-result v3

    if-nez v3, :cond_1

    .line 269
    const/4 v1, 0x0

    .line 276
    :cond_0
    :goto_0
    return-object v1

    .line 271
    :cond_1
    const/4 v1, 0x0

    .line 272
    .local v1, "result":Ljavax/net/ssl/SSLSession;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->getSocket()Ljava/net/Socket;

    move-result-object v2

    .line 273
    .local v2, "sock":Ljava/net/Socket;
    instance-of v3, v2, Ljavax/net/ssl/SSLSocket;

    if-eqz v3, :cond_0

    .line 274
    check-cast v2, Ljavax/net/ssl/SSLSocket;

    .end local v2    # "sock":Ljava/net/Socket;
    invoke-virtual {v2}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v1

    goto :goto_0
.end method

.method public getSocketTimeout()I
    .locals 2

    .prologue
    .line 180
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 181
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 182
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->getSocketTimeout()I

    move-result v1

    return v1
.end method

.method protected getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->wrappedConnection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    return-object v0
.end method

.method public isMarkedReusable()Z
    .locals 1

    .prologue
    .line 288
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->markedReusable:Z

    return v0
.end method

.method public isOpen()Z
    .locals 2

    .prologue
    .line 156
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 157
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    if-nez v0, :cond_0

    .line 158
    const/4 v1, 0x0

    .line 160
    :goto_0
    return v1

    :cond_0
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isOpen()Z

    move-result v1

    goto :goto_0
.end method

.method protected isReleased()Z
    .locals 1

    .prologue
    .line 139
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->released:Z

    return v0
.end method

.method public isResponseAvailable(I)Z
    .locals 2
    .param p1, "timeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 198
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 199
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 200
    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isResponseAvailable(I)Z

    move-result v1

    return v1
.end method

.method public isSecure()Z
    .locals 2

    .prologue
    .line 260
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 261
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 262
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isSecure()Z

    move-result v1

    return v1
.end method

.method public isStale()Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 164
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->isReleased()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 170
    :cond_0
    :goto_0
    return v1

    .line 166
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 167
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    if-eqz v0, :cond_0

    .line 170
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isStale()Z

    move-result v1

    goto :goto_0
.end method

.method public markReusable()V
    .locals 1

    .prologue
    .line 280
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->markedReusable:Z

    .line 281
    return-void
.end method

.method public receiveResponseEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 1
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 205
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 206
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 207
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->unmarkReusable()V

    .line 208
    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->receiveResponseEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 209
    return-void
.end method

.method public receiveResponseHeader()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 213
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 214
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 215
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->unmarkReusable()V

    .line 216
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->receiveResponseHeader()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    return-object v1
.end method

.method public declared-synchronized releaseConnection()V
    .locals 4

    .prologue
    .line 300
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->released:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 305
    :goto_0
    monitor-exit p0

    return-void

    .line 303
    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->released:Z

    .line 304
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    iget-wide v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->duration:J

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, p0, v2, v3, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;->releaseConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;JLjava/util/concurrent/TimeUnit;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 300
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public sendRequestEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 221
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 222
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 223
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->unmarkReusable()V

    .line 224
    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->sendRequestEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V

    .line 225
    return-void
.end method

.method public sendRequestHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 229
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 230
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 231
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->unmarkReusable()V

    .line 232
    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->sendRequestHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 233
    return-void
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 341
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 342
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 343
    instance-of v1, v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    if-eqz v1, :cond_0

    .line 344
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .end local v0    # "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 346
    :cond_0
    return-void
.end method

.method public setIdleDuration(JLjava/util/concurrent/TimeUnit;)V
    .locals 3
    .param p1, "duration"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 292
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    .line 293
    invoke-virtual {p3, p1, p2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->duration:J

    .line 297
    :goto_0
    return-void

    .line 295
    :cond_0
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->duration:J

    goto :goto_0
.end method

.method public setSocketTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 174
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->getWrappedConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 175
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->assertValid(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V

    .line 176
    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->setSocketTimeout(I)V

    .line 177
    return-void
.end method

.method public unmarkReusable()V
    .locals 1

    .prologue
    .line 284
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractClientConnAdapter;->markedReusable:Z

    .line 285
    return-void
.end method
