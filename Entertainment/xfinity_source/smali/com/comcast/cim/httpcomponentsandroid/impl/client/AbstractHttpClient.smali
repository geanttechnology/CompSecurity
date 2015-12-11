.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;
.super Ljava/lang/Object;
.source "AbstractHttpClient.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field private connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private cookieStore:Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private credsProvider:Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private defaultParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private keepAliveStrategy:Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private final log:Lorg/apache/commons/logging/Log;

.field private mutableProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private protocolProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private routePlanner:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private supportedAuthSchemes:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private supportedCookieSpecs:Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private userTokenHandler:Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 1
    .param p1, "conman"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 260
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 182
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->log:Lorg/apache/commons/logging/Log;

    .line 261
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->defaultParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 262
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    .line 263
    return-void
.end method

.method private static determineTarget(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .locals 5
    .param p0, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 760
    const/4 v1, 0x0

    .line 762
    .local v1, "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    invoke-interface {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    .line 763
    .local v0, "requestURI":Ljava/net/URI;
    invoke-virtual {v0}, Ljava/net/URI;->isAbsolute()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 764
    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URIUtils;->extractHost(Ljava/net/URI;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v1

    .line 765
    if-nez v1, :cond_0

    .line 766
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "URI does not specify a valid host name: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 770
    :cond_0
    return-object v1
.end method

.method private final declared-synchronized getProtocolProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;
    .locals 7

    .prologue
    .line 642
    monitor-enter p0

    :try_start_0
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->protocolProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;

    if-nez v6, :cond_2

    .line 644
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    move-result-object v1

    .line 646
    .local v1, "proc":Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->getRequestInterceptorCount()I

    move-result v2

    .line 647
    .local v2, "reqc":I
    new-array v3, v2, [Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .line 648
    .local v3, "reqinterceptors":[Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_0

    .line 649
    invoke-virtual {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->getRequestInterceptor(I)Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    move-result-object v6

    aput-object v6, v3, v0

    .line 648
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 651
    :cond_0
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->getResponseInterceptorCount()I

    move-result v4

    .line 652
    .local v4, "resc":I
    new-array v5, v4, [Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .line 653
    .local v5, "resinterceptors":[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;
    const/4 v0, 0x0

    :goto_1
    if-ge v0, v4, :cond_1

    .line 654
    invoke-virtual {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->getResponseInterceptor(I)Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    move-result-object v6

    aput-object v6, v5, v0

    .line 653
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 656
    :cond_1
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;

    invoke-direct {v6, v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;-><init>([Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V

    iput-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->protocolProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;

    .line 658
    .end local v0    # "i":I
    .end local v1    # "proc":Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    .end local v2    # "reqc":I
    .end local v3    # "reqinterceptors":[Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    .end local v4    # "resc":I
    .end local v5    # "resinterceptors":[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;
    :cond_2
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->protocolProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v6

    .line 642
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6
.end method


# virtual methods
.method public declared-synchronized addRequestInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V
    .locals 1
    .param p1, "itcp"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .prologue
    .line 707
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 708
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->protocolProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 709
    monitor-exit p0

    return-void

    .line 707
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected createAuthSchemeRegistry()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    .locals 3

    .prologue
    .line 326
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;-><init>()V

    .line 327
    .local v0, "registry":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    const-string v1, "Basic"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/BasicSchemeFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/BasicSchemeFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;)V

    .line 330
    const-string v1, "Digest"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/DigestSchemeFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/DigestSchemeFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;)V

    .line 333
    const-string v1, "NTLM"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMSchemeFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NTLMSchemeFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;)V

    .line 336
    const-string v1, "negotiate"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateSchemeFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeFactory;)V

    .line 339
    return-object v0
.end method

.method protected createClientConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .locals 10

    .prologue
    .line 294
    invoke-static {}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SchemeRegistryFactory;->createDefault()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    move-result-object v6

    .line 296
    .local v6, "registry":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;
    const/4 v2, 0x0

    .line 297
    .local v2, "connManager":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v5

    .line 299
    .local v5, "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    const/4 v4, 0x0

    .line 301
    .local v4, "factory":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;
    const-string v7, "http.connection-manager.factory-class-name"

    invoke-interface {v5, v7}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 303
    .local v0, "className":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 305
    :try_start_0
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 306
    .local v1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "factory":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;
    check-cast v4, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_2

    .line 315
    .end local v1    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v4    # "factory":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;
    :cond_0
    if-eqz v4, :cond_1

    .line 316
    invoke-interface {v4, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;->newInstance(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v2

    .line 321
    :goto_0
    return-object v2

    .line 307
    .end local v4    # "factory":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;
    :catch_0
    move-exception v3

    .line 308
    .local v3, "ex":Ljava/lang/ClassNotFoundException;
    new-instance v7, Ljava/lang/IllegalStateException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Invalid class name: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 309
    .end local v3    # "ex":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v3

    .line 310
    .local v3, "ex":Ljava/lang/IllegalAccessException;
    new-instance v7, Ljava/lang/IllegalAccessError;

    invoke-virtual {v3}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v7

    .line 311
    .end local v3    # "ex":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v3

    .line 312
    .local v3, "ex":Ljava/lang/InstantiationException;
    new-instance v7, Ljava/lang/InstantiationError;

    invoke-virtual {v3}, Ljava/lang/InstantiationException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/InstantiationError;-><init>(Ljava/lang/String;)V

    throw v7

    .line 318
    .end local v3    # "ex":Ljava/lang/InstantiationException;
    .restart local v4    # "factory":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;
    :cond_1
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;

    .end local v2    # "connManager":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    invoke-direct {v2, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)V

    .restart local v2    # "connManager":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    goto :goto_0
.end method

.method protected createClientRequestDirector(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/client/RequestDirector;
    .locals 14
    .param p1, "requestExec"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;
    .param p2, "conman"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .param p3, "reustrat"    # Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;
    .param p4, "kastrat"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;
    .param p5, "rouplan"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;
    .param p6, "httpProcessor"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;
    .param p7, "retryHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;
    .param p8, "redirectStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;
    .param p9, "targetAuthHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .param p10, "proxyAuthHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .param p11, "stateHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;
    .param p12, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 871
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->log:Lorg/apache/commons/logging/Log;

    move-object v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-object/from16 v6, p5

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    move-object/from16 v9, p8

    move-object/from16 v10, p9

    move-object/from16 v11, p10

    move-object/from16 v12, p11

    move-object/from16 v13, p12

    invoke-direct/range {v0 .. v13}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;-><init>(Lorg/apache/commons/logging/Log;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    return-object v0
.end method

.method protected createConnectionKeepAliveStrategy()Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;
    .locals 1

    .prologue
    .line 378
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultConnectionKeepAliveStrategy;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultConnectionKeepAliveStrategy;-><init>()V

    return-object v0
.end method

.method protected createConnectionReuseStrategy()Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;
    .locals 1

    .prologue
    .line 373
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultConnectionReuseStrategy;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultConnectionReuseStrategy;-><init>()V

    return-object v0
.end method

.method protected createCookieSpecRegistry()Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;
    .locals 3

    .prologue
    .line 344
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;-><init>()V

    .line 345
    .local v0, "registry":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;
    const-string v1, "best-match"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BestMatchSpecFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BestMatchSpecFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecFactory;)V

    .line 348
    const-string v1, "compatibility"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpecFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpecFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecFactory;)V

    .line 351
    const-string v1, "netscape"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpecFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpecFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecFactory;)V

    .line 354
    const-string v1, "rfc2109"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2109SpecFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2109SpecFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecFactory;)V

    .line 357
    const-string v1, "rfc2965"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965SpecFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965SpecFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecFactory;)V

    .line 360
    const-string v1, "ignoreCookies"

    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/IgnoreSpecFactory;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/IgnoreSpecFactory;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;->register(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecFactory;)V

    .line 363
    return-object v0
.end method

.method protected createCookieStore()Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;
    .locals 1

    .prologue
    .line 404
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCookieStore;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCookieStore;-><init>()V

    return-object v0
.end method

.method protected createCredentialsProvider()Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    .locals 1

    .prologue
    .line 409
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCredentialsProvider;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicCredentialsProvider;-><init>()V

    return-object v0
.end method

.method protected createHttpContext()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .locals 3

    .prologue
    .line 273
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;-><init>()V

    .line 274
    .local v0, "context":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    const-string v1, "http.scheme-registry"

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;->getSchemeRegistry()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 277
    const-string v1, "http.authscheme-registry"

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getAuthSchemes()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 280
    const-string v1, "http.cookiespec-registry"

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getCookieSpecs()Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 283
    const-string v1, "http.cookie-store"

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getCookieStore()Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 286
    const-string v1, "http.auth.credentials-provider"

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getCredentialsProvider()Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 289
    return-object v0
.end method

.method protected abstract createHttpParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
.end method

.method protected abstract createHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
.end method

.method protected createHttpRequestRetryHandler()Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;
    .locals 1

    .prologue
    .line 383
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpRequestRetryHandler;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpRequestRetryHandler;-><init>()V

    return-object v0
.end method

.method protected createHttpRoutePlanner()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;
    .locals 2

    .prologue
    .line 414
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultHttpRoutePlanner;

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;->getSchemeRegistry()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultHttpRoutePlanner;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)V

    return-object v0
.end method

.method protected createProxyAuthenticationHandler()Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .locals 1

    .prologue
    .line 399
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultProxyAuthenticationHandler;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultProxyAuthenticationHandler;-><init>()V

    return-object v0
.end method

.method protected createRedirectHandler()Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 389
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectHandler;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectHandler;-><init>()V

    return-object v0
.end method

.method protected createRequestExecutor()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;
    .locals 1

    .prologue
    .line 368
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;-><init>()V

    return-object v0
.end method

.method protected createTargetAuthenticationHandler()Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .locals 1

    .prologue
    .line 394
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultTargetAuthenticationHandler;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultTargetAuthenticationHandler;-><init>()V

    return-object v0
.end method

.method protected createUserTokenHandler()Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;
    .locals 1

    .prologue
    .line 419
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultUserTokenHandler;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultUserTokenHandler;-><init>()V

    return-object v0
.end method

.method protected determineParams(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 4
    .param p1, "req"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .prologue
    const/4 v3, 0x0

    .line 902
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v1

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v2

    invoke-direct {v0, v3, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;-><init>(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    return-object v0
.end method

.method public final execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 22
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 783
    if-nez p2, :cond_0

    .line 784
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Request must not be null."

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 790
    :cond_0
    const/16 v19, 0x0

    .line 791
    .local v19, "execContext":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    const/16 v18, 0x0

    .line 795
    .local v18, "director":Lcom/comcast/cim/httpcomponentsandroid/client/RequestDirector;
    monitor-enter p0

    .line 797
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createHttpContext()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    move-result-object v17

    .line 798
    .local v17, "defaultContext":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    if-nez p3, :cond_1

    .line 799
    move-object/from16 v19, v17

    .line 804
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getRequestExecutor()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    move-result-object v5

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v6

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getConnectionReuseStrategy()Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    move-result-object v7

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getConnectionKeepAliveStrategy()Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;

    move-result-object v8

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getRoutePlanner()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;

    move-result-object v9

    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getProtocolProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

    move-result-object v10

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getHttpRequestRetryHandler()Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

    move-result-object v11

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getRedirectStrategy()Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;

    move-result-object v12

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getTargetAuthenticationHandler()Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-result-object v13

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getProxyAuthenticationHandler()Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-result-object v14

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getUserTokenHandler()Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;

    move-result-object v15

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->determineParams(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v16

    move-object/from16 v4, p0

    invoke-virtual/range {v4 .. v16}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createClientRequestDirector(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/client/RequestDirector;

    move-result-object v18

    .line 817
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 820
    :try_start_1
    move-object/from16 v0, v18

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, v19

    invoke-interface {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/client/RequestDirector;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :try_end_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v4

    return-object v4

    .line 801
    :cond_1
    :try_start_2
    new-instance v20, Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;

    move-object/from16 v0, v20

    move-object/from16 v1, p3

    move-object/from16 v2, v17

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;-><init>(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .end local v19    # "execContext":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .local v20, "execContext":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    move-object/from16 v19, v20

    .end local v20    # "execContext":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .restart local v19    # "execContext":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    goto :goto_0

    .line 817
    .end local v17    # "defaultContext":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    :catchall_0
    move-exception v4

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v4

    .line 821
    .restart local v17    # "defaultContext":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    :catch_0
    move-exception v21

    .line 822
    .local v21, "httpException":Lcom/comcast/cim/httpcomponentsandroid/HttpException;
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;

    move-object/from16 v0, v21

    invoke-direct {v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;-><init>(Ljava/lang/Throwable;)V

    throw v4
.end method

.method public final execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 732
    const/4 v0, 0x0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public final execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 749
    if-nez p1, :cond_0

    .line 750
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 754
    :cond_0
    invoke-static {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->determineTarget(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v0

    invoke-virtual {p0, v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public final declared-synchronized getAuthSchemes()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    .locals 1

    .prologue
    .line 460
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->supportedAuthSchemes:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;

    if-nez v0, :cond_0

    .line 461
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createAuthSchemeRegistry()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->supportedAuthSchemes:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;

    .line 463
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->supportedAuthSchemes:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 460
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getConnectionKeepAliveStrategy()Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;
    .locals 1

    .prologue
    .line 499
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->keepAliveStrategy:Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;

    if-nez v0, :cond_0

    .line 500
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createConnectionKeepAliveStrategy()Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->keepAliveStrategy:Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;

    .line 502
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->keepAliveStrategy:Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 499
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 444
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    if-nez v0, :cond_0

    .line 445
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createClientConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    .line 447
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 444
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getConnectionReuseStrategy()Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;
    .locals 1

    .prologue
    .line 486
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    if-nez v0, :cond_0

    .line 487
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createConnectionReuseStrategy()Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    .line 489
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 486
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getCookieSpecs()Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;
    .locals 1

    .prologue
    .line 473
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->supportedCookieSpecs:Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;

    if-nez v0, :cond_0

    .line 474
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createCookieSpecRegistry()Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->supportedCookieSpecs:Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;

    .line 476
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->supportedCookieSpecs:Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 473
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getCookieStore()Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;
    .locals 1

    .prologue
    .line 582
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->cookieStore:Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;

    if-nez v0, :cond_0

    .line 583
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createCookieStore()Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->cookieStore:Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;

    .line 585
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->cookieStore:Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 582
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getCredentialsProvider()Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    .locals 1

    .prologue
    .line 595
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->credsProvider:Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    if-nez v0, :cond_0

    .line 596
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createCredentialsProvider()Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->credsProvider:Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    .line 598
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->credsProvider:Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 595
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected final declared-synchronized getHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    .locals 1

    .prologue
    .line 634
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->mutableProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    if-nez v0, :cond_0

    .line 635
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->mutableProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    .line 637
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->mutableProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 634
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getHttpRequestRetryHandler()Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;
    .locals 1

    .prologue
    .line 512
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

    if-nez v0, :cond_0

    .line 513
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createHttpRequestRetryHandler()Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

    .line 515
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 512
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 425
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->defaultParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    if-nez v0, :cond_0

    .line 426
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createHttpParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->defaultParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 428
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->defaultParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 425
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getProxyAuthenticationHandler()Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .locals 1

    .prologue
    .line 568
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    if-nez v0, :cond_0

    .line 569
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createProxyAuthenticationHandler()Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    .line 571
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 568
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getRedirectHandler()Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 526
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createRedirectHandler()Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getRedirectStrategy()Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;
    .locals 1

    .prologue
    .line 539
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;

    if-nez v0, :cond_0

    .line 540
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectStrategy;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectStrategy;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;

    .line 542
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 539
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getRequestExecutor()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;
    .locals 1

    .prologue
    .line 452
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    if-nez v0, :cond_0

    .line 453
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createRequestExecutor()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    .line 455
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 452
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getRequestInterceptorCount()I
    .locals 1

    .prologue
    .line 678
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->getRequestInterceptorCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getResponseInterceptorCount()I
    .locals 1

    .prologue
    .line 663
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->getHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->getResponseInterceptorCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getRoutePlanner()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;
    .locals 1

    .prologue
    .line 608
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->routePlanner:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;

    if-nez v0, :cond_0

    .line 609
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createHttpRoutePlanner()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->routePlanner:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;

    .line 611
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->routePlanner:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 608
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getTargetAuthenticationHandler()Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .locals 1

    .prologue
    .line 554
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    if-nez v0, :cond_0

    .line 555
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createTargetAuthenticationHandler()Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    .line 557
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 554
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getUserTokenHandler()Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;
    .locals 1

    .prologue
    .line 621
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->userTokenHandler:Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;

    if-nez v0, :cond_0

    .line 622
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->createUserTokenHandler()Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->userTokenHandler:Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;

    .line 624
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->userTokenHandler:Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 621
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setAuthSchemes(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;)V
    .locals 1
    .param p1, "authSchemeRegistry"    # Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;

    .prologue
    .line 468
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->supportedAuthSchemes:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 469
    monitor-exit p0

    return-void

    .line 468
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setCookieSpecs(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;)V
    .locals 1
    .param p1, "cookieSpecRegistry"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;

    .prologue
    .line 481
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->supportedCookieSpecs:Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 482
    monitor-exit p0

    return-void

    .line 481
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setCookieStore(Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;)V
    .locals 1
    .param p1, "cookieStore"    # Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;

    .prologue
    .line 590
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->cookieStore:Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 591
    monitor-exit p0

    return-void

    .line 590
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setCredentialsProvider(Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;)V
    .locals 1
    .param p1, "credsProvider"    # Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    .prologue
    .line 603
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->credsProvider:Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 604
    monitor-exit p0

    return-void

    .line 603
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setHttpRequestRetryHandler(Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;)V
    .locals 1
    .param p1, "retryHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

    .prologue
    .line 520
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 521
    monitor-exit p0

    return-void

    .line 520
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setKeepAliveStrategy(Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;)V
    .locals 1
    .param p1, "keepAliveStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;

    .prologue
    .line 507
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->keepAliveStrategy:Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 508
    monitor-exit p0

    return-void

    .line 507
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 1
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 439
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->defaultParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 440
    monitor-exit p0

    return-void

    .line 439
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setProxyAuthenticationHandler(Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;)V
    .locals 1
    .param p1, "proxyAuthHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    .prologue
    .line 577
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 578
    monitor-exit p0

    return-void

    .line 577
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setRedirectHandler(Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;)V
    .locals 1
    .param p1, "redirectHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 532
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectStrategyAdaptor;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRedirectStrategyAdaptor;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 533
    monitor-exit p0

    return-void

    .line 532
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setRedirectStrategy(Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;)V
    .locals 1
    .param p1, "redirectStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;

    .prologue
    .line 549
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 550
    monitor-exit p0

    return-void

    .line 549
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setReuseStrategy(Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;)V
    .locals 1
    .param p1, "reuseStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    .prologue
    .line 494
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 495
    monitor-exit p0

    return-void

    .line 494
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setRoutePlanner(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;)V
    .locals 1
    .param p1, "routePlanner"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;

    .prologue
    .line 616
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->routePlanner:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 617
    monitor-exit p0

    return-void

    .line 616
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setTargetAuthenticationHandler(Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;)V
    .locals 1
    .param p1, "targetAuthHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    .prologue
    .line 563
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 564
    monitor-exit p0

    return-void

    .line 563
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setUserTokenHandler(Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;)V
    .locals 1
    .param p1, "userTokenHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;

    .prologue
    .line 629
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;->userTokenHandler:Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 630
    monitor-exit p0

    return-void

    .line 629
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
