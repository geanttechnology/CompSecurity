.class public final Lcom/squareup/okhttp/Connection;
.super Ljava/lang/Object;
.source "Connection.java"

# interfaces
.implements Ljava/io/Closeable;


# instance fields
.field private connected:Z

.field private handshake:Lcom/squareup/okhttp/Handshake;

.field private httpConnection:Lcom/squareup/okhttp/internal/http/HttpConnection;

.field private httpMinorVersion:I

.field private idleStartTimeNs:J

.field private in:Ljava/io/InputStream;

.field private out:Ljava/io/OutputStream;

.field private owner:Ljava/lang/Object;

.field private final pool:Lcom/squareup/okhttp/ConnectionPool;

.field private recycleCount:I

.field private final route:Lcom/squareup/okhttp/Route;

.field private sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

.field private socket:Ljava/net/Socket;

.field private source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

.field private spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/ConnectionPool;Lcom/squareup/okhttp/Route;)V
    .locals 1
    .param p1, "pool"    # Lcom/squareup/okhttp/ConnectionPool;
    .param p2, "route"    # Lcom/squareup/okhttp/Route;

    .prologue
    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/squareup/okhttp/Connection;->connected:Z

    .line 83
    const/4 v0, 0x1

    iput v0, p0, Lcom/squareup/okhttp/Connection;->httpMinorVersion:I

    .line 96
    iput-object p1, p0, Lcom/squareup/okhttp/Connection;->pool:Lcom/squareup/okhttp/ConnectionPool;

    .line 97
    iput-object p2, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    .line 98
    return-void
.end method

.method private initSourceAndSink()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 417
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->in:Ljava/io/InputStream;

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/Okio;->source(Ljava/io/InputStream;)Lcom/squareup/okhttp/internal/okio/Source;

    move-result-object v0

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Source;)Lcom/squareup/okhttp/internal/okio/BufferedSource;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/Connection;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    .line 418
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->out:Ljava/io/OutputStream;

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/Okio;->sink(Ljava/io/OutputStream;)Lcom/squareup/okhttp/internal/okio/Sink;

    move-result-object v0

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Sink;)Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/Connection;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    .line 419
    return-void
.end method

.method private makeTunnel(Lcom/squareup/okhttp/TunnelRequest;)V
    .locals 10
    .param p1, "tunnelRequest"    # Lcom/squareup/okhttp/TunnelRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 383
    iget-object v6, p0, Lcom/squareup/okhttp/Connection;->in:Ljava/io/InputStream;

    invoke-static {v6}, Lcom/squareup/okhttp/internal/okio/Okio;->source(Ljava/io/InputStream;)Lcom/squareup/okhttp/internal/okio/Source;

    move-result-object v6

    invoke-static {v6}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Source;)Lcom/squareup/okhttp/internal/okio/BufferedSource;

    move-result-object v5

    .line 384
    .local v5, "tunnelSource":Lcom/squareup/okhttp/internal/okio/BufferedSource;
    iget-object v6, p0, Lcom/squareup/okhttp/Connection;->out:Ljava/io/OutputStream;

    invoke-static {v6}, Lcom/squareup/okhttp/internal/okio/Okio;->sink(Ljava/io/OutputStream;)Lcom/squareup/okhttp/internal/okio/Sink;

    move-result-object v6

    invoke-static {v6}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Sink;)Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v4

    .line 385
    .local v4, "tunnelSink":Lcom/squareup/okhttp/internal/okio/BufferedSink;
    new-instance v3, Lcom/squareup/okhttp/internal/http/HttpConnection;

    iget-object v6, p0, Lcom/squareup/okhttp/Connection;->pool:Lcom/squareup/okhttp/ConnectionPool;

    invoke-direct {v3, v6, p0, v5, v4}, Lcom/squareup/okhttp/internal/http/HttpConnection;-><init>(Lcom/squareup/okhttp/ConnectionPool;Lcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/okio/BufferedSource;Lcom/squareup/okhttp/internal/okio/BufferedSink;)V

    .line 386
    .local v3, "tunnelConnection":Lcom/squareup/okhttp/internal/http/HttpConnection;
    invoke-virtual {p1}, Lcom/squareup/okhttp/TunnelRequest;->getRequest()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v0

    .line 387
    .local v0, "request":Lcom/squareup/okhttp/internal/http/Request;
    invoke-virtual {p1}, Lcom/squareup/okhttp/TunnelRequest;->requestLine()Ljava/lang/String;

    move-result-object v1

    .line 389
    .local v1, "requestLine":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Request;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v6

    invoke-virtual {v3, v6, v1}, Lcom/squareup/okhttp/internal/http/HttpConnection;->writeRequest(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)V

    .line 390
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/HttpConnection;->flush()V

    .line 391
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/HttpConnection;->readResponse()Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v6

    invoke-virtual {v6, v0}, Lcom/squareup/okhttp/internal/http/Response$Builder;->request(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v6

    invoke-virtual {v6}, Lcom/squareup/okhttp/internal/http/Response$Builder;->build()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v2

    .line 392
    .local v2, "response":Lcom/squareup/okhttp/internal/http/Response;
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/HttpConnection;->emptyResponseBody()V

    .line 394
    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v6

    sparse-switch v6, :sswitch_data_0

    .line 410
    new-instance v6, Ljava/io/IOException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Unexpected response code for CONNECT: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 398
    :sswitch_0
    invoke-interface {v5}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->buffer()Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v6

    invoke-virtual {v6}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v6, v6, v8

    if-lez v6, :cond_1

    .line 399
    new-instance v6, Ljava/io/IOException;

    const-string/jumbo v7, "TLS tunnel buffered too many bytes!"

    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 404
    :sswitch_1
    iget-object v6, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v6, v6, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v6, v6, Lcom/squareup/okhttp/Address;->authenticator:Lcom/squareup/okhttp/OkAuthenticator;

    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->proxy:Ljava/net/Proxy;

    invoke-static {v6, v2, v7}, Lcom/squareup/okhttp/internal/http/HttpAuthenticator;->processAuthHeader(Lcom/squareup/okhttp/OkAuthenticator;Lcom/squareup/okhttp/internal/http/Response;Ljava/net/Proxy;)Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v0

    .line 406
    if-nez v0, :cond_0

    .line 407
    new-instance v6, Ljava/io/IOException;

    const-string/jumbo v7, "Failed to authenticate with proxy"

    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 401
    :cond_1
    return-void

    .line 394
    :sswitch_data_0
    .sparse-switch
        0xc8 -> :sswitch_0
        0x197 -> :sswitch_1
    .end sparse-switch
.end method

.method private upgradeToTls(Lcom/squareup/okhttp/TunnelRequest;)V
    .locals 11
    .param p1, "tunnelRequest"    # Lcom/squareup/okhttp/TunnelRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 174
    invoke-static {}, Lcom/squareup/okhttp/internal/Platform;->get()Lcom/squareup/okhttp/internal/Platform;

    move-result-object v1

    .line 177
    .local v1, "platform":Lcom/squareup/okhttp/internal/Platform;
    invoke-virtual {p0}, Lcom/squareup/okhttp/Connection;->requiresTunnel()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 178
    invoke-direct {p0, p1}, Lcom/squareup/okhttp/Connection;->makeTunnel(Lcom/squareup/okhttp/TunnelRequest;)V

    .line 182
    :cond_0
    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->sslSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    iget-object v8, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    iget-object v9, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v9, v9, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v9, v9, Lcom/squareup/okhttp/Address;->uriHost:Ljava/lang/String;

    iget-object v10, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v10, v10, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget v10, v10, Lcom/squareup/okhttp/Address;->uriPort:I

    invoke-virtual {v7, v8, v9, v10, v5}, Ljavax/net/ssl/SSLSocketFactory;->createSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;

    move-result-object v7

    iput-object v7, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    .line 184
    iget-object v3, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    check-cast v3, Ljavax/net/ssl/SSLSocket;

    .line 185
    .local v3, "sslSocket":Ljavax/net/ssl/SSLSocket;
    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-boolean v7, v7, Lcom/squareup/okhttp/Route;->modernTls:Z

    if-eqz v7, :cond_3

    .line 186
    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->uriHost:Ljava/lang/String;

    invoke-virtual {v1, v3, v7}, Lcom/squareup/okhttp/internal/Platform;->enableTlsExtensions(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;)V

    .line 191
    :goto_0
    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-boolean v7, v7, Lcom/squareup/okhttp/Route;->modernTls:Z

    if-eqz v7, :cond_4

    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->protocols:Ljava/util/List;

    sget-object v8, Lcom/squareup/okhttp/Protocol;->HTTP_2:Lcom/squareup/okhttp/Protocol;

    invoke-interface {v7, v8}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_1

    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->protocols:Ljava/util/List;

    sget-object v8, Lcom/squareup/okhttp/Protocol;->SPDY_3:Lcom/squareup/okhttp/Protocol;

    invoke-interface {v7, v8}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    :cond_1
    move v4, v5

    .line 196
    .local v4, "useNpn":Z
    :goto_1
    if-eqz v4, :cond_2

    .line 197
    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->protocols:Ljava/util/List;

    sget-object v8, Lcom/squareup/okhttp/Protocol;->HTTP_2:Lcom/squareup/okhttp/Protocol;

    invoke-interface {v7, v8}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->protocols:Ljava/util/List;

    sget-object v8, Lcom/squareup/okhttp/Protocol;->SPDY_3:Lcom/squareup/okhttp/Protocol;

    invoke-interface {v7, v8}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 199
    sget-object v7, Lcom/squareup/okhttp/internal/Util;->HTTP2_SPDY3_AND_HTTP:Ljava/util/List;

    invoke-virtual {v1, v3, v7}, Lcom/squareup/okhttp/internal/Platform;->setNpnProtocols(Ljavax/net/ssl/SSLSocket;Ljava/util/List;)V

    .line 208
    :cond_2
    :goto_2
    invoke-virtual {v3}, Ljavax/net/ssl/SSLSocket;->startHandshake()V

    .line 211
    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->hostnameVerifier:Ljavax/net/ssl/HostnameVerifier;

    iget-object v8, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v8, v8, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v8, v8, Lcom/squareup/okhttp/Address;->uriHost:Ljava/lang/String;

    invoke-virtual {v3}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v9

    invoke-interface {v7, v8, v9}, Ljavax/net/ssl/HostnameVerifier;->verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z

    move-result v7

    if-nez v7, :cond_7

    .line 212
    new-instance v5, Ljava/io/IOException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Hostname \'"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->uriHost:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "\' was not verified"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 188
    .end local v4    # "useNpn":Z
    :cond_3
    invoke-virtual {v1, v3}, Lcom/squareup/okhttp/internal/Platform;->supportTlsIntolerantServer(Ljavax/net/ssl/SSLSocket;)V

    goto/16 :goto_0

    :cond_4
    move v4, v6

    .line 191
    goto :goto_1

    .line 200
    .restart local v4    # "useNpn":Z
    :cond_5
    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v7, v7, Lcom/squareup/okhttp/Address;->protocols:Ljava/util/List;

    sget-object v8, Lcom/squareup/okhttp/Protocol;->HTTP_2:Lcom/squareup/okhttp/Protocol;

    invoke-interface {v7, v8}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_6

    .line 201
    sget-object v7, Lcom/squareup/okhttp/internal/Util;->HTTP2_AND_HTTP_11:Ljava/util/List;

    invoke-virtual {v1, v3, v7}, Lcom/squareup/okhttp/internal/Platform;->setNpnProtocols(Ljavax/net/ssl/SSLSocket;Ljava/util/List;)V

    goto :goto_2

    .line 203
    :cond_6
    sget-object v7, Lcom/squareup/okhttp/internal/Util;->SPDY3_AND_HTTP11:Ljava/util/List;

    invoke-virtual {v1, v3, v7}, Lcom/squareup/okhttp/internal/Platform;->setNpnProtocols(Ljavax/net/ssl/SSLSocket;Ljava/util/List;)V

    goto :goto_2

    .line 215
    :cond_7
    invoke-virtual {v3}, Ljavax/net/ssl/SSLSocket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v7

    iput-object v7, p0, Lcom/squareup/okhttp/Connection;->out:Ljava/io/OutputStream;

    .line 216
    invoke-virtual {v3}, Ljavax/net/ssl/SSLSocket;->getInputStream()Ljava/io/InputStream;

    move-result-object v7

    iput-object v7, p0, Lcom/squareup/okhttp/Connection;->in:Ljava/io/InputStream;

    .line 217
    invoke-virtual {v3}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v7

    invoke-static {v7}, Lcom/squareup/okhttp/Handshake;->get(Ljavax/net/ssl/SSLSession;)Lcom/squareup/okhttp/Handshake;

    move-result-object v7

    iput-object v7, p0, Lcom/squareup/okhttp/Connection;->handshake:Lcom/squareup/okhttp/Handshake;

    .line 218
    invoke-direct {p0}, Lcom/squareup/okhttp/Connection;->initSourceAndSink()V

    .line 221
    sget-object v2, Lcom/squareup/okhttp/Protocol;->HTTP_11:Lcom/squareup/okhttp/Protocol;

    .line 222
    .local v2, "selectedProtocol":Lcom/squareup/okhttp/Protocol;
    if-eqz v4, :cond_8

    invoke-virtual {v1, v3}, Lcom/squareup/okhttp/internal/Platform;->getNpnSelectedProtocol(Ljavax/net/ssl/SSLSocket;)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v0

    .local v0, "maybeProtocol":Lcom/squareup/okhttp/internal/okio/ByteString;
    if-eqz v0, :cond_8

    .line 223
    invoke-static {v0}, Lcom/squareup/okhttp/internal/Util;->getProtocol(Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/Protocol;

    move-result-object v2

    .line 226
    .end local v0    # "maybeProtocol":Lcom/squareup/okhttp/internal/okio/ByteString;
    :cond_8
    iget-boolean v7, v2, Lcom/squareup/okhttp/Protocol;->spdyVariant:Z

    if-eqz v7, :cond_9

    .line 227
    invoke-virtual {v3, v6}, Ljavax/net/ssl/SSLSocket;->setSoTimeout(I)V

    .line 228
    new-instance v6, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v7, v7, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    invoke-virtual {v7}, Lcom/squareup/okhttp/Address;->getUriHost()Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/squareup/okhttp/Connection;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    iget-object v9, p0, Lcom/squareup/okhttp/Connection;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-direct {v6, v7, v5, v8, v9}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;-><init>(Ljava/lang/String;ZLcom/squareup/okhttp/internal/okio/BufferedSource;Lcom/squareup/okhttp/internal/okio/BufferedSink;)V

    invoke-virtual {v6, v2}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->protocol(Lcom/squareup/okhttp/Protocol;)Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    move-result-object v5

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->build()Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    move-result-object v5

    iput-object v5, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    .line 230
    iget-object v5, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection;->sendConnectionHeader()V

    .line 234
    :goto_3
    return-void

    .line 232
    :cond_9
    new-instance v5, Lcom/squareup/okhttp/internal/http/HttpConnection;

    iget-object v6, p0, Lcom/squareup/okhttp/Connection;->pool:Lcom/squareup/okhttp/ConnectionPool;

    iget-object v7, p0, Lcom/squareup/okhttp/Connection;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    iget-object v8, p0, Lcom/squareup/okhttp/Connection;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-direct {v5, v6, p0, v7, v8}, Lcom/squareup/okhttp/internal/http/HttpConnection;-><init>(Lcom/squareup/okhttp/ConnectionPool;Lcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/okio/BufferedSource;Lcom/squareup/okhttp/internal/okio/BufferedSink;)V

    iput-object v5, p0, Lcom/squareup/okhttp/Connection;->httpConnection:Lcom/squareup/okhttp/internal/http/HttpConnection;

    goto :goto_3
.end method


# virtual methods
.method public clearOwner()Z
    .locals 2

    .prologue
    .line 121
    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->pool:Lcom/squareup/okhttp/ConnectionPool;

    monitor-enter v1

    .line 122
    :try_start_0
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->owner:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 124
    const/4 v0, 0x0

    monitor-exit v1

    .line 128
    :goto_0
    return v0

    .line 127
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/squareup/okhttp/Connection;->owner:Ljava/lang/Object;

    .line 128
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 129
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 242
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    .line 243
    return-void
.end method

.method public closeIfOwnedBy(Ljava/lang/Object;)V
    .locals 2
    .param p1, "owner"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 137
    invoke-virtual {p0}, Lcom/squareup/okhttp/Connection;->isSpdy()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 138
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->pool:Lcom/squareup/okhttp/ConnectionPool;

    monitor-enter v1

    .line 139
    :try_start_0
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->owner:Ljava/lang/Object;

    if-eq v0, p1, :cond_1

    .line 140
    monitor-exit v1

    .line 148
    :goto_0
    return-void

    .line 143
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/squareup/okhttp/Connection;->owner:Ljava/lang/Object;

    .line 144
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 147
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    goto :goto_0

    .line 144
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public connect(IILcom/squareup/okhttp/TunnelRequest;)V
    .locals 4
    .param p1, "connectTimeout"    # I
    .param p2, "readTimeout"    # I
    .param p3, "tunnelRequest"    # Lcom/squareup/okhttp/TunnelRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 152
    iget-boolean v0, p0, Lcom/squareup/okhttp/Connection;->connected:Z

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "already connected"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v0, v0, Lcom/squareup/okhttp/Route;->proxy:Ljava/net/Proxy;

    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v0

    sget-object v1, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    if-eq v0, v1, :cond_1

    new-instance v0, Ljava/net/Socket;

    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v1, v1, Lcom/squareup/okhttp/Route;->proxy:Ljava/net/Proxy;

    invoke-direct {v0, v1}, Ljava/net/Socket;-><init>(Ljava/net/Proxy;)V

    :goto_0
    iput-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    .line 155
    invoke-static {}, Lcom/squareup/okhttp/internal/Platform;->get()Lcom/squareup/okhttp/internal/Platform;

    move-result-object v0

    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    iget-object v2, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v2, v2, Lcom/squareup/okhttp/Route;->inetSocketAddress:Ljava/net/InetSocketAddress;

    invoke-virtual {v0, v1, v2, p1}, Lcom/squareup/okhttp/internal/Platform;->connectSocket(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V

    .line 156
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0, p2}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 157
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/Connection;->in:Ljava/io/InputStream;

    .line 158
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/Connection;->out:Ljava/io/OutputStream;

    .line 160
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v0, v0, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v0, v0, Lcom/squareup/okhttp/Address;->sslSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    if-eqz v0, :cond_2

    .line 161
    invoke-direct {p0, p3}, Lcom/squareup/okhttp/Connection;->upgradeToTls(Lcom/squareup/okhttp/TunnelRequest;)V

    .line 166
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/squareup/okhttp/Connection;->connected:Z

    .line 167
    return-void

    .line 154
    :cond_1
    new-instance v0, Ljava/net/Socket;

    invoke-direct {v0}, Ljava/net/Socket;-><init>()V

    goto :goto_0

    .line 163
    :cond_2
    invoke-direct {p0}, Lcom/squareup/okhttp/Connection;->initSourceAndSink()V

    .line 164
    new-instance v0, Lcom/squareup/okhttp/internal/http/HttpConnection;

    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->pool:Lcom/squareup/okhttp/ConnectionPool;

    iget-object v2, p0, Lcom/squareup/okhttp/Connection;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    iget-object v3, p0, Lcom/squareup/okhttp/Connection;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-direct {v0, v1, p0, v2, v3}, Lcom/squareup/okhttp/internal/http/HttpConnection;-><init>(Lcom/squareup/okhttp/ConnectionPool;Lcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/okio/BufferedSource;Lcom/squareup/okhttp/internal/okio/BufferedSink;)V

    iput-object v0, p0, Lcom/squareup/okhttp/Connection;->httpConnection:Lcom/squareup/okhttp/internal/http/HttpConnection;

    goto :goto_1
.end method

.method public getHandshake()Lcom/squareup/okhttp/Handshake;
    .locals 1

    .prologue
    .line 320
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->handshake:Lcom/squareup/okhttp/Handshake;

    return-object v0
.end method

.method public getHttpMinorVersion()I
    .locals 1

    .prologue
    .line 344
    iget v0, p0, Lcom/squareup/okhttp/Connection;->httpMinorVersion:I

    return v0
.end method

.method public getIdleStartTimeNs()J
    .locals 2

    .prologue
    .line 316
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    if-nez v0, :cond_0

    iget-wide v0, p0, Lcom/squareup/okhttp/Connection;->idleStartTimeNs:J

    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection;->getIdleStartTimeNs()J

    move-result-wide v0

    goto :goto_0
.end method

.method public getOwner()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 101
    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->pool:Lcom/squareup/okhttp/ConnectionPool;

    monitor-enter v1

    .line 102
    :try_start_0
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->owner:Ljava/lang/Object;

    monitor-exit v1

    return-object v0

    .line 103
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getRoute()Lcom/squareup/okhttp/Route;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    return-object v0
.end method

.method public getSocket()Ljava/net/Socket;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    return-object v0
.end method

.method public incrementRecycleCount()V
    .locals 1

    .prologue
    .line 366
    iget v0, p0, Lcom/squareup/okhttp/Connection;->recycleCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/squareup/okhttp/Connection;->recycleCount:I

    .line 367
    return-void
.end method

.method public isAlive()Z
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->isInputShutdown()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->isOutputShutdown()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isConnected()Z
    .locals 1

    .prologue
    .line 238
    iget-boolean v0, p0, Lcom/squareup/okhttp/Connection;->connected:Z

    return v0
.end method

.method public isExpired(J)Z
    .locals 4
    .param p1, "keepAliveDurationNs"    # J

    .prologue
    .line 308
    invoke-virtual {p0}, Lcom/squareup/okhttp/Connection;->getIdleStartTimeNs()J

    move-result-wide v0

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    sub-long/2addr v2, p1

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isIdle()Z
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection;->isIdle()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isReadable()Z
    .locals 7

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 269
    iget-object v5, p0, Lcom/squareup/okhttp/Connection;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    if-nez v5, :cond_1

    .line 289
    :cond_0
    :goto_0
    return v3

    .line 272
    :cond_1
    invoke-virtual {p0}, Lcom/squareup/okhttp/Connection;->isSpdy()Z

    move-result v5

    if-nez v5, :cond_0

    .line 276
    :try_start_0
    iget-object v5, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v5}, Ljava/net/Socket;->getSoTimeout()I
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v2

    .line 278
    .local v2, "readTimeout":I
    :try_start_1
    iget-object v5, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 279
    iget-object v5, p0, Lcom/squareup/okhttp/Connection;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    invoke-interface {v5}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->exhausted()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v5

    if-eqz v5, :cond_2

    .line 284
    :try_start_2
    iget-object v5, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v5, v2}, Ljava/net/Socket;->setSoTimeout(I)V

    move v3, v4

    goto :goto_0

    :cond_2
    iget-object v5, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v5, v2}, Ljava/net/Socket;->setSoTimeout(I)V

    goto :goto_0

    .line 286
    .end local v2    # "readTimeout":I
    :catch_0
    move-exception v1

    .line 287
    .local v1, "ignored":Ljava/net/SocketTimeoutException;
    goto :goto_0

    .line 284
    .end local v1    # "ignored":Ljava/net/SocketTimeoutException;
    .restart local v2    # "readTimeout":I
    :catchall_0
    move-exception v5

    iget-object v6, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v6, v2}, Ljava/net/Socket;->setSoTimeout(I)V

    throw v5
    :try_end_2
    .catch Ljava/net/SocketTimeoutException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 288
    .end local v2    # "readTimeout":I
    :catch_1
    move-exception v0

    .local v0, "e":Ljava/io/IOException;
    move v3, v4

    .line 289
    goto :goto_0
.end method

.method public isSpdy()Z
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public newTransport(Lcom/squareup/okhttp/internal/http/HttpEngine;)Ljava/lang/Object;
    .locals 2
    .param p1, "httpEngine"    # Lcom/squareup/okhttp/internal/http/HttpEngine;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 325
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    if-eqz v0, :cond_0

    new-instance v0, Lcom/squareup/okhttp/internal/http/SpdyTransport;

    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    invoke-direct {v0, p1, v1}, Lcom/squareup/okhttp/internal/http/SpdyTransport;-><init>(Lcom/squareup/okhttp/internal/http/HttpEngine;Lcom/squareup/okhttp/internal/spdy/SpdyConnection;)V

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/squareup/okhttp/internal/http/HttpTransport;

    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->httpConnection:Lcom/squareup/okhttp/internal/http/HttpConnection;

    invoke-direct {v0, p1, v1}, Lcom/squareup/okhttp/internal/http/HttpTransport;-><init>(Lcom/squareup/okhttp/internal/http/HttpEngine;Lcom/squareup/okhttp/internal/http/HttpConnection;)V

    goto :goto_0
.end method

.method public recycleCount()I
    .locals 1

    .prologue
    .line 374
    iget v0, p0, Lcom/squareup/okhttp/Connection;->recycleCount:I

    return v0
.end method

.method public requiresTunnel()Z
    .locals 2

    .prologue
    .line 357
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v0, v0, Lcom/squareup/okhttp/Route;->address:Lcom/squareup/okhttp/Address;

    iget-object v0, v0, Lcom/squareup/okhttp/Address;->sslSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->route:Lcom/squareup/okhttp/Route;

    iget-object v0, v0, Lcom/squareup/okhttp/Route;->proxy:Ljava/net/Proxy;

    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v0

    sget-object v1, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public resetIdleStartTime()V
    .locals 2

    .prologue
    .line 294
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->spdyConnection:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "spdyConnection != null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 295
    :cond_0
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/squareup/okhttp/Connection;->idleStartTimeNs:J

    .line 296
    return-void
.end method

.method public setHttpMinorVersion(I)V
    .locals 0
    .param p1, "httpMinorVersion"    # I

    .prologue
    .line 348
    iput p1, p0, Lcom/squareup/okhttp/Connection;->httpMinorVersion:I

    .line 349
    return-void
.end method

.method public setOwner(Ljava/lang/Object;)V
    .locals 3
    .param p1, "owner"    # Ljava/lang/Object;

    .prologue
    .line 107
    invoke-virtual {p0}, Lcom/squareup/okhttp/Connection;->isSpdy()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 112
    :goto_0
    return-void

    .line 108
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/Connection;->pool:Lcom/squareup/okhttp/ConnectionPool;

    monitor-enter v1

    .line 109
    :try_start_0
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->owner:Ljava/lang/Object;

    if-eqz v0, :cond_1

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Connection already has an owner!"

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 111
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 110
    :cond_1
    :try_start_1
    iput-object p1, p0, Lcom/squareup/okhttp/Connection;->owner:Ljava/lang/Object;

    .line 111
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public updateReadTimeout(I)V
    .locals 2
    .param p1, "newTimeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 361
    iget-boolean v0, p0, Lcom/squareup/okhttp/Connection;->connected:Z

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "updateReadTimeout - not connected"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 362
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/Connection;->socket:Ljava/net/Socket;

    invoke-virtual {v0, p1}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 363
    return-void
.end method
