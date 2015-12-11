.class final Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;
.super Lcom/amazon/mShop/net/MetricsSender;
.source "MShopAggregatedClientMetrics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field private mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsSender;-><init>()V

    .line 111
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    return-void
.end method

.method private appendClickedSlots(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 128
    .local p1, "slotTokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getClickedSlots()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1}, Ljava/util/Vector;-><init>()V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setClickedSlots(Ljava/util/List;)V

    .line 131
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getClickedSlots()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 132
    return-void
.end method

.method private appendClientMetrics(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 114
    .local p1, "metrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getMetrics()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1}, Ljava/util/Vector;-><init>()V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 117
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getMetrics()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 118
    return-void
.end method

.method private appendExposedSlots(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 121
    .local p1, "slotTokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getExposedSlots()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 122
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1}, Ljava/util/Vector;-><init>()V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setExposedSlots(Ljava/util/List;)V

    .line 124
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getExposedSlots()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 125
    return-void
.end method


# virtual methods
.method public appendAggregatedMetrics(Lcom/amazon/mShop/net/AggregatedMetrics;)V
    .locals 3
    .param p1, "aggregatedMetrics"    # Lcom/amazon/mShop/net/AggregatedMetrics;

    .prologue
    .line 56
    instance-of v2, p1, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    if-eqz v2, :cond_2

    move-object v1, p1

    .line 57
    check-cast v1, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    .line 60
    .local v1, "mshopAggregatedClientMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    invoke-virtual {v1}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->getClientMetrics()Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    move-result-object v0

    .line 62
    .local v0, "clientMetrics":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getMetrics()Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 63
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getMetrics()Ljava/util/List;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->appendClientMetrics(Ljava/util/List;)V

    .line 66
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getExposedSlots()Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 67
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getExposedSlots()Ljava/util/List;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->appendExposedSlots(Ljava/util/List;)V

    .line 70
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getClickedSlots()Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 71
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getClickedSlots()Ljava/util/List;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->appendClickedSlots(Ljava/util/List;)V

    .line 75
    .end local v0    # "clientMetrics":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    .end local v1    # "mshopAggregatedClientMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    :cond_2
    return-void
.end method

.method public postMetrics()V
    .locals 7

    .prologue
    .line 79
    # getter for: Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->access$000()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 80
    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getMetrics()Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 81
    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getMetrics()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .line 82
    .local v0, "c":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    const-string/jumbo v4, "Amazon"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, " -> "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " count:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getCount()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " size:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getSize()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " time:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getTime()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " info:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getInfo()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 86
    .end local v0    # "c":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getClickedSlots()Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 87
    const-string/jumbo v4, "Amazon"

    const-string/jumbo v5, "clickedSlots metric:"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getClickedSlots()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .restart local v3    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 89
    .local v1, "clickedSlot":Ljava/lang/String;
    const-string/jumbo v4, "Amazon"

    invoke-static {v4, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 93
    .end local v1    # "clickedSlot":Ljava/lang/String;
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getExposedSlots()Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 94
    const-string/jumbo v4, "Amazon"

    const-string/jumbo v5, "exposedSlots metric:"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getExposedSlots()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .restart local v3    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 96
    .local v2, "exposedSlot":Ljava/lang/String;
    const-string/jumbo v4, "Amazon"

    invoke-static {v4, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 102
    .end local v2    # "exposedSlot":Ljava/lang/String;
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getClickedSlots()Ljava/util/List;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getExposedSlots()Ljava/util/List;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->getMetrics()Ljava/util/List;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 105
    :cond_3
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    # getter for: Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->sPostMetricsResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;
    invoke-static {}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->access$100()Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 108
    :cond_4
    new-instance v4, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;-><init>()V

    iput-object v4, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    .line 109
    return-void
.end method
