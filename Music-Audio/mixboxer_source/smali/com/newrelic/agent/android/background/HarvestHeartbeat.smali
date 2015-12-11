.class public Lcom/newrelic/agent/android/background/HarvestHeartbeat;
.super Ljava/lang/Object;
.source "HarvestHeartbeat.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final log:Lcom/newrelic/agent/android/logging/AgentLog;


# instance fields
.field private final api1:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

.field private final connectivitySampler:Lcom/newrelic/agent/android/util/ConnectivitySampler;

.field private final deltaTimeUnit:Ljava/util/concurrent/TimeUnit;

.field private final executor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

.field private finalThread:Ljava/lang/Thread;

.field private final finalThreadLock:Ljava/lang/Object;

.field private future:Ljava/util/concurrent/ScheduledFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ScheduledFuture",
            "<*>;"
        }
    .end annotation
.end field

.field private final harvestCond:Ljava/util/concurrent/locks/Condition;

.field private harvestCounter:J

.field private harvestInterval:J

.field private harvestIntervalUnit:Ljava/util/concurrent/TimeUnit;

.field private harvesting:Z

.field private lastTime:J

.field private final lock:Ljava/util/concurrent/locks/ReentrantLock;

.field private final machineMeasurementsSampler:Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;

.field private final minDeltaTime:J

.field private needConnect:Z

.field private sessionStartTime:J

.field private final stopCond:Ljava/util/concurrent/locks/Condition;

.field private stopRequested:Z

.field private stopped:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    invoke-static {}, Lcom/newrelic/agent/android/logging/AgentLogManager;->getAgentLog()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    sput-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    return-void
.end method

.method public constructor <init>(Lcom/newrelic/agent/android/api/v1/NewRelicApi;Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;Lcom/newrelic/agent/android/util/ConnectivitySampler;J)V
    .locals 10
    .param p1, "api"    # Lcom/newrelic/agent/android/api/v1/NewRelicApi;
    .param p2, "machineMeasurementsSampler"    # Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;
    .param p3, "connectivitySampler"    # Lcom/newrelic/agent/android/util/ConnectivitySampler;
    .param p4, "harvestIntervalInMilliseconds"    # J

    .prologue
    .line 81
    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    long-to-double v0, p4

    const-wide v2, 0x3feaaaaaaaaaaaabL    # 0.8333333333333334

    mul-double/2addr v0, v2

    double-to-long v7, v0

    sget-object v9, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-wide v4, p4

    invoke-direct/range {v0 .. v9}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;-><init>(Lcom/newrelic/agent/android/api/v1/NewRelicApi;Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;Lcom/newrelic/agent/android/util/ConnectivitySampler;JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;)V

    .line 82
    return-void
.end method

.method public constructor <init>(Lcom/newrelic/agent/android/api/v1/NewRelicApi;Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;Lcom/newrelic/agent/android/util/ConnectivitySampler;JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;)V
    .locals 3
    .param p1, "api1"    # Lcom/newrelic/agent/android/api/v1/NewRelicApi;
    .param p2, "machineMeasurementsSampler"    # Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;
    .param p3, "connectivitySampler"    # Lcom/newrelic/agent/android/util/ConnectivitySampler;
    .param p4, "harvestInterval"    # J
    .param p6, "harvestTimeUnit"    # Ljava/util/concurrent/TimeUnit;
    .param p7, "minDeltaTime"    # J
    .param p9, "deltaTimeUnit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    const/4 v1, 0x0

    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThreadLock:Ljava/lang/Object;

    .line 69
    iput-boolean v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopped:Z

    .line 70
    iput-boolean v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopRequested:Z

    .line 71
    iput-boolean v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z

    .line 74
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 75
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopCond:Ljava/util/concurrent/locks/Condition;

    .line 76
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;

    .line 78
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    .line 85
    iput-object p1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->api1:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    .line 86
    iput-wide p4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestInterval:J

    .line 87
    iput-object p6, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestIntervalUnit:Ljava/util/concurrent/TimeUnit;

    .line 88
    iput-wide p7, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->minDeltaTime:J

    .line 89
    iput-object p9, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->deltaTimeUnit:Ljava/util/concurrent/TimeUnit;

    .line 90
    iput-object p2, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->machineMeasurementsSampler:Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;

    .line 91
    iput-object p3, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->connectivitySampler:Lcom/newrelic/agent/android/util/ConnectivitySampler;

    .line 92
    new-instance v0, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const/4 v1, 0x1

    new-instance v2, Lcom/newrelic/agent/android/background/HarvestHeartbeat$1;

    invoke-direct {v2, p0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat$1;-><init>(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)V

    invoke-direct {v0, v1, v2}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;-><init>(ILjava/util/concurrent/ThreadFactory;)V

    iput-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->executor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    .line 98
    return-void
.end method

.method static synthetic access$000(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/util/concurrent/locks/ReentrantLock;
    .locals 1
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    return-object v0
.end method

.method static synthetic access$100(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Z
    .locals 1
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z

    return v0
.end method

.method static synthetic access$200(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/util/concurrent/locks/Condition;
    .locals 1
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;

    return-object v0
.end method

.method static synthetic access$300()Lcom/newrelic/agent/android/logging/AgentLog;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    return-object v0
.end method

.method static synthetic access$400(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Lcom/newrelic/agent/android/util/ConnectivitySampler;
    .locals 1
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->connectivitySampler:Lcom/newrelic/agent/android/util/ConnectivitySampler;

    return-object v0
.end method

.method static synthetic access$500(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;
    .locals 1
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->machineMeasurementsSampler:Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;

    return-object v0
.end method

.method static synthetic access$600(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Lcom/newrelic/agent/android/api/v1/NewRelicApi;
    .locals 1
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->api1:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    return-object v0
.end method

.method static synthetic access$700(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThreadLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$802(Lcom/newrelic/agent/android/background/HarvestHeartbeat;Ljava/lang/Thread;)Ljava/lang/Thread;
    .locals 0
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;
    .param p1, "x1"    # Ljava/lang/Thread;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;

    return-object p1
.end method

.method static synthetic access$900(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)V
    .locals 0
    .param p0, "x0"    # Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->afterStop()V

    return-void
.end method

.method private afterStop()V
    .locals 2

    .prologue
    .line 271
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 273
    :try_start_0
    iget-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopRequested:Z

    if-eqz v0, :cond_0

    .line 274
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopRequested:Z

    .line 276
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopped:Z

    .line 277
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 279
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 281
    return-void

    .line 279
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0
.end method

.method private finalSendData(JJ)V
    .locals 9
    .param p1, "sessionStartTime"    # J
    .param p3, "lastHarvestTime"    # J

    .prologue
    .line 207
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 208
    .local v4, "thisTime":J
    iget-object v8, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThreadLock:Ljava/lang/Object;

    monitor-enter v8

    .line 209
    :try_start_0
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;

    if-nez v0, :cond_0

    .line 210
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Sending final data in background."

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->debug(Ljava/lang/String;)V

    .line 212
    new-instance v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;

    move-object v1, p0

    move-wide v2, p1

    move-wide v6, p3

    invoke-direct/range {v0 .. v7}, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;-><init>(Lcom/newrelic/agent/android/background/HarvestHeartbeat;JJJ)V

    iput-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;

    .line 260
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 267
    :goto_0
    monitor-exit v8

    .line 268
    return-void

    .line 263
    :cond_0
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Final session data thread already running: will not fire again."

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->debug(Ljava/lang/String;)V

    .line 264
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getAndClearTransactionData()Ljava/util/List;

    .line 265
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getAndClearErrorData()Ljava/util/List;

    goto :goto_0

    .line 267
    :catchall_0
    move-exception v0

    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private harvest(J)V
    .locals 12
    .param p1, "delta"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/InterruptedIOException;
        }
    .end annotation

    .prologue
    const-wide/16 v10, 0x1

    .line 361
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 363
    :try_start_0
    iget-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z

    if-eqz v0, :cond_0

    .line 364
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "A harvest is already in progress. Come back later."

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 370
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 446
    :goto_0
    return-void

    .line 367
    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 370
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 374
    :try_start_2
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    iget-wide v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->minDeltaTime:J

    iget-object v5, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->deltaTimeUnit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v5}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-gez v0, :cond_1

    .line 375
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Skipping harvest heartbeat - too soon"

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_4

    .line 429
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 434
    :try_start_3
    iget-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    add-long/2addr v0, v10

    iput-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    .line 439
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z

    .line 440
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 443
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    .line 370
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    .line 443
    :catchall_1
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    .line 379
    :cond_1
    :try_start_4
    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThreadLock:Ljava/lang/Object;

    monitor-enter v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_4

    .line 383
    :try_start_5
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;

    if-eqz v0, :cond_2

    .line 384
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v2, "Previous heartbeat is still shutting down -- skipping harvest ..."

    invoke-interface {v0, v2}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 385
    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    .line 429
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 434
    :try_start_6
    iget-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    add-long/2addr v0, v10

    iput-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    .line 439
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z

    .line 440
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 443
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    :catchall_2
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    .line 387
    :cond_2
    :try_start_7
    monitor-exit v1
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 389
    :try_start_8
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getAndClearTransactionData()Ljava/util/List;

    move-result-object v3

    .line 390
    .local v3, "transactionData":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getAndClearErrorData()Ljava/util/List;

    move-result-object v4

    .line 391
    .local v4, "errorData":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    new-instance v7, Lcom/newrelic/agent/android/stats/TicToc;

    invoke-direct {v7}, Lcom/newrelic/agent/android/stats/TicToc;-><init>()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_4

    .line 394
    .local v7, "timer":Lcom/newrelic/agent/android/stats/TicToc;
    :try_start_9
    invoke-direct {p0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->isOnline()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 400
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V
    :try_end_9
    .catch Lcom/newrelic/agent/android/transport/TransportException; {:try_start_9 .. :try_end_9} :catch_0
    .catchall {:try_start_9 .. :try_end_9} :catchall_4

    .line 402
    :try_start_a
    iget-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopRequested:Z

    if-eqz v0, :cond_3

    .line 403
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Stop requested after the harvest started -- skipping harvest ..."

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_6

    .line 407
    :try_start_b
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V
    :try_end_b
    .catch Lcom/newrelic/agent/android/transport/TransportException; {:try_start_b .. :try_end_b} :catch_0
    .catchall {:try_start_b .. :try_end_b} :catchall_4

    .line 429
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 434
    :try_start_c
    iget-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    add-long/2addr v0, v10

    iput-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    .line 439
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z

    .line 440
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_5

    .line 443
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto/16 :goto_0

    .line 387
    .end local v3    # "transactionData":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    .end local v4    # "errorData":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    .end local v7    # "timer":Lcom/newrelic/agent/android/stats/TicToc;
    :catchall_3
    move-exception v0

    :try_start_d
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_3

    :try_start_e
    throw v0
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_4

    .line 429
    :catchall_4
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 434
    :try_start_f
    iget-wide v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    add-long/2addr v1, v10

    iput-wide v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    .line 439
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z

    .line 440
    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_8

    .line 443
    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    .restart local v3    # "transactionData":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    .restart local v4    # "errorData":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    .restart local v7    # "timer":Lcom/newrelic/agent/android/stats/TicToc;
    :catchall_5
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    .line 407
    :cond_3
    :try_start_10
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 410
    invoke-virtual {v7}, Lcom/newrelic/agent/android/stats/TicToc;->tic()V

    .line 412
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->api1:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    long-to-double v1, p1

    const-wide v8, 0x408f400000000000L    # 1000.0

    div-double/2addr v1, v8

    iget-object v5, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->machineMeasurementsSampler:Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;

    invoke-interface {v5}, Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;->sample()Lcom/newrelic/agent/android/api/common/MachineMeasurements;

    move-result-object v5

    invoke-interface/range {v0 .. v5}, Lcom/newrelic/agent/android/api/v1/NewRelicApi;->sendData(DLjava/util/Collection;Ljava/util/Collection;Lcom/newrelic/agent/android/api/common/MachineMeasurements;)V

    .line 414
    invoke-static {}, Lcom/newrelic/agent/android/stats/StatsEngine;->get()Lcom/newrelic/agent/android/stats/StatsEngine;

    move-result-object v0

    const-string v1, "Supportability/MobileAgent/Collector/Harvest"

    invoke-virtual {v7}, Lcom/newrelic/agent/android/stats/TicToc;->toc()J

    move-result-wide v8

    invoke-virtual {v0, v1, v8, v9}, Lcom/newrelic/agent/android/stats/StatsEngine;->recordTimeMs(Ljava/lang/String;J)V
    :try_end_10
    .catch Lcom/newrelic/agent/android/transport/TransportException; {:try_start_10 .. :try_end_10} :catch_0
    .catchall {:try_start_10 .. :try_end_10} :catchall_4

    .line 429
    :goto_1
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 434
    :try_start_11
    iget-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    add-long/2addr v0, v10

    iput-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    .line 439
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z

    .line 440
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_7

    .line 443
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto/16 :goto_0

    .line 407
    :catchall_6
    move-exception v0

    :try_start_12
    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0
    :try_end_12
    .catch Lcom/newrelic/agent/android/transport/TransportException; {:try_start_12 .. :try_end_12} :catch_0
    .catchall {:try_start_12 .. :try_end_12} :catchall_4

    .line 422
    :catch_0
    move-exception v6

    .line 423
    .local v6, "e":Lcom/newrelic/agent/android/transport/TransportException;
    :try_start_13
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Failed to send transaction data"

    invoke-interface {v0, v1, v6}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 424
    invoke-static {v3}, Lcom/newrelic/agent/android/Agent;->mergeTransactionData(Ljava/util/List;)V

    .line 425
    invoke-static {v4}, Lcom/newrelic/agent/android/Agent;->mergeErrorData(Ljava/util/List;)V
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_4

    goto :goto_1

    .line 417
    .end local v6    # "e":Lcom/newrelic/agent/android/transport/TransportException;
    :cond_4
    :try_start_14
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Radio seems to be offline. Metric data will not be sent..."

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->debug(Ljava/lang/String;)V

    .line 418
    invoke-static {v3}, Lcom/newrelic/agent/android/Agent;->mergeTransactionData(Ljava/util/List;)V

    .line 419
    invoke-static {v4}, Lcom/newrelic/agent/android/Agent;->mergeErrorData(Ljava/util/List;)V
    :try_end_14
    .catch Lcom/newrelic/agent/android/transport/TransportException; {:try_start_14 .. :try_end_14} :catch_0
    .catchall {:try_start_14 .. :try_end_14} :catchall_4

    goto :goto_1

    .line 443
    :catchall_7
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    .end local v3    # "transactionData":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    .end local v4    # "errorData":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    .end local v7    # "timer":Lcom/newrelic/agent/android/stats/TicToc;
    :catchall_8
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0
.end method

.method private isOnline()Z
    .locals 1

    .prologue
    .line 449
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->connectivitySampler:Lcom/newrelic/agent/android/util/ConnectivitySampler;

    invoke-interface {v0}, Lcom/newrelic/agent/android/util/ConnectivitySampler;->sample()Z

    move-result v0

    return v0
.end method


# virtual methods
.method public dispose()V
    .locals 1

    .prologue
    .line 164
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stop(Z)V

    .line 165
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->executor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->shutdown()V

    .line 166
    return-void
.end method

.method public run()V
    .locals 8

    .prologue
    .line 318
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 321
    .local v2, "thisTime":J
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 323
    :try_start_1
    iget-boolean v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->needConnect:Z

    .line 324
    .local v1, "needConnect":Z
    if-eqz v1, :cond_0

    .line 325
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->needConnect:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 329
    :cond_0
    :try_start_2
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 332
    if-eqz v1, :cond_1

    .line 333
    sget-object v4, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v5, "Connecting!"

    invoke-interface {v4, v5}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 335
    :try_start_3
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->api1:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    invoke-interface {v4}, Lcom/newrelic/agent/android/api/v1/NewRelicApi;->sendConnect()V
    :try_end_3
    .catch Ljava/io/InterruptedIOException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    .line 351
    :goto_0
    :try_start_4
    monitor-enter p0
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    .line 352
    :try_start_5
    iput-wide v2, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lastTime:J

    .line 353
    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 358
    .end local v1    # "needConnect":Z
    .end local v2    # "thisTime":J
    :goto_1
    return-void

    .line 329
    .restart local v2    # "thisTime":J
    :catchall_0
    move-exception v4

    :try_start_6
    iget-object v5, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v4
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0

    .line 355
    .end local v2    # "thisTime":J
    :catch_0
    move-exception v0

    .line 356
    .local v0, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;)V

    goto :goto_1

    .line 337
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "needConnect":Z
    .restart local v2    # "thisTime":J
    :catch_1
    move-exception v0

    .line 338
    .local v0, "e":Ljava/io/InterruptedIOException;
    :try_start_7
    sget-object v4, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Harvested interrupted during I/O operation: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/io/InterruptedIOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v0}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 342
    .end local v0    # "e":Ljava/io/InterruptedIOException;
    :cond_1
    sget-object v4, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Heartbeat ["

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-wide v6, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lastTime:J

    sub-long v6, v2, v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "ms elapsed]"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_0

    .line 344
    :try_start_8
    iget-wide v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lastTime:J

    sub-long v4, v2, v4

    invoke-direct {p0, v4, v5}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvest(J)V
    :try_end_8
    .catch Ljava/io/InterruptedIOException; {:try_start_8 .. :try_end_8} :catch_2
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_0

    goto :goto_0

    .line 346
    :catch_2
    move-exception v0

    .line 347
    .restart local v0    # "e":Ljava/io/InterruptedIOException;
    :try_start_9
    sget-object v4, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Harvester interrupted during an I/O operation: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/io/InterruptedIOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v0}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_0

    goto :goto_0

    .line 353
    .end local v0    # "e":Ljava/io/InterruptedIOException;
    :catchall_1
    move-exception v4

    :try_start_a
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    :try_start_b
    throw v4
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_0
.end method

.method public setInterval(JLjava/util/concurrent/TimeUnit;)V
    .locals 7
    .param p1, "harvestInterval"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 106
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 108
    :try_start_0
    iget-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopRequested:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    if-eqz v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 133
    :goto_0
    return-void

    .line 113
    :cond_0
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 116
    monitor-enter p0

    .line 117
    :try_start_1
    iget-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestInterval:J

    iget-object v2, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestIntervalUnit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {p3, v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    cmp-long v0, v0, p1

    if-eqz v0, :cond_1

    .line 118
    iput-wide p1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestInterval:J

    .line 119
    iput-object p3, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestIntervalUnit:Ljava/util/concurrent/TimeUnit;

    .line 121
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Setting heartbeat interval to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p3}, Ljava/util/concurrent/TimeUnit;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V

    .line 126
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->future:Ljava/util/concurrent/ScheduledFuture;

    if-eqz v0, :cond_1

    .line 127
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Restarting the executor with the new heartbeat interval"

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->debug(Ljava/lang/String;)V

    .line 128
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->future:Ljava/util/concurrent/ScheduledFuture;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledFuture;->cancel(Z)Z

    .line 129
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->executor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    iget-object v6, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestIntervalUnit:Ljava/util/concurrent/TimeUnit;

    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p1

    invoke-virtual/range {v0 .. v6}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->future:Ljava/util/concurrent/ScheduledFuture;

    .line 132
    :cond_1
    monitor-exit p0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 113
    :catchall_1
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0
.end method

.method public start(Z)V
    .locals 7
    .param p1, "needConnect"    # Z

    .prologue
    .line 136
    monitor-enter p0

    .line 137
    :try_start_0
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->future:Ljava/util/concurrent/ScheduledFuture;

    if-nez v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 140
    const/4 v0, 0x0

    :try_start_1
    iput-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopRequested:Z

    .line 141
    iput-boolean p1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->needConnect:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 144
    :try_start_2
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 147
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lastTime:J

    .line 148
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->sessionStartTime:J

    .line 150
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->executor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    if-eqz p1, :cond_1

    const-wide/16 v2, 0x0

    :goto_0
    iget-wide v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestInterval:J

    iget-object v6, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestIntervalUnit:Ljava/util/concurrent/TimeUnit;

    move-object v1, p0

    invoke-virtual/range {v0 .. v6}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->future:Ljava/util/concurrent/ScheduledFuture;

    .line 151
    sget-object v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Harvest thread started [interval: {0} {1}, minDelta: {2} {3}]"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-wide v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestInterval:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestIntervalUnit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v4}, Ljava/util/concurrent/TimeUnit;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    iget-wide v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->minDeltaTime:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->deltaTimeUnit:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v4}, Ljava/util/concurrent/TimeUnit;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/text/MessageFormat;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V

    .line 153
    :cond_0
    monitor-exit p0

    .line 154
    return-void

    .line 144
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    .line 153
    :catchall_1
    move-exception v0

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v0

    .line 150
    :cond_1
    :try_start_3
    iget-wide v2, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestInterval:J
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_0
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 157
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stop(Z)V

    .line 158
    return-void
.end method

.method public stop(Z)V
    .locals 6
    .param p1, "doSendData"    # Z

    .prologue
    .line 169
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 171
    const/4 v4, 0x1

    :try_start_0
    iput-boolean v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopRequested:Z

    .line 172
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopped:Z

    .line 173
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->needConnect:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 175
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 178
    monitor-enter p0

    .line 179
    :try_start_1
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->future:Ljava/util/concurrent/ScheduledFuture;

    if-eqz v4, :cond_1

    .line 180
    iget-wide v2, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->sessionStartTime:J

    .line 181
    .local v2, "sessionStartTime":J
    const-wide/16 v4, 0x0

    iput-wide v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->sessionStartTime:J

    .line 183
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->future:Ljava/util/concurrent/ScheduledFuture;

    const/4 v5, 0x1

    invoke-interface {v4, v5}, Ljava/util/concurrent/ScheduledFuture;->cancel(Z)Z

    .line 184
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->future:Ljava/util/concurrent/ScheduledFuture;

    .line 186
    sget-object v4, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v5, "Harvest thread stopped"

    invoke-interface {v4, v5}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V

    .line 188
    if-eqz p1, :cond_0

    .line 189
    iget-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lastTime:J

    .line 190
    .local v0, "lastHarvestTime":J
    invoke-direct {p0, v2, v3, v0, v1}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalSendData(JJ)V

    .line 203
    .end local v0    # "lastHarvestTime":J
    .end local v2    # "sessionStartTime":J
    :goto_0
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 204
    return-void

    .line 175
    :catchall_0
    move-exception v4

    iget-object v5, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v4

    .line 197
    .restart local v2    # "sessionStartTime":J
    :cond_0
    :try_start_2
    invoke-direct {p0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->afterStop()V

    goto :goto_0

    .line 203
    .end local v2    # "sessionStartTime":J
    :catchall_1
    move-exception v4

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v4

    .line 201
    :cond_1
    :try_start_3
    invoke-direct {p0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->afterStop()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_0
.end method

.method public waitForHarvest(JLjava/util/concurrent/TimeUnit;)Z
    .locals 7
    .param p1, "time"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 299
    iget-object v3, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 301
    :try_start_0
    new-instance v2, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v5, p1, p2, p3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v5

    add-long/2addr v3, v5

    invoke-direct {v2, v3, v4}, Ljava/util/Date;-><init>(J)V

    .line 302
    .local v2, "deadline":Ljava/util/Date;
    iget-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    .line 303
    .local v0, "counterValue":J
    :cond_0
    iget-wide v3, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCounter:J

    cmp-long v3, v3, v0

    if-nez v3, :cond_1

    .line 304
    iget-object v3, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v3, v2}, Ljava/util/concurrent/locks/Condition;->awaitUntil(Ljava/util/Date;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    if-nez v3, :cond_0

    .line 305
    const/4 v3, 0x0

    .line 311
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    :goto_0
    return v3

    .line 308
    :cond_1
    const/4 v3, 0x1

    .line 311
    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    .end local v0    # "counterValue":J
    .end local v2    # "deadline":Ljava/util/Date;
    :catchall_0
    move-exception v3

    iget-object v4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v3
.end method

.method public waitForStop(JLjava/util/concurrent/TimeUnit;)Z
    .locals 2
    .param p1, "time"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 284
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 286
    :cond_0
    :try_start_0
    iget-boolean v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopped:Z

    if-nez v0, :cond_1

    .line 287
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stopCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0, p1, p2, p3}, Ljava/util/concurrent/locks/Condition;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 288
    const/4 v0, 0x0

    .line 294
    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    :goto_0
    return v0

    .line 291
    :cond_1
    const/4 v0, 0x1

    .line 294
    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0
.end method
