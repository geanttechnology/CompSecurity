.class public Lcom/amazon/client/metrics/transport/HttpClientFactory;
.super Ljava/lang/Object;
.source "HttpClientFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    return-void
.end method

.method public static getHttpClient(Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
    .locals 1
    .param p0, "userAgent"    # Ljava/lang/String;

    .prologue
    .line 60
    invoke-static {p0}, Landroid/net/http/AndroidHttpClient;->newInstance(Ljava/lang/String;)Landroid/net/http/AndroidHttpClient;

    move-result-object v0

    return-object v0
.end method

.method public static getSecureHttpClient(Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
    .locals 6
    .param p0, "userAgent"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/cert/CertificateException;,
            Ljava/io/IOException;,
            Ljava/security/KeyManagementException;,
            Ljava/security/UnrecoverableKeyException;
        }
    .end annotation

    .prologue
    .line 79
    invoke-static {}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->getSocketFactory()Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-result-object v2

    .line 80
    .local v2, "sslSocketFactory":Lorg/apache/http/conn/ssl/SSLSocketFactory;
    sget-object v3, Lorg/apache/http/conn/ssl/SSLSocketFactory;->STRICT_HOSTNAME_VERIFIER:Lorg/apache/http/conn/ssl/X509HostnameVerifier;

    invoke-virtual {v2, v3}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->setHostnameVerifier(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V

    .line 86
    new-instance v0, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v0}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 87
    .local v0, "params":Lorg/apache/http/params/HttpParams;
    sget-object v3, Lorg/apache/http/HttpVersion;->HTTP_1_1:Lorg/apache/http/HttpVersion;

    invoke-static {v0, v3}, Lorg/apache/http/params/HttpProtocolParams;->setVersion(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V

    .line 88
    const-string/jumbo v3, "UTF-8"

    invoke-static {v0, v3}, Lorg/apache/http/params/HttpProtocolParams;->setContentCharset(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 89
    invoke-static {v0, p0}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 94
    new-instance v1, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v1}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 96
    .local v1, "registry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v3, Lorg/apache/http/conn/scheme/Scheme;

    sget-object v4, Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;->HTTPS:Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;

    invoke-virtual {v4}, Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;->getScheme()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;->HTTPS:Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;

    invoke-virtual {v5}, Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;->getPort()I

    move-result v5

    invoke-direct {v3, v4, v2, v5}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v1, v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 98
    new-instance v3, Lorg/apache/http/conn/scheme/Scheme;

    sget-object v4, Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;->HTTP:Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;

    invoke-virtual {v4}, Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;->getScheme()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;->HTTP:Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;

    invoke-virtual {v5}, Lcom/amazon/client/metrics/transport/HttpClientFactory$Protocol;->getPort()I

    move-result v5

    invoke-direct {v3, v4, v2, v5}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v1, v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 101
    new-instance v3, Lorg/apache/http/impl/client/DefaultHttpClient;

    new-instance v4, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v4, v0, v1}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    invoke-direct {v3, v4, v0}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    return-object v3
.end method
