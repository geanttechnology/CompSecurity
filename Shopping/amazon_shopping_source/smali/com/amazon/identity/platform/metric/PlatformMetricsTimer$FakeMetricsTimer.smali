.class final Lcom/amazon/identity/platform/metric/PlatformMetricsTimer$FakeMetricsTimer;
.super Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
.source "PlatformMetricsTimer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "FakeMetricsTimer"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 132
    invoke-direct {p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;-><init>()V

    return-void
.end method


# virtual methods
.method public discard()V
    .locals 0

    .prologue
    .line 148
    return-void
.end method

.method public getTimerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 169
    const/4 v0, 0x0

    return-object v0
.end method

.method public setTimerName(Ljava/lang/String;)V
    .locals 0
    .param p1, "timerName"    # Ljava/lang/String;

    .prologue
    .line 158
    return-void
.end method

.method public start()V
    .locals 0

    .prologue
    .line 138
    return-void
.end method

.method public stop()V
    .locals 0

    .prologue
    .line 143
    return-void
.end method

.method public stopAndDiscard()V
    .locals 0

    .prologue
    .line 153
    return-void
.end method

.method public stopClock()V
    .locals 0

    .prologue
    .line 164
    return-void
.end method
