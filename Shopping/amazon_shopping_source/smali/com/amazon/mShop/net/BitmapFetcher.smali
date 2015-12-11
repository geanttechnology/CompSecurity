.class public Lcom/amazon/mShop/net/BitmapFetcher;
.super Lcom/amazon/mShop/net/HttpFetcher;
.source "BitmapFetcher.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/net/HttpFetcher",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;)V
    .locals 0
    .param p1, "params"    # Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    .prologue
    .line 80
    invoke-direct {p0, p1}, Lcom/amazon/mShop/net/HttpFetcher;-><init>(Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    .line 81
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V
    .locals 1
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "maxDimension"    # Ljava/lang/Integer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 37
    .local p3, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 38
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
    .locals 7
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "maxDimension"    # Ljava/lang/Integer;
    .param p4, "useDiskCache"    # Z
    .param p5, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;Z",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;",
            ")V"
        }
    .end annotation

    .prologue
    .line 50
    .local p3, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    .line 51
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V
    .locals 2
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "maxDimension"    # Ljava/lang/Integer;
    .param p3, "tag"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 62
    .local p4, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-direct {v0, p1, p4, v1, p3}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ILjava/lang/Object;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/net/HttpFetcher;-><init>(Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    .line 63
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
    .locals 7
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "maxDimension"    # Ljava/lang/Integer;
    .param p3, "tag"    # Ljava/lang/Object;
    .param p5, "useDiskCache"    # Z
    .param p6, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;Z",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;",
            ")V"
        }
    .end annotation

    .prologue
    .line 76
    .local p4, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v3

    move-object v1, p1

    move-object v2, p4

    move-object v4, p3

    move v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ILjava/lang/Object;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/net/HttpFetcher;-><init>(Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    .line 77
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V
    .locals 1
    .param p1, "fullUrl"    # Ljava/lang/String;
    .param p2, "baseUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p3, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/net/HttpFetcher;-><init>(Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    .line 23
    return-void
.end method

.method private httpFetch(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
    .locals 2
    .param p1, "uriStr"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "priority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .prologue
    .line 194
    sget-object v0, Lcom/amazon/mShop/net/BitmapFetcher;->sExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/amazon/mShop/net/BitmapFetcher$1;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/amazon/mShop/net/BitmapFetcher$1;-><init>(Lcom/amazon/mShop/net/BitmapFetcher;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 240
    return-void
.end method

.method private revalidate(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
    .locals 7
    .param p1, "uriStr"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p4, "priority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;",
            ")V"
        }
    .end annotation

    .prologue
    .line 244
    .local p3, "cachedHeader":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v6, Lcom/amazon/mShop/net/BitmapFetcher;->sExecutor:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher$2;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p3

    move-object v4, p2

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/net/BitmapFetcher$2;-><init>(Lcom/amazon/mShop/net/BitmapFetcher;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 316
    return-void
.end method


# virtual methods
.method public fetch()V
    .locals 1

    .prologue
    .line 405
    sget-object v0, Lcom/amazon/mShop/net/BitmapFetcher;->sExecutor:Ljava/util/concurrent/Executor;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch(Ljava/util/concurrent/Executor;)V

    .line 406
    return-void
.end method

.method public fetch(Ljava/util/concurrent/Executor;)V
    .locals 1
    .param p1, "executor"    # Ljava/util/concurrent/Executor;

    .prologue
    .line 389
    invoke-virtual {p0}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->useDiskCache()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 394
    invoke-virtual {p0}, Lcom/amazon/mShop/net/BitmapFetcher;->fetchInAllCache()V

    .line 401
    :goto_0
    return-void

    .line 399
    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/net/HttpFetcher;->fetch(Ljava/util/concurrent/Executor;)V

    goto :goto_0
.end method

.method protected fetchInAllCache()V
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x1

    .line 339
    invoke-virtual {p0}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v4

    .line 340
    .local v4, "p":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-virtual {v4}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getServiceCallIdentifier()Lcom/amazon/mShop/net/ServiceCallIdentifier;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    .line 341
    invoke-virtual {v4}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getCacheKey()Ljava/lang/String;

    move-result-object v7

    .line 342
    .local v7, "uriStr":Ljava/lang/String;
    invoke-virtual {v4}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getResidencePriority()Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    move-result-object v5

    .line 344
    .local v5, "priority":Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    invoke-virtual {p0}, Lcom/amazon/mShop/net/BitmapFetcher;->getParameterizedClass()Ljava/lang/Class;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/graphics/Bitmap;

    .line 345
    .local v6, "result":Landroid/graphics/Bitmap;
    invoke-static {v7}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->uriStrToKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 346
    .local v3, "key":Ljava/lang/String;
    const/4 v2, 0x0

    .line 347
    .local v2, "hitInDisk":Z
    if-nez v6, :cond_0

    .line 348
    invoke-static {}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->isCacheDirReady()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 351
    invoke-static {v3, v5}, Lcom/amazon/mShop/net/MShopDiskCache;->getFileCacheInf(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;

    move-result-object v0

    .line 352
    .local v0, "cacheInf":Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;
    if-eqz v0, :cond_3

    .line 353
    iget-object v1, v0, Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;->mHeaderFields:Ljava/util/Map;

    .line 355
    .local v1, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {v1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->isExpired(Ljava/util/Map;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 357
    invoke-direct {p0, v7, v3, v1, v5}, Lcom/amazon/mShop/net/BitmapFetcher;->revalidate(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    .line 375
    .end local v0    # "cacheInf":Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;
    .end local v1    # "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    :goto_0
    if-eqz v6, :cond_1

    .line 377
    iget-object v8, p0, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v8}, Lcom/amazon/mShop/net/CallObserver;->onResponseReceived()V

    .line 378
    iget-object v8, p0, Lcom/amazon/mShop/net/BitmapFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v8, v9}, Lcom/amazon/mShop/net/CallObserver;->setCacheHit(Z)V

    .line 379
    invoke-virtual {v4, v9}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->setCached(Z)V

    .line 380
    invoke-virtual {p0, v6}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V

    .line 381
    if-eqz v2, :cond_1

    .line 382
    invoke-static {v3, v6}, Lcom/amazon/mShop/net/LRUCache;->putValueWithKey(Ljava/lang/String;Ljava/lang/Object;)V

    .line 385
    :cond_1
    return-void

    .line 360
    .restart local v0    # "cacheInf":Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;
    .restart local v1    # "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getMaxDimension()I

    move-result v8

    invoke-static {v3, v5, v8}, Lcom/amazon/mShop/net/MShopDiskCache;->readBitmap(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;I)Landroid/graphics/Bitmap;

    move-result-object v6

    .line 361
    const/4 v2, 0x1

    .line 362
    if-nez v6, :cond_0

    .line 363
    invoke-virtual {p0, v10}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V

    goto :goto_0

    .line 368
    .end local v1    # "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    invoke-direct {p0, v7, v3, v5}, Lcom/amazon/mShop/net/BitmapFetcher;->httpFetch(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    goto :goto_0

    .line 371
    .end local v0    # "cacheInf":Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;
    :cond_4
    invoke-virtual {p0, v10}, Lcom/amazon/mShop/net/BitmapFetcher;->onPostExecute(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected getParameterizedClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 189
    const-class v0, Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    .locals 1

    .prologue
    .line 165
    invoke-super {p0}, Lcom/amazon/mShop/net/HttpFetcher;->getParams()Lcom/amazon/mShop/net/HttpFetcher$Params;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    return-object v0
.end method

.method public bridge synthetic getParams()Lcom/amazon/mShop/net/HttpFetcher$Params;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v0

    return-object v0
.end method

.method public handleResponse(Ljava/net/HttpURLConnection;)Landroid/graphics/Bitmap;
    .locals 3
    .param p1, "httpConnection"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 170
    invoke-virtual {p0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 171
    const/4 v1, 0x0

    .line 184
    :goto_0
    return-object v1

    .line 174
    :cond_0
    const/4 v1, 0x0

    .line 177
    .local v1, "result":Landroid/graphics/Bitmap;
    :try_start_0
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    invoke-static {v2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 178
    :catch_0
    move-exception v0

    .line 179
    .local v0, "oome":Ljava/lang/OutOfMemoryError;
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 181
    throw v0
.end method

.method public bridge synthetic handleResponse(Ljava/net/HttpURLConnection;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/net/BitmapFetcher;->handleResponse(Ljava/net/HttpURLConnection;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method
