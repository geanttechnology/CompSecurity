.class Lcom/amazon/device/ads/InterstitialAd$2;
.super Ljava/lang/Object;
.source "InterstitialAd.java"

# interfaces
.implements Lcom/amazon/device/ads/AdView;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/InterstitialAd;->constructMraidView(Landroid/webkit/WebView;)Lcom/amazon/device/ads/MraidView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/InterstitialAd;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAd;)V
    .locals 0

    .prologue
    .line 431
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd$2;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getHeight()I
    .locals 1

    .prologue
    .line 457
    const/4 v0, 0x0

    return v0
.end method

.method public getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;
    .locals 1

    .prologue
    .line 463
    const/4 v0, 0x0

    return-object v0
.end method

.method public isAdViewRenderable()Z
    .locals 1

    .prologue
    .line 435
    const/4 v0, 0x1

    return v0
.end method

.method public launchExternalBrowserForLink(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 451
    const/4 v0, 0x0

    return v0
.end method

.method public onPageFinished()V
    .locals 4

    .prologue
    .line 441
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    .line 442
    .local v0, "renderStopTime":J
    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd$2;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v2}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 443
    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd$2;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v2}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 444
    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd$2;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v2}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_SUCCESS:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 445
    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd$2;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v2}, Lcom/amazon/device/ads/InterstitialAd;->onAdPrerendered()V

    .line 446
    return-void
.end method

.method public shouldDisableWebViewHardwareAcceleration()Z
    .locals 1

    .prologue
    .line 469
    const/4 v0, 0x0

    return v0
.end method
