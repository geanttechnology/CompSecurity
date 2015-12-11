.class final Lcom/adobe/mediacore/VideoEngineTimelineHold;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/TimelineHold;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static final _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private final _time:J

.field private final _videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

.field private referenceCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/VideoEngineTimelineHold;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineTimelineProxy;J)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    iput-wide p2, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_time:J

    return-void
.end method


# virtual methods
.method public addReference(J)V
    .locals 5

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_time:J

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->referenceCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->referenceCount:I

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimelineHold;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#addReference"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Number of references for HOLD at time = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->referenceCount:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public getHoldTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_time:J

    return-wide v0
.end method

.method public isReleased()Z
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->referenceCount:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public releaseReference(J)V
    .locals 5

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_time:J

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->referenceCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->referenceCount:I

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimelineHold;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#releaseReference"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Number of references for HOLD at time = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->referenceCount:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->referenceCount:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    iget-wide v2, p0, Lcom/adobe/mediacore/VideoEngineTimelineHold;->_time:J

    invoke-virtual {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->removeHoldFor(J)V

    :cond_0
    return-void
.end method
