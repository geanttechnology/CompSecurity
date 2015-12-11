.class public final Lcom/amazon/android/profiling/PageMetricTracker;
.super Ljava/lang/Object;
.source "PageMetricTracker.java"


# static fields
.field private static pageActivity:Landroid/app/Activity;

.field private static pageMetrics:Lcom/amazon/android/profiling/PageMetrics;


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 15
    invoke-static {}, Lcom/amazon/android/profiling/PageMetricTracker;->startPageMeasurement()V

    .line 16
    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method

.method public static declared-synchronized getAndResetMetrics()Lcom/amazon/android/profiling/PageMetrics;
    .locals 3

    .prologue
    .line 37
    const-class v2, Lcom/amazon/android/profiling/PageMetricTracker;

    monitor-enter v2

    :try_start_0
    sget-object v0, Lcom/amazon/android/profiling/PageMetricTracker;->pageMetrics:Lcom/amazon/android/profiling/PageMetrics;

    .line 38
    .local v0, "metricsToReturn":Lcom/amazon/android/profiling/PageMetrics;
    new-instance v1, Lcom/amazon/android/profiling/PageMetrics;

    invoke-direct {v1}, Lcom/amazon/android/profiling/PageMetrics;-><init>()V

    sput-object v1, Lcom/amazon/android/profiling/PageMetricTracker;->pageMetrics:Lcom/amazon/android/profiling/PageMetrics;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 40
    monitor-exit v2

    return-object v0

    .line 37
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static getPageActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/android/profiling/PageMetricTracker;->pageActivity:Landroid/app/Activity;

    return-object v0
.end method

.method public static declared-synchronized startPageMeasurement()V
    .locals 4

    .prologue
    .line 45
    const-class v1, Lcom/amazon/android/profiling/PageMetricTracker;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/amazon/android/profiling/PageMetricTracker;->getAndResetMetrics()Lcom/amazon/android/profiling/PageMetrics;

    .line 47
    sget-object v0, Lcom/amazon/android/profiling/PageMetricTracker;->pageMetrics:Lcom/amazon/android/profiling/PageMetrics;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/amazon/android/profiling/PageMetrics;->setPageStartTime(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 48
    monitor-exit v1

    return-void

    .line 45
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
