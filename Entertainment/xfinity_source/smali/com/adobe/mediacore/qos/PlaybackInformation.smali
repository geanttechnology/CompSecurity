.class public Lcom/adobe/mediacore/qos/PlaybackInformation;
.super Ljava/lang/Object;


# instance fields
.field private final _bitrate:J

.field private final _bufferLength:J

.field private final _bufferTime:J

.field private final _bufferingTime:J

.field private final _droppedFrameCount:J

.field private final _emptyBufferCount:J

.field private final _frameRate:F

.field private final _lastSeekTime:J

.field private final _secondsPlayed:J

.field private final _secondsSpent:J

.field private final _timeToFail:J

.field private final _timeToFirstByte:J

.field private final _timeToFirstFrame:J

.field private final _timeToLoad:J

.field private final _timeToPrepare:J

.field private final _timeToStart:J


# direct methods
.method public constructor <init>(JJJJJJJJFJJJJJJJ)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToFirstByte:J

    iput-wide p3, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToLoad:J

    iput-wide p5, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToStart:J

    iput-wide p7, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToFirstFrame:J

    iput-wide p9, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToPrepare:J

    iput-wide p11, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToFail:J

    move-wide/from16 v0, p13

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_secondsPlayed:J

    move-wide/from16 v0, p15

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_secondsSpent:J

    move/from16 v0, p17

    iput v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_frameRate:F

    move-wide/from16 v0, p18

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_droppedFrameCount:J

    move-wide/from16 v0, p20

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_bitrate:J

    move-wide/from16 v0, p22

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_bufferTime:J

    move-wide/from16 v0, p24

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_bufferLength:J

    move-wide/from16 v0, p26

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_emptyBufferCount:J

    move-wide/from16 v0, p28

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_bufferingTime:J

    move-wide/from16 v0, p30

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_lastSeekTime:J

    return-void
.end method


# virtual methods
.method public final getBitrate()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_bitrate:J

    return-wide v0
.end method

.method public final getBufferLength()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_bufferLength:J

    return-wide v0
.end method

.method public final getBufferTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_bufferTime:J

    return-wide v0
.end method

.method public final getBufferingTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_bufferingTime:J

    return-wide v0
.end method

.method public final getDroppedFrameCount()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_droppedFrameCount:J

    return-wide v0
.end method

.method public final getEmptyBufferCount()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_emptyBufferCount:J

    return-wide v0
.end method

.method public final getFrameRate()F
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_frameRate:F

    return v0
.end method

.method public getLastSeekTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_lastSeekTime:J

    return-wide v0
.end method

.method public final getTimeToFail()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToFail:J

    return-wide v0
.end method

.method public final getTimeToFirstByte()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToFirstByte:J

    return-wide v0
.end method

.method public final getTimeToFirstFrame()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToFirstFrame:J

    return-wide v0
.end method

.method public final getTimeToLoad()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToLoad:J

    return-wide v0
.end method

.method public getTimeToPrepare()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToPrepare:J

    return-wide v0
.end method

.method public final getTimeToStart()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_timeToStart:J

    return-wide v0
.end method

.method public final getTotalSecondsPlayed()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_secondsPlayed:J

    return-wide v0
.end method

.method public final getTotalSecondsSpent()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/PlaybackInformation;->_secondsSpent:J

    return-wide v0
.end method
