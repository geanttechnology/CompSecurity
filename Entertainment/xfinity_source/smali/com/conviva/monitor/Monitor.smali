.class public Lcom/conviva/monitor/Monitor;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/conviva/monitor/IMonitorNotifier;


# static fields
.field private static _utils:Lcom/conviva/utils/PlatformUtils;


# instance fields
.field private final _NUM_PHT_OBSERVATIONS:I

.field private final _PHT_MIN_SAMPLES:I

.field private final _PHT_PAUSED_EXPECTED_SPEED:I

.field private final _PHT_PLAY_EXPECTED_SPEED:I

.field private final _PHT_TOLERANCE:F

.field private _adStartTimeMs:D

.field private _adTimeMs:I

.field private _api:Lcom/conviva/platforms/PlatformApi;

.field private _bitrateKbps:I

.field private _bufferingEventCount:I

.field private _cdn:Ljava/lang/String;

.field private _contentInfo:Lcom/conviva/ConvivaContentInfo;

.field private _contentLenMs:I

.field private _cumulativeTimePerState:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private _encodedFps:I

.field private _eventQueue:Lcom/conviva/session/EventQueue;

.field private _explicitPlayerPaused:Z

.field private _externalBitrateReporting:Z

.field private _isProxyCreatedOutside:Z

.field private _joinTimeMs:I

.field private _lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/conviva/utils/SlidingWindow",
            "<",
            "Ljava/lang/Number;",
            ">;"
        }
    .end annotation
.end field

.field private _lastPlayHeadTimeMs:I

.field private _lastPollTimeMs:D

.field private _lastStateUpdateTimeMs:D

.field private _nominalPlayingBitsTotal:D

.field private _playingFpsObservationCount:I

.field private _playingFpsTotal:D

.field private _playingState:I

.field private _pollStreamerTask:Ljava/util/TimerTask;

.field private _preGingerBread:Z

.field private _resource:Ljava/lang/String;

.field private _sessionFlags:I

.field private _sessionId:I

.field private _startTimeMs:D

.field private _streamer:Lcom/conviva/ConvivaStreamerProxy;

.field private _streamerObject:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;Lcom/conviva/session/EventQueue;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;ILcom/conviva/platforms/PlatformApi;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/conviva/session/EventQueue;",
            "Lcom/conviva/ConvivaContentInfo;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;I",
            "Lcom/conviva/platforms/PlatformApi;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v1, 0x1

    const/4 v8, -0x1

    const/4 v3, 0x0

    const-wide/16 v6, 0x0

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_sessionId:I

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_streamerObject:Ljava/lang/Object;

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_eventQueue:Lcom/conviva/session/EventQueue;

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_api:Lcom/conviva/platforms/PlatformApi;

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_startTimeMs:D

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_adStartTimeMs:D

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_adTimeMs:I

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_lastStateUpdateTimeMs:D

    iput-boolean v2, p0, Lcom/conviva/monitor/Monitor;->_explicitPlayerPaused:Z

    iput-boolean v2, p0, Lcom/conviva/monitor/Monitor;->_externalBitrateReporting:Z

    iput-boolean v2, p0, Lcom/conviva/monitor/Monitor;->_preGingerBread:Z

    iput-boolean v2, p0, Lcom/conviva/monitor/Monitor;->_isProxyCreatedOutside:Z

    const/16 v0, 0x64

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    iput v8, p0, Lcom/conviva/monitor/Monitor;->_bitrateKbps:I

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_cdn:Ljava/lang/String;

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_resource:Ljava/lang/String;

    iput v1, p0, Lcom/conviva/monitor/Monitor;->_sessionFlags:I

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    iput v8, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_bufferingEventCount:I

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_nominalPlayingBitsTotal:D

    iput v8, p0, Lcom/conviva/monitor/Monitor;->_encodedFps:I

    iput v8, p0, Lcom/conviva/monitor/Monitor;->_contentLenMs:I

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_playingFpsObservationCount:I

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_playingFpsTotal:D

    const/4 v0, 0x5

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_NUM_PHT_OBSERVATIONS:I

    const/4 v0, 0x3

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_PHT_MIN_SAMPLES:I

    iput v1, p0, Lcom/conviva/monitor/Monitor;->_PHT_PLAY_EXPECTED_SPEED:I

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_PHT_PAUSED_EXPECTED_SPEED:I

    const/high16 v0, 0x3f000000    # 0.5f

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_PHT_TOLERANCE:F

    iput-object v3, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    new-instance v0, Lcom/conviva/monitor/Monitor$1;

    invoke-direct {v0, p0}, Lcom/conviva/monitor/Monitor$1;-><init>(Lcom/conviva/monitor/Monitor;)V

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_pollStreamerTask:Ljava/util/TimerTask;

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_lastPollTimeMs:D

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_lastPlayHeadTimeMs:I

    iput-object p2, p0, Lcom/conviva/monitor/Monitor;->_eventQueue:Lcom/conviva/session/EventQueue;

    invoke-static {}, Lcom/conviva/utils/PlatformUtils;->getInstance()Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    sput-object v0, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    iput-object p3, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iput p5, p0, Lcom/conviva/monitor/Monitor;->_sessionId:I

    iput-object p6, p0, Lcom/conviva/monitor/Monitor;->_api:Lcom/conviva/platforms/PlatformApi;

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_startTimeMs:D

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_adStartTimeMs:D

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_adTimeMs:I

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_lastStateUpdateTimeMs:D

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    sget-object v0, Lcom/conviva/monitor/PlayerStates;->stateToInt:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    iget-object v4, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_0
    iput v8, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_bufferingEventCount:I

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_nominalPlayingBitsTotal:D

    iput v8, p0, Lcom/conviva/monitor/Monitor;->_encodedFps:I

    iput v8, p0, Lcom/conviva/monitor/Monitor;->_contentLenMs:I

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_playingFpsObservationCount:I

    iput-wide v6, p0, Lcom/conviva/monitor/Monitor;->_playingFpsTotal:D

    iput-object p1, p0, Lcom/conviva/monitor/Monitor;->_streamerObject:Ljava/lang/Object;

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    check-cast v0, Lcom/conviva/streamerProxies/NativeStreamerProxy;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->getApiLevel()I

    move-result v0

    const/16 v3, 0x9

    if-ge v0, v3, :cond_1

    iput-boolean v1, p0, Lcom/conviva/monitor/Monitor;->_preGingerBread:Z

    :cond_1
    if-eqz p4, :cond_2

    const-string v0, "explicitPlayerPaused"

    invoke-interface {p4, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "explicitPlayerPaused"

    invoke-interface {p4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/conviva/monitor/Monitor;->_explicitPlayerPaused:Z

    const-string v0, "externalBitrateReporting"

    invoke-interface {p4, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    const-string v0, "externalBitrateReporting"

    invoke-interface {p4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_4

    :goto_2
    iput-boolean v1, p0, Lcom/conviva/monitor/Monitor;->_externalBitrateReporting:Z

    :cond_2
    return-void

    :cond_3
    move v0, v2

    goto :goto_1

    :cond_4
    move v1, v2

    goto :goto_2
.end method

.method private InferPlayingState(D)V
    .locals 10

    const/4 v9, 0x1

    const/4 v2, 0x0

    const/16 v8, 0xc

    const/4 v7, 0x6

    const/4 v6, 0x3

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget v0, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    if-gez v0, :cond_2

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->GetRenderedFrameRate()D

    move-result-wide v0

    const-wide/16 v4, 0x0

    cmpl-double v0, v0, v4

    if-lez v0, :cond_2

    const/4 v0, -0x3

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "infer state to PLAYING, rendered frame rate is "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v1}, Lcom/conviva/ConvivaStreamerProxy;->GetRenderedFrameRate()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0, v6}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    goto :goto_0

    :cond_2
    const-class v0, Lcom/conviva/streamerProxies/NativeStreamerProxy;

    iget-object v1, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    invoke-virtual {v0}, Lcom/conviva/utils/SlidingWindow;->size()I

    move-result v0

    if-lt v0, v6, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    invoke-virtual {v0}, Lcom/conviva/utils/SlidingWindow;->getSlots()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v1, v2

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {v0}, Ljava/lang/Number;->floatValue()F

    move-result v0

    add-float/2addr v0, v1

    move v1, v0

    goto :goto_1

    :cond_3
    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    invoke-virtual {v0}, Lcom/conviva/utils/SlidingWindow;->size()I

    move-result v0

    int-to-float v0, v0

    div-float v0, v1, v0

    iget v1, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    if-eq v1, v6, :cond_4

    const/high16 v1, 0x3f800000    # 1.0f

    sub-float v1, v0, v1

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v1

    const/high16 v3, 0x3f000000    # 0.5f

    cmpg-float v1, v1, v3

    if-gez v1, :cond_4

    const-string v0, "infer state PLAYING, PHT is moving"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0, v6}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    goto/16 :goto_0

    :cond_4
    iget v1, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    if-ltz v1, :cond_0

    cmpl-float v0, v0, v2

    if-nez v0, :cond_0

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    if-eq v0, v9, :cond_6

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_lastPlayHeadTimeMs:I

    if-eqz v0, :cond_5

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_lastPlayHeadTimeMs:I

    iget v1, p0, Lcom/conviva/monitor/Monitor;->_contentLenMs:I

    if-ne v0, v1, :cond_6

    :cond_5
    const-string v0, "infer STOPPED state, PHT is not moving and is 0"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0, v9}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    goto/16 :goto_0

    :cond_6
    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->GetBufferLengthMs()I

    move-result v1

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    if-eq v0, v6, :cond_7

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    const/16 v2, 0x64

    if-ne v0, v2, :cond_9

    :cond_7
    if-ltz v1, :cond_b

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->GetMinBufferLengthMs()I

    move-result v0

    iget v2, p0, Lcom/conviva/monitor/Monitor;->_contentLenMs:I

    iget v3, p0, Lcom/conviva/monitor/Monitor;->_lastPlayHeadTimeMs:I

    sub-int/2addr v2, v3

    if-le v0, v2, :cond_8

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_contentLenMs:I

    iget v2, p0, Lcom/conviva/monitor/Monitor;->_lastPlayHeadTimeMs:I

    sub-int/2addr v0, v2

    :cond_8
    if-ge v1, v0, :cond_a

    const-string v0, "infer BUFFERING state, PHT is not moving and buffer length is less than minBufferlen"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0, v7}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    :cond_9
    :goto_2
    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    if-ne v0, v7, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->GetStartingBufferLengthMs()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->GetStartingBufferLengthMs()I

    move-result v0

    if-le v1, v0, :cond_0

    const-string v0, "infer PAUSED state, buffer length grew longer than starting bufferLen."

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0, v8}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    goto/16 :goto_0

    :cond_a
    const-string v0, "infer PAUSED state, PHT is not moving"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0, v8}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    goto :goto_2

    :cond_b
    iget-boolean v0, p0, Lcom/conviva/monitor/Monitor;->_explicitPlayerPaused:Z

    if-nez v0, :cond_c

    iget-boolean v0, p0, Lcom/conviva/monitor/Monitor;->_preGingerBread:Z

    if-eqz v0, :cond_d

    :cond_c
    const-string v0, "infer BUFFERING state, PHT is not moving and buffer length is unavailable"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0, v7}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    goto :goto_2

    :cond_d
    const-string v0, "infer PAUSED state, PHT is not moving and buffer events are available"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0, v8}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    goto :goto_2
.end method

.method static synthetic access$000(Lcom/conviva/monitor/Monitor;)V
    .locals 0

    invoke-direct {p0}, Lcom/conviva/monitor/Monitor;->pollStreamer()V

    return-void
.end method

.method private clearPHTSamples()V
    .locals 1

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    invoke-virtual {v0}, Lcom/conviva/utils/SlidingWindow;->clear()V

    :cond_0
    return-void
.end method

.method private enqueueEvent(Ljava/lang/String;Ljava/util/Map;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_eventQueue:Lcom/conviva/session/EventQueue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_eventQueue:Lcom/conviva/session/EventQueue;

    sget-object v1, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v1}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v2

    iget-wide v4, p0, Lcom/conviva/monitor/Monitor;->_startTimeMs:D

    sub-double/2addr v2, v4

    double-to-int v1, v2

    invoke-virtual {v0, p1, p2, v1}, Lcom/conviva/session/EventQueue;->enqueueEvent(Ljava/lang/String;Ljava/util/Map;I)V

    :cond_0
    return-void
.end method

.method private enqueueStateChange(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 3

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    if-eqz p2, :cond_0

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {v1, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "old"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {v1, p1, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "new"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "CwsStateChangeEvent"

    invoke-direct {p0, v1, v0}, Lcom/conviva/monitor/Monitor;->enqueueEvent(Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method private pollStreamer()V
    .locals 8

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->GetPlayheadTimeMs()I

    move-result v0

    sget-object v1, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v1}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v2

    if-ltz v0, :cond_1

    iget-wide v4, p0, Lcom/conviva/monitor/Monitor;->_lastPollTimeMs:D

    const-wide/16 v6, 0x0

    cmpl-double v1, v4, v6

    if-lez v1, :cond_1

    iget-wide v4, p0, Lcom/conviva/monitor/Monitor;->_lastPollTimeMs:D

    cmpl-double v1, v2, v4

    if-lez v1, :cond_1

    iget-object v1, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    iget v4, p0, Lcom/conviva/monitor/Monitor;->_lastPlayHeadTimeMs:I

    sub-int v4, v0, v4

    int-to-float v4, v4

    iget-wide v6, p0, Lcom/conviva/monitor/Monitor;->_lastPollTimeMs:D

    sub-double v6, v2, v6

    double-to-float v5, v6

    div-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/conviva/utils/SlidingWindow;->add(Ljava/lang/Object;)V

    :cond_1
    iput-wide v2, p0, Lcom/conviva/monitor/Monitor;->_lastPollTimeMs:D

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_lastPlayHeadTimeMs:I

    invoke-direct {p0, v2, v3}, Lcom/conviva/monitor/Monitor;->InferPlayingState(D)V

    goto :goto_0
.end method

.method private updateMetrics()V
    .locals 4

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->GetRenderedFrameRate()D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpl-double v2, v0, v2

    if-ltz v2, :cond_1

    iget-wide v2, p0, Lcom/conviva/monitor/Monitor;->_playingFpsTotal:D

    add-double/2addr v0, v2

    iput-wide v0, p0, Lcom/conviva/monitor/Monitor;->_playingFpsTotal:D

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingFpsObservationCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_playingFpsObservationCount:I

    :cond_1
    invoke-direct {p0}, Lcom/conviva/monitor/Monitor;->updateStateCumulativeTime()V

    goto :goto_0
.end method

.method private updateStateCumulativeTime()V
    .locals 7

    sget-object v0, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v2

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    const/16 v1, 0x64

    if-eq v0, v1, :cond_0

    iget-wide v0, p0, Lcom/conviva/monitor/Monitor;->_lastStateUpdateTimeMs:D

    sub-double v0, v2, v0

    double-to-int v1, v0

    iget-object v4, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    iget v6, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v0, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    add-int/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v4, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    const/4 v4, 0x3

    if-ne v0, v4, :cond_0

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_bitrateKbps:I

    const/4 v4, -0x1

    if-eq v0, v4, :cond_0

    iget-wide v4, p0, Lcom/conviva/monitor/Monitor;->_nominalPlayingBitsTotal:D

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_bitrateKbps:I

    mul-int/2addr v0, v1

    int-to-double v0, v0

    add-double/2addr v0, v4

    iput-wide v0, p0, Lcom/conviva/monitor/Monitor;->_nominalPlayingBitsTotal:D

    :cond_0
    iput-wide v2, p0, Lcom/conviva/monitor/Monitor;->_lastStateUpdateTimeMs:D

    return-void
.end method

.method private wrapInConvivaStreamerProxy(Ljava/lang/Object;)Lcom/conviva/ConvivaStreamerProxy;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v4, 0x1

    const/4 v3, 0x0

    const-class v0, Lcom/conviva/ConvivaStreamerProxy;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iput-boolean v4, p0, Lcom/conviva/monitor/Monitor;->_isProxyCreatedOutside:Z

    const-string v0, "streamer is ConvivaStreamerProxy"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    check-cast p1, Lcom/conviva/ConvivaStreamerProxy;

    :goto_0
    return-object p1

    :cond_0
    iput-boolean v3, p0, Lcom/conviva/monitor/Monitor;->_isProxyCreatedOutside:Z

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const/4 v0, 0x0

    :try_start_0
    const-string v2, "android.media.MediaPlayer"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v2, "com.conviva.streamerProxies.MediaPlayerProxy"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4

    move-result-object v0

    :cond_1
    :goto_1
    :try_start_1
    const-string v2, "android.widget.VideoView"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_2

    const-string v2, "com.conviva.streamerProxies.VideoViewProxy"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    move-result-object v0

    :cond_2
    :goto_2
    :try_start_2
    const-string v2, "com.nexstreaming.nexplayerengine.NexPlayer"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string v2, "com.conviva.streamerProxies.NexStreamingProxy"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v0

    :cond_3
    :goto_3
    :try_start_3
    const-string v2, "com.visualon.OSMPBasePlayer.voOSBasePlayer"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_4

    const-string v2, "com.conviva.streamerProxies.VisualOnProxy"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    move-result-object v0

    :cond_4
    :goto_4
    :try_start_4
    const-string v2, "com.visualon.OSMPPlayer.VOCommonPlayer"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_5

    const-string v1, "com.conviva.streamerProxies.VisualOnImplProxy"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    move-result-object v0

    :cond_5
    :goto_5
    if-eqz v0, :cond_6

    new-array v1, v4, [Ljava/lang/Class;

    const-class v2, Ljava/lang/Object;

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    new-array v1, v4, [Ljava/lang/Object;

    aput-object p1, v1, v3

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/conviva/ConvivaStreamerProxy;

    move-object p1, v0

    goto :goto_0

    :cond_6
    sget-object v0, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "The streamer is not recognizable, class: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->err(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/Exception;

    const-string v1, "Monitoring unimplemented for streamer"

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0

    :catch_0
    move-exception v1

    goto :goto_5

    :catch_1
    move-exception v2

    goto :goto_4

    :catch_2
    move-exception v2

    goto :goto_3

    :catch_3
    move-exception v2

    goto :goto_2

    :catch_4
    move-exception v2

    goto/16 :goto_1
.end method


# virtual methods
.method public Log(Ljava/lang/String;)V
    .locals 2

    sget-object v0, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    iget v1, p0, Lcom/conviva/monitor/Monitor;->_sessionId:I

    invoke-virtual {v0, p1, v1}, Lcom/conviva/utils/PlatformUtils;->logSession(Ljava/lang/String;I)V

    return-void
.end method

.method public OnError(Lcom/conviva/StreamerError;)V
    .locals 4

    const/4 v0, 0x1

    const-string v1, "Enqueue CwsErrorEvent"

    invoke-virtual {p0, v1}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/conviva/StreamerError;->getSeverity()I

    move-result v1

    if-ne v1, v0, :cond_1

    :goto_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    const-string v2, "ft"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "err"

    invoke-virtual {p1}, Lcom/conviva/StreamerError;->getErrorCode()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "CwsErrorEvent"

    invoke-direct {p0, v2, v1}, Lcom/conviva/monitor/Monitor;->enqueueEvent(Ljava/lang/String;Ljava/util/Map;)V

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    if-gez v0, :cond_0

    const/4 v0, -0x2

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    :cond_0
    return-void

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public OnMetadata(Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    :try_start_0
    const-string v0, "framerate"

    invoke-interface {p1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v1, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v0, "framerate"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/4 v2, -0x1

    invoke-virtual {v1, v0, v2}, Lcom/conviva/utils/PlatformUtils;->parseInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_encodedFps:I

    :cond_0
    const-string v0, "duration"

    invoke-interface {p1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    sget-object v1, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v0, "duration"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/4 v2, -0x1

    invoke-virtual {v1, v0, v2}, Lcom/conviva/utils/PlatformUtils;->parseInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_contentLenMs:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_0
    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "monitor.OnMetadata() error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public SetPlayingState(I)V
    .locals 10

    const/4 v9, 0x3

    const/4 v8, 0x6

    const/4 v1, 0x1

    const/4 v0, 0x0

    iget v2, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    if-ne v2, p1, :cond_0

    :goto_0
    return-void

    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Change state to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/conviva/monitor/Monitor;->updateStateCumulativeTime()V

    iget v2, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    if-ltz v2, :cond_7

    move v2, v1

    :goto_1
    if-nez v2, :cond_3

    if-ne p1, v9, :cond_3

    iget-object v3, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-wide v4, p0, Lcom/conviva/monitor/Monitor;->_adStartTimeMs:D

    const-wide/16 v6, 0x0

    cmpl-double v3, v4, v6

    if-lez v3, :cond_1

    invoke-virtual {p0}, Lcom/conviva/monitor/Monitor;->adEnd()V

    :cond_1
    sget-object v3, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v3}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v4

    iget-wide v6, p0, Lcom/conviva/monitor/Monitor;->_startTimeMs:D

    sub-double/2addr v4, v6

    iget v3, p0, Lcom/conviva/monitor/Monitor;->_adTimeMs:I

    int-to-double v6, v3

    sub-double/2addr v4, v6

    double-to-int v3, v4

    iput v3, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    iget v3, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    if-gez v3, :cond_2

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    :cond_2
    move v0, v1

    :cond_3
    if-eqz v2, :cond_4

    if-ne p1, v8, :cond_4

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_bufferingEventCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_bufferingEventCount:I

    move v0, v1

    :cond_4
    iget v2, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    if-ne v2, v8, :cond_5

    if-ne p1, v9, :cond_5

    move v0, v1

    :cond_5
    if-eqz v0, :cond_6

    invoke-direct {p0}, Lcom/conviva/monitor/Monitor;->clearPHTSamples()V

    :cond_6
    const-string v0, "ps"

    iget v1, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/conviva/monitor/Monitor;->enqueueStateChange(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    iput p1, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    goto :goto_0

    :cond_7
    move v2, v0

    goto :goto_1
.end method

.method public adEnd()V
    .locals 10

    const/4 v1, 0x0

    const-wide/16 v8, 0x0

    const-string v0, "monitor.adEnd()"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    iget-wide v2, p0, Lcom/conviva/monitor/Monitor;->_adStartTimeMs:D

    cmpl-double v0, v2, v8

    if-lez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    iget v2, p0, Lcom/conviva/monitor/Monitor;->_adTimeMs:I

    int-to-double v2, v2

    sget-object v4, Lcom/conviva/monitor/Monitor;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v4}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v4

    iget-wide v6, p0, Lcom/conviva/monitor/Monitor;->_adStartTimeMs:D

    sub-double/2addr v4, v6

    add-double/2addr v2, v4

    double-to-int v2, v2

    iput v2, p0, Lcom/conviva/monitor/Monitor;->_adTimeMs:I

    :cond_0
    iput-wide v8, p0, Lcom/conviva/monitor/Monitor;->_adStartTimeMs:D

    const-string v2, "pj"

    new-instance v3, Ljava/lang/Boolean;

    invoke-direct {v3, v1}, Ljava/lang/Boolean;-><init>(Z)V

    invoke-direct {p0, v2, v0, v3}, Lcom/conviva/monitor/Monitor;->enqueueStateChange(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    return-void

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public attachStreamer(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    if-nez p1, :cond_0

    const-string v0, "monitor.attachStreamer() received a null streamer"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    const/16 v0, 0x62

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    :goto_0
    return-void

    :cond_0
    const/16 v0, 0x64

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    const-string v0, "monitor.attachStreamer()"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-direct {p0, p1}, Lcom/conviva/monitor/Monitor;->wrapInConvivaStreamerProxy(Ljava/lang/Object;)Lcom/conviva/ConvivaStreamerProxy;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->GetCapabilities()I

    move-result v0

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_sessionFlags:I

    iget-boolean v0, p0, Lcom/conviva/monitor/Monitor;->_externalBitrateReporting:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_sessionFlags:I

    or-int/lit8 v0, v0, 0x10

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_sessionFlags:I

    :cond_1
    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0, p0}, Lcom/conviva/ConvivaStreamerProxy;->startMonitoring(Lcom/conviva/monitor/IMonitorNotifier;)V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/conviva/monitor/Monitor;->_lastPollTimeMs:D

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_api:Lcom/conviva/platforms/PlatformApi;

    iget-object v1, p0, Lcom/conviva/monitor/Monitor;->_pollStreamerTask:Ljava/util/TimerTask;

    const/16 v2, 0xc8

    invoke-interface {v0, v1, v2}, Lcom/conviva/platforms/PlatformApi;->createPollTask(Ljava/util/TimerTask;I)V

    goto :goto_0
.end method

.method public cleanup()V
    .locals 2

    const/4 v1, 0x0

    const-string v0, "monitor.cleanup()"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/conviva/monitor/Monitor;->pauseMonitor()V

    iput-object v1, p0, Lcom/conviva/monitor/Monitor;->_api:Lcom/conviva/platforms/PlatformApi;

    iput-object v1, p0, Lcom/conviva/monitor/Monitor;->_eventQueue:Lcom/conviva/session/EventQueue;

    iput-object v1, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    return-void
.end method

.method public pauseMonitor()V
    .locals 2

    const/4 v1, 0x0

    const-string v0, "monitor.pauseMonitor()"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/conviva/monitor/Monitor;->updateMetrics()V

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0, v1}, Lcom/conviva/ConvivaStreamerProxy;->startMonitoring(Lcom/conviva/monitor/IMonitorNotifier;)V

    iget-boolean v0, p0, Lcom/conviva/monitor/Monitor;->_isProxyCreatedOutside:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    iput-object v1, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v0}, Lcom/conviva/ConvivaStreamerProxy;->Cleanup()V

    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    invoke-virtual {v0}, Lcom/conviva/utils/SlidingWindow;->clear()V

    :cond_1
    const/16 v0, 0x62

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->SetPlayingState(I)V

    return-void

    :cond_2
    const-string v0, "Streamer Proxy is not created by Conviva and will not be cleaned up by Conviva Library"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    goto :goto_0
.end method

.method public start(D)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const-string v0, "monitor starts"

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->Log(Ljava/lang/String;)V

    iput-wide p1, p0, Lcom/conviva/monitor/Monitor;->_startTimeMs:D

    iput-wide p1, p0, Lcom/conviva/monitor/Monitor;->_lastStateUpdateTimeMs:D

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, v0, Lcom/conviva/ConvivaContentInfo;->defaultReportingCdnName:Ljava/lang/String;

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_cdn:Ljava/lang/String;

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, v0, Lcom/conviva/ConvivaContentInfo;->defaultReportingResource:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_cdn:Ljava/lang/String;

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_resource:Ljava/lang/String;

    :goto_0
    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget v0, v0, Lcom/conviva/ConvivaContentInfo;->defaultReportingBitrateKbps:I

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_bitrateKbps:I

    :goto_1
    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamerObject:Ljava/lang/Object;

    invoke-virtual {p0, v0}, Lcom/conviva/monitor/Monitor;->attachStreamer(Ljava/lang/Object;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_streamerObject:Ljava/lang/Object;

    new-instance v0, Lcom/conviva/utils/SlidingWindow;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Lcom/conviva/utils/SlidingWindow;-><init>(I)V

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_lastPHTSpeeds:Lcom/conviva/utils/SlidingWindow;

    const/4 v0, 0x0

    iput v0, p0, Lcom/conviva/monitor/Monitor;->_lastPlayHeadTimeMs:I

    return-void

    :cond_0
    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, v0, Lcom/conviva/ConvivaContentInfo;->defaultReportingResource:Ljava/lang/String;

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_resource:Ljava/lang/String;

    goto :goto_0

    :cond_1
    const-string v0, "OTHER"

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_cdn:Ljava/lang/String;

    const-string v0, "OTHER"

    iput-object v0, p0, Lcom/conviva/monitor/Monitor;->_resource:Ljava/lang/String;

    goto :goto_1
.end method

.method public updateHeartbeat(Ljava/util/Map;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    const/4 v3, -0x1

    const/4 v1, 0x1

    const/4 v2, 0x0

    const-wide/16 v10, 0x0

    invoke-direct {p0}, Lcom/conviva/monitor/Monitor;->updateMetrics()V

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    const/4 v4, 0x3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    if-ltz v0, :cond_8

    move v0, v1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    const/4 v6, 0x6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v0, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    :goto_1
    const-string v6, "ps"

    iget v7, p0, Lcom/conviva/monitor/Monitor;->_playingState:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-interface {p1, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v6, "pj"

    iget-wide v8, p0, Lcom/conviva/monitor/Monitor;->_adStartTimeMs:D

    cmpl-double v7, v8, v10

    if-lez v7, :cond_0

    move v2, v1

    :cond_0
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {p1, v6, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "sf"

    iget v6, p0, Lcom/conviva/monitor/Monitor;->_sessionFlags:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {p1, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    if-eqz v2, :cond_1

    const-string v2, "fw"

    iget-object v6, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v6}, Lcom/conviva/ConvivaStreamerProxy;->GetStreamerType()Ljava/lang/String;

    move-result-object v6

    invoke-interface {p1, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, p0, Lcom/conviva/monitor/Monitor;->_streamer:Lcom/conviva/ConvivaStreamerProxy;

    invoke-interface {v2}, Lcom/conviva/ConvivaStreamerProxy;->GetStreamerVersion()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    const-string v6, "fwv"

    invoke-interface {p1, v6, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    iget-object v2, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v2, v2, Lcom/conviva/ConvivaContentInfo;->streamUrl:Ljava/lang/String;

    if-eqz v2, :cond_2

    const-string v2, "url"

    iget-object v6, p0, Lcom/conviva/monitor/Monitor;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v6, v6, Lcom/conviva/ConvivaContentInfo;->streamUrl:Ljava/lang/String;

    invoke-interface {p1, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    const-string v2, "rs"

    iget-object v6, p0, Lcom/conviva/monitor/Monitor;->_resource:Ljava/lang/String;

    invoke-interface {p1, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "cdn"

    iget-object v6, p0, Lcom/conviva/monitor/Monitor;->_cdn:Ljava/lang/String;

    invoke-interface {p1, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget v2, p0, Lcom/conviva/monitor/Monitor;->_contentLenMs:I

    if-ltz v2, :cond_3

    const-string v2, "cl"

    iget v6, p0, Lcom/conviva/monitor/Monitor;->_contentLenMs:I

    int-to-double v6, v6

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v6, v8

    double-to-int v6, v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {p1, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    iget v2, p0, Lcom/conviva/monitor/Monitor;->_encodedFps:I

    if-ltz v2, :cond_4

    const-string v2, "efps"

    iget v6, p0, Lcom/conviva/monitor/Monitor;->_encodedFps:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {p1, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_4
    iget v2, p0, Lcom/conviva/monitor/Monitor;->_playingFpsObservationCount:I

    if-lez v2, :cond_9

    iget-wide v6, p0, Lcom/conviva/monitor/Monitor;->_playingFpsTotal:D

    add-double/2addr v6, v10

    iget v2, p0, Lcom/conviva/monitor/Monitor;->_playingFpsObservationCount:I

    int-to-double v8, v2

    div-double/2addr v6, v8

    double-to-int v2, v6

    :goto_2
    if-ltz v2, :cond_5

    const-string v6, "afps"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {p1, v6, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5
    const-string v2, "tpt"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {p1, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "tbt"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {p1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "tpst"

    iget-object v2, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    const/16 v6, 0xc

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-interface {p1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "tst"

    iget-object v2, p0, Lcom/conviva/monitor/Monitor;->_cumulativeTimePerState:Ljava/util/Map;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "jt"

    iget v1, p0, Lcom/conviva/monitor/Monitor;->_joinTimeMs:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "tbe"

    iget v1, p0, Lcom/conviva/monitor/Monitor;->_bufferingEventCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget v0, p0, Lcom/conviva/monitor/Monitor;->_bitrateKbps:I

    if-lez v0, :cond_6

    const-string v0, "cbr"

    iget v1, p0, Lcom/conviva/monitor/Monitor;->_bitrateKbps:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "br"

    iget v1, p0, Lcom/conviva/monitor/Monitor;->_bitrateKbps:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_6
    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_a

    iget-wide v0, p0, Lcom/conviva/monitor/Monitor;->_nominalPlayingBitsTotal:D

    cmpl-double v0, v0, v10

    if-ltz v0, :cond_a

    iget-wide v0, p0, Lcom/conviva/monitor/Monitor;->_nominalPlayingBitsTotal:D

    add-double/2addr v0, v10

    int-to-double v2, v4

    div-double/2addr v0, v2

    double-to-int v0, v0

    :goto_3
    if-lez v0, :cond_7

    const-string v1, "abr"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_7
    return-void

    :cond_8
    move v0, v2

    goto/16 :goto_0

    :cond_9
    move v2, v3

    goto/16 :goto_2

    :cond_a
    move v0, v3

    goto :goto_3

    :cond_b
    move v0, v2

    goto/16 :goto_1
.end method
