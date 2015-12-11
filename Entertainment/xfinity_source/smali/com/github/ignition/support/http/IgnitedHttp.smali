.class public Lcom/github/ignition/support/http/IgnitedHttp;
.super Ljava/lang/Object;
.source "IgnitedHttp.java"


# static fields
.field static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private defaultHeaders:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private httpClient:Lorg/apache/http/impl/client/AbstractHttpClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    const-class v0, Lcom/github/ignition/support/http/IgnitedHttp;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/github/ignition/support/http/IgnitedHttp;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/github/ignition/support/http/IgnitedHttp;->defaultHeaders:Ljava/util/HashMap;

    .line 72
    invoke-virtual {p0}, Lcom/github/ignition/support/http/IgnitedHttp;->setupHttpClient()V

    .line 73
    return-void
.end method


# virtual methods
.method protected setupHttpClient()V
    .locals 8

    .prologue
    const/16 v7, 0x1bb

    const/4 v6, 0x4

    .line 81
    new-instance v1, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v1}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 83
    .local v1, "httpParams":Lorg/apache/http/params/BasicHttpParams;
    const-wide/16 v4, 0x7530

    invoke-static {v1, v4, v5}, Lorg/apache/http/conn/params/ConnManagerParams;->setTimeout(Lorg/apache/http/params/HttpParams;J)V

    .line 84
    new-instance v3, Lorg/apache/http/conn/params/ConnPerRouteBean;

    invoke-direct {v3, v6}, Lorg/apache/http/conn/params/ConnPerRouteBean;-><init>(I)V

    invoke-static {v1, v3}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxConnectionsPerRoute(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V

    .line 86
    invoke-static {v1, v6}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxTotalConnections(Lorg/apache/http/params/HttpParams;I)V

    .line 87
    const/16 v3, 0x7530

    invoke-static {v1, v3}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 88
    const/4 v3, 0x1

    invoke-static {v1, v3}, Lorg/apache/http/params/HttpConnectionParams;->setTcpNoDelay(Lorg/apache/http/params/HttpParams;Z)V

    .line 89
    sget-object v3, Lorg/apache/http/HttpVersion;->HTTP_1_1:Lorg/apache/http/HttpVersion;

    invoke-static {v1, v3}, Lorg/apache/http/params/HttpProtocolParams;->setVersion(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V

    .line 90
    const-string v3, "Android/Ignition"

    invoke-static {v1, v3}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 92
    new-instance v2, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v2}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 93
    .local v2, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v3, Lorg/apache/http/conn/scheme/Scheme;

    const-string v4, "http"

    invoke-static {}, Lorg/apache/http/conn/scheme/PlainSocketFactory;->getSocketFactory()Lorg/apache/http/conn/scheme/PlainSocketFactory;

    move-result-object v5

    const/16 v6, 0x50

    invoke-direct {v3, v4, v5, v6}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v2, v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 94
    sget v3, Lcom/github/ignition/support/IgnitedDiagnostics;->ANDROID_API_LEVEL:I

    const/4 v4, 0x7

    if-lt v3, v4, :cond_0

    .line 95
    new-instance v3, Lorg/apache/http/conn/scheme/Scheme;

    const-string v4, "https"

    invoke-static {}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->getSocketFactory()Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-result-object v5

    invoke-direct {v3, v4, v5, v7}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v2, v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 103
    :goto_0
    new-instance v0, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v0, v1, v2}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 104
    .local v0, "cm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    new-instance v3, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v3, v0, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    iput-object v3, p0, Lcom/github/ignition/support/http/IgnitedHttp;->httpClient:Lorg/apache/http/impl/client/AbstractHttpClient;

    .line 105
    return-void

    .line 100
    .end local v0    # "cm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    :cond_0
    new-instance v3, Lorg/apache/http/conn/scheme/Scheme;

    const-string v4, "https"

    new-instance v5, Lcom/github/ignition/support/http/ssl/EasySSLSocketFactory;

    invoke-direct {v5}, Lcom/github/ignition/support/http/ssl/EasySSLSocketFactory;-><init>()V

    invoke-direct {v3, v4, v5, v7}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v2, v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    goto :goto_0
.end method

.method public updateProxySettings(Landroid/content/Context;)V
    .locals 10
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v9, 0x0

    const/4 v8, -0x1

    .line 213
    if-nez p1, :cond_1

    .line 242
    :cond_0
    :goto_0
    return-void

    .line 216
    :cond_1
    iget-object v6, p0, Lcom/github/ignition/support/http/IgnitedHttp;->httpClient:Lorg/apache/http/impl/client/AbstractHttpClient;

    invoke-virtual {v6}, Lorg/apache/http/impl/client/AbstractHttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v1

    .line 217
    .local v1, "httpParams":Lorg/apache/http/params/HttpParams;
    const-string v6, "connectivity"

    invoke-virtual {p1, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 219
    .local v0, "connectivity":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v2

    .line 220
    .local v2, "nwInfo":Landroid/net/NetworkInfo;
    if-eqz v2, :cond_0

    .line 223
    sget-object v6, Lcom/github/ignition/support/http/IgnitedHttp;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2}, Landroid/net/NetworkInfo;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 224
    invoke-virtual {v2}, Landroid/net/NetworkInfo;->getType()I

    move-result v6

    if-nez v6, :cond_5

    .line 225
    invoke-static {p1}, Landroid/net/Proxy;->getHost(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 226
    .local v4, "proxyHost":Ljava/lang/String;
    if-nez v4, :cond_2

    .line 227
    invoke-static {}, Landroid/net/Proxy;->getDefaultHost()Ljava/lang/String;

    move-result-object v4

    .line 229
    :cond_2
    invoke-static {p1}, Landroid/net/Proxy;->getPort(Landroid/content/Context;)I

    move-result v5

    .line 230
    .local v5, "proxyPort":I
    if-ne v5, v8, :cond_3

    .line 231
    invoke-static {}, Landroid/net/Proxy;->getDefaultPort()I

    move-result v5

    .line 233
    :cond_3
    if-eqz v4, :cond_4

    if-le v5, v8, :cond_4

    .line 234
    new-instance v3, Lorg/apache/http/HttpHost;

    invoke-direct {v3, v4, v5}, Lorg/apache/http/HttpHost;-><init>(Ljava/lang/String;I)V

    .line 235
    .local v3, "proxy":Lorg/apache/http/HttpHost;
    const-string v6, "http.route.default-proxy"

    invoke-interface {v1, v6, v3}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    goto :goto_0

    .line 237
    .end local v3    # "proxy":Lorg/apache/http/HttpHost;
    :cond_4
    const-string v6, "http.route.default-proxy"

    invoke-interface {v1, v6, v9}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    goto :goto_0

    .line 240
    .end local v4    # "proxyHost":Ljava/lang/String;
    .end local v5    # "proxyPort":I
    :cond_5
    const-string v6, "http.route.default-proxy"

    invoke-interface {v1, v6, v9}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    goto :goto_0
.end method
