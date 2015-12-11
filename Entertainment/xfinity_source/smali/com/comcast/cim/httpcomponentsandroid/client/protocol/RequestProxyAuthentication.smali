.class public Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;
.super Ljava/lang/Object;
.source "RequestProxyAuthentication.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final log:Lorg/apache/commons/logging/Log;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;->log:Lorg/apache/commons/logging/Log;

    .line 64
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 10
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 69
    if-nez p1, :cond_0

    .line 70
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "HTTP request may not be null"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 72
    :cond_0
    if-nez p2, :cond_1

    .line 73
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "HTTP context may not be null"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 76
    :cond_1
    const-string v7, "Proxy-Authorization"

    invoke-interface {p1, v7}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 125
    :cond_2
    :goto_0
    return-void

    .line 80
    :cond_3
    const-string v7, "http.connection"

    invoke-interface {p2, v7}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/conn/HttpRoutedConnection;

    .line 82
    .local v2, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/HttpRoutedConnection;
    if-nez v2, :cond_4

    .line 83
    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;->log:Lorg/apache/commons/logging/Log;

    const-string v8, "HTTP connection not set in the context"

    invoke-interface {v7, v8}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_0

    .line 86
    :cond_4
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/conn/HttpRoutedConnection;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v6

    .line 87
    .local v6, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    invoke-virtual {v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->isTunnelled()Z

    move-result v7

    if-nez v7, :cond_2

    .line 92
    const-string v7, "http.auth.proxy-scope"

    invoke-interface {p2, v7}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;

    .line 94
    .local v1, "authState":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;
    if-nez v1, :cond_5

    .line 95
    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;->log:Lorg/apache/commons/logging/Log;

    const-string v8, "Proxy auth state not set in the context"

    invoke-interface {v7, v8}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_0

    .line 99
    :cond_5
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getAuthScheme()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    move-result-object v0

    .line 100
    .local v0, "authScheme":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    if-eqz v0, :cond_2

    .line 104
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getCredentials()Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    move-result-object v3

    .line 105
    .local v3, "creds":Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;
    if-nez v3, :cond_6

    .line 106
    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;->log:Lorg/apache/commons/logging/Log;

    const-string v8, "User credentials not available"

    invoke-interface {v7, v8}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_0

    .line 109
    :cond_6
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->getAuthScope()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;

    move-result-object v7

    if-nez v7, :cond_7

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->isConnectionBased()Z

    move-result v7

    if-nez v7, :cond_2

    .line 112
    :cond_7
    :try_start_0
    instance-of v7, v0, Lcom/comcast/cim/httpcomponentsandroid/auth/ContextAwareAuthScheme;

    if-eqz v7, :cond_8

    .line 113
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/auth/ContextAwareAuthScheme;

    .end local v0    # "authScheme":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    invoke-interface {v0, v3, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/auth/ContextAwareAuthScheme;->authenticate(Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    .line 118
    .local v5, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :goto_1
    invoke-interface {p1, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 119
    .end local v5    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :catch_0
    move-exception v4

    .line 120
    .local v4, "ex":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v7}, Lorg/apache/commons/logging/Log;->isErrorEnabled()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 121
    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;->log:Lorg/apache/commons/logging/Log;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Proxy authentication error: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 116
    .end local v4    # "ex":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
    .restart local v0    # "authScheme":Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    :cond_8
    :try_start_1
    invoke-interface {v0, v3, p1}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;->authenticate(Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    :try_end_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v5

    .restart local v5    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    goto :goto_1
.end method
