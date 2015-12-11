.class final Lcom/adobe/mediacore/VideoEngineAdapter;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/VideoEngineAdapter$2;,
        Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    }
.end annotation


# static fields
.field private static final AUDIO:Ljava/lang/String; = "AUDIO"

.field private static final DICTIONARY_TYPE:Ljava/lang/String; = "_dictionaryType"

.field private static final ID3:Ljava/lang/String; = "ID3"

.field private static final INITIAL_BUFFER_TIME:J = 0x7d0L

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final PLAY_BUFFER_TIME:J = 0x7530L

.field private static final UNKNOWN_CONTENT_ID:I = -0x1

.field private static final UNKNOWN_PERIOD_INDEX:I = -0x1

.field private static final _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private _adTags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private _alreadyReleased:Z

.field private _backgroundMediaResource:Lcom/adobe/mediacore/MediaResource;

.field private _backgroundVideoEngineItem:Lcom/adobe/mediacore/BackgroundVideoEngineItem;

.field private _contentId:I

.field private _context:Landroid/content/Context;

.field private _desiredABRControlParameters:Lcom/adobe/mediacore/ABRControlParameters;

.field private _desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

.field private _desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

.field private _desiredCaptionsVisibility:Lcom/adobe/mediacore/MediaPlayer$Visibility;

.field private _desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

.field private _desiredVolume:I

.field private _drmManager:Lcom/adobe/ave/drm/DRMManager;

.field private _drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

.field private _hasSurface:Z

.field private _isBuffering:Z

.field private _isInitialised:Z

.field private _isProtected:Z

.field private _isSeeking:Z

.field private _isTempBuffer:Z

.field private _lastKnownContentId:I

.field private _lastKnownProfile:J

.field private _lastKnownTime:J

.field private _mediaResource:Lcom/adobe/mediacore/MediaResource;

.field private final _pendingOperations:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/PlayerOperation;",
            ">;"
        }
    .end annotation
.end field

.field private _playerState:Lcom/adobe/ave/PlayState;

.field private _timelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

.field private _videoEngine:Lcom/adobe/ave/VideoEngine;

.field private _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

.field private _videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

.field private _videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

.field private _videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

.field private _videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/adobe/mediacore/VideoEngineDispatcher;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundMediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->getDefaultBufferingParameters()Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    iput-boolean v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isTempBuffer:Z

    iput-boolean v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine context parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez p2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine dispatcher parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_context:Landroid/content/Context;

    iput-object p2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v0, Lcom/adobe/mediacore/DRMMetadataCache;

    invoke-direct {v0}, Lcom/adobe/mediacore/DRMMetadataCache;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->resetState()V

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/adobe/mediacore/VideoEngineAdapter;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z

    return v0
.end method

.method static synthetic access$1002(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z

    return p1
.end method

.method static synthetic access$1100(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BufferControlParameters;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/adobe/mediacore/VideoEngineAdapter;J)V
    .locals 1

    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineAdapter;->setBufferTime(J)V

    return-void
.end method

.method static synthetic access$1300(Lcom/adobe/mediacore/VideoEngineAdapter;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isTempBuffer:Z

    return v0
.end method

.method static synthetic access$1302(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isTempBuffer:Z

    return p1
.end method

.method static synthetic access$1400(Lcom/adobe/mediacore/VideoEngineAdapter;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->checkAndDispatchBufferingComplete()V

    return-void
.end method

.method static synthetic access$1500(Lcom/adobe/mediacore/VideoEngineAdapter;)I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I

    return v0
.end method

.method static synthetic access$1502(Lcom/adobe/mediacore/VideoEngineAdapter;I)I
    .locals 0

    iput p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I

    return p1
.end method

.method static synthetic access$1600(Lcom/adobe/mediacore/VideoEngineAdapter;J)I
    .locals 1

    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineAdapter;->getContentIdByTime(J)I

    move-result v0

    return v0
.end method

.method static synthetic access$1700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    return-object v0
.end method

.method static synthetic access$1702(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/VideoEngineTimeline;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    return-object p1
.end method

.method static synthetic access$1800(Lcom/adobe/mediacore/VideoEngineAdapter;)J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownProfile:J

    return-wide v0
.end method

.method static synthetic access$1802(Lcom/adobe/mediacore/VideoEngineAdapter;J)J
    .locals 1

    iput-wide p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownProfile:J

    return-wide p1
.end method

.method static synthetic access$1900(Lcom/adobe/mediacore/VideoEngineAdapter;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isProtected:Z

    return v0
.end method

.method static synthetic access$1902(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isProtected:Z

    return p1
.end method

.method static synthetic access$200()Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/DRMMetadataCache;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/adobe/mediacore/VideoEngineAdapter;)Z
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->isAveTimelineValid()Z

    move-result v0

    return v0
.end method

.method static synthetic access$2202(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_alreadyReleased:Z

    return p1
.end method

.method static synthetic access$2300(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineItem;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    return-object v0
.end method

.method static synthetic access$2302(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineItem;)Lcom/adobe/mediacore/VideoEngineItem;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    return-object p1
.end method

.method static synthetic access$2400(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/MediaResource;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    return-object v0
.end method

.method static synthetic access$2500(Lcom/adobe/mediacore/VideoEngineAdapter;)I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_contentId:I

    return v0
.end method

.method static synthetic access$2600(Lcom/adobe/mediacore/VideoEngineAdapter;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_adTags:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$2700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/MediaResource;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundMediaResource:Lcom/adobe/mediacore/MediaResource;

    return-object v0
.end method

.method static synthetic access$2800(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BackgroundVideoEngineItem;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundVideoEngineItem:Lcom/adobe/mediacore/BackgroundVideoEngineItem;

    return-object v0
.end method

.method static synthetic access$2802(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/BackgroundVideoEngineItem;)Lcom/adobe/mediacore/BackgroundVideoEngineItem;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundVideoEngineItem:Lcom/adobe/mediacore/BackgroundVideoEngineItem;

    return-object p1
.end method

.method static synthetic access$2900(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/metadata/Metadata;)Z
    .locals 1

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->shouldUseContentCache(Lcom/adobe/mediacore/metadata/Metadata;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;
    .locals 1

    invoke-static {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->createLoadInformationFrom(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$3002(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isInitialised:Z

    return p1
.end method

.method static synthetic access$3100(Lcom/adobe/mediacore/VideoEngineAdapter;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isSeeking:Z

    return v0
.end method

.method static synthetic access$3102(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isSeeking:Z

    return p1
.end method

.method static synthetic access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    return-object v0
.end method

.method static synthetic access$3300(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)J
    .locals 2

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->calculateVirtualTime(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$3400(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/ave/Dictionary;)Z
    .locals 1

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->isID3Dictionary(Lcom/adobe/ave/Dictionary;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$3500(Lcom/adobe/mediacore/VideoEngineAdapter;)J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->extractVirtualTime()J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;
    .locals 1

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getFileLoadErrorNotification(Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/qos/LoadInfo;)Z
    .locals 1

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->handleAudioTrackError(Lcom/adobe/mediacore/qos/LoadInfo;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    return-object v0
.end method

.method static synthetic access$700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_timelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    return-object v0
.end method

.method static synthetic access$802(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/ave/PlayState;)Lcom/adobe/ave/PlayState;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_playerState:Lcom/adobe/ave/PlayState;

    return-object p1
.end method

.method static synthetic access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    return-object v0
.end method

.method private calculateVirtualTime(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)J
    .locals 8

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    :try_start_0
    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v2}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    iget-wide v6, v2, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    sub-long/2addr v4, v6

    iget-wide v0, v2, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    add-long/2addr v0, v4

    :cond_0
    :goto_0
    return-wide v0

    :catch_0
    move-exception v2

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#calculateVirtualTime"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Exception raised while accessing the timeline { code = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v2}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", description = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v2}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, " }"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v3, v4, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private checkAndDispatchBufferingComplete()V
    .locals 3

    const/4 v2, 0x0

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isSeeking:Z

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iput-boolean v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isTempBuffer:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    invoke-virtual {v0}, Lcom/adobe/mediacore/BufferControlParameters;->getPlayBufferTime()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setBufferTime(J)V

    iput-boolean v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isTempBuffer:Z

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method private convertOpacity(I)Ljava/lang/String;
    .locals 1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    const-string v0, "default"

    :goto_0
    return-object v0

    :cond_0
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private convertType(Lcom/adobe/mediacore/MediaResource$Type;)Lcom/adobe/ave/ContainerType;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaResource$Type;->HDS:Lcom/adobe/mediacore/MediaResource$Type;

    if-ne p1, v0, :cond_0

    sget-object v0, Lcom/adobe/ave/ContainerType;->F4M:Lcom/adobe/ave/ContainerType;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    if-ne p1, v0, :cond_1

    sget-object v0, Lcom/adobe/ave/ContainerType;->HLS:Lcom/adobe/ave/ContainerType;

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/adobe/ave/ContainerType;->UNDEFINED:Lcom/adobe/ave/ContainerType;

    goto :goto_0
.end method

.method private createEngineListener()Lcom/adobe/ave/VideoEngineListener;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/VideoEngineAdapter$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/VideoEngineAdapter$1;-><init>(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    return-object v0
.end method

.method private static createLoadInformationFrom(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;
    .locals 18

    invoke-static/range {p0 .. p0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    const-string v3, "url"

    const-string v2, "rendition url"

    const-string v4, "sizeBytes"

    const-string v6, "downloadTime(ms)"

    const-string v7, "mediaDuration(ms)"

    const-string v10, "periodIndex"

    const-string v13, "trackType"

    const-string v14, "trackName"

    const-string v15, "trackIndex"

    const-string v5, ","

    const-string v8, "::="

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v5, v8}, Lcom/adobe/mediacore/utils/StringUtils;->extractFromString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v2

    move-object v11, v2

    check-cast v11, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-virtual {v11, v3}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    const/4 v2, 0x0

    goto :goto_0

    :cond_1
    invoke-virtual {v11, v3}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual {v11, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual {v11, v13}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#getFileLoadInfo"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Manifest load info parsed for url ["

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "]"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2}, Lcom/adobe/mediacore/qos/LoadInfo;->createManifestLoadInformation(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v2

    goto :goto_0

    :cond_2
    invoke-virtual {v11, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-wide/16 v4, 0x0

    invoke-static {v3, v4, v5}, Lcom/adobe/mediacore/utils/NumberUtils;->parseLong(Ljava/lang/String;J)J

    move-result-wide v4

    invoke-virtual {v11, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-wide/16 v8, 0x0

    invoke-static {v3, v8, v9}, Lcom/adobe/mediacore/utils/NumberUtils;->parseLong(Ljava/lang/String;J)J

    move-result-wide v8

    invoke-virtual {v11, v7}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-wide/16 v6, 0x0

    invoke-static {v3, v6, v7}, Lcom/adobe/mediacore/utils/NumberUtils;->parseLong(Ljava/lang/String;J)J

    move-result-wide v6

    invoke-virtual {v11, v10}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-wide/16 v16, 0x0

    move-wide/from16 v0, v16

    invoke-static {v3, v0, v1}, Lcom/adobe/mediacore/utils/NumberUtils;->parseLong(Ljava/lang/String;J)J

    move-result-wide v16

    move-wide/from16 v0, v16

    long-to-int v3, v0

    invoke-virtual {v11, v14}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_3

    sget-object v10, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v12, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "#getFileLoadInfo"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Video load info parsed for url ["

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "]"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-interface {v10, v11, v12}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static/range {v2 .. v9}, Lcom/adobe/mediacore/qos/LoadInfo;->createFragmentLoadInformation(Ljava/lang/String;IJJJ)Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v2

    goto/16 :goto_0

    :cond_3
    const/4 v12, 0x0

    :try_start_0
    invoke-virtual {v11, v15}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const-wide/16 v16, 0x0

    move-wide/from16 v0, v16

    invoke-static {v10, v0, v1}, Lcom/adobe/mediacore/utils/NumberUtils;->parseNumber(Ljava/lang/String;J)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v16

    move-wide/from16 v0, v16

    long-to-int v12, v0

    :goto_1
    sget-object v10, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v16, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "#getFileLoadInfo"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Audio load info parsed for url ["

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "]"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-interface {v10, v15, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v11, v14}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v11, v13}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-static/range {v2 .. v12}, Lcom/adobe/mediacore/qos/LoadInfo;->createTrackLoadInformation(Ljava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;I)Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v2

    goto/16 :goto_0

    :catch_0
    move-exception v10

    goto :goto_1
.end method

.method private encodeToHTTPHeader(Lcom/adobe/mediacore/metadata/Metadata;)Ljava/lang/String;
    .locals 5

    const-string v1, ""

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/adobe/mediacore/metadata/Metadata;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {p1}, Lcom/adobe/mediacore/metadata/Metadata;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {p1, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    invoke-static {v3}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "; "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_1
    move-object v1, v0

    goto :goto_0

    :cond_0
    return-object v1

    :cond_1
    move-object v0, v1

    goto :goto_1
.end method

.method private extractVirtualTime()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-wide v0, v0, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    goto :goto_0
.end method

.method private getContentIdByTime(J)I
    .locals 9

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    if-eqz v1, :cond_1

    iget v0, v1, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    iget v2, v1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    add-int/lit8 v2, v2, 0x1

    :goto_0
    if-ge v0, v2, :cond_1

    invoke-virtual {v1, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-wide v4, v3, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    iget-wide v6, v3, Lcom/adobe/ave/PeriodInfo;->duration:J

    add-long/2addr v6, v4

    cmp-long v4, v4, p1

    if-gtz v4, :cond_0

    cmp-long v4, p1, v6

    if-gtz v4, :cond_0

    iget v0, v3, Lcom/adobe/ave/PeriodInfo;->userData:I
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    return v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PERIOD_INFO_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Get period info operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method static getDefaultBufferingParameters()Lcom/adobe/mediacore/BufferControlParameters;
    .locals 4

    const-wide/16 v0, 0x7d0

    const-wide/16 v2, 0x7530

    invoke-static {v0, v1, v2, v3}, Lcom/adobe/mediacore/BufferControlParameters;->createDual(JJ)Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v0

    return-object v0
.end method

.method private getFileLoadErrorNotification(Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;
    .locals 5

    const/4 v0, 0x0

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->DOWNLOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "An error has occurred while attempting to download data."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "URL"

    invoke-virtual {p1}, Lcom/adobe/mediacore/qos/LoadInfo;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter$2;->$SwitchMap$com$adobe$mediacore$qos$LoadInfo$Type:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/qos/LoadInfo;->getType()Lcom/adobe/mediacore/qos/LoadInfo$Type;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/qos/LoadInfo$Type;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    :goto_1
    if-eqz v0, :cond_0

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setInnerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    goto :goto_0

    :pswitch_0
    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->MANIFEST_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "An error has occurred while downloading a manifest."

    invoke-static {v0, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    goto :goto_1

    :pswitch_1
    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->CONTENT_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "An error has occurred while downloading a fragment."

    invoke-static {v0, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private getPeriodById(I)Lcom/adobe/ave/PeriodInfo;
    .locals 5

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v2

    if-eqz v2, :cond_1

    iget v0, v2, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    iget v1, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    add-int/lit8 v3, v1, 0x1

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    invoke-virtual {v2, v1}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    iget v4, v0, Lcom/adobe/ave/PeriodInfo;->userData:I
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    if-ne v4, p1, :cond_0

    :goto_1
    return-object v0

    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PERIOD_INFO_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Get period info operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private getUrl(Lcom/adobe/mediacore/MediaResource;)Ljava/lang/String;
    .locals 2

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method private handleAudioTrackError(Lcom/adobe/mediacore/qos/LoadInfo;)Z
    .locals 5

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/qos/LoadInfo;->getType()Lcom/adobe/mediacore/qos/LoadInfo$Type;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/qos/LoadInfo$Type;->TRACK:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    if-eq v1, v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string v1, "AUDIO"

    invoke-virtual {p1}, Lcom/adobe/mediacore/qos/LoadInfo;->getTrackType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineItem;->getAudioTracks()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/AudioTrack;

    invoke-virtual {v0}, Lcom/adobe/mediacore/info/AudioTrack;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/qos/LoadInfo;->getTrackName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    :goto_1
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v0}, Lcom/adobe/mediacore/AudioTrackEvent;->createAudioTrackFailedEvent(Lcom/adobe/mediacore/info/AudioTrack;)Lcom/adobe/mediacore/AudioTrackEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_3
    const/4 v0, 0x1

    goto :goto_0

    :cond_4
    move-object v0, v1

    goto :goto_1
.end method

.method private isAdPeriod(Lcom/adobe/ave/PeriodInfo;)Z
    .locals 4

    iget v1, p1, Lcom/adobe/ave/PeriodInfo;->userData:I

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v0

    if-ne v0, v1, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isAveTimelineValid()Z
    .locals 5

    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onTimeline"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "VideoEngine timeline is null. Ignoring event."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return v0

    :catch_0
    move-exception v1

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#onTimeline"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Exception while trying to read VideoEngine timeline."

    invoke-interface {v2, v3, v4, v1}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0

    :cond_0
    invoke-direct {p0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->showDebuggingInformation(Lcom/adobe/ave/Timeline;)V

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private isID3Dictionary(Lcom/adobe/ave/Dictionary;)Z
    .locals 5

    const/4 v0, 0x0

    :try_start_0
    const-string v1, "_dictionaryType"

    invoke-virtual {p1, v1}, Lcom/adobe/ave/Dictionary;->getValueByKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    const-string v2, "ID3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v1

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#isID3Dictionary"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Video engine exception raised while accesing the dictionary"

    invoke-interface {v2, v3, v4, v1}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method private preventSeekAtClientLivePoint(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Z
    .locals 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    :try_start_0
    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v2}, Lcom/adobe/ave/VideoEngine;->getTime()J
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    iget-boolean v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isInitialised:Z

    if-nez v4, :cond_0

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/VideoEngineItem;->isLive()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    cmp-long v2, v4, v2

    if-nez v2, :cond_0

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isInitialised:Z

    :goto_0
    return v0

    :catch_0
    move-exception v0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#preventSeekAtClientLivePoint"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Unable to retrive current time from video engine"

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto :goto_0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method static printLivePlaybackWindowState(Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;)V
    .locals 9

    if-eqz p0, :cond_1

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getTime()J

    move-result-wide v2

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getReadHead()J

    move-result-wide v4

    if-eqz v0, :cond_0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "#printLivePlaybackWindowState"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "PlaybackRange = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v6, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "#printLivePlaybackWindowState"

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Current time = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "; read head = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_1
    return-void

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "#printLivePlaybackWindowState"

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v6, "Cannot print playback range"

    invoke-interface {v0, v1, v6}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#printLivePlaybackWindowState"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Cannot print playback metrics"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private resetState()V
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x0

    iput-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iput-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isSeeking:Z

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isInitialised:Z

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isProtected:Z

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DRMMetadataCache;->reset()V

    const/4 v0, -0x1

    iput v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownTime:J

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_alreadyReleased:Z

    return-void
.end method

.method private setBufferTime(J)V
    .locals 5

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/ave/VideoEngine;->setBufferTime(J)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_BUFFER_TIME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Set buffer time operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "PLAY_BUFFER_TIME"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v0, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method private shouldUseContentCache(Lcom/adobe/mediacore/metadata/Metadata;)Z
    .locals 3

    const/4 v0, 0x1

    if-eqz p1, :cond_0

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->DISABLE_CONTENT_CACHING:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->DISABLE_CONTENT_CACHING:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "true"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private showDebuggingInformation(Lcom/adobe/ave/Timeline;)V
    .locals 3

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#showDebuggingInformation"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Displaying debug information."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->printTimeline(Lcom/adobe/ave/Timeline;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->printLivePlaybackWindowState(Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;)V

    return-void
.end method


# virtual methods
.method public convertToLocalTime(J)J
    .locals 9

    :try_start_0
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineItem;->isLive()Z

    move-result v1

    if-nez v1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne v0, v1, :cond_2

    :cond_1
    :goto_0
    return-wide p1

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v3

    const/4 v1, 0x0

    if-eqz v3, :cond_7

    iget v0, v3, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    :goto_1
    iget v2, v3, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v0, v2, :cond_7

    invoke-virtual {v3, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v2

    if-eqz v2, :cond_3

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->isAdPeriod(Lcom/adobe/ave/PeriodInfo;)Z

    move-result v4

    if-nez v4, :cond_3

    move-object v1, v2

    :cond_3
    if-eqz v2, :cond_6

    iget-wide v4, v2, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    iget-wide v6, v2, Lcom/adobe/ave/PeriodInfo;->duration:J

    add-long/2addr v6, v4

    cmp-long v8, v4, p1

    if-gtz v8, :cond_6

    cmp-long v6, p1, v6

    if-gtz v6, :cond_6

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->isAdPeriod(Lcom/adobe/ave/PeriodInfo;)Z

    move-result v6

    if-nez v6, :cond_4

    sub-long v0, p1, v4

    iget-wide v2, v2, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    add-long p1, v2, v0

    goto :goto_0

    :cond_4
    if-eqz v1, :cond_5

    iget-wide v2, v1, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    iget-wide v0, v1, Lcom/adobe/ave/PeriodInfo;->duration:J
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    add-long p1, v2, v0

    goto :goto_0

    :cond_5
    if-nez v1, :cond_6

    const-wide/16 p1, 0x0

    goto :goto_0

    :cond_6
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#convertToLocalTime"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Exception raised while trying to access the timeline "

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    :cond_7
    const-wide/16 p1, -0x1

    goto :goto_0
.end method

.method protected createVideoEngineTimelineProxy()Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    .locals 5

    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    new-instance v1, Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-direct {v1, v0, v2}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;-><init>(Lcom/adobe/ave/Timeline;Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;)V

    iput-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_timelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_timelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    return-object v0

    :catch_0
    move-exception v1

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#createVideoEngineTimelineProxy"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "VideoException raised while accesing the timeline"

    invoke-interface {v2, v3, v4, v1}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public enableTrickPlay(FZ)V
    .locals 5

    const/high16 v3, -0x40800000    # -1.0f

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    if-nez v0, :cond_1

    new-instance v0, Lcom/adobe/mediacore/TrickPlayOperation;

    invoke-direct {v0, p1, p2}, Lcom/adobe/mediacore/TrickPlayOperation;-><init>(FZ)V

    invoke-virtual {v0, p0}, Lcom/adobe/mediacore/TrickPlayOperation;->setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getPlayState()Lcom/adobe/ave/PlayState;

    move-result-object v0

    sget-object v1, Lcom/adobe/ave/PlayState;->SUSPENDED:Lcom/adobe/ave/PlayState;

    if-ne v0, v1, :cond_2

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->play()V

    :cond_2
    if-eqz p2, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeAdsOnSourceTimeline()V

    :cond_3
    const/4 v0, 0x0

    cmpl-float v0, p1, v0

    if-lez v0, :cond_4

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#enableTrickPlay"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "transitioning to fast forward"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngine;->fastForward(F)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->TRICKPLAY_RATE_CHANGE_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v2, "Playback rate change failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0

    :cond_4
    cmpg-float v0, p1, v3

    if-gez v0, :cond_5

    :try_start_1
    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#enableTrickPlay"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "transitioning to fast rewind"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    mul-float v1, v3, p1

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngine;->rewind(F)V

    goto/16 :goto_0

    :cond_5
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Rate [{0}] is not allowed in this version.}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0
.end method

.method public getABRControlParameters()Lcom/adobe/mediacore/ABRControlParameters;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredABRControlParameters:Lcom/adobe/mediacore/ABRControlParameters;

    return-object v0
.end method

.method public getBufferControlParameters()Lcom/adobe/mediacore/BufferControlParameters;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    return-object v0
.end method

.method public getCaptionsControlParameters()Lcom/adobe/mediacore/TextFormat;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    return-object v0
.end method

.method public getCaptionsVisibility()Lcom/adobe/mediacore/MediaPlayer$Visibility;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsVisibility:Lcom/adobe/mediacore/MediaPlayer$Visibility;

    return-object v0
.end method

.method public getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    return-object v0
.end method

.method public getCurrentTime()J
    .locals 4

    const-wide/16 v0, 0x0

    :try_start_0
    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    if-eqz v2, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTime()J
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    :cond_0
    :goto_0
    return-wide v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RETRIEVE_TIME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Get client live point operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_1
    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownTime:J

    goto :goto_0
.end method

.method public getDRMManager()Lcom/adobe/ave/drm/DRMManager;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    return-object v0
.end method

.method public getLocalTime()J
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertToLocalTime(J)J
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    :goto_0
    return-wide v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#getLocalTime"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Exception raised while trying to access the timeline "

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    return-object v0
.end method

.method protected getPlayerState()Lcom/adobe/ave/PlayState;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_playerState:Lcom/adobe/ave/PlayState;

    return-object v0
.end method

.method getRawTimeline()Lcom/adobe/ave/Timeline;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public getTimeline()Lcom/adobe/mediacore/VideoEngineTimeline;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    return-object v0
.end method

.method public getVirtualTimeForLocalTime(J)J
    .locals 9

    :try_start_0
    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineItem;->isLive()Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-wide p1

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    if-eqz v1, :cond_2

    iget v0, v1, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    :goto_1
    iget v2, v1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v0, v2, :cond_2

    invoke-virtual {v1, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-wide v4, v2, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    iget-wide v6, v2, Lcom/adobe/ave/PeriodInfo;->duration:J

    add-long/2addr v6, v4

    cmp-long v3, v4, p1

    if-gtz v3, :cond_1

    cmp-long v3, p1, v6

    if-gtz v3, :cond_1

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->isAdPeriod(Lcom/adobe/ave/PeriodInfo;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-wide v0, v2, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    sub-long v2, p1, v4

    add-long p1, v0, v2

    goto :goto_0

    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#getVirtualTimeForLocalTime"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Unable to get virtual time for this local time. "

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    :cond_2
    const-wide/16 p1, 0x0

    goto :goto_0
.end method

.method public getVolume()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredVolume:I

    return v0
.end method

.method hasAllDataBuffered()Z
    .locals 6

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    invoke-virtual {v2}, Lcom/adobe/mediacore/VideoEngineItem;->isLive()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getTime()J

    move-result-wide v2

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getBufferLength()J

    move-result-wide v4

    add-long/2addr v2, v4

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/utils/TimeRange;->getDuration()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getBufferLength()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-lez v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public initialize()V
    .locals 4

    :try_start_0
    new-instance v0, Lcom/adobe/ave/VideoEngine;

    invoke-direct {v0}, Lcom/adobe/ave/VideoEngine;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->createEngineListener()Lcom/adobe/ave/VideoEngineListener;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    sget-object v0, Lcom/adobe/ave/ListenerType;->ERROR:Lcom/adobe/ave/ListenerType;

    const/16 v1, 0xe

    new-array v1, v1, [Lcom/adobe/ave/ListenerType;

    const/4 v2, 0x0

    sget-object v3, Lcom/adobe/ave/ListenerType;->PLAY_STATE:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    sget-object v3, Lcom/adobe/ave/ListenerType;->STREAM_SWITCH:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    sget-object v3, Lcom/adobe/ave/ListenerType;->STREAM_METADATA:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    sget-object v3, Lcom/adobe/ave/ListenerType;->DRM_METADATA:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/4 v2, 0x4

    sget-object v3, Lcom/adobe/ave/ListenerType;->TIMELINE:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/4 v2, 0x5

    sget-object v3, Lcom/adobe/ave/ListenerType;->DATA:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/4 v2, 0x6

    sget-object v3, Lcom/adobe/ave/ListenerType;->MANIFEST_LOAD:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/4 v2, 0x7

    sget-object v3, Lcom/adobe/ave/ListenerType;->LOAD_INFO:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/16 v2, 0x8

    sget-object v3, Lcom/adobe/ave/ListenerType;->SEEK_COMPLETE:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/16 v2, 0x9

    sget-object v3, Lcom/adobe/ave/ListenerType;->WARNING:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/16 v2, 0xa

    sget-object v3, Lcom/adobe/ave/ListenerType;->DICTIONARY_DATA:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/16 v2, 0xb

    sget-object v3, Lcom/adobe/ave/ListenerType;->DRM_ERROR:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/16 v2, 0xc

    sget-object v3, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_ERROR:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    const/16 v2, 0xd

    sget-object v3, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/ave/ListenerType;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/util/EnumSet;->of(Ljava/lang/Enum;[Ljava/lang/Enum;)Ljava/util/EnumSet;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    invoke-virtual {v1, v0, v2}, Lcom/adobe/ave/VideoEngine;->addListener(Ljava/util/Set;Lcom/adobe/ave/VideoEngineListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_context:Landroid/content/Context;

    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->getSharedManager(Landroid/content/Context;)Lcom/adobe/ave/drm/DRMManager;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngine;->setDRMManager(Lcom/adobe/ave/drm/DRMManager;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1, v0}, Lcom/adobe/ave/VideoEngine;->setLocalStoragePath(Ljava/lang/String;)V

    new-instance v0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;-><init>(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_CREATION_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Unexpected error while creating the video engine."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public injectData(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;[B)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    if-nez p2, :cond_0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#injectData"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Input data object is null."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->calculateVirtualTime(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)J

    move-result-wide v2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    sget-object v1, Lcom/adobe/ave/DataType;->DT_AMF:Lcom/adobe/ave/DataType;

    array-length v5, p2

    move-object v4, p2

    invoke-virtual/range {v0 .. v5}, Lcom/adobe/ave/VideoEngine;->injectData(Lcom/adobe/ave/DataType;J[BI)V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#injectData"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Injected data at virtual time ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected isBufferFull()Z
    .locals 6

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getBufferLength()J

    move-result-wide v2

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    invoke-virtual {v1}, Lcom/adobe/mediacore/BufferControlParameters;->getPlayBufferTime()J

    move-result-wide v4

    cmp-long v1, v2, v4

    if-gez v1, :cond_2

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->hasAllDataBuffered()Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public isInitialised()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isInitialised:Z

    return v0
.end method

.method public load(Lcom/adobe/mediacore/MediaResource;I)V
    .locals 10

    iget-boolean v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    if-nez v1, :cond_1

    new-instance v1, Lcom/adobe/mediacore/LoadOperation;

    invoke-direct {v1, p1, p2}, Lcom/adobe/mediacore/LoadOperation;-><init>(Lcom/adobe/mediacore/MediaResource;I)V

    invoke-interface {v1, p0}, Lcom/adobe/mediacore/PlayerOperation;->setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->resetState()V

    :try_start_0
    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iput p2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_contentId:I

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v3

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaResource;->getType()Lcom/adobe/mediacore/MediaResource$Type;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertType(Lcom/adobe/mediacore/MediaResource$Type;)Lcom/adobe/ave/ContainerType;

    move-result-object v4

    invoke-static {}, Lcom/adobe/mediacore/PSDKConfig;->getAdTagsWithDefault()[Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    array-length v5, v1

    invoke-virtual {v2, v1, v5}, Lcom/adobe/ave/VideoEngine;->setCuePointTags([Ljava/lang/String;I)V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#load"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Setting ad cues: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2, v5, v6}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/adobe/mediacore/PSDKConfig;->getSubscribedTags()[Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/adobe/mediacore/utils/StringUtils;->getReunion([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    array-length v6, v5

    invoke-virtual {v2, v5, v6}, Lcom/adobe/ave/VideoEngine;->setSubscribedTags([Ljava/lang/String;I)V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "#load"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Setting subscribed cues: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v5}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v6, v7}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_adTags:Ljava/util/List;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    invoke-virtual {p0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v2

    if-eqz v2, :cond_4

    instance-of v1, v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v1, :cond_4

    move-object v0, v2

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    move-object v1, v0

    sget-object v6, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NETWORK_CONFIGURATION:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v6}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    check-cast v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NETWORK_CONFIGURATION:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/system/NetworkConfiguration;

    const-string v2, ""

    invoke-virtual {v1}, Lcom/adobe/mediacore/system/NetworkConfiguration;->getCookieHeaders()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    if-eqz v6, :cond_2

    invoke-virtual {v1}, Lcom/adobe/mediacore/system/NetworkConfiguration;->getCookieHeaders()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->encodeToHTTPHeader(Lcom/adobe/mediacore/metadata/Metadata;)Ljava/lang/String;

    move-result-object v2

    :cond_2
    invoke-virtual {v1}, Lcom/adobe/mediacore/system/NetworkConfiguration;->getUseCookieHeadersForAllRequests()Z

    move-result v6

    invoke-virtual {v1}, Lcom/adobe/mediacore/system/NetworkConfiguration;->getUseRedirectedUrl()Z

    move-result v7

    invoke-virtual {v1}, Lcom/adobe/mediacore/system/NetworkConfiguration;->getCustomHeaders()Ljava/util/HashMap;

    move-result-object v8

    invoke-virtual {v1}, Lcom/adobe/mediacore/system/NetworkConfiguration;->getMasterUpdateInterval()I

    move-result v9

    new-instance v1, Lcom/adobe/ave/NetworkingParameters;

    invoke-direct {v1, v2, v6}, Lcom/adobe/ave/NetworkingParameters;-><init>(Ljava/lang/String;Z)V

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v2, v1}, Lcom/adobe/ave/VideoEngine;->setNetworkingParameters(Lcom/adobe/ave/NetworkingParameters;)V

    invoke-virtual {p0, v7}, Lcom/adobe/mediacore/VideoEngineAdapter;->useRedirectedUrl(Z)V

    if-eqz v8, :cond_3

    invoke-virtual {v8}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    array-length v8, v1

    invoke-virtual {v7, v2, v1, v8}, Lcom/adobe/ave/VideoEngine;->addCustomHeader(Ljava/lang/String;[Ljava/lang/String;I)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v1

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RESOURCE_LOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v3, "Video engine load-resource operation has failed."

    invoke-static {v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v2

    new-instance v3, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v3}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v4, "DESCRIPTION"

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v4, v1}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "RESOURCE"

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaResource;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v1, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v2}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_3
    :try_start_1
    invoke-virtual {p0, v9}, Lcom/adobe/mediacore/VideoEngineAdapter;->masterUpdateInterval(I)V

    :goto_2
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundMediaResource:Lcom/adobe/mediacore/MediaResource;

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    array-length v2, v5

    invoke-virtual {v1, v5, v2}, Lcom/adobe/ave/VideoEngine;->setSubscribedTagsForBackgroundManifest([Ljava/lang/String;I)V

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v6, "#load"

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Setting subscribed cues on background stream: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v5}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v2, v5}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundMediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->getUrl(Lcom/adobe/mediacore/MediaResource;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v3, v4, p2, v2}, Lcom/adobe/ave/VideoEngine;->loadWithBackgroundManifest(Ljava/lang/String;Lcom/adobe/ave/ContainerType;ILjava/lang/String;)V

    goto/16 :goto_0

    :cond_4
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->useRedirectedUrl(Z)V

    const/4 v1, -0x1

    invoke-virtual {p0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->masterUpdateInterval(I)V

    goto :goto_2

    :cond_5
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1, v3, v4, p2}, Lcom/adobe/ave/VideoEngine;->load(Ljava/lang/String;Lcom/adobe/ave/ContainerType;I)V
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method public masterUpdateInterval(I)V
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngine;->setMasterUpdateInterval(I)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#masterUpdateInterval"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Not successful"

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public pause()V
    .locals 4

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    if-nez v0, :cond_1

    new-instance v0, Lcom/adobe/mediacore/PlayOperation;

    invoke-direct {v0}, Lcom/adobe/mediacore/PlayOperation;-><init>()V

    new-instance v1, Lcom/adobe/mediacore/PauseOperation;

    invoke-direct {v1}, Lcom/adobe/mediacore/PauseOperation;-><init>()V

    invoke-interface {v1, p0}, Lcom/adobe/mediacore/PlayerOperation;->setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    invoke-interface {v0, p0}, Lcom/adobe/mediacore/PlayerOperation;->setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getPlayState()Lcom/adobe/ave/PlayState;

    move-result-object v0

    sget-object v1, Lcom/adobe/ave/PlayState;->SUSPENDED:Lcom/adobe/ave/PlayState;

    if-ne v0, v1, :cond_2

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->play()V

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngine;->setScreenOnWhilePlaying(Z)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->pause()V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PAUSE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Pause operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public play()V
    .locals 4

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    if-nez v0, :cond_1

    new-instance v0, Lcom/adobe/mediacore/PlayOperation;

    invoke-direct {v0}, Lcom/adobe/mediacore/PlayOperation;-><init>()V

    invoke-interface {v0, p0}, Lcom/adobe/mediacore/PlayerOperation;->setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    :try_start_0
    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineItem;->isLive()Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isInitialised:Z

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngine;->setScreenOnWhilePlaying(Z)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->play()V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PLAYBACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Play operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public prepareBuffer()V
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->prepareBuffer()V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RESOURCE_LOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Video engine prepare buffer operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    if-eqz v0, :cond_1

    const-string v0, "RESOURCE"

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v3}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v0, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public release()V
    .locals 7

    const/4 v6, 0x0

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->reset()V

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngine;->removeListener(Lcom/adobe/ave/VideoEngineListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->release()V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_context:Landroid/content/Context;

    :goto_0
    return-void

    :catch_0
    move-exception v0

    :try_start_1
    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RELEASE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Video engine release operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "NATIVE_ERROR_CODE"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "NATIVE_ERROR_NAME"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/MediaErrorCode;->name()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_0
    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_context:Landroid/content/Context;

    goto :goto_0

    :catchall_0
    move-exception v0

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_context:Landroid/content/Context;

    throw v0
.end method

.method public releaseResources()V
    .locals 6

    :try_start_0
    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_alreadyReleased:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->releaseGPUResources()V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RESOURCES_RELEASE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Video engine release-resources operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "NATIVE_ERROR_CODE"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "NATIVE_ERROR_NAME"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/MediaErrorCode;->name()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public reset()V
    .locals 6

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    if-nez v0, :cond_1

    new-instance v0, Lcom/adobe/mediacore/ResetOperation;

    invoke-direct {v0}, Lcom/adobe/mediacore/ResetOperation;-><init>()V

    invoke-interface {v0, p0}, Lcom/adobe/mediacore/PlayerOperation;->setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->resetState()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredABRControlParameters:Lcom/adobe/mediacore/ABRControlParameters;

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->getDefaultBufferingParameters()Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->reset()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngine;->setScreenOnWhilePlaying(Z)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->reset()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->destroyNotificationHistory()V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RESET_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Video engine reset operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "NATIVE_ERROR_CODE"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "NATIVE_ERROR_NAME"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/MediaErrorCode;->name()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method protected restorePlayer(Lcom/adobe/mediacore/MediaPlayer$PlayerState;)V
    .locals 6

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    if-eqz v0, :cond_1

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#suspendPlayer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Player is already restored. Current state ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlayerState()Lcom/adobe/ave/PlayState;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#restorePlayer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Executing ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] pending operation(s)."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/PlayerOperation;

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#restorePlayer"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Executing operation: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0}, Lcom/adobe/mediacore/PlayerOperation;->execute()V

    goto :goto_1

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto/16 :goto_0

    :cond_3
    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->isInitialised()Z

    move-result v0

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->COMPLETE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq p1, v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#restorePlayer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Restoring video engine to state ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->play()V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq p1, v0, :cond_4

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne p1, v0, :cond_0

    :cond_4
    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->pause()V

    goto/16 :goto_0
.end method

.method public returnFromTrickPlay()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->restoreAdsOnSourceTimeline()V

    return-void
.end method

.method public seek(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->seek(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Z)V

    return-void
.end method

.method public seek(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Z)V
    .locals 8

    const-wide/16 v6, -0x2

    const/4 v0, 0x1

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->isInvalid()Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#seek"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ignoring seek to invalid position."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget-boolean v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    if-nez v1, :cond_3

    new-instance v0, Lcom/adobe/mediacore/PlayOperation;

    invoke-direct {v0}, Lcom/adobe/mediacore/PlayOperation;-><init>()V

    invoke-interface {v0, p0}, Lcom/adobe/mediacore/PlayerOperation;->setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v0, Lcom/adobe/mediacore/SeekOperation;

    invoke-direct {v0, p1}, Lcom/adobe/mediacore/SeekOperation;-><init>(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V

    invoke-virtual {v0, p0}, Lcom/adobe/mediacore/SeekOperation;->setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_pendingOperations:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_3
    :try_start_0
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->preventSeekAtClientLivePoint(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    cmp-long v1, v2, v6

    if-nez v1, :cond_7

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v1

    invoke-static {v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    :goto_1
    if-nez p2, :cond_5

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isSeeking:Z

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/adobe/mediacore/SeekEvent;->createSeekStarted(J)Lcom/adobe/mediacore/SeekEvent;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_4
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v2, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v3, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v2, v3}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_5
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngine;->getPlayState()Lcom/adobe/ave/PlayState;

    move-result-object v1

    sget-object v2, Lcom/adobe/ave/PlayState;->SUSPENDED:Lcom/adobe/ave/PlayState;

    if-ne v1, v2, :cond_6

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->play()V

    :cond_6
    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#seek"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Seeking to position "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_8

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v1

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Lcom/adobe/ave/VideoEngine;->seekToLocalTime(IJ)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#seek"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Seek has failed to position "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    sget-object v2, Lcom/adobe/ave/MediaErrorCode;->SEEK_FAILED:Lcom/adobe/ave/MediaErrorCode;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/ave/VideoEngineListener;->onSeekComplete(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;)V

    goto/16 :goto_0

    :cond_7
    :try_start_1
    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    goto/16 :goto_1

    :cond_8
    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    cmp-long v1, v2, v6

    if-nez v1, :cond_9

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->seekToLivePoint()V

    goto/16 :goto_0

    :cond_9
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v2

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngine;->getBufferLength()J

    move-result-wide v4

    add-long/2addr v4, v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v6

    cmp-long v1, v2, v6

    if-gtz v1, :cond_a

    cmp-long v1, v6, v4

    if-gtz v1, :cond_a

    :goto_2
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3, v0}, Lcom/adobe/ave/VideoEngine;->seek(JZ)V
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    :cond_a
    const/4 v0, 0x0

    goto :goto_2
.end method

.method public setABRControlParameters(Lcom/adobe/mediacore/ABRControlParameters;)V
    .locals 4

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredABRControlParameters:Lcom/adobe/mediacore/ABRControlParameters;

    :try_start_0
    new-instance v0, Lcom/adobe/ave/ABRParameters;

    invoke-direct {v0}, Lcom/adobe/ave/ABRParameters;-><init>()V

    invoke-virtual {p1}, Lcom/adobe/mediacore/ABRControlParameters;->getInitialBitRate()I

    move-result v1

    iput v1, v0, Lcom/adobe/ave/ABRParameters;->startBitsPerSecond:I

    invoke-virtual {p1}, Lcom/adobe/mediacore/ABRControlParameters;->getMinBitRate()I

    move-result v1

    iput v1, v0, Lcom/adobe/ave/ABRParameters;->minBitsPerSecond:I

    invoke-virtual {p1}, Lcom/adobe/mediacore/ABRControlParameters;->getMaxBitRate()I

    move-result v1

    iput v1, v0, Lcom/adobe/ave/ABRParameters;->maxBitsPerSecond:I

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter$2;->$SwitchMap$com$adobe$mediacore$ABRControlParameters$ABRPolicy:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/ABRControlParameters;->getABRPolicy()Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    :goto_0
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1, v0}, Lcom/adobe/ave/VideoEngine;->setABRParameters(Lcom/adobe/ave/ABRParameters;)V

    :cond_0
    :goto_1
    return-void

    :pswitch_0
    sget-object v1, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_AGGRESSIVE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    iput-object v1, v0, Lcom/adobe/ave/ABRParameters;->policy:Lcom/adobe/ave/ABRParameters$ABRPolicy;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_ABR_PARAMETERS_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Set ABR params operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_1

    :pswitch_1
    :try_start_1
    sget-object v1, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_MODERATE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    iput-object v1, v0, Lcom/adobe/ave/ABRParameters;->policy:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    goto :goto_0

    :pswitch_2
    sget-object v1, Lcom/adobe/ave/ABRParameters$ABRPolicy;->ABR_CONSERVATIVE:Lcom/adobe/ave/ABRParameters$ABRPolicy;

    iput-object v1, v0, Lcom/adobe/ave/ABRParameters;->policy:Lcom/adobe/ave/ABRParameters$ABRPolicy;
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public setBackgroundMediaResource(Lcom/adobe/mediacore/MediaResource;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundMediaResource:Lcom/adobe/mediacore/MediaResource;

    return-void
.end method

.method public setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V
    .locals 6

    :try_start_0
    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {p1}, Lcom/adobe/mediacore/BufferControlParameters;->getInitialBufferTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/adobe/ave/VideoEngine;->setInitialBufferTime(J)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {p1}, Lcom/adobe/mediacore/BufferControlParameters;->getPlayBufferTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/adobe/ave/VideoEngine;->setBufferTime(J)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_BUFFER_PARAMETERS_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Set buffer control parameters operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "INITIAL_BUFFER_TIME"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/adobe/mediacore/BufferControlParameters;->getInitialBufferTime()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v0, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "PLAY_BUFFER_TIME"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/adobe/mediacore/BufferControlParameters;->getPlayBufferTime()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v0, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public setCaptionsControlParameters(Lcom/adobe/mediacore/TextFormat;)V
    .locals 6

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    const/16 v0, 0xb

    const/4 v1, 0x0

    :try_start_0
    new-array v2, v0, [Ljava/lang/String;

    new-array v3, v0, [Ljava/lang/String;

    const-string v4, "font"

    aput-object v4, v2, v1

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getFont()Lcom/adobe/mediacore/TextFormat$Font;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/TextFormat$Font;->getValue()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v1

    const-string v1, "font_color"

    aput-object v1, v2, v4

    const/4 v1, 0x2

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getFontColor()Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/TextFormat$Color;->getValue()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const-string v4, "font_edge"

    aput-object v4, v2, v1

    const/4 v4, 0x3

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getFontEdge()Lcom/adobe/mediacore/TextFormat$FontEdge;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/TextFormat$FontEdge;->getValue()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v1

    const-string v1, "background_color"

    aput-object v1, v2, v4

    const/4 v1, 0x4

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getBackgroundColor()Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/TextFormat$Color;->getValue()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const-string v4, "fill_color"

    aput-object v4, v2, v1

    const/4 v4, 0x5

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getFillColor()Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/TextFormat$Color;->getValue()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v1

    const-string v1, "edge_color"

    aput-object v1, v2, v4

    const/4 v1, 0x6

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getEdgeColor()Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/TextFormat$Color;->getValue()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const-string v4, "size"

    aput-object v4, v2, v1

    const/4 v4, 0x7

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getSize()Lcom/adobe/mediacore/TextFormat$Size;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/TextFormat$Size;->getValue()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v1

    const-string v1, "font_opacity"

    aput-object v1, v2, v4

    const/16 v1, 0x8

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getFontOpacity()I

    move-result v5

    invoke-direct {p0, v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertOpacity(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const-string v4, "background_opacity"

    aput-object v4, v2, v1

    const/16 v4, 0x9

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getBackgroundOpacity()I

    move-result v5

    invoke-direct {p0, v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertOpacity(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v1

    const-string v1, "fill_opacity"

    aput-object v1, v2, v4

    const/16 v1, 0xa

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v5}, Lcom/adobe/mediacore/TextFormat;->getFillOpacity()I

    move-result v5

    invoke-direct {p0, v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertOpacity(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const-string v4, "bottom_inset"

    aput-object v4, v2, v1

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsControlParameters:Lcom/adobe/mediacore/TextFormat;

    invoke-interface {v4}, Lcom/adobe/mediacore/TextFormat;->getBottomInset()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v1

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1, v2, v3, v0}, Lcom/adobe/ave/VideoEngine;->setCaptionStyle([Ljava/lang/String;[Ljava/lang/String;I)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_CC_STYLING_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Set CC-styling operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public setCaptionsVisibility(Lcom/adobe/mediacore/MediaPlayer$Visibility;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsVisibility:Lcom/adobe/mediacore/MediaPlayer$Visibility;

    if-eq v0, p1, :cond_0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredCaptionsVisibility:Lcom/adobe/mediacore/MediaPlayer$Visibility;

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$Visibility;->VISIBLE:Lcom/adobe/mediacore/MediaPlayer$Visibility;

    if-ne p1, v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Lcom/adobe/ave/VideoEngine;->enableCaptions(Z)V
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

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_CC_VISIBILITY_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Set CC visibility operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_1
.end method

.method public setCustomConfiguration(Ljava/lang/String;)V
    .locals 1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngine;->setCustomConfiguration(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public setView(Lcom/adobe/ave/VideoEngineView;)V
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngine;->setView(Lcom/adobe/ave/VideoEngineView;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_SET_VIEW_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Set view operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public setVolume(I)V
    .locals 5

    :try_start_0
    iput p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredVolume:I

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iget v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredVolume:I

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngine;->setVolume(I)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_VOLUME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Set volume operation has failed."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "VOLUME"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v0, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public shouldTriggerSubscribedTagEvent(J)Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline;->shouldTriggerSubscribedTagEvent(J)Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected suspendPlayer()V
    .locals 3

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    if-nez v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#suspendPlayer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Player is already suspended."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#suspendPlayer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Releasing GPU resources and suspending video engine."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_hasSurface:Z

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineAdapter;->releaseResources()V

    goto :goto_0
.end method

.method public useRedirectedUrl(Z)V
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngine;->useRedirectedUrl(Z)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#useRedirectedUrl"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Not successful"

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method
