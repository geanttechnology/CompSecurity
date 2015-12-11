.class Lcom/facebook/widget/ImageDownloader;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final CACHE_READ_QUEUE_MAX_CONCURRENT:I = 0x2

.field private static final DOWNLOAD_QUEUE_MAX_CONCURRENT:I = 0x8

.field private static cacheReadQueue:Lcom/facebook/widget/WorkQueue;

.field private static downloadQueue:Lcom/facebook/widget/WorkQueue;

.field private static final handler:Landroid/os/Handler;

.field private static final pendingRequests:Ljava/util/Map;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 36
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    sput-object v0, Lcom/facebook/widget/ImageDownloader;->handler:Landroid/os/Handler;

    .line 37
    new-instance v0, Lcom/facebook/widget/WorkQueue;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Lcom/facebook/widget/WorkQueue;-><init>(I)V

    sput-object v0, Lcom/facebook/widget/ImageDownloader;->downloadQueue:Lcom/facebook/widget/WorkQueue;

    .line 38
    new-instance v0, Lcom/facebook/widget/WorkQueue;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Lcom/facebook/widget/WorkQueue;-><init>(I)V

    sput-object v0, Lcom/facebook/widget/ImageDownloader;->cacheReadQueue:Lcom/facebook/widget/WorkQueue;

    .line 40
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 328
    return-void
.end method

.method static synthetic access$100(Lcom/facebook/widget/ImageDownloader$RequestKey;Landroid/content/Context;Z)V
    .locals 0

    .prologue
    .line 33
    invoke-static {p0, p1, p2}, Lcom/facebook/widget/ImageDownloader;->readFromCache(Lcom/facebook/widget/ImageDownloader$RequestKey;Landroid/content/Context;Z)V

    return-void
.end method

.method static synthetic access$200(Lcom/facebook/widget/ImageDownloader$RequestKey;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 33
    invoke-static {p0, p1}, Lcom/facebook/widget/ImageDownloader;->download(Lcom/facebook/widget/ImageDownloader$RequestKey;Landroid/content/Context;)V

    return-void
.end method

.method static cancelRequest(Lcom/facebook/widget/ImageRequest;)Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 71
    const/4 v2, 0x0

    .line 72
    new-instance v3, Lcom/facebook/widget/ImageDownloader$RequestKey;

    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->getImageUrl()Ljava/net/URL;

    move-result-object v0

    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->getCallerTag()Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v3, v0, v4}, Lcom/facebook/widget/ImageDownloader$RequestKey;-><init>(Ljava/net/URL;Ljava/lang/Object;)V

    .line 73
    sget-object v4, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    monitor-enter v4

    .line 74
    :try_start_0
    sget-object v0, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;

    .line 75
    if-eqz v0, :cond_1

    .line 81
    iget-object v2, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->workItem:Lcom/facebook/widget/WorkQueue$WorkItem;

    invoke-interface {v2}, Lcom/facebook/widget/WorkQueue$WorkItem;->cancel()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 82
    sget-object v0, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    invoke-interface {v0, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move v0, v1

    .line 89
    :goto_0
    monitor-exit v4

    .line 91
    return v0

    .line 86
    :cond_0
    const/4 v2, 0x1

    iput-boolean v2, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->isCancelled:Z

    move v0, v1

    goto :goto_0

    .line 89
    :catchall_0
    move-exception v0

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    move v0, v2

    goto :goto_0
.end method

.method private static download(Lcom/facebook/widget/ImageDownloader$RequestKey;Landroid/content/Context;)V
    .locals 11

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 199
    .line 203
    const/4 v1, 0x1

    .line 206
    :try_start_0
    iget-object v0, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->url:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 207
    const/4 v4, 0x0

    :try_start_1
    invoke-virtual {v0, v4}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 209
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v4

    sparse-switch v4, :sswitch_data_0

    .line 239
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-result-object v5

    .line 240
    :try_start_2
    new-instance v4, Ljava/io/InputStreamReader;

    invoke-direct {v4, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 241
    const/16 v6, 0x80

    new-array v6, v6, [C

    .line 243
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 244
    :goto_0
    const/4 v8, 0x0

    array-length v9, v6

    invoke-virtual {v4, v6, v8, v9}, Ljava/io/InputStreamReader;->read([CII)I

    move-result v8

    if-lez v8, :cond_2

    .line 245
    const/4 v9, 0x0

    invoke-virtual {v7, v6, v9, v8}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 252
    :catch_0
    move-exception v4

    move-object v10, v4

    move-object v4, v0

    move-object v0, v10

    .line 255
    :goto_1
    invoke-static {v5}, Lcom/facebook/internal/Utility;->closeQuietly(Ljava/io/Closeable;)V

    .line 256
    invoke-static {v4}, Lcom/facebook/internal/Utility;->disconnectQuietly(Ljava/net/URLConnection;)V

    move-object v4, v0

    .line 259
    :goto_2
    if-eqz v1, :cond_0

    .line 260
    invoke-static {p0, v4, v3, v2}, Lcom/facebook/widget/ImageDownloader;->issueResponse(Lcom/facebook/widget/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V

    .line 262
    :cond_0
    return-void

    .line 215
    :sswitch_0
    :try_start_3
    const-string v1, "location"

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 216
    invoke-static {v1}, Lcom/facebook/internal/Utility;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 217
    new-instance v4, Ljava/net/URL;

    invoke-direct {v4, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 218
    iget-object v1, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->url:Ljava/net/URL;

    invoke-static {p1, v1, v4}, Lcom/facebook/widget/UrlRedirectCache;->cacheUrlRedirect(Landroid/content/Context;Ljava/net/URL;Ljava/net/URL;)V

    .line 222
    invoke-static {p0}, Lcom/facebook/widget/ImageDownloader;->removePendingRequest(Lcom/facebook/widget/ImageDownloader$RequestKey;)Lcom/facebook/widget/ImageDownloader$DownloaderContext;

    move-result-object v1

    .line 223
    if-eqz v1, :cond_1

    iget-boolean v5, v1, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->isCancelled:Z

    if-nez v5, :cond_1

    .line 224
    iget-object v1, v1, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->request:Lcom/facebook/widget/ImageRequest;

    new-instance v5, Lcom/facebook/widget/ImageDownloader$RequestKey;

    iget-object v6, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->tag:Ljava/lang/Object;

    invoke-direct {v5, v4, v6}, Lcom/facebook/widget/ImageDownloader$RequestKey;-><init>(Ljava/net/URL;Ljava/lang/Object;)V

    const/4 v4, 0x0

    invoke-static {v1, v5, v4}, Lcom/facebook/widget/ImageDownloader;->enqueueCacheRead(Lcom/facebook/widget/ImageRequest;Lcom/facebook/widget/ImageDownloader$RequestKey;Z)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    :cond_1
    move v1, v2

    move-object v4, v3

    move-object v5, v3

    .line 255
    :goto_3
    invoke-static {v5}, Lcom/facebook/internal/Utility;->closeQuietly(Ljava/io/Closeable;)V

    .line 256
    invoke-static {v0}, Lcom/facebook/internal/Utility;->disconnectQuietly(Ljava/net/URLConnection;)V

    goto :goto_2

    .line 234
    :sswitch_1
    :try_start_4
    invoke-static {p1, v0}, Lcom/facebook/widget/ImageResponseCache;->interceptAndCacheImageStream(Landroid/content/Context;Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-result-object v5

    .line 235
    :try_start_5
    invoke-static {v5}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v4

    move-object v10, v4

    move-object v4, v3

    move-object v3, v10

    .line 236
    goto :goto_3

    .line 247
    :cond_2
    invoke-static {v4}, Lcom/facebook/internal/Utility;->closeQuietly(Ljava/io/Closeable;)V

    .line 249
    new-instance v4, Lcom/facebook/FacebookException;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v6}, Lcom/facebook/FacebookException;-><init>(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_3

    .line 255
    :catchall_0
    move-exception v1

    move-object v3, v5

    move-object v10, v1

    move-object v1, v0

    move-object v0, v10

    :goto_4
    invoke-static {v3}, Lcom/facebook/internal/Utility;->closeQuietly(Ljava/io/Closeable;)V

    .line 256
    invoke-static {v1}, Lcom/facebook/internal/Utility;->disconnectQuietly(Ljava/net/URLConnection;)V

    throw v0

    .line 255
    :catchall_1
    move-exception v0

    move-object v1, v3

    goto :goto_4

    :catchall_2
    move-exception v1

    move-object v10, v1

    move-object v1, v0

    move-object v0, v10

    goto :goto_4

    .line 252
    :catch_1
    move-exception v0

    move-object v5, v3

    move-object v4, v3

    goto :goto_1

    :catch_2
    move-exception v4

    move-object v5, v3

    move-object v10, v4

    move-object v4, v0

    move-object v0, v10

    goto :goto_1

    :catch_3
    move-exception v1

    move-object v5, v3

    move-object v4, v0

    move-object v0, v1

    move v1, v2

    goto :goto_1

    :cond_3
    move v1, v2

    move-object v4, v3

    move-object v5, v3

    goto :goto_3

    .line 209
    :sswitch_data_0
    .sparse-switch
        0xc8 -> :sswitch_1
        0x12d -> :sswitch_0
        0x12e -> :sswitch_0
    .end sparse-switch
.end method

.method static downloadAsync(Lcom/facebook/widget/ImageRequest;)V
    .locals 3

    .prologue
    .line 48
    if-nez p0, :cond_0

    .line 67
    :goto_0
    return-void

    .line 57
    :cond_0
    new-instance v1, Lcom/facebook/widget/ImageDownloader$RequestKey;

    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->getImageUrl()Ljava/net/URL;

    move-result-object v0

    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->getCallerTag()Ljava/lang/Object;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/facebook/widget/ImageDownloader$RequestKey;-><init>(Ljava/net/URL;Ljava/lang/Object;)V

    .line 58
    sget-object v2, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    monitor-enter v2

    .line 59
    :try_start_0
    sget-object v0, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;

    .line 60
    if-eqz v0, :cond_1

    .line 61
    iput-object p0, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->request:Lcom/facebook/widget/ImageRequest;

    .line 62
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->isCancelled:Z

    .line 63
    iget-object v0, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->workItem:Lcom/facebook/widget/WorkQueue$WorkItem;

    invoke-interface {v0}, Lcom/facebook/widget/WorkQueue$WorkItem;->moveToFront()V

    .line 67
    :goto_1
    monitor-exit v2

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 65
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->isCachedRedirectAllowed()Z

    move-result v0

    invoke-static {p0, v1, v0}, Lcom/facebook/widget/ImageDownloader;->enqueueCacheRead(Lcom/facebook/widget/ImageRequest;Lcom/facebook/widget/ImageDownloader$RequestKey;Z)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method

.method private static enqueueCacheRead(Lcom/facebook/widget/ImageRequest;Lcom/facebook/widget/ImageDownloader$RequestKey;Z)V
    .locals 3

    .prologue
    .line 105
    sget-object v0, Lcom/facebook/widget/ImageDownloader;->cacheReadQueue:Lcom/facebook/widget/WorkQueue;

    new-instance v1, Lcom/facebook/widget/ImageDownloader$CacheReadWorkItem;

    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2, p1, p2}, Lcom/facebook/widget/ImageDownloader$CacheReadWorkItem;-><init>(Landroid/content/Context;Lcom/facebook/widget/ImageDownloader$RequestKey;Z)V

    invoke-static {p0, p1, v0, v1}, Lcom/facebook/widget/ImageDownloader;->enqueueRequest(Lcom/facebook/widget/ImageRequest;Lcom/facebook/widget/ImageDownloader$RequestKey;Lcom/facebook/widget/WorkQueue;Ljava/lang/Runnable;)V

    .line 110
    return-void
.end method

.method private static enqueueDownload(Lcom/facebook/widget/ImageRequest;Lcom/facebook/widget/ImageDownloader$RequestKey;)V
    .locals 3

    .prologue
    .line 113
    sget-object v0, Lcom/facebook/widget/ImageDownloader;->downloadQueue:Lcom/facebook/widget/WorkQueue;

    new-instance v1, Lcom/facebook/widget/ImageDownloader$DownloadImageWorkItem;

    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lcom/facebook/widget/ImageDownloader$DownloadImageWorkItem;-><init>(Landroid/content/Context;Lcom/facebook/widget/ImageDownloader$RequestKey;)V

    invoke-static {p0, p1, v0, v1}, Lcom/facebook/widget/ImageDownloader;->enqueueRequest(Lcom/facebook/widget/ImageRequest;Lcom/facebook/widget/ImageDownloader$RequestKey;Lcom/facebook/widget/WorkQueue;Ljava/lang/Runnable;)V

    .line 118
    return-void
.end method

.method private static enqueueRequest(Lcom/facebook/widget/ImageRequest;Lcom/facebook/widget/ImageDownloader$RequestKey;Lcom/facebook/widget/WorkQueue;Ljava/lang/Runnable;)V
    .locals 3

    .prologue
    .line 125
    sget-object v1, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    monitor-enter v1

    .line 126
    :try_start_0
    new-instance v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/facebook/widget/ImageDownloader$DownloaderContext;-><init>(Lcom/facebook/widget/ImageDownloader$1;)V

    .line 127
    iput-object p0, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->request:Lcom/facebook/widget/ImageRequest;

    .line 128
    sget-object v2, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    invoke-interface {v2, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 137
    invoke-virtual {p2, p3}, Lcom/facebook/widget/WorkQueue;->addActiveWorkItem(Ljava/lang/Runnable;)Lcom/facebook/widget/WorkQueue$WorkItem;

    move-result-object v2

    iput-object v2, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->workItem:Lcom/facebook/widget/WorkQueue$WorkItem;

    .line 138
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static issueResponse(Lcom/facebook/widget/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V
    .locals 7

    .prologue
    .line 148
    invoke-static {p0}, Lcom/facebook/widget/ImageDownloader;->removePendingRequest(Lcom/facebook/widget/ImageDownloader$RequestKey;)Lcom/facebook/widget/ImageDownloader$DownloaderContext;

    move-result-object v0

    .line 149
    if-eqz v0, :cond_0

    iget-boolean v1, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->isCancelled:Z

    if-nez v1, :cond_0

    .line 150
    iget-object v1, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->request:Lcom/facebook/widget/ImageRequest;

    .line 151
    invoke-virtual {v1}, Lcom/facebook/widget/ImageRequest;->getCallback()Lcom/facebook/widget/ImageRequest$Callback;

    move-result-object v5

    .line 152
    if-eqz v5, :cond_0

    .line 153
    sget-object v6, Lcom/facebook/widget/ImageDownloader;->handler:Landroid/os/Handler;

    new-instance v0, Lcom/facebook/widget/ImageDownloader$1;

    move-object v2, p1

    move v3, p3

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/facebook/widget/ImageDownloader$1;-><init>(Lcom/facebook/widget/ImageRequest;Ljava/lang/Exception;ZLandroid/graphics/Bitmap;Lcom/facebook/widget/ImageRequest$Callback;)V

    invoke-virtual {v6, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 166
    :cond_0
    return-void
.end method

.method static prioritizeRequest(Lcom/facebook/widget/ImageRequest;)V
    .locals 3

    .prologue
    .line 95
    new-instance v0, Lcom/facebook/widget/ImageDownloader$RequestKey;

    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->getImageUrl()Ljava/net/URL;

    move-result-object v1

    invoke-virtual {p0}, Lcom/facebook/widget/ImageRequest;->getCallerTag()Ljava/lang/Object;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/facebook/widget/ImageDownloader$RequestKey;-><init>(Ljava/net/URL;Ljava/lang/Object;)V

    .line 96
    sget-object v1, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    monitor-enter v1

    .line 97
    :try_start_0
    sget-object v2, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;

    .line 98
    if-eqz v0, :cond_0

    .line 99
    iget-object v0, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->workItem:Lcom/facebook/widget/WorkQueue$WorkItem;

    invoke-interface {v0}, Lcom/facebook/widget/WorkQueue$WorkItem;->moveToFront()V

    .line 101
    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static readFromCache(Lcom/facebook/widget/ImageDownloader$RequestKey;Landroid/content/Context;Z)V
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x0

    .line 169
    .line 171
    if-eqz p2, :cond_4

    .line 172
    iget-object v1, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->url:Ljava/net/URL;

    invoke-static {p1, v1}, Lcom/facebook/widget/UrlRedirectCache;->getRedirectedUrl(Landroid/content/Context;Ljava/net/URL;)Ljava/net/URL;

    move-result-object v1

    .line 173
    if-eqz v1, :cond_4

    .line 174
    invoke-static {v1, p1}, Lcom/facebook/widget/ImageResponseCache;->getCachedImageStream(Ljava/net/URL;Landroid/content/Context;)Ljava/io/InputStream;

    move-result-object v1

    .line 175
    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    move v4, v0

    move-object v0, v1

    move v1, v4

    .line 179
    :goto_0
    if-nez v1, :cond_1

    .line 180
    iget-object v0, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->url:Ljava/net/URL;

    invoke-static {v0, p1}, Lcom/facebook/widget/ImageResponseCache;->getCachedImageStream(Ljava/net/URL;Landroid/content/Context;)Ljava/io/InputStream;

    move-result-object v0

    .line 183
    :cond_1
    if-eqz v0, :cond_3

    .line 185
    invoke-static {v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v3

    .line 186
    invoke-static {v0}, Lcom/facebook/internal/Utility;->closeQuietly(Ljava/io/Closeable;)V

    .line 187
    invoke-static {p0, v2, v3, v1}, Lcom/facebook/widget/ImageDownloader;->issueResponse(Lcom/facebook/widget/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V

    .line 196
    :cond_2
    :goto_1
    return-void

    .line 191
    :cond_3
    invoke-static {p0}, Lcom/facebook/widget/ImageDownloader;->removePendingRequest(Lcom/facebook/widget/ImageDownloader$RequestKey;)Lcom/facebook/widget/ImageDownloader$DownloaderContext;

    move-result-object v0

    .line 192
    if-eqz v0, :cond_2

    iget-boolean v1, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->isCancelled:Z

    if-nez v1, :cond_2

    .line 193
    iget-object v0, v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;->request:Lcom/facebook/widget/ImageRequest;

    invoke-static {v0, p0}, Lcom/facebook/widget/ImageDownloader;->enqueueDownload(Lcom/facebook/widget/ImageRequest;Lcom/facebook/widget/ImageDownloader$RequestKey;)V

    goto :goto_1

    :cond_4
    move v1, v0

    move-object v0, v2

    goto :goto_0
.end method

.method private static removePendingRequest(Lcom/facebook/widget/ImageDownloader$RequestKey;)Lcom/facebook/widget/ImageDownloader$DownloaderContext;
    .locals 2

    .prologue
    .line 265
    sget-object v1, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    monitor-enter v1

    .line 266
    :try_start_0
    sget-object v0, Lcom/facebook/widget/ImageDownloader;->pendingRequests:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/widget/ImageDownloader$DownloaderContext;

    monitor-exit v1

    return-object v0

    .line 267
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
