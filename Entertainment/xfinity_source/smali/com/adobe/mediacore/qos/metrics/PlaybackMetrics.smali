.class public abstract Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
.super Ljava/lang/Object;


# instance fields
.field protected _bitrate:J

.field protected _bufferLength:J

.field protected _bufferTime:J

.field protected _bufferedRange:Lcom/adobe/mediacore/utils/TimeRange;

.field protected _droppedFramesCount:J

.field protected _frameRate:F

.field protected _playbackRange:Lcom/adobe/mediacore/utils/TimeRange;

.field protected _seekableRange:Lcom/adobe/mediacore/utils/TimeRange;

.field protected _time:J

.field protected _timeLocal:J


# direct methods
.method public constructor <init>()V
    .locals 4

    const-wide/16 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {v2, v3, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_playbackRange:Lcom/adobe/mediacore/utils/TimeRange;

    invoke-static {v2, v3, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_seekableRange:Lcom/adobe/mediacore/utils/TimeRange;

    invoke-static {v2, v3, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bufferedRange:Lcom/adobe/mediacore/utils/TimeRange;

    return-void
.end method


# virtual methods
.method protected abstract doUpdate()V
.end method

.method public getBitrate()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bitrate:J

    return-wide v0
.end method

.method public getBufferLength()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bufferLength:J

    return-wide v0
.end method

.method public getBufferTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bufferTime:J

    return-wide v0
.end method

.method public getBufferedRange()Lcom/adobe/mediacore/utils/TimeRange;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bufferedRange:Lcom/adobe/mediacore/utils/TimeRange;

    return-object v0
.end method

.method public getDroppedFramesCount()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_droppedFramesCount:J

    return-wide v0
.end method

.method public getFrameRate()F
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_frameRate:F

    return v0
.end method

.method public getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_playbackRange:Lcom/adobe/mediacore/utils/TimeRange;

    return-object v0
.end method

.method public getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_seekableRange:Lcom/adobe/mediacore/utils/TimeRange;

    return-object v0
.end method

.method public getTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_time:J

    return-wide v0
.end method

.method public getTimeLocal()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_timeLocal:J

    return-wide v0
.end method

.method public reset()V
    .locals 4

    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_time:J

    iput-wide v2, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_timeLocal:J

    invoke-static {v2, v3, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_playbackRange:Lcom/adobe/mediacore/utils/TimeRange;

    invoke-static {v2, v3, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_seekableRange:Lcom/adobe/mediacore/utils/TimeRange;

    invoke-static {v2, v3, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bufferedRange:Lcom/adobe/mediacore/utils/TimeRange;

    const/4 v0, 0x0

    iput v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_frameRate:F

    iput-wide v2, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_droppedFramesCount:J

    iput-wide v2, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bitrate:J

    iput-wide v2, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bufferTime:J

    iput-wide v2, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->_bufferLength:J

    return-void
.end method

.method public update()V
    .locals 0

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->doUpdate()V

    return-void
.end method
