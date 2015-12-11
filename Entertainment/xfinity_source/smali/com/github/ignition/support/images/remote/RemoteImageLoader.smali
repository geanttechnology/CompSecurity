.class public Lcom/github/ignition/support/images/remote/RemoteImageLoader;
.super Ljava/lang/Object;
.source "RemoteImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<MT:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private defaultBufferSize:I

.field private defaultDummyDrawable:Landroid/graphics/drawable/Drawable;

.field private errorDrawable:Landroid/graphics/drawable/Drawable;

.field private executor:Ljava/util/concurrent/ThreadPoolExecutor;

.field private final executorLock:Ljava/lang/Object;

.field private final handlerMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;",
            ">;>;"
        }
    .end annotation
.end field

.field private imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<TMT;>;"
        }
    .end annotation
.end field

.field private numRetries:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 72
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    const/4 v0, 0x3

    iput v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->numRetries:I

    .line 55
    const/high16 v0, 0x10000

    iput v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->defaultBufferSize:I

    .line 57
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->executorLock:Ljava/lang/Object;

    .line 61
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->handlerMap:Ljava/util/HashMap;

    .line 73
    invoke-direct {p0}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->newExecutor()Ljava/util/concurrent/ThreadPoolExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 74
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->errorDrawable:Landroid/graphics/drawable/Drawable;

    .line 75
    return-void
.end method

.method private newExecutor()Ljava/util/concurrent/ThreadPoolExecutor;
    .locals 1

    .prologue
    .line 295
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    const/4 v0, 0x3

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/ThreadPoolExecutor;

    return-object v0
.end method


# virtual methods
.method public cancelLoad(Landroid/widget/ImageView;)V
    .locals 1
    .param p1, "view"    # Landroid/widget/ImageView;

    .prologue
    .line 305
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 306
    return-void
.end method

.method public loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;)V
    .locals 8
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "dummyDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p4, "handler"    # Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;

    .prologue
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    const/4 v4, 0x0

    .line 205
    if-eqz p2, :cond_3

    .line 206
    if-nez p1, :cond_1

    .line 209
    invoke-virtual {p2, v4}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 210
    if-eqz p3, :cond_0

    .line 211
    invoke-virtual {p2, p3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 266
    :cond_0
    :goto_0
    return-void

    .line 215
    :cond_1
    invoke-virtual {p2}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 216
    .local v2, "oldImageUrl":Ljava/lang/String;
    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 220
    if-eqz p3, :cond_2

    .line 222
    invoke-virtual {p2, p3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 224
    :cond_2
    invoke-virtual {p2, p1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 228
    .end local v2    # "oldImageUrl":Ljava/lang/String;
    :cond_3
    iget-object v3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    invoke-virtual {v3, p1}, Lcom/github/ignition/support/cache/AbstractImageCache;->containsKeyInMemory(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 230
    iget-object v3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    invoke-virtual {v3, p1}, Lcom/github/ignition/support/cache/AbstractImageCache;->getBitmap(Ljava/lang/Object;)Landroid/graphics/Bitmap;

    move-result-object v3

    invoke-virtual {p4, v3, v4}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->handleImageLoaded(Landroid/graphics/Bitmap;Landroid/os/Message;)Z

    goto :goto_0

    .line 246
    :cond_4
    iget-object v4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->executorLock:Ljava/lang/Object;

    monitor-enter v4

    .line 247
    const/4 v1, 0x1

    .line 249
    .local v1, "isNewQuery":Z
    :try_start_0
    iget-object v5, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->handlerMap:Ljava/util/HashMap;

    monitor-enter v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 250
    :try_start_1
    iget-object v3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->handlerMap:Ljava/util/HashMap;

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    .line 251
    .local v0, "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    if-eqz v0, :cond_6

    .line 252
    const/4 v1, 0x0

    .line 257
    :goto_1
    invoke-interface {v0, p4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 258
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 260
    if-eqz v1, :cond_5

    .line 261
    :try_start_2
    iget-object v3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v5, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;

    iget-object v6, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    iget v7, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->numRetries:I

    invoke-direct {v5, p1, p0, v6, v7}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderJob;-><init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;I)V

    invoke-virtual {v3, v5}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    .line 264
    :cond_5
    monitor-exit v4

    goto :goto_0

    .end local v0    # "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3

    .line 254
    .restart local v0    # "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    :cond_6
    :try_start_3
    new-instance v0, Ljava/util/HashSet;

    .end local v0    # "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 255
    .restart local v0    # "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    iget-object v3, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->handlerMap:Ljava/util/HashMap;

    invoke-virtual {v3, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 258
    .end local v0    # "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    :catchall_1
    move-exception v3

    monitor-exit v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :try_start_4
    throw v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;)V
    .locals 1
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;
    .param p3, "handler"    # Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;

    .prologue
    .line 185
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    iget-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->defaultDummyDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;)V

    .line 186
    return-void
.end method

.method notifyAndCleanupHandlers(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 7
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "data"    # Landroid/os/Bundle;

    .prologue
    .line 271
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    iget-object v5, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->handlerMap:Ljava/util/HashMap;

    monitor-enter v5

    .line 272
    :try_start_0
    iget-object v4, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->handlerMap:Ljava/util/HashMap;

    invoke-virtual {v4, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Set;

    .line 273
    .local v1, "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 275
    if-eqz v1, :cond_0

    if-eqz p2, :cond_0

    .line 276
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;

    .line 277
    .local v0, "handler":Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v3

    .line 278
    .local v3, "message":Landroid/os/Message;
    const/4 v4, 0x0

    iput v4, v3, Landroid/os/Message;->what:I

    .line 279
    invoke-virtual {v3, p2}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 280
    invoke-virtual {v0, v3}, Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0

    .line 273
    .end local v0    # "handler":Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;
    .end local v1    # "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "message":Landroid/os/Message;
    :catchall_0
    move-exception v4

    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v4

    .line 283
    .restart local v1    # "handlerList":Ljava/util/Set;, "Ljava/util/Set<Lcom/github/ignition/support/images/remote/RemoteImageLoaderHandler;>;"
    :cond_0
    const-string v4, "Ignition/ImageLoader"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Handler missing for image "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 285
    :cond_1
    return-void
.end method

.method public purgeJobs()V
    .locals 2

    .prologue
    .line 288
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    iget-object v1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->executorLock:Ljava/lang/Object;

    monitor-enter v1

    .line 289
    :try_start_0
    iget-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ThreadPoolExecutor;->shutdownNow()Ljava/util/List;

    .line 290
    invoke-direct {p0}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->newExecutor()Ljava/util/concurrent/ThreadPoolExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 291
    monitor-exit v1

    .line 292
    return-void

    .line 291
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public setDownloadFailedDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 112
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    iput-object p1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->errorDrawable:Landroid/graphics/drawable/Drawable;

    .line 113
    return-void
.end method

.method public setDownloadInProgressDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 108
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    iput-object p1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->defaultDummyDrawable:Landroid/graphics/drawable/Drawable;

    .line 109
    return-void
.end method

.method public setImageCache(Lcom/github/ignition/support/cache/AbstractImageCache;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<TMT;>;)V"
        }
    .end annotation

    .prologue
    .line 116
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    .local p1, "imageCache":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<TMT;>;"
    iput-object p1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->imageCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    .line 117
    return-void
.end method

.method public setMaxDownloadAttempts(I)V
    .locals 0
    .param p1, "numAttempts"    # I

    .prologue
    .line 91
    .local p0, "this":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<TMT;>;"
    iput p1, p0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->numRetries:I

    .line 92
    return-void
.end method
