.class final Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver$1;
.super Lcom/amazon/mShop/net/MetricsAggregator;
.source "ExposedSlotsMetricsObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 30
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
    .line 35
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 36
    .local v4, "slotTokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 37
    .local v0, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    instance-of v5, v0, Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;

    if-eqz v5, :cond_0

    move-object v3, v0

    .line 41
    check-cast v3, Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;

    .line 42
    .local v3, "observer":Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;
    invoke-virtual {v3}, Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;->getSlotTokens()Ljava/util/List;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 44
    .end local v0    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v3    # "observer":Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;
    :cond_1
    new-instance v2, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    invoke-direct {v2}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;-><init>()V

    .line 45
    .local v2, "mShopAggregatedMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    invoke-virtual {v2, v4}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->setExposedSlots(Ljava/util/List;)V

    .line 46
    return-object v2
.end method
