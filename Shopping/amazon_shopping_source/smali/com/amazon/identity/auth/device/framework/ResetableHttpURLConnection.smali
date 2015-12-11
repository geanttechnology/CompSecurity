.class public Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;
.super Ljava/net/HttpURLConnection;
.source "ResetableHttpURLConnection.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mErrorStreamBytes:[B

.field private mInputStreamBytes:[B

.field private mInputStreamException:Ljava/io/IOException;

.field private final mLock:[Ljava/lang/Object;

.field private final mUrlConn:Ljava/net/HttpURLConnection;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/net/HttpURLConnection;)V
    .locals 1
    .param p1, "urlConn"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 33
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/net/HttpURLConnection;-><init>(Ljava/net/URL;)V

    .line 22
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mLock:[Ljava/lang/Object;

    .line 35
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    .line 36
    return-void
.end method


# virtual methods
.method public addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 255
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
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
    .line 165
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V

    .line 166
    return-void
.end method

.method public disconnect()V
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 124
    return-void
.end method

.method public getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 369
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getConnectTimeout()I

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
    .line 177
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContent()Ljava/lang/Object;

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
    .line 183
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getContent([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContentEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getContentLength()I
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentLength()I

    move-result v0

    return v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDate()J
    .locals 2

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDate()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public getDoInput()Z
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public getDoOutput()Z
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public getErrorStream()Ljava/io/InputStream;
    .locals 4

    .prologue
    .line 75
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mLock:[Ljava/lang/Object;

    monitor-enter v2

    .line 78
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mErrorStreamBytes:[B
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 80
    const/4 v0, 0x0

    .line 83
    .local v0, "errorStream":Ljava/io/InputStream;
    :try_start_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    .line 84
    if-eqz v0, :cond_1

    .line 86
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mErrorStreamBytes:[B
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 100
    :goto_0
    :try_start_2
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    .line 104
    .end local v0    # "errorStream":Ljava/io/InputStream;
    :cond_0
    :goto_1
    new-instance v1, Ljava/io/ByteArrayInputStream;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mErrorStreamBytes:[B

    invoke-direct {v1, v3}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    return-object v1

    .line 90
    .restart local v0    # "errorStream":Ljava/io/InputStream;
    :cond_1
    :try_start_3
    sget-object v1, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "No Error Stream found"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const/4 v1, 0x0

    new-array v1, v1, [B

    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mErrorStreamBytes:[B
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_0

    .line 96
    :catch_0
    move-exception v1

    const/4 v1, 0x0

    :try_start_4
    new-array v1, v1, [B

    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mErrorStreamBytes:[B
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 100
    :try_start_5
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_1

    .line 105
    .end local v0    # "errorStream":Ljava/io/InputStream;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 100
    .restart local v0    # "errorStream":Ljava/io/InputStream;
    :catchall_1
    move-exception v1

    :try_start_6
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0
.end method

.method public getExpiration()J
    .locals 2

    .prologue
    .line 231
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getExpiration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderField(I)Ljava/lang/String;
    .locals 1
    .param p1, "pos"    # I

    .prologue
    .line 237
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 261
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaderFieldDate(Ljava/lang/String;J)J
    .locals 2
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 267
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2, p3}, Ljava/net/HttpURLConnection;->getHeaderFieldDate(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public getHeaderFieldInt(Ljava/lang/String;I)I
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 273
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->getHeaderFieldInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getHeaderFieldKey(I)Ljava/lang/String;
    .locals 1
    .param p1, "posn"    # I

    .prologue
    .line 279
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

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
    .line 243
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getIfModifiedSince()J
    .locals 2

    .prologue
    .line 285
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getIfModifiedSince()J

    move-result-wide v0

    return-wide v0
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 41
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mLock:[Ljava/lang/Object;

    monitor-enter v3

    .line 43
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamBytes:[B

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamException:Ljava/io/IOException;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_0

    .line 45
    const/4 v0, 0x0

    .line 48
    .local v0, "connStream":Ljava/io/InputStream;
    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    .line 49
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamBytes:[B
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 59
    :try_start_2
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    .line 63
    .end local v0    # "connStream":Ljava/io/InputStream;
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamException:Ljava/io/IOException;

    if-eqz v2, :cond_1

    .line 65
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamException:Ljava/io/IOException;

    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 69
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2

    .line 51
    .restart local v0    # "connStream":Ljava/io/InputStream;
    :catch_0
    move-exception v1

    .line 53
    .local v1, "e":Ljava/io/IOException;
    const/4 v2, 0x0

    :try_start_3
    new-array v2, v2, [B

    iput-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamBytes:[B

    .line 54
    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamException:Ljava/io/IOException;

    .line 55
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamException:Ljava/io/IOException;

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 59
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_1
    move-exception v2

    :try_start_4
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v2

    .line 68
    .end local v0    # "connStream":Ljava/io/InputStream;
    :cond_1
    new-instance v2, Ljava/io/ByteArrayInputStream;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mInputStreamBytes:[B

    invoke-direct {v2, v4}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    return-object v2
.end method

.method public getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getLastModified()J
    .locals 2

    .prologue
    .line 291
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getLastModified()J

    move-result-wide v0

    return-wide v0
.end method

.method public getOutputStream()Ljava/io/OutputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

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
    .line 297
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getPermission()Ljava/security/Permission;

    move-result-object v0

    return-object v0
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 381
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

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
    .line 249
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "field"    # Ljava/lang/String;

    .prologue
    .line 303
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

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
    .line 129
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

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
    .line 135
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public getUseCaches()Z
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method public setAllowUserInteraction(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 321
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setAllowUserInteraction(Z)V

    .line 322
    return-void
.end method

.method public setChunkedStreamingMode(I)V
    .locals 1
    .param p1, "chunklen"    # I

    .prologue
    .line 387
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setChunkedStreamingMode(I)V

    .line 388
    return-void
.end method

.method public setConnectTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 364
    return-void
.end method

.method public setDefaultUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 327
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDefaultUseCaches(Z)V

    .line 328
    return-void
.end method

.method public setDoInput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 333
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 334
    return-void
.end method

.method public setDoOutput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 339
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 340
    return-void
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 1
    .param p1, "contentLength"    # I

    .prologue
    .line 393
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    .line 394
    return-void
.end method

.method public setIfModifiedSince(J)V
    .locals 1
    .param p1, "newValue"    # J

    .prologue
    .line 345
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setIfModifiedSince(J)V

    .line 346
    return-void
.end method

.method public setInstanceFollowRedirects(Z)V
    .locals 1
    .param p1, "followRedirects"    # Z

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 160
    return-void
.end method

.method public setReadTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 375
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 376
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
    .line 141
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 142
    return-void
.end method

.method public setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 351
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 352
    return-void
.end method

.method public setUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 357
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 358
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public usingProxy()Z
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;->mUrlConn:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->usingProxy()Z

    move-result v0

    return v0
.end method
