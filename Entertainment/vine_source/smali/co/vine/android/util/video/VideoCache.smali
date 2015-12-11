.class public Lco/vine/android/util/video/VideoCache;
.super Lco/vine/android/util/UrlResourceCache;
.source "VideoCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lco/vine/android/util/UrlResourceCache",
        "<",
        "Lco/vine/android/util/video/VideoKey;",
        "Lco/vine/android/util/video/UrlVideo;",
        "Ljava/io/File;",
        ">;"
    }
.end annotation


# static fields
.field private static final AVG_LOCK:[I

.field private static final CACHE_NAME:Ljava/lang/String; = "video_cache"

.field private static final INDEX_TIMESTAMP:I = 0x1

.field private static final INDEX_VIDEO_BYTES:I = 0x0

.field private static final LOCK:[I

.field private static final MAX_AVERAGE:I = 0x5

.field private static final MAX_EXTERNAL_DISK_CACHE_SIZE:I = 0x9600000

.field private static final MAX_INTERNAL_DISK_CACHE_SIZE:I = 0x3200000

.field private static final VALUE_COUNT:I = 0x2

.field private static final VERSION:I = 0x2

.field private static averagePosition:I

.field private static final averages:[I

.field private static numberRecorded:I

.field private static sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

.field private static sIsCacheInitialized:Z


# instance fields
.field private final mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/util/video/VideoListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 35
    new-array v0, v1, [I

    sput-object v0, Lco/vine/android/util/video/VideoCache;->LOCK:[I

    .line 37
    sput-boolean v1, Lco/vine/android/util/video/VideoCache;->sIsCacheInitialized:Z

    .line 42
    const/4 v0, 0x5

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/util/video/VideoCache;->averages:[I

    .line 43
    sput v1, Lco/vine/android/util/video/VideoCache;->averagePosition:I

    .line 44
    sput v1, Lco/vine/android/util/video/VideoCache;->numberRecorded:I

    .line 45
    new-array v0, v1, [I

    sput-object v0, Lco/vine/android/util/video/VideoCache;->AVG_LOCK:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "maxCacheSize"    # I

    .prologue
    .line 86
    invoke-direct {p0, p1, p2}, Lco/vine/android/util/UrlResourceCache;-><init>(Landroid/content/Context;I)V

    .line 87
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/util/video/VideoCache;->mListeners:Ljava/util/ArrayList;

    .line 88
    return-void
.end method

.method public static evictExpiredEntries(Landroid/content/Context;I)V
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "lifetime"    # I

    .prologue
    .line 163
    invoke-static {p0}, Lco/vine/android/util/video/VideoCache;->getCacheInstance(Landroid/content/Context;)Lcom/vandalsoftware/io/DiskLruCache;

    move-result-object v4

    .line 164
    .local v4, "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    new-instance v5, Ljava/util/LinkedHashSet;

    invoke-virtual {v4}, Lcom/vandalsoftware/io/DiskLruCache;->getLruEntries()Ljava/util/LinkedHashMap;

    move-result-object v10

    invoke-virtual {v10}, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;

    move-result-object v10

    invoke-direct {v5, v10}, Ljava/util/LinkedHashSet;-><init>(Ljava/util/Collection;)V

    .line 165
    .local v5, "entrySet":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Ljava/lang/String;>;"
    invoke-virtual {v5}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .line 167
    .local v7, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    :try_start_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    .line 168
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 169
    .local v8, "key":Ljava/lang/String;
    const/4 v10, 0x1

    invoke-virtual {v4, v8, v10}, Lcom/vandalsoftware/io/DiskLruCache;->get(Ljava/lang/String;Z)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;

    move-result-object v9

    .line 170
    .local v9, "snapshot":Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    if-eqz v9, :cond_0

    .line 175
    const/16 v10, 0x8

    invoke-static {v10}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v3

    .line 176
    .local v3, "buffer":Ljava/nio/ByteBuffer;
    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v6

    .line 177
    .local v6, "is":Ljava/io/InputStream;
    const/16 v10, 0x8

    new-array v2, v10, [B

    .line 178
    .local v2, "b":[B
    const/4 v10, 0x0

    const/16 v11, 0x8

    invoke-virtual {v6, v2, v10, v11}, Ljava/io/InputStream;->read([BII)I

    move-result v10

    if-lez v10, :cond_0

    .line 179
    invoke-virtual {v3, v2}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    move-result-object v10

    invoke-virtual {v10}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 180
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->getLong()J

    move-result-wide v12

    sub-long v0, v10, v12

    .line 181
    .local v0, "age":J
    int-to-long v10, p1

    const-wide/32 v12, 0x36ee80

    mul-long/2addr v10, v12

    cmp-long v10, v0, v10

    if-lez v10, :cond_1

    .line 182
    invoke-virtual {v4, v8}, Lcom/vandalsoftware/io/DiskLruCache;->remove(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 189
    .end local v0    # "age":J
    .end local v2    # "b":[B
    .end local v3    # "buffer":Ljava/nio/ByteBuffer;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v8    # "key":Ljava/lang/String;
    .end local v9    # "snapshot":Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    :catch_0
    move-exception v10

    .line 191
    :cond_1
    return-void
.end method

.method protected static getCacheDir()Ljava/io/File;
    .locals 2

    .prologue
    .line 229
    sget-object v1, Lco/vine/android/util/video/VideoCache;->LOCK:[I

    monitor-enter v1

    .line 230
    :try_start_0
    sget-object v0, Lco/vine/android/util/video/VideoCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    if-eqz v0, :cond_0

    .line 231
    sget-object v0, Lco/vine/android/util/video/VideoCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    invoke-virtual {v0}, Lcom/vandalsoftware/io/DiskLruCache;->getDirectory()Ljava/io/File;

    move-result-object v0

    monitor-exit v1

    .line 233
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 235
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static getCacheInstance(Landroid/content/Context;)Lcom/vandalsoftware/io/DiskLruCache;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 124
    sget-object v3, Lco/vine/android/util/video/VideoCache;->LOCK:[I

    monitor-enter v3

    .line 125
    :try_start_0
    sget-boolean v2, Lco/vine/android/util/video/VideoCache;->sIsCacheInitialized:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_0

    .line 126
    const/4 v1, 0x0

    .line 128
    .local v1, "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :try_start_1
    invoke-static {p0}, Lco/vine/android/util/Util;->getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 129
    .local v0, "cacheDir":Ljava/io/File;
    if-eqz v0, :cond_1

    .line 130
    const-wide/32 v4, 0x9600000

    const/4 v2, 0x0

    invoke-static {v0, v4, v5, v2}, Lco/vine/android/util/video/VideoCache;->prepareCache(Ljava/io/File;JZ)Lcom/vandalsoftware/io/DiskLruCache;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 143
    .end local v0    # "cacheDir":Ljava/io/File;
    :goto_0
    :try_start_2
    sput-object v1, Lco/vine/android/util/video/VideoCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    .line 144
    const/4 v2, 0x1

    sput-boolean v2, Lco/vine/android/util/video/VideoCache;->sIsCacheInitialized:Z

    .line 146
    .end local v1    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :cond_0
    sget-object v2, Lco/vine/android/util/video/VideoCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    return-object v2

    .line 132
    .restart local v0    # "cacheDir":Ljava/io/File;
    .restart local v1    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :cond_1
    :try_start_3
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xe

    if-ge v2, v4, :cond_2

    .line 133
    const-string v2, "video_cache"

    const/4 v4, 0x1

    invoke-virtual {p0, v2, v4}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v2

    const-wide/32 v4, 0x3200000

    const/4 v6, 0x0

    invoke-static {v2, v4, v5, v6}, Lco/vine/android/util/video/VideoCache;->prepareCache(Ljava/io/File;JZ)Lcom/vandalsoftware/io/DiskLruCache;

    move-result-object v1

    goto :goto_0

    .line 137
    :cond_2
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v2

    const-wide/32 v4, 0x3200000

    const/4 v6, 0x0

    invoke-static {v2, v4, v5, v6}, Lco/vine/android/util/video/VideoCache;->prepareCache(Ljava/io/File;JZ)Lcom/vandalsoftware/io/DiskLruCache;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v1

    goto :goto_0

    .line 147
    .end local v0    # "cacheDir":Ljava/io/File;
    .end local v1    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :catchall_0
    move-exception v2

    :try_start_4
    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v2

    .line 141
    .restart local v1    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public static getCurrentAverageSpeed()I
    .locals 6

    .prologue
    .line 65
    sget-object v4, Lco/vine/android/util/video/VideoCache;->AVG_LOCK:[I

    monitor-enter v4

    .line 66
    const/4 v2, 0x0

    .line 67
    .local v2, "total":I
    :try_start_0
    sget v3, Lco/vine/android/util/video/VideoCache;->numberRecorded:I

    if-nez v3, :cond_0

    .line 68
    const v3, 0x7fffffff

    monitor-exit v4

    .line 74
    :goto_0
    return v3

    .line 70
    :cond_0
    sget v3, Lco/vine/android/util/video/VideoCache;->numberRecorded:I

    const/4 v5, 0x5

    invoke-static {v3, v5}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 71
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v0, :cond_1

    .line 72
    sget-object v3, Lco/vine/android/util/video/VideoCache;->averages:[I

    aget v3, v3, v1

    add-int/2addr v2, v3

    .line 71
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 74
    :cond_1
    div-int v3, v2, v0

    monitor-exit v4

    goto :goto_0

    .line 75
    .end local v0    # "count":I
    .end local v1    # "i":I
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method public static invalidateCache()V
    .locals 2

    .prologue
    .line 151
    sget-object v1, Lco/vine/android/util/video/VideoCache;->LOCK:[I

    monitor-enter v1

    .line 152
    const/4 v0, 0x0

    :try_start_0
    sput-object v0, Lco/vine/android/util/video/VideoCache;->sDiskCache:Lcom/vandalsoftware/io/DiskLruCache;

    .line 153
    const/4 v0, 0x0

    sput-boolean v0, Lco/vine/android/util/video/VideoCache;->sIsCacheInitialized:Z

    .line 154
    monitor-exit v1

    .line 155
    return-void

    .line 154
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static prepareCache(Ljava/io/File;JZ)Lcom/vandalsoftware/io/DiskLruCache;
    .locals 10
    .param p0, "dir"    # Ljava/io/File;
    .param p1, "absMax"    # J
    .param p3, "appendCacheName"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 195
    const-wide/16 v0, -0x1

    .line 197
    .local v0, "available":J
    :try_start_0
    new-instance v5, Landroid/os/StatFs;

    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    .line 199
    .local v5, "stat":Landroid/os/StatFs;
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const/16 v7, 0x12

    if-lt v6, v7, :cond_0

    .line 201
    :try_start_1
    invoke-virtual {v5}, Landroid/os/StatFs;->getBlockSizeLong()J

    move-result-wide v6

    invoke-virtual {v5}, Landroid/os/StatFs;->getAvailableBlocksLong()J
    :try_end_1
    .catch Ljava/lang/NoSuchMethodError; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-wide v8

    mul-long v0, v6, v8

    .line 207
    :cond_0
    :goto_0
    const-wide/16 v6, 0x0

    cmp-long v6, v0, v6

    if-gez v6, :cond_1

    .line 208
    :try_start_2
    invoke-virtual {v5}, Landroid/os/StatFs;->getBlockSize()I

    move-result v6

    int-to-long v6, v6

    invoke-virtual {v5}, Landroid/os/StatFs;->getAvailableBlocks()I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-result v8

    int-to-long v8, v8

    mul-long v0, v6, v8

    .line 214
    .end local v5    # "stat":Landroid/os/StatFs;
    :cond_1
    :goto_1
    const-wide/16 v6, 0x0

    cmp-long v6, v0, v6

    if-gez v6, :cond_2

    .line 215
    invoke-virtual {p0}, Ljava/io/File;->getUsableSpace()J

    move-result-wide v0

    .line 218
    :cond_2
    const-wide/16 v6, 0x0

    cmp-long v6, v0, v6

    if-lez v6, :cond_5

    .line 219
    cmp-long v6, v0, p1

    if-lez v6, :cond_4

    move-wide v3, p1

    .line 223
    .local v3, "maxSize":J
    :goto_2
    const-string v6, "Preparing a DiskLruCache with absMax={}, available={}, maxSize={}"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-static {v6, v7, v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 225
    if-eqz p3, :cond_3

    new-instance v6, Ljava/io/File;

    const-string v7, "video_cache"

    invoke-direct {v6, p0, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    move-object p0, v6

    .end local p0    # "dir":Ljava/io/File;
    :cond_3
    const/4 v6, 0x2

    const/4 v7, 0x2

    invoke-static {p0, v6, v7, v3, v4}, Lcom/vandalsoftware/io/DiskLruCache;->open(Ljava/io/File;IIJ)Lcom/vandalsoftware/io/DiskLruCache;

    move-result-object v6

    return-object v6

    .line 211
    .end local v3    # "maxSize":J
    .restart local p0    # "dir":Ljava/io/File;
    :catch_0
    move-exception v2

    .line 212
    .local v2, "e":Ljava/lang/Exception;
    const-string v6, "Failed to statf, but it is ok, we will get the aval size in other ways on this phone."

    invoke-static {v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_1

    .line 219
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_4
    const-wide/16 v6, 0xa

    div-long v3, v0, v6

    goto :goto_2

    .line 221
    :cond_5
    move-wide v3, p1

    .restart local v3    # "maxSize":J
    goto :goto_2

    .line 202
    .end local v3    # "maxSize":J
    .restart local v5    # "stat":Landroid/os/StatFs;
    :catch_1
    move-exception v6

    goto :goto_0
.end method

.method private static reportAverageSpeed(I)V
    .locals 4
    .param p0, "speed"    # I

    .prologue
    .line 55
    sget-object v2, Lco/vine/android/util/video/VideoCache;->AVG_LOCK:[I

    monitor-enter v2

    .line 56
    :try_start_0
    const-string v1, "Latest download speed: {}"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 57
    sget v1, Lco/vine/android/util/video/VideoCache;->averagePosition:I

    rem-int/lit8 v0, v1, 0x5

    .line 58
    .local v0, "nextPos":I
    sget-object v1, Lco/vine/android/util/video/VideoCache;->averages:[I

    aput p0, v1, v0

    .line 59
    add-int/lit8 v1, v0, 0x1

    rem-int/lit8 v1, v1, 0x5

    sput v1, Lco/vine/android/util/video/VideoCache;->averagePosition:I

    .line 60
    sget v1, Lco/vine/android/util/video/VideoCache;->numberRecorded:I

    add-int/lit8 v1, v1, 0x1

    sput v1, Lco/vine/android/util/video/VideoCache;->numberRecorded:I

    .line 61
    monitor-exit v2

    .line 62
    return-void

    .line 61
    .end local v0    # "nextPos":I
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public static resetAverageSpeed()V
    .locals 2

    .prologue
    .line 48
    sget-object v1, Lco/vine/android/util/video/VideoCache;->AVG_LOCK:[I

    monitor-enter v1

    .line 49
    const/4 v0, 0x0

    :try_start_0
    sput v0, Lco/vine/android/util/video/VideoCache;->averagePosition:I

    .line 50
    const/4 v0, 0x0

    sput v0, Lco/vine/android/util/video/VideoCache;->numberRecorded:I

    .line 51
    monitor-exit v1

    .line 52
    return-void

    .line 51
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public addListener(Lco/vine/android/util/video/VideoListener;)V
    .locals 1
    .param p1, "listener"    # Lco/vine/android/util/video/VideoListener;

    .prologue
    .line 244
    iget-object v0, p0, Lco/vine/android/util/video/VideoCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 245
    return-void
.end method

.method public get(JLco/vine/android/util/video/VideoKey;)Lco/vine/android/util/video/UrlVideo;
    .locals 6
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/video/VideoKey;

    .prologue
    .line 120
    iget-object v4, p3, Lco/vine/android/util/video/VideoKey;->url:Ljava/lang/String;

    const/4 v5, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    invoke-super/range {v0 .. v5}, Lco/vine/android/util/UrlResourceCache;->get(JLjava/lang/Object;Ljava/lang/String;Z)Lco/vine/android/util/UrlResource;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/video/UrlVideo;

    return-object v0
.end method

.method public getFile(JLco/vine/android/util/video/VideoKey;Z)Ljava/lang/String;
    .locals 7
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p4, "peekOnly"    # Z

    .prologue
    .line 101
    iget-object v4, p3, Lco/vine/android/util/video/VideoKey;->url:Ljava/lang/String;

    const/4 v5, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/util/video/VideoCache;->get(JLjava/lang/Object;Ljava/lang/String;Z)Lco/vine/android/util/UrlResource;

    move-result-object v6

    check-cast v6, Lco/vine/android/util/video/UrlVideo;

    .line 102
    .local v6, "video":Lco/vine/android/util/video/UrlVideo;
    if-eqz v6, :cond_0

    .line 103
    iget-object v0, v6, Lco/vine/android/util/video/UrlVideo;->value:Ljava/lang/Object;

    check-cast v0, Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 105
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
    .line 28
    check-cast p1, Lco/vine/android/util/video/VideoKey;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p3, Ljava/io/File;

    .end local p3    # "x2":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lco/vine/android/util/video/VideoCache;->instantiateResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/File;)Lco/vine/android/util/video/UrlVideo;

    move-result-object v0

    return-object v0
.end method

.method protected instantiateResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/File;)Lco/vine/android/util/video/UrlVideo;
    .locals 1
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "file"    # Ljava/io/File;

    .prologue
    .line 346
    new-instance v0, Lco/vine/android/util/video/UrlVideo;

    invoke-direct {v0, p2, p3}, Lco/vine/android/util/video/UrlVideo;-><init>(Ljava/lang/String;Ljava/io/File;)V

    return-object v0
.end method

.method protected bridge synthetic loadResource(JLjava/lang/Object;Ljava/lang/String;)Lco/vine/android/util/UrlResource;
    .locals 1
    .param p1, "x0"    # J
    .param p3, "x1"    # Ljava/lang/Object;
    .param p4, "x2"    # Ljava/lang/String;

    .prologue
    .line 28
    check-cast p3, Lco/vine/android/util/video/VideoKey;

    .end local p3    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3, p4}, Lco/vine/android/util/video/VideoCache;->loadResource(JLco/vine/android/util/video/VideoKey;Ljava/lang/String;)Lco/vine/android/util/video/UrlVideo;

    move-result-object v0

    return-object v0
.end method

.method protected loadResource(JLco/vine/android/util/video/VideoKey;Ljava/lang/String;)Lco/vine/android/util/video/UrlVideo;
    .locals 7
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p4, "url"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 258
    invoke-static {p4}, Lco/vine/android/util/Util;->md5Digest(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 259
    .local v1, "diskCacheKey":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 278
    :goto_0
    return-object v3

    .line 262
    :cond_0
    const/4 v2, 0x0

    .line 263
    .local v2, "snapshot":Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    sget-object v4, Lco/vine/android/util/video/VideoCache;->LOCK:[I

    monitor-enter v4

    .line 264
    :try_start_0
    iget-object v5, p0, Lco/vine/android/util/video/VideoCache;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/video/VideoCache;->getCacheInstance(Landroid/content/Context;)Lcom/vandalsoftware/io/DiskLruCache;

    move-result-object v0

    .line 265
    .local v0, "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/vandalsoftware/io/DiskLruCache;->isClosed()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v5

    if-nez v5, :cond_2

    .line 267
    :try_start_1
    invoke-virtual {v0, v1}, Lcom/vandalsoftware/io/DiskLruCache;->get(Ljava/lang/String;)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v2

    .line 268
    if-nez v2, :cond_1

    .line 274
    :try_start_2
    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    monitor-exit v4

    goto :goto_0

    .line 277
    .end local v0    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3

    .line 271
    .restart local v0    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    :cond_1
    :try_start_3
    new-instance v5, Ljava/io/File;

    const/4 v6, 0x0

    invoke-virtual {v2, v6}, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->getPath(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p3, p4, v5}, Lco/vine/android/util/video/VideoCache;->instantiateResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/File;)Lco/vine/android/util/video/UrlVideo;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v3

    .line 274
    :try_start_4
    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    monitor-exit v4

    goto :goto_0

    .line 272
    :catch_0
    move-exception v5

    .line 274
    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 277
    :cond_2
    monitor-exit v4

    goto :goto_0

    .line 274
    :catchall_1
    move-exception v3

    invoke-static {v2}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    throw v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method protected bridge synthetic obtainResource(Ljava/lang/Object;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/UrlResource;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/io/InputStream;

    .prologue
    .line 28
    check-cast p1, Lco/vine/android/util/video/VideoKey;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lco/vine/android/util/video/VideoCache;->obtainResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/video/UrlVideo;

    move-result-object v0

    return-object v0
.end method

.method protected obtainResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/video/UrlVideo;
    .locals 16
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "is"    # Ljava/io/InputStream;

    .prologue
    .line 366
    move-object/from16 v0, p0

    iget-object v12, v0, Lco/vine/android/util/video/VideoCache;->mContext:Landroid/content/Context;

    invoke-static {v12}, Lco/vine/android/util/Util;->getCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v2

    .line 368
    .local v2, "cacheDir":Ljava/io/File;
    if-eqz v2, :cond_1

    .line 369
    invoke-static/range {p2 .. p2}, Lco/vine/android/util/Util;->md5Digest(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 370
    .local v5, "md5":Ljava/lang/String;
    if-nez v5, :cond_0

    .line 371
    const/16 v12, 0xa

    invoke-static {v12}, Lco/vine/android/util/Util;->randomString(I)Ljava/lang/String;

    move-result-object v5

    .line 373
    :cond_0
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v2, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 378
    .local v4, "f":Ljava/io/File;
    const/4 v6, 0x0

    .line 380
    .local v6, "out":Ljava/io/FileOutputStream;
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    .line 381
    .local v8, "startTime":J
    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 382
    .end local v6    # "out":Ljava/io/FileOutputStream;
    .local v7, "out":Ljava/io/FileOutputStream;
    const/16 v12, 0x1000

    :try_start_1
    move-object/from16 v0, p3

    invoke-static {v0, v7, v12}, Lco/vine/android/util/Util;->readFullyWriteTo(Ljava/io/InputStream;Ljava/io/OutputStream;I)I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v1

    .line 383
    .local v1, "bytesLen":I
    if-nez v1, :cond_2

    .line 384
    const/4 v12, 0x0

    .line 398
    invoke-static {v7}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 400
    .end local v1    # "bytesLen":I
    .end local v4    # "f":Ljava/io/File;
    .end local v5    # "md5":Ljava/lang/String;
    .end local v7    # "out":Ljava/io/FileOutputStream;
    .end local v8    # "startTime":J
    :goto_0
    return-object v12

    .line 375
    :cond_1
    const-string v12, "cache dir is null."

    invoke-static {v12}, Lcom/edisonwang/android/slog/SLog;->w(Ljava/lang/String;)V

    .line 376
    const/4 v12, 0x0

    goto :goto_0

    .line 386
    .restart local v1    # "bytesLen":I
    .restart local v4    # "f":Ljava/io/File;
    .restart local v5    # "md5":Ljava/lang/String;
    .restart local v7    # "out":Ljava/io/FileOutputStream;
    .restart local v8    # "startTime":J
    :cond_2
    :try_start_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    sub-long/2addr v12, v8

    const-wide/16 v14, 0x3e8

    div-long v10, v12, v14

    .line 387
    .local v10, "time":J
    if-lez v1, :cond_3

    .line 388
    const-string v12, "Download time: {}."

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    invoke-static {v12, v13}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 389
    div-int/lit16 v12, v1, 0x400

    int-to-double v12, v12

    const-wide/16 v14, 0x1

    invoke-static {v14, v15, v10, v11}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v14

    long-to-double v14, v14

    div-double/2addr v12, v14

    invoke-static {v12, v13}, Ljava/lang/Math;->round(D)J

    move-result-wide v12

    long-to-int v12, v12

    invoke-static {v12}, Lco/vine/android/util/video/VideoCache;->reportAverageSpeed(I)V

    .line 393
    :goto_1
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->flush()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 398
    invoke-static {v7}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 400
    new-instance v12, Lco/vine/android/util/video/UrlVideo;

    move-object/from16 v0, p2

    invoke-direct {v12, v0, v4}, Lco/vine/android/util/video/UrlVideo;-><init>(Ljava/lang/String;Ljava/io/File;)V

    goto :goto_0

    .line 391
    :cond_3
    :try_start_3
    const-string v12, "Invalid bytesLen or time: {}"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-static {v12, v13}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_1

    .line 394
    .end local v1    # "bytesLen":I
    .end local v10    # "time":J
    :catch_0
    move-exception v3

    move-object v6, v7

    .line 395
    .end local v7    # "out":Ljava/io/FileOutputStream;
    .end local v8    # "startTime":J
    .local v3, "e":Ljava/io/IOException;
    .restart local v6    # "out":Ljava/io/FileOutputStream;
    :goto_2
    :try_start_4
    const-string v12, "Failed to download file."

    invoke-static {v12, v3}, Lcom/edisonwang/android/slog/SLog;->w(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 396
    const/4 v12, 0x0

    .line 398
    invoke-static {v6}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    goto :goto_0

    .end local v3    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v12

    :goto_3
    invoke-static {v6}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    throw v12

    .end local v6    # "out":Ljava/io/FileOutputStream;
    .restart local v7    # "out":Ljava/io/FileOutputStream;
    .restart local v8    # "startTime":J
    :catchall_1
    move-exception v12

    move-object v6, v7

    .end local v7    # "out":Ljava/io/FileOutputStream;
    .restart local v6    # "out":Ljava/io/FileOutputStream;
    goto :goto_3

    .line 394
    .end local v8    # "startTime":J
    :catch_1
    move-exception v3

    goto :goto_2
.end method

.method protected onResourceError(Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V
    .locals 2
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 359
    iget-object v1, p0, Lco/vine/android/util/video/VideoCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 360
    iget-object v1, p0, Lco/vine/android/util/video/VideoCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/video/VideoListener;

    invoke-interface {v1, p0, p1, p2}, Lco/vine/android/util/video/VideoListener;->onVideoPathError(Lco/vine/android/util/video/VideoCache;Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V

    .line 359
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 362
    :cond_0
    return-void
.end method

.method protected bridge synthetic onResourceError(Ljava/lang/Object;Lco/vine/android/network/HttpResult;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 28
    check-cast p1, Lco/vine/android/util/video/VideoKey;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/util/video/VideoCache;->onResourceError(Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V

    return-void
.end method

.method protected onResourceLoaded(Ljava/util/HashMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Lco/vine/android/util/video/UrlVideo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 352
    .local p1, "resources":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    iget-object v1, p0, Lco/vine/android/util/video/VideoCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 353
    iget-object v1, p0, Lco/vine/android/util/video/VideoCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/video/VideoListener;

    invoke-interface {v1, p0, p1}, Lco/vine/android/util/video/VideoListener;->onVideoPathObtained(Lco/vine/android/util/video/VideoCache;Ljava/util/HashMap;)V

    .line 352
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 355
    :cond_0
    return-void
.end method

.method public peekPath(Lco/vine/android/util/video/VideoKey;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;

    .prologue
    .line 410
    invoke-super {p0, p1}, Lco/vine/android/util/UrlResourceCache;->peek(Ljava/lang/Object;)Lco/vine/android/util/UrlResource;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/video/UrlVideo;

    .line 411
    .local v0, "video":Lco/vine/android/util/video/UrlVideo;
    if-eqz v0, :cond_0

    .line 412
    iget-object v1, v0, Lco/vine/android/util/video/UrlVideo;->url:Ljava/lang/String;

    .line 414
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public prepopulateVideoCacheForUrl(JLco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;)V
    .locals 7
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "is"    # Ljava/io/InputStream;

    .prologue
    .line 282
    const/4 v6, 0x0

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/util/video/VideoCache;->saveResource(JLco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/video/UrlVideo;

    .line 283
    const/4 v0, 0x0

    invoke-virtual {p0, p3, p4, v0}, Lco/vine/android/util/video/VideoCache;->instantiateResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/File;)Lco/vine/android/util/video/UrlVideo;

    .line 284
    return-void
.end method

.method public removeListener(Lco/vine/android/util/video/VideoListener;)V
    .locals 1
    .param p1, "listener"    # Lco/vine/android/util/video/VideoListener;

    .prologue
    .line 253
    iget-object v0, p0, Lco/vine/android/util/video/VideoCache;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 254
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
    .line 28
    move-object v3, p3

    check-cast v3, Lco/vine/android/util/video/VideoKey;

    move-object v0, p0

    move-wide v1, p1

    move-object v4, p4

    move-object v5, p5

    move v6, p6

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/util/video/VideoCache;->saveResource(JLco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/video/UrlVideo;

    move-result-object v0

    return-object v0
.end method

.method protected saveResource(JLco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/video/UrlVideo;
    .locals 24
    .param p1, "ownerId"    # J
    .param p3, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "is"    # Ljava/io/InputStream;
    .param p6, "reportSpeed"    # Z

    .prologue
    .line 288
    invoke-static/range {p4 .. p4}, Lco/vine/android/util/Util;->md5Digest(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 289
    .local v7, "diskCacheKey":Ljava/lang/String;
    const/4 v9, 0x0

    .line 290
    .local v9, "editor":Lcom/vandalsoftware/io/DiskLruCache$Editor;
    const/4 v11, 0x0

    .line 291
    .local v11, "ret":Lco/vine/android/util/video/UrlVideo;
    sget-object v19, Lco/vine/android/util/video/VideoCache;->LOCK:[I

    monitor-enter v19

    .line 292
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/util/video/VideoCache;->mContext:Landroid/content/Context;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lco/vine/android/util/video/VideoCache;->getCacheInstance(Landroid/content/Context;)Lcom/vandalsoftware/io/DiskLruCache;

    move-result-object v6

    .line 293
    .local v6, "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    if-eqz v6, :cond_8

    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache;->isClosed()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result v18

    if-nez v18, :cond_8

    .line 294
    const/4 v15, 0x0

    .line 296
    .local v15, "success":Z
    :try_start_1
    invoke-virtual {v6, v7}, Lcom/vandalsoftware/io/DiskLruCache;->edit(Ljava/lang/String;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    move-result-object v9

    .line 297
    if-eqz v9, :cond_1

    .line 298
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v13

    .line 299
    .local v13, "startTime":J
    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-virtual {v9, v0}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v18

    const/16 v20, 0x1000

    move-object/from16 v0, p5

    move-object/from16 v1, v18

    move/from16 v2, v20

    invoke-static {v0, v1, v2}, Lco/vine/android/util/Util;->readFullyWriteTo(Ljava/io/InputStream;Ljava/io/OutputStream;I)I

    move-result v5

    .line 301
    .local v5, "bytesLen":I
    if-lez v5, :cond_3

    const/4 v15, 0x1

    .line 302
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v20

    sub-long v20, v20, v13

    const-wide/16 v22, 0x3e8

    div-long v16, v20, v22

    .line 304
    .local v16, "time":J
    const-string v18, "Bytes {} Download time: {}."

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v20

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v21

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 305
    if-lez v5, :cond_0

    if-eqz p6, :cond_0

    .line 306
    div-int/lit16 v0, v5, 0x400

    move/from16 v18, v0

    move/from16 v0, v18

    int-to-double v0, v0

    move-wide/from16 v20, v0

    const-wide/16 v22, 0x1

    move-wide/from16 v0, v22

    move-wide/from16 v2, v16

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v22

    move-wide/from16 v0, v22

    long-to-double v0, v0

    move-wide/from16 v22, v0

    div-double v20, v20, v22

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->round(D)J

    move-result-wide v20

    move-wide/from16 v0, v20

    long-to-int v0, v0

    move/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lco/vine/android/util/video/VideoCache;->reportAverageSpeed(I)V

    .line 309
    :cond_0
    const/16 v18, 0x8

    invoke-static/range {v18 .. v18}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v4

    .line 310
    .local v4, "buffer":Ljava/nio/ByteBuffer;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v20

    move-wide/from16 v0, v20

    invoke-virtual {v4, v0, v1}, Ljava/nio/ByteBuffer;->putLong(J)Ljava/nio/ByteBuffer;

    .line 311
    const/16 v18, 0x1

    move/from16 v0, v18

    invoke-virtual {v9, v0}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v18

    invoke-virtual {v4}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write([B)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 316
    .end local v4    # "buffer":Ljava/nio/ByteBuffer;
    .end local v5    # "bytesLen":I
    .end local v13    # "startTime":J
    .end local v16    # "time":J
    :cond_1
    if-eqz v9, :cond_2

    .line 320
    if-eqz v15, :cond_4

    .line 321
    :try_start_2
    invoke-virtual {v9}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->commit()V

    .line 322
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache;->flush()V

    .line 323
    new-instance v10, Ljava/io/File;

    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-virtual {v6, v7, v0}, Lcom/vandalsoftware/io/DiskLruCache;->get(Ljava/lang/String;Z)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;

    move-result-object v18

    const/16 v20, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->getPath(I)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-direct {v10, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 325
    .local v10, "f":Ljava/io/File;
    new-instance v12, Lco/vine/android/util/video/UrlVideo;

    move-object/from16 v0, p4

    invoke-direct {v12, v0, v10}, Lco/vine/android/util/video/UrlVideo;-><init>(Ljava/lang/String;Ljava/io/File;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .end local v11    # "ret":Lco/vine/android/util/video/UrlVideo;
    .local v12, "ret":Lco/vine/android/util/video/UrlVideo;
    move-object v11, v12

    .line 340
    .end local v10    # "f":Ljava/io/File;
    .end local v12    # "ret":Lco/vine/android/util/video/UrlVideo;
    .end local v15    # "success":Z
    .restart local v11    # "ret":Lco/vine/android/util/video/UrlVideo;
    :cond_2
    :goto_1
    :try_start_3
    monitor-exit v19
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 341
    return-object v11

    .line 301
    .restart local v5    # "bytesLen":I
    .restart local v13    # "startTime":J
    .restart local v15    # "success":Z
    :cond_3
    const/4 v15, 0x0

    goto/16 :goto_0

    .line 327
    .end local v5    # "bytesLen":I
    .end local v13    # "startTime":J
    :cond_4
    :try_start_4
    invoke-virtual {v9}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V

    .line 328
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/util/video/VideoCache;->obtainResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/video/UrlVideo;

    move-result-object v11

    .line 329
    const-string v18, "Failed to save a video to DiskLruCache"

    invoke-static/range {v18 .. v18}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_1

    .line 331
    :catch_0
    move-exception v18

    goto :goto_1

    .line 313
    :catch_1
    move-exception v8

    .line 314
    .local v8, "e":Ljava/io/IOException;
    const/4 v15, 0x0

    .line 316
    if-eqz v9, :cond_2

    .line 320
    if-eqz v15, :cond_5

    .line 321
    :try_start_5
    invoke-virtual {v9}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->commit()V

    .line 322
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache;->flush()V

    .line 323
    new-instance v10, Ljava/io/File;

    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-virtual {v6, v7, v0}, Lcom/vandalsoftware/io/DiskLruCache;->get(Ljava/lang/String;Z)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;

    move-result-object v18

    const/16 v20, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->getPath(I)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-direct {v10, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 325
    .restart local v10    # "f":Ljava/io/File;
    new-instance v12, Lco/vine/android/util/video/UrlVideo;

    move-object/from16 v0, p4

    invoke-direct {v12, v0, v10}, Lco/vine/android/util/video/UrlVideo;-><init>(Ljava/lang/String;Ljava/io/File;)V

    .end local v11    # "ret":Lco/vine/android/util/video/UrlVideo;
    .restart local v12    # "ret":Lco/vine/android/util/video/UrlVideo;
    move-object v11, v12

    .line 326
    .end local v12    # "ret":Lco/vine/android/util/video/UrlVideo;
    .restart local v11    # "ret":Lco/vine/android/util/video/UrlVideo;
    goto :goto_1

    .line 327
    .end local v10    # "f":Ljava/io/File;
    :cond_5
    invoke-virtual {v9}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V

    .line 328
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/util/video/VideoCache;->obtainResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/video/UrlVideo;

    move-result-object v11

    .line 329
    const-string v18, "Failed to save a video to DiskLruCache"

    invoke-static/range {v18 .. v18}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_1

    .line 331
    :catch_2
    move-exception v18

    goto :goto_1

    .line 316
    .end local v8    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v18

    if-eqz v9, :cond_6

    .line 320
    if-eqz v15, :cond_7

    .line 321
    :try_start_6
    invoke-virtual {v9}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->commit()V

    .line 322
    invoke-virtual {v6}, Lcom/vandalsoftware/io/DiskLruCache;->flush()V

    .line 323
    new-instance v10, Ljava/io/File;

    const/16 v20, 0x0

    move/from16 v0, v20

    invoke-virtual {v6, v7, v0}, Lcom/vandalsoftware/io/DiskLruCache;->get(Ljava/lang/String;Z)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;

    move-result-object v20

    const/16 v21, 0x0

    invoke-virtual/range {v20 .. v21}, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;->getPath(I)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-direct {v10, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 325
    .restart local v10    # "f":Ljava/io/File;
    new-instance v12, Lco/vine/android/util/video/UrlVideo;

    move-object/from16 v0, p4

    invoke-direct {v12, v0, v10}, Lco/vine/android/util/video/UrlVideo;-><init>(Ljava/lang/String;Ljava/io/File;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .end local v11    # "ret":Lco/vine/android/util/video/UrlVideo;
    .restart local v12    # "ret":Lco/vine/android/util/video/UrlVideo;
    move-object v11, v12

    .line 332
    .end local v10    # "f":Ljava/io/File;
    .end local v12    # "ret":Lco/vine/android/util/video/UrlVideo;
    .restart local v11    # "ret":Lco/vine/android/util/video/UrlVideo;
    :cond_6
    :goto_2
    :try_start_7
    throw v18

    .line 340
    .end local v6    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    .end local v15    # "success":Z
    :catchall_1
    move-exception v18

    monitor-exit v19
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    throw v18

    .line 327
    .restart local v6    # "diskCache":Lcom/vandalsoftware/io/DiskLruCache;
    .restart local v15    # "success":Z
    :cond_7
    :try_start_8
    invoke-virtual {v9}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V

    .line 328
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/util/video/VideoCache;->obtainResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/video/UrlVideo;

    move-result-object v11

    .line 329
    const-string v20, "Failed to save a video to DiskLruCache"

    invoke-static/range {v20 .. v20}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_3
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    goto :goto_2

    .line 331
    :catch_3
    move-exception v20

    goto :goto_2

    .line 337
    .end local v15    # "success":Z
    :cond_8
    :try_start_9
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/util/video/VideoCache;->obtainResource(Lco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/video/UrlVideo;

    move-result-object v11

    .line 338
    const-string v18, "Videos DiskLruCache could not be opened"

    invoke-static/range {v18 .. v18}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    goto/16 :goto_1
.end method
