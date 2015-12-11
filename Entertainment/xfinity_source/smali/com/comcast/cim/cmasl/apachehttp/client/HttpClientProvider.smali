.class public Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;
.super Ljava/lang/Object;
.source "HttpClientProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private disableSSLVerification:Z

.field private optionalProxy:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

.field private optionalRequestInterceptors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;",
            ">;"
        }
    .end annotation
.end field

.field private userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(ZLcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Ljava/util/List;)V
    .locals 1
    .param p1, "disableSSLVerification"    # Z
    .param p2, "userAgent"    # Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    .param p3, "optionalProxy"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpHost;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p4, "optionalRequestInterceptors":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->disableSSLVerification:Z

    .line 52
    iput-boolean p1, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->disableSSLVerification:Z

    .line 53
    iput-object p2, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    .line 54
    iput-object p3, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->optionalProxy:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 55
    iput-object p4, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->optionalRequestInterceptors:Ljava/util/List;

    .line 56
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;)Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    return-object v0
.end method


# virtual methods
.method public get()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .locals 13

    .prologue
    .line 64
    :try_start_0
    iget-boolean v9, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->disableSSLVerification:Z

    if-eqz v9, :cond_1

    .line 65
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;

    new-instance v9, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$1;

    invoke-direct {v9, p0}, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$1;-><init>(Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;)V

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/TrustStrategy;)V

    .line 75
    .local v8, "sslSocketFactory":Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;
    :goto_0
    new-instance v7, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    invoke-direct {v7}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;-><init>()V

    .line 76
    .local v7, "registry":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;
    new-instance v9, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    const-string v10, "http"

    const/16 v11, 0x50

    invoke-static {}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;->getSocketFactory()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;

    move-result-object v12

    invoke-direct {v9, v10, v11, v12}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;-><init>(Ljava/lang/String;ILcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;)V

    invoke-virtual {v7, v9}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;->register(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;)Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    .line 77
    new-instance v9, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    const-string v10, "https"

    const/16 v11, 0x1bb

    invoke-direct {v9, v10, v11, v8}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;-><init>(Ljava/lang/String;ILcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;)V

    invoke-virtual {v7, v9}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;->register(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;)Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    .line 79
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v2, v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)V

    .line 80
    .local v2, "cm":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;
    const/16 v9, 0x14

    invoke-virtual {v2, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;->setMaxTotal(I)V

    .line 81
    const/4 v9, 0x5

    invoke-virtual {v2, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;->setDefaultMaxPerRoute(I)V

    .line 84
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;

    invoke-direct {v6}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;-><init>()V

    .line 85
    .local v6, "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    const/16 v9, 0x1388

    invoke-static {v6, v9}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setConnectionTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 86
    const/16 v9, 0x2710

    invoke-static {v6, v9}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setSoTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 87
    const/16 v9, 0x2000

    invoke-static {v6, v9}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setSocketBufferSize(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 89
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;

    invoke-direct {v1, v2, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 90
    .local v1, "client":Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;
    iget-object v9, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    if-eqz v9, :cond_0

    .line 91
    sget-object v9, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->LOG:Lorg/slf4j/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Configuring HttpClient to use "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->userAgent:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    invoke-virtual {v11}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->getValue()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " as the User-Agent header"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v9, v10}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 92
    new-instance v9, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$2;

    invoke-direct {v9, p0}, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider$2;-><init>(Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;)V

    invoke-virtual {v1, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;->addRequestInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 104
    :cond_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;-><init>()V

    .line 105
    .local v0, "authSchemeRegistry":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    const-string v9, "Basic"

    new-instance v10, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/BasicSchemeFactory;

    invoke-direct {v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/BasicSchemeFactory;-><init>()V

    invoke-virtual {v0, v9, v10}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;)V

    .line 106
    const-string v9, "Digest"

    new-instance v10, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/DigestSchemeFactory;

    invoke-direct {v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/DigestSchemeFactory;-><init>()V

    invoke-virtual {v0, v9, v10}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;)V

    .line 107
    invoke-virtual {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;->setAuthSchemes(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;)V

    .line 109
    iget-object v9, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->optionalRequestInterceptors:Ljava/util/List;

    if-eqz v9, :cond_2

    .line 110
    iget-object v9, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->optionalRequestInterceptors:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .line 111
    .local v5, "interceptor":Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    invoke-virtual {v1, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;->addRequestInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 123
    .end local v0    # "authSchemeRegistry":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    .end local v1    # "client":Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;
    .end local v2    # "cm":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "interceptor":Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    .end local v6    # "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .end local v7    # "registry":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;
    .end local v8    # "sslSocketFactory":Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;
    :catch_0
    move-exception v3

    .line 124
    .local v3, "e":Ljava/lang/Exception;
    new-instance v9, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v9, v3}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v9

    .line 71
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_1
    invoke-static {}, Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;->getSocketFactory()Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;

    move-result-object v8

    .restart local v8    # "sslSocketFactory":Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;
    goto/16 :goto_0

    .line 116
    .restart local v0    # "authSchemeRegistry":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    .restart local v1    # "client":Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;
    .restart local v2    # "cm":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;
    .restart local v6    # "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .restart local v7    # "registry":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;
    :cond_2
    iget-object v9, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->optionalProxy:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    if-eqz v9, :cond_3

    .line 117
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v9

    const-string v10, "http.route.default-proxy"

    iget-object v11, p0, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->optionalProxy:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    invoke-interface {v9, v10, v11}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 122
    :goto_2
    return-object v1

    .line 119
    :cond_3
    new-instance v9, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ProxySelectorRoutePlanner;

    invoke-static {}, Ljava/net/ProxySelector;->getDefault()Ljava/net/ProxySelector;

    move-result-object v10

    invoke-direct {v9, v7, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ProxySelectorRoutePlanner;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;Ljava/net/ProxySelector;)V

    invoke-virtual {v1, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;->setRoutePlanner(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/apachehttp/client/HttpClientProvider;->get()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    return-object v0
.end method
