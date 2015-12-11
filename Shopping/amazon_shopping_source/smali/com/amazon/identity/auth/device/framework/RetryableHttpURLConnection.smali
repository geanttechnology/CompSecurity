.class Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;
.super Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;
.source "RetryableHttpURLConnection.java"


# static fields
.field private static final FIRST_RETRY_INTERVAL:I

.field private static final MAX_INTERVAL:I

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mExpBackoffHelper:Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;

.field private final mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

.field private final mRetryLogic:Lcom/amazon/identity/auth/device/framework/RetryLogic;

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->TAG:Ljava/lang/String;

    .line 23
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x1

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    long-to-int v0, v0

    sput v0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->FIRST_RETRY_INTERVAL:I

    .line 24
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0xa

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    long-to-int v0, v0

    sput v0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->MAX_INTERVAL:I

    return-void
.end method

.method constructor <init>(Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)V
    .locals 3
    .param p1, "httpConnectionBuilder"    # Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;
    .param p2, "retryLogic"    # Lcom/amazon/identity/auth/device/framework/RetryLogic;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    .line 50
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;-><init>(Ljava/net/URL;)V

    .line 52
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    .line 53
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mRetryLogic:Lcom/amazon/identity/auth/device/framework/RetryLogic;

    .line 55
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;

    sget v1, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->FIRST_RETRY_INTERVAL:I

    sget v2, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->MAX_INTERVAL:I

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;-><init>(II)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mExpBackoffHelper:Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;

    .line 56
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 57
    iput-object p4, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mContext:Landroid/content/Context;

    .line 58
    return-void
.end method

.method constructor <init>(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)V
    .locals 1
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
    .line 41
    new-instance v0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;-><init>(Ljava/net/URL;)V

    invoke-direct {p0, v0, p2, p3, p4}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;-><init>(Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)V

    .line 42
    return-void
.end method


# virtual methods
.method public addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    return-void
.end method

.method public getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getConnectTimeout()I

    move-result v0

    return v0
.end method

.method public getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public getDoInput()Z
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public getDoOutput()Z
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public getIfModifiedSince()J
    .locals 2

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getIfModifiedSince()J

    move-result-wide v0

    return-wide v0
.end method

.method public getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getOutputStream()Ljava/io/OutputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    return-object v0
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getRequestMethod()Ljava/lang/String;

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
    .line 174
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "field"    # Ljava/lang/String;

    .prologue
    .line 192
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public getUseCaches()Z
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method protected performOnConnectionRequested()Ljava/net/HttpURLConnection;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    const/4 v1, 0x0

    .line 68
    .local v1, "httpUrlConnection":Ljava/net/HttpURLConnection;
    :cond_0
    :try_start_0
    new-instance v1, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;

    .end local v1    # "httpUrlConnection":Ljava/net/HttpURLConnection;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->createConnection()Ljava/net/HttpURLConnection;

    move-result-object v3

    invoke-direct {v1, v3}, Lcom/amazon/identity/auth/device/framework/ResetableHttpURLConnection;-><init>(Ljava/net/HttpURLConnection;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    .restart local v1    # "httpUrlConnection":Ljava/net/HttpURLConnection;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mRetryLogic:Lcom/amazon/identity/auth/device/framework/RetryLogic;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mExpBackoffHelper:Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;

    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;->numberOfRetryAttempts()I

    move-result v4

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v3, v1, v4, v5}, Lcom/amazon/identity/auth/device/framework/RetryLogic;->shouldRetry(Ljava/net/HttpURLConnection;ILcom/amazon/identity/auth/device/framework/Tracer;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 82
    return-object v1

    .line 70
    .end local v1    # "httpUrlConnection":Ljava/net/HttpURLConnection;
    :catch_0
    move-exception v0

    .line 76
    .local v0, "e":Ljava/io/IOException;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->url:Ljava/net/URL;

    invoke-static {v4}, Lcom/amazon/identity/platform/metric/MetricUtils;->getIOExceptionMetricName(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 77
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->url:Ljava/net/URL;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mContext:Landroid/content/Context;

    invoke-static {v4, v0, v5}, Lcom/amazon/identity/platform/metric/MetricUtils;->getIOExceptionWithSubClassMetricName(Ljava/net/URL;Ljava/io/IOException;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 78
    throw v0

    .line 86
    .end local v0    # "e":Ljava/io/IOException;
    .restart local v1    # "httpUrlConnection":Ljava/net/HttpURLConnection;
    :cond_1
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 88
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mExpBackoffHelper:Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;->nextRetryInterval()I

    move-result v2

    .line 90
    .local v2, "waitInterval":I
    sget-object v3, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Connection failed. We will attempt to the %d retry"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mExpBackoffHelper:Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;

    invoke-virtual {v7}, Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;->numberOfRetryAttempts()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    int-to-long v3, v2

    :try_start_1
    invoke-static {v3, v4}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    .line 103
    :goto_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mExpBackoffHelper:Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/ExponentialBackoffHelper;->numberOfRetryAttempts()I

    move-result v3

    const/4 v4, 0x3

    if-lt v3, v4, :cond_0

    .line 105
    sget-object v3, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "All retries failed. Aborting request"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/platform/metric/MetricUtils;->getRetriesFailedMetricName(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 108
    new-instance v3, Ljava/io/IOException;

    const-string/jumbo v4, "Could not get a connection"

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 98
    :catch_1
    move-exception v0

    .line 100
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v3, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Backoff wait interrupted"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public setAllowUserInteraction(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 210
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setAllowUserInteraction(Z)V

    .line 211
    return-void
.end method

.method public setChunkedStreamingMode(I)V
    .locals 1
    .param p1, "chunklen"    # I

    .prologue
    .line 276
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setChunkedStreamingMode(I)V

    .line 277
    return-void
.end method

.method public setConnectTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setConnectTimeout(I)V

    .line 253
    return-void
.end method

.method public setDefaultUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 216
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setDefaultUseCaches(Z)V

    .line 217
    return-void
.end method

.method public setDoInput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 222
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setDoInput(Z)V

    .line 223
    return-void
.end method

.method public setDoOutput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 228
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setDoOutput(Z)V

    .line 229
    return-void
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 3
    .param p1, "contentLength"    # I

    .prologue
    .line 282
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    int-to-long v1, p1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setFixedLengthStreamingMode(J)V

    .line 283
    return-void
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 1
    .param p1, "contentLength"    # J

    .prologue
    .line 288
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setFixedLengthStreamingMode(J)V

    .line 289
    return-void
.end method

.method public setIfModifiedSince(J)V
    .locals 1
    .param p1, "newValue"    # J

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setIfModifiedSince(J)V

    .line 235
    return-void
.end method

.method public setInstanceFollowRedirects(Z)V
    .locals 1
    .param p1, "followRedirects"    # Z

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setInstanceFollowRedirects(Z)V

    .line 145
    return-void
.end method

.method public setReadTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 264
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setReadTimeout(I)V

    .line 265
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
    .line 126
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setRequestMethod(Ljava/lang/String;)V

    .line 127
    return-void
.end method

.method public setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 240
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    return-void
.end method

.method public setUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 246
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setUseCaches(Z)V

    .line 247
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 294
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public usingProxy()Z
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;->mHttpUrlConnectionBuilder:Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->usingProxy()Z

    move-result v0

    return v0
.end method
