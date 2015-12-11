.class public Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;
.super Ljava/lang/Object;
.source "ResponseCacheAdapter.java"

# interfaces
.implements Lcom/squareup/okhttp/OkResponseCache;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;,
        Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;
    }
.end annotation


# instance fields
.field private final delegate:Ljava/net/ResponseCache;


# direct methods
.method public constructor <init>(Ljava/net/ResponseCache;)V
    .locals 0
    .param p1, "delegate"    # Ljava/net/ResponseCache;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->delegate:Ljava/net/ResponseCache;

    .line 50
    return-void
.end method

.method static synthetic access$000()Ljava/lang/RuntimeException;
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/RuntimeException;
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestHeaderAccessException()Ljava/lang/RuntimeException;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200()Ljava/lang/RuntimeException;
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwResponseBodyAccessException()Ljava/lang/RuntimeException;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400()Ljava/lang/RuntimeException;
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestSslAccessException()Ljava/lang/RuntimeException;

    move-result-object v0

    return-object v0
.end method

.method private static createJavaUrlConnection(Lcom/squareup/okhttp/internal/http/Response;)Ljava/net/HttpURLConnection;
    .locals 3
    .param p0, "okResponse"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 154
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v0

    .line 156
    .local v0, "request":Lcom/squareup/okhttp/internal/http/Request;
    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Request;->isHttps()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 157
    new-instance v1, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;

    new-instance v2, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    invoke-direct {v2, p0}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;-><init>(Lcom/squareup/okhttp/internal/http/Response;)V

    invoke-direct {v1, v2}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;-><init>(Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;)V

    .line 159
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    invoke-direct {v1, p0}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;-><init>(Lcom/squareup/okhttp/internal/http/Response;)V

    goto :goto_0
.end method

.method private static createOkBody(Lcom/squareup/okhttp/internal/http/Headers;Ljava/io/InputStream;)Lcom/squareup/okhttp/internal/http/Response$Body;
    .locals 1
    .param p0, "okHeaders"    # Lcom/squareup/okhttp/internal/http/Headers;
    .param p1, "body"    # Ljava/io/InputStream;

    .prologue
    .line 208
    new-instance v0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$1;

    invoke-direct {v0, p0, p1}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$1;-><init>(Lcom/squareup/okhttp/internal/http/Headers;Ljava/io/InputStream;)V

    return-object v0
.end method

.method private static extractJavaHeaders(Lcom/squareup/okhttp/internal/http/Request;)Ljava/util/Map;
    .locals 2
    .param p0, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/squareup/okhttp/internal/http/Request;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 201
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/squareup/okhttp/internal/http/OkHeaders;->toMultimap(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method private static extractOkHeaders(Ljava/net/CacheResponse;)Lcom/squareup/okhttp/internal/http/Headers;
    .locals 8
    .param p0, "javaResponse"    # Ljava/net/CacheResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 169
    invoke-virtual {p0}, Ljava/net/CacheResponse;->getHeaders()Ljava/util/Map;

    move-result-object v1

    .line 170
    .local v1, "cachedHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    new-instance v5, Lcom/squareup/okhttp/internal/http/Headers$Builder;

    invoke-direct {v5}, Lcom/squareup/okhttp/internal/http/Headers$Builder;-><init>()V

    .line 171
    .local v5, "okHeadersBuilder":Lcom/squareup/okhttp/internal/http/Headers$Builder;
    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 172
    .local v0, "cachedHeader":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 173
    .local v4, "name":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 177
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 178
    .local v6, "value":Ljava/lang/String;
    invoke-virtual {v5, v4, v6}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->add(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    goto :goto_0

    .line 181
    .end local v0    # "cachedHeader":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "name":Ljava/lang/String;
    .end local v6    # "value":Ljava/lang/String;
    :cond_1
    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->build()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v7

    return-object v7
.end method

.method private static extractStatusLine(Ljava/net/CacheResponse;)Ljava/lang/String;
    .locals 3
    .param p0, "javaResponse"    # Ljava/net/CacheResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 190
    invoke-virtual {p0}, Ljava/net/CacheResponse;->getHeaders()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 191
    .local v0, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_1

    .line 194
    :cond_0
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    goto :goto_0
.end method

.method private getJavaCachedResponse(Lcom/squareup/okhttp/internal/http/Request;)Ljava/net/CacheResponse;
    .locals 4
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 146
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->extractJavaHeaders(Lcom/squareup/okhttp/internal/http/Request;)Ljava/util/Map;

    move-result-object v0

    .line 147
    .local v0, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->delegate:Ljava/net/ResponseCache;

    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Request;->uri()Ljava/net/URI;

    move-result-object v2

    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Request;->method()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Ljava/net/ResponseCache;->get(Ljava/net/URI;Ljava/lang/String;Ljava/util/Map;)Ljava/net/CacheResponse;

    move-result-object v1

    return-object v1
.end method

.method private static throwRequestHeaderAccessException()Ljava/lang/RuntimeException;
    .locals 2

    .prologue
    .line 544
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "ResponseCache cannot access request headers"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static throwRequestModificationException()Ljava/lang/RuntimeException;
    .locals 2

    .prologue
    .line 540
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "ResponseCache cannot modify the request."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static throwRequestSslAccessException()Ljava/lang/RuntimeException;
    .locals 2

    .prologue
    .line 548
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "ResponseCache cannot access SSL internals"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static throwResponseBodyAccessException()Ljava/lang/RuntimeException;
    .locals 2

    .prologue
    .line 552
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "ResponseCache cannot access the response body."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public get(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Response;
    .locals 10
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->getJavaCachedResponse(Lcom/squareup/okhttp/internal/http/Request;)Ljava/net/CacheResponse;

    move-result-object v2

    .line 59
    .local v2, "javaResponse":Ljava/net/CacheResponse;
    if-nez v2, :cond_0

    .line 60
    const/4 v9, 0x0

    .line 102
    :goto_0
    return-object v9

    .line 63
    :cond_0
    new-instance v7, Lcom/squareup/okhttp/internal/http/Response$Builder;

    invoke-direct {v7}, Lcom/squareup/okhttp/internal/http/Response$Builder;-><init>()V

    .line 66
    .local v7, "okResponseBuilder":Lcom/squareup/okhttp/internal/http/Response$Builder;
    invoke-virtual {v7, p1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->request(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    .line 69
    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->extractStatusLine(Ljava/net/CacheResponse;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Lcom/squareup/okhttp/internal/http/Response$Builder;->statusLine(Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    .line 72
    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->extractOkHeaders(Ljava/net/CacheResponse;)Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v6

    .line 73
    .local v6, "okHeaders":Lcom/squareup/okhttp/internal/http/Headers;
    invoke-virtual {v7, v6}, Lcom/squareup/okhttp/internal/http/Response$Builder;->headers(Lcom/squareup/okhttp/internal/http/Headers;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    .line 76
    sget-object v9, Lcom/squareup/okhttp/ResponseSource;->CACHE:Lcom/squareup/okhttp/ResponseSource;

    invoke-virtual {v7, v9}, Lcom/squareup/okhttp/internal/http/Response$Builder;->setResponseSource(Lcom/squareup/okhttp/ResponseSource;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    .line 79
    invoke-virtual {v2}, Ljava/net/CacheResponse;->getBody()Ljava/io/InputStream;

    move-result-object v9

    invoke-static {v6, v9}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->createOkBody(Lcom/squareup/okhttp/internal/http/Headers;Ljava/io/InputStream;)Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v5

    .line 80
    .local v5, "okBody":Lcom/squareup/okhttp/internal/http/Response$Body;
    invoke-virtual {v7, v5}, Lcom/squareup/okhttp/internal/http/Response$Builder;->body(Lcom/squareup/okhttp/internal/http/Response$Body;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    .line 83
    instance-of v9, v2, Ljava/net/SecureCacheResponse;

    if-eqz v9, :cond_2

    move-object v3, v2

    .line 84
    check-cast v3, Ljava/net/SecureCacheResponse;

    .line 89
    .local v3, "javaSecureCacheResponse":Ljava/net/SecureCacheResponse;
    :try_start_0
    invoke-virtual {v3}, Ljava/net/SecureCacheResponse;->getServerCertificateChain()Ljava/util/List;
    :try_end_0
    .catch Ljavax/net/ssl/SSLPeerUnverifiedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 93
    .local v8, "peerCertificates":Ljava/util/List;, "Ljava/util/List<Ljava/security/cert/Certificate;>;"
    :goto_1
    invoke-virtual {v3}, Ljava/net/SecureCacheResponse;->getLocalCertificateChain()Ljava/util/List;

    move-result-object v4

    .line 94
    .local v4, "localCertificates":Ljava/util/List;, "Ljava/util/List<Ljava/security/cert/Certificate;>;"
    if-nez v4, :cond_1

    .line 95
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v4

    .line 97
    :cond_1
    invoke-virtual {v3}, Ljava/net/SecureCacheResponse;->getCipherSuite()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9, v8, v4}, Lcom/squareup/okhttp/Handshake;->get(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/squareup/okhttp/Handshake;

    move-result-object v1

    .line 99
    .local v1, "handshake":Lcom/squareup/okhttp/Handshake;
    invoke-virtual {v7, v1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->handshake(Lcom/squareup/okhttp/Handshake;)Lcom/squareup/okhttp/internal/http/Response$Builder;

    .line 102
    .end local v1    # "handshake":Lcom/squareup/okhttp/Handshake;
    .end local v3    # "javaSecureCacheResponse":Ljava/net/SecureCacheResponse;
    .end local v4    # "localCertificates":Ljava/util/List;, "Ljava/util/List<Ljava/security/cert/Certificate;>;"
    .end local v8    # "peerCertificates":Ljava/util/List;, "Ljava/util/List<Ljava/security/cert/Certificate;>;"
    :cond_2
    invoke-virtual {v7}, Lcom/squareup/okhttp/internal/http/Response$Builder;->build()Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v9

    goto :goto_0

    .line 90
    .restart local v3    # "javaSecureCacheResponse":Ljava/net/SecureCacheResponse;
    :catch_0
    move-exception v0

    .line 91
    .local v0, "e":Ljavax/net/ssl/SSLPeerUnverifiedException;
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v8

    .restart local v8    # "peerCertificates":Ljava/util/List;, "Ljava/util/List<Ljava/security/cert/Certificate;>;"
    goto :goto_1
.end method

.method public getDelegate()Ljava/net/ResponseCache;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->delegate:Ljava/net/ResponseCache;

    return-object v0
.end method

.method public maybeRemove(Lcom/squareup/okhttp/internal/http/Request;)Z
    .locals 1
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 119
    const/4 v0, 0x0

    return v0
.end method

.method public put(Lcom/squareup/okhttp/internal/http/Response;)Ljava/net/CacheRequest;
    .locals 3
    .param p1, "response"    # Lcom/squareup/okhttp/internal/http/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 107
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v2

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->uri()Ljava/net/URI;

    move-result-object v1

    .line 108
    .local v1, "uri":Ljava/net/URI;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->createJavaUrlConnection(Lcom/squareup/okhttp/internal/http/Response;)Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 109
    .local v0, "connection":Ljava/net/HttpURLConnection;
    iget-object v2, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->delegate:Ljava/net/ResponseCache;

    invoke-virtual {v2, v1, v0}, Ljava/net/ResponseCache;->put(Ljava/net/URI;Ljava/net/URLConnection;)Ljava/net/CacheRequest;

    move-result-object v2

    return-object v2
.end method

.method public trackConditionalCacheHit()V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public trackResponse(Lcom/squareup/okhttp/ResponseSource;)V
    .locals 0
    .param p1, "source"    # Lcom/squareup/okhttp/ResponseSource;

    .prologue
    .line 139
    return-void
.end method

.method public update(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Response;)V
    .locals 0
    .param p1, "cached"    # Lcom/squareup/okhttp/internal/http/Response;
    .param p2, "network"    # Lcom/squareup/okhttp/internal/http/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 129
    return-void
.end method
