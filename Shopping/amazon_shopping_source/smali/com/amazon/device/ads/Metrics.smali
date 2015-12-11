.class Lcom/amazon/device/ads/Metrics;
.super Ljava/lang/Object;
.source "Metrics.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/Metrics$2;,
        Lcom/amazon/device/ads/Metrics$MetricType;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static instance:Lcom/amazon/device/ads/Metrics;


# instance fields
.field private metricsCollector:Lcom/amazon/device/ads/MetricsCollector;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/device/ads/Metrics;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/Metrics;->LOG_TAG:Ljava/lang/String;

    .line 18
    new-instance v0, Lcom/amazon/device/ads/Metrics;

    invoke-direct {v0}, Lcom/amazon/device/ads/Metrics;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/Metrics;->instance:Lcom/amazon/device/ads/Metrics;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 168
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 169
    new-instance v0, Lcom/amazon/device/ads/MetricsCollector;

    invoke-direct {v0}, Lcom/amazon/device/ads/MetricsCollector;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/Metrics;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    .line 170
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/amazon/device/ads/Metrics;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static getInstance()Lcom/amazon/device/ads/Metrics;
    .locals 1

    .prologue
    .line 178
    sget-object v0, Lcom/amazon/device/ads/Metrics;->instance:Lcom/amazon/device/ads/Metrics;

    return-object v0
.end method

.method protected static reset()V
    .locals 1

    .prologue
    .line 190
    new-instance v0, Lcom/amazon/device/ads/Metrics;

    invoke-direct {v0}, Lcom/amazon/device/ads/Metrics;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/Metrics;->instance:Lcom/amazon/device/ads/Metrics;

    .line 191
    return-void
.end method

.method private sendMetrics(Lcom/amazon/device/ads/WebRequest;)V
    .locals 1
    .param p1, "webRequest"    # Lcom/amazon/device/ads/WebRequest;

    .prologue
    .line 225
    new-instance v0, Lcom/amazon/device/ads/Metrics$1;

    invoke-direct {v0, p0, p1}, Lcom/amazon/device/ads/Metrics$1;-><init>(Lcom/amazon/device/ads/Metrics;Lcom/amazon/device/ads/WebRequest;)V

    invoke-static {v0}, Lcom/amazon/device/ads/ThreadUtils;->executeRunnable(Ljava/lang/Runnable;)V

    .line 260
    return-void
.end method

.method protected static setInstance(Lcom/amazon/device/ads/Metrics;)V
    .locals 0
    .param p0, "metrics"    # Lcom/amazon/device/ads/Metrics;

    .prologue
    .line 186
    sput-object p0, Lcom/amazon/device/ads/Metrics;->instance:Lcom/amazon/device/ads/Metrics;

    .line 187
    return-void
.end method


# virtual methods
.method public getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/amazon/device/ads/Metrics;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    return-object v0
.end method

.method public submitAndResetMetrics(Lcom/amazon/device/ads/AdData;)V
    .locals 4
    .param p1, "ad"    # Lcom/amazon/device/ads/AdData;

    .prologue
    .line 205
    new-instance v0, Lcom/amazon/device/ads/AdMetrics;

    invoke-direct {v0, p1}, Lcom/amazon/device/ads/AdMetrics;-><init>(Lcom/amazon/device/ads/AdData;)V

    .line 206
    .local v0, "adMetrics":Lcom/amazon/device/ads/AdMetrics;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdMetrics;->canSubmit()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 208
    iget-object v1, p0, Lcom/amazon/device/ads/Metrics;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    .line 209
    .local v1, "metricsCollector":Lcom/amazon/device/ads/MetricsCollector;
    new-instance v3, Lcom/amazon/device/ads/MetricsCollector;

    invoke-direct {v3}, Lcom/amazon/device/ads/MetricsCollector;-><init>()V

    iput-object v3, p0, Lcom/amazon/device/ads/Metrics;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    .line 210
    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/AdMetrics;->addGlobalMetrics(Lcom/amazon/device/ads/MetricsCollector;)V

    .line 212
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdMetrics;->getAaxWebRequestAndResetAdMetrics()Lcom/amazon/device/ads/WebRequest;

    move-result-object v2

    .line 213
    .local v2, "request":Lcom/amazon/device/ads/WebRequest;
    invoke-direct {p0, v2}, Lcom/amazon/device/ads/Metrics;->sendMetrics(Lcom/amazon/device/ads/WebRequest;)V

    .line 221
    .end local v1    # "metricsCollector":Lcom/amazon/device/ads/MetricsCollector;
    .end local v2    # "request":Lcom/amazon/device/ads/WebRequest;
    :goto_0
    return-void

    .line 219
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/device/ads/AdData;->resetMetricsCollector()V

    goto :goto_0
.end method
