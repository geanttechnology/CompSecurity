.class Lcom/amazon/device/ads/MetricsCollector;
.super Ljava/lang/Object;
.source "MetricsCollector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/MetricsCollector$MetricHitString;,
        Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;,
        Lcom/amazon/device/ads/MetricsCollector$MetricHitTotalTime;,
        Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;,
        Lcom/amazon/device/ads/MetricsCollector$MetricHitStartTime;,
        Lcom/amazon/device/ads/MetricsCollector$MetricHit;,
        Lcom/amazon/device/ads/MetricsCollector$CompositeMetricsCollector;
    }
.end annotation


# instance fields
.field private adTypeMetricTag:Ljava/lang/String;

.field protected metricHits:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/amazon/device/ads/MetricsCollector$MetricHit;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Ljava/util/Vector;

    const/16 v1, 0x3c

    invoke-direct {v0, v1}, Ljava/util/Vector;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->metricHits:Ljava/util/Vector;

    .line 28
    return-void
.end method


# virtual methods
.method public getAdTypeMetricTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->adTypeMetricTag:Ljava/lang/String;

    return-object v0
.end method

.method public getMetricHits()Ljava/util/Vector;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Vector",
            "<",
            "Lcom/amazon/device/ads/MetricsCollector$MetricHit;",
            ">;"
        }
    .end annotation

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->metricHits:Ljava/util/Vector;

    return-object v0
.end method

.method public incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V
    .locals 3
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->metricHits:Ljava/util/Vector;

    new-instance v1, Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;

    const/4 v2, 0x1

    invoke-direct {v1, p1, v2}, Lcom/amazon/device/ads/MetricsCollector$MetricHitIncrement;-><init>(Lcom/amazon/device/ads/Metrics$MetricType;I)V

    invoke-virtual {v0, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 42
    return-void
.end method

.method public isMetricsCollectorEmpty()Z
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->metricHits:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public publishMetricInMilliseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V
    .locals 2
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;
    .param p2, "value"    # J

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->metricHits:Ljava/util/Vector;

    new-instance v1, Lcom/amazon/device/ads/MetricsCollector$MetricHitTotalTime;

    invoke-direct {v1, p1, p2, p3}, Lcom/amazon/device/ads/MetricsCollector$MetricHitTotalTime;-><init>(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    invoke-virtual {v0, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 61
    return-void
.end method

.method public publishMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V
    .locals 0
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;
    .param p2, "value"    # J

    .prologue
    .line 64
    invoke-static {p2, p3}, Lcom/amazon/device/ads/Utils;->convertToMillisecondsFromNanoseconds(J)J

    move-result-wide p2

    .line 65
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/device/ads/MetricsCollector;->publishMetricInMilliseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 66
    return-void
.end method

.method public setAdType(Lcom/amazon/device/ads/AdProperties$AdType;)V
    .locals 1
    .param p1, "adType"    # Lcom/amazon/device/ads/AdProperties$AdType;

    .prologue
    .line 89
    invoke-virtual {p1}, Lcom/amazon/device/ads/AdProperties$AdType;->getAdTypeMetricTag()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->adTypeMetricTag:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setMetricString(Lcom/amazon/device/ads/Metrics$MetricType;Ljava/lang/String;)V
    .locals 2
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;
    .param p2, "s"    # Ljava/lang/String;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->metricHits:Ljava/util/Vector;

    new-instance v1, Lcom/amazon/device/ads/MetricsCollector$MetricHitString;

    invoke-direct {v1, p1, p2}, Lcom/amazon/device/ads/MetricsCollector$MetricHitString;-><init>(Lcom/amazon/device/ads/Metrics$MetricType;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 51
    return-void
.end method

.method public startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V
    .locals 2
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;

    .prologue
    .line 75
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 76
    return-void
.end method

.method public startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V
    .locals 2
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;
    .param p2, "startTime"    # J

    .prologue
    .line 70
    invoke-static {p2, p3}, Lcom/amazon/device/ads/Utils;->convertToMillisecondsFromNanoseconds(J)J

    move-result-wide p2

    .line 71
    iget-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->metricHits:Ljava/util/Vector;

    new-instance v1, Lcom/amazon/device/ads/MetricsCollector$MetricHitStartTime;

    invoke-direct {v1, p1, p2, p3}, Lcom/amazon/device/ads/MetricsCollector$MetricHitStartTime;-><init>(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    invoke-virtual {v0, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 72
    return-void
.end method

.method public stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V
    .locals 2
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;

    .prologue
    .line 84
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 85
    return-void
.end method

.method public stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V
    .locals 2
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;
    .param p2, "stopTime"    # J

    .prologue
    .line 79
    invoke-static {p2, p3}, Lcom/amazon/device/ads/Utils;->convertToMillisecondsFromNanoseconds(J)J

    move-result-wide p2

    .line 80
    iget-object v0, p0, Lcom/amazon/device/ads/MetricsCollector;->metricHits:Ljava/util/Vector;

    new-instance v1, Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;

    invoke-direct {v1, p1, p2, p3}, Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;-><init>(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    invoke-virtual {v0, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 81
    return-void
.end method
