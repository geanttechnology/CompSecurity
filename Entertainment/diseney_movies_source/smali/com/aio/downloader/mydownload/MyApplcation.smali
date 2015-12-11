.class public Lcom/aio/downloader/mydownload/MyApplcation;
.super Landroid/app/Application;
.source "MyApplcation.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;
    }
.end annotation


# static fields
.field public static final DEVELOPER_MODE:Z

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

.field private downloadItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private downloadSuccess:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field private imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

.field private options1:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

.field private pager:Landroid/support/v4/view/ViewPager;

.field private startDownloadMovieItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field private stopOrStartDownloadMovieItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 74
    const-class v0, Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/mydownload/MyApplcation;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const v2, 0x7f0200f9

    .line 47
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->downloadItems:Ljava/util/List;

    .line 61
    new-instance v0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    .line 62
    sget-object v1, Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;->IN_SAMPLE_INT:Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->imageScaleType(Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    .line 63
    sget-object v1, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->bitmapConfig(Landroid/graphics/Bitmap$Config;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    .line 65
    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc()Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showStubImage(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    .line 66
    invoke-virtual {v0, v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageOnFail(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 67
    new-instance v0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    .line 68
    sget-object v1, Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;->IN_SAMPLE_INT:Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->imageScaleType(Lcom/nostra13/universalimageloader/core/assist/ImageScaleType;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    .line 69
    sget-object v1, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->bitmapConfig(Landroid/graphics/Bitmap$Config;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    .line 70
    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc()Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showStubImage(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->options1:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 71
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    .line 72
    new-instance v0, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;-><init>(Lcom/aio/downloader/mydownload/MyApplcation$AnimateFirstDisplayListener;)V

    iput-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 47
    return-void
.end method

.method public static initImageLoader(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 175
    new-instance v1, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    invoke-direct {v1, p0}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;-><init>(Landroid/content/Context;)V

    .line 176
    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->threadPriority(I)Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    move-result-object v1

    .line 177
    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->denyCacheImageMultipleSizesInMemory()Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    move-result-object v1

    .line 178
    new-instance v2, Lcom/nostra13/universalimageloader/cache/disc/naming/Md5FileNameGenerator;

    invoke-direct {v2}, Lcom/nostra13/universalimageloader/cache/disc/naming/Md5FileNameGenerator;-><init>()V

    invoke-virtual {v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->discCacheFileNameGenerator(Lcom/nostra13/universalimageloader/cache/disc/naming/FileNameGenerator;)Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    move-result-object v1

    .line 179
    sget-object v2, Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;->LIFO:Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;

    invoke-virtual {v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->tasksProcessingOrder(Lcom/nostra13/universalimageloader/core/assist/QueueProcessingType;)Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->enableLogging()Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    move-result-object v1

    .line 180
    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->build()Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    move-result-object v0

    .line 181
    .local v0, "config":Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->init(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;)V

    .line 182
    return-void
.end method


# virtual methods
.method public asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 3
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 189
    iget-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    iget-object v1, p0, Lcom/aio/downloader/mydownload/MyApplcation;->options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 190
    iget-object v2, p0, Lcom/aio/downloader/mydownload/MyApplcation;->animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 189
    invoke-virtual {v0, p1, p2, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 192
    return-void
.end method

.method public asyncLoadImage1(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 3
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 196
    iget-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    iget-object v1, p0, Lcom/aio/downloader/mydownload/MyApplcation;->options1:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 197
    iget-object v2, p0, Lcom/aio/downloader/mydownload/MyApplcation;->animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 196
    invoke-virtual {v0, p1, p2, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 199
    return-void
.end method

.method public getDownloadItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 258
    iget-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->downloadItems:Ljava/util/List;

    return-object v0
.end method

.method public getDownloadSuccess()Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 284
    iget-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->downloadSuccess:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method public getListData()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 164
    iget-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->list:Ljava/util/List;

    return-object v0
.end method

.method public getPager()Landroid/support/v4/view/ViewPager;
    .locals 1

    .prologue
    .line 292
    iget-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->pager:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method public getStartDownloadMovieItem()Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->startDownloadMovieItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method public getStopOrStartDownloadMovieItem()Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 275
    iget-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->stopOrStartDownloadMovieItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method public onCreate()V
    .locals 1

    .prologue
    .line 86
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 87
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/mydownload/MyApplcation;->list:Ljava/util/List;

    .line 89
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/MyApplcation;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/mydownload/MyApplcation;->initImageLoader(Landroid/content/Context;)V

    .line 92
    invoke-static {p0}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 161
    return-void
.end method

.method public setDownloadItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 262
    .local p1, "downloadItems":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    iput-object p1, p0, Lcom/aio/downloader/mydownload/MyApplcation;->downloadItems:Ljava/util/List;

    .line 263
    return-void
.end method

.method public setDownloadSuccess(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0
    .param p1, "downloadSuccess"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 288
    iput-object p1, p0, Lcom/aio/downloader/mydownload/MyApplcation;->downloadSuccess:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 289
    return-void
.end method

.method public setListData(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 168
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    iput-object p1, p0, Lcom/aio/downloader/mydownload/MyApplcation;->list:Ljava/util/List;

    .line 169
    return-void
.end method

.method public setPager(Landroid/support/v4/view/ViewPager;)V
    .locals 0
    .param p1, "pager"    # Landroid/support/v4/view/ViewPager;

    .prologue
    .line 296
    iput-object p1, p0, Lcom/aio/downloader/mydownload/MyApplcation;->pager:Landroid/support/v4/view/ViewPager;

    .line 297
    return-void
.end method

.method public setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0
    .param p1, "startDownloadMovieItem"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 271
    iput-object p1, p0, Lcom/aio/downloader/mydownload/MyApplcation;->startDownloadMovieItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 272
    return-void
.end method

.method public setStopOrStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0
    .param p1, "stopOrStartDownloadMovieItem"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 280
    iput-object p1, p0, Lcom/aio/downloader/mydownload/MyApplcation;->stopOrStartDownloadMovieItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 281
    return-void
.end method

.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "arg0"    # Ljava/lang/Thread;
    .param p2, "arg1"    # Ljava/lang/Throwable;

    .prologue
    .line 302
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "uncaughtException"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 303
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/System;->exit(I)V

    .line 304
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 305
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x14000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 307
    invoke-virtual {p0, v0}, Lcom/aio/downloader/mydownload/MyApplcation;->startActivity(Landroid/content/Intent;)V

    .line 308
    return-void
.end method
