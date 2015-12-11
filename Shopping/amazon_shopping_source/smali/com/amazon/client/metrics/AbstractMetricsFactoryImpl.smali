.class public abstract Lcom/amazon/client/metrics/AbstractMetricsFactoryImpl;
.super Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;
.source "AbstractMetricsFactoryImpl.java"


# static fields
.field private static final DEFAULT_ALLOW_RUNNING_TIMERS:Z = false

.field private static final TAG:Ljava/lang/String; = "AbstractMetricsFactoryImpl"

.field protected static sMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

.field protected static sMetricsService:Lcom/amazon/client/metrics/IMetricsService;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/amazon/client/metrics/BaseMetricsFactoryImpl;-><init>()V

    return-void
.end method

.method public static getSystemServiceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    const-string/jumbo v0, "com.amazon.dp.metrics.MetricsFactory"

    return-object v0
.end method

.method public static setInstance(Lcom/amazon/client/metrics/MetricsFactory;)V
    .locals 0
    .param p0, "metricsFactory"    # Lcom/amazon/client/metrics/MetricsFactory;

    .prologue
    .line 72
    sput-object p0, Lcom/amazon/client/metrics/AbstractMetricsFactoryImpl;->sMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 73
    return-void
.end method

.method public static declared-synchronized setService(Lcom/amazon/client/metrics/IMetricsService;)V
    .locals 2
    .param p0, "metricsService"    # Lcom/amazon/client/metrics/IMetricsService;

    .prologue
    .line 76
    const-class v0, Lcom/amazon/client/metrics/AbstractMetricsFactoryImpl;

    monitor-enter v0

    :try_start_0
    sput-object p0, Lcom/amazon/client/metrics/AbstractMetricsFactoryImpl;->sMetricsService:Lcom/amazon/client/metrics/IMetricsService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 77
    monitor-exit v0

    return-void

    .line 76
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method


# virtual methods
.method protected abstract getService()Lcom/amazon/client/metrics/IMetricsService;
.end method

.method public record(Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/client/metrics/Priority;)V
    .locals 9
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p2, "priority"    # Lcom/amazon/client/metrics/Priority;

    .prologue
    .line 93
    if-nez p1, :cond_0

    .line 94
    const-string/jumbo v0, "AbstractMetricsFactoryImpl"

    const-string/jumbo v1, "record : Null metric event"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    :goto_0
    return-void

    .line 98
    :cond_0
    invoke-interface {p1}, Lcom/amazon/client/metrics/MetricEvent;->hasDataPoints()Z

    move-result v0

    if-nez v0, :cond_1

    .line 99
    const-string/jumbo v0, "AbstractMetricsFactoryImpl"

    const-string/jumbo v1, "record : No data points in metrics event"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 107
    :cond_1
    instance-of v0, p1, Lcom/amazon/client/metrics/ConcurrentMetricEvent;

    if-eqz v0, :cond_3

    move-object v0, p1

    .line 108
    check-cast v0, Lcom/amazon/client/metrics/ConcurrentMetricEvent;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/ConcurrentMetricEvent;->getAsDataPointsAndClear()Ljava/util/List;

    move-result-object v7

    .line 114
    .local v7, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    :goto_1
    if-eqz v7, :cond_2

    invoke-interface {v7}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 115
    :cond_2
    const-string/jumbo v0, "AbstractMetricsFactoryImpl"

    const-string/jumbo v1, "record : No valid data points in metrics event"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 110
    .end local v7    # "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    :cond_3
    invoke-interface {p1}, Lcom/amazon/client/metrics/MetricEvent;->getAsDataPoints()Ljava/util/List;

    move-result-object v7

    .line 111
    .restart local v7    # "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    invoke-interface {p1}, Lcom/amazon/client/metrics/MetricEvent;->clear()V

    goto :goto_1

    .line 122
    :cond_4
    :try_start_0
    invoke-static {v7}, Lcom/amazon/client/metrics/DataPointEnvelope;->convertToEnvelopes(Ljava/util/List;)Ljava/util/List;

    move-result-object v6

    .line 125
    .local v6, "datapointEnvelopes":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPointEnvelope;>;"
    invoke-virtual {p0}, Lcom/amazon/client/metrics/AbstractMetricsFactoryImpl;->getService()Lcom/amazon/client/metrics/IMetricsService;

    move-result-object v0

    invoke-virtual {p2}, Lcom/amazon/client/metrics/Priority;->ordinal()I

    move-result v1

    invoke-interface {p1}, Lcom/amazon/client/metrics/MetricEvent;->getProgram()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/amazon/client/metrics/MetricEvent;->getSource()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/client/metrics/IMetricsService;->record(ILjava/lang/String;Ljava/lang/String;JLjava/util/List;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 128
    .end local v6    # "datapointEnvelopes":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPointEnvelope;>;"
    :catch_0
    move-exception v8

    .line 129
    .local v8, "e":Ljava/lang/SecurityException;
    const-string/jumbo v0, "AbstractMetricsFactoryImpl"

    const-string/jumbo v1, "record : SecurityException caught while trying to record metric: "

    invoke-static {v0, v1, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 131
    .end local v8    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v8

    .line 133
    .local v8, "e":Landroid/os/RemoteException;
    const-string/jumbo v0, "AbstractMetricsFactoryImpl"

    const-string/jumbo v1, "record : RemoteException caught while trying to record metric: "

    invoke-static {v0, v1, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
