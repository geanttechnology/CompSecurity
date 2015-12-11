.class Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;
.super Lcom/amazon/device/ads/MetricsCollector$MetricHit;
.source "MetricsCollector.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MetricsCollector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MetricHitStopTime"
.end annotation


# instance fields
.field public final stopTime:J


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/Metrics$MetricType;J)V
    .locals 0
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;
    .param p2, "stopTime"    # J

    .prologue
    .line 225
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/MetricsCollector$MetricHit;-><init>(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 226
    iput-wide p2, p0, Lcom/amazon/device/ads/MetricsCollector$MetricHitStopTime;->stopTime:J

    .line 227
    return-void
.end method
