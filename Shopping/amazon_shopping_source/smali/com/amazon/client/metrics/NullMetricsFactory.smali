.class public Lcom/amazon/client/metrics/NullMetricsFactory;
.super Ljava/lang/Object;
.source "NullMetricsFactory.java"

# interfaces
.implements Lcom/amazon/client/metrics/MetricsFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 70
    new-instance v0, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;

    invoke-direct {v0, p1, p2}, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 76
    new-instance v0, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    return-object v0
.end method

.method public createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 83
    new-instance v0, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    return-object v0
.end method

.method public createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 25
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    invoke-direct {v0, p1, p2}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 31
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    return-object v0
.end method

.method public createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 37
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    return-object v0
.end method

.method public createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 42
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    invoke-direct {v0, p1, p2}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public createMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 48
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    return-object v0
.end method

.method public createMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 54
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    return-object v0
.end method

.method public getSessionID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    const-string/jumbo v0, ""

    return-object v0
.end method

.method public record(Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 0
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 60
    return-void
.end method

.method public record(Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/client/metrics/Priority;)V
    .locals 0
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p2, "priority"    # Lcom/amazon/client/metrics/Priority;

    .prologue
    .line 65
    return-void
.end method
