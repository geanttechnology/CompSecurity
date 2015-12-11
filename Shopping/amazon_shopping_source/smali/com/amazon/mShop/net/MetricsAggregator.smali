.class public abstract Lcom/amazon/mShop/net/MetricsAggregator;
.super Ljava/lang/Object;
.source "MetricsAggregator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;,
        Lcom/amazon/mShop/net/MetricsAggregator$Type;
    }
.end annotation


# static fields
.field public static sMetricsAggregatorMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/net/MetricsAggregator$Type;",
            "Lcom/amazon/mShop/net/MetricsAggregator;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 132
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/MetricsAggregator;->sMetricsAggregatorMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 164
    return-void
.end method

.method static aggregate(Ljava/util/Collection;)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/net/AggregatedMetrics;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    .local p0, "events":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 31
    .local v6, "metricsGroupedByType":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/mShop/net/MetricsAggregator$Type;Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;>;"
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 32
    .local v3, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    invoke-virtual {v3}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;->getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;

    move-result-object v8

    .line 33
    .local v8, "type":Lcom/amazon/mShop/net/MetricsAggregator$Type;
    invoke-interface {v6, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/List;

    .line 34
    .local v7, "previousMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    if-nez v7, :cond_0

    .line 35
    new-instance v7, Ljava/util/ArrayList;

    .end local v7    # "previousMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 36
    .restart local v7    # "previousMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    invoke-interface {v6, v8, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    :cond_0
    invoke-interface {v7, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 42
    .end local v3    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v7    # "previousMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    .end local v8    # "type":Lcom/amazon/mShop/net/MetricsAggregator$Type;
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 45
    .local v1, "aggregatedMetricsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/AggregatedMetrics;>;"
    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 46
    .local v5, "metrics":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/amazon/mShop/net/MetricsAggregator$Type;Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;>;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/mShop/net/MetricsAggregator$Type;

    invoke-static {v9}, Lcom/amazon/mShop/net/MetricsAggregator;->getAggregatorForType(Lcom/amazon/mShop/net/MetricsAggregator$Type;)Lcom/amazon/mShop/net/MetricsAggregator;

    move-result-object v2

    .line 47
    .local v2, "aggregator":Lcom/amazon/mShop/net/MetricsAggregator;
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-virtual {v2, v9}, Lcom/amazon/mShop/net/MetricsAggregator;->aggregate(Ljava/util/List;)Lcom/amazon/mShop/net/AggregatedMetrics;

    move-result-object v0

    .line 48
    .local v0, "aggregatedMetrics":Lcom/amazon/mShop/net/AggregatedMetrics;
    if-eqz v0, :cond_2

    .line 49
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 53
    .end local v0    # "aggregatedMetrics":Lcom/amazon/mShop/net/AggregatedMetrics;
    .end local v2    # "aggregator":Lcom/amazon/mShop/net/MetricsAggregator;
    .end local v5    # "metrics":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/amazon/mShop/net/MetricsAggregator$Type;Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;>;"
    :cond_3
    return-object v1
.end method

.method public static getAggregatorForType(Lcom/amazon/mShop/net/MetricsAggregator$Type;)Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 2
    .param p0, "type"    # Lcom/amazon/mShop/net/MetricsAggregator$Type;

    .prologue
    .line 141
    sget-object v1, Lcom/amazon/mShop/net/MetricsAggregator;->sMetricsAggregatorMap:Ljava/util/Map;

    monitor-enter v1

    .line 142
    :try_start_0
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator;->sMetricsAggregatorMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/MetricsAggregator;

    monitor-exit v1

    return-object v0

    .line 143
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static registerAggregator(Lcom/amazon/mShop/net/MetricsAggregator$Type;Lcom/amazon/mShop/net/MetricsAggregator;)V
    .locals 2
    .param p0, "type"    # Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .param p1, "aggregator"    # Lcom/amazon/mShop/net/MetricsAggregator;

    .prologue
    .line 153
    sget-object v1, Lcom/amazon/mShop/net/MetricsAggregator;->sMetricsAggregatorMap:Ljava/util/Map;

    monitor-enter v1

    .line 154
    :try_start_0
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator;->sMetricsAggregatorMap:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    monitor-exit v1

    .line 156
    return-void

    .line 155
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public abstract aggregate(Ljava/util/List;)Lcom/amazon/mShop/net/AggregatedMetrics;
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
.end method
