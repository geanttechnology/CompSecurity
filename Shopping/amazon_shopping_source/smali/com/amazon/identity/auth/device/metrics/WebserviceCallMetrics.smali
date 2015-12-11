.class public final Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;
.super Ljava/lang/Object;
.source "WebserviceCallMetrics.java"


# static fields
.field public static final NETWORK_NOT_AVAILABLE:Ljava/lang/String; = "NetworkNotAvailable"

.field private static sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

.field private static sContext:Landroid/content/Context;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    return-void
.end method

.method private static declared-synchronized doInit()V
    .locals 2

    .prologue
    .line 91
    const-class v1, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->sContext:Landroid/content/Context;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    .line 97
    :cond_0
    :goto_0
    monitor-exit v1

    return-void

    .line 96
    :cond_1
    :try_start_1
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->sContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->getMetricsCollectorInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 91
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 3
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->doInit()V

    .line 42
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "WebserviceCallTime"

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method

.method private static varargs incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 2
    .param p0, "metricName"    # Ljava/lang/String;
    .param p1, "extras"    # [Ljava/lang/String;

    .prologue
    .line 101
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    if-nez v0, :cond_0

    .line 107
    :goto_0
    return-void

    .line 106
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "GenericMetrics_WebserviceCall"

    invoke-interface {v0, v1, p0, p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static init(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->sContext:Landroid/content/Context;

    .line 36
    return-void
.end method

.method public static reportAllRetriesFailed(Ljava/lang/String;)V
    .locals 5
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->doInit()V

    .line 70
    const-string/jumbo v0, "Retries"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "AllRetriesFailed:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 71
    return-void
.end method

.method public static reportIOException(Ljava/lang/String;Ljava/io/IOException;)V
    .locals 5
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "e"    # Ljava/io/IOException;

    .prologue
    .line 82
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->doInit()V

    .line 84
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":IOException"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 85
    .local v0, "allIOExceptions":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 86
    .local v1, "specificIOException":Ljava/lang/String;
    const-string/jumbo v2, "IOException"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v4, 0x1

    aput-object v1, v3, v4

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 87
    return-void
.end method

.method public static reportNetworkFailure(Ljava/lang/String;)V
    .locals 4
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 54
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->doInit()V

    .line 56
    const-string/jumbo v0, "NetworkFailure"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 57
    return-void
.end method

.method public static reportNetworkNotAvailableFailure(Ljava/lang/String;)V
    .locals 5
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->doInit()V

    .line 49
    const-string/jumbo v0, "NetworkNotAvailable"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "NetworkNotAvailable"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 50
    return-void
.end method

.method public static reportServerError(Ljava/lang/String;I)V
    .locals 5
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "responseCode"    # I

    .prologue
    .line 61
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->doInit()V

    .line 63
    const-string/jumbo v0, "ServerError"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 64
    return-void
.end method

.method public static reportSuccessAfterRetry(Ljava/lang/String;)V
    .locals 5
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 75
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->doInit()V

    .line 77
    const-string/jumbo v0, "Retries"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "SuccessAfterRetry:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 78
    return-void
.end method
