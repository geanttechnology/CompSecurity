.class public Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;
.super Ljavax/net/ssl/HttpsURLConnection;
.source "AuthenticatedURLConnection.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-class v0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 1
    .param p1, "url"    # Ljava/net/URL;
    .param p2, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 43
    invoke-direct {p0, p1}, Ljavax/net/ssl/HttpsURLConnection;-><init>(Ljava/net/URL;)V

    .line 46
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    .line 47
    return-void
.end method

.method constructor <init>(Ljava/net/URL;Ljavax/net/ssl/HttpsURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 1
    .param p1, "testUrl"    # Ljava/net/URL;
    .param p2, "connection"    # Ljavax/net/ssl/HttpsURLConnection;
    .param p3, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 54
    invoke-direct {p0, p1}, Ljavax/net/ssl/HttpsURLConnection;-><init>(Ljava/net/URL;)V

    .line 55
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;-><init>(Ljava/net/URL;Ljavax/net/ssl/HttpsURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    .line 56
    return-void
.end method

.method public static openConnection(Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;
    .locals 8
    .param p0, "connection"    # Ljava/net/HttpURLConnection;
    .param p1, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 95
    if-nez p0, :cond_0

    .line 97
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "Must Specify a URL"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 100
    :cond_0
    if-nez p1, :cond_1

    .line 102
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "Must Specify an Authentication Method"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 105
    :cond_1
    instance-of v3, p0, Ljavax/net/ssl/HttpsURLConnection;

    if-eqz v3, :cond_2

    .line 107
    new-instance v3, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    check-cast p0, Ljavax/net/ssl/HttpsURLConnection;

    .end local p0    # "connection":Ljava/net/HttpURLConnection;
    invoke-direct {v3, p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;-><init>(Ljavax/net/ssl/HttpsURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    .line 124
    :goto_0
    return-object v3

    .line 111
    .restart local p0    # "connection":Ljava/net/HttpURLConnection;
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->parse(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/AuthenticationType;

    move-result-object v0

    .line 113
    .local v0, "authType":Lcom/amazon/identity/auth/device/api/AuthenticationType;
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->requireHttps()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 115
    new-instance v3, Ljava/lang/SecurityException;

    const-string/jumbo v4, "The authentication type %s can only be used over HTTPS. "

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 120
    :cond_3
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v2

    .line 121
    .local v2, "url":Ljava/net/URL;
    if-eqz v2, :cond_4

    invoke-virtual {v2}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 122
    .local v1, "host":Ljava/lang/String;
    :goto_1
    sget-object v3, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Using http for "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " with auth type "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 124
    new-instance v3, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-direct {v3, p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;-><init>(Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    goto :goto_0

    .line 121
    .end local v1    # "host":Ljava/lang/String;
    :cond_4
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public static openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;
    .locals 3
    .param p0, "url"    # Ljava/net/URL;
    .param p1, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 67
    if-nez p0, :cond_0

    .line 69
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Must Specify a URL"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 72
    :cond_0
    if-nez p1, :cond_1

    .line 74
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Must Specify an Authentication Method"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 77
    :cond_1
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/security/EnhancedURLConnectionFactory;->createURLConnection(Ljava/net/URL;)Ljava/net/URLConnection;

    move-result-object v0

    .line 78
    .local v0, "connection":Ljava/net/URLConnection;
    instance-of v1, v0, Ljava/net/HttpURLConnection;

    if-nez v1, :cond_2

    .line 80
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Url must be an Https or Http Url"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 83
    :cond_2
    check-cast v0, Ljava/net/HttpURLConnection;

    .end local v0    # "connection":Ljava/net/URLConnection;
    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->openConnection(Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 346
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 347
    return-void
.end method

.method public connect()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 251
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->connect()V

    .line 252
    return-void
.end method

.method public disconnect()V
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->disconnect()V

    .line 198
    return-void
.end method

.method public getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public getCipherSuite()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getCipherSuite()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 467
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getConnectTimeout()I

    move-result v0

    return v0
.end method

.method public getContent()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 263
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getContent()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContent([Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .param p1, "types"    # [Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 269
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getContent([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContentEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getContentLength()I
    .locals 1

    .prologue
    .line 282
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getContentLength()I

    move-result v0

    return v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method getCurrentBody()[B
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getCurrentBody()[B

    move-result-object v0

    return-object v0
.end method

.method public getDate()J
    .locals 2

    .prologue
    .line 295
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getDate()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 302
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public getDoInput()Z
    .locals 1

    .prologue
    .line 308
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public getDoOutput()Z
    .locals 1

    .prologue
    .line 314
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public getErrorStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getExpiration()J
    .locals 2

    .prologue
    .line 320
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getExpiration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderField(I)Ljava/lang/String;
    .locals 1
    .param p1, "pos"    # I

    .prologue
    .line 326
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 352
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderFieldDate(Ljava/lang/String;J)J
    .locals 2
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 358
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getHeaderFieldDate(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderFieldInt(Ljava/lang/String;I)I
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 365
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getHeaderFieldInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getHeaderFieldKey(I)Ljava/lang/String;
    .locals 1
    .param p1, "posn"    # I

    .prologue
    .line 371
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderFields()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 334
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v0

    return-object v0
.end method

.method public getIfModifiedSince()J
    .locals 2

    .prologue
    .line 377
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getIfModifiedSince()J

    move-result-wide v0

    return-wide v0
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 383
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getLastModified()J
    .locals 2

    .prologue
    .line 389
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getLastModified()J

    move-result-wide v0

    return-wide v0
.end method

.method public getLocalCertificates()[Ljava/security/cert/Certificate;
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getLocalCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    return-object v0
.end method

.method public getLocalPrincipal()Ljava/security/Principal;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getLocalPrincipal()Ljava/security/Principal;

    move-result-object v0

    return-object v0
.end method

.method public getOutputStream()Ljava/io/OutputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    return-object v0
.end method

.method public getPeerPrincipal()Ljava/security/Principal;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/net/ssl/SSLPeerUnverifiedException;
        }
    .end annotation

    .prologue
    .line 185
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getPeerPrincipal()Ljava/security/Principal;

    move-result-object v0

    return-object v0
.end method

.method public getPermission()Ljava/security/Permission;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 395
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getPermission()Ljava/security/Permission;

    move-result-object v0

    return-object v0
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 479
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperties()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 340
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "field"    # Ljava/lang/String;

    .prologue
    .line 401
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getResponseCode()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 215
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getResponseCode()I

    move-result v0

    return v0
.end method

.method public getResponseMessage()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 221
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    return-object v0
.end method

.method public getServerCertificates()[Ljava/security/cert/Certificate;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/net/ssl/SSLPeerUnverifiedException;
        }
    .end annotation

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getServerCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    return-object v0
.end method

.method public getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 407
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public getUseCaches()Z
    .locals 1

    .prologue
    .line 413
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method public setAllowUserInteraction(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 419
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setAllowUserInteraction(Z)V

    .line 420
    return-void
.end method

.method public setChunkedStreamingMode(I)V
    .locals 1
    .param p1, "chunklen"    # I

    .prologue
    .line 485
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setChunkedStreamingMode(I)V

    .line 486
    return-void
.end method

.method public setConnectTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 461
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setConnectTimeout(I)V

    .line 462
    return-void
.end method

.method public setDefaultUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 425
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setDefaultUseCaches(Z)V

    .line 426
    return-void
.end method

.method public setDoInput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 431
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setDoInput(Z)V

    .line 432
    return-void
.end method

.method public setDoOutput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 437
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setDoOutput(Z)V

    .line 438
    return-void
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 1
    .param p1, "contentLength"    # I

    .prologue
    .line 491
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setFixedLengthStreamingMode(I)V

    .line 492
    return-void
.end method

.method public setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V
    .locals 1
    .param p1, "v"    # Ljavax/net/ssl/HostnameVerifier;

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 144
    return-void
.end method

.method public setIfModifiedSince(J)V
    .locals 1
    .param p1, "newValue"    # J

    .prologue
    .line 443
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setIfModifiedSince(J)V

    .line 444
    return-void
.end method

.method public setInstanceFollowRedirects(Z)V
    .locals 1
    .param p1, "followRedirects"    # Z

    .prologue
    .line 245
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setInstanceFollowRedirects(Z)V

    .line 246
    return-void
.end method

.method public setReadTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 473
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setReadTimeout(I)V

    .line 474
    return-void
.end method

.method public setRequestMethod(Ljava/lang/String;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/ProtocolException;
        }
    .end annotation

    .prologue
    .line 227
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 228
    return-void
.end method

.method public setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 449
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 450
    return-void
.end method

.method public setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V
    .locals 1
    .param p1, "sf"    # Ljavax/net/ssl/SSLSocketFactory;

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 150
    return-void
.end method

.method public setUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 455
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->setUseCaches(Z)V

    .line 456
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 497
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public usingProxy()Z
    .locals 1

    .prologue
    .line 233
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->mInnerHttpsUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->usingProxy()Z

    move-result v0

    return v0
.end method
