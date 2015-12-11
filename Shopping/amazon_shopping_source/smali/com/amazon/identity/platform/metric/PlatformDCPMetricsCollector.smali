.class Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;
.super Ljava/lang/Object;
.source "PlatformDCPMetricsCollector.java"

# interfaces
.implements Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private final mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    invoke-static {p1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 30
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 31
    .local v0, "program":Ljava/lang/String;
    const-string/jumbo v1, "MAPClientLib"

    .line 32
    .local v1, "source":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v2, v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 33
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "apiName"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    invoke-static {p1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 39
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 40
    .local v0, "program":Ljava/lang/String;
    move-object v1, p2

    .line 41
    .local v1, "source":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v2, v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 42
    return-void
.end method

.method private convertMetricIdentifierToEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "metricComponent"    # Ljava/lang/String;
    .param p2, "timerName"    # Ljava/lang/String;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v0, p1, p2}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public createPeriodicTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 103
    new-instance v0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;

    iget-object v1, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-direct {v0, v1, p1}, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;-><init>(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;)V

    return-object v0
.end method

.method public createTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 138
    new-instance v0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;

    iget-object v1, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-direct {v0, v1, p1}, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;-><init>(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;)V

    return-object v0
.end method

.method public varargs increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 9
    .param p1, "counter"    # Ljava/lang/String;
    .param p2, "extraCounters"    # [Ljava/lang/String;

    .prologue
    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    .line 113
    iget-object v4, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v4, p1, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 114
    move-object v0, p2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, p2

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 116
    .local v1, "extraCounter":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

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

    invoke-interface {v4, v5, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 114
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 118
    .end local v1    # "extraCounter":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public incrementCounter(Ljava/lang/String;)V
    .locals 3
    .param p1, "counter"    # Ljava/lang/String;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 124
    return-void
.end method

.method public incrementCounter(Ljava/lang/String;D)V
    .locals 5
    .param p1, "counter"    # Ljava/lang/String;
    .param p2, "count"    # D

    .prologue
    const-wide/high16 v3, 0x4024000000000000L    # 10.0

    .line 130
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    mul-double v1, p2, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->round(D)J

    move-result-wide v1

    long-to-double v1, v1

    div-double/2addr v1, v3

    invoke-interface {v0, p1, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 132
    return-void
.end method

.method public incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 6
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
    .line 63
    .local p3, "extraCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->convertMetricIdentifierToEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 64
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 66
    .local v1, "extraCounter":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    int-to-double v4, v4

    invoke-interface {v0, v3, v4, v5}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto :goto_0

    .line 69
    .end local v1    # "extraCounter":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Integer;>;"
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v3, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 70
    return-void
.end method

.method public varargs incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 7
    .param p1, "metricComponent"    # Ljava/lang/String;
    .param p2, "metricName"    # Ljava/lang/String;
    .param p3, "extraCounters"    # [Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->convertMetricIdentifierToEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v1

    .line 50
    .local v1, "event":Lcom/amazon/client/metrics/MetricEvent;
    move-object v0, p3

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, p3

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v2, v0, v3

    .line 52
    .local v2, "extraCounter":Ljava/lang/String;
    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    invoke-interface {v1, v2, v5, v6}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 50
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 55
    .end local v2    # "extraCounter":Ljava/lang/String;
    :cond_0
    iget-object v5, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v5, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 56
    return-void
.end method

.method public incrementStateMetricCounter(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 5
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
    .line 77
    .local p3, "extraCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->convertMetricIdentifierToEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 78
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 80
    .local v1, "extraCounter":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v0, v3, v4}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 83
    .end local v1    # "extraCounter":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v3, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 84
    return-void
.end method

.method public recordEvent()V
    .locals 2

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 145
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0}, Lcom/amazon/client/metrics/MetricEvent;->clear()V

    .line 146
    return-void
.end method

.method public recordMetricTimerEvent(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 3
    .param p1, "metricComponent"    # Ljava/lang/String;
    .param p2, "timerName"    # Ljava/lang/String;
    .param p3, "elapsedTime"    # J

    .prologue
    .line 89
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->convertMetricIdentifierToEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 90
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    long-to-double v1, p3

    invoke-interface {v0, p2, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->addTimer(Ljava/lang/String;D)V

    .line 92
    iget-object v1, p0, Lcom/amazon/identity/platform/metric/PlatformDCPMetricsCollector;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v1, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 93
    return-void
.end method
