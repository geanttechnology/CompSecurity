.class public final Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
.super Ljava/lang/Object;
.source "ImageLoaderConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;
    }
.end annotation


# instance fields
.field final context:Landroid/content/Context;

.field final customExecutor:Z

.field final customExecutorForCachedImages:Z

.field final decoder:Lcom/nostra13/universalimageloader/core/decode/ImageDecoder;

.field final defaultDisplayImageOptions:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

.field final discCache:Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;

.field final downloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

.field final imageCompressFormatForDiscCache:Landroid/graphics/Bitmap$CompressFormat;

.field final imageQualityForDiscCache:I

.field final loggingEnabled:Z

.field final maxImageHeightForDiscCache:I

.field final maxImageHeightForMemoryCache:I

.field final maxImageWidthForDiscCache:I

.field final maxImageWidthForMemoryCache:I

.field final memoryCache:Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field final networkDeniedDownloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

.field final reserveDiscCache:Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;

.field final slowNetworkDownloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

.field final taskExecutor:Ljava/util/concurrent/Executor;

.field final taskExecutorForCachedImages:Ljava/util/concurrent/Executor;

.field final tasksProcessingType:Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;

.field final threadPoolSize:I

.field final threadPriority:I


# direct methods
.method private constructor <init>(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)V
    .locals 2
    .param p1, "builder"    # Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->context:Landroid/content/Context;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$0(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->context:Landroid/content/Context;

    .line 82
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->maxImageWidthForMemoryCache:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$1(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->maxImageWidthForMemoryCache:I

    .line 83
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->maxImageHeightForMemoryCache:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$2(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->maxImageHeightForMemoryCache:I

    .line 84
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->maxImageWidthForDiscCache:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$3(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->maxImageWidthForDiscCache:I

    .line 85
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->maxImageHeightForDiscCache:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$4(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->maxImageHeightForDiscCache:I

    .line 86
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->imageCompressFormatForDiscCache:Landroid/graphics/Bitmap$CompressFormat;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$5(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Landroid/graphics/Bitmap$CompressFormat;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->imageCompressFormatForDiscCache:Landroid/graphics/Bitmap$CompressFormat;

    .line 87
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->imageQualityForDiscCache:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$6(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->imageQualityForDiscCache:I

    .line 88
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->taskExecutor:Ljava/util/concurrent/Executor;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$7(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Ljava/util/concurrent/Executor;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->taskExecutor:Ljava/util/concurrent/Executor;

    .line 89
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->taskExecutorForCachedImages:Ljava/util/concurrent/Executor;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$8(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Ljava/util/concurrent/Executor;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->taskExecutorForCachedImages:Ljava/util/concurrent/Executor;

    .line 90
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->threadPoolSize:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$9(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->threadPoolSize:I

    .line 91
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->threadPriority:I
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$10(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)I

    move-result v0

    iput v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->threadPriority:I

    .line 92
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->tasksProcessingType:Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$11(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->tasksProcessingType:Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;

    .line 93
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->discCache:Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$12(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->discCache:Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;

    .line 94
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->memoryCache:Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$13(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->memoryCache:Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;

    .line 95
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->defaultDisplayImageOptions:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$14(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->defaultDisplayImageOptions:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 96
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->loggingEnabled:Z
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$15(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->loggingEnabled:Z

    .line 97
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->downloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$16(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->downloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

    .line 98
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->decoder:Lcom/nostra13/universalimageloader/core/decode/ImageDecoder;
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$17(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Lcom/nostra13/universalimageloader/core/decode/ImageDecoder;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->decoder:Lcom/nostra13/universalimageloader/core/decode/ImageDecoder;

    .line 100
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->customExecutor:Z
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$18(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->customExecutor:Z

    .line 101
    # getter for: Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->customExecutorForCachedImages:Z
    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->access$19(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->customExecutorForCachedImages:Z

    .line 103
    new-instance v0, Lcom/nostra13/universalimageloader/core/download/NetworkDeniedImageDownloader;

    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->downloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

    invoke-direct {v0, v1}, Lcom/nostra13/universalimageloader/core/download/NetworkDeniedImageDownloader;-><init>(Lcom/nostra13/universalimageloader/core/download/ImageDownloader;)V

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->networkDeniedDownloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

    .line 104
    new-instance v0, Lcom/nostra13/universalimageloader/core/download/SlowNetworkImageDownloader;

    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->downloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

    invoke-direct {v0, v1}, Lcom/nostra13/universalimageloader/core/download/SlowNetworkImageDownloader;-><init>(Lcom/nostra13/universalimageloader/core/download/ImageDownloader;)V

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->slowNetworkDownloader:Lcom/nostra13/universalimageloader/core/download/ImageDownloader;

    .line 106
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->context:Landroid/content/Context;

    invoke-static {v0}, Lcom/nostra13/universalimageloader/core/DefaultConfigurationFactory;->createReserveDiscCache(Landroid/content/Context;)Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->reserveDiscCache:Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;

    .line 107
    return-void
.end method

.method synthetic constructor <init>(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;)V
    .locals 0

    .prologue
    .line 80
    invoke-direct {p0, p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;-><init>(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;)V

    return-void
.end method

.method public static createDefault(Landroid/content/Context;)Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 131
    new-instance v0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    invoke-direct {v0, p0}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->build()Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    move-result-object v0

    return-object v0
.end method
