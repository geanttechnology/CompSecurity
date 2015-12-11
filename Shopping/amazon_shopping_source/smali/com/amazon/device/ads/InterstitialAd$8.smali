.class Lcom/amazon/device/ads/InterstitialAd$8;
.super Ljava/lang/Object;
.source "InterstitialAd.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/InterstitialAd;->submitAndResetMetricsOnMainThreadAndStartMetric(Lcom/amazon/device/ads/Metrics$MetricType;J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/InterstitialAd;

.field final synthetic val$metricType:Lcom/amazon/device/ads/Metrics$MetricType;

.field final synthetic val$startTime:J


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/Metrics$MetricType;J)V
    .locals 0

    .prologue
    .line 718
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd$8;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    iput-object p2, p0, Lcom/amazon/device/ads/InterstitialAd$8;->val$metricType:Lcom/amazon/device/ads/Metrics$MetricType;

    iput-wide p3, p0, Lcom/amazon/device/ads/InterstitialAd$8;->val$startTime:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 722
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$8;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->submitAndResetMetrics()V

    .line 723
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$8;->val$metricType:Lcom/amazon/device/ads/Metrics$MetricType;

    if-eqz v0, :cond_0

    .line 725
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$8;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd$8;->val$metricType:Lcom/amazon/device/ads/Metrics$MetricType;

    iget-wide v2, p0, Lcom/amazon/device/ads/InterstitialAd$8;->val$startTime:J

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 727
    :cond_0
    return-void
.end method
