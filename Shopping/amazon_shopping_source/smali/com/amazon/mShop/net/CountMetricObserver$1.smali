.class final Lcom/amazon/mShop/net/CountMetricObserver$1;
.super Lcom/amazon/mShop/net/MetricsAggregator;
.source "CountMetricObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/CountMetricObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 123
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
    .line 128
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 131
    .local v1, "clientMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getCurrentCarrierName()Ljava/lang/String;

    move-result-object v0

    .line 133
    .local v0, "carrier":Ljava/lang/String;
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 134
    .local v4, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    instance-of v11, v4, Lcom/amazon/mShop/net/CountMetricObserver;

    if-eqz v11, :cond_0

    move-object v9, v4

    .line 138
    check-cast v9, Lcom/amazon/mShop/net/CountMetricObserver;

    .line 139
    .local v9, "observer":Lcom/amazon/mShop/net/CountMetricObserver;
    monitor-enter v9

    .line 140
    :try_start_0
    # getter for: Lcom/amazon/mShop/net/CountMetricObserver;->sMetricPrefixMap:Ljava/util/Map;
    invoke-static {}, Lcom/amazon/mShop/net/CountMetricObserver;->access$100()Ljava/util/Map;

    move-result-object v11

    # invokes: Lcom/amazon/mShop/net/CountMetricObserver;->getMetricType()Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
    invoke-static {v9}, Lcom/amazon/mShop/net/CountMetricObserver;->access$000(Lcom/amazon/mShop/net/CountMetricObserver;)Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    move-result-object v12

    invoke-interface {v11, v12}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 141
    .local v10, "prefix":Ljava/lang/String;
    # invokes: Lcom/amazon/mShop/net/CountMetricObserver;->getMetric()Ljava/lang/String;
    invoke-static {v9}, Lcom/amazon/mShop/net/CountMetricObserver;->access$200(Lcom/amazon/mShop/net/CountMetricObserver;)Ljava/lang/String;

    move-result-object v7

    .line 142
    .local v7, "metric":Ljava/lang/String;
    # invokes: Lcom/amazon/mShop/net/CountMetricObserver;->getCount()I
    invoke-static {v9}, Lcom/amazon/mShop/net/CountMetricObserver;->access$300(Lcom/amazon/mShop/net/CountMetricObserver;)I

    move-result v2

    .line 143
    .local v2, "count":I
    const-string/jumbo v12, "%s/%s%s"

    const/4 v11, 0x3

    new-array v13, v11, [Ljava/lang/Object;

    const/4 v14, 0x0

    if-eqz v0, :cond_1

    move-object v11, v0

    :goto_1
    aput-object v11, v13, v14

    const/4 v11, 0x1

    if-eqz v10, :cond_2

    .end local v10    # "prefix":Ljava/lang/String;
    :goto_2
    aput-object v10, v13, v11

    const/4 v11, 0x2

    if-eqz v7, :cond_3

    .end local v7    # "metric":Ljava/lang/String;
    :goto_3
    aput-object v7, v13, v11

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    .line 149
    .local v8, "metricName":Ljava/lang/String;
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 150
    .local v3, "countMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {v3, v8}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 151
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v3, v11}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 153
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 154
    monitor-exit v9

    goto :goto_0

    .end local v2    # "count":I
    .end local v3    # "countMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v8    # "metricName":Ljava/lang/String;
    :catchall_0
    move-exception v11

    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v11

    .line 143
    .restart local v2    # "count":I
    .restart local v7    # "metric":Ljava/lang/String;
    .restart local v10    # "prefix":Ljava/lang/String;
    :cond_1
    :try_start_1
    const-string/jumbo v11, ""

    goto :goto_1

    :cond_2
    const-string/jumbo v10, ""

    goto :goto_2

    .end local v10    # "prefix":Ljava/lang/String;
    :cond_3
    const-string/jumbo v7, ""
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_3

    .line 157
    .end local v2    # "count":I
    .end local v4    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v7    # "metric":Ljava/lang/String;
    .end local v9    # "observer":Lcom/amazon/mShop/net/CountMetricObserver;
    :cond_4
    new-instance v6, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    invoke-direct {v6}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;-><init>()V

    .line 158
    .local v6, "mShopAggregatedMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    invoke-virtual {v6, v1}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 159
    return-object v6
.end method
