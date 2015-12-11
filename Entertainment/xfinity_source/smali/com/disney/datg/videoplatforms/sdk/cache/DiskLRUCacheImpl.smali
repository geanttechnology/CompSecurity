.class public Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;
.super Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;
.source "DiskLRUCacheImpl.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache",
        "<TK;TV;>;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field protected mCacheParams:Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

.field protected final mDiskCacheLock:Ljava/lang/Object;

.field protected mDiskCacheStarting:Z

.field protected mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;

    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->makeLogTag(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 56
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl<TK;TV;>;"
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;-><init>()V

    .line 39
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheLock:Ljava/lang/Object;

    .line 41
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheStarting:Z

    .line 57
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

    invoke-direct {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;-><init>(Landroid/content/Context;)V

    invoke-direct {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->init(Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;)V

    .line 58
    return-void
.end method

.method private init(Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;)V
    .locals 1
    .param p1, "cacheParams"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

    .prologue
    .line 62
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl<TK;TV;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mCacheParams:Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

    .line 64
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mCacheParams:Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

    sget-boolean v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->DEFAULT_INIT_DISK_CACHE_ON_CREATE:Z

    if-eqz v0, :cond_0

    .line 66
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->initDiskCache()V

    .line 68
    :cond_0
    return-void
.end method

.method private writeDataToFile(Lcom/disney/datg/videoplatforms/sdk/cache/Data;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;)Z
    .locals 7
    .param p2, "editor"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/cache/Data",
            "<TK;TV;>;",
            "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;",
            ")Z"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl<TK;TV;>;"
    .local p1, "data":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    const/4 v4, 0x0

    .line 245
    const/4 v1, 0x0

    .line 249
    .local v1, "out":Ljava/io/OutputStream;
    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->getValue()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v5

    if-nez v5, :cond_2

    .line 268
    :cond_0
    if-eqz v1, :cond_1

    .line 269
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V

    :cond_1
    :goto_0
    return v4

    .line 253
    :cond_2
    :try_start_1
    new-instance v2, Ljava/io/BufferedOutputStream;

    const/4 v5, 0x0

    invoke-virtual {p2, v5}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v5

    const/16 v6, 0x2000

    invoke-direct {v2, v5, v6}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 255
    .end local v1    # "out":Ljava/io/OutputStream;
    .local v2, "out":Ljava/io/OutputStream;
    :try_start_2
    new-instance v3, Ljava/io/ObjectOutputStream;

    invoke-direct {v3, v2}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 256
    .local v3, "output":Ljava/io/ObjectOutput;
    invoke-interface {v3, p1}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 257
    const/4 v4, 0x1

    .line 268
    if-eqz v2, :cond_3

    .line 269
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V

    :cond_3
    move-object v1, v2

    .end local v2    # "out":Ljava/io/OutputStream;
    .restart local v1    # "out":Ljava/io/OutputStream;
    goto :goto_0

    .line 260
    .end local v3    # "output":Ljava/io/ObjectOutput;
    :catch_0
    move-exception v0

    .line 262
    .local v0, "e":Ljava/io/IOException;
    :goto_1
    :try_start_3
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 263
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 264
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 268
    if-eqz v1, :cond_1

    .line 269
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V

    goto :goto_0

    .line 268
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    :goto_2
    if-eqz v1, :cond_4

    .line 269
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V

    :cond_4
    throw v4

    .line 268
    .end local v1    # "out":Ljava/io/OutputStream;
    .restart local v2    # "out":Ljava/io/OutputStream;
    :catchall_1
    move-exception v4

    move-object v1, v2

    .end local v2    # "out":Ljava/io/OutputStream;
    .restart local v1    # "out":Ljava/io/OutputStream;
    goto :goto_2

    .line 260
    .end local v1    # "out":Ljava/io/OutputStream;
    .restart local v2    # "out":Ljava/io/OutputStream;
    :catch_1
    move-exception v0

    move-object v1, v2

    .end local v2    # "out":Ljava/io/OutputStream;
    .restart local v1    # "out":Ljava/io/OutputStream;
    goto :goto_1
.end method


# virtual methods
.method public flush()V
    .locals 5

    .prologue
    .line 407
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl<TK;TV;>;"
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 408
    :try_start_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 410
    :try_start_1
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->flush()V

    .line 411
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    const-string v3, "Disk cache flushed"

    invoke-static {v1, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 417
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 418
    return-void

    .line 412
    :catch_0
    move-exception v0

    .line 413
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 414
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "flush - "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 417
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public initDiskCache()V
    .locals 8

    .prologue
    .line 72
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl<TK;TV;>;"
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v3

    .line 73
    :try_start_0
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->isClosed()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 74
    :cond_0
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mCacheParams:Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

    iget-object v0, v2, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->diskCacheDir:Ljava/io/File;

    .line 76
    .local v0, "diskCacheDir":Ljava/io/File;
    if-eqz v0, :cond_2

    .line 77
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_1

    .line 78
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 80
    :cond_1
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->getUsableSpace(Ljava/io/File;)J

    move-result-wide v4

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mCacheParams:Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

    iget v2, v2, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->diskCacheSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    int-to-long v6, v2

    cmp-long v2, v4, v6

    if-lez v2, :cond_2

    .line 82
    const/4 v2, 0x1

    const/4 v4, 0x1

    :try_start_1
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mCacheParams:Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

    iget v5, v5, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->diskCacheSize:I

    int-to-long v6, v5

    invoke-static {v0, v2, v4, v6, v7}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->open(Ljava/io/File;IIJ)Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    move-result-object v2

    iput-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    .line 84
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    const-string v4, "Disk cache initialized"

    invoke-static {v2, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 93
    .end local v0    # "diskCacheDir":Ljava/io/File;
    :cond_2
    :goto_0
    const/4 v2, 0x0

    :try_start_2
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheStarting:Z

    .line 94
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheLock:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->notifyAll()V

    .line 95
    monitor-exit v3

    .line 96
    return-void

    .line 85
    .restart local v0    # "diskCacheDir":Ljava/io/File;
    :catch_0
    move-exception v1

    .line 86
    .local v1, "e":Ljava/io/IOException;
    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 87
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mCacheParams:Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;

    const/4 v4, 0x0

    iput-object v4, v2, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCacheProperties;->diskCacheDir:Ljava/io/File;

    .line 88
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "initDiskCache - "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 95
    .end local v0    # "diskCacheDir":Ljava/io/File;
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method

.method public isEmpty()Z
    .locals 4

    .prologue
    .line 372
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl<TK;TV;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->size()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public readFromFile(Ljava/lang/Object;)Lcom/disney/datg/videoplatforms/sdk/cache/Data;
    .locals 20
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)",
            "Lcom/disney/datg/videoplatforms/sdk/cache/Data",
            "<TK;TV;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 108
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    invoke-virtual/range {p0 .. p1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->processKey(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 109
    .local v7, "keyValue":Ljava/lang/String;
    const/4 v3, 0x0

    .line 110
    .local v3, "data":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v13

    .line 111
    :goto_0
    :try_start_0
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheStarting:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v12, :cond_0

    .line 113
    :try_start_1
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskCacheLock:Ljava/lang/Object;

    invoke-virtual {v12}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 114
    :catch_0
    move-exception v4

    .line 115
    .local v4, "e":Ljava/lang/InterruptedException;
    :try_start_2
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 175
    .end local v4    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v12

    monitor-exit v13
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v12

    .line 118
    :cond_0
    :try_start_3
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    if-eqz v12, :cond_4

    .line 119
    const/4 v6, 0x0

    .line 121
    .local v6, "inputStream":Ljava/io/InputStream;
    :try_start_4
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    invoke-virtual {v12, v7}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->get(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;

    move-result-object v10

    .line 122
    .local v10, "snapshot":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
    if-eqz v10, :cond_2

    .line 123
    sget-object v12, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    const-string v14, "Disk cache hit"

    invoke-static {v12, v14}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const/4 v12, 0x0

    invoke-virtual {v10, v12}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v6

    .line 125
    if-eqz v6, :cond_2

    .line 127
    new-instance v2, Ljava/io/BufferedInputStream;

    const/16 v12, 0x2000

    invoke-direct {v2, v6, v12}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    .line 128
    .local v2, "buffIn":Ljava/io/BufferedInputStream;
    new-instance v5, Ljava/io/ObjectInputStream;

    invoke-direct {v5, v2}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 131
    .local v5, "input":Ljava/io/ObjectInput;
    :try_start_5
    invoke-interface {v5}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v12

    move-object v0, v12

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;

    move-object v3, v0

    .line 132
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->getTtl()I

    move-result v11

    .line 133
    .local v11, "ttl":I
    if-lez v11, :cond_1

    .line 134
    new-instance v9, Ljava/util/Date;

    invoke-direct {v9}, Ljava/util/Date;-><init>()V

    .line 135
    .local v9, "now":Ljava/util/Date;
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->getAccessTime()Ljava/util/Date;

    move-result-object v8

    .line 136
    .local v8, "lastAccessed":Ljava/util/Date;
    int-to-long v14, v11

    invoke-virtual {v9}, Ljava/util/Date;->getTime()J

    move-result-wide v16

    invoke-virtual {v8}, Ljava/util/Date;->getTime()J

    move-result-wide v18

    sub-long v16, v16, v18

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    cmp-long v12, v14, v16

    if-gez v12, :cond_1

    .line 137
    sget-object v12, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    const-string v14, "item has expired, removing from disk cache"

    invoke-static {v12, v14}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    invoke-virtual {v12, v7}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->remove(Ljava/lang/String;)Z
    :try_end_5
    .catch Ljava/lang/ClassNotFoundException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 148
    .end local v8    # "lastAccessed":Ljava/util/Date;
    .end local v9    # "now":Ljava/util/Date;
    :cond_1
    :try_start_6
    invoke-interface {v5}, Ljava/io/ObjectInput;->close()V

    .line 152
    .end local v2    # "buffIn":Ljava/io/BufferedInputStream;
    .end local v5    # "input":Ljava/io/ObjectInput;
    .end local v11    # "ttl":I
    :cond_2
    :goto_1
    if-eqz v10, :cond_3

    .line 153
    invoke-virtual {v10}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 161
    :cond_3
    if-eqz v6, :cond_4

    .line 162
    :try_start_7
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 174
    .end local v6    # "inputStream":Ljava/io/InputStream;
    .end local v10    # "snapshot":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
    :cond_4
    :goto_2
    :try_start_8
    monitor-exit v13
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    return-object v3

    .line 143
    .restart local v2    # "buffIn":Ljava/io/BufferedInputStream;
    .restart local v5    # "input":Ljava/io/ObjectInput;
    .restart local v6    # "inputStream":Ljava/io/InputStream;
    .restart local v10    # "snapshot":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
    :catch_1
    move-exception v4

    .line 144
    .local v4, "e":Ljava/lang/ClassNotFoundException;
    :try_start_9
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 145
    sget-object v12, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "readFromFile - "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v12, v14}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .line 148
    :try_start_a
    invoke-interface {v5}, Ljava/io/ObjectInput;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_2
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    goto :goto_1

    .line 156
    .end local v2    # "buffIn":Ljava/io/BufferedInputStream;
    .end local v4    # "e":Ljava/lang/ClassNotFoundException;
    .end local v5    # "input":Ljava/io/ObjectInput;
    .end local v10    # "snapshot":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
    :catch_2
    move-exception v4

    .line 157
    .local v4, "e":Ljava/io/IOException;
    :try_start_b
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 158
    sget-object v12, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->TAG:Ljava/lang/String;

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "readFromFile - "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v12, v14}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    .line 161
    if-eqz v6, :cond_4

    .line 162
    :try_start_c
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_3
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    goto :goto_2

    .line 164
    :catch_3
    move-exception v4

    .line 165
    :try_start_d
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    goto :goto_2

    .line 148
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v2    # "buffIn":Ljava/io/BufferedInputStream;
    .restart local v5    # "input":Ljava/io/ObjectInput;
    .restart local v10    # "snapshot":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
    :catchall_1
    move-exception v12

    :try_start_e
    invoke-interface {v5}, Ljava/io/ObjectInput;->close()V

    throw v12
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_2
    .catchall {:try_start_e .. :try_end_e} :catchall_2

    .line 160
    .end local v2    # "buffIn":Ljava/io/BufferedInputStream;
    .end local v5    # "input":Ljava/io/ObjectInput;
    .end local v10    # "snapshot":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
    :catchall_2
    move-exception v12

    .line 161
    if-eqz v6, :cond_5

    .line 162
    :try_start_f
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_5
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    .line 166
    :cond_5
    :goto_3
    :try_start_10
    throw v12

    .line 164
    .restart local v10    # "snapshot":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
    :catch_4
    move-exception v4

    .line 165
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    goto :goto_2

    .line 164
    .end local v4    # "e":Ljava/io/IOException;
    .end local v10    # "snapshot":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Snapshot;
    :catch_5
    move-exception v4

    .line 165
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    goto :goto_3
.end method

.method public writeToFile(Ljava/lang/Object;Ljava/lang/Object;I)V
    .locals 6
    .param p3, "ttl"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;I)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 186
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 241
    :cond_0
    :goto_0
    return-void

    .line 191
    :cond_1
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->processKey(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 192
    .local v4, "keyValue":Ljava/lang/String;
    const/4 v2, 0x0

    .line 193
    .local v2, "editor":Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;-><init>()V

    .line 194
    .local v0, "data":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    invoke-virtual {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->setKey(Ljava/lang/Object;)V

    .line 195
    invoke-virtual {v0, p2}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->setValue(Ljava/lang/Object;)V

    .line 196
    invoke-virtual {v0, p3}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->setTtl(I)V

    .line 197
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v5}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->setAccessTime(Ljava/util/Date;)V

    .line 201
    :try_start_0
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->mDiskLruCache:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    invoke-virtual {v5, v4}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->edit(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;

    move-result-object v2

    .line 202
    if-eqz v2, :cond_0

    .line 206
    invoke-direct {p0, v0, v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->writeDataToFile(Lcom/disney/datg/videoplatforms/sdk/cache/Data;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 208
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;->flush()V

    .line 209
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->commit()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 224
    :catch_0
    move-exception v1

    .line 232
    .local v1, "e":Ljava/io/IOException;
    if-eqz v2, :cond_0

    .line 234
    :try_start_1
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->abort()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 236
    :catch_1
    move-exception v3

    .line 237
    .local v3, "ex":Ljava/io/IOException;
    invoke-static {v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 217
    .end local v1    # "e":Ljava/io/IOException;
    .end local v3    # "ex":Ljava/io/IOException;
    :cond_2
    :try_start_2
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->abort()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0
.end method
