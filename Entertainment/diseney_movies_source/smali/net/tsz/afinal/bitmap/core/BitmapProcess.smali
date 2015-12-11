.class public Lnet/tsz/afinal/bitmap/core/BitmapProcess;
.super Ljava/lang/Object;
.source "BitmapProcess.java"


# static fields
.field private static final DEFAULT_CACHE_SIZE:I = 0x1400000

.field private static final DISK_CACHE_INDEX:I = 0x0

.field private static final TAG:Ljava/lang/String; = "BitmapProcess"


# instance fields
.field private cacheSize:I

.field private downloader:Lnet/tsz/afinal/bitmap/download/Downloader;

.field private final mHttpDiskCacheLock:Ljava/lang/Object;

.field private mHttpDiskCacheStarting:Z

.field private mOriginalCacheDir:Ljava/io/File;

.field private mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

.field private neverCalculate:Z


# direct methods
.method public constructor <init>(Lnet/tsz/afinal/bitmap/download/Downloader;Ljava/lang/String;I)V
    .locals 3
    .param p1, "downloader"    # Lnet/tsz/afinal/bitmap/download/Downloader;
    .param p2, "filePath"    # Ljava/lang/String;
    .param p3, "cacheSize"    # I

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const/4 v0, 0x1

    iput-boolean v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheStarting:Z

    .line 36
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheLock:Ljava/lang/Object;

    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->neverCalculate:Z

    .line 45
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/original"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalCacheDir:Ljava/io/File;

    .line 46
    iput-object p1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->downloader:Lnet/tsz/afinal/bitmap/download/Downloader;

    .line 47
    if-gtz p3, :cond_0

    .line 48
    const/high16 p3, 0x1400000

    .line 49
    :cond_0
    iput p3, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->cacheSize:I

    .line 50
    return-void
.end method


# virtual methods
.method public clearCacheInternal()V
    .locals 5

    .prologue
    .line 137
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 138
    :try_start_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->isClosed()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 140
    :try_start_1
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->delete()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 144
    :goto_0
    const/4 v1, 0x0

    :try_start_2
    iput-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    .line 145
    const/4 v1, 0x1

    iput-boolean v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheStarting:Z

    .line 146
    invoke-virtual {p0}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->initHttpDiskCache()V

    .line 137
    :cond_0
    monitor-exit v2

    .line 149
    return-void

    .line 141
    :catch_0
    move-exception v0

    .line 142
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "BitmapProcess"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "clearCacheInternal - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 137
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public closeCacheInternal()V
    .locals 5

    .prologue
    .line 164
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 165
    :try_start_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 167
    :try_start_1
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->isClosed()Z

    move-result v1

    if-nez v1, :cond_0

    .line 168
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->close()V

    .line 169
    const/4 v1, 0x0

    iput-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 164
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 176
    return-void

    .line 171
    :catch_0
    move-exception v0

    .line 172
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "BitmapProcess"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "closeCacheInternal - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 164
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public configCalculateBitmap(Z)V
    .locals 0
    .param p1, "neverCalculate"    # Z

    .prologue
    .line 53
    iput-boolean p1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->neverCalculate:Z

    .line 54
    return-void
.end method

.method public flushCacheInternal()V
    .locals 5

    .prologue
    .line 152
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 153
    :try_start_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 155
    :try_start_1
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->flush()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 152
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 161
    return-void

    .line 156
    :catch_0
    move-exception v0

    .line 157
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "BitmapProcess"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "flush - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 152
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public initHttpDiskCache()V
    .locals 7

    .prologue
    .line 120
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalCacheDir:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_0

    .line 121
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalCacheDir:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 123
    :cond_0
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 124
    :try_start_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalCacheDir:Ljava/io/File;

    invoke-static {v1}, Lnet/tsz/afinal/bitmap/core/BitmapCommonUtils;->getUsableSpace(Ljava/io/File;)J

    move-result-wide v3

    iget v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->cacheSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    int-to-long v5, v1

    cmp-long v1, v3, v5

    if-lez v1, :cond_1

    .line 126
    :try_start_1
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalCacheDir:Ljava/io/File;

    const/4 v3, 0x1

    const/4 v4, 0x1

    iget v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->cacheSize:I

    int-to-long v5, v5

    invoke-static {v1, v3, v4, v5, v6}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->open(Ljava/io/File;IIJ)Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    move-result-object v1

    iput-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 131
    :cond_1
    :goto_0
    const/4 v1, 0x0

    :try_start_2
    iput-boolean v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheStarting:Z

    .line 132
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 123
    monitor-exit v2

    .line 134
    return-void

    .line 127
    :catch_0
    move-exception v0

    .line 128
    .local v0, "e":Ljava/io/IOException;
    const/4 v1, 0x0

    iput-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    goto :goto_0

    .line 123
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public processBitmap(Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)Landroid/graphics/Bitmap;
    .locals 12
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "config"    # Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .prologue
    .line 57
    invoke-static {p1}, Lnet/tsz/afinal/bitmap/core/FileNameGenerator;->generator(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 58
    .local v6, "key":Ljava/lang/String;
    const/4 v4, 0x0

    .line 59
    .local v4, "fileDescriptor":Ljava/io/FileDescriptor;
    const/4 v5, 0x0

    .line 61
    .local v5, "fileInputStream":Ljava/io/FileInputStream;
    iget-object v9, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheLock:Ljava/lang/Object;

    monitor-enter v9

    .line 63
    :goto_0
    :try_start_0
    iget-boolean v8, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheStarting:Z

    if-nez v8, :cond_6

    .line 70
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    if-eqz v8, :cond_3

    .line 72
    :try_start_1
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v8, v6}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->get(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;

    move-result-object v7

    .line 73
    .local v7, "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    if-nez v7, :cond_1

    .line 74
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v8, v6}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->edit(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v3

    .line 75
    .local v3, "editor":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    if-eqz v3, :cond_0

    .line 76
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->downloader:Lnet/tsz/afinal/bitmap/download/Downloader;

    const/4 v10, 0x0

    invoke-virtual {v3, v10}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v10

    invoke-interface {v8, p1, v10}, Lnet/tsz/afinal/bitmap/download/Downloader;->downloadToLocalStreamByUrl(Ljava/lang/String;Ljava/io/OutputStream;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 77
    invoke-virtual {v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->commit()V

    .line 82
    :cond_0
    :goto_1
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mOriginalDiskCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v8, v6}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->get(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;

    move-result-object v7

    .line 84
    .end local v3    # "editor":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    :cond_1
    if-eqz v7, :cond_2

    .line 85
    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v8

    move-object v0, v8

    check-cast v0, Ljava/io/FileInputStream;

    move-object v5, v0

    .line 86
    invoke-virtual {v5}, Ljava/io/FileInputStream;->getFD()Ljava/io/FileDescriptor;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v4

    .line 93
    :cond_2
    if-nez v4, :cond_3

    if-eqz v5, :cond_3

    .line 95
    :try_start_2
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_6
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 61
    .end local v7    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :cond_3
    :goto_2
    :try_start_3
    monitor-exit v9
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 103
    const/4 v1, 0x0

    .line 104
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v4, :cond_4

    .line 105
    iget-boolean v8, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->neverCalculate:Z

    if-eqz v8, :cond_9

    .line 106
    invoke-static {v4}, Landroid/graphics/BitmapFactory;->decodeFileDescriptor(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 110
    :cond_4
    :goto_3
    if-eqz v5, :cond_5

    .line 112
    :try_start_4
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_7

    .line 116
    :cond_5
    :goto_4
    return-object v1

    .line 65
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    :cond_6
    :try_start_5
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->mHttpDiskCacheLock:Ljava/lang/Object;

    invoke-virtual {v8}, Ljava/lang/Object;->wait()V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_0

    .line 66
    :catch_0
    move-exception v8

    goto :goto_0

    .line 79
    .restart local v3    # "editor":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    .restart local v7    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :cond_7
    :try_start_6
    invoke-virtual {v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->abort()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Ljava/lang/IllegalStateException; {:try_start_6 .. :try_end_6} :catch_3
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_1

    .line 88
    .end local v3    # "editor":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    .end local v7    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :catch_1
    move-exception v2

    .line 89
    .local v2, "e":Ljava/io/IOException;
    :try_start_7
    const-string v8, "BitmapProcess"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "processBitmap - "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v8, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 93
    if-nez v4, :cond_3

    if-eqz v5, :cond_3

    .line 95
    :try_start_8
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_2
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    goto :goto_2

    .line 96
    :catch_2
    move-exception v8

    goto :goto_2

    .line 90
    .end local v2    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v2

    .line 91
    .local v2, "e":Ljava/lang/IllegalStateException;
    :try_start_9
    const-string v8, "BitmapProcess"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "processBitmap - "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v8, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 93
    if-nez v4, :cond_3

    if-eqz v5, :cond_3

    .line 95
    :try_start_a
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_4
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    goto :goto_2

    .line 96
    :catch_4
    move-exception v8

    goto :goto_2

    .line 92
    .end local v2    # "e":Ljava/lang/IllegalStateException;
    :catchall_0
    move-exception v8

    .line 93
    if-nez v4, :cond_8

    if-eqz v5, :cond_8

    .line 95
    :try_start_b
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_5
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    .line 99
    :cond_8
    :goto_5
    :try_start_c
    throw v8

    .line 61
    :catchall_1
    move-exception v8

    monitor-exit v9
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    throw v8

    .line 108
    .restart local v1    # "bitmap":Landroid/graphics/Bitmap;
    :cond_9
    invoke-virtual {p2}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getBitmapWidth()I

    move-result v8

    invoke-virtual {p2}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getBitmapHeight()I

    move-result v9

    invoke-static {v4, v8, v9}, Lnet/tsz/afinal/bitmap/core/BitmapDecoder;->decodeSampledBitmapFromDescriptor(Ljava/io/FileDescriptor;II)Landroid/graphics/Bitmap;

    move-result-object v1

    goto :goto_3

    .line 96
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    :catch_5
    move-exception v10

    goto :goto_5

    .restart local v7    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :catch_6
    move-exception v8

    goto :goto_2

    .line 113
    .end local v7    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    .restart local v1    # "bitmap":Landroid/graphics/Bitmap;
    :catch_7
    move-exception v8

    goto :goto_4
.end method
