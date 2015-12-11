.class public abstract Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
.super Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
.source "BaseAdManager.java"


# static fields
.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private adBreakCompleteSent:Z

.field protected auditdueTimelineMarkers:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

.field protected eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field protected hasResumePoint:Z

.field protected player:Lcom/comcast/playerplatform/primetime/android/player/Player;

.field protected savedSeekValue:J

.field protected seekingOutOfAd:Z

.field protected skipAdsOnSeek:Z

.field protected timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 44
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;-><init>()V

    .line 33
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    .line 34
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->hasResumePoint:Z

    .line 35
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->skipAdsOnSeek:Z

    .line 37
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->savedSeekValue:J

    .line 38
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->adBreakCompleteSent:Z

    .line 43
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->auditdueTimelineMarkers:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    .line 45
    return-void
.end method


# virtual methods
.method public addPlayerEventManager(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V
    .locals 1
    .param p1, "eventManager"    # Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .prologue
    .line 136
    if-eqz p1, :cond_0

    .line 137
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .line 138
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->addListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 140
    :cond_0
    return-void
.end method

.method public attachPlayer(Lcom/comcast/playerplatform/primetime/android/player/Player;)V
    .locals 0
    .param p1, "player"    # Lcom/comcast/playerplatform/primetime/android/player/Player;

    .prologue
    .line 174
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    .line 175
    return-void
.end method

.method public clearPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->clear()V

    .line 170
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    return-object v0
.end method

.method public getAdList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation

    .prologue
    .line 108
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->getAdList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getAdOffset()J
    .locals 8

    .prologue
    .line 266
    const-wide/16 v2, 0x0

    .line 267
    .local v2, "offset":J
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-result-object v0

    .line 268
    .local v0, "currentAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getMarkerPosition()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v6

    cmp-long v1, v4, v6

    if-eqz v1, :cond_0

    .line 270
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getMarkerPosition()J

    move-result-wide v6

    sub-long v2, v4, v6

    .line 272
    :cond_0
    return-wide v2
.end method

.method public getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-result-object v0

    return-object v0
.end method

.method public abstract getMetadataForAdobe()Lcom/adobe/mediacore/metadata/MetadataNode;
.end method

.method public abstract getPlayerTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
.end method

.method public getSeekAdjustment(JJZ)J
    .locals 15
    .param p1, "seekPosition"    # J
    .param p3, "currentPosition"    # J
    .param p5, "skipAds"    # Z

    .prologue
    .line 179
    const/4 v4, 0x0

    .line 180
    .local v4, "closestAd":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    move-wide/from16 v8, p1

    .line 181
    .local v8, "newSeekValue":J
    move/from16 v0, p5

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->skipAdsOnSeek:Z

    .line 182
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    if-eqz v7, :cond_1

    if-nez p5, :cond_1

    .line 183
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-result-object v5

    .line 184
    .local v5, "currentAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    if-eqz v5, :cond_0

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getAdOffset()J

    move-result-wide v10

    const-wide/16 v12, 0x0

    cmp-long v7, v10, v12

    if-eqz v7, :cond_0

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getMarkerPosition()J

    move-result-wide v10

    cmp-long v7, v10, p1

    if-gez v7, :cond_0

    .line 185
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getAdOffset()J

    move-result-wide v10

    add-long/2addr v8, v10

    .line 187
    :cond_0
    if-eqz v5, :cond_2

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->hasBeenSeen()Z

    move-result v7

    if-nez v7, :cond_2

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isSeekDisabled()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getAdOffset()J

    move-result-wide v10

    add-long v10, v10, p3

    cmp-long v7, v10, v8

    if-gez v7, :cond_2

    .line 189
    move-wide/from16 v8, p3

    .line 216
    .end local v5    # "currentAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    :cond_1
    :goto_0
    return-wide v8

    .line 191
    .restart local v5    # "currentAdBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    :cond_2
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->getAdList()Ljava/util/List;

    move-result-object v3

    .line 192
    .local v3, "adBreaks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v7, :cond_5

    if-eqz v3, :cond_5

    .line 193
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 194
    .local v2, "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v10

    cmp-long v7, p1, v10

    if-ltz v7, :cond_3

    if-eqz v4, :cond_4

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v10

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v12

    cmp-long v7, v10, v12

    if-ltz v7, :cond_3

    .line 195
    :cond_4
    move-object v4, v2

    goto :goto_1

    .line 200
    .end local v2    # "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v6    # "i$":Ljava/util/Iterator;
    :cond_5
    if-eqz v4, :cond_6

    if-eq v4, v5, :cond_6

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->hasBeenSeen()Z

    move-result v7

    if-nez v7, :cond_6

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->isSeekDisabled()Z

    move-result v7

    if-eqz v7, :cond_6

    .line 201
    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getStartTime()J

    move-result-wide v8

    .line 202
    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getEndTime()J

    move-result-wide v10

    cmp-long v7, p1, v10

    if-lez v7, :cond_8

    .line 203
    move-wide/from16 v0, p1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->savedSeekValue:J

    .line 208
    :cond_6
    :goto_2
    if-eqz v5, :cond_1

    invoke-virtual {v5, v8, v9}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->coversLocation(J)Z

    move-result v7

    if-nez v7, :cond_1

    cmp-long v7, v8, p3

    if-nez v7, :cond_7

    cmp-long v7, v8, p1

    if-eqz v7, :cond_1

    .line 210
    :cond_7
    const/4 v7, 0x1

    iput-boolean v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    goto :goto_0

    .line 205
    :cond_8
    const-wide/16 v10, -0x1

    iput-wide v10, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->savedSeekValue:J

    goto :goto_2
.end method

.method public abstract getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;
.end method

.method public getSkipAdsOnSeek()Z
    .locals 1

    .prologue
    .line 253
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->skipAdsOnSeek:Z

    return v0
.end method

.method public getTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;
    .locals 1
    .param p1, "adobeTimeline"    # Lcom/adobe/mediacore/timeline/Timeline;

    .prologue
    .line 132
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    return-object v0
.end method

.method public getWatchedPolicy()Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;
    .locals 2

    .prologue
    .line 223
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;->DO_NOT_MARK:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;

    .line 225
    .local v0, "policy":Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-result-object v1

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    if-nez v1, :cond_0

    .line 226
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;->MARK_AS_WATCHED:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy;

    .line 229
    :cond_0
    iget-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    if-eqz v1, :cond_1

    .line 230
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    .line 233
    :cond_1
    return-object v0
.end method

.method public isAdPlaying()Z
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->isAdPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public markAsSeen(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 1
    .param p1, "currentAdBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 243
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->hasBeenSeen()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    if-nez v0, :cond_0

    .line 244
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setHasBeenSeen(Z)V

    .line 246
    :cond_0
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    if-eqz v0, :cond_1

    .line 247
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    .line 249
    :cond_1
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
    .line 104
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->updateProgress(J)V

    .line 105
    return-void
.end method

.method public abstract onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
.end method

.method public playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 1
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 260
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {p1, v0}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 261
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->auditdueTimelineMarkers:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    .line 263
    :cond_0
    return-void
.end method

.method public removePlayerEventManager()V
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->removeListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 147
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .line 148
    return-void
.end method

.method public setAdList(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 113
    .local p1, "adList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->setAdList(Ljava/util/List;)V

    .line 114
    return-void
.end method

.method public setResumePosition(J)V
    .locals 5
    .param p1, "position"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 159
    cmp-long v0, p1, v2

    if-lez v0, :cond_0

    .line 160
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->hasResumePoint:Z

    .line 161
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->setResumePosition(J)V

    .line 165
    :goto_0
    return-void

    .line 163
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->updateProgress(J)V

    goto :goto_0
.end method

.method public triggerAdBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 4
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 59
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    .line 60
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    if-eqz v0, :cond_2

    .line 61
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adBreakExited(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 67
    :cond_0
    :goto_0
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->savedSeekValue:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    if-nez v0, :cond_1

    .line 68
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->savedSeekValue:J

    const/4 v1, 0x1

    invoke-interface {v0, v2, v3, v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setPosition(JZ)V

    .line 69
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->savedSeekValue:J

    .line 71
    :cond_1
    return-void

    .line 63
    :cond_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    goto :goto_0
.end method

.method public triggerAdBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 1
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->adBreakCompleteSent:Z

    .line 53
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 56
    :cond_0
    return-void
.end method

.method public triggerAdComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 6
    .param p1, "adbreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 74
    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getEndTime()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getEndTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->adBreakCompleteSent:Z

    if-nez v0, :cond_0

    .line 75
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getEndTime()J

    move-result-wide v0

    const-wide/16 v2, 0xa

    sub-long/2addr v0, v2

    invoke-virtual {p1, v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getAdAtLocation(J)Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    move-result-object v2

    const/16 v3, 0x64

    const-wide/16 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V

    .line 76
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->adBreakCompleteSent:Z

    .line 78
    :cond_0
    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_1

    .line 79
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->seekingOutOfAd:Z

    if-eqz v0, :cond_2

    .line 80
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adExited(Ljava/lang/String;)V

    .line 85
    :cond_1
    :goto_0
    return-void

    .line 82
    :cond_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {p2}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adComplete(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public triggerAdProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 6
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "percentComplete"    # I
    .param p4, "timeToComplete"    # J

    .prologue
    .line 94
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->adBreakCompleteSent:Z

    if-nez v0, :cond_0

    .line 95
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-wide v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V

    .line 96
    const/16 v0, 0x64

    if-ne p3, v0, :cond_0

    .line 97
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->adBreakCompleteSent:Z

    .line 100
    :cond_0
    return-void
.end method

.method public triggerAdStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 1
    .param p1, "adbreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 88
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->eventManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 91
    :cond_0
    return-void
.end method
