.class final Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;
.super Lcom/squareup/okhttp/internal/http/DelegatingHttpsURLConnection;
.source "ResponseCacheAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "CacheHttpsURLConnection"
.end annotation


# instance fields
.field private final delegate:Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;)V
    .locals 0
    .param p1, "delegate"    # Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    .prologue
    .line 502
    invoke-direct {p0, p1}, Lcom/squareup/okhttp/internal/http/DelegatingHttpsURLConnection;-><init>(Ljava/net/HttpURLConnection;)V

    .line 503
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;->delegate:Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    .line 504
    return-void
.end method


# virtual methods
.method public getContentLengthLong()J
    .locals 2

    .prologue
    .line 527
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;->delegate:Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->getContentLengthLong()J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderFieldLong(Ljava/lang/String;J)J
    .locals 2
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 535
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;->delegate:Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    invoke-virtual {v0, p1, p2, p3}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->getHeaderFieldLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;
    .locals 1

    .prologue
    .line 515
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestSslAccessException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$400()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .locals 1

    .prologue
    .line 523
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestSslAccessException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$400()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method protected handshake()Lcom/squareup/okhttp/Handshake;
    .locals 1

    .prologue
    .line 507
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;->delegate:Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    # getter for: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->response:Lcom/squareup/okhttp/internal/http/Response;
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->access$300(Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;)Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Response;->handshake()Lcom/squareup/okhttp/Handshake;

    move-result-object v0

    return-object v0
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 1
    .param p1, "contentLength"    # J

    .prologue
    .line 531
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpsURLConnection;->delegate:Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter$CacheHttpURLConnection;->setFixedLengthStreamingMode(J)V

    .line 532
    return-void
.end method

.method public setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V
    .locals 1
    .param p1, "hostnameVerifier"    # Ljavax/net/ssl/HostnameVerifier;

    .prologue
    .line 511
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V
    .locals 1
    .param p1, "socketFactory"    # Ljavax/net/ssl/SSLSocketFactory;

    .prologue
    .line 519
    # invokes: Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->throwRequestModificationException()Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/squareup/okhttp/internal/http/ResponseCacheAdapter;->access$000()Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method
