.class public Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;
.super Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
.source "C3Manager.java"


# instance fields
.field private metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 10
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
    .line 29
    .local p1, "adBreaks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;-><init>()V

    .line 30
    new-instance v6, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;

    invoke-direct {v6, p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    iput-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    .line 32
    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v6, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->setAdList(Ljava/util/List;)V

    .line 34
    new-instance v6, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v6}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    iput-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    .line 36
    new-instance v5, Lcom/adobe/mediacore/utils/TimeRangeCollection;

    sget-object v6, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->MARK_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    invoke-direct {v5, v6}, Lcom/adobe/mediacore/utils/TimeRangeCollection;-><init>(Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;)V

    .line 37
    .local v5, "timeRanges":Lcom/adobe/mediacore/utils/TimeRangeCollection;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .line 38
    .local v1, "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->getVideoAdsList()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .line 39
    .local v0, "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getStartTime()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v8

    invoke-static {v6, v7, v8, v9}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/adobe/mediacore/utils/TimeRangeCollection;->addTimeRange(Lcom/adobe/mediacore/utils/TimeRange;)V

    goto :goto_0

    .line 43
    .end local v0    # "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .end local v1    # "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_1
    new-instance v4, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v4}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    .line 45
    .local v4, "options":Lcom/adobe/mediacore/metadata/Metadata;
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    sget-object v6, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v6}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v4}, Lcom/adobe/mediacore/utils/TimeRangeCollection;->toMetadata(Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    check-cast v6, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-virtual {v7, v8, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    .line 46
    return-void
.end method


# virtual methods
.method public getMetadataForAdobe()Lcom/adobe/mediacore/metadata/MetadataNode;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    return-object v0
.end method

.method public getPlayerTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 2
    .param p1, "adobeTimeline"    # Lcom/adobe/mediacore/timeline/Timeline;

    .prologue
    .line 70
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->getAdList()Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;-><init>(Ljava/util/List;)V

    return-object v0
.end method

.method public getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 1

    .prologue
    .line 55
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    return-object v0
.end method

.method public mediaProgress(JDJJI)V
    .locals 1
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 75
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/C3Manager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->updateProgress(J)V

    .line 76
    return-void
.end method

.method public onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 0
    .param p1, "timedMetadata"    # Lcom/adobe/mediacore/metadata/TimedMetadata;

    .prologue
    .line 61
    return-void
.end method
