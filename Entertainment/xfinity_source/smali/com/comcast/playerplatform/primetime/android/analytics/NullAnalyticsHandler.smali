.class public Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;
.super Ljava/lang/Object;
.source "NullAnalyticsHandler.java"

# interfaces
.implements Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;


# instance fields
.field private logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    return-void
.end method

.method private log(Ljava/lang/String;)V
    .locals 4
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 128
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.analytics]::PlayerAnalytics"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Analytics not configured for event: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    return-void
.end method


# virtual methods
.method public adProgress(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "percentComplete"    # I
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 85
    const-string v0, "triggerAdProgress"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 87
    return-void
.end method

.method public bitrateChanged(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "bitrate"    # J
    .param p3, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 62
    const-string v0, "bitrateChanged"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 64
    return-void
.end method

.method public error(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "errorClass"    # Ljava/lang/String;
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 114
    const-string v0, "error"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 115
    return-void
.end method

.method public fragmentWarning(IIILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "downloadDuration"    # I
    .param p2, "fragmentDuration"    # I
    .param p3, "fragmentSize"    # I
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "currentAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 124
    const-string v0, "fragmentWarning"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 125
    return-void
.end method

.method public heartBeat(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;)V
    .locals 1
    .param p1, "currentPosition"    # Ljava/lang/Long;
    .param p2, "bitrate"    # Ljava/lang/Long;
    .param p3, "fps"    # Ljava/lang/Integer;
    .param p4, "cc"    # Ljava/lang/String;
    .param p5, "sap"    # Ljava/lang/String;
    .param p6, "millisecondsBuffered"    # Ljava/lang/Long;
    .param p7, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .param p8, "fragmentInfo"    # Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    .prologue
    .line 28
    const-string v0, "heartBeat"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 29
    return-void
.end method

.method public mediaEnded(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 56
    const-string v0, "mediaEnded"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 58
    return-void
.end method

.method public mediaFailed(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "manifestUrl"    # Ljava/lang/String;
    .param p2, "currentPosition"    # J
    .param p4, "code"    # Ljava/lang/String;
    .param p5, "description"    # Ljava/lang/String;
    .param p6, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 45
    const-string v0, "mediaFailed"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 47
    return-void
.end method

.method public mediaInfo(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 51
    const-string v0, "mediaInfo"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 52
    return-void
.end method

.method public mediaOpened(Ljava/lang/String;JLjava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "manifestUrl"    # Ljava/lang/String;
    .param p2, "currentPosition"    # J
    .param p4, "latency"    # Ljava/lang/Long;
    .param p5, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 39
    const-string v0, "mediaOpened"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 41
    return-void
.end method

.method public openingMedia(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "manifestUrl"    # Ljava/lang/String;
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 33
    const-string v0, "openingMedia"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 35
    return-void
.end method

.method public playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 74
    const-string v0, "playStateChanged"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 76
    return-void
.end method

.method public playStateChanged(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "status"    # Ljava/lang/String;
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 80
    const-string v0, "playStateChanged"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 81
    return-void
.end method

.method public pluginInitialized(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    const-string v0, "pluginInitialized"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 24
    return-void
.end method

.method public retryAttempt(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "errorClass"    # Ljava/lang/String;
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "retryCount"    # I
    .param p5, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 119
    invoke-virtual {p0, p1, p2, p3, p5}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->error(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 120
    return-void
.end method

.method public scrubEnded(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 103
    const-string v0, "scrubEnded"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 105
    return-void
.end method

.method public scrubStarted(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 97
    const-string v0, "scrubStarted"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 99
    return-void
.end method

.method public trickPlay(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "currentPosition"    # I
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 91
    const-string v0, "trickPlay"

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;->log(Ljava/lang/String;)V

    .line 93
    return-void
.end method
