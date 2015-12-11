.class public final Lcom/adobe/mediacore/DefaultMediaPlayer;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/DefaultMediaPlayer$13;
    }
.end annotation


# static fields
.field private static final DEFAULT_CONTENT_ID:I

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final INTERNAL_TIMER_PERIOD:J

.field private _adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

.field private _adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

.field private _adTimeline:Lcom/adobe/mediacore/AdTimeline;

.field private _adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

.field private _backgroundItem:Lcom/adobe/mediacore/MediaPlayerItem;

.field private _backgroundResource:Lcom/adobe/mediacore/MediaResource;

.field private _closedCaptionsTextFormat:Lcom/adobe/mediacore/TextFormat;

.field private _context:Landroid/content/Context;

.field private _cuesResolved:Z

.field private _currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field private _handler:Landroid/os/Handler;

.field private _initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

.field private _internalTimer:Ljava/lang/Runnable;

.field private _internalTimerRunning:Z

.field private _isPrepared:Z

.field private _item:Lcom/adobe/mediacore/MediaPlayerItem;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

.field private _mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

.field private _playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

.field private _preparePending:Z

.field private _resource:Lcom/adobe/mediacore/MediaResource;

.field private final _seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

.field private _seekNeeded:Z

.field private _shouldStopInternalTimer:Z

.field private _startPosition:J

.field private _trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

.field private _videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

.field private _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 4

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    const-wide/16 v0, 0xfa

    iput-wide v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->INTERNAL_TIMER_PERIOD:J

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iput-boolean v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_isPrepared:Z

    iput-boolean v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekNeeded:Z

    iput-boolean v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_preparePending:Z

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_closedCaptionsTextFormat:Lcom/adobe/mediacore/TextFormat;

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->IDLE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$1;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_context:Landroid/content/Context;

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_handler:Landroid/os/Handler;

    new-instance v0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$2;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimer:Ljava/lang/Runnable;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-direct {v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RESOURCE_LOADED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$3;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$3;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$4;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$4;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_CREATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$5;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$5;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$6;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$6;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_READY:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$7;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$7;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_FULL:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$8;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$8;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIEW_CLICKED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$9;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$9;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AUDIO_TRACK_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$10;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$10;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIDEO_ERROR:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$11;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$11;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIDEO_STATE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/DefaultMediaPlayer$12;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer$12;-><init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    new-instance v0, Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_context:Landroid/content/Context;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;-><init>(Landroid/content/Context;Lcom/adobe/mediacore/VideoEngineDispatcher;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->initialize()V

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerView;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_context:Landroid/content/Context;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerView;-><init>(Landroid/content/Context;Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineDispatcher;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayerView;->getVideoEngineView()Lcom/adobe/ave/VideoEngineView;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setView(Lcom/adobe/ave/VideoEngineView;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/SeekAdjustCompletedListener;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineDispatcher;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TrickPlayManager;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_shouldStopInternalTimer:Z

    return v0
.end method

.method static synthetic access$1200(Lcom/adobe/mediacore/DefaultMediaPlayer;)Ljava/lang/Runnable;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimer:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/adobe/mediacore/DefaultMediaPlayer;)Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$1400()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaResource;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_preparePending:Z

    return v0
.end method

.method static synthetic access$1900(Lcom/adobe/mediacore/DefaultMediaPlayer;)J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_startPosition:J

    return-wide v0
.end method

.method static synthetic access$200(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineAdapter;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_cuesResolved:Z

    return v0
.end method

.method static synthetic access$2100(Lcom/adobe/mediacore/DefaultMediaPlayer;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->resolveCues()V

    return-void
.end method

.method static synthetic access$2200(Lcom/adobe/mediacore/DefaultMediaPlayer;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->stopInternalTimer()V

    return-void
.end method

.method static synthetic access$2300(Lcom/adobe/mediacore/DefaultMediaPlayer;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Z
    .locals 1

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->isErrorRecoverable(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerItem;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    return-object v0
.end method

.method static synthetic access$302(Lcom/adobe/mediacore/DefaultMediaPlayer;Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/MediaPlayerItem;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    return-object p1
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerClient;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    return-object v0
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    return-object v0
.end method

.method static synthetic access$600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimerRunning:Z

    return v0
.end method

.method static synthetic access$700(Lcom/adobe/mediacore/DefaultMediaPlayer;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->startInternalTimer()V

    return-void
.end method

.method static synthetic access$800(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/AdTimeline;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    return-object v0
.end method

.method static synthetic access$900(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TimelineMonitor;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    return-object v0
.end method

.method private adjustDesiredSeekPosition(J)V
    .locals 7

    const-wide/16 v0, -0x2

    cmp-long v0, p1, v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#adjustDesiredSeekPosition"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Seeking starting at client live point "

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createLivePoint()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/adobe/mediacore/SeekEvent;->createSeekAdjustCompleted(J)Lcom/adobe/mediacore/SeekEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    :goto_0
    const/4 v0, -0x1

    invoke-static {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#adjustDesiredSeekPosition"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Seeking starting ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->pause()V

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_ADJUST_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    invoke-virtual {v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_1
    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getTime()J

    move-result-wide v2

    sget-object v4, Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;->SEEK:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    invoke-virtual {v1, v0, v2, v3, v4}, Lcom/adobe/mediacore/TimelineMonitor;->adjustSeekPosition(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#adjustDesiredSeekPosition"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Adjusted seek position is ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "]."

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    return-void

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#seek"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Invalid parameter. Seeking to the client live point is not allowed for video on demand content. Will use default value."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide p1

    goto/16 :goto_0

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/utils/TimeRange;->contains(J)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-lez v0, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v0

    :goto_1
    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#seek"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Desired seek position is not included in the seekble range. Will use default value "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move-wide p1, v0

    goto/16 :goto_0

    :cond_5
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v0

    goto :goto_1
.end method

.method private adjustDesiredStartPosition(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 5

    const/4 v3, -0x1

    const-wide/16 v0, -0x2

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getInitialTimeForLive()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/utils/TimeRange;->contains(J)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#adjustDesiredStartPosition"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Desired start position is not included in the seekble range. Will used default values."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getInitialTimeForLive()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v0

    invoke-static {v3, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto :goto_0

    :cond_2
    invoke-static {v3, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto :goto_0
.end method

.method private beginLoadResource()V
    .locals 5

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#beginLoadResource"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Loading of media resource is starting. ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-boolean v4, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_isPrepared:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v0, v1, v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->load(Lcom/adobe/mediacore/MediaResource;I)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayerView;->getVideoEngineView()Lcom/adobe/ave/VideoEngineView;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setView(Lcom/adobe/ave/VideoEngineView;)V

    return-void
.end method

.method private checkAndThrowIfError()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The media player is in ERROR state. You\'ll need to reset it before further use."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method private checkAndThrowIfReleased()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->RELEASED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "The media player has been released. No method can be invoked anymore."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method public static create(Landroid/content/Context;)Lcom/adobe/mediacore/MediaPlayer;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method private static createInitialPlacementInformations(Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/metadata/AdSignalingMode;Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Ljava/util/List;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/MediaPlayerItem;",
            "Lcom/adobe/mediacore/metadata/AdSignalingMode;",
            "Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;",
            ">;"
        }
    .end annotation

    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne p1, v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "adSignalingMode should not be set to DEFAULT. The adSignalingMode should be already adjusted to the actual value (MANIFEST_CUES or SERVER_MAP) based on the media player item type."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;

    invoke-interface {p0}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;-><init>(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_3

    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->SERVER_MAP:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne p1, v0, :cond_2

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->SERVER_MAP:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-wide/16 v2, -0x1

    const-wide/16 v4, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1
    :goto_0
    return-object v8

    :cond_2
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne p1, v0, :cond_1

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-virtual {p2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    const-wide/16 v4, -0x1

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_3
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v1

    const-string v2, "mark"

    if-ne v1, v2, :cond_4

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->MARK:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    const-wide/16 v4, -0x1

    const-wide/16 v6, 0x0

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_4
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v1

    const-string v2, "delete"

    if-ne v1, v2, :cond_6

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->DELETE:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    const-wide/16 v4, -0x1

    const-wide/16 v6, 0x0

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->SERVER_MAP:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne p1, v0, :cond_5

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->SERVER_MAP:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-wide/16 v2, -0x1

    const-wide/16 v4, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_5
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne p1, v0, :cond_1

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-virtual {p2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    const-wide/16 v4, -0x1

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_6
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v0

    const-string v1, "replace"

    if-ne v0, v1, :cond_1

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->DELETE:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    const-wide/16 v4, -0x1

    const-wide/16 v6, 0x0

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->REPLACE:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    const-wide/16 v4, -0x1

    const-wide/16 v6, 0x0

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0
.end method

.method private extractAdSignalingMode(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 5

    sget-object v2, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    invoke-interface {p1}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    new-instance v3, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;

    invoke-direct {v3, v1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;-><init>(Lcom/adobe/mediacore/metadata/Metadata;)V

    if-eqz v1, :cond_9

    instance-of v1, v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v1, :cond_9

    const/4 v1, 0x0

    sget-object v4, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v4}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;

    :cond_0
    sget-object v4, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v4}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;

    move-object v1, v0

    :cond_1
    if-eqz v1, :cond_9

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v0

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v2

    const-string v4, "replace"

    if-eq v2, v4, :cond_2

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v2

    const-string v4, "mark"

    if-ne v2, v4, :cond_3

    :cond_2
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    sget-object v2, Lcom/adobe/mediacore/metadata/AdSignalingMode;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->setSignalingMode(Lcom/adobe/mediacore/metadata/AdSignalingMode;)V

    :cond_3
    :goto_0
    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne v0, v1, :cond_4

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v1

    const-string v2, "replace"

    if-eq v1, v2, :cond_4

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->UNDEFINED_TIME_RANGES:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v2, "Ad signaling mode is CUSTOM TIME RANGES but there are no replace time ranges."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_4
    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne v0, v1, :cond_5

    invoke-interface {p1}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v0

    if-eqz v0, :cond_6

    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    :cond_5
    :goto_1
    return-object v0

    :cond_6
    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v0

    const-string v1, "replace"

    if-eq v0, v1, :cond_7

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->hasRanges()Ljava/lang/String;

    move-result-object v0

    const-string v1, "mark"

    if-ne v0, v1, :cond_8

    :cond_7
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    goto :goto_1

    :cond_8
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->SERVER_MAP:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    goto :goto_1

    :cond_9
    move-object v0, v2

    goto :goto_0
.end method

.method private extractEnableLivePreroll(Lcom/adobe/mediacore/MediaPlayerItem;)Z
    .locals 3

    invoke-interface {p1}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v1, :cond_1

    instance-of v1, v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v1, :cond_1

    const/4 v1, 0x0

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;

    :cond_0
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;

    :goto_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->getEnableLivePreroll()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->getEnableLivePreroll()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    :goto_1
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_1

    :cond_2
    move-object v0, v1

    goto :goto_0
.end method

.method private getInitialTimeForLive()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 4

    const/4 v0, -0x1

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentTime()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    return-object v0
.end method

.method private isErrorRecoverable(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Z
    .locals 5

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->CONTENT_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    if-eq v2, v3, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->MANIFEST_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    if-ne v2, v3, :cond_1

    :cond_0
    :goto_0
    :pswitch_0
    return v0

    :cond_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SEEK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    if-ne v2, v3, :cond_2

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->play()V

    goto :goto_0

    :cond_2
    :try_start_0
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v2

    const-string v3, "NATIVE_ERROR_CODE"

    invoke-interface {v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v3

    aget-object v2, v3, v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    sget-object v3, Lcom/adobe/mediacore/DefaultMediaPlayer$13;->$SwitchMap$com$adobe$ave$MediaErrorCode:[I

    invoke-virtual {v2}, Lcom/adobe/ave/MediaErrorCode;->ordinal()I

    move-result v2

    aget v2, v3, v2

    packed-switch v2, :pswitch_data_0

    move v0, v1

    goto :goto_0

    :catch_0
    move-exception v0

    move v0, v1

    goto :goto_0

    :pswitch_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v2

    const-string v3, "DESCRIPTION"

    invoke-interface {v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_3

    move v0, v1

    goto :goto_0

    :cond_3
    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    array-length v3, v2

    if-nez v3, :cond_4

    move v0, v1

    goto :goto_0

    :cond_4
    aget-object v2, v2, v1

    const-string v3, "::="

    invoke-virtual {v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    array-length v3, v2

    const/4 v4, 0x2

    if-eq v3, v4, :cond_5

    move v0, v1

    goto :goto_0

    :cond_5
    aget-object v3, v2, v1

    const-string v4, "url"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    aget-object v3, v2, v1

    const-string v4, "rendition url"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    move v0, v1

    goto :goto_0

    :cond_6
    aget-object v2, v2, v0

    const-string v3, ".ts"

    invoke-virtual {v2, v3}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private loadAdComponents(Lcom/adobe/mediacore/MediaPlayerItem;)V
    .locals 6

    new-instance v0, Lcom/adobe/mediacore/AdTimeline;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getTimeline()Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/adobe/mediacore/AdTimeline;-><init>(Lcom/adobe/mediacore/VideoEngineTimeline;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    new-instance v0, Lcom/adobe/mediacore/TimelineMonitor;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/TimelineMonitor;-><init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/AdTimeline;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->extractAdSignalingMode(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-eq v0, v1, :cond_1

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_cuesResolved:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    if-nez v0, :cond_0

    new-instance v0, Lcom/adobe/mediacore/DefaultAdvertisingFactory;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_context:Landroid/content/Context;

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/DefaultAdvertisingFactory;-><init>(Lcom/adobe/mediacore/metadata/AdSignalingMode;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/MediaPlayerClient;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v4, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    iget-object v5, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/MediaPlayerClient;-><init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/AdClientFactory;Lcom/adobe/mediacore/metadata/AdSignalingMode;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerClient;->initialize(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Lcom/adobe/mediacore/TimelineMonitor;)V

    new-instance v0, Lcom/adobe/mediacore/TrickPlayManager;

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v4, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    iget-object v5, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/TrickPlayManager;-><init>(Lcom/adobe/mediacore/MediaPlayer;Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/TimelineMonitor;Lcom/adobe/mediacore/VideoEngineDispatcher;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    return-void

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private playerIsPrepared()V
    .locals 3

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_isPrepared:Z

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_isPrepared:Z

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PREPARED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method private resetInternalComponents()V
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_shouldStopInternalTimer:Z

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->stopInternalTimer()V

    iput-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iput-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    return-void
.end method

.method private resolveCues()V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#resolveCues"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Entering in-stream cue resolving."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "resolveCues"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Starting in-stream cue resolving."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v1}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getTime()J

    move-result-wide v2

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v1}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Lcom/adobe/mediacore/MediaPlayerClient;->update(JLcom/adobe/mediacore/utils/TimeRange;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#resolveCues"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to resolve cues."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->endAdResolving()V

    goto :goto_0
.end method

.method private startInternalTimer()V
    .locals 4

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimerRunning:Z

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_shouldStopInternalTimer:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimerRunning:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_handler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimer:Ljava/lang/Runnable;

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method private stopInternalTimer()V
    .locals 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_shouldStopInternalTimer:Z

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimerRunning:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_handler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimer:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    :cond_0
    return-void
.end method

.method private unloadAdComponents()V
    .locals 2

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TimelineMonitor;->clear()V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getTimeline()Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getTimeline()Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->clear()V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->unload()V

    :cond_2
    iput-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    iput-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    iput-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    return-void
.end method

.method private updateVideoEngineAdapter()V
    .locals 4

    const/4 v3, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#updateVideoEngineAdapter"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Releasing the media player associated resources."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->unloadAdComponents()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->resetInternalComponents()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#updateVideoEngineAdapter()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Destroying the media player instance."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->release()V

    iput-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->IDLE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {p0, v0, v3}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    new-instance v0, Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_context:Landroid/content/Context;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;-><init>(Landroid/content/Context;Lcom/adobe/mediacore/VideoEngineDispatcher;)V

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->initialize()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_backgroundResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setBackgroundMediaResource(Lcom/adobe/mediacore/MediaResource;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_context:Landroid/content/Context;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerView;->updateVideoEngine(Landroid/content/Context;Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayerView;->getVideoEngineView()Lcom/adobe/ave/VideoEngineView;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setView(Lcom/adobe/ave/VideoEngineView;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    return-void
.end method


# virtual methods
.method public addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_0
    return-void
.end method

.method public convertToLocalTime(J)J
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    const-wide/16 v0, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v2, p1, p2}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertToLocalTime(J)J

    move-result-wide v2

    const-wide/16 v4, -0x1

    cmp-long v4, v2, v4

    if-nez v4, :cond_1

    :cond_0
    :goto_0
    return-wide v0

    :cond_1
    move-wide v0, v2

    goto :goto_0
.end method

.method endAdResolving()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#endAdResolving"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ignore event as media player is in ERROR state."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_cuesResolved:Z

    if-nez v0, :cond_1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_cuesResolved:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#endAdResolving"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Revisiting manifest cues."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->resolveCues()V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#endAdResolving"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ad resolving and placement process is complete."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->update()V

    :cond_2
    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->playerIsPrepared()V

    goto :goto_0
.end method

.method public getBufferControlParameters()Lcom/adobe/mediacore/BufferControlParameters;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getBufferControlParameters()Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v0

    return-object v0
.end method

.method public getBufferedRange()Lcom/adobe/mediacore/utils/TimeRange;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getBufferedRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    return-object v0
.end method

.method public getCCStyle()Lcom/adobe/mediacore/TextFormat;
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    const/4 v8, -0x1

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_closedCaptionsTextFormat:Lcom/adobe/mediacore/TextFormat;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_closedCaptionsTextFormat:Lcom/adobe/mediacore/TextFormat;

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/TextFormatBuilder;

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Font;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Font;

    sget-object v2, Lcom/adobe/mediacore/TextFormat$Size;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Size;

    sget-object v3, Lcom/adobe/mediacore/TextFormat$FontEdge;->DEFAULT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    sget-object v4, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    sget-object v5, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    sget-object v6, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    sget-object v7, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    const-string v11, "default"

    move v9, v8

    move v10, v8

    invoke-direct/range {v0 .. v11}, Lcom/adobe/mediacore/TextFormatBuilder;-><init>(Lcom/adobe/mediacore/TextFormat$Font;Lcom/adobe/mediacore/TextFormat$Size;Lcom/adobe/mediacore/TextFormat$FontEdge;Lcom/adobe/mediacore/TextFormat$Color;Lcom/adobe/mediacore/TextFormat$Color;Lcom/adobe/mediacore/TextFormat$Color;Lcom/adobe/mediacore/TextFormat$Color;IIILjava/lang/String;)V

    invoke-virtual {v0}, Lcom/adobe/mediacore/TextFormatBuilder;->toTextFormat()Lcom/adobe/mediacore/TextFormat;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_closedCaptionsTextFormat:Lcom/adobe/mediacore/TextFormat;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_closedCaptionsTextFormat:Lcom/adobe/mediacore/TextFormat;

    goto :goto_0
.end method

.method public getCCVisibility()Lcom/adobe/mediacore/MediaPlayer$Visibility;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCaptionsVisibility()Lcom/adobe/mediacore/MediaPlayer$Visibility;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    return-object v0
.end method

.method public getCurrentTime()J
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->isInitialised()Z

    move-result v0

    if-nez v0, :cond_2

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    const-wide/16 v2, -0x3

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getTime()J

    move-result-wide v2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TimelineMonitor;->skippingAdBreaks()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TrickPlayManager;->getCurrentPlaybackRate()F

    move-result v0

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-lez v0, :cond_3

    const/4 v0, 0x1

    :goto_1
    int-to-long v0, v0

    iget-object v4, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-virtual {v4}, Lcom/adobe/mediacore/TimelineMonitor;->skippedDuration()J

    move-result-wide v4

    mul-long/2addr v0, v4

    add-long/2addr v0, v2

    goto :goto_0

    :cond_3
    const/4 v0, -0x1

    goto :goto_1

    :cond_4
    move-wide v0, v2

    goto :goto_0
.end method

.method public getDRMManager()Lcom/adobe/ave/drm/DRMManager;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getDRMManager()Lcom/adobe/ave/drm/DRMManager;

    move-result-object v0

    return-object v0
.end method

.method public getLocalTime()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->isInitialised()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getTimeLocal()J

    move-result-wide v0

    goto :goto_0
.end method

.method public getNotificationHistory()Lcom/adobe/mediacore/session/NotificationHistory;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->getNotificationHistory()Lcom/adobe/mediacore/session/NotificationHistory;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    return-object v0
.end method

.method public getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    return-object v0
.end method

.method public getRate()F
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TrickPlayManager;->getCurrentPlaybackRate()F

    move-result v0

    return v0
.end method

.method public getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    return-object v0
.end method

.method public getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    return-object v0
.end method

.method public getTimeline()Lcom/adobe/mediacore/timeline/Timeline;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    return-object v0
.end method

.method public getView()Lcom/adobe/mediacore/MediaPlayerView;
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    return-object v0
.end method

.method public pause()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    const/4 v3, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TrickPlayManager;->trickPlayEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#pause"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "MediaPlayer.pause() is called during trick-play - changing rate to 0.0 "

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0, v3}, Lcom/adobe/mediacore/TrickPlayManager;->changePlaybackRate(F)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0, v3}, Lcom/adobe/mediacore/TrickPlayManager;->updatePlaybackRate(F)V

    :cond_2
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->READY:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->COMPLETE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid player status [ "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] for operation [play]."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v1, v0, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TrickPlayManager;->isReturningFromTrickPlay()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->pause()V

    goto :goto_0

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#pause"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Playback already paused."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_5
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#play"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Playback pausing."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->pause()V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->isBufferFull()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->stopInternalTimer()V

    goto/16 :goto_0
.end method

.method public play()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    const/high16 v3, 0x3f800000    # 1.0f

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TrickPlayManager;->trickPlayEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#play"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "MediaPlayer.play() is called during trick-play - changing rate to 1.0"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0, v3}, Lcom/adobe/mediacore/TrickPlayManager;->changePlaybackRate(F)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0, v3}, Lcom/adobe/mediacore/TrickPlayManager;->updatePlaybackRate(F)V

    :cond_1
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->READY:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TrickPlayManager;->isReturningFromTrickPlay()Z

    move-result v0

    if-nez v0, :cond_3

    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid player status [ "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] for operation [play]."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v1, v0, :cond_6

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlayerState()Lcom/adobe/ave/PlayState;

    move-result-object v0

    sget-object v1, Lcom/adobe/ave/PlayState;->SUSPENDED:Lcom/adobe/ave/PlayState;

    if-eq v0, v1, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TrickPlayManager;->isReturningFromTrickPlay()Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlayerState()Lcom/adobe/ave/PlayState;

    move-result-object v0

    sget-object v1, Lcom/adobe/ave/PlayState;->TRICK_PLAY:Lcom/adobe/ave/PlayState;

    if-ne v0, v1, :cond_5

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->play()V

    goto/16 :goto_0

    :cond_5
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#play"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Playback already in progress."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_6
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#play"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Playback starting."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->play()V

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekNeeded:Z

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#play"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Performing initial seek at position ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekNeeded:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->seekToLocalTime(J)V

    :cond_7
    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    goto/16 :goto_0
.end method

.method public prepareBuffer()V
    .locals 6

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_1

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekNeeded:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#play"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Performing initial seek at position ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekNeeded:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    const/4 v1, -0x1

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->getVirtualTimeForLocalTime(J)J

    move-result-wide v2

    invoke-static {v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->seek(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Z)V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#prepareBuffer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Prepare buffer."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->prepareBuffer()V

    :goto_0
    return-void

    :cond_1
    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#prepareBuffer"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid player status ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "] for operation [prepareBuffer]."

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public prepareToPlay()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    const-wide/16 v0, -0x2

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->prepareToPlay(J)V

    return-void
.end method

.method public prepareToPlay(J)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    const/4 v0, 0x1

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v1, v2, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#prepareToPlay"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Initialization is already in progress, we will ignore any additional requests until completion."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    if-nez v2, :cond_2

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid current playback item (the item must not be null).Before calling prepareToPlay(), indicate the playback item through replaceCurrentItem() method."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v1, v2, :cond_3

    iget-boolean v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_preparePending:Z

    if-nez v2, :cond_3

    iput-wide p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_startPosition:J

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_preparePending:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#prepareToPlay"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Resource loading is already in progress. This operation will be called automatically after the loading has completed"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq v1, v2, :cond_4

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid player state. prepareToPlay method must be called only once after replaceCurrentItem method."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    if-nez v1, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#prepareToPlay"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "MediaPlayerItem is null. Unable to proceed with preparing resource: ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_5
    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->adjustDesiredStartPosition(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v1

    if-nez v1, :cond_6

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v1}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v1

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v1}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    cmp-long v1, v2, v4

    if-eqz v1, :cond_8

    :cond_6
    :goto_1
    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekNeeded:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->loadAdComponents(Lcom/adobe/mediacore/MediaPlayerItem;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_initialTime:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-static {v0, v1, v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->createInitialPlacementInformations(Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/metadata/AdSignalingMode;Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_7

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v1

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v1

    if-eqz v1, :cond_9

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->extractEnableLivePreroll(Lcom/adobe/mediacore/MediaPlayerItem;)Z

    move-result v1

    if-nez v1, :cond_9

    :cond_7
    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->endAdResolving()V

    goto/16 :goto_0

    :cond_8
    const/4 v0, 0x0

    goto :goto_1

    :cond_9
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerClient;->registerPlacement(I)V

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-virtual {v2, v0}, Lcom/adobe/mediacore/MediaPlayerClient;->beginResolveAds(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    goto :goto_2
.end method

.method public registerAdClientFactory(Lcom/adobe/mediacore/AdClientFactory;)V
    .locals 3

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "adClientFactory parameter can not be null. If you  need to reset the advertising factory to the default one, then provide a new DefaultAdvertisingFactory instance."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#registerAdvertisingFactory"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Registering custom ad client factory."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    return-void
.end method

.method public registerCurrentItemAsBackgroundItem()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#registerCurrentItemAsBackgroundItem"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Register current item as background item."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_backgroundResource:Lcom/adobe/mediacore/MediaResource;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_backgroundItem:Lcom/adobe/mediacore/MediaPlayerItem;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#registerCurrentItemAsBackgroundItem"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Background rsource url: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v3}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public release()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    const/4 v3, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#release"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Releasing the media player associated resources."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->unloadAdComponents()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->resetInternalComponents()V

    iput-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimer:Ljava/lang/Runnable;

    iput-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_handler:Landroid/os/Handler;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#release()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Destroying the media player instance."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->release()V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerView;->detachView()V

    iput-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->RELEASED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {p0, v0, v3}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    return-void
.end method

.method public removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_0
    return-void
.end method

.method public replaceCurrentItem(Lcom/adobe/mediacore/MediaResource;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    if-eq v0, p1, :cond_1

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->IDLE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq v0, v1, :cond_0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->updateVideoEngineAdapter()V

    :cond_0
    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->beginLoadResource()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_REPLACED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#replaceCurrentItem"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ignoring command as the same media resource is provided. If you want to force the reloading of the same media resource, call method reset first."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public reset()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#reset"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Reseting the media player associated resources."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->unloadAdComponents()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->resetInternalComponents()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#reset()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Reseting the media player instance"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->reset()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerView:Lcom/adobe/mediacore/MediaPlayerView;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerView;->resetView()V

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->IDLE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    return-void
.end method

.method public seek(J)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TrickPlayManager;->trickPlayEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#seek"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "MediaPlayer.seek() is not allowed during trick-play."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->READY:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->COMPLETE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid player status [ "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] for operation [play]."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->adjustDesiredSeekPosition(J)V

    goto :goto_0
.end method

.method public seekToLocalTime(J)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineAdapter;->getVirtualTimeForLocalTime(J)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->seek(J)V

    :cond_0
    return-void
.end method

.method public setABRControlParameters(Lcom/adobe/mediacore/ABRControlParameters;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#setABRControlParameters"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Setting ABR control params: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/ABRControlParameters;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setABRControlParameters(Lcom/adobe/mediacore/ABRControlParameters;)V

    return-void
.end method

.method public setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "BufferControlParameters parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#setBufferControlParameters"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Setting buffer control params: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/BufferControlParameters;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V

    return-void
.end method

.method public setCCStyle(Lcom/adobe/mediacore/TextFormat;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_closedCaptionsTextFormat:Lcom/adobe/mediacore/TextFormat;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setCaptionsControlParameters(Lcom/adobe/mediacore/TextFormat;)V

    return-void
.end method

.method public setCCVisibility(Lcom/adobe/mediacore/MediaPlayer$Visibility;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setCaptionsVisibility(Lcom/adobe/mediacore/MediaPlayer$Visibility;)V

    return-void
.end method

.method public setCustomConfiguration(Ljava/lang/String;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#setCustomConfiguration"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Setting custom configuration: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setCustomConfiguration(Ljava/lang/String;)V

    return-void
.end method

.method public setRate(F)V
    .locals 4

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#setRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Setting playback rate: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TrickPlayManager;->changePlaybackRate(F)V

    return-void
.end method

.method protected declared-synchronized setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
    .locals 4

    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#setStatus"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Set player state to: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-static {v1, p2}, Lcom/adobe/mediacore/StateChangedEvent;->createChangedEvent(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)Lcom/adobe/mediacore/StateChangedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setVolume(I)V
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setVolume(I)V

    return-void
.end method

.method public shouldTriggerSubscribedTagEvent()Z
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getCurrentTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->shouldTriggerSubscribedTagEvent(J)Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public unregisterCurrentBackgroundItem()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    const/4 v1, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfReleased()V

    invoke-direct {p0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->checkAndThrowIfError()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_backgroundResource:Lcom/adobe/mediacore/MediaResource;

    if-eqz v0, :cond_0

    iput-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_backgroundResource:Lcom/adobe/mediacore/MediaResource;

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_backgroundItem:Lcom/adobe/mediacore/MediaPlayerItem;

    if-eqz v0, :cond_1

    iput-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer;->_backgroundItem:Lcom/adobe/mediacore/MediaPlayerItem;

    :cond_1
    return-void
.end method
