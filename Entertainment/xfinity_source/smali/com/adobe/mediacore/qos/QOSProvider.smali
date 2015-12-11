.class public final Lcom/adobe/mediacore/qos/QOSProvider;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/qos/QOSProvider$3;
    }
.end annotation


# instance fields
.field private _bufferingMetrics:Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

.field private final _deviceInformation:Lcom/adobe/mediacore/qos/DeviceInformation;

.field private _mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

.field private final _playbackListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

.field private _playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

.field private _playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

.field private _playbackSessionMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;

.field private final _qosListener:Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

.field private _seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/adobe/mediacore/qos/QOSProvider$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/qos/QOSProvider$1;-><init>(Lcom/adobe/mediacore/qos/QOSProvider;)V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_qosListener:Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    new-instance v0, Lcom/adobe/mediacore/qos/QOSProvider$2;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/qos/QOSProvider$2;-><init>(Lcom/adobe/mediacore/qos/QOSProvider;)V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    new-instance v0, Lcom/adobe/mediacore/qos/DeviceInformation;

    invoke-direct {v0, p1}, Lcom/adobe/mediacore/qos/DeviceInformation;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_deviceInformation:Lcom/adobe/mediacore/qos/DeviceInformation;

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_bufferingMetrics:Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

    return-object v0
.end method

.method static synthetic access$100(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/SeekMetrics;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    return-object v0
.end method

.method static synthetic access$200(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    return-object v0
.end method


# virtual methods
.method public attachMediaPlayer(Lcom/adobe/mediacore/MediaPlayer;)V
    .locals 3

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Provided media player can not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/QOSProvider;->detachMediaPlayer()V

    :cond_1
    iput-object p1, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    new-instance v0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    invoke-direct {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    new-instance v0, Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;

    invoke-direct {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackSessionMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;

    new-instance v0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

    invoke-direct {v0}, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_bufferingMetrics:Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

    new-instance v0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    invoke-direct {v0}, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->QOS:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_qosListener:Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    return-void
.end method

.method public detachMediaPlayer()V
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v0, :cond_0

    iput-object v3, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_bufferingMetrics:Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

    iput-object v3, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    iput-object v3, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    iput-object v3, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackSessionMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;

    iput-object v3, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->QOS:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_qosListener:Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iput-object v3, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    :cond_0
    return-void
.end method

.method public getDeviceInformation()Lcom/adobe/mediacore/qos/DeviceInformation;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_deviceInformation:Lcom/adobe/mediacore/qos/DeviceInformation;

    return-object v0
.end method

.method public getPlaybackInformation()Lcom/adobe/mediacore/qos/PlaybackInformation;
    .locals 35

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    if-nez v2, :cond_0

    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Playback information is available only when a media player is attached to this qos provided."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_0
    new-instance v3, Lcom/adobe/mediacore/qos/PlaybackInformation;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->getTimeToFirstByte()J

    move-result-wide v4

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->getTimeToLoad()J

    move-result-wide v6

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->getTimeToStart()J

    move-result-wide v8

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->getTimeToFirstFrame()J

    move-result-wide v10

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->getTimeToPrepare()J

    move-result-wide v12

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->getTimeToFail()J

    move-result-wide v14

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackSessionMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;->getSecondsPlayed()J

    move-result-wide v16

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackSessionMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackSessionMetrics;->getSecondsSpent()J

    move-result-wide v18

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getFrameRate()F

    move-result v20

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getDroppedFramesCount()J

    move-result-wide v21

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getBitrate()J

    move-result-wide v23

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getBufferTime()J

    move-result-wide v25

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getBufferLength()J

    move-result-wide v27

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_bufferingMetrics:Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->getEmptyBufferCount()J

    move-result-wide v29

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_bufferingMetrics:Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->getTotalBufferingTime()J

    move-result-wide v31

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/qos/QOSProvider;->_seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->getLastSeekTime()J

    move-result-wide v33

    invoke-direct/range {v3 .. v34}, Lcom/adobe/mediacore/qos/PlaybackInformation;-><init>(JJJJJJJJFJJJJJJJ)V

    return-object v3
.end method

.method public updateMetrics(Lcom/adobe/mediacore/MediaPlayer;)V
    .locals 2

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Provided media player can not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_mediaPlayer:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    return-void
.end method
