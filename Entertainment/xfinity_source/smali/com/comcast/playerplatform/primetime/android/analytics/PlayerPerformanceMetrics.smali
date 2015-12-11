.class public Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;
.super Ljava/lang/Object;
.source "PlayerPerformanceMetrics.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;


# instance fields
.field private asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

.field private initialBufferFillSent:Z

.field private initialBufferStart:J

.field private initialFragmentTimeSent:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private sendPerformanceMetric(Ljava/lang/String;J)V
    .locals 8
    .param p1, "metric"    # Ljava/lang/String;
    .param p2, "value"    # J

    .prologue
    .line 72
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->getInstance()Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    move-result-object v7

    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v6

    move-object v3, p1

    move-wide v4, p2

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;-><init>(JLjava/lang/String;JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-virtual {v7, v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->buildMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 75
    return-void
.end method


# virtual methods
.method public onBufferComplete()V
    .locals 6

    .prologue
    .line 45
    iget-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialBufferFillSent:Z

    if-nez v2, :cond_0

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialBufferStart:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    .line 46
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialBufferStart:J

    sub-long v0, v2, v4

    .line 47
    .local v0, "initialBufferTime":J
    const-string v2, "InitialBufferFillTime"

    invoke-direct {p0, v2, v0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->sendPerformanceMetric(Ljava/lang/String;J)V

    .line 48
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialBufferFillSent:Z

    .line 50
    .end local v0    # "initialBufferTime":J
    :cond_0
    return-void
.end method

.method public onBufferStart()V
    .locals 2

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialBufferFillSent:Z

    if-nez v0, :cond_0

    .line 39
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialBufferStart:J

    .line 41
    :cond_0
    return-void
.end method

.method public onLoadInfo(Lcom/adobe/mediacore/qos/LoadInfo;)V
    .locals 4
    .param p1, "loadInfo"    # Lcom/adobe/mediacore/qos/LoadInfo;

    .prologue
    .line 55
    invoke-virtual {p1}, Lcom/adobe/mediacore/qos/LoadInfo;->getDownloadDuration()J

    move-result-wide v0

    .line 57
    .local v0, "downloadDuration":J
    invoke-virtual {p1}, Lcom/adobe/mediacore/qos/LoadInfo;->getType()Lcom/adobe/mediacore/qos/LoadInfo$Type;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/qos/LoadInfo$Type;->MANIFEST:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    if-ne v2, v3, :cond_1

    .line 58
    const-string v2, "ManifestDownloadTime"

    invoke-direct {p0, v2, v0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->sendPerformanceMetric(Ljava/lang/String;J)V

    .line 63
    :cond_0
    :goto_0
    return-void

    .line 59
    :cond_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/qos/LoadInfo;->getType()Lcom/adobe/mediacore/qos/LoadInfo$Type;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/qos/LoadInfo$Type;->FRAGMENT:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    if-ne v2, v3, :cond_0

    iget-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialFragmentTimeSent:Z

    if-nez v2, :cond_0

    .line 60
    const-string v2, "InitialFragmentRequestDownloadTime"

    invoke-direct {p0, v2, v0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->sendPerformanceMetric(Ljava/lang/String;J)V

    .line 61
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialFragmentTimeSent:Z

    goto :goto_0
.end method

.method public onOperationFailed(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V
    .locals 0
    .param p1, "warning"    # Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    .prologue
    .line 90
    return-void
.end method

.method public onSeekComplete(J)V
    .locals 0
    .param p1, "l"    # J

    .prologue
    .line 85
    return-void
.end method

.method public onSeekStart()V
    .locals 0

    .prologue
    .line 80
    return-void
.end method

.method public reset()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 26
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialBufferStart:J

    .line 27
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialBufferFillSent:Z

    .line 28
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->initialFragmentTimeSent:Z

    .line 29
    return-void
.end method

.method public setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;)V
    .locals 0
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .prologue
    .line 32
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->reset()V

    .line 33
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .line 34
    return-void
.end method
