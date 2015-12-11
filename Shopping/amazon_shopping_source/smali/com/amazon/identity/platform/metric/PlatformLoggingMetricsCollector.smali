.class Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;
.super Ljava/lang/Object;
.source "PlatformLoggingMetricsCollector.java"

# interfaces
.implements Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;


# instance fields
.field private final mTag:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "loggingTag"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 21
    const-class v0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->mTag:Ljava/lang/String;

    .line 27
    :goto_0
    return-void

    .line 25
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->mTag:Ljava/lang/String;

    goto :goto_0
.end method

.method private incrementExtraCounters(Ljava/lang/String;Ljava/util/Map;)V
    .locals 6
    .param p1, "metricComponent"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)V"
        }
    .end annotation

    .prologue
    .line 79
    .local p2, "extraCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "IncrementCounter: "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 80
    .local v2, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 83
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;*>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    .line 84
    .local v3, "value":Ljava/lang/Object;
    instance-of v4, v3, Ljava/lang/Integer;

    if-nez v4, :cond_1

    instance-of v4, v3, Ljava/lang/String;

    if-eqz v4, :cond_0

    .line 86
    :cond_1
    const-string/jumbo v4, ","

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 90
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;*>;"
    .end local v3    # "value":Ljava/lang/Object;
    :cond_2
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->logMetric(Ljava/lang/String;)V

    .line 91
    return-void
.end method


# virtual methods
.method public createPeriodicTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 69
    sget-object v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->NULL_TIMER:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-object v0
.end method

.method public createTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 124
    new-instance v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$FakeMetricsTimer;

    invoke-direct {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$FakeMetricsTimer;-><init>()V

    return-object v0
.end method

.method public varargs increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 7
    .param p1, "counter"    # Ljava/lang/String;
    .param p2, "extraCounters"    # [Ljava/lang/String;

    .prologue
    .line 96
    iget-object v4, p0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->mTag:Ljava/lang/String;

    invoke-static {v4, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    move-object v0, p2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, p2

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 99
    .local v1, "extraCounter":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->mTag:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 101
    .end local v1    # "extraCounter":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public incrementCounter(Ljava/lang/String;)V
    .locals 3
    .param p1, "counter"    # Ljava/lang/String;

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->mTag:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Increment counter : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 107
    return-void
.end method

.method public incrementCounter(Ljava/lang/String;D)V
    .locals 3
    .param p1, "counter"    # Ljava/lang/String;
    .param p2, "count"    # D

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->mTag:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Increment counter : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", by : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2, p3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 113
    return-void
.end method

.method public incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .param p1, "metricComponent"    # Ljava/lang/String;
    .param p2, "metricName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 49
    .local p3, "extraCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-direct {p0, p1, p3}, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->incrementExtraCounters(Ljava/lang/String;Ljava/util/Map;)V

    .line 50
    return-void
.end method

.method public varargs incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 7
    .param p1, "metricComponent"    # Ljava/lang/String;
    .param p2, "metricName"    # Ljava/lang/String;
    .param p3, "extraCounters"    # [Ljava/lang/String;

    .prologue
    .line 34
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "IncrementCounter: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 35
    .local v4, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 36
    move-object v0, p3

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, p3

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 38
    .local v1, "entry":Ljava/lang/String;
    const-string/jumbo v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "=1"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 36
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 41
    .end local v1    # "entry":Ljava/lang/String;
    :cond_0
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->logMetric(Ljava/lang/String;)V

    .line 42
    return-void
.end method

.method public incrementStateMetricCounter(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .param p1, "metricComponent"    # Ljava/lang/String;
    .param p2, "metricName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 57
    .local p3, "extraCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p3}, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->incrementExtraCounters(Ljava/lang/String;Ljava/util/Map;)V

    .line 58
    return-void
.end method

.method protected logMetric(Ljava/lang/String;)V
    .locals 1
    .param p1, "metric"    # Ljava/lang/String;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->mTag:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 75
    return-void
.end method

.method public recordEvent()V
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->mTag:Ljava/lang/String;

    const-string/jumbo v1, "Recording metric event object"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    return-void
.end method

.method public recordMetricTimerEvent(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 4
    .param p1, "metricComponent"    # Ljava/lang/String;
    .param p2, "timerName"    # Ljava/lang/String;
    .param p3, "elapsedTimeMs"    # J

    .prologue
    .line 63
    const-string/jumbo v0, "RecordTiming: %s:%s=%d"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    const/4 v2, 0x2

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/platform/metric/PlatformLoggingMetricsCollector;->logMetric(Ljava/lang/String;)V

    .line 64
    return-void
.end method
