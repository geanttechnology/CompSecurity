.class Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;
.super Ljavax/net/ssl/HttpsURLConnection;
.source "AuthenticatedHttpsURLConnection.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

.field private final mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

.field private final mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Ljava/net/URL;Ljavax/net/ssl/HttpsURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 1
    .param p1, "testUrl"    # Ljava/net/URL;
    .param p2, "connection"    # Ljavax/net/ssl/HttpsURLConnection;
    .param p3, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Ljavax/net/ssl/HttpsURLConnection;-><init>(Ljava/net/URL;)V

    .line 45
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 46
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    .line 48
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;-><init>(Ljava/net/URL;Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    .line 49
    return-void
.end method

.method constructor <init>(Ljavax/net/ssl/HttpsURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 1
    .param p1, "httpsUrlConnection"    # Ljavax/net/ssl/HttpsURLConnection;
    .param p2, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 35
    invoke-virtual {p1}, Ljavax/net/ssl/HttpsURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-direct {p0, v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;-><init>(Ljava/net/URL;Ljavax/net/ssl/HttpsURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    .line 36
    return-void
.end method


# virtual methods
.method public addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 276
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 277
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
    .line 174
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->connect()V

    .line 175
    return-void
.end method

.method public disconnect()V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->disconnect()V

    .line 121
    return-void
.end method

.method public getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public getCipherSuite()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getCipherSuite()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 405
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getConnectTimeout()I

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
    .line 186
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getContent()Ljava/lang/Object;

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
    .line 192
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getContent([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContentEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getContentLength()I
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getContentLength()I

    move-result v0

    return v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method getCurrentBody()[B
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getCurrentBody()[B

    move-result-object v0

    return-object v0
.end method

.method public getDate()J
    .locals 2

    .prologue
    .line 223
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getDate()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public getDoInput()Z
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public getDoOutput()Z
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public getErrorStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getExpiration()J
    .locals 2

    .prologue
    .line 248
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getExpiration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderField(I)Ljava/lang/String;
    .locals 1
    .param p1, "pos"    # I

    .prologue
    .line 255
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 283
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderFieldDate(Ljava/lang/String;J)J
    .locals 2
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 291
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getHeaderFieldDate(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderFieldInt(Ljava/lang/String;I)I
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 299
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getHeaderFieldInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getHeaderFieldKey(I)Ljava/lang/String;
    .locals 1
    .param p1, "posn"    # I

    .prologue
    .line 307
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

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
    .line 263
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v0

    return-object v0
.end method

.method public getIfModifiedSince()J
    .locals 2

    .prologue
    .line 314
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getIfModifiedSince()J

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
    .line 320
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getLastModified()J
    .locals 2

    .prologue
    .line 326
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getLastModified()J

    move-result-wide v0

    return-wide v0
.end method

.method public getLocalCertificates()[Ljava/security/cert/Certificate;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getLocalCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    return-object v0
.end method

.method public getLocalPrincipal()Ljava/security/Principal;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getLocalPrincipal()Ljava/security/Principal;

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
    .line 59
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

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
    .line 108
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getPeerPrincipal()Ljava/security/Principal;

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
    .line 333
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getPermission()Ljava/security/Permission;

    move-result-object v0

    return-object v0
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 417
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getRequestMethod()Ljava/lang/String;

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
    .line 270
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "field"    # Ljava/lang/String;

    .prologue
    .line 339
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

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
    .line 138
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getResponseCode()I

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
    .line 144
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

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
    .line 102
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getServerCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    return-object v0
.end method

.method public getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 345
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public getUseCaches()Z
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method public setAllowUserInteraction(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 357
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setAllowUserInteraction(Z)V

    .line 358
    return-void
.end method

.method public setChunkedStreamingMode(I)V
    .locals 1
    .param p1, "chunklen"    # I

    .prologue
    .line 423
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setChunkedStreamingMode(I)V

    .line 424
    return-void
.end method

.method public setConnectTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 399
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setConnectTimeout(I)V

    .line 400
    return-void
.end method

.method public setDefaultUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setDefaultUseCaches(Z)V

    .line 364
    return-void
.end method

.method public setDoInput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 369
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setDoInput(Z)V

    .line 370
    return-void
.end method

.method public setDoOutput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 375
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setDoOutput(Z)V

    .line 376
    return-void
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 1
    .param p1, "contentLength"    # I

    .prologue
    .line 429
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setFixedLengthStreamingMode(I)V

    .line 430
    return-void
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 1
    .param p1, "contentLength"    # J
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    .line 436
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setFixedLengthStreamingMode(J)V

    .line 437
    return-void
.end method

.method public setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V
    .locals 1
    .param p1, "v"    # Ljavax/net/ssl/HostnameVerifier;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0, p1}, Ljavax/net/ssl/HttpsURLConnection;->setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 67
    return-void
.end method

.method public setIfModifiedSince(J)V
    .locals 1
    .param p1, "newValue"    # J

    .prologue
    .line 381
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setIfModifiedSince(J)V

    .line 382
    return-void
.end method

.method public setInstanceFollowRedirects(Z)V
    .locals 1
    .param p1, "followRedirects"    # Z

    .prologue
    .line 168
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 169
    return-void
.end method

.method public setReadTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 411
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setReadTimeout(I)V

    .line 412
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
    .line 150
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 151
    return-void
.end method

.method public setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 387
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 388
    return-void
.end method

.method public setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V
    .locals 1
    .param p1, "sf"    # Ljavax/net/ssl/SSLSocketFactory;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpsUrlConnection:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0, p1}, Ljavax/net/ssl/HttpsURLConnection;->setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 73
    return-void
.end method

.method public setUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 393
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->setUseCaches(Z)V

    .line 394
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 442
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public usingProxy()Z
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->usingProxy()Z

    move-result v0

    return v0
.end method
