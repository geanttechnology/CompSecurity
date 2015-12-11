.class Lcom/amazon/device/ads/AdController;
.super Ljava/lang/Object;
.source "AdController.java"

# interfaces
.implements Lcom/amazon/device/ads/IAdController;
.implements Lcom/amazon/device/ads/IAdLoaderCallback;


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "AdController"


# instance fields
.field private adData:Lcom/amazon/device/ads/AdData;

.field private final adLayout:Lcom/amazon/device/ads/AdLayout;

.field private adListener:Lcom/amazon/device/ads/AdListener;

.field private final adSize:Lcom/amazon/device/ads/AdSize;

.field private adWindowHeight:I

.field private adWindowWidth:I

.field private final context:Landroid/content/Context;

.field private currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

.field private isLoading:Z

.field private timeout:I

.field private webView:Landroid/webkit/WebView;


# direct methods
.method protected constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 178
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 154
    const/16 v0, 0x4e20

    iput v0, p0, Lcom/amazon/device/ads/AdController;->timeout:I

    .line 179
    iput-object v1, p0, Lcom/amazon/device/ads/AdController;->adLayout:Lcom/amazon/device/ads/AdLayout;

    .line 180
    iput-object v1, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    .line 181
    iput-object v1, p0, Lcom/amazon/device/ads/AdController;->adSize:Lcom/amazon/device/ads/AdSize;

    .line 182
    return-void
.end method

.method constructor <init>(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)V
    .locals 1
    .param p1, "adLayout"    # Lcom/amazon/device/ads/AdLayout;
    .param p2, "adSize"    # Lcom/amazon/device/ads/AdSize;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 166
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 154
    const/16 v0, 0x4e20

    iput v0, p0, Lcom/amazon/device/ads/AdController;->timeout:I

    .line 167
    iput-object p1, p0, Lcom/amazon/device/ads/AdController;->adLayout:Lcom/amazon/device/ads/AdLayout;

    .line 168
    iput-object p3, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    .line 169
    iput-object p2, p0, Lcom/amazon/device/ads/AdController;->adSize:Lcom/amazon/device/ads/AdSize;

    .line 171
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->createAdListener()Lcom/amazon/device/ads/AdListener;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AdController;->adListener:Lcom/amazon/device/ads/AdListener;

    .line 172
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/AdController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/AdController;

    .prologue
    .line 144
    invoke-direct {p0}, Lcom/amazon/device/ads/AdController;->retrieveAndSetUserAgentString()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/device/ads/AdController;)Lcom/amazon/device/ads/AdLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdController;

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->adLayout:Lcom/amazon/device/ads/AdLayout;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/device/ads/AdController;)Lcom/amazon/device/ads/AdListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdController;

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->adListener:Lcom/amazon/device/ads/AdListener;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/device/ads/AdController;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/AdController;
    .param p1, "x1"    # Z

    .prologue
    .line 144
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/AdController;->submitAndResetMetricsIfNecessary(Z)V

    return-void
.end method

.method private createAndCacheWebView()V
    .locals 2

    .prologue
    .line 489
    invoke-static {}, Lcom/amazon/device/ads/WebViewFactory;->getInstance()Lcom/amazon/device/ads/WebViewFactory;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebViewFactory;->createWebView(Landroid/content/Context;)Landroid/webkit/WebView;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AdController;->webView:Landroid/webkit/WebView;

    .line 490
    return-void
.end method

.method private destroyCurrentAdRenderer()V
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    if-eqz v0, :cond_0

    .line 327
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdRenderer;->removeView()V

    .line 328
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdRenderer;->destroy()V

    .line 329
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    .line 331
    :cond_0
    return-void
.end method

.method protected static getAsSizeString(II)Ljava/lang/String;
    .locals 2
    .param p0, "w"    # I
    .param p1, "h"    # I

    .prologue
    .line 283
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private prepareRenderer(Lcom/amazon/device/ads/AdData$AAXCreative;)V
    .locals 6
    .param p1, "creativeType"    # Lcom/amazon/device/ads/AdData$AAXCreative;

    .prologue
    .line 426
    iget-object v3, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {p0, p1, v3}, Lcom/amazon/device/ads/AdController;->createAdRendererFromFactory(Lcom/amazon/device/ads/AdData$AAXCreative;Lcom/amazon/device/ads/AdRenderer;)Lcom/amazon/device/ads/AdRenderer;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    .line 428
    iget-object v3, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    if-nez v3, :cond_1

    .line 430
    const-string/jumbo v0, "No renderer returned, not loading an ad"

    .line 431
    .local v0, "msg":Ljava/lang/String;
    const-string/jumbo v3, "AdController"

    const-string/jumbo v4, "No renderer returned, not loading an ad"

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 432
    new-instance v3, Lcom/amazon/device/ads/AdError;

    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v5, "No renderer returned, not loading an ad"

    invoke-direct {v3, v4, v5}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/AdController;->adFailed(Lcom/amazon/device/ads/AdError;)V

    .line 454
    .end local v0    # "msg":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 436
    :cond_1
    iget-object v3, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdRenderer;->initialize()V

    .line 437
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/amazon/device/ads/AdData;->setIsRendering(Z)V

    .line 438
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v1

    .line 439
    .local v1, "renderLatencyStartTime":J
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 440
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 441
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 442
    iget-object v3, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdRenderer;->render()Z

    move-result v3

    if-nez v3, :cond_0

    .line 445
    invoke-direct {p0}, Lcom/amazon/device/ads/AdController;->destroyCurrentAdRenderer()V

    .line 447
    const-string/jumbo v0, "Ad could not render"

    .line 448
    .restart local v0    # "msg":Ljava/lang/String;
    const-string/jumbo v3, "AdController"

    const-string/jumbo v4, "Ad could not render"

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 451
    new-instance v3, Lcom/amazon/device/ads/AdError;

    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v5, "Ad could not render"

    invoke-direct {v3, v4, v5}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/AdController;->adFailed(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0
.end method

.method private processAdFailure()V
    .locals 1

    .prologue
    .line 575
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->webView:Landroid/webkit/WebView;

    if-eqz v0, :cond_0

    .line 577
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 578
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/ads/AdController;->webView:Landroid/webkit/WebView;

    .line 580
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdController;->isLoading:Z

    .line 581
    return-void
.end method

.method private retrieveAndSetUserAgentString()V
    .locals 2

    .prologue
    .line 391
    invoke-direct {p0}, Lcom/amazon/device/ads/AdController;->createAndCacheWebView()V

    .line 392
    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->webView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v0

    .line 393
    .local v0, "userAgent":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/device/ads/DeviceInfo;->setUserAgentString(Ljava/lang/String;)V

    .line 394
    return-void
.end method

.method private submitAndResetMetricsIfNecessary(Z)V
    .locals 2
    .param p1, "shouldSubmitMetrics"    # Z

    .prologue
    .line 695
    if-eqz p1, :cond_0

    .line 697
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/Metrics;->submitAndResetMetrics(Lcom/amazon/device/ads/AdData;)V

    .line 699
    :cond_0
    return-void
.end method


# virtual methods
.method protected accumulateAdFailureMetrics(Lcom/amazon/device/ads/AdError;)V
    .locals 4
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 589
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    .line 590
    .local v0, "renderStopTime":J
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 594
    invoke-virtual {p1}, Lcom/amazon/device/ads/AdError;->getCode()Lcom/amazon/device/ads/AdError$ErrorCode;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->NO_FILL:Lcom/amazon/device/ads/AdError$ErrorCode;

    if-eq v2, v3, :cond_0

    .line 596
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 599
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getIsRendering()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 601
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_RENDERING_FATAL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 602
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/AdData;->setIsRendering(Z)V

    .line 605
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 606
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 607
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 608
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->setAdditionalMetrics()V

    .line 609
    return-void
.end method

.method public adClosedExpansion()V
    .locals 2

    .prologue
    .line 645
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 646
    .local v0, "h":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/AdController$5;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/AdController$5;-><init>(Lcom/amazon/device/ads/AdController;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 654
    return-void
.end method

.method public adExpanded()V
    .locals 2

    .prologue
    .line 632
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 633
    .local v0, "h":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/AdController$4;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/AdController$4;-><init>(Lcom/amazon/device/ads/AdController;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 641
    return-void
.end method

.method public adFailed(Lcom/amazon/device/ads/AdError;)V
    .locals 1
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 536
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MetricsCollector;->isMetricsCollectorEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 538
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdController;->adFailedBeforeAdMetricsStart(Lcom/amazon/device/ads/AdError;)V

    .line 544
    :goto_0
    return-void

    .line 542
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdController;->adFailedAfterAdMetricsStart(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0
.end method

.method protected adFailedAfterAdMetricsStart(Lcom/amazon/device/ads/AdError;)V
    .locals 1
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 565
    invoke-direct {p0}, Lcom/amazon/device/ads/AdController;->processAdFailure()V

    .line 566
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdController;->accumulateAdFailureMetrics(Lcom/amazon/device/ads/AdError;)V

    .line 567
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/amazon/device/ads/AdController;->callListenerOnAdFailedToLoad(Lcom/amazon/device/ads/AdError;Z)V

    .line 568
    return-void
.end method

.method protected adFailedBeforeAdMetricsStart(Lcom/amazon/device/ads/AdError;)V
    .locals 1
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 553
    invoke-direct {p0}, Lcom/amazon/device/ads/AdController;->processAdFailure()V

    .line 555
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/device/ads/AdController;->callListenerOnAdFailedToLoad(Lcom/amazon/device/ads/AdError;Z)V

    .line 556
    return-void
.end method

.method public adLoaded(Lcom/amazon/device/ads/AdProperties;)V
    .locals 6
    .param p1, "props"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    const/4 v5, 0x0

    .line 496
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v1

    .line 497
    .local v1, "renderStopTime":J
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->adShown()V

    .line 499
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 500
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_SUCCESS:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 501
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 503
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->setAdditionalMetrics()V

    .line 505
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/device/ads/AdData;->setIsRendering(Z)V

    .line 507
    iput-boolean v5, p0, Lcom/amazon/device/ads/AdController;->isLoading:Z

    .line 509
    new-instance v0, Landroid/os/Handler;

    iget-object v3, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v0, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 510
    .local v0, "h":Landroid/os/Handler;
    new-instance v3, Lcom/amazon/device/ads/AdController$2;

    invoke-direct {v3, p0, p1}, Lcom/amazon/device/ads/AdController$2;-><init>(Lcom/amazon/device/ads/AdController;Lcom/amazon/device/ads/AdProperties;)V

    invoke-virtual {v0, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 519
    return-void
.end method

.method public adShown()V
    .locals 1

    .prologue
    .line 527
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getImpressionPixelUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/ads/WebRequest;->executeWebRequestInThread(Ljava/lang/String;)V

    .line 528
    return-void
.end method

.method protected callListenerOnAdFailedToLoad(Lcom/amazon/device/ads/AdError;Z)V
    .locals 2
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;
    .param p2, "shouldSubmitMetrics"    # Z

    .prologue
    .line 618
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 619
    .local v0, "h":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/AdController$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/device/ads/AdController$3;-><init>(Lcom/amazon/device/ads/AdController;Lcom/amazon/device/ads/AdError;Z)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 628
    return-void
.end method

.method protected createAdListener()Lcom/amazon/device/ads/AdListener;
    .locals 2

    .prologue
    .line 187
    new-instance v0, Lcom/amazon/device/ads/DefaultAdListener;

    const-string/jumbo v1, "AdController"

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/DefaultAdListener;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method protected createAdRendererFromFactory(Lcom/amazon/device/ads/AdData$AAXCreative;Lcom/amazon/device/ads/AdRenderer;)Lcom/amazon/device/ads/AdRenderer;
    .locals 6
    .param p1, "creativeType"    # Lcom/amazon/device/ads/AdData$AAXCreative;
    .param p2, "adRenderer"    # Lcom/amazon/device/ads/AdRenderer;

    .prologue
    .line 458
    new-instance v0, Lcom/amazon/device/ads/AdRendererFactory;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdRendererFactory;-><init>()V

    .line 459
    .local v0, "adRendererFactory":Lcom/amazon/device/ads/AdRendererFactory;
    invoke-virtual {v0, p1, p2}, Lcom/amazon/device/ads/AdRendererFactory;->shouldCreateNewRenderer(Lcom/amazon/device/ads/AdData$AAXCreative;Lcom/amazon/device/ads/AdRenderer;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 461
    const-string/jumbo v1, "AdController"

    const-string/jumbo v2, "Creating new renderer"

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 463
    if-eqz p2, :cond_0

    .line 465
    invoke-virtual {p2}, Lcom/amazon/device/ads/AdRenderer;->destroy()V

    .line 468
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->webView:Landroid/webkit/WebView;

    if-nez v1, :cond_1

    .line 470
    invoke-direct {p0}, Lcom/amazon/device/ads/AdController;->createAndCacheWebView()V

    .line 473
    :cond_1
    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->adData:Lcom/amazon/device/ads/AdData;

    iget-object v4, p0, Lcom/amazon/device/ads/AdController;->webView:Landroid/webkit/WebView;

    iget-object v5, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    move-object v1, p1

    move-object v3, p0

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/device/ads/AdRendererFactory;->getAdRenderer(Lcom/amazon/device/ads/AdData$AAXCreative;Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdController;Landroid/webkit/WebView;Landroid/content/Context;)Lcom/amazon/device/ads/AdRenderer;

    move-result-object p2

    .line 474
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/device/ads/AdController;->webView:Landroid/webkit/WebView;

    .line 481
    :goto_0
    return-object p2

    .line 478
    :cond_2
    const-string/jumbo v1, "AdController"

    const-string/jumbo v2, "Re-using renderer"

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 479
    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {p2, v1}, Lcom/amazon/device/ads/AdRenderer;->setAd(Lcom/amazon/device/ads/AdData;)V

    goto :goto_0
.end method

.method public destroy()V
    .locals 0

    .prologue
    .line 320
    invoke-direct {p0}, Lcom/amazon/device/ads/AdController;->destroyCurrentAdRenderer()V

    .line 321
    return-void
.end method

.method protected getAdData()Lcom/amazon/device/ads/AdData;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->adData:Lcom/amazon/device/ads/AdData;

    return-object v0
.end method

.method public getAdLayout()Lcom/amazon/device/ads/AdLayout;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->adLayout:Lcom/amazon/device/ads/AdLayout;

    return-object v0
.end method

.method protected getAdListener()Lcom/amazon/device/ads/AdListener;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->adListener:Lcom/amazon/device/ads/AdListener;

    return-object v0
.end method

.method public getAdSize()Lcom/amazon/device/ads/AdSize;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->adSize:Lcom/amazon/device/ads/AdSize;

    return-object v0
.end method

.method protected getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 681
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    return-object v0
.end method

.method protected getCurrentAdRenderer()Lcom/amazon/device/ads/AdRenderer;
    .locals 1

    .prologue
    .line 686
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    return-object v0
.end method

.method public getMaxSize()Ljava/lang/String;
    .locals 2

    .prologue
    .line 266
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->adSize:Lcom/amazon/device/ads/AdSize;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdSize;->isAuto()Z

    move-result v0

    if-nez v0, :cond_0

    .line 268
    const/4 v0, 0x0

    .line 272
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getWindowWidth()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getWindowHeight()I

    move-result v1

    invoke-static {v0, v1}, Lcom/amazon/device/ads/AdController;->getAsSizeString(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;
    .locals 3

    .prologue
    .line 710
    new-instance v0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;

    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->context:Landroid/content/Context;

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;-><init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V

    return-object v0
.end method

.method public getTimeout()I
    .locals 1

    .prologue
    .line 221
    iget v0, p0, Lcom/amazon/device/ads/AdController;->timeout:I

    return v0
.end method

.method public getWindowHeight()I
    .locals 1

    .prologue
    .line 245
    iget v0, p0, Lcom/amazon/device/ads/AdController;->adWindowHeight:I

    return v0
.end method

.method public getWindowWidth()I
    .locals 1

    .prologue
    .line 250
    iget v0, p0, Lcom/amazon/device/ads/AdController;->adWindowWidth:I

    return v0
.end method

.method public handleResponse()V
    .locals 5

    .prologue
    .line 399
    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    if-eqz v2, :cond_0

    .line 401
    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdRenderer;->removeView()V

    .line 404
    :cond_0
    const/4 v0, 0x0

    .line 405
    .local v0, "creativeType":Lcom/amazon/device/ads/AdData$AAXCreative;
    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->adData:Lcom/amazon/device/ads/AdData;

    if-nez v2, :cond_1

    .line 407
    const-string/jumbo v1, "We are unable to load the ad due to an internal error."

    .line 408
    .local v1, "msg":Ljava/lang/String;
    const-string/jumbo v2, "AdController"

    const-string/jumbo v3, "We are unable to load the ad due to an internal error."

    invoke-static {v2, v3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 409
    new-instance v2, Lcom/amazon/device/ads/AdError;

    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v4, "We are unable to load the ad due to an internal error."

    invoke-direct {v2, v3, v4}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/AdController;->adFailed(Lcom/amazon/device/ads/AdError;)V

    .line 422
    .end local v1    # "msg":Ljava/lang/String;
    :goto_0
    return-void

    .line 411
    :cond_1
    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getCreativeTypes()Ljava/util/Set;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getCreativeTypes()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getCreativeTypes()Ljava/util/Set;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/device/ads/AdData$AAXCreative;->getTopCreative(Ljava/util/Set;)Lcom/amazon/device/ads/AdData$AAXCreative;

    move-result-object v0

    if-nez v0, :cond_3

    .line 414
    :cond_2
    const-string/jumbo v1, "There were no valid creative types returned, and we are unable to load the ad."

    .line 415
    .restart local v1    # "msg":Ljava/lang/String;
    const-string/jumbo v2, "AdController"

    const-string/jumbo v3, "There were no valid creative types returned, and we are unable to load the ad."

    invoke-static {v2, v3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 416
    new-instance v2, Lcom/amazon/device/ads/AdError;

    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v4, "There were no valid creative types returned, and we are unable to load the ad."

    invoke-direct {v2, v3, v4}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/AdController;->adFailed(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0

    .line 420
    .end local v1    # "msg":Ljava/lang/String;
    :cond_3
    invoke-direct {p0, v0}, Lcom/amazon/device/ads/AdController;->prepareRenderer(Lcom/amazon/device/ads/AdData$AAXCreative;)V

    goto :goto_0
.end method

.method public isAdExpanded()Z
    .locals 2

    .prologue
    .line 236
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    if-nez v0, :cond_0

    .line 238
    const/4 v0, 0x0

    .line 240
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    const-string/jumbo v1, "EXPANDED"

    invoke-static {v1}, Lcom/amazon/device/ads/AdRenderer$AdState;->valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/AdRenderer$AdState;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/AdRenderer;->getAdState(Lcom/amazon/device/ads/AdRenderer$AdState;)Z

    move-result v0

    goto :goto_0
.end method

.method public isAdLoading()Z
    .locals 1

    .prologue
    .line 211
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdController;->isLoading:Z

    return v0
.end method

.method public prepareAd(J)V
    .locals 4
    .param p1, "loadAdStartTime"    # J

    .prologue
    .line 335
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->setNewAdData()V

    .line 337
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, p1, p2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 338
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, p1, p2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 339
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_SUCCESS:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, p1, p2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 340
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, p1, p2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 343
    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->adSize:Lcom/amazon/device/ads/AdSize;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdSize;->isAuto()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 345
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getMaxSize()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/AdData;->setMaxSize(Ljava/lang/String;)V

    .line 348
    :cond_0
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/device/ads/AdController;->isLoading:Z

    .line 349
    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getUserAgentString()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    .line 351
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    .line 352
    .local v1, "looper":Landroid/os/Looper;
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v1}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v3

    if-ne v2, v3, :cond_2

    .line 354
    invoke-direct {p0}, Lcom/amazon/device/ads/AdController;->retrieveAndSetUserAgentString()V

    .line 374
    .end local v1    # "looper":Landroid/os/Looper;
    :cond_1
    :goto_0
    return-void

    .line 358
    .restart local v1    # "looper":Landroid/os/Looper;
    :cond_2
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 359
    .local v0, "handler":Landroid/os/Handler;
    new-instance v2, Lcom/amazon/device/ads/AdController$1;

    invoke-direct {v2, p0}, Lcom/amazon/device/ads/AdController$1;-><init>(Lcom/amazon/device/ads/AdController;)V

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public prepareToGoAway()V
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    if-eqz v0, :cond_0

    .line 302
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdRenderer;->prepareToGoAway()V

    .line 304
    :cond_0
    return-void
.end method

.method public sendCommand(Ljava/lang/String;Ljava/util/HashMap;)Z
    .locals 1
    .param p1, "command"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 308
    .local p2, "args":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    if-eqz v0, :cond_0

    .line 310
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/device/ads/AdRenderer;->sendCommand(Ljava/lang/String;Ljava/util/Map;)Z

    move-result v0

    .line 314
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected setAdData(Lcom/amazon/device/ads/AdData;)V
    .locals 0
    .param p1, "adData"    # Lcom/amazon/device/ads/AdData;

    .prologue
    .line 206
    iput-object p1, p0, Lcom/amazon/device/ads/AdController;->adData:Lcom/amazon/device/ads/AdData;

    .line 207
    return-void
.end method

.method protected setAdditionalMetrics()V
    .locals 3

    .prologue
    .line 661
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/ads/AdUtils;->setConnectionMetrics(Lcom/amazon/device/ads/AdData;)V

    .line 663
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 665
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_PARENT_VIEW_MISSING:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 668
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getWindowHeight()I

    move-result v0

    if-nez v0, :cond_1

    .line 670
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->ADLAYOUT_HEIGHT_ZERO:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 673
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    if-eqz v0, :cond_2

    .line 675
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->VIEWPORT_SCALE:Lcom/amazon/device/ads/Metrics$MetricType;

    iget-object v2, p0, Lcom/amazon/device/ads/AdController;->currentAdRenderer:Lcom/amazon/device/ads/AdRenderer;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdRenderer;->getScalingMultiplierDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->setMetricString(Lcom/amazon/device/ads/Metrics$MetricType;Ljava/lang/String;)V

    .line 677
    :cond_2
    return-void
.end method

.method public setListener(Lcom/amazon/device/ads/AdListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/AdListener;

    .prologue
    .line 288
    if-nez p1, :cond_0

    .line 290
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->createAdListener()Lcom/amazon/device/ads/AdListener;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AdController;->adListener:Lcom/amazon/device/ads/AdListener;

    .line 296
    :goto_0
    return-void

    .line 294
    :cond_0
    iput-object p1, p0, Lcom/amazon/device/ads/AdController;->adListener:Lcom/amazon/device/ads/AdListener;

    goto :goto_0
.end method

.method protected setNewAdData()V
    .locals 2

    .prologue
    .line 381
    new-instance v0, Lcom/amazon/device/ads/AdData;

    iget-object v1, p0, Lcom/amazon/device/ads/AdController;->adSize:Lcom/amazon/device/ads/AdSize;

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/AdData;-><init>(Lcom/amazon/device/ads/AdSize;)V

    .line 382
    .local v0, "adData":Lcom/amazon/device/ads/AdData;
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AdController;->setAdData(Lcom/amazon/device/ads/AdData;)V

    .line 383
    return-void
.end method

.method public setTimeout(I)V
    .locals 0
    .param p1, "timeout"    # I

    .prologue
    .line 226
    iput p1, p0, Lcom/amazon/device/ads/AdController;->timeout:I

    .line 227
    return-void
.end method

.method public setWindowDimensions(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 255
    iput p1, p0, Lcom/amazon/device/ads/AdController;->adWindowWidth:I

    .line 256
    iput p2, p0, Lcom/amazon/device/ads/AdController;->adWindowHeight:I

    .line 257
    return-void
.end method

.method public shouldDisableWebViewHardwareAcceleration()Z
    .locals 1

    .prologue
    .line 704
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdLayout;->shouldDisableWebViewHardwareAcceleration()Z

    move-result v0

    return v0
.end method
