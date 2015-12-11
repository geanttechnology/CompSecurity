.class public Ltv/freewheel/hybrid/utils/Scheduler;
.super Ljava/lang/Object;
.source "Scheduler.java"


# instance fields
.field private lastRunDuration:J

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private paused:Z

.field private recordTimer:Ltv/freewheel/hybrid/utils/RecordTimer;

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
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 18
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    .line 19
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->lastRunDuration:J

    .line 20
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->paused:Z

    .line 21
    return-void
.end method

.method static synthetic access$002(Ltv/freewheel/hybrid/utils/Scheduler;J)J
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/Scheduler;
    .param p1, "x1"    # J

    .prologue
    .line 6
    iput-wide p1, p0, Ltv/freewheel/hybrid/utils/Scheduler;->lastRunDuration:J

    return-wide p1
.end method

.method static synthetic access$100(Ltv/freewheel/hybrid/utils/Scheduler;)Ltv/freewheel/hybrid/utils/RecordTimer;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/Scheduler;

    .prologue
    .line 6
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->recordTimer:Ltv/freewheel/hybrid/utils/RecordTimer;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/utils/Scheduler;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/Scheduler;

    .prologue
    .line 6
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->task:Ljava/lang/Runnable;

    return-object v0
.end method


# virtual methods
.method public getLastRunDuration()J
    .locals 2

    .prologue
    .line 105
    iget-wide v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->lastRunDuration:J

    return-wide v0
.end method

.method public resume()V
    .locals 8

    .prologue
    const-wide/16 v6, 0x3e8

    .line 71
    iget-boolean v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->paused:Z

    if-eqz v0, :cond_0

    .line 72
    iget-wide v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->taskIntervalSeconds:J

    iget-wide v4, p0, Ltv/freewheel/hybrid/utils/Scheduler;->lastRunDuration:J

    sub-long/2addr v0, v4

    mul-long v2, v0, v6

    .line 73
    .local v2, "delay":J
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->recordTimer:Ltv/freewheel/hybrid/utils/RecordTimer;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/utils/RecordTimer;->resume()V

    .line 74
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    .line 75
    iget-boolean v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->repeatTask:Z

    if-eqz v0, :cond_1

    .line 76
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/hybrid/utils/Scheduler$3;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/utils/Scheduler$3;-><init>(Ltv/freewheel/hybrid/utils/Scheduler;)V

    iget-wide v4, p0, Ltv/freewheel/hybrid/utils/Scheduler;->taskIntervalSeconds:J

    mul-long/2addr v4, v6

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    .line 90
    :goto_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->paused:Z

    .line 92
    .end local v2    # "delay":J
    :cond_0
    return-void

    .line 83
    .restart local v2    # "delay":J
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/hybrid/utils/Scheduler$4;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/utils/Scheduler$4;-><init>(Ltv/freewheel/hybrid/utils/Scheduler;)V

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto :goto_0
.end method

.method public setTask(Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "task"    # Ljava/lang/Runnable;

    .prologue
    .line 24
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/Scheduler;->task:Ljava/lang/Runnable;

    .line 25
    return-void
.end method

.method public start(DZ)V
    .locals 7
    .param p1, "intervalSeconds"    # D
    .param p3, "repeat"    # Z

    .prologue
    .line 28
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->task:Ljava/lang/Runnable;

    if-nez v0, :cond_0

    .line 29
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "task set is null"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 58
    :goto_0
    return-void

    .line 32
    :cond_0
    iget-boolean v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->paused:Z

    if-eqz v0, :cond_1

    .line 33
    invoke-virtual {p0}, Ltv/freewheel/hybrid/utils/Scheduler;->resume()V

    goto :goto_0

    .line 36
    :cond_1
    const-wide v0, 0x408f400000000000L    # 1000.0

    mul-double/2addr v0, p1

    double-to-long v2, v0

    .line 37
    .local v2, "intervalMilliSeconds":J
    new-instance v0, Ltv/freewheel/hybrid/utils/RecordTimer;

    invoke-direct {v0}, Ltv/freewheel/hybrid/utils/RecordTimer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->recordTimer:Ltv/freewheel/hybrid/utils/RecordTimer;

    .line 38
    double-to-long v0, p1

    iput-wide v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->taskIntervalSeconds:J

    .line 39
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 40
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    .line 41
    if-eqz p3, :cond_2

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->repeatTask:Z

    .line 43
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/hybrid/utils/Scheduler$1;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/utils/Scheduler$1;-><init>(Ltv/freewheel/hybrid/utils/Scheduler;)V

    move-wide v4, v2

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    goto :goto_0

    .line 50
    :cond_2
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->repeatTask:Z

    .line 51
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/hybrid/utils/Scheduler$2;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/utils/Scheduler$2;-><init>(Ltv/freewheel/hybrid/utils/Scheduler;)V

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto :goto_0
.end method

.method public stop()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    const/4 v1, 0x0

    .line 95
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 96
    iput-object v1, p0, Ltv/freewheel/hybrid/utils/Scheduler;->recordTimer:Ltv/freewheel/hybrid/utils/RecordTimer;

    .line 97
    iput-wide v2, p0, Ltv/freewheel/hybrid/utils/Scheduler;->lastRunDuration:J

    .line 98
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/utils/Scheduler;->paused:Z

    .line 99
    iput-object v1, p0, Ltv/freewheel/hybrid/utils/Scheduler;->task:Ljava/lang/Runnable;

    .line 100
    iput-wide v2, p0, Ltv/freewheel/hybrid/utils/Scheduler;->taskIntervalSeconds:J

    .line 101
    return-void
.end method
