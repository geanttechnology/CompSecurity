.class public Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;
.super Ljava/lang/Object;
.source "PeriodicMetricReporterImpl.java"

# interfaces
.implements Lcom/amazon/client/metrics/PeriodicMetricReporter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;
    }
.end annotation


# static fields
.field private static final SHUTDOWN_TIMEOUT_MS:J = 0x7d0L


# instance fields
.field protected final mAdditionalMetricEvents:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/MetricEvent;",
            ">;"
        }
    .end annotation
.end field

.field protected final mCommand:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;

.field protected final mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

.field protected final mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

.field protected final mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/MetricsFactory;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "factory"    # Lcom/amazon/client/metrics/MetricsFactory;
    .param p2, "program"    # Ljava/lang/String;
    .param p3, "source"    # Ljava/lang/String;

    .prologue
    .line 125
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;-><init>(Lcom/amazon/client/metrics/MetricsFactory;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    .line 126
    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/MetricsFactory;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V
    .locals 3
    .param p1, "factory"    # Lcom/amazon/client/metrics/MetricsFactory;
    .param p2, "program"    # Ljava/lang/String;
    .param p3, "source"    # Ljava/lang/String;
    .param p4, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    if-nez p1, :cond_0

    .line 86
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Argument: factory cannot be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 88
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_2

    .line 89
    :cond_1
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Argument: program cannot be null or empty."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 91
    :cond_2
    if-eqz p3, :cond_3

    invoke-virtual {p3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_4

    .line 92
    :cond_3
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Argument: source cannot be null or empty."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 95
    :cond_4
    iput-object p1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 96
    new-instance v1, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;

    invoke-direct {v1, p0}, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;-><init>(Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mCommand:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;

    .line 97
    new-instance v1, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$1;

    invoke-direct {v1, p0}, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$1;-><init>(Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;)V

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    .line 106
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mAdditionalMetricEvents:Ljava/util/List;

    .line 110
    const/4 v0, 0x1

    .line 111
    .local v0, "allowRunningTimers":Z
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const/4 v2, 0x1

    invoke-interface {v1, p2, p3, p4, v2}, Lcom/amazon/client/metrics/MetricsFactory;->createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 113
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->recordMetricEvent()V

    return-void
.end method

.method private recordMetricEvent()V
    .locals 4

    .prologue
    .line 204
    iget-object v2, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v3, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v2, v3}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 205
    iget-object v3, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mAdditionalMetricEvents:Ljava/util/List;

    monitor-enter v3

    .line 206
    :try_start_0
    iget-object v2, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mAdditionalMetricEvents:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/client/metrics/MetricEvent;

    .line 207
    .local v1, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    iget-object v2, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v2, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    goto :goto_0

    .line 209
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 210
    return-void
.end method


# virtual methods
.method public createTrackedMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 143
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->createTrackedMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method public createTrackedMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 3
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 149
    iget-object v2, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mAdditionalMetricEvents:Ljava/util/List;

    monitor-enter v2

    .line 150
    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v1, p1, p2, p3}, Lcom/amazon/client/metrics/MetricsFactory;->createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 152
    .local v0, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mAdditionalMetricEvents:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 153
    monitor-exit v2

    return-object v0

    .line 154
    .end local v0    # "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    return-object v0
.end method

.method public shutdown()V
    .locals 5

    .prologue
    .line 179
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mCommand:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;->shutdown()V

    .line 180
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v1}, Ljava/util/concurrent/ScheduledExecutorService;->shutdown()V

    .line 184
    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    const-wide/16 v2, 0x7d0

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 185
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v1}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    .line 187
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    const-wide/16 v2, 0x7d0

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-nez v1, :cond_0

    .line 195
    :cond_0
    :goto_0
    return-void

    .line 191
    :catch_0
    move-exception v0

    .line 193
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V

    goto :goto_0
.end method

.method public startRecordingPeriodically(JLjava/util/concurrent/TimeUnit;)V
    .locals 7
    .param p1, "period"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 132
    move-wide v2, p1

    .line 133
    .local v2, "initialDelay":J
    iget-object v0, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mCommand:Lcom/amazon/client/metrics/PeriodicMetricReporterImpl$PeriodicCommand;

    move-wide v4, p1

    move-object v6, p3

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 134
    return-void
.end method

.method public stopTrackingMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 2
    .param p1, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 159
    iget-object v1, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mAdditionalMetricEvents:Ljava/util/List;

    monitor-enter v1

    .line 160
    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mAdditionalMetricEvents:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 165
    monitor-exit v1

    .line 173
    :goto_0
    return-void

    .line 167
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 172
    iget-object v0, p0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    goto :goto_0

    .line 167
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
