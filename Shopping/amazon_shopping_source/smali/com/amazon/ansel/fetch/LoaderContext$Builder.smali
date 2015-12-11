.class public Lcom/amazon/ansel/fetch/LoaderContext$Builder;
.super Ljava/lang/Object;
.source "LoaderContext.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/ansel/fetch/LoaderContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private callbackExecutor:Ljava/util/concurrent/Executor;

.field private envContext:Landroid/content/Context;

.field private executor:Ljava/util/concurrent/ThreadPoolExecutor;

.field private maxPrimaryCacheMemSize:I

.field private primaryCacheFactory:Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;>;"
        }
    .end annotation
.end field

.field private queue:Ljava/util/concurrent/BlockingQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/BlockingQueue",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field private readCache:Z

.field private readPrimaryCache:Z

.field private removalInvalidates:Z

.field private sendCallbacksToUiThread:Z

.field private trackReferences:Z

.field private useCache:Z

.field private usePrimaryCache:Z

.field private useWeakResourceListeners:Z

.field private webClientFactory:Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

.field private writeCache:Z

.field private writePrimaryCache:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "envContext"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 336
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 319
    iput-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->useWeakResourceListeners:Z

    .line 320
    iput-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->useCache:Z

    .line 321
    iput-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->readCache:Z

    .line 322
    iput-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->writeCache:Z

    .line 323
    iput-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->usePrimaryCache:Z

    .line 324
    iput-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->readPrimaryCache:Z

    .line 325
    iput-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->writePrimaryCache:Z

    .line 326
    iput-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->removalInvalidates:Z

    .line 327
    iput-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->trackReferences:Z

    .line 328
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->maxPrimaryCacheMemSize:I

    .line 334
    iput-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->sendCallbacksToUiThread:Z

    .line 337
    iput-object p1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->envContext:Landroid/content/Context;

    .line 338
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/ansel/fetch/LoaderContext;
    .locals 14

    .prologue
    .line 488
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->removalInvalidates:Z

    if-eqz v0, :cond_0

    .line 489
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->trackReferences:Z

    .line 492
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->primaryCacheFactory:Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;

    if-nez v0, :cond_2

    .line 493
    iget v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->maxPrimaryCacheMemSize:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 494
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->envContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->getDefaultPrimaryCacheMemSize(Landroid/content/Context;)I

    move-result v0

    iput v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->maxPrimaryCacheMemSize:I

    .line 497
    :cond_1
    iget v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->maxPrimaryCacheMemSize:I

    invoke-static {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->createDefaultPrimaryCacheFactory(I)Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->primaryCacheFactory:Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;

    .line 500
    :cond_2
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    if-nez v0, :cond_3

    .line 501
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->queue:Ljava/util/concurrent/BlockingQueue;

    invoke-static {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->createDefaultExecutor(Ljava/util/concurrent/BlockingQueue;)Ljava/util/concurrent/ThreadPoolExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 504
    :cond_3
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->webClientFactory:Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

    if-nez v0, :cond_4

    .line 505
    invoke-static {}, Lcom/amazon/ansel/fetch/LoaderContext;->createDefaultWebClientFactory()Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->webClientFactory:Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

    .line 508
    :cond_4
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->callbackExecutor:Ljava/util/concurrent/Executor;

    if-nez v0, :cond_5

    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->sendCallbacksToUiThread:Z

    if-eqz v0, :cond_5

    .line 509
    invoke-static {}, Lcom/amazon/ansel/fetch/UiThreadExecutor;->getInstance()Lcom/amazon/ansel/fetch/UiThreadExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->callbackExecutor:Ljava/util/concurrent/Executor;

    .line 512
    :cond_5
    new-instance v0, Lcom/amazon/ansel/fetch/LoaderContext;

    iget-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->useWeakResourceListeners:Z

    iget-boolean v2, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->useCache:Z

    iget-boolean v3, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->readCache:Z

    iget-boolean v4, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->writeCache:Z

    iget-boolean v5, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->usePrimaryCache:Z

    iget-boolean v6, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->readPrimaryCache:Z

    iget-boolean v7, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->writePrimaryCache:Z

    iget-boolean v8, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->removalInvalidates:Z

    iget-boolean v9, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->trackReferences:Z

    iget-object v10, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->primaryCacheFactory:Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;

    iget-object v11, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v12, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->webClientFactory:Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

    iget-object v13, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->callbackExecutor:Ljava/util/concurrent/Executor;

    invoke-direct/range {v0 .. v13}, Lcom/amazon/ansel/fetch/LoaderContext;-><init>(ZZZZZZZZZLcom/amazon/ansel/fetch/cache/ResourceCacheFactory;Ljava/util/concurrent/ThreadPoolExecutor;Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;Ljava/util/concurrent/Executor;)V

    return-object v0
.end method

.method public setUseWeakResourceListeners(Z)Lcom/amazon/ansel/fetch/LoaderContext$Builder;
    .locals 0
    .param p1, "useWeakResourceListeners"    # Z

    .prologue
    .line 345
    iput-boolean p1, p0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->useWeakResourceListeners:Z

    .line 346
    return-object p0
.end method
