.class final Lcom/amazon/mShop/net/MetricsCollector$1;
.super Ljava/lang/Object;
.source "MetricsCollector.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MetricsCollector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 15

    .prologue
    const-wide/32 v13, 0xea60

    .line 119
    :goto_0
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 122
    .local v4, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    :try_start_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    .line 126
    .local v1, "enterTime":J
    # getter for: Lcom/amazon/mShop/net/MetricsCollector;->sCompletedEventsQueue:Ljava/util/concurrent/LinkedBlockingQueue;
    invoke-static {}, Lcom/amazon/mShop/net/MetricsCollector;->access$000()Ljava/util/concurrent/LinkedBlockingQueue;

    move-result-object v11

    invoke-virtual {v11}, Ljava/util/concurrent/LinkedBlockingQueue;->take()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 127
    .local v3, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 133
    :goto_1
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v5

    .line 134
    .local v5, "now":J
    sub-long v9, v5, v1

    .line 136
    .local v9, "waitTime":J
    const-wide/32 v11, 0x1d4c0

    cmp-long v11, v9, v11

    if-lez v11, :cond_1

    .line 198
    .end local v1    # "enterTime":J
    .end local v3    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v5    # "now":J
    .end local v9    # "waitTime":J
    :cond_0
    :goto_2
    # getter for: Lcom/amazon/mShop/net/MetricsCollector;->sCompletedEventsQueue:Ljava/util/concurrent/LinkedBlockingQueue;
    invoke-static {}, Lcom/amazon/mShop/net/MetricsCollector;->access$000()Ljava/util/concurrent/LinkedBlockingQueue;

    move-result-object v11

    invoke-virtual {v11, v4}, Ljava/util/concurrent/LinkedBlockingQueue;->drainTo(Ljava/util/Collection;)I

    .line 199
    # invokes: Lcom/amazon/mShop/net/MetricsCollector;->collect(Ljava/util/Collection;)V
    invoke-static {v4}, Lcom/amazon/mShop/net/MetricsCollector;->access$100(Ljava/util/Collection;)V

    goto :goto_0

    .line 145
    .restart local v1    # "enterTime":J
    .restart local v3    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .restart local v5    # "now":J
    .restart local v9    # "waitTime":J
    :cond_1
    const-wide/32 v7, 0x1d4c0

    .line 147
    .local v7, "pollWaitTime":J
    :try_start_1
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v11

    const/16 v12, 0x1e

    if-lt v11, v12, :cond_2

    .line 149
    add-long v11, v1, v13

    cmp-long v11, v5, v11

    if-gtz v11, :cond_0

    .line 160
    add-long v11, v1, v13

    sub-long v7, v11, v5

    .line 168
    :cond_2
    # getter for: Lcom/amazon/mShop/net/MetricsCollector;->sCompletedEventsQueue:Ljava/util/concurrent/LinkedBlockingQueue;
    invoke-static {}, Lcom/amazon/mShop/net/MetricsCollector;->access$000()Ljava/util/concurrent/LinkedBlockingQueue;

    move-result-object v11

    sget-object v12, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v11, v7, v8, v12}, Ljava/util/concurrent/LinkedBlockingQueue;->poll(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    check-cast v3, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 169
    .restart local v3    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    if-eqz v3, :cond_0

    .line 179
    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 182
    .end local v1    # "enterTime":J
    .end local v3    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v5    # "now":J
    .end local v7    # "pollWaitTime":J
    .end local v9    # "waitTime":J
    :catch_0
    move-exception v0

    .line 184
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string/jumbo v11, "Amazon"

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2
.end method
