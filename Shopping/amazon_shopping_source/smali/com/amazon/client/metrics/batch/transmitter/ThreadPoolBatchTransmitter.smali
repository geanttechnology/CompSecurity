.class public abstract Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;
.super Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
.source "ThreadPoolBatchTransmitter.java"


# static fields
.field private static final THREAD_KEEP_ALIVE_TIME_MS:I = 0x1

.field private static final THREAD_POOL_CORE_SIZE:I = 0x1

.field private static final THREAD_POOL_MAX_SIZE:I = 0x1

.field private static final THREAD_POOL_QUEUE_CAPACITY:I = 0x2

.field private static final THREAD_POOL_TERMINATION_WAIT_MS:I = 0x1388

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected mThreadPoolExecutor:Ljava/util/concurrent/ThreadPoolExecutor;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics:ThreadPoolBatchTransmitter"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V
    .locals 0
    .param p1, "byteArrayQueue"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .param p2, "metricsTransport"    # Lcom/amazon/client/metrics/transport/MetricsTransport;
    .param p3, "uploadResultBroadcaster"    # Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    .param p4, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .prologue
    .line 54
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;-><init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V

    .line 55
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->createDefaultThreadPoolExecutor()V

    .line 56
    return-void
.end method

.method private createDefaultThreadPoolExecutor()V
    .locals 8

    .prologue
    const/4 v1, 0x1

    .line 82
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v3, 0x1

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    const/4 v2, 0x2

    invoke-direct {v6, v2}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>(I)V

    new-instance v7, Lcom/amazon/device/utils/BackgroundThreadFactory;

    invoke-direct {v7}, Lcom/amazon/device/utils/BackgroundThreadFactory;-><init>()V

    move v2, v1

    invoke-direct/range {v0 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mThreadPoolExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 84
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mThreadPoolExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;

    invoke-direct {v1}, Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;-><init>()V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->setRejectedExecutionHandler(Ljava/util/concurrent/RejectedExecutionHandler;)V

    .line 85
    return-void
.end method


# virtual methods
.method public shutdown()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 92
    invoke-super {p0}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->shutdown()V

    .line 94
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mThreadPoolExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v1}, Ljava/util/concurrent/ThreadPoolExecutor;->shutdown()V

    .line 96
    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mThreadPoolExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/concurrent/ThreadPoolExecutor;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 97
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mThreadPoolExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v1}, Ljava/util/concurrent/ThreadPoolExecutor;->shutdownNow()Ljava/util/List;

    .line 99
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mThreadPoolExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/concurrent/ThreadPoolExecutor;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 100
    sget-object v1, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "Thread pool did not terminate."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 107
    :cond_0
    :goto_0
    return-void

    .line 103
    :catch_0
    move-exception v0

    .line 104
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v1, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "Thread pool interrupted on shutdown."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 105
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V

    goto :goto_0
.end method

.method public declared-synchronized transmitBatches(Z)V
    .locals 6
    .param p1, "shouldBroadcastResult"    # Z

    .prologue
    .line 115
    monitor-enter p0

    if-eqz p1, :cond_0

    .line 125
    :try_start_0
    sget-object v1, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "transmitBatches"

    const-string/jumbo v3, "Enabling broadcast result for next run."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 126
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mQueuePusher:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->enableBroadcastResultForNextRun()V

    .line 128
    :cond_0
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mThreadPoolExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->mQueuePusher:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;

    invoke-virtual {v1, v2}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 136
    :goto_0
    monitor-exit p0

    return-void

    .line 129
    :catch_0
    move-exception v0

    .line 134
    .local v0, "e":Ljava/util/concurrent/RejectedExecutionException;
    :try_start_1
    sget-object v1, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "transmitBatches"

    const-string/jumbo v3, "Unexpected rejected execution exception while executing QueuePusher"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 115
    .end local v0    # "e":Ljava/util/concurrent/RejectedExecutionException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
