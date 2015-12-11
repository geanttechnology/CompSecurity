.class public final Lcom/a/a/a/a/r;
.super Ljavax/net/ssl/HttpsURLConnection;
.source "SourceFile"


# instance fields
.field public final a:Lcom/a/a/a/a/s;


# direct methods
.method public constructor <init>(Ljava/net/URL;Lcom/a/a/r;)V
    .locals 2

    .prologue
    .line 44
    invoke-direct {p0, p1}, Ljavax/net/ssl/HttpsURLConnection;-><init>(Ljava/net/URL;)V

    .line 45
    new-instance v0, Lcom/a/a/a/a/s;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/a/a/a/a/s;-><init>(Lcom/a/a/a/a/r;Ljava/net/URL;Lcom/a/a/r;B)V

    iput-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    .line 46
    return-void
.end method

.method private a()Ljavax/net/ssl/SSLSocket;
    .locals 4

    .prologue
    .line 115
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    iget-object v0, v0, Lcom/a/a/a/a/s;->c:Lcom/a/a/a/a/h;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    iget-object v0, v0, Lcom/a/a/a/a/s;->c:Lcom/a/a/a/a/h;

    iget-wide v0, v0, Lcom/a/a/a/a/h;->g:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    .line 116
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Connection has not yet been established"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 118
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    iget-object v0, v0, Lcom/a/a/a/a/s;->c:Lcom/a/a/a/a/h;

    instance-of v0, v0, Lcom/a/a/a/a/q;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    iget-object v0, v0, Lcom/a/a/a/a/s;->c:Lcom/a/a/a/a/h;

    check-cast v0, Lcom/a/a/a/a/q;

    iget-object v0, v0, Lcom/a/a/a/a/q;->k:Ljavax/net/ssl/SSLSocket;

    :goto_0
    return-object v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1, p2}, Lcom/a/a/a/a/s;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    return-void
.end method

.method public final connect()V
    .locals 1

    .prologue
    .line 160
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/r;->connected:Z

    .line 161
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->connect()V

    .line 162
    return-void
.end method

.method public final disconnect()V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->disconnect()V

    .line 125
    return-void
.end method

.method public final getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public final getCipherSuite()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->e()Ljava/net/SecureCacheResponse;

    move-result-object v0

    .line 50
    if-eqz v0, :cond_0

    .line 51
    invoke-virtual {v0}, Ljava/net/SecureCacheResponse;->getCipherSuite()Ljava/lang/String;

    move-result-object v0

    .line 57
    :goto_0
    return-object v0

    .line 53
    :cond_0
    invoke-direct {p0}, Lcom/a/a/a/a/r;->a()Ljavax/net/ssl/SSLSocket;

    move-result-object v0

    .line 54
    if-eqz v0, :cond_1

    .line 55
    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    invoke-interface {v0}, Ljavax/net/ssl/SSLSession;->getCipherSuite()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 57
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getConnectTimeout()I
    .locals 1

    .prologue
    .line 306
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getConnectTimeout()I

    move-result v0

    return v0
.end method

.method public final getContent()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getContent()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final getContent([Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->getContent([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final getContentEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getContentEncoding()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getContentLength()I
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getContentLength()I

    move-result v0

    return v0
.end method

.method public final getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getContentType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getDate()J
    .locals 2

    .prologue
    .line 190
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getDate()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public final getDoInput()Z
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public final getDoOutput()Z
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public final getErrorStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public final getExpiration()J
    .locals 2

    .prologue
    .line 206
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getExpiration()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getHeaderField(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->getHeaderField(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getHeaderFieldDate(Ljava/lang/String;J)J
    .locals 2

    .prologue
    .line 230
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1, p2, p3}, Lcom/a/a/a/a/s;->getHeaderFieldDate(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public final getHeaderFieldInt(Ljava/lang/String;I)I
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1, p2}, Lcom/a/a/a/a/s;->getHeaderFieldInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public final getHeaderFieldKey(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->getHeaderFieldKey(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getHeaderFields()Ljava/util/Map;
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
    .line 214
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getHeaderFields()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    iget-object v0, v0, Lcom/a/a/a/a/s;->a:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->h:Ljavax/net/ssl/HostnameVerifier;

    return-object v0
.end method

.method public final getIfModifiedSince()J
    .locals 2

    .prologue
    .line 242
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getIfModifiedSince()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getInputStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public final getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public final getLastModified()J
    .locals 2

    .prologue
    .line 250
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getLastModified()J

    move-result-wide v0

    return-wide v0
.end method

.method public final getLocalCertificates()[Ljava/security/cert/Certificate;
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 61
    iget-object v1, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v1}, Lcom/a/a/a/a/s;->e()Ljava/net/SecureCacheResponse;

    move-result-object v1

    .line 62
    if-eqz v1, :cond_1

    .line 63
    invoke-virtual {v1}, Ljava/net/SecureCacheResponse;->getLocalCertificateChain()Ljava/util/List;

    move-result-object v1

    .line 64
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Ljava/security/cert/Certificate;

    invoke-interface {v1, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/security/cert/Certificate;

    .line 70
    :cond_0
    :goto_0
    return-object v0

    .line 66
    :cond_1
    invoke-direct {p0}, Lcom/a/a/a/a/r;->a()Ljavax/net/ssl/SSLSocket;

    move-result-object v1

    .line 67
    if-eqz v1, :cond_0

    .line 68
    invoke-virtual {v1}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    invoke-interface {v0}, Ljavax/net/ssl/SSLSession;->getLocalCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    goto :goto_0
.end method

.method public final getLocalPrincipal()Ljava/security/Principal;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->e()Ljava/net/SecureCacheResponse;

    move-result-object v0

    .line 100
    if-eqz v0, :cond_0

    .line 101
    invoke-virtual {v0}, Ljava/net/SecureCacheResponse;->getLocalPrincipal()Ljava/security/Principal;

    move-result-object v0

    .line 107
    :goto_0
    return-object v0

    .line 103
    :cond_0
    invoke-direct {p0}, Lcom/a/a/a/a/r;->a()Ljavax/net/ssl/SSLSocket;

    move-result-object v0

    .line 104
    if-eqz v0, :cond_1

    .line 105
    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    invoke-interface {v0}, Ljavax/net/ssl/SSLSession;->getLocalPrincipal()Ljava/security/Principal;

    move-result-object v0

    goto :goto_0

    .line 107
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getOutputStream()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    return-object v0
.end method

.method public final getPeerPrincipal()Ljava/security/Principal;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->e()Ljava/net/SecureCacheResponse;

    move-result-object v0

    .line 88
    if-eqz v0, :cond_0

    .line 89
    invoke-virtual {v0}, Ljava/net/SecureCacheResponse;->getPeerPrincipal()Ljava/security/Principal;

    move-result-object v0

    .line 95
    :goto_0
    return-object v0

    .line 91
    :cond_0
    invoke-direct {p0}, Lcom/a/a/a/a/r;->a()Ljavax/net/ssl/SSLSocket;

    move-result-object v0

    .line 92
    if-eqz v0, :cond_1

    .line 93
    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    invoke-interface {v0}, Ljavax/net/ssl/SSLSession;->getPeerPrincipal()Ljava/security/Principal;

    move-result-object v0

    goto :goto_0

    .line 95
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getPermission()Ljava/security/Permission;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getPermission()Ljava/security/Permission;

    move-result-object v0

    return-object v0
.end method

.method public final getReadTimeout()I
    .locals 1

    .prologue
    .line 314
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public final getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getRequestProperties()Ljava/util/Map;
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
    .line 218
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 262
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getResponseCode()I
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getResponseCode()I

    move-result v0

    return v0
.end method

.method public final getResponseMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getResponseMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    iget-object v0, v0, Lcom/a/a/a/a/s;->a:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->g:Ljavax/net/ssl/SSLSocketFactory;

    return-object v0
.end method

.method public final getServerCertificates()[Ljava/security/cert/Certificate;
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 74
    iget-object v1, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v1}, Lcom/a/a/a/a/s;->e()Ljava/net/SecureCacheResponse;

    move-result-object v1

    .line 75
    if-eqz v1, :cond_1

    .line 76
    invoke-virtual {v1}, Ljava/net/SecureCacheResponse;->getServerCertificateChain()Ljava/util/List;

    move-result-object v1

    .line 77
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Ljava/security/cert/Certificate;

    invoke-interface {v1, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/security/cert/Certificate;

    .line 83
    :cond_0
    :goto_0
    return-object v0

    .line 79
    :cond_1
    invoke-direct {p0}, Lcom/a/a/a/a/r;->a()Ljavax/net/ssl/SSLSocket;

    move-result-object v1

    .line 80
    if-eqz v1, :cond_0

    .line 81
    invoke-virtual {v1}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v0

    invoke-interface {v0}, Ljavax/net/ssl/SSLSession;->getPeerCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    goto :goto_0
.end method

.method public final getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public final getUseCaches()Z
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method public final setAllowUserInteraction(Z)V
    .locals 1

    .prologue
    .line 274
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setAllowUserInteraction(Z)V

    .line 275
    return-void
.end method

.method public final setChunkedStreamingMode(I)V
    .locals 1

    .prologue
    .line 326
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setChunkedStreamingMode(I)V

    .line 327
    return-void
.end method

.method public final setConnectTimeout(I)V
    .locals 1

    .prologue
    .line 302
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setConnectTimeout(I)V

    .line 303
    return-void
.end method

.method public final setDefaultUseCaches(Z)V
    .locals 1

    .prologue
    .line 278
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setDefaultUseCaches(Z)V

    .line 279
    return-void
.end method

.method public final setDoInput(Z)V
    .locals 1

    .prologue
    .line 282
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setDoInput(Z)V

    .line 283
    return-void
.end method

.method public final setDoOutput(Z)V
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setDoOutput(Z)V

    .line 287
    return-void
.end method

.method public final setFixedLengthStreamingMode(I)V
    .locals 1

    .prologue
    .line 322
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setFixedLengthStreamingMode(I)V

    .line 323
    return-void
.end method

.method public final setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    iget-object v0, v0, Lcom/a/a/a/a/s;->a:Lcom/a/a/r;

    iput-object p1, v0, Lcom/a/a/r;->h:Ljavax/net/ssl/HostnameVerifier;

    .line 331
    return-void
.end method

.method public final setIfModifiedSince(J)V
    .locals 1

    .prologue
    .line 290
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1, p2}, Lcom/a/a/a/a/s;->setIfModifiedSince(J)V

    .line 291
    return-void
.end method

.method public final setInstanceFollowRedirects(Z)V
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setInstanceFollowRedirects(Z)V

    .line 157
    return-void
.end method

.method public final setReadTimeout(I)V
    .locals 1

    .prologue
    .line 310
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setReadTimeout(I)V

    .line 311
    return-void
.end method

.method public final setRequestMethod(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setRequestMethod(Ljava/lang/String;)V

    .line 145
    return-void
.end method

.method public final setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 294
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1, p2}, Lcom/a/a/a/a/s;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 295
    return-void
.end method

.method public final setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    iget-object v0, v0, Lcom/a/a/a/a/s;->a:Lcom/a/a/r;

    iput-object p1, v0, Lcom/a/a/r;->g:Ljavax/net/ssl/SSLSocketFactory;

    .line 339
    return-void
.end method

.method public final setUseCaches(Z)V
    .locals 1

    .prologue
    .line 298
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/s;->setUseCaches(Z)V

    .line 299
    return-void
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 318
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final usingProxy()Z
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/a/a/a/a/r;->a:Lcom/a/a/a/a/s;

    invoke-virtual {v0}, Lcom/a/a/a/a/s;->usingProxy()Z

    move-result v0

    return v0
.end method
