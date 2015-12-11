.class public Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/VideoEngineTimeline;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TimeMapping"
.end annotation


# static fields
.field public static final INVALID_PERIOD:I = -0x1

.field public static final INVALID_POSITION:J = -0x3L

.field public static final LIVE_POINT:J = -0x2L


# instance fields
.field final _period:I

.field final _time:J


# direct methods
.method private constructor <init>(IJ)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->_period:I

    iput-wide p2, p0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->_time:J

    return-void
.end method

.method synthetic constructor <init>(IJLcom/adobe/mediacore/VideoEngineTimeline$1;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;-><init>(IJ)V

    return-void
.end method

.method public static create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-direct {v0, p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;-><init>(IJ)V

    return-object v0
.end method

.method public static createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 4

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    const/4 v1, -0x1

    const-wide/16 v2, -0x3

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;-><init>(IJ)V

    return-object v0
.end method

.method public static createLivePoint()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 4

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    const/4 v1, -0x1

    const-wide/16 v2, -0x2

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;-><init>(IJ)V

    return-object v0
.end method


# virtual methods
.method public getPeriod()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->_period:I

    return v0
.end method

.method public getTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->_time:J

    return-wide v0
.end method

.method public isInvalid()Z
    .locals 4

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->_period:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->_time:J

    const-wide/16 v2, -0x3

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "TimeMapping { _period="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->_period:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", _time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->_time:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
