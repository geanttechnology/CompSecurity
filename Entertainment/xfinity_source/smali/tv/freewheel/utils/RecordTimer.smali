.class public Ltv/freewheel/utils/RecordTimer;
.super Ljava/lang/Object;
.source "RecordTimer.java"


# instance fields
.field private lastDate:Ljava/util/Date;

.field private paused:Z

.field private record:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Ltv/freewheel/utils/RecordTimer;->lastDate:Ljava/util/Date;

    .line 14
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Ltv/freewheel/utils/RecordTimer;->record:J

    .line 15
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/utils/RecordTimer;->paused:Z

    .line 16
    return-void
.end method


# virtual methods
.method public pause()V
    .locals 4

    .prologue
    .line 19
    iget-boolean v0, p0, Ltv/freewheel/utils/RecordTimer;->paused:Z

    if-eqz v0, :cond_0

    .line 26
    :goto_0
    return-void

    .line 22
    :cond_0
    iget-object v0, p0, Ltv/freewheel/utils/RecordTimer;->lastDate:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    iput-wide v0, p0, Ltv/freewheel/utils/RecordTimer;->record:J

    .line 23
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Ltv/freewheel/utils/RecordTimer;->lastDate:Ljava/util/Date;

    .line 24
    iget-object v0, p0, Ltv/freewheel/utils/RecordTimer;->lastDate:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    iget-wide v2, p0, Ltv/freewheel/utils/RecordTimer;->record:J

    sub-long/2addr v0, v2

    iput-wide v0, p0, Ltv/freewheel/utils/RecordTimer;->record:J

    .line 25
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/utils/RecordTimer;->paused:Z

    goto :goto_0
.end method

.method public resume()V
    .locals 1

    .prologue
    .line 29
    iget-boolean v0, p0, Ltv/freewheel/utils/RecordTimer;->paused:Z

    if-eqz v0, :cond_0

    .line 30
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Ltv/freewheel/utils/RecordTimer;->lastDate:Ljava/util/Date;

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/utils/RecordTimer;->paused:Z

    .line 33
    :cond_0
    return-void
.end method

.method public tick()J
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    .line 38
    iget-boolean v2, p0, Ltv/freewheel/utils/RecordTimer;->paused:Z

    if-eqz v2, :cond_0

    .line 39
    iget-wide v0, p0, Ltv/freewheel/utils/RecordTimer;->record:J

    .line 40
    .local v0, "ret":J
    iput-wide v4, p0, Ltv/freewheel/utils/RecordTimer;->record:J

    .line 48
    :goto_0
    const-wide/16 v2, 0x3e8

    div-long v2, v0, v2

    return-wide v2

    .line 42
    .end local v0    # "ret":J
    :cond_0
    iget-object v2, p0, Ltv/freewheel/utils/RecordTimer;->lastDate:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    .line 43
    .restart local v0    # "ret":J
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    iput-object v2, p0, Ltv/freewheel/utils/RecordTimer;->lastDate:Ljava/util/Date;

    .line 44
    iget-object v2, p0, Ltv/freewheel/utils/RecordTimer;->lastDate:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    sub-long v0, v2, v0

    .line 45
    iget-wide v2, p0, Ltv/freewheel/utils/RecordTimer;->record:J

    add-long/2addr v0, v2

    .line 46
    iput-wide v4, p0, Ltv/freewheel/utils/RecordTimer;->record:J

    goto :goto_0
.end method
