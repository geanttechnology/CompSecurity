.class final Lcom/amazon/mShop/net/NetworkInfoMetricObserver$1;
.super Lcom/amazon/mShop/net/MetricsAggregator;
.source "NetworkInfoMetricObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/NetworkInfoMetricObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator;-><init>()V

    return-void
.end method

.method private getNetworkCollectionType(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 92
    const-string/jumbo v0, ""

    .line 94
    .local v0, "networkType":Ljava/lang/String;
    const-string/jumbo v1, "unknown"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 95
    const-string/jumbo v0, "Unknown"

    .line 100
    :goto_0
    return-object v0

    .line 97
    :cond_0
    const-string/jumbo v1, "Wifi"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string/jumbo v0, "Wifi"

    :goto_1
    goto :goto_0

    :cond_1
    const-string/jumbo v0, "Mobile"

    goto :goto_1
.end method


# virtual methods
.method public aggregate(Ljava/util/List;)Lcom/amazon/mShop/net/AggregatedMetrics;
    .locals 14
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
    .line 52
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 54
    .local v0, "clientMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
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

    .line 55
    .local v2, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    instance-of v10, v2, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    if-eqz v10, :cond_0

    move-object v9, v2

    .line 59
    check-cast v9, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    .line 60
    .local v9, "observer":Lcom/amazon/mShop/net/NetworkInfoMetricObserver;
    monitor-enter v9

    .line 61
    :try_start_0
    invoke-virtual {v9}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->getPageIdentifier()Ljava/lang/String;

    move-result-object v4

    .line 64
    .local v4, "identifier":Ljava/lang/String;
    const-string/jumbo v10, "none"

    invoke-virtual {v10, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_1

    invoke-virtual {v9}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->isStatusFailed()Z

    move-result v10

    if-eqz v10, :cond_2

    .line 65
    :cond_1
    monitor-exit v9

    goto :goto_0

    .line 77
    .end local v4    # "identifier":Ljava/lang/String;
    :catchall_0
    move-exception v10

    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v10

    .line 67
    .restart local v4    # "identifier":Ljava/lang/String;
    :cond_2
    :try_start_1
    invoke-direct {p0, v4}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver$1;->getNetworkCollectionType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 68
    .local v8, "networkType":Ljava/lang/String;
    const-string/jumbo v10, "%s/%s:%s"

    const/4 v11, 0x3

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v4, v11, v12

    const/4 v12, 0x1

    const-string/jumbo v13, "Latency"

    aput-object v13, v11, v12

    const/4 v12, 0x2

    aput-object v8, v11, v12

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 72
    .local v5, "latencyMetricName":Ljava/lang/String;
    new-instance v7, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    invoke-direct {v7}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 73
    .local v7, "metric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {v9}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->getTotalTime()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v7, v10}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setTime(Ljava/lang/Integer;)V

    .line 74
    invoke-virtual {v7, v5}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 75
    const/4 v10, 0x1

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v7, v10}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 76
    invoke-interface {v0, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 77
    monitor-exit v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 80
    .end local v2    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v4    # "identifier":Ljava/lang/String;
    .end local v5    # "latencyMetricName":Ljava/lang/String;
    .end local v7    # "metric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v8    # "networkType":Ljava/lang/String;
    .end local v9    # "observer":Lcom/amazon/mShop/net/NetworkInfoMetricObserver;
    :cond_3
    # getter for: Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->access$000()Z

    move-result v10

    if-eqz v10, :cond_4

    .line 81
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v10

    const-string/jumbo v11, "Network collection aggregator data"

    invoke-static {v10, v11}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .line 83
    .local v1, "data":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v10

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v12, "Network collection data name is : "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, " time is "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getTime()Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 86
    .end local v1    # "data":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    :cond_4
    new-instance v6, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    invoke-direct {v6}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;-><init>()V

    .line 87
    .local v6, "mShopAggregatedMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    invoke-virtual {v6, v0}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 88
    return-object v6
.end method
