.class public Lcom/nostra13/universalimageloader/core/DefaultConfigurationFactory;
.super Ljava/lang/Object;
.source "DefaultConfigurationFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/nostra13/universalimageloader/core/DefaultConfigurationFactory$DefaultThreadFactory;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createBitmapDisplayer()Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;
    .locals 1

    .prologue
    .line 124
    new-instance v0, Lcom/nostra13/universalimageloader/core/display/SimpleBitmapDisplayer;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/display/SimpleBitmapDisplayer;-><init>()V

    return-object v0
.end method

.method public static createDiscCache(Landroid/content/Context;Lcom/nostra13/universalimageloader/cache/disc/naming/FileNameGenerator;II)Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "discCacheFileNameGenerator"    # Lcom/nostra13/universalimageloader/cache/disc/naming/FileNameGenerator;
    .param p2, "discCacheSize"    # I
    .param p3, "discCacheFileCount"    # I

    .prologue
    .line 72
    if-lez p2, :cond_0

    .line 73
    invoke-static {p0}, Lcom/nostra13/universalimageloader/utils/StorageUtils;->getIndividualCacheDirectory(Landroid/content/Context;)Ljava/io/File;

    move-result-object v1

    .line 74
    .local v1, "individualCacheDir":Ljava/io/File;
    new-instance v2, Lcom/nostra13/universalimageloader/cache/disc/impl/TotalSizeLimitedDiscCache;

    invoke-direct {v2, v1, p1, p2}, Lcom/nostra13/universalimageloader/cache/disc/impl/TotalSizeLimitedDiscCache;-><init>(Ljava/io/File;Lcom/nostra13/universalimageloader/cache/disc/naming/FileNameGenerator;I)V

    .line 80
    .end local v1    # "individualCacheDir":Ljava/io/File;
    :goto_0
    return-object v2

    .line 75
    :cond_0
    if-lez p3, :cond_1

    .line 76
    invoke-static {p0}, Lcom/nostra13/universalimageloader/utils/StorageUtils;->getIndividualCacheDirectory(Landroid/content/Context;)Ljava/io/File;

    move-result-object v1

    .line 77
    .restart local v1    # "individualCacheDir":Ljava/io/File;
    new-instance v2, Lcom/nostra13/universalimageloader/cache/disc/impl/FileCountLimitedDiscCache;

    invoke-direct {v2, v1, p1, p3}, Lcom/nostra13/universalimageloader/cache/disc/impl/FileCountLimitedDiscCache;-><init>(Ljava/io/File;Lcom/nostra13/universalimageloader/cache/disc/naming/FileNameGenerator;I)V

    goto :goto_0

    .line 79
    .end local v1    # "individualCacheDir":Ljava/io/File;
    :cond_1
    invoke-static {p0}, Lcom/nostra13/universalimageloader/utils/StorageUtils;->getCacheDirectory(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 80
    .local v0, "cacheDir":Ljava/io/File;
    new-instance v2, Lcom/nostra13/universalimageloader/cache/disc/impl/UnlimitedDiscCache;

    invoke-direct {v2, v0, p1}, Lcom/nostra13/universalimageloader/cache/disc/impl/UnlimitedDiscCache;-><init>(Ljava/io/File;Lcom/nostra13/universalimageloader/cache/disc/naming/FileNameGenerator;)V

    goto :goto_0
.end method

.method public static createExecutor(IILcom/nostra13/universalimageloader/core/assist/QueueProcessingType;)Ljava/util/concurrent/Executor;
    .locals 9
    .param p0, "threadPoolSize"    # I
    .param p1, "threadPriority"    # I
    .param p2, "tasksProcessingType"    # Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;

    .prologue
    .line 60
    sget-object v0, Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;->LIFO:Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;

    if-ne p2, v0, :cond_0

    const/4 v8, 0x1

    .line 61
    .local v8, "lifo":Z
    :goto_0
    if-eqz v8, :cond_1

    new-instance v6, Lcom/nostra13/universalimageloader/core/assist/deque/LIFOLinkedBlockingDeque;

    invoke-direct {v6}, Lcom/nostra13/universalimageloader/core/assist/deque/LIFOLinkedBlockingDeque;-><init>()V

    .line 62
    .local v6, "taskQueue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    :goto_1
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v3, 0x0

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/DefaultConfigurationFactory;->createThreadFactory(I)Ljava/util/concurrent/ThreadFactory;

    move-result-object v7

    move v1, p0

    move v2, p0

    invoke-direct/range {v0 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    return-object v0

    .line 60
    .end local v6    # "taskQueue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    .end local v8    # "lifo":Z
    :cond_0
    const/4 v8, 0x0

    goto :goto_0

    .line 61
    .restart local v8    # "lifo":Z
    :cond_1
    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    goto :goto_1
.end method

.method public static createFileNameGenerator()Lcom/nostra13/universalimageloader/cache/disc/naming/FileNameGenerator;
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/nostra13/universalimageloader/cache/disc/naming/HashCodeFileNameGenerator;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/cache/disc/naming/HashCodeFileNameGenerator;-><init>()V

    return-object v0
.end method

.method public static createImageDecoder(Z)Lcom/nostra13/universalimageloader/core/decode/ImageDecoder;
    .locals 1
    .param p0, "loggingEnabled"    # Z

    .prologue
    .line 119
    new-instance v0, Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder;

    invoke-direct {v0, p0}, Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder;-><init>(Z)V

    return-object v0
.end method

.method public static createImageDownloader(Landroid/content/Context;)Lcom/nostra13/universalimageloader/core/download/ImageDownloader;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 114
    new-instance v0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;

    invoke-direct {v0, p0}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public static createMemoryCache(I)Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;
    .locals 5
    .param p0, "memoryCacheSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 100
    if-nez p0, :cond_0

    .line 101
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Runtime;->maxMemory()J

    move-result-wide v1

    const-wide/16 v3, 0x8

    div-long/2addr v1, v3

    long-to-int p0, v1

    .line 104
    :cond_0
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x9

    if-lt v1, v2, :cond_1

    .line 105
    new-instance v0, Lcom/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache;

    invoke-direct {v0, p0}, Lcom/nostra13/universalimageloader/cache/memory/impl/LruMemoryCache;-><init>(I)V

    .line 109
    .local v0, "memoryCache":Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;, "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware<Ljava/lang/String;Landroid/graphics/Bitmap;>;"
    :goto_0
    return-object v0

    .line 107
    .end local v0    # "memoryCache":Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;, "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware<Ljava/lang/String;Landroid/graphics/Bitmap;>;"
    :cond_1
    new-instance v0, Lcom/nostra13/universalimageloader/cache/memory/impl/LRULimitedMemoryCache;

    invoke-direct {v0, p0}, Lcom/nostra13/universalimageloader/cache/memory/impl/LRULimitedMemoryCache;-><init>(I)V

    .restart local v0    # "memoryCache":Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;, "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware<Ljava/lang/String;Landroid/graphics/Bitmap;>;"
    goto :goto_0
.end method

.method public static createReserveDiscCache(Landroid/content/Context;)Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 86
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v0

    .line 87
    .local v0, "cacheDir":Ljava/io/File;
    new-instance v1, Ljava/io/File;

    const-string v2, "uil-images"

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 88
    .local v1, "individualDir":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->mkdir()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 89
    :cond_0
    move-object v0, v1

    .line 91
    :cond_1
    new-instance v2, Lcom/nostra13/universalimageloader/cache/disc/impl/TotalSizeLimitedDiscCache;

    const/high16 v3, 0x200000

    invoke-direct {v2, v0, v3}, Lcom/nostra13/universalimageloader/cache/disc/impl/TotalSizeLimitedDiscCache;-><init>(Ljava/io/File;I)V

    return-object v2
.end method

.method private static createThreadFactory(I)Ljava/util/concurrent/ThreadFactory;
    .locals 1
    .param p0, "threadPriority"    # I

    .prologue
    .line 129
    new-instance v0, Lcom/nostra13/universalimageloader/core/DefaultConfigurationFactory$DefaultThreadFactory;

    invoke-direct {v0, p0}, Lcom/nostra13/universalimageloader/core/DefaultConfigurationFactory$DefaultThreadFactory;-><init>(I)V

    return-object v0
.end method
