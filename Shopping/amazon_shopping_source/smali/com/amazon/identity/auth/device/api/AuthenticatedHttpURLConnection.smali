.class Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;
.super Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;
.source "AuthenticatedHttpURLConnection.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

.field private final mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

.field private final mLock:[Ljava/lang/Object;

.field private mWrappedOutputStream:Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 1
    .param p1, "httpUrlConnection"    # Ljava/net/HttpURLConnection;
    .param p2, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 33
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-direct {p0, v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;-><init>(Ljava/net/URL;Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    .line 34
    return-void
.end method

.method constructor <init>(Ljava/net/URL;Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 1
    .param p1, "testUrl"    # Ljava/net/URL;
    .param p2, "connection"    # Ljava/net/HttpURLConnection;
    .param p3, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;-><init>(Ljava/net/URL;)V

    .line 26
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mLock:[Ljava/lang/Object;

    .line 43
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 44
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    .line 45
    return-void
.end method


# virtual methods
.method public addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    return-void
.end method

.method public getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getConnectTimeout()I

    move-result v0

    return v0
.end method

.method getCurrentBody()[B
    .locals 2

    .prologue
    .line 87
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 89
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mWrappedOutputStream:Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;

    if-nez v0, :cond_0

    .line 91
    const/4 v0, 0x0

    new-array v0, v0, [B

    monitor-exit v1

    .line 94
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mWrappedOutputStream:Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->getCurrentBytes()[B

    move-result-object v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 95
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public getDoInput()Z
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public getDoOutput()Z
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public getIfModifiedSince()J
    .locals 2

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getIfModifiedSince()J

    move-result-wide v0

    return-wide v0
.end method

.method public getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getOutputStream()Ljava/io/OutputStream;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 55
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 57
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mWrappedOutputStream:Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;

    if-nez v0, :cond_0

    .line 59
    new-instance v0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;-><init>(Ljava/net/URLConnection;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mWrappedOutputStream:Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mWrappedOutputStream:Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v0

    .line 63
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

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
    .line 168
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "field"    # Ljava/lang/String;

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public getUseCaches()Z
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method protected performOnConnectionRequested()Ljava/net/HttpURLConnection;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 69
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection$1;

    invoke-direct {v0, p0, p0}, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection$1;-><init>(Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;)V

    .line 78
    .local v0, "adapter":Lcom/amazon/identity/auth/request/IRequestAdapter;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mAuthMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->authenticateConnection(Lcom/amazon/identity/auth/request/IRequestAdapter;)V

    .line 80
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mLock:[Ljava/lang/Object;

    monitor-enter v2

    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mWrappedOutputStream:Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;

    if-nez v1, :cond_0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 82
    :goto_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    return-object v1

    .line 80
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mWrappedOutputStream:Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->flushToUnderlyingStream()V

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public setAllowUserInteraction(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setAllowUserInteraction(Z)V

    .line 205
    return-void
.end method

.method public setChunkedStreamingMode(I)V
    .locals 1
    .param p1, "chunklen"    # I

    .prologue
    .line 270
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setChunkedStreamingMode(I)V

    .line 271
    return-void
.end method

.method public setConnectTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 246
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 247
    return-void
.end method

.method public setDefaultUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 210
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDefaultUseCaches(Z)V

    .line 211
    return-void
.end method

.method public setDoInput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 216
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 217
    return-void
.end method

.method public setDoOutput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 222
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 223
    return-void
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 1
    .param p1, "contentLength"    # I

    .prologue
    .line 276
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    .line 277
    return-void
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 1
    .param p1, "contentLength"    # J
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    .line 283
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(J)V

    .line 284
    return-void
.end method

.method public setIfModifiedSince(J)V
    .locals 1
    .param p1, "newValue"    # J

    .prologue
    .line 228
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setIfModifiedSince(J)V

    .line 229
    return-void
.end method

.method public setInstanceFollowRedirects(Z)V
    .locals 1
    .param p1, "followRedirects"    # Z

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 139
    return-void
.end method

.method public setReadTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 259
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
    .line 120
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 121
    return-void
.end method

.method public setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    return-void
.end method

.method public setUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 240
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 241
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public usingProxy()Z
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->usingProxy()Z

    move-result v0

    return v0
.end method
