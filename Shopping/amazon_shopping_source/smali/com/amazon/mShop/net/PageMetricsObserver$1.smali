.class final Lcom/amazon/mShop/net/PageMetricsObserver$1;
.super Lcom/amazon/mShop/net/MetricsAggregator;
.source "PageMetricsObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/PageMetricsObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 523
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator;-><init>()V

    return-void
.end method


# virtual methods
.method public aggregate(Ljava/util/List;)Lcom/amazon/mShop/net/AggregatedMetrics;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;",
            ">;)",
            "Lcom/amazon/mShop/net/AggregatedMetrics;"
        }
    .end annotation

    .prologue
    .line 529
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 532
    .local v1, "clientMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getCurrentCarrierName()Ljava/lang/String;

    move-result-object v0

    .line 534
    .local v0, "carrier":Ljava/lang/String;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 535
    .local v2, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    instance-of v10, v2, Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v10, :cond_0

    move-object v9, v2

    .line 539
    check-cast v9, Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 540
    .local v9, "observer":Lcom/amazon/mShop/net/PageMetricsObserver;
    monitor-enter v9

    .line 541
    :try_start_0
    invoke-virtual {v9}, Lcom/amazon/mShop/net/PageMetricsObserver;->getPageIdentifier()Ljava/lang/String;

    move-result-object v4

    .line 542
    .local v4, "identifier":Ljava/lang/String;
    invoke-virtual {v9}, Lcom/amazon/mShop/net/PageMetricsObserver;->isStatusFailed()Z

    move-result v10

    if-eqz v10, :cond_2

    const-string/jumbo v8, "Failed"

    .line 543
    .local v8, "metricType":Ljava/lang/String;
    :goto_1
    const-string/jumbo v10, "%s/%s:%s"

    const/4 v11, 0x3

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v0, v11, v12

    const/4 v12, 0x1

    aput-object v8, v11, v12

    const/4 v12, 0x2

    aput-object v4, v11, v12

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 547
    .local v6, "latencyMetricName":Ljava/lang/String;
    # getter for: Lcom/amazon/mShop/net/PageMetricsObserver;->LOG_TEST_METRICS:Z
    invoke-static {}, Lcom/amazon/mShop/net/PageMetricsObserver;->access$000()Z

    move-result v10

    if-eqz v10, :cond_1

    .line 549
    const-string/jumbo v10, "PageLatencyTest"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ":"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v9}, Lcom/amazon/mShop/net/PageMetricsObserver;->getTotalTime()I

    move-result v12

    invoke-static {v12}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 559
    :cond_1
    new-instance v5, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 560
    .local v5, "latencyMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {v5, v6}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 561
    const/4 v10, 0x1

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 562
    invoke-virtual {v9}, Lcom/amazon/mShop/net/PageMetricsObserver;->getTotalTime()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v5, v10}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setTime(Ljava/lang/Integer;)V

    .line 564
    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 565
    monitor-exit v9

    goto :goto_0

    .end local v4    # "identifier":Ljava/lang/String;
    .end local v5    # "latencyMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v6    # "latencyMetricName":Ljava/lang/String;
    .end local v8    # "metricType":Ljava/lang/String;
    :catchall_0
    move-exception v10

    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v10

    .line 542
    .restart local v4    # "identifier":Ljava/lang/String;
    :cond_2
    :try_start_1
    const-string/jumbo v8, "Latency"
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 569
    .end local v2    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v4    # "identifier":Ljava/lang/String;
    .end local v9    # "observer":Lcom/amazon/mShop/net/PageMetricsObserver;
    :cond_3
    new-instance v7, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    invoke-direct {v7}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;-><init>()V

    .line 570
    .local v7, "mShopAggregatedMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    invoke-virtual {v7, v1}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 571
    return-object v7
.end method
