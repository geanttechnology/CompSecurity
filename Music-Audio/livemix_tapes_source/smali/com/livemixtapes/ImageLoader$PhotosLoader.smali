.class Lcom/livemixtapes/ImageLoader$PhotosLoader;
.super Ljava/lang/Object;
.source "ImageLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/ImageLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PhotosLoader"
.end annotation


# instance fields
.field photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

.field final synthetic this$0:Lcom/livemixtapes/ImageLoader;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ImageLoader;Lcom/livemixtapes/ImageLoader$PhotoToLoad;)V
    .locals 0
    .param p2, "photoToLoad"    # Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    .prologue
    .line 147
    iput-object p1, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->this$0:Lcom/livemixtapes/ImageLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 148
    iput-object p2, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    .line 149
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 154
    :try_start_0
    iget-object v3, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->this$0:Lcom/livemixtapes/ImageLoader;

    iget-object v4, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ImageLoader;->imageViewReused(Lcom/livemixtapes/ImageLoader$PhotoToLoad;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 156
    :cond_1
    iget-object v3, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->this$0:Lcom/livemixtapes/ImageLoader;

    iget-object v4, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    iget-object v4, v4, Lcom/livemixtapes/ImageLoader$PhotoToLoad;->url:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ImageLoader;->getBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 157
    .local v1, "bmp":Landroid/graphics/Bitmap;
    sget-object v3, Lcom/livemixtapes/ImageLoader;->memoryCache:Lcom/livemixtapes/MemoryCache;

    iget-object v4, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    iget-object v4, v4, Lcom/livemixtapes/ImageLoader$PhotoToLoad;->url:Ljava/lang/String;

    invoke-virtual {v3, v4, v1}, Lcom/livemixtapes/MemoryCache;->put(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 158
    iget-object v3, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->this$0:Lcom/livemixtapes/ImageLoader;

    iget-object v4, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ImageLoader;->imageViewReused(Lcom/livemixtapes/ImageLoader$PhotoToLoad;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 160
    new-instance v0, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;

    iget-object v3, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->this$0:Lcom/livemixtapes/ImageLoader;

    iget-object v4, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->photoToLoad:Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    invoke-direct {v0, v3, v1, v4}, Lcom/livemixtapes/ImageLoader$BitmapDisplayer;-><init>(Lcom/livemixtapes/ImageLoader;Landroid/graphics/Bitmap;Lcom/livemixtapes/ImageLoader$PhotoToLoad;)V

    .line 161
    .local v0, "bd":Lcom/livemixtapes/ImageLoader$BitmapDisplayer;
    iget-object v3, p0, Lcom/livemixtapes/ImageLoader$PhotosLoader;->this$0:Lcom/livemixtapes/ImageLoader;

    iget-object v3, v3, Lcom/livemixtapes/ImageLoader;->handler:Landroid/os/Handler;

    invoke-virtual {v3, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 162
    .end local v0    # "bd":Lcom/livemixtapes/ImageLoader$BitmapDisplayer;
    .end local v1    # "bmp":Landroid/graphics/Bitmap;
    :catch_0
    move-exception v2

    .line 163
    .local v2, "th":Ljava/lang/Throwable;
    invoke-virtual {v2}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0
.end method
