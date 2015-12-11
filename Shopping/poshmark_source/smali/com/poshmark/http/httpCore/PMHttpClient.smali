.class public Lcom/poshmark/http/httpCore/PMHttpClient;
.super Ljava/lang/Object;
.source "PMHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/http/httpCore/PMHttpClient$InflatingEntity;,
        Lcom/poshmark/http/httpCore/PMHttpClient$SingletonHolder;
    }
.end annotation


# static fields
.field public static final DEFAULT_MAX_CONNECTIONS:I = 0xa

.field public static final DEFAULT_MAX_CONNECTIONS_PER_ROUTE:I = 0xa

.field public static final DEFAULT_SOCKET_BUFFER_SIZE:I = 0x2000


# instance fields
.field final httpClient:Lorg/apache/http/client/HttpClient;


# direct methods
.method private constructor <init>()V
    .locals 8

    .prologue
    const/16 v7, 0x4e20

    const/16 v6, 0xa

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v2, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v2}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 48
    .local v2, "httpParams":Lorg/apache/http/params/BasicHttpParams;
    const-wide/16 v4, 0x4e20

    invoke-static {v2, v4, v5}, Lorg/apache/http/conn/params/ConnManagerParams;->setTimeout(Lorg/apache/http/params/HttpParams;J)V

    .line 49
    new-instance v4, Lorg/apache/http/conn/params/ConnPerRouteBean;

    invoke-direct {v4, v6}, Lorg/apache/http/conn/params/ConnPerRouteBean;-><init>(I)V

    invoke-static {v2, v4}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxConnectionsPerRoute(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V

    .line 50
    invoke-static {v2, v6}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxTotalConnections(Lorg/apache/http/params/HttpParams;I)V

    .line 52
    invoke-static {v2, v7}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 53
    invoke-static {v2, v7}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 54
    const/4 v4, 0x1

    invoke-static {v2, v4}, Lorg/apache/http/params/HttpConnectionParams;->setTcpNoDelay(Lorg/apache/http/params/HttpParams;Z)V

    .line 55
    const/16 v4, 0x2000

    invoke-static {v2, v4}, Lorg/apache/http/params/HttpConnectionParams;->setSocketBufferSize(Lorg/apache/http/params/HttpParams;I)V

    .line 57
    sget-object v4, Lorg/apache/http/HttpVersion;->HTTP_1_1:Lorg/apache/http/HttpVersion;

    invoke-static {v2, v4}, Lorg/apache/http/params/HttpProtocolParams;->setVersion(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V

    .line 58
    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/application/AppInfo;->userAgent:Ljava/lang/String;

    invoke-static {v2, v4}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 60
    new-instance v3, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 61
    .local v3, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v4, Lorg/apache/http/conn/scheme/Scheme;

    const-string v5, "http"

    invoke-static {}, Lorg/apache/http/conn/scheme/PlainSocketFactory;->getSocketFactory()Lorg/apache/http/conn/scheme/PlainSocketFactory;

    move-result-object v6

    const/16 v7, 0x50

    invoke-direct {v4, v5, v6, v7}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v4}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 62
    new-instance v4, Lorg/apache/http/conn/scheme/Scheme;

    const-string v5, "https"

    invoke-static {}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->getSocketFactory()Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-result-object v6

    const/16 v7, 0x1bb

    invoke-direct {v4, v5, v6, v7}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v4}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 63
    new-instance v0, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v0, v2, v3}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 65
    .local v0, "cm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1, v0, v2}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    .line 66
    .local v1, "defaultHttpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    iput-object v1, p0, Lcom/poshmark/http/httpCore/PMHttpClient;->httpClient:Lorg/apache/http/client/HttpClient;

    .line 68
    new-instance v4, Lcom/poshmark/http/httpCore/PMHttpClient$1;

    invoke-direct {v4, p0}, Lcom/poshmark/http/httpCore/PMHttpClient$1;-><init>(Lcom/poshmark/http/httpCore/PMHttpClient;)V

    invoke-virtual {v1, v4}, Lorg/apache/http/impl/client/DefaultHttpClient;->addRequestInterceptor(Lorg/apache/http/HttpRequestInterceptor;)V

    .line 77
    new-instance v4, Lcom/poshmark/http/httpCore/PMHttpClient$2;

    invoke-direct {v4, p0}, Lcom/poshmark/http/httpCore/PMHttpClient$2;-><init>(Lcom/poshmark/http/httpCore/PMHttpClient;)V

    invoke-virtual {v1, v4}, Lorg/apache/http/impl/client/DefaultHttpClient;->addResponseInterceptor(Lorg/apache/http/HttpResponseInterceptor;)V

    .line 99
    return-void
.end method

.method synthetic constructor <init>(Lcom/poshmark/http/httpCore/PMHttpClient$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/http/httpCore/PMHttpClient$1;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/poshmark/http/httpCore/PMHttpClient;-><init>()V

    return-void
.end method

.method static getInstance()Lcom/poshmark/http/httpCore/PMHttpClient;
    .locals 1

    .prologue
    .line 108
    sget-object v0, Lcom/poshmark/http/httpCore/PMHttpClient$SingletonHolder;->INSTANCE:Lcom/poshmark/http/httpCore/PMHttpClient;

    return-object v0
.end method
