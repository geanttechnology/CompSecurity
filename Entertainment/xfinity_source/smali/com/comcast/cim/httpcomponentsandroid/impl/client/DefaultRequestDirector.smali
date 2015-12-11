.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;
.super Ljava/lang/Object;
.source "DefaultRequestDirector.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/RequestDirector;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field protected final connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

.field private execCount:I

.field protected final httpProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

.field protected final keepAliveStrategy:Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;

.field private final log:Lorg/apache/commons/logging/Log;

.field protected managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

.field private maxRedirects:I

.field protected final params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

.field protected final proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

.field protected final proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

.field private redirectCount:I

.field protected final redirectHandler:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field protected final redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;

.field protected final requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

.field protected final retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

.field protected final reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

.field protected final routePlanner:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;

.field protected final targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

.field protected final targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

.field protected final userTokenHandler:Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;

.field private virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;


# direct methods
.method public constructor <init>(Lorg/apache/commons/logging/Log;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 4
    .param p1, "log"    # Lorg/apache/commons/logging/Log;
    .param p2, "requestExec"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;
    .param p3, "conman"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .param p4, "reustrat"    # Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;
    .param p5, "kastrat"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;
    .param p6, "rouplan"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;
    .param p7, "httpProcessor"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;
    .param p8, "retryHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;
    .param p9, "redirectStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;
    .param p10, "targetAuthHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .param p11, "proxyAuthHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .param p12, "userTokenHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;
    .param p13, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 232
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 162
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->redirectHandler:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;

    .line 234
    if-nez p1, :cond_0

    .line 235
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Log may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 238
    :cond_0
    if-nez p2, :cond_1

    .line 239
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Request executor may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 242
    :cond_1
    if-nez p3, :cond_2

    .line 243
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Client connection manager may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 246
    :cond_2
    if-nez p4, :cond_3

    .line 247
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Connection reuse strategy may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 250
    :cond_3
    if-nez p5, :cond_4

    .line 251
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Connection keep alive strategy may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 254
    :cond_4
    if-nez p6, :cond_5

    .line 255
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Route planner may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 258
    :cond_5
    if-nez p7, :cond_6

    .line 259
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP protocol processor may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 262
    :cond_6
    if-nez p8, :cond_7

    .line 263
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP request retry handler may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 266
    :cond_7
    if-nez p9, :cond_8

    .line 267
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Redirect strategy may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 270
    :cond_8
    if-nez p10, :cond_9

    .line 271
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Target authentication handler may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 274
    :cond_9
    if-nez p11, :cond_a

    .line 275
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Proxy authentication handler may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 278
    :cond_a
    if-nez p12, :cond_b

    .line 279
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "User token handler may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 282
    :cond_b
    if-nez p13, :cond_c

    .line 283
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP parameters may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 286
    :cond_c
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    .line 287
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    .line 288
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    .line 289
    iput-object p4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    .line 290
    iput-object p5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->keepAliveStrategy:Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;

    .line 291
    iput-object p6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->routePlanner:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;

    .line 292
    iput-object p7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->httpProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

    .line 293
    iput-object p8, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

    .line 294
    iput-object p9, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;

    .line 295
    iput-object p10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    .line 296
    iput-object p11, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    .line 297
    move-object/from16 v0, p12

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->userTokenHandler:Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;

    .line 298
    move-object/from16 v0, p13

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 300
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    .line 302
    const/4 v1, 0x0

    iput v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->execCount:I

    .line 303
    const/4 v1, 0x0

    iput v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->redirectCount:I

    .line 304
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v2, "http.protocol.max-redirects"

    const/16 v3, 0x64

    invoke-interface {v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getIntParameter(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->maxRedirects:I

    .line 305
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;-><init>()V

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    .line 306
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;-><init>()V

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    .line 307
    return-void
.end method

.method private abortConnection()V
    .locals 5

    .prologue
    .line 1154
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    .line 1155
    .local v2, "mcc":Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
    if-eqz v2, :cond_1

    .line 1158
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    .line 1160
    :try_start_0
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->abortConnection()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1168
    :cond_0
    :goto_0
    :try_start_1
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->releaseConnection()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 1173
    :cond_1
    :goto_1
    return-void

    .line 1161
    :catch_0
    move-exception v0

    .line 1162
    .local v0, "ex":Ljava/io/IOException;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1163
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v0}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 1169
    .end local v0    # "ex":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 1170
    .local v1, "ignored":Ljava/io/IOException;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "Error releasing connection"

    invoke-interface {v3, v4, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method private invalidateAuthIfSuccessful(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;)V
    .locals 2
    .param p1, "authState"    # Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    .prologue
    .line 1249
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getAuthScheme()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    move-result-object v0

    .line 1250
    .local v0, "authscheme":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->isConnectionBased()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->isComplete()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getCredentials()Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1254
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->invalidate()V

    .line 1256
    :cond_0
    return-void
.end method

.method private processChallenges(Ljava/util/Map;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 6
    .param p2, "authState"    # Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;
    .param p3, "authHandler"    # Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
    .param p4, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p5, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;",
            "Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;",
            "Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;,
            Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
        }
    .end annotation

    .prologue
    .line 1184
    .local p1, "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getAuthScheme()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    move-result-object v0

    .line 1185
    .local v0, "authScheme":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    if-nez v0, :cond_0

    .line 1187
    invoke-interface {p3, p1, p4, p5}, Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;->selectScheme(Ljava/util/Map;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    move-result-object v0

    .line 1188
    invoke-virtual {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->setAuthScheme(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;)V

    .line 1190
    :cond_0
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->getSchemeName()Ljava/lang/String;

    move-result-object v2

    .line 1192
    .local v2, "id":Ljava/lang/String;
    sget-object v3, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v2, v3}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 1193
    .local v1, "challenge":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-nez v1, :cond_1

    .line 1194
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " authorization challenge expected, but not found"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1197
    :cond_1
    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->processChallenge(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 1198
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "Authorization challenge processed"

    invoke-interface {v3, v4}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 1199
    return-void
.end method

.method private tryConnect(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 7
    .param p1, "req"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 565
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v2

    .line 566
    .local v2, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRequest()Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    move-result-object v3

    .line 567
    .local v3, "wrapper":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    const-string v4, "http.request"

    invoke-interface {p2, v4, v3}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 569
    const/4 v0, 0x0

    .line 572
    .local v0, "connectCount":I
    :goto_0
    add-int/lit8 v0, v0, 0x1

    .line 574
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->isOpen()Z

    move-result v4

    if-nez v4, :cond_0

    .line 575
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v4, v2, p2, v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->open(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 579
    :goto_1
    invoke-virtual {p0, v2, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->establishRoute(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 601
    return-void

    .line 577
    :cond_0
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v5}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->getSoTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)I

    move-result v5

    invoke-interface {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->setSocketTimeout(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 581
    :catch_0
    move-exception v1

    .line 583
    .local v1, "ex":Ljava/io/IOException;
    :try_start_1
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 586
    :goto_2
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

    invoke-interface {v4, v1, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;->retryRequest(Ljava/io/IOException;ILcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 587
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v4}, Lorg/apache/commons/logging/Log;->isInfoEnabled()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 588
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "I/O exception ("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ") caught when connecting to the target host: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lorg/apache/commons/logging/Log;->info(Ljava/lang/Object;)V

    .line 592
    :cond_1
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v4}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 593
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 595
    :cond_2
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "Retrying connect"

    invoke-interface {v4, v5}, Lorg/apache/commons/logging/Log;->info(Ljava/lang/Object;)V

    goto :goto_0

    .line 597
    :cond_3
    throw v1

    .line 584
    :catch_1
    move-exception v4

    goto :goto_2
.end method

.method private tryExecute(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 8
    .param p1, "req"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 608
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRequest()Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    move-result-object v4

    .line 609
    .local v4, "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v3

    .line 610
    .local v3, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    const/4 v1, 0x0

    .line 612
    .local v1, "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    const/4 v2, 0x0

    .line 615
    .local v2, "retryReason":Ljava/lang/Exception;
    :goto_0
    iget v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->execCount:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->execCount:I

    .line 617
    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->incrementExecCount()V

    .line 618
    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->isRepeatable()Z

    move-result v5

    if-nez v5, :cond_1

    .line 619
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Cannot retry non-repeatable request"

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 620
    if-eqz v2, :cond_0

    .line 621
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/client/NonRepeatableRequestException;

    const-string v6, "Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed."

    invoke-direct {v5, v6, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/NonRepeatableRequestException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 625
    :cond_0
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/client/NonRepeatableRequestException;

    const-string v6, "Cannot retry request with a non-repeatable request entity."

    invoke-direct {v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/client/NonRepeatableRequestException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 631
    :cond_1
    :try_start_0
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->isOpen()Z

    move-result v5

    if-nez v5, :cond_2

    .line 634
    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->isTunnelled()Z

    move-result v5

    if-nez v5, :cond_4

    .line 635
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Reopening the direct connection."

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 636
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v5, v3, p2, v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->open(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 644
    :cond_2
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 645
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Attempt "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->execCount:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " to execute request"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 647
    :cond_3
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-virtual {v5, v4, v6, p2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpClientConnection;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    .line 672
    :goto_1
    return-object v1

    .line 639
    :cond_4
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Proxied connection. Need to start over."

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 650
    :catch_0
    move-exception v0

    .line 651
    .local v0, "ex":Ljava/io/IOException;
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Closing the connection."

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 653
    :try_start_1
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 656
    :goto_2
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->retryHandler:Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;

    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getExecCount()I

    move-result v6

    invoke-interface {v5, v0, v6, p2}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpRequestRetryHandler;->retryRequest(Ljava/io/IOException;ILcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 657
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isInfoEnabled()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 658
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "I/O exception ("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ") caught when processing request: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->info(Ljava/lang/Object;)V

    .line 662
    :cond_5
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v5

    if-eqz v5, :cond_6

    .line 663
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v0}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 665
    :cond_6
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Retrying request"

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->info(Ljava/lang/Object;)V

    .line 666
    move-object v2, v0

    goto/16 :goto_0

    .line 668
    :cond_7
    throw v0

    .line 654
    :catch_1
    move-exception v5

    goto :goto_2
.end method

.method private updateAuthState(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;)V
    .locals 9
    .param p1, "authState"    # Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;
    .param p2, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p3, "credsProvider"    # Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    .prologue
    .line 1207
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->isValid()Z

    move-result v6

    if-nez v6, :cond_0

    .line 1246
    :goto_0
    return-void

    .line 1211
    :cond_0
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getHostName()Ljava/lang/String;

    move-result-object v3

    .line 1212
    .local v3, "hostname":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getPort()I

    move-result v4

    .line 1213
    .local v4, "port":I
    if-gez v4, :cond_1

    .line 1214
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;->getSchemeRegistry()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    move-result-object v6

    invoke-virtual {v6, p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;->getScheme(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    move-result-object v5

    .line 1215
    .local v5, "scheme":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    invoke-virtual {v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->getDefaultPort()I

    move-result v4

    .line 1218
    .end local v5    # "scheme":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    :cond_1
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getAuthScheme()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    move-result-object v0

    .line 1219
    .local v0, "authScheme":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->getRealm()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->getSchemeName()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v1, v3, v4, v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    .line 1225
    .local v1, "authScope":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v6}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 1226
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Authentication scope: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 1228
    :cond_2
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getCredentials()Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    move-result-object v2

    .line 1229
    .local v2, "creds":Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;
    if-nez v2, :cond_5

    .line 1230
    invoke-interface {p3, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;->getCredentials(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;)Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    move-result-object v2

    .line 1231
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v6}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 1232
    if-eqz v2, :cond_4

    .line 1233
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v7, "Found credentials"

    invoke-interface {v6, v7}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 1244
    :cond_3
    :goto_1
    invoke-virtual {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->setAuthScope(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;)V

    .line 1245
    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->setCredentials(Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;)V

    goto :goto_0

    .line 1235
    :cond_4
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v7, "Credentials not found"

    invoke-interface {v6, v7}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_1

    .line 1239
    :cond_5
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->isComplete()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 1240
    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v7, "Authentication failed"

    invoke-interface {v6, v7}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 1241
    const/4 v2, 0x0

    goto :goto_1
.end method

.method private wrapRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation

    .prologue
    .line 312
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v0, :cond_0

    .line 313
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V

    .line 316
    :goto_0
    return-object v0

    .restart local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    goto :goto_0
.end method


# virtual methods
.method protected createConnectRequest(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 10
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 977
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v6

    .line 979
    .local v6, "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    invoke-virtual {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getHostName()Ljava/lang/String;

    move-result-object v2

    .line 980
    .local v2, "host":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getPort()I

    move-result v3

    .line 981
    .local v3, "port":I
    if-gez v3, :cond_0

    .line 982
    iget-object v8, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;->getSchemeRegistry()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    move-result-object v8

    invoke-virtual {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getSchemeName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;->getScheme(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    move-result-object v5

    .line 984
    .local v5, "scheme":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    invoke-virtual {v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->getDefaultPort()I

    move-result v3

    .line 987
    .end local v5    # "scheme":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v8

    add-int/lit8 v8, v8, 0x6

    invoke-direct {v1, v8}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 988
    .local v1, "buffer":Ljava/lang/StringBuilder;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 989
    const/16 v8, 0x3a

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 990
    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 992
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 993
    .local v0, "authority":Ljava/lang/String;
    iget-object v8, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v8}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->getVersion(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v7

    .line 994
    .local v7, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;

    const-string v8, "CONNECT"

    invoke-direct {v4, v8, v0, v7}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    .line 997
    .local v4, "req":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    return-object v4
.end method

.method protected createTunnelToProxy(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;ILcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z
    .locals 2
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "hop"    # I
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 957
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/HttpException;

    const-string v1, "Proxy chains are not supported."

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected createTunnelToTarget(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z
    .locals 16
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 814
    invoke-virtual/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getProxyHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v13

    .line 815
    .local v13, "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    invoke-virtual/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v15

    .line 816
    .local v15, "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    const/4 v6, 0x0

    .line 818
    .local v6, "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    const/4 v10, 0x0

    .line 819
    .local v10, "done":Z
    :cond_0
    :goto_0
    if-nez v10, :cond_3

    .line 821
    const/4 v10, 0x1

    .line 823
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->isOpen()Z

    move-result v2

    if-nez v2, :cond_1

    .line 824
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-interface {v2, v0, v1, v4}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->open(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 827
    :cond_1
    invoke-virtual/range {p0 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->createConnectRequest(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v8

    .line 828
    .local v8, "connect":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v8, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 831
    const-string v2, "http.target_host"

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v15}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 833
    const-string v2, "http.proxy_host"

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v13}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 835
    const-string v2, "http.connection"

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 837
    const-string v2, "http.auth.target-scope"

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 839
    const-string v2, "http.auth.proxy-scope"

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 841
    const-string v2, "http.request"

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v8}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 844
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->httpProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

    move-object/from16 v0, p2

    invoke-virtual {v2, v8, v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;->preProcess(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 846
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v0, p2

    invoke-virtual {v2, v8, v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpClientConnection;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v6

    .line 848
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v6, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 849
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->httpProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

    move-object/from16 v0, p2

    invoke-virtual {v2, v6, v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;->postProcess(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 851
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v14

    .line 852
    .local v14, "status":I
    const/16 v2, 0xc8

    if-ge v14, v2, :cond_2

    .line 853
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/HttpException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unexpected response to CONNECT request: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 857
    :cond_2
    const-string v2, "http.auth.credentials-provider"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    .line 860
    .local v9, "credsProvider":Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    if-eqz v9, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v2}, Lcom/comcast/cim/httpcomponentsandroid/client/params/HttpClientParams;->isAuthenticating(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 861
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v0, p2

    invoke-interface {v2, v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;->isAuthenticationRequested(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 863
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "Proxy requested authentication"

    invoke-interface {v2, v4}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 864
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v0, p2

    invoke-interface {v2, v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;->getChallenges(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/Map;

    move-result-object v3

    .line 867
    .local v3, "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    :try_start_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v2, p0

    move-object/from16 v7, p2

    invoke-direct/range {v2 .. v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->processChallenges(Ljava/util/Map;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 876
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v13, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->updateAuthState(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;)V

    .line 878
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getCredentials()Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 879
    const/4 v10, 0x0

    .line 882
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    move-object/from16 v0, p2

    invoke-interface {v2, v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;->keepAlive(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 883
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "Connection kept alive"

    invoke-interface {v2, v4}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 885
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v11

    .line 886
    .local v11, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    invoke-static {v11}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    goto/16 :goto_0

    .line 870
    .end local v11    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    :catch_0
    move-exception v12

    .line 871
    .local v12, "ex":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isWarnEnabled()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 872
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Authentication error: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v12}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v4}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;)V

    .line 900
    .end local v3    # "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    .end local v8    # "connect":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .end local v9    # "credsProvider":Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    .end local v12    # "ex":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
    .end local v14    # "status":I
    :cond_3
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v14

    .line 902
    .restart local v14    # "status":I
    const/16 v2, 0x12b

    if-le v14, v2, :cond_7

    .line 905
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v11

    .line 906
    .restart local v11    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-eqz v11, :cond_4

    .line 907
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/entity/BufferedHttpEntity;

    invoke-direct {v2, v11}, Lcom/comcast/cim/httpcomponentsandroid/entity/BufferedHttpEntity;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    invoke-interface {v6, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 910
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->close()V

    .line 911
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "CONNECT refused by proxy: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;-><init>(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    throw v2

    .line 888
    .end local v11    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .restart local v3    # "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    .restart local v8    # "connect":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .restart local v9    # "credsProvider":Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->close()V

    goto/16 :goto_0

    .line 895
    .end local v3    # "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->setAuthScope(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;)V

    goto/16 :goto_0

    .line 915
    .end local v8    # "connect":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .end local v9    # "credsProvider":Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->markReusable()V

    .line 921
    const/4 v2, 0x0

    return v2
.end method

.method protected determineRoute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .locals 2
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    .line 714
    if-nez p1, :cond_0

    .line 715
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v0

    const-string v1, "http.default-host"

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    .end local p1    # "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 718
    .restart local p1    # "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    :cond_0
    if-nez p1, :cond_1

    .line 719
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Target host must not be null, or set in parameters."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 723
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->routePlanner:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;

    invoke-interface {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;->determineRoute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v0

    return-object v0
.end method

.method protected establishRoute(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 8
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 739
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/BasicRouteDirector;

    invoke-direct {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/BasicRouteDirector;-><init>()V

    .line 742
    .local v2, "rowdy":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRouteDirector;
    :cond_0
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v0

    .line 743
    .local v0, "fact":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    invoke-interface {v2, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRouteDirector;->nextStep(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteInfo;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteInfo;)I

    move-result v4

    .line 745
    .local v4, "step":I
    packed-switch v4, :pswitch_data_0

    .line 782
    new-instance v5, Ljava/lang/IllegalStateException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unknown step indicator "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " from RouteDirector."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 749
    :pswitch_0
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v5, p1, p2, v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->open(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 786
    :goto_0
    :pswitch_1
    if-gtz v4, :cond_0

    .line 788
    return-void

    .line 753
    :pswitch_2
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->createTunnelToTarget(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v3

    .line 754
    .local v3, "secure":Z
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Tunnel to target created."

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 755
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v5, v3, v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->tunnelTarget(ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    goto :goto_0

    .line 763
    .end local v3    # "secure":Z
    :pswitch_3
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getHopCount()I

    move-result v5

    add-int/lit8 v1, v5, -0x1

    .line 764
    .local v1, "hop":I
    invoke-virtual {p0, p1, v1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->createTunnelToProxy(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;ILcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v3

    .line 765
    .restart local v3    # "secure":Z
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v6, "Tunnel to proxy created."

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 766
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-virtual {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getHopTarget(I)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v6

    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v5, v6, v3, v7}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->tunnelProxy(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    goto :goto_0

    .line 772
    .end local v1    # "hop":I
    .end local v3    # "secure":Z
    :pswitch_4
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v5, p2, v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->layerProtocol(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    goto :goto_0

    .line 776
    :pswitch_5
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/HttpException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unable to establish route: planned = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "; current = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 745
    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_5
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 32
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 355
    move-object/from16 v15, p2

    .line 356
    .local v15, "orig":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->wrapRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    move-result-object v17

    .line 357
    .local v17, "origWrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-object/from16 v29, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 358
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v17

    move-object/from16 v3, p3

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->determineRoute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v16

    .line 360
    .local v16, "origRoute":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    invoke-interface {v15}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v29

    const-string v30, "http.virtual-host"

    invoke-interface/range {v29 .. v30}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 364
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-object/from16 v29, v0

    if-eqz v29, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getPort()I

    move-result v29

    const/16 v30, -0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_0

    .line 366
    invoke-virtual/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getPort()I

    move-result v18

    .line 367
    .local v18, "port":I
    const/16 v29, -0x1

    move/from16 v0, v18

    move/from16 v1, v29

    if-eq v0, v1, :cond_0

    .line 368
    new-instance v29, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-object/from16 v30, v0

    invoke-virtual/range {v30 .. v30}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getHostName()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getSchemeName()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    move/from16 v2, v18

    move-object/from16 v3, v31

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 372
    .end local v18    # "port":I
    :cond_0
    new-instance v22, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;

    move-object/from16 v0, v22

    move-object/from16 v1, v17

    move-object/from16 v2, v16

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V

    .line 374
    .local v22, "roureq":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    const/16 v21, 0x0

    .line 375
    .local v21, "reuse":Z
    const/4 v5, 0x0

    .line 377
    .local v5, "done":Z
    const/16 v20, 0x0

    .line 378
    .local v20, "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :cond_1
    :goto_0
    if-nez v5, :cond_9

    .line 384
    :try_start_0
    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRequest()Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    move-result-object v28

    .line 385
    .local v28, "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v23

    .line 386
    .local v23, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    const/16 v20, 0x0

    .line 389
    const-string v29, "http.user-token"

    move-object/from16 v0, p3

    move-object/from16 v1, v29

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v25

    .line 392
    .local v25, "userToken":Ljava/lang/Object;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    if-nez v29, :cond_3

    .line 393
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->connManager:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v23

    move-object/from16 v2, v25

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;->requestConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;

    move-result-object v4

    .line 395
    .local v4, "connRequest":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
    instance-of v0, v15, Lcom/comcast/cim/httpcomponentsandroid/client/methods/AbortableHttpRequest;

    move/from16 v29, v0

    if-eqz v29, :cond_2

    .line 396
    move-object v0, v15

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/client/methods/AbortableHttpRequest;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    invoke-interface {v0, v4}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/AbortableHttpRequest;->setConnectionRequest(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;)V

    .line 399
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParams;->getTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)J
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_5

    move-result-wide v26

    .line 401
    .local v26, "timeout":J
    :try_start_1
    sget-object v29, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    move-wide/from16 v0, v26

    move-object/from16 v2, v29

    invoke-interface {v4, v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;->getConnection(JLjava/util/concurrent/TimeUnit;)Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_5

    .line 408
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->isStaleCheckingEnabled(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z

    move-result v29

    if-eqz v29, :cond_3

    .line 410
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->isOpen()Z

    move-result v29

    if-eqz v29, :cond_3

    .line 411
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v29, v0

    const-string v30, "Stale connection check"

    invoke-interface/range {v29 .. v30}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 412
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->isStale()Z

    move-result v29

    if-eqz v29, :cond_3

    .line 413
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v29, v0

    const-string v30, "Stale connection detected"

    invoke-interface/range {v29 .. v30}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 414
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->close()V

    .line 420
    .end local v4    # "connRequest":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
    .end local v26    # "timeout":J
    :cond_3
    instance-of v0, v15, Lcom/comcast/cim/httpcomponentsandroid/client/methods/AbortableHttpRequest;

    move/from16 v29, v0

    if-eqz v29, :cond_4

    .line 421
    move-object v0, v15

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/client/methods/AbortableHttpRequest;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v30, v0

    invoke-interface/range {v29 .. v30}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/AbortableHttpRequest;->setReleaseTrigger(Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionReleaseTrigger;)V
    :try_end_2
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_5

    .line 425
    :cond_4
    :try_start_3
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    move-object/from16 v2, p3

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->tryConnect(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    :try_end_3
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_5

    .line 435
    :try_start_4
    invoke-virtual/range {v28 .. v28}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->resetHeaders()V

    .line 438
    move-object/from16 v0, p0

    move-object/from16 v1, v28

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->rewriteRequestURI(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V

    .line 441
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-object/from16 p1, v0

    .line 443
    if-nez p1, :cond_5

    .line 444
    invoke-virtual/range {v23 .. v23}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object p1

    .line 447
    :cond_5
    invoke-virtual/range {v23 .. v23}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getProxyHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v19

    .line 450
    .local v19, "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    const-string v29, "http.target_host"

    move-object/from16 v0, p3

    move-object/from16 v1, v29

    move-object/from16 v2, p1

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 452
    const-string v29, "http.proxy_host"

    move-object/from16 v0, p3

    move-object/from16 v1, v29

    move-object/from16 v2, v19

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 454
    const-string v29, "http.connection"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v30, v0

    move-object/from16 v0, p3

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 456
    const-string v29, "http.auth.target-scope"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v30, v0

    move-object/from16 v0, p3

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 458
    const-string v29, "http.auth.proxy-scope"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v30, v0

    move-object/from16 v0, p3

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 462
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->httpProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

    move-object/from16 v30, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v28

    move-object/from16 v2, v30

    move-object/from16 v3, p3

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;->preProcess(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 464
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    move-object/from16 v2, p3

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->tryExecute(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v20

    .line 465
    if-eqz v20, :cond_1

    .line 471
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-object/from16 v29, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v29

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 472
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->requestExec:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->httpProcessor:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

    move-object/from16 v30, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v20

    move-object/from16 v2, v30

    move-object/from16 v3, p3

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestExecutor;->postProcess(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 476
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->reuseStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v20

    move-object/from16 v2, p3

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;->keepAlive(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v21

    .line 477
    if-eqz v21, :cond_7

    .line 479
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->keepAliveStrategy:Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v20

    move-object/from16 v2, p3

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;->getKeepAliveDuration(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)J

    move-result-wide v6

    .line 480
    .local v6, "duration":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v29

    if-eqz v29, :cond_6

    .line 482
    const-wide/16 v30, 0x0

    cmp-long v29, v6, v30

    if-lez v29, :cond_c

    .line 483
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "for "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v0, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, " "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    sget-object v30, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    .line 487
    .local v24, "s":Ljava/lang/String;
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v29, v0

    new-instance v30, Ljava/lang/StringBuilder;

    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuilder;-><init>()V

    const-string v31, "Connection can be kept alive "

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    invoke-interface/range {v29 .. v30}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 489
    .end local v24    # "s":Ljava/lang/String;
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    sget-object v30, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-interface {v0, v6, v7, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->setIdleDuration(JLjava/util/concurrent/TimeUnit;)V

    .line 492
    .end local v6    # "duration":J
    :cond_7
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    move-object/from16 v2, v20

    move-object/from16 v3, p3

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->handleResponse(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;

    move-result-object v11

    .line 493
    .local v11, "followup":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    if-nez v11, :cond_d

    .line 494
    const/4 v5, 0x1

    .line 515
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    if-eqz v29, :cond_1

    if-nez v25, :cond_1

    .line 516
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->userTokenHandler:Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, p3

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/UserTokenHandler;->getUserToken(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/lang/Object;

    move-result-object v25

    .line 517
    const-string v29, "http.user-token"

    move-object/from16 v0, p3

    move-object/from16 v1, v29

    move-object/from16 v2, v25

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 518
    if-eqz v25, :cond_1

    .line 519
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v25

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->setState(Ljava/lang/Object;)V
    :try_end_4
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_5

    goto/16 :goto_0

    .line 542
    .end local v11    # "followup":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    .end local v19    # "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .end local v23    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .end local v25    # "userToken":Ljava/lang/Object;
    .end local v28    # "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :catch_0
    move-exception v10

    .line 543
    .local v10, "ex":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException;
    new-instance v13, Ljava/io/InterruptedIOException;

    const-string v29, "Connection has been shut down"

    move-object/from16 v0, v29

    invoke-direct {v13, v0}, Ljava/io/InterruptedIOException;-><init>(Ljava/lang/String;)V

    .line 545
    .local v13, "ioex":Ljava/io/InterruptedIOException;
    invoke-virtual {v13, v10}, Ljava/io/InterruptedIOException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 546
    throw v13

    .line 402
    .end local v10    # "ex":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException;
    .end local v13    # "ioex":Ljava/io/InterruptedIOException;
    .restart local v4    # "connRequest":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
    .restart local v23    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .restart local v25    # "userToken":Ljava/lang/Object;
    .restart local v26    # "timeout":J
    .restart local v28    # "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :catch_1
    move-exception v12

    .line 403
    .local v12, "interrupted":Ljava/lang/InterruptedException;
    :try_start_5
    new-instance v14, Ljava/io/InterruptedIOException;

    invoke-direct {v14}, Ljava/io/InterruptedIOException;-><init>()V

    .line 404
    .local v14, "iox":Ljava/io/InterruptedIOException;
    invoke-virtual {v14, v12}, Ljava/io/InterruptedIOException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 405
    throw v14
    :try_end_5
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_5 .. :try_end_5} :catch_5

    .line 547
    .end local v4    # "connRequest":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
    .end local v12    # "interrupted":Ljava/lang/InterruptedException;
    .end local v14    # "iox":Ljava/io/InterruptedIOException;
    .end local v23    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .end local v25    # "userToken":Ljava/lang/Object;
    .end local v26    # "timeout":J
    .end local v28    # "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :catch_2
    move-exception v10

    .line 548
    .local v10, "ex":Lcom/comcast/cim/httpcomponentsandroid/HttpException;
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->abortConnection()V

    .line 549
    throw v10

    .line 426
    .end local v10    # "ex":Lcom/comcast/cim/httpcomponentsandroid/HttpException;
    .restart local v23    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .restart local v25    # "userToken":Ljava/lang/Object;
    .restart local v28    # "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :catch_3
    move-exception v10

    .line 427
    .local v10, "ex":Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;
    :try_start_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v29

    if-eqz v29, :cond_8

    .line 428
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    move-object/from16 v29, v0

    invoke-virtual {v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;->getMessage()Ljava/lang/String;

    move-result-object v30

    invoke-interface/range {v29 .. v30}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 430
    :cond_8
    invoke-virtual {v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;->getResponse()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v20

    .line 527
    .end local v10    # "ex":Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;
    .end local v23    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .end local v25    # "userToken":Ljava/lang/Object;
    .end local v28    # "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :cond_9
    if-eqz v20, :cond_a

    invoke-interface/range {v20 .. v20}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v29

    if-eqz v29, :cond_a

    invoke-interface/range {v20 .. v20}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v29

    invoke-interface/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isStreaming()Z

    move-result v29

    if-nez v29, :cond_10

    .line 530
    :cond_a
    if-eqz v21, :cond_b

    .line 531
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->markReusable()V

    .line 532
    :cond_b
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->releaseConnection()V

    .line 540
    :goto_3
    return-object v20

    .line 485
    .restart local v6    # "duration":J
    .restart local v19    # "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .restart local v23    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .restart local v25    # "userToken":Ljava/lang/Object;
    .restart local v28    # "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :cond_c
    const-string v24, "indefinitely"

    .restart local v24    # "s":Ljava/lang/String;
    goto/16 :goto_1

    .line 496
    .end local v6    # "duration":J
    .end local v24    # "s":Ljava/lang/String;
    .restart local v11    # "followup":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    :cond_d
    if-eqz v21, :cond_f

    .line 498
    invoke-interface/range {v20 .. v20}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v8

    .line 499
    .local v8, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    invoke-static {v8}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 502
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->markReusable()V

    .line 509
    .end local v8    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    :goto_4
    invoke-virtual {v11}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v29

    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-nez v29, :cond_e

    .line 510
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->releaseConnection()V

    .line 512
    :cond_e
    move-object/from16 v22, v11

    goto/16 :goto_2

    .line 504
    :cond_f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->close()V

    .line 505
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->invalidateAuthIfSuccessful(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;)V

    .line 506
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->invalidateAuthIfSuccessful(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;)V
    :try_end_6
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_6 .. :try_end_6} :catch_5

    goto :goto_4

    .line 550
    .end local v11    # "followup":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    .end local v19    # "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .end local v23    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .end local v25    # "userToken":Ljava/lang/Object;
    .end local v28    # "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    :catch_4
    move-exception v10

    .line 551
    .local v10, "ex":Ljava/io/IOException;
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->abortConnection()V

    .line 552
    throw v10

    .line 535
    .end local v10    # "ex":Ljava/io/IOException;
    :cond_10
    :try_start_7
    invoke-interface/range {v20 .. v20}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v8

    .line 536
    .restart local v8    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    new-instance v9, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move/from16 v1, v21

    invoke-direct {v9, v8, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;Z)V

    .line 537
    .end local v8    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .local v9, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    move-object/from16 v0, v20

    invoke-interface {v0, v9}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    :try_end_7
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/conn/ConnectionShutdownException; {:try_start_7 .. :try_end_7} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_7 .. :try_end_7} :catch_5

    goto :goto_3

    .line 553
    .end local v9    # "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    :catch_5
    move-exception v10

    .line 554
    .local v10, "ex":Ljava/lang/RuntimeException;
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->abortConnection()V

    .line 555
    throw v10
.end method

.method protected handleResponse(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    .locals 24
    .param p1, "roureq"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1019
    invoke-virtual/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v20

    .line 1020
    .local v20, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    invoke-virtual/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;->getRequest()Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    move-result-object v19

    .line 1022
    .local v19, "request":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    invoke-virtual/range {v19 .. v19}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v16

    .line 1023
    .local v16, "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    invoke-static/range {v16 .. v16}, Lcom/comcast/cim/httpcomponentsandroid/client/params/HttpClientParams;->isRedirecting(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z

    move-result v3

    if-eqz v3, :cond_5

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;

    move-object/from16 v0, v19

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    invoke-interface {v3, v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;->isRedirected(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 1026
    move-object/from16 v0, p0

    iget v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->redirectCount:I

    move-object/from16 v0, p0

    iget v5, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->maxRedirects:I

    if-lt v3, v5, :cond_0

    .line 1027
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/client/RedirectException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Maximum redirects ("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, p0

    iget v6, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->maxRedirects:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ") exceeded"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/client/RedirectException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1030
    :cond_0
    move-object/from16 v0, p0

    iget v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->redirectCount:I

    add-int/lit8 v3, v3, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->redirectCount:I

    .line 1033
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->virtualHost:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 1035
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->redirectStrategy:Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;

    move-object/from16 v0, v19

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    invoke-interface {v3, v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/RedirectStrategy;->getRedirect(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    move-result-object v18

    .line 1036
    .local v18, "redirect":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    invoke-virtual/range {v19 .. v19}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getOriginal()Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    move-result-object v15

    .line 1037
    .local v15, "orig":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-interface {v15}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-interface {v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 1039
    invoke-interface/range {v18 .. v18}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v22

    .line 1040
    .local v22, "uri":Ljava/net/URI;
    invoke-virtual/range {v22 .. v22}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1

    .line 1041
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Redirect URI does not specify a valid host name: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v22

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1044
    :cond_1
    new-instance v14, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    invoke-virtual/range {v22 .. v22}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {v22 .. v22}, Ljava/net/URI;->getPort()I

    move-result v5

    invoke-virtual/range {v22 .. v22}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v14, v3, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    .line 1050
    .local v14, "newTarget":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->setAuthScope(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;)V

    .line 1051
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->setAuthScope(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;)V

    .line 1054
    invoke-virtual/range {v20 .. v20}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v3

    invoke-virtual {v3, v14}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 1055
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->invalidate()V

    .line 1056
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getAuthScheme()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    move-result-object v9

    .line 1057
    .local v9, "authScheme":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    if-eqz v9, :cond_2

    invoke-interface {v9}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->isConnectionBased()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 1058
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->invalidate()V

    .line 1062
    .end local v9    # "authScheme":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    :cond_2
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->wrapRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    move-result-object v23

    .line 1063
    .local v23, "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    move-object/from16 v0, v23

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 1065
    move-object/from16 v0, p0

    move-object/from16 v1, v23

    move-object/from16 v2, p3

    invoke-virtual {v0, v14, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->determineRoute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v13

    .line 1066
    .local v13, "newRoute":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    new-instance v12, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;

    move-object/from16 v0, v23

    invoke-direct {v12, v0, v13}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V

    .line 1068
    .local v12, "newRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1069
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Redirecting to \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v22

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\' via "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v5}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    :cond_3
    move-object/from16 p1, v12

    .line 1144
    .end local v12    # "newRequest":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    .end local v13    # "newRoute":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .end local v14    # "newTarget":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .end local v15    # "orig":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .end local v18    # "redirect":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .end local v22    # "uri":Ljava/net/URI;
    .end local v23    # "wrapper":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    .end local p1    # "roureq":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    :cond_4
    :goto_0
    return-object p1

    .line 1075
    .restart local p1    # "roureq":Lcom/comcast/cim/httpcomponentsandroid/impl/client/RoutedRequest;
    :cond_5
    const-string v3, "http.auth.credentials-provider"

    move-object/from16 v0, p3

    invoke-interface {v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    .line 1078
    .local v10, "credsProvider":Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;
    if-eqz v10, :cond_b

    invoke-static/range {v16 .. v16}, Lcom/comcast/cim/httpcomponentsandroid/client/params/HttpClientParams;->isAuthenticating(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z

    move-result v3

    if-eqz v3, :cond_b

    .line 1080
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-interface {v3, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;->isAuthenticationRequested(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 1082
    const-string v3, "http.target_host"

    move-object/from16 v0, p3

    invoke-interface {v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 1084
    .local v21, "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    if-nez v21, :cond_6

    .line 1085
    invoke-virtual/range {v20 .. v20}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v21

    .line 1088
    :cond_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "Target requested authentication"

    invoke-interface {v3, v5}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 1089
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-interface {v3, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;->getChallenges(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/Map;

    move-result-object v4

    .line 1092
    .local v4, "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    :try_start_0
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v3, p0

    move-object/from16 v7, p2

    move-object/from16 v8, p3

    invoke-direct/range {v3 .. v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->processChallenges(Ljava/util/Map;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1101
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v3, v1, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->updateAuthState(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;)V

    .line 1103
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getCredentials()Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    move-result-object v3

    if-nez v3, :cond_4

    .line 1107
    const/16 p1, 0x0

    goto :goto_0

    .line 1095
    :catch_0
    move-exception v11

    .line 1096
    .local v11, "ex":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isWarnEnabled()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 1097
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Authentication error: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v11}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v5}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;)V

    .line 1099
    :cond_7
    const/16 p1, 0x0

    goto/16 :goto_0

    .line 1111
    .end local v4    # "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    .end local v11    # "ex":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
    .end local v21    # "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    :cond_8
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->targetAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->setAuthScope(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;)V

    .line 1114
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-interface {v3, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;->isAuthenticationRequested(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 1116
    invoke-virtual/range {v20 .. v20}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getProxyHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v17

    .line 1118
    .local v17, "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "Proxy requested authentication"

    invoke-interface {v3, v5}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 1119
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-interface {v3, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;->getChallenges(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/Map;

    move-result-object v4

    .line 1122
    .restart local v4    # "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    :try_start_1
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthHandler:Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;

    move-object/from16 v3, p0

    move-object/from16 v7, p2

    move-object/from16 v8, p3

    invoke-direct/range {v3 .. v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->processChallenges(Ljava/util/Map;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    :try_end_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException; {:try_start_1 .. :try_end_1} :catch_1

    .line 1131
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v3, v1, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->updateAuthState(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;)V

    .line 1133
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getCredentials()Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    move-result-object v3

    if-nez v3, :cond_4

    .line 1137
    const/16 p1, 0x0

    goto/16 :goto_0

    .line 1125
    :catch_1
    move-exception v11

    .line 1126
    .restart local v11    # "ex":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isWarnEnabled()Z

    move-result v3

    if-eqz v3, :cond_9

    .line 1127
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Authentication error: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v11}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v5}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;)V

    .line 1129
    :cond_9
    const/16 p1, 0x0

    goto/16 :goto_0

    .line 1141
    .end local v4    # "challenges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    .end local v11    # "ex":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
    .end local v17    # "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    :cond_a
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->proxyAuthState:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->setAuthScope(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;)V

    .line 1144
    :cond_b
    const/16 p1, 0x0

    goto/16 :goto_0
.end method

.method protected releaseConnection()V
    .locals 3

    .prologue
    .line 685
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->releaseConnection()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 689
    :goto_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    .line 690
    return-void

    .line 686
    :catch_0
    move-exception v0

    .line 687
    .local v0, "ignored":Ljava/io/IOException;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultRequestDirector;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "IOException releasing connection"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected rewriteRequestURI(Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V
    .locals 6
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
    .param p2, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation

    .prologue
    .line 327
    :try_start_0
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getURI()Ljava/net/URI;

    move-result-object v2

    .line 328
    .local v2, "uri":Ljava/net/URI;
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getProxyHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->isTunnelled()Z

    move-result v3

    if-nez v3, :cond_1

    .line 330
    invoke-virtual {v2}, Ljava/net/URI;->isAbsolute()Z

    move-result v3

    if-nez v3, :cond_0

    .line 331
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v1

    .line 332
    .local v1, "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    invoke-static {v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URIUtils;->rewriteURI(Ljava/net/URI;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)Ljava/net/URI;

    move-result-object v2

    .line 333
    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setURI(Ljava/net/URI;)V

    .line 347
    .end local v1    # "target":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    :cond_0
    :goto_0
    return-void

    .line 337
    :cond_1
    invoke-virtual {v2}, Ljava/net/URI;->isAbsolute()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 338
    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URIUtils;->rewriteURI(Ljava/net/URI;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)Ljava/net/URI;

    move-result-object v2

    .line 339
    invoke-virtual {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setURI(Ljava/net/URI;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 343
    .end local v2    # "uri":Ljava/net/URI;
    :catch_0
    move-exception v0

    .line 344
    .local v0, "ex":Ljava/net/URISyntaxException;
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Invalid URI: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method
