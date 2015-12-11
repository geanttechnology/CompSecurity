.class public Lcom/amazon/mShop/net/RefMarkerObserver;
.super Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
.source "RefMarkerObserver.java"


# static fields
.field static final METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;


# instance fields
.field private mRefMarker:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 555
    new-instance v0, Lcom/amazon/mShop/net/RefMarkerObserver$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/RefMarkerObserver$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/RefMarkerObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 5
    .param p1, "featureImpression"    # Ljava/lang/String;

    .prologue
    .line 451
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;-><init>()V

    .line 455
    const-string/jumbo v3, ":"

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 456
    .local v2, "results":[Ljava/lang/String;
    array-length v3, v2

    const/4 v4, 0x1

    if-le v3, v4, :cond_0

    .line 457
    iput-object p1, p0, Lcom/amazon/mShop/net/RefMarkerObserver;->mRefMarker:Ljava/lang/String;

    .line 463
    :goto_0
    return-void

    .line 459
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 460
    .local v0, "context":Landroid/content/Context;
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_refmarker_platform_specific_prefix:I

    invoke-static {v0, v3}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForApp(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    .line 461
    .local v1, "platformAndAppName":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "msh_:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/net/RefMarkerObserver;->mRefMarker:Ljava/lang/String;

    goto :goto_0
.end method

.method public static logRefMarker(Ljava/lang/String;)V
    .locals 2
    .param p0, "featureImpression"    # Ljava/lang/String;

    .prologue
    .line 470
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$bool;->config_postRefMarker:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabledForApp(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 472
    new-instance v0, Lcom/amazon/mShop/net/RefMarkerObserver;

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/RefMarkerObserver;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/amazon/mShop/net/MetricsCollector;->queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V

    .line 474
    :cond_0
    return-void
.end method


# virtual methods
.method public getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 1

    .prologue
    .line 444
    sget-object v0, Lcom/amazon/mShop/net/RefMarkerObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-object v0
.end method

.method public getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 439
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->RefMarkerMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method

.method public getRefMarker()Ljava/lang/String;
    .locals 1

    .prologue
    .line 448
    iget-object v0, p0, Lcom/amazon/mShop/net/RefMarkerObserver;->mRefMarker:Ljava/lang/String;

    return-object v0
.end method
