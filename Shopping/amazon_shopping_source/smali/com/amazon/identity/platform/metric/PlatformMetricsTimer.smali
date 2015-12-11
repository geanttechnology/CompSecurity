.class public abstract Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
.super Ljava/lang/Object;
.source "PlatformMetricsTimer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$FakeMetricsTimer;,
        Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;
    }
.end annotation


# static fields
.field public static final MILLISECONDS_PER_NANOSECOND:J = 0xf4240L

.field public static final NULL_TIMER:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    new-instance v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$FakeMetricsTimer;

    invoke-direct {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$FakeMetricsTimer;-><init>()V

    sput-object v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->NULL_TIMER:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 132
    return-void
.end method

.method public static createPeriodicTimer(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p0, "collector"    # Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 176
    if-eqz p0, :cond_0

    .line 178
    invoke-interface {p0, p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->createPeriodicTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    .line 182
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->NULL_TIMER:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    goto :goto_0
.end method

.method public static getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p0, "collector"    # Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    .param p1, "metricComponent"    # Ljava/lang/String;
    .param p2, "timerName"    # Ljava/lang/String;

    .prologue
    .line 190
    if-eqz p0, :cond_0

    .line 192
    new-instance v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$DCPMetricsTimer;-><init>(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->NULL_TIMER:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    goto :goto_0
.end method


# virtual methods
.method public abstract discard()V
.end method

.method public abstract getTimerName()Ljava/lang/String;
.end method

.method public abstract setTimerName(Ljava/lang/String;)V
.end method

.method public abstract start()V
.end method

.method public abstract stop()V
.end method

.method public abstract stopAndDiscard()V
.end method

.method public abstract stopClock()V
.end method
