.class public Lcom/squareup/okhttp/internal/http/HttpEngine;
.super Ljava/lang/Object;
.source "HttpEngine.java"


# instance fields
.field public final bufferRequestBody:Z

.field private bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

.field private cacheRequest:Ljava/net/CacheRequest;

.field final client:Lcom/squareup/okhttp/OkHttpClient;

.field private connection:Lcom/squareup/okhttp/Connection;

.field private originalRequest:Lcom/squareup/okhttp/internal/http/Request;

.field private request:Lcom/squareup/okhttp/internal/http/Request;

.field private requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

.field private response:Lcom/squareup/okhttp/internal/http/Response;

.field private responseBody:Lcom/squareup/okhttp/internal/okio/Source;

.field private responseBodyBytes:Ljava/io/InputStream;

.field private responseSource:Lcom/squareup/okhttp/ResponseSource;

.field private responseTransferSource:Lcom/squareup/okhttp/internal/okio/Source;

.field private route:Lcom/squareup/okhttp/Route;

.field private routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

.field sentRequestMillis:J

.field private transparentGzip:Z

.field private transport:Lcom/squareup/okhttp/internal/http/Transport;

.field private validatingResponse:Lcom/squareup/okhttp/internal/http/Response;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/internal/http/Request;ZLcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/http/RouteSelector;Lcom/squareup/okhttp/internal/http/RetryableSink;)V
    .locals 2
    .param p1, "client"    # Lcom/squareup/okhttp/OkHttpClient;
    .param p2, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .param p3, "bufferRequestBody"    # Z
    .param p4, "connection"    # Lcom/squareup/okhttp/Connection;
    .param p5, "routeSelector"    # Lcom/squareup/okhttp/internal/http/RouteSelector;
    .param p6, "requestBodyOut"    # Lcom/squareup/okhttp/internal/http/RetryableSink;

    .prologue
    .line 134
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->sentRequestMillis:J

    .line 135
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    .line 136
    iput-object p2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->originalRequest:Lcom/squareup/okhttp/internal/http/Request;

    .line 137
    iput-object p2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 138
    iput-boolean p3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferRequestBody:Z

    .line 139
    iput-object p4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    .line 140
    iput-object p5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    .line 141
    iput-object p6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    .line 143
    if-eqz p4, :cond_0

    .line 144
    invoke-virtual {p4, p0}, Lcom/squareup/okhttp/Connection;->setOwner(Ljava/lang/Object;)V

    .line 145
    invoke-virtual {p4}, Lcom/squareup/okhttp/Connection;->getRoute()Lcom/squareup/okhttp/Route;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->route:Lcom/squareup/okhttp/Route;

    .line 149
    :goto_0
    return-void

    .line 147
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->route:Lcom/squareup/okhttp/Route;

    goto :goto_0
.end method

.method private cacheableResponse()Lcom/squareup/okhttp/internal/http/Response;
    .locals 2

    .prologue
    .line 218
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->newBuilder()Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->body(Lcom/squareup/okhttp/internal/http/Response$Body;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response$Builder;->build()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v0

    return-object v0
.end method

.method private static combine(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Response;)Lcom/squareup/okhttp/internal/http/Response;
    .locals 8
    .param p0, "cached"    # Lcom/squareup/okhttp/internal/http/Response;
    .param p1, "network"    # Lcom/squareup/okhttp/internal/http/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 642
    new-instance v4, Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-direct {v4}, Lcom/squareup/okhttp/internal/http/Headers$Builder;-><init>()V

    .line 644
    .local v4, "result":Lcom/squareup/okhttp/internal/http/Headers$Builder;
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    .line 645
    .local v0, "cachedHeaders":Lcom/squareup/okhttp/internal/http/Headers;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v6

    if-ge v2, v6, :cond_3

    .line 646
    invoke-virtual {v0, v2}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v1

    .line 647
    .local v1, "fieldName":Ljava/lang/String;
    invoke-virtual {v0, v2}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v5

    .line 648
    .local v5, "value":Ljava/lang/String;
    const-string/jumbo v6, "Warning"

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    const-string/jumbo v6, "1"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 645
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 651
    :cond_1
    invoke-static {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->isEndToEnd(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/http/Response;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    if-nez v6, :cond_0

    .line 652
    :cond_2
    invoke-virtual {v4, v1, v5}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->add(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    goto :goto_1

    .line 656
    .end local v1    # "fieldName":Ljava/lang/String;
    .end local v5    # "value":Ljava/lang/String;
    :cond_3
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v3

    .line 657
    .local v3, "networkHeaders":Lcom/squareup/okhttp/internal/http/Headers;
    const/4 v2, 0x0

    :goto_2
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v6

    if-ge v2, v6, :cond_5

    .line 658
    invoke-virtual {v3, v2}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v1

    .line 659
    .restart local v1    # "fieldName":Ljava/lang/String;
    invoke-static {v1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->isEndToEnd(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 660
    invoke-virtual {v3, v2}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v1, v6}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->add(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    .line 657
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 664
    .end local v1    # "fieldName":Ljava/lang/String;
    :cond_5
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Response;->newBuilder()Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v6

    invoke-virtual {v4}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->build()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/squareup/okhttp/internal/http/Response$Builder;->headers(Lcom/squareup/okhttp/internal/http/Headers;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v6

    invoke-virtual {v6}, Lcom/squareup/okhttp/internal/http/Response$Builder;->build()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v6

    return-object v6
.end method

.method private connect()V
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 223
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    if-eqz v2, :cond_0

    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-direct {v2}, Ljava/lang/IllegalStateException;-><init>()V

    throw v2

    .line 225
    :cond_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    if-nez v2, :cond_4

    .line 226
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 227
    .local v1, "uriHost":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_2

    .line 228
    :cond_1
    new-instance v2, Ljava/net/UnknownHostException;

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v5

    invoke-virtual {v5}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v5}, Ljava/net/UnknownHostException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 230
    :cond_2
    const/4 v3, 0x0

    .line 231
    .local v3, "sslSocketFactory":Ljavax/net/ssl/SSLSocketFactory;
    const/4 v4, 0x0

    .line 232
    .local v4, "hostnameVerifier":Ljavax/net/ssl/HostnameVerifier;
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->isHttps()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 233
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v2}, Lcom/squareup/okhttp/OkHttpClient;->getSslSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v3

    .line 234
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v2}, Lcom/squareup/okhttp/OkHttpClient;->getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v4

    .line 236
    :cond_3
    new-instance v0, Lcom/squareup/okhttp/Address;

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v2

    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->getEffectivePort(Ljava/net/URL;)I

    move-result v2

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v5}, Lcom/squareup/okhttp/OkHttpClient;->getAuthenticator()Lcom/squareup/okhttp/OkAuthenticator;

    move-result-object v5

    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v6}, Lcom/squareup/okhttp/OkHttpClient;->getProxy()Ljava/net/Proxy;

    move-result-object v6

    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v7}, Lcom/squareup/okhttp/OkHttpClient;->getProtocols()Ljava/util/List;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/squareup/okhttp/Address;-><init>(Ljava/lang/String;ILjavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lcom/squareup/okhttp/OkAuthenticator;Ljava/net/Proxy;Ljava/util/List;)V

    .line 238
    .local v0, "address":Lcom/squareup/okhttp/Address;
    new-instance v5, Lcom/squareup/okhttp/internal/http/RouteSelector;

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->uri()Ljava/net/URI;

    move-result-object v7

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v2}, Lcom/squareup/okhttp/OkHttpClient;->getProxySelector()Ljava/net/ProxySelector;

    move-result-object v8

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v2}, Lcom/squareup/okhttp/OkHttpClient;->getConnectionPool()Lcom/squareup/okhttp/ConnectionPool;

    move-result-object v9

    sget-object v10, Lcom/squareup/okhttp/internal/Dns;->DEFAULT:Lcom/squareup/okhttp/internal/Dns;

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v2}, Lcom/squareup/okhttp/OkHttpClient;->getRoutesDatabase()Lcom/squareup/okhttp/RouteDatabase;

    move-result-object v11

    move-object v6, v0

    invoke-direct/range {v5 .. v11}, Lcom/squareup/okhttp/internal/http/RouteSelector;-><init>(Lcom/squareup/okhttp/Address;Ljava/net/URI;Ljava/net/ProxySelector;Lcom/squareup/okhttp/ConnectionPool;Lcom/squareup/okhttp/internal/Dns;Lcom/squareup/okhttp/RouteDatabase;)V

    iput-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    .line 242
    .end local v0    # "address":Lcom/squareup/okhttp/Address;
    .end local v1    # "uriHost":Ljava/lang/String;
    .end local v3    # "sslSocketFactory":Ljavax/net/ssl/SSLSocketFactory;
    .end local v4    # "hostnameVerifier":Ljavax/net/ssl/HostnameVerifier;
    :cond_4
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/squareup/okhttp/internal/http/RouteSelector;->next(Ljava/lang/String;)Lcom/squareup/okhttp/Connection;

    move-result-object v2

    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    .line 243
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v2, p0}, Lcom/squareup/okhttp/Connection;->setOwner(Ljava/lang/Object;)V

    .line 245
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v2}, Lcom/squareup/okhttp/Connection;->isConnected()Z

    move-result v2

    if-nez v2, :cond_7

    .line 246
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v5}, Lcom/squareup/okhttp/OkHttpClient;->getConnectTimeout()I

    move-result v5

    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v6}, Lcom/squareup/okhttp/OkHttpClient;->getReadTimeout()I

    move-result v6

    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getTunnelConfig()Lcom/squareup/okhttp/TunnelRequest;

    move-result-object v7

    invoke-virtual {v2, v5, v6, v7}, Lcom/squareup/okhttp/Connection;->connect(IILcom/squareup/okhttp/TunnelRequest;)V

    .line 247
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v2}, Lcom/squareup/okhttp/Connection;->isSpdy()Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v2}, Lcom/squareup/okhttp/OkHttpClient;->getConnectionPool()Lcom/squareup/okhttp/ConnectionPool;

    move-result-object v2

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v2, v5}, Lcom/squareup/okhttp/ConnectionPool;->share(Lcom/squareup/okhttp/Connection;)V

    .line 248
    :cond_5
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v2}, Lcom/squareup/okhttp/OkHttpClient;->getRoutesDatabase()Lcom/squareup/okhttp/RouteDatabase;

    move-result-object v2

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v5}, Lcom/squareup/okhttp/Connection;->getRoute()Lcom/squareup/okhttp/Route;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/squareup/okhttp/RouteDatabase;->connected(Lcom/squareup/okhttp/Route;)V

    .line 253
    :cond_6
    :goto_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v2}, Lcom/squareup/okhttp/Connection;->getRoute()Lcom/squareup/okhttp/Route;

    move-result-object v2

    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->route:Lcom/squareup/okhttp/Route;

    .line 254
    return-void

    .line 249
    :cond_7
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v2}, Lcom/squareup/okhttp/Connection;->isSpdy()Z

    move-result v2

    if-nez v2, :cond_6

    .line 250
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v5}, Lcom/squareup/okhttp/OkHttpClient;->getReadTimeout()I

    move-result v5

    invoke-virtual {v2, v5}, Lcom/squareup/okhttp/Connection;->updateReadTimeout(I)V

    goto :goto_0
.end method

.method public static getDefaultUserAgent()Ljava/lang/String;
    .locals 3

    .prologue
    .line 546
    const-string/jumbo v1, "http.agent"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 547
    .local v0, "agent":Ljava/lang/String;
    if-eqz v0, :cond_0

    .end local v0    # "agent":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "agent":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Java"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "java.version"

    invoke-static {v2}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getTunnelConfig()Lcom/squareup/okhttp/TunnelRequest;
    .locals 6

    .prologue
    .line 683
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->isHttps()Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    .line 689
    :goto_0
    return-object v2

    .line 685
    :cond_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->getUserAgent()Ljava/lang/String;

    move-result-object v1

    .line 686
    .local v1, "userAgent":Ljava/lang/String;
    if-nez v1, :cond_1

    invoke-static {}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getDefaultUserAgent()Ljava/lang/String;

    move-result-object v1

    .line 688
    :cond_1
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v0

    .line 689
    .local v0, "url":Ljava/net/URL;
    new-instance v2, Lcom/squareup/okhttp/TunnelRequest;

    invoke-virtual {v0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0}, Lcom/squareup/okhttp/internal/Util;->getEffectivePort(Ljava/net/URL;)I

    move-result v4

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Request;->getProxyAuthorization()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v1, v5}, Lcom/squareup/okhttp/TunnelRequest;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static hostHeader(Ljava/net/URL;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;

    .prologue
    .line 551
    invoke-static {p0}, Lcom/squareup/okhttp/internal/Util;->getEffectivePort(Ljava/net/URL;)I

    move-result v0

    invoke-virtual {p0}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/squareup/okhttp/internal/Util;->getDefaultPort(Ljava/lang/String;)I

    move-result v1

    if-eq v0, v1, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ljava/net/URL;->getPort()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private initContentStream(Lcom/squareup/okhttp/internal/okio/Source;)V
    .locals 3
    .param p1, "transferSource"    # Lcom/squareup/okhttp/internal/okio/Source;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 458
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseTransferSource:Lcom/squareup/okhttp/internal/okio/Source;

    .line 459
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transparentGzip:Z

    if-eqz v0, :cond_0

    const-string/jumbo v0, "gzip"

    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    const-string/jumbo v2, "Content-Encoding"

    invoke-virtual {v1, v2}, Lcom/squareup/okhttp/internal/http/Response;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 460
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->newBuilder()Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v0

    const-string/jumbo v1, "Content-Encoding"

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->removeHeader(Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v0

    const-string/jumbo v1, "Content-Length"

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->removeHeader(Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response$Builder;->build()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    .line 464
    new-instance v0, Lcom/squareup/okhttp/internal/okio/GzipSource;

    invoke-direct {v0, p1}, Lcom/squareup/okhttp/internal/okio/GzipSource;-><init>(Lcom/squareup/okhttp/internal/okio/Source;)V

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBody:Lcom/squareup/okhttp/internal/okio/Source;

    .line 468
    :goto_0
    return-void

    .line 466
    :cond_0
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBody:Lcom/squareup/okhttp/internal/okio/Source;

    goto :goto_0
.end method

.method private static isEndToEnd(Ljava/lang/String;)Z
    .locals 1
    .param p0, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 672
    const-string/jumbo v0, "Connection"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "Keep-Alive"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "Proxy-Authenticate"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "Proxy-Authorization"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "TE"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "Trailers"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "Transfer-Encoding"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "Upgrade"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isRecoverable(Ljava/io/IOException;)Z
    .locals 5
    .param p1, "e"    # Ljava/io/IOException;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 347
    instance-of v4, p1, Ljavax/net/ssl/SSLHandshakeException;

    if-eqz v4, :cond_0

    invoke-virtual {p1}, Ljava/io/IOException;->getCause()Ljava/lang/Throwable;

    move-result-object v4

    instance-of v4, v4, Ljava/security/cert/CertificateException;

    if-eqz v4, :cond_0

    move v1, v2

    .line 349
    .local v1, "sslFailure":Z
    :goto_0
    instance-of v0, p1, Ljava/net/ProtocolException;

    .line 350
    .local v0, "protocolFailure":Z
    if-nez v1, :cond_1

    if-nez v0, :cond_1

    :goto_1
    return v2

    .end local v0    # "protocolFailure":Z
    .end local v1    # "sslFailure":Z
    :cond_0
    move v1, v3

    .line 347
    goto :goto_0

    .restart local v0    # "protocolFailure":Z
    .restart local v1    # "sslFailure":Z
    :cond_1
    move v2, v3

    .line 350
    goto :goto_1
.end method

.method private maybeCache()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 362
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v1}, Lcom/squareup/okhttp/OkHttpClient;->getOkResponseCache()Lcom/squareup/okhttp/OkResponseCache;

    move-result-object v0

    .line 363
    .local v0, "responseCache":Lcom/squareup/okhttp/OkResponseCache;
    if-nez v0, :cond_0

    .line 373
    :goto_0
    return-void

    .line 366
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-static {v1, v2}, Lcom/squareup/okhttp/internal/http/CacheStrategy;->isCacheable(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Request;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 367
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-interface {v0, v1}, Lcom/squareup/okhttp/OkResponseCache;->maybeRemove(Lcom/squareup/okhttp/internal/http/Request;)Z

    goto :goto_0

    .line 372
    :cond_1
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->cacheableResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/squareup/okhttp/OkResponseCache;->put(Lcom/squareup/okhttp/internal/http/Response;)Ljava/net/CacheRequest;

    move-result-object v1

    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->cacheRequest:Ljava/net/CacheRequest;

    goto :goto_0
.end method

.method private prepareRawRequestHeaders()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 505
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v4}, Lcom/squareup/okhttp/internal/http/Request;->newBuilder()Lcom/squareup/okhttp/internal/http/Request$Builder;

    move-result-object v3

    .line 507
    .local v3, "result":Lcom/squareup/okhttp/internal/http/Request$Builder;
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v4}, Lcom/squareup/okhttp/internal/http/Request;->getUserAgent()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_0

    .line 508
    invoke-static {}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getDefaultUserAgent()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/squareup/okhttp/internal/http/Request$Builder;->setUserAgent(Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 511
    :cond_0
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    const-string/jumbo v5, "Host"

    invoke-virtual {v4, v5}, Lcom/squareup/okhttp/internal/http/Request;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_1

    .line 512
    const-string/jumbo v4, "Host"

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v5

    invoke-static {v5}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hostHeader(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 515
    :cond_1
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    if-eqz v4, :cond_2

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v4}, Lcom/squareup/okhttp/Connection;->getHttpMinorVersion()I

    move-result v4

    if-eqz v4, :cond_3

    :cond_2
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    const-string/jumbo v5, "Connection"

    invoke-virtual {v4, v5}, Lcom/squareup/okhttp/internal/http/Request;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_3

    .line 517
    const-string/jumbo v4, "Connection"

    const-string/jumbo v5, "Keep-Alive"

    invoke-virtual {v3, v4, v5}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 520
    :cond_3
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    const-string/jumbo v5, "Accept-Encoding"

    invoke-virtual {v4, v5}, Lcom/squareup/okhttp/internal/http/Request;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_4

    .line 521
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transparentGzip:Z

    .line 522
    const-string/jumbo v4, "Accept-Encoding"

    const-string/jumbo v5, "gzip"

    invoke-virtual {v3, v4, v5}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 525
    :cond_4
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hasRequestBody()Z

    move-result v4

    if-eqz v4, :cond_5

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    const-string/jumbo v5, "Content-Type"

    invoke-virtual {v4, v5}, Lcom/squareup/okhttp/internal/http/Request;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_5

    .line 526
    const-string/jumbo v4, "Content-Type"

    const-string/jumbo v5, "application/x-www-form-urlencoded"

    invoke-virtual {v3, v4, v5}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    .line 529
    :cond_5
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v4}, Lcom/squareup/okhttp/OkHttpClient;->getCookieHandler()Ljava/net/CookieHandler;

    move-result-object v0

    .line 530
    .local v0, "cookieHandler":Ljava/net/CookieHandler;
    if-eqz v0, :cond_6

    .line 534
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Request$Builder;->build()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v4

    invoke-virtual {v4}, Lcom/squareup/okhttp/internal/http/Request;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lcom/squareup/okhttp/internal/http/OkHeaders;->toMultimap(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v2

    .line 536
    .local v2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v4}, Lcom/squareup/okhttp/internal/http/Request;->uri()Ljava/net/URI;

    move-result-object v4

    invoke-virtual {v0, v4, v2}, Ljava/net/CookieHandler;->get(Ljava/net/URI;Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 539
    .local v1, "cookies":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-static {v3, v1}, Lcom/squareup/okhttp/internal/http/OkHeaders;->addCookies(Lcom/squareup/okhttp/internal/http/Request$Builder;Ljava/util/Map;)V

    .line 542
    .end local v1    # "cookies":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v2    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    :cond_6
    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Request$Builder;->build()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v4

    iput-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 543
    return-void
.end method


# virtual methods
.method public final close()Lcom/squareup/okhttp/Connection;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 404
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    if-eqz v2, :cond_1

    .line 406
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 412
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBody:Lcom/squareup/okhttp/internal/okio/Source;

    if-nez v2, :cond_2

    .line 413
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 414
    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    move-object v0, v1

    .line 438
    :goto_1
    return-object v0

    .line 407
    :cond_1
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    if-eqz v2, :cond_0

    .line 408
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    goto :goto_0

    .line 419
    :cond_2
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBody:Lcom/squareup/okhttp/internal/okio/Source;

    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 422
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBodyBytes:Ljava/io/InputStream;

    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 425
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    invoke-interface {v2}, Lcom/squareup/okhttp/internal/http/Transport;->canReuseConnection()Z

    move-result v2

    if-nez v2, :cond_3

    .line 426
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 427
    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    move-object v0, v1

    .line 428
    goto :goto_1

    .line 432
    :cond_3
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v2}, Lcom/squareup/okhttp/Connection;->clearOwner()Z

    move-result v2

    if-nez v2, :cond_4

    .line 433
    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    .line 436
    :cond_4
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    .line 437
    .local v0, "result":Lcom/squareup/okhttp/Connection;
    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    goto :goto_1
.end method

.method public final disconnect()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 394
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    if-eqz v0, :cond_0

    .line 395
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    invoke-interface {v0, p0}, Lcom/squareup/okhttp/internal/http/Transport;->disconnect(Lcom/squareup/okhttp/internal/http/HttpEngine;)V

    .line 397
    :cond_0
    return-void
.end method

.method public final getBufferedRequestBody()Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 3

    .prologue
    .line 276
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    .line 277
    .local v1, "result":Lcom/squareup/okhttp/internal/okio/BufferedSink;
    if-eqz v1, :cond_0

    .line 279
    .end local v1    # "result":Lcom/squareup/okhttp/internal/okio/BufferedSink;
    :goto_0
    return-object v1

    .line 278
    .restart local v1    # "result":Lcom/squareup/okhttp/internal/okio/BufferedSink;
    :cond_0
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getRequestBody()Lcom/squareup/okhttp/internal/okio/Sink;

    move-result-object v0

    .line 279
    .local v0, "requestBody":Lcom/squareup/okhttp/internal/okio/Sink;
    if-eqz v0, :cond_1

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Sink;)Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v2

    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    :goto_1
    move-object v1, v2

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public final getConnection()Lcom/squareup/okhttp/Connection;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    return-object v0
.end method

.method public final getRequest()Lcom/squareup/okhttp/internal/http/Request;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    return-object v0
.end method

.method public final getRequestBody()Lcom/squareup/okhttp/internal/okio/Sink;
    .locals 1

    .prologue
    .line 271
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 272
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    return-object v0
.end method

.method public final getResponse()Lcom/squareup/okhttp/internal/http/Response;
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 300
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    return-object v0
.end method

.method public final getResponseBody()Lcom/squareup/okhttp/internal/okio/Source;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 305
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBody:Lcom/squareup/okhttp/internal/okio/Source;

    return-object v0
.end method

.method public final getResponseBodyBytes()Ljava/io/InputStream;
    .locals 2

    .prologue
    .line 309
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBodyBytes:Ljava/io/InputStream;

    .line 310
    .local v0, "result":Ljava/io/InputStream;
    if-eqz v0, :cond_0

    .end local v0    # "result":Ljava/io/InputStream;
    :goto_0
    return-object v0

    .restart local v0    # "result":Ljava/io/InputStream;
    :cond_0
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->getResponseBody()Lcom/squareup/okhttp/internal/okio/Source;

    move-result-object v1

    invoke-static {v1}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Source;)Lcom/squareup/okhttp/internal/okio/BufferedSource;

    move-result-object v1

    invoke-interface {v1}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->inputStream()Ljava/io/InputStream;

    move-result-object v0

    .end local v0    # "result":Ljava/io/InputStream;
    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBodyBytes:Ljava/io/InputStream;

    goto :goto_0
.end method

.method public getRoute()Lcom/squareup/okhttp/Route;
    .locals 1

    .prologue
    .line 358
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->route:Lcom/squareup/okhttp/Route;

    return-object v0
.end method

.method hasRequestBody()Z
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/HttpMethod;->hasRequestBody(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public final hasResponse()Z
    .locals 1

    .prologue
    .line 285
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final hasResponseBody()Z
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 476
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "HEAD"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 495
    :cond_0
    :goto_0
    return v1

    .line 480
    :cond_1
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v0

    .line 481
    .local v0, "responseCode":I
    const/16 v3, 0x64

    if-lt v0, v3, :cond_2

    const/16 v3, 0xc8

    if-lt v0, v3, :cond_3

    :cond_2
    const/16 v3, 0xcc

    if-eq v0, v3, :cond_3

    const/16 v3, 0x130

    if-eq v0, v3, :cond_3

    move v1, v2

    .line 484
    goto :goto_0

    .line 490
    :cond_3
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-static {v3}, Lcom/squareup/okhttp/internal/http/OkHeaders;->contentLength(Lcom/squareup/okhttp/internal/http/Response;)J

    move-result-wide v3

    const-wide/16 v5, -0x1

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    const-string/jumbo v3, "chunked"

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    const-string/jumbo v5, "Transfer-Encoding"

    invoke-virtual {v4, v5}, Lcom/squareup/okhttp/internal/http/Response;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    :cond_4
    move v1, v2

    .line 492
    goto :goto_0
.end method

.method public final readResponse()V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v7, -0x1

    .line 561
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    if-eqz v3, :cond_1

    .line 635
    :cond_0
    :goto_0
    return-void

    .line 562
    :cond_1
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    if-nez v3, :cond_2

    new-instance v3, Ljava/lang/IllegalStateException;

    const-string/jumbo v4, "call sendRequest() first!"

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 563
    :cond_2
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    invoke-virtual {v3}, Lcom/squareup/okhttp/ResponseSource;->requiresConnection()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 566
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->buffer()Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size()J

    move-result-wide v3

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-lez v3, :cond_3

    .line 567
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->flush()V

    .line 570
    :cond_3
    iget-wide v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->sentRequestMillis:J

    cmp-long v3, v3, v7

    if-nez v3, :cond_5

    .line 571
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-static {v3}, Lcom/squareup/okhttp/internal/http/OkHeaders;->contentLength(Lcom/squareup/okhttp/internal/http/Request;)J

    move-result-wide v3

    cmp-long v3, v3, v7

    if-nez v3, :cond_4

    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    instance-of v3, v3, Lcom/squareup/okhttp/internal/http/RetryableSink;

    if-eqz v3, :cond_4

    .line 573
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    check-cast v3, Lcom/squareup/okhttp/internal/http/RetryableSink;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/RetryableSink;->contentLength()J

    move-result-wide v0

    .line 574
    .local v0, "contentLength":J
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Request;->newBuilder()Lcom/squareup/okhttp/internal/http/Request$Builder;

    move-result-object v3

    const-string/jumbo v4, "Content-Length"

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Request$Builder;->build()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v3

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 578
    .end local v0    # "contentLength":J
    :cond_4
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-interface {v3, v4}, Lcom/squareup/okhttp/internal/http/Transport;->writeRequestHeaders(Lcom/squareup/okhttp/internal/http/Request;)V

    .line 581
    :cond_5
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    if-eqz v3, :cond_6

    .line 582
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    if-eqz v3, :cond_7

    .line 584
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferedRequestBody:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->close()V

    .line 588
    :goto_1
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    instance-of v3, v3, Lcom/squareup/okhttp/internal/http/RetryableSink;

    if-eqz v3, :cond_6

    .line 589
    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    check-cast v3, Lcom/squareup/okhttp/internal/http/RetryableSink;

    invoke-interface {v4, v3}, Lcom/squareup/okhttp/internal/http/Transport;->writeRequestBody(Lcom/squareup/okhttp/internal/http/RetryableSink;)V

    .line 593
    :cond_6
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/http/Transport;->flushRequest()V

    .line 595
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/http/Transport;->readResponseHeaders()Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v3

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v3, v4}, Lcom/squareup/okhttp/internal/http/Response$Builder;->request(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v3

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v4}, Lcom/squareup/okhttp/Connection;->getHandshake()Lcom/squareup/okhttp/Handshake;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/squareup/okhttp/internal/http/Response$Builder;->handshake(Lcom/squareup/okhttp/Handshake;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v3

    sget-object v4, Lcom/squareup/okhttp/internal/http/OkHeaders;->SENT_MILLIS:Ljava/lang/String;

    iget-wide v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->sentRequestMillis:J

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/squareup/okhttp/internal/http/Response$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v3

    sget-object v4, Lcom/squareup/okhttp/internal/http/OkHeaders;->RECEIVED_MILLIS:Ljava/lang/String;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/squareup/okhttp/internal/http/Response$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v3

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    invoke-virtual {v3, v4}, Lcom/squareup/okhttp/internal/http/Response$Builder;->setResponseSource(Lcom/squareup/okhttp/ResponseSource;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response$Builder;->build()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v3

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    .line 602
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v4}, Lcom/squareup/okhttp/internal/http/Response;->httpMinorVersion()I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/squareup/okhttp/Connection;->setHttpMinorVersion(I)V

    .line 603
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/squareup/okhttp/internal/http/HttpEngine;->receiveHeaders(Lcom/squareup/okhttp/internal/http/Headers;)V

    .line 605
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    sget-object v4, Lcom/squareup/okhttp/ResponseSource;->CONDITIONAL_CACHE:Lcom/squareup/okhttp/ResponseSource;

    if-ne v3, v4, :cond_9

    .line 606
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v3, v4}, Lcom/squareup/okhttp/internal/http/Response;->validate(Lcom/squareup/okhttp/internal/http/Response;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 607
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/http/Transport;->emptyTransferStream()V

    .line 608
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->releaseConnection()V

    .line 609
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    invoke-static {v3, v4}, Lcom/squareup/okhttp/internal/http/HttpEngine;->combine(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Response;)Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v3

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    .line 613
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v3}, Lcom/squareup/okhttp/OkHttpClient;->getOkResponseCache()Lcom/squareup/okhttp/OkResponseCache;

    move-result-object v2

    .line 614
    .local v2, "responseCache":Lcom/squareup/okhttp/OkResponseCache;
    invoke-interface {v2}, Lcom/squareup/okhttp/OkResponseCache;->trackConditionalCacheHit()V

    .line 615
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->cacheableResponse()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/squareup/okhttp/OkResponseCache;->update(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Response;)V

    .line 617
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 618
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v3

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response$Body;->source()Lcom/squareup/okhttp/internal/okio/Source;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/squareup/okhttp/internal/http/HttpEngine;->initContentStream(Lcom/squareup/okhttp/internal/okio/Source;)V

    goto/16 :goto_0

    .line 586
    .end local v2    # "responseCache":Lcom/squareup/okhttp/OkResponseCache;
    :cond_7
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/okio/Sink;->close()V

    goto/16 :goto_1

    .line 622
    :cond_8
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v3

    invoke-static {v3}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 626
    :cond_9
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hasResponseBody()Z

    move-result v3

    if-nez v3, :cond_a

    .line 628
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->cacheRequest:Ljava/net/CacheRequest;

    invoke-interface {v3, v4}, Lcom/squareup/okhttp/internal/http/Transport;->getTransferStream(Ljava/net/CacheRequest;)Lcom/squareup/okhttp/internal/okio/Source;

    move-result-object v3

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseTransferSource:Lcom/squareup/okhttp/internal/okio/Source;

    .line 629
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseTransferSource:Lcom/squareup/okhttp/internal/okio/Source;

    iput-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseBody:Lcom/squareup/okhttp/internal/okio/Source;

    goto/16 :goto_0

    .line 633
    :cond_a
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->maybeCache()V

    .line 634
    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->cacheRequest:Ljava/net/CacheRequest;

    invoke-interface {v3, v4}, Lcom/squareup/okhttp/internal/http/Transport;->getTransferStream(Ljava/net/CacheRequest;)Lcom/squareup/okhttp/internal/okio/Source;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/squareup/okhttp/internal/http/HttpEngine;->initContentStream(Lcom/squareup/okhttp/internal/okio/Source;)V

    goto/16 :goto_0
.end method

.method public receiveHeaders(Lcom/squareup/okhttp/internal/http/Headers;)V
    .locals 3
    .param p1, "headers"    # Lcom/squareup/okhttp/internal/http/Headers;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 694
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v1}, Lcom/squareup/okhttp/OkHttpClient;->getCookieHandler()Ljava/net/CookieHandler;

    move-result-object v0

    .line 695
    .local v0, "cookieHandler":Ljava/net/CookieHandler;
    if-eqz v0, :cond_0

    .line 696
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/http/Request;->uri()Ljava/net/URI;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {p1, v2}, Lcom/squareup/okhttp/internal/http/OkHeaders;->toMultimap(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/net/CookieHandler;->put(Ljava/net/URI;Ljava/util/Map;)V

    .line 698
    :cond_0
    return-void
.end method

.method public recover(Ljava/io/IOException;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    .locals 8
    .param p1, "e"    # Ljava/io/IOException;

    .prologue
    .line 325
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    if-eqz v0, :cond_0

    .line 326
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v0, v1, p1}, Lcom/squareup/okhttp/internal/http/RouteSelector;->connectFailed(Lcom/squareup/okhttp/Connection;Ljava/io/IOException;)V

    .line 329
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    instance-of v0, v0, Lcom/squareup/okhttp/internal/http/RetryableSink;

    if-eqz v0, :cond_5

    :cond_1
    const/4 v7, 0x1

    .line 330
    .local v7, "canRetryRequestBody":Z
    :goto_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    if-eqz v0, :cond_4

    :cond_2
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/RouteSelector;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_3
    invoke-direct {p0, p1}, Lcom/squareup/okhttp/internal/http/HttpEngine;->isRecoverable(Ljava/io/IOException;)Z

    move-result v0

    if-eqz v0, :cond_4

    if-nez v7, :cond_6

    .line 334
    :cond_4
    const/4 v0, 0x0

    .line 340
    :goto_1
    return-object v0

    .line 329
    .end local v7    # "canRetryRequestBody":Z
    :cond_5
    const/4 v7, 0x0

    goto :goto_0

    .line 337
    .restart local v7    # "canRetryRequestBody":Z
    :cond_6
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->close()Lcom/squareup/okhttp/Connection;

    move-result-object v4

    .line 340
    .local v4, "connection":Lcom/squareup/okhttp/Connection;
    new-instance v0, Lcom/squareup/okhttp/internal/http/HttpEngine;

    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->originalRequest:Lcom/squareup/okhttp/internal/http/Request;

    iget-boolean v3, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->bufferRequestBody:Z

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->routeSelector:Lcom/squareup/okhttp/internal/http/RouteSelector;

    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    check-cast v6, Lcom/squareup/okhttp/internal/http/RetryableSink;

    invoke-direct/range {v0 .. v6}, Lcom/squareup/okhttp/internal/http/HttpEngine;-><init>(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/internal/http/Request;ZLcom/squareup/okhttp/Connection;Lcom/squareup/okhttp/internal/http/RouteSelector;Lcom/squareup/okhttp/internal/http/RetryableSink;)V

    goto :goto_1
.end method

.method public final releaseConnection()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 381
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    if-eqz v0, :cond_0

    .line 382
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    invoke-interface {v0}, Lcom/squareup/okhttp/internal/http/Transport;->releaseConnectionOnIdle()V

    .line 384
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    .line 385
    return-void
.end method

.method public final responseSource()Lcom/squareup/okhttp/ResponseSource;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    return-object v0
.end method

.method public final sendRequest()V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 157
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    if-eqz v6, :cond_1

    .line 213
    :cond_0
    :goto_0
    return-void

    .line 158
    :cond_1
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    if-eqz v6, :cond_2

    new-instance v5, Ljava/lang/IllegalStateException;

    invoke-direct {v5}, Ljava/lang/IllegalStateException;-><init>()V

    throw v5

    .line 160
    :cond_2
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->prepareRawRequestHeaders()V

    .line 161
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v6}, Lcom/squareup/okhttp/OkHttpClient;->getOkResponseCache()Lcom/squareup/okhttp/OkResponseCache;

    move-result-object v4

    .line 163
    .local v4, "responseCache":Lcom/squareup/okhttp/OkResponseCache;
    if-eqz v4, :cond_7

    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-interface {v4, v6}, Lcom/squareup/okhttp/OkResponseCache;->get(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v0

    .line 166
    .local v0, "cacheResponse":Lcom/squareup/okhttp/internal/http/Response;
    :goto_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 167
    .local v2, "now":J
    new-instance v6, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;

    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-direct {v6, v2, v3, v7, v0}, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;-><init>(JLcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;)V

    invoke-virtual {v6}, Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;->get()Lcom/squareup/okhttp/internal/http/CacheStrategy;

    move-result-object v1

    .line 168
    .local v1, "cacheStrategy":Lcom/squareup/okhttp/internal/http/CacheStrategy;
    iget-object v6, v1, Lcom/squareup/okhttp/internal/http/CacheStrategy;->source:Lcom/squareup/okhttp/ResponseSource;

    iput-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    .line 169
    iget-object v6, v1, Lcom/squareup/okhttp/internal/http/CacheStrategy;->request:Lcom/squareup/okhttp/internal/http/Request;

    iput-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 171
    if-eqz v4, :cond_3

    .line 172
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    invoke-interface {v4, v6}, Lcom/squareup/okhttp/OkResponseCache;->trackResponse(Lcom/squareup/okhttp/ResponseSource;)V

    .line 175
    :cond_3
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    sget-object v7, Lcom/squareup/okhttp/ResponseSource;->NETWORK:Lcom/squareup/okhttp/ResponseSource;

    if-eq v6, v7, :cond_4

    .line 176
    iget-object v6, v1, Lcom/squareup/okhttp/internal/http/CacheStrategy;->response:Lcom/squareup/okhttp/internal/http/Response;

    iput-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    .line 179
    :cond_4
    if-eqz v0, :cond_5

    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    invoke-virtual {v6}, Lcom/squareup/okhttp/ResponseSource;->usesCache()Z

    move-result v6

    if-nez v6, :cond_5

    .line 180
    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v6

    invoke-static {v6}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 183
    :cond_5
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->responseSource:Lcom/squareup/okhttp/ResponseSource;

    invoke-virtual {v6}, Lcom/squareup/okhttp/ResponseSource;->requiresConnection()Z

    move-result v6

    if-eqz v6, :cond_9

    .line 185
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    if-nez v5, :cond_6

    .line 186
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->connect()V

    .line 190
    :cond_6
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v5}, Lcom/squareup/okhttp/Connection;->getOwner()Ljava/lang/Object;

    move-result-object v5

    if-eq v5, p0, :cond_8

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v5}, Lcom/squareup/okhttp/Connection;->isSpdy()Z

    move-result v5

    if-nez v5, :cond_8

    new-instance v5, Ljava/lang/AssertionError;

    invoke-direct {v5}, Ljava/lang/AssertionError;-><init>()V

    throw v5

    .end local v0    # "cacheResponse":Lcom/squareup/okhttp/internal/http/Response;
    .end local v1    # "cacheStrategy":Lcom/squareup/okhttp/internal/http/CacheStrategy;
    .end local v2    # "now":J
    :cond_7
    move-object v0, v5

    .line 163
    goto :goto_1

    .line 192
    .restart local v0    # "cacheResponse":Lcom/squareup/okhttp/internal/http/Response;
    .restart local v1    # "cacheStrategy":Lcom/squareup/okhttp/internal/http/CacheStrategy;
    .restart local v2    # "now":J
    :cond_8
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v5, p0}, Lcom/squareup/okhttp/Connection;->newTransport(Lcom/squareup/okhttp/internal/http/HttpEngine;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/squareup/okhttp/internal/http/Transport;

    iput-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    .line 196
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/HttpEngine;->hasRequestBody()Z

    move-result v5

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    if-nez v5, :cond_0

    .line 197
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->transport:Lcom/squareup/okhttp/internal/http/Transport;

    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->request:Lcom/squareup/okhttp/internal/http/Request;

    invoke-interface {v5, v6}, Lcom/squareup/okhttp/internal/http/Transport;->createRequestBody(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/okio/Sink;

    move-result-object v5

    iput-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->requestBodyOut:Lcom/squareup/okhttp/internal/okio/Sink;

    goto/16 :goto_0

    .line 202
    :cond_9
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    if-eqz v6, :cond_a

    .line 203
    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->client:Lcom/squareup/okhttp/OkHttpClient;

    invoke-virtual {v6}, Lcom/squareup/okhttp/OkHttpClient;->getConnectionPool()Lcom/squareup/okhttp/ConnectionPool;

    move-result-object v6

    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    invoke-virtual {v6, v7}, Lcom/squareup/okhttp/ConnectionPool;->recycle(Lcom/squareup/okhttp/Connection;)V

    .line 204
    iput-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->connection:Lcom/squareup/okhttp/Connection;

    .line 208
    :cond_a
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    iput-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->response:Lcom/squareup/okhttp/internal/http/Response;

    .line 209
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 210
    iget-object v5, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->validatingResponse:Lcom/squareup/okhttp/internal/http/Response;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Response;->body()Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v5

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Response$Body;->source()Lcom/squareup/okhttp/internal/okio/Source;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/squareup/okhttp/internal/http/HttpEngine;->initContentStream(Lcom/squareup/okhttp/internal/okio/Source;)V

    goto/16 :goto_0
.end method

.method public writingRequestHeaders()V
    .locals 4

    .prologue
    .line 261
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->sentRequestMillis:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 262
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/squareup/okhttp/internal/http/HttpEngine;->sentRequestMillis:J

    .line 263
    return-void
.end method
