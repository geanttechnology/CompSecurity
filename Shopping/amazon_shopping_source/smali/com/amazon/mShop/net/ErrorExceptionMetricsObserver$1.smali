.class final Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver$1;
.super Lcom/amazon/mShop/net/MetricsAggregator;
.source "ErrorExceptionMetricsObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 50
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
    .line 55
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 58
    .local v3, "clientMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 60
    .local v0, "aggregatedMetrics":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_5

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 61
    .local v6, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    instance-of v11, v6, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;

    if-eqz v11, :cond_0

    move-object v10, v6

    .line 65
    check-cast v10, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;

    .line 66
    .local v10, "observer":Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;
    # invokes: Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->getException()Ljava/lang/Exception;
    invoke-static {v10}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->access$000(Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;)Ljava/lang/Exception;

    move-result-object v11

    if-eqz v11, :cond_0

    .line 70
    # invokes: Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->getException()Ljava/lang/Exception;
    invoke-static {v10}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->access$000(Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;)Ljava/lang/Exception;

    move-result-object v11

    # invokes: Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->getErrorMessage(Ljava/lang/Exception;)Ljava/lang/String;
    invoke-static {v11}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->access$100(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v5

    .line 73
    .local v5, "errorMessage":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getCurrentCarrierName()Ljava/lang/String;

    move-result-object v1

    .line 74
    .local v1, "carrier":Ljava/lang/String;
    const-string/jumbo v11, "%s/%s:%s"

    const/4 v12, 0x3

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v1, v12, v13

    const/4 v13, 0x1

    const-string/jumbo v14, "ErrorExceptionType"

    aput-object v14, v12, v13

    const/4 v13, 0x2

    # invokes: Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->getException()Ljava/lang/Exception;
    invoke-static {v10}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->access$000(Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;)Ljava/lang/Exception;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v14

    aput-object v14, v12, v13

    invoke-static {v11, v12}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    .line 76
    .local v9, "metricName":Ljava/lang/String;
    invoke-interface {v0, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .line 78
    .local v2, "clientMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 79
    .local v4, "errorInfo":Ljava/lang/StringBuilder;
    const-string/jumbo v11, "Info: { Model: "

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v12, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ",\n SDK: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v12, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ",\n Release: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v12, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 83
    if-nez v2, :cond_3

    .line 84
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .end local v2    # "clientMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 85
    .restart local v2    # "clientMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {v2, v9}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 86
    invoke-interface {v0, v9, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_1

    .line 90
    const-string/jumbo v11, ",\n Error Message: "

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 93
    :cond_1
    const/4 v11, 0x1

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v2, v11}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 106
    :cond_2
    :goto_1
    const-string/jumbo v11, "}"

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v2, v11}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setInfo(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 97
    :cond_3
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getCount()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    add-int/lit8 v11, v11, 0x1

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v2, v11}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 98
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_4

    .line 99
    const-string/jumbo v11, ",\n Error Message: "

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 102
    :cond_4
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getInfo()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_2

    .line 103
    const/4 v11, 0x0

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getInfo()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string/jumbo v13, ", "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v4, v11, v12}, Ljava/lang/StringBuilder;->insert(ILjava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 110
    .end local v1    # "carrier":Ljava/lang/String;
    .end local v2    # "clientMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v4    # "errorInfo":Ljava/lang/StringBuilder;
    .end local v5    # "errorMessage":Ljava/lang/String;
    .end local v6    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v9    # "metricName":Ljava/lang/String;
    .end local v10    # "observer":Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;
    :cond_5
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v11

    invoke-interface {v3, v11}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 111
    new-instance v8, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    invoke-direct {v8}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;-><init>()V

    .line 112
    .local v8, "mShopAggregatedMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    invoke-virtual {v8, v3}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 113
    return-object v8
.end method
