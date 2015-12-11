.class Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;
.super Ljavax/net/ssl/HttpsURLConnection;
.source "RetryableHttpsURLConnection.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

.field private final mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

.field private final mRetryLogic:Lcom/amazon/identity/auth/device/framework/RetryLogic;

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)V
    .locals 3
    .param p1, "url"    # Ljava/net/URL;
    .param p2, "retryLogic"    # Lcom/amazon/identity/auth/device/framework/RetryLogic;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .param p4, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 39
    invoke-direct {p0, p1}, Ljavax/net/ssl/HttpsURLConnection;-><init>(Ljava/net/URL;)V

    .line 41
    new-instance v0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;-><init>(Ljava/net/URL;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    .line 42
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mRetryLogic:Lcom/amazon/identity/auth/device/framework/RetryLogic;

    .line 44
    new-instance v0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mRetryLogic:Lcom/amazon/identity/auth/device/framework/RetryLogic;

    invoke-direct {v0, v1, v2, p3, p4}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;-><init>(Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    .line 47
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 48
    return-void
.end method


# virtual methods
.method public addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 270
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 271
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
    .line 168
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->connect()V

    .line 169
    return-void
.end method

.method public disconnect()V
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->disconnect()V

    .line 115
    return-void
.end method

.method public getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public getCipherSuite()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->getCipherSuite()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getConnectTimeout()I

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
    .line 180
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getContent()Ljava/lang/Object;

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
    .line 186
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getContent([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContentEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getContentLength()I
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getContentLength()I

    move-result v0

    return v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDate()J
    .locals 2

    .prologue
    .line 217
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getDate()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public getDoInput()Z
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public getDoOutput()Z
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public getErrorStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getExpiration()J
    .locals 2

    .prologue
    .line 242
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getExpiration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderField(I)Ljava/lang/String;
    .locals 1
    .param p1, "pos"    # I

    .prologue
    .line 249
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 277
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderFieldDate(Ljava/lang/String;J)J
    .locals 2
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 285
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getHeaderFieldDate(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderFieldInt(Ljava/lang/String;I)I
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 293
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getHeaderFieldInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getHeaderFieldKey(I)Ljava/lang/String;
    .locals 1
    .param p1, "posn"    # I

    .prologue
    .line 301
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

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
    .line 257
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v0

    return-object v0
.end method

.method public getIfModifiedSince()J
    .locals 2

    .prologue
    .line 308
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getIfModifiedSince()J

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
    .line 314
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getLastModified()J
    .locals 2

    .prologue
    .line 320
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getLastModified()J

    move-result-wide v0

    return-wide v0
.end method

.method public getLocalCertificates()[Ljava/security/cert/Certificate;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->getLocalCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    return-object v0
.end method

.method public getLocalPrincipal()Ljava/security/Principal;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->getLocalPrincipal()Ljava/security/Principal;

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
    .line 53
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

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
    .line 102
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->getPeerPrincipal()Ljava/security/Principal;

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
    .line 327
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getPermission()Ljava/security/Permission;

    move-result-object v0

    return-object v0
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 411
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getRequestMethod()Ljava/lang/String;

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
    .line 264
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "field"    # Ljava/lang/String;

    .prologue
    .line 333
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

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
    .line 132
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getResponseCode()I

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
    .line 138
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

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
    .line 96
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->getServerCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    return-object v0
.end method

.method public getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 339
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public getUseCaches()Z
    .locals 1

    .prologue
    .line 345
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method public setAllowUserInteraction(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 351
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setAllowUserInteraction(Z)V

    .line 352
    return-void
.end method

.method public setChunkedStreamingMode(I)V
    .locals 1
    .param p1, "chunklen"    # I

    .prologue
    .line 417
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setChunkedStreamingMode(I)V

    .line 418
    return-void
.end method

.method public setConnectTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 393
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setConnectTimeout(I)V

    .line 394
    return-void
.end method

.method public setDefaultUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 357
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setDefaultUseCaches(Z)V

    .line 358
    return-void
.end method

.method public setDoInput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setDoInput(Z)V

    .line 364
    return-void
.end method

.method public setDoOutput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 369
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setDoOutput(Z)V

    .line 370
    return-void
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 1
    .param p1, "contentLength"    # I

    .prologue
    .line 423
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setFixedLengthStreamingMode(I)V

    .line 424
    return-void
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 1
    .param p1, "contentLength"    # J
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    .line 430
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setFixedLengthStreamingMode(J)V

    .line 431
    return-void
.end method

.method public setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V
    .locals 1
    .param p1, "v"    # Ljavax/net/ssl/HostnameVerifier;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 61
    return-void
.end method

.method public setIfModifiedSince(J)V
    .locals 1
    .param p1, "newValue"    # J

    .prologue
    .line 375
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setIfModifiedSince(J)V

    .line 376
    return-void
.end method

.method public setInstanceFollowRedirects(Z)V
    .locals 1
    .param p1, "followRedirects"    # Z

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 163
    return-void
.end method

.method public setReadTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 405
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setReadTimeout(I)V

    .line 406
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
    .line 144
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 145
    return-void
.end method

.method public setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 381
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    return-void
.end method

.method public setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V
    .locals 1
    .param p1, "sf"    # Ljavax/net/ssl/SSLSocketFactory;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mHttpsUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 67
    return-void
.end method

.method public setUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 387
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->setUseCaches(Z)V

    .line 388
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 436
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public usingProxy()Z
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;->mInnerHttpUrlConnection:Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->usingProxy()Z

    move-result v0

    return v0
.end method
