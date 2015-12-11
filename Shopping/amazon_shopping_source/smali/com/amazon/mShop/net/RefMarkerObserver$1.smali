.class final Lcom/amazon/mShop/net/RefMarkerObserver$1;
.super Lcom/amazon/mShop/net/MetricsAggregator;
.source "RefMarkerObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/RefMarkerObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 555
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator;-><init>()V

    return-void
.end method


# virtual methods
.method public aggregate(Ljava/util/List;)Lcom/amazon/mShop/net/AggregatedMetrics;
    .locals 6
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
    .line 560
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 561
    .local v3, "refMarkers":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 562
    .local v1, "metricEvent":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    instance-of v5, v1, Lcom/amazon/mShop/net/RefMarkerObserver;

    if-eqz v5, :cond_0

    .line 566
    check-cast v1, Lcom/amazon/mShop/net/RefMarkerObserver;

    .end local v1    # "metricEvent":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    invoke-virtual {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->getRefMarker()Ljava/lang/String;

    move-result-object v2

    .line 567
    .local v2, "refMarker":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 568
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 572
    .end local v2    # "refMarker":Ljava/lang/String;
    :cond_1
    new-instance v4, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;

    invoke-direct {v4}, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;-><init>()V

    .line 573
    .local v4, "refMarkersAggregatedMetrics":Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;
    invoke-virtual {v4, v3}, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->setRefmarkers(Ljava/util/List;)V

    .line 574
    return-object v4
.end method
