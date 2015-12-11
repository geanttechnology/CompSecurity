.class public Lcom/amazon/client/metrics/ConcurrentMetricEvent;
.super Ljava/lang/Object;
.source "ConcurrentMetricEvent.java"

# interfaces
.implements Lcom/amazon/client/metrics/MetricEvent;


# instance fields
.field private final mDelegate:Lcom/amazon/client/metrics/MetricEvent;


# direct methods
.method protected constructor <init>(Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 0
    .param p1, "delegate"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    .line 45
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/client/metrics/ConcurrentMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/client/metrics/ConcurrentMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V

    .line 35
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    new-instance v0, Lcom/amazon/client/metrics/BasicMetricEvent;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/amazon/client/metrics/BasicMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V

    iput-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    .line 40
    return-void
.end method


# virtual methods
.method public declared-synchronized addCounter(Ljava/lang/String;D)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D

    .prologue
    .line 64
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 65
    monitor-exit p0

    return-void

    .line 64
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V
    .locals 1
    .param p1, "dataPoint"    # Lcom/amazon/client/metrics/DataPoint;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/MetricsException;
        }
    .end annotation

    .prologue
    .line 139
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 140
    monitor-exit p0

    return-void

    .line 139
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized addDataPoints(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/MetricsException;
        }
    .end annotation

    .prologue
    .line 144
    .local p1, "dataPointList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->addDataPoints(Ljava/util/List;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 145
    monitor-exit p0

    return-void

    .line 144
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized addString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 104
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1, p2}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 105
    monitor-exit p0

    return-void

    .line 104
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized addTimer(Ljava/lang/String;D)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D

    .prologue
    .line 79
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/client/metrics/MetricEvent;->addTimer(Ljava/lang/String;D)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 80
    monitor-exit p0

    return-void

    .line 79
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized addTimer(Ljava/lang/String;DI)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D
    .param p4, "repeat"    # I

    .prologue
    .line 84
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/amazon/client/metrics/MetricEvent;->addTimer(Ljava/lang/String;DI)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 85
    monitor-exit p0

    return-void

    .line 84
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized appendString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 109
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1, p2}, Lcom/amazon/client/metrics/MetricEvent;->appendString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 110
    monitor-exit p0

    return-void

    .line 109
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized clear()V
    .locals 1

    .prologue
    .line 119
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0}, Lcom/amazon/client/metrics/MetricEvent;->clear()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 120
    monitor-exit p0

    return-void

    .line 119
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAsDataPoints()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 129
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0}, Lcom/amazon/client/metrics/MetricEvent;->getAsDataPoints()Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAsDataPointsAndClear()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 152
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v1}, Lcom/amazon/client/metrics/MetricEvent;->getAsDataPoints()Ljava/util/List;

    move-result-object v0

    .line 153
    .local v0, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    iget-object v1, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v1}, Lcom/amazon/client/metrics/MetricEvent;->clear()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 154
    monitor-exit p0

    return-object v0

    .line 152
    .end local v0    # "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getMetricEventType()Lcom/amazon/client/metrics/MetricEventType;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0}, Lcom/amazon/client/metrics/MetricEvent;->getMetricEventType()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    return-object v0
.end method

.method public getProgram()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0}, Lcom/amazon/client/metrics/MetricEvent;->getProgram()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSource()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0}, Lcom/amazon/client/metrics/MetricEvent;->getSource()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized hasDataPoints()Z
    .locals 1

    .prologue
    .line 124
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0}, Lcom/amazon/client/metrics/MetricEvent;->hasDataPoints()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized incrementCounter(Ljava/lang/String;D)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "toAdd"    # D

    .prologue
    .line 69
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 70
    monitor-exit p0

    return-void

    .line 69
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized removeCounter(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 74
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->removeCounter(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 75
    monitor-exit p0

    return-void

    .line 74
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized removeString(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 114
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->removeString(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 115
    monitor-exit p0

    return-void

    .line 114
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized removeTimer(Ljava/lang/String;)V
    .locals 1
    .param p1, "timer"    # Ljava/lang/String;

    .prologue
    .line 99
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->removeTimer(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 100
    monitor-exit p0

    return-void

    .line 99
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized restoreFromMap(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 162
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->restoreFromMap(Ljava/util/Map;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 163
    monitor-exit p0

    return-void

    .line 162
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized saveToMap(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 158
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->saveToMap(Ljava/util/Map;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 159
    monitor-exit p0

    return-void

    .line 158
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized startTimer(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 89
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 90
    monitor-exit p0

    return-void

    .line 89
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized stopTimer(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 94
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 95
    monitor-exit p0

    return-void

    .line 94
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->mDelegate:Lcom/amazon/client/metrics/MetricEvent;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
