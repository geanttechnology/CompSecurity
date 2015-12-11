.class public abstract Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;
.super Ljava/net/HttpURLConnection;
.source "WrappableHttpURLConnection.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$1;,
        Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mConnectionInitiator:Ljava/lang/Throwable;

.field private mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

.field private final mLock:[Ljava/lang/Object;

.field private mState:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Ljava/net/URL;)V
    .locals 1
    .param p1, "url"    # Ljava/net/URL;

    .prologue
    .line 42
    invoke-direct {p0, p1}, Ljava/net/HttpURLConnection;-><init>(Ljava/net/URL;)V

    .line 31
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mLock:[Ljava/lang/Object;

    .line 35
    sget-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Initial:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mState:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    .line 36
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mConnectionInitiator:Ljava/lang/Throwable;

    .line 43
    return-void
.end method

.method private onConnectionRequested()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 47
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 49
    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$1;->$SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState:[I

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mState:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->ordinal()I

    move-result v2

    aget v0, v0, v2

    packed-switch v0, :pswitch_data_0

    .line 62
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Connection is in unknown state:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mState:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 64
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 52
    :pswitch_0
    :try_start_1
    new-instance v0, Ljava/lang/Throwable;

    invoke-direct {v0}, Ljava/lang/Throwable;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mConnectionInitiator:Ljava/lang/Throwable;

    .line 53
    sget-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Connecting:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mState:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    .line 64
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 66
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->performOnConnectionRequested()Ljava/net/HttpURLConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    .line 68
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    if-nez v0, :cond_0

    .line 70
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "Connection could not be established"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :pswitch_1
    :try_start_2
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Connection is being established. Connection initiated from:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mConnectionInitiator:Ljava/lang/Throwable;

    invoke-static {v3}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 60
    :pswitch_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 76
    :goto_0
    return-void

    .line 73
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 75
    :try_start_3
    sget-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Connected:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mState:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    .line 76
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_0

    :catchall_1
    move-exception v0

    monitor-exit v1

    throw v0

    .line 49
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public abstract addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public connect()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 141
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 142
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V

    .line 143
    return-void
.end method

.method public disconnect()V
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mState:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Connected:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    if-ne v0, v1, :cond_0

    .line 89
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 91
    :cond_0
    return-void
.end method

.method public abstract getAllowUserInteraction()Z
.end method

.method public abstract getConnectTimeout()I
.end method

.method public getContent()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 151
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 152
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

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
    .line 158
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 159
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getContent([Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContentEncoding()Ljava/lang/String;
    .locals 3

    .prologue
    .line 167
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 168
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getContentEncoding()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 175
    :goto_0
    return-object v1

    .line 170
    :catch_0
    move-exception v0

    .line 172
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get Content Encoding"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 175
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getContentLength()I
    .locals 3

    .prologue
    .line 183
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 184
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getContentLength()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 191
    :goto_0
    return v1

    .line 186
    :catch_0
    move-exception v0

    .line 188
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get Content Length"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 191
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 3

    .prologue
    .line 199
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 200
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 207
    :goto_0
    return-object v1

    .line 202
    :catch_0
    move-exception v0

    .line 204
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get Content Type"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 207
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getDate()J
    .locals 3

    .prologue
    .line 215
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 216
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getDate()J
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v1

    .line 223
    :goto_0
    return-wide v1

    .line 218
    :catch_0
    move-exception v0

    .line 220
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get Date"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 223
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public abstract getDefaultUseCaches()Z
.end method

.method public abstract getDoInput()Z
.end method

.method public abstract getDoOutput()Z
.end method

.method public getErrorStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    .line 105
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getExpiration()J
    .locals 3

    .prologue
    .line 240
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 241
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getExpiration()J
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v1

    .line 248
    :goto_0
    return-wide v1

    .line 243
    :catch_0
    move-exception v0

    .line 245
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get expiration"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 248
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public getHeaderField(I)Ljava/lang/String;
    .locals 3
    .param p1, "pos"    # I

    .prologue
    .line 256
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 257
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1, p1}, Ljava/net/HttpURLConnection;->getHeaderField(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 264
    :goto_0
    return-object v1

    .line 259
    :catch_0
    move-exception v0

    .line 261
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get header field"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 264
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 294
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 295
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1, p1}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 302
    :goto_0
    return-object v1

    .line 297
    :catch_0
    move-exception v0

    .line 299
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get header field"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 302
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getHeaderFieldDate(Ljava/lang/String;J)J
    .locals 3
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 310
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 311
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1, p1, p2, p3}, Ljava/net/HttpURLConnection;->getHeaderFieldDate(Ljava/lang/String;J)J
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide p2

    .line 318
    .end local p2    # "defaultValue":J
    :goto_0
    return-wide p2

    .line 313
    .restart local p2    # "defaultValue":J
    :catch_0
    move-exception v0

    .line 315
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get header field date"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getHeaderFieldInt(Ljava/lang/String;I)I
    .locals 3
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 326
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 327
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1, p1, p2}, Ljava/net/HttpURLConnection;->getHeaderFieldInt(Ljava/lang/String;I)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result p2

    .line 334
    .end local p2    # "defaultValue":I
    :goto_0
    return p2

    .line 329
    .restart local p2    # "defaultValue":I
    :catch_0
    move-exception v0

    .line 331
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get header field int"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getHeaderFieldKey(I)Ljava/lang/String;
    .locals 3
    .param p1, "posn"    # I

    .prologue
    .line 342
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 343
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1, p1}, Ljava/net/HttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 350
    :goto_0
    return-object v1

    .line 345
    :catch_0
    move-exception v0

    .line 347
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get header field key"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 350
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getHeaderFields()Ljava/util/Map;
    .locals 3
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
    .line 272
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 273
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 280
    :goto_0
    return-object v1

    .line 275
    :catch_0
    move-exception v0

    .line 277
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get header fields"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 280
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    goto :goto_0
.end method

.method public abstract getIfModifiedSince()J
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 359
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 360
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public abstract getInstanceFollowRedirects()Z
.end method

.method public getLastModified()J
    .locals 3

    .prologue
    .line 368
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 369
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getLastModified()J
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v1

    .line 376
    :goto_0
    return-wide v1

    .line 371
    :catch_0
    move-exception v0

    .line 373
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not get last modified date"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 376
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public abstract getOutputStream()Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public getPermission()Ljava/security/Permission;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 382
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 383
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getPermission()Ljava/security/Permission;

    move-result-object v0

    return-object v0
.end method

.method public abstract getReadTimeout()I
.end method

.method public abstract getRequestMethod()Ljava/lang/String;
.end method

.method public abstract getRequestProperties()Ljava/util/Map;
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
.end method

.method public abstract getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public getResponseCode()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 115
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 116
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

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
    .line 122
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->onConnectionRequested()V

    .line 123
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;->mInnerHttpUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public abstract getURL()Ljava/net/URL;
.end method

.method public abstract getUseCaches()Z
.end method

.method protected abstract performOnConnectionRequested()Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract setAllowUserInteraction(Z)V
.end method

.method public abstract setChunkedStreamingMode(I)V
.end method

.method public abstract setConnectTimeout(I)V
.end method

.method public abstract setDefaultUseCaches(Z)V
.end method

.method public abstract setDoInput(Z)V
.end method

.method public abstract setDoOutput(Z)V
.end method

.method public abstract setFixedLengthStreamingMode(I)V
.end method

.method public abstract setFixedLengthStreamingMode(J)V
.end method

.method public abstract setIfModifiedSince(J)V
.end method

.method public abstract setInstanceFollowRedirects(Z)V
.end method

.method public abstract setReadTimeout(I)V
.end method

.method public abstract setRequestMethod(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/ProtocolException;
        }
    .end annotation
.end method

.method public abstract setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract setUseCaches(Z)V
.end method

.method public abstract toString()Ljava/lang/String;
.end method

.method public abstract usingProxy()Z
.end method
