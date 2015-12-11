.class public Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;
.super Ljava/lang/Object;


# instance fields
.field private _emptyBufferCount:J

.field private _lastBufferingStartDate:Ljava/util/Date;

.field private _totalBufferingTime:J


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->reset()V

    return-void
.end method


# virtual methods
.method public getEmptyBufferCount()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_emptyBufferCount:J

    return-wide v0
.end method

.method public getTotalBufferingTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_totalBufferingTime:J

    return-wide v0
.end method

.method public recordBufferEmpty()V
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_emptyBufferCount:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_emptyBufferCount:J

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_lastBufferingStartDate:Ljava/util/Date;

    return-void
.end method

.method public recordBufferFull()V
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_totalBufferingTime:J

    iget-object v2, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_lastBufferingStartDate:Ljava/util/Date;

    invoke-static {v2}, Lcom/adobe/mediacore/utils/DateUtils;->getMillisecondsSince(Ljava/util/Date;)J

    move-result-wide v2

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_totalBufferingTime:J

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_lastBufferingStartDate:Ljava/util/Date;

    return-void
.end method

.method public reset()V
    .locals 2

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_emptyBufferCount:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->_totalBufferingTime:J

    return-void
.end method
