.class public abstract Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;
.super Ljava/lang/Object;
.source "BaseMetricsFactoryImpl.java"

# interfaces
.implements Lcom/amazon/client/metrics/MetricsFactory;


# static fields
.field private static final DEFAULT_ALLOW_RUNNING_TIMERS:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
    .locals 2
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 81
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;

    move-result-object v0

    return-object v0
.end method

.method public createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 88
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;

    move-result-object v0

    return-object v0
.end method

.method public createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 95
    invoke-virtual {p0}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->shouldRecordMetrics()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 96
    new-instance v0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V

    .line 98
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    goto :goto_0
.end method

.method public createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 2
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method public createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method public createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 66
    invoke-virtual {p0}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->shouldRecordMetrics()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    new-instance v0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/amazon/client/metrics/ConcurrentMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V

    .line 69
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    goto :goto_0
.end method

.method public createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 2
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method public createMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 37
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method public createMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 43
    invoke-virtual {p0}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->shouldRecordMetrics()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 44
    new-instance v0, Lcom/amazon/client/metrics/BasicMetricEvent;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/amazon/client/metrics/BasicMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V

    .line 46
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    goto :goto_0
.end method

.method public record(Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 1
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 75
    sget-object v0, Lcom/amazon/client/metrics/Priority;->NORMAL:Lcom/amazon/client/metrics/Priority;

    invoke-virtual {p0, p1, v0}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;->record(Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/client/metrics/Priority;)V

    .line 76
    return-void
.end method

.method protected abstract shouldRecordMetrics()Z
.end method
