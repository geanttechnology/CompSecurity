.class public Lcom/adobe/mediacore/DefaultAdPolicySelector;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final _adBreakAsWatchedPolicy:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private final _mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/DefaultAdPolicySelector;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerItem;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/DefaultAdPolicySelector;->extractAdBreakAsWatchedPolicy(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_adBreakAsWatchedPolicy:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    return-void
.end method

.method private extractAdBreakAsWatchedPolicy(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/metadata/AdBreakAsWatched;
    .locals 3

    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_BEGIN:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v0, :cond_0

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->getAdBreakAsWatched()Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method public selectAdBreaksToPlay(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultAdPolicySelector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#selectAdBreaksToPlay"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "currentTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getCurrentTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " seekToTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " rate="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getRate()F

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " adPolicyMode="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getMode()Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    if-lez v2, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getCurrentTime()J

    move-result-wide v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-gtz v3, :cond_0

    add-int/lit8 v2, v2, -0x1

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public selectPolicyForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;
    .locals 6

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultAdPolicySelector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#selectPolicyForAdBreak"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "currentTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getCurrentTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " seekToTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " rate="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getRate()F

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " adPolicyMode="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getMode()Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getMode()Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;->SEEK:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    if-ne v1, v2, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->SKIP:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    :goto_0
    return-object v0

    :cond_0
    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v0, :cond_3

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v0

    :goto_1
    iget-object v1, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v1

    if-nez v1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne v0, v1, :cond_2

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    goto :goto_0

    :cond_2
    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->REMOVE_AFTER_PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    goto :goto_0

    :cond_3
    move-object v0, v1

    goto :goto_1
.end method

.method public selectPolicyForSeekIntoAd(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/timeline/advertising/AdPolicy;
    .locals 6

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultAdPolicySelector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#selectPolicyForSeekIntoAd"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "currentTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getCurrentTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " seekToTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " rate="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getRate()F

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " adPolicyMode="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getMode()Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->SKIP_AD_BREAK:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->PLAY_FROM_AD_BREAK_BEGIN:Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    goto :goto_0
.end method

.method public selectWatchedPolicyForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/metadata/AdBreakAsWatched;
    .locals 6

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultAdPolicySelector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#selectWatchedPolicyForAdBreak"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "currentTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getCurrentTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " seekToTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getSeekToTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " rate="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getRate()F

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " adPolicyMode="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->getMode()Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdPolicySelector;->_adBreakAsWatchedPolicy:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    return-object v0
.end method
