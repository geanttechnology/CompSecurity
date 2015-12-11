.class Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;
.super Ljava/lang/Object;
.source "ProcessAndDisplayImageTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final LOG_POSTPROCESS_IMAGE:Ljava/lang/String; = "PostProcess image before displaying [%s]"


# instance fields
.field private final bitmap:Landroid/graphics/Bitmap;

.field private final engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

.field private final handler:Landroid/os/Handler;

.field private final imageLoadingInfo:Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;


# direct methods
.method public constructor <init>(Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;Landroid/graphics/Bitmap;Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;Landroid/os/Handler;)V
    .locals 0
    .param p1, "engine"    # Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "imageLoadingInfo"    # Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    .param p4, "handler"    # Landroid/os/Handler;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    .line 43
    iput-object p2, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->bitmap:Landroid/graphics/Bitmap;

    .line 44
    iput-object p3, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->imageLoadingInfo:Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;

    .line 45
    iput-object p4, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->handler:Landroid/os/Handler;

    .line 46
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 50
    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    iget-object v2, v2, Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;->configuration:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-boolean v2, v2, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->loggingEnabled:Z

    if-eqz v2, :cond_0

    const-string v2, "PostProcess image before displaying [%s]"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->imageLoadingInfo:Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;

    iget-object v5, v5, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->memoryCacheKey:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/nostra13/universalimageloader/utils/L;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 51
    :cond_0
    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->imageLoadingInfo:Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;

    iget-object v2, v2, Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;->options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    invoke-virtual {v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions;->getPostProcessor()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;

    move-result-object v1

    .line 52
    .local v1, "processor":Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->bitmap:Landroid/graphics/Bitmap;

    invoke-interface {v1, v2}, Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;->process(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 53
    .local v0, "processedBitmap":Landroid/graphics/Bitmap;
    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->handler:Landroid/os/Handler;

    new-instance v3, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;

    iget-object v4, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->imageLoadingInfo:Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;

    iget-object v5, p0, Lcom/nostra13/universalimageloader/core/ProcessAndDisplayImageTask;->engine:Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;

    invoke-direct {v3, v0, v4, v5}, Lcom/nostra13/universalimageloader/core/DisplayBitmapTask;-><init>(Landroid/graphics/Bitmap;Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 54
    return-void
.end method
