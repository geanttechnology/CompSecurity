.class final Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;
.super Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
.source "PlatformMetricsTimer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "DCPMetricsTimer"
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

.field private mDiscard:Z

.field private mEnd:J

.field private final mMetricComponent:Ljava/lang/String;

.field private mStart:J

.field private mTimerName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "collector"    # Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    .param p2, "metricComponent"    # Ljava/lang/String;
    .param p3, "timerName"    # Ljava/lang/String;

    .prologue
    const-wide/16 v1, -0x1

    .line 42
    invoke-direct {p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mDiscard:Z

    .line 43
    iput-object p1, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    .line 44
    iput-object p2, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mMetricComponent:Ljava/lang/String;

    .line 45
    iput-object p3, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    .line 46
    iput-wide v1, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mStart:J

    .line 47
    iput-wide v1, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mEnd:J

    .line 48
    return-void
.end method


# virtual methods
.method public discard()V
    .locals 2

    .prologue
    .line 102
    sget-object v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Discarding timer: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 103
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mDiscard:Z

    .line 104
    return-void
.end method

.method public getTimerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    return-object v0
.end method

.method public setTimerName(Ljava/lang/String;)V
    .locals 0
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 116
    iput-object p1, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    .line 117
    return-void
.end method

.method public start()V
    .locals 2

    .prologue
    .line 53
    sget-object v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Starting timer: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mMetricComponent:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 54
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mStart:J

    .line 55
    return-void
.end method

.method public stop()V
    .locals 10

    .prologue
    const-wide/32 v8, 0xf4240

    const-wide/16 v4, 0x0

    const-wide/16 v6, -0x1

    .line 60
    iget-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 62
    sget-object v2, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->TAG:Ljava/lang/String;

    .line 97
    :cond_0
    :goto_0
    return-void

    .line 66
    :cond_1
    iget-boolean v2, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mDiscard:Z

    if-nez v2, :cond_0

    .line 71
    iget-wide v2, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mStart:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_2

    .line 73
    sget-object v2, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Timer not started: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_0

    .line 78
    :cond_2
    iget-wide v2, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mEnd:J

    cmp-long v2, v2, v4

    if-lez v2, :cond_3

    .line 80
    iget-wide v2, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mEnd:J

    iget-wide v4, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mStart:J

    sub-long/2addr v2, v4

    div-long v0, v2, v8

    .line 86
    .local v0, "elapsedTimeInMs":J
    :goto_1
    sget-object v2, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Stopping timer: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 87
    iput-wide v6, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mStart:J

    .line 88
    iput-wide v6, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mEnd:J

    .line 90
    iget-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    if-nez v2, :cond_4

    .line 92
    sget-object v2, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Could not record timer because no collector was set"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 84
    .end local v0    # "elapsedTimeInMs":J
    :cond_3
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mStart:J

    sub-long/2addr v2, v4

    div-long v0, v2, v8

    .restart local v0    # "elapsedTimeInMs":J
    goto :goto_1

    .line 96
    :cond_4
    iget-object v2, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    iget-object v3, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mMetricComponent:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mTimerName:Ljava/lang/String;

    invoke-interface {v2, v3, v4, v0, v1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->recordMetricTimerEvent(Ljava/lang/String;Ljava/lang/String;J)V

    goto :goto_0
.end method

.method public stopAndDiscard()V
    .locals 0

    .prologue
    .line 109
    invoke-virtual {p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->stop()V

    .line 110
    invoke-virtual {p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->discard()V

    .line 111
    return-void
.end method

.method public stopClock()V
    .locals 2

    .prologue
    .line 122
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;->mEnd:J

    .line 123
    return-void
.end method
