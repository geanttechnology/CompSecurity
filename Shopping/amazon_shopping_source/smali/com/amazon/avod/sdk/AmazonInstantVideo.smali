.class public Lcom/amazon/avod/sdk/AmazonInstantVideo;
.super Ljava/lang/Object;
.source "AmazonInstantVideo.java"


# instance fields
.field private final mAivConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

.field private final mCleanUpLock:Ljava/lang/Object;

.field private final mConnectionGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

.field private final mContext:Landroid/content/Context;

.field private final mTeardownGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    new-instance v0, Lcom/amazon/avod/sdk/internal/CleanupGuard;

    invoke-direct {v0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;-><init>()V

    iput-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mConnectionGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    .line 44
    new-instance v0, Lcom/amazon/avod/sdk/internal/CleanupGuard;

    invoke-direct {v0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;-><init>()V

    iput-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mTeardownGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    .line 45
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mCleanUpLock:Ljava/lang/Object;

    .line 67
    if-nez p1, :cond_0

    .line 68
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "Context cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 77
    :cond_0
    iput-object p1, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mContext:Landroid/content/Context;

    .line 78
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/avod/sdk/internal/AivConnection$Factory;->newConnection(Landroid/content/Context;)Lcom/amazon/avod/sdk/internal/AivConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mAivConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    .line 79
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mConnectionGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    const-string/jumbo v1, "cleanup"

    invoke-virtual {v0, v1}, Lcom/amazon/avod/sdk/internal/CleanupGuard;->open(Ljava/lang/String;)V

    .line 80
    return-void
.end method


# virtual methods
.method public cleanup()V
    .locals 2

    .prologue
    .line 222
    iget-object v1, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mCleanUpLock:Ljava/lang/Object;

    monitor-enter v1

    .line 223
    :try_start_0
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mConnectionGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;->isOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 225
    monitor-exit v1

    .line 231
    :goto_0
    return-void

    .line 228
    :cond_0
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mAivConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    invoke-interface {v0}, Lcom/amazon/avod/sdk/internal/AivConnection;->disconnect()V

    .line 229
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mConnectionGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;->close()V

    .line 230
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected finalize()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 91
    :try_start_0
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mTeardownGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    if-eqz v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mTeardownGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;->warnIfOpen()V

    .line 93
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/avod/sdk/AmazonInstantVideo;->teardownPreparedVideo(Lcom/amazon/avod/sdk/ResponseHandler;)V

    .line 96
    :cond_0
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mConnectionGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    if-eqz v0, :cond_1

    .line 97
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mConnectionGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;->warnIfOpen()V

    .line 98
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/AmazonInstantVideo;->cleanup()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 102
    :cond_1
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 104
    return-void

    .line 102
    :catchall_0
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public play(Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;)Lcom/amazon/avod/sdk/VideoPlaybackStarter;
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "urlType"    # Lcom/amazon/avod/sdk/Constants$UrlType;

    .prologue
    .line 192
    new-instance v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;

    iget-object v1, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mAivConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    invoke-direct {v0, v1, p1, p2}, Lcom/amazon/avod/sdk/VideoPlaybackStarter;-><init>(Lcom/amazon/avod/sdk/internal/AivConnection;Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;)V

    return-object v0
.end method

.method public queryPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V
    .locals 2
    .param p1, "callback"    # Lcom/amazon/avod/sdk/PlaybackSupportResponse;

    .prologue
    .line 169
    if-nez p1, :cond_0

    .line 170
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "callback cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 173
    :cond_0
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mAivConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    invoke-interface {v0, p1}, Lcom/amazon/avod/sdk/internal/AivConnection;->queryPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V

    .line 174
    return-void
.end method

.method public teardownPreparedVideo(Lcom/amazon/avod/sdk/ResponseHandler;)V
    .locals 1
    .param p1, "handler"    # Lcom/amazon/avod/sdk/ResponseHandler;

    .prologue
    .line 269
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mTeardownGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;->isOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 276
    :goto_0
    return-void

    .line 274
    :cond_0
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mAivConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    invoke-interface {v0, p1}, Lcom/amazon/avod/sdk/internal/AivConnection;->teardownPreparedVideo(Lcom/amazon/avod/sdk/ResponseHandler;)V

    .line 275
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mTeardownGuard:Lcom/amazon/avod/sdk/internal/CleanupGuard;

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;->close()V

    goto :goto_0
.end method

.method public whisperCacheContent(Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V
    .locals 2
    .param p2, "cacheLevel"    # Lcom/amazon/avod/sdk/CacheLevel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/avod/sdk/CacheLevel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 311
    .local p1, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 312
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "asins cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 315
    :cond_0
    if-nez p2, :cond_1

    .line 316
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "bucket cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 319
    :cond_1
    iget-object v0, p0, Lcom/amazon/avod/sdk/AmazonInstantVideo;->mAivConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    invoke-interface {v0, p1, p2}, Lcom/amazon/avod/sdk/internal/AivConnection;->whisperCacheContent(Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V

    .line 320
    return-void
.end method
