.class final Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;
.super Ljava/lang/Object;
.source "DisplayBitmapTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final LOG_DISPLAY_IMAGE_IN_IMAGEVIEW:Ljava/lang/String; = "Display image in ImageView [%s]"

.field private static final LOG_TASK_CANCELLED:Ljava/lang/String; = "ImageView is reused for another image. Task is cancelled. [%s]"


# instance fields
.field private final bitmap:Landroid/graphics/Bitmap;

.field private final displayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

.field private final engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

.field private final imageUri:Ljava/lang/String;

.field private final imageView:Landroid/widget/ImageView;

.field private final listener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

.field private loggingEnabled:Z

.field private final memoryCacheKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/graphics/Bitmap;Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "imageLoadingInfo"    # Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    .param p3, "engine"    # Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->bitmap:Landroid/graphics/Bitmap;

    .line 50
    iget-object v0, p2, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->uri:Ljava/lang/String;

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageUri:Ljava/lang/String;

    .line 51
    iget-object v0, p2, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->imageView:Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageView:Landroid/widget/ImageView;

    .line 52
    iget-object v0, p2, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->memoryCacheKey:Ljava/lang/String;

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->memoryCacheKey:Ljava/lang/String;

    .line 53
    iget-object v0, p2, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->getDisplayer()Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->displayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    .line 54
    iget-object v0, p2, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->listener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->listener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 55
    iput-object p3, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    .line 56
    return-void
.end method

.method private isViewWasReused()Z
    .locals 3

    .prologue
    .line 72
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageView:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->getLoadingUriForView(Landroid/widget/ImageView;)Ljava/lang/String;

    move-result-object v0

    .line 73
    .local v0, "currentCacheKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->memoryCacheKey:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 59
    invoke-direct {p0}, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->isViewWasReused()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 60
    iget-boolean v1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->loggingEnabled:Z

    if-eqz v1, :cond_0

    const-string v1, "ImageView is reused for another image. Task is cancelled. [%s]"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->memoryCacheKey:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Lcom/nostra13/universalimageloader/utils/L;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 61
    :cond_0
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->listener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageUri:Ljava/lang/String;

    iget-object v3, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageView:Landroid/widget/ImageView;

    invoke-interface {v1, v2, v3}, Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;->onLoadingCancelled(Ljava/lang/String;Landroid/view/View;)V

    .line 68
    :goto_0
    return-void

    .line 63
    :cond_1
    iget-boolean v1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->loggingEnabled:Z

    if-eqz v1, :cond_2

    const-string v1, "Display image in ImageView [%s]"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->memoryCacheKey:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Lcom/nostra13/universalimageloader/utils/L;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 64
    :cond_2
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->displayer:Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;

    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->bitmap:Landroid/graphics/Bitmap;

    iget-object v3, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageView:Landroid/widget/ImageView;

    invoke-interface {v1, v2, v3}, Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;->display(Landroid/graphics/Bitmap;Landroid/widget/ImageView;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 65
    .local v0, "displayedBitmap":Landroid/graphics/Bitmap;
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->listener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageUri:Ljava/lang/String;

    iget-object v3, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageView:Landroid/widget/ImageView;

    invoke-interface {v1, v2, v3, v0}, Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;->onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V

    .line 66
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->imageView:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->cancelDisplayTaskFor(Landroid/widget/ImageView;)V

    goto :goto_0
.end method

.method setLoggingEnabled(Z)V
    .locals 0
    .param p1, "loggingEnabled"    # Z

    .prologue
    .line 77
    iput-boolean p1, p0, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;->loggingEnabled:Z

    .line 78
    return-void
.end method
