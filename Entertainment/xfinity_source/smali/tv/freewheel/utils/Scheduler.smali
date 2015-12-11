.class public Ltv/freewheel/utils/Scheduler;
.super Ljava/lang/Object;
.source "Scheduler.java"


# instance fields
.field private lastRunDuration:J

.field private logger:Ltv/freewheel/utils/Logger;

.field private paused:Z

.field private recordTimer:Ltv/freewheel/utils/RecordTimer;

.field private repeatTask:Z

.field private task:Ljava/lang/Runnable;

.field private taskIntervalSeconds:J

.field private timer:Ljava/util/Timer;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/utils/Scheduler;->logger:Ltv/freewheel/utils/Logger;

    .line 18
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    .line 19
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Ltv/freewheel/utils/Scheduler;->lastRunDuration:J

    .line 20
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->paused:Z

    .line 21
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/utils/Scheduler;)Ltv/freewheel/utils/RecordTimer;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/utils/Scheduler;

    .prologue
    .line 6
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;

    return-object v0
.end method

.method static synthetic access$102(Ltv/freewheel/utils/Scheduler;J)J
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/utils/Scheduler;
    .param p1, "x1"    # J

    .prologue
    .line 6
    iput-wide p1, p0, Ltv/freewheel/utils/Scheduler;->lastRunDuration:J

    return-wide p1
.end method

.method static synthetic access$200(Ltv/freewheel/utils/Scheduler;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/utils/Scheduler;

    .prologue
    .line 6
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->task:Ljava/lang/Runnable;

    return-object v0
.end method


# virtual methods
.method public getLastRunDuration()J
    .locals 2

    .prologue
    .line 116
    iget-wide v0, p0, Ltv/freewheel/utils/Scheduler;->lastRunDuration:J

    return-wide v0
.end method

.method public pause()V
    .locals 2

    .prologue
    .line 65
    iget-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->paused:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->task:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;

    if-nez v0, :cond_1

    .line 73
    :cond_0
    :goto_0
    return-void

    .line 68
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->paused:Z

    .line 69
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;

    invoke-virtual {v0}, Ltv/freewheel/utils/RecordTimer;->pause()V

    .line 70
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 71
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    .line 72
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;

    invoke-virtual {v0}, Ltv/freewheel/utils/RecordTimer;->tick()J

    move-result-wide v0

    iput-wide v0, p0, Ltv/freewheel/utils/Scheduler;->lastRunDuration:J

    goto :goto_0
.end method

.method public resume()V
    .locals 8

    .prologue
    const-wide/16 v6, 0x3e8

    .line 76
    iget-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->paused:Z

    if-eqz v0, :cond_1

    .line 77
    iget-wide v0, p0, Ltv/freewheel/utils/Scheduler;->taskIntervalSeconds:J

    iget-wide v4, p0, Ltv/freewheel/utils/Scheduler;->lastRunDuration:J

    sub-long/2addr v0, v4

    mul-long v2, v0, v6

    .line 78
    .local v2, "delay":J
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;

    invoke-virtual {v0}, Ltv/freewheel/utils/RecordTimer;->resume()V

    .line 79
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 80
    :cond_0
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    .line 81
    iget-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->repeatTask:Z

    if-eqz v0, :cond_2

    .line 82
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/utils/Scheduler$3;

    invoke-direct {v1, p0}, Ltv/freewheel/utils/Scheduler$3;-><init>(Ltv/freewheel/utils/Scheduler;)V

    iget-wide v4, p0, Ltv/freewheel/utils/Scheduler;->taskIntervalSeconds:J

    mul-long/2addr v4, v6

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    .line 100
    :goto_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->paused:Z

    .line 102
    .end local v2    # "delay":J
    :cond_1
    return-void

    .line 91
    .restart local v2    # "delay":J
    :cond_2
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/utils/Scheduler$4;

    invoke-direct {v1, p0}, Ltv/freewheel/utils/Scheduler$4;-><init>(Ltv/freewheel/utils/Scheduler;)V

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto :goto_0
.end method

.method public setTask(Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "task"    # Ljava/lang/Runnable;

    .prologue
    .line 24
    iput-object p1, p0, Ltv/freewheel/utils/Scheduler;->task:Ljava/lang/Runnable;

    .line 25
    return-void
.end method

.method public start(DZ)V
    .locals 7
    .param p1, "intervalSeconds"    # D
    .param p3, "repeat"    # Z

    .prologue
    .line 28
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->task:Ljava/lang/Runnable;

    if-nez v0, :cond_0

    .line 29
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "task set is null"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 62
    :goto_0
    return-void

    .line 32
    :cond_0
    iget-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->paused:Z

    if-eqz v0, :cond_1

    .line 33
    invoke-virtual {p0}, Ltv/freewheel/utils/Scheduler;->resume()V

    goto :goto_0

    .line 36
    :cond_1
    const-wide v0, 0x408f400000000000L    # 1000.0

    mul-double/2addr v0, p1

    double-to-long v2, v0

    .line 37
    .local v2, "intervalMilliSeconds":J
    new-instance v0, Ltv/freewheel/utils/RecordTimer;

    invoke-direct {v0}, Ltv/freewheel/utils/RecordTimer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;

    .line 38
    double-to-long v0, p1

    iput-wide v0, p0, Ltv/freewheel/utils/Scheduler;->taskIntervalSeconds:J

    .line 39
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 40
    :cond_2
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    .line 41
    if-eqz p3, :cond_3

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->repeatTask:Z

    .line 43
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/utils/Scheduler$1;

    invoke-direct {v1, p0}, Ltv/freewheel/utils/Scheduler$1;-><init>(Ltv/freewheel/utils/Scheduler;)V

    move-wide v4, v2

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    goto :goto_0

    .line 52
    :cond_3
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->repeatTask:Z

    .line 53
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/utils/Scheduler$2;

    invoke-direct {v1, p0}, Ltv/freewheel/utils/Scheduler$2;-><init>(Ltv/freewheel/utils/Scheduler;)V

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto :goto_0
.end method

.method public stop()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    const/4 v1, 0x0

    .line 105
    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 106
    :cond_0
    iput-object v1, p0, Ltv/freewheel/utils/Scheduler;->timer:Ljava/util/Timer;

    .line 107
    iput-object v1, p0, Ltv/freewheel/utils/Scheduler;->recordTimer:Ltv/freewheel/utils/RecordTimer;

    .line 108
    iput-wide v2, p0, Ltv/freewheel/utils/Scheduler;->lastRunDuration:J

    .line 109
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/utils/Scheduler;->paused:Z

    .line 110
    iput-object v1, p0, Ltv/freewheel/utils/Scheduler;->task:Ljava/lang/Runnable;

    .line 111
    iput-wide v2, p0, Ltv/freewheel/utils/Scheduler;->taskIntervalSeconds:J

    .line 112
    return-void
.end method
