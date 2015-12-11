.class public Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;
.super Ljava/lang/Object;


# instance fields
.field private _lastPlaybackInitDate:Ljava/util/Date;

.field private _timeToFail:J

.field private _timeToFirstByte:J

.field private _timeToFirstFrame:J

.field private _timeToLoad:J

.field private _timeToPrepare:J

.field private _timeToStart:J


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->reset()V

    return-void
.end method


# virtual methods
.method public getTimeToFail()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFail:J

    return-wide v0
.end method

.method public getTimeToFirstByte()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFirstByte:J

    return-wide v0
.end method

.method public getTimeToFirstFrame()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFirstFrame:J

    return-wide v0
.end method

.method public getTimeToLoad()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToLoad:J

    return-wide v0
.end method

.method public getTimeToPrepare()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToPrepare:J

    return-wide v0
.end method

.method public getTimeToStart()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToStart:J

    return-wide v0
.end method

.method public recordPlaybackFail()V
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFail:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_lastPlaybackInitDate:Ljava/util/Date;

    invoke-static {v0}, Lcom/adobe/mediacore/utils/DateUtils;->getMillisecondsSince(Ljava/util/Date;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFail:J

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_lastPlaybackInitDate:Ljava/util/Date;

    :cond_0
    return-void
.end method

.method public recordPlaybackInit()V
    .locals 1

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->reset()V

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_lastPlaybackInitDate:Ljava/util/Date;

    return-void
.end method

.method public recordPlaybackLoad()V
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToLoad:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_lastPlaybackInitDate:Ljava/util/Date;

    invoke-static {v0}, Lcom/adobe/mediacore/utils/DateUtils;->getMillisecondsSince(Ljava/util/Date;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToLoad:J

    :cond_0
    return-void
.end method

.method public recordPlaybackStart()V
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToStart:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_lastPlaybackInitDate:Ljava/util/Date;

    invoke-static {v0}, Lcom/adobe/mediacore/utils/DateUtils;->getMillisecondsSince(Ljava/util/Date;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToStart:J

    :cond_0
    return-void
.end method

.method public recordTimeToFirstFrame()V
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFirstFrame:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_lastPlaybackInitDate:Ljava/util/Date;

    invoke-static {v0}, Lcom/adobe/mediacore/utils/DateUtils;->getMillisecondsSince(Ljava/util/Date;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFirstFrame:J

    :cond_0
    return-void
.end method

.method public recordTimeToPrepare()V
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToPrepare:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_lastPlaybackInitDate:Ljava/util/Date;

    invoke-static {v0}, Lcom/adobe/mediacore/utils/DateUtils;->getMillisecondsSince(Ljava/util/Date;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToPrepare:J

    :cond_0
    return-void
.end method

.method public reset()V
    .locals 2

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFail:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFirstByte:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToLoad:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToStart:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToFirstFrame:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->_timeToPrepare:J

    return-void
.end method
