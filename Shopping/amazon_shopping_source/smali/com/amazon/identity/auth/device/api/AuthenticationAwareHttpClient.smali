.class public Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;
.super Ljava/lang/Object;
.source "AuthenticationAwareHttpClient.java"

# interfaces
.implements Lorg/apache/http/client/HttpClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mInnerHttpClient:Lorg/apache/http/client/HttpClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 68
    const-class v0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 8

    .prologue
    .line 213
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 214
    new-instance v3, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 221
    .local v3, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    :try_start_0
    new-instance v4, Lorg/apache/http/conn/scheme/Scheme;

    const-string/jumbo v5, "http"

    invoke-static {}, Lorg/apache/http/conn/scheme/PlainSocketFactory;->getSocketFactory()Lorg/apache/http/conn/scheme/PlainSocketFactory;

    move-result-object v6

    const/16 v7, 0x50

    invoke-direct {v4, v5, v6, v7}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v4}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 222
    new-instance v4, Lorg/apache/http/conn/scheme/Scheme;

    const-string/jumbo v5, "https"

    invoke-static {}, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->getInstance()Lorg/apache/http/conn/scheme/SocketFactory;

    move-result-object v6

    const/16 v7, 0x1bb

    invoke-direct {v4, v5, v6, v7}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v4}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 233
    new-instance v2, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v2}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 240
    .local v2, "httpParams":Lorg/apache/http/params/HttpParams;
    new-instance v0, Lorg/apache/http/impl/conn/SingleClientConnManager;

    invoke-direct {v0, v2, v3}, Lorg/apache/http/impl/conn/SingleClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 242
    .local v0, "connectionManager":Lorg/apache/http/conn/ClientConnectionManager;
    new-instance v4, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v4, v0, v2}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    iput-object v4, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    .line 243
    return-void

    .line 224
    .end local v0    # "connectionManager":Lorg/apache/http/conn/ClientConnectionManager;
    .end local v2    # "httpParams":Lorg/apache/http/params/HttpParams;
    :catch_0
    move-exception v1

    .line 226
    .local v1, "e":Ljava/security/GeneralSecurityException;
    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 228
    .end local v1    # "e":Ljava/security/GeneralSecurityException;
    :catch_1
    move-exception v1

    .line 230
    .local v1, "e":Ljava/io/IOException;
    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v4
.end method

.method public constructor <init>(Lorg/apache/http/client/HttpClient;)V
    .locals 0
    .param p1, "wrappedHttpClient"    # Lorg/apache/http/client/HttpClient;

    .prologue
    .line 253
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 254
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    .line 255
    return-void
.end method

.method private onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V
    .locals 8
    .param p1, "httpHost"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 382
    const/4 v0, 0x0

    .line 384
    .local v0, "authMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    instance-of v1, p2, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpRequest;

    if-eqz v1, :cond_0

    move-object v1, p2

    .line 386
    check-cast v1, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpRequest;

    invoke-interface {v1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpRequest;->getAuthenticationMethod()Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    move-result-object v0

    .line 389
    :cond_0
    if-eqz v0, :cond_6

    .line 391
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->parse(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/AuthenticationType;

    move-result-object v5

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lorg/apache/http/HttpHost;->getSchemeName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lorg/apache/http/HttpHost;->getHostName()Ljava/lang/String;

    move-result-object v1

    move-object v7, v1

    move-object v1, v4

    move-object v4, v7

    :goto_0
    if-eqz v1, :cond_3

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v6}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v6, "https"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    move v1, v2

    :goto_1
    if-nez v1, :cond_5

    if-eqz v5, :cond_4

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->requireHttps()Z

    move-result v1

    if-eqz v1, :cond_4

    new-instance v1, Ljava/lang/SecurityException;

    const-string/jumbo v4, "The authentication type %s can only be used over HTTPS. "

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    invoke-static {v4, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1
    instance-of v1, p2, Lorg/apache/http/client/methods/HttpUriRequest;

    if-eqz v1, :cond_2

    move-object v1, p2

    check-cast v1, Lorg/apache/http/client/methods/HttpUriRequest;

    invoke-interface {v1}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v1

    move-object v7, v1

    move-object v1, v4

    move-object v4, v7

    goto :goto_0

    :cond_2
    move-object v1, v4

    goto :goto_0

    :cond_3
    move v1, v3

    goto :goto_1

    :cond_4
    sget-object v1, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Using http for "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " with auth type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 392
    :cond_5
    new-instance v1, Lcom/amazon/identity/auth/request/HttpRequestAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/identity/auth/request/HttpRequestAdapter;-><init>(Lorg/apache/http/HttpRequest;)V

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->authenticateConnection(Lcom/amazon/identity/auth/request/IRequestAdapter;)V

    .line 394
    :cond_6
    return-void
.end method

.method private wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lorg/apache/http/HttpRequest;",
            ">(TT;)TT;"
        }
    .end annotation

    .prologue
    .line 440
    .local p1, "request":Lorg/apache/http/HttpRequest;, "TT;"
    instance-of v2, p1, Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;

    if-nez v2, :cond_1

    .line 452
    :cond_0
    :goto_0
    return-object p1

    :cond_1
    move-object v1, p1

    .line 445
    check-cast v1, Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;

    .line 446
    .local v1, "httpEntityRequest":Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;
    invoke-virtual {v1}, Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    .line 447
    .local v0, "httpEntity":Lorg/apache/http/HttpEntity;
    if-eqz v0, :cond_0

    .line 449
    new-instance v2, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;

    invoke-direct {v2, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient$WrappedHttpEntity;-><init>(Lorg/apache/http/HttpEntity;)V

    invoke-virtual {v1, v2}, Lorg/apache/http/client/methods/HttpEntityEnclosingRequestBase;->setEntity(Lorg/apache/http/HttpEntity;)V

    goto :goto_0
.end method


# virtual methods
.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    .locals 2
    .param p1, "host"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 341
    .local p3, "responseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;

    move-result-object v0

    .line 342
    .local v0, "wrappedRequest":Lorg/apache/http/HttpRequest;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V

    .line 344
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v1, p1, v0, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    .locals 2
    .param p1, "host"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .param p4, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 356
    .local p3, "responseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;

    move-result-object v0

    .line 357
    .local v0, "wrappedRequest":Lorg/apache/http/HttpRequest;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V

    .line 359
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v1, p1, v0, p3, p4}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    .locals 2
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 300
    .local p2, "responseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;

    move-result-object v0

    check-cast v0, Lorg/apache/http/client/methods/HttpUriRequest;

    .line 301
    .local v0, "wrappedRequest":Lorg/apache/http/client/methods/HttpUriRequest;
    const/4 v1, 0x0

    invoke-direct {p0, v1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V

    .line 303
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v1, v0, p2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    .locals 2
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p3, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 327
    .local p2, "responseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;

    move-result-object v0

    check-cast v0, Lorg/apache/http/client/methods/HttpUriRequest;

    .line 328
    .local v0, "wrappedRequest":Lorg/apache/http/client/methods/HttpUriRequest;
    const/4 v1, 0x0

    invoke-direct {p0, v1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V

    .line 330
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v1, v0, p2, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    .locals 2
    .param p1, "target"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 287
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;

    move-result-object v0

    .line 288
    .local v0, "wrappedRequest":Lorg/apache/http/HttpRequest;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V

    .line 290
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v1, p1, v0}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    return-object v1
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 2
    .param p1, "target"    # Lorg/apache/http/HttpHost;
    .param p2, "request"    # Lorg/apache/http/HttpRequest;
    .param p3, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 313
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;

    move-result-object v0

    .line 314
    .local v0, "wrappedRequest":Lorg/apache/http/HttpRequest;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V

    .line 316
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v1, p1, v0, p3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    return-object v1
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    .locals 2
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 263
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;

    move-result-object v0

    check-cast v0, Lorg/apache/http/client/methods/HttpUriRequest;

    .line 264
    .local v0, "wrappedRequest":Lorg/apache/http/client/methods/HttpUriRequest;
    const/4 v1, 0x0

    invoke-direct {p0, v1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V

    .line 266
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v1, v0}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    return-object v1
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 2
    .param p1, "request"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p2, "context"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 275
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->wrapHttpRequest(Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpRequest;

    move-result-object v0

    check-cast v0, Lorg/apache/http/client/methods/HttpUriRequest;

    .line 276
    .local v0, "wrappedRequest":Lorg/apache/http/client/methods/HttpUriRequest;
    const/4 v1, 0x0

    invoke-direct {p0, v1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->onConnectionRequested(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)V

    .line 278
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v1, v0, p2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    return-object v1
.end method

.method public getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 368
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    return-object v0
.end method

.method public getParams()Lorg/apache/http/params/HttpParams;
    .locals 1

    .prologue
    .line 377
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;->mInnerHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v0

    return-object v0
.end method
