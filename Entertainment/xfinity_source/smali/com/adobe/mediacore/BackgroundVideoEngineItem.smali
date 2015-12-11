.class final Lcom/adobe/mediacore/BackgroundVideoEngineItem;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayerItem;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static final UNKNOWN_PERIOD_INDEX:I = -0x1

.field private static final _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private _adCueTags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private _audioTracks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/AudioTrack;",
            ">;"
        }
    .end annotation
.end field

.field private _closedCaptionsTracks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/ClosedCaptionsTrack;",
            ">;"
        }
    .end annotation
.end field

.field private _currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

.field private _currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

.field private _dispatchedTimedMetadata:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/metadata/TimedMetadata;",
            ">;"
        }
    .end annotation
.end field

.field private _drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

.field private _hasAudio:Z

.field private _hasClosedCaptions:Z

.field private _hasTimedMetadata:Z

.field private _internalAudioTracks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/AudioTrack;",
            ">;"
        }
    .end annotation
.end field

.field private _internalClosedCaptionsTracks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/ClosedCaptionsTrack;",
            ">;"
        }
    .end annotation
.end field

.field private _internalProfiles:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/Profile;",
            ">;"
        }
    .end annotation
.end field

.field private _internalTimedMetadatas:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/metadata/TimedMetadata;",
            ">;"
        }
    .end annotation
.end field

.field private _isDynamic:Z

.field private _isLive:Z

.field private _isProtected:Z

.field private _isTrickPlaySupported:Z

.field private _profiles:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/Profile;",
            ">;"
        }
    .end annotation
.end field

.field private _resource:Lcom/adobe/mediacore/MediaResource;

.field private _timedMetadatas:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/metadata/TimedMetadata;",
            ">;"
        }
    .end annotation
.end field

.field private _videoEngine:Lcom/adobe/ave/VideoEngine;

.field private _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/BackgroundVideoEngineItem;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/MediaResource;Lcom/adobe/mediacore/DRMMetadataCache;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/VideoEngineDispatcher;",
            "Lcom/adobe/mediacore/MediaResource;",
            "Lcom/adobe/mediacore/DRMMetadataCache;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_timedMetadatas:Ljava/util/List;

    iput-object p1, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object p2, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_resource:Lcom/adobe/mediacore/MediaResource;

    iput-object p4, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_adCueTags:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    iput-object p3, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

    return-void
.end method

.method private checkAndDispatchTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {p1}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->createBackgroundAddedEvent(Lcom/adobe/mediacore/metadata/TimedMetadata;)Lcom/adobe/mediacore/TimedMetadataAddedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    return-void
.end method

.method private isTimedMetadataAdded(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_timedMetadatas:Ljava/util/List;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private loadTimedMetadata(Lcom/adobe/ave/Timeline;)Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/ave/Timeline;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/metadata/TimedMetadata;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v2

    iget-wide v4, p1, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v2

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v6

    cmp-long v6, v6, v2

    if-gez v6, :cond_0

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0, v4}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_timedMetadatas:Ljava/util/List;

    invoke-interface {v0, v4}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    :cond_2
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v3

    sget-object v0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    sget-object v4, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "#loadTimedMetadata : # of subTag in period ["

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "] = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, v3, Lcom/adobe/ave/PeriodInfo;->lastSubscribedTagIndex:I

    iget v7, v3, Lcom/adobe/ave/PeriodInfo;->firstSubscribedTagIndex:I

    sub-int/2addr v6, v7

    add-int/lit8 v6, v6, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget v0, v3, Lcom/adobe/ave/PeriodInfo;->firstSubscribedTagIndex:I

    :goto_1
    iget v4, v3, Lcom/adobe/ave/PeriodInfo;->lastSubscribedTagIndex:I

    if-gt v0, v4, :cond_5

    invoke-virtual {p1, v2, v0}, Lcom/adobe/ave/Timeline;->getSubscribedTag(II)Lcom/adobe/ave/TagData;

    move-result-object v4

    if-eqz v4, :cond_3

    iget-object v5, v4, Lcom/adobe/ave/TagData;->data:Ljava/lang/String;

    if-eqz v5, :cond_3

    invoke-static {v4}, Lcom/adobe/mediacore/TimedMetadataParser;->parseTagData(Lcom/adobe/ave/TagData;)Lcom/adobe/mediacore/metadata/TimedMetadata;

    move-result-object v4

    if-eqz v4, :cond_3

    invoke-interface {v1, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_3

    invoke-direct {p0, v4}, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->isTimedMetadataAdded(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z

    move-result v5

    if-eqz v5, :cond_4

    :cond_3
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_4
    invoke-direct {p0, v4}, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->checkAndDispatchTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    :cond_5
    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    return-object v1
.end method

.method private updateTimedMetadata(Lcom/adobe/ave/Timeline;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->loadTimedMetadata(Lcom/adobe/ave/Timeline;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_internalTimedMetadatas:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_internalTimedMetadatas:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    iget-object v2, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_timedMetadatas:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_timedMetadatas:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_timedMetadatas:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    iput-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_hasTimedMetadata:Z

    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method public getAdTags()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_adCueTags:Ljava/util/List;

    return-object v0
.end method

.method public getAudioTracks()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/AudioTrack;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_audioTracks:Ljava/util/List;

    return-object v0
.end method

.method public getAvailablePlaybackRates()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getClosedCaptionsTracks()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/ClosedCaptionsTrack;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_closedCaptionsTracks:Ljava/util/List;

    return-object v0
.end method

.method public getDRMMetadataInfos()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/DRMMetadataInfo;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DRMMetadataCache;->getDRMMetadataInfos()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getProfiles()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/Profile;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_profiles:Ljava/util/List;

    return-object v0
.end method

.method public getResource()Lcom/adobe/mediacore/MediaResource;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_resource:Lcom/adobe/mediacore/MediaResource;

    return-object v0
.end method

.method public getSelectedAudioTrack()Lcom/adobe/mediacore/info/AudioTrack;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    return-object v0
.end method

.method public getSelectedClosedCaptionsTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    return-object v0
.end method

.method public getTimedMetadata()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/metadata/TimedMetadata;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_timedMetadatas:Ljava/util/List;

    return-object v0
.end method

.method public hasAlternateAudio()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_hasAudio:Z

    return v0
.end method

.method public hasClosedCaptions()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_hasClosedCaptions:Z

    return v0
.end method

.method public hasTimedMetadata()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_hasTimedMetadata:Z

    return v0
.end method

.method public isDynamic()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_isDynamic:Z

    return v0
.end method

.method public isLive()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_isLive:Z

    return v0
.end method

.method public isProtected()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_isProtected:Z

    return v0
.end method

.method public isTrickPlaySupported()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_isTrickPlaySupported:Z

    return v0
.end method

.method public selectAudioTrack(Lcom/adobe/mediacore/info/AudioTrack;)Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public selectClosedCaptionsTrack(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;)Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public setIsProtected(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_isProtected:Z

    return-void
.end method

.method public update(Lcom/adobe/ave/VideoEngine;)V
    .locals 4

    :try_start_0
    iput-object p1, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iget-object v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getBackgroundTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    if-eqz v1, :cond_0

    iget v0, v1, Lcom/adobe/ave/Timeline;->complete:I

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_isLive:Z

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->updateTimedMetadata(Lcom/adobe/ave/Timeline;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_1
    return-void

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#update"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "A video engine exception occurred."

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_1
.end method
