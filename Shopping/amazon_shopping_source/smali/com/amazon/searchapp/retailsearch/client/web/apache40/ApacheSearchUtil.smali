.class public Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil;
.super Ljava/lang/Object;
.source "ApacheSearchUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static configureClient(Lorg/apache/http/impl/client/AbstractHttpClient;)V
    .locals 3
    .param p0, "client"    # Lorg/apache/http/impl/client/AbstractHttpClient;

    .prologue
    .line 136
    const/4 v0, 0x1

    const v1, 0x493e0

    const/4 v2, 0x0

    invoke-static {p0, v0, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil;->configureClient(Lorg/apache/http/impl/client/AbstractHttpClient;ZILcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 137
    return-void
.end method

.method public static configureClient(Lorg/apache/http/impl/client/AbstractHttpClient;ZILcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 4
    .param p0, "client"    # Lorg/apache/http/impl/client/AbstractHttpClient;
    .param p1, "enableGzip"    # Z
    .param p2, "keepAliveTimeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/apache/http/impl/client/AbstractHttpClient;",
            "ZI",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 151
    .local p3, "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_0

    if-eqz p3, :cond_1

    invoke-virtual {p3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 152
    :cond_0
    if-eqz p3, :cond_4

    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v0, p3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 155
    .local v0, "requestHeaders":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$1;

    invoke-direct {v1, p1, v0}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$1;-><init>(ZLcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    invoke-virtual {p0, v1}, Lorg/apache/http/impl/client/AbstractHttpClient;->addRequestInterceptor(Lorg/apache/http/HttpRequestInterceptor;)V

    .line 179
    .end local v0    # "requestHeaders":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    if-eqz p1, :cond_2

    .line 180
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$2;

    invoke-direct {v1}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil$2;-><init>()V

    invoke-virtual {p0, v1}, Lorg/apache/http/impl/client/AbstractHttpClient;->addResponseInterceptor(Lorg/apache/http/HttpResponseInterceptor;)V

    .line 211
    :cond_2
    if-ltz p2, :cond_3

    .line 212
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/web/apache40/KeepAliveStrategy;

    int-to-long v2, p2

    invoke-direct {v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/KeepAliveStrategy;-><init>(J)V

    invoke-virtual {p0, v1}, Lorg/apache/http/impl/client/AbstractHttpClient;->setKeepAliveStrategy(Lorg/apache/http/conn/ConnectionKeepAliveStrategy;)V

    .line 214
    :cond_3
    return-void

    .line 152
    :cond_4
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static createConnectionManager(Lorg/apache/http/params/HttpParams;)Lorg/apache/http/conn/ClientConnectionManager;
    .locals 5
    .param p0, "params"    # Lorg/apache/http/params/HttpParams;

    .prologue
    .line 108
    new-instance v0, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v0}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 109
    .local v0, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v1, Lorg/apache/http/conn/scheme/Scheme;

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->HTTP:Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lorg/apache/http/conn/scheme/PlainSocketFactory;->getSocketFactory()Lorg/apache/http/conn/scheme/PlainSocketFactory;

    move-result-object v3

    const/16 v4, 0x50

    invoke-direct {v1, v2, v3, v4}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v0, v1}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 111
    new-instance v1, Lorg/apache/http/conn/scheme/Scheme;

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->HTTPS:Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->getSocketFactory()Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-result-object v3

    const/16 v4, 0x1bb

    invoke-direct {v1, v2, v3, v4}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v0, v1}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 113
    new-instance v1, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v1, p0, v0}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    return-object v1
.end method

.method public static createHttpClient(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/ClientConnectionManager;)Lorg/apache/http/client/HttpClient;
    .locals 1
    .param p0, "httpParams"    # Lorg/apache/http/params/HttpParams;
    .param p1, "connectionManager"    # Lorg/apache/http/conn/ClientConnectionManager;

    .prologue
    .line 125
    new-instance v0, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v0, p1, p0}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    .line 126
    .local v0, "client":Lorg/apache/http/impl/client/AbstractHttpClient;
    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheSearchUtil;->configureClient(Lorg/apache/http/impl/client/AbstractHttpClient;)V

    .line 127
    return-object v0
.end method

.method public static createHttpParams(I)Lorg/apache/http/params/HttpParams;
    .locals 4
    .param p0, "maxConnections"    # I

    .prologue
    const/16 v3, 0x7530

    .line 79
    new-instance v0, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v0}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 80
    .local v0, "params":Lorg/apache/http/params/BasicHttpParams;
    invoke-static {v0, p0}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxTotalConnections(Lorg/apache/http/params/HttpParams;I)V

    .line 81
    new-instance v1, Lorg/apache/http/conn/params/ConnPerRouteBean;

    invoke-direct {v1, p0}, Lorg/apache/http/conn/params/ConnPerRouteBean;-><init>(I)V

    invoke-static {v0, v1}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxConnectionsPerRoute(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V

    .line 89
    const-wide/16 v1, 0x7530

    invoke-static {v0, v1, v2}, Lorg/apache/http/conn/params/ConnManagerParams;->setTimeout(Lorg/apache/http/params/HttpParams;J)V

    .line 91
    const/16 v1, 0x2000

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setSocketBufferSize(Lorg/apache/http/params/HttpParams;I)V

    .line 92
    const/4 v1, 0x1

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setTcpNoDelay(Lorg/apache/http/params/HttpParams;Z)V

    .line 93
    invoke-static {v0, v3}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 94
    invoke-static {v0, v3}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 95
    sget-object v1, Lorg/apache/http/HttpVersion;->HTTP_1_1:Lorg/apache/http/HttpVersion;

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpProtocolParams;->setVersion(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V

    .line 96
    const-string/jumbo v1, "http.protocol.cookie-policy"

    const-string/jumbo v2, "compatibility"

    invoke-virtual {v0, v1, v2}, Lorg/apache/http/params/BasicHttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 98
    return-object v0
.end method
