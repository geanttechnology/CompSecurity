.class public Lcom/nostra13/universalimageloader/core/ImageLoader;
.super Ljava/lang/Object;
.source "ImageLoader.java"


# static fields
.field private static final ERROR_INIT_CONFIG_WITH_NULL:Ljava/lang/String; = "ImageLoader configuration can not be initialized with null"

.field private static final ERROR_NOT_INIT:Ljava/lang/String; = "ImageLoader must be init with configuration before using"

.field private static final ERROR_WRONG_ARGUMENTS:Ljava/lang/String; = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)"

.field static final LOG_DESTROY:Ljava/lang/String; = "Destroy ImageLoader"

.field static final LOG_INIT_CONFIG:Ljava/lang/String; = "Initialize ImageLoader with configuration"

.field static final LOG_LOAD_IMAGE_FROM_MEMORY_CACHE:Ljava/lang/String; = "Load image from memory cache [%s]"

.field public static final TAG:Ljava/lang/String;

.field private static final WARNING_RE_INIT_CONFIG:Ljava/lang/String; = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first."

.field private static volatile instance:Lcom/nostra13/universalimageloader/core/ImageLoader;


# instance fields
.field private configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

.field private final emptyListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

.field private engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

.field private final fakeBitmapDisplayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const-class v0, Lcom/nostra13/universalimageloader/core/ImageLoader;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/nostra13/universalimageloader/core/ImageLoader;->TAG:Ljava/lang/String;

    .line 66
    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    new-instance v0, Lcom/nostra13/universalimageloader/core/assist/SimpleImageLoadingListener;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/assist/SimpleImageLoadingListener;-><init>()V

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->emptyListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 64
    new-instance v0, Lcom/nostra13/universalimageloader/core/display/FakeBitmapDisplayer;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/display/FakeBitmapDisplayer;-><init>()V

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->fakeBitmapDisplayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    .line 81
    return-void
.end method

.method private checkConfiguration()V
    .locals 2

    .prologue
    .line 438
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    if-nez v0, :cond_0

    .line 439
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "ImageLoader must be init with configuration before using"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 441
    :cond_0
    return-void
.end method

.method public static getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;
    .locals 2

    .prologue
    .line 70
    sget-object v0, Lcom/nostra13/universalimageloader/core/ImageLoader;->instance:Lcom/nostra13/universalimageloader/core/ImageLoader;

    if-nez v0, :cond_1

    .line 71
    const-class v1, Lcom/nostra13/universalimageloader/core/ImageLoader;

    monitor-enter v1

    .line 72
    :try_start_0
    sget-object v0, Lcom/nostra13/universalimageloader/core/ImageLoader;->instance:Lcom/nostra13/universalimageloader/core/ImageLoader;

    if-nez v0, :cond_0

    .line 73
    new-instance v0, Lcom/nostra13/universalimageloader/core/ImageLoader;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;-><init>()V

    sput-object v0, Lcom/nostra13/universalimageloader/core/ImageLoader;->instance:Lcom/nostra13/universalimageloader/core/ImageLoader;

    .line 71
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 77
    :cond_1
    sget-object v0, Lcom/nostra13/universalimageloader/core/ImageLoader;->instance:Lcom/nostra13/universalimageloader/core/ImageLoader;

    return-object v0

    .line 71
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method


# virtual methods
.method public cancelDisplayTask(Landroid/widget/ImageView;)V
    .locals 1
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 507
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v0, p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->cancelDisplayTaskFor(Landroid/widget/ImageView;)V

    .line 508
    return-void
.end method

.method public clearDiscCache()V
    .locals 1

    .prologue
    .line 487
    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->checkConfiguration()V

    .line 488
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object v0, v0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->discCache:Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;

    invoke-interface {v0}, Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;->clear()V

    .line 489
    return-void
.end method

.method public clearMemoryCache()V
    .locals 1

    .prologue
    .line 463
    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->checkConfiguration()V

    .line 464
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object v0, v0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->memoryCache:Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;

    invoke-interface {v0}, Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;->clear()V

    .line 465
    return-void
.end method

.method public denyNetworkDownloads(Z)V
    .locals 1
    .param p1, "denyNetworkDownloads"    # Z

    .prologue
    .line 523
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v0, p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->denyNetworkDownloads(Z)V

    .line 524
    return-void
.end method

.method public destroy()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 568
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-boolean v0, v0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->loggingEnabled:Z

    if-eqz v0, :cond_0

    .line 569
    const-string v0, "Destroy ImageLoader"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/nostra13/universalimageloader/utils/L;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 570
    :cond_0
    invoke-virtual {p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->stop()V

    .line 571
    iput-object v2, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    .line 572
    iput-object v2, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    .line 573
    return-void
.end method

.method public displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    const/4 v0, 0x0

    .line 140
    invoke-virtual {p0, p1, p2, v0, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 141
    return-void
.end method

.method public displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "options"    # Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .prologue
    .line 169
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 170
    return-void
.end method

.method public displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V
    .locals 10
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "options"    # Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    .param p4, "listener"    # Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .prologue
    const/4 v5, 0x0

    .line 229
    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->checkConfiguration()V

    .line 230
    if-nez p2, :cond_0

    .line 231
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 233
    :cond_0
    if-nez p4, :cond_1

    .line 234
    iget-object p4, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->emptyListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 236
    :cond_1
    if-nez p3, :cond_2

    .line 237
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object p3, v1, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->defaultDisplayImageOptions:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 240
    :cond_2
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 241
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v1, p2}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->cancelDisplayTaskFor(Landroid/widget/ImageView;)V

    .line 242
    invoke-interface {p4, p1, p2}, Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;->onLoadingStarted(Ljava/lang/String;Landroid/view/View;)V

    .line 243
    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->shouldShowImageForEmptyUri()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 244
    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->getImageForEmptyUri()I

    move-result v1

    invoke-virtual {p2, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 248
    :goto_0
    invoke-interface {p4, p1, p2, v5}, Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;->onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V

    .line 291
    :goto_1
    return-void

    .line 246
    :cond_3
    invoke-virtual {p2, v5}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 253
    :cond_4
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget v1, v1, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->maxImageWidthForMemoryCache:I

    .line 254
    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget v2, v2, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->maxImageHeightForMemoryCache:I

    .line 252
    invoke-static {p2, v1, v2}, Lcom/nostra13/universalimageloader/utils/ImageSizeUtils;->defineTargetSizeForView(Landroid/widget/ImageView;II)Lcom/nostra13/universalimageloader/core/assist/ImageSize;

    move-result-object v3

    .line 255
    .local v3, "targetSize":Lcom/nostra13/universalimageloader/core/assist/ImageSize;
    invoke-static {p1, v3}, Lcom/nostra13/universalimageloader/core/assist/MemoryCacheUtil;->generateKey(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/assist/ImageSize;)Ljava/lang/String;

    move-result-object v4

    .line 256
    .local v4, "memoryCacheKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v1, p2, v4}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->prepareDisplayTaskFor(Landroid/widget/ImageView;Ljava/lang/String;)V

    .line 258
    invoke-interface {p4, p1, p2}, Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;->onLoadingStarted(Ljava/lang/String;Landroid/view/View;)V

    .line 259
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object v1, v1, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->memoryCache:Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;

    invoke-interface {v1, v4}, Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/graphics/Bitmap;

    .line 260
    .local v8, "bmp":Landroid/graphics/Bitmap;
    if-eqz v8, :cond_7

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v1

    if-nez v1, :cond_7

    .line 261
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-boolean v1, v1, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->loggingEnabled:Z

    if-eqz v1, :cond_5

    .line 262
    const-string v1, "Load image from memory cache [%s]"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v4, v2, v5

    invoke-static {v1, v2}, Lcom/nostra13/universalimageloader/utils/L;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 264
    :cond_5
    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->shouldPostProcess()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 265
    new-instance v0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;

    .line 267
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v1, p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->getLockForUri(Ljava/lang/String;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v7

    move-object v1, p1

    move-object v2, p2

    move-object v5, p3

    move-object v6, p4

    .line 265
    invoke-direct/range {v0 .. v7}, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;-><init>(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/assist/ImageSize;Ljava/lang/String;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;Ljava/util/concurrent/locks/ReentrantLock;)V

    .line 268
    .local v0, "imageLoadingInfo":Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    new-instance v9, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;

    .line 269
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->getHandler()Landroid/os/Handler;

    move-result-object v2

    .line 268
    invoke-direct {v9, v1, v8, v0, v2}, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;-><init>(Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;Landroid/graphics/Bitmap;Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;Landroid/os/Handler;)V

    .line 270
    .local v9, "displayTask":Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v1, v9}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->submit(Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;)V

    goto :goto_1

    .line 272
    .end local v0    # "imageLoadingInfo":Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    .end local v9    # "displayTask":Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;
    :cond_6
    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->getDisplayer()Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    move-result-object v1

    invoke-interface {v1, v8, p2}, Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;->display(Landroid/graphics/Bitmap;Landroid/widget/ImageView;)Landroid/graphics/Bitmap;

    .line 273
    invoke-interface {p4, p1, p2, v8}, Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;->onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V

    goto :goto_1

    .line 276
    :cond_7
    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->shouldShowStubImage()Z

    move-result v1

    if-eqz v1, :cond_9

    .line 277
    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->getStubImage()I

    move-result v1

    invoke-virtual {p2, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 284
    :cond_8
    :goto_2
    new-instance v0, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;

    .line 286
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v1, p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->getLockForUri(Ljava/lang/String;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v7

    move-object v1, p1

    move-object v2, p2

    move-object v5, p3

    move-object v6, p4

    .line 284
    invoke-direct/range {v0 .. v7}, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;-><init>(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/assist/ImageSize;Ljava/lang/String;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;Ljava/util/concurrent/locks/ReentrantLock;)V

    .line 287
    .restart local v0    # "imageLoadingInfo":Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    new-instance v9, Lcom/nostra13/universalimageloader/core/LoadAndDisplayImageTask;

    .line 288
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->getHandler()Landroid/os/Handler;

    move-result-object v2

    .line 287
    invoke-direct {v9, v1, v0, v2}, Lcom/nostra13/universalimageloader/core/LoadAndDisplayImageTask;-><init>(Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;Landroid/os/Handler;)V

    .line 289
    .local v9, "displayTask":Lcom/nostra13/universalimageloader/core/LoadAndDisplayImageTask;
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v1, v9}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->submit(Lcom/nostra13/universalimageloader/core/LoadAndDisplayImageTask;)V

    goto/16 :goto_1

    .line 279
    .end local v0    # "imageLoadingInfo":Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    .end local v9    # "displayTask":Lcom/nostra13/universalimageloader/core/LoadAndDisplayImageTask;
    :cond_9
    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->isResetViewBeforeLoading()Z

    move-result v1

    if-eqz v1, :cond_8

    .line 280
    invoke-virtual {p2, v5}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_2
.end method

.method public displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "listener"    # Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .prologue
    .line 197
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 198
    return-void
.end method

.method public getDiscCache()Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;
    .locals 1

    .prologue
    .line 475
    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->checkConfiguration()V

    .line 476
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object v0, v0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->discCache:Lcom/nostra13/universalimageloader/cache/disc/DiscCacheAware;

    return-object v0
.end method

.method public getLoadingUriForView(Landroid/widget/ImageView;)Ljava/lang/String;
    .locals 1
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 496
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v0, p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->getLoadingUriForView(Landroid/widget/ImageView;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMemoryCache()Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 451
    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->checkConfiguration()V

    .line 452
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object v0, v0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->memoryCache:Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;

    return-object v0
.end method

.method public handleSlowNetwork(Z)V
    .locals 1
    .param p1, "handleSlowNetwork"    # Z

    .prologue
    .line 537
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v0, p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->handleSlowNetwork(Z)V

    .line 538
    return-void
.end method

.method public declared-synchronized init(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;)V
    .locals 2
    .param p1, "configuration"    # Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    .prologue
    .line 97
    monitor-enter p0

    if-nez p1, :cond_0

    .line 98
    :try_start_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "ImageLoader configuration can not be initialized with null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 97
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 100
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    if-nez v0, :cond_2

    .line 101
    iget-boolean v0, p1, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->loggingEnabled:Z

    if-eqz v0, :cond_1

    .line 102
    const-string v0, "Initialize ImageLoader with configuration"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/nostra13/universalimageloader/utils/L;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 103
    :cond_1
    new-instance v0, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-direct {v0, p1}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;-><init>(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;)V

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    .line 104
    iput-object p1, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 108
    :goto_0
    monitor-exit p0

    return-void

    .line 106
    :cond_2
    :try_start_2
    const-string v0, "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first."

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/nostra13/universalimageloader/utils/L;->w(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public isInited()Z
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "options"    # Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    .param p3, "listener"    # Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .prologue
    .line 369
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, p2, p3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/assist/ImageSize;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 370
    return-void
.end method

.method public loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .prologue
    const/4 v0, 0x0

    .line 311
    invoke-virtual {p0, p1, v0, v0, p2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/assist/ImageSize;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 312
    return-void
.end method

.method public loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/assist/ImageSize;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V
    .locals 5
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "targetImageSize"    # Lcom/nostra13/universalimageloader/core/assist/ImageSize;
    .param p3, "options"    # Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    .param p4, "listener"    # Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .prologue
    .line 405
    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->checkConfiguration()V

    .line 406
    if-nez p2, :cond_0

    .line 407
    new-instance p2, Lcom/nostra13/universalimageloader/core/assist/ImageSize;

    .line 408
    .end local p2    # "targetImageSize":Lcom/nostra13/universalimageloader/core/assist/ImageSize;
    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget v2, v2, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->maxImageWidthForMemoryCache:I

    .line 409
    iget-object v3, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget v3, v3, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->maxImageHeightForMemoryCache:I

    .line 407
    invoke-direct {p2, v2, v3}, Lcom/nostra13/universalimageloader/core/assist/ImageSize;-><init>(II)V

    .line 411
    .restart local p2    # "targetImageSize":Lcom/nostra13/universalimageloader/core/assist/ImageSize;
    :cond_0
    if-nez p3, :cond_1

    .line 412
    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object p3, v2, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->defaultDisplayImageOptions:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 416
    :cond_1
    invoke-virtual {p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->getDisplayer()Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    move-result-object v2

    instance-of v2, v2, Lcom/nostra13/universalimageloader/core/display/FakeBitmapDisplayer;

    if-eqz v2, :cond_2

    .line 417
    move-object v1, p3

    .line 423
    .local v1, "optionsWithFakeDisplayer":Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    :goto_0
    new-instance v0, Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object v2, v2, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->context:Landroid/content/Context;

    invoke-direct {v0, v2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 424
    .local v0, "fakeImage":Landroid/widget/ImageView;
    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {p2}, Lcom/nostra13/universalimageloader/core/assist/ImageSize;->getWidth()I

    move-result v3

    .line 425
    invoke-virtual {p2}, Lcom/nostra13/universalimageloader/core/assist/ImageSize;->getHeight()I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 424
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 426
    sget-object v2, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 428
    invoke-virtual {p0, p1, v0, v1, p4}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 429
    return-void

    .line 419
    .end local v0    # "fakeImage":Landroid/widget/ImageView;
    .end local v1    # "optionsWithFakeDisplayer":Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    :cond_2
    new-instance v2, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    .line 420
    invoke-virtual {v2, p3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cloneFrom(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v2

    iget-object v3, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->fakeBitmapDisplayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    invoke-virtual {v2, v3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->displayer(Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v1

    .line 419
    .restart local v1    # "optionsWithFakeDisplayer":Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    goto :goto_0
.end method

.method public loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/assist/ImageSize;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "minImageSize"    # Lcom/nostra13/universalimageloader/core/assist/ImageSize;
    .param p3, "listener"    # Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .prologue
    .line 339
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/assist/ImageSize;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 340
    return-void
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 546
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->pause()V

    .line 547
    return-void
.end method

.method public resume()V
    .locals 1

    .prologue
    .line 551
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->resume()V

    .line 552
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 559
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/ImageLoader;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->stop()V

    .line 560
    return-void
.end method
