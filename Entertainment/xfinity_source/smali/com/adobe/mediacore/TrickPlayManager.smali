.class public Lcom/adobe/mediacore/TrickPlayManager;
.super Ljava/lang/Object;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field public static final NORMAL_PLAYBACK_RATE:F = 1.0f

.field public static final PAUSE_PLAYBACK_RATE:F

.field private static final _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private _currentPlaybackRate:F

.field private _dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

.field private _engine:Lcom/adobe/mediacore/VideoEngineAdapter;

.field private _initialTrickPlayPosition:J

.field private _item:Lcom/adobe/mediacore/MediaPlayerItem;

.field private _lastUpdatedTime:J

.field private _pendingRatePlayingEvent:Z

.field private _player:Lcom/adobe/mediacore/MediaPlayer;

.field private _returningFromTrickPlay:Z

.field private final _seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

.field private _timelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/TrickPlayManager;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayer;Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/TimelineMonitor;Lcom/adobe/mediacore/VideoEngineDispatcher;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    iput-boolean v1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z

    iput-boolean v1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_pendingRatePlayingEvent:Z

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_lastUpdatedTime:J

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_initialTrickPlayPosition:J

    new-instance v0, Lcom/adobe/mediacore/TrickPlayManager$2;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/TrickPlayManager$2;-><init>(Lcom/adobe/mediacore/TrickPlayManager;)V

    iput-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    iput-object p1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_player:Lcom/adobe/mediacore/MediaPlayer;

    iput-object p3, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    iput-object p4, p0, Lcom/adobe/mediacore/TrickPlayManager;->_timelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    iput-object p5, p0, Lcom/adobe/mediacore/TrickPlayManager;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object p2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-direct {p0}, Lcom/adobe/mediacore/TrickPlayManager;->addEventListeners()V

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/TrickPlayManager;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z

    return v0
.end method

.method static synthetic access$002(Lcom/adobe/mediacore/TrickPlayManager;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z

    return p1
.end method

.method static synthetic access$100(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/VideoEngineDispatcher;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    return-object v0
.end method

.method static synthetic access$200(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/SeekAdjustCompletedListener;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    return-object v0
.end method

.method static synthetic access$300(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/VideoEngineAdapter;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    return-object v0
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/TrickPlayManager;)F
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    return v0
.end method

.method static synthetic access$500()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600()Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$700(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/MediaPlayer;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_player:Lcom/adobe/mediacore/MediaPlayer;

    return-object v0
.end method

.method static synthetic access$800(Lcom/adobe/mediacore/TrickPlayManager;F)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TrickPlayManager;->changeRateWithoutRemovingAds(F)V

    return-void
.end method

.method static synthetic access$902(Lcom/adobe/mediacore/TrickPlayManager;J)J
    .locals 1

    iput-wide p1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_initialTrickPlayPosition:J

    return-wide p1
.end method

.method private addEventListeners()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v2, Lcom/adobe/mediacore/TrickPlayManager$1;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/TrickPlayManager$1;-><init>(Lcom/adobe/mediacore/TrickPlayManager;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    return-void
.end method

.method private changeRateWithoutRemovingAds(F)V
    .locals 3

    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#changeRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "switching from one slow motion rate to another slow motion rate"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TrickPlayManager;->getActualRate(F)F

    move-result v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->enableTrickPlay(FZ)V

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_pendingRatePlayingEvent:Z

    iput v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    return-void
.end method

.method private getActualRate(F)F
    .locals 8

    const/4 v7, 0x0

    const/high16 v2, -0x40800000    # -1.0f

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_item:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->getAvailablePlaybackRates()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    move v1, v2

    move v3, p1

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v4

    mul-float v0, p1, v4

    cmpl-float v0, v0, v7

    if-lez v0, :cond_2

    const/high16 v0, 0x3f800000    # 1.0f

    cmpl-float v0, v4, v0

    if-eqz v0, :cond_2

    cmpl-float v0, v4, v7

    if-eqz v0, :cond_2

    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    move-result v0

    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v6

    sub-float/2addr v0, v6

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    cmpg-float v6, v0, v1

    if-ltz v6, :cond_0

    cmpl-float v6, v1, v2

    if-nez v6, :cond_2

    :cond_0
    move v1, v4

    :goto_1
    move v3, v1

    move v1, v0

    goto :goto_0

    :cond_1
    return v3

    :cond_2
    move v0, v1

    move v1, v3

    goto :goto_1
.end method

.method private isWithinNormalPlaybackRateRange(F)Z
    .locals 1

    const/4 v0, 0x0

    cmpl-float v0, p1, v0

    if-ltz v0, :cond_0

    const/high16 v0, 0x3f800000    # 1.0f

    cmpg-float v0, p1, v0

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public changePlaybackRate(F)V
    .locals 6

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    const/4 v1, 0x1

    iget v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    cmpl-float v0, p1, v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#changePlaybackRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "this rate has been already set."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/TrickPlayManager;->isWithinNormalPlaybackRateRange(F)Z

    move-result v0

    if-nez v0, :cond_3

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TrickPlayManager;->isWithinNormalPlaybackRateRange(F)Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z

    iget v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/TrickPlayManager;->isWithinNormalPlaybackRateRange(F)Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TrickPlayManager;->isWithinNormalPlaybackRateRange(F)Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    :goto_2
    iget v3, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    invoke-direct {p0, v3}, Lcom/adobe/mediacore/TrickPlayManager;->isWithinNormalPlaybackRateRange(F)Z

    move-result v3

    if-eqz v3, :cond_2

    cmpl-float v3, p1, v5

    if-gtz v3, :cond_1

    const/high16 v3, -0x40800000    # -1.0f

    cmpg-float v3, p1, v3

    if-gez v3, :cond_2

    :cond_1
    move v2, v1

    :cond_2
    if-nez v0, :cond_5

    iget-object v3, p0, Lcom/adobe/mediacore/TrickPlayManager;->_timelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-virtual {v3}, Lcom/adobe/mediacore/TimelineMonitor;->isPlayingAdBreak()Z

    move-result v3

    if-eqz v3, :cond_5

    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#changePlaybackRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Rate cannot be changed during ad breaks."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_1

    :cond_4
    move v0, v2

    goto :goto_2

    :cond_5
    iget-object v3, p0, Lcom/adobe/mediacore/TrickPlayManager;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {p1}, Lcom/adobe/mediacore/PlaybackRateEvent;->createRateSelectedEvent(F)Lcom/adobe/mediacore/PlaybackRateEvent;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    if-eqz v0, :cond_8

    iput p1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    const/4 v0, 0x0

    cmpl-float v0, p1, v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->pause()V

    goto :goto_0

    :cond_6
    cmpl-float v0, p1, v5

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->play()V

    goto :goto_0

    :cond_7
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TrickPlayManager;->changeRateWithoutRemovingAds(F)V

    goto/16 :goto_0

    :cond_8
    iget-boolean v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z

    if-eqz v0, :cond_a

    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#changePlaybackRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "returning back from trick-play mode to playback rate"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->pause()V

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->returnFromTrickPlay()V

    iget-object v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_timelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-virtual {v2}, Lcom/adobe/mediacore/TimelineMonitor;->enableAdBreaks()V

    iget-object v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getVirtualTimeForLocalTime(J)J

    move-result-wide v0

    const/4 v2, -0x1

    invoke-static {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#changePlaybackRate"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "returning to normal mode,  current time="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentTime()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", desired position="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", begin="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Lcom/adobe/mediacore/TrickPlayManager;->_initialTrickPlayPosition:J

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput p1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    iget-object v1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    if-eqz v1, :cond_9

    iget-object v1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_ADJUST_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v3, p0, Lcom/adobe/mediacore/TrickPlayManager;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    invoke-virtual {v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_9
    iget-object v1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_timelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    iget-wide v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_initialTrickPlayPosition:J

    sget-object v4, Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;->TRICK_PLAY:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    invoke-virtual {v1, v0, v2, v3, v4}, Lcom/adobe/mediacore/TimelineMonitor;->adjustSeekPosition(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    goto/16 :goto_0

    :cond_a
    if-eqz v2, :cond_c

    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#changePlaybackRate"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "switching to trick-play mode from allowed playback rate range"

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-wide v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_initialTrickPlayPosition:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-nez v0, :cond_b

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentTime()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_initialTrickPlayPosition:J

    :cond_b
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TrickPlayManager;->getActualRate(F)F

    move-result v0

    iget-object v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_timelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-virtual {v2}, Lcom/adobe/mediacore/TimelineMonitor;->skipAdBreaks()V

    iget-object v2, p0, Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->enableTrickPlay(FZ)V

    iput-boolean v1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_pendingRatePlayingEvent:Z

    iput v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    goto/16 :goto_0

    :cond_c
    sget-object v0, Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#changePlaybackRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "switching from one trick-play rate to another trick-play rate"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TrickPlayManager;->changeRateWithoutRemovingAds(F)V

    goto/16 :goto_0
.end method

.method public getCurrentPlaybackRate()F
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    return v0
.end method

.method public isReturningFromTrickPlay()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z

    return v0
.end method

.method public trickPlayEnabled()Z
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/TrickPlayManager;->isWithinNormalPlaybackRateRange(F)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public update(J)V
    .locals 3

    iget-wide v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_lastUpdatedTime:J

    cmp-long v0, p1, v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_pendingRatePlayingEvent:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_pendingRatePlayingEvent:Z

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget v1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    invoke-static {v1}, Lcom/adobe/mediacore/PlaybackRateEvent;->createRatePlayingEvent(F)Lcom/adobe/mediacore/PlaybackRateEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    iput-wide p1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_lastUpdatedTime:J

    return-void
.end method

.method public updatePlaybackRate(F)V
    .locals 0

    iput p1, p0, Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F

    return-void
.end method
