.class public Lco/vine/android/util/image/PhotoImagesCache;
.super Lco/vine/android/util/UrlResourceCache;
.source "PhotoImagesCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lco/vine/android/util/UrlResourceCache",
        "<",
        "Lco/vine/android/util/image/ImageKey;",
        "Lco/vine/android/util/image/UrlImage;",
        "Lco/vine/android/util/image/ImageUtils$BitmapInfo;",
        ">;"
    }
.end annotation


# static fields
.field private static final DISK_CACHE_NAME:Ljava/lang/String; = "photos"

.field private static final INDEX_IMAGE_BYTES:I = 0x0

.field private static final LOCK:[I

.field private static final MAX_EXTERNAL_DISK_CACHE_SIZE:I = 0x6400000

.field private static final MAX_INTERNAL_DISK_CACHE_SIZE:I = 0xa00000

.field private static final VALUE_COUNT:I = 0x1

.field private static final VERSION:I = 0x2

.field private static sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

.field private static sIsCacheInitialized:Z


# instance fields
.field private final mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/util/image/PhotoImagesListener;",
            ">;"
        }
    .end annotation
.end field

.field private final mMaxImageSize:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 54
    new-array v0, v1, [I

    sput-object v0, Lco/vine/android/util/image/PhotoImagesCache;->LOCK:[I

    .line 56
    sput-boolean v1, Lco/vine/android/util/image/PhotoImagesCache;->sIsCacheInitialized:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;II)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "maxImageSize"    # I
    .param p3, "cacheSize"    # I

    .prologue
    .line 67
    invoke-direct {p0, p1, p3}, Lco/vine/android/util/UrlResourceCache;-><init>(Landroid/content/Context;I)V

    .line 68
    iput p2, p0, Lco/vine/android/util/image/PhotoImagesCache;->mMaxImageSize:I

    .line 69
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/util/image/PhotoImagesCache;->mListeners:Ljava/util/ArrayList;

    .line 70
    return-void
.end method

.method static getCacheDir()Ljava/io/File;
    .locals 2

    .prologue
    .line 97
    sget-object v1, Lco/vine/android/util/image/PhotoImagesCache;->LOCK:[I

    monitor-enter v1

    .line 98
    :try_start_0
    sget-object v0, Lco/vine/android/util/image/PhotoImagesCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    if-eqz v0, :cond_0

    .line 99
    sget-object v0, Lco/vine/android/util/image/PhotoImagesCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    invoke-virtual {v0}, Lcom/vandalsoftware/io/DiskLruCache;->getDirectory()Ljava/io/File;

    move-result-object v0

    monitor-exit v1

    .line 101
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 103
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static getDiskLruCache(Landroid/content/Context;)Lcom/vandalsoftware/io/DiskLruCache;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 73
    sget-object v3, Lco/vine/android/util/image/PhotoImagesCache;->LOCK:[I

    monitor-enter v3

    .line 74
    :try_start_0
    sget-boolean v2, Lco/vine/android/util/image/PhotoImagesCache;->sIsCacheInitialized:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_0

    .line 75
    const/4 v1, 0x0

    .line 77
    .local v1, "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :try_start_1
    invoke-static {p0}, Lco/vine/android/util/Util;->getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 78
    .local v0, "cacheDir":Ljava/io/File;
    if-eqz v0, :cond_1

    .line 79
    new-instance v2, Ljava/io/File;

    const-string v4, "photos"

    invoke-direct {v2, v0, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 v4, 0x2

    const/4 v5, 0x1

    const-wide/32 v6, 0x6400000

    invoke-static {v2, v4, v5, v6, v7}, Lcom/vandalsoftware/io/DiskLruCache;->open(Ljava/io/File;IIJ)Lcom/vandalsoftware/io/DiskLruCache;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 89
    .end local v0    # "cacheDir":Ljava/io/File;
    :goto_0
    :try_start_2
    sput-object v1, Lco/vine/android/util/image/PhotoImagesCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    .line 90
    const/4 v2, 0x1

    sput-boolean v2, Lco/vine/android/util/image/PhotoImagesCache;->sIsCacheInitialized:Z

    .line 92
    .end local v1    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :cond_0
    sget-object v2, Lco/vine/android/util/image/PhotoImagesCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    return-object v2

    .line 83
    .restart local v0    # "cacheDir":Ljava/io/File;
    .restart local v1    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :cond_1
    :try_start_3
    new-instance v2, Ljava/io/File;

    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v4

    const-string v5, "photos"

    invoke-direct {v2, v4, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 v4, 0x2

    const/4 v5, 0x1

    const-wide/32 v6, 0xa00000

    invoke-static {v2, v4, v5, v6, v7}, Lcom/vandalsoftware/io/DiskLruCache;->open(Ljava/io/File;IIJ)Lcom/vandalsoftware/io/DiskLruCache;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v1

    goto :goto_0

    .line 93
    .end local v0    # "cacheDir":Ljava/io/File;
    .end local v1    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :catchall_0
    move-exception v2

    :try_start_4
    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v2

    .line 87
    .restart local v1    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public static invalidateCache()V
    .locals 2

    .prologue
    .line 354
    sget-object v1, Lco/vine/android/util/image/PhotoImagesCache;->LOCK:[I

    monitor-enter v1

    .line 355
    const/4 v0, 0x0

    :try_start_0
    sput-object v0, Lco/vine/android/util/image/PhotoImagesCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    .line 356
    const/4 v0, 0x0

    sput-boolean v0, Lco/vine/android/util/image/PhotoImagesCache;->sIsCacheInitialized:Z

    .line 357
    monitor-exit v1

    .line 358
    return-void

    .line 357
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public addListener(Lco/vine/android/util/image/PhotoImagesListener;)V
    .locals 1
    .param p1, "listener"    # Lco/vine/android/util/image/PhotoImagesListener;

    .prologue
    .line 112
    iget-object v0, p0, Lco/vine/android/util/image/PhotoImagesCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 113
    return-void
.end method

.method public clearMemory()V
    .locals 5

    .prologue
    .line 321
    sget-object v4, Lco/vine/android/util/image/PhotoImagesCache;->LOCK:[I

    monitor-enter v4

    .line 322
    :try_start_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {p0}, Lco/vine/android/util/image/PhotoImagesCache;->snapShot()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 323
    .local v1, "snapshot":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/util/image/UrlImage;>;"
    invoke-virtual {p0}, Lco/vine/android/util/image/PhotoImagesCache;->clear()V

    .line 324
    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 325
    .local v2, "v":Lco/vine/android/util/image/UrlImage;
    iget-object v3, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v3, :cond_0

    .line 326
    iget-object v3, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->recycle()V

    .line 327
    const/4 v3, 0x0

    iput-object v3, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    goto :goto_0

    .line 330
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "snapshot":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/util/image/UrlImage;>;"
    .end local v2    # "v":Lco/vine/android/util/image/UrlImage;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v1    # "snapshot":Ljava/util/Collection;, "Ljava/util/Collection<Lco/vine/android/util/image/UrlImage;>;"
    :cond_1
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 331
    return-void
.end method

.method public get(JLco/vine/android/util/image/ImageKey;)Lco/vine/android/util/image/UrlImage;
    .locals 6
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/image/ImageKey;

    .prologue
    .line 154
    iget-object v4, p3, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    const/4 v5, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    invoke-super/range {v0 .. v5}, Lco/vine/android/util/UrlResourceCache;->get(JLjava/lang/Object;Ljava/lang/String;Z)Lco/vine/android/util/UrlResource;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/image/UrlImage;

    return-object v0
.end method

.method public getBitmap(JLco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;
    .locals 7
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/image/ImageKey;

    .prologue
    .line 135
    iget-object v4, p3, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    const/4 v5, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/util/image/PhotoImagesCache;->get(JLjava/lang/Object;Ljava/lang/String;Z)Lco/vine/android/util/UrlResource;

    move-result-object v6

    check-cast v6, Lco/vine/android/util/image/UrlImage;

    .line 136
    .local v6, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v6, :cond_0

    .line 137
    iget-object v0, v6, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    .line 139
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic instantiateResource(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/UrlResource;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/lang/Object;

    .prologue
    .line 45
    check-cast p1, Lco/vine/android/util/image/ImageKey;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p3, Lco/vine/android/util/image/ImageUtils$BitmapInfo;

    .end local p3    # "x2":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lco/vine/android/util/image/PhotoImagesCache;->instantiateResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Lco/vine/android/util/image/ImageUtils$BitmapInfo;)Lco/vine/android/util/image/UrlImage;

    move-result-object v0

    return-object v0
.end method

.method protected instantiateResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Lco/vine/android/util/image/ImageUtils$BitmapInfo;)Lco/vine/android/util/image/UrlImage;
    .locals 1
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "b"    # Lco/vine/android/util/image/ImageUtils$BitmapInfo;

    .prologue
    .line 174
    new-instance v0, Lco/vine/android/util/image/UrlImage;

    invoke-direct {v0, p2, p3}, Lco/vine/android/util/image/UrlImage;-><init>(Ljava/lang/String;Lco/vine/android/util/image/ImageUtils$BitmapInfo;)V

    return-object v0
.end method

.method protected bridge synthetic loadResource(JLjava/lang/Object;Ljava/lang/String;)Lco/vine/android/util/UrlResource;
    .locals 1
    .param p1, "x0"    # J
    .param p3, "x1"    # Ljava/lang/Object;
    .param p4, "x2"    # Ljava/lang/String;

    .prologue
    .line 45
    check-cast p3, Lco/vine/android/util/image/ImageKey;

    .end local p3    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3, p4}, Lco/vine/android/util/image/PhotoImagesCache;->loadResource(JLco/vine/android/util/image/ImageKey;Ljava/lang/String;)Lco/vine/android/util/image/UrlImage;

    move-result-object v0

    return-object v0
.end method

.method protected loadResource(JLco/vine/android/util/image/ImageKey;Ljava/lang/String;)Lco/vine/android/util/image/UrlImage;
    .locals 9
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p4, "url"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 179
    invoke-static {p4}, Lco/vine/android/util/Util;->md5Digest(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 180
    .local v3, "diskCacheKey":Ljava/lang/String;
    if-nez v3, :cond_0

    .line 209
    :goto_0
    return-object v6

    .line 184
    :cond_0
    const/4 v5, 0x0

    .line 185
    .local v5, "snapshot":Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    const/4 v4, 0x0

    .line 186
    .local v4, "is":Ljava/io/InputStream;
    const/4 v0, 0x0

    .line 187
    .local v0, "bis":Ljava/io/BufferedInputStream;
    sget-object v7, Lco/vine/android/util/image/PhotoImagesCache;->LOCK:[I

    monitor-enter v7

    .line 188
    :try_start_0
    iget-object v8, p0, Lco/vine/android/util/image/PhotoImagesCache;->mContext:Landroid/content/Context;

    invoke-static {v8}, Lco/vine/android/util/image/PhotoImagesCache;->getDiskLruCache(Landroid/content/Context;)Lcom/vandalsoftware/io/DiskLruCache;

    move-result-object v2

    .line 189
    .local v2, "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    if-eqz v2, :cond_3

    invoke-virtual {v2}, Lcom/vandalsoftware/io/DiskLruCache;->isClosed()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v8

    if-nez v8, :cond_3

    .line 191
    :try_start_1
    invoke-virtual {v2, v3}, Lcom/vandalsoftware/io/DiskLruCache;->get(Ljava/lang/String;)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-result-object v5

    .line 192
    if-nez v5, :cond_1

    .line 203
    :try_start_2
    invoke-static {v5}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 204
    invoke-static {v4}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 205
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    monitor-exit v7

    goto :goto_0

    .line 208
    .end local v2    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :catchall_0
    move-exception v6

    :goto_1
    monitor-exit v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v6

    .line 195
    .restart local v2    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :cond_1
    const/4 v8, 0x0

    :try_start_3
    invoke-virtual {v5, v8}, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    move-result-object v4

    .line 196
    if-nez v4, :cond_2

    .line 203
    :try_start_4
    invoke-static {v5}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 204
    invoke-static {v4}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 205
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    monitor-exit v7
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 199
    :cond_2
    :try_start_5
    new-instance v1, Ljava/io/BufferedInputStream;

    const/16 v8, 0x1000

    invoke-direct {v1, v4, v8}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 200
    .end local v0    # "bis":Ljava/io/BufferedInputStream;
    .local v1, "bis":Ljava/io/BufferedInputStream;
    :try_start_6
    invoke-virtual {p0, p3, p4, v1}, Lco/vine/android/util/image/PhotoImagesCache;->obtainResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/image/UrlImage;
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    move-result-object v6

    .line 203
    :try_start_7
    invoke-static {v5}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 204
    invoke-static {v4}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 205
    invoke-static {v1}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    monitor-exit v7
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto :goto_0

    .line 208
    :catchall_1
    move-exception v6

    move-object v0, v1

    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v0    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_1

    .line 201
    :catch_0
    move-exception v8

    .line 203
    :goto_2
    :try_start_8
    invoke-static {v5}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 204
    invoke-static {v4}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 205
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 208
    :cond_3
    monitor-exit v7

    goto :goto_0

    .line 203
    :catchall_2
    move-exception v6

    :goto_3
    invoke-static {v5}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 204
    invoke-static {v4}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 205
    invoke-static {v0}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    throw v6
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 203
    .end local v0    # "bis":Ljava/io/BufferedInputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    :catchall_3
    move-exception v6

    move-object v0, v1

    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v0    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_3

    .line 201
    .end local v0    # "bis":Ljava/io/BufferedInputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    :catch_1
    move-exception v8

    move-object v0, v1

    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v0    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_2
.end method

.method protected bridge synthetic obtainResource(Ljava/lang/Object;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/UrlResource;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/io/InputStream;

    .prologue
    .line 45
    check-cast p1, Lco/vine/android/util/image/ImageKey;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lco/vine/android/util/image/PhotoImagesCache;->obtainResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/image/UrlImage;

    move-result-object v0

    return-object v0
.end method

.method protected obtainResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/image/UrlImage;
    .locals 17
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "is"    # Ljava/io/InputStream;

    .prologue
    .line 269
    move-object/from16 v0, p1

    iget-boolean v13, v0, Lco/vine/android/util/image/ImageKey;->requestResize:Z

    if-eqz v13, :cond_2

    .line 270
    move-object/from16 v0, p1

    iget v12, v0, Lco/vine/android/util/image/ImageKey;->width:I

    .line 271
    .local v12, "width":I
    move-object/from16 v0, p1

    iget v6, v0, Lco/vine/android/util/image/ImageKey;->height:I

    .line 276
    .local v6, "height":I
    :goto_0
    const/4 v8, 0x0

    .line 277
    .local v8, "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    const/4 v5, 0x0

    .line 279
    .local v5, "hasMemoryException":Z
    :try_start_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/util/image/PhotoImagesCache;->mContext:Landroid/content/Context;

    move-object/from16 v0, p3

    invoke-static {v13, v0, v12, v6}, Lco/vine/android/util/image/ImageUtils;->resizeBitmap(Landroid/content/Context;Ljava/io/InputStream;II)Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    :try_end_0
    .catch Lco/vine/android/util/image/ImageUtils$ImageMemoryException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    move-object v9, v8

    .line 283
    .end local v8    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    .local v9, "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    :goto_1
    if-eqz v9, :cond_4

    iget-object v13, v9, Lco/vine/android/util/image/ImageUtils$BitmapInfo;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v13, :cond_4

    .line 284
    iget-object v13, v9, Lco/vine/android/util/image/ImageUtils$BitmapInfo;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v13}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    .line 285
    .local v11, "w":I
    iget-object v13, v9, Lco/vine/android/util/image/ImageUtils$BitmapInfo;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v13}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    .line 286
    .local v4, "h":I
    if-ge v11, v4, :cond_3

    move v10, v11

    .line 287
    .local v10, "r":I
    :goto_2
    move-object/from16 v0, p1

    iget-boolean v13, v0, Lco/vine/android/util/image/ImageKey;->circularCropped:Z

    if-eqz v13, :cond_0

    .line 289
    :try_start_1
    new-instance v8, Lco/vine/android/util/image/ImageUtils$BitmapInfo;

    iget-object v13, v9, Lco/vine/android/util/image/ImageUtils$BitmapInfo;->bitmap:Landroid/graphics/Bitmap;

    invoke-static {v13, v10}, Lco/vine/android/util/image/ImageUtils;->getCroppedBitmap(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;

    move-result-object v13

    invoke-direct {v8, v13, v10, v11, v4}, Lco/vine/android/util/image/ImageUtils$BitmapInfo;-><init>(Landroid/graphics/Bitmap;III)V
    :try_end_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_1 .. :try_end_1} :catch_1

    .end local v9    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    .restart local v8    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    move-object v9, v8

    .line 296
    .end local v8    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    .restart local v9    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    :cond_0
    :goto_3
    :try_start_2
    move-object/from16 v0, p1

    iget-boolean v13, v0, Lco/vine/android/util/image/ImageKey;->blurred:Z

    if-eqz v13, :cond_4

    .line 297
    new-instance v8, Lco/vine/android/util/image/ImageUtils$BitmapInfo;

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/util/image/PhotoImagesCache;->mContext:Landroid/content/Context;

    iget-object v14, v9, Lco/vine/android/util/image/ImageUtils$BitmapInfo;->bitmap:Landroid/graphics/Bitmap;

    move-object/from16 v0, p1

    iget v15, v0, Lco/vine/android/util/image/ImageKey;->blurRadius:I

    move-object/from16 v0, p1

    iget-boolean v0, v0, Lco/vine/android/util/image/ImageKey;->desaturated:Z

    move/from16 v16, v0

    invoke-static/range {v13 .. v16}, Lco/vine/android/util/image/ImageUtils;->getBlurredBitmap(Landroid/content/Context;Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;

    move-result-object v13

    invoke-direct {v8, v13, v10, v11, v4}, Lco/vine/android/util/image/ImageUtils$BitmapInfo;-><init>(Landroid/graphics/Bitmap;III)V
    :try_end_2
    .catch Landroid/support/v8/renderscript/RSRuntimeException; {:try_start_2 .. :try_end_2} :catch_2

    .line 305
    .end local v4    # "h":I
    .end local v9    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    .end local v10    # "r":I
    .end local v11    # "w":I
    .restart local v8    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    :goto_4
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2, v8}, Lco/vine/android/util/image/PhotoImagesCache;->instantiateResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Lco/vine/android/util/image/ImageUtils$BitmapInfo;)Lco/vine/android/util/image/UrlImage;

    move-result-object v7

    .line 306
    .local v7, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v5, :cond_1

    .line 307
    const-string v13, "Decoding error!!! Memory Low? Clear all bitmaps now!"

    invoke-static {v13}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 309
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/util/image/PhotoImagesCache;->clearMemory()V

    .line 311
    :try_start_3
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/util/image/PhotoImagesCache;->mContext:Landroid/content/Context;

    move-object/from16 v0, p3

    invoke-static {v13, v0, v12, v6}, Lco/vine/android/util/image/ImageUtils;->resizeBitmap(Landroid/content/Context;Ljava/io/InputStream;II)Lco/vine/android/util/image/ImageUtils$BitmapInfo;

    move-result-object v13

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2, v13}, Lco/vine/android/util/image/PhotoImagesCache;->instantiateResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Lco/vine/android/util/image/ImageUtils$BitmapInfo;)Lco/vine/android/util/image/UrlImage;
    :try_end_3
    .catch Lco/vine/android/util/image/ImageUtils$ImageMemoryException; {:try_start_3 .. :try_end_3} :catch_3

    move-result-object v7

    .line 316
    .end local v7    # "image":Lco/vine/android/util/image/UrlImage;
    :cond_1
    :goto_5
    return-object v7

    .line 273
    .end local v5    # "hasMemoryException":Z
    .end local v6    # "height":I
    .end local v8    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    .end local v12    # "width":I
    :cond_2
    move-object/from16 v0, p0

    iget v12, v0, Lco/vine/android/util/image/PhotoImagesCache;->mMaxImageSize:I

    .line 274
    .restart local v12    # "width":I
    move-object/from16 v0, p0

    iget v6, v0, Lco/vine/android/util/image/PhotoImagesCache;->mMaxImageSize:I

    .restart local v6    # "height":I
    goto/16 :goto_0

    .line 280
    .restart local v5    # "hasMemoryException":Z
    .restart local v8    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    :catch_0
    move-exception v3

    .line 281
    .local v3, "e":Lco/vine/android/util/image/ImageUtils$ImageMemoryException;
    const/4 v5, 0x1

    move-object v9, v8

    .end local v8    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    .restart local v9    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    goto :goto_1

    .end local v3    # "e":Lco/vine/android/util/image/ImageUtils$ImageMemoryException;
    .restart local v4    # "h":I
    .restart local v11    # "w":I
    :cond_3
    move v10, v4

    .line 286
    goto :goto_2

    .line 290
    .restart local v10    # "r":I
    :catch_1
    move-exception v3

    .line 291
    .local v3, "e":Ljava/lang/OutOfMemoryError;
    const/4 v5, 0x1

    goto :goto_3

    .line 300
    .end local v3    # "e":Ljava/lang/OutOfMemoryError;
    :catch_2
    move-exception v3

    .line 302
    .local v3, "e":Landroid/support/v8/renderscript/RSRuntimeException;
    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .end local v3    # "e":Landroid/support/v8/renderscript/RSRuntimeException;
    .end local v4    # "h":I
    .end local v10    # "r":I
    .end local v11    # "w":I
    :cond_4
    move-object v8, v9

    .end local v9    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    .restart local v8    # "imageInfo":Lco/vine/android/util/image/ImageUtils$BitmapInfo;
    goto :goto_4

    .line 312
    .restart local v7    # "image":Lco/vine/android/util/image/UrlImage;
    :catch_3
    move-exception v3

    .line 313
    .local v3, "e":Lco/vine/android/util/image/ImageUtils$ImageMemoryException;
    const/4 v13, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2, v13}, Lco/vine/android/util/image/PhotoImagesCache;->instantiateResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Lco/vine/android/util/image/ImageUtils$BitmapInfo;)Lco/vine/android/util/image/UrlImage;

    move-result-object v7

    goto :goto_5
.end method

.method protected onResourceError(Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V
    .locals 2
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 167
    iget-object v1, p0, Lco/vine/android/util/image/PhotoImagesCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 168
    iget-object v1, p0, Lco/vine/android/util/image/PhotoImagesCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/image/PhotoImagesListener;

    invoke-interface {v1, p0, p1, p2}, Lco/vine/android/util/image/PhotoImagesListener;->onPhotoImageError(Lco/vine/android/util/image/PhotoImagesCache;Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V

    .line 167
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 170
    :cond_0
    return-void
.end method

.method protected bridge synthetic onResourceError(Ljava/lang/Object;Lco/vine/android/network/HttpResult;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 45
    check-cast p1, Lco/vine/android/util/image/ImageKey;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/util/image/PhotoImagesCache;->onResourceError(Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V

    return-void
.end method

.method protected onResourceLoaded(Ljava/util/HashMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 160
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v1, p0, Lco/vine/android/util/image/PhotoImagesCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 161
    iget-object v1, p0, Lco/vine/android/util/image/PhotoImagesCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/image/PhotoImagesListener;

    invoke-interface {v1, p0, p1}, Lco/vine/android/util/image/PhotoImagesListener;->onPhotoImageLoaded(Lco/vine/android/util/image/PhotoImagesCache;Ljava/util/HashMap;)V

    .line 160
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 163
    :cond_0
    return-void
.end method

.method public peekBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;
    .locals 2
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;

    .prologue
    .line 340
    invoke-super {p0, p1}, Lco/vine/android/util/UrlResourceCache;->peek(Ljava/lang/Object;)Lco/vine/android/util/UrlResource;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/image/UrlImage;

    .line 341
    .local v0, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v0, :cond_0

    .line 342
    iget-object v1, v0, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    .line 344
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public prepopulateThumbnailCacheForUrl(JLco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/FileInputStream;)V
    .locals 7
    .param p1, "ownerId"    # J
    .param p3, "imageKey"    # Lco/vine/android/util/image/ImageKey;
    .param p4, "thumbnailUrl"    # Ljava/lang/String;
    .param p5, "fis"    # Ljava/io/FileInputStream;

    .prologue
    .line 350
    const/4 v6, 0x0

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/util/image/PhotoImagesCache;->saveResource(JLco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/image/UrlImage;

    .line 351
    return-void
.end method

.method public removeListener(Lco/vine/android/util/image/PhotoImagesListener;)V
    .locals 1
    .param p1, "listener"    # Lco/vine/android/util/image/PhotoImagesListener;

    .prologue
    .line 121
    iget-object v0, p0, Lco/vine/android/util/image/PhotoImagesCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 122
    return-void
.end method

.method protected bridge synthetic saveResource(JLjava/lang/Object;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/UrlResource;
    .locals 7
    .param p1, "x0"    # J
    .param p3, "x1"    # Ljava/lang/Object;
    .param p4, "x2"    # Ljava/lang/String;
    .param p5, "x3"    # Ljava/io/InputStream;
    .param p6, "x4"    # Z

    .prologue
    .line 45
    move-object v3, p3

    check-cast v3, Lco/vine/android/util/image/ImageKey;

    move-object v0, p0

    move-wide v1, p1

    move-object v4, p4

    move-object v5, p5

    move v6, p6

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/util/image/PhotoImagesCache;->saveResource(JLco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/image/UrlImage;

    move-result-object v0

    return-object v0
.end method

.method protected saveResource(JLco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/image/UrlImage;
    .locals 14
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "is"    # Ljava/io/InputStream;
    .param p6, "reportSpeed"    # Z

    .prologue
    .line 214
    invoke-static/range {p4 .. p4}, Lco/vine/android/util/Util;->md5Digest(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 215
    .local v4, "diskCacheKey":Ljava/lang/String;
    if-nez v4, :cond_0

    .line 216
    move-object/from16 v0, p3

    move-object/from16 v1, p4

    move-object/from16 v2, p5

    invoke-virtual {p0, v0, v1, v2}, Lco/vine/android/util/image/PhotoImagesCache;->obtainResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/image/UrlImage;

    move-result-object v9

    .line 262
    :goto_0
    return-object v9

    .line 219
    :cond_0
    const/4 v6, 0x0

    .line 220
    .local v6, "editor":Lcom/vandalsoftware/io/DiskLruCache$Editor;
    const/4 v7, 0x0

    .line 221
    .local v7, "os":Ljava/io/BufferedOutputStream;
    sget-object v12, Lco/vine/android/util/image/PhotoImagesCache;->LOCK:[I

    monitor-enter v12

    .line 222
    :try_start_0
    iget-object v11, p0, Lco/vine/android/util/image/PhotoImagesCache;->mContext:Landroid/content/Context;

    invoke-static {v11}, Lco/vine/android/util/image/PhotoImagesCache;->getDiskLruCache(Landroid/content/Context;)Lcom/vandalsoftware/io/DiskLruCache;

    move-result-object v3

    .line 223
    .local v3, "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    if-eqz v3, :cond_7

    invoke-virtual {v3}, Lcom/vandalsoftware/io/DiskLruCache;->isClosed()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v11

    if-nez v11, :cond_7

    .line 224
    const/4 v10, 0x0

    .line 226
    .local v10, "success":Z
    :try_start_1
    invoke-virtual {v3, v4}, Lcom/vandalsoftware/io/DiskLruCache;->edit(Ljava/lang/String;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    move-result-object v6

    .line 227
    if-eqz v6, :cond_3

    .line 228
    new-instance v8, Ljava/io/BufferedOutputStream;

    const/4 v11, 0x0

    invoke-virtual {v6, v11}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v11

    const/16 v13, 0x1000

    invoke-direct {v8, v11, v13}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 230
    .end local v7    # "os":Ljava/io/BufferedOutputStream;
    .local v8, "os":Ljava/io/BufferedOutputStream;
    :try_start_2
    new-instance v11, Lco/vine/android/util/PipingInputStream;

    move-object/from16 v0, p5

    invoke-direct {v11, v0, v8}, Lco/vine/android/util/PipingInputStream;-><init>(Ljava/io/InputStream;Ljava/io/OutputStream;)V

    move-object/from16 v0, p3

    move-object/from16 v1, p4

    invoke-virtual {p0, v0, v1, v11}, Lco/vine/android/util/image/PhotoImagesCache;->obtainResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/image/UrlImage;

    move-result-object v9

    .line 232
    .local v9, "result":Lco/vine/android/util/image/UrlImage;
    invoke-virtual {v9}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v10

    .line 233
    if-eqz v10, :cond_b

    .line 234
    invoke-virtual {v8}, Ljava/io/BufferedOutputStream;->flush()V

    .line 235
    invoke-virtual {v8}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 236
    const/4 v7, 0x0

    .line 245
    .end local v8    # "os":Ljava/io/BufferedOutputStream;
    .restart local v7    # "os":Ljava/io/BufferedOutputStream;
    :goto_1
    if-eqz v6, :cond_1

    .line 249
    if-eqz v10, :cond_2

    .line 250
    :try_start_3
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->commit()V

    .line 251
    invoke-virtual {v3}, Lcom/vandalsoftware/io/DiskLruCache;->flush()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 258
    :cond_1
    :goto_2
    :try_start_4
    invoke-static {v7}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    monitor-exit v12

    goto :goto_0

    .line 261
    .end local v3    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    .end local v9    # "result":Lco/vine/android/util/image/UrlImage;
    .end local v10    # "success":Z
    :catchall_0
    move-exception v11

    monitor-exit v12
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v11

    .line 253
    .restart local v3    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    .restart local v9    # "result":Lco/vine/android/util/image/UrlImage;
    .restart local v10    # "success":Z
    :cond_2
    :try_start_5
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 255
    :catch_0
    move-exception v11

    goto :goto_2

    .line 240
    .end local v9    # "result":Lco/vine/android/util/image/UrlImage;
    :cond_3
    :try_start_6
    move-object/from16 v0, p3

    move-object/from16 v1, p4

    move-object/from16 v2, p5

    invoke-virtual {p0, v0, v1, v2}, Lco/vine/android/util/image/PhotoImagesCache;->obtainResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/image/UrlImage;
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    move-result-object v9

    .line 245
    if-eqz v6, :cond_4

    .line 249
    if-eqz v10, :cond_5

    .line 250
    :try_start_7
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->commit()V

    .line 251
    invoke-virtual {v3}, Lcom/vandalsoftware/io/DiskLruCache;->flush()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 258
    :cond_4
    :goto_3
    :try_start_8
    invoke-static {v7}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    monitor-exit v12
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_0

    .line 253
    :cond_5
    :try_start_9
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_1
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto :goto_3

    .line 255
    :catch_1
    move-exception v11

    goto :goto_3

    .line 242
    :catch_2
    move-exception v5

    .line 243
    .local v5, "e":Ljava/io/IOException;
    :goto_4
    const/4 v10, 0x0

    .line 245
    if-eqz v6, :cond_6

    .line 249
    if-eqz v10, :cond_8

    .line 250
    :try_start_a
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->commit()V

    .line 251
    invoke-virtual {v3}, Lcom/vandalsoftware/io/DiskLruCache;->flush()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_3
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 258
    :cond_6
    :goto_5
    :try_start_b
    invoke-static {v7}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 261
    .end local v5    # "e":Ljava/io/IOException;
    .end local v10    # "success":Z
    :cond_7
    monitor-exit v12
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .line 262
    move-object/from16 v0, p3

    move-object/from16 v1, p4

    move-object/from16 v2, p5

    invoke-virtual {p0, v0, v1, v2}, Lco/vine/android/util/image/PhotoImagesCache;->obtainResource(Lco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/image/UrlImage;

    move-result-object v9

    goto/16 :goto_0

    .line 253
    .restart local v5    # "e":Ljava/io/IOException;
    .restart local v10    # "success":Z
    :cond_8
    :try_start_c
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_3
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    goto :goto_5

    .line 255
    :catch_3
    move-exception v11

    goto :goto_5

    .line 245
    .end local v5    # "e":Ljava/io/IOException;
    :catchall_1
    move-exception v11

    :goto_6
    if-eqz v6, :cond_9

    .line 249
    if-eqz v10, :cond_a

    .line 250
    :try_start_d
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->commit()V

    .line 251
    invoke-virtual {v3}, Lcom/vandalsoftware/io/DiskLruCache;->flush()V
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_4
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    .line 258
    :cond_9
    :goto_7
    :try_start_e
    invoke-static {v7}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    throw v11
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_0

    .line 253
    :cond_a
    :try_start_f
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_4
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    goto :goto_7

    .line 255
    :catch_4
    move-exception v13

    goto :goto_7

    .line 245
    .end local v7    # "os":Ljava/io/BufferedOutputStream;
    .restart local v8    # "os":Ljava/io/BufferedOutputStream;
    :catchall_2
    move-exception v11

    move-object v7, v8

    .end local v8    # "os":Ljava/io/BufferedOutputStream;
    .restart local v7    # "os":Ljava/io/BufferedOutputStream;
    goto :goto_6

    .line 242
    .end local v7    # "os":Ljava/io/BufferedOutputStream;
    .restart local v8    # "os":Ljava/io/BufferedOutputStream;
    :catch_5
    move-exception v5

    move-object v7, v8

    .end local v8    # "os":Ljava/io/BufferedOutputStream;
    .restart local v7    # "os":Ljava/io/BufferedOutputStream;
    goto :goto_4

    .end local v7    # "os":Ljava/io/BufferedOutputStream;
    .restart local v8    # "os":Ljava/io/BufferedOutputStream;
    .restart local v9    # "result":Lco/vine/android/util/image/UrlImage;
    :cond_b
    move-object v7, v8

    .end local v8    # "os":Ljava/io/BufferedOutputStream;
    .restart local v7    # "os":Ljava/io/BufferedOutputStream;
    goto :goto_1
.end method
