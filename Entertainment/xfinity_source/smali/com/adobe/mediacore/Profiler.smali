.class final Lcom/adobe/mediacore/Profiler;
.super Ljava/lang/Object;


# instance fields
.field private _elapsedTime:J

.field private _totalElapsedTime:J


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method getElapsedTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/Profiler;->_elapsedTime:J

    return-wide v0
.end method

.method getTotalElapsedTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/Profiler;->_totalElapsedTime:J

    return-wide v0
.end method

.method registerElapsedTime()V
    .locals 4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/adobe/mediacore/Profiler;->_elapsedTime:J

    sub-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/Profiler;->_elapsedTime:J

    iget-wide v0, p0, Lcom/adobe/mediacore/Profiler;->_totalElapsedTime:J

    iget-wide v2, p0, Lcom/adobe/mediacore/Profiler;->_elapsedTime:J

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/Profiler;->_totalElapsedTime:J

    return-void
.end method

.method registerStartElapsedTime()V
    .locals 2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/Profiler;->_elapsedTime:J

    return-void
.end method
