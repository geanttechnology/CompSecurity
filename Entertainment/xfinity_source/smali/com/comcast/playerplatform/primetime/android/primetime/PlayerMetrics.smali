.class public Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;
.super Ljava/lang/Object;
.source "PlayerMetrics.java"


# static fields
.field private static currentAspectRatio:F

.field private static drmLatencyEnd:J

.field private static islatencyComplete:Z

.field private static latencyStart:J

.field private static playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

.field private static playbackLatencyEnd:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const-wide/16 v0, 0x0

    .line 12
    sput-wide v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->latencyStart:J

    .line 13
    sput-wide v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackLatencyEnd:J

    .line 14
    sput-wide v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->drmLatencyEnd:J

    .line 15
    const/4 v0, 0x0

    sput v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->currentAspectRatio:F

    .line 16
    const/4 v0, 0x0

    sput-boolean v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->islatencyComplete:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getBitrate()J
    .locals 2

    .prologue
    .line 46
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getBitrate()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getBufferLength()J
    .locals 2

    .prologue
    .line 62
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getBufferLength()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getBufferTime()J
    .locals 2

    .prologue
    .line 66
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getBufferTime()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getBufferingTime()J
    .locals 2

    .prologue
    .line 58
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getBufferingTime()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getCurrentAspectRatio()F
    .locals 1

    .prologue
    .line 114
    sget v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->currentAspectRatio:F

    return v0
.end method

.method public static getDrmLatency()J
    .locals 6

    .prologue
    .line 41
    sget-wide v2, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->drmLatencyEnd:J

    sget-wide v4, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->latencyStart:J

    sub-long v0, v2, v4

    .line 42
    .local v0, "latency":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-lez v2, :cond_0

    .end local v0    # "latency":J
    :goto_0
    return-wide v0

    .restart local v0    # "latency":J
    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method static getDrmLatencyDictionary()Ljava/util/Map;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 94
    sget-wide v4, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->drmLatencyEnd:J

    sget-wide v6, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->latencyStart:J

    sub-long v0, v4, v6

    .line 95
    .local v0, "latency":J
    const-wide/16 v4, 0x0

    cmp-long v3, v0, v4

    if-lez v3, :cond_0

    .line 96
    :goto_0
    new-instance v2, Ljava/util/Hashtable;

    invoke-direct {v2}, Ljava/util/Hashtable;-><init>()V

    .line 97
    .local v2, "ret":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "drmLatency"

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    return-object v2

    .line 95
    .end local v2    # "ret":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getDroppedFrames()J
    .locals 2

    .prologue
    .line 54
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getDroppedFrameCount()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getEmptyBufferCount()J
    .locals 2

    .prologue
    .line 70
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getEmptyBufferCount()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getFrameRate()F
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getFrameRate()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/high16 v0, -0x40800000    # -1.0f

    goto :goto_0
.end method

.method public static getLoadingLatency()J
    .locals 2

    .prologue
    .line 74
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getTimeToLoad()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getOpeningLatency()J
    .locals 6

    .prologue
    .line 36
    sget-wide v2, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackLatencyEnd:J

    sget-wide v4, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->latencyStart:J

    sub-long v0, v2, v4

    .line 37
    .local v0, "latency":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-lez v2, :cond_0

    .end local v0    # "latency":J
    :goto_0
    return-wide v0

    .restart local v0    # "latency":J
    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public static getStartLatency()J
    .locals 2

    .prologue
    .line 78
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/PlaybackInformation;->getTimeToStart()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method


# virtual methods
.method clearLatencyValues()V
    .locals 2

    .prologue
    const-wide/16 v0, 0x0

    .line 21
    sput-wide v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->latencyStart:J

    .line 22
    sput-wide v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackLatencyEnd:J

    .line 23
    sput-wide v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->drmLatencyEnd:J

    .line 24
    const/4 v0, 0x0

    sput-boolean v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->islatencyComplete:Z

    .line 25
    return-void
.end method

.method getPlaybackInformaiton()Lcom/adobe/mediacore/qos/PlaybackInformation;
    .locals 1

    .prologue
    .line 106
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    return-object v0
.end method

.method isIslatencyComplete()Z
    .locals 1

    .prologue
    .line 28
    sget-boolean v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->islatencyComplete:Z

    return v0
.end method

.method setCurrentAspectRatio(F)V
    .locals 0
    .param p1, "newAspectRatio"    # F

    .prologue
    .line 110
    sput p1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->currentAspectRatio:F

    .line 111
    return-void
.end method

.method setDrmLatencyEnd(J)V
    .locals 1
    .param p1, "value"    # J

    .prologue
    .line 82
    sput-wide p1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->drmLatencyEnd:J

    .line 83
    return-void
.end method

.method setIslatencyComplete(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 32
    sput-boolean p1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->islatencyComplete:Z

    .line 33
    return-void
.end method

.method setLatencyStart(J)V
    .locals 1
    .param p1, "value"    # J

    .prologue
    .line 90
    sput-wide p1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->latencyStart:J

    .line 91
    return-void
.end method

.method setPlaybackInformation(Lcom/adobe/mediacore/qos/PlaybackInformation;)V
    .locals 0
    .param p1, "playbackInformation"    # Lcom/adobe/mediacore/qos/PlaybackInformation;

    .prologue
    .line 102
    sput-object p1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackInformation:Lcom/adobe/mediacore/qos/PlaybackInformation;

    .line 103
    return-void
.end method

.method setPlaybackLatencyEnd(J)V
    .locals 1
    .param p1, "value"    # J

    .prologue
    .line 86
    sput-wide p1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->playbackLatencyEnd:J

    .line 87
    return-void
.end method
