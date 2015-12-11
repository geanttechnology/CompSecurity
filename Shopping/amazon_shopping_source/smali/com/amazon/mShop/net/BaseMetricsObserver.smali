.class public abstract Lcom/amazon/mShop/net/BaseMetricsObserver;
.super Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
.source "BaseMetricsObserver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    }
.end annotation


# instance fields
.field private mEndTime:Ljava/lang/Long;

.field private mNetworkEndTime:Ljava/lang/Long;

.field private mShortErrorMessage:Ljava/lang/String;

.field private mStartTime:Ljava/lang/Long;

.field private mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;-><init>()V

    .line 162
    sget-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Unknown:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    iput-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .line 39
    return-void
.end method


# virtual methods
.method public declared-synchronized getErrorMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mShortErrorMessage:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getStatus()Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    .locals 1

    .prologue
    .line 175
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTotalTime()I
    .locals 4

    .prologue
    .line 203
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mEndTime:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    iget-object v2, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStartTime:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    sub-long/2addr v0, v2

    long-to-int v0, v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isFinished()Z
    .locals 2

    .prologue
    .line 189
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Canceled:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Completed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Failed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isStatusFailed()Z
    .locals 2

    .prologue
    .line 182
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    sget-object v1, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Failed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onCancelled()V
    .locals 1

    .prologue
    .line 114
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Canceled:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/net/BaseMetricsObserver;->onFinished(Lcom/amazon/mShop/net/BaseMetricsObserver$Status;)V

    .line 115
    invoke-static {p0}, Lcom/amazon/mShop/net/MetricsCollector;->queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 116
    monitor-exit p0

    return-void

    .line 114
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onComplete()V
    .locals 1

    .prologue
    .line 60
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Completed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/net/BaseMetricsObserver;->onFinished(Lcom/amazon/mShop/net/BaseMetricsObserver$Status;)V

    .line 61
    invoke-static {p0}, Lcom/amazon/mShop/net/MetricsCollector;->queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 62
    monitor-exit p0

    return-void

    .line 60
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "shortErrorMessage"    # Ljava/lang/String;

    .prologue
    .line 105
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mShortErrorMessage:Ljava/lang/String;

    .line 106
    sget-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Failed:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/net/BaseMetricsObserver;->onFinished(Lcom/amazon/mShop/net/BaseMetricsObserver$Status;)V

    .line 107
    invoke-static {p0}, Lcom/amazon/mShop/net/MetricsCollector;->queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 108
    monitor-exit p0

    return-void

    .line 105
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected onFinished(Lcom/amazon/mShop/net/BaseMetricsObserver$Status;)V
    .locals 2
    .param p1, "status"    # Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .prologue
    .line 74
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mEndTime:Ljava/lang/Long;

    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mNetworkEndTime:Ljava/lang/Long;

    if-nez v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mEndTime:Ljava/lang/Long;

    iput-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mNetworkEndTime:Ljava/lang/Long;

    .line 77
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    .line 78
    return-void
.end method

.method public declared-synchronized onResponseReceived()V
    .locals 2

    .prologue
    .line 94
    monitor-enter p0

    :try_start_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mNetworkEndTime:Ljava/lang/Long;

    .line 95
    sget-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Received:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    iput-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 96
    monitor-exit p0

    return-void

    .line 94
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onStart()V
    .locals 2

    .prologue
    .line 52
    monitor-enter p0

    :try_start_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStartTime:Ljava/lang/Long;

    .line 53
    sget-object v0, Lcom/amazon/mShop/net/BaseMetricsObserver$Status;->Running:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;

    iput-object v0, p0, Lcom/amazon/mShop/net/BaseMetricsObserver;->mStatus:Lcom/amazon/mShop/net/BaseMetricsObserver$Status;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 54
    monitor-exit p0

    return-void

    .line 52
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
