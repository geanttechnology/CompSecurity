.class public Lcom/amazon/mShop/net/PageMetricsObserver;
.super Lcom/amazon/mShop/net/BaseMetricsObserver;
.source "PageMetricsObserver.java"


# static fields
.field private static LOG_TEST_METRICS:Z

.field static final METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;


# instance fields
.field private mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

.field private mObjectsRefCounters:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mPageIdentifier:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 75
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mShop/net/PageMetricsObserver;->LOG_TEST_METRICS:Z

    .line 523
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/PageMetricsObserver$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/PageMetricsObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 249
    invoke-direct {p0}, Lcom/amazon/mShop/net/BaseMetricsObserver;-><init>()V

    .line 343
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    .line 250
    iput-object p1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mPageIdentifier:Ljava/lang/String;

    .line 251
    return-void
.end method

.method static synthetic access$000()Z
    .locals 1

    .prologue
    .line 72
    sget-boolean v0, Lcom/amazon/mShop/net/PageMetricsObserver;->LOG_TEST_METRICS:Z

    return v0
.end method

.method public static start(Ljava/lang/String;)Lcom/amazon/mShop/net/PageMetricsObserver;
    .locals 1
    .param p0, "identifier"    # Ljava/lang/String;

    .prologue
    .line 317
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    .line 318
    .local v0, "observer":Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onStart()V

    .line 319
    return-object v0
.end method


# virtual methods
.method public declared-synchronized completeForObject(Ljava/lang/String;)V
    .locals 3
    .param p1, "objectId"    # Ljava/lang/String;

    .prologue
    .line 388
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_1

    .line 418
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 395
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v1

    if-nez v1, :cond_0

    .line 404
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .line 405
    .local v0, "value":I
    if-gtz v0, :cond_2

    .line 406
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 412
    :goto_1
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 413
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onComplete()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 388
    .end local v0    # "value":I
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 408
    .restart local v0    # "value":I
    :cond_2
    :try_start_2
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 1

    .prologue
    .line 511
    sget-object v0, Lcom/amazon/mShop/net/PageMetricsObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-object v0
.end method

.method public getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 506
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->PageMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method

.method public getPageIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mPageIdentifier:Ljava/lang/String;

    return-object v0
.end method

.method protected notifyListenerOnComplete()V
    .locals 2

    .prologue
    .line 287
    iget-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    if-eqz v0, :cond_0

    .line 288
    iget-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mPageIdentifier:Ljava/lang/String;

    invoke-interface {v0, p0, v1}, Lcom/amazon/mShop/net/PageMetricsEventListener;->onPageComplete(Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V

    .line 290
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    .line 292
    :cond_0
    return-void
.end method

.method protected notifyListenerOnPageCancelled()V
    .locals 2

    .prologue
    .line 298
    iget-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    if-eqz v0, :cond_0

    .line 299
    iget-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mPageIdentifier:Ljava/lang/String;

    invoke-interface {v0, p0, v1}, Lcom/amazon/mShop/net/PageMetricsEventListener;->onPageCancelled(Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V

    .line 301
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    .line 303
    :cond_0
    return-void
.end method

.method protected notifyListenerOnStart()V
    .locals 2

    .prologue
    .line 277
    iget-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    if-eqz v0, :cond_0

    .line 278
    iget-object v0, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mPageIdentifier:Ljava/lang/String;

    invoke-interface {v0, p0, v1}, Lcom/amazon/mShop/net/PageMetricsEventListener;->onPageStart(Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V

    .line 281
    :cond_0
    return-void
.end method

.method public declared-synchronized onCancelled()V
    .locals 1

    .prologue
    .line 465
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Canceled:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onFinished(Lcom/amazon/mShop/net/BaseMetricsObserver$Status;)V

    .line 466
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->notifyListenerOnPageCancelled()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 467
    monitor-exit p0

    return-void

    .line 465
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onComplete()V
    .locals 1

    .prologue
    .line 455
    monitor-enter p0

    :try_start_0
    invoke-super {p0}, Lcom/amazon/mShop/net/BaseMetricsObserver;->onComplete()V

    .line 456
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->notifyListenerOnComplete()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 457
    monitor-exit p0

    return-void

    .line 455
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "ignoredErrorMessage"    # Ljava/lang/String;

    .prologue
    .line 499
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/net/BaseMetricsObserver;->onFailed(Ljava/lang/String;)V

    .line 500
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->notifyListenerOnComplete()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 501
    monitor-exit p0

    return-void

    .line 499
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onStart()V
    .locals 1

    .prologue
    .line 446
    monitor-enter p0

    :try_start_0
    invoke-super {p0}, Lcom/amazon/mShop/net/BaseMetricsObserver;->onStart()V

    .line 447
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->notifyListenerOnStart()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 448
    monitor-exit p0

    return-void

    .line 446
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setEventListener(Lcom/amazon/mShop/net/PageMetricsEventListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/mShop/net/PageMetricsEventListener;

    .prologue
    .line 266
    iput-object p1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mEventListener:Lcom/amazon/mShop/net/PageMetricsEventListener;

    .line 267
    return-void
.end method

.method public declared-synchronized startForObject(Ljava/lang/String;)V
    .locals 3
    .param p1, "objectId"    # Ljava/lang/String;

    .prologue
    .line 353
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-eqz v1, :cond_1

    .line 380
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 360
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v1

    if-nez v1, :cond_0

    .line 367
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->getStatus()Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Unknown:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    if-ne v1, v2, :cond_2

    .line 370
    invoke-virtual {p0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onStart()V

    .line 374
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 375
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 353
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 377
    :cond_3
    :try_start_2
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 378
    .local v0, "value":I
    iget-object v1, p0, Lcom/amazon/mShop/net/PageMetricsObserver;->mObjectsRefCounters:Ljava/util/Map;

    add-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method
