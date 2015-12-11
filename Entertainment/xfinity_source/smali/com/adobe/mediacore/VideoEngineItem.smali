.class final Lcom/adobe/mediacore/VideoEngineItem;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayerItem;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/VideoEngineItem$1;
    }
.end annotation


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

.field private _contentId:I

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

    const-class v1, Lcom/adobe/mediacore/VideoEngineItem;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/MediaResource;ILcom/adobe/mediacore/DRMMetadataCache;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/VideoEngineDispatcher;",
            "Lcom/adobe/mediacore/MediaResource;",
            "I",
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

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_timedMetadatas:Ljava/util/List;

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object p2, p0, Lcom/adobe/mediacore/VideoEngineItem;->_resource:Lcom/adobe/mediacore/MediaResource;

    iput p3, p0, Lcom/adobe/mediacore/VideoEngineItem;->_contentId:I

    iput-object p5, p0, Lcom/adobe/mediacore/VideoEngineItem;->_adCueTags:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    iput-object p4, p0, Lcom/adobe/mediacore/VideoEngineItem;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

    return-void
.end method

.method private checkAndDispatchTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {p1}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->createAddedEvent(Lcom/adobe/mediacore/metadata/TimedMetadata;)Lcom/adobe/mediacore/TimedMetadataAddedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    return-void
.end method

.method private getCurrentPeriodIndex()I
    .locals 8

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v2

    if-eqz v1, :cond_1

    iget v0, v1, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    :goto_0
    iget v4, v1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v0, v4, :cond_1

    invoke-virtual {v1, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v4

    if-eqz v4, :cond_0

    iget-wide v6, v4, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    iget-wide v4, v4, Lcom/adobe/ave/PeriodInfo;->duration:J
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    add-long/2addr v4, v6

    cmp-long v6, v6, v2

    if-gtz v6, :cond_0

    cmp-long v4, v2, v4

    if-gtz v4, :cond_0

    :goto_1
    return v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#getCurrentPeriodIndex"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to get current period index."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method private getIndexOfLastMainContentPeriod(Lcom/adobe/ave/Timeline;)I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    iget v0, p1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    :goto_0
    iget v1, p1, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p1, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v1

    if-eqz v1, :cond_0

    iget v1, v1, Lcom/adobe/ave/PeriodInfo;->userData:I

    iget v2, p0, Lcom/adobe/mediacore/VideoEngineItem;->_contentId:I

    if-ne v1, v2, :cond_0

    :goto_1
    return v0

    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method private isTimedMetadataAdded(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_timedMetadatas:Ljava/util/List;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

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

.method private loadAudioTracks(Lcom/adobe/ave/Timeline;I)Ljava/util/List;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/ave/Timeline;",
            "I)",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/AudioTrack;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    sget-object v0, Lcom/adobe/ave/PayloadType;->AUDIO:Lcom/adobe/ave/PayloadType;

    invoke-virtual {p1, p2, v0}, Lcom/adobe/ave/Timeline;->getTrackCount(ILcom/adobe/ave/PayloadType;)I

    move-result v8

    const/4 v0, 0x0

    move v6, v0

    :goto_0
    if-ge v6, v8, :cond_1

    sget-object v0, Lcom/adobe/ave/PayloadType;->AUDIO:Lcom/adobe/ave/PayloadType;

    invoke-virtual {p1, p2, v6, v0}, Lcom/adobe/ave/Timeline;->getTrackInfo(IILcom/adobe/ave/PayloadType;)Ljava/lang/Object;

    move-result-object v0

    move-object v5, v0

    check-cast v5, Lcom/adobe/ave/AudioTrackInfo;

    if-eqz v5, :cond_0

    new-instance v0, Lcom/adobe/mediacore/info/AudioTrack;

    iget-object v1, v5, Lcom/adobe/ave/AudioTrackInfo;->description:Ljava/lang/String;

    iget-object v2, v5, Lcom/adobe/ave/AudioTrackInfo;->language:Ljava/lang/String;

    iget-boolean v3, v5, Lcom/adobe/ave/AudioTrackInfo;->isDefault:Z

    iget-boolean v4, v5, Lcom/adobe/ave/AudioTrackInfo;->isAutoSelect:Z

    iget-boolean v5, v5, Lcom/adobe/ave/AudioTrackInfo;->isForced:Z

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/info/AudioTrack;-><init>(Ljava/lang/String;Ljava/lang/String;ZZZ)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    add-int/lit8 v0, v6, 0x1

    move v6, v0

    goto :goto_0

    :cond_1
    return-object v7
.end method

.method private loadClosedCaptionsTrack(Lcom/adobe/ave/Timeline;I)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/ave/Timeline;",
            "I)",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/ClosedCaptionsTrack;",
            ">;"
        }
    .end annotation

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    :try_start_0
    sget-object v1, Lcom/adobe/ave/PayloadType;->DATA:Lcom/adobe/ave/PayloadType;

    invoke-virtual {p1, p2, v1}, Lcom/adobe/ave/Timeline;->getTrackCount(ILcom/adobe/ave/PayloadType;)I

    move-result v9

    const/4 v1, 0x0

    move v7, v1

    :goto_0
    if-ge v7, v9, :cond_0

    sget-object v1, Lcom/adobe/ave/PayloadType;->DATA:Lcom/adobe/ave/PayloadType;

    invoke-virtual {p1, p2, v7, v1}, Lcom/adobe/ave/Timeline;->getTrackInfo(IILcom/adobe/ave/PayloadType;)Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Lcom/adobe/ave/DataTrackInfo;

    move-object v6, v0

    new-instance v1, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    iget-object v2, v6, Lcom/adobe/ave/DataTrackInfo;->description:Ljava/lang/String;

    iget-object v3, v6, Lcom/adobe/ave/DataTrackInfo;->serviceType:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    invoke-virtual {v3}, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->getValue()I

    move-result v3

    iget-object v4, v6, Lcom/adobe/ave/DataTrackInfo;->language:Ljava/lang/String;

    iget-boolean v5, v6, Lcom/adobe/ave/DataTrackInfo;->isDefault:Z

    iget-boolean v6, v6, Lcom/adobe/ave/DataTrackInfo;->activity:Z

    invoke-direct/range {v1 .. v6}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;-><init>(Ljava/lang/String;ILjava/lang/String;ZZ)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    add-int/lit8 v1, v7, 0x1

    move v7, v1

    goto :goto_0

    :catch_0
    move-exception v1

    sget-object v2, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#refreshClosedCaptionsTracks"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "A video engine exception occurred "

    invoke-interface {v2, v3, v4, v1}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    :cond_0
    return-object v8
.end method

.method private loadProfiles(Lcom/adobe/ave/Timeline;I)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/ave/Timeline;",
            "I)",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/info/Profile;",
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

    invoke-virtual {p1, p2}, Lcom/adobe/ave/Timeline;->getABRProfileCount(I)I

    move-result v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_1

    invoke-virtual {p1, p2, v0}, Lcom/adobe/ave/Timeline;->getABRProfileInfoAtIndex(II)Lcom/adobe/ave/ABRProfileInfo;

    move-result-object v3

    if-eqz v3, :cond_0

    new-instance v4, Lcom/adobe/mediacore/info/Profile;

    iget v5, v3, Lcom/adobe/ave/ABRProfileInfo;->bitsPerSecond:I

    iget v6, v3, Lcom/adobe/ave/ABRProfileInfo;->width:I

    iget v3, v3, Lcom/adobe/ave/ABRProfileInfo;->height:I

    invoke-direct {v4, v5, v6, v3}, Lcom/adobe/mediacore/info/Profile;-><init>(III)V

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-object v1
.end method

.method private loadTimedMetadata(Lcom/adobe/ave/Timeline;I)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/ave/Timeline;",
            "I)",
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

    invoke-virtual {p1, p2}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v2

    if-nez v2, :cond_0

    invoke-static {p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->printTimeline(Lcom/adobe/ave/Timeline;)V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#loadTimedMetadata"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not get main period info. Period index is ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]. Main period index is ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineItem;->getIndexOfLastMainContentPeriod(Lcom/adobe/ave/Timeline;)I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v4

    iget-wide v6, p1, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v4

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_1
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v8

    cmp-long v7, v8, v4

    if-gez v7, :cond_1

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_2
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_dispatchedTimedMetadata:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_timedMetadatas:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    :cond_3
    iget v0, p1, Lcom/adobe/ave/Timeline;->lastSubscribedTagIndex:I

    if-lez v0, :cond_6

    iget v0, p1, Lcom/adobe/ave/Timeline;->firstSubscribedTagIndex:I

    :goto_2
    iget v3, p1, Lcom/adobe/ave/Timeline;->lastSubscribedTagIndex:I

    if-gt v0, v3, :cond_6

    invoke-virtual {p1, v0}, Lcom/adobe/ave/Timeline;->getMainManifestSubscribedTag(I)Lcom/adobe/ave/TagData;

    move-result-object v3

    if-nez v3, :cond_5

    :cond_4
    :goto_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_5
    invoke-static {v3}, Lcom/adobe/mediacore/TimedMetadataParser;->parseTagData(Lcom/adobe/ave/TagData;)Lcom/adobe/mediacore/metadata/TimedMetadata;

    move-result-object v3

    if-eqz v3, :cond_4

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4

    invoke-direct {p0, v3}, Lcom/adobe/mediacore/VideoEngineItem;->isTimedMetadataAdded(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z

    move-result v4

    if-nez v4, :cond_4

    invoke-direct {p0, v3}, Lcom/adobe/mediacore/VideoEngineItem;->checkAndDispatchTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    :cond_6
    iget v0, v2, Lcom/adobe/ave/PeriodInfo;->firstSubscribedTagIndex:I

    :goto_4
    iget v3, v2, Lcom/adobe/ave/PeriodInfo;->lastSubscribedTagIndex:I

    if-gt v0, v3, :cond_9

    invoke-virtual {p1, p2, v0}, Lcom/adobe/ave/Timeline;->getSubscribedTag(II)Lcom/adobe/ave/TagData;

    move-result-object v3

    if-nez v3, :cond_8

    :cond_7
    :goto_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    :cond_8
    invoke-static {v3}, Lcom/adobe/mediacore/TimedMetadataParser;->parseTagData(Lcom/adobe/ave/TagData;)Lcom/adobe/mediacore/metadata/TimedMetadata;

    move-result-object v3

    if-eqz v3, :cond_7

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_7

    invoke-direct {p0, v3}, Lcom/adobe/mediacore/VideoEngineItem;->isTimedMetadataAdded(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z

    move-result v4

    if-nez v4, :cond_7

    invoke-direct {p0, v3}, Lcom/adobe/mediacore/VideoEngineItem;->checkAndDispatchTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5

    :cond_9
    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    move-object v0, v1

    goto/16 :goto_0
.end method

.method private selectTrack(Lcom/adobe/ave/Timeline;ILjava/lang/String;Lcom/adobe/ave/PayloadType;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    const/4 v1, 0x0

    invoke-virtual {p1, p2, p4}, Lcom/adobe/ave/Timeline;->getTrackCount(ILcom/adobe/ave/PayloadType;)I

    move-result v3

    move v2, v1

    :goto_0
    if-ge v2, v3, :cond_1

    invoke-virtual {p1, p2, v2, p4}, Lcom/adobe/ave/Timeline;->getTrackInfo(IILcom/adobe/ave/PayloadType;)Ljava/lang/Object;

    move-result-object v0

    sget-object v4, Lcom/adobe/mediacore/VideoEngineItem$1;->$SwitchMap$com$adobe$ave$PayloadType:[I

    invoke-virtual {p4}, Lcom/adobe/ave/PayloadType;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    :cond_0
    move v0, v1

    :goto_1
    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0, p2, p4, v2}, Lcom/adobe/ave/VideoEngine;->selectTrack(ILcom/adobe/ave/PayloadType;I)Lcom/adobe/ave/MediaErrorCode;

    :cond_1
    return-void

    :pswitch_0
    check-cast v0, Lcom/adobe/ave/DataTrackInfo;

    if-eqz v0, :cond_0

    iget-object v0, v0, Lcom/adobe/ave/DataTrackInfo;->description:Ljava/lang/String;

    invoke-virtual {v0, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_1

    :pswitch_1
    check-cast v0, Lcom/adobe/ave/AudioTrackInfo;

    if-eqz v0, :cond_0

    iget-object v0, v0, Lcom/adobe/ave/AudioTrackInfo;->description:Ljava/lang/String;

    invoke-virtual {v0, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_1

    :pswitch_2
    check-cast v0, Lcom/adobe/ave/VideoTrackInfo;

    if-eqz v0, :cond_0

    iget-object v0, v0, Lcom/adobe/ave/VideoTrackInfo;->description:Ljava/lang/String;

    invoke-virtual {v0, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_1

    :cond_2
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private selectTrackByNameAndServiceType(Lcom/adobe/ave/Timeline;ILjava/lang/String;ILcom/adobe/ave/PayloadType;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    const/4 v1, 0x0

    sget-object v0, Lcom/adobe/ave/PayloadType;->DATA:Lcom/adobe/ave/PayloadType;

    invoke-virtual {p1, p2, v0}, Lcom/adobe/ave/Timeline;->getTrackCount(ILcom/adobe/ave/PayloadType;)I

    move-result v3

    move v2, v1

    :goto_0
    if-ge v2, v3, :cond_0

    sget-object v0, Lcom/adobe/ave/PayloadType;->DATA:Lcom/adobe/ave/PayloadType;

    invoke-virtual {p1, p2, v2, v0}, Lcom/adobe/ave/Timeline;->getTrackInfo(IILcom/adobe/ave/PayloadType;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/DataTrackInfo;

    if-eqz v0, :cond_3

    iget-object v4, v0, Lcom/adobe/ave/DataTrackInfo;->description:Ljava/lang/String;

    invoke-virtual {v4, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    iget-object v0, v0, Lcom/adobe/ave/DataTrackInfo;->serviceType:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    invoke-virtual {v0}, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->getValue()I

    move-result v0

    if-ne v0, p4, :cond_1

    const/4 v0, 0x1

    :goto_1
    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0, p2, p5, v2}, Lcom/adobe/ave/VideoEngine;->selectTrack(ILcom/adobe/ave/PayloadType;I)Lcom/adobe/ave/MediaErrorCode;

    :cond_0
    return-void

    :cond_1
    move v0, v1

    goto :goto_1

    :cond_2
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    :cond_3
    move v0, v1

    goto :goto_1
.end method

.method private updateAudioTracks(Lcom/adobe/ave/Timeline;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineItem;->loadAudioTracks(Lcom/adobe/ave/Timeline;I)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalAudioTracks:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalAudioTracks:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_audioTracks:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_audioTracks:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_hasAudio:Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalAudioTracks:Ljava/util/List;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    invoke-virtual {p0, v0, v2}, Lcom/adobe/mediacore/VideoEngineItem;->updateTrack(Ljava/util/List;Lcom/adobe/mediacore/info/Track;)Lcom/adobe/mediacore/info/Track;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/AudioTrack;

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalAudioTracks:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalAudioTracks:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/AudioTrack;

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    :cond_0
    return-void

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private updateClosedCaptionsTracks(Lcom/adobe/ave/Timeline;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineItem;->loadClosedCaptionsTrack(Lcom/adobe/ave/Timeline;I)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalClosedCaptionsTracks:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalClosedCaptionsTracks:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_closedCaptionsTracks:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_closedCaptionsTracks:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_hasClosedCaptions:Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalClosedCaptionsTracks:Ljava/util/List;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    invoke-virtual {p0, v0, v2}, Lcom/adobe/mediacore/VideoEngineItem;->updateTrack(Ljava/util/List;Lcom/adobe/mediacore/info/Track;)Lcom/adobe/mediacore/info/Track;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalClosedCaptionsTracks:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalClosedCaptionsTracks:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    :cond_0
    return-void

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private updateProfiles(Lcom/adobe/ave/Timeline;I)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    const/4 v0, 0x1

    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineItem;->loadProfiles(Lcom/adobe/ave/Timeline;I)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalProfiles:Ljava/util/List;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalProfiles:Ljava/util/List;

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_profiles:Ljava/util/List;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_profiles:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-le v1, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_isDynamic:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private updateTimedMetadata(Lcom/adobe/ave/Timeline;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineItem;->loadTimedMetadata(Lcom/adobe/ave/Timeline;I)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalTimedMetadatas:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_internalTimedMetadatas:Ljava/util/List;

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

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineItem;->_timedMetadatas:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineItem;->_timedMetadatas:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_timedMetadatas:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_hasTimedMetadata:Z

    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private updateTrickPlayInfo(Lcom/adobe/ave/Timeline;I)V
    .locals 4

    :try_start_0
    invoke-virtual {p1, p2}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v0

    iget-boolean v0, v0, Lcom/adobe/ave/PeriodInfo;->supportsTrickPlay:Z

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_isTrickPlaySupported:Z
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#updateTrickPlayInfo"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "A video engine exception occurred "

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
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

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_adCueTags:Ljava/util/List;

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

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_audioTracks:Ljava/util/List;

    return-object v0
.end method

.method public getAvailablePlaybackRates()Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation

    const/high16 v6, 0x3f800000    # 1.0f

    const/high16 v5, 0x3f400000    # 0.75f

    const/high16 v4, 0x3f000000    # 0.5f

    const/high16 v3, 0x3e800000    # 0.25f

    const/4 v2, 0x0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineItem;->isTrickPlaySupported()Z

    move-result v1

    if-eqz v1, :cond_0

    const/high16 v1, -0x3d000000    # -128.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, -0x3d800000    # -64.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, -0x3e000000    # -32.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, -0x3e800000    # -16.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, -0x3f000000    # -8.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, -0x3f800000    # -4.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, -0x40000000    # -2.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, 0x40000000    # 2.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, 0x40800000    # 4.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, 0x41000000    # 8.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, 0x41800000    # 16.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, 0x42000000    # 32.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, 0x42800000    # 64.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/high16 v1, 0x43000000    # 128.0f

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :goto_0
    return-object v0

    :cond_0
    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
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

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_closedCaptionsTracks:Ljava/util/List;

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

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

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

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_profiles:Ljava/util/List;

    return-object v0
.end method

.method public getResource()Lcom/adobe/mediacore/MediaResource;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_resource:Lcom/adobe/mediacore/MediaResource;

    return-object v0
.end method

.method public getSelectedAudioTrack()Lcom/adobe/mediacore/info/AudioTrack;
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_audioTracks:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_audioTracks:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/AudioTrack;

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSelectedClosedCaptionsTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_closedCaptionsTracks:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_closedCaptionsTracks:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
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

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_timedMetadatas:Ljava/util/List;

    return-object v0
.end method

.method public hasAlternateAudio()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_hasAudio:Z

    return v0
.end method

.method public hasClosedCaptions()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_hasClosedCaptions:Z

    return v0
.end method

.method public hasTimedMetadata()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_hasTimedMetadata:Z

    return v0
.end method

.method public isDynamic()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_isDynamic:Z

    return v0
.end method

.method public isLive()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_isLive:Z

    return v0
.end method

.method public isProtected()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_isProtected:Z

    return v0
.end method

.method public isTrickPlaySupported()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_isTrickPlaySupported:Z

    return v0
.end method

.method public refreshClosedCaptionsTracks(Lcom/adobe/ave/VideoEngine;)V
    .locals 4

    :try_start_0
    invoke-virtual {p1}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/VideoEngineItem;->getIndexOfLastMainContentPeriod(Lcom/adobe/ave/Timeline;)I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    invoke-direct {p0, v0, v1}, Lcom/adobe/mediacore/VideoEngineItem;->updateClosedCaptionsTracks(Lcom/adobe/ave/Timeline;I)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#refreshClosedCaptionsTracks"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "A video engine exception occurred "

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public selectAudioTrack(Lcom/adobe/mediacore/info/AudioTrack;)Z
    .locals 5

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    sget-object v0, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    sget-object v1, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Selected audio track ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x1

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentAudioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    invoke-virtual {v1}, Lcom/adobe/mediacore/info/AudioTrack;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v3

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineItem;->getCurrentPeriodIndex()I

    move-result v1

    const/4 v4, -0x1

    if-eq v1, v4, :cond_0

    sget-object v4, Lcom/adobe/ave/PayloadType;->AUDIO:Lcom/adobe/ave/PayloadType;

    invoke-direct {p0, v3, v1, v2, v4}, Lcom/adobe/mediacore/VideoEngineItem;->selectTrack(Lcom/adobe/ave/Timeline;ILjava/lang/String;Lcom/adobe/ave/PayloadType;)V

    :cond_0
    if-eqz v3, :cond_1

    iget v1, v3, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    :goto_0
    iget v4, v3, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v1, v4, :cond_1

    sget-object v4, Lcom/adobe/ave/PayloadType;->AUDIO:Lcom/adobe/ave/PayloadType;

    invoke-direct {p0, v3, v1, v2, v4}, Lcom/adobe/mediacore/VideoEngineItem;->selectTrack(Lcom/adobe/ave/Timeline;ILjava/lang/String;Lcom/adobe/ave/PayloadType;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :cond_1
    return v0
.end method

.method public selectClosedCaptionsTrack(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;)Z
    .locals 7

    sget-object v0, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#selectClosedCaptionsTrack"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Selecting CC track: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    const/4 v6, 0x1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_currentClosedCaptionsTrack:Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->getServiceType()I

    move-result v4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    if-eqz v1, :cond_0

    iget v2, v1, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    :goto_0
    iget v0, v1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v2, v0, :cond_0

    sget-object v5, Lcom/adobe/ave/PayloadType;->DATA:Lcom/adobe/ave/PayloadType;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/VideoEngineItem;->selectTrackByNameAndServiceType(Lcom/adobe/ave/Timeline;ILjava/lang/String;ILcom/adobe/ave/PayloadType;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    move v0, v6

    :goto_1
    return v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#refreshClosedCaptionsTracks"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "A video engine exception occurred "

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    const/4 v0, 0x0

    goto :goto_1
.end method

.method public setIsProtected(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_isProtected:Z

    return-void
.end method

.method public update(Lcom/adobe/ave/VideoEngine;)V
    .locals 4

    :try_start_0
    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    if-eqz v1, :cond_0

    iget v0, v1, Lcom/adobe/ave/Timeline;->complete:I

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_isLive:Z

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/VideoEngineItem;->getIndexOfLastMainContentPeriod(Lcom/adobe/ave/Timeline;)I

    move-result v0

    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    invoke-direct {p0, v1, v0}, Lcom/adobe/mediacore/VideoEngineItem;->updateProfiles(Lcom/adobe/ave/Timeline;I)V

    invoke-direct {p0, v1, v0}, Lcom/adobe/mediacore/VideoEngineItem;->updateAudioTracks(Lcom/adobe/ave/Timeline;I)V

    invoke-direct {p0, v1, v0}, Lcom/adobe/mediacore/VideoEngineItem;->updateClosedCaptionsTracks(Lcom/adobe/ave/Timeline;I)V

    invoke-direct {p0, v1, v0}, Lcom/adobe/mediacore/VideoEngineItem;->updateTimedMetadata(Lcom/adobe/ave/Timeline;I)V

    invoke-direct {p0, v1, v0}, Lcom/adobe/mediacore/VideoEngineItem;->updateTrickPlayInfo(Lcom/adobe/ave/Timeline;I)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineItem;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineItem;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v2}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Lcom/adobe/mediacore/DRMMetadataCache;->update(Lcom/adobe/ave/Timeline;J)V
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

    sget-object v1, Lcom/adobe/mediacore/VideoEngineItem;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineItem;->LOG_TAG:Ljava/lang/String;

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

.method public updateTrack(Ljava/util/List;Lcom/adobe/mediacore/info/Track;)Lcom/adobe/mediacore/info/Track;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/adobe/mediacore/info/Track;",
            ">(",
            "Ljava/util/List",
            "<TT;>;TT;)TT;"
        }
    .end annotation

    const/4 v2, 0x0

    if-eqz p2, :cond_3

    invoke-virtual {p2}, Lcom/adobe/mediacore/info/Track;->getName()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    :goto_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/Track;

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/Track;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    :cond_1
    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/Track;->isDefault()Z

    move-result v4

    if-eqz v4, :cond_0

    :cond_2
    :goto_1
    return-object v0

    :cond_3
    move-object v1, v2

    goto :goto_0

    :cond_4
    move-object v0, v2

    goto :goto_1
.end method
