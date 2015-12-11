.class public Ltwitter4j/internal/http/HttpClientImpl;
.super Ltwitter4j/internal/http/HttpClientBase;
.source "HttpClientImpl.java"

# interfaces
.implements Ltwitter4j/internal/http/HttpResponseCode;
.implements Ljava/io/Serializable;


# static fields
.field private static final instanceMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ltwitter4j/internal/http/HttpClientConfiguration;",
            "Ltwitter4j/internal/http/HttpClient;",
            ">;"
        }
    .end annotation
.end field

.field private static isJDK14orEarlier:Z = false

.field private static final logger:Ltwitter4j/internal/logging/Logger;

.field private static final serialVersionUID:J = -0x7a63fdacd4e632ffL


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 37
    const-class v4, Ltwitter4j/internal/http/HttpClientImpl;

    invoke-static {v4}, Ltwitter4j/internal/logging/Logger;->getLogger(Ljava/lang/Class;)Ltwitter4j/internal/logging/Logger;

    move-result-object v4

    sput-object v4, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    .line 39
    sput-boolean v2, Ltwitter4j/internal/http/HttpClientImpl;->isJDK14orEarlier:Z

    .line 45
    :try_start_0
    const-string v4, "java.specification.version"

    invoke-static {v4}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 46
    .local v1, "versionStr":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 47
    const-wide/high16 v4, 0x3ff8000000000000L    # 1.5

    invoke-static {v1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v6

    cmpl-double v4, v4, v6

    if-lez v4, :cond_0

    move v2, v3

    :cond_0
    sput-boolean v2, Ltwitter4j/internal/http/HttpClientImpl;->isJDK14orEarlier:Z

    .line 49
    :cond_1
    invoke-static {}, Ltwitter4j/conf/ConfigurationContext;->getInstance()Ltwitter4j/conf/Configuration;

    move-result-object v2

    invoke-interface {v2}, Ltwitter4j/conf/Configuration;->isDalvik()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 50
    const/4 v2, 0x0

    sput-boolean v2, Ltwitter4j/internal/http/HttpClientImpl;->isJDK14orEarlier:Z

    .line 53
    const-string v2, "http.keepAlive"

    const-string v4, "false"

    invoke-static {v2, v4}, Ljava/lang/System;->setProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    :cond_2
    :goto_0
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2, v3}, Ljava/util/HashMap;-><init>(I)V

    sput-object v2, Ltwitter4j/internal/http/HttpClientImpl;->instanceMap:Ljava/util/Map;

    return-void

    .line 55
    :catch_0
    move-exception v0

    .line 57
    .local v0, "ignore":Ljava/lang/SecurityException;
    sput-boolean v3, Ltwitter4j/internal/http/HttpClientImpl;->isJDK14orEarlier:Z

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 62
    invoke-static {}, Ltwitter4j/conf/ConfigurationContext;->getInstance()Ltwitter4j/conf/Configuration;

    move-result-object v0

    invoke-direct {p0, v0}, Ltwitter4j/internal/http/HttpClientBase;-><init>(Ltwitter4j/internal/http/HttpClientConfiguration;)V

    .line 63
    return-void
.end method

.method public constructor <init>(Ltwitter4j/internal/http/HttpClientConfiguration;)V
    .locals 2
    .param p1, "conf"    # Ltwitter4j/internal/http/HttpClientConfiguration;

    .prologue
    .line 66
    invoke-direct {p0, p1}, Ltwitter4j/internal/http/HttpClientBase;-><init>(Ltwitter4j/internal/http/HttpClientConfiguration;)V

    .line 67
    invoke-virtual {p0}, Ltwitter4j/internal/http/HttpClientImpl;->isProxyConfigured()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-boolean v0, Ltwitter4j/internal/http/HttpClientImpl;->isJDK14orEarlier:Z

    if-eqz v0, :cond_0

    .line 68
    sget-object v0, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    const-string v1, "HTTP Proxy is not supported on JDK1.4 or earlier. Try twitter4j-httpclient-supoprt artifact"

    invoke-virtual {v0, v1}, Ltwitter4j/internal/logging/Logger;->warn(Ljava/lang/String;)V

    .line 70
    :cond_0
    return-void
.end method

.method public static getInstance(Ltwitter4j/internal/http/HttpClientConfiguration;)Ltwitter4j/internal/http/HttpClient;
    .locals 2
    .param p0, "conf"    # Ltwitter4j/internal/http/HttpClientConfiguration;

    .prologue
    .line 75
    sget-object v1, Ltwitter4j/internal/http/HttpClientImpl;->instanceMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltwitter4j/internal/http/HttpClient;

    .line 76
    .local v0, "client":Ltwitter4j/internal/http/HttpClient;
    if-nez v0, :cond_0

    .line 77
    new-instance v0, Ltwitter4j/internal/http/HttpClientImpl;

    .end local v0    # "client":Ltwitter4j/internal/http/HttpClient;
    invoke-direct {v0, p0}, Ltwitter4j/internal/http/HttpClientImpl;-><init>(Ltwitter4j/internal/http/HttpClientConfiguration;)V

    .line 78
    .restart local v0    # "client":Ltwitter4j/internal/http/HttpClient;
    sget-object v1, Ltwitter4j/internal/http/HttpClientImpl;->instanceMap:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    :cond_0
    return-object v0
.end method

.method private setHeaders(Ltwitter4j/internal/http/HttpRequest;Ljava/net/HttpURLConnection;)V
    .locals 6
    .param p1, "req"    # Ltwitter4j/internal/http/HttpRequest;
    .param p2, "connection"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 215
    sget-object v3, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    invoke-virtual {v3}, Ltwitter4j/internal/logging/Logger;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 216
    sget-object v3, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    const-string v4, "Request: "

    invoke-virtual {v3, v4}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    .line 217
    sget-object v3, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ltwitter4j/internal/http/HttpRequest;->getMethod()Ltwitter4j/internal/http/RequestMethod;

    move-result-object v5

    invoke-virtual {v5}, Ltwitter4j/internal/http/RequestMethod;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Ltwitter4j/internal/http/HttpRequest;->getURL()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    :cond_0
    invoke-virtual {p1}, Ltwitter4j/internal/http/HttpRequest;->getAuthorization()Ltwitter4j/auth/Authorization;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {p1}, Ltwitter4j/internal/http/HttpRequest;->getAuthorization()Ltwitter4j/auth/Authorization;

    move-result-object v3

    invoke-interface {v3, p1}, Ltwitter4j/auth/Authorization;->getAuthorizationHeader(Ltwitter4j/internal/http/HttpRequest;)Ljava/lang/String;

    move-result-object v0

    .local v0, "authorizationHeader":Ljava/lang/String;
    if-eqz v0, :cond_2

    .line 222
    sget-object v3, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    invoke-virtual {v3}, Ltwitter4j/internal/logging/Logger;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 223
    sget-object v3, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    const-string v4, "Authorization: "

    invoke-static {v0}, Ltwitter4j/internal/util/z_T4JInternalStringUtil;->maskString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    :cond_1
    const-string v3, "Authorization"

    invoke-virtual {p2, v3, v0}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    .end local v0    # "authorizationHeader":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Ltwitter4j/internal/http/HttpRequest;->getRequestHeaders()Ljava/util/Map;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 228
    invoke-virtual {p1}, Ltwitter4j/internal/http/HttpRequest;->getRequestHeaders()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 229
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {p1}, Ltwitter4j/internal/http/HttpRequest;->getRequestHeaders()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p2, v2, v3}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    sget-object v4, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, ": "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Ltwitter4j/internal/http/HttpRequest;->getRequestHeaders()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 233
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    :cond_3
    return-void
.end method


# virtual methods
.method public get(Ljava/lang/String;)Ltwitter4j/internal/http/HttpResponse;
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 84
    new-instance v0, Ltwitter4j/internal/http/HttpRequest;

    sget-object v1, Ltwitter4j/internal/http/RequestMethod;->GET:Ltwitter4j/internal/http/RequestMethod;

    move-object v2, p1

    move-object v4, v3

    move-object v5, v3

    invoke-direct/range {v0 .. v5}, Ltwitter4j/internal/http/HttpRequest;-><init>(Ltwitter4j/internal/http/RequestMethod;Ljava/lang/String;[Ltwitter4j/internal/http/HttpParameter;Ltwitter4j/auth/Authorization;Ljava/util/Map;)V

    invoke-virtual {p0, v0}, Ltwitter4j/internal/http/HttpClientImpl;->request(Ltwitter4j/internal/http/HttpRequest;)Ltwitter4j/internal/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method protected getConnection(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 237
    invoke-virtual {p0}, Ltwitter4j/internal/http/HttpClientImpl;->isProxyConfigured()Z

    move-result v2

    if-eqz v2, :cond_5

    sget-boolean v2, Ltwitter4j/internal/http/HttpClientImpl;->isJDK14orEarlier:Z

    if-nez v2, :cond_5

    .line 238
    iget-object v2, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v2}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpProxyUser()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v2}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpProxyUser()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 239
    sget-object v2, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    invoke-virtual {v2}, Ltwitter4j/internal/logging/Logger;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 240
    sget-object v2, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Proxy AuthUser: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v4}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpProxyUser()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    .line 241
    sget-object v2, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Proxy AuthPassword: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v4}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpProxyPassword()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ltwitter4j/internal/util/z_T4JInternalStringUtil;->maskString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    .line 243
    :cond_0
    new-instance v2, Ltwitter4j/internal/http/HttpClientImpl$1;

    invoke-direct {v2, p0}, Ltwitter4j/internal/http/HttpClientImpl$1;-><init>(Ltwitter4j/internal/http/HttpClientImpl;)V

    invoke-static {v2}, Ljava/net/Authenticator;->setDefault(Ljava/net/Authenticator;)V

    .line 257
    :cond_1
    new-instance v1, Ljava/net/Proxy;

    sget-object v2, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    iget-object v3, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v3}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpProxyHost()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v4}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpProxyPort()I

    move-result v4

    invoke-static {v3, v4}, Ljava/net/InetSocketAddress;->createUnresolved(Ljava/lang/String;I)Ljava/net/InetSocketAddress;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/net/Proxy;-><init>(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V

    .line 259
    .local v1, "proxy":Ljava/net/Proxy;
    sget-object v2, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    invoke-virtual {v2}, Ltwitter4j/internal/logging/Logger;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 260
    sget-object v2, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Opening proxied connection("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v4}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpProxyHost()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v4}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpProxyPort()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    .line 262
    :cond_2
    new-instance v2, Ljava/net/URL;

    invoke-direct {v2, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/net/URL;->openConnection(Ljava/net/Proxy;)Ljava/net/URLConnection;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->openConnectionWithProxy(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 266
    .end local v1    # "proxy":Ljava/net/Proxy;
    .local v0, "con":Ljava/net/HttpURLConnection;
    :goto_0
    iget-object v2, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v2}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpConnectionTimeout()I

    move-result v2

    if-lez v2, :cond_3

    sget-boolean v2, Ltwitter4j/internal/http/HttpClientImpl;->isJDK14orEarlier:Z

    if-nez v2, :cond_3

    .line 267
    iget-object v2, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v2}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpConnectionTimeout()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 269
    :cond_3
    iget-object v2, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v2}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpReadTimeout()I

    move-result v2

    if-lez v2, :cond_4

    sget-boolean v2, Ltwitter4j/internal/http/HttpClientImpl;->isJDK14orEarlier:Z

    if-nez v2, :cond_4

    .line 270
    iget-object v2, p0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    invoke-interface {v2}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpReadTimeout()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 272
    :cond_4
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 273
    return-object v0

    .line 264
    .end local v0    # "con":Ljava/net/HttpURLConnection;
    :cond_5
    new-instance v2, Ljava/net/URL;

    invoke-direct {v2, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->openConnection(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .restart local v0    # "con":Ljava/net/HttpURLConnection;
    goto :goto_0
.end method

.method public post(Ljava/lang/String;[Ltwitter4j/internal/http/HttpParameter;)Ltwitter4j/internal/http/HttpResponse;
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "params"    # [Ltwitter4j/internal/http/HttpParameter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 88
    new-instance v0, Ltwitter4j/internal/http/HttpRequest;

    sget-object v1, Ltwitter4j/internal/http/RequestMethod;->POST:Ltwitter4j/internal/http/RequestMethod;

    move-object v2, p1

    move-object v3, p2

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Ltwitter4j/internal/http/HttpRequest;-><init>(Ltwitter4j/internal/http/RequestMethod;Ljava/lang/String;[Ltwitter4j/internal/http/HttpParameter;Ltwitter4j/auth/Authorization;Ljava/util/Map;)V

    invoke-virtual {p0, v0}, Ltwitter4j/internal/http/HttpClientImpl;->request(Ltwitter4j/internal/http/HttpRequest;)Ltwitter4j/internal/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public request(Ltwitter4j/internal/http/HttpRequest;)Ltwitter4j/internal/http/HttpResponse;
    .locals 32
    .param p1, "req"    # Ltwitter4j/internal/http/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    .line 94
    move-object/from16 v0, p0

    iget-object v0, v0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    move-object/from16 v28, v0

    invoke-interface/range {v28 .. v28}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpRetryCount()I

    move-result v28

    add-int/lit8 v25, v28, 0x1

    .line 95
    .local v25, "retry":I
    const/16 v20, 0x0

    .line 96
    .local v20, "res":Ltwitter4j/internal/http/HttpResponse;
    const/16 v24, 0x0

    .local v24, "retriedCount":I
    move-object/from16 v21, v20

    .end local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    .local v21, "res":Ltwitter4j/internal/http/HttpResponse;
    :goto_0
    move/from16 v0, v24

    move/from16 v1, v25

    if-ge v0, v1, :cond_f

    .line 97
    const/16 v22, -0x1

    .line 100
    .local v22, "responseCode":I
    const/16 v16, 0x0

    .line 102
    .local v16, "os":Ljava/io/OutputStream;
    :try_start_0
    invoke-virtual/range {p1 .. p1}, Ltwitter4j/internal/http/HttpRequest;->getURL()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Ltwitter4j/internal/http/HttpClientImpl;->getConnection(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v8

    .line 103
    .local v8, "con":Ljava/net/HttpURLConnection;
    const/16 v28, 0x1

    move/from16 v0, v28

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 104
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v8}, Ltwitter4j/internal/http/HttpClientImpl;->setHeaders(Ltwitter4j/internal/http/HttpRequest;Ljava/net/HttpURLConnection;)V

    .line 105
    invoke-virtual/range {p1 .. p1}, Ltwitter4j/internal/http/HttpRequest;->getMethod()Ltwitter4j/internal/http/RequestMethod;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ltwitter4j/internal/http/RequestMethod;->name()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 106
    invoke-virtual/range {p1 .. p1}, Ltwitter4j/internal/http/HttpRequest;->getMethod()Ltwitter4j/internal/http/RequestMethod;

    move-result-object v28

    sget-object v29, Ltwitter4j/internal/http/RequestMethod;->POST:Ltwitter4j/internal/http/RequestMethod;

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    if-ne v0, v1, :cond_4

    .line 107
    invoke-virtual/range {p1 .. p1}, Ltwitter4j/internal/http/HttpRequest;->getParameters()[Ltwitter4j/internal/http/HttpParameter;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Ltwitter4j/internal/http/HttpParameter;->containsFile([Ltwitter4j/internal/http/HttpParameter;)Z

    move-result v28

    if-eqz v28, :cond_6

    .line 108
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "----Twitter4J-upload"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v30

    move-object/from16 v0, v28

    move-wide/from16 v1, v30

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 109
    .local v5, "boundary":Ljava/lang/String;
    const-string v28, "Content-Type"

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "multipart/form-data; boundary="

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    invoke-virtual {v8, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "--"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 111
    const/16 v28, 0x1

    move/from16 v0, v28

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 112
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v16

    .line 113
    new-instance v17, Ljava/io/DataOutputStream;

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-direct {v0, v1}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 114
    .local v17, "out":Ljava/io/DataOutputStream;
    invoke-virtual/range {p1 .. p1}, Ltwitter4j/internal/http/HttpRequest;->getParameters()[Ltwitter4j/internal/http/HttpParameter;

    move-result-object v4

    .local v4, "arr$":[Ltwitter4j/internal/http/HttpParameter;
    array-length v14, v4

    .local v14, "len$":I
    const/4 v9, 0x0

    .local v9, "i$":I
    :goto_1
    if-ge v9, v14, :cond_3

    aget-object v18, v4, v9

    .line 115
    .local v18, "param":Ltwitter4j/internal/http/HttpParameter;
    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->isFile()Z

    move-result v28

    if-eqz v28, :cond_2

    .line 116
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v28

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "\r\n"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 117
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "Content-Disposition: form-data; name=\""

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->getName()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "\"; filename=\""

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->getFile()Ljava/io/File;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "\"\r\n"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 118
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "Content-Type: "

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->getContentType()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "\r\n\r\n"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 119
    new-instance v11, Ljava/io/BufferedInputStream;

    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->hasFileBody()Z

    move-result v28

    if-eqz v28, :cond_0

    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->getFileBody()Ljava/io/InputStream;

    move-result-object v28

    :goto_2
    move-object/from16 v0, v28

    invoke-direct {v11, v0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 122
    .local v11, "in":Ljava/io/BufferedInputStream;
    const/16 v28, 0x400

    move/from16 v0, v28

    new-array v6, v0, [B

    .line 124
    .local v6, "buff":[B
    :goto_3
    invoke-virtual {v11, v6}, Ljava/io/BufferedInputStream;->read([B)I

    move-result v15

    .local v15, "length":I
    const/16 v28, -0x1

    move/from16 v0, v28

    if-eq v15, v0, :cond_1

    .line 125
    const/16 v28, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v28

    invoke-virtual {v0, v6, v1, v15}, Ljava/io/DataOutputStream;->write([BII)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_3

    .line 184
    .end local v4    # "arr$":[Ltwitter4j/internal/http/HttpParameter;
    .end local v5    # "boundary":Ljava/lang/String;
    .end local v6    # "buff":[B
    .end local v8    # "con":Ljava/net/HttpURLConnection;
    .end local v9    # "i$":I
    .end local v11    # "in":Ljava/io/BufferedInputStream;
    .end local v14    # "len$":I
    .end local v15    # "length":I
    .end local v17    # "out":Ljava/io/DataOutputStream;
    .end local v18    # "param":Ltwitter4j/internal/http/HttpParameter;
    :catchall_0
    move-exception v28

    move-object/from16 v20, v21

    .line 185
    .end local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    :goto_4
    :try_start_1
    invoke-virtual/range {v16 .. v16}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 187
    :goto_5
    :try_start_2
    throw v28
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 189
    :catch_0
    move-exception v12

    .line 191
    .local v12, "ioe":Ljava/io/IOException;
    move-object/from16 v0, p0

    iget-object v0, v0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    move-object/from16 v28, v0

    invoke-interface/range {v28 .. v28}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpRetryCount()I

    move-result v28

    move/from16 v0, v24

    move/from16 v1, v28

    if-ne v0, v1, :cond_d

    .line 192
    new-instance v28, Ltwitter4j/TwitterException;

    invoke-virtual {v12}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move/from16 v2, v22

    invoke-direct {v0, v1, v12, v2}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;Ljava/lang/Exception;I)V

    throw v28

    .line 119
    .end local v12    # "ioe":Ljava/io/IOException;
    .end local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v4    # "arr$":[Ltwitter4j/internal/http/HttpParameter;
    .restart local v5    # "boundary":Ljava/lang/String;
    .restart local v8    # "con":Ljava/net/HttpURLConnection;
    .restart local v9    # "i$":I
    .restart local v14    # "len$":I
    .restart local v17    # "out":Ljava/io/DataOutputStream;
    .restart local v18    # "param":Ltwitter4j/internal/http/HttpParameter;
    .restart local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    :cond_0
    :try_start_3
    new-instance v28, Ljava/io/FileInputStream;

    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->getFile()Ljava/io/File;

    move-result-object v29

    invoke-direct/range {v28 .. v29}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    goto :goto_2

    .line 127
    .restart local v6    # "buff":[B
    .restart local v11    # "in":Ljava/io/BufferedInputStream;
    .restart local v15    # "length":I
    :cond_1
    const-string v28, "\r\n"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 128
    invoke-virtual {v11}, Ljava/io/BufferedInputStream;->close()V

    .line 114
    .end local v6    # "buff":[B
    .end local v11    # "in":Ljava/io/BufferedInputStream;
    .end local v15    # "length":I
    :goto_6
    add-int/lit8 v9, v9, 0x1

    goto/16 :goto_1

    .line 130
    :cond_2
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v28

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "\r\n"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 131
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "Content-Disposition: form-data; name=\""

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->getName()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "\"\r\n"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 132
    const-string v28, "Content-Type: text/plain; charset=UTF-8\r\n\r\n"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 133
    sget-object v28, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->getValue()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    .line 134
    invoke-virtual/range {v18 .. v18}, Ltwitter4j/internal/http/HttpParameter;->getValue()Ljava/lang/String;

    move-result-object v28

    const-string v29, "UTF-8"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v28

    move-object/from16 v0, v17

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->write([B)V

    .line 135
    const-string v28, "\r\n"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    goto :goto_6

    .line 138
    .end local v18    # "param":Ltwitter4j/internal/http/HttpParameter;
    :cond_3
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v28

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "--\r\n"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 139
    const-string v28, "\r\n"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/http/HttpClientImpl;->write(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 153
    .end local v4    # "arr$":[Ltwitter4j/internal/http/HttpParameter;
    .end local v5    # "boundary":Ljava/lang/String;
    .end local v9    # "i$":I
    .end local v14    # "len$":I
    .end local v17    # "out":Ljava/io/DataOutputStream;
    :goto_7
    invoke-virtual/range {v16 .. v16}, Ljava/io/OutputStream;->flush()V

    .line 154
    invoke-virtual/range {v16 .. v16}, Ljava/io/OutputStream;->close()V

    .line 156
    :cond_4
    new-instance v20, Ltwitter4j/internal/http/HttpResponseImpl;

    move-object/from16 v0, p0

    iget-object v0, v0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    move-object/from16 v28, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v28

    invoke-direct {v0, v8, v1}, Ltwitter4j/internal/http/HttpResponseImpl;-><init>(Ljava/net/HttpURLConnection;Ltwitter4j/internal/http/HttpClientConfiguration;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 157
    .end local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    :try_start_4
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v22

    .line 158
    sget-object v28, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    invoke-virtual/range {v28 .. v28}, Ltwitter4j/internal/logging/Logger;->isDebugEnabled()Z

    move-result v28

    if-eqz v28, :cond_8

    .line 159
    sget-object v28, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    const-string v29, "Response: "

    invoke-virtual/range {v28 .. v29}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    .line 160
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v23

    .line 161
    .local v23, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface/range {v23 .. v23}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v28

    invoke-interface/range {v28 .. v28}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_5
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v28

    if-eqz v28, :cond_8

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 162
    .local v13, "key":Ljava/lang/String;
    move-object/from16 v0, v23

    invoke-interface {v0, v13}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Ljava/util/List;

    .line 163
    .local v27, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface/range {v27 .. v27}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :goto_8
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v28

    if-eqz v28, :cond_5

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Ljava/lang/String;

    .line 164
    .local v26, "value":Ljava/lang/String;
    if-eqz v13, :cond_7

    .line 165
    sget-object v28, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, ": "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_8

    .line 184
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v13    # "key":Ljava/lang/String;
    .end local v23    # "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v26    # "value":Ljava/lang/String;
    .end local v27    # "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catchall_1
    move-exception v28

    goto/16 :goto_4

    .line 142
    .end local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    :cond_6
    :try_start_5
    const-string v28, "Content-Type"

    const-string v29, "application/x-www-form-urlencoded"

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    invoke-virtual {v8, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    invoke-virtual/range {p1 .. p1}, Ltwitter4j/internal/http/HttpRequest;->getParameters()[Ltwitter4j/internal/http/HttpParameter;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Ltwitter4j/internal/http/HttpParameter;->encodeParameters([Ltwitter4j/internal/http/HttpParameter;)Ljava/lang/String;

    move-result-object v19

    .line 145
    .local v19, "postParam":Ljava/lang/String;
    sget-object v28, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    const-string v29, "Post Params: "

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    const-string v28, "UTF-8"

    move-object/from16 v0, v19

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v7

    .line 147
    .local v7, "bytes":[B
    const-string v28, "Content-Length"

    array-length v0, v7

    move/from16 v29, v0

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    invoke-virtual {v8, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    const/16 v28, 0x1

    move/from16 v0, v28

    invoke-virtual {v8, v0}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 150
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v16

    .line 151
    move-object/from16 v0, v16

    invoke-virtual {v0, v7}, Ljava/io/OutputStream;->write([B)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_7

    .line 167
    .end local v7    # "bytes":[B
    .end local v19    # "postParam":Ljava/lang/String;
    .end local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v10    # "i$":Ljava/util/Iterator;
    .restart local v13    # "key":Ljava/lang/String;
    .restart local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v23    # "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .restart local v26    # "value":Ljava/lang/String;
    .restart local v27    # "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_7
    :try_start_6
    sget-object v28, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    move-object/from16 v0, v28

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_8

    .line 172
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v13    # "key":Ljava/lang/String;
    .end local v23    # "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v26    # "value":Ljava/lang/String;
    .end local v27    # "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_8
    const/16 v28, 0xc8

    move/from16 v0, v22

    move/from16 v1, v28

    if-lt v0, v1, :cond_9

    const/16 v28, 0x12e

    move/from16 v0, v22

    move/from16 v1, v28

    if-eq v0, v1, :cond_b

    const/16 v28, 0x12c

    move/from16 v0, v28

    move/from16 v1, v22

    if-gt v0, v1, :cond_b

    .line 173
    :cond_9
    const/16 v28, 0x1a4

    move/from16 v0, v22

    move/from16 v1, v28

    if-eq v0, v1, :cond_a

    const/16 v28, 0x190

    move/from16 v0, v22

    move/from16 v1, v28

    if-eq v0, v1, :cond_a

    const/16 v28, 0x1f4

    move/from16 v0, v22

    move/from16 v1, v28

    if-lt v0, v1, :cond_a

    move-object/from16 v0, p0

    iget-object v0, v0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    move-object/from16 v28, v0

    invoke-interface/range {v28 .. v28}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpRetryCount()I

    move-result v28

    move/from16 v0, v24

    move/from16 v1, v28

    if-ne v0, v1, :cond_c

    .line 177
    :cond_a
    new-instance v28, Ltwitter4j/TwitterException;

    invoke-virtual/range {v20 .. v20}, Ltwitter4j/internal/http/HttpResponse;->asString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move-object/from16 v2, v20

    invoke-direct {v0, v1, v2}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;Ltwitter4j/internal/http/HttpResponse;)V

    throw v28
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 185
    :cond_b
    :try_start_7
    invoke-virtual/range {v16 .. v16}, Ljava/io/OutputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0

    .line 205
    .end local v8    # "con":Ljava/net/HttpURLConnection;
    .end local v16    # "os":Ljava/io/OutputStream;
    .end local v22    # "responseCode":I
    :goto_9
    return-object v20

    .line 185
    .restart local v8    # "con":Ljava/net/HttpURLConnection;
    .restart local v16    # "os":Ljava/io/OutputStream;
    .restart local v22    # "responseCode":I
    :cond_c
    :try_start_8
    invoke-virtual/range {v16 .. v16}, Ljava/io/OutputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_0

    .line 196
    .end local v8    # "con":Ljava/net/HttpURLConnection;
    :cond_d
    :goto_a
    :try_start_9
    sget-object v28, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    invoke-virtual/range {v28 .. v28}, Ltwitter4j/internal/logging/Logger;->isDebugEnabled()Z

    move-result v28

    if-eqz v28, :cond_e

    if-eqz v20, :cond_e

    .line 197
    invoke-virtual/range {v20 .. v20}, Ltwitter4j/internal/http/HttpResponse;->asString()Ljava/lang/String;

    .line 199
    :cond_e
    sget-object v28, Ltwitter4j/internal/http/HttpClientImpl;->logger:Ltwitter4j/internal/logging/Logger;

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "Sleeping "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, p0

    iget-object v0, v0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    move-object/from16 v30, v0

    invoke-interface/range {v30 .. v30}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpRetryIntervalSeconds()I

    move-result v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, " seconds until the next retry."

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ltwitter4j/internal/logging/Logger;->debug(Ljava/lang/String;)V

    .line 200
    move-object/from16 v0, p0

    iget-object v0, v0, Ltwitter4j/internal/http/HttpClientImpl;->CONF:Ltwitter4j/internal/http/HttpClientConfiguration;

    move-object/from16 v28, v0

    invoke-interface/range {v28 .. v28}, Ltwitter4j/internal/http/HttpClientConfiguration;->getHttpRetryIntervalSeconds()I

    move-result v28

    move/from16 v0, v28

    mul-int/lit16 v0, v0, 0x3e8

    move/from16 v28, v0

    move/from16 v0, v28

    int-to-long v0, v0

    move-wide/from16 v28, v0

    invoke-static/range {v28 .. v29}, Ljava/lang/Thread;->sleep(J)V
    :try_end_9
    .catch Ljava/lang/InterruptedException; {:try_start_9 .. :try_end_9} :catch_4

    .line 96
    :goto_b
    add-int/lit8 v24, v24, 0x1

    move-object/from16 v21, v20

    .end local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    goto/16 :goto_0

    .line 186
    .end local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v8    # "con":Ljava/net/HttpURLConnection;
    .restart local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    :catch_1
    move-exception v28

    goto :goto_9

    :catch_2
    move-exception v28

    goto :goto_a

    .end local v8    # "con":Ljava/net/HttpURLConnection;
    :catch_3
    move-exception v29

    goto/16 :goto_5

    .line 201
    :catch_4
    move-exception v28

    goto :goto_b

    .end local v16    # "os":Ljava/io/OutputStream;
    .end local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    .end local v22    # "responseCode":I
    .restart local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    :cond_f
    move-object/from16 v20, v21

    .end local v21    # "res":Ltwitter4j/internal/http/HttpResponse;
    .restart local v20    # "res":Ltwitter4j/internal/http/HttpResponse;
    goto :goto_9
.end method
