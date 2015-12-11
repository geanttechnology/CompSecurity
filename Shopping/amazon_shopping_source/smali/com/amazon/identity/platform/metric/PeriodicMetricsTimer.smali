.class Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;
.super Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
.source "PeriodicMetricsTimer.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mDiscard:Z

.field private mEndTimeNanos:J

.field private final mPeriodicMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private mStartTimeNanos:J

.field private mTimerName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;)V
    .locals 2
    .param p1, "periodicMetricEvent"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p2, "timerName"    # Ljava/lang/String;

    .prologue
    const-wide/16 v0, -0x1

    .line 19
    invoke-direct {p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;-><init>()V

    .line 14
    iput-wide v0, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mStartTimeNanos:J

    .line 15
    iput-wide v0, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mEndTimeNanos:J

    .line 16
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mDiscard:Z

    .line 20
    iput-object p1, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mPeriodicMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 21
    iput-object p2, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mTimerName:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public discard()V
    .locals 1

    .prologue
    .line 68
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mDiscard:Z

    .line 69
    return-void
.end method

.method public getTimerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mTimerName:Ljava/lang/String;

    return-object v0
.end method

.method public setTimerName(Ljava/lang/String;)V
    .locals 0
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mTimerName:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public start()V
    .locals 2

    .prologue
    .line 27
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mStartTimeNanos:J

    .line 28
    return-void
.end method

.method public stop()V
    .locals 8

    .prologue
    const-wide/16 v4, 0x0

    const-wide/16 v6, -0x1

    .line 33
    iget-object v2, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 35
    sget-object v2, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->TAG:Ljava/lang/String;

    .line 63
    :goto_0
    return-void

    .line 39
    :cond_0
    iget-boolean v2, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mDiscard:Z

    if-eqz v2, :cond_1

    .line 41
    sget-object v2, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Timer already discarded : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_0

    .line 45
    :cond_1
    iget-wide v2, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mStartTimeNanos:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_2

    .line 47
    sget-object v2, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Timer not started : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_0

    .line 52
    :cond_2
    iget-wide v2, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mEndTimeNanos:J

    cmp-long v2, v2, v4

    if-lez v2, :cond_3

    .line 54
    iget-wide v2, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mEndTimeNanos:J

    iget-wide v4, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mStartTimeNanos:J

    sub-long v0, v2, v4

    .line 60
    .local v0, "elapsedTimeNanos":J
    :goto_1
    iput-wide v6, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mStartTimeNanos:J

    .line 61
    iput-wide v6, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mEndTimeNanos:J

    .line 62
    iget-object v2, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mPeriodicMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    iget-object v3, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mTimerName:Ljava/lang/String;

    long-to-double v4, v0

    const-wide v6, 0x412e848000000000L    # 1000000.0

    div-double/2addr v4, v6

    invoke-interface {v2, v3, v4, v5}, Lcom/amazon/client/metrics/MetricEvent;->addTimer(Ljava/lang/String;D)V

    goto :goto_0

    .line 58
    .end local v0    # "elapsedTimeNanos":J
    :cond_3
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mStartTimeNanos:J

    sub-long v0, v2, v4

    .restart local v0    # "elapsedTimeNanos":J
    goto :goto_1
.end method

.method public stopAndDiscard()V
    .locals 0

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->stop()V

    .line 75
    invoke-virtual {p0}, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->discard()V

    .line 76
    return-void
.end method

.method public stopClock()V
    .locals 2

    .prologue
    .line 87
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/identity/platform/metric/PeriodicMetricsTimer;->mEndTimeNanos:J

    .line 88
    return-void
.end method
