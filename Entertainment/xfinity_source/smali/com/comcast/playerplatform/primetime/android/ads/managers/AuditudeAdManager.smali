.class public Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;
.super Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
.source "AuditudeAdManager.java"


# static fields
.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;Ljava/lang/String;)V
    .locals 1
    .param p1, "zoneId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "adParams"    # Lcom/adobe/mediacore/metadata/Metadata;
    .param p4, "mediaId"    # Ljava/lang/String;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;-><init>()V

    .line 30
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/DefaultAdTimeline;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    .line 32
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->createMetadata(Ljava/lang/String;Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;Ljava/lang/String;)V

    .line 33
    return-void
.end method

.method private createMetadata(Ljava/lang/String;Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;Ljava/lang/String;)V
    .locals 3
    .param p1, "zoneId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "adParams"    # Lcom/adobe/mediacore/metadata/Metadata;
    .param p4, "mediaId"    # Ljava/lang/String;

    .prologue
    .line 36
    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    .line 38
    new-instance v0, Lcom/adobe/mediacore/metadata/AuditudeSettings;

    invoke-direct {v0}, Lcom/adobe/mediacore/metadata/AuditudeSettings;-><init>()V

    .line 39
    .local v0, "auditudeMetadata":Lcom/adobe/mediacore/metadata/AuditudeSettings;
    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setZoneId(Ljava/lang/String;)V

    .line 40
    invoke-virtual {v0, p4}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setMediaId(Ljava/lang/String;)V

    .line 41
    invoke-virtual {v0, p2}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setDomain(Ljava/lang/String;)V

    .line 42
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setCreativeRepackagingEnabled(Z)V

    .line 43
    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    const-string v2, "false"

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    if-eqz p3, :cond_0

    invoke-interface {p3}, Lcom/adobe/mediacore/metadata/Metadata;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 46
    invoke-virtual {v0, p3}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setTargetingParameters(Lcom/adobe/mediacore/metadata/Metadata;)V

    .line 49
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    const-string v2, "auditude_metadata"

    invoke-virtual {v1, v2, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    .line 50
    return-void
.end method


# virtual methods
.method public getMetadataForAdobe()Lcom/adobe/mediacore/metadata/MetadataNode;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    return-object v0
.end method

.method public getPlayerTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 2
    .param p1, "adobeTimeline"    # Lcom/adobe/mediacore/timeline/Timeline;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->auditdueTimelineMarkers:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    .line 75
    .local v0, "timeline":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    if-nez v0, :cond_0

    .line 76
    if-nez p1, :cond_1

    .line 77
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    .end local v0    # "timeline":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;-><init>(Ljava/util/List;)V

    .line 82
    .restart local v0    # "timeline":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    :cond_0
    :goto_0
    return-object v0

    .line 79
    :cond_1
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    .end local v0    # "timeline":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    invoke-interface {p1}, Lcom/adobe/mediacore/timeline/Timeline;->timelineMarkers()Ljava/util/Iterator;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;-><init>(Ljava/util/Iterator;)V

    .restart local v0    # "timeline":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    goto :goto_0
.end method

.method public getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    return-object v0
.end method

.method public mediaProgress(JDJJI)V
    .locals 5
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/AuditudeAdManager;->getAdOffset()J

    move-result-wide v2

    add-long/2addr v2, p1

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->updateProgress(J)V

    .line 106
    return-void
.end method

.method public onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 0
    .param p1, "timedMetadata"    # Lcom/adobe/mediacore/metadata/TimedMetadata;

    .prologue
    .line 65
    return-void
.end method
