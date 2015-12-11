.class public Lcom/adobe/mediacore/qos/metrics/SeekMetrics;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;
    }
.end annotation


# instance fields
.field private _lastSeekStartDate:Ljava/util/Date;

.field private _lastSeekTime:J

.field private _seekFailCount:J

.field private _seekStartCount:J

.field private _seekSuccessCount:J

.field private _totalSeekTime:J


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->reset()V

    return-void
.end method


# virtual methods
.method public getLastSeekTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekTime:J

    return-wide v0
.end method

.method public getSeekFailCount()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekFailCount:J

    return-wide v0
.end method

.method public getSeekStartCount()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekStartCount:J

    return-wide v0
.end method

.method public getSeekSuccessCount()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekSuccessCount:J

    return-wide v0
.end method

.method public getTotalSeekTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_totalSeekTime:J

    return-wide v0
.end method

.method public recordSeekComplete(Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;)V
    .locals 4

    const-wide/16 v2, 0x1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekStartDate:Ljava/util/Date;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;->SUCCESS:Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;

    if-ne p1, v0, :cond_1

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekSuccessCount:J

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekSuccessCount:J

    :goto_1
    iget-object v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekStartDate:Ljava/util/Date;

    invoke-static {v0}, Lcom/adobe/mediacore/utils/DateUtils;->getMillisecondsSince(Ljava/util/Date;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekTime:J

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_totalSeekTime:J

    iget-wide v2, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekTime:J

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_totalSeekTime:J

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekStartDate:Ljava/util/Date;

    goto :goto_0

    :cond_1
    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekFailCount:J

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekFailCount:J

    goto :goto_1
.end method

.method public recordSeekStart()V
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekStartCount:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekStartCount:J

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekStartDate:Ljava/util/Date;

    return-void
.end method

.method public reset()V
    .locals 2

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekStartCount:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekSuccessCount:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_seekFailCount:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekTime:J

    iput-wide v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_totalSeekTime:J

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->_lastSeekStartDate:Ljava/util/Date;

    return-void
.end method
