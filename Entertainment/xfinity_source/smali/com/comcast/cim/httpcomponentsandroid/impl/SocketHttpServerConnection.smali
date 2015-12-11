.class public Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;
.source "SocketHttpServerConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpInetConnection;


# instance fields
.field private volatile open:Z

.field private volatile socket:Ljava/net/Socket;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 67
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpServerConnection;-><init>()V

    .line 64
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    .line 68
    return-void
.end method


# virtual methods
.method protected assertOpen()V
    .locals 2

    .prologue
    .line 77
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->open:Z

    if-nez v0, :cond_0

    .line 78
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Connection is not open"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 80
    :cond_0
    return-void
.end method

.method public close()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 257
    iget-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->open:Z

    if-nez v1, :cond_0

    .line 280
    :goto_0
    return-void

    .line 260
    :cond_0
    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->open:Z

    .line 261
    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->open:Z

    .line 262
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    .line 264
    .local v0, "sock":Ljava/net/Socket;
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->doFlush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 267
    :try_start_1
    invoke-virtual {v0}, Ljava/net/Socket;->shutdownOutput()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 271
    :goto_1
    :try_start_2
    invoke-virtual {v0}, Ljava/net/Socket;->shutdownInput()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 278
    :goto_2
    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    throw v1

    .line 268
    :catch_0
    move-exception v1

    goto :goto_1

    .line 272
    :catch_1
    move-exception v1

    goto :goto_2

    .line 274
    :catch_2
    move-exception v1

    goto :goto_2
.end method

.method public getLocalAddress()Ljava/net/InetAddress;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getLocalAddress()Ljava/net/InetAddress;

    move-result-object v0

    .line 195
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLocalPort()I
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getLocalPort()I

    move-result v0

    .line 203
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public getRemoteAddress()Ljava/net/InetAddress;
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getInetAddress()Ljava/net/InetAddress;

    move-result-object v0

    .line 211
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getRemotePort()I
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 217
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getPort()I

    move-result v0

    .line 219
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method protected getSocket()Ljava/net/Socket;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    return-object v0
.end method

.method public getSocketTimeout()I
    .locals 3

    .prologue
    const/4 v1, -0x1

    .line 237
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    if-eqz v2, :cond_0

    .line 239
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v2}, Ljava/net/Socket;->getSoTimeout()I
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 244
    :cond_0
    :goto_0
    return v1

    .line 240
    :catch_0
    move-exception v0

    .line 241
    .local v0, "ignore":Ljava/net/SocketException;
    goto :goto_0
.end method

.method public isOpen()Z
    .locals 1

    .prologue
    .line 188
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->open:Z

    return v0
.end method

.method public setSocketTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 224
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->assertOpen()V

    .line 225
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 227
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0, p1}, Ljava/net/Socket;->setSoTimeout(I)V
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    .line 234
    :cond_0
    :goto_0
    return-void

    .line 228
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public shutdown()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 249
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->open:Z

    .line 250
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;->socket:Ljava/net/Socket;

    .line 251
    .local v0, "tmpsocket":Ljava/net/Socket;
    if-eqz v0, :cond_0

    .line 252
    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    .line 254
    :cond_0
    return-void
.end method
