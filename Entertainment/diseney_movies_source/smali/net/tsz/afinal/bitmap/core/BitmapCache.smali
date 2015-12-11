.class public Lnet/tsz/afinal/bitmap/core/BitmapCache;
.super Ljava/lang/Object;
.source "BitmapCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;
    }
.end annotation


# static fields
.field private static final DEFAULT_CLEAR_DISK_CACHE_ON_START:Z = false

.field private static final DEFAULT_COMPRESS_FORMAT:Landroid/graphics/Bitmap$CompressFormat;

.field private static final DEFAULT_COMPRESS_QUALITY:I = 0x46

.field private static final DEFAULT_DISK_CACHE_ENABLED:Z = true

.field private static final DEFAULT_DISK_CACHE_SIZE:I = 0x1400000

.field private static final DEFAULT_INIT_DISK_CACHE_ON_CREATE:Z = false

.field private static final DEFAULT_MEM_CACHE_ENABLED:Z = true

.field private static final DEFAULT_MEM_CACHE_SIZE:I = 0x800000

.field private static final DISK_CACHE_INDEX:I = 0x0

.field private static final TAG:Ljava/lang/String; = "ImageCache"


# instance fields
.field private mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

.field private final mDiskCacheLock:Ljava/lang/Object;

.field private mDiskCacheStarting:Z

.field private mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

.field private mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lnet/tsz/afinal/bitmap/core/LruMemoryCache",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    sget-object v0, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    sput-object v0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->DEFAULT_COMPRESS_FORMAT:Landroid/graphics/Bitmap$CompressFormat;

    .line 50
    return-void
.end method

.method public constructor <init>(Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;)V
    .locals 1
    .param p1, "cacheParams"    # Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    .line 56
    const/4 v0, 0x1

    iput-boolean v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheStarting:Z

    .line 64
    invoke-direct {p0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->init(Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;)V

    .line 65
    return-void
.end method

.method static synthetic access$0()Landroid/graphics/Bitmap$CompressFormat;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->DEFAULT_COMPRESS_FORMAT:Landroid/graphics/Bitmap$CompressFormat;

    return-object v0
.end method

.method private init(Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;)V
    .locals 2
    .param p1, "cacheParams"    # Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    .prologue
    .line 74
    iput-object p1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    .line 77
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget-boolean v0, v0, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->memoryCacheEnabled:Z

    if-eqz v0, :cond_0

    .line 78
    new-instance v0, Lnet/tsz/afinal/bitmap/core/BitmapCache$1;

    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget v1, v1, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->memCacheSize:I

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapCache$1;-><init>(Lnet/tsz/afinal/bitmap/core/BitmapCache;I)V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    .line 92
    :cond_0
    iget-boolean v0, p1, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->initDiskCacheOnCreate:Z

    if-eqz v0, :cond_1

    .line 94
    invoke-virtual {p0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->initDiskCache()V

    .line 96
    :cond_1
    return-void
.end method


# virtual methods
.method public addBitmapToCache(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 9
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 134
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 179
    :cond_0
    :goto_0
    return-void

    .line 139
    :cond_1
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    if-eqz v5, :cond_2

    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    invoke-virtual {v5, p1}, Lnet/tsz/afinal/bitmap/core/LruMemoryCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-nez v5, :cond_2

    .line 140
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    invoke-virtual {v5, p1, p2}, Lnet/tsz/afinal/bitmap/core/LruMemoryCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    :cond_2
    iget-object v6, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v6

    .line 145
    :try_start_0
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    if-eqz v5, :cond_5

    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v5}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->getDirectory()Ljava/io/File;

    move-result-object v5

    if-eqz v5, :cond_5

    .line 147
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v5}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->getDirectory()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_3

    .line 148
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v5}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->getDirectory()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v5}, Ljava/io/File;->mkdirs()Z

    .line 150
    :cond_3
    invoke-static {p1}, Lnet/tsz/afinal/bitmap/core/FileNameGenerator;->generator(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 151
    .local v2, "key":Ljava/lang/String;
    const/4 v3, 0x0

    .line 153
    .local v3, "out":Ljava/io/OutputStream;
    :try_start_1
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v5, v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->get(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;

    move-result-object v4

    .line 154
    .local v4, "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    if-nez v4, :cond_6

    .line 155
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v5, v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->edit(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v1

    .line 156
    .local v1, "editor":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    if-eqz v1, :cond_4

    .line 157
    const/4 v5, 0x0

    invoke-virtual {v1, v5}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v3

    .line 159
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget-object v5, v5, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->compressFormat:Landroid/graphics/Bitmap$CompressFormat;

    iget-object v7, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget v7, v7, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->compressQuality:I

    .line 158
    invoke-virtual {p2, v5, v7, v3}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 160
    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->commit()V

    .line 161
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 172
    .end local v1    # "editor":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    :cond_4
    :goto_1
    if-eqz v3, :cond_5

    .line 173
    :try_start_2
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 143
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "out":Ljava/io/OutputStream;
    .end local v4    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :cond_5
    :goto_2
    :try_start_3
    monitor-exit v6

    goto :goto_0

    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v5

    .line 164
    .restart local v2    # "key":Ljava/lang/String;
    .restart local v3    # "out":Ljava/io/OutputStream;
    .restart local v4    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :cond_6
    const/4 v5, 0x0

    :try_start_4
    invoke-virtual {v4, v5}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v5

    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_1

    .line 166
    .end local v4    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :catch_0
    move-exception v0

    .line 167
    .local v0, "e":Ljava/io/IOException;
    :try_start_5
    const-string v5, "ImageCache"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "addBitmapToCache - "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 172
    if-eqz v3, :cond_5

    .line 173
    :try_start_6
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_2

    .line 175
    :catch_1
    move-exception v5

    goto :goto_2

    .line 168
    .end local v0    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v0

    .line 169
    .local v0, "e":Ljava/lang/Exception;
    :try_start_7
    const-string v5, "ImageCache"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "addBitmapToCache - "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 172
    if-eqz v3, :cond_5

    .line 173
    :try_start_8
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_3
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_2

    .line 175
    :catch_3
    move-exception v5

    goto :goto_2

    .line 170
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v5

    .line 172
    if-eqz v3, :cond_7

    .line 173
    :try_start_9
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_4
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 176
    :cond_7
    :goto_3
    :try_start_a
    throw v5
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 175
    :catch_4
    move-exception v7

    goto :goto_3

    .restart local v4    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :catch_5
    move-exception v5

    goto :goto_2
.end method

.method public clearCache()V
    .locals 0

    .prologue
    .line 243
    invoke-virtual {p0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearMemoryCache()V

    .line 244
    invoke-virtual {p0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearDiskCache()V

    .line 245
    return-void
.end method

.method public clearCache(Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 270
    invoke-virtual {p0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearMemoryCache(Ljava/lang/String;)V

    .line 271
    invoke-virtual {p0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearDiskCache(Ljava/lang/String;)V

    .line 272
    return-void
.end method

.method public clearDiskCache()V
    .locals 5

    .prologue
    .line 248
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 249
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheStarting:Z

    .line 250
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->isClosed()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 252
    :try_start_1
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->delete()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 256
    :goto_0
    const/4 v1, 0x0

    :try_start_2
    iput-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    .line 257
    invoke-virtual {p0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->initDiskCache()V

    .line 248
    :cond_0
    monitor-exit v2

    .line 260
    return-void

    .line 253
    :catch_0
    move-exception v0

    .line 254
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "ImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "clearCache - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 248
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public clearDiskCache(Ljava/lang/String;)V
    .locals 5
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 275
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 276
    :try_start_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->isClosed()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 278
    :try_start_1
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1, p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->remove(Ljava/lang/String;)Z
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 275
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 284
    return-void

    .line 279
    :catch_0
    move-exception v0

    .line 280
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "ImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "clearCache - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 275
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public clearMemoryCache()V
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    if-eqz v0, :cond_0

    .line 264
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/LruMemoryCache;->evictAll()V

    .line 266
    :cond_0
    return-void
.end method

.method public clearMemoryCache(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 287
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    if-eqz v0, :cond_0

    .line 288
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/LruMemoryCache;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 290
    :cond_0
    return-void
.end method

.method public close()V
    .locals 5

    .prologue
    .line 313
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 314
    :try_start_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 316
    :try_start_1
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->isClosed()Z

    move-result v1

    if-nez v1, :cond_0

    .line 317
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->close()V

    .line 318
    const/4 v1, 0x0

    iput-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 313
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 325
    return-void

    .line 320
    :catch_0
    move-exception v0

    .line 321
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "ImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "close - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 313
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public flush()V
    .locals 5

    .prologue
    .line 297
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 298
    :try_start_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 300
    :try_start_1
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->flush()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 297
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 306
    return-void

    .line 301
    :catch_0
    move-exception v0

    .line 302
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "ImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "flush - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 297
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public getBitmapFromDiskCache(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 9
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 206
    invoke-static {p1}, Lnet/tsz/afinal/bitmap/core/FileNameGenerator;->generator(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 207
    .local v3, "key":Ljava/lang/String;
    iget-object v6, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v6

    .line 208
    :goto_0
    :try_start_0
    iget-boolean v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheStarting:Z

    if-nez v5, :cond_1

    .line 213
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    if-eqz v5, :cond_2

    .line 214
    const/4 v2, 0x0

    .line 216
    .local v2, "inputStream":Ljava/io/InputStream;
    :try_start_1
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v5, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->get(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;

    move-result-object v4

    .line 217
    .local v4, "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    if-eqz v4, :cond_4

    .line 218
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v2

    .line 219
    if-eqz v2, :cond_4

    .line 220
    invoke-static {v2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    .line 228
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v2, :cond_0

    .line 229
    :try_start_2
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 221
    :cond_0
    :goto_1
    :try_start_3
    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 234
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "inputStream":Ljava/io/InputStream;
    .end local v4    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :goto_2
    return-object v0

    .line 210
    :cond_1
    :try_start_4
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    invoke-virtual {v5}, Ljava/lang/Object;->wait()V
    :try_end_4
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_0

    .line 211
    :catch_0
    move-exception v5

    goto :goto_0

    .line 224
    .restart local v2    # "inputStream":Ljava/io/InputStream;
    :catch_1
    move-exception v1

    .line 225
    .local v1, "e":Ljava/io/IOException;
    :try_start_5
    const-string v5, "ImageCache"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "getBitmapFromDiskCache - "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 228
    if-eqz v2, :cond_2

    .line 229
    :try_start_6
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 232
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "inputStream":Ljava/io/InputStream;
    :cond_2
    :goto_3
    :try_start_7
    monitor-exit v6
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 234
    const/4 v0, 0x0

    goto :goto_2

    .line 226
    .restart local v2    # "inputStream":Ljava/io/InputStream;
    :catchall_0
    move-exception v5

    .line 228
    if-eqz v2, :cond_3

    .line 229
    :try_start_8
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_5
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 232
    :cond_3
    :goto_4
    :try_start_9
    throw v5

    .line 207
    .end local v2    # "inputStream":Ljava/io/InputStream;
    :catchall_1
    move-exception v5

    monitor-exit v6
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    throw v5

    .line 228
    .restart local v2    # "inputStream":Ljava/io/InputStream;
    .restart local v4    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    :cond_4
    if-eqz v2, :cond_2

    .line 229
    :try_start_a
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_2
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    goto :goto_3

    .line 231
    :catch_2
    move-exception v5

    goto :goto_3

    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    :catch_3
    move-exception v5

    goto :goto_1

    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v4    # "snapshot":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    .restart local v1    # "e":Ljava/io/IOException;
    :catch_4
    move-exception v5

    goto :goto_3

    .end local v1    # "e":Ljava/io/IOException;
    :catch_5
    move-exception v7

    goto :goto_4
.end method

.method public getBitmapFromMemCache(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 2
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 188
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    if-eqz v1, :cond_0

    .line 189
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mMemoryCache:Lnet/tsz/afinal/bitmap/core/LruMemoryCache;

    invoke-virtual {v1, p1}, Lnet/tsz/afinal/bitmap/core/LruMemoryCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 190
    .local v0, "memBitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 194
    .end local v0    # "memBitmap":Landroid/graphics/Bitmap;
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public initDiskCache()V
    .locals 8

    .prologue
    .line 106
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v3

    .line 107
    :try_start_0
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-virtual {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->isClosed()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 108
    :cond_0
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget-object v0, v2, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->diskCacheDir:Ljava/io/File;

    .line 109
    .local v0, "diskCacheDir":Ljava/io/File;
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget-boolean v2, v2, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->diskCacheEnabled:Z

    if-eqz v2, :cond_2

    if-eqz v0, :cond_2

    .line 110
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_1

    .line 111
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 113
    :cond_1
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/BitmapCommonUtils;->getUsableSpace(Ljava/io/File;)J

    move-result-wide v4

    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget v2, v2, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->diskCacheSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    int-to-long v6, v2

    cmp-long v2, v4, v6

    if-lez v2, :cond_2

    .line 115
    const/4 v2, 0x1

    const/4 v4, 0x1

    :try_start_1
    iget-object v5, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget v5, v5, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->diskCacheSize:I

    int-to-long v5, v5

    invoke-static {v0, v2, v4, v5, v6}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->open(Ljava/io/File;IIJ)Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    move-result-object v2

    iput-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskLruCache:Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 123
    .end local v0    # "diskCacheDir":Ljava/io/File;
    :cond_2
    :goto_0
    const/4 v2, 0x0

    :try_start_2
    iput-boolean v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheStarting:Z

    .line 124
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mDiskCacheLock:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->notifyAll()V

    .line 106
    monitor-exit v3

    .line 126
    return-void

    .line 116
    .restart local v0    # "diskCacheDir":Ljava/io/File;
    :catch_0
    move-exception v1

    .line 117
    .local v1, "e":Ljava/io/IOException;
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    const/4 v4, 0x0

    iput-object v4, v2, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->diskCacheDir:Ljava/io/File;

    .line 118
    const-string v2, "ImageCache"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "initDiskCache - "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 106
    .end local v0    # "diskCacheDir":Ljava/io/File;
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method

.method public setCompressFormat(Landroid/graphics/Bitmap$CompressFormat;)V
    .locals 1
    .param p1, "format"    # Landroid/graphics/Bitmap$CompressFormat;

    .prologue
    .line 329
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/BitmapCache;->mCacheParams:Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->setCompressFormat(Landroid/graphics/Bitmap$CompressFormat;)V

    .line 330
    return-void
.end method
