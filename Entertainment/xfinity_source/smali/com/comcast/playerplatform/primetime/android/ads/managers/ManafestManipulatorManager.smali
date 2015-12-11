.class public Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;
.super Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
.source "ManafestManipulatorManager.java"


# static fields
.field private static final dateFormat:Ljava/text/DateFormat;

.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private deviceId:Ljava/lang/String;

.field private dispatcher:Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;

.field private endAllSent:Z

.field private endSent:Z

.field private fistQuartileSent:Z

.field private isFirstProgress:Z

.field private partnerId:Ljava/lang/String;

.field protected playerIsReady:Z

.field private secondQuartileSent:Z

.field private thirdQuartileSent:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->logger:Lorg/slf4j/Logger;

    .line 38
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZZZZZ"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->dateFormat:Ljava/text/DateFormat;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 2
    .param p1, "deviceId"    # Ljava/lang/String;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p3, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;-><init>()V

    .line 48
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->isFirstProgress:Z

    .line 49
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->playerIsReady:Z

    .line 53
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManifestManipulatorTimeline;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    .line 54
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->deviceId:Ljava/lang/String;

    .line 55
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;-><init>()V

    .line 56
    .local v0, "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getPartnerId()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->partnerId:Ljava/lang/String;

    .line 57
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->createMetadataNode()V

    .line 58
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;

    invoke-direct {v1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->dispatcher:Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;

    .line 59
    return-void
.end method

.method private createMetadataNode()V
    .locals 1

    .prologue
    .line 62
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->endAllSent:Z

    .line 63
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->resetQuartiles()V

    .line 64
    return-void
.end method

.method private getTimestamp()Ljava/lang/String;
    .locals 3

    .prologue
    .line 167
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 168
    .local v0, "date":Ljava/util/Date;
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->dateFormat:Ljava/text/DateFormat;

    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/DateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 169
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->dateFormat:Ljava/text/DateFormat;

    invoke-virtual {v1, v0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private isAdCue(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z
    .locals 2
    .param p1, "timedMetadata"    # Lcom/adobe/mediacore/metadata/TimedMetadata;

    .prologue
    .line 266
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "#EXT-X-CUE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isAdRestriction(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z
    .locals 2
    .param p1, "timedMetadata"    # Lcom/adobe/mediacore/metadata/TimedMetadata;

    .prologue
    .line 270
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "#EXT-X-TRICKMODE-RESTRICTION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private resetQuartiles()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 121
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->fistQuartileSent:Z

    .line 122
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->secondQuartileSent:Z

    .line 123
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->thirdQuartileSent:Z

    .line 124
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->isFirstProgress:Z

    .line 125
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->endSent:Z

    .line 126
    return-void
.end method

.method private sendPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 13
    .param p1, "eventType"    # Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    const-wide/16 v8, 0x3e8

    const/4 v4, 0x0

    .line 149
    const-wide/16 v10, 0x0

    .line 150
    .local v10, "position":J
    const-string v1, ""

    .line 152
    .local v1, "adId":Ljava/lang/String;
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END_ALL:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    if-eq p1, v0, :cond_1

    .line 153
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v2

    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getSecondsRemaining()J

    move-result-wide v6

    sub-long v10, v2, v6

    .line 154
    cmp-long v0, v10, v8

    if-gez v0, :cond_2

    .line 155
    const-wide/16 v10, 0x0

    .line 160
    :cond_0
    :goto_0
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getId()Ljava/lang/String;

    move-result-object v1

    .line 163
    :cond_1
    iget-object v12, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->dispatcher:Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;

    long-to-float v2, v10

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->deviceId:Ljava/lang/String;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->getTimestamp()Ljava/lang/String;

    move-result-object v8

    move-object v5, v4

    move-object v6, v4

    move-object v7, v4

    move-object v9, p1

    invoke-direct/range {v0 .. v9}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent;-><init>(Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;)V

    invoke-virtual {v12, v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;->dispatchPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;)V

    .line 164
    return-void

    .line 156
    :cond_2
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v2

    sub-long/2addr v2, v8

    cmp-long v0, v10, v2

    if-lez v0, :cond_0

    .line 157
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v10

    goto :goto_0
.end method


# virtual methods
.method public clearPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 252
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    move-result-object v0

    .line 253
    .local v0, "currentAd":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->endSent:Z

    if-nez v1, :cond_0

    .line 254
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-direct {p0, v1, v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->sendPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 255
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->endSent:Z

    .line 257
    :cond_0
    iget-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->endAllSent:Z

    if-nez v1, :cond_1

    .line 258
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END_ALL:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-direct {p0, v1, v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->sendPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 259
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->endAllSent:Z

    .line 262
    :cond_1
    invoke-super {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->clearPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v1

    return-object v1
.end method

.method public getMetadataForAdobe()Lcom/adobe/mediacore/metadata/MetadataNode;
    .locals 1

    .prologue
    .line 130
    const/4 v0, 0x0

    return-object v0
.end method

.method public getPlayerTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 2
    .param p1, "adobeTimeline"    # Lcom/adobe/mediacore/timeline/Timeline;

    .prologue
    .line 275
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->getAdList()Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;-><init>(Ljava/util/List;)V

    return-object v0
.end method

.method public getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 1

    .prologue
    .line 135
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    return-object v0
.end method

.method public mediaEnded()V
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->streamComplete()V

    .line 204
    return-void
.end method

.method public mediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V
    .locals 10
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "mediaType"    # Ljava/lang/String;
    .param p6, "width"    # J
    .param p8, "height"    # J
    .param p10, "duration"    # J
    .param p12, "openingLatency"    # D
    .param p14, "hasCC"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;",
            ">;JJJDZ)V"
        }
    .end annotation

    .prologue
    .line 208
    .local p3, "playbackSpeeds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p4, "availableAudioLanguages":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;>;"
    .local p5, "availableClosedCaptionTracks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    const/4 v6, 0x0

    move-object v1, p0

    invoke-virtual/range {v1 .. v6}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->getSeekAdjustment(JJZ)J

    move-result-wide v8

    .line 209
    .local v8, "startPositionAdjustment":J
    const-wide/16 v0, 0x0

    cmp-long v0, v8, v0

    if-eqz v0, :cond_0

    .line 210
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    const/4 v1, 0x1

    invoke-interface {v0, v8, v9, v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setPosition(JZ)V

    .line 212
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->playerIsReady:Z

    .line 213
    return-void
.end method

.method public mediaProgress(JDJJI)V
    .locals 1
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 196
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->playerIsReady:Z

    if-eqz v0, :cond_0

    .line 197
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->updateProgress(J)V

    .line 199
    :cond_0
    return-void
.end method

.method public onSeekComplete(J)V
    .locals 1
    .param p1, "position"    # J

    .prologue
    .line 245
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->playerIsReady:Z

    if-eqz v0, :cond_0

    .line 246
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->onSeekEnd(J)V

    .line 248
    :cond_0
    return-void
.end method

.method public onSeekStart()V
    .locals 4

    .prologue
    .line 238
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->playerIsReady:Z

    if-eqz v0, :cond_0

    .line 239
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->onSeekStart(J)V

    .line 241
    :cond_0
    return-void
.end method

.method public onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 10
    .param p1, "timedMetadata"    # Lcom/adobe/mediacore/metadata/TimedMetadata;

    .prologue
    .line 217
    sget-object v7, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->logger:Lorg/slf4j/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "onTimedMetadata:"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v8, ":"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    const-string v9, "ID"

    invoke-interface {v6, v9}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    const-string v9, "ID"

    invoke-interface {v6, v9}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    :goto_0
    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v7, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 218
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->isAdRestriction(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 219
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    const-string v7, "ADID"

    invoke-interface {v6, v7}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 220
    .local v2, "id":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    const-string v7, "MODE"

    invoke-interface {v6, v7}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 221
    .local v5, "type":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    const-string v7, "LIMIT"

    invoke-interface {v6, v7}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 222
    .local v3, "limit":Ljava/lang/String;
    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v6, v2, v5, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->createAdRestriction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 229
    .end local v2    # "id":Ljava/lang/String;
    .end local v3    # "limit":Ljava/lang/String;
    .end local v5    # "type":Ljava/lang/String;
    :cond_0
    :goto_1
    return-void

    .line 217
    :cond_1
    const-string v6, ""

    goto :goto_0

    .line 223
    :cond_2
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->isAdCue(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 224
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    const-string v7, "ID"

    invoke-interface {v6, v7}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 225
    .restart local v2    # "id":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    const-string v7, "DURATION"

    invoke-interface {v6, v7}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    const/high16 v7, 0x447a0000    # 1000.0f

    mul-float/2addr v6, v7

    float-to-long v0, v6

    .line 226
    .local v0, "duration":J
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    .line 227
    .local v4, "time":Ljava/lang/Long;
    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v6, v2, v4, v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->createAdBreak(Ljava/lang/String;Ljava/lang/Long;J)V

    goto :goto_1
.end method

.method public triggerAdBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 117
    invoke-super {p0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 118
    return-void
.end method

.method public triggerAdBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 97
    invoke-super {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 98
    return-void
.end method

.method public triggerAdComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 1
    .param p1, "adbreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 102
    invoke-super {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 103
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->endSent:Z

    if-nez v0, :cond_0

    .line 105
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->END:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-direct {p0, v0, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->sendPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 106
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->endSent:Z

    .line 108
    :cond_0
    return-void
.end method

.method public declared-synchronized triggerAdProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 6
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "percentComplete"    # I
    .param p4, "timeToComplete"    # J

    .prologue
    const/16 v4, 0x4b

    const/16 v3, 0x32

    const/16 v2, 0x19

    .line 67
    monitor-enter p0

    :try_start_0
    invoke-super/range {p0 .. p5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V

    .line 69
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getAdProgressPercent()I

    move-result v0

    .line 70
    .local v0, "progressPercent":I
    iget-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->isFirstProgress:Z

    if-eqz v1, :cond_1

    .line 71
    if-le v0, v4, :cond_3

    .line 72
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->fistQuartileSent:Z

    .line 73
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->secondQuartileSent:Z

    .line 74
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->thirdQuartileSent:Z

    .line 81
    :cond_0
    :goto_0
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->isFirstProgress:Z

    .line 84
    :cond_1
    iget-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->fistQuartileSent:Z

    if-nez v1, :cond_5

    if-le v0, v2, :cond_5

    .line 85
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->FIRST_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-direct {p0, v1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->sendPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 86
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->fistQuartileSent:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 94
    :cond_2
    :goto_1
    monitor-exit p0

    return-void

    .line 75
    :cond_3
    if-le v0, v3, :cond_4

    .line 76
    const/4 v1, 0x1

    :try_start_1
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->fistQuartileSent:Z

    .line 77
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->secondQuartileSent:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 67
    .end local v0    # "progressPercent":I
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 78
    .restart local v0    # "progressPercent":I
    :cond_4
    if-le v0, v2, :cond_0

    .line 79
    const/4 v1, 0x1

    :try_start_2
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->fistQuartileSent:Z

    goto :goto_0

    .line 87
    :cond_5
    iget-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->secondQuartileSent:Z

    if-nez v1, :cond_6

    if-le v0, v3, :cond_6

    .line 88
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->SECOND_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-direct {p0, v1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->sendPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 89
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->secondQuartileSent:Z

    goto :goto_1

    .line 90
    :cond_6
    iget-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->thirdQuartileSent:Z

    if-nez v1, :cond_2

    if-le v0, v4, :cond_2

    .line 91
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->THIRD_QUARTILE:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-direct {p0, v1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->sendPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 92
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->thirdQuartileSent:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public triggerAdStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 1
    .param p1, "adbreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 111
    invoke-super {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 112
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->resetQuartiles()V

    .line 113
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;->START:Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;

    invoke-direct {p0, v0, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->sendPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 114
    return-void
.end method

.method public updateUriWithQueryParams(Landroid/net/Uri;Lcom/comcast/playerplatform/primetime/android/asset/Asset;Ljava/lang/String;)Landroid/net/Uri;
    .locals 6
    .param p1, "urForAds"    # Landroid/net/Uri;
    .param p2, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p3, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 173
    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v1

    .line 174
    .local v1, "oldDomain":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    .line 176
    .local v2, "uriBuilder":Landroid/net/Uri$Builder;
    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->deviceId:Ljava/lang/String;

    .line 179
    :try_start_0
    const-string v3, "ccr"

    const-string v4, "mm"

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 180
    const-string v3, "sid"

    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;->refreshSessionUUID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 181
    const-string v3, "dtz"

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->getTimestamp()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 182
    const-string v3, "DeviceId"

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->deviceId:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 183
    const-string v3, "PartnerId"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "private:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->partnerId:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 184
    const-string v3, "ProviderId"

    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 185
    const-string v3, "AssetId"

    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 186
    const-string v3, "StreamType"

    const-string v4, "VOD_T6"

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 191
    :goto_0
    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    return-object v3

    .line 187
    :catch_0
    move-exception v0

    .line 189
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {p1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    goto :goto_0
.end method
