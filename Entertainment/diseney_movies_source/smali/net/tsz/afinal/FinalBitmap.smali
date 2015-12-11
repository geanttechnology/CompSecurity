.class public Lnet/tsz/afinal/FinalBitmap;
.super Ljava/lang/Object;
.source "FinalBitmap.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;,
        Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;,
        Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;,
        Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;
    }
.end annotation


# static fields
.field private static bitmapLoadAndDisplayExecutor:Ljava/util/concurrent/ExecutorService;

.field private static mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

.field private static mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;


# instance fields
.field private configMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;",
            ">;"
        }
    .end annotation
.end field

.field private mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

.field private mContext:Landroid/content/Context;

.field private mExitTasksEarly:Z

.field private mPauseWork:Z

.field private final mPauseWorkLock:Ljava/lang/Object;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-boolean v0, p0, Lnet/tsz/afinal/FinalBitmap;->mExitTasksEarly:Z

    .line 54
    iput-boolean v0, p0, Lnet/tsz/afinal/FinalBitmap;->mPauseWork:Z

    .line 55
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mPauseWorkLock:Ljava/lang/Object;

    .line 497
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    .line 63
    iput-object p1, p0, Lnet/tsz/afinal/FinalBitmap;->mContext:Landroid/content/Context;

    .line 64
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    invoke-direct {v0, p0, p1}, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;-><init>(Lnet/tsz/afinal/FinalBitmap;Landroid/content/Context;)V

    iput-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    .line 66
    const-string v0, "afinalCache"

    invoke-static {p1, v0}, Lnet/tsz/afinal/bitmap/core/BitmapCommonUtils;->getDiskCacheDir(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lnet/tsz/afinal/FinalBitmap;->configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;

    .line 67
    new-instance v0, Lnet/tsz/afinal/bitmap/display/SimpleDisplayer;

    invoke-direct {v0}, Lnet/tsz/afinal/bitmap/display/SimpleDisplayer;-><init>()V

    invoke-virtual {p0, v0}, Lnet/tsz/afinal/FinalBitmap;->configDisplayer(Lnet/tsz/afinal/bitmap/display/Displayer;)Lnet/tsz/afinal/FinalBitmap;

    .line 68
    new-instance v0, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader;

    invoke-direct {v0}, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader;-><init>()V

    invoke-virtual {p0, v0}, Lnet/tsz/afinal/FinalBitmap;->configDownlader(Lnet/tsz/afinal/bitmap/download/Downloader;)Lnet/tsz/afinal/FinalBitmap;

    .line 69
    return-void
.end method

.method static synthetic access$0(Lnet/tsz/afinal/FinalBitmap;)V
    .locals 0

    .prologue
    .line 520
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->clearCacheInternalInBackgroud()V

    return-void
.end method

.method static synthetic access$1(Lnet/tsz/afinal/FinalBitmap;)V
    .locals 0

    .prologue
    .line 511
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->initDiskCacheInternalInBackgroud()V

    return-void
.end method

.method static synthetic access$10(Lnet/tsz/afinal/FinalBitmap;)Z
    .locals 1

    .prologue
    .line 54
    iget-boolean v0, p0, Lnet/tsz/afinal/FinalBitmap;->mPauseWork:Z

    return v0
.end method

.method static synthetic access$11()Lnet/tsz/afinal/bitmap/core/BitmapCache;
    .locals 1

    .prologue
    .line 51
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    return-object v0
.end method

.method static synthetic access$12(Lnet/tsz/afinal/FinalBitmap;)Z
    .locals 1

    .prologue
    .line 53
    iget-boolean v0, p0, Lnet/tsz/afinal/FinalBitmap;->mExitTasksEarly:Z

    return v0
.end method

.method static synthetic access$13(Lnet/tsz/afinal/FinalBitmap;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 589
    invoke-direct {p0, p1, p2}, Lnet/tsz/afinal/FinalBitmap;->processBitmap(Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$14(Lnet/tsz/afinal/FinalBitmap;)Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    return-object v0
.end method

.method static synthetic access$15(Landroid/widget/ImageView;)Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;
    .locals 1

    .prologue
    .line 739
    invoke-static {p0}, Lnet/tsz/afinal/FinalBitmap;->getBitmapTaskFromImageView(Landroid/widget/ImageView;)Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2(Lnet/tsz/afinal/FinalBitmap;)V
    .locals 0

    .prologue
    .line 530
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->clearMemoryCacheInBackgroud()V

    return-void
.end method

.method static synthetic access$3(Lnet/tsz/afinal/FinalBitmap;)V
    .locals 0

    .prologue
    .line 565
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->flushCacheInternalInBackgroud()V

    return-void
.end method

.method static synthetic access$4(Lnet/tsz/afinal/FinalBitmap;)V
    .locals 0

    .prologue
    .line 574
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->closeCacheInternalInBackgroud()V

    return-void
.end method

.method static synthetic access$5(Lnet/tsz/afinal/FinalBitmap;)V
    .locals 0

    .prologue
    .line 536
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->clearDiskCacheInBackgroud()V

    return-void
.end method

.method static synthetic access$6(Lnet/tsz/afinal/FinalBitmap;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 546
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalBitmap;->clearCacheInBackgroud(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$7(Lnet/tsz/afinal/FinalBitmap;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 558
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalBitmap;->clearMemoryCacheInBackgroud(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$8(Lnet/tsz/afinal/FinalBitmap;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 552
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalBitmap;->clearDiskCacheInBackgroud(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$9(Lnet/tsz/afinal/FinalBitmap;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mPauseWorkLock:Ljava/lang/Object;

    return-object v0
.end method

.method public static checkImageTask(Ljava/lang/Object;Landroid/widget/ImageView;)Z
    .locals 4
    .param p0, "data"    # Ljava/lang/Object;
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    const/4 v2, 0x1

    .line 758
    invoke-static {p1}, Lnet/tsz/afinal/FinalBitmap;->getBitmapTaskFromImageView(Landroid/widget/ImageView;)Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;

    move-result-object v1

    .line 760
    .local v1, "bitmapWorkerTask":Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;
    if-eqz v1, :cond_1

    .line 761
    # getter for: Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;->data:Ljava/lang/Object;
    invoke-static {v1}, Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;->access$3(Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;)Ljava/lang/Object;

    move-result-object v0

    .line 762
    .local v0, "bitmapData":Ljava/lang/Object;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 763
    :cond_0
    invoke-virtual {v1, v2}, Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;->cancel(Z)Z

    .line 769
    .end local v0    # "bitmapData":Ljava/lang/Object;
    :cond_1
    :goto_0
    return v2

    .line 766
    .restart local v0    # "bitmapData":Ljava/lang/Object;
    :cond_2
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private clearCacheInBackgroud(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 547
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 548
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearCache(Ljava/lang/String;)V

    .line 550
    :cond_0
    return-void
.end method

.method private clearCacheInternalInBackgroud()V
    .locals 1

    .prologue
    .line 521
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 522
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearCache()V

    .line 524
    :cond_0
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    if-eqz v0, :cond_1

    .line 525
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->clearCacheInternal()V

    .line 527
    :cond_1
    return-void
.end method

.method private clearDiskCacheInBackgroud()V
    .locals 1

    .prologue
    .line 537
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 538
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearDiskCache()V

    .line 540
    :cond_0
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    if-eqz v0, :cond_1

    .line 541
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->clearCacheInternal()V

    .line 543
    :cond_1
    return-void
.end method

.method private clearDiskCacheInBackgroud(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 553
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 554
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearDiskCache(Ljava/lang/String;)V

    .line 556
    :cond_0
    return-void
.end method

.method private clearMemoryCacheInBackgroud()V
    .locals 1

    .prologue
    .line 531
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 532
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearMemoryCache()V

    .line 534
    :cond_0
    return-void
.end method

.method private clearMemoryCacheInBackgroud(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 559
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 560
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->clearMemoryCache(Ljava/lang/String;)V

    .line 562
    :cond_0
    return-void
.end method

.method private closeCacheInternalInBackgroud()V
    .locals 1

    .prologue
    .line 575
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 576
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->close()V

    .line 577
    const/4 v0, 0x0

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    .line 579
    :cond_0
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    if-eqz v0, :cond_1

    .line 580
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->clearCacheInternal()V

    .line 582
    :cond_1
    return-void
.end method

.method private configBitmapLoadThreadSize(I)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 363
    const/4 v0, 0x1

    if-lt p1, v0, :cond_0

    .line 364
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iput p1, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->poolSize:I

    .line 365
    :cond_0
    return-object p0
.end method

.method private configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "strPath"    # Ljava/lang/String;

    .prologue
    .line 323
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 324
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iput-object p1, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->cachePath:Ljava/lang/String;

    .line 326
    :cond_0
    return-object p0
.end method

.method private configDiskCacheSize(I)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 352
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iput p1, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->diskCacheSize:I

    .line 353
    return-object p0
.end method

.method private configMemoryCachePercent(F)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "percent"    # F

    .prologue
    .line 343
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iput p1, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->memCacheSizePercent:F

    .line 344
    return-object p0
.end method

.method private configMemoryCacheSize(I)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 334
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iput p1, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->memCacheSize:I

    .line 335
    return-object p0
.end method

.method public static create(Landroid/content/Context;)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;

    .prologue
    .line 77
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    if-nez v0, :cond_0

    .line 78
    new-instance v0, Lnet/tsz/afinal/FinalBitmap;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalBitmap;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    .line 79
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalBitmap;->init()Lnet/tsz/afinal/FinalBitmap;

    .line 81
    :cond_0
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    return-object v0
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "diskCachePath"    # Ljava/lang/String;

    .prologue
    .line 91
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    if-nez v0, :cond_0

    .line 92
    new-instance v0, Lnet/tsz/afinal/FinalBitmap;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalBitmap;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    .line 93
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p1}, Lnet/tsz/afinal/FinalBitmap;->configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;

    .line 94
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalBitmap;->init()Lnet/tsz/afinal/FinalBitmap;

    .line 96
    :cond_0
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    return-object v0
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;F)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "diskCachePath"    # Ljava/lang/String;
    .param p2, "memoryCacheSizePercent"    # F

    .prologue
    .line 109
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    if-nez v0, :cond_0

    .line 110
    new-instance v0, Lnet/tsz/afinal/FinalBitmap;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalBitmap;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    .line 111
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p1}, Lnet/tsz/afinal/FinalBitmap;->configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;

    .line 112
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p2}, Lnet/tsz/afinal/FinalBitmap;->configMemoryCachePercent(F)Lnet/tsz/afinal/FinalBitmap;

    .line 113
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalBitmap;->init()Lnet/tsz/afinal/FinalBitmap;

    .line 116
    :cond_0
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    return-object v0
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;FI)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "diskCachePath"    # Ljava/lang/String;
    .param p2, "memoryCacheSizePercent"    # F
    .param p3, "threadSize"    # I

    .prologue
    .line 147
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    if-nez v0, :cond_0

    .line 148
    new-instance v0, Lnet/tsz/afinal/FinalBitmap;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalBitmap;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    .line 149
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p1}, Lnet/tsz/afinal/FinalBitmap;->configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;

    .line 150
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p3}, Lnet/tsz/afinal/FinalBitmap;->configBitmapLoadThreadSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 151
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p2}, Lnet/tsz/afinal/FinalBitmap;->configMemoryCachePercent(F)Lnet/tsz/afinal/FinalBitmap;

    .line 152
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalBitmap;->init()Lnet/tsz/afinal/FinalBitmap;

    .line 155
    :cond_0
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    return-object v0
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;FII)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "diskCachePath"    # Ljava/lang/String;
    .param p2, "memoryCacheSizePercent"    # F
    .param p3, "diskCacheSize"    # I
    .param p4, "threadSize"    # I

    .prologue
    .line 188
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    if-nez v0, :cond_0

    .line 189
    new-instance v0, Lnet/tsz/afinal/FinalBitmap;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalBitmap;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    .line 190
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p1}, Lnet/tsz/afinal/FinalBitmap;->configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;

    .line 191
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p4}, Lnet/tsz/afinal/FinalBitmap;->configBitmapLoadThreadSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 192
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p2}, Lnet/tsz/afinal/FinalBitmap;->configMemoryCachePercent(F)Lnet/tsz/afinal/FinalBitmap;

    .line 193
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p3}, Lnet/tsz/afinal/FinalBitmap;->configDiskCacheSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 194
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalBitmap;->init()Lnet/tsz/afinal/FinalBitmap;

    .line 197
    :cond_0
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    return-object v0
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;I)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "diskCachePath"    # Ljava/lang/String;
    .param p2, "memoryCacheSize"    # I

    .prologue
    .line 127
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    if-nez v0, :cond_0

    .line 128
    new-instance v0, Lnet/tsz/afinal/FinalBitmap;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalBitmap;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    .line 129
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p1}, Lnet/tsz/afinal/FinalBitmap;->configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;

    .line 130
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p2}, Lnet/tsz/afinal/FinalBitmap;->configMemoryCacheSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 131
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalBitmap;->init()Lnet/tsz/afinal/FinalBitmap;

    .line 134
    :cond_0
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    return-object v0
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;II)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "diskCachePath"    # Ljava/lang/String;
    .param p2, "memoryCacheSize"    # I
    .param p3, "threadSize"    # I

    .prologue
    .line 167
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    if-nez v0, :cond_0

    .line 168
    new-instance v0, Lnet/tsz/afinal/FinalBitmap;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalBitmap;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    .line 169
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p1}, Lnet/tsz/afinal/FinalBitmap;->configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;

    .line 170
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p3}, Lnet/tsz/afinal/FinalBitmap;->configBitmapLoadThreadSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 171
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p2}, Lnet/tsz/afinal/FinalBitmap;->configMemoryCacheSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 172
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalBitmap;->init()Lnet/tsz/afinal/FinalBitmap;

    .line 175
    :cond_0
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    return-object v0
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;III)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "diskCachePath"    # Ljava/lang/String;
    .param p2, "memoryCacheSize"    # I
    .param p3, "diskCacheSize"    # I
    .param p4, "threadSize"    # I

    .prologue
    .line 210
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    if-nez v0, :cond_0

    .line 211
    new-instance v0, Lnet/tsz/afinal/FinalBitmap;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lnet/tsz/afinal/FinalBitmap;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    .line 212
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p1}, Lnet/tsz/afinal/FinalBitmap;->configDiskCachePath(Ljava/lang/String;)Lnet/tsz/afinal/FinalBitmap;

    .line 213
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p4}, Lnet/tsz/afinal/FinalBitmap;->configBitmapLoadThreadSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 214
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p2}, Lnet/tsz/afinal/FinalBitmap;->configMemoryCacheSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 215
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0, p3}, Lnet/tsz/afinal/FinalBitmap;->configDiskCacheSize(I)Lnet/tsz/afinal/FinalBitmap;

    .line 216
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalBitmap;->init()Lnet/tsz/afinal/FinalBitmap;

    .line 219
    :cond_0
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mFinalBitmap:Lnet/tsz/afinal/FinalBitmap;

    return-object v0
.end method

.method private doDisplay(Landroid/widget/ImageView;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V
    .locals 6
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "displayConfig"    # Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .prologue
    .line 470
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    if-nez p1, :cond_1

    .line 495
    :cond_0
    :goto_0
    return-void

    .line 474
    :cond_1
    if-nez p3, :cond_2

    .line 475
    iget-object v3, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object p3, v3, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .line 477
    :cond_2
    const/4 v1, 0x0

    .line 479
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    sget-object v3, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v3, :cond_3

    .line 480
    sget-object v3, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v3, p2}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->getBitmapFromMemCache(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 483
    :cond_3
    if-eqz v1, :cond_4

    .line 484
    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 486
    :cond_4
    invoke-static {p2, p1}, Lnet/tsz/afinal/FinalBitmap;->checkImageTask(Ljava/lang/Object;Landroid/widget/ImageView;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 488
    new-instance v2, Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;

    invoke-direct {v2, p0, p1, p3}, Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Landroid/widget/ImageView;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V

    .line 490
    .local v2, "task":Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;

    iget-object v3, p0, Lnet/tsz/afinal/FinalBitmap;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {p3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getLoadingBitmap()Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-direct {v0, v3, v4, v2}, Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;)V

    .line 491
    .local v0, "asyncDrawable":Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 493
    sget-object v3, Lnet/tsz/afinal/FinalBitmap;->bitmapLoadAndDisplayExecutor:Ljava/util/concurrent/ExecutorService;

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p2, v4, v5

    invoke-virtual {v2, v3, v4}, Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    goto :goto_0
.end method

.method private flushCacheInternalInBackgroud()V
    .locals 1

    .prologue
    .line 566
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 567
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->flush()V

    .line 569
    :cond_0
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    if-eqz v0, :cond_1

    .line 570
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->flushCacheInternal()V

    .line 572
    :cond_1
    return-void
.end method

.method private static getBitmapTaskFromImageView(Landroid/widget/ImageView;)Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;
    .locals 3
    .param p0, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 740
    if-eqz p0, :cond_0

    .line 741
    invoke-virtual {p0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 742
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    instance-of v2, v1, Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;

    if-eqz v2, :cond_0

    move-object v0, v1

    .line 743
    check-cast v0, Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;

    .line 744
    .local v0, "asyncDrawable":Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;
    invoke-virtual {v0}, Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;->getBitmapWorkerTask()Lnet/tsz/afinal/FinalBitmap$BitmapLoadAndDisplayTask;

    move-result-object v2

    .line 747
    .end local v0    # "asyncDrawable":Lnet/tsz/afinal/FinalBitmap$AsyncDrawable;
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private getDisplayConfig()Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;
    .locals 2

    .prologue
    .line 501
    new-instance v0, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-direct {v0}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;-><init>()V

    .line 502
    .local v0, "config":Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setAnimation(Landroid/view/animation/Animation;)V

    .line 503
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getAnimationType()I

    move-result v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setAnimationType(I)V

    .line 504
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getBitmapHeight()I

    move-result v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapHeight(I)V

    .line 505
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getBitmapWidth()I

    move-result v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapWidth(I)V

    .line 506
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getLoadfailBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadfailBitmap(Landroid/graphics/Bitmap;)V

    .line 507
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getLoadingBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadingBitmap(Landroid/graphics/Bitmap;)V

    .line 508
    return-object v0
.end method

.method private init()Lnet/tsz/afinal/FinalBitmap;
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 374
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    invoke-virtual {v1}, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->init()V

    .line 376
    new-instance v0, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;

    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->cachePath:Ljava/lang/String;

    invoke-direct {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;-><init>(Ljava/lang/String;)V

    .line 377
    .local v0, "imageCacheParams":Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->memCacheSizePercent:F

    float-to-double v1, v1

    const-wide v3, 0x3fa999999999999aL    # 0.05

    cmpl-double v1, v1, v3

    if-lez v1, :cond_1

    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->memCacheSizePercent:F

    float-to-double v1, v1

    const-wide v3, 0x3fe999999999999aL    # 0.8

    cmpg-double v1, v1, v3

    if-gez v1, :cond_1

    .line 378
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget v2, v2, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->memCacheSizePercent:F

    invoke-virtual {v0, v1, v2}, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->setMemCacheSizePercent(Landroid/content/Context;F)V

    .line 387
    :goto_0
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->diskCacheSize:I

    const/high16 v2, 0x500000

    if-le v1, v2, :cond_0

    .line 388
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->diskCacheSize:I

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->setDiskCacheSize(I)V

    .line 389
    :cond_0
    new-instance v1, Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-direct {v1, v0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;-><init>(Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;)V

    sput-object v1, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    .line 391
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->poolSize:I

    new-instance v2, Lnet/tsz/afinal/FinalBitmap$1;

    invoke-direct {v2, p0}, Lnet/tsz/afinal/FinalBitmap$1;-><init>(Lnet/tsz/afinal/FinalBitmap;)V

    invoke-static {v1, v2}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    sput-object v1, Lnet/tsz/afinal/FinalBitmap;->bitmapLoadAndDisplayExecutor:Ljava/util/concurrent/ExecutorService;

    .line 400
    new-instance v1, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    new-array v2, v5, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 402
    return-object p0

    .line 380
    :cond_1
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->memCacheSize:I

    const/high16 v2, 0x200000

    if-le v1, v2, :cond_2

    .line 381
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget v1, v1, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->memCacheSize:I

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->setMemCacheSize(I)V

    goto :goto_0

    .line 384
    :cond_2
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mContext:Landroid/content/Context;

    const v2, 0x3e99999a    # 0.3f

    invoke-virtual {v0, v1, v2}, Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;->setMemCacheSizePercent(Landroid/content/Context;F)V

    goto :goto_0
.end method

.method private initDiskCacheInternalInBackgroud()V
    .locals 1

    .prologue
    .line 512
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    if-eqz v0, :cond_0

    .line 513
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->initDiskCache()V

    .line 515
    :cond_0
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    if-eqz v0, :cond_1

    .line 516
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->initHttpDiskCache()V

    .line 518
    :cond_1
    return-void
.end method

.method private processBitmap(Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "config"    # Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .prologue
    .line 590
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    if-eqz v0, :cond_0

    .line 591
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    invoke-virtual {v0, p1, p2}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->processBitmap(Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 593
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public clearCache()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 657
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 658
    return-void
.end method

.method public clearCache(Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 665
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const/4 v3, 0x6

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 666
    return-void
.end method

.method public clearDiskCache()V
    .locals 4

    .prologue
    .line 688
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const/4 v3, 0x5

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 689
    return-void
.end method

.method public clearDiskCache(Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 696
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const/16 v3, 0x8

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 697
    return-void
.end method

.method public clearMemoryCache()V
    .locals 4

    .prologue
    .line 672
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const/4 v3, 0x4

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 673
    return-void
.end method

.method public clearMemoryCache(Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 680
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const/4 v3, 0x7

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 681
    return-void
.end method

.method public closeCache()V
    .locals 4

    .prologue
    .line 712
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const/4 v3, 0x3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 713
    return-void
.end method

.method public configBitmapMaxHeight(I)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "bitmapHeight"    # I

    .prologue
    .line 265
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapHeight(I)V

    .line 266
    return-object p0
.end method

.method public configBitmapMaxWidth(I)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "bitmapWidth"    # I

    .prologue
    .line 274
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapWidth(I)V

    .line 275
    return-object p0
.end method

.method public configCalculateBitmapSizeWhenDecode(Z)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "neverCalculate"    # Z

    .prologue
    .line 312
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    if-eqz v0, :cond_0

    .line 313
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;->configCalculateBitmap(Z)V

    .line 314
    :cond_0
    return-object p0
.end method

.method public configCompressFormat(Landroid/graphics/Bitmap$CompressFormat;)V
    .locals 1
    .param p1, "format"    # Landroid/graphics/Bitmap$CompressFormat;

    .prologue
    .line 304
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->setCompressFormat(Landroid/graphics/Bitmap$CompressFormat;)V

    .line 305
    return-void
.end method

.method public configDisplayer(Lnet/tsz/afinal/bitmap/display/Displayer;)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "displayer"    # Lnet/tsz/afinal/bitmap/display/Displayer;

    .prologue
    .line 294
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iput-object p1, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->displayer:Lnet/tsz/afinal/bitmap/display/Displayer;

    .line 295
    return-object p0
.end method

.method public configDownlader(Lnet/tsz/afinal/bitmap/download/Downloader;)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "downlader"    # Lnet/tsz/afinal/bitmap/download/Downloader;

    .prologue
    .line 284
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iput-object p1, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->downloader:Lnet/tsz/afinal/bitmap/download/Downloader;

    .line 285
    return-object p0
.end method

.method public configLoadfailImage(I)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p1, "resId"    # I

    .prologue
    .line 255
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {v1, p1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadfailBitmap(Landroid/graphics/Bitmap;)V

    .line 256
    return-object p0
.end method

.method public configLoadfailImage(Landroid/graphics/Bitmap;)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 246
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadfailBitmap(Landroid/graphics/Bitmap;)V

    .line 247
    return-object p0
.end method

.method public configLoadingImage(I)Lnet/tsz/afinal/FinalBitmap;
    .locals 2
    .param p1, "resId"    # I

    .prologue
    .line 237
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {v1, p1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadingBitmap(Landroid/graphics/Bitmap;)V

    .line 238
    return-object p0
.end method

.method public configLoadingImage(Landroid/graphics/Bitmap;)Lnet/tsz/afinal/FinalBitmap;
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 228
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mConfig:Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;

    iget-object v0, v0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadingBitmap(Landroid/graphics/Bitmap;)V

    .line 229
    return-object p0
.end method

.method public display(Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 1
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "uri"    # Ljava/lang/String;

    .prologue
    .line 408
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lnet/tsz/afinal/FinalBitmap;->doDisplay(Landroid/widget/ImageView;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V

    .line 409
    return-void
.end method

.method public display(Landroid/widget/ImageView;Ljava/lang/String;II)V
    .locals 4
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "imageWidth"    # I
    .param p4, "imageHeight"    # I

    .prologue
    .line 414
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .line 415
    .local v0, "displayConfig":Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;
    if-nez v0, :cond_0

    .line 416
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->getDisplayConfig()Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    move-result-object v0

    .line 417
    invoke-virtual {v0, p4}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapHeight(I)V

    .line 418
    invoke-virtual {v0, p3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapWidth(I)V

    .line 419
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 422
    :cond_0
    invoke-direct {p0, p1, p2, v0}, Lnet/tsz/afinal/FinalBitmap;->doDisplay(Landroid/widget/ImageView;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V

    .line 423
    return-void
.end method

.method public display(Landroid/widget/ImageView;Ljava/lang/String;IILandroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    .locals 4
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "imageWidth"    # I
    .param p4, "imageHeight"    # I
    .param p5, "loadingBitmap"    # Landroid/graphics/Bitmap;
    .param p6, "laodfailBitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 450
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .line 451
    .local v0, "displayConfig":Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;
    if-nez v0, :cond_0

    .line 452
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->getDisplayConfig()Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    move-result-object v0

    .line 453
    invoke-virtual {v0, p4}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapHeight(I)V

    .line 454
    invoke-virtual {v0, p3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapWidth(I)V

    .line 455
    invoke-virtual {v0, p5}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadingBitmap(Landroid/graphics/Bitmap;)V

    .line 456
    invoke-virtual {v0, p6}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadfailBitmap(Landroid/graphics/Bitmap;)V

    .line 457
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 460
    :cond_0
    invoke-direct {p0, p1, p2, v0}, Lnet/tsz/afinal/FinalBitmap;->doDisplay(Landroid/widget/ImageView;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V

    .line 461
    return-void
.end method

.method public display(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "loadingBitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 426
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    invoke-static {p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .line 427
    .local v0, "displayConfig":Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;
    if-nez v0, :cond_0

    .line 428
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->getDisplayConfig()Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    move-result-object v0

    .line 429
    invoke-virtual {v0, p3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadingBitmap(Landroid/graphics/Bitmap;)V

    .line 430
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    invoke-static {p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 433
    :cond_0
    invoke-direct {p0, p1, p2, v0}, Lnet/tsz/afinal/FinalBitmap;->doDisplay(Landroid/widget/ImageView;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V

    .line 434
    return-void
.end method

.method public display(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    .locals 4
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "loadingBitmap"    # Landroid/graphics/Bitmap;
    .param p4, "laodfailBitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 438
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .line 439
    .local v0, "displayConfig":Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;
    if-nez v0, :cond_0

    .line 440
    invoke-direct {p0}, Lnet/tsz/afinal/FinalBitmap;->getDisplayConfig()Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    move-result-object v0

    .line 441
    invoke-virtual {v0, p3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadingBitmap(Landroid/graphics/Bitmap;)V

    .line 442
    invoke-virtual {v0, p4}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setLoadfailBitmap(Landroid/graphics/Bitmap;)V

    .line 443
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->configMap:Ljava/util/HashMap;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 446
    :cond_0
    invoke-direct {p0, p1, p2, v0}, Lnet/tsz/afinal/FinalBitmap;->doDisplay(Landroid/widget/ImageView;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V

    .line 447
    return-void
.end method

.method public display(Landroid/widget/ImageView;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V
    .locals 0
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "config"    # Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .prologue
    .line 465
    invoke-direct {p0, p1, p2, p3}, Lnet/tsz/afinal/FinalBitmap;->doDisplay(Landroid/widget/ImageView;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V

    .line 466
    return-void
.end method

.method public exitTasksEarly(Z)V
    .locals 1
    .param p1, "exitTasksEarly"    # Z

    .prologue
    .line 720
    iput-boolean p1, p0, Lnet/tsz/afinal/FinalBitmap;->mExitTasksEarly:Z

    .line 721
    if-eqz p1, :cond_0

    .line 722
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lnet/tsz/afinal/FinalBitmap;->pauseWork(Z)V

    .line 723
    :cond_0
    return-void
.end method

.method public flushCache()V
    .locals 4

    .prologue
    .line 705
    new-instance v0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->execute([Ljava/lang/Object;)Lnet/tsz/afinal/core/AsyncTask;

    .line 706
    return-void
.end method

.method public getBitmapFromCache(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 602
    invoke-virtual {p0, p1}, Lnet/tsz/afinal/FinalBitmap;->getBitmapFromMemoryCache(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 603
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-nez v0, :cond_0

    .line 604
    invoke-virtual {p0, p1}, Lnet/tsz/afinal/FinalBitmap;->getBitmapFromDiskCache(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 606
    :cond_0
    return-object v0
.end method

.method public getBitmapFromDiskCache(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 624
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->getBitmapFromDiskCache(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getBitmapFromMemoryCache(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 615
    sget-object v0, Lnet/tsz/afinal/FinalBitmap;->mImageCache:Lnet/tsz/afinal/bitmap/core/BitmapCache;

    invoke-virtual {v0, p1}, Lnet/tsz/afinal/bitmap/core/BitmapCache;->getBitmapFromMemCache(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 650
    invoke-virtual {p0}, Lnet/tsz/afinal/FinalBitmap;->closeCache()V

    .line 651
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 642
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lnet/tsz/afinal/FinalBitmap;->setExitTasksEarly(Z)V

    .line 643
    invoke-virtual {p0}, Lnet/tsz/afinal/FinalBitmap;->flushCache()V

    .line 644
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 635
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lnet/tsz/afinal/FinalBitmap;->setExitTasksEarly(Z)V

    .line 636
    return-void
.end method

.method public pauseWork(Z)V
    .locals 2
    .param p1, "pauseWork"    # Z

    .prologue
    .line 730
    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap;->mPauseWorkLock:Ljava/lang/Object;

    monitor-enter v1

    .line 731
    :try_start_0
    iput-boolean p1, p0, Lnet/tsz/afinal/FinalBitmap;->mPauseWork:Z

    .line 732
    iget-boolean v0, p0, Lnet/tsz/afinal/FinalBitmap;->mPauseWork:Z

    if-nez v0, :cond_0

    .line 733
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap;->mPauseWorkLock:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 730
    :cond_0
    monitor-exit v1

    .line 736
    return-void

    .line 730
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public setExitTasksEarly(Z)V
    .locals 0
    .param p1, "exitTasksEarly"    # Z

    .prologue
    .line 628
    iput-boolean p1, p0, Lnet/tsz/afinal/FinalBitmap;->mExitTasksEarly:Z

    .line 629
    return-void
.end method
