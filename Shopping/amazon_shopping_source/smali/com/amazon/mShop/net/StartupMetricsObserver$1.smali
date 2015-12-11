.class final Lcom/amazon/mShop/net/StartupMetricsObserver$1;
.super Lcom/amazon/mShop/net/MetricsAggregator;
.source "StartupMetricsObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/StartupMetricsObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator;-><init>()V

    return-void
.end method


# virtual methods
.method public aggregate(Ljava/util/List;)Lcom/amazon/mShop/net/AggregatedMetrics;
    .locals 15
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
    .line 93
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 96
    .local v2, "clientMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getCurrentCarrierName()Ljava/lang/String;

    move-result-object v1

    .line 99
    .local v1, "carrier":Ljava/lang/String;
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 102
    .local v0, "aggregatedMetrics":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_5

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 103
    .local v3, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    instance-of v11, v3, Lcom/amazon/mShop/net/StartupMetricsObserver;

    if-eqz v11, :cond_0

    move-object v8, v3

    .line 107
    check-cast v8, Lcom/amazon/mShop/net/StartupMetricsObserver;

    .line 108
    .local v8, "observer":Lcom/amazon/mShop/net/StartupMetricsObserver;
    monitor-enter v8

    .line 109
    :try_start_0
    sget-object v11, Lcom/amazon/mShop/net/StartupMetricsObserver;->sStartupPrefixMap:Ljava/util/Map;

    invoke-virtual {v8}, Lcom/amazon/mShop/net/StartupMetricsObserver;->getStartupType()Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    move-result-object v12

    invoke-interface {v11, v12}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 110
    .local v10, "startupType":Ljava/lang/String;
    invoke-virtual {v8}, Lcom/amazon/mShop/net/StartupMetricsObserver;->getMetricsType()Ljava/lang/String;

    move-result-object v7

    .line 111
    .local v7, "metricsType":Ljava/lang/String;
    const-string/jumbo v12, "%s/%s%s"

    const/4 v11, 0x3

    new-array v13, v11, [Ljava/lang/Object;

    const/4 v14, 0x0

    if-eqz v1, :cond_1

    move-object v11, v1

    :goto_1
    aput-object v11, v13, v14

    const/4 v11, 0x1

    if-eqz v10, :cond_2

    .end local v10    # "startupType":Ljava/lang/String;
    :goto_2
    aput-object v10, v13, v11

    const/4 v11, 0x2

    if-eqz v7, :cond_3

    .end local v7    # "metricsType":Ljava/lang/String;
    :goto_3
    aput-object v7, v13, v11

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 120
    .local v6, "metricName":Ljava/lang/String;
    invoke-interface {v0, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .line 121
    .local v9, "startMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    if-nez v9, :cond_4

    .line 122
    new-instance v9, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .end local v9    # "startMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-direct {v9}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 123
    .restart local v9    # "startMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {v9, v6}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 124
    invoke-interface {v0, v6, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 125
    const/4 v11, 0x1

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v9, v11}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 129
    :goto_4
    monitor-exit v8

    goto :goto_0

    .end local v6    # "metricName":Ljava/lang/String;
    .end local v9    # "startMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    :catchall_0
    move-exception v11

    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v11

    .line 111
    .restart local v7    # "metricsType":Ljava/lang/String;
    .restart local v10    # "startupType":Ljava/lang/String;
    :cond_1
    :try_start_1
    const-string/jumbo v11, ""

    goto :goto_1

    :cond_2
    const-string/jumbo v10, ""

    goto :goto_2

    .end local v10    # "startupType":Ljava/lang/String;
    :cond_3
    const-string/jumbo v7, ""

    goto :goto_3

    .line 127
    .end local v7    # "metricsType":Ljava/lang/String;
    .restart local v6    # "metricName":Ljava/lang/String;
    .restart local v9    # "startMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    :cond_4
    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getCount()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    add-int/lit8 v11, v11, 0x1

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v9, v11}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_4

    .line 132
    .end local v3    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v6    # "metricName":Ljava/lang/String;
    .end local v8    # "observer":Lcom/amazon/mShop/net/StartupMetricsObserver;
    .end local v9    # "startMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    :cond_5
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v11

    invoke-interface {v2, v11}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 133
    new-instance v5, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    invoke-direct {v5}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;-><init>()V

    .line 134
    .local v5, "mShopAggregatedMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    invoke-virtual {v5, v2}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 135
    return-object v5
.end method
