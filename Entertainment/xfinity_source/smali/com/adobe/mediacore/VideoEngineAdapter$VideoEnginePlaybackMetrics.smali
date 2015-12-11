.class public Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
.super Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/VideoEngineAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "VideoEnginePlaybackMetrics"
.end annotation


# static fields
.field private static final DEFAULT_TARGET_DURATION:I = 0x2710

.field private static final READ_HEAD_DELTA:J


# instance fields
.field private _clientLivePoint:J

.field private _dispatchedBufferFull:Z

.field private _readHead:J

.field private _savedBufferLength:J

.field final synthetic this$0:Lcom/adobe/mediacore/VideoEngineAdapter;


# direct methods
.method protected constructor <init>(Lcom/adobe/mediacore/VideoEngineAdapter;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-direct {p0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;-><init>()V

    return-void
.end method

.method private checkAndDispatchBufferFullEvent()V
    .locals 5

    const/4 v4, 0x0

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_dispatchedBufferFull:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->hasAllDataBuffered()Z

    move-result v0

    if-nez v0, :cond_0

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bufferLength:J

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1100(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/BufferControlParameters;->getPlayBufferTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_savedBufferLength:J

    iget-wide v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bufferLength:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iput-boolean v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_dispatchedBufferFull:Z

    :cond_0
    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_dispatchedBufferFull:Z

    if-eqz v0, :cond_2

    :cond_1
    :goto_0
    return-void

    :cond_2
    iput-boolean v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_dispatchedBufferFull:Z

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bufferLength:J

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_savedBufferLength:J

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->isBufferFull()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_dispatchedBufferFull:Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_FULL:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method


# virtual methods
.method protected doUpdate()V
    .locals 10

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isSeeking:Z
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3100(Lcom/adobe/mediacore/VideoEngineAdapter;)Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    const-wide/16 v2, -0x3

    cmp-long v0, v0, v2

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_time:J

    :goto_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getLocalTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_timeLocal:J

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getBufferLength()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bufferLength:J

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_time:J

    iget-wide v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bufferLength:J

    add-long/2addr v0, v2

    const-wide/16 v2, 0x0

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_readHead:J

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1100(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/BufferControlParameters;->getPlayBufferTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bufferTime:J

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v2

    if-eqz v2, :cond_3

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_time:J

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    sub-long/2addr v4, v0

    iget-wide v6, v2, Lcom/adobe/ave/Timeline;->virtualDuration:J

    add-long/2addr v4, v6

    invoke-static {v0, v1, v4, v5}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_playbackRange:Lcom/adobe/mediacore/utils/TimeRange;

    iget v0, v2, Lcom/adobe/ave/Timeline;->complete:I

    if-nez v0, :cond_6

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getClientLivePoint()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_clientLivePoint:J

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_clientLivePoint:J

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualDuration:J

    iget-wide v6, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    add-long/2addr v4, v6

    cmp-long v0, v0, v4

    if-ltz v0, :cond_2

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#DEBUG"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Client live point = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_clientLivePoint:J

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " virtual start time = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " virtual end time  = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    iget-wide v6, v2, Lcom/adobe/ave/Timeline;->virtualDuration:J

    add-long/2addr v4, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_clientLivePoint:J

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    sub-long/2addr v0, v4

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    invoke-static {v4, v5, v0, v1}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_seekableRange:Lcom/adobe/mediacore/utils/TimeRange;

    :goto_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v0

    iget-wide v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bufferLength:J

    iget-wide v6, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    iget-wide v2, v2, Lcom/adobe/ave/Timeline;->virtualDuration:J

    add-long/2addr v2, v6

    iget-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v6}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v6

    sub-long/2addr v2, v6

    invoke-static {v4, v5, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bufferedRange:Lcom/adobe/mediacore/utils/TimeRange;

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getQosFrameRate()F

    move-result v0

    iput v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_frameRate:F

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getQosDroppedFrameCount()I

    move-result v0

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_droppedFramesCount:J

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownProfile:J
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1800(Lcom/adobe/mediacore/VideoEngineAdapter;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_bitrate:J

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->checkAndDispatchBufferFullEvent()V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#doUpdate"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Unable to update metrics."

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->GET_QOS_DATA_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "An error has occurred while attempting to retrieve the QOS information."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-static {v1}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_4
    :try_start_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->extractVirtualTime()J
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3500(Lcom/adobe/mediacore/VideoEngineAdapter;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_time:J

    goto/16 :goto_1

    :cond_5
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngine;->getTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_time:J

    goto/16 :goto_1

    :cond_6
    iget-wide v0, v2, Lcom/adobe/ave/Timeline;->virtualDuration:J

    iget v3, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    invoke-virtual {v2, v3}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v3

    if-eqz v3, :cond_7

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    add-long/2addr v4, v0

    iget-wide v6, v3, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    iget-wide v8, v3, Lcom/adobe/ave/PeriodInfo;->duration:J

    add-long/2addr v6, v8

    cmp-long v4, v4, v6

    if-lez v4, :cond_7

    iget-wide v0, v3, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    iget-wide v4, v3, Lcom/adobe/ave/PeriodInfo;->duration:J

    add-long/2addr v0, v4

    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    sub-long/2addr v0, v4

    :cond_7
    iget-wide v4, v2, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    invoke-static {v4, v5, v0, v1}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_seekableRange:Lcom/adobe/mediacore/utils/TimeRange;
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_2
.end method

.method public getReadHead()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->_readHead:J

    return-wide v0
.end method
