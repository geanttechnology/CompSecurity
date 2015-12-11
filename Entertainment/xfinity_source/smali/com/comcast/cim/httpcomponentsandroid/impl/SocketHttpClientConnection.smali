.class public Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;
.source "SocketHttpClientConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpInetConnection;


# instance fields
.field private volatile open:Z

.field private volatile socket:Ljava/net/Socket;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 68
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/AbstractHttpClientConnection;-><init>()V

    .line 65
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    .line 69
    return-void
.end method


# virtual methods
.method protected assertNotOpen()V
    .locals 2

    .prologue
    .line 72
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->open:Z

    if-eqz v0, :cond_0

    .line 73
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Connection is already open"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :cond_0
    return-void
.end method

.method protected assertOpen()V
    .locals 2

    .prologue
    .line 78
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->open:Z

    if-nez v0, :cond_0

    .line 79
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Connection is not open"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 81
    :cond_0
    return-void
.end method

.method protected bind(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 3
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 148
    if-nez p1, :cond_0

    .line 149
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Socket may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 151
    :cond_0
    if-nez p2, :cond_1

    .line 152
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP parameters may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 154
    :cond_1
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    .line 156
    invoke-static {p2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->getSocketBufferSize(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)I

    move-result v0

    .line 158
    .local v0, "buffersize":I
    invoke-virtual {p0, p1, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->createSessionInputBuffer(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    move-result-object v1

    invoke-virtual {p0, p1, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->createSessionOutputBuffer(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;

    move-result-object v2

    invoke-virtual {p0, v1, v2, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->init(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 163
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->open:Z

    .line 164
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
    .line 240
    iget-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->open:Z

    if-nez v1, :cond_0

    .line 262
    :goto_0
    return-void

    .line 243
    :cond_0
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->open:Z

    .line 244
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    .line 246
    .local v0, "sock":Ljava/net/Socket;
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->doFlush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 249
    :try_start_1
    invoke-virtual {v0}, Ljava/net/Socket;->shutdownOutput()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 253
    :goto_1
    :try_start_2
    invoke-virtual {v0}, Ljava/net/Socket;->shutdownInput()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 260
    :goto_2
    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    throw v1

    .line 250
    :catch_0
    move-exception v1

    goto :goto_1

    .line 254
    :catch_1
    move-exception v1

    goto :goto_2

    .line 256
    :catch_2
    move-exception v1

    goto :goto_2
.end method

.method protected createSessionInputBuffer(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .locals 1
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "buffersize"    # I
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 102
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;-><init>(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    return-object v0
.end method

.method protected createSessionOutputBuffer(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/io/SessionOutputBuffer;
    .locals 1
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "buffersize"    # I
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 124
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketOutputBuffer;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketOutputBuffer;-><init>(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    return-object v0
.end method

.method public getLocalAddress()Ljava/net/InetAddress;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 176
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getLocalAddress()Ljava/net/InetAddress;

    move-result-object v0

    .line 178
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLocalPort()I
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 184
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getLocalPort()I

    move-result v0

    .line 186
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public getRemoteAddress()Ljava/net/InetAddress;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 192
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getInetAddress()Ljava/net/InetAddress;

    move-result-object v0

    .line 194
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getRemotePort()I
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 200
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getPort()I

    move-result v0

    .line 202
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method protected getSocket()Ljava/net/Socket;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    return-object v0
.end method

.method public getSocketTimeout()I
    .locals 3

    .prologue
    const/4 v1, -0x1

    .line 220
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    if-eqz v2, :cond_0

    .line 222
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v2}, Ljava/net/Socket;->getSoTimeout()I
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 227
    :cond_0
    :goto_0
    return v1

    .line 223
    :catch_0
    move-exception v0

    .line 224
    .local v0, "ignore":Ljava/net/SocketException;
    goto :goto_0
.end method

.method public isOpen()Z
    .locals 1

    .prologue
    .line 167
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->open:Z

    return v0
.end method

.method public setSocketTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 207
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->assertOpen()V

    .line 208
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 210
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    invoke-virtual {v0, p1}, Ljava/net/Socket;->setSoTimeout(I)V
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    .line 217
    :cond_0
    :goto_0
    return-void

    .line 211
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
    .line 232
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->open:Z

    .line 233
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->socket:Ljava/net/Socket;

    .line 234
    .local v0, "tmpsocket":Ljava/net/Socket;
    if-eqz v0, :cond_0

    .line 235
    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    .line 237
    :cond_0
    return-void
.end method
